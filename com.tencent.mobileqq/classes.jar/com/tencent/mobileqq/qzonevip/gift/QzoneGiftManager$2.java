package com.tencent.mobileqq.qzonevip.gift;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;

class QzoneGiftManager$2
  extends AnimatorListenerAdapter
{
  boolean jdField_a_of_type_Boolean = false;
  
  QzoneGiftManager$2(QzoneGiftManager paramQzoneGiftManager) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.i("QzoneGiftManager", 1, "onAnimationEnd");
    if (this.jdField_a_of_type_Boolean) {
      QzoneGiftManager.a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager, 8);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QLog.i("QzoneGiftManager", 1, "onAnimationStart");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager.2
 * JD-Core Version:    0.7.0.1
 */