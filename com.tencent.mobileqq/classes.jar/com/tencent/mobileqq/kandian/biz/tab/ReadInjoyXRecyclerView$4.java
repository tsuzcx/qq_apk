package com.tencent.mobileqq.kandian.biz.tab;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;

class ReadInjoyXRecyclerView$4
  extends RecyclerView.OnScrollListener
{
  ReadInjoyXRecyclerView$4(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (ReadInjoyXRecyclerView.c(this.a) == 2)) {
      ReadInjoyXRecyclerView.d(this.a);
    }
    int j = paramRecyclerView.getChildCount();
    boolean bool = paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager;
    int i = 0;
    if (bool)
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      i = paramRecyclerView.getItemCount();
      paramRecyclerView = paramRecyclerView.findFirstVisibleItemPositions(null);
      int k = ReadInjoyXRecyclerView.e(this.a).getProLoaderCount();
      if (i - j <= paramRecyclerView[0] + k) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("XRecyclerView", 2, new Object[] { "totalItemCount=%d, firstVisibleItem=%d, visibleThreshold=%d, isCloseToTheEnd=%b", Integer.valueOf(i), Integer.valueOf(paramRecyclerView[0]), Integer.valueOf(k), Boolean.valueOf(bool) });
      }
      if (bool) {
        ReadInjoyXRecyclerView.e(this.a).setLoadMore(true);
      }
    }
    else if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
    {
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
      if (paramRecyclerView.getItemCount() - j <= paramRecyclerView.findFirstVisibleItemPosition() + ReadInjoyXRecyclerView.e(this.a).getProLoaderCount()) {
        i = 1;
      }
      if (i != 0) {
        ReadInjoyXRecyclerView.e(this.a).setLoadMore(true);
      }
    }
    ReadInjoyXRecyclerView.c(this.a, paramInt);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = this.a;
    ReadInjoyXRecyclerView.a(paramRecyclerView, ReadInjoyXRecyclerView.a(paramRecyclerView) + paramInt1);
    paramRecyclerView = this.a;
    ReadInjoyXRecyclerView.b(paramRecyclerView, ReadInjoyXRecyclerView.b(paramRecyclerView) + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView.4
 * JD-Core Version:    0.7.0.1
 */