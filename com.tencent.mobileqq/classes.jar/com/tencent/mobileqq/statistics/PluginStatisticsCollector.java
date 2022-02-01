package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.IStatisticsUploader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PluginStatisticsCollector
  implements IStatisticsUploader
{
  public static final Random a = new Random();
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    if (a.nextInt(1000) != 0) {
      return;
    }
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, String.valueOf(paramInt));
    ((HashMap)localObject1).put("plugin_name", paramString);
    ((HashMap)localObject1).put("cost", String.valueOf(paramLong));
    ((HashMap)localObject1).put("result", String.valueOf(paramInt));
    Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject2 != null)
    {
      localObject2 = ((AppRuntime)localObject2).getAccount();
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance((String)localObject2, "actPluginDexa2OatInfo", false, paramLong, 0L, (HashMap)localObject1, null);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("uploadDexOatInfo pluginId ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(String.valueOf(paramInt));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.d("PluginStatisticsCollector", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void uploadStartupFailure(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject = paramString5;
    boolean bool = "success".equals(localObject);
    paramString5 = (String)localObject;
    if (localObject != null)
    {
      paramString5 = (String)localObject;
      if (((String)localObject).contains(ClassNotFoundException.class.getName()))
      {
        float f = FileUtils.getAvailableInnernalMemorySize();
        paramString5 = new StringBuilder();
        paramString5.append("GetAvailableInnernalMemorySize:");
        paramString5.append(f);
        paramString5.append("__");
        paramString5.append((String)localObject);
        paramString5 = paramString5.toString();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uploadStartupFailure result = ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", pluginName = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", extraInfo = ");
      ((StringBuilder)localObject).append(paramString5);
      QLog.d("PluginStatisticsCollector", 2, ((StringBuilder)localObject).toString());
    }
    if (!bool)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      ((HashMap)localObject).put("plugin_name", paramString2);
      ((HashMap)localObject).put("plugin_loc", paramString3);
      ((HashMap)localObject).put("plugin_activity", paramString4);
      ((HashMap)localObject).put("plugin_extra_info", paramString5);
      StatisticCollector.getInstance(paramContext).collectPerformance(paramString1, "actPluginStartupFailure", bool, 0L, 0L, (HashMap)localObject, null);
    }
    paramString3 = new HashMap();
    paramString3.put(BaseConstants.RDM_NoChangeFailCode, "");
    paramString3.put("plugin_name", paramString2);
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString1, "actPluginStartupResult", bool, 0L, 0L, paramString3, null);
  }
  
  public void uploadStartupSpeedInfo(Context paramContext, Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("launchTotal", 0L);
    long l2 = paramIntent.getLongExtra("pluginApkCost", 0L);
    long l3 = paramIntent.getLongExtra("pluginOatCost", 0L);
    long l4 = paramIntent.getLongExtra("pluginDownloadCost", 0L);
    long l5 = paramIntent.getLongExtra("pluginLibCost", 0L);
    long l6 = paramIntent.getLongExtra("pluginLoaderCost", 0L);
    String str1 = paramIntent.getStringExtra("launchComponent");
    String str2 = paramIntent.getStringExtra("launchProcName");
    String str4 = paramIntent.getStringExtra("pluginsdk_selfuin");
    String str5 = paramIntent.getStringExtra("pluginsdk_pluginName");
    String str3 = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    String str6 = paramIntent.getStringExtra("pluginsdk_pluginpath");
    paramIntent = paramIntent.getStringExtra("pluginsdk_launchActivity");
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("plugin_name", str5);
    localHashMap.put("plugin_loc", str3);
    localHashMap.put("plugin_activity", paramIntent);
    localHashMap.put("plugin_extra_info", str6);
    localHashMap.put("pluginOatCost", String.valueOf(l3));
    localHashMap.put("pluginApkCost", String.valueOf(l2));
    localHashMap.put("pluginLoaderCost", String.valueOf(l6));
    localHashMap.put("launchTotal", String.valueOf(l1));
    StatisticCollector.getInstance(paramContext).collectPerformance(str4, "actPluginSpeedInfoV2", false, l1, 0L, localHashMap, null);
    paramContext = new StringBuilder();
    paramContext.append("uploadStartupSpeedInfo  ");
    paramContext.append(str3);
    paramContext.append(", launchTotal ");
    paramContext.append(l1);
    paramContext.append(", apkCost ");
    paramContext.append(l2);
    paramContext.append(", dex2OatCost ");
    paramContext.append(l3);
    paramContext.append(", libCost ");
    paramContext.append(l5);
    paramContext.append(", downloadCost ");
    paramContext.append(l4);
    paramContext.append(", loaderCost ");
    paramContext.append(l6);
    paramContext.append(", launchComponent ");
    paramContext.append(str1);
    paramContext.append(", procName ");
    paramContext.append(str2);
    QLog.d("plugin_tag", 1, paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.PluginStatisticsCollector
 * JD-Core Version:    0.7.0.1
 */