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
  int invokeFrom = 0;
  PageInfo pageInfo;
  
  private PageManager$InnerRunnable(PageManager paramPageManager) {}
  
  private boolean isPageVisible(@NonNull PageInfo paramPageInfo)
  {
    Object localObject = paramPageInfo.getPageView();
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    double d1 = VideoReportInner.getInstance().getConfiguration().getPageExposureMinRate();
    double d2 = UIUtils.getViewExposureRate((View)localObject);
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isPageVisible: pageInfo = ");
      ((StringBuilder)localObject).append(paramPageInfo);
      ((StringBuilder)localObject).append(", exposureMinRate = ");
      ((StringBuilder)localObject).append(d1);
      ((StringBuilder)localObject).append(", exposureRate = ");
      ((StringBuilder)localObject).append(d2);
      Log.i("PageManager", ((StringBuilder)localObject).toString());
    }
    boolean bool1 = bool2;
    if (d2 > 0.0D)
    {
      bool1 = bool2;
      if (d2 >= d1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void run()
  {
    if (!isPageVisible(this.pageInfo)) {
      return;
    }
    if ((!PageManager.access$400(this.this$0)) && (PageManager.access$500(this.this$0) != null) && (PageManager.access$500(this.this$0).getPage() != this.pageInfo.getPage()))
    {
      localObject = this.this$0;
      PageManager.access$600((PageManager)localObject, this.pageInfo, PageManager.access$500((PageManager)localObject), false);
    }
    Object localObject = PageManager.access$500(this.this$0);
    PageManager.access$502(this.this$0, this.pageInfo);
    PageManager localPageManager = this.this$0;
    if (PageManager.access$700(localPageManager, this.pageInfo, (PageInfo)localObject, PageManager.access$400(localPageManager))) {
      PageManager.access$800(this.this$0, this.pageInfo, (PageInfo)localObject, this.invokeFrom);
    } else {
      PageManager.access$900(this.this$0, this.pageInfo, this.invokeFrom);
    }
    PageManager.access$402(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageManager.InnerRunnable
 * JD-Core Version:    0.7.0.1
 */