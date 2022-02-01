package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class RoundCornerRelativeLayout
  extends RelativeLayout
{
  private Path a;
  private RectF b;
  private float c;
  private PaintFlagsDrawFilter d;
  private int e;
  private int f;
  
  public RoundCornerRelativeLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new Path();
    this.b = new RectF();
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
    this.d = new PaintFlagsDrawFilter(0, 3);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    if ((this.e != getMeasuredWidth()) || (this.f != getMeasuredHeight()))
    {
      this.e = getMeasuredWidth();
      this.f = getMeasuredHeight();
      this.a.reset();
      this.b.set(0.0F, 0.0F, this.e, this.f);
      Path localPath = this.a;
      RectF localRectF = this.b;
      float f1 = this.c;
      localPath.addRoundRect(localRectF, f1, f1, Path.Direction.CW);
    }
    paramCanvas.setDrawFilter(this.d);
    paramCanvas.clipPath(this.a);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setRadius(float paramFloat)
  {
    this.c = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.RoundCornerRelativeLayout
 * JD-Core Version:    0.7.0.1
 */