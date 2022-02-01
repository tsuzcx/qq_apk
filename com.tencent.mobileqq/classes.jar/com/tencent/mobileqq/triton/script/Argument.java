package com.tencent.mobileqq.triton.script;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/script/Argument;", "", "callbackId", "", "getCallbackId", "()I", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "getContextType", "()Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "params", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/triton/script/ScriptData;", "getParams", "()Lorg/json/JSONObject;", "rawParams", "", "getRawParams", "()Ljava/lang/String;", "task", "Lcom/tencent/mobileqq/triton/script/ScriptTask;", "getTask", "()Lcom/tencent/mobileqq/triton/script/ScriptTask;", "callback", "", "result", "createBuffer", "buffer", "", "offset", "", "length", "getBuffer", "bufferId", "subscribe", "eventName", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface Argument
{
  public abstract boolean callback(@Nullable String paramString);
  
  public abstract int createBuffer(@NotNull byte[] paramArrayOfByte, long paramLong1, long paramLong2);
  
  @Nullable
  public abstract byte[] getBuffer(int paramInt);
  
  public abstract int getCallbackId();
  
  @NotNull
  public abstract ScriptContextType getContextType();
  
  @NotNull
  public abstract JSONObject getParams();
  
  @NotNull
  public abstract String getRawParams();
  
  @Nullable
  public abstract ScriptTask getTask();
  
  public abstract boolean subscribe(@NotNull String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.Argument
 * JD-Core Version:    0.7.0.1
 */