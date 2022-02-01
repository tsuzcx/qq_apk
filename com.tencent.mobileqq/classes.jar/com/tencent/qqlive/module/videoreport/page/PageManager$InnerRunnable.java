package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;

class PageManager$InnerRunnable
  implements Runnable
{
  PageInfo pageInfo;
  
  private PageManager$InnerRunnable(PageManager paramPageManager) {}
  
  private boolean isPageVisible(@NonNull PageInfo paramPageInfo)
  {
    View localView = paramPageInfo.getPageView();
    if (localView == null) {}
    double d1;
    double d2;
    do
    {
      return false;
      d1 = VideoReportInner.getInstance().getConfiguration().getPageExposureMinRate();
      d2 = UIUtils.getViewExposureRate(localView);
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.i("PageManager", "isPageVisible: pageInfo = " + paramPageInfo + ", exposureMinRate = " + d1 + ", exposureRate = " + d2);
      }
    } while ((d2 <= 0.0D) || (d2 < d1));
    return true;
  }
  
  public void run()
  {
    if (!isPageVisible(this.pageInfo)) {
      return;
    }
    if ((!PageManager.access$400(this.this$0)) && (PageManager.access$500(this.this$0) != null) && (PageManager.access$500(this.this$0).getPage() != this.pageInfo.getPage())) {
      PageManager.access$600(this.this$0, this.pageInfo, PageManager.access$500(this.this$0), false);
    }
    PageInfo localPageInfo = PageManager.access$500(this.this$0);
    PageManager.access$502(this.this$0, this.pageInfo);
    if (PageManager.access$700(this.this$0, this.pageInfo, localPageInfo, PageManager.access$400(this.this$0))) {
      PageManager.access$800(this.this$0, this.pageInfo, localPageInfo);
    }
    for (;;)
    {
      PageManager.access$402(this.this$0, false);
      return;
      PageManager.access$900(this.this$0, this.pageInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageManager.InnerRunnable
 * JD-Core Version:    0.7.0.1
 */