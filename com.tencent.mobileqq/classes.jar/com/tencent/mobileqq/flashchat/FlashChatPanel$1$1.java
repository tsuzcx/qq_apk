package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.data.MessageForArkFlashChat;

class FlashChatPanel$1$1
  implements Runnable
{
  FlashChatPanel$1$1(FlashChatPanel.1 param1) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.stopAnim();
    }
    this.a.b.playAnim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanel.1.1
 * JD-Core Version:    0.7.0.1
 */