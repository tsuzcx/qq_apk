package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;

class GameActivity1$2
  implements OnColorNoteAnimFinishListener
{
  GameActivity1$2(GameActivity1 paramGameActivity1) {}
  
  public void onColorNoteAnimFinish()
  {
    this.this$0.doOnBackPressed();
    this.this$0.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1.2
 * JD-Core Version:    0.7.0.1
 */