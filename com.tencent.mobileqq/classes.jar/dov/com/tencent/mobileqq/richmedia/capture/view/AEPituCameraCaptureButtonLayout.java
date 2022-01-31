package dov.com.tencent.mobileqq.richmedia.capture.view;

import actj;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bbll;
import bcql;
import birt;
import bizt;
import bizx;
import bjaa;
import bjah;
import bkvj;
import bkvk;
import bkvl;
import bkvm;
import bkvn;
import bkvo;
import bkvp;
import bkvq;
import bkvr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AEPituCameraCaptureButtonLayout
  extends RelativeLayout
{
  private static boolean f;
  protected float a;
  protected int a;
  public long a;
  protected ValueAnimator a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  public Handler a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bkvn(this);
  public View a;
  public bkvp a;
  protected bkvq a;
  protected bkvr a;
  protected URLImageView a;
  protected AECameraGLSurfaceView a;
  public AnimationQIMCircleProgress a;
  public QIMCameraCountTimeLayout a;
  private String jdField_a_of_type_JavaLangString;
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
  private int d;
  protected View d;
  protected boolean d;
  protected boolean e = true;
  private boolean g = true;
  private boolean h = true;
  
  public AEPituCameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = actj.a(53.0F, getResources());
    this.jdField_c_of_type_Int = actj.a(80.0F, getResources());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new bkvo(this, Looper.getMainLooper());
    a();
  }
  
  public AEPituCameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = actj.a(53.0F, getResources());
    this.jdField_c_of_type_Int = actj.a(80.0F, getResources());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new bkvo(this, Looper.getMainLooper());
    a();
  }
  
  public static boolean a()
  {
    return f;
  }
  
  private boolean c()
  {
    return (birt.d(this.jdField_d_of_type_Int)) || (birt.c(this.jdField_d_of_type_Int)) || (birt.b(this.jdField_d_of_type_Int)) || (birt.e(this.jdField_d_of_type_Int));
  }
  
  public static void i()
  {
    f = bjaa.a().a("camera_ad_show", false, 4);
    String str = bjaa.a().a("camera_ad_type", "", 4);
    bjah.b("CameraCaptureLayout", "isPresent: " + f + " type: " + str);
    if ((!"h5".equals(str)) && (!"widget".equals(str))) {
      f = false;
    }
  }
  
  private void r()
  {
    i();
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new bkvm(this));
    if (f) {
      this.jdField_a_of_type_JavaLangString = bjaa.a().a("camera_ad_icon_url", "", 4);
    }
  }
  
  private void s()
  {
    bjah.b("CameraCaptureLayout", "content entry present.");
    if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      try
      {
        bjah.b("CameraCaptureLayout", "in url drawable set：" + this.jdField_a_of_type_JavaLangString);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2131167087);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2131167087);
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Exception localException)
      {
        bjah.d("CameraCaptureLayout", "url error url: " + this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    bjah.b("CameraCaptureLayout", "iconUrl is empty.");
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 0)) {
      bizt.a().v();
    }
  }
  
  private void u()
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
        if (!FeatureManager.isBasicFeaturesFunctionReady())
        {
          bcql.a(getContext(), 1, getContext().getString(2131689826), 1).a();
          return;
        }
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
        {
          p();
          return;
        }
      } while (this.jdField_c_of_type_Boolean);
      if (this.jdField_d_of_type_Boolean)
      {
        n();
        return;
      }
      o();
      return;
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        p();
        return;
      }
    } while (this.jdField_c_of_type_Boolean);
    if (this.jdField_d_of_type_Boolean)
    {
      n();
      return;
    }
    o();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2131560551, this, true);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131363884);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)findViewById(2131364821));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131366393);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131363826));
    r();
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366396);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setBackgroundResource(2130843628);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterView();
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setVisibility(0);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout = ((QIMCameraCountTimeLayout)findViewById(2131363899));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131364822);
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
            c();
            return;
          } while (this.jdField_a_of_type_Bkvp == null);
          this.jdField_a_of_type_Bkvp.g();
          return;
        } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        if (this.jdField_a_of_type_Bkvp != null) {
          this.jdField_a_of_type_Bkvp.h();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        f();
        return;
        if (this.jdField_a_of_type_Bkvp != null) {
          this.jdField_a_of_type_Bkvp.j();
        }
        f();
        return;
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      h();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 50L);
      return;
      g();
    } while (this.jdField_a_of_type_Bkvp == null);
    this.jdField_a_of_type_Bkvp.k();
  }
  
  public void a(bkvp parambkvp, int paramInt, AECameraGLSurfaceView paramAECameraGLSurfaceView)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = paramAECameraGLSurfaceView;
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_Bkvp = parambkvp;
    k();
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
  
  public void a(boolean paramBoolean, bkvr parambkvr)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bkvr = parambkvr;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", actionUp:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isOver:" + this.jdField_a_of_type_Boolean + ", mTouchEnable:" + this.g);
    }
    if (!this.g) {}
    do
    {
      do
      {
        return false;
        if (this.h) {
          GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
        }
      } while ((this.jdField_a_of_type_Boolean) || (!this.e));
      if ((this.jdField_a_of_type_Bkvp != null) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
        this.jdField_a_of_type_Bkvp.i();
      }
      if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0)
      {
        q();
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
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    u();
    return true;
    p();
    return true;
    return true;
  }
  
  public void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getLayoutParams();
    localLayoutParams.bottomMargin = actj.a(158.0F, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getResources());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setLayoutParams(localLayoutParams);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = this.jdField_c_of_type_AndroidViewView.getHeight();
      if (i != 0)
      {
        i = i / 2 - bbll.a(86.0F);
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setTranslationY(i);
        this.jdField_b_of_type_AndroidViewView.setTranslationY(i);
        return;
      }
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setTranslationY(bbll.a(17.0F));
      this.jdField_b_of_type_AndroidViewView.setTranslationY(bbll.a(17.0F));
      return;
    }
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setTranslationY(bbll.a(17.0F));
    this.jdField_b_of_type_AndroidViewView.setTranslationY(bbll.a(17.0F));
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a() != 0;
  }
  
  @TargetApi(11)
  protected void c()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bkvj(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bkvk(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(1);
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setStrokeWidth(3.0F);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bkvl(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void d() {}
  
  @TargetApi(11)
  public void e()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  protected void f()
  {
    a(1.0F);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterScaleValue(1.0F);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText("0秒");
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void g()
  {
    f();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_Bkvq != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        p();
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
  
  public void j()
  {
    if (!f)
    {
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      bjah.a("CameraCaptureLayout", "hide camera content entry.");
      return;
    }
    if (birt.g(this.jdField_d_of_type_Int))
    {
      t();
      s();
      return;
    }
    if (c())
    {
      if ("h5".equals(bjaa.a().a("camera_ad_type", "", 4)))
      {
        t();
        s();
        return;
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      f = false;
      return;
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    f = false;
  }
  
  public void k()
  {
    if (c())
    {
      f = "h5".equals(bjaa.a().a("camera_ad_type", "", 4));
      return;
    }
    f = birt.g(this.jdField_d_of_type_Int);
  }
  
  public void l()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    g();
  }
  
  public void m()
  {
    this.jdField_b_of_type_Boolean = true;
    p();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Bkvr != null) {
      this.jdField_a_of_type_Bkvr.a();
    }
  }
  
  public void o()
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
    p();
  }
  
  public void p()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, "stop failed because is not start");
      }
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
    case 3: 
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      e();
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
        } else if ((this.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_Bkvp != null)) {
          this.jdField_a_of_type_Bkvp.l();
        }
      }
    case 2: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      bjah.a("CameraCaptureLayout", "in stop capture 1");
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      e();
      bizx.a().d(System.currentTimeMillis() - a());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
      return;
    }
    bjah.a("CameraCaptureLayout", "in stop capture 2 " + this.jdField_c_of_type_Boolean);
  }
  
  public void q()
  {
    c(false);
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
  
  public void setEntryPresent(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView == null) || (!f)) {
      return;
    }
    if (paramBoolean)
    {
      j();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setOriginIntent(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */