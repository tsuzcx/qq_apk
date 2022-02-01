package com.tencent.mobileqq.werewolves;

import android.os.Handler;

class WereWolvesLoadingView$2
  implements Runnable
{
  WereWolvesLoadingView$2(WereWolvesLoadingView paramWereWolvesLoadingView) {}
  
  public void run()
  {
    if ((this.this$0.jdField_b_of_type_Int > 90) || (this.this$0.jdField_b_of_type_Boolean)) {
      return;
    }
    WereWolvesLoadingView localWereWolvesLoadingView1 = this.this$0;
    localWereWolvesLoadingView1.jdField_b_of_type_Int += 1;
    localWereWolvesLoadingView1 = this.this$0;
    WereWolvesLoadingView localWereWolvesLoadingView2 = this.this$0;
    int i = localWereWolvesLoadingView2.jdField_b_of_type_Int;
    localWereWolvesLoadingView2.jdField_b_of_type_Int = (i + 1);
    localWereWolvesLoadingView1.setProgress(i);
    i = (int)(2.222222F * this.this$0.jdField_b_of_type_Int + 100.0F);
    this.this$0.a.postDelayed(this, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WereWolvesLoadingView.2
 * JD-Core Version:    0.7.0.1
 */