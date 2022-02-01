package com.tencent.rmonitor.base.reporter.batch;

import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.util.AsyncSPEditor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/rmonitor/common/util/AsyncSPEditor;", "it", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig;", "invoke"}, k=3, mv={1, 1, 15})
final class CollectRecordDataRunnable$reportDbData$1
  extends Lambda
  implements Function1<DefaultPluginConfig, AsyncSPEditor>
{
  public static final 1 INSTANCE = new 1();
  
  CollectRecordDataRunnable$reportDbData$1()
  {
    super(1);
  }
  
  @NotNull
  public final AsyncSPEditor invoke(@NotNull DefaultPluginConfig paramDefaultPluginConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDefaultPluginConfig, "it");
    AsyncSPEditor localAsyncSPEditor = BaseInfo.editor;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count_plugin_");
    localStringBuilder.append(paramDefaultPluginConfig.toString());
    return localAsyncSPEditor.a(localStringBuilder.toString(), paramDefaultPluginConfig.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.batch.CollectRecordDataRunnable.reportDbData.1
 * JD-Core Version:    0.7.0.1
 */