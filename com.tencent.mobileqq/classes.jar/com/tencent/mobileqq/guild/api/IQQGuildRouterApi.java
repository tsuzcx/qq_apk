package com.tencent.mobileqq.guild.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.avatar.IGuildAvatarMgr;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.message.chatpie.IGuildMenuEventCallBack;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQQGuildRouterApi
  extends QRouteApi
{
  public abstract void addGuildByAuthSig(Context paramContext, String paramString1, String paramString2, int paramInt);
  
  public abstract void addGuildByShareUrl(Context paramContext, String paramString);
  
  public abstract IGuildAvatarMgr getGuildAvatarMgr();
  
  public abstract boolean isShowGuildTab();
  
  public abstract void openAudioChannelInfoSetting(Context paramContext, String paramString1, IGProChannelInfo paramIGProChannelInfo, String paramString2, int paramInt);
  
  public abstract void openChannelNotifySetting(Activity paramActivity, IGProGuildInfo paramIGProGuildInfo);
  
  public abstract void openChannelSharePanel(Activity paramActivity, IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo);
  
  public abstract void openCreateGuildChannel(Context paramContext, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, long paramLong);
  
  public abstract void openGuild(AppRuntime paramAppRuntime, Context paramContext, boolean paramBoolean, Bundle paramBundle, String paramString);
  
  public abstract void openGuildAvatarSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo);
  
  public abstract void openGuildChannelCategorySort(Context paramContext, AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract void openGuildChannelChooseCategory(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract void openGuildChannelCreateCategorySetting(Context paramContext, AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract void openGuildChannelHomepagePublishMood(Context paramContext, IGProChannelInfo paramIGProChannelInfo);
  
  public abstract void openGuildChannelInfoSetting(Context paramContext, String paramString1, IGProChannelInfo paramIGProChannelInfo, String paramString2, int paramInt);
  
  public abstract void openGuildChannelInfoSetting(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2);
  
  public abstract void openGuildChannelInfoSettingForMember(Context paramContext, String paramString1, String paramString2);
  
  public abstract void openGuildChannelListSetting(Context paramContext, String paramString);
  
  public abstract void openGuildChannelListSort(Context paramContext, AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract void openGuildChannelModifyCategorySetting(Context paramContext, AppInterface paramAppInterface, String paramString1, String paramString2, long paramLong);
  
  public abstract void openGuildChannelNameSetting(Context paramContext, IGProChannelInfo paramIGProChannelInfo);
  
  public abstract Fragment openGuildChatPieMenuDialog(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity, QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, IGuildMenuEventCallBack paramIGuildMenuEventCallBack);
  
  public abstract void openGuildCoverSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo);
  
  public abstract void openGuildInfoSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo);
  
  public abstract void openGuildIntroSetting(Context paramContext, String paramString1, String paramString2);
  
  public abstract void openGuildJoinSetting(Context paramContext, String paramString);
  
  public abstract void openGuildMemberCard(AppInterface paramAppInterface, Activity paramActivity, @Nullable String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void openGuildMemberListSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo, String paramString);
  
  public abstract void openGuildMemberSelector(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void openGuildMsgNotifySetting(Context paramContext, String paramString);
  
  public abstract void openGuildNameSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo);
  
  public abstract void openGuildNicknameSetting(Context paramContext, String paramString1, String paramString2);
  
  public abstract void openGuildProfile(Context paramContext, String paramString1, String paramString2, int paramInt);
  
  public abstract void openGuildProfileDialog(Activity paramActivity, GuildProfileData paramGuildProfileData);
  
  public abstract void openGuildProfileSettingFragment(Context paramContext, @Nullable String paramString);
  
  public abstract void openGuildSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo, String paramString);
  
  public abstract void openGuildThirdAppSetting(Context paramContext, String paramString);
  
  public abstract void openRobotList(Activity paramActivity, String paramString);
  
  public abstract void openRobotProfileCard(Activity paramActivity, String paramString1, String paramString2, String paramString3);
  
  public abstract void openSharePanel(Activity paramActivity, IGProGuildInfo paramIGProGuildInfo);
  
  public abstract void setShowGuildTab(boolean paramBoolean);
  
  public abstract void shareGuild(Activity paramActivity, IGProGuildInfo paramIGProGuildInfo, int paramInt);
  
  public abstract boolean shouldInterceptQQBrowserDelegationActivity(Activity paramActivity, String paramString, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IQQGuildRouterApi
 * JD-Core Version:    0.7.0.1
 */