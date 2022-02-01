package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.internal.script.InspectorBridge;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import io.github.landerlyoung.jenny.NativeClass;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/TTAppAgent;", "", "inspectorBridge", "Lcom/tencent/mobileqq/triton/internal/script/InspectorBridge;", "scriptSystem", "Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "(Lcom/tencent/mobileqq/triton/internal/script/InspectorBridge;Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;)V", "jankCanaryNativeInstance", "", "nativeInstance", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
@NativeClass(namespace="triton::jni")
public final class TTAppAgent
{
  public static final TTAppAgent.Companion Companion = new TTAppAgent.Companion(null);
  public static final int WHAT_JANK_CANARY = 1;
  public static final int WHAT_SCRIPT_MANAGER = 2;
  private final long jankCanaryNativeInstance;
  private final long nativeInstance;
  
  public TTAppAgent(@NotNull InspectorBridge paramInspectorBridge, @NotNull ScriptSystem paramScriptSystem)
  {
    this.nativeInstance = TTAppAgent.Companion.access$nativeCreate(Companion, paramInspectorBridge);
    if (this.nativeInstance == 0L) {
      throw ((Throwable)new TritonInitException("failed to create TTApp", ErrorCodes.NATIVE_FUNCTION_CALL, null, 4, null));
    }
    this.jankCanaryNativeInstance = Companion.nativeGetInstance(this.nativeInstance, 1);
  }
  
  @JvmStatic
  private static final native long nativeCreate(InspectorBridge paramInspectorBridge);
  
  @JvmStatic
  public static final native long nativeGetInstance(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.TTAppAgent
 * JD-Core Version:    0.7.0.1
 */