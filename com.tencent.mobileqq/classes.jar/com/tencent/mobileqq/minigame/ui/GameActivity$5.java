package com.tencent.mobileqq.minigame.ui;

import android.widget.ProgressBar;
import android.widget.TextView;

class GameActivity$5
  implements Runnable
{
  GameActivity$5(GameActivity paramGameActivity, float paramFloat) {}
  
  public void run()
  {
    String str = (int)(this.val$progress * 100.0F) + "%";
    if (GameActivity.access$200(this.this$0)) {
      if (GameActivity.access$300(this.this$0) != null) {
        GameActivity.access$300(this.this$0).setText(str);
      }
    }
    for (;;)
    {
      GameActivity.access$502(this.this$0, str);
      if (GameActivity.access$600(this.this$0))
      {
        GameActivity.access$700(this.this$0).setProgress((int)(this.val$progress * 100.0F));
        GameActivity.access$800(this.this$0).setText(str);
      }
      return;
      if (GameActivity.access$400(this.this$0) != null) {
        GameActivity.access$400(this.this$0).setText(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.5
 * JD-Core Version:    0.7.0.1
 */