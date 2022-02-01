package com.tencent.mobileqq.triton.engine;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.sdk.bridge.InspectorAgent;

public final class TTEngine$InspectorBridge
{
  String a = "InspectorBridge";
  private InspectorAgent b;
  @TTNativeCall
  private final long nativeInstance = nativeCreate();
  
  private native long nativeCreate();
  
  @TTNativeCall
  private void sendMessageToDebugger(@NonNull String paramString)
  {
    try
    {
      this.b.sendMessageToDebugger(paramString);
      return;
    }
    finally
    {
      TTLog.b(this.a, "sendMessageToDebugger", paramString);
    }
  }
  
  private static native void sendMessageToEngine(long paramLong, String paramString);
  
  public void a(@NonNull InspectorAgent paramInspectorAgent)
  {
    this.b = paramInspectorAgent;
    this.b.setOnDebuggerMessageListener(new TTEngine.InspectorBridge.a(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTEngine.InspectorBridge
 * JD-Core Version:    0.7.0.1
 */