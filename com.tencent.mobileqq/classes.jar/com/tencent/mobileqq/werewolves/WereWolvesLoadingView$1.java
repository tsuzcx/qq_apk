package com.tencent.mobileqq.werewolves;

import android.os.Handler;

class WereWolvesLoadingView$1
  implements Runnable
{
  WereWolvesLoadingView$1(WereWolvesLoadingView paramWereWolvesLoadingView) {}
  
  public void run()
  {
    if (this.this$0.b >= 100)
    {
      this.this$0.setProgress(100);
      this.this$0.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
      return;
    }
    WereWolvesLoadingView localWereWolvesLoadingView = this.this$0;
    localWereWolvesLoadingView.b += 3;
    if (this.this$0.b > 100) {
      this.this$0.b = 100;
    }
    this.this$0.setProgress(this.this$0.b);
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 40L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WereWolvesLoadingView.1
 * JD-Core Version:    0.7.0.1
 */