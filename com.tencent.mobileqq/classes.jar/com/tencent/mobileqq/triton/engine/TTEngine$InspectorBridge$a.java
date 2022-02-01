package com.tencent.mobileqq.triton.engine;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.sdk.bridge.InspectorAgent.DebuggerMessageListener;

class TTEngine$InspectorBridge$a
  implements InspectorAgent.DebuggerMessageListener
{
  TTEngine$InspectorBridge$a(TTEngine.InspectorBridge paramInspectorBridge) {}
  
  public void sendMessageToEngine(@NonNull String paramString)
  {
    TTEngine.InspectorBridge.a(TTEngine.InspectorBridge.a(this.a), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTEngine.InspectorBridge.a
 * JD-Core Version:    0.7.0.1
 */