package com.tencent.mobileqq.nearby;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;

class NearbyRedDotFaceController$1
  extends AnimatorListenerAdapter
{
  NearbyRedDotFaceController$1(NearbyRedDotFaceController paramNearbyRedDotFaceController, URLDrawable paramURLDrawable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.b.setImageDrawable(this.a);
    ObjectAnimator.ofFloat(this.b.b, "alpha", new float[] { 0.1F, 1.0F }).setDuration(1500L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyRedDotFaceController.1
 * JD-Core Version:    0.7.0.1
 */