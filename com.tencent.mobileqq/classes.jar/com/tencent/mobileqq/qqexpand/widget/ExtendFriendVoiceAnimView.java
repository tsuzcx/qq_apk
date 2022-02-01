package com.tencent.mobileqq.qqexpand.widget;

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
  private long a = 800L;
  private View b;
  private View c;
  private AnimatorSet d;
  
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
    this.b = new View(paramContext);
    this.c = new View(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.b, paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.c, paramContext);
    this.b.setAlpha(0.0F);
    this.c.setAlpha(0.0F);
  }
  
  public void a(long paramLong)
  {
    AnimatorSet localAnimatorSet = this.d;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning())) {
      this.d.cancel();
    }
    this.b.setAlpha(0.0F);
    this.c.setAlpha(0.0F);
    localAnimatorSet = new AnimatorSet();
    Object localObject = ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 0.4F, 0.0F });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.b, "scaleX", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { 0.0F, 1.0F });
    localAnimatorSet.setDuration(this.a);
    localAnimatorSet.play((Animator)localObject).with(localObjectAnimator1).with(localObjectAnimator2);
    localObject = localAnimatorSet.clone();
    ((AnimatorSet)localObject).setTarget(this.c);
    ((AnimatorSet)localObject).setStartDelay(this.a / 2L);
    this.d = new AnimatorSet();
    this.d.playTogether(new Animator[] { localAnimatorSet, localObject });
    if (paramLong > 0L) {
      this.d.setStartDelay(paramLong);
    }
    this.d.start();
  }
  
  public void setCircleParams(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(paramInt1);
    this.b.setBackgroundDrawable(localGradientDrawable);
    localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(paramInt1);
    this.c.setBackgroundDrawable(localGradientDrawable);
    if (paramInt2 > 0) {
      this.a = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendVoiceAnimView
 * JD-Core Version:    0.7.0.1
 */