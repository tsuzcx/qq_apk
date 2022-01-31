package com.tencent.qg.sdk.doraemon;

public abstract class DoraemonApiWrapper
{
  protected boolean mHasInit;
  
  public native void attachNative();
  
  public abstract void call(String paramString1, String paramString2, long paramLong);
  
  public void init()
  {
    if (!this.mHasInit) {
      attachNative();
    }
    this.mHasInit = true;
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.doraemon.DoraemonApiWrapper
 * JD-Core Version:    0.7.0.1
 */