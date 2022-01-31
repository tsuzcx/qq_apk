package com.tencent.qqmini.sdk.minigame;

import bdnw;
import bdoz;
import bdsc;
import bdsg;
import bdsh;
import bdsu;
import bdsx;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;

public class GameRuntime$7
  implements Runnable
{
  public GameRuntime$7(bdoz parambdoz) {}
  
  public void run()
  {
    bdoz.a(this.this$0).a();
    bdsx.a(bdoz.a(this.this$0), "1", null, "load", null);
    bdsc.a("2load", null, null, bdoz.a(this.this$0));
    bdoz.a(this.this$0, 1);
    bdsu.a(bdoz.a(this.this$0), 1007, "1");
    int i = bdoz.a(this.this$0).getGameLauncher().launchGame();
    if (i == 0)
    {
      bdsu.a(bdoz.a(this.this$0), 1008, "1");
      bdsh.a(bdoz.a(this.this$0), 0);
      return;
    }
    bdsx.a(bdoz.a(this.this$0), "1", null, "show_fail", "load_pkg_fail");
    bdsc.a("2launch_fail", "load_pkg_fail", null, bdoz.a(this.this$0));
    bdnw.d("GameRuntime", "launchGame " + i);
    bdsh.a(bdoz.a(this.this$0), 512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.7
 * JD-Core Version:    0.7.0.1
 */