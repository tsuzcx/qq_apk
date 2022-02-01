package com.tencent.mobileqq.werewolves;

import android.os.Handler;

class WereWolvesLoadingView$1
  implements Runnable
{
  WereWolvesLoadingView$1(WereWolvesLoadingView paramWereWolvesLoadingView) {}
  
  public void run()
  {
    if (this.this$0.i >= 100)
    {
      this.this$0.setProgress(100);
      this.this$0.h.removeCallbacks(this);
      return;
    }
    WereWolvesLoadingView localWereWolvesLoadingView = this.this$0;
    localWereWolvesLoadingView.i += 3;
    if (this.this$0.i > 100) {
      this.this$0.i = 100;
    }
    localWereWolvesLoadingView = this.this$0;
    localWereWolvesLoadingView.setProgress(localWereWolvesLoadingView.i);
    this.this$0.h.postDelayed(this.this$0.j, 40L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WereWolvesLoadingView.1
 * JD-Core Version:    0.7.0.1
 */