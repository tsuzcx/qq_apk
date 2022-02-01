package com.tencent.mobileqq.qqexpand.widget.pulltorefresh;

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
import com.tencent.mobileqq.qqexpand.api.R.styleable;
import com.tencent.qphone.base.util.QLog;

public abstract class PullToRefreshBase<T extends View>
  extends LinearLayout
  implements IPullToRefresh<T>
{
  private float jdField_a_of_type_Float;
  public int a;
  protected T a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected LoadingLayoutBase a;
  private PullToRefreshBase.AnimationStyle jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$AnimationStyle = PullToRefreshBase.AnimationStyle.getDefault();
  private PullToRefreshBase.Mode jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode = PullToRefreshBase.Mode.getDefault();
  private PullToRefreshBase.OnPullEventListener<T> jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnPullEventListener;
  private PullToRefreshBase.OnRefreshListener2<T> jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener2;
  private PullToRefreshBase.OnRefreshListener<T> jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener;
  private PullToRefreshBase<T>.SmoothScrollRunnable jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$SmoothScrollRunnable;
  private PullToRefreshBase.State jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$State = PullToRefreshBase.State.RESET;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  public int b;
  protected LoadingLayoutBase b;
  private PullToRefreshBase.Mode jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e = true;
  private boolean f = true;
  private boolean g = true;
  private boolean h = true;
  
  public PullToRefreshBase(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    a(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshBase(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode = paramMode;
    a(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode = paramMode;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$AnimationStyle = paramAnimationStyle;
    a(paramContext, null);
  }
  
  private LinearLayout.LayoutParams a()
  {
    if (PullToRefreshBase.5.a[a().ordinal()] != 1) {
      return new LinearLayout.LayoutParams(-1, -2);
    }
    return new LinearLayout.LayoutParams(-2, -1);
  }
  
  private final void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, 0L, null);
  }
  
  private final void a(int paramInt, long paramLong1, long paramLong2, PullToRefreshBase.OnSmoothScrollFinishedListener paramOnSmoothScrollFinishedListener)
  {
    PullToRefreshBase.SmoothScrollRunnable localSmoothScrollRunnable = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$SmoothScrollRunnable;
    if (localSmoothScrollRunnable != null) {
      localSmoothScrollRunnable.a();
    }
    if (PullToRefreshBase.5.a[a().ordinal()] != 1) {}
    for (int i = getScrollY();; i = getScrollX()) {
      break;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PullToRefreshBase", 2, String.format("oldScroll:%d newScroll:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }));
    }
    if (i != paramInt)
    {
      if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {
        this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$SmoothScrollRunnable = new PullToRefreshBase.SmoothScrollRunnable(this, i, paramInt, paramLong1, paramOnSmoothScrollFinishedListener);
      if (paramLong2 > 0L)
      {
        postDelayed(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$SmoothScrollRunnable, paramLong2);
        return;
      }
      post(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$SmoothScrollRunnable);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (PullToRefreshBase.5.a[a().ordinal()] != 1) {
      setOrientation(1);
    } else {
      setOrientation(0);
    }
    setGravity(17);
    this.jdField_c_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aO);
    if (localTypedArray.hasValue(R.styleable.o)) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode = PullToRefreshBase.Mode.mapIntToValue(localTypedArray.getInteger(R.styleable.o, 0));
    }
    if (localTypedArray.hasValue(R.styleable.jdField_c_of_type_Int)) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$AnimationStyle = PullToRefreshBase.AnimationStyle.mapIntToValue(localTypedArray.getInteger(R.styleable.jdField_c_of_type_Int, 0));
    }
    if (localTypedArray.hasValue(R.styleable.k)) {
      this.jdField_a_of_type_Int = ((int)localTypedArray.getDimension(R.styleable.k, 0.0F));
    }
    if (localTypedArray.hasValue(R.styleable.j)) {
      this.jdField_b_of_type_Int = ((int)localTypedArray.getDimension(R.styleable.j, 0.0F));
    }
    this.jdField_a_of_type_AndroidViewView = a(paramContext, paramAttributeSet);
    a(paramContext, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase = a(paramContext, PullToRefreshBase.Mode.PULL_FROM_START, localTypedArray);
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase = a(paramContext, PullToRefreshBase.Mode.PULL_FROM_END, localTypedArray);
    if (localTypedArray.hasValue(R.styleable.q))
    {
      paramContext = localTypedArray.getDrawable(R.styleable.q);
      if (paramContext != null) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramContext);
      }
    }
    else if (localTypedArray.hasValue(R.styleable.jdField_b_of_type_Int))
    {
      paramContext = localTypedArray.getDrawable(R.styleable.jdField_b_of_type_Int);
      if (paramContext != null) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramContext);
      }
    }
    if (localTypedArray.hasValue(R.styleable.p)) {
      this.e = localTypedArray.getBoolean(R.styleable.p, true);
    }
    if (localTypedArray.hasValue(R.styleable.s)) {
      this.jdField_c_of_type_Boolean = localTypedArray.getBoolean(R.styleable.s, false);
    }
    a(localTypedArray);
    localTypedArray.recycle();
    g();
  }
  
  private void a(Context paramContext, T paramT)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramT, -1, -1);
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout, new LinearLayout.LayoutParams(-1, -1));
  }
  
  private int d()
  {
    if (PullToRefreshBase.5.a[a().ordinal()] != 1) {
      return Math.round(getHeight() / 2.0F);
    }
    return Math.round(getWidth() / 2.0F);
  }
  
  private boolean e()
  {
    int i = PullToRefreshBase.5.c[this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.ordinal()];
    boolean bool = true;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4) {
          return false;
        }
        if (!b())
        {
          if (a()) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
      return a();
    }
    return b();
  }
  
  private void h()
  {
    PullToRefreshBase.OnRefreshListener localOnRefreshListener = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener;
    if (localOnRefreshListener != null)
    {
      localOnRefreshListener.a(this);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener2 != null) {
      if ((this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode != PullToRefreshBase.Mode.PULL_FROM_START) && (this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode != PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY))
      {
        if (this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode == PullToRefreshBase.Mode.PULL_FROM_END) {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener2.b(this);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener2.a(this);
      }
    }
  }
  
  private void i()
  {
    float f1;
    float f2;
    if (PullToRefreshBase.5.a[a().ordinal()] != 1)
    {
      f1 = this.jdField_d_of_type_Float;
      f2 = this.jdField_b_of_type_Float;
    }
    else
    {
      f1 = this.jdField_c_of_type_Float;
      f2 = this.jdField_a_of_type_Float;
    }
    int i;
    int j;
    if (PullToRefreshBase.5.c[this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.ordinal()] != 1)
    {
      if (this.g) {
        i = Math.round(Math.min(f1 - f2, 0.0F) / 2.0F);
      } else {
        i = Math.round(Math.min(f1 - f2, 0.0F));
      }
      j = b();
    }
    else
    {
      if (this.h) {
        i = Math.round(Math.max(f1 - f2, 0.0F) / 2.0F);
      } else {
        i = Math.round(Math.max(f1 - f2, 0.0F));
      }
      j = a();
    }
    a(i);
    if ((i != 0) && (!d()))
    {
      f1 = Math.abs(i) / j;
      if (PullToRefreshBase.5.c[this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.ordinal()] != 1) {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.a(f1);
      } else {
        this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.a(f1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$State != PullToRefreshBase.State.PULL_TO_REFRESH) && (j >= Math.abs(i)))
      {
        a(PullToRefreshBase.State.PULL_TO_REFRESH, new boolean[0]);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$State == PullToRefreshBase.State.PULL_TO_REFRESH) && (j < Math.abs(i))) {
        a(PullToRefreshBase.State.RELEASE_TO_REFRESH, new boolean[0]);
      }
    }
  }
  
  protected final int a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.a();
  }
  
  public final T a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected abstract T a(Context paramContext, AttributeSet paramAttributeSet);
  
  public final ILoadingLayout a()
  {
    return a(true, true);
  }
  
  public final ILoadingLayout a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2);
  }
  
  public final LoadingLayoutBase a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase;
  }
  
  protected LoadingLayoutBase a(Context paramContext, PullToRefreshBase.Mode paramMode, TypedArray paramTypedArray)
  {
    paramContext = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$AnimationStyle.createLoadingLayout(paramContext, paramMode, a(), paramTypedArray);
    paramContext.setVisibility(4);
    return paramContext;
  }
  
  protected LoadingLayoutProxy a(boolean paramBoolean1, boolean paramBoolean2)
  {
    LoadingLayoutProxy localLoadingLayoutProxy = new LoadingLayoutProxy();
    if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout())) {
      localLoadingLayoutProxy.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase);
    }
    if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout())) {
      localLoadingLayoutProxy.a(this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase);
    }
    return localLoadingLayoutProxy;
  }
  
  public abstract PullToRefreshBase.Orientation a();
  
  public final PullToRefreshBase.State a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$State;
  }
  
  public final void a()
  {
    if (d()) {
      a(PullToRefreshBase.State.RESET, new boolean[0]);
    }
  }
  
  protected final void a(int paramInt)
  {
    int i = d();
    paramInt = Math.min(i, Math.max(-i, paramInt));
    if (this.f) {
      if (paramInt < 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.setVisibility(0);
      }
      else if (paramInt > 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.setVisibility(4);
        this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.setVisibility(4);
      }
    }
    i = PullToRefreshBase.5.a[a().ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      scrollTo(0, paramInt);
      return;
    }
    scrollTo(paramInt, 0);
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    int i = PullToRefreshBase.5.a[a().ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if (localLayoutParams.height != paramInt2)
      {
        localLayoutParams.height = paramInt2;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
      }
    }
    else if (localLayoutParams.width != paramInt1)
    {
      localLayoutParams.width = paramInt1;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
    }
  }
  
  protected final void a(int paramInt, PullToRefreshBase.OnSmoothScrollFinishedListener paramOnSmoothScrollFinishedListener)
  {
    a(paramInt, c(), 0L, paramOnSmoothScrollFinishedListener);
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
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$State = paramState;
    switch (PullToRefreshBase.5.b[this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$State.ordinal()])
    {
    default: 
      break;
    case 4: 
    case 5: 
      a(paramVarArgs[0]);
      break;
    case 3: 
      d();
      break;
    case 2: 
      c();
      break;
    case 1: 
      e();
    }
    paramState = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnPullEventListener;
    if (paramState != null) {
      paramState.a(this, this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$State, this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout()) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.f();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout()) {
      this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.f();
    }
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        PullToRefreshBase.2 local2 = new PullToRefreshBase.2(this);
        if (PullToRefreshBase.5.c[this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.ordinal()] != 1)
        {
          a(-b(), local2);
          return;
        }
        a(a(), local2);
        return;
      }
      b(0);
      return;
    }
    h();
  }
  
  protected abstract boolean a();
  
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
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.a();
  }
  
  public final void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.h();
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.h();
    postDelayed(new PullToRefreshBase.1(this), 1000L);
  }
  
  protected final void b(int paramInt)
  {
    a(paramInt, c());
  }
  
  protected void b(Bundle paramBundle) {}
  
  protected abstract boolean b();
  
  protected int c()
  {
    return 200;
  }
  
  protected void c()
  {
    int i = PullToRefreshBase.5.c[this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.d();
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.d();
  }
  
  public final boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.permitsPullToRefresh();
  }
  
  protected void d()
  {
    int i = PullToRefreshBase.5.c[this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.e();
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.e();
  }
  
  public final boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$State == PullToRefreshBase.State.REFRESHING) || (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$State == PullToRefreshBase.State.MANUAL_REFRESHING);
  }
  
  protected void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.f = true;
    b(0);
  }
  
  protected final void f()
  {
    int i1 = (int)(d() * 1.2F);
    int m = getPaddingLeft();
    int n = getPaddingTop();
    int j = getPaddingRight();
    int k = getPaddingBottom();
    int i = PullToRefreshBase.5.a[a().ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout())
        {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.setHeight(i1);
          i = -i1;
        }
        else
        {
          i = 0;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout())
        {
          this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.setHeight(i1);
          k = -i1;
          n = i;
        }
        else
        {
          k = 0;
          n = i;
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout())
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.setWidth(i1);
        i = -i1;
      }
      else
      {
        i = 0;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout())
      {
        this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.setWidth(i1);
        j = -i1;
        m = i;
      }
      else
      {
        j = 0;
        m = i;
      }
    }
    setPadding(m, n, j, k);
  }
  
  protected void g()
  {
    Object localObject = a();
    if (this == this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.getParent()) {
      removeView(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout())
    {
      ((LinearLayout.LayoutParams)localObject).topMargin += this.jdField_a_of_type_Int;
      ((LinearLayout.LayoutParams)localObject).bottomMargin += this.jdField_b_of_type_Int;
      a(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase, 0, (ViewGroup.LayoutParams)localObject);
    }
    if (this == this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase.getParent()) {
      removeView(this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout()) {
      a(this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase, (ViewGroup.LayoutParams)localObject);
    }
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode != PullToRefreshBase.Mode.BOTH) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode;
    } else {
      localObject = PullToRefreshBase.Mode.PULL_FROM_START;
    }
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode = ((PullToRefreshBase.Mode)localObject);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!c()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i != 3) && (i != 1))
    {
      if ((i != 0) && (this.jdField_a_of_type_Boolean)) {
        return true;
      }
      float f1;
      if (i != 0)
      {
        if (i == 2)
        {
          if ((!this.jdField_c_of_type_Boolean) && (d())) {
            return true;
          }
          if (e())
          {
            float f3 = paramMotionEvent.getY();
            float f4 = paramMotionEvent.getX();
            float f2;
            if (PullToRefreshBase.5.a[a().ordinal()] != 1)
            {
              f1 = f3 - this.jdField_b_of_type_Float;
              f2 = f4 - this.jdField_a_of_type_Float;
            }
            else
            {
              f1 = f4 - this.jdField_a_of_type_Float;
              f2 = f3 - this.jdField_b_of_type_Float;
            }
            float f5 = Math.abs(f1);
            if ((f5 > this.jdField_c_of_type_Int) && ((!this.jdField_d_of_type_Boolean) || (f5 > Math.abs(f2)))) {
              if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showHeaderLoadingLayout()) && (f1 >= 1.0F) && (a()))
              {
                this.jdField_b_of_type_Float = f3;
                this.jdField_a_of_type_Float = f4;
                this.jdField_a_of_type_Boolean = true;
                if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode == PullToRefreshBase.Mode.BOTH) {
                  this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode = PullToRefreshBase.Mode.PULL_FROM_START;
                }
              }
              else if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.showFooterLoadingLayout()) && (f1 <= -1.0F) && (b()))
              {
                this.jdField_b_of_type_Float = f3;
                this.jdField_a_of_type_Float = f4;
                this.jdField_a_of_type_Boolean = true;
                if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode == PullToRefreshBase.Mode.BOTH) {
                  this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode = PullToRefreshBase.Mode.PULL_FROM_END;
                }
              }
            }
          }
        }
      }
      else if (e())
      {
        f1 = paramMotionEvent.getY();
        this.jdField_d_of_type_Float = f1;
        this.jdField_b_of_type_Float = f1;
        f1 = paramMotionEvent.getX();
        this.jdField_c_of_type_Float = f1;
        this.jdField_a_of_type_Float = f1;
        this.jdField_a_of_type_Boolean = false;
      }
      return this.jdField_a_of_type_Boolean;
    }
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      setMode(PullToRefreshBase.Mode.mapIntToValue(paramParcelable.getInt("ptr_mode", 0)));
      this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode = PullToRefreshBase.Mode.mapIntToValue(paramParcelable.getInt("ptr_current_mode", 0));
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
    localBundle.putInt("ptr_state", this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$State.getIntValue());
    localBundle.putInt("ptr_mode", this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.getIntValue());
    localBundle.putInt("ptr_current_mode", this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.getIntValue());
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
    post(new PullToRefreshBase.3(this));
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!c()) {
      return false;
    }
    if ((!this.jdField_c_of_type_Boolean) && (d())) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label213;
          }
          this.jdField_b_of_type_Float = paramMotionEvent.getY();
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
          i();
          return true;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$State == PullToRefreshBase.State.RELEASE_TO_REFRESH) && ((this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener != null) || (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener2 != null)))
        {
          a(PullToRefreshBase.State.REFRESHING, new boolean[] { true });
          return true;
        }
        if (d())
        {
          b(0);
          return true;
        }
        a(PullToRefreshBase.State.RESET, new boolean[0]);
        return true;
      }
    }
    else if (e())
    {
      float f1 = paramMotionEvent.getY();
      this.jdField_d_of_type_Float = f1;
      this.jdField_b_of_type_Float = f1;
      f1 = paramMotionEvent.getX();
      this.jdField_c_of_type_Float = f1;
      this.jdField_a_of_type_Float = f1;
      return true;
    }
    label213:
    return false;
  }
  
  public void setDisableScrollingWhileRefreshing(boolean paramBoolean)
  {
    setScrollingWhileRefreshingEnabled(paramBoolean ^ true);
  }
  
  public final void setFilterTouchEvents(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setFooterLayout(LoadingLayoutBase paramLoadingLayoutBase)
  {
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase = paramLoadingLayoutBase;
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
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshLoadingLayoutBase = paramLoadingLayoutBase;
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
    if (paramMode != this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode = paramMode;
      g();
    }
  }
  
  public void setOnPullEventListener(PullToRefreshBase.OnPullEventListener<T> paramOnPullEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnPullEventListener = paramOnPullEventListener;
  }
  
  public final void setOnRefreshListener(PullToRefreshBase.OnRefreshListener2<T> paramOnRefreshListener2)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener2 = paramOnRefreshListener2;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener = null;
  }
  
  public final void setOnRefreshListener(PullToRefreshBase.OnRefreshListener<T> paramOnRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener = paramOnRefreshListener;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$OnRefreshListener2 = null;
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
    PullToRefreshBase.Mode localMode;
    if (paramBoolean) {
      localMode = PullToRefreshBase.Mode.getDefault();
    } else {
      localMode = PullToRefreshBase.Mode.DISABLED;
    }
    setMode(localMode);
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
    if (!d()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase
 * JD-Core Version:    0.7.0.1
 */