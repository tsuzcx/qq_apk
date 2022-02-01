package com.tencent.mobileqq.qqguildsdk.callback;

import com.tencent.mobileqq.qqguildsdk.data.IGProResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import java.util.List;

public abstract interface IKickChannelMemberCallback
{
  public abstract void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult, List<IGProResultInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.callback.IKickChannelMemberCallback
 * JD-Core Version:    0.7.0.1
 */