package com.tencent.rmonitor.base.config;

import com.tencent.rmonitor.base.config.data.RPluginConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/config/DefaultPluginConfig;", "", "plugin", "", "mode", "pluginName", "", "entrance", "curReportNum", "config", "Lcom/tencent/rmonitor/base/config/data/RPluginConfig;", "(IILjava/lang/String;Ljava/lang/String;ILcom/tencent/rmonitor/base/config/data/RPluginConfig;)V", "BigBitmapPlugin", "CeilingHprofPlugin", "CeilingValuePlugin", "DBPlugin", "DevicePlugin", "DropFramePlugin", "FdLeakPlugin", "IOPlugin", "LeakPlugin", "LoopStackPlugin", "NatMemPlugin", "QQBatteryPlugin", "ResourcePlugin", "StatisticsPlugin", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$DropFramePlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$LoopStackPlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$DBPlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$IOPlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$LeakPlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$CeilingHprofPlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$CeilingValuePlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$QQBatteryPlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$DevicePlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$ResourcePlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$StatisticsPlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$BigBitmapPlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$FdLeakPlugin;", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig$NatMemPlugin;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract class DefaultPluginConfig
{
  @JvmField
  public final int a;
  @JvmField
  public final int b;
  @JvmField
  @NotNull
  public String c;
  @JvmField
  @NotNull
  public String d;
  @JvmField
  public int e;
  @JvmField
  @NotNull
  public final RPluginConfig f;
  
  private DefaultPluginConfig(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, RPluginConfig paramRPluginConfig)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramInt3;
    this.f = paramRPluginConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.DefaultPluginConfig
 * JD-Core Version:    0.7.0.1
 */