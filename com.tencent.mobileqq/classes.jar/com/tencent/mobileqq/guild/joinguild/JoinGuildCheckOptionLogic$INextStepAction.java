package com.tencent.mobileqq.guild.joinguild;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewModel.JoinChannelParams;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

public abstract interface JoinGuildCheckOptionLogic$INextStepAction
{
  public abstract void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, IGProSecurityResult paramIGProSecurityResult, JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, String paramString2, Bundle paramBundle);
  
  public abstract void a(JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, String paramString, Bundle paramBundle, IResultWithSecurityCallback paramIResultWithSecurityCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.joinguild.JoinGuildCheckOptionLogic.INextStepAction
 * JD-Core Version:    0.7.0.1
 */