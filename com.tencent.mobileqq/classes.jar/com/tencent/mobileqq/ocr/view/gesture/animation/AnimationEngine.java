package com.tencent.mobileqq.ocr.view.gesture.animation;

import android.os.Build.VERSION;
import android.view.View;
import azcb;

public abstract class AnimationEngine
  implements Runnable
{
  private final View jdField_a_of_type_AndroidViewView;
  private final azcb jdField_a_of_type_Azcb;
  
  public AnimationEngine(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (azcb.a()) {}
    for (paramView = new azcb();; paramView = null)
    {
      this.jdField_a_of_type_Azcb = paramView;
      return;
    }
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
    if (this.jdField_a_of_type_Azcb != null) {
      this.jdField_a_of_type_Azcb.a(paramInt);
    }
    a();
  }
  
  public abstract boolean a();
  
  public final void run()
  {
    boolean bool = a();
    if (this.jdField_a_of_type_Azcb != null)
    {
      this.jdField_a_of_type_Azcb.b();
      if (!bool) {
        this.jdField_a_of_type_Azcb.a();
      }
    }
    if (bool) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.animation.AnimationEngine
 * JD-Core Version:    0.7.0.1
 */