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
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)localIterator.next();
        if ((this.jdField_a_of_type_JavaLangLong == null) || (this.jdField_a_of_type_JavaLangLong.longValue() != localMessageForArkFlashChat.uniseq)) {
          localMessageForArkFlashChat.stopAnim();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager.StopTask
 * JD-Core Version:    0.7.0.1
 */