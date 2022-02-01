package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.mobileqq.activity.photo.DragGallery;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class EmotionGallery
  extends DragGallery
{
  private EmotionGallery.OnScaleChangeListener a;
  
  public EmotionGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return super.a(this.jdField_a_of_type_AndroidViewView);
    }
    return 1.0F;
  }
  
  public float a(View paramView, float paramFloat, int paramInt)
  {
    paramFloat = getResources().getDisplayMetrics().density * 135.0F * 1.5F;
    if (paramInt > paramFloat) {}
    for (paramFloat /= paramInt;; paramFloat = Math.min(1.5F, paramFloat / paramInt))
    {
      setMaxScale((float)ScreenUtil.a / paramInt);
      return paramFloat;
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery$OnScaleChangeListener != null)
    {
      float f = a();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery$OnScaleChangeListener.b(f);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery$OnScaleChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery$OnScaleChangeListener.b();
    }
    return super.onScaleBegin(paramScaleGestureDetector);
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery$OnScaleChangeListener != null)
    {
      float f = a();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery$OnScaleChangeListener.a(f);
    }
    super.onScaleEnd(paramScaleGestureDetector);
  }
  
  public void setOnScaleChangeListener(EmotionGallery.OnScaleChangeListener paramOnScaleChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery$OnScaleChangeListener = paramOnScaleChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionGallery
 * JD-Core Version:    0.7.0.1
 */