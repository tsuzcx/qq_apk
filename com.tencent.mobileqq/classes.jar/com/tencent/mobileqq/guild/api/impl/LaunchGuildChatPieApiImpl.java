package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.audio.dialog.AudioRoomDialog;
import com.tencent.mobileqq.guild.audio.dialog.AudioRoomDialog.Companion;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.message.MessageRecordForGuildWelcome;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class LaunchGuildChatPieApiImpl
  implements ILaunchGuildChatPieApi
{
  private static int INTERVAL_TIME = 500;
  private static String TAG = "LaunchGuildChatPieApiImpl";
  private static long mLastClick;
  
  private void startActivity(Context paramContext, Intent paramIntent, String paramString)
  {
    paramContext = new ActivityURIRequest(paramContext, paramString);
    paramContext.extra().putAll(paramIntent.getExtras());
    paramContext.setFlags(paramIntent.getFlags());
    QRoute.startUri(paramContext, null);
  }
  
  public ChatMessage createWelcomeMsg(AppRuntime paramAppRuntime, IGProChannelInfo paramIGProChannelInfo)
  {
    if (paramIGProChannelInfo == null) {
      return null;
    }
    String str1 = "";
    Object localObject2 = ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramIGProChannelInfo.getGuildId());
    Object localObject1 = QQGuildUtil.a(paramIGProChannelInfo.getGuildId(), paramAppRuntime);
    String str2 = paramAppRuntime.getCurrentAccountUin();
    String str4 = paramIGProChannelInfo.getGuildId();
    String str3 = ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    if (localObject2 != null) {
      paramAppRuntime = ((IGProGuildInfo)localObject2).getCreatorId();
    } else {
      paramAppRuntime = "";
    }
    localObject2 = paramIGProChannelInfo.getCreatorId();
    if (localObject1 != null) {
      str1 = ((IGProChannelInfo)localObject1).getChannelUin();
    }
    localObject1 = new MessageRecordForGuildWelcome();
    int i;
    if (TextUtils.equals(str1, paramIGProChannelInfo.getChannelUin()))
    {
      if (TextUtils.equals(paramAppRuntime, str3)) {
        i = 1;
      } else {
        i = 3;
      }
      ((MessageRecordForGuildWelcome)localObject1).welcomeType = i;
    }
    else
    {
      if (TextUtils.equals((CharSequence)localObject2, str3)) {
        i = 2;
      } else {
        i = 4;
      }
      ((MessageRecordForGuildWelcome)localObject1).welcomeType = i;
    }
    ((MessageRecordForGuildWelcome)localObject1).channelType = paramIGProChannelInfo.getType();
    ((MessageRecordForGuildWelcome)localObject1).guildUin = str4;
    ((MessageRecordForGuildWelcome)localObject1).channelUin = paramIGProChannelInfo.getChannelUin();
    ((MessageRecordForGuildWelcome)localObject1).shmsgseq = 0L;
    ((MessageRecordForGuildWelcome)localObject1).saveExtInfoToExtStr("GUILD_MSG_LOCAL_ONLY", "1");
    ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR((MessageRecord)localObject1, str4);
    long l = MessageCache.c();
    paramIGProChannelInfo = paramIGProChannelInfo.getChannelUin();
    if (TextUtils.isEmpty(str3)) {
      paramAppRuntime = str2;
    } else {
      paramAppRuntime = str3;
    }
    ((MessageRecordForGuildWelcome)localObject1).init(str2, paramIGProChannelInfo, paramAppRuntime, "", l, -4028, 10014, 0L);
    return localObject1;
  }
  
  public Intent getGuildChatPieIntent(Context paramContext, LaunchGuildChatPieParam paramLaunchGuildChatPieParam)
  {
    if ((paramContext != null) && (paramLaunchGuildChatPieParam != null) && (paramLaunchGuildChatPieParam.a()))
    {
      Intent localIntent = ((IGuildLiveChannelApi)QRoute.api(IGuildLiveChannelApi.class)).getLiveChannelIntent(paramContext, paramLaunchGuildChatPieParam);
      if (localIntent != null) {
        return localIntent;
      }
      localIntent = new Intent();
      if (paramLaunchGuildChatPieParam.h)
      {
        localIntent.putExtra("goto_guildtab_actiontype", GuildMainFrameConstants.s);
        ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setGuildTabIntent(paramContext, localIntent);
        localIntent.putExtra("GOTO_GUILD_TAB", true);
        localIntent.putExtra("forceStartActivity", true);
        localIntent.putExtra("forceStartActivityTemp", true);
      }
      localIntent.putExtra("uin", paramLaunchGuildChatPieParam.b);
      localIntent.putExtra("uintype", 10014);
      localIntent.putExtra("uinname", paramLaunchGuildChatPieParam.c);
      localIntent.putExtra("channel_name", paramLaunchGuildChatPieParam.c);
      localIntent.putExtra("guild_id", paramLaunchGuildChatPieParam.a);
      localIntent.putExtra("channel_type", paramLaunchGuildChatPieParam.d);
      localIntent.putExtra("need_to_show_unread_num", true);
      localIntent.putExtra("openGuildAioFrom", paramLaunchGuildChatPieParam.i);
      localIntent.putExtra("openGuildAioDisableReuse", paramLaunchGuildChatPieParam.j);
      localIntent.putExtra("openGuildAioUpdateSession", paramLaunchGuildChatPieParam.k);
      if (paramLaunchGuildChatPieParam.l != null) {
        localIntent.putExtra("guild_extra", paramLaunchGuildChatPieParam.l);
      }
      paramContext = new Bundle();
      paramContext.putBoolean("openAioWithoutAnimation", paramLaunchGuildChatPieParam.f);
      paramContext.putBoolean("openAioIn", paramLaunchGuildChatPieParam.g);
      paramContext.putBoolean("keepOpenPos", paramLaunchGuildChatPieParam.e);
      localIntent.putExtra("goto_guildtab_actionextra", paramContext);
      return localIntent;
    }
    return null;
  }
  
  public void launchAudioChatPie(Context paramContext, IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean)
  {
    if ((paramIGProChannelInfo != null) && (paramIGProGuildInfo != null) && (System.currentTimeMillis() - mLastClick >= INTERVAL_TIME))
    {
      if (QBaseActivity.sTopActivity == null)
      {
        QLog.d(TAG, 1, "launchAudioChatPie sTopActivity is null");
        return;
      }
      mLastClick = System.currentTimeMillis();
      AudioRoomDialog.a.a(paramIGProGuildInfo, paramIGProChannelInfo, paramBoolean, 0).show(QBaseActivity.sTopActivity.getSupportFragmentManager(), "AudioRoomDialog");
      return;
    }
    mLastClick = System.currentTimeMillis();
  }
  
  public void launchGuildChatPie(@NonNull Context paramContext, @NonNull LaunchGuildChatPieParam paramLaunchGuildChatPieParam)
  {
    if ((paramContext != null) && ((paramContext instanceof Activity)) && (paramLaunchGuildChatPieParam != null))
    {
      if (!paramLaunchGuildChatPieParam.a()) {
        return;
      }
      if (paramLaunchGuildChatPieParam.h)
      {
        paramContext.startActivity(getGuildChatPieIntent(paramContext, paramLaunchGuildChatPieParam));
        paramContext = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("launchGuildChatPie guildChatPieParam:");
        ((StringBuilder)localObject).append(paramLaunchGuildChatPieParam.toString());
        QLog.i(paramContext, 1, ((StringBuilder)localObject).toString());
        return;
      }
      boolean bool = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).checkGuildMainFrameShow() ^ true;
      paramLaunchGuildChatPieParam.h = bool;
      Object localObject = getGuildChatPieIntent(paramContext, paramLaunchGuildChatPieParam);
      if (bool)
      {
        paramContext.startActivity((Intent)localObject);
      }
      else
      {
        paramContext = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).getMainFragment();
        ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).openGuildAttachContainer(paramContext, GuildAttachContainerController.c, localObject);
      }
      paramContext = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launchGuildChatPie guildChatPieParam:");
      ((StringBuilder)localObject).append(paramLaunchGuildChatPieParam.toString());
      QLog.i(paramContext, 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.LaunchGuildChatPieApiImpl
 * JD-Core Version:    0.7.0.1
 */