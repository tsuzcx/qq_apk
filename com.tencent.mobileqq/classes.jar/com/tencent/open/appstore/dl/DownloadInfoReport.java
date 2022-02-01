package com.tencent.open.appstore.dl;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.network.NetworkMonitor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

public class DownloadInfoReport
{
  public static ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
  
  public static void a(int paramInt1, @Nullable String paramString, int paramInt2, @Nullable Object paramObject)
  {
    try
    {
      ThreadManager.executeOnSubThread(new DownloadInfoReport.1(paramInt1, paramString, paramObject, paramInt2));
      return;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UniformDownloadEvent", 2, paramString, new Object[] { " in reportSpecialCareAPKDownloadInfo" });
      }
    }
  }
  
  public static void a(Context paramContext, WadlParams paramWadlParams)
  {
    if ((paramWadlParams != null) && (paramContext != null))
    {
      NetworkMonitor.a().addDownloadURL(paramWadlParams.k);
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", paramWadlParams.k);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(NetworkUtil.getNetworkType(paramContext));
      String str = "";
      ((StringBuilder)localObject1).append("");
      localHashMap.put("NetworkType", ((StringBuilder)localObject1).toString());
      if (a(paramContext)) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      localHashMap.put("isForeground", localObject1);
      localHashMap.put("reportVia", "2");
      localObject1 = new Throwable().getStackTrace();
      Object localObject2 = new StringBuilder();
      if (a.containsKey(paramWadlParams.e)) {
        ((StringBuilder)localObject2).append((String)a.remove(paramWadlParams.e));
      } else if (a.containsKey(paramWadlParams.k)) {
        ((StringBuilder)localObject2).append((String)a.remove(paramWadlParams.k));
      }
      int i = 1;
      while (i < localObject1.length)
      {
        ((StringBuilder)localObject2).append(localObject1[i].toString());
        i += 1;
      }
      if (((StringBuilder)localObject2).length() < 950)
      {
        localHashMap.put("Stack", ((StringBuilder)localObject2).toString());
      }
      else
      {
        localHashMap.put("Stack", ((StringBuilder)localObject2).substring(0, 950));
        if (((StringBuilder)localObject2).length() < 1901) {
          localHashMap.put("Stack1", ((StringBuilder)localObject2).substring(950));
        } else {
          localHashMap.put("Stack1", ((StringBuilder)localObject2).substring(950, 1900));
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramWadlParams.B);
      ((StringBuilder)localObject1).append("");
      localHashMap.put("_filesize_from_dlg", ((StringBuilder)localObject1).toString());
      localHashMap.put("_filename_from_dlg", paramWadlParams.m);
      if (!paramWadlParams.b) {
        localHashMap.put("isAPK", "1");
      } else {
        localHashMap.put("isAPK", "0");
      }
      localHashMap.put("ReferURL", paramWadlParams.x);
      localObject2 = paramWadlParams.A;
      if (paramWadlParams.x == null) {
        localObject1 = str;
      } else {
        localObject1 = paramWadlParams.x;
      }
      paramWadlParams = (WadlParams)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        if ((!((String)localObject1).contains("youxi.vip.qq.com/m/act/")) && (!((String)localObject1).contains("cmshow.qq.com")))
        {
          if (((String)localObject1).contains("ag.qq.com/kd/detail")) {}
          do
          {
            paramWadlParams = "biz_src_zz_dianjing";
            break label602;
            if ((((String)localObject1).contains("m.gamecenter.qq.com")) || (((String)localObject1).contains("imgcache.qq.com")) || (((String)localObject1).contains("sgame.gamecenter.qq.com")) || (((String)localObject1).equals("publicAccount")) || (((String)localObject1).equals("YUYUE")) || (((String)localObject1).equals("YANCHI"))) {
              break label593;
            }
            if ((((String)localObject1).contains("cdn.vip.qq.com/club/client/comic/")) || (((String)localObject1).contains("qc.vip.qq.com"))) {
              break;
            }
          } while (((String)localObject1).contains("m.egame.qq.com"));
          paramWadlParams = "biz_src_feeds_kandianads";
          break label602;
          paramWadlParams = "biz_src_zz_bodong";
          break label602;
          label593:
          paramWadlParams = "biz_src_zf_games";
        }
        else
        {
          paramWadlParams = "biz_src_optools";
        }
      }
      label602:
      if (TextUtils.isEmpty(paramWadlParams))
      {
        StatisticCollector.getInstance(paramContext).collectPerformance(null, "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, localHashMap, "");
      }
      else
      {
        localHashMap.put("DOWNLOAD_BIG_BROTHER_SOURCE", paramWadlParams);
        StatisticCollector.getInstance(paramContext).collectPerformance(null, "UniformDownloadEvent", true, 0L, 0L, localHashMap, "");
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramWadlParams = localHashMap.keySet().iterator();
        while (paramWadlParams.hasNext())
        {
          localObject1 = (String)paramWadlParams.next();
          paramContext.append((String)localObject1);
          paramContext.append("=");
          paramContext.append((String)localHashMap.get(localObject1));
          paramContext.append("\n");
        }
        QLog.d("UniformDownloadEvent", 2, paramContext.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UniformDownloadEvent", 2, "wadlParams is null");
    }
  }
  
  public static void a(Context paramContext, DownloadInfo paramDownloadInfo)
  {
    HashMap localHashMap;
    StringBuilder localStringBuilder2;
    if ((paramDownloadInfo != null) && (paramContext != null))
    {
      NetworkMonitor.a().addDownloadURL(paramDownloadInfo.d);
      if (a(paramDownloadInfo.d)) {
        return;
      }
      localHashMap = new HashMap();
      localHashMap.put("url", paramDownloadInfo.d);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(NetworkUtil.getNetworkType(paramContext));
      ((StringBuilder)localObject).append("");
      localHashMap.put("NetworkType", ((StringBuilder)localObject).toString());
      if (a(paramContext)) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("isForeground", localObject);
      localHashMap.put("reportVia", "3");
      localObject = new Throwable().getStackTrace();
      localStringBuilder2 = new StringBuilder();
    }
    try
    {
      if (a.containsKey(paramDownloadInfo.c)) {
        localStringBuilder2.append((String)a.remove(paramDownloadInfo.c));
      } else if (a.containsKey(paramDownloadInfo.d)) {
        localStringBuilder2.append((String)a.remove(paramDownloadInfo.d));
      }
    }
    catch (Throwable localThrowable)
    {
      label212:
      int i;
      String str2;
      String str1;
      StringBuilder localStringBuilder1;
      break label212;
    }
    i = 1;
    while (i < localObject.length)
    {
      localStringBuilder2.append(localObject[i].toString());
      i += 1;
    }
    if (localStringBuilder2.length() < 950)
    {
      localHashMap.put("Stack", localStringBuilder2.toString());
    }
    else
    {
      localHashMap.put("Stack", localStringBuilder2.substring(0, 950));
      if (localStringBuilder2.length() < 1901) {
        localHashMap.put("Stack1", localStringBuilder2.substring(950));
      } else {
        localHashMap.put("Stack1", localStringBuilder2.substring(950, 1900));
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramDownloadInfo.I);
    ((StringBuilder)localObject).append("");
    localHashMap.put("_filesize_from_dlg", ((StringBuilder)localObject).toString());
    str2 = paramDownloadInfo.e;
    localHashMap.put("_filename_from_dlg", str2);
    if (paramDownloadInfo.A) {
      localHashMap.put("isAPK", "1");
    } else {
      localHashMap.put("isAPK", "0");
    }
    if (paramDownloadInfo.h != null) {
      localObject = paramDownloadInfo.h;
    } else {
      localObject = "";
    }
    localHashMap.put("ReferURL", localObject);
    str1 = paramDownloadInfo.r;
    localStringBuilder1 = new StringBuilder(paramDownloadInfo.d);
    localStringBuilder1.append(";");
    localStringBuilder1.append((String)localHashMap.get("NetworkType"));
    localStringBuilder1.append(";");
    localStringBuilder1.append(str1);
    localStringBuilder1.append(";");
    localStringBuilder1.append(str2);
    localStringBuilder1.append(";");
    localStringBuilder1.append((String)localHashMap.get("_filesize_from_dlg"));
    localStringBuilder1.append(";");
    localStringBuilder1.append((String)localHashMap.get("ReferURL"));
    localObject = str1;
    if (TextUtils.isEmpty(str1)) {
      if (localStringBuilder2.toString().contains("DownloadInterface"))
      {
        localObject = "DownloadAPI";
      }
      else if (localStringBuilder2.toString().contains("DownloadReceiver"))
      {
        localObject = "DownloadManager";
      }
      else if (localStringBuilder2.toString().contains("now.download.js.DownloadJSApi"))
      {
        localObject = "biz_src_now";
      }
      else if (localStringBuilder2.toString().contains("DownloadApi"))
      {
        if (str2.equals("com.tencent.qqmusic"))
        {
          localObject = "biz_src_qqmusic";
        }
        else if (str2.equals("com.tencent.nijigen"))
        {
          localObject = "biz_src_zz_bodong";
        }
        else if (str2.equals("com.tencent.mobileqq"))
        {
          localObject = "biz_src_yyb";
        }
        else if (str2.equals("com.tencent.reading"))
        {
          localObject = "biz_src_jc_neirong";
        }
        else
        {
          localObject = str1;
          if (str2.equals("com.tencent.news.lite")) {
            localObject = "biz_src_news";
          }
        }
      }
      else
      {
        if (paramDownloadInfo.h != null) {
          paramDownloadInfo = paramDownloadInfo.h;
        } else {
          paramDownloadInfo = "";
        }
        localObject = str1;
        if (!TextUtils.isEmpty(paramDownloadInfo)) {
          if (paramDownloadInfo.equals("ANDROIDQQ.QQMUSIC.GENE"))
          {
            localObject = "biz_src_qqmusic";
          }
          else if (paramDownloadInfo.equals("1"))
          {
            localObject = "biz_src_zz_bodong";
          }
          else if ((!paramDownloadInfo.equals("ANDROID.QQ.NEWYYBAPK")) && (!paramDownloadInfo.startsWith("YYBH5.STORE.COMMONDETAIL.FEED.ADVERTISE")) && (!paramDownloadInfo.equals("ANDROIDQQ.NEWYYB.XINJIFUWUHAO")))
          {
            localObject = str1;
            if (paramDownloadInfo.startsWith("ANDROIDQQ.FEED.ADVERTISE")) {
              localObject = "biz_src_ads";
            }
          }
          else
          {
            localObject = str1;
            if (!TextUtils.isEmpty(str2)) {
              localObject = "biz_src_yyb";
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      StatisticCollector.getInstance(paramContext).collectPerformance(null, "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, localHashMap, "");
      paramDownloadInfo = (String)localHashMap.get("isForeground");
      localObject = (String)localHashMap.get("isAPK");
      str1 = localStringBuilder1.toString();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append((String)localHashMap.get("Stack"));
      if (localHashMap.containsKey("Stack1")) {
        paramContext = (String)localHashMap.get("Stack1");
      } else {
        paramContext = "";
      }
      localStringBuilder1.append(paramContext);
      ReportController.b(null, "dc00898", "", "", "0X800A003", "0X800A003", 1, 0, paramDownloadInfo, (String)localObject, str1, localStringBuilder1.toString());
    }
    else
    {
      localHashMap.put("DOWNLOAD_BIG_BROTHER_SOURCE", localObject);
      StatisticCollector.getInstance(paramContext).collectPerformance(null, "UniformDownloadEvent", true, 0L, 0L, localHashMap, "");
      paramDownloadInfo = (String)localHashMap.get("isForeground");
      localObject = (String)localHashMap.get("isAPK");
      str1 = localStringBuilder1.toString();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append((String)localHashMap.get("Stack"));
      if (localHashMap.containsKey("Stack1")) {
        paramContext = (String)localHashMap.get("Stack1");
      } else {
        paramContext = "";
      }
      localStringBuilder1.append(paramContext);
      ReportController.b(null, "dc00898", "", "", "0X800A002", "0X800A002", 1, 0, paramDownloadInfo, (String)localObject, str1, localStringBuilder1.toString());
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramDownloadInfo = localHashMap.keySet().iterator();
      while (paramDownloadInfo.hasNext())
      {
        localObject = (String)paramDownloadInfo.next();
        paramContext.append((String)localObject);
        paramContext.append("=");
        paramContext.append((String)localHashMap.get(localObject));
        paramContext.append("\n");
      }
      QLog.d("UniformDownloadEvent", 2, paramContext.toString());
    }
    return;
    if (QLog.isColorLevel()) {
      QLog.d("UniformDownloadEvent", 2, "downloadInfo is null");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (paramContext != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", paramString1);
      paramString1 = new StringBuilder();
      paramString1.append(NetworkUtil.getNetworkType(paramContext));
      paramString1.append("");
      localHashMap.put("NetworkType", paramString1.toString());
      if (a(paramContext)) {
        paramString1 = "1";
      } else {
        paramString1 = "0";
      }
      localHashMap.put("isForeground", paramString1);
      localHashMap.put("reportVia", "6");
      paramString1 = new Throwable().getStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 1;
      while (i < paramString1.length)
      {
        localStringBuilder.append(paramString1[i].toString());
        i += 1;
      }
      if (localStringBuilder.length() < 950)
      {
        localHashMap.put("Stack", localStringBuilder.toString());
      }
      else
      {
        localHashMap.put("Stack", localStringBuilder.substring(0, 950));
        if (localStringBuilder.length() < 1901) {
          localHashMap.put("Stack1", localStringBuilder.substring(950));
        } else {
          localHashMap.put("Stack1", localStringBuilder.substring(950, 1900));
        }
      }
      localHashMap.put("_filesize_from_dlg", "");
      localHashMap.put("_filename_from_dlg", paramString2);
      localHashMap.put("isAPK", "1");
      localHashMap.put("ReferURL", "");
      if (TextUtils.isEmpty(paramString3))
      {
        StatisticCollector.getInstance(paramContext).collectPerformance(null, "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, localHashMap, "");
      }
      else
      {
        localHashMap.put("DOWNLOAD_BIG_BROTHER_SOURCE", paramString3);
        StatisticCollector.getInstance(paramContext).collectPerformance(null, "UniformDownloadEvent", true, 0L, 0L, localHashMap, "");
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramString1 = localHashMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          paramContext.append(paramString2);
          paramContext.append("=");
          paramContext.append((String)localHashMap.get(paramString2));
          paramContext.append("\n");
        }
        QLog.d("UniformDownloadEvent", 2, paramContext.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UniformDownloadEvent", 2, "info or context is null");
    }
  }
  
  public static void a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo)
  {
    a(paramAppInterface.getApp(), paramDownloadInfo);
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      Object localObject1 = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
      paramContext = paramContext.getApplicationContext().getPackageName();
      localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        if ((((ActivityManager.RunningAppProcessInfo)localObject2).importance == 100) && (((ActivityManager.RunningAppProcessInfo)localObject2).processName != null)) {
          if (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals(paramContext))
          {
            localObject2 = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramContext);
            localStringBuilder.append(":");
            boolean bool = ((String)localObject2).startsWith(localStringBuilder.toString());
            if (!bool) {
              break;
            }
          }
          else
          {
            return true;
          }
        }
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.endsWith("patch")) || (paramString.endsWith("zip")) || (paramString.endsWith("7z")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadInfoReport
 * JD-Core Version:    0.7.0.1
 */