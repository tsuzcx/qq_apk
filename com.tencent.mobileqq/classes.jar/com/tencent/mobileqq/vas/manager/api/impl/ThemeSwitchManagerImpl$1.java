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
    if (this.a.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 1, "onPostThemeChanged, remove view, tmpScreenShot==null");
      }
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    paramAnimation = (ViewGroup)this.a.jdField_a_of_type_AndroidWidgetImageView.getParent();
    if (paramAnimation != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 1, "onPostThemeChanged, execute remove view");
      }
      paramAnimation.removeView(this.a.jdField_a_of_type_AndroidWidgetImageView);
      paramAnimation.clearDisappearingChildren();
    }
    this.a.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    paramAnimation = this.a;
    paramAnimation.jdField_a_of_type_AndroidGraphicsBitmap = null;
    paramAnimation.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.a.jdField_a_of_type_AndroidWidgetImageView = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.manager.api.impl.ThemeSwitchManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */