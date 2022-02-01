package com.tencent.mobileqq.structmsg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;

public class CountdownTextView
  extends TextView
{
  private CountDownTimer a = new CountDownTimer();
  private CountDownTimer.CountDownTimerListener b;
  
  public CountdownTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CountdownTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CountdownTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    CountDownTimer localCountDownTimer = this.a;
    if (localCountDownTimer != null) {
      localCountDownTimer.b(this.b);
    }
  }
  
  public void a(long paramLong, CountdownTextView.TimerCallback paramTimerCallback)
  {
    CountDownTimer localCountDownTimer = this.a;
    if (localCountDownTimer != null)
    {
      this.b = new CountdownTextView.1(this, paramLong, paramTimerCallback);
      localCountDownTimer.a(this.b);
    }
  }
  
  public CountDownTimer getCountDownTimer()
  {
    return this.a;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.widget.CountdownTextView
 * JD-Core Version:    0.7.0.1
 */