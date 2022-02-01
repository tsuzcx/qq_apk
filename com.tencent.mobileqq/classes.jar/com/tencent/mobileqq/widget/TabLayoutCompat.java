package com.tencent.mobileqq.widget;

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
  private static final Pools.Pool<TabLayoutCompat.Tab> jdField_a_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SynchronizedPool(16);
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private PagerAdapter jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
  private TabLayoutCompat.AdapterChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$AdapterChangeListener;
  private TabLayoutCompat.OnTabSelectedListener jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$OnTabSelectedListener;
  private TabLayoutCompat.PagerAdapterObserver jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$PagerAdapterObserver;
  private final TabLayoutCompat.SlidingTabStrip jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip;
  private TabLayoutCompat.Tab jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab;
  private TabLayoutCompat.TabLayoutOnPageChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabLayoutOnPageChangeListener;
  private TabLayoutCompat.ViewPagerTabEventListener jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$ViewPagerTabEventListener;
  ViewPagerCompat jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat;
  private final ArrayList<TabLayoutCompat.Tab> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private final Pools.Pool<TabLayoutCompat.TabView> jdField_b_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SimplePool(12);
  private TabLayoutCompat.OnTabSelectedListener jdField_b_of_type_ComTencentMobileqqWidgetTabLayoutCompat$OnTabSelectedListener;
  private final ArrayList<TabLayoutCompat.OnTabSelectedListener> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  int c;
  int d;
  int e;
  int f;
  int g = 2147483647;
  int h;
  int i;
  private final int j;
  private final int k;
  private int l;
  private int m;
  private int n;
  
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip = new TabLayoutCompat.SlidingTabStrip(this, paramContext);
    super.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip, 0, new FrameLayout.LayoutParams(-2, -1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.b(DisplayUtil.a(paramContext, 2.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.a(-1);
    this.d = 0;
    this.c = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
    this.d = 0;
    this.jdField_a_of_type_Float = DisplayUtil.c(paramContext, 12.0F);
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-1979711488);
    this.f = 0;
    this.m = 0;
    this.n = 0;
    this.i = 1;
    this.h = 1;
    this.jdField_b_of_type_Float = DisplayUtil.a(paramContext, 12.0F);
    this.l = DisplayUtil.a(paramContext, 72.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bz);
    this.j = paramContext.getDimensionPixelSize(R.styleable.bS, -1);
    this.k = paramContext.getDimensionPixelSize(R.styleable.bR, -1);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.bU, 0);
    this.c = paramContext.getDimensionPixelSize(R.styleable.bT, 0);
    this.m = paramContext.getDimensionPixelSize(R.styleable.bQ, 0);
    this.n = paramContext.getDimensionPixelSize(R.styleable.bP, 0);
    paramContext.recycle();
    e();
  }
  
  private int a(int paramInt, float paramFloat)
  {
    int i1 = this.i;
    int i2 = 0;
    if (i1 == 0)
    {
      View localView2 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(paramInt);
      paramInt += 1;
      View localView1;
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.getChildCount()) {
        localView1 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(paramInt);
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
  
  private LinearLayout.LayoutParams a()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    return localLayoutParams;
  }
  
  private TabLayoutCompat.TabView a(@NonNull TabLayoutCompat.Tab paramTab)
  {
    Object localObject1 = this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool;
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
    ((TabLayoutCompat.TabView)localObject2).setMinimumWidth(f());
    return localObject2;
  }
  
  private void a(int paramInt)
  {
    TabLayoutCompat.TabView localTabView = (TabLayoutCompat.TabView)this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.removeViewAt(paramInt);
    if (localTabView != null)
    {
      localTabView.a();
      this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool.release(localTabView);
    }
    requestLayout();
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.i == 1) && (this.h == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = f();
    paramLayoutParams.weight = 0.0F;
  }
  
  private void a(TabLayoutCompat.Tab paramTab)
  {
    TabLayoutCompat.TabView localTabView = paramTab.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.addView(localTabView, paramTab.a(), a());
  }
  
  private void a(TabLayoutCompat.Tab paramTab, int paramInt)
  {
    paramTab.a(paramInt);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramTab);
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    for (;;)
    {
      paramInt += 1;
      if (paramInt >= i1) {
        break;
      }
      ((TabLayoutCompat.Tab)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(paramInt);
    }
  }
  
  private void a(@Nullable ViewPagerCompat paramViewPagerCompat, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat;
    if (localObject != null)
    {
      TabLayoutCompat.TabLayoutOnPageChangeListener localTabLayoutOnPageChangeListener = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabLayoutOnPageChangeListener;
      if (localTabLayoutOnPageChangeListener != null) {
        ((ViewPagerCompat)localObject).removeOnPageChangeListener(localTabLayoutOnPageChangeListener);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$AdapterChangeListener;
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.b((ViewPagerCompat.OnAdapterChangeListener)localObject);
      }
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetTabLayoutCompat$OnTabSelectedListener;
    if (localObject != null)
    {
      b((TabLayoutCompat.OnTabSelectedListener)localObject);
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabLayoutCompat$OnTabSelectedListener = null;
    }
    if (paramViewPagerCompat != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat = paramViewPagerCompat;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabLayoutOnPageChangeListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabLayoutOnPageChangeListener = new TabLayoutCompat.TabLayoutOnPageChangeListener(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabLayoutOnPageChangeListener.a();
      paramViewPagerCompat.addOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabLayoutOnPageChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabLayoutCompat$OnTabSelectedListener = new TabLayoutCompat.ViewPagerOnTabSelectedListener(paramViewPagerCompat);
      a(this.jdField_b_of_type_ComTencentMobileqqWidgetTabLayoutCompat$OnTabSelectedListener);
      localObject = paramViewPagerCompat.getAdapter();
      if (localObject != null) {
        a((PagerAdapter)localObject, paramBoolean1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$AdapterChangeListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$AdapterChangeListener = new TabLayoutCompat.AdapterChangeListener(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$AdapterChangeListener.a(paramBoolean1);
      paramViewPagerCompat.a(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$AdapterChangeListener);
      setScrollPosition(paramViewPagerCompat.getCurrentItem(), 0.0F, true);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat = null;
      a(null, false);
    }
    this.jdField_a_of_type_Boolean = paramBoolean2;
  }
  
  private void b(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() != null) && (ViewCompat.isLaidOut(this)) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.a()))
    {
      int i1 = getScrollX();
      int i2 = a(paramInt, 0.0F);
      if (i1 != i2)
      {
        d();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { i1, i2 });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.b(paramInt, 300);
      return;
    }
    setScrollPosition(paramInt, 0.0F, true);
  }
  
  private void b(@NonNull TabLayoutCompat.Tab paramTab)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayoutCompat.OnTabSelectedListener)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).a(paramTab);
      i1 -= 1;
    }
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((TabLayoutCompat.Tab)localIterator.next()).c();
    }
  }
  
  private void c(int paramInt)
  {
    int i2 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.getChildCount();
    if (paramInt < i2)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(i1);
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
  
  private void c(@NonNull TabLayoutCompat.Tab paramTab)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayoutCompat.OnTabSelectedListener)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).b(paramTab);
      i1 -= 1;
    }
  }
  
  private int d()
  {
    return Math.max(0, this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  @RequiresApi(api=11)
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new FastOutSlowInInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new TabLayoutCompat.1(this));
    }
  }
  
  private int e()
  {
    int i4 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= i4) {
        break;
      }
      TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if ((localTab != null) && (localTab.a() != null) && (!TextUtils.isEmpty(localTab.a())))
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
  
  private void e()
  {
    int i3 = this.m;
    int i2 = this.n;
    int i1 = i3;
    if (this.i == 0)
    {
      i1 = Math.max(0, i3 - this.jdField_a_of_type_Int);
      i2 = Math.max(0, this.n - this.c);
    }
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip, i1, 0, i2, 0);
    i1 = this.i;
    if (i1 != 0)
    {
      if (i1 == 1) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.setGravity(1);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.setGravity(8388611);
    }
    c(true);
  }
  
  private int f()
  {
    int i1 = this.j;
    if (i1 != -1) {
      return i1;
    }
    if (this.i == 0) {
      return this.l;
    }
    return 0;
  }
  
  private void f(@NonNull TabLayoutCompat.Tab paramTab)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayoutCompat.OnTabSelectedListener)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).c(paramTab);
      i1 -= 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  int a(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  @NonNull
  public TabLayoutCompat.Tab a()
  {
    Object localObject2 = (TabLayoutCompat.Tab)jdField_a_of_type_AndroidSupportV4UtilPools$Pool.acquire();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new TabLayoutCompat.Tab();
    }
    ((TabLayoutCompat.Tab)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat = this;
    ((TabLayoutCompat.Tab)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabView = a((TabLayoutCompat.Tab)localObject1);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$ViewPagerTabEventListener;
    if (localObject2 != null) {
      ((TabLayoutCompat.Tab)localObject1).a(((TabLayoutCompat.ViewPagerTabEventListener)localObject2).a(((TabLayoutCompat.Tab)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabView));
    }
    return localObject1;
  }
  
  @Nullable
  public TabLayoutCompat.Tab a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < a())) {
      return (TabLayoutCompat.Tab)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.getChildCount() - 1;
    while (i1 >= 0)
    {
      a(i1);
      i1 -= 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)localIterator.next();
      localIterator.remove();
      localTab.d();
      jdField_a_of_type_AndroidSupportV4UtilPools$Pool.release(localTab);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab = null;
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Math.round(paramInt + paramFloat);
    if (i1 >= 0)
    {
      if (i1 >= this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.getChildCount()) {
        return;
      }
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.a(paramInt, paramFloat);
      }
      ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      scrollTo(a(paramInt, paramFloat), 0);
      if (paramBoolean1) {
        c(i1);
      }
    }
  }
  
  void a(@Nullable PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if (localPagerAdapter != null)
    {
      TabLayoutCompat.PagerAdapterObserver localPagerAdapterObserver = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$PagerAdapterObserver;
      if (localPagerAdapterObserver != null) {
        localPagerAdapter.unregisterDataSetObserver(localPagerAdapterObserver);
      }
    }
    this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter = paramPagerAdapter;
    if (paramPagerAdapter != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$PagerAdapterObserver == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$PagerAdapterObserver = new TabLayoutCompat.PagerAdapterObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$PagerAdapterObserver.a(paramBoolean);
      paramPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$PagerAdapterObserver);
    }
    b();
  }
  
  public void a(@NonNull TabLayoutCompat.OnTabSelectedListener paramOnTabSelectedListener)
  {
    if (!this.jdField_b_of_type_JavaUtilArrayList.contains(paramOnTabSelectedListener)) {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramOnTabSelectedListener);
    }
  }
  
  public void a(@NonNull TabLayoutCompat.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    if (paramTab.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat == this)
    {
      a(paramTab, paramInt);
      a(paramTab);
      if (paramBoolean) {
        paramTab.a();
      }
      return;
    }
    throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
  }
  
  public void a(@NonNull TabLayoutCompat.Tab paramTab, boolean paramBoolean)
  {
    a(paramTab, this.jdField_a_of_type_JavaUtilArrayList.size(), paramBoolean);
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
  
  public int b()
  {
    TabLayoutCompat.Tab localTab = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab;
    if (localTab != null) {
      return localTab.a();
    }
    return -1;
  }
  
  void b()
  {
    a();
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if (localObject != null)
    {
      int i2 = ((PagerAdapter)localObject).getCount();
      int i1 = 0;
      while (i1 < i2)
      {
        a(a().a(this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageTitle(i1)), false);
        i1 += 1;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat;
      if ((localObject != null) && (i2 > 0))
      {
        i1 = ((ViewPagerCompat)localObject).getCurrentItem();
        if ((i1 != b()) && (i1 < a())) {
          e(a(i1));
        }
      }
    }
  }
  
  public void b(@NonNull TabLayoutCompat.OnTabSelectedListener paramOnTabSelectedListener)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramOnTabSelectedListener);
  }
  
  void b(TabLayoutCompat.Tab paramTab, boolean paramBoolean)
  {
    TabLayoutCompat.Tab localTab = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab;
    if (localTab == paramTab)
    {
      if (localTab != null)
      {
        f(paramTab);
        b(paramTab.a());
      }
    }
    else
    {
      int i1;
      if (paramTab != null) {
        i1 = paramTab.a();
      } else {
        i1 = -1;
      }
      if (paramBoolean)
      {
        if (((localTab == null) || (localTab.a() == -1)) && (i1 != -1)) {
          setScrollPosition(i1, 0.0F, true);
        } else {
          b(i1);
        }
        if (i1 != -1) {
          c(i1);
        }
      }
      if (localTab != null) {
        c(localTab);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab = paramTab;
      if (paramTab != null) {
        b(paramTab);
      }
    }
  }
  
  int c()
  {
    return this.g;
  }
  
  void c(TabLayoutCompat.Tab paramTab, boolean paramBoolean)
  {
    TabLayoutCompat.Tab localTab = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab;
    if (localTab == paramTab)
    {
      if (localTab != null) {
        b(paramTab.a());
      }
    }
    else
    {
      int i1;
      if (paramTab != null) {
        i1 = paramTab.a();
      } else {
        i1 = -1;
      }
      if (paramBoolean)
      {
        if (((localTab == null) || (localTab.a() == -1)) && (i1 != -1)) {
          setScrollPosition(i1, 0.0F, true);
        } else {
          b(i1);
        }
        if (i1 != -1) {
          c(i1);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab = paramTab;
    }
  }
  
  void c(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(i1);
      localView.setMinimumWidth(f());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i1 += 1;
    }
  }
  
  public void d(@NonNull TabLayoutCompat.Tab paramTab)
  {
    a(paramTab, this.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  void e(TabLayoutCompat.Tab paramTab)
  {
    b(paramTab, true);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat == null)
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
    if (this.jdField_a_of_type_Boolean)
    {
      setupWithViewPager(null);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = a(e()) + getPaddingTop() + getPaddingBottom();
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
      i1 = this.k;
      if (i1 <= 0) {
        i1 = i2 - a(56);
      }
      this.g = i1;
    }
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() == 1)
    {
      paramInt1 = 0;
      View localView = getChildAt(0);
      i1 = this.i;
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
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  @Deprecated
  public void setOnTabSelectedListener(@Nullable TabLayoutCompat.OnTabSelectedListener paramOnTabSelectedListener)
  {
    TabLayoutCompat.OnTabSelectedListener localOnTabSelectedListener = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$OnTabSelectedListener;
    if (localOnTabSelectedListener != null) {
      b(localOnTabSelectedListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$OnTabSelectedListener = paramOnTabSelectedListener;
    if (paramOnTabSelectedListener != null) {
      a(paramOnTabSelectedListener);
    }
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    a(paramInt, paramFloat, paramBoolean, true);
  }
  
  public void setScrollableTabMinWidth(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setSelectedTabIndicatorColor(@ColorInt int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.a(paramInt);
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.b(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingBottom(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.e(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingLeft(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.c(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingRight(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.d(paramInt);
  }
  
  public void setTabBackgroundResId(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)localIterator.next();
        if (localTab.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabView != null) {
          localTab.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabView.setBackgroundResource(this.f);
        }
      }
    }
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      e();
    }
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.i)
    {
      this.i = paramInt;
      e();
    }
  }
  
  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(a(paramInt1, paramInt2));
  }
  
  public void setTabTextColors(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      c();
    }
  }
  
  public void setTabTextSize(int paramInt)
  {
    float f1 = this.jdField_a_of_type_Float;
    float f2 = paramInt;
    if (f1 != f2)
    {
      this.jdField_a_of_type_Float = f2;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)localIterator.next();
        if ((localTab.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabView != null) && (TabLayoutCompat.TabView.a(localTab.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabView) != null)) {
          TabLayoutCompat.TabView.a(localTab.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$TabView).setTextSize(this.jdField_a_of_type_Float);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$ViewPagerTabEventListener = paramViewPagerTabEventListener;
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
    return d() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat
 * JD-Core Version:    0.7.0.1
 */