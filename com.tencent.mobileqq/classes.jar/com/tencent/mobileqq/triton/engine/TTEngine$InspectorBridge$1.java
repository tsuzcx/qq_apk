package com.tencent.mobileqq.triton.engine;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.sdk.bridge.IInspectorAgent.IDebuggerMessageListener;

class TTEngine$InspectorBridge$1
  implements IInspectorAgent.IDebuggerMessageListener
{
  TTEngine$InspectorBridge$1(TTEngine.InspectorBridge paramInspectorBridge) {}
  
  public void sendMessageToEngine(@NonNull String paramString)
  {
    TTEngine.InspectorBridge.access$200(TTEngine.InspectorBridge.access$100(this.this$0), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTEngine.InspectorBridge.1
 * JD-Core Version:    0.7.0.1
 */