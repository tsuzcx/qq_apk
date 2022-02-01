package com.tencent.mobileqq.qzonevip.gift;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;

class QzoneGiftManager$2
  extends AnimatorListenerAdapter
{
  boolean a = false;
  
  QzoneGiftManager$2(QzoneGiftManager paramQzoneGiftManager) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.i("QzoneGiftManager", 1, "onAnimationEnd");
    if (this.a) {
      QzoneGiftManager.a(this.b, 8);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QLog.i("QzoneGiftManager", 1, "onAnimationStart");
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager.2
 * JD-Core Version:    0.7.0.1
 */