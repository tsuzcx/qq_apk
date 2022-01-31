package com.tencent.mobileqq.minigame.ui;

import amgq;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class GameActivity$24
  extends amgq
{
  GameActivity$24(GameActivity paramGameActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    QLog.e("[minigame] GameActivity", 1, "[ColorNote exit]");
    if (this.this$0.doNotMoveTaskToBackThisTime)
    {
      this.this$0.doNotMoveTaskToBackThisTime = false;
      return;
    }
    this.this$0.doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.24
 * JD-Core Version:    0.7.0.1
 */