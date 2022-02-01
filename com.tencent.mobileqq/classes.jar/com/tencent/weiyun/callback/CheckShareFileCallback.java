package com.tencent.weiyun.callback;

import com.tencent.weiyun.data.CBundleReader;

public abstract class CheckShareFileCallback
  extends WeiyunCallback
{
  public abstract void onError(int paramInt, String paramString);
  
  protected void onNativeCallback(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 0)
    {
      if (paramLong == 0L)
      {
        onSuccess("");
        return;
      }
      paramString = CBundleReader.getString(paramLong, "share_url");
      CBundleReader.deleteBundle(paramLong);
      onSuccess(paramString);
      return;
    }
    onError(paramInt2, paramString);
  }
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.callback.CheckShareFileCallback
 * JD-Core Version:    0.7.0.1
 */