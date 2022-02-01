package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R.styleable;

public class TriangleView
  extends View
{
  private Paint a = new Paint(1);
  private Path b = new Path();
  private float c;
  
  public TriangleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TriangleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int[] arrayOfInt = R.styleable.TriangleView;
    int i = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, 0, 0);
    try
    {
      int j = paramContext.getIndexCount();
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == 1) {
          setColor(paramContext.getColor(k, -16777216));
        } else if (k == 0) {
          setAngle(paramContext.getFloat(k, 0.0F));
        }
        i += 1;
      }
      paramContext.recycle();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
    for (;;)
    {
      throw paramAttributeSet;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.rotate(this.c);
    paramCanvas.drawPath(this.b, this.a);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = paramInt1 / 2;
    this.b.reset();
    this.b.moveTo(0.0F, 0.0F);
    this.b.lineTo(paramInt1, 0.0F);
    this.b.lineTo(paramInt3, paramInt2);
    this.b.close();
  }
  
  public void setAngle(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void setColor(int paramInt)
  {
    this.a.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.TriangleView
 * JD-Core Version:    0.7.0.1
 */