package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.PressDarkImageView;

public class RoundedCornerImageViewNoPadding
  extends PressDarkImageView
{
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = Color.parseColor("#FFD5D5D5");
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  
  public RoundedCornerImageViewNoPadding(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public RoundedCornerImageViewNoPadding(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedCornerImageViewNoPadding(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLayerType(2, null);
    }
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    super.setLayerType(1, null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    if (this.c > 0) {
      i = this.c;
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
        this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
        this.jdField_b_of_type_Boolean = true;
      }
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      super.draw(paramCanvas);
      return;
      i /= 30;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("should not be less than 0");
    }
    this.c = paramInt;
    this.jdField_b_of_type_Boolean = false;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundedCornerImageViewNoPadding
 * JD-Core Version:    0.7.0.1
 */