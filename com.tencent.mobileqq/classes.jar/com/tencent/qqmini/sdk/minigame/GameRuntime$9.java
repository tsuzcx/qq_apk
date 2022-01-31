package com.tencent.qqmini.sdk.minigame;

import bgnd;
import bgtj;

public class GameRuntime$9
  implements Runnable
{
  public GameRuntime$9(bgtj parambgtj) {}
  
  public void run()
  {
    if (bgtj.a(this.this$0) != null)
    {
      bgtj.a(this.this$0).dismiss();
      bgtj.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.9
 * JD-Core Version:    0.7.0.1
 */