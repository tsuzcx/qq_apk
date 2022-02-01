package com.tencent.pts.support;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;

public class RecyclerViewCompat
  extends RecyclerView
{
  private static final String TAG = "RecyclerViewCompat";
  private boolean mIsInterruptedFling = false;
  private boolean mIsInterruptedPreFling = false;
  private RecyclerViewCompat.OnFlingListener mOnFlingListener;
  
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
    boolean bool1 = false;
    int j = paramInt1;
    int k = paramInt2;
    if (this.mOnFlingListener != null)
    {
      if (getLayoutManager() == null) {}
      boolean bool3;
      boolean bool2;
      int i;
      do
      {
        do
        {
          return false;
        } while (isLayoutFrozen());
        RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
        bool3 = localLayoutManager.canScrollHorizontally();
        bool2 = localLayoutManager.canScrollVertically();
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
      } while ((i == 0) && (paramInt1 == 0));
      j = i;
      k = paramInt1;
      if (!dispatchNestedPreFling(i, paramInt1))
      {
        if ((bool3) || (bool2)) {
          bool1 = true;
        }
        dispatchNestedFling(i, paramInt1, bool1);
        if ((this.mOnFlingListener != null) && (this.mOnFlingListener.onFling(i, paramInt1))) {
          return true;
        }
        this.mIsInterruptedPreFling = true;
        this.mIsInterruptedFling = true;
        return super.fling(i, paramInt1);
      }
    }
    return super.fling(j, k);
  }
  
  public RecyclerViewCompat.OnFlingListener getOnFlingListenerCompat()
  {
    return this.mOnFlingListener;
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    super.setAdapter(paramAdapter);
  }
  
  public void setOnFlingListenerCompat(RecyclerViewCompat.OnFlingListener paramOnFlingListener)
  {
    this.mOnFlingListener = paramOnFlingListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.support.RecyclerViewCompat
 * JD-Core Version:    0.7.0.1
 */