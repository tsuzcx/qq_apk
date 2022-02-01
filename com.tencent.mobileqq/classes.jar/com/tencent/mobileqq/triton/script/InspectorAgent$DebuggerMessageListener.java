package com.tencent.mobileqq.triton.script;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/script/InspectorAgent$DebuggerMessageListener;", "", "sendMessageToEngine", "", "message", "", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface InspectorAgent$DebuggerMessageListener
{
  public abstract void sendMessageToEngine(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.InspectorAgent.DebuggerMessageListener
 * JD-Core Version:    0.7.0.1
 */