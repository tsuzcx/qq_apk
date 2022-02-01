package com.tencent.mobileqq.together.ui;

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
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.List;

class HeadsPanelAnimationView$2
  implements Animation.AnimationListener
{
  HeadsPanelAnimationView$2(HeadsPanelAnimationView paramHeadsPanelAnimationView, AnimatorSet paramAnimatorSet) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    while (i < 3)
    {
      paramAnimation = (ImageView)this.b.b.get(i);
      paramAnimation.clearAnimation();
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 != null) && (i < this.b.g.size()))
      {
        Object localObject2 = (String)this.b.g.get(i);
        Drawable localDrawable = ImageUtil.a(true);
        localObject1 = FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, (String)localObject2, 4, localDrawable, localDrawable);
        localObject2 = paramAnimation.getDrawable();
        if ((localObject2 != null) && (localObject2 != localObject1) && ((localObject2 instanceof FaceDrawable))) {
          ((FaceDrawable)localObject2).cancel();
        }
        paramAnimation.setImageDrawable((Drawable)localObject1);
      }
      i += 1;
    }
    this.b.i.clearAnimation();
    this.a.cancel();
    this.b.e.setTranslationX(0.0F);
    this.b.e.setAlpha(1.0F);
    paramAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramAnimation.setFillAfter(true);
    paramAnimation.setDuration(200L);
    paramAnimation.setAnimationListener(new HeadsPanelAnimationView.2.1(this));
    this.b.i.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.HeadsPanelAnimationView.2
 * JD-Core Version:    0.7.0.1
 */