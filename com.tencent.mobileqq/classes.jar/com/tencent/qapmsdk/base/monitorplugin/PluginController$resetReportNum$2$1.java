package com.tencent.qapmsdk.base.monitorplugin;

import android.content.SharedPreferences;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "invoke"}, k=3, mv={1, 1, 15})
final class PluginController$resetReportNum$2$1
  extends Lambda
  implements Function1<DefaultPluginConfig, Unit>
{
  PluginController$resetReportNum$2$1(SharedPreferences paramSharedPreferences)
  {
    super(1);
  }
  
  public final void invoke(@NotNull DefaultPluginConfig paramDefaultPluginConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDefaultPluginConfig, "it");
    paramDefaultPluginConfig.curReportNum = this.$sp.getInt("count_plugin_" + paramDefaultPluginConfig.toString(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.monitorplugin.PluginController.resetReportNum.2.1
 * JD-Core Version:    0.7.0.1
 */