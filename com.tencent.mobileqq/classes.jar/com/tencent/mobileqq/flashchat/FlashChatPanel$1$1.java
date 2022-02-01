package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.data.MessageForArkFlashChat;

class FlashChatPanel$1$1
  implements Runnable
{
  FlashChatPanel$1$1(FlashChatPanel.1 param1) {}
  
  public void run()
  {
    if (this.a.b != null) {
      this.a.b.stopAnim();
    }
    this.a.c.playAnim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanel.1.1
 * JD-Core Version:    0.7.0.1
 */