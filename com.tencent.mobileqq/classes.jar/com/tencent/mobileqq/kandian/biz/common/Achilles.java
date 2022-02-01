package com.tencent.mobileqq.kandian.biz.common;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderProxy;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.kandian.base.utils.AchillesFragmentUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJMaybeInitializedAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.config.AchillesParams;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class Achilles
{
  private static Map<String, Long> a = new HashMap();
  private static String b = "biz_src_feeds_kandian_tab";
  private static final Runnable c = new Achilles.1();
  
  public static Set<AchillesParams> a()
  {
    return Aladdin.getConfig(140).getSet("param_set");
  }
  
  public static void a(String paramString)
  {
    QLog.d("Achilles", 2, "[maybeStart] ");
    b = paramString;
    ThreadManager.executeOnFileThread(c);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, AchillesParams paramAchillesParams)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAchillesParams != null) {}
    try
    {
      localJSONObject.put(paramAchillesParams.getPackageName(), paramAchillesParams.toString());
      label27:
      PublicAccountReportUtils.a(null, "", "0X8009ECD", "0X8009ECD", 0, 0, paramString1, paramString2, paramString3, localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramAchillesParams)
    {
      break label27;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, WebViewPlugin.PluginRuntime paramPluginRuntime, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        RIJMaybeInitializedAladdinConfig.a();
        Object localObject = a();
        if ((localObject != null) && (!((Set)localObject).isEmpty()))
        {
          StringBuilder localStringBuilder = null;
          Iterator localIterator = ((Set)localObject).iterator();
          localObject = localStringBuilder;
          if (localIterator.hasNext())
          {
            localObject = (AchillesParams)localIterator.next();
            if (!TextUtils.equals(((AchillesParams)localObject).getPackageName(), paramString2)) {
              continue;
            }
          }
          if ((localObject != null) && (((AchillesParams)localObject).isEnable()))
          {
            if ((paramBoolean) && (!((AchillesParams)localObject).isInstallIfJump()))
            {
              paramString1 = new StringBuilder();
              paramString1.append("[installIfDownloaded] installIfJump is false ");
              paramString1.append(paramString2);
              QLog.e("Achilles", 1, paramString1.toString());
              return false;
            }
            localObject = b(paramString2);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[installIfDownloaded] downloadInfo: ");
            localStringBuilder.append(localObject);
            QLog.d("Achilles", 1, localStringBuilder.toString());
            if (localObject != null)
            {
              paramBoolean = RockDownloaderProxy.c((RockDownloadInfo)localObject);
              return AchillesFragmentUtils.a(paramString1, paramString2, paramPluginRuntime, paramBoolean);
            }
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append("[installIfDownloaded] no enabled found in param set, package name: ");
            paramString1.append(paramString2);
            QLog.e("Achilles", 1, paramString1.toString());
            return false;
          }
        }
        else
        {
          QLog.e("Achilles", 1, "[installIfDownloaded] empty param set");
          return false;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("Achilles", 1, "[installIfDownloaded] ", paramString1);
        return false;
      }
      paramBoolean = false;
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a(null, paramString, null, true);
  }
  
  private static RockDownloadInfo b(AchillesParams paramAchillesParams)
  {
    RockDownloadInfo localRockDownloadInfo = new RockDownloadInfo();
    localRockDownloadInfo.packageName = paramAchillesParams.getPackageName();
    localRockDownloadInfo.businessName = b;
    localRockDownloadInfo.businessScene = paramAchillesParams.getSceneId();
    localRockDownloadInfo.downloadURL = paramAchillesParams.getDownloadUrl();
    localRockDownloadInfo.versionCode = paramAchillesParams.getVersionCode();
    return localRockDownloadInfo;
  }
  
  public static RockDownloadInfo b(String paramString)
  {
    List localList = e(paramString);
    paramString = new StringBuilder();
    paramString.append("[installIfDownloaded] downloadInfoList: ");
    paramString.append(localList);
    QLog.d("Achilles", 1, paramString.toString());
    Iterator localIterator = null;
    paramString = null;
    Object localObject = localIterator;
    if (localList != null)
    {
      localObject = localIterator;
      if (localList.size() > 0)
      {
        int i = -1;
        localIterator = localList.iterator();
        for (;;)
        {
          localObject = paramString;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (RockDownloadInfo)localIterator.next();
          if (((RockDownloadInfo)localObject).getRealVersionCode() > i)
          {
            i = ((RockDownloadInfo)localObject).getRealVersionCode();
            paramString = (String)localObject;
          }
        }
      }
    }
    return localObject;
  }
  
  private static void b(RockDownloadInfo paramRockDownloadInfo, AchillesParams paramAchillesParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start download ");
    localStringBuilder.append(paramAchillesParams);
    QLog.d("Achilles", 1, localStringBuilder.toString());
    a("download", "1", paramAchillesParams.getPackageName(), paramAchillesParams);
    RockDownloaderProxy.a(paramRockDownloadInfo, new Achilles.AchilesRockDownloadListener(null));
  }
  
  private static void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = (Long)a.get(paramString1);
    long l2 = System.currentTimeMillis();
    long l1;
    if (localObject == null) {
      l1 = 0L;
    } else {
      l1 = ((Long)localObject).longValue();
    }
    localObject = RIJQQAppInterfaceUtil.d();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("param_FailMsg", paramString2);
    localHashMap.put("uin", localObject);
    StatisticCollector.getInstance(RIJQQAppInterfaceUtil.e().getApplication()).collectPerformance((String)localObject, "actAchilles", paramBoolean, l2 - l1, 0L, localHashMap, null, false);
    if (paramBoolean) {
      paramString2 = "1";
    } else {
      paramString2 = "0";
    }
    a("downloadresult", paramString2, paramString1, null);
  }
  
  public static boolean c(String paramString)
  {
    try
    {
      if (ApkUtils.a(paramString, BaseApplicationImpl.getContext()))
      {
        QLog.e("Achilles", 1, "[isInstalled] true");
        return true;
      }
      QLog.e("Achilles", 1, "[isInstalled] false");
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e("Achilles", 1, "[isInstalled] ", paramString);
    }
    return false;
  }
  
  public static String d(String paramString)
  {
    for (;;)
    {
      try
      {
        RIJMaybeInitializedAladdinConfig.a();
        localObject1 = a();
        if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
        {
          Object localObject3 = ((Set)localObject1).iterator();
          localObject1 = null;
          Object localObject2;
          if (((Iterator)localObject3).hasNext())
          {
            localObject2 = (AchillesParams)((Iterator)localObject3).next();
            if (!TextUtils.equals(((AchillesParams)localObject2).getPackageName(), paramString)) {
              continue;
            }
            localObject1 = localObject2;
            continue;
          }
          if (localObject1 == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[queryPreDownloadInfoAladdin] param not found for ");
            ((StringBuilder)localObject1).append(paramString);
            QLog.e("Achilles", 1, ((StringBuilder)localObject1).toString());
            return "";
          }
          localObject3 = b(paramString);
          int j = 0;
          if (localObject3 != null)
          {
            bool = true;
            paramString = new StringBuilder();
            paramString.append("[queryPreDownloadInfoAladdin] download info pkgExist:");
            paramString.append(bool);
            paramString.append(" packageName:");
            paramString.append(((AchillesParams)localObject1).getPackageName());
            QLog.i("Achilles", 1, paramString.toString());
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("app_id", ((AchillesParams)localObject1).getAppId());
            if (localObject3 == null) {
              break label351;
            }
            paramString = ((RockDownloadInfo)localObject3).getDownloadURL();
            ((JSONObject)localObject2).put("download_url", paramString);
            if (!bool) {
              break label357;
            }
            i = 1;
            ((JSONObject)localObject2).put("download_finished", i);
            i = j;
            if (((AchillesParams)localObject1).isEnable()) {
              i = 1;
            }
            ((JSONObject)localObject2).put("enable_predownload", i);
            if (!bool) {
              break label362;
            }
            paramString = "1";
            if (localObject3 == null) {
              break label369;
            }
            localObject1 = ((RockDownloadInfo)localObject3).getPackageName();
            a("query", paramString, (String)localObject1, null);
            return ((JSONObject)localObject2).toString();
          }
        }
        else
        {
          QLog.e("Achilles", 1, "[queryPreDownloadInfoAladdin] empty param set.");
          return "";
        }
      }
      catch (Exception paramString)
      {
        QLog.e("Achilles", 1, "[queryPreDownloadInfoAladdin] ", paramString);
        return "";
      }
      boolean bool = false;
      continue;
      label351:
      paramString = "";
      continue;
      label357:
      int i = 0;
      continue;
      label362:
      paramString = "0";
      continue;
      label369:
      Object localObject1 = "";
    }
  }
  
  private static List<RockDownloadInfo> e(String paramString)
  {
    RockDownloadInfo localRockDownloadInfo = new RockDownloadInfo();
    localRockDownloadInfo.packageName = paramString;
    localRockDownloadInfo.businessName = "biz_src_feeds_kandian_tab";
    paramString = RockDownloaderProxy.a(localRockDownloadInfo);
    if ((paramString != null) && (paramString.size() > 0)) {
      return paramString;
    }
    localRockDownloadInfo.businessName = "biz_src_feeds_kandian_news";
    paramString = RockDownloaderProxy.a(localRockDownloadInfo);
    if ((paramString != null) && (paramString.size() > 0)) {
      return paramString;
    }
    localRockDownloadInfo.businessName = "biz_src_feeds_kandian_daily";
    paramString = RockDownloaderProxy.a(localRockDownloadInfo);
    if ((paramString != null) && (paramString.size() > 0)) {
      return paramString;
    }
    return null;
  }
  
  private static boolean e()
  {
    return NetworkState.isWifiConn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.Achilles
 * JD-Core Version:    0.7.0.1
 */