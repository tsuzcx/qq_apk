package com.tencent.qqperf.monitor.network;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.monitor.NetworkMonitorCallback;
import com.tencent.mobileqq.msf.sdk.utils.MonitorHttpInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

public class NetworkMonitor
  implements NetworkMonitorCallback
{
  private static NetworkMonitor jdField_a_of_type_ComTencentQqperfMonitorNetworkNetworkMonitor;
  private ConcurrentLinkedQueue<NetworkMonitor.DownloadURLBean> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  
  public NetworkMonitor()
  {
    if (BaseApplication.networkMonitorCallback == null)
    {
      BaseApplication.networkMonitorCallback = this;
      if (QLog.isColorLevel()) {
        QLog.d("NetworkMonitor", 2, new Object[] { "NetworkMonitor init Success! Current ProcessID=", Integer.valueOf(MobileQQ.sProcessId) });
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("NetworkMonitor", 2, "BaseApplication.mNetworkMonitorCallback!=null");
    }
  }
  
  private int a(String paramString1, String paramString2)
  {
    int n = paramString1.length();
    int i1 = paramString2.length();
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, i1 });
    int j = 0;
    int i = 0;
    while (j < n)
    {
      int k = 0;
      while (k < i1)
      {
        int m = i;
        if (paramString1.charAt(j) == paramString2.charAt(k))
        {
          if ((j != 0) && (k != 0)) {
            arrayOfInt[j][k] = (arrayOfInt[(j - 1)][(k - 1)] + 1);
          } else {
            arrayOfInt[j][k] = 1;
          }
          m = i;
          if (i < arrayOfInt[j][k]) {
            m = arrayOfInt[j][k];
          }
        }
        k += 1;
        i = m;
      }
      j += 1;
    }
    return i;
  }
  
  public static NetworkMonitor a()
  {
    NetworkMonitor localNetworkMonitor = jdField_a_of_type_ComTencentQqperfMonitorNetworkNetworkMonitor;
    if (localNetworkMonitor != null) {
      return localNetworkMonitor;
    }
    try
    {
      if (jdField_a_of_type_ComTencentQqperfMonitorNetworkNetworkMonitor == null) {
        jdField_a_of_type_ComTencentQqperfMonitorNetworkNetworkMonitor = new NetworkMonitor();
      }
      localNetworkMonitor = jdField_a_of_type_ComTencentQqperfMonitorNetworkNetworkMonitor;
      return localNetworkMonitor;
    }
    finally {}
  }
  
  public static void a(Context paramContext, MonitorHttpInfo paramMonitorHttpInfo, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramMonitorHttpInfo != null) && (paramContext != null))
    {
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMonitorHttpInfo.getHost());
      localStringBuilder.append(":");
      localStringBuilder.append(paramMonitorHttpInfo.getPort());
      localStringBuilder.append("/");
      localStringBuilder.append(paramMonitorHttpInfo.getUrl());
      localHashMap.put("url", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMonitorHttpInfo.getResponseLength());
      localStringBuilder.append("");
      localHashMap.put("fileSize", localStringBuilder.toString());
      localHashMap.put("mimeType", paramMonitorHttpInfo.getMimeType());
      localHashMap.put("method", paramMonitorHttpInfo.getMethod());
      localHashMap.put("ResponseBodyHex", paramMonitorHttpInfo.getResponseBodyHex());
      localHashMap.put("type", paramMonitorHttpInfo.getType());
      localHashMap.put("ResponseCode", paramMonitorHttpInfo.getResponseCode());
      localHashMap.put("processName", paramString1);
      if (paramString2 == null) {
        paramString2 = "null";
      }
      localHashMap.put("CurrentActivity", paramString2);
      localHashMap.put("reportVia", "4");
      if (paramBoolean) {
        StatisticCollector.getInstance(paramContext).collectPerformance(null, "MonitorApkDownload", true, 0L, 0L, localHashMap, "");
      } else {
        StatisticCollector.getInstance(paramContext).collectPerformance(null, "UnMonitorApkDownload", true, 0L, 0L, localHashMap, "");
      }
      if (QLog.isColorLevel())
      {
        if (paramBoolean) {
          paramContext = "MonitorApkDownload{";
        } else {
          paramContext = "UnMonitorApkDownload{";
        }
        paramContext = new StringBuilder(paramContext);
        paramContext.append(" ProcessName=");
        paramContext.append(paramString1);
        paramContext.append(" ");
        paramMonitorHttpInfo = localHashMap.keySet().iterator();
        while (paramMonitorHttpInfo.hasNext())
        {
          paramString1 = (String)paramMonitorHttpInfo.next();
          paramContext.append(paramString1);
          paramContext.append("=");
          paramContext.append((String)localHashMap.get(paramString1));
          paramContext.append("\n");
        }
        QLog.d("NetworkMonitor", 2, paramContext.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, "httpInfo is null");
    }
  }
  
  private static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.endsWith("patch")) || (paramString.contains("QQpeizhiwenjian")) || (paramString.contains("/qun/configs/")) || (paramString.contains("qzonestyle")) || (paramString.contains("gxh.vip.qq.com")) || (paramString.contains("/tmp_video/quic")) || (paramString.contains("groupgift")) || (paramString.contains("vac.gtimg.cn")) || (paramString.contains("sqimg.qq.com")) || (paramString.contains("imgcache.qq.com")) || (paramString.contains("imgcache.gtimg.cn")) || (paramString.contains("i.gtimg.cn")) || (paramString.contains("cmshow.gtimg.cn")) || (paramString.contains("myapp/qq_desk")) || (paramString.contains("myapp/qqteam")) || (paramString.contains("myapp/qqt")) || (paramString.contains("plugin")) || (paramString.contains("Plugin")) || (paramString.contains("cgi-bin/httpconn")) || (paramString.contains("mobileqq/FT")) || (paramString.contains("ftn_handler")) || (paramString.contains("comp_bsdiff")) || (paramString.contains("qqpitu/jsons")) || (paramString.contains("hudongzip-1251316161.file.myqcloud.com")) || (paramString.contains("sngapp/app/update")) || (paramString.contains("qqpitu/materials/")) || (paramString.contains("hotfiles")) || (paramString.contains("2Q2W")) || (paramString.contains("soft.tbs.imtt")) || (paramString.contains("AndroidQQPlugin")));
  }
  
  private void b(MonitorHttpInfo paramMonitorHttpInfo, String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramMonitorHttpInfo.getHost());
    ((StringBuilder)localObject1).append(":");
    ((StringBuilder)localObject1).append(paramMonitorHttpInfo.getPort());
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(paramMonitorHttpInfo.getUrl());
    localObject1 = ((StringBuilder)localObject1).toString();
    if (a((String)localObject1)) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
    if (localObject2 != null)
    {
      localObject2 = ((ConcurrentLinkedQueue)localObject2).toArray();
      int k = localObject2.length;
      int i = 0;
      while (i < k)
      {
        NetworkMonitor.DownloadURLBean localDownloadURLBean = localObject2[i];
        if ((localDownloadURLBean instanceof NetworkMonitor.DownloadURLBean))
        {
          localDownloadURLBean = (NetworkMonitor.DownloadURLBean)localDownloadURLBean;
          int j;
          try
          {
            j = a((String)localObject1, localDownloadURLBean.a());
          }
          catch (Throwable localThrowable)
          {
            if (QLog.isColorLevel()) {
              QLog.d("NetworkMonitor", 2, "Exception", localThrowable);
            }
            j = 0;
          }
          if (QLog.isColorLevel()) {
            QLog.d("NetworkMonitor", 2, new Object[] { "url=", localObject1, " bean's url=", localDownloadURLBean.a(), " lcs length=", Integer.valueOf(j) });
          }
          if (j >= 10) {
            a(MobileQQ.context, paramMonitorHttpInfo, true, paramString1, paramString2);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("NetworkMonitor", 2, new Object[] { "class=", localDownloadURLBean.getClass().getSimpleName() });
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, new Object[] { "needDoReport!", paramMonitorHttpInfo.getHost(), paramMonitorHttpInfo.getUrl() });
    }
    a(MobileQQ.context, paramMonitorHttpInfo, false, paramString1, paramString2);
  }
  
  public void a(MonitorHttpInfo paramMonitorHttpInfo, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, new Object[] { "doRealAddHttpInfo=", paramMonitorHttpInfo });
    }
    if ((paramMonitorHttpInfo.getFileType() == 1) || (paramMonitorHttpInfo.getFileType() == 2)) {
      b(paramMonitorHttpInfo, paramString1, paramString2);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    }
    NetworkMonitor.DownloadURLBean localDownloadURLBean = new NetworkMonitor.DownloadURLBean(this, paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localDownloadURLBean);
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, new Object[] { "doRealAddDownloadURL=", paramString });
    }
    while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
    {
      paramString = (NetworkMonitor.DownloadURLBean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
      if ((paramString == null) || (paramString.a - localDownloadURLBean.a <= 600000L)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    }
  }
  
  public void addDownloadURL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, new Object[] { "addDownloadURL=", paramString });
    }
    if (1 != MobileQQ.sProcessId)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_URL", paramString);
      QIPCClientHelper.getInstance().callServer("NetworkMonitorIPCModule", "ACTION_REPORT_DOWNLOAD_URL", localBundle, new NetworkMonitor.1(this));
      return;
    }
    a(paramString);
  }
  
  public void addHttpInfo(MonitorHttpInfo paramMonitorHttpInfo)
  {
    if (paramMonitorHttpInfo == null) {
      return;
    }
    Object localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      if (Foreground.getTopActivity() != null) {
        localObject1 = Foreground.getTopActivity().getClass().getName();
      }
      if (1 != MobileQQ.sProcessId)
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putSerializable("BUNDLE_KEY_REPORT_HTTP_INFO_INFO", paramMonitorHttpInfo);
        ((Bundle)localObject3).putString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_PROCESS_NAME", MobileQQ.processName);
        paramMonitorHttpInfo = (MonitorHttpInfo)localObject1;
        if (localObject1 == null) {
          paramMonitorHttpInfo = "Null";
        }
        ((Bundle)localObject3).putString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_TOP_ACTIVITY", paramMonitorHttpInfo);
        QIPCClientHelper.getInstance().getClient().callServer("NetworkMonitorIPCModule", "ACTION_REPORT_HTTPINFO", (Bundle)localObject3);
        return;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = "Null";
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          a(paramMonitorHttpInfo, "com.tencent.mobileqq", (String)localObject3);
          return;
        }
        catch (Throwable paramMonitorHttpInfo) {}
        localThrowable = localThrowable;
        Object localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.network.NetworkMonitor
 * JD-Core Version:    0.7.0.1
 */