package com.tencent.qqmini.minigame;

import com.tencent.qqmini.minigame.ui.VConsoleDragView;
import com.tencent.qqmini.minigame.utils.VConsoleLogManager;

class GamePage$3
  implements Runnable
{
  GamePage$3(GamePage paramGamePage, VConsoleDragView paramVConsoleDragView) {}
  
  public void run()
  {
    if (!GamePage.access$500(this.this$0))
    {
      GamePage.access$600(this.this$0);
      GamePage.access$800(this.this$0).updateVconsoleView(GamePage.access$700(this.this$0), this.val$dragView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage.3
 * JD-Core Version:    0.7.0.1
 */