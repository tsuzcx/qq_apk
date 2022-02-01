package com.tencent.mobileqq.qzonevip.gift;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView;

class QzoneGiftManager$3
  extends AnimatorListenerAdapter
{
  QzoneGiftManager$3(QzoneGiftManager paramQzoneGiftManager) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QzoneGiftManager.i(this.a) != null) {
      QzoneGiftManager.i(this.a).e();
    }
    QzoneGiftManager.a(this.a, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager.3
 * JD-Core Version:    0.7.0.1
 */