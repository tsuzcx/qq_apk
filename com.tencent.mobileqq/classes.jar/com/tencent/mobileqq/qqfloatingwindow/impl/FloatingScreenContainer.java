package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
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
  private WindowManager.LayoutParams A;
  private int B = 2130847941;
  private IContainerBackPressListener C;
  private IDragListener D;
  private int a = 0;
  private int b;
  private int c = 20;
  private FloatingScreenParams d;
  private FloatingScreenParams e;
  private Context f;
  private WindowManager g;
  private int h = 0;
  private int i = 0;
  private ValueAnimator j = null;
  private ObjectAnimator k = null;
  private boolean l = false;
  private boolean m = false;
  private float n;
  private float o;
  private FloatingScreenContainer.OnScaleAnimListener p;
  private int q = -1;
  private int r = -1;
  private float s = -1.0F;
  private float t = 1.0F;
  private boolean u = true;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  private int y = 0;
  private boolean z = false;
  
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
    this.f = paramContext;
    this.g = ((WindowManager)paramContext.getSystemService("window"));
    paramContext = this.g;
    if (paramContext != null)
    {
      this.i = paramContext.getDefaultDisplay().getHeight();
      this.h = this.g.getDefaultDisplay().getWidth();
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.b = 2038;
      return;
    }
    this.b = 2002;
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
  
  private void a(Context paramContext)
  {
    if (paramContext != null) {
      this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    }
  }
  
  private void a(FrameLayout.LayoutParams paramLayoutParams, float paramFloat)
  {
    int i1 = this.h;
    if (i1 != 0)
    {
      int i2 = this.i;
      if (i2 != 0)
      {
        if (paramFloat >= i1 / i2) {
          i2 = (int)(i1 / paramFloat);
        } else {
          i1 = (int)(i2 * paramFloat);
        }
        paramLayoutParams.width = i1;
        paramLayoutParams.height = i2;
      }
    }
  }
  
  private void a(FrameLayout.LayoutParams paramLayoutParams, float paramFloat, boolean paramBoolean)
  {
    int i1 = this.d.getShapeType();
    float f1 = 1.0F;
    if (i1 == 1) {
      f1 = 1.0F / this.d.getScreenRatio();
    } else if (this.d.getShapeType() == 2) {
      f1 = this.d.getScreenRatio();
    }
    double d1 = Math.abs(paramFloat - f1);
    int i2 = -1;
    if (d1 < 0.1D)
    {
      i1 = i2;
      if (paramBoolean)
      {
        this.q = this.d.getInitialWidth();
        this.r = this.d.getInitialHeight();
        i1 = i2;
      }
    }
    int i3;
    for (;;)
    {
      i3 = -1;
      break;
      if (paramFloat > f1)
      {
        int i4 = (int)Math.ceil(this.d.getWidth() / paramFloat);
        i1 = i2;
        i3 = i4;
        if (!paramBoolean) {
          break;
        }
        this.q = this.d.getInitialWidth();
        this.r = ((int)Math.ceil(this.d.getInitialWidth() / paramFloat));
        i1 = i2;
        i3 = i4;
        break;
      }
      i1 = (int)Math.ceil(this.d.getHeight() * paramFloat);
      if (paramBoolean)
      {
        this.r = this.d.getInitialHeight();
        this.q = ((int)Math.ceil(this.d.getInitialHeight() * paramFloat));
      }
    }
    paramLayoutParams.width = i1;
    paramLayoutParams.height = i3;
  }
  
  private void b(float paramFloat)
  {
    if ((this.u) && (!this.z))
    {
      n();
      o();
      p();
      x();
      this.u = false;
    }
    setVideoAndContainerScaled(paramFloat);
    b(false);
  }
  
  private void b(WindowManager.LayoutParams paramLayoutParams)
  {
    this.e = this.d.clone();
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator = this.k;
    if (localObjectAnimator != null)
    {
      if (localObjectAnimator.isRunning()) {
        this.k.cancel();
      }
      this.k = null;
    }
    this.k = ObjectAnimator.ofPropertyValuesHolder(this.g, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.k.addUpdateListener(new FloatingScreenContainer.3(this, paramLayoutParams));
    this.k.addListener(new FloatingScreenContainer.4(this));
    this.k.start();
  }
  
  private void b(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramBoolean)
      {
        setElevation(15.0F);
        setBackground(getResources().getDrawable(getOutCornerBackgroundDrawable()));
        return;
      }
      setElevation(0.0F);
      setBackgroundResource(0);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (this.d.getCanMove())
    {
      this.e.setShapeType(this.d.getShapeType());
      this.e.setFloatingCenterX(this.d.getFloatingCenterX() + paramInt1);
      this.e.setFloatingCenterY(this.d.getFloatingCenterY() + paramInt2);
      a(a(this.e, false));
    }
  }
  
  private void c(WindowManager.LayoutParams paramLayoutParams)
  {
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator = this.k;
    if (localObjectAnimator != null)
    {
      if (localObjectAnimator.isRunning()) {
        this.k.cancel();
      }
      this.k = null;
    }
    this.k = ObjectAnimator.ofPropertyValuesHolder(this.g, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.k.addUpdateListener(new FloatingScreenContainer.5(this, paramLayoutParams));
    this.k.addListener(new FloatingScreenContainer.6(this));
    this.k.start();
  }
  
  private void c(boolean paramBoolean)
  {
    this.d = this.e.clone();
    if (paramBoolean) {
      r();
    }
    int i2 = 28;
    Context localContext = this.f;
    int i1 = i2;
    if (localContext != null)
    {
      i1 = i2;
      if (localContext.getResources() != null) {
        i1 = FloatingScreenUtils.a(14.0F, this.f.getResources());
      }
    }
    int i3 = 0;
    i2 = i3;
    try
    {
      if (this.f != null)
      {
        i2 = i3;
        if (this.f.getResources() != null)
        {
          i4 = this.f.getResources().getIdentifier("status_bar_height", "dimen", "android");
          i2 = i3;
          if (i4 > 0) {
            i2 = this.f.getResources().getDimensionPixelSize(i4);
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i2 = i3;
    }
    i3 = this.h / 2 - i1 - this.d.getOuterWidth() / 2;
    int i6 = this.i / 2 - i1 - this.d.getOuterHeight() / 2;
    int i5 = -i6 + i2;
    i1 = -this.h;
    i2 = -this.i;
    Object localObject = (WindowManager.LayoutParams)getLayoutParams();
    ((WindowManager.LayoutParams)localObject).gravity = 17;
    int i7 = ((WindowManager.LayoutParams)localObject).x;
    int i4 = -i3;
    if (i7 < i4) {
      i1 = i4;
    }
    if (((WindowManager.LayoutParams)localObject).x > i3) {
      i1 = i3;
    }
    if (((WindowManager.LayoutParams)localObject).y < i5) {
      i2 = i5;
    }
    if (((WindowManager.LayoutParams)localObject).y > i6) {
      i2 = i6;
    }
    if ((((WindowManager.LayoutParams)localObject).x > i4) && (((WindowManager.LayoutParams)localObject).x < i3)) {
      if (((WindowManager.LayoutParams)localObject).x < 0) {
        i1 = i4;
      } else {
        i1 = i3;
      }
    }
    ValueAnimator localValueAnimator = this.j;
    if (localValueAnimator != null)
    {
      if (localValueAnimator.isRunning()) {
        this.j.cancel();
      }
      this.j = null;
    }
    this.j = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.j.setTarget(this);
    this.j.setDuration(200L);
    i4 = ((WindowManager.LayoutParams)localObject).x;
    i6 = ((WindowManager.LayoutParams)localObject).y;
    this.j.addUpdateListener(new FloatingScreenContainer.1(this, i1, i3, (WindowManager.LayoutParams)localObject, i4, i2, i5, i6));
    this.j.addListener(new FloatingScreenContainer.2(this));
    this.j.start();
    localObject = this.D;
    if (localObject != null) {
      ((IDragListener)localObject).b();
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (this.A == null) {
      this.A = ((WindowManager.LayoutParams)getLayoutParams());
    }
    WindowManager.LayoutParams localLayoutParams = this.A;
    localLayoutParams.gravity = 17;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localLayoutParams.x = (this.v + (this.d.getOuterWidth() - this.x) / 2);
    this.A.y = (this.w + (this.d.getOuterHeight() - this.y) / 2);
    a(this.A);
  }
  
  private void n()
  {
    if (this.A == null) {
      this.A = ((WindowManager.LayoutParams)getLayoutParams());
    }
    this.v = this.A.x;
    this.w = this.A.y;
    this.x = this.d.getOuterWidth();
    this.y = this.d.getOuterHeight();
  }
  
  private void o()
  {
    if (this.A == null) {
      this.A = ((WindowManager.LayoutParams)getLayoutParams());
    }
    WindowManager.LayoutParams localLayoutParams = this.A;
    localLayoutParams.gravity = 17;
    localLayoutParams.width = (this.h / 2 - this.v + this.d.getOuterWidth() / 2);
    this.A.height = (this.i / 2 - this.w + this.d.getOuterHeight() / 2);
    localLayoutParams = this.A;
    localLayoutParams.x = (this.h / 2 - localLayoutParams.width / 2);
    localLayoutParams = this.A;
    localLayoutParams.y = (this.i / 2 - localLayoutParams.height / 2);
    this.z = true;
    a(this.A);
  }
  
  private void p()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131442583);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
    localLayoutParams.gravity = 51;
    Object localObject = this.d;
    if (localObject != null)
    {
      int i1 = (((FloatingScreenParams)localObject).getOuterWidth() - this.d.getWidth()) / 2;
      localLayoutParams.leftMargin = i1;
      localLayoutParams.topMargin = i1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateWrapperGravity() margin = ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" OuterWidth = ");
        ((StringBuilder)localObject).append(this.d.getOuterWidth());
        ((StringBuilder)localObject).append(" Width = ");
        ((StringBuilder)localObject).append(this.d.getWidth());
        QLog.d("FloatingScreenContainer", 2, ((StringBuilder)localObject).toString());
      }
    }
    updateViewLayout(localFrameLayout, localLayoutParams);
  }
  
  private void q()
  {
    this.s = -1.0F;
  }
  
  private void r()
  {
    if (this.z)
    {
      s();
      t();
      this.z = false;
    }
  }
  
  private void s()
  {
    int i1 = this.d.getReboundSize();
    if (this.d.getWidth() <= 0)
    {
      this.t = 1.0F;
      setVideoAndContainerScaled(this.t);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDragEndAnimation mFloatParams.getWidth() Wrong ！！！！ mFloatParams.getWidth() = ");
        localStringBuilder.append(this.d.getWidth());
        QLog.d("FloatingScreenContainer", 2, localStringBuilder.toString());
      }
    }
    else
    {
      float f1 = i1 / this.d.getWidth();
      if (f1 != 1.0F)
      {
        this.t *= f1;
        setVideoAndContainerScaled(this.t);
      }
    }
  }
  
  private void setFloatingMode(int paramInt)
  {
    this.a = paramInt;
  }
  
  private void t()
  {
    d(this.d.getOuterWidth(), this.d.getOuterHeight());
    u();
    b(true);
  }
  
  private void u()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131442583);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
    localLayoutParams.gravity = 17;
    localLayoutParams.leftMargin = 0;
    localLayoutParams.topMargin = 0;
    localLayoutParams.rightMargin = 0;
    localLayoutParams.bottomMargin = 0;
    updateViewLayout(localFrameLayout, localLayoutParams);
  }
  
  private void v()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131442583);
    if (localFrameLayout != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localFrameLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  private void w()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        this.A = ((WindowManager.LayoutParams)getLayoutParams());
        this.A.layoutInDisplayCutoutMode = 2;
        if (this.g != null)
        {
          this.g.updateViewLayout(this, this.A);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void x()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", "1");
    Object localObject = PluginRuntime.getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    StatisticCollector.getInstance(this.f).collectPerformance((String)localObject, "VideoFloatScale", true, 0L, 0L, localHashMap, "");
  }
  
  WindowManager.LayoutParams a(FloatingScreenParams paramFloatingScreenParams, boolean paramBoolean)
  {
    int i1 = (this.h - paramFloatingScreenParams.getOuterWidth()) / 2;
    int i2 = (this.i - paramFloatingScreenParams.getOuterHeight()) / 2;
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterX()) > i1)
    {
      if (paramFloatingScreenParams.getFloatingCenterX() <= 0) {
        i1 = -i1;
      }
      paramFloatingScreenParams.setFloatingCenterX(i1);
    }
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterY()) > i2)
    {
      if (paramFloatingScreenParams.getFloatingCenterY() > 0) {
        i1 = i2;
      } else {
        i1 = -i2;
      }
      paramFloatingScreenParams.setFloatingCenterY(i1);
    }
    if (this.A == null) {
      this.A = ((WindowManager.LayoutParams)getLayoutParams());
    }
    if (paramBoolean)
    {
      this.A.width = paramFloatingScreenParams.getOuterWidth();
      this.A.height = paramFloatingScreenParams.getOuterHeight();
    }
    this.A.x = paramFloatingScreenParams.getFloatingCenterX();
    this.A.y = paramFloatingScreenParams.getFloatingCenterY();
    return this.A;
  }
  
  void a()
  {
    setFloatingMode(0);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat != this.d.getScreenRatio())
    {
      this.d.setScreenRatio(paramFloat);
      this.e = this.d.clone();
      a(a(this.e, true));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.d.getShapeType())
    {
      this.d.setShapeType(paramInt);
      this.e = this.d.clone();
      a(a(this.e, true));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = this.d.getFloatingCenterX();
    int i2 = this.d.getFloatingCenterY();
    if ((i1 != paramInt1) || (i2 != paramInt2))
    {
      this.d.setFloatingCenterX(paramInt1);
      this.d.setFloatingCenterY(paramInt2);
      this.e = this.d.clone();
      a(a(this.e, false));
    }
  }
  
  public void a(View paramView, FloatingScreenParams paramFloatingScreenParams)
  {
    if (getIsFloating()) {
      i();
    }
    b();
    this.d = paramFloatingScreenParams;
    this.e = paramFloatingScreenParams.clone();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    removeAllViews();
    addView(paramView, localLayoutParams);
    a(paramFloatingScreenParams);
    c(false);
  }
  
  public void a(WindowManager.LayoutParams paramLayoutParams)
  {
    try
    {
      if (this.g != null)
      {
        this.g.updateViewLayout(this, paramLayoutParams);
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
      if (this.g != null)
      {
        paramFloatingScreenParams = b(paramFloatingScreenParams);
        this.g.addView(this, paramFloatingScreenParams);
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
    Object localObject = this.d;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ((FloatingScreenParams)localObject).setShapeType(i1);
    int i7 = this.d.getFloatingCenterX();
    int i3 = this.d.getFloatingCenterY();
    int i5 = 28;
    int i4 = 0;
    localObject = this.f;
    int i1 = i5;
    int i2 = i4;
    if (localObject != null)
    {
      i1 = i5;
      i2 = i4;
      if (((Context)localObject).getResources() != null)
      {
        i5 = FloatingScreenUtils.a(14.0F, this.f.getResources());
        try
        {
          i6 = this.f.getResources().getIdentifier("status_bar_height", "dimen", "android");
          i1 = i5;
          i2 = i4;
          if (i6 > 0)
          {
            i2 = this.f.getResources().getDimensionPixelSize(i6);
            i1 = i5;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i2 = i4;
          i1 = i5;
        }
      }
    }
    i5 = this.h / 2 - i1 - this.d.getOuterWidth() / 2;
    i4 = this.i / 2 - i1 - this.d.getOuterHeight() / 2;
    int i6 = -i4 + i2;
    i2 = i5;
    if (i7 < 0) {
      i2 = -i5;
    }
    i1 = i3;
    if (i3 < i6) {
      i1 = i6;
    }
    i3 = i1;
    if (i1 > i4) {
      i3 = i4;
    }
    this.d.setFloatingCenterX(i2);
    this.d.setFloatingCenterY(i3);
    if (this.A == null) {
      this.A = ((WindowManager.LayoutParams)getLayoutParams());
    }
    this.A.width = this.d.getOuterWidth();
    this.A.height = this.d.getOuterHeight();
    this.A.x = this.d.getFloatingCenterX();
    this.A.y = this.d.getFloatingCenterY();
    WindowManager.LayoutParams localLayoutParams = this.A;
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
    Object localObject = (FrameLayout)findViewById(2131442582);
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
          v();
          if (Build.VERSION.SDK_INT >= 16) {
            setBackground(this.f.getResources().getDrawable(2130847940));
          }
          if (Build.VERSION.SDK_INT >= 21) {
            ((FrameLayout)localObject).setClipToOutline(false);
          }
        }
        else
        {
          if (this.d == null)
          {
            this.q = -1;
            this.r = -1;
            if (QLog.isColorLevel()) {
              QLog.d("FloatingScreenContainer", 2, " mFloatParams is null!");
            }
          }
          else
          {
            a(localLayoutParams, f1, paramBoolean2);
          }
          if (Build.VERSION.SDK_INT >= 16) {
            setBackground(this.f.getResources().getDrawable(2131168376));
          }
          if (Build.VERSION.SDK_INT >= 21) {
            ((FrameLayout)localObject).setClipToOutline(true);
          }
        }
        ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
        return;
      }
      ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  WindowManager.LayoutParams b(FloatingScreenParams paramFloatingScreenParams)
  {
    int i1 = (this.h - paramFloatingScreenParams.getOuterWidth()) / 2;
    int i2 = (this.i - paramFloatingScreenParams.getOuterHeight()) / 2;
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterX()) > i1)
    {
      if (paramFloatingScreenParams.getFloatingCenterX() <= 0) {
        i1 = -i1;
      }
      paramFloatingScreenParams.setFloatingCenterX(i1);
    }
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterY()) > i2)
    {
      if (paramFloatingScreenParams.getFloatingCenterY() > 0) {
        i1 = i2;
      } else {
        i1 = -i2;
      }
      paramFloatingScreenParams.setFloatingCenterY(i1);
    }
    if (this.A == null) {
      this.A = new WindowManager.LayoutParams();
    }
    WindowManager.LayoutParams localLayoutParams = this.A;
    localLayoutParams.type = this.b;
    localLayoutParams.format = 1;
    localLayoutParams.flags = 16777256;
    localLayoutParams.width = paramFloatingScreenParams.getOuterWidth();
    this.A.height = paramFloatingScreenParams.getOuterHeight();
    this.A.x = paramFloatingScreenParams.getFloatingCenterX();
    this.A.y = paramFloatingScreenParams.getFloatingCenterY();
    if (Build.VERSION.SDK_INT >= 28) {
      this.A.layoutInDisplayCutoutMode = 2;
    }
    if (!FloatingScreenUtils.a(this.f)) {
      this.A.systemUiVisibility = 5892;
    }
    return this.A;
  }
  
  void b()
  {
    setFloatingMode(1);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i1 = this.d.getWidth();
    int i2 = this.d.getHeight();
    if ((i1 != paramInt1) || (i2 != paramInt2))
    {
      this.d.setWidth(paramInt1);
      this.d.setHeight(paramInt2);
      this.e = this.d.clone();
      a(a(this.e, true));
    }
  }
  
  void c()
  {
    setFloatingMode(2);
  }
  
  public void d()
  {
    try
    {
      if (this.g != null)
      {
        this.g.removeView(this);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (getIsFullScreenFloating()))
    {
      IContainerBackPressListener localIContainerBackPressListener = this.C;
      if (localIContainerBackPressListener != null) {
        localIContainerBackPressListener.c();
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void e()
  {
    ValueAnimator localValueAnimator = this.j;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.j.cancel();
    }
  }
  
  public void f()
  {
    if (this.d != null) {
      getIsSmallFloating();
    }
    FloatingScreenParams localFloatingScreenParams = this.d;
    if (localFloatingScreenParams != null) {
      localFloatingScreenParams.setShowPadding(false);
    }
    b(l());
    c();
  }
  
  public void g()
  {
    FloatingScreenParams localFloatingScreenParams = this.d;
    if (localFloatingScreenParams != null) {
      localFloatingScreenParams.setShowPadding(true);
    }
    c(m());
    b();
  }
  
  public int getFloatingCenterX()
  {
    FloatingScreenParams localFloatingScreenParams = this.d;
    if (localFloatingScreenParams != null) {
      return localFloatingScreenParams.getFloatingCenterX();
    }
    return 0;
  }
  
  public int getFloatingCenterY()
  {
    FloatingScreenParams localFloatingScreenParams = this.d;
    if (localFloatingScreenParams != null) {
      return localFloatingScreenParams.getFloatingCenterY();
    }
    return 0;
  }
  
  public boolean getIsFloating()
  {
    return this.a != 0;
  }
  
  public boolean getIsFullScreenFloating()
  {
    return this.a == 2;
  }
  
  public boolean getIsSmallFloating()
  {
    return this.a == 1;
  }
  
  public int getOutCornerBackgroundDrawable()
  {
    return this.B;
  }
  
  public int getShapeType()
  {
    return this.d.getShapeType();
  }
  
  public void h()
  {
    WindowManager localWindowManager = this.g;
    if (localWindowManager != null)
    {
      this.i = localWindowManager.getDefaultDisplay().getHeight();
      this.h = this.g.getDefaultDisplay().getWidth();
    }
  }
  
  public boolean i()
  {
    if (!getIsFloating()) {
      return false;
    }
    a();
    setVisibility(8);
    w();
    d();
    this.A = null;
    e();
    removeAllViews();
    this.e = null;
    this.t = 1.0F;
    return true;
  }
  
  public void j()
  {
    if (!getIsFloating()) {
      return;
    }
    this.d.resetParams();
    this.t = 1.0F;
    setVideoAndContainerScaled(this.t);
    this.d.resetParams();
    t();
    this.v = 0;
    this.w = 0;
    this.x = 0;
    this.y = 0;
  }
  
  public boolean k()
  {
    return this.d.isHasZoomed();
  }
  
  WindowManager.LayoutParams l()
  {
    if (this.A == null) {
      this.A = ((WindowManager.LayoutParams)getLayoutParams());
    }
    WindowManager.LayoutParams localLayoutParams = this.A;
    localLayoutParams.type = this.b;
    localLayoutParams.format = 1;
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    if (Build.VERSION.SDK_INT >= 28) {
      this.A.layoutInDisplayCutoutMode = 1;
    }
    if (!FloatingScreenUtils.a(this.f)) {
      this.A.flags = 256;
    }
    return this.A;
  }
  
  WindowManager.LayoutParams m()
  {
    if (this.A == null) {
      this.A = ((WindowManager.LayoutParams)getLayoutParams());
    }
    Object localObject = this.A;
    ((WindowManager.LayoutParams)localObject).type = this.b;
    ((WindowManager.LayoutParams)localObject).format = 1;
    ((WindowManager.LayoutParams)localObject).flags = 40;
    if (Build.VERSION.SDK_INT >= 28) {
      this.A.layoutInDisplayCutoutMode = 2;
    }
    localObject = this.d;
    if (localObject != null)
    {
      this.A.width = ((FloatingScreenParams)localObject).getOuterWidth();
      this.A.height = this.d.getOuterHeight();
      this.A.x = this.d.getFloatingCenterX();
      this.A.y = this.d.getFloatingCenterY();
    }
    else
    {
      localObject = this.A;
      ((WindowManager.LayoutParams)localObject).width = 500;
      ((WindowManager.LayoutParams)localObject).height = 281;
      ((WindowManager.LayoutParams)localObject).x = 200;
      ((WindowManager.LayoutParams)localObject).y = 0;
    }
    return this.A;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    WindowManager localWindowManager = this.g;
    if (localWindowManager != null)
    {
      this.i = localWindowManager.getDefaultDisplay().getHeight();
      this.h = this.g.getDefaultDisplay().getWidth();
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = getIsFullScreenFloating();
    boolean bool1 = false;
    if (bool2)
    {
      this.l = false;
      return false;
    }
    if (paramMotionEvent.getPointerCount() > 2) {
      return true;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label173;
          }
        }
        else
        {
          float f1 = paramMotionEvent.getY();
          float f2 = paramMotionEvent.getX();
          if ((Math.abs(this.n - f1) > this.c) || (Math.abs(this.o - f2) > this.c)) {
            bool1 = true;
          }
          this.l = bool1;
          if (!this.l) {
            break label173;
          }
          this.n = paramMotionEvent.getRawY();
          this.o = paramMotionEvent.getRawX();
          break label173;
        }
      }
      this.l = false;
    }
    else
    {
      this.n = paramMotionEvent.getY();
      this.o = paramMotionEvent.getX();
      this.l = false;
    }
    label173:
    return this.l;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.l) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.m)
    {
      Log.d("FloatingScreenContainer", "could not dragging while scaling!");
      return super.onTouchEvent(paramMotionEvent);
    }
    int i1 = paramMotionEvent.getPointerCount();
    int i2 = paramMotionEvent.getAction();
    if (i2 != 0)
    {
      if (i2 != 1) {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if (i2 == 5) {
              break label233;
            }
            q();
            this.u = true;
            return true;
          }
        }
        else
        {
          if ((this.d.getCanZoom()) && (i1 == 2))
          {
            f1 = a(paramMotionEvent);
            float f2 = this.s;
            if (f2 != -1.0F)
            {
              if (Math.abs(f1 - f2) > 2.0F)
              {
                this.t = (this.t * f1 / this.s);
                b(this.t);
                this.s = f1;
              }
              else
              {
                return true;
              }
            }
            else
            {
              this.s = f1;
              this.u = true;
            }
          }
          if ((i1 != 1) || (this.z)) {
            break label248;
          }
          float f1 = paramMotionEvent.getRawY();
          c((int)(paramMotionEvent.getRawX() - this.o), (int)(f1 - this.n));
          return true;
        }
      }
      c(true);
      q();
      this.u = true;
      return true;
    }
    label233:
    if (i1 == 2) {
      this.s = a(paramMotionEvent);
    }
    label248:
    return true;
  }
  
  public void setOnBackPressListener(IContainerBackPressListener paramIContainerBackPressListener)
  {
    this.C = paramIContainerBackPressListener;
  }
  
  public void setOnDragListener(IDragListener paramIDragListener)
  {
    this.D = paramIDragListener;
  }
  
  public void setOnScaleAnimListener(FloatingScreenContainer.OnScaleAnimListener paramOnScaleAnimListener)
  {
    this.p = paramOnScaleAnimListener;
  }
  
  public void setOutCornerBackgroundDrawable(int paramInt)
  {
    this.B = paramInt;
  }
  
  void setVideoAndContainerScaled(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setVideoAndContainerScaled: scale[");
    ((StringBuilder)localObject).append(paramFloat);
    ((StringBuilder)localObject).append("");
    QLog.d("FloatingScreenContainer", 2, ((StringBuilder)localObject).toString());
    this.d.updateZoomRatio(paramFloat);
    this.e = this.d.clone();
    int i2 = this.d.getWidth();
    int i1 = this.d.getHeight();
    int i3 = this.r;
    if (i3 != -1) {
      i1 = (int)Math.ceil(i3 * paramFloat);
    }
    i3 = this.q;
    if (i3 != -1) {
      i2 = (int)Math.ceil(i3 * paramFloat);
    }
    localObject = (FrameLayout)findViewById(2131442583);
    if (localObject != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((FrameLayout)localObject).getLayoutParams();
      localLayoutParams.width = i2;
      localLayoutParams.height = i1;
      ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer
 * JD-Core Version:    0.7.0.1
 */