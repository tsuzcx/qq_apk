package com.tencent.mobileqq.emosm.web;

import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerRecallListener;

class MessengerService$2
  implements EmojiStickerManager.StickerRecallListener
{
  MessengerService$2(MessengerService paramMessengerService) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a.a != null) {
      EmojiStickerManager.a().a(this.a.a, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.2
 * JD-Core Version:    0.7.0.1
 */