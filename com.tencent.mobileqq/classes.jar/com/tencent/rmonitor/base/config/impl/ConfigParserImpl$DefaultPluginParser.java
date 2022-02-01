package com.tencent.rmonitor.base.config.impl;

import com.tencent.rmonitor.base.config.data.RPluginConfig;
import org.jetbrains.annotations.NotNull;

class ConfigParserImpl$DefaultPluginParser
  implements IPluginConfigParser
{
  public void a(@NotNull RPluginConfig paramRPluginConfig, String paramString)
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = paramString.split(",");
    }
    ConfigParserImpl.a(paramString, paramRPluginConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.impl.ConfigParserImpl.DefaultPluginParser
 * JD-Core Version:    0.7.0.1
 */