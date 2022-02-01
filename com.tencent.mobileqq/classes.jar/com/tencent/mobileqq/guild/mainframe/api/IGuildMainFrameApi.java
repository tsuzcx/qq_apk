package com.tencent.mobileqq.guild.mainframe.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.ChannelData;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IGuildMainFrameApi
  extends QRouteApi
{
  public static final String GOTO_GUILD_TAB = "GOTO_GUILD_TAB";
  
  public abstract void addGestureListener(FrameFragment paramFrameFragment, AbsGestureListener paramAbsGestureListener);
  
  public abstract void addGestureListener(QBaseActivity paramQBaseActivity, AbsGestureListener paramAbsGestureListener);
  
  public abstract void attachContainerInOrOut(QBaseActivity paramQBaseActivity, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void closeAppChannel(QBaseActivity paramQBaseActivity, ChannelData paramChannelData);
  
  public abstract int getAttachContainerProgress(FrameFragment paramFrameFragment);
  
  public abstract IGProChannelInfo getChannelInfo(QBaseActivity paramQBaseActivity, String paramString);
  
  public abstract Class<? extends Frame> getGuildMainFrameClass();
  
  public abstract String getSelectedChannel(FrameFragment paramFrameFragment, String paramString);
  
  public abstract String getSelectedGuild(FrameFragment paramFrameFragment);
  
  public abstract void gotoGuildTab(Context paramContext, int paramInt, Bundle paramBundle);
  
  public abstract void gotoGuildTabFromBackground(Context paramContext, boolean paramBoolean, int paramInt, Bundle paramBundle);
  
  public abstract void guildAttachContainerInOrOut(FrameFragment paramFrameFragment, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void handleJumpAction(FrameFragment paramFrameFragment, Bundle paramBundle);
  
  public abstract boolean isAioFullyOpen(FrameFragment paramFrameFragment);
  
  public abstract boolean isGuildTabFrame(Frame paramFrame);
  
  public abstract void jumpToGuild(FrameFragment paramFrameFragment, String paramString, boolean paramBoolean);
  
  public abstract void onPostThemeChanged(Frame paramFrame, int paramInt);
  
  public abstract void openGuildAttachContainer(FrameFragment paramFrameFragment, int paramInt, Object paramObject);
  
  public abstract void openTeamSharePage(QBaseActivity paramQBaseActivity, String paramString, long paramLong);
  
  public abstract void removeGestureListener(FrameFragment paramFrameFragment, AbsGestureListener paramAbsGestureListener);
  
  public abstract void removeGestureListener(QBaseActivity paramQBaseActivity, AbsGestureListener paramAbsGestureListener);
  
  public abstract void setSelectedChannel(FrameFragment paramFrameFragment, String paramString1, String paramString2);
  
  public abstract void setTabHeight(Frame paramFrame, int paramInt);
  
  public abstract void updateLiveChannel(AppRuntime paramAppRuntime, IGProChannelInfo paramIGProChannelInfo);
  
  public abstract void updateSelectedChannel(QBaseActivity paramQBaseActivity, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi
 * JD-Core Version:    0.7.0.1
 */