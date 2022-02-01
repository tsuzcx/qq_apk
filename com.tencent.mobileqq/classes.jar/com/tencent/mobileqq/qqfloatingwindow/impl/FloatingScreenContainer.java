package com.tencent.mobileqq.qqfloatingwindow.impl;

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
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.listener.IContainerBackPressListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IDragListener;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class FloatingScreenContainer
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator = null;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  private Context jdField_a_of_type_AndroidContentContext;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private FloatingScreenParams jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams;
  private FloatingScreenContainer.OnScaleAnimListener jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplFloatingScreenContainer$OnScaleAnimListener;
  private IContainerBackPressListener jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIContainerBackPressListener;
  private IDragListener jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIDragListener;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private FloatingScreenParams jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = -1.0F;
  private int jdField_c_of_type_Int = 20;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float = 1.0F;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int e = 0;
  private int f = -1;
  private int g = -1;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  
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
    paramContext = this.jdField_a_of_type_AndroidViewWindowManager;
    if (paramContext != null)
    {
      this.e = paramContext.getDefaultDisplay().getHeight();
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
    if ((paramMotionEvent != null) && (paramMotionEvent.getPointerCount() == 2))
    {
      float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      return (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    return 0.0F;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getCanMove())
    {
      this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.setShapeType(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getShapeType());
      this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.setFloatingCenterX(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getFloatingCenterX() + paramInt1);
      this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.setFloatingCenterY(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getFloatingCenterY() + paramInt2);
      a(a(this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams, false));
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
    int m = this.jdField_d_of_type_Int;
    if (m != 0)
    {
      int n = this.e;
      if (n != 0)
      {
        if (paramFloat >= m / n) {
          n = (int)(m / paramFloat);
        } else {
          m = (int)(n * paramFloat);
        }
        paramLayoutParams.width = m;
        paramLayoutParams.height = n;
      }
    }
  }
  
  private void a(FrameLayout.LayoutParams paramLayoutParams, float paramFloat, boolean paramBoolean)
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getShapeType();
    float f1 = 1.0F;
    if (m == 1) {
      f1 = 1.0F / this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getScreenRatio();
    } else if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getShapeType() == 2) {
      f1 = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getScreenRatio();
    }
    double d1 = Math.abs(paramFloat - f1);
    int n = -1;
    if (d1 < 0.1D)
    {
      m = n;
      if (paramBoolean)
      {
        this.f = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getInitialWidth();
        this.g = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getInitialHeight();
        m = n;
      }
    }
    int i1;
    for (;;)
    {
      i1 = -1;
      break;
      if (paramFloat > f1)
      {
        int i2 = (int)Math.ceil(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getWidth() / paramFloat);
        m = n;
        i1 = i2;
        if (!paramBoolean) {
          break;
        }
        this.f = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getInitialWidth();
        this.g = ((int)Math.ceil(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getInitialWidth() / paramFloat));
        m = n;
        i1 = i2;
        break;
      }
      m = (int)Math.ceil(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getHeight() * paramFloat);
      if (paramBoolean)
      {
        this.g = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getInitialHeight();
        this.f = ((int)Math.ceil(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getInitialHeight() * paramFloat));
      }
    }
    paramLayoutParams.width = m;
    paramLayoutParams.height = i1;
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
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.gravity = 17;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localLayoutParams.x = (this.h + (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterWidth() - this.j) / 2);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = (this.i + (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterHeight() - this.k) / 2);
    a(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
  
  private void b(WindowManager.LayoutParams paramLayoutParams)
  {
    this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.clone();
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if (localObjectAnimator != null)
    {
      if (localObjectAnimator.isRunning()) {
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewWindowManager, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new FloatingScreenContainer.3(this, paramLayoutParams));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new FloatingScreenContainer.4(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams = this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.clone();
    if (paramBoolean) {
      l();
    }
    int n = 28;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    int m = n;
    if (localContext != null)
    {
      m = n;
      if (localContext.getResources() != null) {
        m = FloatingScreenUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
    }
    int i1 = 0;
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
      localException.printStackTrace();
      n = i1;
    }
    i1 = this.jdField_d_of_type_Int / 2 - m - this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterWidth() / 2;
    int i4 = this.e / 2 - m - this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterHeight() / 2;
    int i3 = -i4 + n;
    m = -this.jdField_d_of_type_Int;
    n = -this.e;
    Object localObject = (WindowManager.LayoutParams)getLayoutParams();
    ((WindowManager.LayoutParams)localObject).gravity = 17;
    int i5 = ((WindowManager.LayoutParams)localObject).x;
    int i2 = -i1;
    if (i5 < i2) {
      m = i2;
    }
    if (((WindowManager.LayoutParams)localObject).x > i1) {
      m = i1;
    }
    if (((WindowManager.LayoutParams)localObject).y < i3) {
      n = i3;
    }
    if (((WindowManager.LayoutParams)localObject).y > i4) {
      n = i4;
    }
    if ((((WindowManager.LayoutParams)localObject).x > i2) && (((WindowManager.LayoutParams)localObject).x < i1)) {
      if (((WindowManager.LayoutParams)localObject).x < 0) {
        m = i2;
      } else {
        m = i1;
      }
    }
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      if (localValueAnimator.isRunning()) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setTarget(this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
    i2 = ((WindowManager.LayoutParams)localObject).x;
    i4 = ((WindowManager.LayoutParams)localObject).y;
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new FloatingScreenContainer.1(this, m, i1, (WindowManager.LayoutParams)localObject, i2, n, i3, i4));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new FloatingScreenContainer.2(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIDragListener;
    if (localObject != null) {
      ((IDragListener)localObject).b();
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
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if (localObjectAnimator != null)
    {
      if (localObjectAnimator.isRunning()) {
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewWindowManager, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new FloatingScreenContainer.5(this, paramLayoutParams));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new FloatingScreenContainer.6(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
    }
    this.h = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x;
    this.i = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y;
    this.j = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterWidth();
    this.k = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterHeight();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
    }
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.gravity = 17;
    localLayoutParams.width = (this.jdField_d_of_type_Int / 2 - this.h + this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterWidth() / 2);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = (this.e / 2 - this.i + this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterHeight() / 2);
    localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.x = (this.jdField_d_of_type_Int / 2 - localLayoutParams.width / 2);
    localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.y = (this.e / 2 - localLayoutParams.height / 2);
    this.jdField_d_of_type_Boolean = true;
    a(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
  
  private void j()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131374416);
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
    int m = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getReboundSize();
    if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getWidth() <= 0)
    {
      this.jdField_d_of_type_Float = 1.0F;
      a(this.jdField_d_of_type_Float);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDragEndAnimation mFloatParams.getWidth() Wrong ！！！！ mFloatParams.getWidth() = ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getWidth());
        QLog.d("FloatingScreenContainer", 2, localStringBuilder.toString());
      }
    }
    else
    {
      float f1 = m / this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getWidth();
      if (f1 != 1.0F)
      {
        this.jdField_d_of_type_Float *= f1;
        a(this.jdField_d_of_type_Float);
      }
    }
  }
  
  private void n()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterWidth(), this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterHeight());
    o();
  }
  
  private void o()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131374416);
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
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131374416);
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
        if (this.jdField_a_of_type_AndroidViewWindowManager != null)
        {
          this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
          return;
        }
      }
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
    Object localObject = PluginRuntime.getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).collectPerformance((String)localObject, "VideoFloatScale", true, 0L, 0L, localHashMap, "");
  }
  
  public int a()
  {
    FloatingScreenParams localFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams;
    if (localFloatingScreenParams != null) {
      return localFloatingScreenParams.getFloatingCenterX();
    }
    return 0;
  }
  
  WindowManager.LayoutParams a()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
    }
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.type = this.jdField_b_of_type_Int;
    localLayoutParams.format = 1;
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    if (Build.VERSION.SDK_INT >= 28) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.layoutInDisplayCutoutMode = 1;
    }
    if (!FloatingScreenUtils.a(this.jdField_a_of_type_AndroidContentContext)) {
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
      if (paramFloatingScreenParams.getFloatingCenterX() <= 0) {
        m = -m;
      }
      paramFloatingScreenParams.setFloatingCenterX(m);
    }
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterY()) > n)
    {
      if (paramFloatingScreenParams.getFloatingCenterY() > 0) {
        m = n;
      } else {
        m = -n;
      }
      paramFloatingScreenParams.setFloatingCenterY(m);
    }
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    }
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.type = this.jdField_b_of_type_Int;
    localLayoutParams.format = 1;
    localLayoutParams.flags = 16777256;
    localLayoutParams.width = paramFloatingScreenParams.getOuterWidth();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = paramFloatingScreenParams.getOuterHeight();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = paramFloatingScreenParams.getFloatingCenterX();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = paramFloatingScreenParams.getFloatingCenterY();
    if (Build.VERSION.SDK_INT >= 28) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.layoutInDisplayCutoutMode = 2;
    }
    if (!FloatingScreenUtils.a(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.systemUiVisibility = 5892;
    }
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  }
  
  WindowManager.LayoutParams a(FloatingScreenParams paramFloatingScreenParams, boolean paramBoolean)
  {
    int m = (this.jdField_d_of_type_Int - paramFloatingScreenParams.getOuterWidth()) / 2;
    int n = (this.e - paramFloatingScreenParams.getOuterHeight()) / 2;
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterX()) > m)
    {
      if (paramFloatingScreenParams.getFloatingCenterX() <= 0) {
        m = -m;
      }
      paramFloatingScreenParams.setFloatingCenterX(m);
    }
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterY()) > n)
    {
      if (paramFloatingScreenParams.getFloatingCenterY() > 0) {
        m = n;
      } else {
        m = -n;
      }
      paramFloatingScreenParams.setFloatingCenterY(m);
    }
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
  }
  
  void a()
  {
    b(0);
  }
  
  void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.updateZoomRatio(paramFloat);
    this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.clone();
    int n = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getWidth();
    int m = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getHeight();
    int i1 = this.g;
    if (i1 != -1) {
      m = (int)Math.ceil(i1 * paramFloat);
    }
    i1 = this.f;
    if (i1 != -1) {
      n = (int)Math.ceil(i1 * paramFloat);
    }
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131374416);
    if (localFrameLayout != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
      localLayoutParams.width = n;
      localLayoutParams.height = m;
      localFrameLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getShapeType())
    {
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.setShapeType(paramInt);
      this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.clone();
      a(a(this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams, true));
    }
  }
  
  public void a(View paramView, FloatingScreenParams paramFloatingScreenParams)
  {
    if (a()) {
      d();
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams = paramFloatingScreenParams;
    this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams = paramFloatingScreenParams.clone();
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
      if (this.jdField_a_of_type_AndroidViewWindowManager != null)
      {
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, paramLayoutParams);
        return;
      }
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
        return;
      }
    }
    catch (Exception paramFloatingScreenParams)
    {
      paramFloatingScreenParams.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams;
    if (paramBoolean) {
      m = 1;
    } else {
      m = 2;
    }
    ((FloatingScreenParams)localObject).setShapeType(m);
    int i5 = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getFloatingCenterX();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getFloatingCenterY();
    int i3 = 28;
    int i2 = 0;
    localObject = this.jdField_a_of_type_AndroidContentContext;
    int m = i3;
    int n = i2;
    if (localObject != null)
    {
      m = i3;
      n = i2;
      if (((Context)localObject).getResources() != null)
      {
        i3 = FloatingScreenUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        try
        {
          i4 = this.jdField_a_of_type_AndroidContentContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
          m = i3;
          n = i2;
          if (i4 > 0)
          {
            n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(i4);
            m = i3;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          n = i2;
          m = i3;
        }
      }
    }
    i3 = this.jdField_d_of_type_Int / 2 - m - this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterWidth() / 2;
    i2 = this.e / 2 - m - this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterHeight() / 2;
    int i4 = -i2 + n;
    n = i3;
    if (i5 < 0) {
      n = -i3;
    }
    m = i1;
    if (i1 < i4) {
      m = i4;
    }
    i1 = m;
    if (m > i2) {
      i1 = i2;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.setFloatingCenterX(n);
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.setFloatingCenterY(i1);
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
    }
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterWidth();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterHeight();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getFloatingCenterX();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getFloatingCenterY();
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.gravity = 17;
    a(localLayoutParams);
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" enterFullScreen: ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" videoWidth: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" videoHeight: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" isCalledByEnterFloat: ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("FloatingScreenContainer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (FrameLayout)findViewById(2131374415);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    if (localObject != null)
    {
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        float f1 = paramInt1 / paramInt2;
        if (paramBoolean1)
        {
          a(localLayoutParams, f1);
          p();
          setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846467));
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams == null)
          {
            this.f = -1;
            this.g = -1;
            if (QLog.isColorLevel()) {
              QLog.d("FloatingScreenContainer", 2, " mFloatParams is null!");
            }
          }
          else
          {
            a(localLayoutParams, f1, paramBoolean2);
          }
          setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2131167333));
        }
        ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
        return;
      }
      ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int != 0;
  }
  
  public int b()
  {
    FloatingScreenParams localFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams;
    if (localFloatingScreenParams != null) {
      return localFloatingScreenParams.getFloatingCenterY();
    }
    return 0;
  }
  
  WindowManager.LayoutParams b()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
    }
    Object localObject = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    ((WindowManager.LayoutParams)localObject).type = this.jdField_b_of_type_Int;
    ((WindowManager.LayoutParams)localObject).format = 1;
    ((WindowManager.LayoutParams)localObject).flags = 40;
    if (Build.VERSION.SDK_INT >= 28) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.layoutInDisplayCutoutMode = 2;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = ((FloatingScreenParams)localObject).getOuterWidth();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getOuterHeight();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getFloatingCenterX();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getFloatingCenterY();
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      ((WindowManager.LayoutParams)localObject).width = 500;
      ((WindowManager.LayoutParams)localObject).height = 281;
      ((WindowManager.LayoutParams)localObject).x = 200;
      ((WindowManager.LayoutParams)localObject).y = 0;
    }
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  }
  
  void b()
  {
    b(1);
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat != this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getScreenRatio())
    {
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.setScreenRatio(paramFloat);
      this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.clone();
      a(a(this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams, true));
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
      if (this.jdField_a_of_type_AndroidViewWindowManager != null)
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
        return;
      }
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
    this.jdField_b_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams = null;
    this.jdField_d_of_type_Float = 1.0F;
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (c()))
    {
      IContainerBackPressListener localIContainerBackPressListener = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIContainerBackPressListener;
      if (localIContainerBackPressListener != null) {
        localIContainerBackPressListener.a();
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void e()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams != null) {
      b();
    }
    FloatingScreenParams localFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams;
    if (localFloatingScreenParams != null) {
      localFloatingScreenParams.setShowPadding(false);
    }
    b(a());
    c();
  }
  
  public void g()
  {
    FloatingScreenParams localFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams;
    if (localFloatingScreenParams != null) {
      localFloatingScreenParams.setShowPadding(true);
    }
    c(b());
    b();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = c();
    boolean bool1 = false;
    if (bool2)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    if (paramMotionEvent.getPointerCount() > 2) {
      return true;
    }
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3) {
            break label173;
          }
        }
        else
        {
          float f1 = paramMotionEvent.getY();
          float f2 = paramMotionEvent.getX();
          if ((Math.abs(this.jdField_a_of_type_Float - f1) > this.jdField_c_of_type_Int) || (Math.abs(this.jdField_b_of_type_Float - f2) > this.jdField_c_of_type_Int)) {
            bool1 = true;
          }
          this.jdField_a_of_type_Boolean = bool1;
          if (!this.jdField_a_of_type_Boolean) {
            break label173;
          }
          this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
          this.jdField_b_of_type_Float = paramMotionEvent.getRawX();
          break label173;
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
      this.jdField_a_of_type_Boolean = false;
    }
    label173:
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      Log.d("FloatingScreenContainer", "could not dragging while scaling!");
      return super.onTouchEvent(paramMotionEvent);
    }
    int m = paramMotionEvent.getPointerCount();
    int n = paramMotionEvent.getAction();
    if (n != 0)
    {
      if (n != 1) {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n == 5) {
              break label233;
            }
            k();
            this.jdField_c_of_type_Boolean = true;
            return true;
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowFloatingScreenParams.getCanZoom()) && (m == 2))
          {
            f1 = a(paramMotionEvent);
            float f2 = this.jdField_c_of_type_Float;
            if (f2 != -1.0F)
            {
              if (Math.abs(f1 - f2) > 2.0F)
              {
                this.jdField_d_of_type_Float = (this.jdField_d_of_type_Float * f1 / this.jdField_c_of_type_Float);
                c(this.jdField_d_of_type_Float);
                this.jdField_c_of_type_Float = f1;
              }
              else
              {
                return true;
              }
            }
            else
            {
              this.jdField_c_of_type_Float = f1;
              this.jdField_c_of_type_Boolean = true;
            }
          }
          if ((m != 1) || (this.jdField_d_of_type_Boolean)) {
            break label248;
          }
          float f1 = paramMotionEvent.getRawY();
          a((int)(paramMotionEvent.getRawX() - this.jdField_b_of_type_Float), (int)(f1 - this.jdField_a_of_type_Float));
          return true;
        }
      }
      b(true);
      k();
      this.jdField_c_of_type_Boolean = true;
      return true;
    }
    label233:
    if (m == 2) {
      this.jdField_c_of_type_Float = a(paramMotionEvent);
    }
    label248:
    return true;
  }
  
  public void setOnBackPressListener(IContainerBackPressListener paramIContainerBackPressListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIContainerBackPressListener = paramIContainerBackPressListener;
  }
  
  public void setOnDragListener(IDragListener paramIDragListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIDragListener = paramIDragListener;
  }
  
  public void setOnScaleAnimListener(FloatingScreenContainer.OnScaleAnimListener paramOnScaleAnimListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowImplFloatingScreenContainer$OnScaleAnimListener = paramOnScaleAnimListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer
 * JD-Core Version:    0.7.0.1
 */