package com.tencent.mobileqq.guild.api;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ILaunchGuildChatPieApi
  extends QRouteApi
{
  public abstract ChatMessage createWelcomeMsg(AppRuntime paramAppRuntime, IGProChannelInfo paramIGProChannelInfo);
  
  public abstract Intent getGuildChatPieIntent(Context paramContext, LaunchGuildChatPieParam paramLaunchGuildChatPieParam);
  
  public abstract void launchAudioChatPie(Context paramContext, IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean);
  
  public abstract void launchGuildChatPie(@NonNull Context paramContext, @NonNull LaunchGuildChatPieParam paramLaunchGuildChatPieParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi
 * JD-Core Version:    0.7.0.1
 */