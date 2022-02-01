package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bnky;
import bnqq;
import bnru;
import bpnl;
import bpny;
import bpoj;
import bpok;
import bpol;
import bpom;
import bpon;
import bpoo;
import bpop;
import bptp;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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

public class QIMCameraCaptureButtonLayoutNew
  extends AbsAECaptureButton
{
  protected float a;
  protected int a;
  public long a;
  protected ValueAnimator a;
  protected GLSurfaceView a;
  public Handler a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bpom(this);
  public View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bpny a;
  protected bpoo a;
  protected bpop a;
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
  
  public QIMCameraCaptureButtonLayoutNew(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = AIOUtils.dp2px(53.0F, getResources());
    this.jdField_c_of_type_Int = AIOUtils.dp2px(80.0F, getResources());
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
    this.jdField_a_of_type_AndroidOsHandler = new bpon(this, Looper.getMainLooper());
    e();
  }
  
  public QIMCameraCaptureButtonLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = AIOUtils.dp2px(53.0F, getResources());
    this.jdField_c_of_type_Int = AIOUtils.dp2px(80.0F, getResources());
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
    this.jdField_a_of_type_AndroidOsHandler = new bpon(this, Looper.getMainLooper());
    e();
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
        if (!bnky.a())
        {
          QQToast.a(getContext(), 1, getContext().getString(2131689799), 1).a();
          return;
        }
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
        {
          q();
          return;
        }
      } while (this.jdField_c_of_type_Boolean);
      if (this.jdField_d_of_type_Boolean)
      {
        p();
        return;
      }
      n();
      return;
    }
    n();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
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
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
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
            g();
            return;
          } while (this.jdField_a_of_type_Bpoo == null);
          this.jdField_a_of_type_Bpoo.f();
          return;
        } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        if (this.jdField_a_of_type_Bpoo != null) {
          this.jdField_a_of_type_Bpoo.g();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        j();
        return;
        if (this.jdField_a_of_type_Bpoo != null) {
          this.jdField_a_of_type_Bpoo.h();
        }
        j();
        return;
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      o();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 50L);
      return;
      m();
    } while (this.jdField_a_of_type_Bpoo == null);
    this.jdField_a_of_type_Bpoo.J();
  }
  
  public void a(bpnl parambpnl, int paramInt, GLSurfaceView paramGLSurfaceView)
  {
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
    if ((parambpnl instanceof bpoo))
    {
      this.jdField_a_of_type_Bpoo = ((bpoo)parambpnl);
      return;
    }
    throw new IllegalArgumentException("listener should be instance of SegmentCaptureButtonListener");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress != null) {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(paramBoolean);
    }
    QIMCameraCountTimeLayout localQIMCameraCountTimeLayout;
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout != null)
    {
      localQIMCameraCountTimeLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout;
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (int i = -16777216;; i = -1)
    {
      localQIMCameraCountTimeLayout.setTextColor(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean, bnru parambnru)
  {
    super.a(paramBoolean, parambnru);
  }
  
  public void a(boolean paramBoolean, bpny parambpny)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bpny = parambpny;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a() != 0;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", actionUp:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isOver:" + this.jdField_a_of_type_Boolean + ", mTouchEnable:" + this.f);
    }
    f();
    if (!this.f) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if (this.g) {
              GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
            }
          } while (this.jdField_a_of_type_Boolean);
          if (this.e) {
            break;
          }
        } while ((this.jdField_a_of_type_Bpoo == null) || ((paramMotionEvent.getAction() & 0xFF) != 0));
        this.jdField_a_of_type_Bpoo.b();
        return false;
        if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0)
        {
          r();
          return false;
        }
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        case 2: 
        case 4: 
        default: 
          return false;
        }
      } while (this.jdField_b_of_type_Boolean);
      a();
      return true;
      q();
      return true;
    } while (this.jdField_a_of_type_Bpoo == null);
    this.jdField_a_of_type_Bpoo.a();
    return false;
  }
  
  public void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.dp2px(158.0F, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getResources());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setLayoutParams(localLayoutParams);
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void e()
  {
    LayoutInflater.from(getContext()).inflate(2131560914, this, true);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364286);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)findViewById(2131365303));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131366963);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366966);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setBackgroundResource(2130844414);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterView();
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setVisibility(0);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout = ((QIMCameraCountTimeLayout)findViewById(2131364297));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366221));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131365304);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  @TargetApi(11)
  protected void g()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bpoj(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bpok(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(1);
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setStrokeWidth(3.0F);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bpol(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void h() {}
  
  @TargetApi(11)
  public void i()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  protected void j()
  {
    a(1.0F);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterScaleValue(1.0F);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText("0秒");
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    m();
  }
  
  public void l()
  {
    this.jdField_b_of_type_Boolean = true;
    q();
  }
  
  public void m()
  {
    j();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void n()
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
        QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "start fail because is started");
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
    q();
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_Bpop != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        q();
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
      QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "updateProgress percent:" + i + ", time:" + str);
      break;
      bool = false;
      break label41;
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Bpny != null) {
      this.jdField_a_of_type_Bpny.a();
    }
  }
  
  public void q()
  {
    if (!this.jdField_c_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "stop failed because is not start");
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
        i();
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
          } else if ((this.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_Bpoo != null)) {
            this.jdField_a_of_type_Bpoo.L();
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
    i();
    bnqq.a().d(System.currentTimeMillis() - a());
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
  }
  
  public void r()
  {
    d(false);
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
    localLayoutParams.topMargin += bptp.a(10.0F);
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
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayoutNew
 * JD-Core Version:    0.7.0.1
 */