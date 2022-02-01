package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

public class HotChatReadConfirmCallback
  implements IReadConfirmCallback
{
  public void a(AIOContext paramAIOContext)
  {
    if (paramAIOContext.O().a == 1) {
      ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).setReadedForHCTopic(paramAIOContext.a(), paramAIOContext.O().b);
    }
  }
  
  public void a(AIOContext paramAIOContext, List<ChatMessage> paramList, int paramInt) {}
  
  public void b(AIOContext paramAIOContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.HotChatReadConfirmCallback
 * JD-Core Version:    0.7.0.1
 */