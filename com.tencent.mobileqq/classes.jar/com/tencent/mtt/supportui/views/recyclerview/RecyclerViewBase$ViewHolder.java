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
    if (paramView == null) {
      throw new IllegalArgumentException("itemView may not be null");
    }
    this.itemView = paramView;
  }
  
  public void addFlags(int paramInt)
  {
    this.mFlags |= paramInt;
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
    if (this.mOldPosition == -2147483648) {
      return this.mPosition;
    }
    return this.mOldPosition;
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
    this.mFlags = (this.mFlags & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void setIsRecyclable(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = this.mIsRecyclableCount - 1;
      this.mIsRecyclableCount = i;
      if (this.mIsRecyclableCount >= 0) {
        break label39;
      }
      this.mIsRecyclableCount = 0;
    }
    label39:
    do
    {
      return;
      i = this.mIsRecyclableCount + 1;
      break;
      if ((!paramBoolean) && (this.mIsRecyclableCount == 1))
      {
        this.mFlags |= 0x10;
        return;
      }
    } while ((!paramBoolean) || (this.mIsRecyclableCount != 0));
    this.mFlags &= 0xFFFFFFEF;
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
    StringBuilder localStringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId);
    if (isScrap()) {
      localStringBuilder.append(" scrap");
    }
    if (isInvalid()) {
      localStringBuilder.append(" invalid");
    }
    if (!isBound()) {
      localStringBuilder.append(" unbound");
    }
    if (needsUpdate()) {
      localStringBuilder.append(" updateStyle");
    }
    if (isRemoved()) {
      localStringBuilder.append(" removed");
    }
    localStringBuilder.append(" type=" + this.mItemViewType);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  void unScrap()
  {
    this.mScrapContainer.unscrapView(this);
    this.mScrapContainer = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewHolder
 * JD-Core Version:    0.7.0.1
 */