package com.tencent.mobileqq.vip;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.apollo.res.api.IApolloQueueDownloader;
import com.tencent.mobileqq.apollo.statistics.trace.api.ITraceReportHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.HttpDownloadUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.jetbrains.annotations.NotNull;

public class DownloaderFactory
  implements Manager
{
  static ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new DownloaderFactory.2();
  public static ConcurrentHashMap<Integer, DownloaderInterface> a;
  public static volatile boolean a = true;
  private static final int[] jdField_a_of_type_ArrayOfInt = ;
  public static ConcurrentHashMap<String, Integer> b;
  
  public DownloaderFactory(AppRuntime paramAppRuntime)
  {
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  public static int a(DownloadTask paramDownloadTask, String paramString, Context paramContext)
  {
    QLog.d("DownloaderFactory", 2, "doTask | start download task");
    DownloaderFactory.DownloadStateParam localDownloadStateParam = new DownloaderFactory.DownloadStateParam();
    localDownloadStateParam.jdField_a_of_type_Int = -2;
    a(paramDownloadTask, paramString);
    for (;;)
    {
      try
      {
        IApolloUtil localIApolloUtil = (IApolloUtil)QRoute.api(IApolloUtil.class);
        localIApolloUtil.checkApolloUrl(paramDownloadTask);
        localIApolloUtil.checkWrapApolloDownload(paramDownloadTask);
        if (a(paramDownloadTask, localDownloadStateParam)) {
          return localDownloadStateParam.jdField_a_of_type_Int;
        }
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        localBasicHttpParams.setParameter("http.connection.timeout", Integer.valueOf(10000));
        localBasicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(paramDownloadTask.jdField_e_of_type_Int));
        if (!paramDownloadTask.n) {
          break label266;
        }
        str = "gzip";
        localBasicHttpParams.setParameter("Accept-Encoding", str);
        if (b(paramDownloadTask)) {
          return localDownloadStateParam.jdField_a_of_type_Int;
        }
        int i = paramDownloadTask.jdField_a_of_type_JavaUtilList.size();
        if (1 != BaseApplicationImpl.sProcessId) {
          break label273;
        }
        bool = true;
        a(paramDownloadTask, localDownloadStateParam, a(paramDownloadTask, paramString, paramContext, localDownloadStateParam, localIApolloUtil, localBasicHttpParams, i, false, bool));
        a(paramDownloadTask, localDownloadStateParam.jdField_a_of_type_Int);
      }
      catch (Throwable paramDownloadTask)
      {
        QLog.e("DownloaderFactory", 1, paramDownloadTask.getMessage());
      }
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("doTask | end download task result=");
        paramDownloadTask.append(localDownloadStateParam.jdField_a_of_type_Int);
        QLog.d("DownloaderFactory", 2, paramDownloadTask.toString());
      }
      return localDownloadStateParam.jdField_a_of_type_Int;
      label266:
      String str = "identity";
      continue;
      label273:
      boolean bool = false;
    }
  }
  
  private static int a(DownloadTask paramDownloadTask, String paramString, Context paramContext, DownloaderFactory.DownloadStateParam paramDownloadStateParam, IApolloUtil paramIApolloUtil, HttpParams paramHttpParams, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    DownloadTask localDownloadTask = paramDownloadTask;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      DownloaderFactory.DownloadStateParam localDownloadStateParam = paramDownloadStateParam;
      if (paramInt >= localDownloadTask.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      localDownloadStateParam.jdField_a_of_type_Int = -1;
      localDownloadStateParam.jdField_a_of_type_Long = System.currentTimeMillis();
      localDownloadStateParam.jdField_a_of_type_Boolean = false;
      localDownloadStateParam.jdField_b_of_type_Int = -1;
      localDownloadStateParam.jdField_c_of_type_Int = 2000;
      localDownloadStateParam.jdField_b_of_type_Long = 0L;
      localDownloadStateParam.jdField_c_of_type_Long = 0L;
      localDownloadStateParam.jdField_b_of_type_Boolean = false;
      localDownloadStateParam.jdField_a_of_type_JavaLangString = "";
      Object localObject = new Object();
      HashMap localHashMap = new HashMap();
      String str = (String)localDownloadTask.jdField_a_of_type_JavaUtilList.get(paramInt);
      localDownloadTask.jdField_c_of_type_JavaLangString = str;
      a(localDownloadTask, paramIApolloUtil, paramBoolean2);
      localDownloadStateParam.jdField_b_of_type_JavaLangString = str;
      File localFile1 = (File)localDownloadTask.jdField_a_of_type_JavaUtilMap.get(localDownloadStateParam.jdField_b_of_type_JavaLangString);
      if (localFile1 == null)
      {
        localDownloadTask.jdField_a_of_type_Int = -110;
        QLog.w("DownloaderFactory", 2, "doTask | download task error task file param is null");
      }
      else
      {
        File localFile2 = localFile1.getParentFile();
        File localFile3 = a(localDownloadTask, localFile1, localFile2);
        localDownloadStateParam.jdField_b_of_type_JavaLangString = b(localDownloadTask, str, localDownloadStateParam.jdField_b_of_type_JavaLangString);
        paramBoolean1 = a(paramDownloadTask, paramString, paramContext, paramDownloadStateParam, paramHttpParams, paramBoolean1, paramBoolean2, paramInt, localObject, localHashMap, localFile1, localFile2, localFile3, new DownloadInfo(localDownloadStateParam.jdField_b_of_type_JavaLangString, null, 0));
      }
      paramDownloadTask.e();
      a(paramDownloadTask, paramString, paramContext, localDownloadStateParam.jdField_a_of_type_Int, paramBoolean1, paramBoolean2, localDownloadStateParam.jdField_a_of_type_Long, localDownloadStateParam.jdField_b_of_type_Int, localDownloadStateParam.jdField_b_of_type_Long, localDownloadStateParam.jdField_c_of_type_Long, localHashMap, localDownloadStateParam.jdField_b_of_type_JavaLangString, localDownloadStateParam.jdField_a_of_type_JavaLangString);
      if (paramDownloadStateParam.jdField_a_of_type_Int == 0)
      {
        j = i - 1;
      }
      else
      {
        j = i;
        if (paramDownloadTask.o == true) {
          return i;
        }
      }
      paramInt += 1;
      localDownloadTask = paramDownloadTask;
      i = j;
    }
    return i;
  }
  
  public static int a(DownloadTask paramDownloadTask, AppRuntime paramAppRuntime)
  {
    if (paramDownloadTask == null) {
      return -1;
    }
    if (paramAppRuntime != null)
    {
      if ((paramDownloadTask.k) && (!QQSharpPUtil.a(paramAppRuntime.getApplication()))) {
        QLog.e("AIOAudioPanel", 1, "sharpp load error");
      }
      return a(paramDownloadTask, paramAppRuntime.getAccount(), paramAppRuntime.getApplication());
    }
    return a(paramDownloadTask, null, null);
  }
  
  private static long a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, File paramFile, StringBuilder paramStringBuilder, HttpResponse paramHttpResponse)
  {
    Header localHeader = paramHttpResponse.getFirstHeader("Content-Range");
    paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Length");
    if (localHeader != null) {
      paramDownloadStateParam.jdField_b_of_type_Long = Integer.parseInt(localHeader.getValue().split("/")[1]);
    } else if (paramHttpResponse != null) {
      paramDownloadStateParam.jdField_b_of_type_Long = Integer.parseInt(paramHttpResponse.getValue());
    }
    long l = paramFile.length();
    paramStringBuilder.append(", fixed contentLength: ");
    paramStringBuilder.append(paramDownloadStateParam.jdField_b_of_type_Long);
    paramStringBuilder.append(", tmp fileLen: ");
    paramStringBuilder.append(l);
    if ((paramDownloadTask.jdField_g_of_type_Boolean) || (paramDownloadStateParam.jdField_b_of_type_Long >= 1L))
    {
      if (paramDownloadTask.jdField_e_of_type_Long <= 0L) {
        break label198;
      }
      if (paramDownloadStateParam.jdField_b_of_type_Long <= paramDownloadTask.jdField_e_of_type_Long) {
        return l;
      }
    }
    paramDownloadStateParam.jdField_a_of_type_Boolean = true;
    paramDownloadTask.jdField_a_of_type_Int = -118;
    paramDownloadStateParam.jdField_a_of_type_Int = -118;
    paramStringBuilder.append(", limitSize: ");
    paramStringBuilder.append(paramDownloadTask.jdField_e_of_type_Long);
    throw new Exception("server file len error");
    label198:
    return l;
  }
  
  @NotNull
  private static NetworkInfo a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, StringBuilder paramStringBuilder)
  {
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo != null) {
      return localNetworkInfo;
    }
    paramDownloadTask.jdField_a_of_type_Int = -104;
    paramDownloadStateParam.jdField_a_of_type_Int = -104;
    paramStringBuilder.append(", activeNetworkInfo is null");
    throw new Exception("NONE network");
  }
  
  @NotNull
  private static File a(DownloadTask paramDownloadTask, File paramFile1, File paramFile2)
  {
    if (paramDownloadTask.h)
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append(paramFile1.getName());
      paramDownloadTask.append("_");
      paramDownloadTask.append(System.nanoTime());
      return new File(paramFile2, paramDownloadTask.toString());
    }
    paramDownloadTask = new StringBuilder();
    paramDownloadTask.append(paramFile1.getName());
    paramDownloadTask.append(".temp");
    return new File(paramFile2, paramDownloadTask.toString());
  }
  
  private static String a(int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    String str = paramString;
    if (paramInt > 12)
    {
      str = paramString;
      if (82 == paramArrayOfByte[0])
      {
        str = paramString;
        if (73 == paramArrayOfByte[1])
        {
          str = paramString;
          if (70 == paramArrayOfByte[2])
          {
            str = paramString;
            if (70 == paramArrayOfByte[3])
            {
              str = paramString;
              if (87 == paramArrayOfByte[8])
              {
                str = paramString;
                if (69 == paramArrayOfByte[9])
                {
                  str = paramString;
                  if (66 == paramArrayOfByte[10])
                  {
                    str = paramString;
                    if (80 == paramArrayOfByte[11]) {
                      str = "WebP";
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return str;
  }
  
  private static String a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadUrl: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("DownloaderFactory", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramString;
    if (paramDownloadTask.jdField_f_of_type_Int == 302)
    {
      localObject = paramString;
      if (paramDownloadStateParam.jdField_b_of_type_Int == 0)
      {
        localObject = paramString;
        if (paramDownloadTask.r)
        {
          localObject = paramString;
          if (paramString.startsWith("http://"))
          {
            paramDownloadTask.jdField_e_of_type_Boolean = false;
            paramDownloadStateParam.jdField_a_of_type_Boolean = true;
            localObject = paramString.replaceFirst("http", "https");
          }
        }
      }
    }
    return localObject;
  }
  
  private static String a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, String paramString, File paramFile, HttpResponse paramHttpResponse, int paramInt)
  {
    if (404 == paramInt)
    {
      paramDownloadStateParam.jdField_a_of_type_Boolean = true;
      paramDownloadTask.jdField_a_of_type_Int = paramInt;
      paramDownloadStateParam.jdField_a_of_type_Int = paramInt;
      return paramString;
    }
    if (((302 == paramInt) || (301 == paramInt)) && (!paramDownloadTask.p)) {
      return a(paramDownloadTask, paramDownloadStateParam, paramHttpResponse, paramInt);
    }
    if (304 == paramInt)
    {
      paramDownloadTask.jdField_a_of_type_Int = 0;
      paramDownloadStateParam.jdField_a_of_type_Int = 0;
      return paramString;
    }
    if (416 == paramInt)
    {
      if (paramFile.exists()) {
        paramFile.delete();
      }
      paramDownloadTask.jdField_a_of_type_Int = paramInt;
      paramDownloadStateParam.jdField_a_of_type_Int = paramInt;
      return paramString;
    }
    paramDownloadTask.jdField_a_of_type_Int = paramInt;
    paramDownloadStateParam.jdField_a_of_type_Int = paramInt;
    return paramString;
  }
  
  private static String a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, HttpResponse paramHttpResponse, int paramInt)
  {
    boolean bool;
    if ((paramDownloadTask.r) && ((paramInt == 302) || (paramInt == 301)) && (paramDownloadStateParam.jdField_b_of_type_Int == -1)) {
      bool = false;
    } else {
      bool = true;
    }
    paramDownloadStateParam.jdField_a_of_type_Boolean = bool;
    paramDownloadTask.jdField_a_of_type_Int = paramInt;
    paramDownloadStateParam.jdField_a_of_type_Int = paramInt;
    return paramHttpResponse.getFirstHeader("Location").getValue();
  }
  
  private static String a(DownloadTask paramDownloadTask, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramDownloadTask.q)
    {
      str = paramString2;
      if (!paramString2.contains("randomKey="))
      {
        int i = new Random(UinUtils.a(paramString1) | System.currentTimeMillis()).nextInt();
        if (b(paramString2))
        {
          paramDownloadTask = new StringBuilder();
          paramDownloadTask.append(paramString2);
          paramDownloadTask.append("&randomKey=");
          paramDownloadTask.append(i);
          return paramDownloadTask.toString();
        }
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append(paramString2);
        paramDownloadTask.append("?randomKey=");
        paramDownloadTask.append(i);
        str = paramDownloadTask.toString();
      }
    }
    return str;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("http://");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("/");
      String str = ((StringBuilder)localObject).toString();
      if (paramString1.startsWith("https"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("/");
        paramString2 = ((StringBuilder)localObject).toString();
        localObject = "https://[^/\\s]*/";
      }
      else
      {
        localObject = "http://[^/\\s]*/";
        paramString2 = str;
      }
      return paramString1.replaceFirst((String)localObject, paramString2);
    }
    return null;
  }
  
  public static void a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      if (TextUtils.isEmpty(paramDownloadInfo.urlOriginal)) {
        return;
      }
      Object localObject = InnerDns.getHostFromUrl(paramDownloadInfo.urlOriginal);
      if ((jdField_a_of_type_JavaUtilMap.containsKey(localObject)) && (paramDownloadInfo.urlOriginal.startsWith("http")))
      {
        String str1 = InnerDns.getInstance().reqDns((String)localObject, ((Integer)jdField_a_of_type_JavaUtilMap.get(localObject)).intValue());
        if (!TextUtils.isEmpty(str1))
        {
          String str2 = a(paramDownloadInfo.urlOriginal, str1);
          if (!TextUtils.isEmpty(str2))
          {
            paramDownloadInfo.reqUrl = str2;
            paramDownloadInfo.host = ((String)localObject);
            paramDownloadInfo.ip = str1;
            paramDownloadInfo.isIPUrl = true;
            return;
          }
          paramDownloadInfo.reqUrl = paramDownloadInfo.urlOriginal;
        }
      }
      else
      {
        HttpDownloadUtils.a(paramDownloadInfo);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("use new httpDNS. url: ");
          ((StringBuilder)localObject).append(paramDownloadInfo.urlOriginal);
          QLog.d("DownloaderFactory", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, int paramInt)
  {
    if ((paramDownloadTask.b()) && (!paramDownloadTask.jdField_i_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "no need to call onDone");
      }
    }
    else
    {
      if (paramDownloadTask.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("DownloaderFactory", 2, "canceled");
        }
        paramDownloadTask.a(2);
        paramDownloadTask.c();
      }
      else
      {
        if (paramInt == 0) {
          paramInt = 3;
        } else {
          paramInt = -1;
        }
        paramDownloadTask.a(paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "onDoned");
      }
      paramDownloadTask.f();
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, Context paramContext, int paramInt, File paramFile, DownloadInfo paramDownloadInfo)
  {
    if ((paramInt != 0) && (!paramDownloadTask.b()) && (paramDownloadTask.jdField_e_of_type_Boolean))
    {
      if (paramDownloadInfo.isIPUrl)
      {
        if (!TextUtils.isEmpty(paramDownloadInfo.ip))
        {
          InnerDns.getInstance().reportBadIp(paramDownloadInfo.host, paramDownloadInfo.ip, ((Integer)jdField_a_of_type_JavaUtilMap.get(paramDownloadInfo.host)).intValue());
        }
        else
        {
          FMTSrvAddrProvider localFMTSrvAddrProvider = FMTSrvAddrProvider.getInstance();
          if (localFMTSrvAddrProvider != null) {
            localFMTSrvAddrProvider.onFailed(paramDownloadInfo.domainType, paramDownloadInfo.reqUrl);
          }
        }
        a(paramDownloadInfo.reqUrl, paramFile.getName(), -1, paramContext);
        paramDownloadTask.jdField_d_of_type_Boolean = false;
        return;
      }
      paramDownloadTask.jdField_d_of_type_Boolean = true;
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, IApolloUtil paramIApolloUtil, boolean paramBoolean)
  {
    if ((paramDownloadTask.jdField_g_of_type_Int == 3) && (paramBoolean))
    {
      ITraceReportHelper localITraceReportHelper = (ITraceReportHelper)QRoute.api(ITraceReportHelper.class);
      localITraceReportHelper.beginTrace(30, null, paramDownloadTask.jdField_c_of_type_JavaLangString);
      localITraceReportHelper.beginSpan(30, paramDownloadTask.jdField_c_of_type_JavaLangString, 300);
      paramIApolloUtil.reportTraceResourceSpanDesc(paramDownloadTask.jdField_c_of_type_JavaLangString);
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, int paramInt)
  {
    if ((paramInt > 0) && (paramDownloadTask.jdField_a_of_type_JavaUtilList.size() > 1))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doTask | download not complete,fail size=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",task size=");
        localStringBuilder.append(paramDownloadTask.jdField_a_of_type_JavaUtilList.size());
        QLog.w("DownloaderFactory", 2, localStringBuilder.toString());
      }
      paramDownloadTask.jdField_a_of_type_Int = -108;
      paramDownloadStateParam.jdField_a_of_type_Int = -1;
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, int paramInt, File paramFile1, File paramFile2, StringBuilder paramStringBuilder, HttpResponse paramHttpResponse)
  {
    paramDownloadStateParam.jdField_a_of_type_OrgApacheHttpHttpEntity = paramHttpResponse.getEntity();
    paramDownloadStateParam.jdField_b_of_type_Long = paramDownloadStateParam.jdField_a_of_type_OrgApacheHttpHttpEntity.getContentLength();
    paramStringBuilder.append(", entity ContentLength: ");
    paramStringBuilder.append(paramDownloadStateParam.jdField_b_of_type_Long);
    long l = a(paramDownloadTask, paramDownloadStateParam, paramFile2, paramStringBuilder, paramHttpResponse);
    a(paramDownloadTask, paramDownloadStateParam, paramFile2, l);
    boolean bool;
    if (l != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramDownloadStateParam.jdField_a_of_type_JavaIoBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile2, bool));
    if ((paramHttpResponse.getFirstHeader("Content-Encoding") != null) && ("gzip".equals(paramHttpResponse.getFirstHeader("Content-Encoding").getValue())))
    {
      paramDownloadStateParam.jdField_a_of_type_JavaIoInputStream = new GZIPInputStream(paramDownloadStateParam.jdField_a_of_type_OrgApacheHttpHttpEntity.getContent());
      paramStringBuilder.append(", recv gzip stream");
    }
    else
    {
      paramDownloadStateParam.jdField_a_of_type_JavaIoInputStream = paramDownloadStateParam.jdField_a_of_type_OrgApacheHttpHttpEntity.getContent();
    }
    byte[] arrayOfByte = ByteArrayPool.getGenericInstance().getBuf(paramDownloadStateParam.d);
    a(paramDownloadTask, paramDownloadStateParam, paramDownloadStateParam.jdField_a_of_type_JavaIoInputStream, paramDownloadStateParam.jdField_a_of_type_JavaIoBufferedOutputStream, paramInt, paramStringBuilder, l, arrayOfByte, 0);
    paramDownloadStateParam.jdField_a_of_type_JavaIoBufferedOutputStream.flush();
    ByteArrayPool.getGenericInstance().returnBuf(arrayOfByte);
    paramStringBuilder.append(", tempFile length: ");
    paramStringBuilder.append(paramFile2.length());
    a(paramDownloadTask, paramDownloadStateParam, paramFile1, paramFile2, paramStringBuilder, paramHttpResponse, paramFile2.length());
  }
  
  private static void a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, File paramFile, long paramLong)
  {
    if (0L != paramLong)
    {
      if (paramLong < paramDownloadStateParam.jdField_b_of_type_Long) {
        return;
      }
      paramFile.delete();
      paramDownloadTask.jdField_a_of_type_Int = -117;
      paramDownloadStateParam.jdField_a_of_type_Int = -117;
      throw new Exception("SC_PARTIAL_CONTENT error");
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, File paramFile1, File paramFile2, StringBuilder paramStringBuilder, HttpResponse paramHttpResponse, long paramLong)
  {
    if ((paramLong != paramDownloadStateParam.jdField_b_of_type_Long) && ((paramDownloadStateParam.jdField_b_of_type_Long >= 1L) || (!paramDownloadTask.jdField_g_of_type_Boolean) || (paramLong <= 0L)) && ((paramHttpResponse.getFirstHeader("Content-Encoding") == null) || (!"gzip".equals(paramHttpResponse.getFirstHeader("Content-Encoding").getValue())) || (paramLong < paramDownloadStateParam.jdField_b_of_type_Long)))
    {
      if (paramDownloadTask.b())
      {
        paramDownloadStateParam.jdField_a_of_type_Boolean = true;
        paramDownloadTask.jdField_a_of_type_Int = -106;
        paramDownloadStateParam.jdField_a_of_type_Int = -106;
        paramStringBuilder.append(", cancel by user");
        return;
      }
      paramDownloadTask.jdField_a_of_type_Int = -105;
      paramDownloadStateParam.jdField_a_of_type_Int = -105;
      paramFile2.delete();
      throw new Exception("error file len");
    }
    paramDownloadTask.jdField_a_of_type_Int = 0;
    paramDownloadStateParam.jdField_a_of_type_Int = 0;
    if (paramFile1.exists()) {
      paramFile1.delete();
    }
    boolean bool = paramFile2.renameTo(paramFile1);
    paramStringBuilder.append(", rename: ");
    paramStringBuilder.append(bool);
    a(paramDownloadTask, paramFile1, paramHttpResponse);
  }
  
  private static void a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, File paramFile, StringBuilder paramStringBuilder)
  {
    if (paramFile != null)
    {
      boolean bool;
      if (paramFile.exists())
      {
        bool = paramFile.isDirectory();
        if (bool) {
          return;
        }
      }
      else
      {
        bool = true;
      }
      if (!bool) {
        paramFile.delete();
      }
      if (paramFile.mkdirs()) {
        return;
      }
      paramDownloadStateParam.jdField_a_of_type_Boolean = true;
      paramDownloadTask.jdField_a_of_type_Int = -103;
      paramDownloadStateParam.jdField_a_of_type_Int = -103;
      paramStringBuilder.append(", mkdir fail path: ");
      paramStringBuilder.append(paramFile.getAbsolutePath());
      paramStringBuilder.append(", sdCard exist: ");
      paramStringBuilder.append(Utils.a());
      paramStringBuilder.append(", remain size: ");
      paramStringBuilder.append(Utils.b());
      throw new Exception("mkdir error");
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, InputStream paramInputStream, BufferedOutputStream paramBufferedOutputStream, int paramInt1, StringBuilder paramStringBuilder, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    while (!paramDownloadTask.b())
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i == -1) {
        break;
      }
      a(paramStringBuilder, paramLong, i, paramArrayOfByte);
      paramBufferedOutputStream.write(paramArrayOfByte, 0, i);
      long l = i;
      paramLong += l;
      paramDownloadStateParam.jdField_c_of_type_Long += l;
      paramInt2 += i;
      if (paramDownloadStateParam.jdField_b_of_type_Long > 0L)
      {
        if (paramDownloadTask.jdField_f_of_type_Long == 0L) {
          paramDownloadTask.jdField_f_of_type_Long = (paramDownloadStateParam.jdField_b_of_type_Long / 100L);
        }
        if ((paramInt2 >= paramDownloadTask.jdField_f_of_type_Long) || (paramLong >= paramDownloadStateParam.jdField_b_of_type_Long))
        {
          paramDownloadTask.a(paramDownloadStateParam.jdField_b_of_type_Long, paramLong, paramInt1);
          paramDownloadTask.b();
          paramInt2 = 0;
        }
      }
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, Object paramObject, HashMap<String, String> paramHashMap, String paramString, HttpResponse paramHttpResponse)
  {
    if (b == null) {
      b = new ConcurrentHashMap();
    }
    if ((paramDownloadStateParam.jdField_a_of_type_Int != 0) && (!paramDownloadTask.b())) {
      if (paramDownloadStateParam.jdField_b_of_type_Int >= paramDownloadTask.jdField_b_of_type_Int) {}
    }
    try
    {
      try
      {
        paramObject.wait(paramDownloadStateParam.jdField_c_of_type_Int);
      }
      finally
      {
        break label97;
      }
    }
    catch (InterruptedException paramDownloadStateParam)
    {
      label59:
      int i;
      break label59;
    }
    paramDownloadStateParam = new StringBuilder();
    paramDownloadStateParam.append("doTask | InterruptedException,downloadUrl=");
    paramDownloadStateParam.append(paramString);
    QLog.e("DownloaderFactory", 1, paramDownloadStateParam.toString());
    break label219;
    label97:
    throw paramDownloadTask;
    i = (int)(System.currentTimeMillis() / 1000L);
    if (paramDownloadTask.jdField_c_of_type_Boolean) {
      b.put(paramDownloadTask.jdField_a_of_type_JavaLangString, Integer.valueOf(i));
    }
    paramDownloadStateParam.jdField_a_of_type_Boolean = true;
    paramDownloadStateParam = new StringBuilder();
    paramDownloadStateParam.append("doTask | download fail | try over downloadUrl=");
    paramDownloadStateParam.append(paramString);
    paramDownloadStateParam.append(",change task.useIp=");
    paramDownloadStateParam.append(paramDownloadTask.jdField_e_of_type_Boolean);
    paramDownloadStateParam.append(" task.forceIp=");
    paramDownloadStateParam.append(paramDownloadTask.jdField_d_of_type_Boolean);
    throw new Exception(paramDownloadStateParam.toString());
    b.remove(paramDownloadTask.jdField_a_of_type_JavaLangString);
    label219:
    if (paramDownloadTask.jdField_a_of_type_Int == 302)
    {
      paramDownloadTask = paramHttpResponse.getFirstHeader("Location");
      if (paramDownloadTask != null) {
        paramHashMap.put("param_Location", paramDownloadTask.getValue());
      }
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, HttpParams paramHttpParams, StringBuilder paramStringBuilder, NetworkInfo paramNetworkInfo)
  {
    String str = PkgTools.getApnType(paramNetworkInfo.getExtraInfo());
    if (!str.equals(paramDownloadTask.jdField_d_of_type_JavaLangString))
    {
      paramDownloadTask.jdField_f_of_type_Boolean = false;
      paramDownloadTask.jdField_d_of_type_JavaLangString = str;
    }
    if (NetworkUtil.isMobileNetworkInfo(paramNetworkInfo))
    {
      if (!paramDownloadTask.jdField_f_of_type_Boolean)
      {
        paramDownloadTask = Proxy.getDefaultHost();
        int i = Proxy.getDefaultPort();
        if ((paramDownloadTask != null) && (i > 0))
        {
          paramHttpParams.setParameter("http.route.default-proxy", new HttpHost(paramDownloadTask, i));
          paramDownloadStateParam.jdField_b_of_type_Boolean = true;
          paramStringBuilder.append(", useProxy: ");
          paramStringBuilder.append(paramDownloadStateParam.jdField_b_of_type_Boolean);
          paramStringBuilder.append(", host: ");
          paramStringBuilder.append(paramDownloadTask);
          paramStringBuilder.append(", port: ");
          paramStringBuilder.append(i);
        }
      }
    }
    else
    {
      paramDownloadStateParam.d = 4096;
      paramDownloadStateParam.jdField_b_of_type_Boolean = false;
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (paramBoolean2)) {
      paramDownloadTask.jdField_f_of_type_Boolean = paramDownloadStateParam.jdField_b_of_type_Boolean;
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, File paramFile, HttpResponse paramHttpResponse)
  {
    if ((paramDownloadTask.j) && (paramHttpResponse.containsHeader("last-modified")))
    {
      paramHttpResponse = paramHttpResponse.getFirstHeader("last-modified").getValue();
      if (!TextUtils.isEmpty(paramHttpResponse)) {
        try
        {
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("E,d MMM y HH:mm:ss 'GMT'", Locale.US);
          localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
          long l = localSimpleDateFormat.parse(paramHttpResponse).getTime();
          paramFile.setLastModified(l);
          paramDownloadTask.jdField_i_of_type_Long = l;
          if (QLog.isColorLevel())
          {
            paramDownloadTask = new StringBuilder();
            paramDownloadTask.append("doTask |set lastModifyTime=");
            paramDownloadTask.append(l);
            paramDownloadTask.append(",fileName=");
            paramDownloadTask.append(paramFile.getName());
            paramDownloadTask.append(",lastModify=");
            paramDownloadTask.append(paramFile.lastModified());
            QLog.d("DownloaderFactory", 2, paramDownloadTask.toString());
            return;
          }
        }
        catch (Exception paramDownloadTask)
        {
          paramFile = new StringBuilder();
          paramFile.append("doTask | set lastModify=");
          paramFile.append(paramHttpResponse);
          paramFile.append(",exception msg=");
          paramFile.append(paramDownloadTask.getMessage());
          QLog.e("DownloaderFactory", 1, paramFile.toString());
        }
      }
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, String paramString)
  {
    if (paramDownloadTask.a() == null) {
      paramDownloadTask.a(new DownloaderFactory.1());
    }
    if ((paramString != null) && (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.jdField_a_of_type_Long < 0L)) {
      paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.jdField_a_of_type_Long = Long.parseLong(paramString);
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, String paramString1, Context paramContext, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, int paramInt2, long paramLong2, long paramLong3, HashMap<String, String> paramHashMap, String paramString2, String paramString3)
  {
    if (paramHashMap == null) {
      paramHashMap = new HashMap();
    }
    paramHashMap.put("param_Url", paramString2);
    paramHashMap.put("param_FailCode", String.valueOf(paramDownloadTask.jdField_a_of_type_Int));
    paramHashMap.put("param_HttpCode", String.valueOf(paramDownloadTask.jdField_f_of_type_Int));
    paramHashMap.put("param_TryCount", String.valueOf(paramInt2));
    paramHashMap.put("param_ContentLen", String.valueOf(paramLong2));
    paramHashMap.put("param_TaskDownSize", String.valueOf(paramDownloadTask.jdField_a_of_type_JavaUtilList.size()));
    paramHashMap.put("param_BusinessCode", paramDownloadTask.jdField_f_of_type_JavaLangString);
    paramHashMap.put("param_Executed", Boolean.toString(paramBoolean1));
    paramHashMap.put("param_UrlType", paramString3);
    if (!TextUtils.isEmpty(paramDownloadTask.jdField_b_of_type_JavaLangString))
    {
      paramHashMap.put("param_ErrMsg", paramDownloadTask.jdField_b_of_type_JavaLangString);
      paramString2 = paramDownloadTask.jdField_b_of_type_JavaLangString;
    }
    if (paramInt1 == 0) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    paramLong2 = System.currentTimeMillis();
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1))) {}
    try
    {
      a(paramDownloadTask, paramBoolean2);
      paramString3 = "VipDownload700";
      paramString2 = paramString3;
      if (!TextUtils.isEmpty(paramDownloadTask.jdField_f_of_type_JavaLangString))
      {
        paramString2 = paramString3;
        if (paramDownloadTask.jdField_f_of_type_JavaLangString.contains("apollo"))
        {
          paramString2 = "CMShowDownload";
          paramHashMap.put("param_https", String.valueOf(paramDownloadTask.r));
          paramHashMap.put("param_AddRandom", String.valueOf(paramDownloadTask.q));
        }
      }
      StatisticCollector.getInstance(paramContext).collectPerformance(paramString1, paramString2, paramBoolean1, paramLong2 - paramLong1, paramLong3, paramHashMap, "", false);
      return;
    }
    catch (Throwable paramDownloadTask) {}
  }
  
  private static void a(DownloadTask paramDownloadTask, HttpGet paramHttpGet, DownloadInfo paramDownloadInfo, StringBuilder paramStringBuilder)
  {
    if ((jdField_a_of_type_Boolean) && (paramDownloadTask.jdField_e_of_type_Boolean) && (paramDownloadTask.jdField_d_of_type_Boolean) && (!paramDownloadInfo.isHttps))
    {
      a(paramDownloadInfo);
      if (paramDownloadInfo.isIPUrl)
      {
        paramHttpGet.setURI(new URI(paramDownloadInfo.reqUrl));
        paramHttpGet.addHeader("Host", paramDownloadInfo.host);
        paramStringBuilder.append(", Domain2IP[");
        paramStringBuilder.append(paramDownloadInfo.host);
        paramStringBuilder.append(":");
        paramStringBuilder.append(paramDownloadInfo.ip);
        paramStringBuilder.append("]");
      }
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, HttpGet paramHttpGet, File paramFile, StringBuilder paramStringBuilder)
  {
    if ((!paramDownloadTask.m) && (paramDownloadTask.j) && (paramFile != null) && (paramFile.exists()))
    {
      long l;
      if (paramDownloadTask.jdField_i_of_type_Long > 0L) {
        l = paramDownloadTask.jdField_i_of_type_Long;
      } else {
        l = paramFile.lastModified();
      }
      if (l > 0L)
      {
        paramDownloadTask = new SimpleDateFormat("E, d MMM y HH:mm:ss 'GMT'", Locale.US);
        paramDownloadTask.setTimeZone(TimeZone.getTimeZone("GMT"));
        paramDownloadTask = paramDownloadTask.format(new Date(l));
        if (!TextUtils.isEmpty(paramDownloadTask))
        {
          paramHttpGet.addHeader("If-Modified-Since", paramDownloadTask);
          paramStringBuilder.append(", If-Modified-Since:");
          paramStringBuilder.append(paramDownloadTask);
        }
      }
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, HttpGet paramHttpGet, String paramString, StringBuilder paramStringBuilder, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramMap.get(str1);
        paramHttpGet.addHeader(str1, str2);
        paramStringBuilder.append(", ");
        paramStringBuilder.append(str1);
        paramStringBuilder.append(" : ");
        paramStringBuilder.append(str2);
      }
    }
    if ((paramDownloadTask.k) && (QQSharpPUtil.jdField_a_of_type_Boolean) && (QQSharpPUtil.a()))
    {
      paramHttpGet.addHeader("Accept", "image/sharpp");
      QLog.d("DownloaderFactory", 2, "isSharpPSupport: addHeader");
    }
    if (paramDownloadTask.l)
    {
      paramDownloadTask = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.AcceptType.name());
      if ((!TextUtils.isEmpty(paramDownloadTask)) && ((Integer.parseInt(paramDownloadTask) & 0x1) == 1))
      {
        paramHttpGet.addHeader("Accept", "image/webp,*/*;q=0.8");
        paramDownloadTask = String.format(" WebP/%d.%d.%d", new Object[] { Integer.valueOf(jdField_a_of_type_ArrayOfInt[0]), Integer.valueOf(jdField_a_of_type_ArrayOfInt[1]), Integer.valueOf(jdField_a_of_type_ArrayOfInt[2]) });
        paramStringBuilder = new StringBuilder();
        paramStringBuilder.append("QQ/8.7.0 ");
        paramStringBuilder.append(paramDownloadTask);
        paramHttpGet.addHeader("User-Agent", paramStringBuilder.toString());
        if (QLog.isColorLevel())
        {
          paramDownloadTask = new StringBuilder();
          paramDownloadTask.append("doTask | support webp, add header for ");
          paramDownloadTask.append(paramString);
          QLog.d("DownloaderFactory", 2, paramDownloadTask.toString());
        }
      }
      else
      {
        QLog.w("DownloaderFactory", 2, "DPC config forbidden accept WebP!");
      }
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, HttpParams paramHttpParams)
  {
    if ((!paramDownloadTask.p) && (NetworkUtil.isWifiConnected(BaseApplication.getContext()))) {
      HttpClientParams.setRedirecting(paramHttpParams, false);
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, boolean paramBoolean)
  {
    if ((paramDownloadTask.jdField_g_of_type_Int == 3) && (paramBoolean))
    {
      ITraceReportHelper localITraceReportHelper = (ITraceReportHelper)QRoute.api(ITraceReportHelper.class);
      localITraceReportHelper.endSpan(30, paramDownloadTask.jdField_c_of_type_JavaLangString, 300, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getTraceDownloadErrCode(paramDownloadTask.jdField_a_of_type_Int), new Object[] { "task done, errCode:", Integer.valueOf(paramDownloadTask.jdField_a_of_type_Int), ",httpCode:", Integer.valueOf(paramDownloadTask.jdField_f_of_type_Int) });
      if (paramDownloadTask.jdField_a_of_type_Int == 0) {
        localITraceReportHelper.endTrace(30, paramDownloadTask.jdField_c_of_type_JavaLangString);
      }
    }
  }
  
  /* Error */
  private static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: invokestatic 1055	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   3: invokestatic 1058	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   6: if_acmpeq +294 -> 300
    //   9: aload_0
    //   10: invokevirtual 319	java/io/File:length	()J
    //   13: lstore 4
    //   15: aload_0
    //   16: invokevirtual 666	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   19: invokestatic 1063	com/tencent/open/base/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 9
    //   24: ldc2_w 1064
    //   27: lstore_2
    //   28: lload 4
    //   30: ldc2_w 1064
    //   33: lcmp
    //   34: ifle +6 -> 40
    //   37: goto +6 -> 43
    //   40: lload 4
    //   42: lstore_2
    //   43: lload_2
    //   44: l2i
    //   45: newarray char
    //   47: astore 10
    //   49: aconst_null
    //   50: astore 6
    //   52: aconst_null
    //   53: astore 8
    //   55: new 1067	java/io/FileInputStream
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 1070	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: astore 7
    //   65: new 1072	java/io/InputStreamReader
    //   68: dup
    //   69: aload 7
    //   71: ldc_w 1074
    //   74: invokespecial 1077	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   77: astore_0
    //   78: aload_0
    //   79: aload 10
    //   81: invokevirtual 1080	java/io/InputStreamReader:read	([C)I
    //   84: pop
    //   85: aload 7
    //   87: invokevirtual 1083	java/io/InputStream:close	()V
    //   90: aload_0
    //   91: invokevirtual 1084	java/io/InputStreamReader:close	()V
    //   94: goto +88 -> 182
    //   97: astore 8
    //   99: aload_0
    //   100: astore_1
    //   101: aload 7
    //   103: astore 6
    //   105: aload 8
    //   107: astore_0
    //   108: goto +169 -> 277
    //   111: astore 6
    //   113: goto +18 -> 131
    //   116: astore_0
    //   117: aload 6
    //   119: astore_1
    //   120: aload 7
    //   122: astore 6
    //   124: goto +153 -> 277
    //   127: astore 6
    //   129: aconst_null
    //   130: astore_0
    //   131: goto +25 -> 156
    //   134: astore_0
    //   135: aconst_null
    //   136: astore 7
    //   138: aload 6
    //   140: astore_1
    //   141: aload 7
    //   143: astore 6
    //   145: goto +132 -> 277
    //   148: astore 6
    //   150: aconst_null
    //   151: astore_0
    //   152: aload 8
    //   154: astore 7
    //   156: aload 6
    //   158: invokevirtual 1087	java/lang/Exception:printStackTrace	()V
    //   161: aload 7
    //   163: ifnull +11 -> 174
    //   166: aload 7
    //   168: invokevirtual 1083	java/io/InputStream:close	()V
    //   171: goto +3 -> 174
    //   174: aload_0
    //   175: ifnull +7 -> 182
    //   178: aload_0
    //   179: invokevirtual 1084	java/io/InputStreamReader:close	()V
    //   182: new 168	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   189: astore_0
    //   190: aload_0
    //   191: ldc_w 1089
    //   194: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_0
    //   199: aload_1
    //   200: invokevirtual 666	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   203: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_0
    //   208: ldc_w 1091
    //   211: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_0
    //   216: lload 4
    //   218: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_0
    //   223: ldc_w 1093
    //   226: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_0
    //   231: aload 9
    //   233: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_0
    //   238: ldc_w 1095
    //   241: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_0
    //   246: aload 10
    //   248: invokestatic 1098	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   251: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc 64
    //   257: iconst_2
    //   258: aload_0
    //   259: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: return
    //   266: astore 8
    //   268: aload 7
    //   270: astore 6
    //   272: aload_0
    //   273: astore_1
    //   274: aload 8
    //   276: astore_0
    //   277: aload 6
    //   279: ifnull +11 -> 290
    //   282: aload 6
    //   284: invokevirtual 1083	java/io/InputStream:close	()V
    //   287: goto +3 -> 290
    //   290: aload_1
    //   291: ifnull +7 -> 298
    //   294: aload_1
    //   295: invokevirtual 1084	java/io/InputStreamReader:close	()V
    //   298: aload_0
    //   299: athrow
    //   300: return
    //   301: astore 6
    //   303: goto -213 -> 90
    //   306: astore_0
    //   307: goto -125 -> 182
    //   310: astore 6
    //   312: goto -138 -> 174
    //   315: astore 6
    //   317: goto -27 -> 290
    //   320: astore_1
    //   321: goto -23 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramFile1	File
    //   0	324	1	paramFile2	File
    //   27	17	2	l1	long
    //   13	204	4	l2	long
    //   50	54	6	localObject1	Object
    //   111	7	6	localException1	Exception
    //   122	1	6	localObject2	Object
    //   127	12	6	localException2	Exception
    //   143	1	6	localObject3	Object
    //   148	9	6	localException3	Exception
    //   270	13	6	localObject4	Object
    //   301	1	6	localException4	Exception
    //   310	1	6	localException5	Exception
    //   315	1	6	localException6	Exception
    //   63	206	7	localObject5	Object
    //   53	1	8	localObject6	Object
    //   97	56	8	localObject7	Object
    //   266	9	8	localObject8	Object
    //   22	210	9	str	String
    //   47	200	10	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   78	85	97	finally
    //   78	85	111	java/lang/Exception
    //   65	78	116	finally
    //   65	78	127	java/lang/Exception
    //   55	65	134	finally
    //   55	65	148	java/lang/Exception
    //   156	161	266	finally
    //   85	90	301	java/lang/Exception
    //   90	94	306	java/lang/Exception
    //   178	182	306	java/lang/Exception
    //   166	171	310	java/lang/Exception
    //   282	287	315	java/lang/Exception
    //   294	298	320	java/lang/Exception
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramFile1.delete();
    }
    if (QLog.isColorLevel())
    {
      paramFile1 = new StringBuilder();
      paramFile1.append("unzipResource|unzip resource succ targetDir=");
      paramFile1.append(paramFile2.getAbsolutePath());
      QLog.d("DownloaderFactory", 2, paramFile1.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(NetworkUtil.getSystemNetwork(paramContext));
    if (paramString2 == null) {
      paramString2 = "unknow";
    }
    ReportController.b(null, "P_CliOper", "VipDownload", "0", "VipDownload", "ip", 0, paramInt, "", paramContext, paramString2, paramString1);
  }
  
  private static void a(StringBuilder paramStringBuilder, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if ((QLog.isColorLevel()) && (0L == paramLong))
    {
      if ((paramInt > 4) && (-1 == paramArrayOfByte[0]) && (-40 == paramArrayOfByte[1]))
      {
        paramArrayOfByte = "JPEG";
      }
      else
      {
        if (paramInt > 8)
        {
          byte[] arrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 0, 7);
          if (Arrays.equals(new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 }, arrayOfByte))
          {
            paramArrayOfByte = "PNG";
            break label137;
          }
        }
        paramArrayOfByte = a(paramInt, paramArrayOfByte, null);
      }
      label137:
      if (paramArrayOfByte != null)
      {
        paramStringBuilder.append(", img type: ");
        paramStringBuilder.append(paramArrayOfByte);
      }
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, HeaderIterator paramHeaderIterator)
  {
    if (paramHeaderIterator.hasNext())
    {
      Header localHeader = paramHeaderIterator.nextHeader();
      String[] arrayOfString = new String[10];
      int i = 0;
      arrayOfString[0] = "X-Cache-Lookup";
      arrayOfString[1] = "X-NWS-LOG-UUID";
      arrayOfString[2] = "Content-Length";
      arrayOfString[3] = "cache-control";
      arrayOfString[4] = "last-modified";
      arrayOfString[5] = "Location";
      arrayOfString[6] = "Content-Type";
      arrayOfString[7] = "content-range";
      arrayOfString[8] = "Content-Encoding";
      arrayOfString[9] = "server_ip";
      String str = localHeader.getName();
      int j = arrayOfString.length;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(str))
        {
          paramStringBuilder.append(", ");
          paramStringBuilder.append(str);
          paramStringBuilder.append(" :");
          paramStringBuilder.append(localHeader.getValue());
        }
        i += 1;
      }
    }
  }
  
  private static void a(HttpEntity paramHttpEntity, InputStream paramInputStream, BufferedOutputStream paramBufferedOutputStream, String paramString)
  {
    if (paramHttpEntity != null) {
      try
      {
        paramHttpEntity.consumeContent();
      }
      catch (Exception paramHttpEntity)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doTask closeStream | download close io stream exception=");
        localStringBuilder.append(paramHttpEntity.getMessage());
        localStringBuilder.append(", downloadUrl=");
        localStringBuilder.append(paramString);
        QLog.e("DownloaderFactory", 1, localStringBuilder.toString());
      }
    }
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
      }
      catch (Exception paramHttpEntity)
      {
        paramInputStream = new StringBuilder();
        paramInputStream.append("doTask closeStream | download is close io stream exception=");
        paramInputStream.append(paramHttpEntity.getMessage());
        paramInputStream.append(", downloadUrl=");
        paramInputStream.append(paramString);
        QLog.e("DownloaderFactory", 1, paramInputStream.toString());
      }
    }
    if (paramBufferedOutputStream != null) {
      try
      {
        paramBufferedOutputStream.close();
        return;
      }
      catch (Exception paramHttpEntity)
      {
        paramInputStream = new StringBuilder();
        paramInputStream.append("doTask closeStream | download buffFileOS close io stream exception=");
        paramInputStream.append(paramHttpEntity.getMessage());
        paramInputStream.append(", downloadUrl=");
        paramInputStream.append(paramString);
        QLog.e("DownloaderFactory", 1, paramInputStream.toString());
      }
    }
  }
  
  private static void a(HttpGet paramHttpGet, File paramFile, StringBuilder paramStringBuilder)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      long l = paramFile.length();
      paramFile = new StringBuilder();
      paramFile.append("bytes=");
      paramFile.append(l);
      paramFile.append("-");
      paramHttpGet.addHeader("Range", paramFile.toString());
      paramHttpGet = new StringBuilder();
      paramHttpGet.append(", add HttpMsg.RANGE:");
      paramHttpGet.append(l);
      paramStringBuilder.append(paramHttpGet.toString());
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = true;
    if (paramContext != null)
    {
      int i = NetworkUtil.getSystemNetwork(paramContext);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("isQualityNetwork type=");
        paramContext.append(i);
        QLog.d("DownloaderFactory", 2, paramContext.toString());
      }
      bool1 = bool2;
      if (i == 3) {
        return bool1;
      }
      bool1 = bool2;
      if (i == 4) {
        return bool1;
      }
      if (i == 1) {
        return true;
      }
    }
    boolean bool1 = false;
    return bool1;
  }
  
  public static boolean a(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return false;
    }
    if ((paramDownloadTask.jdField_a_of_type_JavaUtilList != null) && (paramDownloadTask.jdField_a_of_type_JavaUtilMap != null) && (paramDownloadTask.jdField_a_of_type_JavaUtilList.size() >= 1) && (paramDownloadTask.jdField_a_of_type_JavaUtilMap.size() >= 1))
    {
      if (TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString)) {
        return false;
      }
      paramDownloadTask = paramDownloadTask.jdField_a_of_type_JavaUtilList.iterator();
      while (paramDownloadTask.hasNext())
      {
        String str = (String)paramDownloadTask.next();
        if ((TextUtils.isEmpty(str)) || (!URLUtil.isNetworkUrl(str))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private static boolean a(DownloadTask paramDownloadTask, DownloaderFactory.DownloadStateParam paramDownloadStateParam)
  {
    paramDownloadStateParam.jdField_a_of_type_Int = -1;
    if (!paramDownloadTask.c())
    {
      paramDownloadTask.jdField_a_of_type_Int = -109;
      paramDownloadTask.f();
      if (QLog.isColorLevel())
      {
        paramDownloadStateParam = new StringBuilder();
        paramDownloadStateParam.append("doTask |  download start return false stop task:");
        paramDownloadStateParam.append(paramDownloadTask);
        QLog.d("DownloaderFactory", 2, paramDownloadStateParam.toString());
      }
      return true;
    }
    return false;
  }
  
  /* Error */
  private static boolean a(DownloadTask paramDownloadTask, String paramString, Context paramContext, DownloaderFactory.DownloadStateParam paramDownloadStateParam, HttpParams paramHttpParams, boolean paramBoolean1, boolean paramBoolean2, int paramInt, Object paramObject, HashMap<String, String> paramHashMap, File paramFile1, File paramFile2, File paramFile3, DownloadInfo paramDownloadInfo)
  {
    // Byte code:
    //   0: ldc_w 1211
    //   3: astore 21
    //   5: ldc_w 1115
    //   8: astore 20
    //   10: ldc 64
    //   12: astore 25
    //   14: ldc_w 1213
    //   17: astore 22
    //   19: aload 4
    //   21: astore 24
    //   23: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   26: lstore 18
    //   28: new 168	java/lang/StringBuilder
    //   31: dup
    //   32: ldc_w 1215
    //   35: invokespecial 1216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: astore 23
    //   40: aload 23
    //   42: ldc_w 1218
    //   45: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 23
    //   51: aload_0
    //   52: getfield 126	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   55: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 23
    //   61: ldc_w 1220
    //   64: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 23
    //   70: aload_0
    //   71: getfield 401	com/tencent/mobileqq/vip/DownloadTask:p	Z
    //   74: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 23
    //   80: ldc_w 1222
    //   83: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 23
    //   89: aload_0
    //   90: getfield 704	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Int	I
    //   93: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 23
    //   99: ldc_w 1224
    //   102: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 23
    //   108: aload_0
    //   109: getfield 1227	com/tencent/mobileqq/vip/DownloadTask:s	Z
    //   112: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_3
    //   117: iconst_0
    //   118: putfield 194	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_Boolean	Z
    //   121: aload_3
    //   122: sipush 2000
    //   125: putfield 199	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_c_of_type_Int	I
    //   128: aload 13
    //   130: invokevirtual 1230	com/tencent/mobileqq/emoticon/DownloadInfo:clearParams	()V
    //   133: aload_0
    //   134: aload_3
    //   135: aload 11
    //   137: aload 23
    //   139: invokestatic 1232	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam;Ljava/io/File;Ljava/lang/StringBuilder;)V
    //   142: aload_0
    //   143: aload_3
    //   144: aload 23
    //   146: invokestatic 1234	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam;Ljava/lang/StringBuilder;)Landroid/net/NetworkInfo;
    //   149: astore 27
    //   151: aload_3
    //   152: getfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   155: astore 26
    //   157: aload_3
    //   158: aload_0
    //   159: aload_1
    //   160: aload 26
    //   162: invokestatic 1236	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   165: putfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   168: aload_0
    //   169: invokevirtual 1239	com/tencent/mobileqq/vip/DownloadTask:a	()Ljava/util/Map;
    //   172: astore 28
    //   174: aload_3
    //   175: ldc 83
    //   177: invokestatic 89	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   180: checkcast 83	com/tencent/mobileqq/apollo/utils/api/IApolloUtil
    //   183: aload_3
    //   184: getfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   187: invokeinterface 1242 2 0
    //   192: putfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   195: aload_3
    //   196: aload_0
    //   197: aload_3
    //   198: aload_3
    //   199: getfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   202: invokestatic 1244	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam;Ljava/lang/String;)Ljava/lang/String;
    //   205: putfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   208: new 927	org/apache/http/client/methods/HttpGet
    //   211: dup
    //   212: aload_3
    //   213: getfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   216: invokespecial 1245	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   219: astore 26
    //   221: aload_0
    //   222: aload 26
    //   224: aload_3
    //   225: getfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   228: aload 23
    //   230: aload 28
    //   232: invokestatic 1247	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lorg/apache/http/client/methods/HttpGet;Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/util/Map;)V
    //   235: aload 26
    //   237: aload 12
    //   239: aload 23
    //   241: invokestatic 1249	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lorg/apache/http/client/methods/HttpGet;Ljava/io/File;Ljava/lang/StringBuilder;)V
    //   244: aload_0
    //   245: aload 26
    //   247: aload 10
    //   249: aload 23
    //   251: invokestatic 1251	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lorg/apache/http/client/methods/HttpGet;Ljava/io/File;Ljava/lang/StringBuilder;)V
    //   254: aload_0
    //   255: aload 26
    //   257: aload 13
    //   259: aload 23
    //   261: invokestatic 1253	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lorg/apache/http/client/methods/HttpGet;Lcom/tencent/mobileqq/emoticon/DownloadInfo;Ljava/lang/StringBuilder;)V
    //   264: aload_0
    //   265: aload_3
    //   266: aload 24
    //   268: aload 23
    //   270: aload 27
    //   272: invokestatic 1255	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam;Lorg/apache/http/params/HttpParams;Ljava/lang/StringBuilder;Landroid/net/NetworkInfo;)V
    //   275: aload_0
    //   276: aload 24
    //   278: invokestatic 1257	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lorg/apache/http/params/HttpParams;)V
    //   281: aload 24
    //   283: ldc_w 1259
    //   286: aload_3
    //   287: getfield 617	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:d	I
    //   290: invokeinterface 1263 3 0
    //   295: pop
    //   296: aload 26
    //   298: aload 24
    //   300: invokevirtual 1267	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   303: aload_0
    //   304: getfield 126	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   307: istore 5
    //   309: iload 5
    //   311: ifeq +20 -> 331
    //   314: ldc 128
    //   316: astore 24
    //   318: goto +17 -> 335
    //   321: aload 23
    //   323: astore 4
    //   325: goto +968 -> 1293
    //   328: goto +529 -> 857
    //   331: ldc 183
    //   333: astore 24
    //   335: aload 26
    //   337: ldc 130
    //   339: aload 24
    //   341: invokevirtual 1270	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: ldc_w 1271
    //   347: invokestatic 1276	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   350: getstatic 1282	com/tencent/mobileqq/utils/HttpDownloadUtil:CLIENT	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   353: aload 26
    //   355: invokevirtual 1288	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   358: astore 27
    //   360: aload 27
    //   362: invokeinterface 1292 1 0
    //   367: invokeinterface 1297 1 0
    //   372: istore 14
    //   374: aload_0
    //   375: iload 14
    //   377: putfield 378	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Int	I
    //   380: aload 13
    //   382: iload 14
    //   384: putfield 1300	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   387: aload 23
    //   389: ldc_w 1302
    //   392: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 23
    //   398: aload 26
    //   400: invokevirtual 1306	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   403: invokevirtual 1209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 23
    //   409: ldc_w 1308
    //   412: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 23
    //   418: iload 14
    //   420: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 23
    //   426: ldc_w 1310
    //   429: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 23
    //   435: aload 27
    //   437: invokeinterface 1314 1 0
    //   442: invokestatic 1316	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/StringBuilder;Lorg/apache/http/HeaderIterator;)V
    //   445: sipush 200
    //   448: iload 14
    //   450: if_icmpeq +61 -> 511
    //   453: sipush 206
    //   456: iload 14
    //   458: if_icmpne +6 -> 464
    //   461: goto +50 -> 511
    //   464: aload_3
    //   465: getfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   468: astore 24
    //   470: aload_3
    //   471: aload_0
    //   472: aload_3
    //   473: aload 24
    //   475: aload 12
    //   477: aload 27
    //   479: iload 14
    //   481: invokestatic 1318	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam;Ljava/lang/String;Ljava/io/File;Lorg/apache/http/HttpResponse;I)Ljava/lang/String;
    //   484: putfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   487: goto +39 -> 526
    //   490: astore_1
    //   491: goto -170 -> 321
    //   494: astore 24
    //   496: goto +9 -> 505
    //   499: astore_1
    //   500: goto -179 -> 321
    //   503: astore 24
    //   505: iconst_1
    //   506: istore 5
    //   508: goto -180 -> 328
    //   511: aload_0
    //   512: aload_3
    //   513: iload 7
    //   515: aload 10
    //   517: aload 12
    //   519: aload 23
    //   521: aload 27
    //   523: invokestatic 1320	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam;ILjava/io/File;Ljava/io/File;Ljava/lang/StringBuilder;Lorg/apache/http/HttpResponse;)V
    //   526: aload 23
    //   528: astore 26
    //   530: aload 22
    //   532: astore 24
    //   534: aload_0
    //   535: aload_3
    //   536: aload 8
    //   538: aload 9
    //   540: aload_3
    //   541: getfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   544: aload 27
    //   546: invokestatic 1322	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam;Ljava/lang/Object;Ljava/util/HashMap;Ljava/lang/String;Lorg/apache/http/HttpResponse;)V
    //   549: invokestatic 1325	android/net/TrafficStats:clearThreadStatsTag	()V
    //   552: new 168	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   559: astore 23
    //   561: aload 23
    //   563: aload 26
    //   565: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 23
    //   574: aload 24
    //   576: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 23
    //   582: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   585: lload 18
    //   587: lsub
    //   588: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 25
    //   594: iconst_1
    //   595: aload 23
    //   597: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 1327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: aload_0
    //   604: getfield 540	com/tencent/mobileqq/vip/DownloadTask:jdField_g_of_type_Int	I
    //   607: iconst_3
    //   608: if_icmpne +91 -> 699
    //   611: iload 6
    //   613: ifeq +86 -> 699
    //   616: ldc_w 542
    //   619: invokestatic 89	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   622: checkcast 542	com/tencent/mobileqq/apollo/statistics/trace/api/ITraceReportHelper
    //   625: astore 23
    //   627: aload_0
    //   628: getfield 221	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   631: astore 27
    //   633: new 168	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   640: astore 28
    //   642: aload 28
    //   644: aload 26
    //   646: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: pop
    //   653: aload 28
    //   655: aload 24
    //   657: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload 28
    //   663: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   666: lload 18
    //   668: lsub
    //   669: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   672: pop
    //   673: aload 23
    //   675: bipush 30
    //   677: aload 27
    //   679: sipush 300
    //   682: iconst_1
    //   683: anewarray 4	java/lang/Object
    //   686: dup
    //   687: iconst_0
    //   688: aload 28
    //   690: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: aastore
    //   694: invokeinterface 1331 5 0
    //   699: aload_0
    //   700: aload_2
    //   701: aload_3
    //   702: getfield 78	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_Int	I
    //   705: aload 10
    //   707: aload 13
    //   709: invokestatic 1333	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Landroid/content/Context;ILjava/io/File;Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   712: new 168	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   719: astore 24
    //   721: aload 13
    //   723: getfield 921	com/tencent/mobileqq/emoticon/DownloadInfo:isHttps	Z
    //   726: ifeq +11 -> 737
    //   729: ldc_w 1335
    //   732: astore 23
    //   734: goto +8 -> 742
    //   737: ldc_w 1337
    //   740: astore 23
    //   742: aload 24
    //   744: aload 23
    //   746: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload 13
    //   752: getfield 492	com/tencent/mobileqq/emoticon/DownloadInfo:isIPUrl	Z
    //   755: ifeq +10 -> 765
    //   758: aload 21
    //   760: astore 23
    //   762: goto +7 -> 769
    //   765: aload 20
    //   767: astore 23
    //   769: aload 24
    //   771: aload 23
    //   773: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: pop
    //   777: aload_3
    //   778: aload 24
    //   780: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: putfield 210	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   786: aload_3
    //   787: aload_3
    //   788: getfield 196	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_Int	I
    //   791: iconst_1
    //   792: iadd
    //   793: putfield 196	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_Int	I
    //   796: aload_3
    //   797: getfield 565	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_OrgApacheHttpHttpEntity	Lorg/apache/http/HttpEntity;
    //   800: aload_3
    //   801: getfield 607	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   804: aload_3
    //   805: getfield 590	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_JavaIoBufferedOutputStream	Ljava/io/BufferedOutputStream;
    //   808: aload_3
    //   809: getfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   812: invokestatic 1339	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   815: iconst_1
    //   816: istore 5
    //   818: goto +396 -> 1214
    //   821: astore 24
    //   823: goto +5 -> 828
    //   826: astore 24
    //   828: iconst_1
    //   829: istore 5
    //   831: goto +26 -> 857
    //   834: astore 24
    //   836: goto +5 -> 841
    //   839: astore 24
    //   841: iconst_0
    //   842: istore 5
    //   844: goto +13 -> 857
    //   847: astore_1
    //   848: aload 23
    //   850: astore 4
    //   852: goto +441 -> 1293
    //   855: astore 24
    //   857: aload 22
    //   859: astore 26
    //   861: aload_0
    //   862: aload 24
    //   864: iconst_0
    //   865: invokestatic 1342	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Ljava/lang/Throwable;Z)Z
    //   868: istore 15
    //   870: aload_0
    //   871: aload 24
    //   873: invokevirtual 160	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   876: putfield 889	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   879: aload_0
    //   880: aload_3
    //   881: iload 5
    //   883: iload 15
    //   885: invokestatic 1344	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam;ZZ)V
    //   888: aload 23
    //   890: ldc_w 1346
    //   893: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload 23
    //   899: invokestatic 1351	com/tencent/mobileqq/utils/FileUtils:hasSDCardAndWritable	()Z
    //   902: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload 23
    //   908: ldc_w 1353
    //   911: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload 23
    //   917: invokestatic 1357	com/tencent/mobileqq/utils/FileUtils:getAvailableExternalMemorySize	()F
    //   920: ldc_w 1358
    //   923: fdiv
    //   924: invokevirtual 1361	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   927: pop
    //   928: aload 23
    //   930: ldc_w 1363
    //   933: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: pop
    //   937: aload 23
    //   939: aload 24
    //   941: invokevirtual 160	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   944: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: pop
    //   948: invokestatic 1325	android/net/TrafficStats:clearThreadStatsTag	()V
    //   951: new 168	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   958: astore 24
    //   960: aload 24
    //   962: aload 23
    //   964: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   967: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: pop
    //   971: aload 24
    //   973: aload 26
    //   975: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload 24
    //   981: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   984: lload 18
    //   986: lsub
    //   987: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   990: pop
    //   991: aload 25
    //   993: iconst_1
    //   994: aload 24
    //   996: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   999: invokestatic 1327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1002: aload_0
    //   1003: getfield 540	com/tencent/mobileqq/vip/DownloadTask:jdField_g_of_type_Int	I
    //   1006: iconst_3
    //   1007: if_icmpne +91 -> 1098
    //   1010: iload 6
    //   1012: ifeq +86 -> 1098
    //   1015: ldc_w 542
    //   1018: invokestatic 89	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1021: checkcast 542	com/tencent/mobileqq/apollo/statistics/trace/api/ITraceReportHelper
    //   1024: astore 24
    //   1026: aload_0
    //   1027: getfield 221	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1030: astore 27
    //   1032: new 168	java/lang/StringBuilder
    //   1035: dup
    //   1036: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1039: astore 28
    //   1041: aload 28
    //   1043: aload 23
    //   1045: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: pop
    //   1052: aload 28
    //   1054: aload 26
    //   1056: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: aload 28
    //   1062: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   1065: lload 18
    //   1067: lsub
    //   1068: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1071: pop
    //   1072: aload 24
    //   1074: bipush 30
    //   1076: aload 27
    //   1078: sipush 300
    //   1081: iconst_1
    //   1082: anewarray 4	java/lang/Object
    //   1085: dup
    //   1086: iconst_0
    //   1087: aload 28
    //   1089: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1092: aastore
    //   1093: invokeinterface 1331 5 0
    //   1098: aload_0
    //   1099: aload_2
    //   1100: aload_3
    //   1101: getfield 78	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_Int	I
    //   1104: aload 10
    //   1106: aload 13
    //   1108: invokestatic 1333	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Landroid/content/Context;ILjava/io/File;Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   1111: new 168	java/lang/StringBuilder
    //   1114: dup
    //   1115: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1118: astore 24
    //   1120: aload 13
    //   1122: getfield 921	com/tencent/mobileqq/emoticon/DownloadInfo:isHttps	Z
    //   1125: ifeq +11 -> 1136
    //   1128: ldc_w 1335
    //   1131: astore 23
    //   1133: goto +8 -> 1141
    //   1136: ldc_w 1337
    //   1139: astore 23
    //   1141: aload 24
    //   1143: aload 23
    //   1145: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: pop
    //   1149: aload 13
    //   1151: getfield 492	com/tencent/mobileqq/emoticon/DownloadInfo:isIPUrl	Z
    //   1154: ifeq +10 -> 1164
    //   1157: aload 21
    //   1159: astore 23
    //   1161: goto +7 -> 1168
    //   1164: aload 20
    //   1166: astore 23
    //   1168: aload 24
    //   1170: aload 23
    //   1172: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: pop
    //   1176: aload_3
    //   1177: aload 24
    //   1179: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1182: putfield 210	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1185: aload_3
    //   1186: aload_3
    //   1187: getfield 196	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_Int	I
    //   1190: iconst_1
    //   1191: iadd
    //   1192: putfield 196	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_Int	I
    //   1195: aload_3
    //   1196: getfield 565	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_OrgApacheHttpHttpEntity	Lorg/apache/http/HttpEntity;
    //   1199: aload_3
    //   1200: getfield 607	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   1203: aload_3
    //   1204: getfield 590	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_JavaIoBufferedOutputStream	Ljava/io/BufferedOutputStream;
    //   1207: aload_3
    //   1208: getfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1211: invokestatic 1339	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   1214: aload_3
    //   1215: getfield 78	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_Int	I
    //   1218: ifeq +9 -> 1227
    //   1221: iconst_1
    //   1222: istore 15
    //   1224: goto +6 -> 1230
    //   1227: iconst_0
    //   1228: istore 15
    //   1230: aload_3
    //   1231: getfield 194	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_Boolean	Z
    //   1234: istore 17
    //   1236: aload_3
    //   1237: getfield 196	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_Int	I
    //   1240: aload_0
    //   1241: getfield 704	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Int	I
    //   1244: if_icmpge +9 -> 1253
    //   1247: iconst_1
    //   1248: istore 16
    //   1250: goto +6 -> 1256
    //   1253: iconst_0
    //   1254: istore 16
    //   1256: iload 15
    //   1258: iload 17
    //   1260: iconst_1
    //   1261: ixor
    //   1262: iload 16
    //   1264: aload_0
    //   1265: invokevirtual 500	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   1268: invokestatic 1366	com/tencent/mobileqq/vip/DownloaderFactory:a	(ZZZZ)Z
    //   1271: ifne +6 -> 1277
    //   1274: iload 5
    //   1276: ireturn
    //   1277: goto -1258 -> 19
    //   1280: astore_1
    //   1281: aload 23
    //   1283: astore 4
    //   1285: goto +8 -> 1293
    //   1288: astore_1
    //   1289: aload 23
    //   1291: astore 4
    //   1293: invokestatic 1325	android/net/TrafficStats:clearThreadStatsTag	()V
    //   1296: new 168	java/lang/StringBuilder
    //   1299: dup
    //   1300: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1303: astore 8
    //   1305: aload 8
    //   1307: aload 4
    //   1309: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1312: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: pop
    //   1316: aload 8
    //   1318: aload 22
    //   1320: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: pop
    //   1324: aload 8
    //   1326: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   1329: lload 18
    //   1331: lsub
    //   1332: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1335: pop
    //   1336: aload 25
    //   1338: iconst_1
    //   1339: aload 8
    //   1341: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1344: invokestatic 1327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1347: aload_0
    //   1348: getfield 540	com/tencent/mobileqq/vip/DownloadTask:jdField_g_of_type_Int	I
    //   1351: iconst_3
    //   1352: if_icmpne +91 -> 1443
    //   1355: iload 6
    //   1357: ifeq +86 -> 1443
    //   1360: ldc_w 542
    //   1363: invokestatic 89	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1366: checkcast 542	com/tencent/mobileqq/apollo/statistics/trace/api/ITraceReportHelper
    //   1369: astore 8
    //   1371: aload_0
    //   1372: getfield 221	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1375: astore 9
    //   1377: new 168	java/lang/StringBuilder
    //   1380: dup
    //   1381: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1384: astore 11
    //   1386: aload 11
    //   1388: aload 4
    //   1390: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1393: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: aload 11
    //   1399: aload 22
    //   1401: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: pop
    //   1405: aload 11
    //   1407: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   1410: lload 18
    //   1412: lsub
    //   1413: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1416: pop
    //   1417: aload 8
    //   1419: bipush 30
    //   1421: aload 9
    //   1423: sipush 300
    //   1426: iconst_1
    //   1427: anewarray 4	java/lang/Object
    //   1430: dup
    //   1431: iconst_0
    //   1432: aload 11
    //   1434: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1437: aastore
    //   1438: invokeinterface 1331 5 0
    //   1443: aload_0
    //   1444: aload_2
    //   1445: aload_3
    //   1446: getfield 78	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_Int	I
    //   1449: aload 10
    //   1451: aload 13
    //   1453: invokestatic 1333	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Landroid/content/Context;ILjava/io/File;Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   1456: new 168	java/lang/StringBuilder
    //   1459: dup
    //   1460: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   1463: astore_2
    //   1464: aload 13
    //   1466: getfield 921	com/tencent/mobileqq/emoticon/DownloadInfo:isHttps	Z
    //   1469: ifeq +10 -> 1479
    //   1472: ldc_w 1335
    //   1475: astore_0
    //   1476: goto +7 -> 1483
    //   1479: ldc_w 1337
    //   1482: astore_0
    //   1483: aload_2
    //   1484: aload_0
    //   1485: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: pop
    //   1489: aload 13
    //   1491: getfield 492	com/tencent/mobileqq/emoticon/DownloadInfo:isIPUrl	Z
    //   1494: ifeq +10 -> 1504
    //   1497: aload 21
    //   1499: astore 20
    //   1501: goto +3 -> 1504
    //   1504: aload_2
    //   1505: aload 20
    //   1507: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: pop
    //   1511: aload_3
    //   1512: aload_2
    //   1513: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1516: putfield 210	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1519: aload_3
    //   1520: aload_3
    //   1521: getfield 196	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_Int	I
    //   1524: iconst_1
    //   1525: iadd
    //   1526: putfield 196	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_Int	I
    //   1529: aload_3
    //   1530: getfield 565	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_OrgApacheHttpHttpEntity	Lorg/apache/http/HttpEntity;
    //   1533: aload_3
    //   1534: getfield 607	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   1537: aload_3
    //   1538: getfield 590	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_a_of_type_JavaIoBufferedOutputStream	Ljava/io/BufferedOutputStream;
    //   1541: aload_3
    //   1542: getfield 226	com/tencent/mobileqq/vip/DownloaderFactory$DownloadStateParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1545: invokestatic 1339	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   1548: goto +5 -> 1553
    //   1551: aload_1
    //   1552: athrow
    //   1553: goto -2 -> 1551
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1556	0	paramDownloadTask	DownloadTask
    //   0	1556	1	paramString	String
    //   0	1556	2	paramContext	Context
    //   0	1556	3	paramDownloadStateParam	DownloaderFactory.DownloadStateParam
    //   0	1556	4	paramHttpParams	HttpParams
    //   0	1556	5	paramBoolean1	boolean
    //   0	1556	6	paramBoolean2	boolean
    //   0	1556	7	paramInt	int
    //   0	1556	8	paramObject	Object
    //   0	1556	9	paramHashMap	HashMap<String, String>
    //   0	1556	10	paramFile1	File
    //   0	1556	11	paramFile2	File
    //   0	1556	12	paramFile3	File
    //   0	1556	13	paramDownloadInfo	DownloadInfo
    //   372	108	14	i	int
    //   868	389	15	bool1	boolean
    //   1248	15	16	bool2	boolean
    //   1234	28	17	bool3	boolean
    //   26	1385	18	l	long
    //   8	1498	20	str1	String
    //   3	1495	21	str2	String
    //   17	1383	22	str3	String
    //   38	1252	23	localObject1	Object
    //   21	453	24	localObject2	Object
    //   494	1	24	localThrowable1	Throwable
    //   503	1	24	localThrowable2	Throwable
    //   532	247	24	localObject3	Object
    //   821	1	24	localThrowable3	Throwable
    //   826	1	24	localThrowable4	Throwable
    //   834	1	24	localThrowable5	Throwable
    //   839	1	24	localThrowable6	Throwable
    //   855	85	24	localThrowable7	Throwable
    //   958	220	24	localObject4	Object
    //   12	1325	25	str4	String
    //   155	900	26	localObject5	Object
    //   149	928	27	localObject6	Object
    //   172	916	28	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   470	487	490	finally
    //   470	487	494	java/lang/Throwable
    //   464	470	499	finally
    //   464	470	503	java/lang/Throwable
    //   511	526	821	java/lang/Throwable
    //   534	549	821	java/lang/Throwable
    //   360	445	826	java/lang/Throwable
    //   157	309	834	java/lang/Throwable
    //   335	360	834	java/lang/Throwable
    //   128	157	839	java/lang/Throwable
    //   116	128	847	finally
    //   128	157	847	finally
    //   157	309	847	finally
    //   335	360	847	finally
    //   360	445	847	finally
    //   116	128	855	java/lang/Throwable
    //   888	948	1280	finally
    //   511	526	1288	finally
    //   534	549	1288	finally
    //   861	888	1288	finally
  }
  
  private static boolean a(DownloadTask paramDownloadTask, Throwable paramThrowable, boolean paramBoolean)
  {
    boolean bool = paramThrowable instanceof ConnectTimeoutException;
    if ((bool) || ((paramThrowable instanceof SocketTimeoutException)) || ((paramThrowable instanceof SocketException))) {
      paramBoolean = true;
    }
    if ((paramThrowable instanceof IOException))
    {
      paramDownloadTask.jdField_a_of_type_Int = -111;
      return paramBoolean;
    }
    if ((paramThrowable instanceof NullPointerException))
    {
      paramDownloadTask.jdField_a_of_type_Int = -112;
      return paramBoolean;
    }
    if ((!bool) && (!(paramThrowable instanceof SocketTimeoutException)))
    {
      if ((paramThrowable instanceof SocketException))
      {
        paramDownloadTask.jdField_a_of_type_Int = -114;
        return paramBoolean;
      }
      if (paramDownloadTask.jdField_a_of_type_Int == 0)
      {
        paramDownloadTask.jdField_a_of_type_Int = -115;
        return paramBoolean;
      }
    }
    else
    {
      paramDownloadTask.jdField_a_of_type_Int = -113;
    }
    return paramBoolean;
  }
  
  public static boolean a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramFile1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramFile1.exists())
        {
          long l = System.currentTimeMillis();
          try
          {
            if (paramFile2.exists())
            {
              localObject = paramFile2.listFiles();
              i = 0;
              if (i < localObject.length)
              {
                localStringBuilder = localObject[i];
                if (localStringBuilder.isDirectory())
                {
                  File[] arrayOfFile = localStringBuilder.listFiles();
                  if (arrayOfFile == null) {
                    break label315;
                  }
                  int k = arrayOfFile.length;
                  int j = 0;
                  if (j < k)
                  {
                    arrayOfFile[j].delete();
                    j += 1;
                    continue;
                  }
                  localStringBuilder.delete();
                  break label315;
                }
                localObject[i].delete();
                break label315;
              }
            }
            else
            {
              paramFile2.mkdirs();
            }
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramFile2.getAbsolutePath());
            ((StringBuilder)localObject).append(File.separatorChar);
            ZipUtils.unZipFile(paramFile1, ((StringBuilder)localObject).toString());
            a(paramFile1, paramFile2, paramBoolean);
            paramBoolean = true;
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("unzipResource|unzip resource fail targetDir=");
            localStringBuilder.append(paramFile2.getAbsolutePath());
            localStringBuilder.append(localException.getMessage());
            QLog.d("DownloaderFactory", 2, localStringBuilder.toString());
            a(paramFile1, paramFile2);
            paramBoolean = bool;
          }
          if (QLog.isColorLevel())
          {
            paramFile1 = new StringBuilder();
            paramFile1.append("unzipResource|use time ");
            paramFile1.append(System.currentTimeMillis() - l);
            paramFile1.append(" targetDir=");
            paramFile1.append(paramFile2.getAbsolutePath());
            QLog.d("DownloaderFactory", 2, paramFile1.toString());
          }
          return paramBoolean;
        }
      }
      finally {}
      return false;
      label315:
      i += 1;
    }
  }
  
  public static boolean a(String paramString)
  {
    int i;
    if (b.containsKey(paramString)) {
      i = ((Integer)b.get(paramString)).intValue();
    } else {
      i = 0;
    }
    if (i > 0)
    {
      if ((int)(System.currentTimeMillis() / 1000L) < i + 600) {
        return true;
      }
      b.remove(paramString);
    }
    return false;
  }
  
  private static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return (paramBoolean1) && (paramBoolean2) && (paramBoolean3) && (!paramBoolean4);
  }
  
  private static String b(DownloadTask paramDownloadTask, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramDownloadTask.jdField_e_of_type_JavaLangString)) {
      paramString2 = MsfSdkUtils.insertMtype(paramDownloadTask.jdField_e_of_type_JavaLangString, paramString1);
    }
    return paramString2;
  }
  
  private static boolean b(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask.jdField_a_of_type_JavaUtilList != null) && (paramDownloadTask.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return false;
    }
    paramDownloadTask.jdField_a_of_type_Int = -107;
    paramDownloadTask.f();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doTask |  download error task urlList is empty, task:");
      localStringBuilder.append(paramDownloadTask);
      QLog.d("DownloaderFactory", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (paramString.indexOf('?') > -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public DownloaderInterface a(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    Object localObject1 = null;
    if (localConcurrentHashMap != null)
    {
      if ((paramInt == 1) || (paramInt == 2) || ((paramInt == 3) || (paramInt == 4) || (paramInt == 5))) {}
      try
      {
        if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
        {
          localObject1 = (DownloaderInterface)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
          break label203;
        }
        DownloaderFactory.DownloadConfig localDownloadConfig = new DownloaderFactory.DownloadConfig(false);
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = (IApolloQueueDownloader)QRoute.api(IApolloQueueDownloader.class);
        ((IApolloQueueDownloader)localObject1).init(localAppRuntime, localDownloadConfig);
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject1);
      }
      finally {}
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
      {
        localObject1 = (DownloaderInterface)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        break label203;
      }
      localObject1 = new DownloaderFactory.DownloadConfig(false);
      localObject1 = new QueueDownloader(BaseApplicationImpl.getApplication().getRuntime(), (DownloaderFactory.DownloadConfig)localObject1);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject1);
      break label206;
    }
    label203:
    label206:
    for (;;)
    {
      return localObject1;
      return null;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloaderFactory", 2, "onDestroy...");
    }
    synchronized (b)
    {
      b.clear();
      synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          ((DownloaderInterface)((Map.Entry)localIterator.next()).getValue()).onDestroy();
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */