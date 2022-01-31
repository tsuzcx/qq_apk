package com.tencent.mobileqq.minigame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.minigame.debug.QQDebugWebSocket;

class GameActivity$27
  implements View.OnClickListener
{
  GameActivity$27(GameActivity paramGameActivity) {}
  
  public void onClick(View paramView)
  {
    if (GameActivity.access$4500(this.this$0) != null) {
      GameActivity.access$4500(this.this$0).sendQuitDebugMsgInfo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.27
 * JD-Core Version:    0.7.0.1
 */