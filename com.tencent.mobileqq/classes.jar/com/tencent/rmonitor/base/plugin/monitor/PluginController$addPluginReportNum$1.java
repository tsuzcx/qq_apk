package com.tencent.rmonitor.base.plugin.monitor;

import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig;", "invoke"}, k=3, mv={1, 1, 15})
final class PluginController$addPluginReportNum$1
  extends Lambda
  implements Function1<DefaultPluginConfig, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  PluginController$addPluginReportNum$1()
  {
    super(1);
  }
  
  public final void invoke(@NotNull DefaultPluginConfig paramDefaultPluginConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDefaultPluginConfig, "it");
    paramDefaultPluginConfig.e += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.monitor.PluginController.addPluginReportNum.1
 * JD-Core Version:    0.7.0.1
 */