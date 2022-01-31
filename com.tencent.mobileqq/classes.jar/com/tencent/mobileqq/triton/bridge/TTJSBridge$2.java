package com.tencent.mobileqq.triton.bridge;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.jni.JNICaller.TTJSBridge;

class TTJSBridge$2
  implements Runnable
{
  TTJSBridge$2(TTJSBridge paramTTJSBridge, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    JNICaller.TTJSBridge.nativeEvaluateSubscribeJs(this.this$0, TTJSBridge.access$000(this.this$0).getNativeTTAppHandle(), this.val$contextType, this.val$functionName, this.val$eventName, this.val$data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.TTJSBridge.2
 * JD-Core Version:    0.7.0.1
 */