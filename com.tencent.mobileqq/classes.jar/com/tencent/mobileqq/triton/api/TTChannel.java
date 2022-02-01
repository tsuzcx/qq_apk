package com.tencent.mobileqq.triton.api;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.sdk.IQQEnv;

public class TTChannel
{
  private final TTEngine a;
  
  public TTChannel(TTEngine paramTTEngine)
  {
    this.a = paramTTEngine;
  }
  
  @TTNativeCall
  public int g_blackScreenDetectInterval()
  {
    return this.a.l().blackScreenDetectInterval();
  }
  
  @TTNativeCall
  public boolean g_errorDialogEnable()
  {
    return this.a.l().gameErrorDialogEnable();
  }
  
  @TTNativeCall
  public int g_frameNoChangeLimit()
  {
    return this.a.l().frameNoChangeLimit();
  }
  
  @TTNativeCall
  public int g_jsErrorDetectInterval()
  {
    return this.a.l().jsErrorDetectInterval();
  }
  
  @TTNativeCall
  public int g_noPresentDurationLimit()
  {
    return this.a.l().noPresentDurationLimit();
  }
  
  @TTNativeCall
  public int g_noPresentTouchLimit()
  {
    return this.a.l().noPresentTouchLimit();
  }
  
  @TTNativeCall
  public void g_onErrorDialog()
  {
    this.a.l().showGameErrorDialog(this.a.b(), new TTChannel.a(this));
  }
  
  @TTNativeCall
  public int g_presentDetectInterval()
  {
    return this.a.l().presentDetectInterval();
  }
  
  @TTNativeCall
  public void handleJavaScriptException(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      this.a.l().reportDC04266(23, new String(paramArrayOfByte));
    }
  }
  
  public native void nativeCancelErrorDialog(long paramLong);
  
  public native void nativeConfirmErrorDialog();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.api.TTChannel
 * JD-Core Version:    0.7.0.1
 */