package com.tencent.viola.ui.view.list;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.viola.utils.ViolaLogUtils;

class VRecyclerView$ScrollListener
  extends RecyclerView.OnScrollListener
{
  private VRecyclerView$ScrollListener(VRecyclerView paramVRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int k = 0;
    int i;
    VRecyclerView localVRecyclerView;
    label180:
    int j;
    if (paramInt == 0)
    {
      boolean bool = VRecyclerView.access$200(this.this$0);
      this.this$0.calAndSetContentOffset(bool, 0.0F, 0.0F);
      paramRecyclerView = this.this$0.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager))
      {
        i = ((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition();
        if ((this.this$0.getAdapter() != null) && (i != -1) && (i == this.this$0.getAdapter().getItemCount() - 1) && (!VRecyclerView.access$300(this.this$0)) && (VRecyclerView.access$400(this.this$0) != null))
        {
          VRecyclerView.access$302(this.this$0, true);
          VRecyclerView.access$400(this.this$0).onLoadMore(this.this$0, 0, VRecyclerView.access$500(this.this$0));
          ViolaLogUtils.d("VRecyclerView", "hit load more in onScrollStateChanged");
        }
        VRecyclerView.access$600(this.this$0, false);
        if (VRecyclerView.access$400(this.this$0) != null)
        {
          paramRecyclerView = VRecyclerView.access$400(this.this$0);
          localVRecyclerView = this.this$0;
          if (!bool) {
            break label327;
          }
          i = 0;
          if (!bool) {
            break label338;
          }
          j = VRecyclerView.access$500(this.this$0);
          label194:
          paramRecyclerView.onScrollEnd(localVRecyclerView, i, j);
        }
        VRecyclerView.access$802(this.this$0, false);
        label214:
        if (VRecyclerView.access$400(this.this$0) != null)
        {
          paramRecyclerView = VRecyclerView.access$400(this.this$0);
          localVRecyclerView = this.this$0;
          if (this.this$0.canChildPullDown()) {
            break label366;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramRecyclerView.onScrollStateChanged(localVRecyclerView, paramInt, i);
        return;
        if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
          try
          {
            paramRecyclerView = ((StaggeredGridLayoutManager)paramRecyclerView).findLastCompletelyVisibleItemPositions(null);
            if ((paramRecyclerView != null) && (paramRecyclerView.length >= 1)) {
              i = paramRecyclerView[0];
            }
          }
          catch (Exception paramRecyclerView)
          {
            ViolaLogUtils.e("VRecyclerView", "onScrollStateChanged findLastCompletelyVisibleItemPositions error" + paramRecyclerView.getMessage());
          }
        }
      }
      i = -1;
      break;
      label327:
      i = VRecyclerView.access$700(this.this$0);
      break label180;
      label338:
      j = 0;
      break label194;
      if ((paramInt != 2) && (paramInt != 1)) {
        break label214;
      }
      VRecyclerView.access$802(this.this$0, true);
      break label214;
      label366:
      i = k;
      if (!this.this$0.canChildPullUp()) {
        i = 2;
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    VRecyclerView.access$902(this.this$0, paramInt2);
    this.this$0.performOnScroll(paramInt1, paramInt2);
    VRecyclerView.access$1000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.VRecyclerView.ScrollListener
 * JD-Core Version:    0.7.0.1
 */