package com.tencent.mobileqq.profile.view.helper;

import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.util.DisplayUtil;

public class ShakeEffectGenerator
{
  private final int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new ShakeEffectGenerator.1(this);
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private boolean jdField_a_of_type_Boolean = false;
  private final int b;
  private int c = 0;
  private int d = 0;
  
  public ShakeEffectGenerator(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 15.0F);
      double d1 = this.jdField_a_of_type_Int;
      Double.isNaN(d1);
      this.b = ((int)(d1 / 1.5D));
      return;
    }
    throw new IllegalArgumentException("Wrapped View shouldn't be null!");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.c = 0;
    this.d = 0;
    int j;
    int i;
    int k;
    int m;
    int n;
    do
    {
      double d1 = this.b;
      double d2 = Math.random();
      Double.isNaN(d1);
      j = (int)(d1 * (d2 * 2.0D - 1.0D));
      i = this.b;
      i = (int)Math.sqrt(i * i - j * j);
      if (Math.random() <= 0.5D) {
        i = -i;
      }
      k = this.c;
      m = this.d;
      n = this.jdField_a_of_type_Int;
    } while ((j + k) * (j + k) + (i + m) * (i + m) > n * n);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(k, k + j, m, m + i);
    this.c = (j + this.c);
    this.d = (i + this.d);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(this.b * (int)(Math.random() * 30.0D + 50.0D));
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.getAnimation() == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (a()) {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.helper.ShakeEffectGenerator
 * JD-Core Version:    0.7.0.1
 */