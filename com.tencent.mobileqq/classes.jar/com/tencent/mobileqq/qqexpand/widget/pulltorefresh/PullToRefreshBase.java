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
  private PullToRefreshBase.OnPullEventListener<T> A;
  private PullToRefreshBase<T>.SmoothScrollRunnable B;
  private int a;
  private float b;
  public int c = 0;
  public int d = 0;
  protected T e;
  protected LoadingLayoutBase f;
  protected LoadingLayoutBase g;
  private float h;
  private float i;
  private float j;
  private boolean k = false;
  private PullToRefreshBase.State l = PullToRefreshBase.State.RESET;
  private PullToRefreshBase.Mode m = PullToRefreshBase.Mode.getDefault();
  private PullToRefreshBase.Mode n;
  private FrameLayout o;
  private boolean p = true;
  private boolean q = false;
  private boolean r = true;
  private boolean s = true;
  private boolean t = true;
  private boolean u = true;
  private boolean v = true;
  private Interpolator w;
  private PullToRefreshBase.AnimationStyle x = PullToRefreshBase.AnimationStyle.getDefault();
  private PullToRefreshBase.OnRefreshListener<T> y;
  private PullToRefreshBase.OnRefreshListener2<T> z;
  
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
  
  public PullToRefreshBase(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext);
    this.m = paramMode;
    a(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext);
    this.m = paramMode;
    this.x = paramAnimationStyle;
    a(paramContext, null);
  }
  
  private final void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, 0L, null);
  }
  
  private final void a(int paramInt, long paramLong1, long paramLong2, PullToRefreshBase.OnSmoothScrollFinishedListener paramOnSmoothScrollFinishedListener)
  {
    PullToRefreshBase.SmoothScrollRunnable localSmoothScrollRunnable = this.B;
    if (localSmoothScrollRunnable != null) {
      localSmoothScrollRunnable.a();
    }
    if (PullToRefreshBase.5.a[getPullToRefreshScrollDirection().ordinal()] != 1) {}
    for (int i1 = getScrollY();; i1 = getScrollX()) {
      break;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PullToRefreshBase", 2, String.format("oldScroll:%d newScroll:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt) }));
    }
    if (i1 != paramInt)
    {
      if (this.w == null) {
        this.w = new DecelerateInterpolator();
      }
      this.B = new PullToRefreshBase.SmoothScrollRunnable(this, i1, paramInt, paramLong1, paramOnSmoothScrollFinishedListener);
      if (paramLong2 > 0L)
      {
        postDelayed(this.B, paramLong2);
        return;
      }
      post(this.B);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (PullToRefreshBase.5.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
      setOrientation(1);
    } else {
      setOrientation(0);
    }
    setGravity(17);
    this.a = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aR);
    if (localTypedArray.hasValue(R.styleable.bf)) {
      this.m = PullToRefreshBase.Mode.mapIntToValue(localTypedArray.getInteger(R.styleable.bf, 0));
    }
    if (localTypedArray.hasValue(R.styleable.aT)) {
      this.x = PullToRefreshBase.AnimationStyle.mapIntToValue(localTypedArray.getInteger(R.styleable.aT, 0));
    }
    if (localTypedArray.hasValue(R.styleable.bb)) {
      this.c = ((int)localTypedArray.getDimension(R.styleable.bb, 0.0F));
    }
    if (localTypedArray.hasValue(R.styleable.ba)) {
      this.d = ((int)localTypedArray.getDimension(R.styleable.ba, 0.0F));
    }
    this.e = b(paramContext, paramAttributeSet);
    a(paramContext, this.e);
    this.f = a(paramContext, PullToRefreshBase.Mode.PULL_FROM_START, localTypedArray);
    this.g = a(paramContext, PullToRefreshBase.Mode.PULL_FROM_END, localTypedArray);
    if (localTypedArray.hasValue(R.styleable.bh))
    {
      paramContext = localTypedArray.getDrawable(R.styleable.bh);
      if (paramContext != null) {
        this.e.setBackgroundDrawable(paramContext);
      }
    }
    else if (localTypedArray.hasValue(R.styleable.aS))
    {
      paramContext = localTypedArray.getDrawable(R.styleable.aS);
      if (paramContext != null) {
        this.e.setBackgroundDrawable(paramContext);
      }
    }
    if (localTypedArray.hasValue(R.styleable.bg)) {
      this.s = localTypedArray.getBoolean(R.styleable.bg, true);
    }
    if (localTypedArray.hasValue(R.styleable.bj)) {
      this.q = localTypedArray.getBoolean(R.styleable.bj, false);
    }
    a(localTypedArray);
    localTypedArray.recycle();
    k();
  }
  
  private void a(Context paramContext, T paramT)
  {
    this.o = new FrameLayout(paramContext);
    this.o.addView(paramT, -1, -1);
    a(this.o, new LinearLayout.LayoutParams(-1, -1));
  }
  
  private LinearLayout.LayoutParams getLoadingLayoutLayoutParams()
  {
    if (PullToRefreshBase.5.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
      return new LinearLayout.LayoutParams(-1, -2);
    }
    return new LinearLayout.LayoutParams(-2, -1);
  }
  
  private int getMaximumPullScroll()
  {
    if (PullToRefreshBase.5.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
      return Math.round(getHeight() / 2.0F);
    }
    return Math.round(getWidth() / 2.0F);
  }
  
  private void l()
  {
    PullToRefreshBase.OnRefreshListener localOnRefreshListener = this.y;
    if (localOnRefreshListener != null)
    {
      localOnRefreshListener.a(this);
      return;
    }
    if (this.z != null) {
      if ((this.n != PullToRefreshBase.Mode.PULL_FROM_START) && (this.n != PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY))
      {
        if (this.n == PullToRefreshBase.Mode.PULL_FROM_END) {
          this.z.b(this);
        }
      }
      else {
        this.z.a(this);
      }
    }
  }
  
  private boolean m()
  {
    int i1 = PullToRefreshBase.5.c[this.m.ordinal()];
    boolean bool = true;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 4) {
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
  
  private void n()
  {
    float f1;
    float f2;
    if (PullToRefreshBase.5.a[getPullToRefreshScrollDirection().ordinal()] != 1)
    {
      f1 = this.j;
      f2 = this.h;
    }
    else
    {
      f1 = this.i;
      f2 = this.b;
    }
    int i1;
    int i2;
    if (PullToRefreshBase.5.c[this.n.ordinal()] != 1)
    {
      if (this.u) {
        i1 = Math.round(Math.min(f1 - f2, 0.0F) / 2.0F);
      } else {
        i1 = Math.round(Math.min(f1 - f2, 0.0F));
      }
      i2 = getHeaderSize();
    }
    else
    {
      if (this.v) {
        i1 = Math.round(Math.max(f1 - f2, 0.0F) / 2.0F);
      } else {
        i1 = Math.round(Math.max(f1 - f2, 0.0F));
      }
      i2 = getFooterSize();
    }
    setHeaderScroll(i1);
    if ((i1 != 0) && (!d()))
    {
      f1 = Math.abs(i1) / i2;
      if (PullToRefreshBase.5.c[this.n.ordinal()] != 1) {
        this.f.a(f1);
      } else {
        this.g.a(f1);
      }
      if ((this.l != PullToRefreshBase.State.PULL_TO_REFRESH) && (i2 >= Math.abs(i1)))
      {
        a(PullToRefreshBase.State.PULL_TO_REFRESH, new boolean[0]);
        return;
      }
      if ((this.l == PullToRefreshBase.State.PULL_TO_REFRESH) && (i2 < Math.abs(i1))) {
        a(PullToRefreshBase.State.RELEASE_TO_REFRESH, new boolean[0]);
      }
    }
  }
  
  public final ILoadingLayout a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return b(paramBoolean1, paramBoolean2);
  }
  
  protected LoadingLayoutBase a(Context paramContext, PullToRefreshBase.Mode paramMode, TypedArray paramTypedArray)
  {
    paramContext = this.x.createLoadingLayout(paramContext, paramMode, getPullToRefreshScrollDirection(), paramTypedArray);
    paramContext.setVisibility(4);
    return paramContext;
  }
  
  protected final void a(int paramInt)
  {
    a(paramInt, getPullToRefreshScrollDuration());
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
    int i1 = PullToRefreshBase.5.a[getPullToRefreshScrollDirection().ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      if (localLayoutParams.height != paramInt2)
      {
        localLayoutParams.height = paramInt2;
        this.o.requestLayout();
      }
    }
    else if (localLayoutParams.width != paramInt1)
    {
      localLayoutParams.width = paramInt1;
      this.o.requestLayout();
    }
  }
  
  protected final void a(int paramInt, PullToRefreshBase.OnSmoothScrollFinishedListener paramOnSmoothScrollFinishedListener)
  {
    a(paramInt, getPullToRefreshScrollDuration(), 0L, paramOnSmoothScrollFinishedListener);
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
    this.l = paramState;
    switch (PullToRefreshBase.5.b[this.l.ordinal()])
    {
    default: 
      break;
    case 4: 
    case 5: 
      a(paramVarArgs[0]);
      break;
    case 3: 
      h();
      break;
    case 2: 
      g();
      break;
    case 1: 
      i();
    }
    paramState = this.A;
    if (paramState != null) {
      paramState.a(this, this.l, this.n);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.m.showHeaderLoadingLayout()) {
      this.f.f();
    }
    if (this.m.showFooterLoadingLayout()) {
      this.g.f();
    }
    if (paramBoolean)
    {
      if (this.p)
      {
        PullToRefreshBase.2 local2 = new PullToRefreshBase.2(this);
        if (PullToRefreshBase.5.c[this.n.ordinal()] != 1)
        {
          a(-getHeaderSize(), local2);
          return;
        }
        a(getFooterSize(), local2);
        return;
      }
      a(0);
      return;
    }
    l();
  }
  
  protected abstract boolean a();
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    View localView = getRefreshableView();
    if ((localView instanceof ViewGroup))
    {
      ((ViewGroup)localView).addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
  }
  
  protected abstract T b(Context paramContext, AttributeSet paramAttributeSet);
  
  protected LoadingLayoutProxy b(boolean paramBoolean1, boolean paramBoolean2)
  {
    LoadingLayoutProxy localLoadingLayoutProxy = new LoadingLayoutProxy();
    if ((paramBoolean1) && (this.m.showHeaderLoadingLayout())) {
      localLoadingLayoutProxy.a(this.f);
    }
    if ((paramBoolean2) && (this.m.showFooterLoadingLayout())) {
      localLoadingLayoutProxy.a(this.g);
    }
    return localLoadingLayoutProxy;
  }
  
  protected void b(Bundle paramBundle) {}
  
  protected abstract boolean b();
  
  public final boolean c()
  {
    return this.m.permitsPullToRefresh();
  }
  
  public final boolean d()
  {
    return (this.l == PullToRefreshBase.State.REFRESHING) || (this.l == PullToRefreshBase.State.MANUAL_REFRESHING);
  }
  
  public final void e()
  {
    if (d()) {
      a(PullToRefreshBase.State.RESET, new boolean[0]);
    }
  }
  
  public final void f()
  {
    this.f.h();
    this.g.h();
    postDelayed(new PullToRefreshBase.1(this), 1000L);
  }
  
  protected void g()
  {
    int i1 = PullToRefreshBase.5.c[this.n.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      this.f.d();
      return;
    }
    this.g.d();
  }
  
  public final PullToRefreshBase.Mode getCurrentMode()
  {
    return this.n;
  }
  
  public final boolean getFilterTouchEvents()
  {
    return this.r;
  }
  
  protected final LoadingLayoutBase getFooterLayout()
  {
    return this.g;
  }
  
  protected final int getFooterSize()
  {
    return this.g.getContentSize();
  }
  
  public final LoadingLayoutBase getHeaderLayout()
  {
    return this.f;
  }
  
  protected final int getHeaderSize()
  {
    return this.f.getContentSize();
  }
  
  public final ILoadingLayout getLoadingLayoutProxy()
  {
    return a(true, true);
  }
  
  public final PullToRefreshBase.Mode getMode()
  {
    return this.m;
  }
  
  public abstract PullToRefreshBase.Orientation getPullToRefreshScrollDirection();
  
  protected int getPullToRefreshScrollDuration()
  {
    return 200;
  }
  
  protected int getPullToRefreshScrollDurationLonger()
  {
    return 325;
  }
  
  public final T getRefreshableView()
  {
    return this.e;
  }
  
  protected FrameLayout getRefreshableViewWrapper()
  {
    return this.o;
  }
  
  public final boolean getShowViewWhileRefreshing()
  {
    return this.p;
  }
  
  public final PullToRefreshBase.State getState()
  {
    return this.l;
  }
  
  protected void h()
  {
    int i1 = PullToRefreshBase.5.c[this.n.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      this.f.e();
      return;
    }
    this.g.e();
  }
  
  protected void i()
  {
    this.k = false;
    this.t = true;
    a(0);
  }
  
  protected final void j()
  {
    int i6 = (int)(getMaximumPullScroll() * 1.2F);
    int i4 = getPaddingLeft();
    int i5 = getPaddingTop();
    int i2 = getPaddingRight();
    int i3 = getPaddingBottom();
    int i1 = PullToRefreshBase.5.a[getPullToRefreshScrollDirection().ordinal()];
    if (i1 != 1)
    {
      if (i1 == 2)
      {
        if (this.m.showHeaderLoadingLayout())
        {
          this.f.setHeight(i6);
          i1 = -i6;
        }
        else
        {
          i1 = 0;
        }
        if (this.m.showFooterLoadingLayout())
        {
          this.g.setHeight(i6);
          i3 = -i6;
          i5 = i1;
        }
        else
        {
          i3 = 0;
          i5 = i1;
        }
      }
    }
    else
    {
      if (this.m.showHeaderLoadingLayout())
      {
        this.f.setWidth(i6);
        i1 = -i6;
      }
      else
      {
        i1 = 0;
      }
      if (this.m.showFooterLoadingLayout())
      {
        this.g.setWidth(i6);
        i2 = -i6;
        i4 = i1;
      }
      else
      {
        i2 = 0;
        i4 = i1;
      }
    }
    setPadding(i4, i5, i2, i3);
  }
  
  protected void k()
  {
    Object localObject = getLoadingLayoutLayoutParams();
    if (this == this.f.getParent()) {
      removeView(this.f);
    }
    if (this.m.showHeaderLoadingLayout())
    {
      ((LinearLayout.LayoutParams)localObject).topMargin += this.c;
      ((LinearLayout.LayoutParams)localObject).bottomMargin += this.d;
      a(this.f, 0, (ViewGroup.LayoutParams)localObject);
    }
    if (this == this.g.getParent()) {
      removeView(this.g);
    }
    if (this.m.showFooterLoadingLayout()) {
      a(this.g, (ViewGroup.LayoutParams)localObject);
    }
    j();
    if (this.m != PullToRefreshBase.Mode.BOTH) {
      localObject = this.m;
    } else {
      localObject = PullToRefreshBase.Mode.PULL_FROM_START;
    }
    this.n = ((PullToRefreshBase.Mode)localObject);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!c()) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if ((i1 != 3) && (i1 != 1))
    {
      if ((i1 != 0) && (this.k)) {
        return true;
      }
      float f1;
      if (i1 != 0)
      {
        if (i1 == 2)
        {
          if ((!this.q) && (d())) {
            return true;
          }
          if (m())
          {
            float f3 = paramMotionEvent.getY();
            float f4 = paramMotionEvent.getX();
            float f2;
            if (PullToRefreshBase.5.a[getPullToRefreshScrollDirection().ordinal()] != 1)
            {
              f1 = f3 - this.h;
              f2 = f4 - this.b;
            }
            else
            {
              f1 = f4 - this.b;
              f2 = f3 - this.h;
            }
            float f5 = Math.abs(f1);
            if ((f5 > this.a) && ((!this.r) || (f5 > Math.abs(f2)))) {
              if ((this.m.showHeaderLoadingLayout()) && (f1 >= 1.0F) && (a()))
              {
                this.h = f3;
                this.b = f4;
                this.k = true;
                if (this.m == PullToRefreshBase.Mode.BOTH) {
                  this.n = PullToRefreshBase.Mode.PULL_FROM_START;
                }
              }
              else if ((this.m.showFooterLoadingLayout()) && (f1 <= -1.0F) && (b()))
              {
                this.h = f3;
                this.b = f4;
                this.k = true;
                if (this.m == PullToRefreshBase.Mode.BOTH) {
                  this.n = PullToRefreshBase.Mode.PULL_FROM_END;
                }
              }
            }
          }
        }
      }
      else if (m())
      {
        f1 = paramMotionEvent.getY();
        this.j = f1;
        this.h = f1;
        f1 = paramMotionEvent.getX();
        this.i = f1;
        this.b = f1;
        this.k = false;
      }
      return this.k;
    }
    this.k = false;
    return false;
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      setMode(PullToRefreshBase.Mode.mapIntToValue(paramParcelable.getInt("ptr_mode", 0)));
      this.n = PullToRefreshBase.Mode.mapIntToValue(paramParcelable.getInt("ptr_current_mode", 0));
      this.q = paramParcelable.getBoolean("ptr_disable_scrolling", false);
      this.p = paramParcelable.getBoolean("ptr_show_refreshing_view", true);
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
    localBundle.putInt("ptr_state", this.l.getIntValue());
    localBundle.putInt("ptr_mode", this.m.getIntValue());
    localBundle.putInt("ptr_current_mode", this.n.getIntValue());
    localBundle.putBoolean("ptr_disable_scrolling", this.q);
    localBundle.putBoolean("ptr_show_refreshing_view", this.p);
    localBundle.putParcelable("ptr_super", super.onSaveInstanceState());
    return localBundle;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    j();
    a(paramInt1, paramInt2);
    post(new PullToRefreshBase.3(this));
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!c()) {
      return false;
    }
    if ((!this.q) && (d())) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return false;
          }
        }
        else
        {
          if (!this.k) {
            break label213;
          }
          this.h = paramMotionEvent.getY();
          this.b = paramMotionEvent.getX();
          n();
          return true;
        }
      }
      if (this.k)
      {
        this.k = false;
        if ((this.l == PullToRefreshBase.State.RELEASE_TO_REFRESH) && ((this.y != null) || (this.z != null)))
        {
          a(PullToRefreshBase.State.REFRESHING, new boolean[] { true });
          return true;
        }
        if (d())
        {
          a(0);
          return true;
        }
        a(PullToRefreshBase.State.RESET, new boolean[0]);
        return true;
      }
    }
    else if (m())
    {
      float f1 = paramMotionEvent.getY();
      this.j = f1;
      this.h = f1;
      f1 = paramMotionEvent.getX();
      this.i = f1;
      this.b = f1;
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
    this.r = paramBoolean;
  }
  
  public void setFooterLayout(LoadingLayoutBase paramLoadingLayoutBase)
  {
    this.g = paramLoadingLayoutBase;
    k();
  }
  
  public void setHasPullDownFriction(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setHasPullUpFriction(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setHeaderLayout(LoadingLayoutBase paramLoadingLayoutBase)
  {
    this.f = paramLoadingLayoutBase;
    k();
  }
  
  protected final void setHeaderScroll(int paramInt)
  {
    int i1 = getMaximumPullScroll();
    paramInt = Math.min(i1, Math.max(-i1, paramInt));
    if (this.t) {
      if (paramInt < 0)
      {
        this.f.setVisibility(0);
      }
      else if (paramInt > 0)
      {
        this.g.setVisibility(0);
      }
      else
      {
        this.f.setVisibility(4);
        this.g.setVisibility(4);
      }
    }
    i1 = PullToRefreshBase.5.a[getPullToRefreshScrollDirection().ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      scrollTo(0, paramInt);
      return;
    }
    scrollTo(paramInt, 0);
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setLastUpdatedLabel(paramCharSequence);
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    getLoadingLayoutProxy().setLoadingDrawable(paramDrawable);
  }
  
  public void setLoadingDrawable(Drawable paramDrawable, PullToRefreshBase.Mode paramMode)
  {
    a(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setLoadingDrawable(paramDrawable);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    getRefreshableView().setLongClickable(paramBoolean);
  }
  
  public final void setMode(PullToRefreshBase.Mode paramMode)
  {
    if (paramMode != this.m)
    {
      this.m = paramMode;
      k();
    }
  }
  
  public void setOnPullEventListener(PullToRefreshBase.OnPullEventListener<T> paramOnPullEventListener)
  {
    this.A = paramOnPullEventListener;
  }
  
  public final void setOnRefreshListener(PullToRefreshBase.OnRefreshListener2<T> paramOnRefreshListener2)
  {
    this.z = paramOnRefreshListener2;
    this.y = null;
  }
  
  public final void setOnRefreshListener(PullToRefreshBase.OnRefreshListener<T> paramOnRefreshListener)
  {
    this.y = paramOnRefreshListener;
    this.z = null;
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setPullLabel(paramCharSequence);
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
    this.s = paramBoolean;
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
    getLoadingLayoutProxy().setRefreshingLabel(paramCharSequence);
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
    this.w = paramInterpolator;
  }
  
  public final void setScrollingWhileRefreshingEnabled(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setSecondFooterLayout(View paramView) {}
  
  public final void setShowViewWhileRefreshing(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase
 * JD-Core Version:    0.7.0.1
 */