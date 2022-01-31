package com.tencent.ttpic.filter.aifilter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.filter.BeautyFaceList_260;
import com.tencent.ttpic.openapi.filter.RealTimeSmoothFilterV3;
import com.tencent.ttpic.openapi.filter.Renderer;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class FaceBeautyFilterRenderer
  implements Renderer
{
  private final List<Object> filterList;
  private final List<List<PointF>> points;
  
  public FaceBeautyFilterRenderer(@NotNull List<Object> paramList, @NotNull List<List<PointF>> paramList1)
  {
    this.filterList = paramList;
    this.points = paramList1;
  }
  
  @NotNull
  public Frame process(@NotNull Frame paramFrame)
  {
    Iterator localIterator = this.filterList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof BeautyFaceList_260))
      {
        ((BeautyFaceList_260)localObject).initial();
        ((BeautyFaceList_260)localObject).updateVideoSize(paramFrame.width, paramFrame.height, 1.0D);
        paramFrame = ((BeautyFaceList_260)localObject).render(paramFrame, this.points, null, null, false);
      }
      else if ((localObject instanceof RealTimeSmoothFilterV3))
      {
        ((RealTimeSmoothFilterV3)localObject).initial();
        paramFrame = ((RealTimeSmoothFilterV3)localObject).updateAndRender(paramFrame, this.points, paramFrame.width, paramFrame.height, 0);
      }
    }
    return paramFrame;
  }
  
  public void release()
  {
    if (this.filterList != null)
    {
      Iterator localIterator = this.filterList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof BeautyFaceList_260)) {
          ((BeautyFaceList_260)localObject).clear();
        } else if ((localObject instanceof RealTimeSmoothFilterV3)) {
          ((RealTimeSmoothFilterV3)localObject).clear();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.FaceBeautyFilterRenderer
 * JD-Core Version:    0.7.0.1
 */