package com.tencent.mobileqq.emoticonview.api.impl;

import android.view.GestureDetector;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;

class EmosmServiceImpl$2
  implements Runnable
{
  EmosmServiceImpl$2(EmosmServiceImpl paramEmosmServiceImpl, TopGestureLayout paramTopGestureLayout, GestureDetector paramGestureDetector) {}
  
  public void run()
  {
    this.val$topGestureLayout.removeView(((StickerGestureDetector)this.val$gDetector).popupEmo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmosmServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */