package com.tencent.mobileqq.tianshu.api.impl;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.ApngImage;

class RedTouchTempApiImpl$1
  implements Animation.AnimationListener
{
  RedTouchTempApiImpl$1(RedTouchTempApiImpl paramRedTouchTempApiImpl, Animation paramAnimation1, ImageView paramImageView1, Context paramContext, String paramString, TextView paramTextView1, boolean paramBoolean, TextView paramTextView2, Animation paramAnimation2, ImageView paramImageView2, TextView paramTextView3, TextView paramTextView4) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.a)
    {
      this.b.setVisibility(8);
      paramAnimation = this.l.getApngDrawable(this.c, this.d);
      this.b.setImageDrawable(paramAnimation);
      paramAnimation = this.e;
      if ((paramAnimation != null) && (this.f))
      {
        paramAnimation.setVisibility(8);
        this.g.setVisibility(8);
      }
    }
    else if (paramAnimation == this.h)
    {
      this.i.setVisibility(4);
      paramAnimation = this.j;
      if ((paramAnimation != null) && (this.f)) {
        paramAnimation.setVisibility(8);
      }
      paramAnimation = this.k;
      if ((paramAnimation != null) && (this.f)) {
        paramAnimation.setVisibility(8);
      }
      ApngImage.playByTag(39);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.RedTouchTempApiImpl.1
 * JD-Core Version:    0.7.0.1
 */