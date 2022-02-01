package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class ArcImageView
  extends ImageView
{
  private Drawable a = null;
  private boolean b = false;
  private Paint c;
  private int d = 3;
  private float e = 0.0F;
  
  public ArcImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ArcImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ArcImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.STROKE);
    try
    {
      this.c.setColor(getResources().getColor(2131168464));
      this.d = ((int)(getResources().getDisplayMetrics().density * 1.5F));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.c.setStrokeWidth(this.d);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      if ((this.b) && (this.a == null)) {
        this.a = getResources().getDrawable(2130852588);
      }
      postInvalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = new RectF();
    int i = this.d;
    ((RectF)localObject).left = i;
    ((RectF)localObject).top = i;
    ((RectF)localObject).right = (getWidth() - this.d);
    ((RectF)localObject).bottom = (getHeight() - this.d);
    paramCanvas.drawArc((RectF)localObject, 270.0F, this.e, false, this.c);
    if (this.b)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((Drawable)localObject).setState(getDrawableState());
        i = getWidth();
        int j = this.a.getIntrinsicWidth();
        int k = this.a.getIntrinsicHeight();
        this.a.setBounds(i - j, 0, getWidth(), k);
        this.a.draw(paramCanvas);
      }
    }
  }
  
  public void setProgress(float paramFloat)
  {
    float f;
    if (paramFloat < 0.0F)
    {
      f = 0.0F;
    }
    else
    {
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
    paramFloat = f * 360.0F;
    if (this.e != paramFloat)
    {
      this.e = paramFloat;
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ArcImageView
 * JD-Core Version:    0.7.0.1
 */