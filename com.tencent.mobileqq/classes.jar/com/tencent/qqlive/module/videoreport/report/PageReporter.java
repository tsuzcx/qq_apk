package com.tencent.qqlive.module.videoreport.report;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageBodyInfo;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.Locale;
import java.util.Map;

public class PageReporter
  implements PageManager.IPageListener
{
  private long mPageInTime;
  
  private FinalData createPgInFinalData()
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("pgin");
    localFinalData.putAll(getCurPageReportInfo());
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("pgin", localFinalData.getEventParams());
    }
    return localFinalData;
  }
  
  private FinalData createPgOutFinalData()
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("pgout");
    localFinalData.put("lvtm", Long.valueOf(SystemClock.uptimeMillis() - this.mPageInTime));
    putPageBodyInfo(localFinalData);
    putInteractiveFlag(localFinalData);
    localFinalData.putAll(getCurPageReportInfo());
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("pgout", localFinalData.getEventParams());
    }
    return localFinalData;
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
  public Map<String, Object> getCurPageReportInfo()
  {
    PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
    if (localPageInfo == null) {}
    for (Object localObject = null; localObject == null; localObject = localPageInfo.getPage()) {
      return new ArrayMap();
    }
    return PageUtils.getPageInfo(localPageInfo.getPage());
  }
  
  public void onPageIn(PageInfo paramPageInfo)
  {
    this.mPageInTime = SystemClock.uptimeMillis();
    initInteractiveFlag(paramPageInfo.getPage());
    FinalDataTarget.handle(paramPageInfo.getPage(), createPgInFinalData());
  }
  
  public void onPageOut(PageInfo paramPageInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FinalDataTarget.handleInMainThread(paramPageInfo.getPage(), createPgOutFinalData());
      return;
    }
    FinalDataTarget.handle(paramPageInfo.getPage(), createPgOutFinalData());
  }
  
  public void onPageUpdate(PageInfo paramPageInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.PageReporter
 * JD-Core Version:    0.7.0.1
 */