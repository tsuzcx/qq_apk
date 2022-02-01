package dov.com.tencent.mobileqq.richmedia.capture.view;

import agej;
import android.animation.ObjectAnimator;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bork;
import bozv;
import brew;
import brex;
import brey;
import brez;
import brfa;
import brfb;
import brfc;
import brfd;
import brfe;
import brkm;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class QIMCameraCaptureButtonLayout
  extends RelativeLayout
{
  protected float a;
  protected int a;
  public long a;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  protected ValueAnimator a;
  public Handler a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new brfa(this);
  public View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected brfc a;
  protected brfd a;
  protected brfe a;
  protected CameraCaptureView a;
  public AnimationQIMCircleProgress a;
  public QIMCameraCountTimeLayout a;
  public AtomicBoolean a;
  protected boolean a;
  private int b;
  protected ValueAnimator b;
  public View b;
  public AtomicBoolean b;
  protected boolean b;
  private int c;
  protected View c;
  protected boolean c;
  protected View d;
  protected boolean d;
  protected boolean e = true;
  private boolean f = true;
  private boolean g = true;
  
  public QIMCameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = agej.a(53.0F, getResources());
    this.jdField_c_of_type_Int = agej.a(80.0F, getResources());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new brfb(this, Looper.getMainLooper());
    d();
  }
  
  public QIMCameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = agej.a(53.0F, getResources());
    this.jdField_c_of_type_Int = agej.a(80.0F, getResources());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new brfb(this, Looper.getMainLooper());
    d();
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 4: 
      do
      {
        return;
        if (!bork.a())
        {
          QQToast.a(getContext(), 1, getContext().getString(2131689779), 1).a();
          return;
        }
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
        {
          r();
          return;
        }
      } while (this.jdField_c_of_type_Boolean);
      if (this.jdField_d_of_type_Boolean)
      {
        p();
        return;
      }
      q();
      return;
    }
    q();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_b_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_b_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_c_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_c_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setLayoutParams(localLayoutParams);
  }
  
  public void a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
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
            h();
            return;
          } while (this.jdField_a_of_type_Brfc == null);
          this.jdField_a_of_type_Brfc.j();
          return;
        } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        if (this.jdField_a_of_type_Brfc != null) {
          this.jdField_a_of_type_Brfc.k();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        k();
        return;
        if (this.jdField_a_of_type_Brfc != null) {
          this.jdField_a_of_type_Brfc.q();
        }
        k();
        return;
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      m();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 50L);
      return;
      l();
    } while (this.jdField_a_of_type_Brfc == null);
    this.jdField_a_of_type_Brfc.E();
  }
  
  public void a(brfc parambrfc, CameraCaptureView paramCameraCaptureView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = paramCameraCaptureView;
    this.jdField_a_of_type_Brfc = parambrfc;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", actionUp:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isOver:" + this.jdField_a_of_type_Boolean + ", mTouchEnable:" + this.f);
    }
    f();
    if (!this.f) {
      return false;
    }
    if (this.g) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    }
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (!this.e)
    {
      if ((this.jdField_a_of_type_Brfc != null) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
        this.jdField_a_of_type_Brfc.D();
      }
      return false;
    }
    if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0)
    {
      s();
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
      a();
      return true;
      r();
      return true;
      if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView instanceof EffectsCameraCaptureView)) && (((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).g())) {
        ((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).k();
      }
    }
  }
  
  protected void d()
  {
    LayoutInflater.from(getContext()).inflate(2131560981, this, true);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364188);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)findViewById(2131365187));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131366821);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366824);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setBackgroundResource(2130844470);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterView();
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setVisibility(0);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout = ((QIMCameraCountTimeLayout)findViewById(2131364201));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366091));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131365188);
  }
  
  public void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "alpha", new float[] { 1.0F, 0.0F });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setStartDelay(3000L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(500L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new brew(this));
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void g()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getLayoutParams();
    localLayoutParams.bottomMargin = agej.a(158.0F, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getResources());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setLayoutParams(localLayoutParams);
  }
  
  @TargetApi(11)
  protected void h()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new brex(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new brey(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(1);
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setStrokeWidth(3.0F);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new brez(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void i() {}
  
  @TargetApi(11)
  public void j()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  protected void k()
  {
    a(1.0F);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterScaleValue(1.0F);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText("0秒");
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void l()
  {
    k();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_Brfd != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        r();
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
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setProgress(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CameraCaptureLayout", 2, "updateProgress percent:" + i + ", time:" + str);
      break;
      bool = false;
      break label41;
    }
  }
  
  public void n()
  {
    this.jdField_b_of_type_Boolean = false;
    l();
  }
  
  public void o()
  {
    this.jdField_b_of_type_Boolean = true;
    r();
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Brfe != null) {
      this.jdField_a_of_type_Brfe.a();
    }
  }
  
  public void q()
  {
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    Iterator localIterator = LogicDataManager.getInstance().getEditableWMElement().iterator();
    while (localIterator.hasNext())
    {
      WMElement localWMElement = (WMElement)localIterator.next();
      if (!localWMElement.getCheckInDate().equals(str)) {
        localWMElement.addDays(str);
      }
    }
    if (this.jdField_c_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, "start fail because is started");
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 4)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
      }
      this.jdField_c_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Int != 2);
    r();
  }
  
  public void r()
  {
    if (!this.jdField_c_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, "stop failed because is not start");
      }
    }
    do
    {
      return;
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
      case 3: 
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
        j();
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        }
        for (;;)
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
          return;
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          if (this.jdField_a_of_type_Int == 1) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
          } else if ((this.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_Brfc != null)) {
            this.jdField_a_of_type_Brfc.F();
          }
        }
      case 2: 
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
        return;
      }
    } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    j();
    bozv.a().d(System.currentTimeMillis() - a());
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
  }
  
  public void s()
  {
    e(false);
    if (this.jdField_a_of_type_Brfc != null) {
      this.jdField_a_of_type_Brfc.G();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.e == paramBoolean) {
      return;
    }
    this.e = paramBoolean;
    if (this.e)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setVisibility(8);
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setIsFollowCaptureTips()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin += brkm.a(10.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setRecordTipsWording(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */