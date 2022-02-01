package com.tencent.mobileqq.widget.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.utils.ViewUtils;

public class DotView
  extends View
{
  private int a = 5;
  private int b = -16777216;
  private Paint c;
  
  public DotView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DotView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DotView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.V);
      this.a = ((int)paramContext.getDimension(R.styleable.X, this.a));
      this.b = paramContext.getColor(R.styleable.W, this.b);
      paramContext.recycle();
    }
    this.c = new Paint();
    this.c.setColor(this.b);
    this.c.setFlags(1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.a;
    paramCanvas.drawCircle(i, i, i, this.c);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = this.a * 2;
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public void setColor(int paramInt)
  {
    this.b = paramInt;
    this.c.setColor(paramInt);
    invalidate();
  }
  
  public void setRadius(float paramFloat)
  {
    this.a = ViewUtils.dip2px(paramFloat);
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.shape.DotView
 * JD-Core Version:    0.7.0.1
 */