package com.tencent.qapmsdk.base.monitorplugin;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "invoke"}, k=3, mv={1, 1, 15})
final class PluginController$resetReportNum$1
  extends Lambda
  implements Function1<DefaultPluginConfig, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  PluginController$resetReportNum$1()
  {
    super(1);
  }
  
  public final void invoke(@NotNull DefaultPluginConfig paramDefaultPluginConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDefaultPluginConfig, "it");
    BaseInfo.editor.putInt("count_plugin_" + String.valueOf(paramDefaultPluginConfig.plugin), 0);
    paramDefaultPluginConfig.curReportNum = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.monitorplugin.PluginController.resetReportNum.1
 * JD-Core Version:    0.7.0.1
 */