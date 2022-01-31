package com.tencent.qqmini.sdk.minigame;

import bgtj;
import bgwp;
import com.tencent.mobileqq.triton.sdk.ITTEngine;

public class GameRuntime$4
  implements Runnable
{
  public GameRuntime$4(bgtj parambgtj) {}
  
  public void run()
  {
    bgwp.a().b(bgtj.a(this.this$0));
    bgtj.a(this.this$0).onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.4
 * JD-Core Version:    0.7.0.1
 */