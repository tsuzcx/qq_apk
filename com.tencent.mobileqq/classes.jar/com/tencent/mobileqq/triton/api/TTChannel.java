package com.tencent.mobileqq.triton.api;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import com.tencent.mobileqq.triton.sdk.IQQEnv;

@TTNativeModule(name="TTChannel")
public class TTChannel
{
  static final String NAME = "TTChannel";
  private APIProxy apiProxy;
  private TTEngine mTritonEngine;
  
  public TTChannel(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  @TTNativeCall
  public int g_blackScreenDetectInterval()
  {
    return this.mTritonEngine.getQQEnv().blackScreenDetectInterval();
  }
  
  @TTNativeCall
  public boolean g_errorDialogEnable()
  {
    return this.mTritonEngine.getQQEnv().gameErrorDialogEnable();
  }
  
  @TTNativeCall
  public int g_frameNoChangeLimit()
  {
    return this.mTritonEngine.getQQEnv().frameNoChangeLimit();
  }
  
  @TTNativeCall
  public int g_jsErrorDetectInterval()
  {
    return this.mTritonEngine.getQQEnv().jsErrorDetectInterval();
  }
  
  @TTNativeCall
  public int g_noPresentDurationLimit()
  {
    return this.mTritonEngine.getQQEnv().noPresentDurationLimit();
  }
  
  @TTNativeCall
  public int g_noPresentTouchLimit()
  {
    return this.mTritonEngine.getQQEnv().noPresentTouchLimit();
  }
  
  @TTNativeCall
  public void g_onErrorDialog()
  {
    this.mTritonEngine.getQQEnv().showGameErrorDialog(this.mTritonEngine.getAttachedActivity(), new TTChannel.1(this));
  }
  
  @TTNativeCall
  public int g_presentDetectInterval()
  {
    return this.mTritonEngine.getQQEnv().presentDetectInterval();
  }
  
  public APIProxy getApiProxy()
  {
    return this.apiProxy;
  }
  
  @TTNativeCall
  public void handleJavaScriptException(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      this.mTritonEngine.getQQEnv().reportDC04266(23, new String(paramArrayOfByte));
    }
  }
  
  public native void nativeAuthDialogCallback(long paramLong, int paramInt, String paramString);
  
  public native void nativeCancelErrorDialog(long paramLong);
  
  public native void nativeConfirmErrorDialog();
  
  public void setApiProxy(APIProxy paramAPIProxy)
  {
    this.apiProxy = paramAPIProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.api.TTChannel
 * JD-Core Version:    0.7.0.1
 */