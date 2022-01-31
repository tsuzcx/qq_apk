package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import aovn;
import aovo;
import aovp;
import aovq;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class QIMCameraSegmentCaptureButtonLayout
  extends QIMCameraCaptureButtonLayout
{
  protected static final int b;
  public float b;
  private float c;
  protected ValueAnimator c;
  public AtomicBoolean c;
  
  static
  {
    jdField_b_of_type_Int = CodecParam.e;
  }
  
  public QIMCameraSegmentCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_c_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    a();
  }
  
  public QIMCameraSegmentCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_c_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    a();
  }
  
  private void l()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label193;
      }
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(8);
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a() < QIMCircleProgress.jdField_a_of_type_Int * (float)(jdField_b_of_type_Int - 500L) / jdField_b_of_type_Int) {
        break label188;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener != null)
      {
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener.v();
        }
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener.u();
      }
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a().add(Float.valueOf(this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a()));
      if (QLog.isColorLevel()) {
        QLog.d("CameraSegmentCaptureLayout", 2, "[segmentCapture] segmentPoints add, size = " + this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a().size());
      }
      this.jdField_c_of_type_Float = this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a();
      a(false);
      return;
      label188:
      bool = false;
    }
    label193:
    a(true);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a();
    this.jdField_a_of_type_Float = jdField_b_of_type_Int;
  }
  
  protected void a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", segmentShot:" + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 7: 
    case 8: 
    case 4: 
    case 5: 
      do
      {
        do
        {
          do
          {
            return;
            b(true);
            return;
          } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener == null);
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener.t();
          return;
        } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener.u();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        e();
        return;
        l();
        return;
        b(false);
        return;
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener.s();
        }
        e();
        return;
      } while ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_Boolean));
      g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 50L);
      return;
    }
    f();
  }
  
  @TargetApi(11)
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Float < 0.0F) {
      this.jdField_b_of_type_Float = 1.2222F;
    }
    if ((this.jdField_c_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_c_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_b_of_type_Float, 1.0F });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration((400.0F * (this.jdField_b_of_type_Float - 1.0F) / 0.2222F));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aovn(this));
    float f = this.jdField_c_of_type_Float;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a().size() > 0)) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new aovo(this, paramBoolean, f));
    }
    this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a(0);
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", segmentShot:" + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", actionUp:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isOver:" + this.jdField_a_of_type_Boolean);
    }
    b();
    GLGestureProxy.a().a(paramMotionEvent, true, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_b_of_type_Boolean) {
        return false;
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener == null) || (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraSegmentCaptureLayout", 2, "[segmentCapture] ignore down action, capture not ready");
        }
        return false;
      }
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 1))
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label270;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = true;
        return true;
        label270:
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      j();
      return true;
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView instanceof EffectsCameraCaptureView)) && (((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).e())) {
        ((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).s();
      }
    }
  }
  
  @TargetApi(11)
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Float < 0.0F) {
      this.jdField_b_of_type_Float = 1.0F;
    }
    if ((this.jdField_c_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_c_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_b_of_type_Float, 1.2222F });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration((400.0F * (1.2222F - this.jdField_b_of_type_Float) / 0.2222F));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aovp(this));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new aovq(this, paramBoolean));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a(1);
    if (paramBoolean) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.setStrokeWidth(3.0F);
    }
  }
  
  @TargetApi(11)
  public void d()
  {
    if (this.jdField_c_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void f()
  {
    super.f();
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a().clear();
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.c();
    this.jdField_c_of_type_Float = 0.0F;
  }
  
  protected void g()
  {
    float f1 = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Float;
    float f2 = QIMCircleProgress.jdField_a_of_type_Int;
    f1 = this.jdField_c_of_type_Float + f1 * f2;
    if (f1 >= QIMCircleProgress.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      String str = (int)(f1 / QIMCircleProgress.jdField_a_of_type_Int * (this.jdField_a_of_type_Float / 1000.0F)) + "秒";
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText(str);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.setProgress(f1);
      if (QLog.isColorLevel()) {
        QLog.i("CameraSegmentCaptureLayout", 2, "updateProgress percent:" + f1 + ", time:" + str);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener.v();
        j();
      }
      return;
    }
  }
  
  public void h()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  protected void j()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 1))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      d();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
        }
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a(0);
      return;
      a(true);
      continue;
      a(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      continue;
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
  }
  
  public void k()
  {
    Object localObject = this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a();
    if (((List)localObject).size() > 0)
    {
      ((List)localObject).remove(((List)localObject).size() - 1);
      if (((List)localObject).size() != 0) {
        break label117;
      }
      this.jdField_c_of_type_Float = 0.0F;
      f();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.setProgress(this.jdField_c_of_type_Float);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraSegmentCaptureLayout", 2, "[segmentCapture] segmentPoints delete, size = " + this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a().size());
      }
      return;
      label117:
      this.jdField_c_of_type_Float = ((Float)((List)localObject).get(((List)localObject).size() - 1)).floatValue();
      localObject = (int)(this.jdField_c_of_type_Float / QIMCircleProgress.jdField_a_of_type_Int * (this.jdField_a_of_type_Float / 1000.0F)) + "秒";
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText((String)localObject);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */