package com.tencent.mobileqq.triton.bridge;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.jni.JNICaller.TTJSBridge;

class TTJSBridge$3
  implements Runnable
{
  TTJSBridge$3(TTJSBridge paramTTJSBridge, int paramInt, String paramString) {}
  
  public void run()
  {
    JNICaller.TTJSBridge.nativeEvaluateJs(this.this$0, TTJSBridge.access$000(this.this$0).getNativeTTAppHandle(), this.val$contextType, this.val$js);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.TTJSBridge.3
 * JD-Core Version:    0.7.0.1
 */