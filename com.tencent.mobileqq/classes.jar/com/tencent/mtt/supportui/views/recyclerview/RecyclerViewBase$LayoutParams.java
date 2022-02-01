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
    if (this.mViewHolder == null) {
      return 0;
    }
    return this.mViewHolder.mPosition;
  }
  
  public boolean isItemRemoved()
  {
    if (this.mViewHolder == null) {
      return true;
    }
    return this.mViewHolder.isRemoved();
  }
  
  public boolean isViewInvalid()
  {
    if (this.mViewHolder == null) {
      return false;
    }
    return this.mViewHolder.isInvalid();
  }
  
  public boolean viewNeedsUpdate()
  {
    if (this.mViewHolder == null) {
      return false;
    }
    return this.mViewHolder.needsUpdate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutParams
 * JD-Core Version:    0.7.0.1
 */