package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.qphone.base.util.QLog;

public class PerfRelativeLayout
  extends RelativeLayout
{
  private OnDrawCompleteListener a;
  
  public PerfRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public PerfRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PerfRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    paramCanvas = this.a;
    if (paramCanvas != null) {
      paramCanvas.b();
    }
    if (QLog.isDevelopLevel())
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("dispatchDraw, ");
      paramCanvas.append(this.a);
      QLog.i("PerfRelativeLayout", 4, paramCanvas.toString());
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    paramCanvas = this.a;
    if (paramCanvas != null) {
      paramCanvas.b();
    }
    if (QLog.isDevelopLevel())
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("draw, ");
      paramCanvas.append(this.a);
      QLog.i("PerfRelativeLayout", 4, paramCanvas.toString());
    }
  }
  
  public void setOnDrawCompleteListener(OnDrawCompleteListener paramOnDrawCompleteListener)
  {
    this.a = paramOnDrawCompleteListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PerfRelativeLayout
 * JD-Core Version:    0.7.0.1
 */