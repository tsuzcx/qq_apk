package com.tencent.mobileqq.gallery.presenter;

import apue;
import com.tencent.TMG.utils.QLog;

class AIOGalleryBasePresenter$ImmersionTimerRunnable
  implements Runnable
{
  AIOGalleryBasePresenter$ImmersionTimerRunnable(AIOGalleryBasePresenter paramAIOGalleryBasePresenter) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryBasePresenter", 0, "ImmersionTimerRunnable run");
    }
    this.this$0.jdField_a_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Apue != null) {
      this.this$0.jdField_a_of_type_Apue.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter.ImmersionTimerRunnable
 * JD-Core Version:    0.7.0.1
 */