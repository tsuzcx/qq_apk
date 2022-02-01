package com.tencent.mobileqq.replymsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class ForwardMsgManager
  implements Manager
{
  private ConcurrentHashMap<Long, ChatMessage> a = new ConcurrentHashMap();
  private QQAppInterface b;
  
  public ForwardMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  public ChatMessage a(long paramLong)
  {
    return (ChatMessage)this.a.get(Long.valueOf(paramLong));
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    this.a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
  }
  
  public ChatMessage b(long paramLong)
  {
    return (ChatMessage)this.a.remove(Long.valueOf(paramLong));
  }
  
  public void onDestroy()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.replymsg.ForwardMsgManager
 * JD-Core Version:    0.7.0.1
 */