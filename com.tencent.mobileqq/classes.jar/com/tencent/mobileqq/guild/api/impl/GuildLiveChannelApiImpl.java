package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.live.QQGuildLiveLauncher;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.fragment.push.QQGuildLivePushMsgHandler;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.message.MessageRecordForGuildWelcome;
import com.tencent.mobileqq.guild.util.GuildAVPriorityManager;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GuildLiveChannelApiImpl
  implements IGuildLiveChannelApi
{
  private static final String TAG = "GuildLiveChannelApiImpl";
  private static MessageRecordForGuildWelcome securityMsg;
  
  public boolean checkGuildLiveAvBusinessFocus(String paramString)
  {
    return GuildAVPriorityManager.b(paramString);
  }
  
  public int checkGuildLiveState()
  {
    QQGuildLiveRoomUiData localQQGuildLiveRoomUiData = QQGuildLiveRoomUiData.a();
    if (((Boolean)localQQGuildLiveRoomUiData.c().getValue()).booleanValue())
    {
      if (((Boolean)localQQGuildLiveRoomUiData.b().getValue()).booleanValue()) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  @RequiresApi(api=16)
  public void cleanLiveChannelAIOBg(ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup = paramViewGroup;
    if (paramViewGroup.getId() == 2131434624) {
      return;
    }
    while (localViewGroup.getId() != 2131434624)
    {
      paramViewGroup = localViewGroup.getBackground();
      if (paramViewGroup != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cleanLiveChannelAIOBg  bg = ");
        localStringBuilder.append(paramViewGroup.getClass().getName());
        localStringBuilder.append(", --- id = ");
        localStringBuilder.append(localViewGroup.getId());
        localStringBuilder.append(", ---view = ");
        localStringBuilder.append(localViewGroup.getClass().getName());
        QLog.d("GuildLiveChannelApiImpl", 4, localStringBuilder.toString());
        localViewGroup.setBackground(null);
      }
      if (!(localViewGroup.getParent() instanceof ViewGroup)) {
        break;
      }
      localViewGroup = (ViewGroup)localViewGroup.getParent();
    }
  }
  
  public ChatMessage createSecurityMsg(Context paramContext)
  {
    Activity localActivity = (Activity)paramContext;
    if (localActivity == null) {
      return null;
    }
    String str2 = QQGuildUtil.e();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramContext.getApplicationContext().getString(2131890423);
    }
    if (localActivity.getIntent().getBooleanExtra("arg_from_float", false))
    {
      paramContext = securityMsg;
      if (paramContext != null)
      {
        paramContext.showMsg = str1;
        return paramContext;
      }
    }
    paramContext = new MessageRecordForGuildWelcome();
    paramContext.showMsg = str1;
    paramContext.shmsgseq = 0L;
    paramContext.saveExtInfoToExtStr("GUILD_MSG_LOCAL_ONLY", "1");
    paramContext.init("", "", "", "", MessageCache.c(), -4028, 10014, 0L);
    securityMsg = paramContext;
    return securityMsg;
  }
  
  public Intent getLiveChannelIntent()
  {
    return QQGuildLiveLauncher.a(QQGuildLiveStartParamsCache.a());
  }
  
  public Intent getLiveChannelIntent(Context paramContext, LaunchGuildChatPieParam paramLaunchGuildChatPieParam)
  {
    paramContext = paramLaunchGuildChatPieParam.b;
    paramContext = ((IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getChannelInfo(paramContext);
    if (paramContext != null)
    {
      if (paramContext.getType() != 5) {
        return null;
      }
      return QQGuildLivePushMsgHandler.a(paramContext.getChannelUin());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildLiveChannelApiImpl
 * JD-Core Version:    0.7.0.1
 */