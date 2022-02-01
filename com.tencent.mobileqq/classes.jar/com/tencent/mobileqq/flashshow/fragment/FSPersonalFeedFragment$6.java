package com.tencent.mobileqq.flashshow.fragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

class FSPersonalFeedFragment$6
  extends RecyclerView.OnScrollListener
{
  FSPersonalFeedFragment$6(FSPersonalFeedFragment paramFSPersonalFeedFragment) {}
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (FSPersonalFeedFragment.c(this.a) == -1) {
      return;
    }
    if (FSPersonalFeedFragment.d(this.a))
    {
      FSPersonalFeedFragment.a(this.a, false);
      paramRecyclerView.removeOnScrollListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSPersonalFeedFragment.6
 * JD-Core Version:    0.7.0.1
 */