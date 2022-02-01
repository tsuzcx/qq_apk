package com.tencent.mobileqq.qqgift.countdown;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class CountDownController$1
  implements Runnable
{
  CountDownController$1(CountDownController paramCountDownController) {}
  
  public void run()
  {
    CountDownController.a(this.this$0);
    CountDownController.b(this.this$0);
    if (CountDownController.c(this.this$0).size() > 0) {
      CountDownController.d(this.this$0);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[enterRoom] key:");
      localStringBuilder.append(CountDownController.e(this.this$0));
      localStringBuilder.append(",mCountDownInfoMapSize:");
      localStringBuilder.append(CountDownController.c(this.this$0).size());
      QLog.i("CountDownControl", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.countdown.CountDownController.1
 * JD-Core Version:    0.7.0.1
 */