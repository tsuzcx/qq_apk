package com.tencent.mobileqq.minigame.ui;

class GameActivity$6
  implements Runnable
{
  GameActivity$6(GameActivity paramGameActivity) {}
  
  public void run()
  {
    if (GameActivity.access$900(this.this$0) != null)
    {
      GameActivity.access$1000(this.this$0);
      return;
    }
    this.this$0.tryStartGameWhenReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.6
 * JD-Core Version:    0.7.0.1
 */