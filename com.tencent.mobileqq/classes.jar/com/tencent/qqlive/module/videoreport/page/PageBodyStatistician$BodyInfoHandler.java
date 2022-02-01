package com.tencent.qqlive.module.videoreport.page;

import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;

class PageBodyStatistician$BodyInfoHandler
{
  private PageBodyInfo mPageBodyInfo = new PageBodyInfo();
  private PageInfo mPageInfo;
  private IScrollReader mScrollReader;
  private View mView;
  
  PageBodyStatistician$BodyInfoHandler(View paramView, IScrollReader paramIScrollReader)
  {
    this.mView = paramView;
    this.mScrollReader = ((IScrollReader)BaseUtils.nullAs(paramIScrollReader, ScrollReader.getScrollReader(paramView)));
    ScrollReader.injectScrollListener(this.mView, new PageBodyStatistician.BodyInfoHandler.1(this));
  }
  
  private void readInitScroll()
  {
    ThreadUtils.runOnUiThread(new PageBodyStatistician.BodyInfoHandler.2(this));
  }
  
  private void transferDataToPage()
  {
    if (this.mPageInfo == null) {}
    for (Object localObject = null;; localObject = this.mPageInfo.getPage())
    {
      if (localObject != null) {
        DataRWProxy.setInnerParam(localObject, "page_body_info", this.mPageBodyInfo);
      }
      return;
    }
  }
  
  private void tryGetPageInfo()
  {
    if (this.mPageInfo == null) {
      this.mPageInfo = PageFinder.findOwnerPage(this.mView);
    }
  }
  
  private boolean updateProgress(PageBodyInfo paramPageBodyInfo, int paramInt)
  {
    int j = paramPageBodyInfo.getRangeStart();
    int k = paramPageBodyInfo.getRangeEnd();
    int i = paramPageBodyInfo.getPageArea();
    paramInt = Math.max(j, Math.min(k, paramInt)) - j + 1;
    if (i == 0) {}
    for (double d = 0.0D; d > paramPageBodyInfo.getProgressRate(); d = paramInt / i)
    {
      paramPageBodyInfo.setProgressArea(paramInt);
      paramPageBodyInfo.setProgressRate(d);
      return true;
    }
    return false;
  }
  
  public void onScrolled(int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageBodyStatistician", "BodyInfoHandler.onScrolled: scrollEnd = " + paramInt);
    }
    if (updateProgress(this.mPageBodyInfo, paramInt))
    {
      tryGetPageInfo();
      transferDataToPage();
    }
  }
  
  void updateRange(int paramInt1, int paramInt2)
  {
    this.mPageBodyInfo.setRangeStart(paramInt1);
    this.mPageBodyInfo.setRangeEnd(paramInt2);
    this.mPageBodyInfo.setPageArea(Math.max(0, paramInt2 - paramInt1 + 1));
    tryGetPageInfo();
    transferDataToPage();
    readInitScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageBodyStatistician.BodyInfoHandler
 * JD-Core Version:    0.7.0.1
 */