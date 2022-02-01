package com.tencent.mobileqq.guild.live;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.live.fragment.QQGuildLiveRoomFragment;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.util.GuildAVPriorityManager;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.guild.window.GuildFloatWindowManager;
import com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGuildLiveLauncher
{
  public static Intent a(@NonNull QQGuildLiveRoomStartParams paramQQGuildLiveRoomStartParams)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_class", QQGuildLiveRoomFragment.class.getName());
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("arg_start_params", paramQQGuildLiveRoomStartParams);
    localIntent.putExtras(localBundle);
    a(localIntent, paramQQGuildLiveRoomStartParams);
    return localIntent;
  }
  
  private static void a(Intent paramIntent, @NonNull QQGuildLiveRoomStartParams paramQQGuildLiveRoomStartParams)
  {
    if ((paramQQGuildLiveRoomStartParams.getChannelInfo() != null) && (paramQQGuildLiveRoomStartParams.getGuildInfo() != null))
    {
      IGProGuildInfo localIGProGuildInfo = paramQQGuildLiveRoomStartParams.getGuildInfo();
      paramQQGuildLiveRoomStartParams = paramQQGuildLiveRoomStartParams.getChannelInfo();
      paramIntent.putExtra("goto_guildtab_actiontype", GuildMainFrameConstants.s);
      paramIntent.setFlags(335544320);
      paramIntent.putExtra("fragment_id", 1);
      paramIntent.putExtra("GOTO_GUILD_TAB", true);
      String str1 = paramQQGuildLiveRoomStartParams.getChannelUin();
      String str2 = paramQQGuildLiveRoomStartParams.getChannelName();
      String str3 = localIGProGuildInfo.getGuildName();
      paramIntent.putExtra("uin", str1);
      paramIntent.putExtra("uintype", 10014);
      paramIntent.putExtra("uinname", str3);
      paramIntent.putExtra("channel_name", str2);
      paramIntent.putExtra("guild_id", localIGProGuildInfo.getGuildID());
      paramIntent.putExtra("channel_type", paramQQGuildLiveRoomStartParams.getType());
      paramQQGuildLiveRoomStartParams = new Bundle();
      paramQQGuildLiveRoomStartParams.putBoolean("openAioWithoutAnimation", false);
      paramQQGuildLiveRoomStartParams.putBoolean("openAioIn", false);
      paramIntent.putExtra("goto_guildtab_actionextra", paramQQGuildLiveRoomStartParams);
      return;
    }
    GuildLiveToast.a(2131890449);
  }
  
  private static void a(@NonNull QQGuildLiveRoomStartParams paramQQGuildLiveRoomStartParams, Bundle paramBundle, QQGuildLiveLauncher.CloseLoadingDialog paramCloseLoadingDialog)
  {
    IGProChannelInfo localIGProChannelInfo = paramQQGuildLiveRoomStartParams.getChannelInfo();
    ((IGPSService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).fetchEnterChannelPermission(localIGProChannelInfo.getGuildId(), localIGProChannelInfo.getChannelUin(), new QQGuildLiveLauncher.1(paramCloseLoadingDialog, paramQQGuildLiveRoomStartParams, paramBundle));
  }
  
  public static void a(@NonNull QQGuildLiveRoomStartParams paramQQGuildLiveRoomStartParams, Bundle paramBundle, boolean paramBoolean, QQGuildLiveLauncher.CloseLoadingDialog paramCloseLoadingDialog)
  {
    IGProChannelInfo localIGProChannelInfo = paramQQGuildLiveRoomStartParams.getChannelInfo();
    Object localObject = paramQQGuildLiveRoomStartParams.getGuildInfo();
    if ((localIGProChannelInfo != null) && (localObject != null))
    {
      if (b())
      {
        QLog.i("QGL.QQGuildLiveLauncher", 1, "checkAvFocusState == true, return.");
        b(paramCloseLoadingDialog);
        GuildLiveToast.a(2131890480);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isFromFloatWindow = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("QGL.QQGuildLiveLauncher", 1, ((StringBuilder)localObject).toString());
      if (a(localIGProChannelInfo.getChannelUin()))
      {
        QLog.i("QGL.QQGuildLiveLauncher", 1, "isEnterTheSameChannel.");
        b(paramCloseLoadingDialog);
        b(QQGuildLiveStartParamsCache.a(), paramBundle, true);
        return;
      }
      if (a())
      {
        QLog.i("QGL.QQGuildLiveLauncher", 1, "selfIsAnchorLiving, return.");
        b(paramCloseLoadingDialog);
        GuildLiveToast.a(2131890481);
        return;
      }
      a(paramQQGuildLiveRoomStartParams, paramBundle, paramCloseLoadingDialog);
      return;
    }
    QLog.i("QGL.QQGuildLiveLauncher", 1, "startParams invalid, return.");
    b(paramCloseLoadingDialog);
    GuildLiveToast.a(2131890449);
  }
  
  private static boolean a()
  {
    return ((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().b(), Boolean.valueOf(false))).booleanValue();
  }
  
  private static boolean a(String paramString)
  {
    IGProChannelInfo localIGProChannelInfo = QQGuildLiveStartParamsCache.a().getChannelInfo();
    return (localIGProChannelInfo != null) && (TextUtils.equals(paramString, localIGProChannelInfo.getChannelUin()));
  }
  
  private static void b(QQGuildLiveLauncher.CloseLoadingDialog paramCloseLoadingDialog)
  {
    if (paramCloseLoadingDialog != null) {
      paramCloseLoadingDialog.a();
    }
  }
  
  private static void b(@NonNull QQGuildLiveRoomStartParams paramQQGuildLiveRoomStartParams, Bundle paramBundle, boolean paramBoolean)
  {
    paramQQGuildLiveRoomStartParams = a(paramQQGuildLiveRoomStartParams);
    paramQQGuildLiveRoomStartParams.putExtra("guild_extra", paramBundle);
    paramQQGuildLiveRoomStartParams.putExtra("arg_from_float", paramBoolean);
    paramBundle = GuildLiveChannelFloatWrapper.class.getName();
    if (GuildFloatWindowManager.a.b(paramBundle)) {
      GuildFloatWindowManager.a.a(paramBundle);
    }
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).startGuildLiveActivity(QQGuildLiveRoomFragment.class, paramQQGuildLiveRoomStartParams);
  }
  
  private static boolean b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("系统通话");
    localArrayList.add("音视频通话");
    localArrayList.add("频道通话");
    return GuildAVPriorityManager.a("频道观看直播", localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.QQGuildLiveLauncher
 * JD-Core Version:    0.7.0.1
 */