package com.tencent.qqmini.minigame;

import com.tencent.qqmini.sdk.widget.MiniProgressDialog;

class GameRuntime$9
  implements Runnable
{
  GameRuntime$9(GameRuntime paramGameRuntime) {}
  
  public void run()
  {
    if (GameRuntime.access$1000(this.this$0) != null)
    {
      GameRuntime.access$1102(this.this$0, new MiniProgressDialog(GameRuntime.access$1000(this.this$0)));
      GameRuntime.access$1100(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.9
 * JD-Core Version:    0.7.0.1
 */