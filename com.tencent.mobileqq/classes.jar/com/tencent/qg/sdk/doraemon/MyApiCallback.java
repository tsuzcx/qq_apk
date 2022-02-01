package com.tencent.qg.sdk.doraemon;

public class MyApiCallback
  implements DoraemonApiWrapper.ApiCallback
{
  private long mEJApiCallbackPtr;
  
  public MyApiCallback(long paramLong)
  {
    this.mEJApiCallbackPtr = paramLong;
  }
  
  private native void nativeOnComplete(long paramLong);
  
  private native void nativeOnFailure(long paramLong, int paramInt, String paramString);
  
  @Deprecated
  private native void nativeOnSuccess(long paramLong, String paramString);
  
  private native void nativeOnSuccessWithBytes(long paramLong, byte[] paramArrayOfByte);
  
  private native void nativeoOnPermission(long paramLong, int paramInt);
  
  private native void nativeonTrigger(long paramLong, String paramString);
  
  public void onComplete()
  {
    nativeOnComplete(this.mEJApiCallbackPtr);
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    nativeOnFailure(this.mEJApiCallbackPtr, paramInt, paramString);
  }
  
  public void onPermission(int paramInt)
  {
    nativeoOnPermission(this.mEJApiCallbackPtr, paramInt);
  }
  
  public void onSuccess(String paramString)
  {
    nativeOnSuccessWithBytes(this.mEJApiCallbackPtr, paramString.getBytes());
  }
  
  public void onTrigger(String paramString)
  {
    nativeonTrigger(this.mEJApiCallbackPtr, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.doraemon.MyApiCallback
 * JD-Core Version:    0.7.0.1
 */