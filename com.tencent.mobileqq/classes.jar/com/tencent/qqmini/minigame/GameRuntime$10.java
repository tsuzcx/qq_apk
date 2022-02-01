package com.tencent.qqmini.minigame;

import com.tencent.qqmini.sdk.widget.MiniProgressDialog;

class GameRuntime$10
  implements Runnable
{
  GameRuntime$10(GameRuntime paramGameRuntime) {}
  
  public void run()
  {
    if (GameRuntime.access$1100(this.this$0) != null)
    {
      GameRuntime.access$1100(this.this$0).dismiss();
      GameRuntime.access$1102(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.10
 * JD-Core Version:    0.7.0.1
 */