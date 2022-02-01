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
    Logger.i$default("SubpackagePlugin", "loadSubpackage name:" + this.$name + " result:" + paramScriptLoadStatistic.getLoadResult(), null, 4, null);
    if ((!paramScriptLoadStatistic.getLoadResult().isSuccess()) && (paramScriptLoadStatistic.getLoadResult() == ScriptLoadResult.FAIL_COMPILE))
    {
      Logger.w$default("SubpackagePlugin", "retry loadSubpackage name:" + this.$name + " for js compile fail", null, 4, null);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("taskId", this.$taskId);
    if (paramScriptLoadStatistic.getLoadResult().isSuccess()) {}
    for (paramScriptLoadStatistic = "success";; paramScriptLoadStatistic = "fail")
    {
      localJSONObject.put("state", paramScriptLoadStatistic);
      this.$arguments.subscribe("onLoadSubPackageTaskStateChange", localJSONObject.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.plugin.SubpackagePlugin.createSubPackageTask.2
 * JD-Core Version:    0.7.0.1
 */