package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.exposure.DetectionData;
import com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;
import java.util.Set;

class PageFinder$PageExposureCallback
  implements IExposureDetectCallback<DetectionData>
{
  private boolean mShouldTerminate;
  Set<View> pageAndParentViewSet;
  private PageInfo tailPageInfo;
  PageInfo targetPageInfo;
  
  private PageFinder$PageExposureCallback(Set<View> paramSet)
  {
    this.pageAndParentViewSet = paramSet;
    this.mShouldTerminate = false;
  }
  
  public final DetectionData createDetectionData()
  {
    return new DetectionData();
  }
  
  public boolean onEnter(View paramView, DetectionData paramDetectionData)
  {
    return (!this.mShouldTerminate) && (BaseUtils.contains(this.pageAndParentViewSet, paramView));
  }
  
  public void onExposed(View paramView, DetectionData paramDetectionData, @NonNull AreaInfo paramAreaInfo)
  {
    double d = VideoReportInner.getInstance().getConfiguration().getPageExposureMinRate();
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramDetectionData = new StringBuilder();
      paramDetectionData.append("onExposed: view = ");
      paramDetectionData.append(paramView);
      paramDetectionData.append(", exposureInfo = ");
      paramDetectionData.append(paramAreaInfo);
      paramDetectionData.append(", exposureMinRate = ");
      paramDetectionData.append(d);
      Log.d("PageFinder", paramDetectionData.toString());
    }
    if (paramAreaInfo.exposureRate < Math.max(d, 0.0D)) {
      return;
    }
    paramView = PageFinder.findRelatedPage(paramView);
    if (paramView != null)
    {
      if (PageFinder.isIgnorePageInOutEvent(paramView)) {
        return;
      }
      paramDetectionData = this.tailPageInfo;
      if (paramDetectionData == null)
      {
        this.tailPageInfo = paramView;
      }
      else if (!this.mShouldTerminate)
      {
        paramDetectionData.setParentPage(paramView);
        this.tailPageInfo = paramView;
      }
      if (this.targetPageInfo == null)
      {
        this.targetPageInfo = paramView;
        this.pageAndParentViewSet = UIUtils.getParentViews(paramView.getPageView());
      }
      if (PageFinder.access$100(paramView)) {
        this.mShouldTerminate = true;
      }
    }
  }
  
  public void onLeave(View paramView, DetectionData paramDetectionData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageFinder.PageExposureCallback
 * JD-Core Version:    0.7.0.1
 */