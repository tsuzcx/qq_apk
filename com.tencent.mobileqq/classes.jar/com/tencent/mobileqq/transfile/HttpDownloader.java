package com.tencent.mobileqq.transfile;

import android.os.Build.VERSION;
import android.view.animation.AnimationUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.StructPicLimitConfigProcessor;
import com.tencent.mobileqq.config.business.StructPicLimitDataBean;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Nullable;

public class HttpDownloader
  extends AbsDownloader
{
  private static final int BUFFER_SIZE = 4096;
  public static final int STRUCT_ITEM_COVER = 1001;
  public static final int STRUCT_PIC_LIMIT_ERROR_CODE = 17174;
  public static final String TAG = "HttpDownloader";
  protected AtomicBoolean isCancelled = new AtomicBoolean(false);
  protected boolean mSupportInnerIp = false;
  
  public HttpDownloader() {}
  
  public HttpDownloader(boolean paramBoolean, Object paramObject)
  {
    this.mSupportInnerIp = paramBoolean;
  }
  
  private static int adjustFailCodeByExceptionType(int paramInt, Exception paramException, boolean paramBoolean)
  {
    String str = paramException.getMessage();
    if ((paramException instanceof SocketException))
    {
      if ((paramException instanceof ConnectException)) {
        return paramInt + 10;
      }
      if ((paramException instanceof NoRouteToHostException)) {
        return paramInt + 11;
      }
      if ((paramException instanceof PortUnreachableException)) {
        return paramInt + 12;
      }
      return paramInt + 13;
    }
    if ((paramException instanceof InterruptedIOException))
    {
      if ((paramException instanceof SocketTimeoutException))
      {
        if (paramBoolean) {
          return paramInt + 100;
        }
        return paramInt + 101;
      }
      return paramInt + 102;
    }
    if ((paramException instanceof IOException))
    {
      if ((paramException instanceof MalformedURLException)) {
        return paramInt + 200;
      }
      if ((paramException instanceof UnknownHostException)) {
        return paramInt + 201;
      }
      if ((paramException instanceof EOFException)) {
        return paramInt + 202;
      }
      if (str == null) {}
      do
      {
        return paramInt + 307;
        if (str.contains("unreachable)")) {
          return paramInt + 300;
        }
        if (str.contains("Connection refused")) {
          return paramInt + 301;
        }
        if (str.contains("No route to host"))
        {
          if (str.contains("SocketException")) {
            return paramInt + 302;
          }
          return paramInt + 303;
        }
        if (str.contains("unexpected end of stream")) {
          return paramInt + 304;
        }
        if (str.contains("Connection timed out")) {
          return paramInt + 305;
        }
      } while (!str.contains("unaccpet content type"));
      return paramInt + 306;
    }
    return paramInt + 400;
  }
  
  protected static boolean checkDownloadFileSize(IHttpEngineService paramIHttpEngineService, URLDrawableHandler paramURLDrawableHandler, NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    boolean bool = StructPicLimitConfigProcessor.a().a;
    long l = StructPicLimitConfigProcessor.a().b;
    if ((bool) && ((paramLong2 > l) || (paramLong1 > l)))
    {
      paramIHttpEngineService.cancelReq(paramNetReq);
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.onFileDownloadFailed(17174);
      }
      QLog.i("HttpDownloader", 1, String.format("download file too big, curOffset is %d, totalLen is %d, totalLen is %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l) }));
      return false;
    }
    return true;
  }
  
  public static void downloadImageByHttpEngine(String paramString, HttpDownloaderParams paramHttpDownloaderParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      String str = AbsDownloader.getFilePath(paramString);
      if (new File(str).exists()) {
        return;
      }
      IHttpEngineService localIHttpEngineService = (IHttpEngineService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IHttpEngineService.class, "all");
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mNeedIpConnect = true;
      localHttpNetReq.mNeedNotReferer = true;
      localHttpNetReq.mSupportBreakResume = true;
      localHttpNetReq.mCallback = new HttpDownloader.1(localIHttpEngineService, paramURLDrawableHandler, paramString, paramHttpDownloaderParams);
      localHttpNetReq.mReqUrl = paramString;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = str;
      localHttpNetReq.mPrioty = 2;
      localHttpNetReq.mIsPreStructPic = paramHttpDownloaderParams.isPreDownload;
      localIHttpEngineService.sendReq(localHttpNetReq);
    }
  }
  
  private void report(DownloadParams paramDownloadParams, boolean paramBoolean1, URL paramURL, boolean paramBoolean2, int paramInt1, int paramInt2, IOException paramIOException)
  {
    int i;
    if ((paramDownloadParams.mHttpDownloaderParams != null) && ((paramDownloadParams.mHttpDownloaderParams instanceof HttpDownloaderParams))) {
      i = ((HttpDownloaderParams)paramDownloadParams.mHttpDownloaderParams).businessType;
    } else {
      i = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("f.businessType =  ");
    localStringBuilder.append(i);
    localStringBuilder.append(" success = ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("config.mHttpDownloaderParams =");
    localStringBuilder.append(paramDownloadParams.mHttpDownloaderParams);
    QLog.d("HttpDownloader", 1, localStringBuilder.toString());
    if (i != 1001) {
      return;
    }
    reportForStructPicDown(paramBoolean1, paramURL, paramBoolean2, paramInt1, paramInt2, paramIOException, null);
  }
  
  public static void reportForStructPicDown(boolean paramBoolean1, URL paramURL, boolean paramBoolean2, int paramInt1, int paramInt2, IOException paramIOException, HttpDownloaderParams paramHttpDownloaderParams)
  {
    String str3 = paramURL.toString();
    String str4 = paramURL.getHost();
    int k = 0;
    int m = 0;
    int i;
    int j;
    String str1;
    if (paramHttpDownloaderParams != null)
    {
      i = paramHttpDownloaderParams.param1;
      j = paramHttpDownloaderParams.param2;
      str1 = paramHttpDownloaderParams.param3;
      if (paramHttpDownloaderParams.isPreDownload) {
        paramURL = "pre";
      } else {
        paramURL = null;
      }
    }
    else
    {
      str1 = "0";
      paramURL = null;
      i = 0;
      j = 0;
    }
    if (!paramBoolean1) {}
    try
    {
      paramHttpDownloaderParams = InetAddress.getByName(str4);
      if (paramHttpDownloaderParams != null) {
        paramHttpDownloaderParams = paramHttpDownloaderParams.getHostAddress();
      }
    }
    catch (UnknownHostException paramHttpDownloaderParams)
    {
      label103:
      int n;
      label155:
      String str2;
      break label103;
    }
    paramHttpDownloaderParams = null;
    n = paramInt1 * 10000;
    k = 1;
    if (paramInt1 == 200)
    {
      if (!SystemUtil.a())
      {
        paramInt1 = 1;
        break label155;
      }
      if (SystemUtil.b() < 8L)
      {
        paramInt1 = 2;
        break label155;
      }
    }
    k = 0;
    paramInt1 = m;
    m = paramInt1;
    if (paramIOException != null)
    {
      str2 = paramIOException.getMessage();
      paramURL = str2;
      m = paramInt1;
      if (k == 0)
      {
        m = adjustFailCodeByExceptionType(paramInt1, paramIOException, paramBoolean2);
        paramURL = str2;
      }
    }
    if (n >= 0) {
      paramInt1 = n + m;
    } else {
      paramInt1 = n - m;
    }
    break label222;
    paramHttpDownloaderParams = null;
    paramInt1 = k;
    label222:
    paramIOException = new HashMap();
    paramIOException.put("param_FailCode", String.valueOf(paramInt1));
    paramIOException.put("param_Url", str3);
    paramIOException.put("serviceId", String.valueOf(i));
    paramIOException.put("templateId", String.valueOf(j));
    paramIOException.put("param_RetryCount", String.valueOf(paramInt2));
    paramIOException.put("param_Host", str4);
    paramIOException.put("param_Address", paramHttpDownloaderParams);
    paramIOException.put("param_First_Direct_Host", null);
    paramIOException.put("param_First_Direct_Address", null);
    paramIOException.put("param_Last_Direct_Host", null);
    paramIOException.put("param_Last_Direct_Address", null);
    paramIOException.put("param_DirectList", "");
    paramIOException.put("param_LastDirectUrl", "");
    paramIOException.put("param_ErrDesc", paramURL);
    paramIOException.put("uintype", str1);
    if (QLog.isDevelopLevel())
    {
      paramURL = new StringBuilder();
      paramURL.append("f =  ");
      paramURL.append(paramIOException.toString());
      QLog.d("HttpDownloader", 4, paramURL.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StructMsgPicDown", paramBoolean1, 0L, 0L, paramIOException, null);
  }
  
  public static void reportHttpsResult(String paramString, int paramInt1, int paramInt2, int paramInt3, Exception paramException, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    int i = paramInt2;
    if (paramException != null)
    {
      if (paramInt2 == -1) {
        paramInt2 = adjustFailCodeByExceptionType(20000, paramException, paramBoolean);
      } else {
        paramInt2 += 10000;
      }
      localHashMap.put("ERROR_MSG", paramException.getMessage());
      i = paramInt2;
    }
    localHashMap.put("param_FailCode", String.valueOf(i));
    paramException = new StringBuilder();
    paramException.append("");
    paramException.append(paramString);
    localHashMap.put("url", paramException.toString());
    paramException = new StringBuilder();
    paramException.append("");
    paramException.append(Build.VERSION.SDK_INT);
    localHashMap.put("API_LEVEL", paramException.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actHttpsDownloadFail", false, paramInt1, paramInt3, localHashMap, "");
    if (QLog.isColorLevel())
    {
      paramException = new StringBuilder();
      paramException.append("[reportHttpsResult] url=");
      paramException.append(paramString);
      paramException.append(" port=");
      paramException.append(paramInt1);
      paramException.append(" responseCode=");
      paramException.append(i);
      paramException.append(" ");
      paramException.append(paramInt3);
      QLog.e("HttpDownloader", 2, paramException.toString());
    }
  }
  
  public static void reportHttpsSniMethod(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString1);
    localHashMap.put("host", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    localHashMap.put("port", localStringBuilder.toString());
    localHashMap.put("businessType", paramString2);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actHttpsSniSupport", false, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("[reportHttpsSniMethod] reflectOrNot=");
      paramString2.append(paramInt1);
      paramString2.append(" host=");
      paramString2.append(paramString1);
      paramString2.append(" ");
      paramString2.append(paramInt2);
      QLog.e("HttpDownloader", 2, paramString2.toString());
    }
  }
  
  private void writeToFile(InputStream paramInputStream, long paramLong, OutputStream paramOutputStream, URLDrawableHandler paramURLDrawableHandler)
  {
    paramInputStream = new BufferedInputStream(paramInputStream, 4096);
    try
    {
      byte[] arrayOfByte = new byte[4096];
      long l1 = 0L;
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
        long l2 = l1 + i;
        l1 = l2;
        if (AnimationUtils.currentAnimationTimeMillis() - 0L > 100L)
        {
          paramURLDrawableHandler.publishProgress((int)((float)l2 / (float)paramLong * 9500.0F));
          l1 = l2;
        }
      }
      paramInputStream.close();
      if (!this.isCancelled.get()) {
        return;
      }
      throw new IOException("cancelled");
    }
    finally
    {
      paramInputStream.close();
    }
    for (;;)
    {
      throw paramOutputStream;
    }
  }
  
  public void cancel()
  {
    this.isCancelled.set(true);
  }
  
  public void copyRespInfo(NetResp paramNetResp, URLDrawableHandler paramURLDrawableHandler) {}
  
  public boolean downByHttpEngine(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    HttpDownloaderParams localHttpDownloaderParams;
    if ((paramDownloadParams.mHttpDownloaderParams != null) && ((paramDownloadParams.mHttpDownloaderParams instanceof HttpDownloaderParams)))
    {
      localHttpDownloaderParams = (HttpDownloaderParams)paramDownloadParams.mHttpDownloaderParams;
      if (localHttpDownloaderParams.businessType != 1001) {}
    }
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" structMsgCover download downloadImageByHttpEngine url = ");
        localStringBuilder.append(paramDownloadParams.url.toString());
        QLog.i("HttpDownloader", 2, localStringBuilder.toString());
      }
      label83:
      downloadImageByHttpEngine(paramDownloadParams.url.toString(), localHttpDownloaderParams, paramURLDrawableHandler, 0);
      return true;
      return false;
    }
    catch (Exception localException)
    {
      break label83;
    }
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return downloadImage(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, 0, null);
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt, URL paramURL)
  {
    boolean bool1 = paramDownloadParams.needCheckNetType;
    boolean bool2 = URLDrawableHelper.isMobileNet();
    boolean bool3 = URLDrawableHelper.isAutoDownAt2G3GAbled(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel())
    {
      paramURL = new StringBuilder();
      paramURL.append(" downloadImage url = ");
      paramURL.append(paramDownloadParams.url.toString());
      paramURL.append(" needCheckNetType:");
      paramURL.append(bool1);
      paramURL.append(" isMobileNet:");
      paramURL.append(bool2);
      paramURL.append("isAutoDownloadAbled:");
      paramURL.append(bool3);
      QLog.i("HttpDownloader", 2, paramURL.toString());
    }
    if ((paramDownloadParams.needCheckNetType) && (bool2) && (!bool3)) {
      return null;
    }
    if (downByHttpEngine(paramDownloadParams, paramURLDrawableHandler)) {
      return null;
    }
    paramURLDrawableHandler.onFileDownloadStarted();
    Object localObject = HttpEngineServiceImpl.getEngineService();
    paramURL = new HttpNetReq();
    paramURL.mReqUrl = paramDownloadParams.url.toString();
    paramURL.mHttpMethod = 0;
    paramURL.mNeedIpConnect = this.mSupportInnerIp;
    paramURL.mOutStream = paramOutputStream;
    paramURL.mContinuErrorLimit = paramDownloadParams.retryCount;
    paramURL.mCallback = new HttpDownloader.2(this, (IHttpEngineService)localObject, paramURLDrawableHandler);
    paramDownloadParams = ((IHttpEngineService)localObject).sendReqSync(paramURL);
    copyRespInfo(paramDownloadParams, paramURLDrawableHandler);
    if (paramDownloadParams != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" resp.mResult = ");
      ((StringBuilder)localObject).append(paramDownloadParams.mResult);
      ((StringBuilder)localObject).append(" , resp.mErrCode = ");
      ((StringBuilder)localObject).append(paramDownloadParams.mErrCode);
      ((StringBuilder)localObject).append(" , resp.mErrDesc = ");
      ((StringBuilder)localObject).append(paramDownloadParams.mErrDesc);
      ((StringBuilder)localObject).append(" file exists: ");
      if ((AbsDownloader.sDiskCache != null) && (AbsDownloader.sDiskCache.getDirectory() != null))
      {
        paramOutputStream = AbsDownloader.sDiskCache.getDirectory();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getFileName(paramURL.mReqUrl));
        localStringBuilder.append(".tmp");
        paramOutputStream = Boolean.valueOf(new File(paramOutputStream, localStringBuilder.toString()).exists());
      }
      else
      {
        paramOutputStream = "null";
      }
      ((StringBuilder)localObject).append(paramOutputStream);
      QLog.i("HttpDownloader", 1, ((StringBuilder)localObject).toString());
      if (paramDownloadParams.mResult == 0)
      {
        paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.mTotalFileLen);
        return null;
      }
      paramURLDrawableHandler.onFileDownloadFailed(paramDownloadParams.mHttpCode);
      throw new IOException(paramDownloadParams.mErrDesc);
    }
    return null;
  }
  
  @Nullable
  protected File getDownloadFile(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
  {
    writeToFile(paramInputStream, paramLong, paramOutputStream, paramURLDrawableHandler);
    report(paramDownloadParams, true, paramDownloadParams.url, paramBoolean, paramInt2, paramInt1, null);
    if ("https".equals(paramDownloadParams.url.getProtocol())) {
      reportHttpsResult(paramDownloadParams.url.getHost(), paramDownloadParams.url.getPort(), paramInt2, paramInt1, null, paramBoolean);
    }
    paramURLDrawableHandler.onFileDownloadSucceed(paramLong);
    return null;
  }
  
  protected void reportIOException(DownloadParams paramDownloadParams, int paramInt1, boolean paramBoolean, int paramInt2, IOException paramIOException)
  {
    report(paramDownloadParams, false, paramDownloadParams.url, paramBoolean, paramInt2, paramInt1, paramIOException);
    if ("https".equals(paramDownloadParams.url.getProtocol())) {
      reportHttpsResult(paramDownloadParams.url.getHost(), paramDownloadParams.url.getPort(), paramInt2, paramInt1, paramIOException, paramBoolean);
    }
  }
  
  public boolean useDiskCache()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpDownloader
 * JD-Core Version:    0.7.0.1
 */