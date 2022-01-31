package com.tencent.mobileqq.triton.api.http;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import com.tencent.mobileqq.triton.sdk.ITHttp;

@TTNativeModule(name="NativeHttp")
public class NativeHttp
  implements ITHttp
{
  static final String NAME = "NativeHttp";
  private static final String TAG = "NativeHttp";
  private TTEngine mTritonEngine;
  
  public NativeHttp(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  private static native void nativeHttpCallBack(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  public void httpCallBack(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.mTritonEngine.isGLThread())
    {
      nativeHttpCallBack(paramLong, paramInt, paramArrayOfByte);
      return;
    }
    this.mTritonEngine.postRunnable(new NativeHttp.1(this, paramLong, paramInt, paramArrayOfByte));
  }
  
  @TTNativeCall
  public void httpRequestForImage(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, boolean paramBoolean)
  {
    this.mTritonEngine.getApiProxy().httpRequestForImage(paramLong, paramString1, paramString2, paramString3, paramString4, paramString5, paramArrayOfString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.api.http.NativeHttp
 * JD-Core Version:    0.7.0.1
 */