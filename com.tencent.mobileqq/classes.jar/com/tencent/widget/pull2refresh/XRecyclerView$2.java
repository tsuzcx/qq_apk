package com.tencent.widget.pull2refresh;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;

class XRecyclerView$2
  extends RecyclerView.OnScrollListener
{
  XRecyclerView$2(XRecyclerView paramXRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (XRecyclerView.access$200(this.this$0) == 2)) {
      this.this$0.rebound();
    }
    int j = paramRecyclerView.getChildCount();
    boolean bool = paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager;
    int i = 0;
    if (bool)
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      i = paramRecyclerView.getItemCount();
      paramRecyclerView = paramRecyclerView.findFirstVisibleItemPositions(null);
      int k = XRecyclerView.access$300(this.this$0).getProLoaderCount();
      if (i - j <= paramRecyclerView[0] + k) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("XRecyclerView", 2, new Object[] { "totalItemCount=%d, firstVisibleItem=%d, visibleThreshold=%d, isCloseToTheEnd=%b", Integer.valueOf(i), Integer.valueOf(paramRecyclerView[0]), Integer.valueOf(k), Boolean.valueOf(bool) });
      }
      if (bool) {
        XRecyclerView.access$300(this.this$0).setLoadMore(true);
      }
    }
    else if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
    {
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
      if (paramRecyclerView.getItemCount() - j <= paramRecyclerView.findFirstVisibleItemPosition() + XRecyclerView.access$300(this.this$0).getProLoaderCount()) {
        i = 1;
      }
      if (i != 0) {
        XRecyclerView.access$300(this.this$0).setLoadMore(true);
      }
    }
    XRecyclerView.access$202(this.this$0, paramInt);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = this.this$0;
    XRecyclerView.access$002(paramRecyclerView, XRecyclerView.access$000(paramRecyclerView) + paramInt1);
    paramRecyclerView = this.this$0;
    XRecyclerView.access$102(paramRecyclerView, XRecyclerView.access$100(paramRecyclerView) + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.XRecyclerView.2
 * JD-Core Version:    0.7.0.1
 */