package com.tencent.weiyun.callback;

import com.tencent.weiyun.data.UserItem;

public abstract class FetchUserInfoCallback
  extends WeiyunCallback
{
  public abstract void onError(int paramInt1, String paramString, int paramInt2);
  
  protected void onNativeCallback(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 0)
    {
      if (paramLong == 0L) {
        paramString = null;
      } else {
        paramString = UserItem.newInstance(paramLong);
      }
      onSuccess(paramString, paramInt1);
      return;
    }
    onError(paramInt2, paramString, paramInt1);
  }
  
  public abstract void onSuccess(UserItem paramUserItem, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.callback.FetchUserInfoCallback
 * JD-Core Version:    0.7.0.1
 */