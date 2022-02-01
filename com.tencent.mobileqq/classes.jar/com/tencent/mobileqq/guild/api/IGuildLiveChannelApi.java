package com.tencent.mobileqq.guild.api;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildLiveChannelApi
  extends QRouteApi
{
  public abstract boolean checkGuildLiveAvBusinessFocus(String paramString);
  
  public abstract int checkGuildLiveState();
  
  public abstract void cleanLiveChannelAIOBg(ViewGroup paramViewGroup);
  
  public abstract ChatMessage createSecurityMsg(Context paramContext);
  
  public abstract Intent getLiveChannelIntent();
  
  public abstract Intent getLiveChannelIntent(Context paramContext, LaunchGuildChatPieParam paramLaunchGuildChatPieParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildLiveChannelApi
 * JD-Core Version:    0.7.0.1
 */