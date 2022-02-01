package com.tencent.mobileqq.triton.internal.script;

import com.tencent.mobileqq.triton.script.InspectorAgent.DebuggerMessageListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/internal/script/InspectorBridge$debugMessageListener$1", "Lcom/tencent/mobileqq/triton/script/InspectorAgent$DebuggerMessageListener;", "real", "getReal", "()Lcom/tencent/mobileqq/triton/script/InspectorAgent$DebuggerMessageListener;", "setReal", "(Lcom/tencent/mobileqq/triton/script/InspectorAgent$DebuggerMessageListener;)V", "sendMessageToEngine", "", "message", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class InspectorBridge$debugMessageListener$1
  implements InspectorAgent.DebuggerMessageListener
{
  @Nullable
  private InspectorAgent.DebuggerMessageListener real = (InspectorAgent.DebuggerMessageListener)new InspectorBridge.debugMessageListener.1.real.1(this);
  
  @Nullable
  public final InspectorAgent.DebuggerMessageListener getReal()
  {
    return this.real;
  }
  
  public void sendMessageToEngine(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    InspectorAgent.DebuggerMessageListener localDebuggerMessageListener = this.real;
    if (localDebuggerMessageListener != null) {
      localDebuggerMessageListener.sendMessageToEngine(paramString);
    }
  }
  
  public final void setReal(@Nullable InspectorAgent.DebuggerMessageListener paramDebuggerMessageListener)
  {
    this.real = paramDebuggerMessageListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.InspectorBridge.debugMessageListener.1
 * JD-Core Version:    0.7.0.1
 */