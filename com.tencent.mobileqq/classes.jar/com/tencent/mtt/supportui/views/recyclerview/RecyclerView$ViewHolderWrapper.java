package com.tencent.mtt.supportui.views.recyclerview;

import android.view.View;

public class RecyclerView$ViewHolderWrapper
  extends RecyclerViewBase.ViewHolder
{
  public RecyclerView$ViewHolderWrapper(View paramView, RecyclerViewBase paramRecyclerViewBase)
  {
    super(paramView, paramRecyclerViewBase);
    if ((paramView instanceof RecyclerViewItem)) {
      this.mContent = ((RecyclerViewItem)paramView).mContentView;
    }
  }
  
  public void inTraversals(int paramInt)
  {
    if ((paramInt != 1991102) && (paramInt != 1991103))
    {
      if (this.mContentHolder != null) {
        this.mContentHolder.inTraversals(paramInt, this.mPosition, this.mParent);
      }
    }
    else {
      this.mBindNextTime = true;
    }
  }
  
  public void setContentHolder(ContentHolder paramContentHolder)
  {
    this.mContentHolder = paramContentHolder;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("holder:");
    localStringBuilder2.append(Integer.toHexString(hashCode()));
    localStringBuilder2.append(",pos=");
    localStringBuilder2.append(getPosition());
    localStringBuilder2.append(",");
    localStringBuilder1.append(localStringBuilder2.toString());
    if (this.mContentHolder != null) {
      localStringBuilder1.append(this.mContentHolder.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerView.ViewHolderWrapper
 * JD-Core Version:    0.7.0.1
 */