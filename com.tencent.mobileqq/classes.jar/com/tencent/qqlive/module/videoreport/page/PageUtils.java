package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.Map;

public class PageUtils
{
  public static FinalData createTrackData(String paramString, Object paramObject)
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey(paramString);
    localFinalData.put("cur_pg", getPageInfo(paramObject));
    return localFinalData;
  }
  
  @NonNull
  public static Map<String, Object> getPageInfo(Object paramObject)
  {
    ArrayMap localArrayMap1 = new ArrayMap(2);
    PageContext localPageContext = PageContextManager.getInstance().get(paramObject);
    ArrayMap localArrayMap2 = new ArrayMap();
    if (localPageContext != null)
    {
      localArrayMap1.put("pg_stp", Integer.valueOf(localPageContext.pageStep));
      putPageParams(localArrayMap2, localPageContext.refPageData);
      if (localArrayMap2.size() == 0) {
        localArrayMap2.put("pgid", "vr_page_none");
      }
    }
    localArrayMap1.put("ref_pg", localArrayMap2);
    putPageParams(localArrayMap1, DataBinder.getDataEntity(paramObject));
    return localArrayMap1;
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