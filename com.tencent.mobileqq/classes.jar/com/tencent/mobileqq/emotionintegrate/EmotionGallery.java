package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import aodv;
import blbz;
import com.tencent.mobileqq.activity.photo.DragGallery;

public class EmotionGallery
  extends DragGallery
{
  private aodv a;
  
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
      setMaxScale((float)blbz.a / paramInt);
      return paramFloat;
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Aodv != null)
    {
      float f = a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Aodv.c(f);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Aodv != null) {
      this.jdField_a_of_type_Aodv.b();
    }
    return super.onScaleBegin(paramScaleGestureDetector);
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Aodv != null)
    {
      float f = a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Aodv.b(f);
    }
    super.onScaleEnd(paramScaleGestureDetector);
  }
  
  public void setOnScaleChangeListener(aodv paramaodv)
  {
    this.jdField_a_of_type_Aodv = paramaodv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionGallery
 * JD-Core Version:    0.7.0.1
 */