package com.tencent.rmonitor.base.config.impl;

import com.tencent.rmonitor.base.config.IConfigLoader;
import com.tencent.rmonitor.base.config.PluginCombination;
import com.tencent.rmonitor.base.config.PluginCombination.Companion;
import com.tencent.rmonitor.base.config.data.RMonitorConfig;
import com.tencent.rmonitor.common.logger.Logger;
import java.net.URL;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class DefaultConfigLoader
  implements IConfigLoader
{
  private static final int a = PluginCombination.a.b();
  private final IConfigApply b;
  private final IConfigSaver c;
  private final IConfigParser d;
  
  public DefaultConfigLoader(URL paramURL)
  {
    this.b = new ConfigApply(paramURL);
    this.c = new ConfigSaverImpl();
    this.d = new ConfigParserImpl();
  }
  
  public void a(@NotNull RMonitorConfig paramRMonitorConfig)
  {
    int j = this.b.a(a);
    int i = 0;
    JSONObject localJSONObject;
    if (j != 1)
    {
      if (j != 2)
      {
        Logger.b.e(new String[] { "RMonitor_config_DefaultConfigLoader", "loadConfig, result: ", String.valueOf(j) });
        localJSONObject = null;
      }
      else
      {
        i = this.b.a();
        localJSONObject = this.c.a();
      }
    }
    else
    {
      i = this.b.a();
      localJSONObject = this.b.b();
      if (!this.c.a(localJSONObject)) {
        Logger.b.e(new String[] { "RMonitor_config_DefaultConfigLoader", "loadConfig", "save config fail" });
      }
    }
    if (localJSONObject != null) {
      this.d.a(localJSONObject, paramRMonitorConfig);
    }
    paramRMonitorConfig.f = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.impl.DefaultConfigLoader
 * JD-Core Version:    0.7.0.1
 */