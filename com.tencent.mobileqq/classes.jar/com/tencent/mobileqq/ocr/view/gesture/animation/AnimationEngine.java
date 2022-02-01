package com.tencent.mobileqq.ocr.view.gesture.animation;

import android.os.Build.VERSION;
import android.view.View;

public abstract class AnimationEngine
  implements Runnable
{
  private final View jdField_a_of_type_AndroidViewView;
  private final GestureFps jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationGestureFps;
  
  public AnimationEngine(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (GestureFps.a()) {
      paramView = new GestureFps();
    } else {
      paramView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationGestureFps = paramView;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this);
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.jdField_a_of_type_AndroidViewView.postOnAnimationDelayed(this, 10L);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.postDelayed(this, 10L);
  }
  
  public void a(int paramInt)
  {
    GestureFps localGestureFps = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationGestureFps;
    if (localGestureFps != null) {
      localGestureFps.a(paramInt);
    }
    a();
  }
  
  public abstract boolean a();
  
  public final void run()
  {
    boolean bool = a();
    GestureFps localGestureFps = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationGestureFps;
    if (localGestureFps != null)
    {
      localGestureFps.b();
      if (!bool) {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureAnimationGestureFps.a();
      }
    }
    if (bool) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.animation.AnimationEngine
 * JD-Core Version:    0.7.0.1
 */