package com.tencent.mobileqq.flashchat;

import apgy;
import com.tencent.mobileqq.data.MessageForArkFlashChat;

final class FlashChatTextEffectView$2
  implements Runnable
{
  FlashChatTextEffectView$2(apgy paramapgy) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.a != null))
    {
      this.a.a.stopAnim();
      this.a.a.playAnim();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView.2
 * JD-Core Version:    0.7.0.1
 */