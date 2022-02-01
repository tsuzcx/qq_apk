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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private OrientationHelper jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper;
  private PagerSnapHelper.OnLayoutChangedListenerImpl jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$OnLayoutChangedListenerImpl;
  private PagerSnapHelper.OnLayoutSizeChangedListener jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$OnLayoutSizeChangedListener;
  private PagerSnapHelper.PagerEventListener jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$PagerEventListener;
  private PagerSnapHelper.TouchEventProcessor jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$TouchEventProcessor;
  private RecyclerViewCompat jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private OrientationHelper jdField_b_of_type_AndroidSupportV7WidgetOrientationHelper;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  
  public PagerSnapHelper()
  {
    this(0, 25.0F);
  }
  
  public PagerSnapHelper(int paramInt, float paramFloat)
  {
    a();
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  private int a()
  {
    return ViewConfiguration.get(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getContext()).getScaledTouchSlop();
  }
  
  private int a(int paramInt)
  {
    int i = c();
    int j = a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    if (paramInt < i) {
      return i;
    }
    i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    return i;
  }
  
  private int a(LinearLayoutManager paramLinearLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int i;
    if (paramLinearLayoutManager.getClipToPadding()) {
      i = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;
    } else {
      i = paramOrientationHelper.getEnd() / 2;
    }
    return i + this.jdField_e_of_type_Int;
  }
  
  private int a(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    if (this.jdField_d_of_type_Int != 1) {
      return c(paramLinearLayoutManager, paramView, paramOrientationHelper);
    }
    return b(paramLinearLayoutManager, paramView, paramOrientationHelper);
  }
  
  private int a(OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getStartAfterPadding() + this.jdField_e_of_type_Int;
  }
  
  private int a(RecyclerView.LayoutManager paramLayoutManager)
  {
    return paramLayoutManager.getItemCount() - this.jdField_a_of_type_Int - 1;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
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
      Object localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
      if ((localObject != null) && (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null))
      {
        localObject = ((RecyclerViewCompat)localObject).getChildViewHolder(paramView);
        int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getPosition(paramView);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("dispatchPagerChanged: position=");
          localStringBuilder.append(i);
          localStringBuilder.append(", centerPosition=");
          localStringBuilder.append(this.jdField_c_of_type_Int);
          localStringBuilder.append(", reset=");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append(", isRealIdle=");
          localStringBuilder.append(this.jdField_e_of_type_Boolean);
          localStringBuilder.append(", isNeedCallPageIdle=");
          localStringBuilder.append(this.jdField_f_of_type_Boolean);
          QLog.d("PagerSnapHelper", 2, localStringBuilder.toString());
        }
        if ((localObject != null) && (i != -1))
        {
          if ((i != this.jdField_c_of_type_Int) || (paramBoolean))
          {
            if (a(i, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager)) {
              return;
            }
            this.jdField_c_of_type_Int = i;
            this.jdField_f_of_type_Boolean = true;
            if (this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$PagerEventListener != null)
            {
              TraceCompat.beginSection("onPagerChanged");
              this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$PagerEventListener.a((RecyclerView.ViewHolder)localObject);
              TraceCompat.endSection();
            }
          }
          if ((this.jdField_e_of_type_Boolean) && (this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$PagerEventListener != null))
          {
            this.jdField_f_of_type_Boolean = false;
            paramView = this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getChildViewHolder(paramView);
            TraceCompat.beginSection("onPagerIdle");
            this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$PagerEventListener.b(paramView);
            TraceCompat.endSection();
          }
        }
      }
    }
  }
  
  private boolean a(int paramInt, RecyclerView.LayoutManager paramLayoutManager)
  {
    int i = a(paramLayoutManager);
    return (paramInt < c()) || (paramInt > i);
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
    int i = paramLinearLayoutManager.getPosition(localView);
    if (i == -1) {
      return false;
    }
    int j = a(i);
    int k = a();
    boolean bool = paramLinearLayoutManager.canScrollHorizontally();
    i = 1;
    if (bool)
    {
      if (Math.abs(paramFloat1) > k ? paramFloat1 > 0.0F : paramFloat3 > 0.0F) {}
    }
    else {
      while (Math.abs(paramFloat2) > k ? paramFloat2 <= 0.0F : paramFloat4 <= 0.0F)
      {
        i = 0;
        break;
      }
    }
    if ((paramInt != -1) && (j != paramInt)) {
      paramInt = j;
    } else if (i != 0) {
      paramInt = j + 1;
    } else {
      paramInt = j - 1;
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
    return a(paramInt);
  }
  
  @NonNull
  private int[] a(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLinearLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = a(paramLinearLayoutManager, paramView, a(paramLinearLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    }
    if (paramLinearLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = a(paramLinearLayoutManager, paramView, a(paramLinearLayoutManager));
      return arrayOfInt;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  private int b(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) - a(paramOrientationHelper);
  }
  
  private void b()
  {
    PagerSnapHelper.PagerEventListener localPagerEventListener = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$PagerEventListener;
    if (localPagerEventListener != null)
    {
      localPagerEventListener.a();
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onFooterRebound");
      }
    }
  }
  
  private int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private int c(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - a(paramLinearLayoutManager, paramOrientationHelper);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onHeaderRebound");
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getOnFlingListener() == null)
    {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$TouchEventProcessor = new PagerSnapHelper.TouchEventProcessor(this, null);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$OnLayoutChangedListenerImpl = new PagerSnapHelper.OnLayoutChangedListenerImpl(this, null);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$OnLayoutSizeChangedListener = new PagerSnapHelper.OnLayoutSizeChangedListener(this, null);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setOnTouchListener(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$TouchEventProcessor);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnScrollListener(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$TouchEventProcessor);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setOnFlingListener(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$TouchEventProcessor);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnLayoutChangeListener(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$OnLayoutChangedListenerImpl);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnLayoutChangeListener(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$OnLayoutSizeChangedListener);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getAdapter().registerAdapterDataObserver(new PagerSnapHelper.1(this));
      return;
    }
    throw new IllegalStateException("An instance of OnFlingListener already set.");
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.removeOnScrollListener(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$TouchEventProcessor);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setOnFlingListener(null);
  }
  
  protected LinearSmoothScroller a(LinearLayoutManager paramLinearLayoutManager)
  {
    return new PagerSnapHelper.2(this, this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getContext(), paramLinearLayoutManager);
  }
  
  @NonNull
  protected OrientationHelper a(LinearLayoutManager paramLinearLayoutManager)
  {
    if (paramLinearLayoutManager.canScrollVertically())
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 1);
      }
      return this.jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper;
    }
    if (this.jdField_b_of_type_AndroidSupportV7WidgetOrientationHelper == null) {
      this.jdField_b_of_type_AndroidSupportV7WidgetOrientationHelper = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 0);
    }
    return this.jdField_b_of_type_AndroidSupportV7WidgetOrientationHelper;
  }
  
  @Nullable
  public View a(LinearLayoutManager paramLinearLayoutManager)
  {
    int n = paramLinearLayoutManager.getChildCount();
    Object localObject = null;
    if (n == 0) {
      return null;
    }
    OrientationHelper localOrientationHelper = a(paramLinearLayoutManager);
    int j = 2147483647;
    int i = 0;
    while (i < n)
    {
      View localView = paramLinearLayoutManager.getChildAt(i);
      int m = Math.abs(a(paramLinearLayoutManager, localView, localOrientationHelper));
      int k = j;
      if (m < j)
      {
        localObject = localView;
        k = m;
      }
      i += 1;
      j = k;
    }
    return localObject;
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
      if (localLinearLayoutManager == null) {
        return;
      }
      if (paramView == null) {
        return;
      }
      if (a(localLinearLayoutManager.getPosition(paramView), this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager)) {
        return;
      }
      if (paramView != null)
      {
        paramView = a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, paramView);
        if ((paramView[0] != 0) || (paramView[1] != 0)) {
          this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.scrollBy(paramView[0], paramView[1]);
        }
      }
    }
  }
  
  public void a(PagerSnapHelper.PagerEventListener paramPagerEventListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$PagerEventListener = paramPagerEventListener;
  }
  
  public void a(@Nullable RecyclerViewCompat paramRecyclerViewCompat)
  {
    RecyclerViewCompat localRecyclerViewCompat = this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
    if (localRecyclerViewCompat == paramRecyclerViewCompat) {
      return;
    }
    if (localRecyclerViewCompat != null) {
      f();
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = paramRecyclerViewCompat;
    paramRecyclerViewCompat = this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
    if (paramRecyclerViewCompat != null)
    {
      a(paramRecyclerViewCompat);
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = ((LinearLayoutManager)this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getLayoutManager());
      e();
      c();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
      if (localLinearLayoutManager == null) {
        return false;
      }
      int i = this.jdField_c_of_type_Int + 1;
      if (a(i, localLinearLayoutManager)) {
        return false;
      }
      a(i);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if (a(paramInt, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager)) {
      return false;
    }
    View localView = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(paramInt);
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
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.smoothScrollToPosition(paramInt);
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    Object localObject = a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, localView);
    int i = localObject[0];
    int j = localObject[1];
    if ((i == 0) && (j == 0)) {
      return false;
    }
    localObject = a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    ((RecyclerView.SmoothScroller)localObject).setTargetPosition(paramInt);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.startSmoothScroll((RecyclerView.SmoothScroller)localObject);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean) {
      a(localView, false);
    }
    if ((paramInt == a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager)) && ((i < 0) || (j < 0)))
    {
      b();
      return true;
    }
    if ((paramInt == c()) && ((i > 0) || (j > 0))) {
      d();
    }
    return true;
  }
  
  public boolean a(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getPosition(paramView);
    if (i == -1) {
      return false;
    }
    return a(a(i));
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
      if (localLinearLayoutManager == null) {
        return false;
      }
      int i = this.jdField_c_of_type_Int - 1;
      if (a(i, localLinearLayoutManager)) {
        return false;
      }
      a(i);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnLayoutChangeListener(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper$OnLayoutChangedListenerImpl);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
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
        localStringBuilder.append(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getPosition((View)localObject));
        QLog.d("PagerSnapHelper", 2, localStringBuilder.toString());
      }
      return a((View)localObject);
    }
    return false;
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void e(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
      if (localLinearLayoutManager == null) {
        return;
      }
      a(localLinearLayoutManager.findViewByPosition(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */