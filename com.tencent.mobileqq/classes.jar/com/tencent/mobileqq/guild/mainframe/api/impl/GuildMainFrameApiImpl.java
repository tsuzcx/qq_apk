package com.tencent.mobileqq.guild.mainframe.api.impl;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrame;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.IGuildMainFrame;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.ChannelData;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import com.tencent.mobileqq.guild.mainframe.helper.ChannelSelectHelper;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftBarSelHelper;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftBarSelHelper.SelItem;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class GuildMainFrameApiImpl
  implements IGuildMainFrameApi
{
  private static final String TAG = "GuildMainFrameApiImpl";
  
  private IGuildMainFrame getGuildMainFrame(FrameFragment paramFrameFragment)
  {
    return (IGuildMainFrame)paramFrameFragment.a(getGuildMainFrameClass());
  }
  
  public void addGestureListener(FrameFragment paramFrameFragment, AbsGestureListener paramAbsGestureListener)
  {
    if (paramFrameFragment == null) {
      return;
    }
    paramFrameFragment = getGuildMainFrame(paramFrameFragment);
    if (paramFrameFragment != null) {
      paramFrameFragment.n().a(paramAbsGestureListener);
    }
  }
  
  public void addGestureListener(QBaseActivity paramQBaseActivity, AbsGestureListener paramAbsGestureListener)
  {
    paramQBaseActivity = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).getMainFragment(paramQBaseActivity);
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity = getGuildMainFrame(paramQBaseActivity);
      if (paramQBaseActivity != null) {
        paramQBaseActivity.n().a(paramAbsGestureListener);
      }
    }
  }
  
  public void attachContainerInOrOut(QBaseActivity paramQBaseActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramQBaseActivity = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).getMainFragment(paramQBaseActivity);
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity = getGuildMainFrame(paramQBaseActivity);
      if (paramQBaseActivity != null) {
        paramQBaseActivity.a(paramBoolean1, paramBoolean2);
      }
    }
  }
  
  public void closeAppChannel(QBaseActivity paramQBaseActivity, ChannelData paramChannelData)
  {
    ((QQGuildHandler)((AppInterface)paramQBaseActivity.getAppRuntime()).getBusinessHandler(QQGuildHandler.class.getName())).a(paramChannelData);
  }
  
  public int getAttachContainerProgress(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = getGuildMainFrame(paramFrameFragment);
    if (paramFrameFragment != null) {
      return paramFrameFragment.m().j();
    }
    return 0;
  }
  
  public IGProChannelInfo getChannelInfo(QBaseActivity paramQBaseActivity, String paramString)
  {
    return ((IGPSService)paramQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(paramString);
  }
  
  public Class<? extends Frame> getGuildMainFrameClass()
  {
    return GuildFragmentDelegateFrame.class;
  }
  
  public String getSelectedChannel(FrameFragment paramFrameFragment, String paramString)
  {
    if (paramFrameFragment == null) {
      return "";
    }
    paramFrameFragment = getGuildMainFrame(paramFrameFragment);
    if (paramFrameFragment != null) {
      return ((ChannelSelectHelper)paramFrameFragment.a(GuildMainFrameConstants.f)).a(paramString);
    }
    return "";
  }
  
  public String getSelectedGuild(FrameFragment paramFrameFragment)
  {
    if (paramFrameFragment == null) {
      return "";
    }
    paramFrameFragment = getGuildMainFrame(paramFrameFragment);
    if (paramFrameFragment != null)
    {
      paramFrameFragment = ((GuildLeftBarSelHelper)paramFrameFragment.a(GuildMainFrameConstants.b)).i();
      if (paramFrameFragment != null) {
        return paramFrameFragment.b;
      }
    }
    return "";
  }
  
  public void gotoGuildTab(Context paramContext, int paramInt, Bundle paramBundle)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("goto_guildtab_actiontype", paramInt);
    localIntent.putExtra("goto_guildtab_actionextra", paramBundle);
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setGuildTabIntent(paramContext, localIntent);
    localIntent.putExtra("GOTO_GUILD_TAB", true);
    paramContext.startActivity(localIntent);
  }
  
  public void gotoGuildTabFromBackground(Context paramContext, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent();
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setGuildTabIntent(paramContext, localIntent);
    if (paramBoolean)
    {
      localIntent.putExtra("goto_guildtab_actiontype", paramInt);
      localIntent.putExtra("goto_guildtab_actionextra", paramBundle);
      localIntent.putExtra("GOTO_GUILD_TAB", true);
    }
    paramContext = PendingIntent.getActivity(paramContext, 0, localIntent, 0);
    try
    {
      paramContext.send();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void guildAttachContainerInOrOut(FrameFragment paramFrameFragment, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramFrameFragment == null) {
      return;
    }
    paramFrameFragment = getGuildMainFrame(paramFrameFragment);
    if (paramFrameFragment != null) {
      paramFrameFragment.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void handleJumpAction(FrameFragment paramFrameFragment, Bundle paramBundle)
  {
    if (paramFrameFragment != null)
    {
      if (paramBundle == null) {
        return;
      }
      paramFrameFragment = getGuildMainFrame(paramFrameFragment);
      if (paramFrameFragment != null) {
        paramFrameFragment.a(paramBundle);
      }
    }
  }
  
  public boolean isAioFullyOpen(FrameFragment paramFrameFragment)
  {
    if (paramFrameFragment == null) {
      return false;
    }
    paramFrameFragment = getGuildMainFrame(paramFrameFragment);
    if (paramFrameFragment != null) {
      return paramFrameFragment.m().i();
    }
    return false;
  }
  
  public boolean isGuildTabFrame(Frame paramFrame)
  {
    return paramFrame instanceof IGuildMainFrame;
  }
  
  public void jumpToGuild(FrameFragment paramFrameFragment, String paramString, boolean paramBoolean)
  {
    if (paramFrameFragment == null) {
      return;
    }
    paramFrameFragment = getGuildMainFrame(paramFrameFragment);
    if (paramFrameFragment != null) {
      paramFrameFragment.cw_().b(1, paramString);
    }
  }
  
  public void onPostThemeChanged(Frame paramFrame, int paramInt)
  {
    if ((paramFrame instanceof IGuildMainFrame)) {
      ((IGuildMainFrame)paramFrame).b(paramInt);
    }
  }
  
  public void openGuildAttachContainer(FrameFragment paramFrameFragment, int paramInt, Object paramObject)
  {
    if (paramFrameFragment == null) {
      return;
    }
    paramFrameFragment = getGuildMainFrame(paramFrameFragment);
    if (paramFrameFragment != null) {
      paramFrameFragment.m().a(paramInt, paramObject);
    }
  }
  
  public void openTeamSharePage(QBaseActivity paramQBaseActivity, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("guildId: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", teamId: ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("GuildMainFrameApiImpl", 1, ((StringBuilder)localObject).toString());
    }
    if (!QQGuildUtil.a(paramQBaseActivity, paramString))
    {
      QQToast.makeText(paramQBaseActivity.getApplicationContext(), 1, "暂无文字子频道发言权限哦", 0).show();
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("is_multi_selection", false);
    ((Intent)localObject).putExtra("open_single_guild_id", paramString);
    ((Intent)localObject).putExtra("only_single_selection", false);
    ((Intent)localObject).putExtra("moba_teamid", paramLong);
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).buildTeamShareForwardIntent((Intent)localObject, paramQBaseActivity);
    QPublicFragmentActivity.startForResult(paramQBaseActivity, (Intent)localObject, ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).getGuildForwardListFragmentClass(), -1);
  }
  
  public void removeGestureListener(FrameFragment paramFrameFragment, AbsGestureListener paramAbsGestureListener)
  {
    if (paramFrameFragment == null) {
      return;
    }
    paramFrameFragment = getGuildMainFrame(paramFrameFragment);
    if (paramFrameFragment != null) {
      paramFrameFragment.n().b(paramAbsGestureListener);
    }
  }
  
  public void removeGestureListener(QBaseActivity paramQBaseActivity, AbsGestureListener paramAbsGestureListener)
  {
    paramQBaseActivity = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).getMainFragment(paramQBaseActivity);
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity = getGuildMainFrame(paramQBaseActivity);
      if (paramQBaseActivity != null) {
        paramQBaseActivity.n().b(paramAbsGestureListener);
      }
    }
  }
  
  public void setSelectedChannel(FrameFragment paramFrameFragment, String paramString1, String paramString2)
  {
    if (paramFrameFragment == null) {
      return;
    }
    paramFrameFragment = getGuildMainFrame(paramFrameFragment);
    if (paramFrameFragment != null) {
      ((ChannelSelectHelper)paramFrameFragment.a(GuildMainFrameConstants.f)).a(paramString1, paramString2);
    }
  }
  
  public void setTabHeight(Frame paramFrame, int paramInt)
  {
    if ((paramFrame instanceof IGuildMainFrame)) {
      ((IGuildMainFrame)paramFrame).c(paramInt);
    }
  }
  
  public void updateLiveChannel(AppRuntime paramAppRuntime, IGProChannelInfo paramIGProChannelInfo)
  {
    ((QQGuildHandler)((AppInterface)paramAppRuntime).getBusinessHandler(QQGuildHandler.class.getName())).a(paramIGProChannelInfo);
  }
  
  public void updateSelectedChannel(QBaseActivity paramQBaseActivity, String paramString)
  {
    ((QQGuildHandler)((AppInterface)paramQBaseActivity.getAppRuntime()).getBusinessHandler(QQGuildHandler.class.getName())).a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.api.impl.GuildMainFrameApiImpl
 * JD-Core Version:    0.7.0.1
 */