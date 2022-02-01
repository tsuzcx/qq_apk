package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class VideoLoadingImage
  extends ImageView
{
  public float a;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public VideoLoadingImage(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VideoLoadingImage(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public VideoLoadingImage(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130840172);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.c = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      this.d = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130840173);
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      this.e = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
      this.f = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = getMeasuredHeight();
      this.jdField_b_of_type_Int = getMeasuredWidth();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null))
    {
      this.jdField_a_of_type_Float += 2.5F;
      paramCanvas.save();
      paramCanvas.rotate(this.jdField_a_of_type_Float, getWidth() >> 1, getHeight() >> 1);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, new Rect(0, 0, this.d, this.c), new Rect(0, 0, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int), null);
      paramCanvas.restore();
      paramCanvas.rotate(-this.jdField_a_of_type_Float, getWidth() >> 1, getHeight() >> 1);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, new Rect(0, 0, this.f, this.e), new Rect(this.jdField_b_of_type_Int >> 2, this.jdField_a_of_type_Int >> 2, this.jdField_b_of_type_Int * 3 / 4, this.jdField_a_of_type_Int * 3 / 4), null);
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.VideoLoadingImage
 * JD-Core Version:    0.7.0.1
 */