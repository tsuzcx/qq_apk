package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class EmotionGallery
  extends DragGallery
{
  private EmotionGallery.OnScaleChangeListener a;
  
  public EmotionGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected float customScale(View paramView, float paramFloat, int paramInt)
  {
    paramFloat = getResources().getDisplayMetrics().density * 135.0F * 1.5F;
    float f = paramInt;
    if (f > paramFloat) {
      paramFloat /= f;
    } else {
      paramFloat = Math.min(1.5F, paramFloat / f);
    }
    setMaxScale((float)ScreenUtil.SCREEN_WIDTH / f);
    return paramFloat;
  }
  
  public float getSelectChildScale()
  {
    if (this.mSelectedChild != null) {
      return super.getChildScale(this.mSelectedChild);
    }
    return 1.0F;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a != null)
    {
      float f = getSelectChildScale();
      this.a.b(f);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    EmotionGallery.OnScaleChangeListener localOnScaleChangeListener = this.a;
    if (localOnScaleChangeListener != null) {
      localOnScaleChangeListener.d();
    }
    return super.onScaleBegin(paramScaleGestureDetector);
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.a != null)
    {
      float f = getSelectChildScale();
      this.a.a(f);
    }
    super.onScaleEnd(paramScaleGestureDetector);
  }
  
  public void setOnScaleChangeListener(EmotionGallery.OnScaleChangeListener paramOnScaleChangeListener)
  {
    this.a = paramOnScaleChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionGallery
 * JD-Core Version:    0.7.0.1
 */