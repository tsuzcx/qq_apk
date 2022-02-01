package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.dtreport.video.VideoEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqlive.module.videoreport.report.element.ReversedDataCollector;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.lang.ref.WeakReference;
import java.util.Map;

public class VideoPageUtils
{
  private static final String COULD_NOT_FIND_PAGEINFO_MSG = "Could not find PageInfo";
  private static final String TAG = "VideoPageUtils";
  
  private static Map<String, Object> formatPage(ReportData paramReportData)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (paramReportData != null)
    {
      localArrayMap.put("pgid", paramReportData.getId());
      BaseUtils.copyTo(paramReportData.getParams(), localArrayMap);
    }
    if (localArrayMap.isEmpty()) {
      return null;
    }
    return localArrayMap;
  }
  
  public static Map<String, Object> getCurPageInfo(String paramString, @NonNull VideoSession paramVideoSession)
  {
    long l1 = System.currentTimeMillis();
    paramVideoSession = paramVideoSession.getVideoView();
    if (paramVideoSession == null)
    {
      Log.i("VideoPageUtils", "videoViewWR is null");
      return null;
    }
    paramVideoSession = (View)paramVideoSession.get();
    if (paramVideoSession == null)
    {
      Log.i("VideoPageUtils", "videoView is null");
      return null;
    }
    paramString = getPageData(paramString, ReversedDataCollector.collect(paramVideoSession));
    if (paramString == null) {
      return null;
    }
    paramString = formatPage(paramString);
    if (paramString == null) {
      return null;
    }
    long l2 = System.currentTimeMillis();
    paramVideoSession = new StringBuilder();
    paramVideoSession.append("getCurPageInfo: cost time:");
    paramVideoSession.append(l2 - l1);
    paramVideoSession.append("   ----->result is: ");
    paramVideoSession.append(paramString);
    Log.i("VideoPageUtils", paramVideoSession.toString());
    return paramString;
  }
  
  private static ReportData getPageData(String paramString, PathData paramPathData)
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
  
  public static boolean isEndOpen()
  {
    return (VideoReportInner.getInstance().getConfiguration().getVideoPageSwitch() == 3) || (VideoReportInner.getInstance().getConfiguration().getVideoPageSwitch() == 2);
  }
  
  private static boolean isMainThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public static boolean isNeedGetPageInfo(String paramString, @NonNull VideoSession paramVideoSession)
  {
    boolean bool2 = shouldReportStart(paramVideoSession);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (paramVideoSession.getCurPage() != null) {
      return false;
    }
    if (getCurPageInfo(paramString, paramVideoSession) == null) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean isShowToast()
  {
    return (VideoReportInner.getInstance().isDebugMode()) && (VideoReportInner.getInstance().getConfiguration().isEnableToast());
  }
  
  public static boolean isStartOpen()
  {
    int i = VideoReportInner.getInstance().getConfiguration().getVideoPageSwitch();
    boolean bool = true;
    if (i != 3)
    {
      if (VideoReportInner.getInstance().getConfiguration().getVideoPageSwitch() == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static void reportOrSaveStartEvent(Object paramObject, @NonNull VideoSession paramVideoSession)
  {
    if (shouldReportStart(paramVideoSession))
    {
      Map localMap = getCurPageInfo("dt_video_start", paramVideoSession);
      if (localMap == null)
      {
        paramVideoSession.setForceReportStart(true);
        VideoEventReporter.getInstance().saveStartedEventInMemory(paramVideoSession);
        showToast();
        return;
      }
      paramVideoSession.setCurPage(localMap);
      VideoEventReporter.getInstance().reportVideoStart(paramObject, paramVideoSession);
      return;
    }
    VideoEventReporter.getInstance().reportVideoStart(paramObject, paramVideoSession);
  }
  
  public static void saveStartEvent(Object paramObject, @NonNull VideoSession paramVideoSession)
  {
    if (shouldReportStart(paramVideoSession))
    {
      Map localMap = getCurPageInfo("dt_video_start", paramVideoSession);
      if (localMap == null) {
        showToast();
      } else {
        paramVideoSession.setCurPage(localMap);
      }
    }
    VideoEventReporter.getInstance().stashVideoStart(paramObject, paramVideoSession);
  }
  
  private static boolean shouldReportEnd(@NonNull VideoSession paramVideoSession)
  {
    return (isEndOpen()) && (paramVideoSession.getVideoView() != null) && (paramVideoSession.getVideoView().get() != null);
  }
  
  private static boolean shouldReportStart(@NonNull VideoSession paramVideoSession)
  {
    return (isStartOpen()) && (paramVideoSession.getVideoView() != null) && (paramVideoSession.getVideoView().get() != null);
  }
  
  private static void showToast()
  {
    if ((isShowToast()) && (isMainThread())) {
      Toast.makeText(ReportUtils.getContext(), "Could not find PageInfo", 0).show();
    }
  }
  
  public static void updateVideoSession(String paramString, @NonNull VideoSession paramVideoSession)
  {
    if (!shouldReportStart(paramVideoSession))
    {
      Log.i("VideoPageUtils", "updateVideoSession not need report current page");
      return;
    }
    if (paramVideoSession.getCurPage() != null)
    {
      Log.i("VideoPageUtils", "updateVideoSession current page not null");
      return;
    }
    paramString = getCurPageInfo(paramString, paramVideoSession);
    if (paramString != null) {
      paramVideoSession.setCurPage(paramString);
    }
  }
  
  public static void updateVideoSessionOnPlayEnd(@NonNull VideoSession paramVideoSession)
  {
    if (!shouldReportEnd(paramVideoSession))
    {
      Log.i("VideoPageUtils", "updateVideoSessionOnPlayEnd not need report current page");
      return;
    }
    Map localMap = getCurPageInfo("dt_video_end", paramVideoSession);
    if (localMap != null) {
      paramVideoSession.setCurPage(localMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoPageUtils
 * JD-Core Version:    0.7.0.1
 */