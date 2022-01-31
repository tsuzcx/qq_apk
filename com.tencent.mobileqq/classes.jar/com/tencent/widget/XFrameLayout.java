package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;

public class XFrameLayout
  extends FrameLayout
{
  private int jdField_a_of_type_Int = -1;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private int b;
  private int c = 0;
  private int d;
  private int e;
  
  public XFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public XFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public XFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.tencent_widget);
    setMaxHeight(paramContext.getDimensionPixelSize(0, -1));
    paramContext.recycle();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
  }
  
  private void a()
  {
    if ((this.d == this.b) && (this.e == this.c)) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.d = this.b;
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    switch (this.c)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, i, j), this.b, this.b, Path.Direction.CW);
      return;
    case 2: 
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.b;
      f2 = this.b;
      f3 = this.b;
      f4 = this.b;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, 0.0F, 0.0F, 0.0F, 0.0F, f3, f4 }, localDirection);
      return;
    case 3: 
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.b;
      f2 = this.b;
      f3 = this.b;
      f4 = this.b;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
      return;
    case 4: 
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.b;
      f2 = this.b;
      f3 = this.b;
      f4 = this.b;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, f1, f2, f3, f4, 0.0F, 0.0F }, localDirection);
      return;
    }
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    float f1 = this.b;
    float f2 = this.b;
    float f3 = this.b;
    float f4 = this.b;
    Path.Direction localDirection = Path.Direction.CW;
    localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f2, f3, f4 }, localDirection);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.c != 0)
    {
      int i = paramCanvas.save();
      a();
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.jdField_a_of_type_Int > 0)
    {
      int j = View.MeasureSpec.getMode(paramInt2);
      i = paramInt2;
      if (View.MeasureSpec.getSize(paramInt2) > this.jdField_a_of_type_Int)
      {
        i = paramInt2;
        if (j != 0) {
          i = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, j);
        }
      }
    }
    super.onMeasure(paramInt1, i);
  }
  
  public void setCornerRadiusAndMode(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int < getMeasuredHeight()) {
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.XFrameLayout
 * JD-Core Version:    0.7.0.1
 */