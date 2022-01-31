package com.tencent.qqmini.sdk.minigame;

import bdoz;
import com.tencent.mobileqq.triton.sdk.ITTEngine;

public class GameRuntime$3
  implements Runnable
{
  public GameRuntime$3(bdoz parambdoz) {}
  
  public void run()
  {
    bdoz.a(this.this$0).onResume();
    bdoz.b(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.3
 * JD-Core Version:    0.7.0.1
 */