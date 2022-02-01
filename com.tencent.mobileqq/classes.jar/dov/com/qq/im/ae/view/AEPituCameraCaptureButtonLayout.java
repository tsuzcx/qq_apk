package dov.com.qq.im.ae.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
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
import androidx.annotation.NonNull;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AECommonUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton.CaptureListener;
import dov.com.tencent.mobileqq.richmedia.capture.view.IAECaptureButton.CountDownDelegate;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCountTimeLayout;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class AEPituCameraCaptureButtonLayout
  extends AbsAECaptureButton
{
  protected float a;
  protected int a;
  protected long a;
  protected ValueAnimator a;
  protected Handler a;
  private View.OnTouchListener a;
  public View a;
  protected BubbleTextView a;
  protected AECameraGLSurfaceView a;
  protected AECircleCaptureProgressView a;
  protected AEPituCameraCaptureButtonLayout.CaptureButtonProgressInterceptor a;
  protected AEPituCameraCaptureButtonLayout.PituCaptureButtonListener a;
  protected AnimationQIMCircleProgress a;
  protected IAECaptureButton.CountDownDelegate a;
  protected QIMCameraCountTimeLayout a;
  protected Runnable a;
  protected AtomicBoolean a;
  protected boolean a;
  protected int b;
  protected ValueAnimator b;
  public View b;
  private Runnable b;
  protected AtomicBoolean b;
  protected boolean b;
  private int c;
  protected View c;
  protected boolean c;
  private int d;
  protected View d;
  protected boolean d;
  protected View e;
  protected boolean e;
  private boolean f = true;
  private boolean g;
  private boolean h = true;
  private boolean i = true;
  
  public AEPituCameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Int = 20;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new AEPituCameraCaptureButtonLayout.5(this);
    this.jdField_a_of_type_AndroidOsHandler = new AEPituCameraCaptureButtonLayout.7(this, Looper.getMainLooper());
    a();
  }
  
  public AEPituCameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Int = 20;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new AEPituCameraCaptureButtonLayout.5(this);
    this.jdField_a_of_type_AndroidOsHandler = new AEPituCameraCaptureButtonLayout.7(this, Looper.getMainLooper());
    a(paramContext, paramAttributeSet);
    a();
  }
  
  private void a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      a(paramView, paramMotionEvent);
      return;
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setAction(0);
      a(paramView, paramMotionEvent);
      paramMotionEvent.recycle();
    }
    this.jdField_b_of_type_JavaLangRunnable = null;
  }
  
  private boolean b()
  {
    return ((getContext() instanceof Activity)) && (AECameraEntry.k(((Activity)getContext()).getIntent()));
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    for (;;)
    {
      boolean bool1;
      try
      {
        if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
        {
          bool1 = c(paramView, paramMotionEvent);
          return bool1;
        }
        if (paramMotionEvent.getAction() == 0)
        {
          if (this.jdField_b_of_type_JavaLangRunnable == null) {
            this.jdField_b_of_type_JavaLangRunnable = new AEPituCameraCaptureButtonLayout.6(this, paramView, paramMotionEvent);
          }
          ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
          bool1 = bool2;
          continue;
        }
        bool1 = bool2;
      }
      finally {}
      if (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() >= 100L)
      {
        a(paramView, paramMotionEvent);
        bool1 = bool2;
      }
    }
  }
  
  private boolean c(View paramView, MotionEvent paramMotionEvent)
  {
    a(paramView, paramMotionEvent);
    return a(paramView, paramMotionEvent);
  }
  
  private void q()
  {
    switch (this.jdField_b_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
        if (!AEResUtil.a())
        {
          QQToast.a(getContext(), 1, getContext().getString(2131689839), 1).a();
          return;
        }
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
        {
          o();
          return;
        }
      } while (this.jdField_c_of_type_Boolean);
      if ((this.h) && (this.jdField_d_of_type_Boolean))
      {
        m();
        return;
      }
      n();
      return;
      AEQLog.a("CameraCaptureLayout", "checkStartCapture: isStarting = " + this.jdField_c_of_type_Boolean + " | shortVideoShot = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " | countDownEnable = " + this.jdField_d_of_type_Boolean);
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        o();
        return;
      }
    } while (this.jdField_c_of_type_Boolean);
    if ((this.h) && (this.jdField_d_of_type_Boolean))
    {
      m();
      return;
    }
    n();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  protected void a()
  {
    if (!this.g)
    {
      LayoutInflater.from(getContext()).inflate(2131561004, this, true);
      this.jdField_c_of_type_Int = AIOUtils.a(53.0F, getResources());
      this.jdField_d_of_type_Int = AIOUtils.a(80.0F, getResources());
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)findViewById(2131365444));
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setBackgroundResource(2130844604);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterView();
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setVisibility(0);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView = findViewById(2131364392);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131367155);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidViewView.setEnabled(true);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131367158);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout = ((QIMCameraCountTimeLayout)findViewById(2131364403));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setIsCircleStyle(this.g);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131365445);
      return;
      LayoutInflater.from(getContext()).inflate(2131558486, this, true);
      this.jdField_c_of_type_Int = AIOUtils.a(98.0F, getResources());
      this.jdField_d_of_type_Int = AIOUtils.a(98.0F, getResources());
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView = ((AECircleCaptureProgressView)findViewById(2131365444));
      this.jdField_d_of_type_AndroidViewView = findViewById(2131369471);
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setCenterView();
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = ((BubbleTextView)findViewById(2131364194));
    }
  }
  
  protected void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_c_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_c_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    if (!this.g)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.getLayoutParams();
      localLayoutParams.width = ((int)(this.jdField_d_of_type_Int * paramFloat));
      localLayoutParams.height = ((int)(this.jdField_d_of_type_Int * paramFloat));
      localLayoutParams.addRule(13);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setLayoutParams(localLayoutParams);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(paramFloat);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {}
    do
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AEPituCameraCaptureButtonLayout);
    } while (paramContext == null);
    this.g = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }
  
  protected void a(Message paramMessage)
  {
    AEQLog.b("CameraCaptureLayout", "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
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
            do
            {
              return;
              e();
              return;
              this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(0);
            } while (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener == null);
            this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener.f();
            return;
          } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
          if (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener != null) {
            this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener.g();
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          h();
          setVisibility(8);
          return;
          if (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener != null) {
            this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener.l();
          }
          h();
        } while (!b());
        paramMessage = new HashMap();
        if (AEMaterialManager.a() != null) {
          paramMessage.put("ext2", AEMaterialManager.a().a);
        }
        if (AEMaterialManager.b() != null) {
          paramMessage.put("ext3", AEMaterialManager.b().a);
        }
        AEMaterialManager localAEMaterialManager = (AEMaterialManager)QIMManager.a(18);
        if (localAEMaterialManager != null) {
          paramMessage.put("ext4", localAEMaterialManager.a());
        }
        AEReportUtils.a(2, 4, paramMessage);
        return;
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      j();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 50L);
      return;
      i();
    } while (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener == null);
    this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener.J();
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {}
    while (AECommonUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView, paramMotionEvent)) {
      return;
    }
    b();
  }
  
  public void a(AbsAECaptureButton.CaptureListener paramCaptureListener, int paramInt, GLSurfaceView paramGLSurfaceView)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)paramGLSurfaceView);
    if ((paramCaptureListener instanceof AEPituCameraCaptureButtonLayout.PituCaptureButtonListener))
    {
      this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener = ((AEPituCameraCaptureButtonLayout.PituCaptureButtonListener)paramCaptureListener);
      return;
    }
    throw new IllegalArgumentException("arg listener must be instance of PituCaptureButtonListener");
  }
  
  public void a(boolean paramBoolean)
  {
    QIMCameraCountTimeLayout localQIMCameraCountTimeLayout;
    if (!this.g)
    {
      if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress != null) {
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(paramBoolean);
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout != null)
      {
        localQIMCameraCountTimeLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout;
        if (!paramBoolean) {
          break label66;
        }
      }
    }
    label66:
    for (int j = -16777216;; j = -1)
    {
      localQIMCameraCountTimeLayout.setTextColor(j);
      return;
      if (this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView == null) {
        break;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(paramBoolean);
      break;
    }
  }
  
  public void a(boolean paramBoolean, @NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    if (!this.g) {
      if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress != null) {
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(paramBoolean, paramAECircleCaptureStyle);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout != null) && (paramBoolean))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setTextColor(paramAECircleCaptureStyle.i);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setTextShadow(paramAECircleCaptureStyle.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setDotView(paramAECircleCaptureStyle.h);
      }
      return;
      if (this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView != null) {
        this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(paramBoolean, paramAECircleCaptureStyle);
      }
      if (this.jdField_d_of_type_AndroidViewView != null)
      {
        int j = paramAECircleCaptureStyle.e;
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(j);
      }
    }
  }
  
  public void a(boolean paramBoolean, IAECaptureButton.CountDownDelegate paramCountDownDelegate)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewIAECaptureButton$CountDownDelegate = paramCountDownDelegate;
  }
  
  public boolean a()
  {
    if (!this.g) {
      if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a() == 0) {}
    }
    while (this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a() != 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!QLog.isDevelopLevel()) || (!this.f)) {}
    do
    {
      do
      {
        return false;
        if ((this.i) && (paramMotionEvent.getAction() != 1)) {
          GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
        }
      } while ((this.jdField_a_of_type_Boolean) || (!this.jdField_e_of_type_Boolean));
      if ((this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener != null) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
        this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener.K();
      }
      if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)
      {
        p();
        return false;
      }
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      case 4: 
      default: 
        return false;
      case 0: 
        b();
      }
    } while (this.jdField_b_of_type_Boolean);
    q();
    return true;
    o();
    return true;
    if (!this.g) {
      o();
    }
    for (;;)
    {
      return true;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(8);
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (paramBoolean)
    {
      j = this.jdField_c_of_type_AndroidViewView.getHeight();
      if (j != 0)
      {
        j = j / 2 - ViewUtils.a(86.0F);
        if (!this.g)
        {
          this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setTranslationY(j);
          this.jdField_b_of_type_AndroidViewView.setTranslationY(j);
        }
      }
    }
    while (this.g)
    {
      for (;;)
      {
        int j;
        return;
        this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setTranslationY(j);
      }
      if (!this.g) {
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setTranslationY(ViewUtils.a(17.0F));
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setTranslationY(ViewUtils.a(17.0F));
        return;
        this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setTranslationY(ViewUtils.a(17.0F));
      }
    }
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setTranslationY(ViewUtils.a(17.0F));
    this.jdField_b_of_type_AndroidViewView.setTranslationY(ViewUtils.a(17.0F));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {}
    while ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getVisibility() == 0) || (AECameraPrefsUtil.a().a("sp_key_ae_photo_photo_video_take_tips", false, 0))) {
      return;
    }
    AECameraPrefsUtil.a().a("sp_key_ae_photo_photo_video_take_tips", true, 0);
    int j = UIUtils.a(getContext(), 8.0F);
    int k = UIUtils.a(getContext(), 6.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(j, k, j, k);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Int = Color.parseColor("#252525");
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.b = UIUtils.a(getContext(), 6.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(getContext().getString(2131689696));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(0);
    this.jdField_a_of_type_JavaLangRunnable = new AEPituCameraCaptureButtonLayout.1(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.a(158.0F, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getResources());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setLayoutParams(localLayoutParams);
  }
  
  @TargetApi(11)
  protected void e()
  {
    if (!this.g)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
      if (this.g) {
        break label198;
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
      label45:
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new AEPituCameraCaptureButtonLayout.2(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new AEPituCameraCaptureButtonLayout.3(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      if (this.g) {
        break label212;
      }
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(1);
      label97:
      if (this.g) {
        break label223;
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setStrokeWidth(3.0F);
      label134:
      if (this.g) {
        break label256;
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new AEPituCameraCaptureButtonLayout.4(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
      return;
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.1735F });
      break;
      label198:
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
      break label45;
      label212:
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(1);
      break label97;
      label223:
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.6F });
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setStrokeWidth(5.0F);
      break label134;
      label256:
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    }
  }
  
  protected void f() {}
  
  @TargetApi(11)
  protected void g()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  protected void h()
  {
    a(1.0F);
    if (!this.g)
    {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setProgress(0.0F);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterScaleValue(1.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText("0秒");
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setEnabled(true);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setProgress(0.0F);
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setCenterScaleValue(1.0F);
    }
  }
  
  public void i()
  {
    h();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$CaptureButtonProgressInterceptor != null) {}
    label142:
    label152:
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        o();
      }
      return;
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      boolean bool;
      label41:
      int j;
      if ((float)l >= this.jdField_a_of_type_Float)
      {
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        if (!this.jdField_a_of_type_Boolean) {
          break label125;
        }
        j = QIMCircleProgress.jdField_a_of_type_Int;
        label58:
        String str = (int)l / 1000 + "秒";
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText(str);
        if (this.g) {
          break label142;
        }
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setProgress(j);
      }
      for (;;)
      {
        if (!QLog.isDevelopLevel()) {
          break label152;
        }
        break;
        bool = false;
        break label41;
        label125:
        j = (int)((float)l / this.jdField_a_of_type_Float * QIMCircleProgress.jdField_a_of_type_Int);
        break label58;
        this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setProgress(j);
      }
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    c();
    i();
  }
  
  public void l()
  {
    this.jdField_b_of_type_Boolean = true;
    o();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewIAECaptureButton$CountDownDelegate != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewIAECaptureButton$CountDownDelegate.a();
    }
  }
  
  public void n()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    AEQLog.a("CameraCaptureLayout", "startCapture: 开始拍摄");
    if (this.jdField_c_of_type_Boolean) {
      AEQLog.b("CameraCaptureLayout", "start fail because is started");
    }
    do
    {
      return;
      if ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 4)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
      }
      this.jdField_c_of_type_Boolean = true;
    } while (this.jdField_b_of_type_Int != 2);
    o();
  }
  
  public void o()
  {
    AEQLog.a("CameraCaptureLayout", "stopCapture: 结束拍摄 | shortVideoShot = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " | mActionUpAnimator = " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    if (!this.jdField_c_of_type_Boolean)
    {
      AEQLog.b("CameraCaptureLayout", "stop failed because is not start");
      return;
    }
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 1: 
    case 3: 
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      g();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        if (this.g) {
          break;
        }
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
        return;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        if (this.jdField_b_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        }
        else if (this.jdField_b_of_type_Int == 3)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          if (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener != null) {
            this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout$PituCaptureButtonListener.L();
          }
        }
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(0);
      return;
    case 2: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      this.jdField_c_of_type_Boolean = false;
      if (!this.g)
      {
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
        return;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(0);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      AEQLog.a("CameraCaptureLayout", "in stop capture 1");
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      g();
      AEBaseReportParam.a().d(System.currentTimeMillis() - a());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      this.jdField_c_of_type_Boolean = false;
      if (!this.g)
      {
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
        return;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(0);
      return;
    }
    AEQLog.a("CameraCaptureLayout", "in stop capture 2 " + this.jdField_c_of_type_Boolean);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      b();
    }
  }
  
  public void p()
  {
    c(false);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (this.g)
      {
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if (this.g)
    {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setVisibility(8);
  }
  
  public void setFunctionFlag(int paramInt)
  {
    if (paramInt != -1) {
      this.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float / 1000.0F));
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */