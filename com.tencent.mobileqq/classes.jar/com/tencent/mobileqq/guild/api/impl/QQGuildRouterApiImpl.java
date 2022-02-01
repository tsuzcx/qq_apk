package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioSettingFragment;
import com.tencent.mobileqq.guild.avatar.GuildAvatarMgr;
import com.tencent.mobileqq.guild.avatar.IGuildAvatarMgr;
import com.tencent.mobileqq.guild.channel.QQGuildChannelCategorySortFragment;
import com.tencent.mobileqq.guild.channel.QQGuildChannelChooseCategoryFragment;
import com.tencent.mobileqq.guild.channel.QQGuildChannelCreateCategoryFragment;
import com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment;
import com.tencent.mobileqq.guild.channel.QQGuildChannelListSettingFragment;
import com.tencent.mobileqq.guild.channel.QQGuildChannelModidyCategoryFragment;
import com.tencent.mobileqq.guild.channel.QQGuildChannelNameSettingFragment;
import com.tencent.mobileqq.guild.channel.QQGuildChannelSettingForMemberFragment;
import com.tencent.mobileqq.guild.channel.QQGuildChannelSortFragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildSubChannelCreateMainDialogFragment;
import com.tencent.mobileqq.guild.client.GuildClientManageFragment;
import com.tencent.mobileqq.guild.client.GuildClientTitleDisplaySettingFragment;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.live.fragment.anchor.manage.QQGuildLiveSettingFragment;
import com.tencent.mobileqq.guild.message.chatpie.GuildMenuDialogFragment;
import com.tencent.mobileqq.guild.message.chatpie.IGuildMenuEventCallBack;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateSelectMemberFragment;
import com.tencent.mobileqq.guild.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.setting.JoinGuildSettingFragment;
import com.tencent.mobileqq.guild.setting.QQGuildAvatarSettingFragment;
import com.tencent.mobileqq.guild.setting.QQGuildCoverSettingFragment;
import com.tencent.mobileqq.guild.setting.QQGuildDescriptionEditFragment;
import com.tencent.mobileqq.guild.setting.QQGuildInfoFragment;
import com.tencent.mobileqq.guild.setting.QQGuildMainSettingFragment;
import com.tencent.mobileqq.guild.setting.QQGuildMemberFragment;
import com.tencent.mobileqq.guild.setting.QQGuildNameSettingFragment;
import com.tencent.mobileqq.guild.setting.QQGuildNicknameSettingFragment;
import com.tencent.mobileqq.guild.setting.QQGuildNotifySettingFragment;
import com.tencent.mobileqq.guild.setting.msgnotify.QQGuildMsgNotifySettingFragment;
import com.tencent.mobileqq.guild.share.GuildShareActionSheet;
import com.tencent.mobileqq.guild.source.QQGuildJumpSource;
import com.tencent.mobileqq.guild.util.QQGuildSPUtils;
import com.tencent.mobileqq.guild.util.QQGuildTabStateUtils;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import mqq.app.AppRuntime;

public class QQGuildRouterApiImpl
  implements IQQGuildRouterApi
{
  public static final String TAG = "QQGuildRouterApiImpl";
  
  private void globalSetJoinSource(Intent paramIntent, String paramString)
  {
    QQGuildJumpSource.a(true);
    if (paramString.startsWith("mqqguild://guild/join"))
    {
      QQGuildJumpSource.a("outside");
      QQGuildJumpSource.b("sdk");
      return;
    }
    if ("biz_src_jc_qzone".equals(paramIntent.getStringExtra("big_brother_source_key")))
    {
      QQGuildJumpSource.a("share");
      QQGuildJumpSource.b("others");
      return;
    }
    int i;
    if ("biz_src_jc_ark".equals(paramIntent.getStringExtra("big_brother_source_key"))) {
      i = paramIntent.getIntExtra("uinType", -2147483648);
    } else {
      i = -2147483648;
    }
    int j = i;
    if (i == -2147483648) {
      j = paramIntent.getIntExtra("curtype", -2147483648);
    }
    if (QQGuildJumpSource.b.contains(Integer.valueOf(j)))
    {
      QQGuildJumpSource.a("share");
      QQGuildJumpSource.b("c2c");
      return;
    }
    if (j == 1)
    {
      QQGuildJumpSource.a("share");
      QQGuildJumpSource.b("grp");
      return;
    }
    if (j == 10014)
    {
      QQGuildJumpSource.a("share");
      QQGuildJumpSource.b("channel");
      return;
    }
    QQGuildJumpSource.a("share");
    QQGuildJumpSource.b("others");
  }
  
  public void addGuildByAuthSig(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    QQGuildUtil.a(paramContext, paramString1, paramString2, paramInt);
  }
  
  public void addGuildByShareUrl(Context paramContext, String paramString)
  {
    QQGuildUtil.a(paramContext, paramString);
  }
  
  public IGuildAvatarMgr getGuildAvatarMgr()
  {
    return new GuildAvatarMgr();
  }
  
  public boolean isShowGuildTab()
  {
    return QQGuildTabStateUtils.a();
  }
  
  public void openAudioChannelInfoSetting(Context paramContext, String paramString1, IGProChannelInfo paramIGProChannelInfo, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localBundle.putSerializable("extra_guild_channel_info", paramIGProChannelInfo);
    localBundle.putString("extra_channel_category", paramString2);
    localBundle.putString("extra_guild_id", paramString1);
    localBundle.putInt("extra_entrance_from", paramInt);
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildAudioSettingFragment.class);
  }
  
  public void openChannelNotifySetting(Activity paramActivity, IGProGuildInfo paramIGProGuildInfo)
  {
    QPublicFragmentActivity.Launcher.a(paramActivity, QQGuildNotifySettingFragment.a(paramIGProGuildInfo), QPublicFragmentActivity.class, QQGuildNotifySettingFragment.class);
  }
  
  public void openChannelSharePanel(@NonNull Activity paramActivity, @NonNull IGProGuildInfo paramIGProGuildInfo, @NonNull IGProChannelInfo paramIGProChannelInfo)
  {
    new GuildShareActionSheet(paramActivity, paramIGProGuildInfo, paramIGProChannelInfo).a();
  }
  
  public void openCreateGuildChannel(Context paramContext, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    QQGuildSubChannelCreateMainDialogFragment.b(new CreateSubChannelInfo(paramString1, paramLong, paramString2)).show(QBaseActivity.sTopActivity.getSupportFragmentManager(), "QQGuildSubChannelCreateMainDialogFragment");
  }
  
  public void openGuild(AppRuntime paramAppRuntime, Context paramContext, boolean paramBoolean, Bundle paramBundle, String paramString)
  {
    QQGuildUtil.a(paramAppRuntime, paramContext, paramBundle, paramBoolean, paramString);
  }
  
  public void openGuildAvatarSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo)
  {
    QPublicFragmentActivity.Launcher.a(paramContext, QQGuildAvatarSettingFragment.a(paramIGProGuildInfo), QPublicFragmentActivity.class, QQGuildAvatarSettingFragment.class);
  }
  
  public void openGuildChannelCategorySort(Context paramContext, AppInterface paramAppInterface, String paramString, int paramInt)
  {
    QPublicFragmentActivity.Launcher.a(paramContext, QQGuildChannelCategorySortFragment.a(paramString), QPublicFragmentActivity.class, QQGuildChannelCategorySortFragment.class, paramInt);
  }
  
  public void openGuildChannelChooseCategory(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QQGuildChannelChooseCategoryFragment.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void openGuildChannelCreateCategorySetting(Context paramContext, AppInterface paramAppInterface, String paramString, int paramInt)
  {
    QPublicFragmentActivity.Launcher.a(paramContext, QQGuildChannelCreateCategoryFragment.b(paramString), QPublicFragmentActivity.class, QQGuildChannelCreateCategoryFragment.class, paramInt);
  }
  
  public void openGuildChannelHomepagePublishMood(Context paramContext, IGProChannelInfo paramIGProChannelInfo) {}
  
  public void openGuildChannelInfoSetting(Context paramContext, String paramString1, IGProChannelInfo paramIGProChannelInfo, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localBundle.putSerializable("extra_guild_channel_info", paramIGProChannelInfo);
    localBundle.putString("extra_channel_category", paramString2);
    localBundle.putString("extra_guild_id", paramString1);
    localBundle.putInt("extra_entrance_from", paramInt);
    localIntent.putExtras(localBundle);
    if (paramIGProChannelInfo.getType() == 5)
    {
      QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildLiveSettingFragment.class);
      return;
    }
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildChannelInfoSettingFragment.class);
  }
  
  public void openGuildChannelInfoSetting(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    QQGuildChannelInfoSettingFragment.a(paramAppInterface, paramContext, paramString1, paramString2);
  }
  
  public void openGuildChannelInfoSettingForMember(Context paramContext, String paramString1, String paramString2)
  {
    QQGuildChannelSettingForMemberFragment.a(paramContext, paramString1, paramString2);
  }
  
  public void openGuildChannelListSetting(Context paramContext, String paramString)
  {
    QQGuildChannelListSettingFragment.a(paramContext, paramString);
  }
  
  public void openGuildChannelListSort(Context paramContext, AppInterface paramAppInterface, String paramString, int paramInt)
  {
    QQGuildChannelSortFragment.a(paramContext, paramString);
  }
  
  public void openGuildChannelModifyCategorySetting(Context paramContext, AppInterface paramAppInterface, String paramString1, String paramString2, long paramLong)
  {
    QPublicFragmentActivity.Launcher.a(paramContext, QQGuildChannelModidyCategoryFragment.a(paramString1, paramString2, paramLong), QPublicFragmentActivity.class, QQGuildChannelModidyCategoryFragment.class);
  }
  
  public void openGuildChannelNameSetting(Context paramContext, IGProChannelInfo paramIGProChannelInfo)
  {
    QQGuildChannelNameSettingFragment.a(paramContext, paramIGProChannelInfo);
  }
  
  public Fragment openGuildChatPieMenuDialog(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity, QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, IGuildMenuEventCallBack paramIGuildMenuEventCallBack)
  {
    if ((paramAppRuntime != null) && (paramQBaseActivity != null))
    {
      paramQBaseActivity = paramQBaseActivity.getSupportFragmentManager();
      paramAppRuntime = new GuildMenuDialogFragment(paramAppRuntime, paramQQCustomMenu, paramChatMessage);
      paramAppRuntime.a(paramIGuildMenuEventCallBack);
      paramAppRuntime.show(paramQBaseActivity, "menuDialogFragment");
      return paramAppRuntime;
    }
    return null;
  }
  
  public void openGuildCoverSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo)
  {
    QPublicFragmentActivity.Launcher.a(paramContext, QQGuildCoverSettingFragment.a(paramIGProGuildInfo), QPublicFragmentActivity.class, QQGuildCoverSettingFragment.class);
  }
  
  public void openGuildInfoSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo)
  {
    QPublicFragmentActivity.Launcher.a(paramContext, QQGuildInfoFragment.a(paramIGProGuildInfo), QPublicFragmentActivity.class, QQGuildInfoFragment.class);
  }
  
  public void openGuildIntroSetting(Context paramContext, String paramString1, String paramString2)
  {
    QQGuildDescriptionEditFragment.a(paramContext, paramString1, paramString2);
  }
  
  public void openGuildJoinSetting(Context paramContext, String paramString)
  {
    QPublicFragmentActivity.Launcher.a(paramContext, JoinGuildSettingFragment.a(paramString), QPublicFragmentActivity.class, JoinGuildSettingFragment.class);
  }
  
  public void openGuildMemberCard(AppInterface paramAppInterface, Activity paramActivity, @Nullable String paramString1, String paramString2, String paramString3, int paramInt)
  {
    IGPSService localIGPSService = (IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "");
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = localIGPSService.getGuildIdOf(paramString2);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = localIGPSService.getGuildInfo(paramString1);
      if (localObject != null)
      {
        i = ((IGProGuildInfo)localObject).getUserType();
        localObject = ((IGProGuildInfo)localObject).getShowNumber();
        break label84;
      }
    }
    Object localObject = paramString1;
    int i = 0;
    label84:
    localIGPSService.fetchUserInfo(paramString1, new ArrayList(Arrays.asList(new String[] { paramString3 })), false, new QQGuildRouterApiImpl.1(this, i, paramAppInterface, paramActivity, paramString3, paramString1, paramString2, (String)localObject, paramInt));
  }
  
  public void openGuildMemberListSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo, String paramString)
  {
    paramIGProGuildInfo = QQGuildMemberFragment.a(paramIGProGuildInfo);
    paramIGProGuildInfo.putExtra("extra_channel_id", paramString);
    QPublicFragmentActivity.Launcher.a(paramContext, paramIGProGuildInfo, QPublicFragmentActivity.class, QQGuildMemberFragment.class);
  }
  
  public void openGuildMemberSelector(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    GuildPrivateSelectMemberFragment.a(paramActivity, paramAppInterface, paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void openGuildMsgNotifySetting(Context paramContext, String paramString)
  {
    QQGuildMsgNotifySettingFragment.a(paramContext, paramString);
  }
  
  public void openGuildNameSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo)
  {
    QQGuildNameSettingFragment.a(paramContext, paramIGProGuildInfo);
  }
  
  public void openGuildNicknameSetting(Context paramContext, String paramString1, String paramString2)
  {
    QQGuildNicknameSettingFragment.a(paramContext, paramString1, paramString2);
  }
  
  public void openGuildProfile(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    QQGuildUtil.b(paramContext, paramString1, paramString2, paramInt);
  }
  
  public void openGuildProfileDialog(Activity paramActivity, GuildProfileData paramGuildProfileData)
  {
    GuildProfileCard.a(paramActivity, null, paramGuildProfileData);
  }
  
  public void openGuildProfileSettingFragment(Context paramContext, @NonNull String paramString)
  {
    GuildClientManageFragment.a(paramContext, paramString);
  }
  
  public void openGuildSetting(Context paramContext, IGProGuildInfo paramIGProGuildInfo, String paramString)
  {
    paramIGProGuildInfo = QQGuildMainSettingFragment.a(paramIGProGuildInfo);
    paramIGProGuildInfo.putExtra("extra_channel_id", paramString);
    QPublicFragmentActivity.Launcher.a(paramContext, paramIGProGuildInfo, QPublicFragmentActivity.class, QQGuildMainSettingFragment.class);
  }
  
  public void openGuildThirdAppSetting(Context paramContext, String paramString)
  {
    GuildClientTitleDisplaySettingFragment.a(paramContext, paramString);
  }
  
  public void openRobotList(Activity paramActivity, String paramString)
  {
    QQGuildUtil.b(paramActivity, paramString);
  }
  
  public void openRobotProfileCard(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    QQGuildUtil.a(paramActivity, paramString1, paramString2, paramString3);
  }
  
  public void openSharePanel(@NonNull Activity paramActivity, @NonNull IGProGuildInfo paramIGProGuildInfo)
  {
    new GuildShareActionSheet(paramActivity, paramIGProGuildInfo, null).a();
  }
  
  public void setShowGuildTab(boolean paramBoolean)
  {
    QQGuildSPUtils.a(paramBoolean);
    ((QQGuildHandler)QQGuildUtil.a(QQGuildHandler.class)).notifyUI(8, true, null);
  }
  
  public void shareGuild(Activity paramActivity, IGProGuildInfo paramIGProGuildInfo, int paramInt)
  {
    new GuildShareActionSheet(paramActivity, paramIGProGuildInfo, null).a(paramInt);
  }
  
  public boolean shouldInterceptQQBrowserDelegationActivity(Activity paramActivity, String paramString, Intent paramIntent)
  {
    if (QQGuildUtil.a(paramString))
    {
      globalSetJoinSource(paramIntent, paramString);
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).addGuildByShareUrl(paramActivity, paramString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.QQGuildRouterApiImpl
 * JD-Core Version:    0.7.0.1
 */