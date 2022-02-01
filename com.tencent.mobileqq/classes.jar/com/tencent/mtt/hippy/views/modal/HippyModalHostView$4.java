package com.tencent.mtt.hippy.views.modal;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.FrameLayout;

class HippyModalHostView$4
  extends FrameLayout
{
  HippyModalHostView$4(HippyModalHostView paramHippyModalHostView, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((HippyModalHostView.access$300(this.this$0)) && (HippyModalHostView.mStatusBarHeight != -1) && (Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT < 23))
    {
      paramCanvas.save();
      paramCanvas.clipRect(0, 0, getMeasuredWidth(), HippyModalHostView.mStatusBarHeight);
      paramCanvas.drawColor(1073741824);
      paramCanvas.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.HippyModalHostView.4
 * JD-Core Version:    0.7.0.1
 */