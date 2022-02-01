package com.tencent.mobileqq.guild.chatpie.sender;

import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler.SendTextMsgParams;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class GuildMsgSendCallback
  implements ISendMessageCallback
{
  private IGuildSendMessageHandler.SendTextMsgParams a(String paramString1, String paramString2, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    IGuildSendMessageHandler.SendTextMsgParams localSendTextMsgParams = new IGuildSendMessageHandler.SendTextMsgParams();
    localSendTextMsgParams.b = paramString1;
    localSendTextMsgParams.c = paramString2;
    localSendTextMsgParams.d = paramSendLogicParam.a();
    localSendTextMsgParams.e = paramArrayList;
    localSendTextMsgParams.g = paramSendLogicParam.b().g;
    localSendTextMsgParams.f = paramSendLogicParam.b().a;
    localSendTextMsgParams.h = paramSendLogicParam.b().w;
    localSendTextMsgParams.i = paramSendLogicParam.b().x;
    return localSendTextMsgParams;
  }
  
  public void afterMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean beforeMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    return false;
  }
  
  public boolean onMessageSending(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    if (paramAIOContext.O().a == 10014)
    {
      String str = paramAIOContext.O().b;
      paramSendLogicParam = a(((IGPSService)paramAIOContext.a().getRuntimeService(IGPSService.class, "")).getGuildIdOf(str), str, paramSendLogicParam, paramArrayList);
      ((IGuildSendMessageHandler)paramAIOContext.a().getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).a(paramAIOContext.a(), paramSendLogicParam);
      paramSendLogicParam = (PhotoListPanel)paramAIOContext.q().d(4);
      int i;
      if (paramSendLogicParam != null) {
        i = paramSendLogicParam.getSelectedPhotoCount();
      } else {
        i = 0;
      }
      int j;
      if (paramSendLogicParam != null) {
        j = paramSendLogicParam.getSelectedVideoCount();
      } else {
        j = 0;
      }
      if ((i + j > 0) && (paramSendLogicParam != null))
      {
        paramSendLogicParam.a(false, null);
        ((PhotoListHelper)paramAIOContext.a(7)).b(paramAIOContext.hashCode());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.sender.GuildMsgSendCallback
 * JD-Core Version:    0.7.0.1
 */