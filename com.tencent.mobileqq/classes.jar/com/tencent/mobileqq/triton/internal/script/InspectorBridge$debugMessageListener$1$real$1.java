package com.tencent.mobileqq.triton.internal.script;

import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.script.InspectorAgent.DebuggerMessageListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/internal/script/InspectorBridge$debugMessageListener$1$real$1", "Lcom/tencent/mobileqq/triton/script/InspectorAgent$DebuggerMessageListener;", "sendMessageToEngine", "", "message", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class InspectorBridge$debugMessageListener$1$real$1
  implements InspectorAgent.DebuggerMessageListener
{
  public void sendMessageToEngine(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    if (InspectorBridge.access$getLifeCycleOwner$p(this.this$0.this$0).getEngineState() != EngineState.DESTROYED) {}
    try
    {
      InspectorBridge.Companion.access$sendMessageToEngine(InspectorBridge.Companion, InspectorBridge.access$getNativeInstance$p(this.this$0.this$0), paramString);
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label49:
      break label49;
    }
    InspectorBridge.Companion.access$sendMessageToEngine(InspectorBridge.Companion, InspectorBridge.access$getNativeInstance$p(this.this$0.this$0), paramString);
    paramString = Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.InspectorBridge.debugMessageListener.1.real.1
 * JD-Core Version:    0.7.0.1
 */