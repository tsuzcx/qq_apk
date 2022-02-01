package com.tencent.qqlive.module.videoreport.exposure;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.traversal.IViewTraverseCallback;
import com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils;

final class ExposureDetector$1
  implements IViewTraverseCallback
{
  ExposureDetector$1(DetectionData paramDetectionData, IExposureDetectCallback paramIExposureDetectCallback, Rect paramRect, boolean paramBoolean) {}
  
  public boolean onEnter(View paramView, int paramInt)
  {
    Object localObject1 = this.val$detectionData;
    ((DetectionData)localObject1).viewsDetected += 1;
    this.val$detectionData.mAreaInfo.set(paramInt, null);
    if (!this.val$callback.onEnter(paramView, this.val$detectionData)) {
      return false;
    }
    if (paramView.getVisibility() != 0) {
      return false;
    }
    localObject1 = (AncestorInfo)this.val$detectionData.ancestorsInfo.get(paramInt - 1);
    int i = ((AncestorInfo)localObject1).actualRect.left + paramView.getLeft() - ((AncestorInfo)localObject1).scrollX;
    int j = ((AncestorInfo)localObject1).actualRect.top + paramView.getTop() - ((AncestorInfo)localObject1).scrollY;
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    Object localObject3 = this.val$detectionData.helperRectF;
    ((RectF)localObject3).set(i, j, k + i, m + j);
    Object localObject2 = paramView.getMatrix();
    if (!((Matrix)localObject2).isIdentity()) {
      ((Matrix)localObject2).mapRect((RectF)localObject3);
    }
    localObject2 = (AncestorInfo)this.val$detectionData.ancestorsInfo.get(paramInt);
    Rect localRect = ((AncestorInfo)localObject2).visibleRect;
    localRect.set((int)((RectF)localObject3).left, (int)((RectF)localObject3).top, (int)((RectF)localObject3).right, (int)((RectF)localObject3).bottom);
    ((AncestorInfo)localObject2).actualRect.set(localRect);
    if ((!localRect.intersect(((AncestorInfo)localObject1).restrictedRect)) || (localRect.isEmpty())) {
      return false;
    }
    localObject3 = this.val$detectionData.helperRectForExclusion;
    ((Rect)localObject3).set(localRect);
    if ((this.val$excludeRect != null) && (((Rect)localObject3).intersect(this.val$excludeRect))) {
      i = ((Rect)localObject3).width();
    }
    for (long l1 = ((Rect)localObject3).height() * i;; l1 = 0L)
    {
      l1 = localRect.width() * localRect.height() - l1;
      if (l1 != 0L)
      {
        long l2 = paramView.getWidth() * paramView.getHeight();
        localObject3 = new AreaInfo(l2, l1, (float)l1 * 1.0F / (float)l2);
        this.val$detectionData.mAreaInfo.set(paramInt, localObject3);
        if (this.val$preOrder) {
          this.val$callback.onExposed(paramView, this.val$detectionData, (AreaInfo)localObject3);
        }
      }
      if (!(paramView instanceof ViewGroup)) {
        return false;
      }
      localObject3 = ((AncestorInfo)localObject2).restrictedRect;
      ViewGroup localViewGroup = (ViewGroup)paramView;
      if (!((AncestorInfo)localObject1).clipChildren) {
        ((Rect)localObject3).set(((AncestorInfo)localObject1).restrictedRect);
      }
      for (;;)
      {
        ((AncestorInfo)localObject2).scrollX = paramView.getScrollX();
        ((AncestorInfo)localObject2).scrollY = paramView.getScrollY();
        ((AncestorInfo)localObject2).clipChildren = ViewCompatUtils.getClipChildren(localViewGroup);
        return true;
        ((Rect)localObject3).set(0, 0, localRect.right - localRect.left, localRect.bottom - localRect.top);
        localObject1 = ViewCompat.getClipBounds(paramView);
        if ((localObject1 != null) && (!((Rect)localObject3).intersect((Rect)localObject1))) {
          return false;
        }
        if ((ViewCompatUtils.getClipToPadding(localViewGroup)) && (!((Rect)localObject3).intersect(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getWidth() - paramView.getPaddingRight(), paramView.getHeight() - paramView.getPaddingBottom()))) {
          return false;
        }
        ((Rect)localObject3).offset(localRect.left, localRect.top);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.exposure.ExposureDetector.1
 * JD-Core Version:    0.7.0.1
 */