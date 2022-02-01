package com.tencent.mobileqq.ocr.view.gesture.animation;

import android.os.Build.VERSION;
import android.view.View;
import ayvu;

public abstract class AnimationEngine
  implements Runnable
{
  private final View jdField_a_of_type_AndroidViewView;
  private final ayvu jdField_a_of_type_Ayvu;
  
  public AnimationEngine(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (ayvu.a()) {}
    for (paramView = new ayvu();; paramView = null)
    {
      this.jdField_a_of_type_Ayvu = paramView;
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
    if (this.jdField_a_of_type_Ayvu != null) {
      this.jdField_a_of_type_Ayvu.a(paramInt);
    }
    a();
  }
  
  public abstract boolean a();
  
  public final void run()
  {
    boolean bool = a();
    if (this.jdField_a_of_type_Ayvu != null)
    {
      this.jdField_a_of_type_Ayvu.b();
      if (!bool) {
        this.jdField_a_of_type_Ayvu.a();
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