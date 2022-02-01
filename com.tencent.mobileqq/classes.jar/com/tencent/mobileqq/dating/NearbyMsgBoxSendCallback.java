package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.nearby.NearbyConstants;

public class NearbyMsgBoxSendCallback
  implements IMsgUpdateCallback
{
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean d(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    if (paramAIOContext.O().a == 1001) {
      ((NearbyHandler)paramAIOContext.a().getBusinessHandler(NearbyConstants.a)).a(paramChatMessage, 1);
    }
    return false;
  }
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyMsgBoxSendCallback
 * JD-Core Version:    0.7.0.1
 */