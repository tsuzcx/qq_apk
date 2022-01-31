package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aoms;
import aomt;
import aomu;
import aomv;
import aomw;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import java.util.concurrent.atomic.AtomicBoolean;

public class QIMCameraCaptureButtonLayout
  extends RelativeLayout
{
  protected float a;
  protected int a;
  public long a;
  protected ValueAnimator a;
  public Handler a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aomv(this);
  protected View a;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
  public ImageView a;
  protected CameraCaptureView a;
  public QIMCircleProgress a;
  protected QIMCameraCaptureButtonLayout.CaptureButtonListener a;
  protected QIMCameraCaptureButtonLayout.CaptureButtonProgressInterceptor a;
  public QIMCameraCountTimeLayout a;
  public AtomicBoolean a;
  protected boolean a;
  private int b;
  protected ValueAnimator b;
  public AtomicBoolean b;
  protected boolean b;
  private int c;
  protected boolean c;
  
  public QIMCameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = AIOUtils.a(45.0F, getResources());
    this.jdField_c_of_type_Int = AIOUtils.a(70.0F, getResources());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 10000.0F;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new aomw(this, Looper.getMainLooper());
    a();
  }
  
  public QIMCameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = AIOUtils.a(45.0F, getResources());
    this.jdField_c_of_type_Int = AIOUtils.a(70.0F, getResources());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 10000.0F;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new aomw(this, Looper.getMainLooper());
    a();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public QIMCircleProgress a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2130970096, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369006);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress = ((QIMCircleProgress)findViewById(2131369008));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369007));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.setBackgroundResource(2130841743);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.setCenterView();
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.setVisibility(0);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout = ((QIMCameraCountTimeLayout)findViewById(2131369009));
  }
  
  public void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_b_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_b_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_c_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_c_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.setLayoutParams(localLayoutParams);
  }
  
  public void a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        do
        {
          do
          {
            return;
            c();
            return;
          } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener == null);
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener.s();
          return;
        } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener.t();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        e();
        return;
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener.r();
        }
        e();
        return;
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 50L);
      return;
    }
    f();
  }
  
  public void a(QIMCameraCaptureButtonLayout.CaptureButtonListener paramCaptureButtonListener, CameraCaptureView paramCameraCaptureView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = paramCameraCaptureView;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonListener = paramCaptureButtonListener;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", actionUp:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isOver:" + this.jdField_a_of_type_Boolean);
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
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
      }
      this.jdField_c_of_type_Boolean = true;
      return true;
      j();
      return true;
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView instanceof EffectsCameraCaptureView)) && (((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).c())) {
        ((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).t();
      }
    }
  }
  
  public void b() {}
  
  @TargetApi(11)
  protected void c()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.2222F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aoms(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new aomt(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a(1);
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.1F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.setStrokeWidth(3.0F);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aomu(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  @TargetApi(11)
  public void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  protected void e()
  {
    a(1.0F);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText("0秒");
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
  }
  
  public void f()
  {
    e();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonProgressInterceptor != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        j();
      }
      return;
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    boolean bool;
    if ((float)l >= this.jdField_a_of_type_Float)
    {
      bool = true;
      label41:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label155;
      }
    }
    label155:
    for (int i = QIMCircleProgress.jdField_a_of_type_Int;; i = (int)((float)l / this.jdField_a_of_type_Float * QIMCircleProgress.jdField_a_of_type_Int))
    {
      String str = (int)l / 1000 + "秒";
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText(str);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.setProgress(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CameraCaptureLayout", 2, "updateProgress percent:" + i + ", time:" + str);
      break;
      bool = false;
      break label41;
    }
  }
  
  public void h()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = true;
    j();
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
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCircleProgress.a(0);
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        continue;
        if (this.jdField_a_of_type_Int == 2) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        }
      }
    }
  }
  
  public void setCaptureButtonProgressInterceptor(QIMCameraCaptureButtonLayout.CaptureButtonProgressInterceptor paramCaptureButtonProgressInterceptor)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$CaptureButtonProgressInterceptor = paramCaptureButtonProgressInterceptor;
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */