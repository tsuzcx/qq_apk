package com.tencent.mobileqq.triton.sdk.bridge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface IInspectorAgent
{
  public abstract void sendMessageToDebugger(@NonNull String paramString);
  
  public abstract void setOnDebuggerMessageListener(@Nullable IInspectorAgent.IDebuggerMessageListener paramIDebuggerMessageListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.bridge.IInspectorAgent
 * JD-Core Version:    0.7.0.1
 */