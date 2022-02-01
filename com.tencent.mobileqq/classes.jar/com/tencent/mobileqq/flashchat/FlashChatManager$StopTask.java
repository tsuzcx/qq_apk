package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.data.MessageForArkFlashChat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class FlashChatManager$StopTask
  implements Runnable
{
  public CopyOnWriteArrayList<MessageForArkFlashChat> a;
  public Long b;
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((CopyOnWriteArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)((Iterator)localObject).next();
      Long localLong = this.b;
      if ((localLong == null) || (localLong.longValue() != localMessageForArkFlashChat.uniseq)) {
        localMessageForArkFlashChat.stopAnim();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager.StopTask
 * JD-Core Version:    0.7.0.1
 */