package com.tencent.qqlive.module.videoreport.exposure;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.trace.Tracer;
import com.tencent.qqlive.module.videoreport.traversal.ViewTraverser;
import com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils;

public class ExposureDetector
{
  private static final String TAG = "ExposureDetector";
  
  public static <T extends DetectionData> void detect(View paramView, boolean paramBoolean, Rect paramRect, IExposureDetectCallback<T> paramIExposureDetectCallback)
  {
    if ((paramView == null) || (paramIExposureDetectCallback == null)) {}
    DetectionData localDetectionData;
    do
    {
      AncestorInfo localAncestorInfo;
      do
      {
        return;
        if (VideoReportInner.getInstance().isDebugMode()) {
          Tracer.begin("detect");
        }
        localDetectionData = paramIExposureDetectCallback.createDetectionData();
        localAncestorInfo = (AncestorInfo)localDetectionData.ancestorsInfo.get(0);
      } while (!paramView.getGlobalVisibleRect(localAncestorInfo.visibleRect));
      localAncestorInfo.restrictedRect = localAncestorInfo.visibleRect;
      localAncestorInfo.actualRect = localAncestorInfo.visibleRect;
      Object localObject = paramView.getParent();
      if ((localObject instanceof ViewGroup))
      {
        localObject = (ViewGroup)localObject;
        localAncestorInfo.scrollX = ((ViewGroup)localObject).getScrollX();
        localAncestorInfo.scrollY = ((ViewGroup)localObject).getScrollY();
        localAncestorInfo.clipChildren = ViewCompatUtils.getClipChildren((ViewGroup)localObject);
      }
      ViewTraverser.getInstance().perform(paramView, new ExposureDetector.1(localDetectionData, paramIExposureDetectCallback, paramRect, paramBoolean));
    } while (!VideoReportInner.getInstance().isDebugMode());
    long l = Tracer.end("detect");
    Log.d("ExposureDetector", "detect: " + l / 1000L + " us cost, " + localDetectionData.viewsDetected + " views detected");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.exposure.ExposureDetector
 * JD-Core Version:    0.7.0.1
 */