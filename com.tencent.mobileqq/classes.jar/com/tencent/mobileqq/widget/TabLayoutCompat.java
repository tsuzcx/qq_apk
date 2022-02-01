package com.tencent.mobileqq.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.widget.FastOutSlowInInterpolator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TabLayoutCompat
  extends HorizontalScrollView
{
  private static final Pools.Pool<TabLayoutCompat.Tab> n = new Pools.SynchronizedPool(16);
  private static final int[] o = { 16842901, 16842904 };
  private ValueAnimator A;
  private PagerAdapter B;
  private TabLayoutCompat.PagerAdapterObserver C;
  private TabLayoutCompat.TabLayoutOnPageChangeListener D;
  private TabLayoutCompat.AdapterChangeListener E;
  private boolean F;
  private TabLayoutCompat.ViewPagerTabEventListener G;
  private boolean H;
  private final Pools.Pool<TabLayoutCompat.TabView> I = new Pools.SimplePool(12);
  int a;
  int b;
  int c;
  int d;
  int e;
  ColorStateList f;
  float g;
  float h;
  int i;
  int j = 2147483647;
  int k;
  int l;
  ViewPagerCompat m;
  private final ArrayList<TabLayoutCompat.Tab> p = new ArrayList();
  private TabLayoutCompat.Tab q;
  private final TabLayoutCompat.SlidingTabStrip r;
  private final int s;
  private final int t;
  private int u;
  private int v;
  private int w;
  private TabLayoutCompat.OnTabSelectedListener x;
  private final ArrayList<TabLayoutCompat.OnTabSelectedListener> y = new ArrayList();
  private TabLayoutCompat.OnTabSelectedListener z;
  
  public TabLayoutCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    this.r = new TabLayoutCompat.SlidingTabStrip(this, paramContext);
    super.addView(this.r, 0, new FrameLayout.LayoutParams(-2, -1));
    this.r.b(DisplayUtil.a(paramContext, 2.0F));
    this.r.a(-1);
    this.d = 0;
    this.c = 0;
    this.b = 0;
    this.a = 0;
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.g = DisplayUtil.c(paramContext, 12.0F);
    this.f = ColorStateList.valueOf(-1979711488);
    this.i = 0;
    this.v = 0;
    this.w = 0;
    this.l = 1;
    this.k = 1;
    this.h = DisplayUtil.a(paramContext, 12.0F);
    this.u = DisplayUtil.a(paramContext, 72.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.eB);
    this.s = paramContext.getDimensionPixelSize(R.styleable.eF, -1);
    this.t = paramContext.getDimensionPixelSize(R.styleable.eE, -1);
    this.a = paramContext.getDimensionPixelSize(R.styleable.eH, 0);
    this.c = paramContext.getDimensionPixelSize(R.styleable.eG, 0);
    this.v = paramContext.getDimensionPixelSize(R.styleable.eD, 0);
    this.w = paramContext.getDimensionPixelSize(R.styleable.eC, 0);
    paramContext.recycle();
    g();
  }
  
  private int a(int paramInt, float paramFloat)
  {
    int i1 = this.l;
    int i2 = 0;
    if (i1 == 0)
    {
      View localView2 = this.r.getChildAt(paramInt);
      paramInt += 1;
      View localView1;
      if (paramInt < this.r.getChildCount()) {
        localView1 = this.r.getChildAt(paramInt);
      } else {
        localView1 = null;
      }
      if (localView2 != null) {
        paramInt = localView2.getWidth();
      } else {
        paramInt = 0;
      }
      if (localView2 != null) {
        i1 = localView2.getLeft();
      } else {
        i1 = 0;
      }
      if (localView1 != null) {
        i2 = localView1.getWidth();
      }
      i1 = i1 + paramInt / 2 - getWidth() / 2;
      paramInt = (int)((paramInt + i2) * 0.5F * paramFloat);
      if (ViewCompat.getLayoutDirection(this) == 0) {
        return i1 + paramInt;
      }
      return i1 - paramInt;
    }
    return 0;
  }
  
  private static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  private TabLayoutCompat.TabView a(@NonNull TabLayoutCompat.Tab paramTab)
  {
    Object localObject1 = this.I;
    if (localObject1 != null) {
      localObject1 = (TabLayoutCompat.TabView)((Pools.Pool)localObject1).acquire();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new TabLayoutCompat.TabView(this, getContext());
    }
    ((TabLayoutCompat.TabView)localObject2).a(paramTab);
    ((TabLayoutCompat.TabView)localObject2).setFocusable(true);
    ((TabLayoutCompat.TabView)localObject2).setMinimumWidth(getTabMinWidth());
    return localObject2;
  }
  
  private void a(int paramInt)
  {
    TabLayoutCompat.TabView localTabView = (TabLayoutCompat.TabView)this.r.getChildAt(paramInt);
    this.r.removeViewAt(paramInt);
    if (localTabView != null)
    {
      localTabView.a();
      this.I.release(localTabView);
    }
    requestLayout();
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.l == 1) && (this.k == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = getTabMinWidth();
    paramLayoutParams.weight = 0.0F;
  }
  
  private void a(TabLayoutCompat.Tab paramTab, int paramInt)
  {
    paramTab.b(paramInt);
    this.p.add(paramInt, paramTab);
    int i1 = this.p.size();
    for (;;)
    {
      paramInt += 1;
      if (paramInt >= i1) {
        break;
      }
      ((TabLayoutCompat.Tab)this.p.get(paramInt)).b(paramInt);
    }
  }
  
  private void a(@Nullable ViewPagerCompat paramViewPagerCompat, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      TabLayoutCompat.TabLayoutOnPageChangeListener localTabLayoutOnPageChangeListener = this.D;
      if (localTabLayoutOnPageChangeListener != null) {
        ((ViewPagerCompat)localObject).removeOnPageChangeListener(localTabLayoutOnPageChangeListener);
      }
      localObject = this.E;
      if (localObject != null) {
        this.m.b((ViewPagerCompat.OnAdapterChangeListener)localObject);
      }
    }
    localObject = this.z;
    if (localObject != null)
    {
      b((TabLayoutCompat.OnTabSelectedListener)localObject);
      this.z = null;
    }
    if (paramViewPagerCompat != null)
    {
      this.m = paramViewPagerCompat;
      if (this.D == null) {
        this.D = new TabLayoutCompat.TabLayoutOnPageChangeListener(this);
      }
      this.D.a();
      paramViewPagerCompat.addOnPageChangeListener(this.D);
      this.z = new TabLayoutCompat.ViewPagerOnTabSelectedListener(paramViewPagerCompat);
      a(this.z);
      localObject = paramViewPagerCompat.getAdapter();
      if (localObject != null) {
        a((PagerAdapter)localObject, paramBoolean1);
      }
      if (this.E == null) {
        this.E = new TabLayoutCompat.AdapterChangeListener(this);
      }
      this.E.a(paramBoolean1);
      paramViewPagerCompat.a(this.E);
      setScrollPosition(paramViewPagerCompat.getCurrentItem(), 0.0F, true);
    }
    else
    {
      this.m = null;
      a(null, false);
    }
    this.F = paramBoolean2;
  }
  
  private void b(TabLayoutCompat.Tab paramTab)
  {
    TabLayoutCompat.TabView localTabView = paramTab.b;
    this.r.addView(localTabView, paramTab.d(), e());
  }
  
  private void c(@NonNull TabLayoutCompat.Tab paramTab)
  {
    int i1 = this.y.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayoutCompat.OnTabSelectedListener)this.y.get(i1)).a(paramTab);
      i1 -= 1;
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.p.iterator();
    while (localIterator.hasNext()) {
      ((TabLayoutCompat.Tab)localIterator.next()).k();
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() != null) && (ViewCompat.isLaidOut(this)) && (!this.r.a()))
    {
      int i1 = getScrollX();
      int i2 = a(paramInt, 0.0F);
      if (i1 != i2)
      {
        f();
        this.A.setIntValues(new int[] { i1, i2 });
        this.A.start();
      }
      this.r.b(paramInt, 300);
      return;
    }
    setScrollPosition(paramInt, 0.0F, true);
  }
  
  private LinearLayout.LayoutParams e()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    return localLayoutParams;
  }
  
  @RequiresApi(api=11)
  private void f()
  {
    if (this.A == null)
    {
      this.A = new ValueAnimator();
      this.A.setInterpolator(new FastOutSlowInInterpolator());
      this.A.setDuration(300L);
      this.A.addUpdateListener(new TabLayoutCompat.1(this));
    }
  }
  
  private void f(@NonNull TabLayoutCompat.Tab paramTab)
  {
    int i1 = this.y.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayoutCompat.OnTabSelectedListener)this.y.get(i1)).b(paramTab);
      i1 -= 1;
    }
  }
  
  private void g()
  {
    int i3 = this.v;
    int i2 = this.w;
    int i1 = i3;
    if (this.l == 0)
    {
      i1 = Math.max(0, i3 - this.a);
      i2 = Math.max(0, this.w - this.c);
    }
    ViewCompat.setPaddingRelative(this.r, i1, 0, i2, 0);
    i1 = this.l;
    if (i1 != 0)
    {
      if (i1 == 1) {
        this.r.setGravity(1);
      }
    }
    else {
      this.r.setGravity(8388611);
    }
    c(true);
  }
  
  private void g(@NonNull TabLayoutCompat.Tab paramTab)
  {
    int i1 = this.y.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayoutCompat.OnTabSelectedListener)this.y.get(i1)).c(paramTab);
      i1 -= 1;
    }
  }
  
  private int getDefaultHeight()
  {
    int i4 = this.p.size();
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= i4) {
        break;
      }
      TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)this.p.get(i1);
      if ((localTab != null) && (localTab.c() != null) && (!TextUtils.isEmpty(localTab.e())))
      {
        i2 = 1;
        break;
      }
      i1 += 1;
    }
    if (i2 != 0) {
      return 72;
    }
    return 48;
  }
  
  private float getScrollPosition()
  {
    return this.r.b();
  }
  
  private int getTabMinWidth()
  {
    int i1 = this.s;
    if (i1 != -1) {
      return i1;
    }
    if (this.l == 0) {
      return this.u;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, this.r.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int i2 = this.r.getChildCount();
    if (paramInt < i2)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = this.r.getChildAt(i1);
        boolean bool;
        if (i1 == paramInt) {
          bool = true;
        } else {
          bool = false;
        }
        localView.setSelected(bool);
        i1 += 1;
      }
    }
  }
  
  @NonNull
  public TabLayoutCompat.Tab a()
  {
    Object localObject2 = (TabLayoutCompat.Tab)n.acquire();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new TabLayoutCompat.Tab();
    }
    ((TabLayoutCompat.Tab)localObject1).a = this;
    ((TabLayoutCompat.Tab)localObject1).b = a((TabLayoutCompat.Tab)localObject1);
    localObject2 = this.G;
    if (localObject2 != null) {
      ((TabLayoutCompat.Tab)localObject1).a(((TabLayoutCompat.ViewPagerTabEventListener)localObject2).a(((TabLayoutCompat.Tab)localObject1).b));
    }
    return localObject1;
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Math.round(paramInt + paramFloat);
    if (i1 >= 0)
    {
      if (i1 >= this.r.getChildCount()) {
        return;
      }
      if (paramBoolean2) {
        this.r.a(paramInt, paramFloat);
      }
      ValueAnimator localValueAnimator = this.A;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        this.A.cancel();
      }
      scrollTo(a(paramInt, paramFloat), 0);
      if (paramBoolean1) {
        setSelectedTabView(i1);
      }
    }
  }
  
  void a(@Nullable PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    PagerAdapter localPagerAdapter = this.B;
    if (localPagerAdapter != null)
    {
      TabLayoutCompat.PagerAdapterObserver localPagerAdapterObserver = this.C;
      if (localPagerAdapterObserver != null) {
        localPagerAdapter.unregisterDataSetObserver(localPagerAdapterObserver);
      }
    }
    this.B = paramPagerAdapter;
    if (paramPagerAdapter != null)
    {
      if (this.C == null) {
        this.C = new TabLayoutCompat.PagerAdapterObserver(this);
      }
      this.C.a(paramBoolean);
      paramPagerAdapter.registerDataSetObserver(this.C);
    }
    c();
  }
  
  public void a(@NonNull TabLayoutCompat.OnTabSelectedListener paramOnTabSelectedListener)
  {
    if (!this.y.contains(paramOnTabSelectedListener)) {
      this.y.add(paramOnTabSelectedListener);
    }
  }
  
  public void a(@NonNull TabLayoutCompat.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    if (paramTab.a == this)
    {
      a(paramTab, paramInt);
      b(paramTab);
      if (paramBoolean) {
        paramTab.f();
      }
      return;
    }
    throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
  }
  
  public void a(@NonNull TabLayoutCompat.Tab paramTab, boolean paramBoolean)
  {
    a(paramTab, this.p.size(), paramBoolean);
  }
  
  public void addView(View paramView)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  public void addView(View paramView, int paramInt)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  @Nullable
  public TabLayoutCompat.Tab b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getTabCount())) {
      return (TabLayoutCompat.Tab)this.p.get(paramInt);
    }
    return null;
  }
  
  public void b()
  {
    int i1 = this.r.getChildCount() - 1;
    while (i1 >= 0)
    {
      a(i1);
      i1 -= 1;
    }
    Iterator localIterator = this.p.iterator();
    while (localIterator.hasNext())
    {
      TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)localIterator.next();
      localIterator.remove();
      localTab.l();
      n.release(localTab);
    }
    this.q = null;
  }
  
  public void b(@NonNull TabLayoutCompat.OnTabSelectedListener paramOnTabSelectedListener)
  {
    this.y.remove(paramOnTabSelectedListener);
  }
  
  void b(TabLayoutCompat.Tab paramTab, boolean paramBoolean)
  {
    TabLayoutCompat.Tab localTab = this.q;
    if (localTab == paramTab)
    {
      if (localTab != null)
      {
        g(paramTab);
        d(paramTab.d());
      }
    }
    else
    {
      int i1;
      if (paramTab != null) {
        i1 = paramTab.d();
      } else {
        i1 = -1;
      }
      if (paramBoolean)
      {
        if (((localTab == null) || (localTab.d() == -1)) && (i1 != -1)) {
          setScrollPosition(i1, 0.0F, true);
        } else {
          d(i1);
        }
        if (i1 != -1) {
          setSelectedTabView(i1);
        }
      }
      if (localTab != null) {
        f(localTab);
      }
      this.q = paramTab;
      if (paramTab != null) {
        c(paramTab);
      }
    }
  }
  
  int c(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  void c()
  {
    b();
    Object localObject = this.B;
    if (localObject != null)
    {
      int i2 = ((PagerAdapter)localObject).getCount();
      int i1 = 0;
      while (i1 < i2)
      {
        a(a().a(this.B.getPageTitle(i1)), false);
        i1 += 1;
      }
      localObject = this.m;
      if ((localObject != null) && (i2 > 0))
      {
        i1 = ((ViewPagerCompat)localObject).getCurrentItem();
        if ((i1 != getSelectedTabPosition()) && (i1 < getTabCount())) {
          e(b(i1));
        }
      }
    }
  }
  
  void c(TabLayoutCompat.Tab paramTab, boolean paramBoolean)
  {
    TabLayoutCompat.Tab localTab = this.q;
    if (localTab == paramTab)
    {
      if (localTab != null) {
        d(paramTab.d());
      }
    }
    else
    {
      int i1;
      if (paramTab != null) {
        i1 = paramTab.d();
      } else {
        i1 = -1;
      }
      if (paramBoolean)
      {
        if (((localTab == null) || (localTab.d() == -1)) && (i1 != -1)) {
          setScrollPosition(i1, 0.0F, true);
        } else {
          d(i1);
        }
        if (i1 != -1) {
          setSelectedTabView(i1);
        }
      }
      this.q = paramTab;
    }
  }
  
  void c(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.r.getChildCount())
    {
      View localView = this.r.getChildAt(i1);
      localView.setMinimumWidth(getTabMinWidth());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i1 += 1;
    }
  }
  
  public void d(@NonNull TabLayoutCompat.Tab paramTab)
  {
    a(paramTab, this.p.isEmpty());
  }
  
  void e(TabLayoutCompat.Tab paramTab)
  {
    b(paramTab, true);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  public int getSelectedTabPosition()
  {
    TabLayoutCompat.Tab localTab = this.q;
    if (localTab != null) {
      return localTab.d();
    }
    return -1;
  }
  
  public int getTabCount()
  {
    return this.p.size();
  }
  
  public int getTabGravity()
  {
    return this.k;
  }
  
  int getTabMaxWidth()
  {
    return this.j;
  }
  
  public int getTabMode()
  {
    return this.l;
  }
  
  @Nullable
  public ColorStateList getTabTextColors()
  {
    return this.f;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.m == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPagerCompat)) {
        a((ViewPagerCompat)localViewParent, true, true);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.F)
    {
      setupWithViewPager(null);
      this.F = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = c(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    int i2 = View.MeasureSpec.getMode(paramInt2);
    if (i2 != -2147483648)
    {
      if (i2 == 0) {
        paramInt2 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
      }
    }
    else {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i1, View.MeasureSpec.getSize(paramInt2)), 1073741824);
    }
    i2 = View.MeasureSpec.getSize(paramInt1);
    if (View.MeasureSpec.getMode(paramInt1) != 0)
    {
      i1 = this.t;
      if (i1 <= 0) {
        i1 = i2 - c(56);
      }
      this.j = i1;
    }
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() == 1)
    {
      paramInt1 = 0;
      View localView = getChildAt(0);
      i1 = this.l;
      if (i1 != 0)
      {
        if ((i1 != 1) || (localView.getMeasuredWidth() == getMeasuredWidth())) {}
      }
      else {
        while (localView.getMeasuredWidth() < getMeasuredWidth())
        {
          paramInt1 = 1;
          break;
        }
      }
      if (paramInt1 != 0)
      {
        paramInt1 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
        localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
      }
    }
  }
  
  public void setCutomViewBeRelated(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  @Deprecated
  public void setOnTabSelectedListener(@Nullable TabLayoutCompat.OnTabSelectedListener paramOnTabSelectedListener)
  {
    TabLayoutCompat.OnTabSelectedListener localOnTabSelectedListener = this.x;
    if (localOnTabSelectedListener != null) {
      b(localOnTabSelectedListener);
    }
    this.x = paramOnTabSelectedListener;
    if (paramOnTabSelectedListener != null) {
      a(paramOnTabSelectedListener);
    }
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  @RequiresApi(api=11)
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    f();
    this.A.addListener(paramAnimatorListener);
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    a(paramInt, paramFloat, paramBoolean, true);
  }
  
  public void setScrollableTabMinWidth(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void setSelectedTabIndicatorColor(@ColorInt int paramInt)
  {
    this.r.a(paramInt);
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.r.b(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingBottom(int paramInt)
  {
    this.r.e(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingLeft(int paramInt)
  {
    this.r.c(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingRight(int paramInt)
  {
    this.r.d(paramInt);
  }
  
  public void setTabBackgroundResId(int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)localIterator.next();
        if (localTab.b != null) {
          localTab.b.setBackgroundResource(this.i);
        }
      }
    }
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.k != paramInt)
    {
      this.k = paramInt;
      g();
    }
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.l)
    {
      this.l = paramInt;
      g();
    }
  }
  
  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(a(paramInt1, paramInt2));
  }
  
  public void setTabTextColors(@Nullable ColorStateList paramColorStateList)
  {
    if (this.f != paramColorStateList)
    {
      this.f = paramColorStateList;
      d();
    }
  }
  
  public void setTabTextSize(int paramInt)
  {
    float f1 = this.g;
    float f2 = paramInt;
    if (f1 != f2)
    {
      this.g = f2;
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)localIterator.next();
        if ((localTab.b != null) && (TabLayoutCompat.TabView.a(localTab.b) != null)) {
          TabLayoutCompat.TabView.a(localTab.b).setTextSize(this.g);
        }
      }
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    a(paramPagerAdapter, false);
  }
  
  public void setViewPagerTabEventListener(TabLayoutCompat.ViewPagerTabEventListener paramViewPagerTabEventListener)
  {
    this.G = paramViewPagerTabEventListener;
  }
  
  public void setupWithViewPager(@Nullable ViewPagerCompat paramViewPagerCompat)
  {
    setupWithViewPager(paramViewPagerCompat, true);
  }
  
  public void setupWithViewPager(@Nullable ViewPagerCompat paramViewPagerCompat, boolean paramBoolean)
  {
    a(paramViewPagerCompat, paramBoolean, false);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return getTabScrollRange() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat
 * JD-Core Version:    0.7.0.1
 */