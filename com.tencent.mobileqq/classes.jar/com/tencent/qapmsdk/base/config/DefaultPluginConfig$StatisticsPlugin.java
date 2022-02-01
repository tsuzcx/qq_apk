package com.tencent.qapmsdk.base.config;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$StatisticsPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "plugin", "", "mode", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "(IIIIFILjava/lang/String;Ljava/lang/String;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class DefaultPluginConfig$StatisticsPlugin
  extends DefaultPluginConfig
{
  public DefaultPluginConfig$StatisticsPlugin()
  {
    this(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
  }
  
  public DefaultPluginConfig$StatisticsPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @NotNull String paramString1, @NotNull String paramString2)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, paramInt5, paramString1, paramString2, 0, 256, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.DefaultPluginConfig.StatisticsPlugin
 * JD-Core Version:    0.7.0.1
 */