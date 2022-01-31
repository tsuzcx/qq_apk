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
    if (a.nextInt(1000) != 0) {}
    do
    {
      do
      {
        return;
        localObject1 = new HashMap();
        ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, String.valueOf(paramInt));
        ((HashMap)localObject1).put("plugin_name", paramString);
        ((HashMap)localObject1).put("cost", String.valueOf(paramLong));
        ((HashMap)localObject1).put("result", String.valueOf(paramInt));
        localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      } while (localObject2 == null);
      Object localObject2 = ((AppRuntime)localObject2).getAccount();
      StatisticCollector.a(MobileQQ.sMobileQQ).a((String)localObject2, "actPluginDexa2OatInfo", false, paramLong, 0L, (HashMap)localObject1, null);
    } while (!QLog.isColorLevel());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uploadDexOatInfo pluginId ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(String.valueOf(paramInt));
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(paramLong);
    QLog.d("PluginStatisticsCollector", 2, ((StringBuilder)localObject1).toString());
  }
  
  public void uploadStartupFailure(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool = false;
    if ("success".equals(paramString5)) {
      bool = true;
    }
    String str = paramString5;
    if (paramString5 != null)
    {
      str = paramString5;
      if (paramString5.contains(ClassNotFoundException.class.getName()))
      {
        float f = FileUtils.a();
        str = "GetAvailableInnernalMemorySize:" + f + "__" + paramString5;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginStatisticsCollector", 2, "uploadStartupFailure result = " + bool + ", pluginName = " + paramString2 + ", extraInfo = " + str);
    }
    if (!bool)
    {
      paramString5 = new HashMap();
      paramString5.put(BaseConstants.RDM_NoChangeFailCode, "");
      paramString5.put("plugin_name", paramString2);
      paramString5.put("plugin_loc", paramString3);
      paramString5.put("plugin_activity", paramString4);
      paramString5.put("plugin_extra_info", str);
      StatisticCollector.a(paramContext).a(paramString1, "actPluginStartupFailure", bool, 0L, 0L, paramString5, null);
    }
    paramString3 = new HashMap();
    paramString3.put(BaseConstants.RDM_NoChangeFailCode, "");
    paramString3.put("plugin_name", paramString2);
    StatisticCollector.a(paramContext).a(paramString1, "actPluginStartupResult", bool, 0L, 0L, paramString3, null);
  }
  
  public void uploadStartupSpeedInfo(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginStatisticsCollector", 2, "uploadLaunchInfo");
    }
    long l1 = paramIntent.getLongExtra("launchTotal", 0L);
    long l2 = paramIntent.getLongExtra("launchType", 0L);
    String str1 = paramIntent.getStringExtra("pluginsdk_selfuin");
    String str2 = paramIntent.getStringExtra("pluginsdk_pluginName");
    String str3 = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    String str4 = paramIntent.getStringExtra("pluginsdk_pluginpath");
    paramIntent = paramIntent.getStringExtra("pluginsdk_launchActivity");
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("plugin_name", str2);
    localHashMap.put("plugin_loc", str3);
    localHashMap.put("plugin_activity", paramIntent);
    localHashMap.put("plugin_extra_info", str4);
    localHashMap.put("launchTotal", String.valueOf(l1));
    localHashMap.put("launchType", String.valueOf(l2));
    StatisticCollector.a(paramContext).a(str1, "actPluginSpeedInfo", false, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel()) {
      QLog.d("PluginStatisticsCollector", 2, "uploadStartupSpeedInfo  " + l1 + " " + l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.PluginStatisticsCollector
 * JD-Core Version:    0.7.0.1
 */