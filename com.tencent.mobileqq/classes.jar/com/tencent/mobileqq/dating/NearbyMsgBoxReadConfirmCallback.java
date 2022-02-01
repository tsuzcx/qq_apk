package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.nearby.NearbyConstants;
import java.util.Iterator;
import java.util.List;

public class NearbyMsgBoxReadConfirmCallback
  implements IReadConfirmCallback
{
  public void a(AIOContext paramAIOContext) {}
  
  public void a(AIOContext paramAIOContext, List<ChatMessage> paramList, int paramInt)
  {
    if (paramAIOContext.O().a == 1001)
    {
      if (paramInt <= 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.next();
        if (!localChatMessage.isread) {
          ((NearbyHandler)paramAIOContext.a().getBusinessHandler(NearbyConstants.a)).a(localChatMessage, 2);
        }
      }
    }
  }
  
  public void b(AIOContext paramAIOContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyMsgBoxReadConfirmCallback
 * JD-Core Version:    0.7.0.1
 */