package com.tencent.qqperf.abfactor;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.reporter.ab.AbProxy;
import com.tencent.qapmsdk.base.reporter.ab.AbType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.HashMap;
import org.json.JSONObject;

public class AbFactorManger
{
  public static Class<? extends AbType>[] a = { AbFactorAIODynamicBg.class, AbFactorProfileCardBg.class };
  
  public static int a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramString != null)
    {
      if ("actSceneMem".equals(paramString)) {
        return PluginCombination.leakPlugin.plugin;
      }
      if ("actScenePerf".equals(paramString)) {
        return PluginCombination.resourcePlugin.plugin;
      }
      if ("unifiedMonitor".equals(paramString))
      {
        int i = Integer.parseInt((String)paramHashMap.get("family"));
        if (i != 0)
        {
          if (i != 20) {
            switch (i)
            {
            default: 
              break;
            case 11: 
              return PluginCombination.qqBatteryPlugin.plugin;
            case 9: 
            case 10: 
              return PluginCombination.dropFramePlugin.plugin;
            }
          } else {
            return PluginCombination.resourcePlugin.plugin;
          }
        }
        else {
          return PluginCombination.loopStackPlugin.plugin;
        }
      }
    }
    return -1;
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    paramHashMap.put("deviceLv", String.valueOf(DeviceInfoUtils.a()));
    paramString = AbProxy.getAbFactorByQapmPlugin(a(paramString, paramHashMap));
    if ((paramString != null) && (paramString.length() > 0)) {
      paramHashMap.put("abfactor", paramString);
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    String str = "newplugin";
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("newplugin")) {
          break label62;
        }
        int i = paramJSONObject.getInt(str);
        str = AbProxy.getAbFactorByQapmPlugin(i);
        if ((str != null) && (str.length() > 0))
        {
          paramJSONObject.put("abfactor", str);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("MagnifierSDK.QAPM.AbFactorManger", 2, "", paramJSONObject);
      }
      return;
      label62:
      str = "plugin";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.abfactor.AbFactorManger
 * JD-Core Version:    0.7.0.1
 */