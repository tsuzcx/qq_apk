package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper;
import com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.RenderState;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.ViewHolderWrapper;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutParams;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Recycler;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.State;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewHolder;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewItem;
import java.util.ArrayList;

public class HippyWaterfallLayoutManager
  extends BaseLayoutManager
{
  int a = 2;
  int b = 0;
  boolean c = true;
  boolean d = false;
  boolean e = false;
  ArrayList<Integer> f = new ArrayList();
  int g = 0;
  int h = 0;
  
  public HippyWaterfallLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public HippyWaterfallLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, View paramView, RecyclerViewBase.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof HippyWaterfallLayoutManager.LayoutParams))
    {
      int i = ((HippyWaterfallLayoutManager.WaterFallRenderState)this.mRenderState).a;
      ((HippyWaterfallLayoutManager.LayoutParams)paramLayoutParams).a = i;
      a(paramInt1, paramInt2, paramView, i);
    }
    if (getOrientation() == 1) {
      paramLayoutParams.width = (paramInt3 - paramLayoutParams.leftMargin - paramLayoutParams.rightMargin);
    } else {
      paramLayoutParams.height = (paramInt3 - paramLayoutParams.topMargin - paramLayoutParams.bottomMargin);
    }
    if (((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter)) && (((RecyclerAdapter)this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight()) && ((paramView instanceof RecyclerViewItem)))
    {
      paramView = (RecyclerViewItem)paramView;
      if (paramView.getChildCount() > 0)
      {
        View localView = paramView.getChildAt(0);
        paramView = localView.getLayoutParams();
        if (paramView != null) {
          paramView.width = paramLayoutParams.width;
        } else {
          paramView = new ViewGroup.LayoutParams(paramLayoutParams);
        }
        if (((!this.e) || (paramInt2 != 0) || (!this.d)) && (paramView.width > 0)) {
          paramView.width -= paramInt1;
        }
        localView.setLayoutParams(paramView);
        localView.measure(View.MeasureSpec.makeMeasureSpec(paramView.width, -2147483648), View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), -2147483648));
      }
    }
    if ((this.e) && (paramInt2 == 0)) {
      return this.mRecyclerView.getMeasuredWidth();
    }
    return this.mRecyclerView.getMeasuredWidth() * (a() - 1) / a();
  }
  
  private int a(BaseLayoutManager.RenderState paramRenderState)
  {
    int i = paramRenderState.mOffset;
    paramRenderState.mOffset = this.mOrientationHelper.getDecoratedEnd(d());
    return paramRenderState.mOffset - i;
  }
  
  private int a(BaseLayoutManager.RenderState paramRenderState, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt;
    if (paramRenderState.mLayoutDirection == -1)
    {
      arrayOfInt = d(paramRenderState.mCurrentPosition - paramRenderState.mItemDirection);
      paramRenderState = c(paramRenderState.mCurrentPosition - paramRenderState.mItemDirection);
      paramInt2 = c(arrayOfInt);
    }
    for (paramInt1 = c(paramRenderState);; paramInt1 = b(paramRenderState))
    {
      return paramInt1 - paramInt2;
      if ((this.e) && (paramInt1 == 0)) {
        return paramInt2;
      }
      arrayOfInt = c(paramRenderState.mCurrentPosition - paramRenderState.mItemDirection);
      paramRenderState = d(paramRenderState.mCurrentPosition - paramRenderState.mItemDirection);
      paramInt2 = b(arrayOfInt);
    }
  }
  
  private int a(BaseLayoutManager.RenderState paramRenderState, int paramInt1, int paramInt2, View paramView, RecyclerViewBase.LayoutParams paramLayoutParams, int paramInt3)
  {
    int k = this.mOrientationHelper.getDecoratedMeasurement(paramView);
    if (getOrientation() == 1)
    {
      if (paramInt3 == 2)
      {
        paramInt3 = getPaddingLeft();
        i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramView) + paramInt3;
        paramInt2 = this.mOrientationHelper.getDecoratedEnd(d());
        paramInt1 = this.mOrientationHelper.getDecoratedEnd(d()) + k;
      }
      else
      {
        if (paramInt3 == 1)
        {
          paramInt2 = getPaddingLeft();
          paramInt3 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramView) + paramInt2;
          if (paramRenderState.mLayoutDirection == -1)
          {
            paramInt1 = paramRenderState.mOffset;
            j = paramRenderState.mOffset;
            j -= k;
            i = paramInt3;
            paramInt3 = j;
          }
        }
        for (;;)
        {
          j = paramInt3;
          paramInt3 = i;
          i = paramInt2;
          paramInt2 = j;
          break label379;
          paramInt1 = paramRenderState.mOffset;
          j = paramRenderState.mOffset + k;
          i = paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = j;
          break label429;
          boolean bool = this.c;
          i = 0;
          paramInt3 = i;
          if (bool) {
            if (((HippyWaterfallLayoutManager.WaterFallRenderState)this.mRenderState).a == 0) {
              paramInt3 = i;
            } else {
              paramInt3 = paramInt2 / 2;
            }
          }
          paramInt2 = ((HippyWaterfallLayoutManager.WaterFallRenderState)this.mRenderState).a * paramInt1 + getPaddingLeft() - paramInt3;
          i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramView) + paramInt2;
          if (paramRenderState.mLayoutDirection == -1)
          {
            paramInt1 = paramRenderState.mOffset;
            j = paramRenderState.mOffset;
            paramInt3 = i;
            break;
          }
          paramInt3 = paramRenderState.mOffset;
          paramInt1 = paramRenderState.mOffset + k;
        }
      }
    }
    else
    {
      if (paramRenderState.mLayoutDirection != -1) {
        break label382;
      }
      paramInt1 = getHeight() - getPaddingBottom() - paramInt1 * ((HippyWaterfallLayoutManager.WaterFallRenderState)this.mRenderState).a;
      paramInt2 = paramInt1 - this.mOrientationHelper.getDecoratedMeasurementInOther(paramView);
      i = paramRenderState.mOffset;
      paramInt3 = paramRenderState.mOffset - k;
    }
    int j = i;
    int i = paramInt3;
    paramInt3 = j;
    label379:
    break label429;
    label382:
    paramInt2 = ((HippyWaterfallLayoutManager.WaterFallRenderState)this.mRenderState).a * paramInt1 + getPaddingTop();
    paramInt1 = paramInt2 + this.mOrientationHelper.getDecoratedMeasurementInOther(paramView);
    i = paramRenderState.mOffset;
    paramInt3 = paramRenderState.mOffset + k;
    label429:
    layoutDecorated(paramView, i + paramLayoutParams.leftMargin, paramInt2 + paramLayoutParams.topMargin, paramInt3 - paramLayoutParams.rightMargin, paramInt1 - paramLayoutParams.bottomMargin);
    return k;
  }
  
  private int a(BaseLayoutManager.RenderState paramRenderState, View paramView)
  {
    if (paramRenderState.mLayoutDirection == -1) {
      return -this.mOrientationHelper.getDecoratedMeasurement(paramView);
    }
    return this.mOrientationHelper.getDecoratedMeasurement(paramView);
  }
  
  private int a(RecyclerViewBase.Recycler paramRecycler, BaseLayoutManager.RenderState paramRenderState, int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4)
  {
    if (paramInt3 == 2) {
      paramInt3 = a(paramRenderState);
    } else if (paramInt3 == 1) {
      paramInt3 = a(paramRenderState, paramView);
    } else {
      paramInt3 = a(paramRenderState, paramInt2, paramInt4);
    }
    if ((this.e) && (paramInt2 == 0)) {
      ((HippyWaterfallLayoutManager.WaterFallRenderState)this.mRenderState).a = 0;
    } else {
      c();
    }
    if (paramRenderState.mLayoutDirection == -1) {
      paramRenderState.mOffset = this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen());
    } else {
      paramRenderState.mOffset += paramRenderState.mLayoutDirection * paramInt3;
    }
    paramRenderState.mAvailable -= Math.abs(paramInt3);
    paramInt2 = Math.abs(paramInt3);
    if (paramRenderState.mScrollingOffset != -2147483648)
    {
      paramRenderState.mScrollingOffset += Math.abs(paramInt3);
      if (paramRenderState.mAvailable < 0) {
        paramRenderState.mScrollingOffset += paramRenderState.mAvailable;
      }
      recycleByRenderState(paramRecycler, paramRenderState);
    }
    return paramInt1 - paramInt2;
  }
  
  private int a(RecyclerViewBase.Recycler paramRecycler, BaseLayoutManager.RenderState paramRenderState, RecyclerViewBase.State paramState, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, View paramView)
  {
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    if ((localLayoutParams instanceof HippyWaterfallLayoutManager.LayoutParams)) {
      ((HippyWaterfallLayoutManager.LayoutParams)localLayoutParams).a = -1;
    }
    if ((!localLayoutParams.isItemRemoved()) && (this.mRenderState.mScrapList == null))
    {
      boolean bool2 = this.mShouldReverseLayout;
      boolean bool1;
      if (paramRenderState.mLayoutDirection == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool2 == bool1) {
        addView(paramView);
      } else {
        addView(paramView, 0);
      }
    }
    int i = localLayoutParams.mViewHolder.mViewType;
    if (i == 3) {
      paramInt5 = a(paramInt2, paramInt4, paramInt5, paramView, localLayoutParams);
    } else {
      paramInt5 = 0;
    }
    measureChildWithMargins(paramView, paramInt5, 0);
    if (((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter)) && (((RecyclerAdapter)this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight())) {
      a(paramRenderState, paramState, paramInt4, paramView, i);
    }
    paramInt1 = a(paramRenderState, paramInt1, paramInt2, paramView, localLayoutParams, i);
    if (!localLayoutParams.isItemRemoved()) {
      return a(paramRecycler, paramRenderState, paramInt3, paramInt4, paramView, i, paramInt1);
    }
    return paramInt3;
  }
  
  public static int a(int[] paramArrayOfInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfInt.length; j = k)
    {
      k = j;
      if (paramArrayOfInt[j] > paramArrayOfInt[i]) {
        k = i;
      }
      i += 1;
    }
    return j;
  }
  
  private void a(int paramInt1, int paramInt2, RecyclerViewBase.State paramState)
  {
    if (((HippyWaterfallAdapter)this.mRecyclerView.getAdapter()).a) {
      return;
    }
    int j = this.mRecyclerView.mAdapter.getPreloadThresholdInItemNumber();
    int k = this.mRecyclerView.mAdapter.getPreloadThresholdInPixels();
    int i;
    if (paramInt1 == 1) {
      i = paramInt2;
    } else {
      i = paramInt2 * -1;
    }
    int m = this.mRenderState.mScrollingOffset + this.g;
    if (paramInt2 > m) {
      i = paramInt1 * m;
    }
    if ((k > 0) && (this.mRecyclerView.getHeight() < paramState.mTotalHeight))
    {
      if ((this.mRecyclerView.mOffsetY + k + this.mRecyclerView.getHeight() < paramState.mTotalHeight) && (this.mRecyclerView.mOffsetY + k + i + this.mRecyclerView.getHeight() >= paramState.mTotalHeight)) {
        this.mRecyclerView.mAdapter.onPreload();
      }
    }
    else if ((j > 0) && (this.mRecyclerView.getHeight() < paramState.mTotalHeight))
    {
      paramInt1 = this.mRecyclerView.mAdapter.getHeightBefore(this.mRenderState.mCurrentPosition - this.mRenderState.mItemDirection);
      if ((this.mRenderState.mCurrentPosition >= getItemCount() - j) && (this.mRecyclerView.mOffsetY + this.mRecyclerView.getHeight() < paramState.mTotalHeight) && (this.mRecyclerView.mOffsetY + i + this.mRecyclerView.getHeight() >= paramInt1)) {
        this.mRecyclerView.mAdapter.onPreload();
      }
    }
  }
  
  private void a(BaseLayoutManager.RenderState paramRenderState, RecyclerViewBase.State paramState, int paramInt1, View paramView, int paramInt2)
  {
    if ((paramView instanceof RecyclerViewItem))
    {
      paramView = (RecyclerViewItem)paramView;
      if (paramView.getChildCount() > 0) {
        recordItemSize(paramInt1, paramView.getChildAt(0));
      }
    }
    else if (paramInt2 == 1)
    {
      paramInt2 = paramView.getMeasuredHeight();
      paramInt1 = Math.abs(paramInt1) - 1;
      while (paramInt1 >= this.f.size()) {
        this.f.add(Integer.valueOf(0));
      }
      this.f.set(paramInt1, Integer.valueOf(paramInt2));
    }
    if (paramRenderState.hasMore(paramState) == 1) {
      this.mRecyclerView.mState.mTotalHeight = this.mRecyclerView.getAdapter().getListTotalHeight();
    }
  }
  
  public static int b(int[] paramArrayOfInt)
  {
    return paramArrayOfInt[a(paramArrayOfInt)];
  }
  
  public static int c(int[] paramArrayOfInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfInt.length; j = k)
    {
      k = j;
      if (paramArrayOfInt[j] < paramArrayOfInt[i]) {
        k = i;
      }
      i += 1;
    }
    return paramArrayOfInt[j];
  }
  
  private void c()
  {
    if ((this.e) && (this.mRenderState.mCurrentPosition == 0))
    {
      ((HippyWaterfallLayoutManager.WaterFallRenderState)this.mRenderState).a = 0;
      return;
    }
    int[] arrayOfInt = c(this.mRenderState.mCurrentPosition);
    ((HippyWaterfallLayoutManager.WaterFallRenderState)this.mRenderState).a = a(arrayOfInt);
  }
  
  private View d()
  {
    View[] arrayOfView = new View[this.a];
    int k = 0;
    int i = 0;
    while (i < getChildCount() - 1)
    {
      View localView = getChildAt(i);
      HippyWaterfallLayoutManager.LayoutParams localLayoutParams = (HippyWaterfallLayoutManager.LayoutParams)localView.getLayoutParams();
      j = 0;
      while (j < this.a)
      {
        if (localLayoutParams.a == j)
        {
          arrayOfView[j] = localView;
          break;
        }
        j += 1;
      }
      i += 1;
    }
    int j = 0;
    i = k;
    while ((i < this.a) && (arrayOfView[j] != null) && (arrayOfView[i] != null))
    {
      k = j;
      if (arrayOfView[j].getBottom() < arrayOfView[i].getBottom()) {
        k = i;
      }
      i += 1;
      j = k;
    }
    return arrayOfView[j];
  }
  
  private View e()
  {
    boolean bool = this.e;
    int k = 1;
    int m = 0;
    if ((bool) && (getChildCount() == 1)) {
      return getChildAt(0);
    }
    View[] arrayOfView = new View[this.a];
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView.getLayoutParams() instanceof HippyWaterfallLayoutManager.LayoutParams)) {
        arrayOfView[((HippyWaterfallLayoutManager.LayoutParams)localView.getLayoutParams()).a] = localView;
      }
      i += 1;
    }
    if (this.mRenderState.mCurrentPosition != getItemCount()) {
      k = 0;
    }
    int j = 0;
    i = m;
    while (i < this.a)
    {
      if (arrayOfView[i] == null) {
        break label204;
      }
      if (arrayOfView[j] == null) {
        break;
      }
      if (k != 0)
      {
        m = j;
        if (arrayOfView[j].getBottom() >= arrayOfView[i].getBottom()) {
          break label192;
        }
      }
      else
      {
        m = j;
        if (arrayOfView[j].getBottom() < arrayOfView[i].getBottom()) {
          break label192;
        }
      }
      m = i;
      label192:
      i += 1;
      j = m;
    }
    i = j;
    label204:
    return arrayOfView[i];
  }
  
  private View f()
  {
    int j = a(c(getPosition(getChildClosestToStartByOrder()) + this.mRenderState.mItemDirection));
    View localView = null;
    int i = 0;
    while (i < getChildCount())
    {
      localView = getChildAt(i);
      if (((localView.getLayoutParams() instanceof HippyWaterfallLayoutManager.LayoutParams)) && (((HippyWaterfallLayoutManager.LayoutParams)localView.getLayoutParams()).a == j)) {
        return localView;
      }
      i += 1;
    }
    return localView;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = Math.max(2, paramInt);
  }
  
  void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    if ((this.e) && (paramInt2 == 0))
    {
      if (this.d)
      {
        paramView.setPadding(0, 0, 0, this.b);
        return;
      }
      paramInt1 /= 2;
      paramView.setPadding(paramInt1, 0, paramInt1, this.b);
      return;
    }
    if (this.c)
    {
      if (paramInt3 == 0)
      {
        paramView.setPadding(0, 0, paramInt1 / 2, this.b);
        return;
      }
      if (paramInt3 == this.a - 1)
      {
        paramView.setPadding(paramInt1 / 2, 0, 0, this.b);
        return;
      }
      paramInt1 /= 2;
      paramView.setPadding(paramInt1, 0, paramInt1, this.b);
      return;
    }
    paramInt1 /= 2;
    paramView.setPadding(paramInt1, 0, paramInt1, this.b);
  }
  
  void a(HippyWaterfallLayoutManager.WaterFallRenderState paramWaterFallRenderState)
  {
    if ((paramWaterFallRenderState.mCurrentPosition > 0) && (paramWaterFallRenderState.mLayoutDirection == 1))
    {
      if (paramWaterFallRenderState.mOffset >= 0) {
        return;
      }
      int[] arrayOfInt = c(paramWaterFallRenderState.mCurrentPosition);
      int i4 = 0;
      int i = arrayOfInt[0];
      int k = arrayOfInt[0];
      int j = 1;
      int i1;
      int n;
      int m;
      while (j < arrayOfInt.length)
      {
        i1 = arrayOfInt[j];
        if (i1 > i)
        {
          n = i1;
          m = k;
        }
        else
        {
          m = k;
          n = i;
          if (i1 < k)
          {
            m = i1;
            n = i;
          }
        }
        j += 1;
        k = m;
        i = n;
      }
      int i6 = k - paramWaterFallRenderState.mOffset;
      if (i <= i6) {
        return;
      }
      int i7 = this.a;
      int i5 = paramWaterFallRenderState.a;
      i = paramWaterFallRenderState.mCurrentPosition - 1;
      while ((i > 0) && (paramWaterFallRenderState.mCurrentPosition - i < i7))
      {
        arrayOfInt = c(i);
        n = arrayOfInt[0];
        j = arrayOfInt[0];
        k = 0;
        m = 1;
        while (m < arrayOfInt.length)
        {
          i1 = arrayOfInt[m];
          int i2;
          int i3;
          if (i1 > n)
          {
            i2 = i1;
            i3 = j;
          }
          else
          {
            i2 = n;
            i3 = j;
            if (i1 < j)
            {
              k = m;
              i3 = i1;
              i2 = n;
            }
          }
          m += 1;
          n = i2;
          j = i3;
        }
        if (n <= i6) {
          break label287;
        }
        i -= 1;
      }
      j = 0;
      k = i5;
      i = i4;
      label287:
      if (paramWaterFallRenderState.mCurrentPosition - i >= i7) {
        return;
      }
      paramWaterFallRenderState.mCurrentPosition = i;
      paramWaterFallRenderState.mOffset = (j - i6);
      paramWaterFallRenderState.a = k;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.b = Math.max(0, paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  int[] c(int paramInt)
  {
    int[] arrayOfInt = new int[this.a];
    RecyclerAdapter localRecyclerAdapter = (RecyclerAdapter)this.mRecyclerView.getAdapter();
    int j = paramInt;
    if (this.e) {
      j = paramInt + (this.a - 1);
    }
    paramInt = 0;
    while (paramInt < j)
    {
      int i = 0;
      int m;
      for (int k = 0; i < arrayOfInt.length; k = m)
      {
        m = k;
        if (arrayOfInt[k] > arrayOfInt[i]) {
          m = i;
        }
        i += 1;
      }
      if (this.e)
      {
        i = this.a;
        if (paramInt > i - 1) {
          i = paramInt - (i - 1);
        } else {
          i = 0;
        }
      }
      else
      {
        i = paramInt;
      }
      i = localRecyclerAdapter.getItemHeight(i) + localRecyclerAdapter.getItemMaigin(1, i) + localRecyclerAdapter.getItemMaigin(3, i);
      arrayOfInt[k] += i;
      if (this.h < i) {
        this.h = i;
      }
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  public void calculateOffsetMap(SparseIntArray paramSparseIntArray, int paramInt)
  {
    RecyclerAdapter localRecyclerAdapter = (RecyclerAdapter)this.mRecyclerView.getAdapter();
    int i = localRecyclerAdapter.getItemCount();
    int[] arrayOfInt = new int[this.a];
    paramInt = 0;
    while (paramInt < i)
    {
      int j = a(arrayOfInt);
      paramSparseIntArray.append(paramInt, arrayOfInt[j]);
      arrayOfInt[j] += localRecyclerAdapter.getItemHeight(paramInt) + localRecyclerAdapter.getItemMaigin(1, paramInt) + localRecyclerAdapter.getItemMaigin(3, paramInt);
      paramInt += 1;
    }
  }
  
  public int[] d(int paramInt)
  {
    int[] arrayOfInt = new int[this.a];
    RecyclerAdapter localRecyclerAdapter = (RecyclerAdapter)this.mRecyclerView.getAdapter();
    int j = paramInt;
    if (this.e) {
      j = paramInt + (this.a - 1);
    }
    paramInt = 0;
    while (paramInt <= j)
    {
      int i = 0;
      for (int k = 0; i < arrayOfInt.length; k = m)
      {
        m = k;
        if (arrayOfInt[k] > arrayOfInt[i]) {
          m = i;
        }
        i += 1;
      }
      if (this.e)
      {
        i = this.a;
        if (paramInt > i - 1) {
          i = paramInt - (i - 1);
        } else {
          i = 0;
        }
      }
      else
      {
        i = paramInt;
      }
      int m = localRecyclerAdapter.getItemHeight(i);
      int n = localRecyclerAdapter.getItemMaigin(1, i);
      i = localRecyclerAdapter.getItemMaigin(3, i);
      arrayOfInt[k] += m + n + i;
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  protected void ensureRenderState()
  {
    if (this.mRenderState == null) {
      this.mRenderState = new HippyWaterfallLayoutManager.WaterFallRenderState();
    }
    super.ensureRenderState();
  }
  
  protected int fill(RecyclerViewBase.Recycler paramRecycler, BaseLayoutManager.RenderState paramRenderState, RecyclerViewBase.State paramState, boolean paramBoolean)
  {
    a((HippyWaterfallLayoutManager.WaterFallRenderState)paramRenderState);
    int m = this.b;
    int i;
    if (this.c) {
      i = (getWidth() + m - getPaddingLeft() - getPaddingRight()) / this.a;
    } else {
      i = (getWidth() - getPaddingLeft() - getPaddingRight()) / this.a;
    }
    int n = paramRenderState.mAvailable;
    if (paramRenderState.mScrollingOffset != -2147483648)
    {
      if (paramRenderState.mAvailable < 0) {
        paramRenderState.mScrollingOffset += paramRenderState.mAvailable;
      }
      recycleByRenderState(paramRecycler, paramRenderState);
    }
    int j = paramRenderState.mAvailable + paramRenderState.mExtra;
    View localView;
    do
    {
      int k;
      do
      {
        if (j <= 0) {
          break;
        }
        if (paramRenderState.hasMore(paramState) == 1) {
          return j;
        }
        int i1 = paramRenderState.mCurrentPosition;
        if ((this.e) && (i1 == 0)) {
          k = getWidth() - getPaddingLeft() - getPaddingRight();
        } else {
          k = i;
        }
        localView = getNextView(paramRecycler, paramRenderState, paramState);
        if (localView == null) {
          break;
        }
        k = a(paramRecycler, paramRenderState, paramState, i, m, j, i1, k, localView);
        if ((paramBoolean) && (localView.isFocusable())) {
          break;
        }
        j = k;
      } while (paramState == null);
      j = k;
    } while (paramState.getTargetScrollPosition() != getPosition(localView));
    this.g = (n - paramRenderState.mAvailable);
    return n - paramRenderState.mAvailable;
  }
  
  public View getChildClosestToEndInScreen()
  {
    if (this.mShouldReverseLayout) {
      return f();
    }
    return e();
  }
  
  public View getChildClosestToStartInScreen()
  {
    if (this.mShouldReverseLayout) {
      return e();
    }
    return f();
  }
  
  public int getHeightBefore(int paramInt)
  {
    int[] arrayOfInt = c(paramInt);
    return arrayOfInt[a(arrayOfInt)];
  }
  
  public int getLayoutType()
  {
    return 3;
  }
  
  public int getTotalHeight()
  {
    return c(d(getItemCount()));
  }
  
  public void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    RecyclerViewBase.LayoutParams localLayoutParams;
    if (paramView.getLayoutParams() != null) {
      localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    } else {
      localLayoutParams = generateDefaultLayoutParams();
    }
    Object localObject1 = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
    int i = ((Rect)localObject1).left;
    int j = ((Rect)localObject1).right;
    int k = ((Rect)localObject1).top;
    int m = ((Rect)localObject1).bottom;
    localObject1 = new HippyWaterfallLayoutManager.MeasureWH();
    ((HippyWaterfallLayoutManager.MeasureWH)localObject1).a = localLayoutParams.width;
    ((HippyWaterfallLayoutManager.MeasureWH)localObject1).b = localLayoutParams.height;
    if (((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter)) && (((RecyclerAdapter)this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight()))
    {
      Object localObject2;
      if ((paramView instanceof RecyclerViewItem))
      {
        localObject2 = (RecyclerViewItem)paramView;
        if (((RecyclerViewItem)localObject2).getChildCount() > 0)
        {
          localObject2 = ((RecyclerViewItem)localObject2).getChildAt(0);
          ((HippyWaterfallLayoutManager.MeasureWH)localObject1).a = (((View)localObject2).getMeasuredWidth() + paramView.getPaddingRight() + paramView.getPaddingLeft());
          ((HippyWaterfallLayoutManager.MeasureWH)localObject1).b = (((View)localObject2).getMeasuredHeight() + this.b);
        }
      }
      else if ((paramView instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)paramView;
        if (((ViewGroup)localObject2).getChildCount() > 0)
        {
          localObject2 = ((ViewGroup)localObject2).getChildAt(0);
          ((HippyWaterfallLayoutManager.MeasureWH)localObject1).a = ((View)localObject2).getMeasuredWidth();
          ((HippyWaterfallLayoutManager.MeasureWH)localObject1).b = ((View)localObject2).getMeasuredHeight();
        }
      }
    }
    paramView.measure(getChildMeasureSpec(getWidth(), getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + (paramInt1 + (i + j)), ((HippyWaterfallLayoutManager.MeasureWH)localObject1).a, canScrollHorizontally()), getChildMeasureSpec(getHeight(), getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin + (paramInt2 + (k + m)), ((HippyWaterfallLayoutManager.MeasureWH)localObject1).b, canScrollVertically()));
  }
  
  public RecyclerViewBase.LayoutParams onCreateItemLayoutParams(RecyclerView.ViewHolderWrapper paramViewHolderWrapper, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = this.mRecyclerView.getAdapter().getItemHeight(paramInt1);
    paramViewHolderWrapper = paramViewHolderWrapper.itemView.getLayoutParams();
    if (paramViewHolderWrapper == null) {
      return new HippyWaterfallLayoutManager.LayoutParams(-2, paramInt1);
    }
    if ((paramViewHolderWrapper instanceof HippyWaterfallLayoutManager.LayoutParams)) {
      return (RecyclerViewBase.LayoutParams)paramViewHolderWrapper;
    }
    return new HippyWaterfallLayoutManager.LayoutParams(paramViewHolderWrapper.width, paramInt1);
  }
  
  protected void updateRenderState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerViewBase.State paramState)
  {
    super.updateRenderState(paramInt1, paramInt2, paramBoolean, paramState);
    if (!((HippyWaterfallAdapter)this.mRecyclerView.getAdapter()).a) {
      a(paramInt1, paramInt2, paramState);
    }
    c();
  }
  
  protected void updateRenderStateToFillEnd(int paramInt1, int paramInt2)
  {
    super.updateRenderStateToFillEnd(paramInt1, paramInt2);
    if ((this.e) && (paramInt1 == 0))
    {
      ((HippyWaterfallLayoutManager.WaterFallRenderState)this.mRenderState).a = 0;
      return;
    }
    c();
  }
  
  protected void updateRenderStateToFillStart(int paramInt1, int paramInt2)
  {
    super.updateRenderStateToFillStart(paramInt1, paramInt2);
    if ((this.e) && (paramInt1 == 0))
    {
      ((HippyWaterfallLayoutManager.WaterFallRenderState)this.mRenderState).a = 0;
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallLayoutManager
 * JD-Core Version:    0.7.0.1
 */