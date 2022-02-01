package com.tencent.mobileqq.flashshow.personal.widget;

import androidx.recyclerview.widget.RecyclerView;

class FSRefreshHeaderView$4
  implements Runnable
{
  FSRefreshHeaderView$4(FSRefreshHeaderView paramFSRefreshHeaderView, RecyclerView paramRecyclerView) {}
  
  public void run()
  {
    RecyclerView localRecyclerView = this.a;
    if (localRecyclerView != null) {
      localRecyclerView.scrollToPosition(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSRefreshHeaderView.4
 * JD-Core Version:    0.7.0.1
 */