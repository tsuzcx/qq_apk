package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import mue;

public class RoundRelativeLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float = 16.0F;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  
  public RoundRelativeLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public RoundRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, Path.Direction.CW);
    QLog.i("RoundRelativeLayout", 2, "roundLayoutRadius " + this.jdField_a_of_type_Float);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Float = mue.a(getContext(), paramInt);
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_Float = mue.a(getContext(), 16.0F);
    setWillNotDraw(false);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.round_rect_corner_image);
      if (paramContext != null)
      {
        this.jdField_a_of_type_Float = paramContext.getDimensionPixelSize(0, 0);
        paramContext.recycle();
      }
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Float > 0.0F) && (this.jdField_a_of_type_AndroidGraphicsPath != null))
    {
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    super.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    a();
  }
  
  public void setRoundLayoutRadius(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    a();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout
 * JD-Core Version:    0.7.0.1
 */