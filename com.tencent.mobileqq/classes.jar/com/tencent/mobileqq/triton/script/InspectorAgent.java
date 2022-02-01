package com.tencent.mobileqq.triton.script;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "", "destroy", "", "sendMessageToDebugger", "message", "", "setOnDebuggerMessageListener", "listener", "Lcom/tencent/mobileqq/triton/script/InspectorAgent$DebuggerMessageListener;", "DebuggerMessageListener", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface InspectorAgent
{
  public abstract void destroy();
  
  public abstract void sendMessageToDebugger(@NotNull String paramString);
  
  public abstract void setOnDebuggerMessageListener(@Nullable InspectorAgent.DebuggerMessageListener paramDebuggerMessageListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.InspectorAgent
 * JD-Core Version:    0.7.0.1
 */