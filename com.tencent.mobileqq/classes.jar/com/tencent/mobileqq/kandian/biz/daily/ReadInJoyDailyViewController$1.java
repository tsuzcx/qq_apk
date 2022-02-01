package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import java.util.List;

class ReadInJoyDailyViewController$1
  extends ReadInJoyObserver
{
  ReadInJoyDailyViewController$1(ReadInJoyDailyViewController paramReadInJoyDailyViewController) {}
  
  public void a(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).a(paramTopBannerInfo);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup)) && (paramInt == ReadInJoyDailyViewController.a(this.a)))
    {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
      ReadInJoyDailyViewController.a(this.a);
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).c(paramInt, paramList);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).b(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void c()
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).n();
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).b(paramInt, paramList);
    }
  }
  
  public void d(int paramInt, List<ChannelBannerInfo> paramList)
  {
    if ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))
    {
      FrameworkHandler localFrameworkHandler = (FrameworkHandler)((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).a().a(2);
      if (localFrameworkHandler != null) {
        localFrameworkHandler.b(paramInt, paramList);
      }
    }
  }
  
  public void j_(int paramInt)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyViewController.1
 * JD-Core Version:    0.7.0.1
 */