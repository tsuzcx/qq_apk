package com.tencent.mobileqq.triton.internal.script;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/triton/script/ScriptData;", "invoke"}, k=3, mv={1, 1, 16})
final class ScriptRuntime$ScriptArgumentImpl$params$2
  extends Lambda
  implements Function0<JSONObject>
{
  ScriptRuntime$ScriptArgumentImpl$params$2(String paramString)
  {
    super(0);
  }
  
  @NotNull
  public final JSONObject invoke()
  {
    return new JSONObject(this.$paramStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.ScriptRuntime.ScriptArgumentImpl.params.2
 * JD-Core Version:    0.7.0.1
 */