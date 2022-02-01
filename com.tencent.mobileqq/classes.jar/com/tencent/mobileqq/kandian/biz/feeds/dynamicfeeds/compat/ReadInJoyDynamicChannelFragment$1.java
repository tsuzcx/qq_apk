package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat;

import android.content.res.Resources;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.BannerInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.List;

class ReadInJoyDynamicChannelFragment$1
  extends ReadInJoyObserver
{
  ReadInJoyDynamicChannelFragment$1(ReadInJoyDynamicChannelFragment paramReadInJoyDynamicChannelFragment) {}
  
  public void a(int paramInt, List<Long> paramList)
  {
    if (paramInt != ReadInJoyDynamicChannelFragment.a(this.a)) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      ReadInJoyDynamicChannelFragment.c(this.a).a(ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyDynamicChannelFragment.b(this.a)), paramList));
      ReadInJoyDynamicChannelFragment.d(this.a).loadMoreComplete(true, true);
    }
    else
    {
      ReadInJoyDynamicChannelFragment.e(this.a).startMachineRefresh();
    }
    paramList = ReadInJoyLogicEngine.a().i();
    if (paramList != null)
    {
      ReadInJoyDynamicChannelFragment localReadInJoyDynamicChannelFragment = this.a;
      ReadInJoyDynamicChannelFragment.a(localReadInJoyDynamicChannelFragment, paramList.a(ReadInJoyDynamicChannelFragment.f(localReadInJoyDynamicChannelFragment)));
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    ReadInJoyDynamicChannelFragment.a(this.a, paramTopBannerInfo);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt != ReadInJoyDynamicChannelFragment.g(this.a)) {
      return;
    }
    paramInt = ReadInJoyLogicEngine.a().b(Integer.valueOf(paramInt));
    String str;
    if ((paramBoolean1) && (paramInt > 0)) {
      str = String.format(this.a.getResources().getString(2131915228), new Object[] { Integer.valueOf(paramInt) });
    } else {
      str = this.a.getResources().getString(2131915227);
    }
    ReadInJoyDynamicChannelFragment.h(this.a).showRefreshResult(paramBoolean1, str);
    if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0)) {
      ReadInJoyDynamicChannelFragment.c(this.a).a(ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyDynamicChannelFragment.i(this.a)), paramList));
    }
    ReadInJoyDynamicChannelFragment.j(this.a).loadMoreComplete(true, true);
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt != ReadInJoyDynamicChannelFragment.k(this.a)) {
      return;
    }
    if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0)) {
      ReadInJoyDynamicChannelFragment.c(this.a).a(ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyDynamicChannelFragment.l(this.a)), paramList));
    }
    ReadInJoyDynamicChannelFragment.m(this.a).loadMoreComplete(paramBoolean1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment.1
 * JD-Core Version:    0.7.0.1
 */