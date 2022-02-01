package com.tencent.rmonitor.base.config.impl;

import android.text.TextUtils;
import com.tencent.rmonitor.base.config.data.NatMemPluginConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;

class ConfigParserImpl$NatMemPluginParser
  implements IPluginConfigParser
{
  public void a(@NotNull RPluginConfig paramRPluginConfig, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    } else {
      paramString = paramString.split(",");
    }
    if ((paramString != null) && (paramString.length >= 9)) {}
    for (;;)
    {
      try
      {
        int i = Integer.parseInt(paramString[0]);
        int j = Integer.parseInt(paramString[1]);
        float f = Float.parseFloat(paramString[2]);
        int k = Integer.parseInt(paramString[3]);
        int m = Integer.parseInt(paramString[4]);
        int n = Integer.parseInt(paramString[5]);
        int i1 = Integer.parseInt(paramString[6]);
        boolean bool2 = Boolean.parseBoolean(paramString[7]);
        long l = Long.parseLong(paramString[8]);
        if (paramString.length < 10) {
          break label220;
        }
        bool1 = Boolean.parseBoolean(paramString[9]);
        paramString = new NatMemPluginConfig(i, j, f, k, m, n, i1, bool2, bool1, l);
      }
      catch (NumberFormatException paramString)
      {
        Logger localLogger = Logger.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parsePluginConfig error: ");
        localStringBuilder.append(paramString.toString());
        localLogger.d(new String[] { "RMonitor_config_ConfigParserImpl", localStringBuilder.toString() });
      }
      paramString = null;
      if (paramString != null) {
        paramRPluginConfig.a(paramString);
      }
      return;
      label220:
      boolean bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.impl.ConfigParserImpl.NatMemPluginParser
 * JD-Core Version:    0.7.0.1
 */