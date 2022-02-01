package com.tencent.mobileqq.qqguildsdk.callback;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;

public abstract interface IGetUserInfoCallback
{
  public abstract void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback
 * JD-Core Version:    0.7.0.1
 */