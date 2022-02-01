package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.internal.script.InspectorBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/TTAppAgent$Companion;", "", "()V", "WHAT_JANK_CANARY", "", "WHAT_SCRIPT_MANAGER", "nativeCreate", "", "inspectorBridge", "Lcom/tencent/mobileqq/triton/internal/script/InspectorBridge;", "nativeGetInstance", "nativeInstance", "what", "Triton_release"}, k=1, mv={1, 1, 16})
public final class TTAppAgent$Companion
{
  @JvmStatic
  private final long nativeCreate(InspectorBridge paramInspectorBridge)
  {
    return TTAppAgent.access$nativeCreate(paramInspectorBridge);
  }
  
  @JvmStatic
  public final long nativeGetInstance(long paramLong, int paramInt)
  {
    return TTAppAgent.nativeGetInstance(paramLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.TTAppAgent.Companion
 * JD-Core Version:    0.7.0.1
 */