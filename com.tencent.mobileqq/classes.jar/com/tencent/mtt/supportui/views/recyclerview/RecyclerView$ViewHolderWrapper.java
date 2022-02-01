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
    if ((paramInt == 1991102) || (paramInt == 1991103)) {
      this.mBindNextTime = true;
    }
    while (this.mContentHolder == null) {
      return;
    }
    this.mContentHolder.inTraversals(paramInt, this.mPosition, this.mParent);
  }
  
  public void setContentHolder(ContentHolder paramContentHolder)
  {
    this.mContentHolder = paramContentHolder;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("holder:" + Integer.toHexString(hashCode()) + ",pos=" + getPosition() + ",");
    if (this.mContentHolder != null) {
      localStringBuilder.append(this.mContentHolder.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerView.ViewHolderWrapper
 * JD-Core Version:    0.7.0.1
 */