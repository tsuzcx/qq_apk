package com.tencent.mobileqq.profilecard.bussiness.colorscreen;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.qphone.base.util.QLog;

class ProfileColorScreenComponent$ColorScreenLoader$ColorScreenListener
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  public long mDuration;
  private boolean mForbidAlpha;
  public int mRepeatTimes;
  public long mTotalTime;
  
  public ProfileColorScreenComponent$ColorScreenLoader$ColorScreenListener(ProfileColorScreenComponent.ColorScreenLoader paramColorScreenLoader, long paramLong)
  {
    this.mDuration = paramLong;
    this.mTotalTime = ((ProfileColorScreenComponent.ColorScreenLoader.access$1000(paramColorScreenLoader).jdField_a_of_type_Int + 1) * paramLong);
    if (Build.VERSION.SDK_INT == 15) {}
    for (boolean bool = true;; bool = false)
    {
      this.mForbidAlpha = bool;
      return;
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorScreenManager", 2, "onAnimationEnd: " + ProfileColorScreenComponent.ColorScreenLoader.access$600(this.this$1));
    }
    ProfileColorScreenComponent.access$400(this.this$1.this$0).setVisibility(8);
    ProfileColorScreenComponent.access$800(this.this$1.this$0).post(new ProfileColorScreenComponent.ColorScreenLoader.ColorScreenListener.1(this));
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.mRepeatTimes += 1;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileColorScreenComponent", 2, "onAnimationStart: " + ProfileColorScreenComponent.ColorScreenLoader.access$600(this.this$1));
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.mForbidAlpha) {
      try
      {
        float f = (paramValueAnimator.getAnimatedFraction() + this.mRepeatTimes) * (float)this.mDuration;
        if (f <= (float)ProfileColorScreenComponent.ColorScreenLoader.access$1000(this.this$1).jdField_a_of_type_Long)
        {
          ProfileColorScreenComponent.access$400(this.this$1.this$0).setAlpha(f / (float)ProfileColorScreenComponent.ColorScreenLoader.access$1000(this.this$1).jdField_a_of_type_Long);
          return;
        }
        if ((this.mTotalTime > 0L) && ((float)this.mTotalTime - f <= (float)ProfileColorScreenComponent.ColorScreenLoader.access$1000(this.this$1).b))
        {
          ProfileColorScreenComponent.access$400(this.this$1.this$0).setAlpha(((float)this.mTotalTime - f) / (float)ProfileColorScreenComponent.ColorScreenLoader.access$1000(this.this$1).b);
          return;
        }
      }
      catch (Exception paramValueAnimator)
      {
        this.mForbidAlpha = true;
        QLog.e("ProfileColorScreenComponent", 1, "onAnimationUpdate: ", paramValueAnimator);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader.ColorScreenListener
 * JD-Core Version:    0.7.0.1
 */