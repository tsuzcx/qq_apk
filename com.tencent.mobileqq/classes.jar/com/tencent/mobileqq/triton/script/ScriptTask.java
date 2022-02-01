package com.tencent.mobileqq.triton.script;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/script/ScriptTask;", "", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "getContextType", "()Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "associate", "", "obj", "callMethod", "", "methodName", "", "arguments", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/triton/script/ScriptData;", "destroy", "getAssociation", "T", "()Ljava/lang/Object;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface ScriptTask
{
  public abstract void associate(@NotNull Object paramObject);
  
  public abstract boolean callMethod(@NotNull String paramString, @Nullable JSONObject paramJSONObject);
  
  public abstract void destroy();
  
  public abstract <T> T getAssociation();
  
  @NotNull
  public abstract ScriptContextType getContextType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.ScriptTask
 * JD-Core Version:    0.7.0.1
 */