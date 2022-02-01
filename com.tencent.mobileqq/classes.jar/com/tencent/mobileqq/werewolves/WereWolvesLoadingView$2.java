package com.tencent.mobileqq.werewolves;

import android.os.Handler;

class WereWolvesLoadingView$2
  implements Runnable
{
  WereWolvesLoadingView$2(WereWolvesLoadingView paramWereWolvesLoadingView) {}
  
  public void run()
  {
    if (this.this$0.jdField_b_of_type_Int <= 90)
    {
      if (this.this$0.jdField_b_of_type_Boolean) {
        return;
      }
      WereWolvesLoadingView localWereWolvesLoadingView = this.this$0;
      localWereWolvesLoadingView.jdField_b_of_type_Int += 1;
      localWereWolvesLoadingView = this.this$0;
      int i = localWereWolvesLoadingView.jdField_b_of_type_Int;
      localWereWolvesLoadingView.jdField_b_of_type_Int = (i + 1);
      localWereWolvesLoadingView.setProgress(i);
      i = (int)(this.this$0.jdField_b_of_type_Int * 2.222222F + 100.0F);
      this.this$0.a.postDelayed(this, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WereWolvesLoadingView.2
 * JD-Core Version:    0.7.0.1
 */