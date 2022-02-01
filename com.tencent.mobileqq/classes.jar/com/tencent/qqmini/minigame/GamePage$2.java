package com.tencent.qqmini.minigame;

import com.tencent.qqmini.minigame.ui.VConsoleDragView;
import com.tencent.qqmini.minigame.utils.VConsoleLogManager;

class GamePage$2
  implements Runnable
{
  GamePage$2(GamePage paramGamePage, VConsoleDragView paramVConsoleDragView) {}
  
  public void run()
  {
    if (!GamePage.access$100(this.this$0))
    {
      GamePage.access$200(this.this$0);
      GamePage.access$400(this.this$0).updateVconsoleView(GamePage.access$300(this.this$0), this.val$dragView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage.2
 * JD-Core Version:    0.7.0.1
 */