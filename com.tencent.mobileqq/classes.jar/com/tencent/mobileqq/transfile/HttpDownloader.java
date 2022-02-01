package com.tencent.mobileqq.transfile;

import android.os.Build.VERSION;
import android.view.animation.AnimationUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.StructPicLimitConfigProcessor;
import com.tencent.mobileqq.config.business.StructPicLimitDataBean;
import com.tencent.mobileqq.pic.StructMsgPicPreDelegate;
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
  public boolean mSupportInnerIp = false;
  
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
      if (str == null) {
        return paramInt + 307;
      }
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
      if (str.contains("unaccpet content type")) {
        return paramInt + 306;
      }
      return paramInt + 307;
    }
    return paramInt + 400;
  }
  
  public static void downloadImageByHttpEngine(String paramString, HttpDownloaderParams paramHttpDownloaderParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    String str;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      str = AbsDownloader.getFilePath(paramString);
      if (!new File(str).exists()) {}
    }
    else
    {
      return;
    }
    IHttpEngineService localIHttpEngineService = (IHttpEngineService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IHttpEngineService.class, "all");
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mNeedIpConnect = true;
    localHttpNetReq.mNeedNotReferer = true;
    localHttpNetReq.mSupportBreakResume = true;
    boolean bool = StructPicLimitConfigProcessor.a().jdField_a_of_type_Boolean;
    localHttpNetReq.mCallback = new HttpDownloader.1(StructPicLimitConfigProcessor.a().jdField_a_of_type_Long, bool, localIHttpEngineService, paramURLDrawableHandler, paramString, paramHttpDownloaderParams);
    localHttpNetReq.mReqUrl = paramString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = str;
    localHttpNetReq.mPrioty = 2;
    localHttpNetReq.mIsPreStructPic = paramHttpDownloaderParams.isPreDownload;
    localIHttpEngineService.sendReq(localHttpNetReq);
  }
  
  private void report(DownloadParams paramDownloadParams, boolean paramBoolean1, URL paramURL, boolean paramBoolean2, int paramInt1, int paramInt2, IOException paramIOException)
  {
    int j = 0;
    int i = j;
    if (paramDownloadParams.mHttpDownloaderParams != null)
    {
      i = j;
      if ((paramDownloadParams.mHttpDownloaderParams instanceof HttpDownloaderParams)) {
        i = ((HttpDownloaderParams)paramDownloadParams.mHttpDownloaderParams).businessType;
      }
    }
    QLog.d("HttpDownloader", 1, "f.businessType =  " + i + " success = " + paramBoolean1 + "config.mHttpDownloaderParams =" + paramDownloadParams.mHttpDownloaderParams);
    switch (i)
    {
    default: 
      return;
    }
    reportForStructPicDown(paramBoolean1, paramURL, paramBoolean2, paramInt1, paramInt2, paramIOException, null);
  }
  
  public static void reportForStructPicDown(boolean paramBoolean1, URL paramURL, boolean paramBoolean2, int paramInt1, int paramInt2, IOException paramIOException, HttpDownloaderParams paramHttpDownloaderParams)
  {
    String str2 = paramURL.toString();
    String str3 = paramURL.getHost();
    String str1 = null;
    int j = 0;
    int i = 0;
    paramURL = "0";
    int m;
    int k;
    Object localObject;
    if (paramHttpDownloaderParams != null)
    {
      m = paramHttpDownloaderParams.param1;
      k = paramHttpDownloaderParams.param2;
      localObject = paramHttpDownloaderParams.param3;
      paramURL = (URL)localObject;
      i = k;
      j = m;
      if (paramHttpDownloaderParams.isPreDownload)
      {
        j = m;
        paramURL = "pre";
      }
    }
    for (;;)
    {
      if (!paramBoolean1)
      {
        try
        {
          InetAddress localInetAddress = InetAddress.getByName(str3);
          paramHttpDownloaderParams = str1;
          if (localInetAddress != null) {
            paramHttpDownloaderParams = localInetAddress.getHostAddress();
          }
        }
        catch (UnknownHostException paramHttpDownloaderParams)
        {
          for (;;)
          {
            int n;
            paramHttpDownloaderParams = null;
            continue;
            if (SystemUtil.a() < 8L)
            {
              paramInt1 = 2;
              i = 1;
              continue;
              paramInt1 = n - m;
              continue;
              throw new NullPointerException();
              paramIOException = null;
            }
            else
            {
              paramInt1 = 0;
              i = 0;
            }
          }
        }
        n = paramInt1 * 10000;
        if (paramInt1 == 200) {
          if (!SystemUtil.a())
          {
            paramInt1 = 1;
            i = 1;
            m = paramInt1;
            if (paramIOException != null)
            {
              str1 = paramIOException.getMessage();
              m = paramInt1;
              paramURL = str1;
              if (i == 0)
              {
                m = adjustFailCodeByExceptionType(paramInt1, paramIOException, paramBoolean2);
                paramURL = str1;
              }
            }
            if (n < 0) {
              break label457;
            }
            paramInt1 = m + n;
          }
        }
      }
      for (paramIOException = paramHttpDownloaderParams;; paramIOException = null)
      {
        paramHttpDownloaderParams = new HashMap();
        paramHttpDownloaderParams.put("param_FailCode", String.valueOf(paramInt1));
        paramHttpDownloaderParams.put("param_Url", str2);
        paramHttpDownloaderParams.put("serviceId", String.valueOf(j));
        paramHttpDownloaderParams.put("templateId", String.valueOf(k));
        paramHttpDownloaderParams.put("param_RetryCount", String.valueOf(paramInt2));
        paramHttpDownloaderParams.put("param_Host", str3);
        paramHttpDownloaderParams.put("param_Address", paramIOException);
        paramHttpDownloaderParams.put("param_First_Direct_Host", null);
        paramHttpDownloaderParams.put("param_First_Direct_Address", null);
        paramHttpDownloaderParams.put("param_Last_Direct_Host", null);
        paramHttpDownloaderParams.put("param_Last_Direct_Address", null);
        if (0 == 0)
        {
          paramHttpDownloaderParams.put("param_DirectList", "");
          if (0 != 0) {
            break label474;
          }
          paramIOException = "";
          paramHttpDownloaderParams.put("param_LastDirectUrl", paramIOException);
          paramHttpDownloaderParams.put("param_ErrDesc", paramURL);
          paramHttpDownloaderParams.put("uintype", localObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("HttpDownloader", 4, "f =  " + paramHttpDownloaderParams.toString());
          }
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StructMsgPicDown", paramBoolean1, 0L, 0L, paramHttpDownloaderParams, null);
        }
        label457:
        label474:
        paramInt1 = 0;
      }
      localObject = paramURL;
      paramURL = null;
      k = i;
    }
  }
  
  public static void reportHttpsResult(String paramString, int paramInt1, int paramInt2, int paramInt3, Exception paramException, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    int i = paramInt2;
    if (paramException != null)
    {
      if (paramInt2 != -1) {
        break label223;
      }
      paramInt2 = adjustFailCodeByExceptionType(20000, paramException, paramBoolean);
    }
    for (;;)
    {
      localHashMap.put("ERROR_MSG", paramException.getMessage());
      i = paramInt2;
      localHashMap.put("param_FailCode", String.valueOf(i));
      localHashMap.put("url", "" + paramString);
      localHashMap.put("API_LEVEL", "" + Build.VERSION.SDK_INT);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actHttpsDownloadFail", false, paramInt1, paramInt3, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.e("HttpDownloader", 2, "[reportHttpsResult] url=" + paramString + " port=" + paramInt1 + " responseCode=" + i + " " + paramInt3);
      }
      return;
      label223:
      paramInt2 += 10000;
    }
  }
  
  public static void reportHttpsSniMethod(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt1));
    localHashMap.put("host", "" + paramString1);
    localHashMap.put("port", "" + paramInt2);
    localHashMap.put("businessType", paramString2);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actHttpsSniSupport", false, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.e("HttpDownloader", 2, "[reportHttpsSniMethod] reflectOrNot=" + paramInt1 + " host=" + paramString1 + " " + paramInt2);
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
    }
    finally
    {
      paramInputStream.close();
    }
    if (this.isCancelled.get()) {
      throw new IOException("cancelled");
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
      if ((localHttpDownloaderParams.businessType != 1001) || (!StructMsgPicPreDelegate.jdField_a_of_type_Boolean)) {}
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("HttpDownloader", 2, " structMsgCover download downloadImageByHttpEngine url = " + paramDownloadParams.url.toString());
      }
      label79:
      downloadImageByHttpEngine(paramDownloadParams.url.toString(), localHttpDownloaderParams, paramURLDrawableHandler, 0);
      return true;
      return false;
    }
    catch (Exception localException)
    {
      break label79;
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
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " downloadImage url = " + paramDownloadParams.url.toString() + " needCheckNetType:" + bool1 + " isMobileNet:" + bool2 + "isAutoDownloadAbled:" + bool3);
    }
    if ((paramDownloadParams.needCheckNetType) && (bool2) && (!bool3)) {}
    HttpNetReq localHttpNetReq;
    do
    {
      do
      {
        return null;
      } while (downByHttpEngine(paramDownloadParams, paramURLDrawableHandler));
      paramURLDrawableHandler.onFileDownloadStarted();
      localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mReqUrl = paramDownloadParams.url.toString();
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mNeedIpConnect = this.mSupportInnerIp;
      localHttpNetReq.mOutStream = paramOutputStream;
      localHttpNetReq.mContinuErrorLimit = paramDownloadParams.retryCount;
      localHttpNetReq.mCallback = new HttpDownloader.2(this, paramURLDrawableHandler);
      paramDownloadParams = HttpEngineServiceImpl.transSync(localHttpNetReq);
      copyRespInfo(paramDownloadParams, paramURLDrawableHandler);
    } while (paramDownloadParams == null);
    paramURL = new StringBuilder().append(" resp.mResult = ").append(paramDownloadParams.mResult).append(" , resp.mErrCode = ").append(paramDownloadParams.mErrCode).append(" , resp.mErrDesc = ").append(paramDownloadParams.mErrDesc).append(" file exists: ");
    if ((AbsDownloader.sDiskCache != null) && (AbsDownloader.sDiskCache.getDirectory() != null)) {}
    for (paramOutputStream = Boolean.valueOf(new File(AbsDownloader.sDiskCache.getDirectory(), getFileName(localHttpNetReq.mReqUrl) + ".tmp").exists());; paramOutputStream = "null")
    {
      QLog.i("HttpDownloader", 1, paramOutputStream);
      if (paramDownloadParams.mResult != 0) {
        break;
      }
      paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.mTotalFileLen);
      return null;
    }
    paramURLDrawableHandler.onFileDownloadFailed(paramDownloadParams.mHttpCode);
    throw new IOException(paramDownloadParams.mErrDesc);
  }
  
  @Nullable
  public File getDownloadFile(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
  {
    writeToFile(paramInputStream, paramLong, paramOutputStream, paramURLDrawableHandler);
    report(paramDownloadParams, true, paramDownloadParams.url, paramBoolean, paramInt2, paramInt1, null);
    if ("https".equals(paramDownloadParams.url.getProtocol())) {
      reportHttpsResult(paramDownloadParams.url.getHost(), paramDownloadParams.url.getPort(), paramInt2, paramInt1, null, paramBoolean);
    }
    paramURLDrawableHandler.onFileDownloadSucceed(paramLong);
    return null;
  }
  
  public void reportIOException(DownloadParams paramDownloadParams, int paramInt1, boolean paramBoolean, int paramInt2, IOException paramIOException)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpDownloader
 * JD-Core Version:    0.7.0.1
 */