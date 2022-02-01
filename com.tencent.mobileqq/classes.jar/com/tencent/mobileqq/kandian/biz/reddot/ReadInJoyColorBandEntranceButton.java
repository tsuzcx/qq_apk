package com.tencent.mobileqq.kandian.biz.reddot;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;

public class ReadInJoyColorBandEntranceButton
  extends ColorBandVideoEntranceButton
{
  private int o = 0;
  
  public ReadInJoyColorBandEntranceButton(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInJoyColorBandEntranceButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void c()
  {
    int i = this.o;
    if (i == 0)
    {
      super.c();
      return;
    }
    AnimatorSet localAnimatorSet;
    if (i == 1)
    {
      i = getResources().getInteger(2131492923);
      this.c.setImageDrawable(getResources().getDrawable(2130851371));
      this.c.setVisibility(0);
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.a, "scaleX", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.a, "scaleY", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.c, "translationX", new float[] { 0.0F, -AIOUtils.b(58.0F, getResources()) }), ObjectAnimator.ofFloat(this.c, "translationY", new float[] { 0.0F, AIOUtils.b(54.0F, getResources()) }) });
      localAnimatorSet.setDuration(i);
      localAnimatorSet.addListener(new ReadInJoyColorBandEntranceButton.1(this));
      localAnimatorSet.start();
      return;
    }
    if (i == 2)
    {
      i = getResources().getInteger(2131492924);
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.b, "rotation", new float[] { 0.0F, 360.0F }) });
      localAnimatorSet.setDuration(i);
      localAnimatorSet.start();
    }
  }
  
  public void setClickAnimMode(int paramInt)
  {
    this.o = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyColorBandEntranceButton
 * JD-Core Version:    0.7.0.1
 */