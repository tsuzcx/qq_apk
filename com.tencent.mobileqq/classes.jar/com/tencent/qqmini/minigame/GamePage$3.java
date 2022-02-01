package com.tencent.qqmini.minigame;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

class GamePage$3
  implements Runnable
{
  GamePage$3(GamePage paramGamePage, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    GamePage.access$500(this.this$0);
    if ((GamePage.access$600(this.this$0) != null) && (!TextUtils.isEmpty(this.val$debuggerTxt))) {
      GamePage.access$600(this.this$0).setText(this.val$debuggerTxt);
    }
    boolean bool = TextUtils.isEmpty(this.val$debuggerToast);
    int i = 0;
    if (!bool) {
      Toast.makeText(GamePage.access$000(this.this$0), this.val$debuggerToast, 0).show();
    }
    if (GamePage.access$700(this.this$0) != null)
    {
      View localView = GamePage.access$700(this.this$0);
      if (!this.val$showBreakPoint) {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage.3
 * JD-Core Version:    0.7.0.1
 */