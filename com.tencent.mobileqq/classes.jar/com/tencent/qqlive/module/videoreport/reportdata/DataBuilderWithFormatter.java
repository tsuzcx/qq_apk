package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class DataBuilderWithFormatter
  implements IDataBuilder
{
  @NonNull
  private ArrayList<ReportData> getElementsData(PathData paramPathData)
  {
    ArrayList localArrayList = new ArrayList();
    paramPathData = paramPathData.iterator();
    while (paramPathData.hasNext())
    {
      Object localObject = (DataEntity)paramPathData.next();
      if (localObject != null)
      {
        String str = DataEntityOperator.getElementId((DataEntity)localObject);
        localObject = DataEntityOperator.getElementParams((DataEntity)localObject);
        ReportData localReportData = (ReportData)ReusablePool.obtain(8);
        localReportData.setId(str);
        localReportData.setParams((Map)localObject);
        localArrayList.add(localReportData);
      }
    }
    return localArrayList;
  }
  
  public static DataBuilderWithFormatter getInstance()
  {
    return DataBuilderWithFormatter.InstanceHolder.INSTANCE;
  }
  
  private ReportData getPageData(PathData paramPathData)
  {
    ReportData localReportData = (ReportData)ReusablePool.obtain(8);
    Object localObject = paramPathData.getPage();
    if (localObject == null) {
      return null;
    }
    paramPathData = DataRWProxy.getPageId(localObject);
    localObject = PageUtils.getPageInfo(localObject);
    localReportData.setId(paramPathData);
    localReportData.setParams((Map)localObject);
    return localReportData;
  }
  
  private void recycleObjects(ArrayList<ReportData> paramArrayList, ReportData paramReportData)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      ReusablePool.recycle((ReportData)paramArrayList.next(), 8);
    }
    ReusablePool.recycle(paramReportData, 8);
  }
  
  @Nullable
  public FinalData build(PathData paramPathData)
  {
    if (paramPathData == null) {
      return null;
    }
    ArrayList localArrayList = getElementsData(paramPathData);
    paramPathData = getPageData(paramPathData);
    Map localMap = VideoReportInner.getInstance().getConfiguration().getFormatter().formatElementParams(localArrayList, paramPathData);
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    if (localMap != null) {
      localFinalData.eventParams = localMap;
    }
    recycleObjects(localArrayList, paramPathData);
    return localFinalData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.DataBuilderWithFormatter
 * JD-Core Version:    0.7.0.1
 */