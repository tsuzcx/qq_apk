package com.tencent.mobileqq.guild.mainframe.container.discover.shareelement;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.ImageView;

public class GuildShareElement
{
  private ShareElementInfo a;
  private AnimatorListenerAdapter b;
  private AnimatorSet c;
  private Interpolator d;
  private boolean e;
  private Context f;
  
  private void a(ImageView paramImageView)
  {
    this.c = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramImageView, "scaleY", new float[] { this.a.d(), 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramImageView, "scaleX", new float[] { this.a.c(), 1.0F });
    localObjectAnimator2.setDuration(550L);
    localObjectAnimator1.setDuration(550L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramImageView, "translationX", new float[] { this.a.a(), 0.0F });
    paramImageView = ObjectAnimator.ofFloat(paramImageView, "translationY", new float[] { this.a.b(), 0.0F });
    localObjectAnimator3.setDuration(500L);
    paramImageView.setDuration(500L);
    this.c.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator1, localObjectAnimator3, paramImageView });
    paramImageView = this.b;
    if (paramImageView != null) {
      this.c.addListener(paramImageView);
    }
    paramImageView = this.d;
    if (paramImageView != null) {
      this.c.setInterpolator(paramImageView);
    }
    this.c.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.shareelement.GuildShareElement
 * JD-Core Version:    0.7.0.1
 */