package com.tencent.mobileqq.extendfriend.wiget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ExtendFriendVoiceAnimView
  extends FrameLayout
{
  private long jdField_a_of_type_Long = 800L;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView;
  private View b;
  
  public ExtendFriendVoiceAnimView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ExtendFriendVoiceAnimView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ExtendFriendVoiceAnimView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    this.b = new View(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.jdField_a_of_type_AndroidViewView, paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.b, paramContext);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    this.b.setAlpha(0.0F);
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    this.b.setAlpha(0.0F);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { 0.4F, 0.0F });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 0.0F, 1.0F });
    localAnimatorSet.setDuration(this.jdField_a_of_type_Long);
    localAnimatorSet.play((Animator)localObject).with(localObjectAnimator1).with(localObjectAnimator2);
    localObject = localAnimatorSet.clone();
    ((AnimatorSet)localObject).setTarget(this.b);
    ((AnimatorSet)localObject).setStartDelay(this.jdField_a_of_type_Long / 2L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localAnimatorSet, localObject });
    if (paramLong > 0L) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setStartDelay(paramLong);
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void setCircleParams(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(paramInt1);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localGradientDrawable);
    localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(paramInt1);
    this.b.setBackgroundDrawable(localGradientDrawable);
    if (paramInt2 > 0) {
      this.jdField_a_of_type_Long = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceAnimView
 * JD-Core Version:    0.7.0.1
 */