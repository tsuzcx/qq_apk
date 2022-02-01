package com.tencent.mobileqq.colornote.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;

public class EnterExitAnimHelper
{
  private float jdField_a_of_type_Float;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView;
  private float b;
  
  public EnterExitAnimHelper(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView.setPivotX(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidViewView.setPivotY(this.b);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 1.0F, 0.0F });
    AnimatorSet localAnimatorSet = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(500L);
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(OnColorNoteAnimFinishListener paramOnColorNoteAnimFinishListener, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      localObject = ViewAnimationCompatUtils.a((View)localObject, (int)this.jdField_a_of_type_Float + paramInt, (int)this.b, ((View)localObject).getHeight() / 2, 1.0F);
      ((Animator)localObject).addListener(new EnterExitAnimHelper.1(this, paramOnColorNoteAnimFinishListener, paramBoolean));
      ((Animator)localObject).setDuration(300L);
      ((Animator)localObject).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper
 * JD-Core Version:    0.7.0.1
 */