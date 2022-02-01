package com.tencent.qqlive.module.videoreport.exposure;

import android.graphics.Rect;
import android.view.View;
import com.tencent.qqlive.module.videoreport.traversal.IViewTraverseCallback;

final class ExposureDetector$1
  implements IViewTraverseCallback
{
  ExposureDetector$1(DetectionData paramDetectionData, IExposureDetectCallback paramIExposureDetectCallback, Rect paramRect, boolean paramBoolean) {}
  
  public boolean onEnter(View paramView, int paramInt)
  {
    return ExposureDetector.access$000(paramView, paramInt, this.val$detectionData, this.val$callback, this.val$excludeRect, this.val$preOrder);
  }
  
  public void onLeave(View paramView, int paramInt)
  {
    AreaInfo localAreaInfo = (AreaInfo)this.val$detectionData.mAreaInfo.get(paramInt);
    if ((localAreaInfo != null) && (!this.val$preOrder)) {
      this.val$callback.onExposed(paramView, this.val$detectionData, localAreaInfo);
    }
    this.val$callback.onLeave(paramView, this.val$detectionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.exposure.ExposureDetector.1
 * JD-Core Version:    0.7.0.1
 */