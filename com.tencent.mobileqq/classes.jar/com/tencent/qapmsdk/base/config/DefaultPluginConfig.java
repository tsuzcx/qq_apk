package com.tencent.qapmsdk.base.config;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "", "plugin", "", "mode", "threshold", "maxReportNum", "eventSampleRatio", "", "stackDepth", "pluginName", "", "entrance", "curReportNum", "(IIIIFILjava/lang/String;Ljava/lang/String;I)V", "AnrPlugin", "BigBitmapPlugin", "BreadCrumbPlugin", "CeilingHprofPlugin", "CeilingValuePlugin", "CrashPlugin", "DBPlugin", "DevicePlugin", "DropFramePlugin", "HttpPlugin", "IOPlugin", "JsErrorPlugin", "LeakPlugin", "LoopStackPlugin", "QQBatteryPlugin", "ResourcePlugin", "StartUpPlugin", "StatisticsPlugin", "WebViewPlugin", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$DropFramePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$LoopStackPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$DBPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$IOPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$LeakPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$CeilingHprofPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$CeilingValuePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$QQBatteryPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$DevicePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$ResourcePlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$CrashPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$AnrPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$WebViewPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$HttpPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$JsErrorPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$BreadCrumbPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$StatisticsPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$BigBitmapPlugin;", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$StartUpPlugin;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract class DefaultPluginConfig
{
  @JvmField
  public int curReportNum;
  @JvmField
  @NotNull
  public String entrance;
  @JvmField
  public float eventSampleRatio;
  @JvmField
  public int maxReportNum;
  @JvmField
  public final int mode;
  @JvmField
  public final int plugin;
  @JvmField
  @NotNull
  public String pluginName;
  @JvmField
  public int stackDepth;
  @JvmField
  public int threshold;
  
  private DefaultPluginConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, String paramString1, String paramString2, int paramInt6)
  {
    this.plugin = paramInt1;
    this.mode = paramInt2;
    this.threshold = paramInt3;
    this.maxReportNum = paramInt4;
    this.eventSampleRatio = paramFloat;
    this.stackDepth = paramInt5;
    this.pluginName = paramString1;
    this.entrance = paramString2;
    this.curReportNum = paramInt6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.DefaultPluginConfig
 * JD-Core Version:    0.7.0.1
 */