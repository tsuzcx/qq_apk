package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.Configuration;
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
  
  public static FinalData createTrackData(String paramString, @NonNull Object paramObject)
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey(paramString);
    localFinalData.put("cur_pg", getPageInfo(paramObject.hashCode()));
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
  public static Map<String, Object> getPageInfo(int paramInt)
  {
    ArrayMap localArrayMap1 = new ArrayMap(2);
    Object localObject2 = PageContextManager.getInstance().get(paramInt);
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      paramInt = ((PageContext)localObject2).pageStep;
      localObject1 = ((PageContext)localObject2).curPageData;
      localArrayMap1.put("pg_stp", Integer.valueOf(paramInt));
      localObject2 = ((PageContext)localObject2).refPageData;
      ListIterator localListIterator = getEntityLink((DataEntity)localObject2, true);
      while (localListIterator.hasNext()) {
        putPageParams(localArrayMap2, (DataEntity)localListIterator.next());
      }
      if (localArrayMap2.isEmpty()) {
        localArrayMap2.put("pgid", "vr_page_none");
      }
      addPagePath(localArrayMap2, getPagePath((DataEntity)localObject2));
    }
    localArrayMap1.put("ref_pg", localArrayMap2);
    addPagePath(localArrayMap1, getPagePath((DataEntity)localObject1));
    localObject1 = getEntityLink((DataEntity)localObject1, true);
    while (((ListIterator)localObject1).hasNext()) {
      putPageParams(localArrayMap1, (DataEntity)((ListIterator)localObject1).next());
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