package com.tencent.qapmsdk.base.reporter.uploaddata.runnable;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/qapmsdk/common/util/AsyncSPEditor;", "it", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "invoke"}, k=3, mv={1, 1, 15})
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
    return localAsyncSPEditor.putInt(localStringBuilder.toString(), paramDefaultPluginConfig.curReportNum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.CollectRecordDataRunnable.reportDbData.1
 * JD-Core Version:    0.7.0.1
 */