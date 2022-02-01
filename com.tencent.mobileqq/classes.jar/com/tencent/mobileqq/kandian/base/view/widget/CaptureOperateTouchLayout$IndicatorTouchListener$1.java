package com.tencent.mobileqq.kandian.base.view.widget;

import android.widget.Scroller;

class CaptureOperateTouchLayout$IndicatorTouchListener$1
  implements Runnable
{
  CaptureOperateTouchLayout$IndicatorTouchListener$1(CaptureOperateTouchLayout.IndicatorTouchListener paramIndicatorTouchListener) {}
  
  public void run()
  {
    CaptureOperateTouchLayout.a(this.a.a, true);
    CaptureOperateTouchLayout.e(this.a.a).abortAnimation();
    CaptureOperateTouchLayout.IndicatorTouchListener.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.CaptureOperateTouchLayout.IndicatorTouchListener.1
 * JD-Core Version:    0.7.0.1
 */