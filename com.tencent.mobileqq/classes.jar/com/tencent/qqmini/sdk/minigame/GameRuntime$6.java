package com.tencent.qqmini.sdk.minigame;

import beuh;
import bexz;
import beyd;
import beyr;
import beyu;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;

public class GameRuntime$6
  implements Runnable
{
  public GameRuntime$6(beuh parambeuh) {}
  
  public void run()
  {
    beuh.a(this.this$0).a();
    beyu.a(beuh.a(this.this$0), "1", null, "load", null);
    bexz.a("2load", null, null, beuh.a(this.this$0));
    beyr.a(beuh.a(this.this$0), 1007, "1");
    beuh.a(this.this$0).getGameLauncher().launchGame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.6
 * JD-Core Version:    0.7.0.1
 */