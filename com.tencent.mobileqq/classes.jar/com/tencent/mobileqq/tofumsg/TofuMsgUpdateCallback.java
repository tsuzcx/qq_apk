package com.tencent.mobileqq.tofumsg;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;

public class TofuMsgUpdateCallback
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
    if (paramAIOContext.a() != null) {
      ((ITofuManagerNew)paramAIOContext.a().getManager(QQManagerFactory.TOFU_NEW_MANAGER)).b(paramAIOContext.O());
    }
    return false;
  }
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuMsgUpdateCallback
 * JD-Core Version:    0.7.0.1
 */