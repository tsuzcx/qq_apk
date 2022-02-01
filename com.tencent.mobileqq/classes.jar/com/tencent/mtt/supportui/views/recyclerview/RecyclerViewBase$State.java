package com.tencent.mtt.supportui.views.recyclerview;

import android.util.SparseArray;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;

public class RecyclerViewBase$State
{
  public int mCustomFooterHeight = 0;
  public int mCustomFooterWidth = 0;
  public int mCustomHeaderHeight = 0;
  public int mCustomHeaderWidth = 0;
  SparseArray<Object> mData;
  public boolean mDataChanged = false;
  int mDeletedInvisibleItemCountSincePreviousLayout = 0;
  public int mFooterCount = 0;
  public int mFooterCountInScreen = 0;
  public int mHeaderCount = 0;
  public int mHeaderCountInScreen = 0;
  boolean mInPreLayout = false;
  public int mItemCount = 0;
  ArrayMap<RecyclerViewBase.ViewHolder, RecyclerViewBase.ItemHolderInfo> mPostLayoutHolderMap = new ArrayMap();
  ArrayMap<RecyclerViewBase.ViewHolder, RecyclerViewBase.ItemHolderInfo> mPreLayoutHolderMap = new ArrayMap();
  int mPreviousLayoutItemCount = 0;
  boolean mStructureChanged = false;
  int mTargetPosition = -2147483648;
  public int mTotalHeight;
  public boolean overscroll = true;
  
  public boolean didStructureChange()
  {
    return this.mStructureChanged;
  }
  
  public <T> T get(int paramInt)
  {
    if (this.mData == null) {
      return null;
    }
    return this.mData.get(paramInt);
  }
  
  public int getItemCount()
  {
    if (this.mInPreLayout) {
      return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
    }
    return this.mItemCount;
  }
  
  public int getTargetScrollPosition()
  {
    return this.mTargetPosition;
  }
  
  public boolean hasTargetScrollPosition()
  {
    return this.mTargetPosition != -2147483648;
  }
  
  public boolean isPreLayout()
  {
    return this.mInPreLayout;
  }
  
  public void put(int paramInt, Object paramObject)
  {
    if (this.mData == null) {
      this.mData = new SparseArray();
    }
    this.mData.put(paramInt, paramObject);
  }
  
  public void remove(int paramInt)
  {
    if (this.mData == null) {
      return;
    }
    this.mData.remove(paramInt);
  }
  
  State reset()
  {
    this.mTargetPosition = -2147483648;
    if (this.mData != null) {
      this.mData.clear();
    }
    this.mItemCount = 0;
    this.mHeaderCount = 0;
    this.mFooterCount = 0;
    this.mStructureChanged = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.State
 * JD-Core Version:    0.7.0.1
 */