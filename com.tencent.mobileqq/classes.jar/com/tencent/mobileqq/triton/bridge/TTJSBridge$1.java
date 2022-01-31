package com.tencent.mobileqq.triton.bridge;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.jni.JNICaller.TTJSBridge;

class TTJSBridge$1
  implements Runnable
{
  TTJSBridge$1(TTJSBridge paramTTJSBridge, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    JNICaller.TTJSBridge.nativeEvaluateCallbackJs(this.this$0, TTJSBridge.access$000(this.this$0).getNativeTTAppHandle(), this.val$contextType, this.val$functionName, this.val$finalCallbackId, this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.TTJSBridge.1
 * JD-Core Version:    0.7.0.1
 */