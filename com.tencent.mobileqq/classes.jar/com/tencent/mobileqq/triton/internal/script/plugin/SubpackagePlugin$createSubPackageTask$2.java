package com.tencent.mobileqq.triton.internal.script.plugin;

import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "invoke"}, k=3, mv={1, 1, 16})
final class SubpackagePlugin$createSubPackageTask$2
  extends Lambda
  implements Function1<ScriptLoadStatistic, Unit>
{
  SubpackagePlugin$createSubPackageTask$2(String paramString, int paramInt, Argument paramArgument)
  {
    super(1);
  }
  
  public final void invoke(@NotNull ScriptLoadStatistic paramScriptLoadStatistic)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptLoadStatistic, "it");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadSubpackage name:");
    ((StringBuilder)localObject).append(this.$name);
    ((StringBuilder)localObject).append(" result:");
    ((StringBuilder)localObject).append(paramScriptLoadStatistic.getLoadResult());
    Logger.i$default("SubpackagePlugin", ((StringBuilder)localObject).toString(), null, 4, null);
    if ((!paramScriptLoadStatistic.getLoadResult().isSuccess()) && (paramScriptLoadStatistic.getLoadResult() == ScriptLoadResult.FAIL_COMPILE))
    {
      paramScriptLoadStatistic = new StringBuilder();
      paramScriptLoadStatistic.append("retry loadSubpackage name:");
      paramScriptLoadStatistic.append(this.$name);
      paramScriptLoadStatistic.append(" for js compile fail");
      Logger.w$default("SubpackagePlugin", paramScriptLoadStatistic.toString(), null, 4, null);
      return;
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("taskId", this.$taskId);
    if (paramScriptLoadStatistic.getLoadResult().isSuccess()) {
      paramScriptLoadStatistic = "success";
    } else {
      paramScriptLoadStatistic = "fail";
    }
    ((JSONObject)localObject).put("state", paramScriptLoadStatistic);
    this.$arguments.subscribe("onLoadSubPackageTaskStateChange", ((JSONObject)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.plugin.SubpackagePlugin.createSubPackageTask.2
 * JD-Core Version:    0.7.0.1
 */