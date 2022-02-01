package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import java.util.List;

class ReadInJoyDailyViewController$4
  extends ReadInJoyObserver
{
  ReadInJoyDailyViewController$4(ReadInJoyDailyViewController paramReadInJoyDailyViewController) {}
  
  public void a(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyDailyViewController.c(this.a) != null) && ((ReadInJoyDailyViewController.c(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.c(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if ((ReadInJoyDailyViewController.c(this.a) != null) && ((ReadInJoyDailyViewController.c(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.c(this.a)).a(paramTopBannerInfo);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyDailyViewController.c(this.a) != null) && ((ReadInJoyDailyViewController.c(this.a) instanceof ReadInJoyListViewGroup)) && (paramInt == ReadInJoyDailyViewController.d(this.a)))
    {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.c(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
      ReadInJoyDailyViewController.e(this.a);
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyDailyViewController.c(this.a) != null) && ((ReadInJoyDailyViewController.c(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.c(this.a)).c(paramInt, paramList);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyDailyViewController.c(this.a) != null) && ((ReadInJoyDailyViewController.c(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.c(this.a)).b(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyDailyViewController.c(this.a) != null) && ((ReadInJoyDailyViewController.c(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.c(this.a)).b(paramInt, paramList);
    }
  }
  
  public void cE_()
  {
    if ((ReadInJoyDailyViewController.c(this.a) != null) && ((ReadInJoyDailyViewController.c(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.c(this.a)).n();
    }
  }
  
  public void d(int paramInt, List<ChannelBannerInfo> paramList)
  {
    if ((ReadInJoyDailyViewController.c(this.a) instanceof ReadInJoyListViewGroup))
    {
      FrameworkHandler localFrameworkHandler = (FrameworkHandler)((ReadInJoyListViewGroup)ReadInJoyDailyViewController.c(this.a)).getInvokeHandler().a(2);
      if (localFrameworkHandler != null) {
        localFrameworkHandler.b(paramInt, paramList);
      }
    }
  }
  
  public void o_(int paramInt)
  {
    if ((ReadInJoyDailyViewController.c(this.a) != null) && ((ReadInJoyDailyViewController.c(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.c(this.a)).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyViewController.4
 * JD-Core Version:    0.7.0.1
 */