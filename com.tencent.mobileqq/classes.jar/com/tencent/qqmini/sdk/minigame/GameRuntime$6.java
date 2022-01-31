package com.tencent.qqmini.sdk.minigame;

import bgxq;
import bhbs;
import bhbw;
import bhck;
import bhcn;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;

public class GameRuntime$6
  implements Runnable
{
  public GameRuntime$6(bgxq parambgxq) {}
  
  public void run()
  {
    bgxq.a(this.this$0).a();
    bhcn.a(bgxq.a(this.this$0), "1", null, "load", null);
    bhbs.a("2load", null, null, bgxq.a(this.this$0));
    bhck.a(bgxq.a(this.this$0), 1007, "1");
    bgxq.a(this.this$0).getGameLauncher().launchGame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.6
 * JD-Core Version:    0.7.0.1
 */