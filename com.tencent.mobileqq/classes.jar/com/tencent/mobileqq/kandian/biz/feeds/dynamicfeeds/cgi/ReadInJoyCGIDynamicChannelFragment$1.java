package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi;

import android.content.res.Resources;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.DataObserver;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.HeaderDataModel;
import com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.List;

class ReadInJoyCGIDynamicChannelFragment$1
  extends DataObserver
{
  ReadInJoyCGIDynamicChannelFragment$1(ReadInJoyCGIDynamicChannelFragment paramReadInJoyCGIDynamicChannelFragment) {}
  
  public void a(int paramInt, List<DynamicChannelDataModel> paramList)
  {
    if (paramInt != ReadInJoyCGIDynamicChannelFragment.a(this.a)) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      ReadInJoyCGIDynamicChannelFragment.a(this.a).a(paramList);
      ReadInJoyCGIDynamicChannelFragment.a(this.a).loadMoreComplete(true, true);
      return;
    }
    ReadInJoyCGIDynamicChannelFragment.b(this.a).startMachineRefresh();
  }
  
  public void a(int paramInt1, boolean paramBoolean, List<HeaderDataModel> paramList, int paramInt2)
  {
    if (paramInt1 != ReadInJoyCGIDynamicChannelFragment.d(this.a)) {
      return;
    }
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      ReadInJoyCGIDynamicChannelFragment.a(this.a, paramInt1, paramList);
    }
    int i = 0;
    if (paramList != null) {
      i = paramList.size();
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "onHeaderRefreshed, channelID = ", Integer.valueOf(paramInt1), ", success = ", Boolean.valueOf(paramBoolean), ", size = ", Integer.valueOf(i), ", insertIndex = ", Integer.valueOf(paramInt2) });
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    if (paramInt != ReadInJoyCGIDynamicChannelFragment.b(this.a)) {
      return;
    }
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    String str;
    if ((paramBoolean1) && (i > 0)) {
      str = String.format(this.a.getResources().getString(2131717753), new Object[] { Integer.valueOf(i) });
    } else {
      str = this.a.getResources().getString(2131717752);
    }
    ReadInJoyCGIDynamicChannelFragment.c(this.a).showRefreshResult(paramBoolean1, str);
    if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0)) {
      ReadInJoyCGIDynamicChannelFragment.a(this.a).a(paramList);
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "onDataRefreshed, channelID = ", Integer.valueOf(paramInt), ", success = ", Boolean.valueOf(paramBoolean1), ", refreshSize = ", Integer.valueOf(i) });
    ReadInJoyCGIDynamicChannelFragment.d(this.a).loadMoreComplete(true, true);
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    if (paramInt != ReadInJoyCGIDynamicChannelFragment.c(this.a)) {
      return;
    }
    int i = 0;
    if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0))
    {
      ReadInJoyCGIDynamicChannelFragment.a(this.a).b(paramList);
      ReadInJoyCGIDynamicChannelFragment.e(this.a).loadMoreComplete(true, paramBoolean2);
    }
    else
    {
      ReadInJoyCGIDynamicChannelFragment.f(this.a).loadMoreComplete(false, true);
    }
    if (paramList != null) {
      i = paramList.size();
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "onLoadMoreData, channelID = ", Integer.valueOf(paramInt), ", success = ", Boolean.valueOf(paramBoolean1), ", size = ", Integer.valueOf(i), ", hasMore = ", Boolean.valueOf(paramBoolean2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment.1
 * JD-Core Version:    0.7.0.1
 */