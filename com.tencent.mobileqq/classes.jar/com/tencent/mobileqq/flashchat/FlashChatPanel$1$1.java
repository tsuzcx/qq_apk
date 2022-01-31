package com.tencent.mobileqq.flashchat;

import arwf;
import com.tencent.mobileqq.data.MessageForArkFlashChat;

public class FlashChatPanel$1$1
  implements Runnable
{
  public FlashChatPanel$1$1(arwf paramarwf) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.stopAnim();
    }
    this.a.b.playAnim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanel.1.1
 * JD-Core Version:    0.7.0.1
 */