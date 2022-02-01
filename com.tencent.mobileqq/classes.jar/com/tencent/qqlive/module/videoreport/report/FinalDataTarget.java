package com.tencent.qqlive.module.videoreport.report;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.IInnerReporter;
import com.tencent.qqlive.module.videoreport.IReporter;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.staging.EventStashManager;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SystemUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FinalDataTarget
{
  private static ListenerMgr<FinalDataTarget.IFinalDataHandleListener> sListenerMgr = new ListenerMgr();
  private static ThreadLocal<FinalDataTarget.NotifyCallbackImpl> sNotifyCallbacks = new FinalDataTarget.1();
  
  private static void addNonRealtimeExternalParams(Map<String, Object> paramMap)
  {
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setNonRealtimePublicDynamicParams(paramMap);
    }
  }
  
  private static void addNonRealtimeInnerParam(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    paramMap.put("os", "1");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Android ");
    localStringBuilder.append(Build.VERSION.RELEASE);
    paramMap.put("os_vrsn", localStringBuilder.toString());
    paramMap.put("ui_vrsn", SystemUtils.getSystemUI());
  }
  
  private static void addRealtimeExternalParams(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    Object localObject = VideoReportInner.getInstance().getPublicParam();
    if (localObject != null) {
      paramMap.putAll((Map)localObject);
    }
    localObject = VideoReportInner.getInstance().getEventDynamicParams();
    if (localObject != null) {
      ((IEventDynamicParams)localObject).setRealtimePublicDynamicParams(paramMap);
    }
  }
  
  private static void addRealtimeInnerParam(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    paramMap.put("usid", AppEventReporter.getInstance().getUsId());
    paramMap.put("us_stmp", Long.valueOf(AppEventReporter.getInstance().getUsStamp()));
    paramMap.put("ussn", Long.valueOf(AppEventReporter.getInstance().getUssn()));
    String str;
    if (AppEventReporter.getInstance().isColdStart()) {
      str = "1";
    } else {
      str = "0";
    }
    paramMap.put("coldstart", str);
    paramMap.put("app_vr", ReportUtils.getPackageName());
    paramMap.put("app_bld", Integer.valueOf(ReportUtils.getPackageCode()));
  }
  
  private static void addStatisticsInnerParam(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    EventStatisticsManager.getInstance().addStatisticsInnerParam(paramString1, paramString2, paramMap);
  }
  
  public static void handle(Object paramObject, @Nullable FinalData paramFinalData)
  {
    innerHandler(paramObject, paramFinalData, false, false);
  }
  
  public static void handleInMainThread(Object paramObject, @Nullable FinalData paramFinalData)
  {
    innerHandler(paramObject, paramFinalData, true, false);
  }
  
  public static void handleWithStash(Object paramObject, @Nullable FinalData paramFinalData)
  {
    innerHandler(paramObject, paramFinalData, false, true);
  }
  
  public static void handleWithoutFormat(Object paramObject, @Nullable FinalData paramFinalData, String paramString)
  {
    if (paramFinalData == null) {
      return;
    }
    ArrayMap localArrayMap = new ArrayMap();
    addRealtimeExternalParams(localArrayMap);
    addRealtimeInnerParam(localArrayMap);
    ThreadUtils.execTask(new FinalDataTarget.2(localArrayMap, paramString, paramFinalData, paramObject), false);
  }
  
  private static void innerHandler(Object paramObject, @Nullable FinalData paramFinalData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramFinalData == null) {
      return;
    }
    ArrayMap localArrayMap = new ArrayMap();
    addRealtimeExternalParams(localArrayMap);
    addRealtimeInnerParam(localArrayMap);
    notifyListener(paramObject, paramFinalData, localArrayMap);
    ThreadUtils.execTask(new FinalDataTarget.3(localArrayMap, paramFinalData, paramBoolean2, paramObject), paramBoolean1);
  }
  
  private static void notifyListener(Object paramObject, @NonNull FinalData paramFinalData, @NonNull Map<String, Object> paramMap)
  {
    FinalDataTarget.NotifyCallbackImpl localNotifyCallbackImpl = (FinalDataTarget.NotifyCallbackImpl)sNotifyCallbacks.get();
    localNotifyCallbackImpl.setNotifyData(paramObject, paramFinalData, paramMap);
    sListenerMgr.startNotify(localNotifyCallbackImpl);
    localNotifyCallbackImpl.reset();
  }
  
  private static void recycleObject(@NonNull FinalData paramFinalData)
  {
    paramFinalData.reset();
    ThreadUtils.runOnUiThread(new FinalDataTarget.4(paramFinalData));
  }
  
  public static void registerListener(FinalDataTarget.IFinalDataHandleListener paramIFinalDataHandleListener)
  {
    sListenerMgr.register(paramIFinalDataHandleListener);
  }
  
  private static void reportByInner(Object paramObject, String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    Iterator localIterator = VideoReportInner.getInstance().getInnerReporters().iterator();
    while (localIterator.hasNext())
    {
      IInnerReporter localIInnerReporter = (IInnerReporter)localIterator.next();
      if (localIInnerReporter != null) {
        localIInnerReporter.report(paramObject, paramString1, paramMap, paramString2);
      }
    }
  }
  
  private static void reportByOuter(Object paramObject, String paramString, Map<String, Object> paramMap)
  {
    Iterator localIterator = VideoReportInner.getInstance().getReporter().iterator();
    while (localIterator.hasNext())
    {
      IReporter localIReporter = (IReporter)localIterator.next();
      if (localIReporter != null) {
        localIReporter.report(paramObject, paramString, paramMap);
      }
    }
  }
  
  private static void reportEvent(Object paramObject, String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      reportByOuter(paramObject, paramString1, paramMap);
    } else {
      reportByInner(paramObject, paramString1, paramMap, paramString2);
    }
    EventStashManager.getInstance().cancelStashEvent(paramString1, paramMap);
  }
  
  public static void reportStashEvent(Object paramObject, String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    addStatisticsInnerParam(paramString2, paramString1, paramMap);
    reportEvent(paramObject, paramString1, paramMap, paramString2);
  }
  
  private static void stashEvent(String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    EventStashManager.getInstance().stashEvent(paramString1, paramMap, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.FinalDataTarget
 * JD-Core Version:    0.7.0.1
 */