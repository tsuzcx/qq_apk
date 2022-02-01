package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.data.ElementDataEntity;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataBuilderWithFormatter
  implements IDataBuilder
{
  private List<ReportData> addVirtualParentParams(DataEntity paramDataEntity)
  {
    ArrayList localArrayList = null;
    if (paramDataEntity == null) {
      return null;
    }
    SparseArray localSparseArray = DataEntityOperator.getVirtualElementParentParams(paramDataEntity);
    paramDataEntity = localArrayList;
    if (localSparseArray != null)
    {
      if (localSparseArray.size() == 0) {
        return null;
      }
      localArrayList = new ArrayList();
      int i = 0;
      for (;;)
      {
        paramDataEntity = localArrayList;
        if (i >= localSparseArray.size()) {
          break;
        }
        paramDataEntity = (ElementDataEntity)localSparseArray.valueAt(i);
        if (paramDataEntity != null)
        {
          ReportData localReportData = (ReportData)ReusablePool.obtain(8);
          localReportData.setId(paramDataEntity.elementId);
          localReportData.setParams(paramDataEntity.elementParams);
          localArrayList.add(localReportData);
        }
        i += 1;
      }
    }
    return paramDataEntity;
  }
  
  @NonNull
  private ArrayList<ReportData> getElementsData(String paramString, PathData paramPathData)
  {
    ArrayList localArrayList = new ArrayList();
    paramPathData = paramPathData.iterator();
    while (paramPathData.hasNext())
    {
      Object localObject1 = (DataEntity)paramPathData.next();
      if (localObject1 != null)
      {
        Object localObject2 = DataEntityOperator.getElementId((DataEntity)localObject1);
        HashMap localHashMap = new HashMap();
        Map localMap = DataEntityOperator.getElementParams((DataEntity)localObject1);
        ReportData localReportData = (ReportData)ReusablePool.obtain(8);
        localReportData.setId((String)localObject2);
        localObject2 = DataEntityOperator.getDynamicElementParams(paramString, (DataEntity)localObject1);
        if (!BaseUtils.isEmpty(localMap)) {
          localHashMap.putAll(localMap);
        }
        if (!BaseUtils.isEmpty((Map)localObject2)) {
          localHashMap.putAll((Map)localObject2);
        }
        localReportData.setParams(localHashMap);
        localArrayList.add(localReportData);
        localObject1 = addVirtualParentParams((DataEntity)localObject1);
        if (!BaseUtils.isEmpty((Collection)localObject1)) {
          localArrayList.addAll((Collection)localObject1);
        }
      }
    }
    return localArrayList;
  }
  
  public static DataBuilderWithFormatter getInstance()
  {
    return DataBuilderWithFormatter.InstanceHolder.INSTANCE;
  }
  
  private ReportData getPageData(String paramString, PathData paramPathData)
  {
    ReportData localReportData = (ReportData)ReusablePool.obtain(8);
    Object localObject = paramPathData.getPage();
    if (localObject == null) {
      return null;
    }
    paramPathData = DataRWProxy.getPageId(localObject);
    paramString = PageUtils.getPageInfo(paramString, localObject, localObject.hashCode());
    localReportData.setId(paramPathData);
    localReportData.setParams(paramString);
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
  public FinalData build(String paramString, PathData paramPathData)
  {
    if (paramPathData == null) {
      return null;
    }
    ArrayList localArrayList = getElementsData(paramString, paramPathData);
    paramString = getPageData(paramString, paramPathData);
    paramPathData = VideoReportInner.getInstance().getConfiguration().getFormatter().formatElementParams(localArrayList, paramString);
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    if (paramPathData != null) {
      localFinalData.eventParams = paramPathData;
    }
    recycleObjects(localArrayList, paramString);
    return localFinalData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.DataBuilderWithFormatter
 * JD-Core Version:    0.7.0.1
 */