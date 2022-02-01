package com.tencent.mobileqq.guild.message.data;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildRoamMessageHandler;
import com.tencent.mobileqq.guild.message.base.AbsGuildMessageManagerCallback;
import com.tencent.mobileqq.guild.message.guest.IGuildGuestHandler;
import com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateUpdateMsgInfoUtil;
import com.tencent.mobileqq.guild.navigatebar.GuildAioNavigateBarManager;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.navigatebar.BaseInfoManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class GuildMessageManagerCallback
  extends AbsGuildMessageManagerCallback
{
  public BaseInfoManager a(BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    return (BaseInfoManager)paramAddMessageContext.j;
  }
  
  public String a(MessageRecord paramMessageRecord)
  {
    return ((IPicHelper)QRoute.api(IPicHelper.class)).getMsgSummaryForAnimationPic((MessageForPic)paramMessageRecord);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    GuildAioMsgNavigateUpdateMsgInfoUtil.a((QQAppInterface)paramAppRuntime, paramString, paramMessageInfo, paramMessageRecord, paramBoolean);
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    Object localObject = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
    paramBoolean = ((IGuildMessageUtilsApi)localObject).isGuest(paramString);
    localObject = ((IGuildMessageUtilsApi)localObject).getGuildIdFromAio(paramString);
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pullMsgFromUserRefresh. guildId: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", channelId: ");
      localStringBuilder.append(paramString);
      QLog.i("GuildMessageManagerCallback", 1, localStringBuilder.toString());
      return ((IGuildGuestHandler)((AppInterface)paramAppRuntime).getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildGuestHandlerName())).a((String)localObject, paramString, paramLong1, paramLong2, paramBundle);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reqPullRoamMsg. guildId: ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", channelId: ");
    localStringBuilder.append(paramString);
    QLog.i("GuildMessageManagerCallback", 1, localStringBuilder.toString());
    return ((IGuildRoamMessageHandler)((AppInterface)paramAppRuntime).getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildRoamMsgHandlerName())).reqPullRoamMsg(paramString, paramLong1, paramLong2, paramBundle);
  }
  
  public GuildAioNavigateBarManager b(AppInterface paramAppInterface)
  {
    return (GuildAioNavigateBarManager)paramAppInterface.getManager(QQManagerFactory.GUILD_AIO_NAVIGATE_BAR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.data.GuildMessageManagerCallback
 * JD-Core Version:    0.7.0.1
 */