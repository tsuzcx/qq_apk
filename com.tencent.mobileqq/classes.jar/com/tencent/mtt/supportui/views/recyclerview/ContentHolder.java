package com.tencent.mtt.supportui.views.recyclerview;

import android.view.View;

public class ContentHolder
{
  public int mContentLeftPadding = 0;
  public View mContentView;
  public boolean mFocusable = true;
  public boolean mForceBind = false;
  public int mItemPaddingLeft = 0;
  public int mItemPaddingRight = 0;
  public Object mParentViewHolder;
  
  public void inTraversals(int paramInt1, int paramInt2, RecyclerViewBase paramRecyclerViewBase) {}
  
  public void setEnable(boolean paramBoolean)
  {
    View localView = this.mContentView;
    if ((localView != null) && (localView.getParent() != null)) {
      ((View)this.mContentView.getParent()).setEnabled(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.ContentHolder
 * JD-Core Version:    0.7.0.1
 */