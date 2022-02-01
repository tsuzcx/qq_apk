package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.page.PageFinder;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import com.tencent.qqlive.module.videoreport.reportdata.PathDataUtils;

public class ReversedDataCollector
{
  public static PathData collect(@NonNull View paramView)
  {
    PathData localPathData = new PathData();
    while (paramView != null)
    {
      Object localObject = DataBinder.getDataEntity(paramView);
      if (PathDataUtils.canCollect((DataEntity)localObject)) {
        localPathData.addLast((DataEntity)localObject);
      }
      PageInfo localPageInfo = PageFinder.findRelatedPage(paramView);
      if (localPageInfo != null)
      {
        DataEntity localDataEntity = DataBinder.getDataEntity(localPageInfo.getPage());
        localObject = localDataEntity;
        if (PathDataUtils.shouldStop(localDataEntity))
        {
          localPathData.setPage(localPageInfo.getPage());
          return localPathData;
        }
      }
      paramView = ReportHelper.findParent(paramView, (DataEntity)localObject);
    }
    return localPathData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ReversedDataCollector
 * JD-Core Version:    0.7.0.1
 */