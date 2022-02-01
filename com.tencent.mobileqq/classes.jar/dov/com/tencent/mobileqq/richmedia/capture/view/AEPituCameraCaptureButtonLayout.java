package dov.com.tencent.mobileqq.richmedia.capture.view;

import afur;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
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
import androidx.annotation.NonNull;
import bgtn;
import bnpy;
import bnqb;
import bnyh;
import bnyl;
import bnyp;
import bnzb;
import bnzg;
import bqce;
import bqcf;
import bqcg;
import bqch;
import bqci;
import bqcj;
import bqck;
import bqcl;
import bqcm;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.view.AECircleCaptureProgressView;
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
  protected float a;
  protected int a;
  public long a;
  protected ValueAnimator a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  public Handler a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bqci(this);
  public View a;
  public bqck a;
  protected bqcl a;
  protected bqcm a;
  protected URLImageView a;
  protected AECameraGLSurfaceView a;
  public AECircleCaptureProgressView a;
  public AnimationQIMCircleProgress a;
  public QIMCameraCountTimeLayout a;
  private String jdField_a_of_type_JavaLangString;
  public AtomicBoolean a;
  protected boolean a;
  protected int b;
  protected ValueAnimator b;
  public View b;
  private String b;
  public AtomicBoolean b;
  protected boolean b;
  private int jdField_c_of_type_Int;
  protected View c;
  private String jdField_c_of_type_JavaLangString;
  protected boolean c;
  private int d;
  protected View d;
  protected boolean d;
  private int e;
  protected boolean e;
  private boolean f;
  private boolean g = true;
  private boolean h;
  private boolean i = true;
  
  public AEPituCameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Int = 20;
    this.jdField_b_of_type_Int = 1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new bqcj(this, Looper.getMainLooper());
    a();
  }
  
  public AEPituCameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_a_of_type_Int = 20;
    this.jdField_b_of_type_Int = 1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new bqcj(this, Looper.getMainLooper());
    a(paramContext, paramAttributeSet);
    a();
  }
  
  private boolean c()
  {
    return ((getContext() instanceof Activity)) && (bnqb.j(((Activity)getContext()).getIntent()));
  }
  
  private boolean d()
  {
    return (bnqb.d(this.jdField_e_of_type_Int)) || (bnqb.c(this.jdField_e_of_type_Int)) || (bnqb.b(this.jdField_e_of_type_Int)) || (bnqb.e(this.jdField_e_of_type_Int));
  }
  
  private void q()
  {
    r();
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new bqch(this));
    if (this.f)
    {
      if (c())
      {
        this.jdField_b_of_type_JavaLangString = bnyp.a().a("circle_camera_ad_icon_url", "", 4);
        this.jdField_c_of_type_JavaLangString = bnyp.a().a("circle_camera_ad_schema", "", 4);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaLangString = bnyp.a().a("camera_ad_icon_url", "", 4);
    this.jdField_c_of_type_JavaLangString = bnyp.a().a("camera_ad_schema", "", 4);
  }
  
  private void r()
  {
    if (c()) {
      this.f = bnyp.a().a("circle_camera_ad_show", false, 4);
    }
    for (this.jdField_a_of_type_JavaLangString = bnyp.a().a("circle_camera_ad_type", "", 4);; this.jdField_a_of_type_JavaLangString = bnyp.a().a("camera_ad_type", "", 4))
    {
      bnzb.b("CameraCaptureLayout", "isPresent: " + this.f + " type: " + this.jdField_a_of_type_JavaLangString);
      if ((!"h5".equals(this.jdField_a_of_type_JavaLangString)) && (!"widget".equals(this.jdField_a_of_type_JavaLangString))) {
        this.f = false;
      }
      return;
      this.f = bnyp.a().a("camera_ad_show", false, 4);
    }
  }
  
  private void s()
  {
    bnzb.b("CameraCaptureLayout", "content entry present.");
    if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if ((this.jdField_b_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      try
      {
        bnzb.b("CameraCaptureLayout", "in url drawable set：" + this.jdField_b_of_type_JavaLangString);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2131167224);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2131167224);
        localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Exception localException)
      {
        bnzb.d("CameraCaptureLayout", "url error url: " + this.jdField_b_of_type_JavaLangString);
        return;
      }
    }
    bnzb.b("CameraCaptureLayout", "iconUrl is empty.");
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 0)) {
      bnyh.a().O();
    }
  }
  
  private void u()
  {
    switch (this.jdField_b_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
        if (!bnpy.a())
        {
          QQToast.a(getContext(), 1, getContext().getString(2131689774), 1).a();
          return;
        }
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
        {
          o();
          return;
        }
      } while (this.jdField_c_of_type_Boolean);
      if (this.jdField_d_of_type_Boolean)
      {
        m();
        return;
      }
      n();
      return;
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        o();
        return;
      }
    } while (this.jdField_c_of_type_Boolean);
    if (this.jdField_d_of_type_Boolean)
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
  
  protected void a()
  {
    if (!this.h)
    {
      LayoutInflater.from(getContext()).inflate(2131560950, this, true);
      this.jdField_c_of_type_Int = afur.a(53.0F, getResources());
      this.jdField_d_of_type_Int = afur.a(80.0F, getResources());
      this.jdField_c_of_type_AndroidViewView = findViewById(2131364147);
      if (this.h) {
        break label277;
      }
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)findViewById(2131365143));
      label83:
      this.jdField_b_of_type_AndroidViewView = findViewById(2131366770);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131364087));
      q();
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidViewView.setEnabled(true);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131366773);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      if (this.h) {
        break label294;
      }
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setBackgroundResource(2130844456);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterView();
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setVisibility(0);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout = ((QIMCameraCountTimeLayout)findViewById(2131364160));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setIsCircleStyle(this.h);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131365144);
      return;
      LayoutInflater.from(getContext()).inflate(2131558484, this, true);
      this.jdField_c_of_type_Int = afur.a(95.0F, getResources());
      this.jdField_d_of_type_Int = afur.a(86.25F, getResources());
      break;
      label277:
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView = ((AECircleCaptureProgressView)findViewById(2131365143));
      break label83;
      label294:
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setCenterView();
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(0);
    }
  }
  
  public void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_c_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_c_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    if (!this.h)
    {
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
    this.h = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }
  
  public void a(Message paramMessage)
  {
    bnzb.b("CameraCaptureLayout", "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
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
          } while (this.jdField_a_of_type_Bqck == null);
          this.jdField_a_of_type_Bqck.c();
          return;
        } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        if (this.jdField_a_of_type_Bqck != null) {
          this.jdField_a_of_type_Bqck.g();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        f();
        setVisibility(8);
        return;
        if (this.jdField_a_of_type_Bqck != null) {
          this.jdField_a_of_type_Bqck.i();
        }
        f();
        return;
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      h();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 50L);
      return;
      g();
    } while (this.jdField_a_of_type_Bqck == null);
    this.jdField_a_of_type_Bqck.j();
  }
  
  public void a(bqck parambqck, int paramInt, AECameraGLSurfaceView paramAECameraGLSurfaceView)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = paramAECameraGLSurfaceView;
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_a_of_type_Bqck = parambqck;
    j();
  }
  
  public void a(boolean paramBoolean)
  {
    QIMCameraCountTimeLayout localQIMCameraCountTimeLayout;
    if (!this.h)
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
  
  public void a(boolean paramBoolean, @NonNull bnzg parambnzg)
  {
    if (!this.h) {
      if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress != null) {
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(paramBoolean, parambnzg);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout != null) && (paramBoolean))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setTextColor(parambnzg.f);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setTextShadow(parambnzg.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setDotView(parambnzg.jdField_e_of_type_Int);
      }
      return;
      if (this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView != null) {
        this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(paramBoolean, parambnzg);
      }
    }
  }
  
  public void a(boolean paramBoolean, bqcm parambqcm)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bqcm = parambqcm;
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!QLog.isDevelopLevel()) || (!this.g)) {}
    do
    {
      do
      {
        return false;
        if (this.i) {
          GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
        }
      } while ((this.jdField_a_of_type_Boolean) || (!this.jdField_e_of_type_Boolean));
      if ((this.jdField_a_of_type_Bqck != null) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
        this.jdField_a_of_type_Bqck.h();
      }
      if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0)
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
      }
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    u();
    return true;
    o();
    return true;
    return true;
  }
  
  public void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getLayoutParams();
    localLayoutParams.bottomMargin = afur.a(158.0F, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.getResources());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setLayoutParams(localLayoutParams);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int j = this.jdField_c_of_type_AndroidViewView.getHeight();
      if (j != 0)
      {
        j = j / 2 - bgtn.a(86.0F);
        if (!this.h) {
          this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setTranslationY(j);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setTranslationY(j);
          return;
          this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setTranslationY(j);
        }
      }
      if (!this.h) {
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setTranslationY(bgtn.a(17.0F));
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setTranslationY(bgtn.a(17.0F));
        return;
        this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setTranslationY(bgtn.a(17.0F));
      }
    }
    if (!this.h) {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setTranslationY(bgtn.a(17.0F));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setTranslationY(bgtn.a(17.0F));
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setTranslationY(bgtn.a(17.0F));
    }
  }
  
  public boolean b()
  {
    if (!this.h) {
      if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a() == 0) {}
    }
    while (this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a() != 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  @TargetApi(11)
  protected void c()
  {
    if (!this.h)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.45F });
      if (this.h) {
        break label198;
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
      label45:
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bqce(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bqcf(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      if (this.h) {
        break label212;
      }
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(1);
      label97:
      if (this.h) {
        break label223;
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setStrokeWidth(3.0F);
      label134:
      if (this.h) {
        break label256;
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bqcg(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
      return;
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.333333F });
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
    if (!this.h)
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
    if (this.jdField_a_of_type_Bqcl != null) {}
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
        if (this.h) {
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
  
  public void i()
  {
    if (!this.f)
    {
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      bnzb.a("CameraCaptureLayout", "hide camera content entry.");
      return;
    }
    if (bnqb.h(this.jdField_e_of_type_Int))
    {
      s();
      return;
    }
    if (bnqb.g(this.jdField_e_of_type_Int))
    {
      t();
      s();
      return;
    }
    if (d())
    {
      if ("h5".equals(bnyp.a().a("camera_ad_type", "", 4)))
      {
        t();
        s();
        return;
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      this.f = false;
      return;
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    this.f = false;
  }
  
  public void j()
  {
    if (c()) {
      return;
    }
    if (d())
    {
      this.f = "h5".equals(bnyp.a().a("camera_ad_type", "", 4));
      return;
    }
    this.f = bnqb.g(this.jdField_e_of_type_Int);
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    g();
  }
  
  public void l()
  {
    this.jdField_b_of_type_Boolean = true;
    o();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Bqcm != null) {
      this.jdField_a_of_type_Bqcm.a();
    }
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
      bnzb.b("CameraCaptureLayout", "start fail because is started");
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
    if (!this.jdField_c_of_type_Boolean)
    {
      bnzb.b("CameraCaptureLayout", "stop failed because is not start");
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
      e();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        if (this.h) {
          break;
        }
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
        return;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        } else if ((this.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Bqck != null)) {
          this.jdField_a_of_type_Bqck.k();
        }
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(0);
      return;
    case 2: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      this.jdField_c_of_type_Boolean = false;
      if (!this.h)
      {
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
        return;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(0);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      bnzb.a("CameraCaptureLayout", "in stop capture 1");
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      e();
      bnyl.a().d(System.currentTimeMillis() - a());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      this.jdField_c_of_type_Boolean = false;
      if (!this.h)
      {
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
        return;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.a(0);
      return;
    }
    bnzb.a("CameraCaptureLayout", "in stop capture 2 " + this.jdField_c_of_type_Boolean);
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
      if (this.h)
      {
        this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if (this.h)
    {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeViewAECircleCaptureProgressView.setVisibility(8);
  }
  
  public void setEntryPresent(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView == null) || (!this.f)) {
      return;
    }
    if (paramBoolean)
    {
      i();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float / 1000.0F));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */