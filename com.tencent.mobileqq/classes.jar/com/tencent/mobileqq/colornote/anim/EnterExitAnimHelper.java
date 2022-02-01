package com.tencent.mobileqq.colornote.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;

public class EnterExitAnimHelper
{
  private View a;
  private AnimatorSet b;
  private float c;
  private float d;
  
  public EnterExitAnimHelper(View paramView)
  {
    this.a = paramView;
    this.b = new AnimatorSet();
  }
  
  private void b()
  {
    this.a.setPivotX(this.c);
    this.a.setPivotY(this.d);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.a, "scaleX", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.a, "scaleY", new float[] { 1.0F, 0.0F });
    AnimatorSet localAnimatorSet = this.b;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      this.b.setDuration(500L);
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.c = paramFloat1;
    this.d = paramFloat2;
  }
  
  public void a(OnColorNoteAnimFinishListener paramOnColorNoteAnimFinishListener, boolean paramBoolean, int paramInt)
  {
    if (this.b != null)
    {
      Object localObject = this.a;
      localObject = ViewAnimationCompatUtils.a((View)localObject, (int)this.c + paramInt, (int)this.d, ((View)localObject).getHeight() / 2, 1.0F);
      ((Animator)localObject).addListener(new EnterExitAnimHelper.1(this, paramOnColorNoteAnimFinishListener, paramBoolean));
      ((Animator)localObject).setDuration(300L);
      ((Animator)localObject).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper
 * JD-Core Version:    0.7.0.1
 */