package com.tencent.mobileqq.guild.mainframe.container.discover.subfragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.adapter.QQGuildDiscoverSubTabCommonRvAdapter;

class QQGuildDiscoverSubTabCommonFragment$2
  extends RecyclerView.OnScrollListener
{
  QQGuildDiscoverSubTabCommonFragment$2(QQGuildDiscoverSubTabCommonFragment paramQQGuildDiscoverSubTabCommonFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.l.a(8);
      return;
    }
    if (paramInt == 1)
    {
      if (paramRecyclerView.getLayoutManager().getChildCount() <= 0) {
        return;
      }
      this.a.l.a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverSubTabCommonFragment.2
 * JD-Core Version:    0.7.0.1
 */