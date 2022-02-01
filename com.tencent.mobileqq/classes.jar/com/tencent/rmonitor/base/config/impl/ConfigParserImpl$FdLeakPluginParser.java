package com.tencent.rmonitor.base.config.impl;

import android.text.TextUtils;
import com.tencent.rmonitor.base.config.data.FdLeakPluginConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;

class ConfigParserImpl$FdLeakPluginParser
  implements IPluginConfigParser
{
  public void a(@NotNull RPluginConfig paramRPluginConfig, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    } else {
      paramString = paramString.split(",");
    }
    ConfigParserImpl.a(paramString, paramRPluginConfig);
    if (((paramRPluginConfig instanceof FdLeakPluginConfig)) && (paramString != null) && (paramString.length >= 9))
    {
      paramRPluginConfig = (FdLeakPluginConfig)paramRPluginConfig;
      try
      {
        paramRPluginConfig.a = Integer.parseInt(paramString[4]);
        paramRPluginConfig.b = Integer.parseInt(paramString[5]);
        paramRPluginConfig.c = Float.parseFloat(paramString[6]);
        paramRPluginConfig.d = Float.parseFloat(paramString[7]);
        paramRPluginConfig.e = Integer.parseInt(paramString[8]);
        return;
      }
      catch (NumberFormatException paramRPluginConfig)
      {
        Logger.b.e(new String[] { "RMonitor_config_ConfigParserImpl", "FdLeakPluginParser parsePluginConfig", paramRPluginConfig.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.impl.ConfigParserImpl.FdLeakPluginParser
 * JD-Core Version:    0.7.0.1
 */