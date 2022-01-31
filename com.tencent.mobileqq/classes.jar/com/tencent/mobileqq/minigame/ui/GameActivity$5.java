package com.tencent.mobileqq.minigame.ui;

import android.widget.TextView;

class GameActivity$5
  implements Runnable
{
  GameActivity$5(GameActivity paramGameActivity, String paramString) {}
  
  public void run()
  {
    if (GameActivity.access$200(this.this$0)) {
      if (GameActivity.access$300(this.this$0) != null) {
        GameActivity.access$300(this.this$0).setText(this.val$msg);
      }
    }
    for (;;)
    {
      GameActivity.access$502(this.this$0, this.val$msg);
      return;
      if (GameActivity.access$400(this.this$0) != null) {
        GameActivity.access$400(this.this$0).setText(this.val$msg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.5
 * JD-Core Version:    0.7.0.1
 */