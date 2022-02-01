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
    FlashChatTextEffectView.a(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$MyViewHolder);
    Message localMessage = Message.obtain();
    localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$MyViewHolder;
    int i = this.jdField_a_of_type_Int;
    localMessage.what = i;
    if (i < FlashChatTextEffectView.a().length)
    {
      FlashChatTextEffectView.FlashChatAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter).sendMessageDelayed(localMessage, FlashChatTextEffectView.a()[this.jdField_a_of_type_Int]);
      return;
    }
    FlashChatTextEffectView.FlashChatAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter).sendMessageDelayed(localMessage, 7000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView.FlashChatAdapter.2
 * JD-Core Version:    0.7.0.1
 */