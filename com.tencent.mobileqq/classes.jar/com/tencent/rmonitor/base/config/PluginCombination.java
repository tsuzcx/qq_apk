package com.tencent.rmonitor.base.config;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/config/PluginCombination;", "", "()V", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class PluginCombination
{
  public static final PluginCombination.Companion a = new PluginCombination.Companion(null);
  private static final DefaultPluginConfig b = (DefaultPluginConfig)new DefaultPluginConfig.DropFramePlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig c = (DefaultPluginConfig)new DefaultPluginConfig.LoopStackPlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig d = (DefaultPluginConfig)new DefaultPluginConfig.DBPlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig e = (DefaultPluginConfig)new DefaultPluginConfig.IOPlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig f = (DefaultPluginConfig)new DefaultPluginConfig.LeakPlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig g = (DefaultPluginConfig)new DefaultPluginConfig.CeilingHprofPlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig h = (DefaultPluginConfig)new DefaultPluginConfig.CeilingValuePlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig i = (DefaultPluginConfig)new DefaultPluginConfig.DevicePlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig j = (DefaultPluginConfig)new DefaultPluginConfig.ResourcePlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig k = (DefaultPluginConfig)new DefaultPluginConfig.StatisticsPlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig l = (DefaultPluginConfig)new DefaultPluginConfig.FdLeakPlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig m = (DefaultPluginConfig)new DefaultPluginConfig.NatMemPlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig n = (DefaultPluginConfig)new DefaultPluginConfig.BigBitmapPlugin(0, 0, null, null, 15, null);
  private static final DefaultPluginConfig o = (DefaultPluginConfig)new DefaultPluginConfig.QQBatteryPlugin(0, 0, null, null, 15, null);
  @NotNull
  private static final List<DefaultPluginConfig> p = CollectionsKt.listOf(new DefaultPluginConfig[] { e, d, i, b, c, f, h, j, l, m, n, o, k, g });
  @NotNull
  private static final Lazy q = LazyKt.lazy((Function0)PluginCombination.Companion.modeAll.2.INSTANCE);
  @NotNull
  private static final Lazy r = LazyKt.lazy((Function0)PluginCombination.Companion.modeStable.2.INSTANCE);
  private static final List<DefaultPluginConfig> s = CollectionsKt.listOf(new DefaultPluginConfig[] { c, j, b });
  private static final List<DefaultPluginConfig> t = CollectionsKt.listOf(new DefaultPluginConfig[] { b, d, e, f, g, h, i, k, l, m, n, o });
  @NotNull
  private static final List<DefaultPluginConfig> u = CollectionsKt.listOf(new DefaultPluginConfig[] { c, j });
  
  @JvmStatic
  @Nullable
  public static final DefaultPluginConfig a(int paramInt)
  {
    return a.c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.PluginCombination
 * JD-Core Version:    0.7.0.1
 */