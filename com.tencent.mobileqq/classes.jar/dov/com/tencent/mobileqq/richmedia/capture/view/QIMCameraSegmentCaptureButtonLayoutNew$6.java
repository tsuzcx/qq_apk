package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class QIMCameraSegmentCaptureButtonLayoutNew$6
  extends AnimatorListenerAdapter
{
  QIMCameraSegmentCaptureButtonLayoutNew$6(QIMCameraSegmentCaptureButtonLayoutNew paramQIMCameraSegmentCaptureButtonLayoutNew, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "scaleAnimator end, shortVideoShot:" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " segmentShot:" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.c.get() + ", mActionUpAnimator:" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.b.get());
    }
    if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.b.get())
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.c.set(true);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.h();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.b.set(false);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.i();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.a(1.0F);
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "scaleAnimator start!");
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayoutNew.6
 * JD-Core Version:    0.7.0.1
 */