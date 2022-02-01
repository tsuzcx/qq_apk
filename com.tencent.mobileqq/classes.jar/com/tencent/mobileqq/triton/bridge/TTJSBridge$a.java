package com.tencent.mobileqq.triton.bridge;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.jni.c;

class TTJSBridge$a
  implements Runnable
{
  TTJSBridge$a(TTJSBridge paramTTJSBridge, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    TTJSBridge localTTJSBridge = this.e;
    c.a(localTTJSBridge, TTJSBridge.a(localTTJSBridge).k(), this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.TTJSBridge.a
 * JD-Core Version:    0.7.0.1
 */