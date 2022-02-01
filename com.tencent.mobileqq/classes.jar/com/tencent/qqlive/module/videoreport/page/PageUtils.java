package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class PageUtils
{
  private static void addPagePath(Map<String, Object> paramMap, List<String> paramList)
  {
    if (!VideoReportInner.getInstance().getConfiguration().isEnablePageLink()) {
      return;
    }
    paramMap.put("pg_path", paramList);
  }
  
  public static FinalData createTrackData(String paramString, Object paramObject)
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey(paramString);
    localFinalData.put("cur_pg", getPageInfo(paramObject));
    return localFinalData;
  }
  
  private static ListIterator<DataEntity> getEntityLink(DataEntity paramDataEntity, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramDataEntity != null)
    {
      if (paramBoolean) {
        localArrayList.add(0, paramDataEntity);
      }
      for (;;)
      {
        paramDataEntity = DataEntityOperator.getParentEntity(paramDataEntity);
        break;
        localArrayList.add(paramDataEntity);
      }
    }
    return localArrayList.listIterator();
  }
  
  @NonNull
  public static Map<String, Object> getPageInfo(Object paramObject)
  {
    ArrayMap localArrayMap1 = new ArrayMap(2);
    Object localObject = PageContextManager.getInstance().get(paramObject);
    ArrayMap localArrayMap2 = new ArrayMap();
    if (localObject != null)
    {
      localArrayMap1.put("pg_stp", Integer.valueOf(((PageContext)localObject).pageStep));
      localObject = ((PageContext)localObject).refPageData;
      ListIterator localListIterator = getEntityLink((DataEntity)localObject, true);
      while (localListIterator.hasNext()) {
        putPageParams(localArrayMap2, (DataEntity)localListIterator.next());
      }
      if (localArrayMap2.isEmpty()) {
        localArrayMap2.put("pgid", "vr_page_none");
      }
      addPagePath(localArrayMap2, getPagePath((DataEntity)localObject));
    }
    localArrayMap1.put("ref_pg", localArrayMap2);
    paramObject = DataBinder.getDataEntity(paramObject);
    addPagePath(localArrayMap1, getPagePath(paramObject));
    paramObject = getEntityLink(paramObject, true);
    while (paramObject.hasNext()) {
      putPageParams(localArrayMap1, (DataEntity)paramObject.next());
    }
    return localArrayMap1;
  }
  
  private static List<String> getPagePath(DataEntity paramDataEntity)
  {
    ArrayList localArrayList = new ArrayList();
    paramDataEntity = getEntityLink(paramDataEntity, false);
    while (paramDataEntity.hasNext()) {
      localArrayList.add(DataEntityOperator.getPageId((DataEntity)paramDataEntity.next()));
    }
    return localArrayList;
  }
  
  public static boolean isCurrentPage(@Nullable PageInfo paramPageInfo)
  {
    return (paramPageInfo != null) && (isCurrentPage(paramPageInfo.getPage()));
  }
  
  public static boolean isCurrentPage(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    PageInfo localPageInfo;
    do
    {
      return false;
      localPageInfo = PageManager.getInstance().getCurrentPageInfo();
    } while ((localPageInfo == null) || (localPageInfo.getPage() != paramObject));
    return true;
  }
  
  private static void putPageParams(Map<String, Object> paramMap, DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {}
    do
    {
      return;
      String str1 = DataEntityOperator.getPageId(paramDataEntity);
      String str2 = DataEntityOperator.getContentId(paramDataEntity);
      paramDataEntity = DataEntityOperator.getPageParams(paramDataEntity);
      paramMap.put("pgid", str1);
      if (str2 != null) {
        paramMap.put("pg_contentid", str2);
      }
    } while (paramDataEntity == null);
    paramMap.putAll(paramDataEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageUtils
 * JD-Core Version:    0.7.0.1
 */