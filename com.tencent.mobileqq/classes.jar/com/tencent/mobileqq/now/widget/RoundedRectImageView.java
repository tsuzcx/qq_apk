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
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private float[] jdField_a_of_type_ArrayOfFloat = new float[8];
  
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
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedRectImageView);
      if (paramContext != null)
      {
        int i = paramContext.getDimensionPixelSize(2, 0);
        int j = paramContext.getDimensionPixelSize(0, 0);
        int k = paramContext.getDimensionPixelSize(3, 0);
        int m = paramContext.getDimensionPixelSize(1, 0);
        paramAttributeSet = this.jdField_a_of_type_ArrayOfFloat;
        float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
        float f = i;
        arrayOfFloat[1] = f;
        paramAttributeSet[0] = f;
        paramAttributeSet = this.jdField_a_of_type_ArrayOfFloat;
        arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
        f = k;
        arrayOfFloat[3] = f;
        paramAttributeSet[2] = f;
        paramAttributeSet = this.jdField_a_of_type_ArrayOfFloat;
        arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
        f = m;
        arrayOfFloat[5] = f;
        paramAttributeSet[4] = f;
        paramAttributeSet = this.jdField_a_of_type_ArrayOfFloat;
        arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
        f = j;
        arrayOfFloat[7] = f;
        paramAttributeSet[6] = f;
        paramContext.recycle();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth(), getHeight());
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    super.onDraw(paramCanvas);
  }
  
  public void setBottomLeftRadius(int paramInt)
  {
    float[] arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    float[] arrayOfFloat2 = this.jdField_a_of_type_ArrayOfFloat;
    float f = paramInt;
    arrayOfFloat2[7] = f;
    arrayOfFloat1[6] = f;
  }
  
  public void setBottomRightRadius(int paramInt)
  {
    float[] arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    float[] arrayOfFloat2 = this.jdField_a_of_type_ArrayOfFloat;
    float f = paramInt;
    arrayOfFloat2[5] = f;
    arrayOfFloat1[4] = f;
  }
  
  public void setTopLeftRadius(int paramInt)
  {
    float[] arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    float[] arrayOfFloat2 = this.jdField_a_of_type_ArrayOfFloat;
    float f = paramInt;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[0] = f;
  }
  
  public void setTopRightRadius(int paramInt)
  {
    float[] arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    float[] arrayOfFloat2 = this.jdField_a_of_type_ArrayOfFloat;
    float f = paramInt;
    arrayOfFloat2[3] = f;
    arrayOfFloat1[2] = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.RoundedRectImageView
 * JD-Core Version:    0.7.0.1
 */