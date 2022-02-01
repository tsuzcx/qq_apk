package com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class QQGuildDiscoverSubTabCommonRvAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  QQGuildDiscoverSubTabCommonRvAdapter$1(QQGuildDiscoverSubTabCommonRvAdapter paramQQGuildDiscoverSubTabCommonRvAdapter, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.b.getItemViewType(paramInt) == 2) {
      return this.a.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.adapter.QQGuildDiscoverSubTabCommonRvAdapter.1
 * JD-Core Version:    0.7.0.1
 */