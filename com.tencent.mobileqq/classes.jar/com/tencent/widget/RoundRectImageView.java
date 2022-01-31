package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundRectImageView
  extends ImageView
{
  private int jdField_a_of_type_Int;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private int b = 0;
  private int c;
  private int d;
  
  public RoundRectImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundRectImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public RoundRectImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
  }
  
  private void a()
  {
    if ((this.c == this.jdField_a_of_type_Int) && (this.d == this.b)) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    switch (this.b)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, i, j), this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, Path.Direction.CW);
      return;
    case 2: 
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.jdField_a_of_type_Int;
      f2 = this.jdField_a_of_type_Int;
      f3 = this.jdField_a_of_type_Int;
      f4 = this.jdField_a_of_type_Int;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, 0.0F, 0.0F, 0.0F, 0.0F, f3, f4 }, localDirection);
      return;
    case 3: 
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.jdField_a_of_type_Int;
      f2 = this.jdField_a_of_type_Int;
      f3 = this.jdField_a_of_type_Int;
      f4 = this.jdField_a_of_type_Int;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
      return;
    case 4: 
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.jdField_a_of_type_Int;
      f2 = this.jdField_a_of_type_Int;
      f3 = this.jdField_a_of_type_Int;
      f4 = this.jdField_a_of_type_Int;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, f1, f2, f3, f4, 0.0F, 0.0F }, localDirection);
      return;
    }
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    float f1 = this.jdField_a_of_type_Int;
    float f2 = this.jdField_a_of_type_Int;
    float f3 = this.jdField_a_of_type_Int;
    float f4 = this.jdField_a_of_type_Int;
    Path.Direction localDirection = Path.Direction.CW;
    localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f2, f3, f4 }, localDirection);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.b != 0)
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
  
  public void setCornerRadiusAndMode(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.RoundRectImageView
 * JD-Core Version:    0.7.0.1
 */