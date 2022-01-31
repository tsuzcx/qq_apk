package com.tencent.qqmini.sdk.minigame;

import beuy;
import beyq;
import beyu;
import bezi;
import bezl;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;

public class GameRuntime$6
  implements Runnable
{
  public GameRuntime$6(beuy parambeuy) {}
  
  public void run()
  {
    beuy.a(this.this$0).a();
    bezl.a(beuy.a(this.this$0), "1", null, "load", null);
    beyq.a("2load", null, null, beuy.a(this.this$0));
    bezi.a(beuy.a(this.this$0), 1007, "1");
    beuy.a(this.this$0).getGameLauncher().launchGame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.6
 * JD-Core Version:    0.7.0.1
 */