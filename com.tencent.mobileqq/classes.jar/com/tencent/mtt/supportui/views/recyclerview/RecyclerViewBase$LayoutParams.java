package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class RecyclerViewBase$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  protected final Rect mDecorInsets = new Rect();
  protected boolean mInsetsDirty = true;
  public RecyclerViewBase.ViewHolder mViewHolder;
  
  public RecyclerViewBase$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public RecyclerViewBase$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecyclerViewBase$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public RecyclerViewBase$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public RecyclerViewBase$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public int getViewPosition()
  {
    RecyclerViewBase.ViewHolder localViewHolder = this.mViewHolder;
    if (localViewHolder == null) {
      return 0;
    }
    return localViewHolder.mPosition;
  }
  
  public boolean isItemRemoved()
  {
    RecyclerViewBase.ViewHolder localViewHolder = this.mViewHolder;
    if (localViewHolder == null) {
      return true;
    }
    return localViewHolder.isRemoved();
  }
  
  public boolean isViewInvalid()
  {
    RecyclerViewBase.ViewHolder localViewHolder = this.mViewHolder;
    if (localViewHolder == null) {
      return false;
    }
    return localViewHolder.isInvalid();
  }
  
  public boolean viewNeedsUpdate()
  {
    RecyclerViewBase.ViewHolder localViewHolder = this.mViewHolder;
    if (localViewHolder == null) {
      return false;
    }
    return localViewHolder.needsUpdate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutParams
 * JD-Core Version:    0.7.0.1
 */