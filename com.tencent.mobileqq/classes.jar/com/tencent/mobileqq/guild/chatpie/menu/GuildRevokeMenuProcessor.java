package com.tencent.mobileqq.guild.chatpie.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildRevokeMessageHandler;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;

public class GuildRevokeMenuProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  private static String c = "GuildRevokeMenuProcessor";
  
  public GuildRevokeMenuProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    ((IGuildRevokeMessageHandler)this.a.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildRevokeMessageHandlerName())).a(paramChatMessage);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    if (paramChatMessage != null)
    {
      if (paramChatMessage.shmsgseq == 0L) {
        return;
      }
      paramBundle = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
      boolean bool1 = paramChatMessage.senderuin.equals(paramBundle);
      long l = ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(paramChatMessage);
      boolean bool2 = ((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).isCreatorOrAdmin(this.a, String.valueOf(l));
      boolean bool3 = ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(paramChatMessage);
      if ((!bool3) && ((bool1) || (bool2)))
      {
        paramQQCustomMenu.a(2131438943, paramContext.getString(2131891960), 2130840748);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramQQCustomMenu = c;
        paramContext = new StringBuilder();
        paramContext.append("doAddMenu. isLocalOnly: ");
        paramContext.append(bool3);
        paramContext.append(", isSentBySelf: ");
        paramContext.append(bool1);
        paramContext.append(", isCreatorOrAdmin: ");
        paramContext.append(bool2);
        QLog.d(paramQQCustomMenu, 2, paramContext.toString());
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return 2131438943 == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.menu.GuildRevokeMenuProcessor
 * JD-Core Version:    0.7.0.1
 */