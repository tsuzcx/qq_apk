package com.tencent.rmonitor.base.plugin.monitor;

import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig;", "invoke"}, k=3, mv={1, 1, 15})
final class PluginController$canCollect$3
  extends Lambda
  implements Function1<DefaultPluginConfig, Boolean>
{
  public static final 3 INSTANCE = new 3();
  
  PluginController$canCollect$3()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull DefaultPluginConfig paramDefaultPluginConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDefaultPluginConfig, "it");
    return paramDefaultPluginConfig.e < paramDefaultPluginConfig.f.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.monitor.PluginController.canCollect.3
 * JD-Core Version:    0.7.0.1
 */