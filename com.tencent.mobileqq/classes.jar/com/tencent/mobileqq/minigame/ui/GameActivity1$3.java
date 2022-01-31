package com.tencent.mobileqq.minigame.ui;

import amgr;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class GameActivity1$3
  extends amgr
{
  GameActivity1$3(GameActivity1 paramGameActivity1) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    QLog.e("qqBaseActivity", 1, "[ColorNote exit]");
    this.this$0.doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1.3
 * JD-Core Version:    0.7.0.1
 */