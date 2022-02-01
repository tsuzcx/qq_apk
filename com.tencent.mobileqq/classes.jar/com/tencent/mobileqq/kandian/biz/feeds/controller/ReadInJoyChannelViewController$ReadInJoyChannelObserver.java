package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.content.res.Configuration;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import java.util.List;

class ReadInJoyChannelViewController$ReadInJoyChannelObserver
  extends ReadInJoyObserver
{
  private ReadInJoyChannelViewController$ReadInJoyChannelObserver(ReadInJoyChannelViewController paramReadInJoyChannelViewController) {}
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramInt, paramAbsBaseArticleInfo, paramString1, paramString2);
    }
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((ReadInJoyChannelViewController.b(this.a) == 56) && (ReadInJoyChannelViewController.c(this.a) != null))
    {
      ReadInJoyChannelViewController.c(this.a).l();
      ReadInJoyChannelViewController.c(this.a).m();
    }
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramConfiguration);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramTopBannerInfo);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<AbsBaseArticleInfo> paramList1)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramBoolean, paramInt, paramLong, paramList, paramList1);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).c(paramInt, paramList);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).b(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).b(paramInt, paramList);
    }
  }
  
  public void cE_()
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).n();
    }
  }
  
  public void d(int paramInt, List<ChannelBannerInfo> paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))
    {
      FrameworkHandler localFrameworkHandler = (FrameworkHandler)((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).getInvokeHandler().a(2);
      if (localFrameworkHandler != null) {
        localFrameworkHandler.b(paramInt, paramList);
      }
    }
  }
  
  public void o_(int paramInt)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController.ReadInJoyChannelObserver
 * JD-Core Version:    0.7.0.1
 */