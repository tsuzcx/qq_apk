package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import bnyw;
import bnyy;
import bnyz;
import bnza;
import bnzb;
import bnzc;
import bnzd;
import bnzl;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class QIMCameraSegmentCaptureButtonLayout
  extends QIMCameraCaptureButtonLayoutNew
{
  protected static final int b;
  protected float b;
  public float c;
  protected ValueAnimator c;
  public AtomicBoolean c;
  private float d = this.jdField_a_of_type_Float * 0.98F / 1000.0F;
  protected boolean f;
  
  static
  {
    jdField_b_of_type_Int = CodecParam.SEGMENT_RECORD_MAX_TIME;
  }
  
  public QIMCameraSegmentCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_c_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public QIMCameraSegmentCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_c_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void b()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label206;
      }
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(8);
      if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a() < QIMCircleProgress.jdField_a_of_type_Int * (float)(jdField_b_of_type_Int - 500L) / jdField_b_of_type_Int) {
        break label201;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Bnyw != null)
      {
        if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Bnyw instanceof bnzl))) {
          ((bnzl)this.jdField_a_of_type_Bnyw).d();
        }
        this.jdField_a_of_type_Bnyw.x();
      }
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a().add(Float.valueOf(this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a()));
      if (QLog.isColorLevel()) {
        QLog.d("CameraSegmentCaptureLayout", 2, "[segmentCapture] segmentPoints add, size = " + this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a().size());
      }
      this.jdField_b_of_type_Float = this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a();
      c(false);
      return;
      label201:
      bool = false;
    }
    label206:
    c(true);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Bnyw != null) {
      this.jdField_a_of_type_Bnyw.B();
    }
    c(true);
  }
  
  protected void a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", segmentShot:" + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            e(true);
            return;
          } while (this.jdField_a_of_type_Bnyw == null);
          this.jdField_a_of_type_Bnyw.z();
          return;
        } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        if (this.jdField_a_of_type_Bnyw != null) {
          this.jdField_a_of_type_Bnyw.x();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        j();
        return;
        b();
        return;
        e(false);
        return;
        if (this.jdField_a_of_type_Bnyw != null) {
          this.jdField_a_of_type_Bnyw.a();
        }
        j();
        return;
      } while ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_Boolean));
      o();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 50L);
      return;
      m();
      return;
    } while (this.jdField_a_of_type_Bnyw == null);
    this.jdField_a_of_type_Bnyw.y();
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", segmentShot:" + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", actionUp:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isOver:" + this.jdField_a_of_type_Boolean);
    }
    boolean bool1;
    if (!this.f) {
      bool1 = super.a(paramView, paramMotionEvent);
    }
    label293:
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            f();
            GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
            bool1 = bool2;
          } while (this.jdField_a_of_type_Boolean);
          switch (paramMotionEvent.getAction() & 0xFF)
          {
          case 2: 
          case 4: 
          default: 
            return false;
          case 0: 
            bool1 = bool2;
          }
        } while (this.jdField_b_of_type_Boolean);
        if ((this.jdField_a_of_type_Bnyw != null) && (this.jdField_a_of_type_Bnyw.g())) {
          break;
        }
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.i("CameraSegmentCaptureLayout", 2, "[segmentCapture] ignore down action, capture not ready");
      return false;
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 1))
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label293;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = true;
        return true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      q();
      return true;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Bnyw == null);
    this.jdField_a_of_type_Bnyw.b();
    return false;
  }
  
  @TargetApi(11)
  protected void c(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Float < 0.0F) {
      this.jdField_c_of_type_Float = 1.45F;
    }
    if ((this.jdField_c_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_c_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_c_of_type_Float, 1.0F });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration((400.0F * (this.jdField_c_of_type_Float - 1.0F) / 0.45F));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bnyy(this));
    float f1 = this.jdField_b_of_type_Float;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a().size() > 0)) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new bnyz(this, paramBoolean, f1));
    }
    this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.85F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bnza(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.b();
    this.jdField_a_of_type_Float = jdField_b_of_type_Int;
    this.f = true;
  }
  
  @TargetApi(11)
  protected void e(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Float < 0.0F) {
      this.jdField_c_of_type_Float = 1.0F;
    }
    if ((this.jdField_c_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_c_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_c_of_type_Float, 1.45F });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration((400.0F * (1.45F - this.jdField_c_of_type_Float) / 0.45F));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bnzb(this));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new bnzc(this, paramBoolean));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bnzd(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(1);
    if (paramBoolean) {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setStrokeWidth(3.0F);
    }
  }
  
  @TargetApi(11)
  public void i()
  {
    if (this.jdField_c_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void m()
  {
    super.m();
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a().clear();
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.d();
    this.jdField_b_of_type_Float = 0.0F;
  }
  
  protected void o()
  {
    float f1 = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Float;
    float f2 = QIMCircleProgress.jdField_a_of_type_Int;
    f1 = this.jdField_b_of_type_Float + f1 * f2;
    if (f1 >= QIMCircleProgress.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      f2 = f1 / QIMCircleProgress.jdField_a_of_type_Int;
      f2 = this.jdField_a_of_type_Float / 1000.0F * f2;
      String str = (int)f2 + "秒";
      if (f2 > this.d) {
        str = (int)(this.jdField_a_of_type_Float / 1000.0F) + "秒";
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText(str);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setProgress(f1);
      if (QLog.isColorLevel()) {
        QLog.i("CameraSegmentCaptureLayout", 2, "updateProgress percent:" + f1 + ", time:" + str + ", maxDuration:" + this.jdField_a_of_type_Float);
      }
      if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Bnyw instanceof bnzl)))
      {
        ((bnzl)this.jdField_a_of_type_Bnyw).d();
        q();
      }
      return;
    }
  }
  
  public void q()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (!this.f)
    {
      super.q();
      return;
    }
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 1))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
      i();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
        }
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
      return;
      a();
      continue;
      a();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      continue;
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
  }
  
  public void setCurrentAnimatorValue(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    super.setMaxDuration(paramFloat);
    this.d = (this.jdField_a_of_type_Float * 0.98F / 1000.0F);
  }
  
  public void setSegment(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */