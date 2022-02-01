package com.tencent.mobileqq.qqguildsdk.callback;

import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGuildJoinInfo;

public abstract interface IFetchGuildInfoByAppIdentityCallback
{
  public abstract void a(int paramInt, String paramString, IGuildJoinInfo paramIGuildJoinInfo, IGProSecurityResult paramIGProSecurityResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoByAppIdentityCallback
 * JD-Core Version:    0.7.0.1
 */