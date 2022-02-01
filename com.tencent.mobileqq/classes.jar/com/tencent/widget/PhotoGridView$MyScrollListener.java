package com.tencent.widget;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class PhotoGridView$MyScrollListener
  extends RecyclerView.OnScrollListener
{
  PhotoGridView$MyScrollListener(PhotoGridView paramPhotoGridView) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt) {}
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (this.this$0.mIsScrolling)
    {
      if (this.this$0.mIsScrollingFromTop)
      {
        paramRecyclerView = this.this$0;
        paramRecyclerView.mEndSelectPosition = paramRecyclerView.gridLayoutManager.findLastVisibleItemPosition();
      }
      else
      {
        paramRecyclerView = this.this$0;
        paramRecyclerView.mEndSelectPosition = paramRecyclerView.gridLayoutManager.findFirstCompletelyVisibleItemPosition();
      }
      this.this$0.mOnSelectChangedListener.onSelectChanged(this.this$0.mBeginSelectPosition, this.this$0.mEndSelectPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.PhotoGridView.MyScrollListener
 * JD-Core Version:    0.7.0.1
 */