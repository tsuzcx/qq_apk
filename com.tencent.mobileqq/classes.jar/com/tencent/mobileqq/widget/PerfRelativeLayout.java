package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import aqhc;
import com.tencent.qphone.base.util.QLog;

public class PerfRelativeLayout
  extends RelativeLayout
{
  private aqhc a;
  
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
    if (this.a != null) {
      this.a.a();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("PerfRelativeLayout", 4, "dispatchDraw, " + this.a);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.a != null) {
      this.a.a();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("PerfRelativeLayout", 4, "draw, " + this.a);
    }
  }
  
  public void setOnDrawCompleteListener(aqhc paramaqhc)
  {
    this.a = paramaqhc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PerfRelativeLayout
 * JD-Core Version:    0.7.0.1
 */