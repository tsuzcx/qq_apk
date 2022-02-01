package com.tencent.qapmsdk.base.monitorplugin;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "invoke"}, k=3, mv={1, 1, 15})
final class PluginController$whetherPluginSampling$familySampleRatio$1
  extends Lambda
  implements Function1<DefaultPluginConfig, Float>
{
  PluginController$whetherPluginSampling$familySampleRatio$1(int paramInt)
  {
    super(1);
  }
  
  public final float invoke(@NotNull DefaultPluginConfig paramDefaultPluginConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDefaultPluginConfig, "it");
    Logger.INSTANCE.d(new String[] { "QAPM_base", "whetherPluginSampling" + this.$plugin + " , canCollect " + paramDefaultPluginConfig.eventSampleRatio });
    return paramDefaultPluginConfig.eventSampleRatio;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.monitorplugin.PluginController.whetherPluginSampling.familySampleRatio.1
 * JD-Core Version:    0.7.0.1
 */