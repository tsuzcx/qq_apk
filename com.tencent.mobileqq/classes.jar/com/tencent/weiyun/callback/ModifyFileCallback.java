package com.tencent.weiyun.callback;

public abstract class ModifyFileCallback
  extends WeiyunCallback
{
  public abstract void onError(int paramInt, String paramString);
  
  protected void onNativeCallback(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 0)
    {
      onSuccess();
      return;
    }
    onError(paramInt2, paramString);
  }
  
  public abstract void onSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.callback.ModifyFileCallback
 * JD-Core Version:    0.7.0.1
 */