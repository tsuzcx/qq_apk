package com.tencent.qqlive.module.videoreport.report;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
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
    localFinalData.putAll(addIsPageReturnParam(getPageReportInfo("pgin", paramPageInfo), paramPageInfo));
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
    long l;
    if (localObject == null) {
      l = 0L;
    } else {
      l = ((Long)localObject).longValue();
    }
    localObject = (FinalData)ReusablePool.obtain(6);
    ((FinalData)localObject).setEventKey("pgout");
    ((FinalData)localObject).put("lvtm", Long.valueOf(SystemClock.elapsedRealtime() - l));
    putPageBodyInfo((FinalData)localObject);
    putInteractiveFlag((FinalData)localObject);
    ((FinalData)localObject).putAll(getPageReportInfo("pgout", paramPageInfo));
    paramPageInfo = VideoReportInner.getInstance().getEventDynamicParams();
    if (paramPageInfo != null) {
      paramPageInfo.setEventDynamicParams("pgout", ((FinalData)localObject).getEventParams());
    }
    return localObject;
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
  private Map<String, Object> getPageReportInfo(String paramString, @NonNull PageInfo paramPageInfo)
  {
    return PageUtils.getPageInfo(paramString, paramPageInfo.getPage(), paramPageInfo.getPageHashCode());
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
    if (DataRWProxy.getInnerParam(localObject, "page_interactive_flag") == Boolean.TRUE) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    paramFinalData.put("is_interactive_flag", localObject);
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
    int i;
    if (paramPageInfo != null) {
      i = isPageReturn(DataBinder.getDataEntity(paramPageInfo.getPage()));
    } else {
      i = 0;
    }
    paramMap.put("dt_pg_isreturn", Integer.valueOf(i));
    return paramMap;
  }
  
  @NonNull
  public Map<String, Object> getCurPageReportInfo(String paramString)
  {
    PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
    if (localPageInfo == null) {
      return new HashMap();
    }
    return getPageReportInfo(paramString, localPageInfo);
  }
  
  int isPageReturn(@Nullable DataEntity paramDataEntity)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    if (paramPageInfo != null)
    {
      if (paramPageInfo.getPage() == null) {
        return;
      }
      paramPageInfo = paramPageInfo.getPage();
      DataRWProxy.setInnerParam(paramPageInfo, "page_last_content_id", DataRWProxy.getContentId(paramPageInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.PageReporter
 * JD-Core Version:    0.7.0.1
 */