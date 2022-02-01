package com.tencent.qqlive.module.videoreport.exposure;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
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
  
  private static boolean calculateRestrictedRect(View paramView, AncestorInfo paramAncestorInfo1, AncestorInfo paramAncestorInfo2, Rect paramRect, ViewGroup paramViewGroup)
  {
    paramAncestorInfo2 = paramAncestorInfo2.restrictedRect;
    if (!paramAncestorInfo1.clipChildren)
    {
      paramAncestorInfo2.set(paramAncestorInfo1.restrictedRect);
    }
    else
    {
      paramAncestorInfo2.set(0, 0, paramRect.right - paramRect.left, paramRect.bottom - paramRect.top);
      paramAncestorInfo1 = ViewCompat.getClipBounds(paramView);
      if ((paramAncestorInfo1 != null) && (!paramAncestorInfo2.intersect(paramAncestorInfo1))) {
        return false;
      }
      if ((ViewCompatUtils.getClipToPadding(paramViewGroup)) && (!paramAncestorInfo2.intersect(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getWidth() - paramView.getPaddingRight(), paramView.getHeight() - paramView.getPaddingBottom()))) {
        return false;
      }
      paramAncestorInfo2.offset(paramRect.left, paramRect.top);
    }
    return true;
  }
  
  public static <T extends DetectionData> void detect(View paramView, boolean paramBoolean, Rect paramRect, IExposureDetectCallback<T> paramIExposureDetectCallback)
  {
    if (paramView != null)
    {
      if (paramIExposureDetectCallback == null) {
        return;
      }
      if (VideoReportInner.getInstance().isDebugMode()) {
        Tracer.begin("detect");
      }
      DetectionData localDetectionData = paramIExposureDetectCallback.createDetectionData();
      AncestorInfo localAncestorInfo = (AncestorInfo)localDetectionData.ancestorsInfo.get(0);
      if (!paramView.getGlobalVisibleRect(localAncestorInfo.visibleRect)) {
        return;
      }
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
      if (VideoReportInner.getInstance().isDebugMode())
      {
        long l = Tracer.end("detect");
        paramView = new StringBuilder();
        paramView.append("detect: ");
        paramView.append(l / 1000L);
        paramView.append(" us cost, ");
        paramView.append(localDetectionData.viewsDetected);
        paramView.append(" views detected");
        Log.d("ExposureDetector", paramView.toString());
      }
    }
  }
  
  private static <T extends DetectionData> boolean performOnEnter(View paramView, int paramInt, T paramT, IExposureDetectCallback<T> paramIExposureDetectCallback, Rect paramRect, boolean paramBoolean)
  {
    paramT.viewsDetected += 1;
    paramT.mAreaInfo.set(paramInt, null);
    if (!paramIExposureDetectCallback.onEnter(paramView, paramT)) {
      return false;
    }
    if (paramView.getVisibility() != 0) {
      return false;
    }
    AncestorInfo localAncestorInfo = (AncestorInfo)paramT.ancestorsInfo.get(paramInt - 1);
    int i = localAncestorInfo.actualRect.left + paramView.getLeft() - localAncestorInfo.scrollX;
    int j = localAncestorInfo.actualRect.top + paramView.getTop() - localAncestorInfo.scrollY;
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    Object localObject2 = paramT.helperRectF;
    ((RectF)localObject2).set(i, j, k + i, m + j);
    Object localObject1 = paramView.getMatrix();
    if (!((Matrix)localObject1).isIdentity()) {
      ((Matrix)localObject1).mapRect((RectF)localObject2);
    }
    localObject1 = (AncestorInfo)paramT.ancestorsInfo.get(paramInt);
    Rect localRect = ((AncestorInfo)localObject1).visibleRect;
    localRect.set((int)((RectF)localObject2).left, (int)((RectF)localObject2).top, (int)((RectF)localObject2).right, (int)((RectF)localObject2).bottom);
    ((AncestorInfo)localObject1).actualRect.set(localRect);
    if ((localRect.intersect(localAncestorInfo.restrictedRect)) && (!localRect.isEmpty()))
    {
      localObject2 = paramT.helperRectForExclusion;
      ((Rect)localObject2).set(localRect);
      if ((paramRect != null) && (((Rect)localObject2).intersect(paramRect))) {
        l1 = ((Rect)localObject2).width() * ((Rect)localObject2).height();
      } else {
        l1 = 0L;
      }
      long l1 = localRect.width() * localRect.height() - l1;
      if (l1 != 0L)
      {
        long l2 = paramView.getWidth() * paramView.getHeight();
        paramRect = new AreaInfo(l2, l1, (float)l1 * 1.0F / (float)l2);
        paramT.mAreaInfo.set(paramInt, paramRect);
        if (paramBoolean) {
          paramIExposureDetectCallback.onExposed(paramView, paramT, paramRect);
        }
      }
      if (!(paramView instanceof ViewGroup)) {
        return false;
      }
      paramT = (ViewGroup)paramView;
      if ((calculateRestrictedRect(paramView, localAncestorInfo, (AncestorInfo)localObject1, localRect, paramT) ^ true)) {
        return false;
      }
      ((AncestorInfo)localObject1).scrollX = paramView.getScrollX();
      ((AncestorInfo)localObject1).scrollY = paramView.getScrollY();
      ((AncestorInfo)localObject1).clipChildren = ViewCompatUtils.getClipChildren(paramT);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.exposure.ExposureDetector
 * JD-Core Version:    0.7.0.1
 */