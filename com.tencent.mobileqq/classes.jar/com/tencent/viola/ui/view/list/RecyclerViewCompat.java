package com.tencent.viola.ui.view.list;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import com.tencent.viola.utils.ViolaLogUtils;

public class RecyclerViewCompat
  extends RecyclerView
{
  private static final String TAG = "RecyclerViewCompat";
  private boolean mIsInterruptedFling = false;
  private boolean mIsInterruptedPreFling = false;
  private RecyclerViewCompat.OnCompatFlingListener mOnFlingListener;
  
  public RecyclerViewCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerViewCompat(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclerViewCompat(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.mIsInterruptedFling)
    {
      this.mIsInterruptedFling = false;
      return false;
    }
    return super.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    if (this.mIsInterruptedPreFling)
    {
      this.mIsInterruptedPreFling = false;
      return false;
    }
    return super.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    int j = paramInt1;
    int k = paramInt2;
    if (this.mOnFlingListener != null)
    {
      Object localObject = getLayoutManager();
      boolean bool1 = false;
      if (localObject == null)
      {
        ViolaLogUtils.e("RecyclerViewCompat", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return false;
      }
      if (isLayoutFrozen()) {
        return false;
      }
      localObject = getLayoutManager();
      boolean bool3 = ((RecyclerView.LayoutManager)localObject).canScrollHorizontally();
      boolean bool2 = ((RecyclerView.LayoutManager)localObject).canScrollVertically();
      int i;
      if (bool3)
      {
        i = paramInt1;
        if (Math.abs(paramInt1) >= getMinFlingVelocity()) {}
      }
      else
      {
        i = 0;
      }
      if (bool2)
      {
        paramInt1 = paramInt2;
        if (Math.abs(paramInt2) >= getMinFlingVelocity()) {}
      }
      else
      {
        paramInt1 = 0;
      }
      if ((i == 0) && (paramInt1 == 0)) {
        return false;
      }
      float f1 = i;
      float f2 = paramInt1;
      j = i;
      k = paramInt1;
      if (!dispatchNestedPreFling(f1, f2))
      {
        if ((bool3) || (bool2)) {
          bool1 = true;
        }
        dispatchNestedFling(f1, f2, bool1);
        localObject = this.mOnFlingListener;
        if ((localObject != null) && (((RecyclerViewCompat.OnCompatFlingListener)localObject).onFling(f1, f2))) {
          return true;
        }
        this.mIsInterruptedPreFling = true;
        this.mIsInterruptedFling = true;
        return super.fling(i, paramInt1);
      }
    }
    return super.fling(j, k);
  }
  
  public RecyclerViewCompat.OnCompatFlingListener getOnCompatFlingListener()
  {
    return this.mOnFlingListener;
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    super.setAdapter(paramAdapter);
  }
  
  public void setOnCompatFlingListener(RecyclerViewCompat.OnCompatFlingListener paramOnCompatFlingListener)
  {
    this.mOnFlingListener = paramOnCompatFlingListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.RecyclerViewCompat
 * JD-Core Version:    0.7.0.1
 */