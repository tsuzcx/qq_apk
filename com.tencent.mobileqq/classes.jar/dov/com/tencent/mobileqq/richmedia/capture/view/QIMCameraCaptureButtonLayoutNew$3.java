package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class QIMCameraCaptureButtonLayoutNew$3
  extends AnimatorListenerAdapter
{
  QIMCameraCaptureButtonLayoutNew$3(QIMCameraCaptureButtonLayoutNew paramQIMCameraCaptureButtonLayoutNew) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "scaleAnimator cancel!");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "scaleAnimator end, shortVideoShot:" + this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", mActionUpAnimator:" + this.a.b.get());
    }
    if (!this.a.b.get())
    {
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.a.h();
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    }
    for (;;)
    {
      this.a.b.set(false);
      this.a.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(0);
      return;
      this.a.i();
      this.a.a(1.0F);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "scaleAnimator start!");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayoutNew.3
 * JD-Core Version:    0.7.0.1
 */