package com.tencent.mobileqq.triton.internal.script;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime$Companion;", "", "()V", "NATIVE_BUFFERS", "", "TAG", "nativeCallback2Script", "", "nativeHandle", "", "callbackId", "", "functionName", "params", "nativeEvaluateScript", "content", "nativeLoadScriptWithCodeCache", "scriptPath", "scriptContent", "scriptName", "codeCacheAbsolutePath", "timeCost", "", "outException", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[J[Ljava/lang/String;)I", "nativeSubscribe2Script", "eventName", "Triton_release"}, k=1, mv={1, 1, 16})
public final class ScriptRuntime$Companion
{
  @JvmStatic
  private final void nativeCallback2Script(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    ScriptRuntime.access$nativeCallback2Script(paramLong, paramInt, paramString1, paramString2);
  }
  
  @JvmStatic
  private final void nativeEvaluateScript(long paramLong, String paramString)
  {
    ScriptRuntime.access$nativeEvaluateScript(paramLong, paramString);
  }
  
  @JvmStatic
  private final int nativeLoadScriptWithCodeCache(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, long[] paramArrayOfLong, String[] paramArrayOfString)
  {
    return ScriptRuntime.access$nativeLoadScriptWithCodeCache(paramLong, paramString1, paramString2, paramString3, paramString4, paramArrayOfLong, paramArrayOfString);
  }
  
  @JvmStatic
  private final void nativeSubscribe2Script(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    ScriptRuntime.access$nativeSubscribe2Script(paramLong, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.ScriptRuntime.Companion
 * JD-Core Version:    0.7.0.1
 */