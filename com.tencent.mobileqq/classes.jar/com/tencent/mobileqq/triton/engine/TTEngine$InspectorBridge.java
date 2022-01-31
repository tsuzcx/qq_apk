package com.tencent.mobileqq.triton.engine;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;
import com.tencent.mobileqq.triton.sdk.bridge.IInspectorAgent;

@TTNativeModule(name="InspectorBridge")
public final class TTEngine$InspectorBridge
{
  private final IInspectorAgent mProxy;
  private final long nativeInstance;
  
  private TTEngine$InspectorBridge(IInspectorAgent paramIInspectorAgent)
  {
    this.mProxy = paramIInspectorAgent;
    this.nativeInstance = nativeCreate();
    this.mProxy.setOnDebuggerMessageListener(new TTEngine.InspectorBridge.1(this));
  }
  
  private native long nativeCreate();
  
  @TTNativeCall
  private void sendMessageToDebugger(@NonNull String paramString)
  {
    try
    {
      this.mProxy.sendMessageToDebugger(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      TTLog.e("TTEngine", "sendMessageToDebugger", paramString);
    }
  }
  
  private static native void sendMessageToEngine(long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTEngine.InspectorBridge
 * JD-Core Version:    0.7.0.1
 */