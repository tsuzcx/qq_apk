package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;

class ReadInJoyDynamicChannelFragment$2
  implements XRecyclerView.RefreshCallback
{
  ReadInJoyDynamicChannelFragment$2(ReadInJoyDynamicChannelFragment paramReadInJoyDynamicChannelFragment) {}
  
  public void endOfRefresh()
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "endRefresh.");
  }
  
  public void startLoadMore(XRecyclerView paramXRecyclerView, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "startLoadMore.");
    if (ReadInJoyDynamicChannelFragment.h(this.a) == 40830) {
      paramInt = ReadInJoyDynamicChannelFragment.i(this.a);
    } else {
      paramInt = 1;
    }
    ReadInJoyLogicEngine.a().a(ReadInJoyDynamicChannelFragment.j(this.a), ReadInJoyDynamicChannelFragment.k(this.a), 2, 0, paramInt);
  }
  
  public void startTopRefresh(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "startTopRefresh.");
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 3;
    }
    this.a.c(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment.2
 * JD-Core Version:    0.7.0.1
 */