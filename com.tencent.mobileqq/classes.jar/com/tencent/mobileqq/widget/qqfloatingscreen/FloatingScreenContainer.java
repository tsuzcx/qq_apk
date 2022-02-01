package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import assm;
import bivy;
import bivz;
import biwa;
import biwb;
import biwc;
import biwd;
import biwe;
import biwf;
import biwg;
import biwn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class FloatingScreenContainer
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private biwe jdField_a_of_type_Biwe;
  private biwf jdField_a_of_type_Biwf;
  private biwg jdField_a_of_type_Biwg;
  private FloatingScreenParams jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private FloatingScreenParams jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = -1.0F;
  private int jdField_c_of_type_Int = 20;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float = 1.0F;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f = -1;
  private int g = -1;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public FloatingScreenContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatingScreenContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatingScreenContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    if (this.jdField_a_of_type_AndroidViewWindowManager != null)
    {
      this.e = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight();
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getWidth();
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.jdField_b_of_type_Int = 2038;
      return;
    }
    this.jdField_b_of_type_Int = 2002;
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent == null) || (paramMotionEvent.getPointerCount() != 2)) {
      return 0.0F;
    }
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getCanMove())
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setShapeType(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getShapeType());
      this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setFloatingCenterX(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX() + paramInt1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setFloatingCenterY(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY() + paramInt2);
      a(a(this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams, false));
    }
  }
  
  private void a(Context paramContext)
  {
    if (paramContext != null) {
      this.jdField_c_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    }
  }
  
  private void a(FrameLayout.LayoutParams paramLayoutParams, float paramFloat)
  {
    int n;
    int m;
    if ((this.jdField_d_of_type_Int != 0) && (this.e != 0))
    {
      if (paramFloat < this.jdField_d_of_type_Int / this.e) {
        break label55;
      }
      n = this.jdField_d_of_type_Int;
      m = (int)(n / paramFloat);
    }
    for (;;)
    {
      paramLayoutParams.width = n;
      paramLayoutParams.height = m;
      return;
      label55:
      m = this.e;
      n = (int)(m * paramFloat);
    }
  }
  
  private void a(FrameLayout.LayoutParams paramLayoutParams, float paramFloat, boolean paramBoolean)
  {
    float f1 = 1.0F;
    int i1 = -1;
    int m;
    int n;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getShapeType() == 1)
    {
      f1 = 1.0F / this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getScreenRatio();
      if (Math.abs(paramFloat - f1) >= 0.1D) {
        break label112;
      }
      if (!paramBoolean) {
        break label246;
      }
      this.f = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getInitialWidth();
      this.g = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getInitialHeight();
      m = -1;
      n = i1;
    }
    for (;;)
    {
      paramLayoutParams.width = n;
      paramLayoutParams.height = m;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getShapeType() != 2) {
        break;
      }
      f1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getScreenRatio();
      break;
      label112:
      if (paramFloat > f1)
      {
        int i2 = (int)Math.ceil(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getWidth() / paramFloat);
        m = i2;
        n = i1;
        if (paramBoolean)
        {
          this.f = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getInitialWidth();
          this.g = ((int)Math.ceil(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getInitialWidth() / paramFloat));
          m = i2;
          n = i1;
        }
      }
      else
      {
        n = (int)Math.ceil(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getHeight() * paramFloat);
        if (paramBoolean)
        {
          this.g = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getInitialHeight();
          this.f = ((int)Math.ceil(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getInitialHeight() * paramFloat));
        }
        m = -1;
        continue;
        label246:
        m = -1;
        n = i1;
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
    }
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 17;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = paramInt1;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = paramInt2;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = (this.h + (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth() - this.j) / 2);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = (this.i + (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight() - this.k) / 2);
    a(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
  
  private void b(WindowManager.LayoutParams paramLayoutParams)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.clone();
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 1.0F });
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null)
    {
      if (this.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()) {
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewWindowManager, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new biwa(this, paramLayoutParams));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new biwb(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.clone();
    if (paramBoolean) {
      l();
    }
    n = 28;
    m = n;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      m = n;
      if (this.jdField_a_of_type_AndroidContentContext.getResources() != null) {
        m = AIOUtils.dp2px(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
    }
    i1 = 0;
    n = i1;
    try
    {
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        n = i1;
        if (this.jdField_a_of_type_AndroidContentContext.getResources() != null)
        {
          i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
          n = i1;
          if (i2 > 0) {
            n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(i2);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i2;
        int i3;
        WindowManager.LayoutParams localLayoutParams;
        int i4;
        localException.printStackTrace();
        n = i1;
        continue;
        m = i1;
        continue;
      }
    }
    i1 = this.jdField_d_of_type_Int / 2 - m - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth() / 2;
    i3 = this.e / 2 - m - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight() / 2;
    i2 = -i3 + n;
    m = -this.jdField_d_of_type_Int;
    n = -this.e;
    localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    localLayoutParams.gravity = 17;
    if (localLayoutParams.x < -i1) {
      m = -i1;
    }
    if (localLayoutParams.x > i1) {
      m = i1;
    }
    if (localLayoutParams.y < i2) {
      n = i2;
    }
    if (localLayoutParams.y > i3)
    {
      n = i3;
      if ((localLayoutParams.x > -i1) && (localLayoutParams.x < i1)) {
        if (localLayoutParams.x < 0)
        {
          m = -i1;
          if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
          {
            if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
              this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
            }
            this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
          }
          this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setTarget(this);
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
          i3 = localLayoutParams.x;
          i4 = localLayoutParams.y;
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bivy(this, m, i1, localLayoutParams, i3, n, i2, i4));
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bivz(this));
          this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          if (this.jdField_a_of_type_Biwf != null) {
            this.jdField_a_of_type_Biwf.b();
          }
          return;
        }
      }
    }
  }
  
  private void c(float paramFloat)
  {
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      h();
      i();
      j();
      r();
      this.jdField_c_of_type_Boolean = false;
    }
    a(paramFloat);
  }
  
  private void c(WindowManager.LayoutParams paramLayoutParams)
  {
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 1.0F });
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null)
    {
      if (this.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()) {
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewWindowManager, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new biwc(this, paramLayoutParams));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new biwd(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
    }
    this.h = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x;
    this.i = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y;
    this.j = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth();
    this.k = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
    }
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 17;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = (this.jdField_d_of_type_Int / 2 - this.h + this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth() / 2);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = (this.e / 2 - this.i + this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight() / 2);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = (this.jdField_d_of_type_Int / 2 - this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width / 2);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = (this.e / 2 - this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height / 2);
    this.jdField_d_of_type_Boolean = true;
    a(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
  
  private void j()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131374511);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
    localLayoutParams.gravity = 51;
    updateViewLayout(localFrameLayout, localLayoutParams);
  }
  
  private void k()
  {
    this.jdField_c_of_type_Float = -1.0F;
  }
  
  private void l()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      m();
      n();
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  private void m()
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getReboundSize();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getWidth() <= 0)
    {
      this.jdField_d_of_type_Float = 1.0F;
      a(this.jdField_d_of_type_Float);
      if (QLog.isColorLevel()) {
        QLog.d("FloatingScreenContainer", 2, "onDragEndAnimation mFloatParams.getWidth() Wrong ！！！！ mFloatParams.getWidth() = " + this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getWidth());
      }
    }
    float f1;
    do
    {
      return;
      f1 = m / this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getWidth();
    } while (f1 == 1.0F);
    this.jdField_d_of_type_Float = (f1 * this.jdField_d_of_type_Float);
    a(this.jdField_d_of_type_Float);
  }
  
  private void n()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth(), this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight());
    o();
  }
  
  private void o()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131374511);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
    localLayoutParams.gravity = 17;
    localLayoutParams.leftMargin = 0;
    localLayoutParams.topMargin = 0;
    localLayoutParams.rightMargin = 0;
    localLayoutParams.bottomMargin = 0;
    updateViewLayout(localFrameLayout, localLayoutParams);
  }
  
  private void p()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131374511);
    if (localFrameLayout != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localFrameLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  private void q()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.layoutInDisplayCutoutMode = 2;
        if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
          this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void r()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", "1");
    String str = "";
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str, "VideoFloatScale", true, 0L, 0L, localHashMap, "");
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX();
    }
    return 0;
  }
  
  WindowManager.LayoutParams a()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
    }
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -1;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = 0;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = 0;
    if (Build.VERSION.SDK_INT >= 28) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.layoutInDisplayCutoutMode = 1;
    }
    if (!biwn.a(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 256;
    }
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  }
  
  WindowManager.LayoutParams a(FloatingScreenParams paramFloatingScreenParams)
  {
    int m = (this.jdField_d_of_type_Int - paramFloatingScreenParams.getOuterWidth()) / 2;
    int n = (this.e - paramFloatingScreenParams.getOuterHeight()) / 2;
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterX()) > m)
    {
      if (paramFloatingScreenParams.getFloatingCenterX() > 0) {
        paramFloatingScreenParams.setFloatingCenterX(m);
      }
    }
    else if (Math.abs(paramFloatingScreenParams.getFloatingCenterY()) > n) {
      if (paramFloatingScreenParams.getFloatingCenterY() <= 0) {
        break label210;
      }
    }
    label210:
    for (m = n;; m = -n)
    {
      paramFloatingScreenParams.setFloatingCenterY(m);
      if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 16777256;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = paramFloatingScreenParams.getOuterWidth();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = paramFloatingScreenParams.getOuterHeight();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = paramFloatingScreenParams.getFloatingCenterX();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = paramFloatingScreenParams.getFloatingCenterY();
      if (Build.VERSION.SDK_INT >= 28) {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.layoutInDisplayCutoutMode = 2;
      }
      if (!biwn.a(this.jdField_a_of_type_AndroidContentContext)) {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.systemUiVisibility = 5892;
      }
      return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      m = -m;
      break;
    }
  }
  
  WindowManager.LayoutParams a(FloatingScreenParams paramFloatingScreenParams, boolean paramBoolean)
  {
    int m = (this.jdField_d_of_type_Int - paramFloatingScreenParams.getOuterWidth()) / 2;
    int n = (this.e - paramFloatingScreenParams.getOuterHeight()) / 2;
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterX()) > m)
    {
      if (paramFloatingScreenParams.getFloatingCenterX() > 0) {
        paramFloatingScreenParams.setFloatingCenterX(m);
      }
    }
    else if (Math.abs(paramFloatingScreenParams.getFloatingCenterY()) > n) {
      if (paramFloatingScreenParams.getFloatingCenterY() <= 0) {
        break label152;
      }
    }
    label152:
    for (m = n;; m = -n)
    {
      paramFloatingScreenParams.setFloatingCenterY(m);
      if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = paramFloatingScreenParams.getOuterWidth();
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = paramFloatingScreenParams.getOuterHeight();
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = paramFloatingScreenParams.getFloatingCenterX();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = paramFloatingScreenParams.getFloatingCenterY();
      return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      m = -m;
      break;
    }
  }
  
  void a()
  {
    b(0);
  }
  
  void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.updateZoomRatio(paramFloat);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.clone();
    int n = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getWidth();
    int m = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getHeight();
    if (this.g == -1) {
      if (this.f != -1) {
        break label114;
      }
    }
    for (;;)
    {
      FrameLayout localFrameLayout = (FrameLayout)findViewById(2131374511);
      if (localFrameLayout != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
        localLayoutParams.width = n;
        localLayoutParams.height = m;
        localFrameLayout.setLayoutParams(localLayoutParams);
      }
      return;
      m = (int)Math.ceil(this.g * paramFloat);
      break;
      label114:
      n = (int)Math.ceil(this.f * paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getShapeType())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setShapeType(paramInt);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.clone();
      a(a(this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams, true));
    }
  }
  
  public void a(View paramView, FloatingScreenParams paramFloatingScreenParams)
  {
    if (a()) {
      d();
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = paramFloatingScreenParams;
    this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = paramFloatingScreenParams.clone();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    removeAllViews();
    addView(paramView, localLayoutParams);
    a(paramFloatingScreenParams);
    b(false);
  }
  
  public void a(WindowManager.LayoutParams paramLayoutParams)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, paramLayoutParams);
      }
      return;
    }
    catch (Exception paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
    }
  }
  
  public void a(FloatingScreenParams paramFloatingScreenParams)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewWindowManager != null)
      {
        paramFloatingScreenParams = a(paramFloatingScreenParams);
        this.jdField_a_of_type_AndroidViewWindowManager.addView(this, paramFloatingScreenParams);
      }
      return;
    }
    catch (Exception paramFloatingScreenParams)
    {
      paramFloatingScreenParams.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    FloatingScreenParams localFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams;
    if (paramBoolean) {}
    for (m = 1;; m = 2)
    {
      localFloatingScreenParams.setShapeType(m);
      int i4 = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX();
      i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY();
      i3 = 28;
      i2 = 0;
      m = i2;
      n = i3;
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        m = i2;
        n = i3;
        if (this.jdField_a_of_type_AndroidContentContext.getResources() != null) {
          i3 = AIOUtils.dp2px(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        }
      }
      try
      {
        int i5 = this.jdField_a_of_type_AndroidContentContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        m = i2;
        n = i3;
        if (i5 > 0)
        {
          m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(i5);
          n = i3;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          m = i2;
          n = i3;
          continue;
          m = i1;
        }
      }
      i3 = this.jdField_d_of_type_Int / 2 - n - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth() / 2;
      i2 = this.e / 2 - n - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight() / 2;
      m += -i2;
      n = i3;
      if (i4 < 0) {
        n = -i3;
      }
      if (i1 >= m) {
        break;
      }
      i1 = m;
      if (m > i2) {
        i1 = i2;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setFloatingCenterX(n);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setFloatingCenterY(i1);
      if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 17;
      a(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenContainer", 2, " enterFullScreen: " + paramBoolean1 + " videoWidth: " + paramInt1 + " videoHeight: " + paramInt2 + " isCalledByEnterFloat: " + paramBoolean2);
    }
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131374510);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    if (localFrameLayout != null)
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        localFrameLayout.setLayoutParams(localLayoutParams);
      }
    }
    else {
      return;
    }
    float f1 = paramInt1 / paramInt2;
    if (paramBoolean1)
    {
      a(localLayoutParams, f1);
      p();
      assm.a(this, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846238));
      localFrameLayout.setLayoutParams(localLayoutParams);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams == null)
    {
      this.f = -1;
      this.g = -1;
      if (QLog.isColorLevel()) {
        QLog.d("FloatingScreenContainer", 2, " mFloatParams is null!");
      }
    }
    for (;;)
    {
      assm.a(this, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2131167296));
      break;
      a(localLayoutParams, f1, paramBoolean2);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int != 0;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY();
    }
    return 0;
  }
  
  WindowManager.LayoutParams b()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
    }
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
    if (Build.VERSION.SDK_INT >= 28) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.layoutInDisplayCutoutMode = 2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams != null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX();
    }
    for (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY();; this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = 0)
    {
      return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = 500;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = 281;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = 200;
    }
  }
  
  void b()
  {
    b(1);
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat != this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getScreenRatio())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setScreenRatio(paramFloat);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.clone();
      a(a(this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams, true));
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  void c()
  {
    b(2);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 2;
  }
  
  public void d()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean d()
  {
    if (!a()) {
      return false;
    }
    a();
    setVisibility(8);
    q();
    d();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = null;
    e();
    removeAllViews();
    this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = null;
    this.jdField_d_of_type_Float = 1.0F;
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (c()) && (this.jdField_a_of_type_Biwe != null)) {
      this.jdField_a_of_type_Biwe.a();
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void f()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams == null) || (!b())) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setShowPadding(false);
    }
    b(a());
    c();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setShowPadding(true);
    }
    c(b());
    b();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (c())
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    if (paramMotionEvent.getPointerCount() > 2) {
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
      this.jdField_a_of_type_Boolean = false;
      continue;
      float f1 = paramMotionEvent.getY();
      float f2 = paramMotionEvent.getX();
      if ((Math.abs(this.jdField_a_of_type_Float - f1) > this.jdField_c_of_type_Int) || (Math.abs(this.jdField_b_of_type_Float - f2) > this.jdField_c_of_type_Int)) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
        this.jdField_b_of_type_Float = paramMotionEvent.getRawX();
        continue;
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.jdField_a_of_type_Boolean) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    int m;
    float f1;
    do
    {
      do
      {
        return bool1;
        if (this.jdField_b_of_type_Boolean)
        {
          Log.d("FloatingScreenContainer", "could not dragging while scaling!");
          return super.onTouchEvent(paramMotionEvent);
        }
        m = paramMotionEvent.getPointerCount();
        switch (paramMotionEvent.getAction())
        {
        case 4: 
        default: 
          k();
          this.jdField_c_of_type_Boolean = true;
          return true;
        case 0: 
        case 5: 
          bool1 = bool2;
        }
      } while (m != 2);
      this.jdField_c_of_type_Float = a(paramMotionEvent);
      return true;
      if ((!this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getCanZoom()) || (m != 2)) {
        break;
      }
      f1 = a(paramMotionEvent);
      if (this.jdField_c_of_type_Float == -1.0F) {
        break label248;
      }
      bool1 = bool2;
    } while (Math.abs(f1 - this.jdField_c_of_type_Float) <= 2.0F);
    this.jdField_d_of_type_Float = (this.jdField_d_of_type_Float * f1 / this.jdField_c_of_type_Float);
    c(this.jdField_d_of_type_Float);
    this.jdField_c_of_type_Float = f1;
    for (;;)
    {
      bool1 = bool2;
      if (m != 1) {
        break;
      }
      bool1 = bool2;
      if (this.jdField_d_of_type_Boolean) {
        break;
      }
      f1 = paramMotionEvent.getRawY();
      a((int)(paramMotionEvent.getRawX() - this.jdField_b_of_type_Float), (int)(f1 - this.jdField_a_of_type_Float));
      return true;
      label248:
      this.jdField_c_of_type_Float = f1;
      this.jdField_c_of_type_Boolean = true;
    }
    b(true);
    k();
    this.jdField_c_of_type_Boolean = true;
    return true;
  }
  
  public void setOnBackPressListener(biwe parambiwe)
  {
    this.jdField_a_of_type_Biwe = parambiwe;
  }
  
  public void setOnDragListener(biwf parambiwf)
  {
    this.jdField_a_of_type_Biwf = parambiwf;
  }
  
  public void setOnScaleAnimListener(biwg parambiwg)
  {
    this.jdField_a_of_type_Biwg = parambiwg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer
 * JD-Core Version:    0.7.0.1
 */