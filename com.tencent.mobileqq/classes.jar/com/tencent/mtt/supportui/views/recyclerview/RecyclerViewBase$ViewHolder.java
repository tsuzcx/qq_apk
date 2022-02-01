package com.tencent.mtt.supportui.views.recyclerview;

import android.view.View;

public abstract class RecyclerViewBase$ViewHolder
{
  protected static final int FLAG_BOUND = 1;
  protected static final int FLAG_INVALID = 4;
  static final int FLAG_NOT_RECYCLABLE = 16;
  static final int FLAG_REMOVED = 8;
  public static final int FLAG_UPDATE = 2;
  public static final int TYPE_CUSTOM_FOOTER = 5;
  public static final int TYPE_CUSTOM_HEADERE = 4;
  public static final int TYPE_FOOTER = 2;
  public static final int TYPE_HEADERE = 1;
  public static final int TYPE_NORMAL = 3;
  public final View itemView;
  public boolean mBindNextTime = false;
  public View mContent;
  public ContentHolder mContentHolder;
  protected int mFlags;
  public boolean mForceBind = false;
  public String mHolderReuseKey = null;
  int mIsRecyclableCount = 0;
  public long mItemId = -1L;
  public int mItemViewType = -1;
  public int mOldPosition = -2147483648;
  protected RecyclerViewBase mParent;
  public boolean mPosDirty;
  public int mPosition = -2147483648;
  RecyclerViewBase.Recycler mScrapContainer = null;
  public int mViewType = 3;
  
  public RecyclerViewBase$ViewHolder(View paramView, RecyclerViewBase paramRecyclerViewBase)
  {
    this.mParent = paramRecyclerViewBase;
    if (paramView != null)
    {
      this.itemView = paramView;
      return;
    }
    throw new IllegalArgumentException("itemView may not be null");
  }
  
  public void addFlags(int paramInt)
  {
    this.mFlags = (paramInt | this.mFlags);
  }
  
  public boolean canChangeOrder()
  {
    return false;
  }
  
  public void clearFlagsForSharedPool()
  {
    this.mFlags = 0;
  }
  
  void clearOldPosition()
  {
    this.mOldPosition = -2147483648;
  }
  
  public final long getItemId()
  {
    return this.mItemId;
  }
  
  public final int getItemViewType()
  {
    return this.mItemViewType;
  }
  
  public int getPosition()
  {
    int j = this.mOldPosition;
    int i = j;
    if (j == -2147483648) {
      i = this.mPosition;
    }
    return i;
  }
  
  public abstract void inTraversals(int paramInt);
  
  public boolean isBound()
  {
    return (this.mFlags & 0x1) != 0;
  }
  
  public boolean isInvalid()
  {
    return (this.mFlags & 0x4) != 0;
  }
  
  public final boolean isRecyclable()
  {
    return (this.mFlags & 0x10) == 0;
  }
  
  public boolean isRemoved()
  {
    return (this.mFlags & 0x8) != 0;
  }
  
  boolean isScrap()
  {
    return this.mScrapContainer != null;
  }
  
  public boolean needsUpdate()
  {
    return (this.mFlags & 0x2) != 0;
  }
  
  public void offsetPosition(int paramInt)
  {
    if (this.mOldPosition == -2147483648) {
      this.mOldPosition = this.mPosition;
    }
    this.mPosition += paramInt;
  }
  
  void setFlags(int paramInt1, int paramInt2)
  {
    this.mFlags = (paramInt1 & paramInt2 | this.mFlags & (paramInt2 ^ 0xFFFFFFFF));
  }
  
  public final void setIsRecyclable(boolean paramBoolean)
  {
    if (paramBoolean) {
      i = this.mIsRecyclableCount - 1;
    } else {
      i = this.mIsRecyclableCount + 1;
    }
    this.mIsRecyclableCount = i;
    int i = this.mIsRecyclableCount;
    if (i < 0)
    {
      this.mIsRecyclableCount = 0;
      return;
    }
    if ((!paramBoolean) && (i == 1)) {}
    for (i = this.mFlags | 0x10;; i = this.mFlags & 0xFFFFFFEF)
    {
      this.mFlags = i;
      return;
      if ((!paramBoolean) || (this.mIsRecyclableCount != 0)) {
        break;
      }
    }
  }
  
  public final void setItemViewType(int paramInt)
  {
    this.mItemViewType = paramInt;
  }
  
  public void setScrapContainer(RecyclerViewBase.Recycler paramRecycler)
  {
    this.mScrapContainer = paramRecycler;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("ViewHolder{");
    localStringBuilder1.append(Integer.toHexString(hashCode()));
    localStringBuilder1.append(" position=");
    localStringBuilder1.append(this.mPosition);
    localStringBuilder1.append(" id=");
    localStringBuilder1.append(this.mItemId);
    localStringBuilder1 = new StringBuilder(localStringBuilder1.toString());
    if (isScrap()) {
      localStringBuilder1.append(" scrap");
    }
    if (isInvalid()) {
      localStringBuilder1.append(" invalid");
    }
    if (!isBound()) {
      localStringBuilder1.append(" unbound");
    }
    if (needsUpdate()) {
      localStringBuilder1.append(" updateStyle");
    }
    if (isRemoved()) {
      localStringBuilder1.append(" removed");
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" type=");
    localStringBuilder2.append(this.mItemViewType);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("}");
    return localStringBuilder1.toString();
  }
  
  void unScrap()
  {
    this.mScrapContainer.unscrapView(this);
    this.mScrapContainer = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewHolder
 * JD-Core Version:    0.7.0.1
 */