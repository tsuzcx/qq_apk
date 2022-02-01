package com.tencent.tissue.v8rt.engine;

import com.tencent.tissue.v8rt.anno.CallByNative;
import com.tencent.tissue.v8rt.anno.NotNull;

public final class Engine$InspectorBridge
{
  @CallByNative
  private final boolean isWaitForDebugger;
  private final IInspectorAgent mProxy;
  @CallByNative
  private final long nativeInstance;
  
  private Engine$InspectorBridge(IInspectorAgent paramIInspectorAgent)
  {
    this.mProxy = paramIInspectorAgent;
    this.nativeInstance = nativeCreate();
    this.isWaitForDebugger = paramIInspectorAgent.isWaitForDebugger();
    this.mProxy.setOnDebuggerMessageListener(new Engine.InspectorBridge.1(this));
  }
  
  private native long nativeCreate();
  
  private void sendMessageToDebugger(@NotNull String paramString)
  {
    try
    {
      this.mProxy.sendMessageToDebugger(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.e("TV8ENG", "sendMessageToDebugger", paramString);
    }
  }
  
  private static native void sendMessageToEngine(long paramLong, String paramString);
  
  public IInspectorAgent getInspectorAgent()
  {
    return this.mProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.Engine.InspectorBridge
 * JD-Core Version:    0.7.0.1
 */