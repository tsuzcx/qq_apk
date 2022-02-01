package com.tencent.mobileqq.qqguildsdk.callback;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;

public abstract interface IGetUserListCallback
{
  public abstract void onGetUserList(String paramString1, int paramInt, String paramString2, Object paramObject, List<IGProUserInfo> paramList1, List<IGProUserInfo> paramList2, List<IGProUserInfo> paramList3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback
 * JD-Core Version:    0.7.0.1
 */