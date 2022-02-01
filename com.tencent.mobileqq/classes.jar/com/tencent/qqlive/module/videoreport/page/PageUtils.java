package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.DynamicEventUtils;
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
    localFinalData.put("cur_pg", getPageInfo(paramString, paramObject, paramObject.hashCode()));
    return localFinalData;
  }
  
  private static ListIterator<DataEntity> getEntityLink(DataEntity paramDataEntity, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramDataEntity != null)
    {
      if (paramBoolean) {
        localArrayList.add(0, paramDataEntity);
      } else {
        localArrayList.add(paramDataEntity);
      }
      paramDataEntity = DataEntityOperator.getParentEntity(paramDataEntity);
    }
    return localArrayList.listIterator();
  }
  
  @NonNull
  public static Map<String, Object> getPageInfo(String paramString, Object paramObject, int paramInt)
  {
    ArrayMap localArrayMap = new ArrayMap(2);
    Object localObject2 = PageContextManager.getInstance().get(paramInt);
    Object localObject1 = new ArrayMap();
    DataEntity localDataEntity;
    if (localObject2 != null)
    {
      paramInt = ((PageContext)localObject2).pageStep;
      localDataEntity = ((PageContext)localObject2).curPageData;
      localArrayMap.put("pg_stp", Integer.valueOf(paramInt));
      localObject2 = ((PageContext)localObject2).refPageData;
      ListIterator localListIterator = getEntityLink((DataEntity)localObject2, true);
      while (localListIterator.hasNext()) {
        putPageParams(paramString, (Map)localObject1, (DataEntity)localListIterator.next());
      }
      insertLastClickInfo((DataEntity)localObject2, (Map)localObject1);
      if (((Map)localObject1).isEmpty()) {
        ((Map)localObject1).put("pgid", "vr_page_none");
      }
      addPagePath((Map)localObject1, getPagePath((DataEntity)localObject2));
    }
    else
    {
      localDataEntity = null;
    }
    localArrayMap.put("ref_pg", localObject1);
    localObject1 = localDataEntity;
    if (localDataEntity == null) {
      localObject1 = DataBinder.getDataEntity(paramObject);
    }
    addPagePath(localArrayMap, getPagePath((DataEntity)localObject1));
    paramObject = getEntityLink((DataEntity)localObject1, true);
    while (paramObject.hasNext()) {
      putPageParams(paramString, localArrayMap, (DataEntity)paramObject.next());
    }
    return localArrayMap;
  }
  
  private static PageLastClickEleInfo getPageLastClickEleInfo(DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return null;
    }
    paramDataEntity = DataEntityOperator.getInnerParam(paramDataEntity, "last_click_element");
    if ((paramDataEntity instanceof PageLastClickEleInfo)) {
      return (PageLastClickEleInfo)paramDataEntity;
    }
    return null;
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
  
  private static void insertLastClickInfo(DataEntity paramDataEntity, Map<String, Object> paramMap)
  {
    paramDataEntity = getPageLastClickEleInfo(paramDataEntity);
    if ((paramDataEntity != null) && (paramDataEntity.getElementParams() != null)) {
      paramMap.put("last_clck_ele", paramDataEntity.getElementParams());
    }
  }
  
  public static boolean isCurrentPage(@Nullable PageInfo paramPageInfo)
  {
    return (paramPageInfo != null) && (isCurrentPage(paramPageInfo.getPage()));
  }
  
  public static boolean isCurrentPage(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
    boolean bool1 = bool2;
    if (localPageInfo != null)
    {
      bool1 = bool2;
      if (localPageInfo.getPage() == paramObject) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void putPageParams(String paramString, Map<String, Object> paramMap, DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return;
    }
    String str1 = DataEntityOperator.getPageId(paramDataEntity);
    String str2 = DataEntityOperator.getContentId(paramDataEntity);
    Map localMap = DataEntityOperator.getPageParams(paramDataEntity);
    paramMap.put("pgid", str1);
    if (str2 != null) {
      paramMap.put("pg_contentid", str2);
    }
    if (localMap != null) {
      paramMap.putAll(localMap);
    }
    if (DynamicEventUtils.filterDynamicEvent(paramString))
    {
      if (paramDataEntity.getEventDynamicParams() == null) {
        paramString = null;
      } else {
        paramString = paramDataEntity.getEventDynamicParams().getDynamicParams(paramString);
      }
      if (paramString != null) {
        paramMap.putAll(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageUtils
 * JD-Core Version:    0.7.0.1
 */