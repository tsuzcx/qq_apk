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
    int k = 0;
    int i;
    VRecyclerView localVRecyclerView;
    int j;
    if (paramInt == 0)
    {
      if ((VRecyclerView.access$200(this.this$0) != null) && (!VRecyclerView.access$200(this.this$0).isSnapping())) {
        VRecyclerView.access$302(this.this$0, 0);
      }
      boolean bool = VRecyclerView.access$400(this.this$0);
      this.this$0.calAndSetContentOffset(bool, 0.0F, 0.0F);
      i = this.this$0.getLastVisibleItemPosition();
      if ((this.this$0.getAdapter() != null) && (i != -1) && (i == this.this$0.getAdapter().getItemCount() - 1) && (!VRecyclerView.access$500(this.this$0)) && (VRecyclerView.access$600(this.this$0) != null))
      {
        VRecyclerView.access$502(this.this$0, true);
        VRecyclerView.access$600(this.this$0).onLoadMore(this.this$0, 0, VRecyclerView.access$700(this.this$0));
        ViolaLogUtils.d("VRecyclerView", "hit load more in onScrollStateChanged");
      }
      VRecyclerView.access$800(this.this$0, false);
      if (VRecyclerView.access$600(this.this$0) != null)
      {
        paramRecyclerView = VRecyclerView.access$600(this.this$0);
        localVRecyclerView = this.this$0;
        if (bool)
        {
          i = 0;
          if (!bool) {
            break label289;
          }
          j = VRecyclerView.access$700(this.this$0);
          label211:
          paramRecyclerView.onScrollEnd(localVRecyclerView, i, j);
        }
      }
      else
      {
        VRecyclerView.access$1002(this.this$0, false);
        label231:
        if (VRecyclerView.access$600(this.this$0) != null)
        {
          paramRecyclerView = VRecyclerView.access$600(this.this$0);
          localVRecyclerView = this.this$0;
          if (this.this$0.canChildPullDown()) {
            break label317;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      paramRecyclerView.onScrollStateChanged(localVRecyclerView, paramInt, i);
      return;
      i = VRecyclerView.access$900(this.this$0);
      break;
      label289:
      j = 0;
      break label211;
      if ((paramInt != 2) && (paramInt != 1)) {
        break label231;
      }
      VRecyclerView.access$1002(this.this$0, true);
      break label231;
      label317:
      i = k;
      if (!this.this$0.canChildPullUp()) {
        i = 2;
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.this$0.performOnScroll(paramInt1, paramInt2);
    VRecyclerView.access$1100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.VRecyclerView.ScrollListener
 * JD-Core Version:    0.7.0.1
 */