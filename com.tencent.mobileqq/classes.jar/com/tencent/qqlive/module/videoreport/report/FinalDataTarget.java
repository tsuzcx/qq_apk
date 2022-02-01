package com.tencent.qqlive.module.videoreport.report;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.IInnerReporter;
import com.tencent.qqlive.module.videoreport.IReporter;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
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
    innerHandler(paramObject, paramFinalData, false);
  }
  
  public static void handleInMainThread(Object paramObject, @Nullable FinalData paramFinalData)
  {
    innerHandler(paramObject, paramFinalData, true);
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
  
  private static void innerHandler(Object paramObject, @Nullable FinalData paramFinalData, boolean paramBoolean)
  {
    if (paramFinalData == null) {
      return;
    }
    ArrayMap localArrayMap = new ArrayMap();
    addRealtimeExternalParams(localArrayMap);
    addRealtimeInnerParam(localArrayMap);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("innner handler ");
    localStringBuilder.append(paramFinalData.eventKey);
    Log.e("jack", localStringBuilder.toString());
    notifyListener(paramObject, paramFinalData, localArrayMap);
    ThreadUtils.execTask(new FinalDataTarget.3(localArrayMap, paramFinalData, paramObject), paramBoolean);
  }
  
  private static void notifyListener(Object paramObject, @NonNull FinalData paramFinalData, @NonNull Map<String, Object> paramMap)
  {
    FinalDataTarget.NotifyCallbackImpl localNotifyCallbackImpl = (FinalDataTarget.NotifyCallbackImpl)sNotifyCallbacks.get();
    localNotifyCallbackImpl.setNotifyData(paramObject, paramFinalData, paramMap);
    sListenerMgr.startNotify(localNotifyCallbackImpl);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.FinalDataTarget
 * JD-Core Version:    0.7.0.1
 */