package com.tencent.tissue.v8rt.engine;

import com.tencent.tissue.v8rt.anno.NotNull;
import com.tencent.tissue.v8rt.anno.Nullable;

public abstract interface IInspectorAgent
{
  public abstract boolean isWaitForDebugger();
  
  public abstract void sendMessageToDebugger(@NotNull String paramString);
  
  public abstract void setOnDebuggerMessageListener(@Nullable IInspectorAgent.IDebuggerMessageListener paramIDebuggerMessageListener);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.IInspectorAgent
 * JD-Core Version:    0.7.0.1
 */