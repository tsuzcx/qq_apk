package com.tencent.qapmsdk.base.config;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/PluginCombination;", "", "()V", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class PluginCombination
{
  public static final PluginCombination.Companion Companion = new PluginCombination.Companion(null);
  @JvmField
  @NotNull
  public static final DefaultPluginConfig anrPlugin;
  private static final List<DefaultPluginConfig> austerityPlugins = CollectionsKt.listOf(new DefaultPluginConfig[] { dropFramePlugin, dbPlugin, ioPlugin, leakPlugin, ceilingHprofPlugin, ceilingValuePlugin, batteryPlugin, devicePlugin, anrPlugin, crashPlugin, statisticsPlugin });
  @JvmField
  @NotNull
  public static final DefaultPluginConfig batteryPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig ceilingHprofPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig ceilingValuePlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig crashPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig dbPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig devicePlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig dropFramePlugin = (DefaultPluginConfig)new DefaultPluginConfig.DropFramePlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
  @JvmField
  @NotNull
  public static final DefaultPluginConfig httpPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig ioPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig jsErrorPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig leakPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig loopStackPlugin = (DefaultPluginConfig)new DefaultPluginConfig.LoopStackPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
  @NotNull
  private static final List<DefaultPluginConfig> loosePlugins = CollectionsKt.listOf(new DefaultPluginConfig[] { loopStackPlugin, resourcePlugin, webViewPlugin, httpPlugin, jsErrorPlugin, userBreadCrumbPlugin });
  @NotNull
  private static final Lazy modeAll$delegate;
  @NotNull
  private static final Lazy modeStable$delegate;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig resourcePlugin;
  private static final List<DefaultPluginConfig> stablePlugins;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig statisticsPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig userBreadCrumbPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig webViewPlugin;
  
  static
  {
    dbPlugin = (DefaultPluginConfig)new DefaultPluginConfig.DBPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    ioPlugin = (DefaultPluginConfig)new DefaultPluginConfig.IOPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    leakPlugin = (DefaultPluginConfig)new DefaultPluginConfig.LeakPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    ceilingHprofPlugin = (DefaultPluginConfig)new DefaultPluginConfig.CeilingHprofPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    ceilingValuePlugin = (DefaultPluginConfig)new DefaultPluginConfig.CeilingValuePlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    batteryPlugin = (DefaultPluginConfig)new DefaultPluginConfig.BatteryPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    devicePlugin = (DefaultPluginConfig)new DefaultPluginConfig.DevicePlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    resourcePlugin = (DefaultPluginConfig)new DefaultPluginConfig.ResourcePlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    crashPlugin = (DefaultPluginConfig)new DefaultPluginConfig.CrashPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    anrPlugin = (DefaultPluginConfig)new DefaultPluginConfig.AnrPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    webViewPlugin = (DefaultPluginConfig)new DefaultPluginConfig.WebViewPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    httpPlugin = (DefaultPluginConfig)new DefaultPluginConfig.HttpPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    jsErrorPlugin = (DefaultPluginConfig)new DefaultPluginConfig.JsErrorPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    userBreadCrumbPlugin = (DefaultPluginConfig)new DefaultPluginConfig.BreadCrumbPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    statisticsPlugin = (DefaultPluginConfig)new DefaultPluginConfig.StatisticsPlugin(0, 0, 0, 0, 0.0F, 0, null, null, 255, null);
    modeAll$delegate = LazyKt.lazy((Function0)PluginCombination.Companion.modeAll.2.INSTANCE);
    modeStable$delegate = LazyKt.lazy((Function0)PluginCombination.Companion.modeStable.2.INSTANCE);
    stablePlugins = CollectionsKt.listOf(new DefaultPluginConfig[] { loopStackPlugin, resourcePlugin, dropFramePlugin, userBreadCrumbPlugin });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.PluginCombination
 * JD-Core Version:    0.7.0.1
 */