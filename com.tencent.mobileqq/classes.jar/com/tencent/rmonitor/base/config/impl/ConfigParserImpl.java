package com.tencent.rmonitor.base.config.impl;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.rmonitor.base.config.data.RMonitorConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import com.tencent.rmonitor.base.constants.PluginId;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

class ConfigParserImpl
  implements IConfigParser
{
  private final SparseArray<IPluginConfigParser> a = new SparseArray(2);
  private final ConfigParserImpl.DefaultPluginParser b = new ConfigParserImpl.DefaultPluginParser();
  
  public ConfigParserImpl()
  {
    this.a.append(154, new ConfigParserImpl.NatMemPluginParser());
    this.a.append(151, new ConfigParserImpl.FdLeakPluginParser());
  }
  
  private void a(int paramInt, RPluginConfig paramRPluginConfig, JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("p_");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (paramJSONObject.has((String)localObject)) {
      paramJSONObject = paramJSONObject.getString((String)localObject);
    } else {
      paramJSONObject = null;
    }
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      IPluginConfigParser localIPluginConfigParser = (IPluginConfigParser)this.a.get(paramInt);
      localObject = localIPluginConfigParser;
      if (localIPluginConfigParser == null) {
        localObject = this.b;
      }
      ((IPluginConfigParser)localObject).a(paramRPluginConfig, paramJSONObject);
    }
  }
  
  private static void b(String[] paramArrayOfString, RPluginConfig paramRPluginConfig)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length >= 4)) {
      try
      {
        paramArrayOfString = new RPluginConfig(Integer.parseInt(paramArrayOfString[0]), Integer.parseInt(paramArrayOfString[1]), Float.parseFloat(paramArrayOfString[2]), Integer.parseInt(paramArrayOfString[3]));
      }
      catch (NumberFormatException paramArrayOfString)
      {
        Logger.b.e(new String[] { "RMonitor_config_ConfigParserImpl", "parsePluginConfig", paramArrayOfString.getMessage() });
      }
    } else {
      paramArrayOfString = null;
    }
    if (paramArrayOfString != null) {
      paramRPluginConfig.a(paramArrayOfString);
    }
  }
  
  public boolean a(JSONObject paramJSONObject, @NotNull RMonitorConfig paramRMonitorConfig)
  {
    if (paramJSONObject != null) {
      try
      {
        if (paramJSONObject.getString("pid").equals(BaseInfo.userMeta.appId))
        {
          if (paramJSONObject.has("usr")) {
            paramRMonitorConfig.a = ((float)paramJSONObject.getDouble("usr"));
          }
          if (paramJSONObject.has("ma")) {
            paramRMonitorConfig.b = paramJSONObject.getInt("ma");
          }
          if (paramJSONObject.has("mb")) {
            paramRMonitorConfig.c = paramJSONObject.getInt("mb");
          }
          if (paramJSONObject.has("vt")) {
            paramRMonitorConfig.d = paramJSONObject.getInt("vt");
          }
          if (paramJSONObject.has("rt")) {
            paramRMonitorConfig.e = paramJSONObject.getInt("rt");
          }
          int[] arrayOfInt = PluginId.a;
          int j = arrayOfInt.length;
          int i = 0;
          while (i < j)
          {
            int k = arrayOfInt[i];
            a(k, paramRMonitorConfig.a(k), paramJSONObject);
            i += 1;
          }
          return true;
        }
      }
      catch (Throwable paramJSONObject)
      {
        Logger.b.e(new String[] { "RMonitor_config_ConfigParserImpl", "parseConfig", paramJSONObject.getMessage() });
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.impl.ConfigParserImpl
 * JD-Core Version:    0.7.0.1
 */