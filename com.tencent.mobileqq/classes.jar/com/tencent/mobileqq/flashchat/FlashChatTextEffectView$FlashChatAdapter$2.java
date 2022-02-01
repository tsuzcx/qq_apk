package com.tencent.mobileqq.flashchat;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.Callback;
import mqq.os.MqqHandler;

class FlashChatTextEffectView$FlashChatAdapter$2
  implements ArkAppView.Callback
{
  FlashChatTextEffectView$FlashChatAdapter$2(FlashChatTextEffectView.FlashChatAdapter paramFlashChatAdapter, FlashChatTextEffectView.MyViewHolder paramMyViewHolder, int paramInt) {}
  
  public void a() {}
  
  public void b()
  {
    FlashChatTextEffectView.a(this.a);
    Message localMessage = Message.obtain();
    localMessage.obj = this.a;
    int i = this.b;
    localMessage.what = i;
    if (i < FlashChatTextEffectView.j().length)
    {
      FlashChatTextEffectView.FlashChatAdapter.a(this.c).sendMessageDelayed(localMessage, FlashChatTextEffectView.j()[this.b]);
      return;
    }
    FlashChatTextEffectView.FlashChatAdapter.a(this.c).sendMessageDelayed(localMessage, 7000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView.FlashChatAdapter.2
 * JD-Core Version:    0.7.0.1
 */