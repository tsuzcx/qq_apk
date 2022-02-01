package com.tencent.qqlive.module.videoreport.page;

import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.lang.ref.WeakReference;

class PageBodyStatistician$BodyInfoHandler
{
  private PageBodyInfo mPageBodyInfo = new PageBodyInfo();
  private PageInfo mPageInfo;
  private WeakReference<IScrollReader> mScrollReader;
  private WeakReference<View> mView;
  
  PageBodyStatistician$BodyInfoHandler(View paramView, IScrollReader paramIScrollReader)
  {
    this.mView = new WeakReference(paramView);
    this.mScrollReader = new WeakReference((IScrollReader)BaseUtils.nullAs(paramIScrollReader, ScrollReader.getScrollReader(paramView)));
    ScrollReader.injectScrollListener(paramView, new PageBodyStatistician.BodyInfoHandler.1(this));
  }
  
  private void readInitScroll()
  {
    ThreadUtils.runOnUiThread(new PageBodyStatistician.BodyInfoHandler.2(this));
  }
  
  private void transferDataToPage()
  {
    Object localObject = this.mPageInfo;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((PageInfo)localObject).getPage();
    }
    if (localObject != null) {
      DataRWProxy.setInnerParam(localObject, "page_body_info", this.mPageBodyInfo);
    }
  }
  
  private void tryGetPageInfo()
  {
    View localView = (View)this.mView.get();
    if ((localView != null) && (this.mPageInfo == null)) {
      this.mPageInfo = PageFinder.findOwnerPage(localView);
    }
  }
  
  private boolean updateProgress(PageBodyInfo paramPageBodyInfo, int paramInt)
  {
    int j = paramPageBodyInfo.getRangeStart();
    int k = paramPageBodyInfo.getRangeEnd();
    int i = paramPageBodyInfo.getPageArea();
    paramInt = Math.max(j, Math.min(k, paramInt)) - j + 1;
    double d1;
    if (i == 0)
    {
      d1 = 0.0D;
    }
    else
    {
      d1 = paramInt;
      double d2 = i;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
    }
    if (d1 > paramPageBodyInfo.getProgressRate())
    {
      paramPageBodyInfo.setProgressArea(paramInt);
      paramPageBodyInfo.setProgressRate(d1);
      return true;
    }
    return false;
  }
  
  private void updateScroll()
  {
    IScrollReader localIScrollReader = (IScrollReader)this.mScrollReader.get();
    View localView = (View)this.mView.get();
    if ((localIScrollReader != null) && (localView != null)) {
      onScrolled(localIScrollReader.readScroll(localView));
    }
  }
  
  public void onScrolled(int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BodyInfoHandler.onScrolled: scrollEnd = ");
      localStringBuilder.append(paramInt);
      Log.d("PageBodyStatistician", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageBodyStatistician.BodyInfoHandler
 * JD-Core Version:    0.7.0.1
 */