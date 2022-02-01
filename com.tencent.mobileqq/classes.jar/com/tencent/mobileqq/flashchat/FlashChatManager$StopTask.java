package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.data.MessageForArkFlashChat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class FlashChatManager$StopTask
  implements Runnable
{
  public Long a;
  public CopyOnWriteArrayList<MessageForArkFlashChat> a;
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject == null) {
      return;
    }
    localObject = ((CopyOnWriteArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)((Iterator)localObject).next();
      Long localLong = this.jdField_a_of_type_JavaLangLong;
      if ((localLong == null) || (localLong.longValue() != localMessageForArkFlashChat.uniseq)) {
        localMessageForArkFlashChat.stopAnim();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager.StopTask
 * JD-Core Version:    0.7.0.1
 */