package com.tencent.qqmini.sdk.minigame;

import bgtj;
import bgxl;
import bgxp;
import bgyd;
import bgyg;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;

public class GameRuntime$6
  implements Runnable
{
  public GameRuntime$6(bgtj parambgtj) {}
  
  public void run()
  {
    bgtj.a(this.this$0).a();
    bgyg.a(bgtj.a(this.this$0), "1", null, "load", null);
    bgxl.a("2load", null, null, bgtj.a(this.this$0));
    bgyd.a(bgtj.a(this.this$0), 1007, "1");
    bgtj.a(this.this$0).getGameLauncher().launchGame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.6
 * JD-Core Version:    0.7.0.1
 */