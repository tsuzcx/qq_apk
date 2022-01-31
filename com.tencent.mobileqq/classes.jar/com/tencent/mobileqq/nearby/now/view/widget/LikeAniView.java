package com.tencent.mobileqq.nearby.now.view.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import java.util.Random;
import mww;

public class LikeAniView
  extends FrameLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private int jdField_a_of_type_Int = 180;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator(1.5F);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private int jdField_b_of_type_Int = 180;
  private Interpolator jdField_b_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  
  public LikeAniView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LikeAniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LikeAniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = ((int)mww.a(getContext(), 90.0F));
    this.jdField_b_of_type_Int = ((int)mww.a(getContext(), 90.0F));
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841073);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = new Random().nextInt(40);
    this.jdField_a_of_type_AndroidWidgetImageView.setX(paramInt1 - this.jdField_a_of_type_Int / 2);
    this.jdField_a_of_type_AndroidWidgetImageView.setY(paramInt2 - this.jdField_b_of_type_Int / 2);
    this.jdField_a_of_type_AndroidWidgetImageView.setRotation(i - 20);
    Object localObject1 = ValueAnimator.ofFloat(new float[] { 1.3F, 0.85F });
    ((ValueAnimator)localObject1).setDuration(300L);
    ((ValueAnimator)localObject1).addUpdateListener(this);
    Object localObject2 = ValueAnimator.ofFloat(new float[] { 0.85F, 1.0F });
    ((ValueAnimator)localObject2).setDuration(150L);
    ((ValueAnimator)localObject2).addUpdateListener(this);
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.95F });
    localValueAnimator1.setDuration(150L);
    localValueAnimator1.addUpdateListener(this);
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.95F, 1.0F });
    localValueAnimator2.setDuration(150L);
    localValueAnimator2.addUpdateListener(this);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playSequentially(new Animator[] { localObject1, localObject2, localValueAnimator1, localValueAnimator2 });
    localAnimatorSet.addListener(this);
    localObject1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject1).setDuration(1500L);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether(new Animator[] { localAnimatorSet, localObject1 });
    ((AnimatorSet)localObject2).start();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(paramValueAnimator.floatValue());
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.LikeAniView
 * JD-Core Version:    0.7.0.1
 */