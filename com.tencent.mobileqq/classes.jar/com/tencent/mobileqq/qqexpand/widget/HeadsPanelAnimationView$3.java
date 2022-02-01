package com.tencent.mobileqq.qqexpand.widget;

import android.animation.AnimatorSet;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.extendfriend.apollo.face.Util;
import java.util.List;

class HeadsPanelAnimationView$3
  implements Animation.AnimationListener
{
  HeadsPanelAnimationView$3(HeadsPanelAnimationView paramHeadsPanelAnimationView, AnimatorSet paramAnimatorSet) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    while (i < this.b.b.size())
    {
      paramAnimation = (ImageView)this.b.b.get(i);
      paramAnimation.clearAnimation();
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && (i < this.b.f.size()))
      {
        localObject = Util.a((AppInterface)localObject, (String)this.b.f.get(i));
        Drawable localDrawable = paramAnimation.getDrawable();
        if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof FaceDrawable))) {
          ((FaceDrawable)localDrawable).cancel();
        }
        paramAnimation.setImageDrawable((Drawable)localObject);
      }
      i += 1;
    }
    this.b.i.clearAnimation();
    this.a.cancel();
    this.b.d.setTranslationX(0.0F);
    this.b.d.setAlpha(1.0F);
    paramAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramAnimation.setFillAfter(true);
    paramAnimation.setDuration(200L);
    paramAnimation.setAnimationListener(new HeadsPanelAnimationView.3.1(this));
    this.b.i.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.HeadsPanelAnimationView.3
 * JD-Core Version:    0.7.0.1
 */