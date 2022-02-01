package com.tencent.qqmini.minigame;

import android.app.Activity;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Orientation;
import com.tencent.qqmini.minigame.ui.VConsoleDragView;
import com.tencent.qqmini.minigame.widget.GameNavigationBar;

class GamePage$1
  implements Runnable
{
  GamePage$1(GamePage paramGamePage) {}
  
  public void run()
  {
    int i;
    if ((GamePage.access$000(this.this$0) == GamePackage.Orientation.LANDSCAPE) && (GamePage.access$100(this.this$0) != GamePage.access$000(this.this$0))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    GamePage.access$102(this.this$0, GamePackage.Orientation.LANDSCAPE);
    if (GamePage.access$200(this.this$0) != null) {
      GamePage.access$200(this.this$0).requestLandscapeLayout();
    }
    if (GamePage.access$300(this.this$0) != null) {
      GamePage.access$300(this.this$0).requestLandscapeLayout();
    }
    if (GamePage.access$400(this.this$0) != null) {
      GamePage.access$400(this.this$0).setRequestedOrientation(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage.1
 * JD-Core Version:    0.7.0.1
 */