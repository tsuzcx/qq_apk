package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.VideoEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VideoPageReporter
  implements PageManager.IPageListener
{
  private static final String TAG = "VideoPageListener";
  
  private void forceReportStartEvent()
  {
    if (!VideoPageUtils.isStartOpen()) {
      return;
    }
    Object localObject = VideoReportManager.getInstance().getPlayerInfoMap();
    if (((Map)localObject).isEmpty())
    {
      Log.w("VideoPageListener", "playerInfoMap is empty!");
      return;
    }
    localObject = ((Map)localObject).values();
    if (((Collection)localObject).isEmpty()) {
      return;
    }
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      VideoSession localVideoSession = ((VideoReportFlowInfo)((Iterator)localObject).next()).getVideoSession();
      if (localVideoSession == null) {
        Log.w("VideoPageListener", "session is null!");
      } else if (localVideoSession.isIgnoreReport()) {
        Log.w("VideoPageListener", "ignore, not need report!");
      } else if (!localVideoSession.isForceReportStart()) {
        Log.w("VideoPageListener", "isForceReportStart is false");
      } else {
        updateStartParamsAndReportStart(localVideoSession);
      }
    }
  }
  
  public static VideoPageReporter getInstance()
  {
    return VideoPageReporter.InstanceHolder.access$000();
  }
  
  private void init()
  {
    PageManager.getInstance().register(this);
  }
  
  private void updateStartParamsAndReportStart(@NonNull VideoSession paramVideoSession)
  {
    Map localMap1 = paramVideoSession.getStartParams();
    if (localMap1 == null)
    {
      Log.w("VideoPageListener", "startParams is null");
      return;
    }
    Map localMap2 = VideoPageUtils.getCurPageInfo("dt_video_start", paramVideoSession);
    if (localMap2 == null)
    {
      Log.w("VideoPageListener", "updateStartParamsAndReportStart page is null");
      return;
    }
    localMap1.put("cur_pg", localMap2);
    VideoEventReporter.getInstance().reportVideoStart(null, localMap1);
    paramVideoSession.setForceReportStart(false);
    paramVideoSession.setStartParams(null);
  }
  
  public void onPageIn(@NonNull PageInfo paramPageInfo, @NonNull Set<PageInfo> paramSet, int paramInt)
  {
    Log.i("VideoPageListener", "onPageIn");
    forceReportStartEvent();
  }
  
  public void onPageOut(@NonNull PageInfo paramPageInfo, @NonNull Set<PageInfo> paramSet, boolean paramBoolean) {}
  
  public void onPageUpdate(PageInfo paramPageInfo, int paramInt)
  {
    Log.i("VideoPageListener", "onPageUpdate");
    forceReportStartEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoPageReporter
 * JD-Core Version:    0.7.0.1
 */