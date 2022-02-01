package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.data.MessageForArkFlashChat;

final class FlashChatTextEffectView$3
  implements Runnable
{
  FlashChatTextEffectView$3(FlashChatTextEffectView.MyViewHolder paramMyViewHolder) {}
  
  public void run()
  {
    FlashChatTextEffectView.MyViewHolder localMyViewHolder = this.a;
    if ((localMyViewHolder != null) && (localMyViewHolder.g != null)) {
      this.a.g.stopAnim();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView.3
 * JD-Core Version:    0.7.0.1
 */