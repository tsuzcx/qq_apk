package com.tencent.mobileqq.flashshow.fragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

class FSPersonalFeedFragment$5
  extends RecyclerView.OnScrollListener
{
  FSPersonalFeedFragment$5(FSPersonalFeedFragment paramFSPersonalFeedFragment) {}
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (this.a.a(paramRecyclerView)) {
      paramRecyclerView.stopScroll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSPersonalFeedFragment.5
 * JD-Core Version:    0.7.0.1
 */