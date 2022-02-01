package com.tencent.mobileqq.vas.manager.api.impl;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ThemeSwitchManagerImpl$1
  implements Animation.AnimationListener
{
  ThemeSwitchManagerImpl$1(ThemeSwitchManagerImpl paramThemeSwitchManagerImpl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.f == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 1, "onPostThemeChanged, remove view, tmpScreenShot==null");
      }
      this.a.g.set(false);
      return;
    }
    paramAnimation = (ViewGroup)this.a.f.getParent();
    if (paramAnimation != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 1, "onPostThemeChanged, execute remove view");
      }
      paramAnimation.removeView(this.a.f);
      paramAnimation.clearDisappearingChildren();
    }
    this.a.e.recycle();
    paramAnimation = this.a;
    paramAnimation.e = null;
    paramAnimation.g.set(false);
    this.a.f = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.manager.api.impl.ThemeSwitchManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */