package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import com.tencent.mobileqq.activity.aio.doodle.DoodleItem;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.qphone.base.util.QLog;

class DrawClassifier$4
  implements Runnable
{
  DrawClassifier$4(DrawClassifier paramDrawClassifier, DrawClassifier.OnRecogListener paramOnRecogListener, DoodleItem paramDoodleItem) {}
  
  public void run()
  {
    try
    {
      if (!DrawClassifier.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "not init ok or already close to recog");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier$OnRecogListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier$OnRecogListener.a(false);
        }
      }
      long l = System.currentTimeMillis();
      boolean bool = DrawClassifier.a(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleItem, DrawClassifier.c(this.this$0), this.this$0.a, DrawClassifier.a(this.this$0), DrawClassifier.a(this.this$0));
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier$OnRecogListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier$OnRecogListener.a(bool);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("recognize cost:");
        localStringBuilder1.append(System.currentTimeMillis() - l);
        QLog.i("DrawClassifier", 2, localStringBuilder1.toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("recognition throwable:");
        localStringBuilder2.append(QWalletTools.a(localThrowable));
        QLog.e("DrawClassifier", 2, localStringBuilder2.toString());
      }
      localThrowable.printStackTrace();
      DrawClassifier.OnRecogListener localOnRecogListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier$OnRecogListener;
      if (localOnRecogListener != null) {
        localOnRecogListener.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawClassifier.4
 * JD-Core Version:    0.7.0.1
 */