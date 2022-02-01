package com.tencent.mobileqq.multicard;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class MultiCardRecommendFragment$1
  extends RecyclerView.OnScrollListener
{
  MultiCardRecommendFragment$1(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (MultiCardRecommendFragment.a(this.a) != null)
    {
      if ((paramInt != 0) && (paramInt != 1))
      {
        MultiCardRecommendFragment.b(this.a);
      }
      else
      {
        MultiCardRecommendFragment.c(this.a);
        MultiCardRecommendFragment.d(this.a);
      }
      if (paramInt == 0) {
        MultiCardRecommendFragment.e(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment.1
 * JD-Core Version:    0.7.0.1
 */