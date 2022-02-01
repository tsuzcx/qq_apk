package com.tencent.mobileqq.kandian.base.view.widget;

import android.widget.ImageView;
import android.widget.TextView;

class CaptureOperateTouchLayout$1
  implements CaptureOperateTouchLayout.IndicatorLongPressCallback
{
  CaptureOperateTouchLayout$1(CaptureOperateTouchLayout paramCaptureOperateTouchLayout, TextView paramTextView, VideoMeasureScaleView paramVideoMeasureScaleView, ImageView paramImageView) {}
  
  public void a()
  {
    this.a.setText(2131915490);
    this.b.setVisibility(0);
    int i = CaptureOperateTouchLayout.a(this.d);
    CaptureOperateTouchLayout.a(this.d, this.c.getX() / CaptureOperateTouchLayout.b(this.d));
    CaptureOperateTouchLayout.a(this.d, i);
    if (CaptureOperateTouchLayout.c(this.d) != null)
    {
      CaptureOperateTouchLayout.OnCaptureOperateCallback localOnCaptureOperateCallback = CaptureOperateTouchLayout.c(this.d);
      CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.d;
      localOnCaptureOperateCallback.a(i, CaptureOperateTouchLayout.b(localCaptureOperateTouchLayout, CaptureOperateTouchLayout.d(localCaptureOperateTouchLayout)));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (CaptureOperateTouchLayout.c(this.d) != null) {
      CaptureOperateTouchLayout.c(this.d).a();
    }
    this.a.setText(2131915368);
    this.b.setVisibility(4);
  }
  
  public void b()
  {
    this.a.setText(2131915523);
  }
  
  public void c()
  {
    this.b.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.CaptureOperateTouchLayout.1
 * JD-Core Version:    0.7.0.1
 */