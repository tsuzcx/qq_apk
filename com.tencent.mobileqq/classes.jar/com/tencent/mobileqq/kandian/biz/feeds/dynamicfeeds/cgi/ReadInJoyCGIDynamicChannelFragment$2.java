package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi;

import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;

class ReadInJoyCGIDynamicChannelFragment$2
  implements XRecyclerView.RefreshCallback
{
  ReadInJoyCGIDynamicChannelFragment$2(ReadInJoyCGIDynamicChannelFragment paramReadInJoyCGIDynamicChannelFragment) {}
  
  public void endOfRefresh()
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "endOfRefresh.");
  }
  
  public void startLoadMore(XRecyclerView paramXRecyclerView, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "startLoadMore.");
    paramXRecyclerView = DynamicChannelDataModule.a();
    if (paramXRecyclerView != null) {
      paramXRecyclerView.a(ReadInJoyCGIDynamicChannelFragment.m(this.a), ReadInJoyCGIDynamicChannelFragment.b(this.a).e(), 10);
    }
  }
  
  public void startTopRefresh(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "startTopRefresh.");
    paramXRecyclerView = DynamicChannelDataModule.a();
    if (paramXRecyclerView != null) {
      paramXRecyclerView.a(ReadInJoyCGIDynamicChannelFragment.l(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment.2
 * JD-Core Version:    0.7.0.1
 */