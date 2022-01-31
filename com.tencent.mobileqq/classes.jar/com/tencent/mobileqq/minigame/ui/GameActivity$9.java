package com.tencent.mobileqq.minigame.ui;

import alud;
import android.widget.Toast;

class GameActivity$9
  implements Runnable
{
  GameActivity$9(GameActivity paramGameActivity, int paramInt) {}
  
  public void run()
  {
    if (this.val$retCode == 104)
    {
      GameActivity.access$1400(this.this$0);
      return;
    }
    Toast.makeText(this.this$0, alud.a(2131705398) + this.val$retCode + ")", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.9
 * JD-Core Version:    0.7.0.1
 */