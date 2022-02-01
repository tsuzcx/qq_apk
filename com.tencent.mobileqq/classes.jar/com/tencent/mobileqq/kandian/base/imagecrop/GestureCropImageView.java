package com.tencent.mobileqq.kandian.base.imagecrop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class GestureCropImageView
  extends CropImageView
{
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 5;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e = true;
  
  public GestureCropImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GestureCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GestureCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new GestureCropImageView.GestureListener(this, null), null, true);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(getContext(), new GestureCropImageView.ScaleListener(this, null));
  }
  
  protected float c()
  {
    return d() * (float)Math.pow(a() / b(), 1.0F / this.jdField_c_of_type_Int);
  }
  
  protected void c()
  {
    super.c();
    d();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      a();
    }
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.jdField_c_of_type_Float = ((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F);
      this.jdField_d_of_type_Float = ((paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 1)
    {
      setImageToWrapCropBounds();
      setImageToLowerMaxScale();
    }
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setDoubleTapScaleSteps(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setIsDoubleTapEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setRotateEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setScaleEnabled(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.GestureCropImageView
 * JD-Core Version:    0.7.0.1
 */