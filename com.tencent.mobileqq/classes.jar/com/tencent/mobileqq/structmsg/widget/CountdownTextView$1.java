package com.tencent.mobileqq.structmsg.widget;

import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;

class CountdownTextView$1
  extends CountDownTimer.CountDownTimerListener
{
  CountdownTextView$1(CountdownTextView paramCountdownTextView, long paramLong, CountdownTextView.TimerCallback paramTimerCallback)
  {
    super(paramLong);
  }
  
  public void b()
  {
    CountdownTextView.TimerCallback localTimerCallback = this.a;
    if (localTimerCallback != null) {
      localTimerCallback.a();
    }
    this.b.a();
  }
  
  public void b(long paramLong)
  {
    CountdownTextView.TimerCallback localTimerCallback = this.a;
    if (localTimerCallback != null) {
      localTimerCallback.a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.widget.CountdownTextView.1
 * JD-Core Version:    0.7.0.1
 */