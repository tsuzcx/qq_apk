package com.tencent.widget.pull2refresh;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;

@SuppressLint({"ClickableViewAccessibility"})
public class PagerSnapHelper
{
  private RecyclerViewCompat a;
  private LinearLayoutManager b;
  private PagerSnapHelper.PagerEventListener c;
  private PagerSnapHelper.TouchEventProcessor d;
  private PagerSnapHelper.OnLayoutChangedListenerImpl e;
  private PagerSnapHelper.OnLayoutSizeChangedListener f;
  private OrientationHelper g;
  private OrientationHelper h;
  private int i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private boolean p;
  private boolean q;
  private float r;
  private boolean s;
  private boolean t;
  private int u = -1;
  
  public PagerSnapHelper()
  {
    this(0, 25.0F);
  }
  
  public PagerSnapHelper(int paramInt, float paramFloat)
  {
    a();
    this.n = paramInt;
    this.r = paramFloat;
  }
  
  private int a(int paramInt)
  {
    int i1 = n();
    int i2 = a(this.b);
    if (paramInt < i1) {
      return i1;
    }
    i1 = paramInt;
    if (paramInt > i2) {
      i1 = i2;
    }
    return i1;
  }
  
  private int a(LinearLayoutManager paramLinearLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int i1;
    if (paramLinearLayoutManager.getClipToPadding()) {
      i1 = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;
    } else {
      i1 = paramOrientationHelper.getEnd() / 2;
    }
    return i1 + this.o;
  }
  
  private int a(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    if (this.n != 1) {
      return c(paramLinearLayoutManager, paramView, paramOrientationHelper);
    }
    return b(paramLinearLayoutManager, paramView, paramOrientationHelper);
  }
  
  private int a(OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getStartAfterPadding() + this.o;
  }
  
  private int a(RecyclerView.LayoutManager paramLayoutManager)
  {
    return paramLayoutManager.getItemCount() - this.i - 1;
  }
  
  private void a()
  {
    this.i = 0;
    this.j = 0;
    this.k = -1;
    this.l = false;
    this.m = false;
    this.t = false;
    this.s = true;
    this.p = true;
    this.q = true;
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView != null) && (paramRecyclerView.getAdapter() != null) && (paramRecyclerView.getLayoutManager() != null))
    {
      if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
        return;
      }
      throw new IllegalStateException("PagerSnapHelper can only attach to the RecyclerView with LinearLayoutManager");
    }
    throw new IllegalStateException("PagerSnapHelper can't attach to the RecyclerView before setup Adapter or LayoutManager");
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      Object localObject = this.a;
      if ((localObject != null) && (this.b != null))
      {
        localObject = ((RecyclerViewCompat)localObject).getChildViewHolder(paramView);
        int i1 = this.b.getPosition(paramView);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("dispatchPagerChanged: position=");
          localStringBuilder.append(i1);
          localStringBuilder.append(", centerPosition=");
          localStringBuilder.append(this.k);
          localStringBuilder.append(", reset=");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append(", isRealIdle=");
          localStringBuilder.append(this.s);
          localStringBuilder.append(", isNeedCallPageIdle=");
          localStringBuilder.append(this.t);
          QLog.d("PagerSnapHelper", 2, localStringBuilder.toString());
        }
        if ((localObject != null) && (i1 != -1))
        {
          if ((i1 != this.k) || (paramBoolean))
          {
            if (a(i1, this.b)) {
              return;
            }
            this.k = i1;
            this.t = true;
            if (this.c != null)
            {
              TraceCompat.beginSection("onPagerChanged");
              this.c.a((RecyclerView.ViewHolder)localObject);
              TraceCompat.endSection();
            }
          }
          if ((this.s) && (this.t) && (this.c != null))
          {
            this.t = false;
            paramView = this.a.getChildViewHolder(paramView);
            TraceCompat.beginSection("onPagerIdle");
            this.c.b(paramView);
            TraceCompat.endSection();
          }
        }
      }
    }
  }
  
  private boolean a(int paramInt, RecyclerView.LayoutManager paramLayoutManager)
  {
    int i1 = a(paramLayoutManager);
    return (paramInt < n()) || (paramInt > i1);
  }
  
  private boolean a(@NonNull LinearLayoutManager paramLinearLayoutManager, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    if (paramLinearLayoutManager.getItemCount() == 0) {
      return false;
    }
    View localView = a(paramLinearLayoutManager);
    if (localView == null) {
      return false;
    }
    int i1 = paramLinearLayoutManager.getPosition(localView);
    if (i1 == -1) {
      return false;
    }
    int i2 = a(i1);
    int i3 = m();
    boolean bool = paramLinearLayoutManager.canScrollHorizontally();
    i1 = 1;
    if (bool)
    {
      if (Math.abs(paramFloat1) > i3 ? paramFloat1 > 0.0F : paramFloat3 > 0.0F) {}
    }
    else {
      while (Math.abs(paramFloat2) > i3 ? paramFloat2 <= 0.0F : paramFloat4 <= 0.0F)
      {
        i1 = 0;
        break;
      }
    }
    if ((paramInt != -1) && (i2 != paramInt)) {
      paramInt = i2;
    } else if (i1 != 0) {
      paramInt = i2 + 1;
    } else {
      paramInt = i2 - 1;
    }
    if (paramInt == -1) {
      return false;
    }
    paramInt = a(paramInt);
    if (QLog.isColorLevel())
    {
      paramLinearLayoutManager = new StringBuilder();
      paramLinearLayoutManager.append("snapFromFling: position=");
      paramLinearLayoutManager.append(paramInt);
      QLog.d("PagerSnapHelper", 2, paramLinearLayoutManager.toString());
    }
    return c(paramInt);
  }
  
  @NonNull
  private int[] a(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLinearLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = a(paramLinearLayoutManager, paramView, b(paramLinearLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    }
    if (paramLinearLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = a(paramLinearLayoutManager, paramView, b(paramLinearLayoutManager));
      return arrayOfInt;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  private int b(LinearLayoutManager paramLinearLayoutManager, OrientationHelper paramOrientationHelper)
  {
    if (this.n != 1) {
      return a(paramLinearLayoutManager, paramOrientationHelper);
    }
    return a(paramOrientationHelper);
  }
  
  private int b(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) - a(paramOrientationHelper);
  }
  
  private void b()
  {
    PagerSnapHelper.PagerEventListener localPagerEventListener = this.c;
    if (localPagerEventListener != null)
    {
      localPagerEventListener.d();
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onFooterRebound");
      }
    }
  }
  
  private int c(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - a(paramLinearLayoutManager, paramOrientationHelper);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onHeaderRebound");
    }
  }
  
  private void k()
  {
    if (this.a.getOnFlingListener() == null)
    {
      this.d = new PagerSnapHelper.TouchEventProcessor(this, null);
      this.e = new PagerSnapHelper.OnLayoutChangedListenerImpl(this, null);
      this.f = new PagerSnapHelper.OnLayoutSizeChangedListener(this, null);
      this.a.setOnTouchListener(this.d);
      this.a.addOnScrollListener(this.d);
      this.a.setOnFlingListener(this.d);
      this.a.addOnLayoutChangeListener(this.e);
      this.a.addOnLayoutChangeListener(this.f);
      this.a.getAdapter().registerAdapterDataObserver(new PagerSnapHelper.1(this));
      return;
    }
    throw new IllegalStateException("An instance of OnFlingListener already set.");
  }
  
  private void l()
  {
    this.a.removeOnScrollListener(this.d);
    this.a.setOnFlingListener(null);
  }
  
  private int m()
  {
    return ViewConfiguration.get(this.a.getContext()).getScaledTouchSlop();
  }
  
  private int n()
  {
    return this.j;
  }
  
  @Nullable
  public View a(LinearLayoutManager paramLinearLayoutManager)
  {
    int i5 = paramLinearLayoutManager.getChildCount();
    Object localObject = null;
    if (i5 == 0) {
      return null;
    }
    OrientationHelper localOrientationHelper = b(paramLinearLayoutManager);
    int i2 = 2147483647;
    int i1 = 0;
    while (i1 < i5)
    {
      View localView = paramLinearLayoutManager.getChildAt(i1);
      int i4 = Math.abs(a(paramLinearLayoutManager, localView, localOrientationHelper));
      int i3 = i2;
      if (i4 < i2)
      {
        localObject = localView;
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return localObject;
  }
  
  public void a(PagerSnapHelper.PagerEventListener paramPagerEventListener)
  {
    this.c = paramPagerEventListener;
  }
  
  public void a(@Nullable RecyclerViewCompat paramRecyclerViewCompat)
  {
    RecyclerViewCompat localRecyclerViewCompat = this.a;
    if (localRecyclerViewCompat == paramRecyclerViewCompat) {
      return;
    }
    if (localRecyclerViewCompat != null) {
      l();
    }
    this.a = paramRecyclerViewCompat;
    paramRecyclerViewCompat = this.a;
    if (paramRecyclerViewCompat != null)
    {
      a(paramRecyclerViewCompat);
      this.b = ((LinearLayoutManager)this.a.getLayoutManager());
      k();
      f();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean a(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    int i1 = this.b.getPosition(paramView);
    if (i1 == -1) {
      return false;
    }
    return c(a(i1));
  }
  
  @NonNull
  protected OrientationHelper b(LinearLayoutManager paramLinearLayoutManager)
  {
    if (paramLinearLayoutManager.canScrollVertically())
    {
      if (this.g == null) {
        this.g = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 1);
      }
      return this.g;
    }
    if (this.h == null) {
      this.h = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 0);
    }
    return this.h;
  }
  
  public void b(View paramView)
  {
    if (this.a != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.b;
      if (localLinearLayoutManager == null) {
        return;
      }
      if (paramView == null) {
        return;
      }
      if (a(localLinearLayoutManager.getPosition(paramView), this.b)) {
        return;
      }
      if (paramView != null)
      {
        paramView = a(this.b, paramView);
        if ((paramView[0] != 0) || (paramView[1] != 0)) {
          this.a.scrollBy(paramView[0], paramView[1]);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  protected LinearSmoothScroller c(LinearLayoutManager paramLinearLayoutManager)
  {
    return new PagerSnapHelper.2(this, this.a.getContext(), paramLinearLayoutManager);
  }
  
  public void c(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public boolean c(int paramInt)
  {
    if (a(paramInt, this.b)) {
      return false;
    }
    View localView = this.b.findViewByPosition(paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("snapToTargetPosition: position=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", view=");
      ((StringBuilder)localObject).append(localView);
      QLog.d("PagerSnapHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (localView == null)
    {
      this.a.smoothScrollToPosition(paramInt);
      this.l = true;
      return true;
    }
    Object localObject = a(this.b, localView);
    int i1 = localObject[0];
    int i2 = localObject[1];
    if ((i1 == 0) && (i2 == 0)) {
      return false;
    }
    localObject = c(this.b);
    ((RecyclerView.SmoothScroller)localObject).setTargetPosition(paramInt);
    this.b.startSmoothScroll((RecyclerView.SmoothScroller)localObject);
    this.l = true;
    if (this.m) {
      a(localView, false);
    }
    if ((paramInt == a(this.b)) && ((i1 < 0) || (i2 < 0)))
    {
      b();
      return true;
    }
    if ((paramInt == n()) && ((i1 > 0) || (i2 > 0))) {
      c();
    }
    return true;
  }
  
  public void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  public boolean d()
  {
    if (this.a != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.b;
      if (localLinearLayoutManager == null) {
        return false;
      }
      int i1 = this.k + 1;
      if (a(i1, localLinearLayoutManager)) {
        return false;
      }
      c(i1);
      return true;
    }
    return false;
  }
  
  public void e(int paramInt)
  {
    this.j = paramInt;
  }
  
  public boolean e()
  {
    if (this.a != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.b;
      if (localLinearLayoutManager == null) {
        return false;
      }
      int i1 = this.k - 1;
      if (a(i1, localLinearLayoutManager)) {
        return false;
      }
      c(i1);
      return true;
    }
    return false;
  }
  
  public void f(int paramInt)
  {
    this.o = paramInt;
  }
  
  public boolean f()
  {
    if (this.a != null)
    {
      Object localObject = this.b;
      if (localObject == null) {
        return false;
      }
      localObject = a((LinearLayoutManager)localObject);
      if (localObject == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("snapToCenterPosition: findCenterView=");
        localStringBuilder.append(this.b.getPosition((View)localObject));
        QLog.d("PagerSnapHelper", 2, localStringBuilder.toString());
      }
      return a((View)localObject);
    }
    return false;
  }
  
  public void g()
  {
    this.a.addOnLayoutChangeListener(this.e);
  }
  
  public void g(int paramInt)
  {
    if (this.a != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.b;
      if (localLinearLayoutManager == null) {
        return;
      }
      b(localLinearLayoutManager.findViewByPosition(paramInt));
    }
  }
  
  public int h()
  {
    LinearLayoutManager localLinearLayoutManager = this.b;
    return b(localLinearLayoutManager, b(localLinearLayoutManager));
  }
  
  public int i()
  {
    return this.k;
  }
  
  public boolean j()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */