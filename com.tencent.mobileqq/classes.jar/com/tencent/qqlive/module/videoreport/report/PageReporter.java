package com.tencent.qqlive.module.videoreport.report;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageBodyInfo;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class PageReporter
  implements PageManager.IPageListener
{
  private final SparseArray<Long> mPageInTimes = new SparseArray();
  
  private FinalData createPgInFinalData(@NonNull PageInfo paramPageInfo)
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("pgin");
    localFinalData.putAll(addIsPageReturnParam(getPageReportInfo(paramPageInfo), paramPageInfo));
    paramPageInfo = VideoReportInner.getInstance().getEventDynamicParams();
    if (paramPageInfo != null) {
      paramPageInfo.setEventDynamicParams("pgin", localFinalData.getEventParams());
    }
    return localFinalData;
  }
  
  private FinalData createPgOutFinalData(@NonNull PageInfo paramPageInfo)
  {
    Object localObject = (Long)this.mPageInTimes.get(paramPageInfo.getPageHashCode());
    this.mPageInTimes.remove(paramPageInfo.getPageHashCode());
    if (localObject == null) {}
    for (long l = 0L;; l = ((Long)localObject).longValue())
    {
      localObject = (FinalData)ReusablePool.obtain(6);
      ((FinalData)localObject).setEventKey("pgout");
      ((FinalData)localObject).put("lvtm", Long.valueOf(SystemClock.elapsedRealtime() - l));
      putPageBodyInfo((FinalData)localObject);
      putInteractiveFlag((FinalData)localObject);
      ((FinalData)localObject).putAll(getPageReportInfo(paramPageInfo));
      paramPageInfo = VideoReportInner.getInstance().getEventDynamicParams();
      if (paramPageInfo != null) {
        paramPageInfo.setEventDynamicParams("pgout", ((FinalData)localObject).getEventParams());
      }
      return localObject;
    }
  }
  
  private Object getCurPage()
  {
    PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
    if (localPageInfo == null) {
      return null;
    }
    return localPageInfo.getPage();
  }
  
  public static PageReporter getInstance()
  {
    return PageReporter.InstanceHolder.access$000();
  }
  
  @NonNull
  private Map<String, Object> getPageReportInfo(@NonNull PageInfo paramPageInfo)
  {
    return PageUtils.getPageInfo(paramPageInfo.getPageHashCode());
  }
  
  private void init()
  {
    PageManager.getInstance().register(this);
  }
  
  private void initInteractiveFlag(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    DataRWProxy.removeInnerParam(paramObject, "page_interactive_flag");
  }
  
  private void putInteractiveFlag(@NonNull FinalData paramFinalData)
  {
    Object localObject = getCurPage();
    if (localObject == null) {
      return;
    }
    if (DataRWProxy.getInnerParam(localObject, "page_interactive_flag") == Boolean.TRUE) {}
    for (localObject = "1";; localObject = "0")
    {
      paramFinalData.put("is_interactive_flag", localObject);
      return;
    }
  }
  
  private void putPageBodyInfo(@NonNull FinalData paramFinalData)
  {
    Object localObject = DataRWProxy.getInnerParam(getCurPage(), "page_body_info");
    if (!(localObject instanceof PageBodyInfo)) {
      return;
    }
    localObject = (PageBodyInfo)localObject;
    paramFinalData.put("pg_area", String.valueOf(((PageBodyInfo)localObject).getPageArea()));
    paramFinalData.put("pg_imp_area", String.valueOf(((PageBodyInfo)localObject).getProgressArea()));
    paramFinalData.put("pg_imp_rate", String.format(Locale.getDefault(), "%.2f", new Object[] { Double.valueOf(((PageBodyInfo)localObject).getProgressRate()) }));
  }
  
  @NonNull
  Map<String, Object> addIsPageReturnParam(@NonNull Map<String, Object> paramMap, PageInfo paramPageInfo)
  {
    int i = 0;
    if (paramPageInfo != null) {
      i = isPageReturn(DataBinder.getDataEntity(paramPageInfo.getPage()));
    }
    paramMap.put("dt_pg_isreturn", Integer.valueOf(i));
    return paramMap;
  }
  
  @NonNull
  public Map<String, Object> getCurPageReportInfo()
  {
    PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
    if (localPageInfo == null) {
      return new HashMap();
    }
    return getPageReportInfo(localPageInfo);
  }
  
  int isPageReturn(@Nullable DataEntity paramDataEntity)
  {
    String str1 = (String)DataEntityOperator.getInnerParam(paramDataEntity, "page_last_content_id");
    String str2 = DataEntityOperator.getContentId(paramDataEntity);
    if ((paramDataEntity == null) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      return 0;
    }
    if (str2.equals(str1)) {
      return 1;
    }
    return 0;
  }
  
  public void onPageIn(@NonNull PageInfo paramPageInfo, @NonNull Set<PageInfo> paramSet, int paramInt)
  {
    paramPageInfo = new ArrayList(paramSet);
    paramInt = paramPageInfo.size() - 1;
    while (paramInt >= 0)
    {
      paramSet = (PageInfo)paramPageInfo.get(paramInt);
      this.mPageInTimes.put(paramSet.getPageHashCode(), Long.valueOf(SystemClock.elapsedRealtime()));
      initInteractiveFlag(paramSet.getPage());
      FinalDataTarget.handle(paramSet.getPage(), createPgInFinalData(paramSet));
      updateLastContentId(paramSet);
      paramInt -= 1;
    }
  }
  
  public void onPageOut(@NonNull PageInfo paramPageInfo, @NonNull Set<PageInfo> paramSet, boolean paramBoolean)
  {
    paramPageInfo = paramSet.iterator();
    while (paramPageInfo.hasNext())
    {
      paramSet = (PageInfo)paramPageInfo.next();
      if (paramBoolean) {
        FinalDataTarget.handleInMainThread(paramSet.getPage(), createPgOutFinalData(paramSet));
      } else {
        FinalDataTarget.handle(paramSet.getPage(), createPgOutFinalData(paramSet));
      }
    }
  }
  
  public void onPageUpdate(PageInfo paramPageInfo, int paramInt) {}
  
  void updateLastContentId(PageInfo paramPageInfo)
  {
    if ((paramPageInfo == null) || (paramPageInfo.getPage() == null)) {
      return;
    }
    paramPageInfo = paramPageInfo.getPage();
    DataRWProxy.setInnerParam(paramPageInfo, "page_last_content_id", DataRWProxy.getContentId(paramPageInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.PageReporter
 * JD-Core Version:    0.7.0.1
 */