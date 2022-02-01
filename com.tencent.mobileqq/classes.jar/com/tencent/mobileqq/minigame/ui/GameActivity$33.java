package com.tencent.mobileqq.minigame.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

class GameActivity$33
  implements Runnable
{
  GameActivity$33(GameActivity paramGameActivity, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    GameActivity.access$4600(this.this$0);
    if ((GameActivity.access$4700(this.this$0) != null) && (!TextUtils.isEmpty(this.val$debuggerTxt))) {
      GameActivity.access$4700(this.this$0).setText(this.val$debuggerTxt);
    }
    if (!TextUtils.isEmpty(this.val$debuggerToast)) {
      Toast.makeText(this.this$0, this.val$debuggerToast, 0).show();
    }
    View localView;
    if (GameActivity.access$4800(this.this$0) != null)
    {
      localView = GameActivity.access$4800(this.this$0);
      if (!this.val$showBreakPoint) {
        break label99;
      }
    }
    for (;;)
    {
      localView.setVisibility(i);
      return;
      label99:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.33
 * JD-Core Version:    0.7.0.1
 */