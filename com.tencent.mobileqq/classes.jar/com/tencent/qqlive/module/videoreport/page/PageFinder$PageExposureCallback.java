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
import java.util.Set;

class PageFinder$PageExposureCallback
  implements IExposureDetectCallback<DetectionData>
{
  Set<View> pageAndParentViewSet;
  PageInfo targetPageInfo;
  
  private PageFinder$PageExposureCallback(Set<View> paramSet)
  {
    this.pageAndParentViewSet = paramSet;
  }
  
  public final DetectionData createDetectionData()
  {
    return new DetectionData();
  }
  
  public boolean onEnter(View paramView, DetectionData paramDetectionData)
  {
    return (this.targetPageInfo == null) && (BaseUtils.contains(this.pageAndParentViewSet, paramView));
  }
  
  public void onExposed(View paramView, DetectionData paramDetectionData, @NonNull AreaInfo paramAreaInfo)
  {
    double d = VideoReportInner.getInstance().getConfiguration().getPageExposureMinRate();
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageFinder", "onExposed: view = " + paramView + ", exposureInfo = " + paramAreaInfo + ", exposureMinRate = " + d);
    }
    if ((this.targetPageInfo != null) || (paramAreaInfo.exposureRate < Math.max(d, 0.0D))) {}
    do
    {
      return;
      paramView = PageFinder.findRelatedPage(paramView);
    } while ((paramView == null) || (PageFinder.isIgnorePageInOutEvent(paramView)));
    this.targetPageInfo = paramView;
  }
  
  public void onLeave(View paramView, DetectionData paramDetectionData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageFinder.PageExposureCallback
 * JD-Core Version:    0.7.0.1
 */