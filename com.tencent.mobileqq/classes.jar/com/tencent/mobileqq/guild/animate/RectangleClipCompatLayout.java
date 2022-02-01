package com.tencent.mobileqq.guild.animate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class RectangleClipCompatLayout
  extends FrameLayout
{
  private RectF a = new RectF();
  private float b;
  private final Path c = new Path();
  private boolean d;
  private FrameLayout e;
  
  public RectangleClipCompatLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RectangleClipCompatLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RectangleClipCompatLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.d)
    {
      if (!this.c.isEmpty())
      {
        paramCanvas.save();
        paramCanvas.clipPath(this.c);
        super.dispatchDraw(paramCanvas);
        paramCanvas.restore();
        return;
      }
      super.dispatchDraw(paramCanvas);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public View getAnimateContentView()
  {
    return this.e;
  }
  
  public void setClipRect(RectF paramRectF, float paramFloat)
  {
    if ((paramRectF.width() >= getWidth()) && (paramRectF.height() >= getHeight()))
    {
      this.d = false;
    }
    else
    {
      this.d = true;
      this.a.set(paramRectF);
      this.b = paramFloat;
      this.c.reset();
      paramRectF = this.c;
      RectF localRectF = this.a;
      paramFloat = this.b;
      paramRectF.addRoundRect(localRectF, paramFloat, paramFloat, Path.Direction.CW);
      this.c.close();
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.animate.RectangleClipCompatLayout
 * JD-Core Version:    0.7.0.1
 */