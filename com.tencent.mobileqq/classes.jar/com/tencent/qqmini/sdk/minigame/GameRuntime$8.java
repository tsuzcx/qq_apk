package com.tencent.qqmini.sdk.minigame;

import bgnd;
import bgtj;

public class GameRuntime$8
  implements Runnable
{
  public GameRuntime$8(bgtj parambgtj) {}
  
  public void run()
  {
    if (bgtj.a(this.this$0) != null)
    {
      bgtj.a(this.this$0, new bgnd(bgtj.a(this.this$0)));
      bgtj.a(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.8
 * JD-Core Version:    0.7.0.1
 */