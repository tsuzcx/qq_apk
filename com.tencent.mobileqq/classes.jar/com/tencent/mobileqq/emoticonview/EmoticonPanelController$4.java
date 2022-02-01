package com.tencent.mobileqq.emoticonview;

import android.view.GestureDetector;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

class EmoticonPanelController$4
  implements Runnable
{
  EmoticonPanelController$4(EmoticonPanelController paramEmoticonPanelController, TopGestureLayout paramTopGestureLayout, GestureDetector paramGestureDetector) {}
  
  public void run()
  {
    this.val$topGestureLayout.removeView(((StickerGestureDetector)this.val$gDetector).popupEmo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController.4
 * JD-Core Version:    0.7.0.1
 */