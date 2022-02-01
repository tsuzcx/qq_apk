package com.tencent.mobileqq.now.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R.styleable;

@SuppressLint({"AppCompatCustomView"})
public class RoundedRectImageView
  extends ImageView
{
  private float[] a = new float[8];
  private Path b;
  private RectF c = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  
  public RoundedRectImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public RoundedRectImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public RoundedRectImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.b = new Path();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedRectImageView);
      if (paramContext != null)
      {
        int i = paramContext.getDimensionPixelSize(2, 0);
        int j = paramContext.getDimensionPixelSize(0, 0);
        int k = paramContext.getDimensionPixelSize(3, 0);
        int m = paramContext.getDimensionPixelSize(1, 0);
        paramAttributeSet = this.a;
        float f = i;
        paramAttributeSet[1] = f;
        paramAttributeSet[0] = f;
        f = k;
        paramAttributeSet[3] = f;
        paramAttributeSet[2] = f;
        f = m;
        paramAttributeSet[5] = f;
        paramAttributeSet[4] = f;
        f = j;
        paramAttributeSet[7] = f;
        paramAttributeSet[6] = f;
        paramContext.recycle();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.c.set(0.0F, 0.0F, getWidth(), getHeight());
    this.b.addRoundRect(this.c, this.a, Path.Direction.CW);
    paramCanvas.clipPath(this.b);
    super.onDraw(paramCanvas);
  }
  
  public void setBottomLeftRadius(int paramInt)
  {
    float[] arrayOfFloat = this.a;
    float f = paramInt;
    arrayOfFloat[7] = f;
    arrayOfFloat[6] = f;
  }
  
  public void setBottomRightRadius(int paramInt)
  {
    float[] arrayOfFloat = this.a;
    float f = paramInt;
    arrayOfFloat[5] = f;
    arrayOfFloat[4] = f;
  }
  
  public void setTopLeftRadius(int paramInt)
  {
    float[] arrayOfFloat = this.a;
    float f = paramInt;
    arrayOfFloat[1] = f;
    arrayOfFloat[0] = f;
  }
  
  public void setTopRightRadius(int paramInt)
  {
    float[] arrayOfFloat = this.a;
    float f = paramInt;
    arrayOfFloat[3] = f;
    arrayOfFloat[2] = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.RoundedRectImageView
 * JD-Core Version:    0.7.0.1
 */