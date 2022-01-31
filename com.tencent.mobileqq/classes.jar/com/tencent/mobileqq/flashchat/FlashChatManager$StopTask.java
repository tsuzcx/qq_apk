package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.data.MessageForArkFlashChat;
import java.util.ArrayList;
import java.util.Iterator;

public final class FlashChatManager$StopTask
  implements Runnable
{
  public Long a;
  public ArrayList a;
  
  public FlashChatManager$StopTask(ArrayList paramArrayList, Long paramLong)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaLangLong = paramLong;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager.StopTask
 * JD-Core Version:    0.7.0.1
 */