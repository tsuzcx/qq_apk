package com.tencent.mobileqq.extendfriend.pulltorefresh;

import acrs;
import acrt;
import acru;
import acrw;
import acrx;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;

public abstract class PullToRefreshBase
  extends LinearLayout
  implements IPullToRefresh
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private acrx jdField_a_of_type_Acrx;
  public View a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected LoadingLayoutBase a;
  private PullToRefreshBase.AnimationStyle jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$AnimationStyle = PullToRefreshBase.AnimationStyle.getDefault();
  private PullToRefreshBase.Mode jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode = PullToRefreshBase.Mode.getDefault();
  private PullToRefreshBase.OnPullEventListener jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnPullEventListener;
  private PullToRefreshBase.OnRefreshListener2 jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener2;
  private PullToRefreshBase.OnRefreshListener jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener;
  private PullToRefreshBase.State jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$State = PullToRefreshBase.State.RESET;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  protected LoadingLayoutBase b;
  private PullToRefreshBase.Mode jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e = true;
  private boolean f = true;
  private boolean g = true;
  private boolean h = true;
  
  public PullToRefreshBase(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private LinearLayout.LayoutParams a()
  {
    switch (acrv.a[a().ordinal()])
    {
    default: 
      return new LinearLayout.LayoutParams(-1, -2);
    }
    return new LinearLayout.LayoutParams(-2, -1);
  }
  
  private final void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, 0L, null);
  }
  
  private final void a(int paramInt, long paramLong1, long paramLong2, acrw paramacrw)
  {
    if (this.jdField_a_of_type_Acrx != null) {
      this.jdField_a_of_type_Acrx.a();
    }
    switch (acrv.a[a().ordinal()])
    {
    }
    for (int i = getScrollY();; i = getScrollX())
    {
      if (i != paramInt)
      {
        if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {
          this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
        }
        this.jdField_a_of_type_Acrx = new acrx(this, i, paramInt, paramLong1, paramacrw);
        if (paramLong2 <= 0L) {
          break;
        }
        postDelayed(this.jdField_a_of_type_Acrx, paramLong2);
      }
      return;
    }
    post(this.jdField_a_of_type_Acrx);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray;
    switch (acrv.a[a().ordinal()])
    {
    default: 
      setOrientation(1);
      setGravity(17);
      this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PullToFresh);
      if (localTypedArray.hasValue(4)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode = PullToRefreshBase.Mode.mapIntToValue(localTypedArray.getInteger(4, 0));
      }
      if (localTypedArray.hasValue(12)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$AnimationStyle = PullToRefreshBase.AnimationStyle.mapIntToValue(localTypedArray.getInteger(12, 0));
      }
      this.jdField_a_of_type_AndroidViewView = a(paramContext, paramAttributeSet);
      a(paramContext, this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase = a(paramContext, PullToRefreshBase.Mode.PULL_FROM_START, localTypedArray);
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase = a(paramContext, PullToRefreshBase.Mode.PULL_FROM_END, localTypedArray);
      if (localTypedArray.hasValue(0))
      {
        paramContext = localTypedArray.getDrawable(0);
        if (paramContext != null) {
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramContext);
        }
      }
      break;
    }
    for (;;)
    {
      if (localTypedArray.hasValue(9)) {
        this.e = localTypedArray.getBoolean(9, true);
      }
      if (localTypedArray.hasValue(13)) {
        this.jdField_c_of_type_Boolean = localTypedArray.getBoolean(13, false);
      }
      a(localTypedArray);
      localTypedArray.recycle();
      g();
      return;
      setOrientation(0);
      break;
      if (localTypedArray.hasValue(17))
      {
        paramContext = localTypedArray.getDrawable(17);
        if (paramContext != null) {
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramContext);
        }
      }
    }
  }
  
  private void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, -1, -1);
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout, new LinearLayout.LayoutParams(-1, -1));
  }
  
  private int d()
  {
    switch (acrv.a[a().ordinal()])
    {
    default: 
      return Math.round(getHeight() / 2.0F);
    }
    return Math.round(getWidth() / 2.0F);
  }
  
  private boolean e()
  {
    switch (acrv.c[this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.ordinal()])
    {
    }
    do
    {
      return false;
      return d();
      return c();
    } while ((!c()) && (!d()));
    return true;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener.a(this);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener2 == null);
      if (this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode == PullToRefreshBase.Mode.PULL_FROM_START)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener2.a(this);
        return;
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode != PullToRefreshBase.Mode.PULL_FROM_END);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener2.b(this);
  }
  
  private void i()
  {
    float f2;
    float f1;
    int i;
    label88:
    int j;
    switch (acrv.a[a().ordinal()])
    {
    default: 
      f2 = this.jdField_d_of_type_Float;
      f1 = this.jdField_b_of_type_Float;
      switch (acrv.c[this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.ordinal()])
      {
      default: 
        if (this.g)
        {
          i = Math.round(Math.min(f2 - f1, 0.0F) / 2.0F);
          j = b();
          a(i);
          if ((i != 0) && (!b()))
          {
            f1 = Math.abs(i) / j;
            switch (acrv.c[this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.ordinal()])
            {
            default: 
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.a(f1);
              label156:
              if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$State != PullToRefreshBase.State.PULL_TO_REFRESH) && (j >= Math.abs(i))) {
                a(PullToRefreshBase.State.PULL_TO_REFRESH, new boolean[0]);
              }
              break;
            }
          }
        }
        break;
      }
      break;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$State != PullToRefreshBase.State.PULL_TO_REFRESH) || (j >= Math.abs(i)))
    {
      return;
      f2 = this.jdField_c_of_type_Float;
      f1 = this.jdField_a_of_type_Float;
      break;
      if (this.h) {}
      for (i = Math.round(Math.max(f2 - f1, 0.0F) / 2.0F);; i = Math.round(Math.max(f2 - f1, 0.0F)))
      {
        j = a();
        break;
      }
      i = Math.round(Math.min(f2 - f1, 0.0F));
      break label88;
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.a(f1);
      break label156;
    }
    a(PullToRefreshBase.State.RELEASE_TO_REFRESH, new boolean[0]);
  }
  
  protected final int a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.a();
  }
  
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public abstract View a(Context paramContext, AttributeSet paramAttributeSet);
  
  public final ILoadingLayout a()
  {
    return a(true, true);
  }
  
  public final ILoadingLayout a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2);
  }
  
  protected LoadingLayoutBase a(Context paramContext, PullToRefreshBase.Mode paramMode, TypedArray paramTypedArray)
  {
    paramContext = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$AnimationStyle.createLoadingLayout(paramContext, paramMode, a(), paramTypedArray);
    paramContext.setVisibility(4);
    return paramContext;
  }
  
  protected LoadingLayoutProxy a(boolean paramBoolean1, boolean paramBoolean2)
  {
    LoadingLayoutProxy localLoadingLayoutProxy = new LoadingLayoutProxy();
    if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout())) {
      localLoadingLayoutProxy.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase);
    }
    if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout())) {
      localLoadingLayoutProxy.a(this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase);
    }
    return localLoadingLayoutProxy;
  }
  
  public abstract PullToRefreshBase.Orientation a();
  
  public final void a()
  {
    if (b()) {
      a(PullToRefreshBase.State.RESET, new boolean[0]);
    }
  }
  
  public final void a(int paramInt)
  {
    int i = d();
    paramInt = Math.min(i, Math.max(-i, paramInt));
    if (this.f)
    {
      if (paramInt >= 0) {
        break label69;
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.setVisibility(0);
    }
    for (;;)
    {
      switch (acrv.a[a().ordinal()])
      {
      default: 
        return;
        label69:
        if (paramInt > 0)
        {
          this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.setVisibility(0);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.setVisibility(4);
          this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.setVisibility(4);
        }
        break;
      }
    }
    scrollTo(0, paramInt);
    return;
    scrollTo(paramInt, 0);
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    switch (acrv.a[a().ordinal()])
    {
    }
    do
    {
      do
      {
        return;
      } while (localLayoutParams.width == paramInt1);
      localLayoutParams.width = paramInt1;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
      return;
    } while (localLayoutParams.height == paramInt2);
    localLayoutParams.height = paramInt2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
  }
  
  protected final void a(int paramInt, acrw paramacrw)
  {
    a(paramInt, c(), 0L, paramacrw);
  }
  
  protected void a(TypedArray paramTypedArray) {}
  
  protected void a(Bundle paramBundle) {}
  
  protected final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, -1, paramLayoutParams);
  }
  
  final void a(PullToRefreshBase.State paramState, boolean... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$State = paramState;
    switch (acrv.b[this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$State.ordinal()])
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnPullEventListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnPullEventListener.a(this, this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$State, this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode);
      }
      return;
      e();
      continue;
      c();
      continue;
      d();
      continue;
      a(paramVarArgs[0]);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout()) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout()) {
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.c();
    }
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        acrt localacrt = new acrt(this);
        switch (acrv.c[this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.ordinal()])
        {
        case 2: 
        default: 
          a(-b(), localacrt);
          return;
        }
        a(a(), localacrt);
        return;
      }
      b(0);
      return;
    }
    h();
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.permitsPullToRefresh();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    View localView = a();
    if ((localView instanceof ViewGroup))
    {
      ((ViewGroup)localView).addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
  }
  
  protected final int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.a();
  }
  
  public final void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.d();
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.d();
    postDelayed(new acrs(this), 1000L);
  }
  
  protected final void b(int paramInt)
  {
    a(paramInt, c());
  }
  
  protected void b(Bundle paramBundle) {}
  
  public final boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$State == PullToRefreshBase.State.REFRESHING) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$State == PullToRefreshBase.State.MANUAL_REFRESHING);
  }
  
  protected int c()
  {
    return 200;
  }
  
  protected void c()
  {
    switch (acrv.c[this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.a();
  }
  
  public abstract boolean c();
  
  protected void d()
  {
    switch (acrv.c[this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.b();
  }
  
  public abstract boolean d();
  
  protected void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.f = true;
    b(0);
  }
  
  protected final void f()
  {
    int i1 = 0;
    int i2 = (int)(d() * 1.2F);
    int k = getPaddingLeft();
    int j = getPaddingTop();
    int n = getPaddingRight();
    int m = getPaddingBottom();
    int i;
    switch (acrv.a[a().ordinal()])
    {
    default: 
      i = m;
      m = k;
      k = j;
      j = i;
      i = n;
    }
    for (;;)
    {
      setPadding(m, k, i, j);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout()) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.setWidth(i2);
      }
      for (i = -i2;; i = 0)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout()) {
          break label163;
        }
        this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.setWidth(i2);
        k = -i2;
        n = i;
        i = k;
        k = j;
        j = m;
        m = n;
        break;
      }
      label163:
      n = i;
      i = 0;
      k = j;
      j = m;
      m = n;
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout()) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.setHeight(i2);
      }
      for (i = -i2;; i = 0)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout()) {
          break label250;
        }
        this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.setHeight(i2);
        j = -i2;
        m = i;
        i = n;
        n = k;
        k = m;
        m = n;
        break;
      }
      label250:
      m = i;
      i = n;
      n = k;
      j = i1;
      k = m;
      m = n;
    }
  }
  
  protected void g()
  {
    Object localObject = a();
    if (this == this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.getParent()) {
      removeView(this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout()) {
      a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase, 0, (ViewGroup.LayoutParams)localObject);
    }
    if (this == this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase.getParent()) {
      removeView(this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout()) {
      a(this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase, (ViewGroup.LayoutParams)localObject);
    }
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode != PullToRefreshBase.Mode.BOTH) {}
    for (localObject = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode;; localObject = PullToRefreshBase.Mode.PULL_FROM_START)
    {
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode = ((PullToRefreshBase.Mode)localObject);
      return;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!a()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    if ((i != 0) && (this.jdField_a_of_type_Boolean)) {
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_Boolean;
      if ((!this.jdField_c_of_type_Boolean) && (b())) {
        return true;
      }
      if (e())
      {
        float f3 = paramMotionEvent.getY();
        float f4 = paramMotionEvent.getX();
        float f2;
        switch (acrv.a[a().ordinal()])
        {
        default: 
          f2 = f3 - this.jdField_b_of_type_Float;
        }
        for (float f1 = f4 - this.jdField_a_of_type_Float;; f1 = f3 - this.jdField_b_of_type_Float)
        {
          float f5 = Math.abs(f2);
          if ((f5 <= this.jdField_a_of_type_Int) || ((this.jdField_d_of_type_Boolean) && (f5 <= Math.abs(f1)))) {
            break;
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout()) || (f2 < 1.0F) || (!d())) {
            break label273;
          }
          this.jdField_b_of_type_Float = f3;
          this.jdField_a_of_type_Float = f4;
          this.jdField_a_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode != PullToRefreshBase.Mode.BOTH) {
            break;
          }
          this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode = PullToRefreshBase.Mode.PULL_FROM_START;
          break;
          f2 = f4 - this.jdField_a_of_type_Float;
        }
        label273:
        if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout()) && (f2 <= -1.0F) && (c()))
        {
          this.jdField_b_of_type_Float = f3;
          this.jdField_a_of_type_Float = f4;
          this.jdField_a_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode == PullToRefreshBase.Mode.BOTH)
          {
            this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode = PullToRefreshBase.Mode.PULL_FROM_END;
            continue;
            if (e())
            {
              f1 = paramMotionEvent.getY();
              this.jdField_d_of_type_Float = f1;
              this.jdField_b_of_type_Float = f1;
              f1 = paramMotionEvent.getX();
              this.jdField_c_of_type_Float = f1;
              this.jdField_a_of_type_Float = f1;
              this.jdField_a_of_type_Boolean = false;
            }
          }
        }
      }
    }
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      setMode(PullToRefreshBase.Mode.mapIntToValue(paramParcelable.getInt("ptr_mode", 0)));
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode = PullToRefreshBase.Mode.mapIntToValue(paramParcelable.getInt("ptr_current_mode", 0));
      this.jdField_c_of_type_Boolean = paramParcelable.getBoolean("ptr_disable_scrolling", false);
      this.jdField_b_of_type_Boolean = paramParcelable.getBoolean("ptr_show_refreshing_view", true);
      super.onRestoreInstanceState(paramParcelable.getParcelable("ptr_super"));
      PullToRefreshBase.State localState = PullToRefreshBase.State.mapIntToValue(paramParcelable.getInt("ptr_state", 0));
      if ((localState == PullToRefreshBase.State.REFRESHING) || (localState == PullToRefreshBase.State.MANUAL_REFRESHING)) {
        a(localState, new boolean[] { true });
      }
      a(paramParcelable);
      return;
    }
    try
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    catch (Exception paramParcelable)
    {
      QLog.e("PullToRefresh", 1, "onRestoreInstanceState fail.", paramParcelable);
    }
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    b(localBundle);
    localBundle.putInt("ptr_state", this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$State.getIntValue());
    localBundle.putInt("ptr_mode", this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.getIntValue());
    localBundle.putInt("ptr_current_mode", this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.getIntValue());
    localBundle.putBoolean("ptr_disable_scrolling", this.jdField_c_of_type_Boolean);
    localBundle.putBoolean("ptr_show_refreshing_view", this.jdField_b_of_type_Boolean);
    localBundle.putParcelable("ptr_super", super.onSaveInstanceState());
    return localBundle;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    f();
    a(paramInt1, paramInt2);
    post(new acru(this));
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!a()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if ((!this.jdField_c_of_type_Boolean) && (b())) {
              return true;
            }
          } while ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0));
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          }
        } while (!e());
        float f1 = paramMotionEvent.getY();
        this.jdField_d_of_type_Float = f1;
        this.jdField_b_of_type_Float = f1;
        f1 = paramMotionEvent.getX();
        this.jdField_c_of_type_Float = f1;
        this.jdField_a_of_type_Float = f1;
        return true;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      i();
      return true;
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$State == PullToRefreshBase.State.RELEASE_TO_REFRESH) && ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener != null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener2 != null)))
    {
      a(PullToRefreshBase.State.REFRESHING, new boolean[] { true });
      return true;
    }
    if (b())
    {
      b(0);
      return true;
    }
    a(PullToRefreshBase.State.RESET, new boolean[0]);
    return true;
  }
  
  public void setDisableScrollingWhileRefreshing(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setScrollingWhileRefreshingEnabled(paramBoolean);
      return;
    }
  }
  
  public final void setFilterTouchEvents(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setFooterLayout(LoadingLayoutBase paramLoadingLayoutBase)
  {
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase = paramLoadingLayoutBase;
    g();
  }
  
  public void setHasPullDownFriction(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setHasPullUpFriction(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setHeaderLayout(LoadingLayoutBase paramLoadingLayoutBase)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshLoadingLayoutBase = paramLoadingLayoutBase;
    g();
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    a().setLastUpdatedLabel(paramCharSequence);
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    a().setLoadingDrawable(paramDrawable);
  }
  
  public void setLoadingDrawable(Drawable paramDrawable, PullToRefreshBase.Mode paramMode)
  {
    a(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setLoadingDrawable(paramDrawable);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    a().setLongClickable(paramBoolean);
  }
  
  public final void setMode(PullToRefreshBase.Mode paramMode)
  {
    if (paramMode != this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode = paramMode;
      g();
    }
  }
  
  public void setOnPullEventListener(PullToRefreshBase.OnPullEventListener paramOnPullEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnPullEventListener = paramOnPullEventListener;
  }
  
  public final void setOnRefreshListener(PullToRefreshBase.OnRefreshListener2 paramOnRefreshListener2)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener2 = paramOnRefreshListener2;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener = null;
  }
  
  public final void setOnRefreshListener(PullToRefreshBase.OnRefreshListener paramOnRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener = paramOnRefreshListener;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$OnRefreshListener2 = null;
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    a().setPullLabel(paramCharSequence);
  }
  
  public void setPullLabel(CharSequence paramCharSequence, PullToRefreshBase.Mode paramMode)
  {
    a(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setPullLabel(paramCharSequence);
  }
  
  public final void setPullToRefreshEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (PullToRefreshBase.Mode localMode = PullToRefreshBase.Mode.getDefault();; localMode = PullToRefreshBase.Mode.DISABLED)
    {
      setMode(localMode);
      return;
    }
  }
  
  public final void setPullToRefreshOverScrollEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final void setRefreshing()
  {
    setRefreshing(true);
  }
  
  public final void setRefreshing(boolean paramBoolean)
  {
    if (!b()) {
      a(PullToRefreshBase.State.MANUAL_REFRESHING, new boolean[] { paramBoolean });
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    a().setRefreshingLabel(paramCharSequence);
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence, PullToRefreshBase.Mode paramMode)
  {
    a(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setRefreshingLabel(paramCharSequence);
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    setReleaseLabel(paramCharSequence, PullToRefreshBase.Mode.BOTH);
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence, PullToRefreshBase.Mode paramMode)
  {
    a(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setReleaseLabel(paramCharSequence);
  }
  
  public void setScrollAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public final void setScrollingWhileRefreshingEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setSecondFooterLayout(View paramView) {}
  
  public final void setShowViewWhileRefreshing(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase
 * JD-Core Version:    0.7.0.1
 */