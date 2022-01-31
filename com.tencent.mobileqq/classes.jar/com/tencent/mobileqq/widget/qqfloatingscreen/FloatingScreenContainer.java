package com.tencent.mobileqq.widget.qqfloatingscreen;

import aciy;
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
import bbqa;
import bbqb;
import bbqc;
import bbqd;
import bbqe;
import bbqf;
import bbqg;
import bbqh;
import bbqi;
import bbqo;

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
  private bbqg jdField_a_of_type_Bbqg;
  private bbqh jdField_a_of_type_Bbqh;
  private bbqi jdField_a_of_type_Bbqi;
  private FloatingScreenParams jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private FloatingScreenParams jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams;
  private boolean jdField_b_of_type_Boolean;
  private int c = 20;
  private int d;
  private int e;
  
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
      this.d = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getWidth();
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.jdField_b_of_type_Int = 2038;
      return;
    }
    this.jdField_b_of_type_Int = 2002;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getCanMove())
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setShapeType(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getShapeType());
      this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setFloatingCenterX(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX() + paramInt1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setFloatingCenterY(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY() + paramInt2);
      a(b(this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams));
    }
  }
  
  private void a(Context paramContext)
  {
    if (paramContext != null) {
      this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    }
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
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new bbqc(this, paramLayoutParams));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new bbqd(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
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
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new bbqe(this, paramLayoutParams));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new bbqf(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.clone();
    j = 28;
    i = j;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidContentContext.getResources() != null) {
        i = aciy.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
    }
    k = 0;
    j = k;
    try
    {
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        j = k;
        if (this.jdField_a_of_type_AndroidContentContext.getResources() != null)
        {
          m = this.jdField_a_of_type_AndroidContentContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
          j = k;
          if (m > 0) {
            j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(m);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int m;
        int n;
        WindowManager.LayoutParams localLayoutParams;
        int i1;
        localException.printStackTrace();
        j = k;
        continue;
        i = k;
        continue;
      }
    }
    k = this.d / 2 - i - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth() / 2;
    n = this.e / 2 - i - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight() / 2;
    m = -n + j;
    i = -this.d;
    j = -this.e;
    localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    localLayoutParams.gravity = 17;
    if (localLayoutParams.x < -k) {
      i = -k;
    }
    if (localLayoutParams.x > k) {
      i = k;
    }
    if (localLayoutParams.y < m) {
      j = m;
    }
    if (localLayoutParams.y > n)
    {
      j = n;
      if ((localLayoutParams.x > -k) && (localLayoutParams.x < k)) {
        if (localLayoutParams.x < 0)
        {
          i = -k;
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
          n = localLayoutParams.x;
          i1 = localLayoutParams.y;
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bbqa(this, i, k, localLayoutParams, n, j, m, i1));
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bbqb(this));
          this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          if (this.jdField_a_of_type_Bbqh != null) {
            this.jdField_a_of_type_Bbqh.b();
          }
          return;
        }
      }
    }
  }
  
  private void i()
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
    if (!bbqo.a(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 256;
    }
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  }
  
  WindowManager.LayoutParams a(FloatingScreenParams paramFloatingScreenParams)
  {
    int i = (this.d - paramFloatingScreenParams.getOuterWidth()) / 2;
    int j = (this.e - paramFloatingScreenParams.getOuterHeight()) / 2;
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterX()) > i)
    {
      if (paramFloatingScreenParams.getFloatingCenterX() > 0) {
        paramFloatingScreenParams.setFloatingCenterX(i);
      }
    }
    else if (Math.abs(paramFloatingScreenParams.getFloatingCenterY()) > j) {
      if (paramFloatingScreenParams.getFloatingCenterY() <= 0) {
        break label210;
      }
    }
    label210:
    for (i = j;; i = -j)
    {
      paramFloatingScreenParams.setFloatingCenterY(i);
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
      if (!bbqo.a(this.jdField_a_of_type_AndroidContentContext)) {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.systemUiVisibility = 5892;
      }
      return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      i = -i;
      break;
    }
  }
  
  void a()
  {
    a(0);
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
    h();
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
    for (i = 1;; i = 2)
    {
      localFloatingScreenParams.setShapeType(i);
      int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX();
      k = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY();
      n = 28;
      m = 0;
      i = m;
      j = n;
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        i = m;
        j = n;
        if (this.jdField_a_of_type_AndroidContentContext.getResources() != null) {
          n = aciy.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        }
      }
      try
      {
        int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        i = m;
        j = n;
        if (i2 > 0)
        {
          i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(i2);
          j = n;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          i = m;
          j = n;
          continue;
          i = k;
        }
      }
      n = this.d / 2 - j - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth() / 2;
      m = this.e / 2 - j - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight() / 2;
      i += -m;
      j = n;
      if (i1 < 0) {
        j = -n;
      }
      if (k >= i) {
        break;
      }
      k = i;
      if (i > m) {
        k = m;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setFloatingCenterX(j);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setFloatingCenterY(k);
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
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i = -1;
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131307451);
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
    float f2 = paramInt1 / paramInt2;
    if (paramBoolean)
    {
      if ((this.d == 0) || (this.e == 0))
      {
        localFrameLayout.setLayoutParams(localLayoutParams);
        return;
      }
      if (f2 >= this.d / this.e)
      {
        paramInt2 = this.d;
        paramInt1 = (int)(paramInt2 / f2);
      }
      for (;;)
      {
        localLayoutParams.width = paramInt2;
        localLayoutParams.height = paramInt1;
        localFrameLayout.setLayoutParams(localLayoutParams);
        return;
        paramInt1 = this.e;
        paramInt2 = (int)(paramInt1 * f2);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams == null)
    {
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localFrameLayout.setLayoutParams(localLayoutParams);
      return;
    }
    float f1 = 1.0F;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getShapeType() == 1)
    {
      f1 = 1.777778F;
      if (Math.abs(f2 - f1) >= 0.1D) {
        break label264;
      }
      paramInt1 = -1;
      paramInt2 = i;
    }
    for (;;)
    {
      localLayoutParams.width = paramInt2;
      localLayoutParams.height = paramInt1;
      localLayoutParams.gravity = 17;
      localFrameLayout.setLayoutParams(localLayoutParams);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getShapeType() != 2) {
        break;
      }
      f1 = 0.5625F;
      break;
      label264:
      if (f2 > f1)
      {
        paramInt1 = (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getWidth() / f2);
        paramInt2 = i;
      }
      else
      {
        paramInt2 = (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getHeight() * f2);
        paramInt1 = -1;
      }
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
  
  WindowManager.LayoutParams b(FloatingScreenParams paramFloatingScreenParams)
  {
    int i = (this.d - paramFloatingScreenParams.getOuterWidth()) / 2;
    int j = (this.e - paramFloatingScreenParams.getOuterHeight()) / 2;
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterX()) > i)
    {
      if (paramFloatingScreenParams.getFloatingCenterX() > 0) {
        paramFloatingScreenParams.setFloatingCenterX(i);
      }
    }
    else if (Math.abs(paramFloatingScreenParams.getFloatingCenterY()) > j) {
      if (paramFloatingScreenParams.getFloatingCenterY() <= 0) {
        break label145;
      }
    }
    label145:
    for (i = j;; i = -j)
    {
      paramFloatingScreenParams.setFloatingCenterY(i);
      if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = ((WindowManager.LayoutParams)getLayoutParams());
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = paramFloatingScreenParams.getOuterWidth();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = paramFloatingScreenParams.getOuterHeight();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = paramFloatingScreenParams.getFloatingCenterX();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = paramFloatingScreenParams.getFloatingCenterY();
      return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      i = -i;
      break;
    }
  }
  
  void b()
  {
    a(1);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  void c()
  {
    a(2);
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
    i();
    d();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = null;
    e();
    removeAllViews();
    this.jdField_b_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = null;
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (c()) && (this.jdField_a_of_type_Bbqg != null)) {
      this.jdField_a_of_type_Bbqg.a();
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
      if ((Math.abs(this.jdField_a_of_type_Float - f1) > this.c) || (Math.abs(this.jdField_b_of_type_Float - f2) > this.c)) {
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
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      Log.d("FloatingScreenContainer", "could not dragging while scaling!");
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      float f = paramMotionEvent.getRawY();
      a((int)(paramMotionEvent.getRawX() - this.jdField_b_of_type_Float), (int)(f - this.jdField_a_of_type_Float));
      continue;
      h();
    }
  }
  
  public void setOnBackPressListener(bbqg parambbqg)
  {
    this.jdField_a_of_type_Bbqg = parambbqg;
  }
  
  public void setOnDragListener(bbqh parambbqh)
  {
    this.jdField_a_of_type_Bbqh = parambbqh;
  }
  
  public void setOnScaleAnimListener(bbqi parambbqi)
  {
    this.jdField_a_of_type_Bbqi = parambbqi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer
 * JD-Core Version:    0.7.0.1
 */