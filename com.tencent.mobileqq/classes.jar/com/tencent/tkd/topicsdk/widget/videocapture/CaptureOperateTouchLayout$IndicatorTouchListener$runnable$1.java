package com.tencent.tkd.topicsdk.widget.videocapture;

import android.widget.Scroller;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class CaptureOperateTouchLayout$IndicatorTouchListener$runnable$1
  implements Runnable
{
  CaptureOperateTouchLayout$IndicatorTouchListener$runnable$1(CaptureOperateTouchLayout.IndicatorTouchListener paramIndicatorTouchListener) {}
  
  public final void run()
  {
    CaptureOperateTouchLayout.a(this.this$0.a, true);
    CaptureOperateTouchLayout.b(this.this$0.a).abortAnimation();
    CaptureOperateTouchLayout.IndicatorTouchListener.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.IndicatorTouchListener.runnable.1
 * JD-Core Version:    0.7.0.1
 */