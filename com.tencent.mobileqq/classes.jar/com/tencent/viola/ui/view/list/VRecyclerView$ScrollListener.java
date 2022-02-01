package com.tencent.viola.ui.view.list;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.viola.utils.ViolaLogUtils;

class VRecyclerView$ScrollListener
  extends RecyclerView.OnScrollListener
{
  private VRecyclerView$ScrollListener(VRecyclerView paramVRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int k = 2;
    int i;
    VRecyclerView localVRecyclerView;
    if (paramInt == 0)
    {
      boolean bool = VRecyclerView.access$300(this.this$0);
      this.this$0.calAndSetContentOffset(bool, 0.0F, 0.0F);
      i = this.this$0.getLastVisibleItemPosition();
      if ((this.this$0.getAdapter() != null) && (i != -1) && (i == this.this$0.getAdapter().getItemCount() - 1) && (!VRecyclerView.access$400(this.this$0)) && (VRecyclerView.access$500(this.this$0) != null))
      {
        VRecyclerView.access$402(this.this$0, true);
        paramRecyclerView = VRecyclerView.access$500(this.this$0);
        localVRecyclerView = this.this$0;
        paramRecyclerView.onLoadMore(localVRecyclerView, 0, VRecyclerView.access$600(localVRecyclerView));
        ViolaLogUtils.d("VRecyclerView", "hit load more in onScrollStateChanged");
      }
      VRecyclerView.access$700(this.this$0, false);
      if (VRecyclerView.access$500(this.this$0) != null)
      {
        paramRecyclerView = VRecyclerView.access$500(this.this$0);
        localVRecyclerView = this.this$0;
        if (bool) {
          i = 0;
        } else {
          i = VRecyclerView.access$800(localVRecyclerView);
        }
        int j;
        if (bool) {
          j = VRecyclerView.access$600(this.this$0);
        } else {
          j = 0;
        }
        paramRecyclerView.onScrollEnd(localVRecyclerView, i, j);
      }
      if ((VRecyclerView.access$900(this.this$0) != null) && (!VRecyclerView.access$900(this.this$0).isSnapping()))
      {
        this.this$0.calculateItemPreState();
        VRecyclerView.access$1002(this.this$0, 0);
      }
      VRecyclerView.access$1102(this.this$0, false);
    }
    else if ((paramInt == 2) || (paramInt == 1))
    {
      VRecyclerView.access$1102(this.this$0, true);
    }
    if (VRecyclerView.access$500(this.this$0) != null)
    {
      paramRecyclerView = VRecyclerView.access$500(this.this$0);
      localVRecyclerView = this.this$0;
      if (!localVRecyclerView.canChildPullDown()) {
        i = 1;
      } else if (!this.this$0.canChildPullUp()) {
        i = k;
      } else {
        i = 0;
      }
      paramRecyclerView.onScrollStateChanged(localVRecyclerView, paramInt, i);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.this$0.performOnScroll(paramInt1, paramInt2);
    VRecyclerView.access$1200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.VRecyclerView.ScrollListener
 * JD-Core Version:    0.7.0.1
 */