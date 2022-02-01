package com.tencent.qqlive.module.videoreport.dtreport.video;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.HashMap;
import java.util.Map;

public class VideoEventReporter
{
  private static final String TAG = "VideoEventReporter";
  
  private VideoEventReporter()
  {
    Log.i("VideoEventReporter", "VideoEventReporter create!");
  }
  
  public static VideoEventReporter getInstance()
  {
    return VideoEventReporter.InstanceHolder.access$000();
  }
  
  private Map<String, Object> prepareEndParams(@NonNull VideoSession paramVideoSession)
  {
    HashMap localHashMap = new HashMap();
    if (paramVideoSession.getCustomParams() != null) {
      localHashMap.putAll(paramVideoSession.getCustomParams());
    }
    localHashMap.put("dt_video_contentid", paramVideoSession.getContentId());
    localHashMap.put("dt_end_reason", paramVideoSession.getPlayEndReason());
    localHashMap.put("dt_play_end_state_time", String.valueOf(paramVideoSession.getEndPosition()));
    localHashMap.put("dt_video_length", paramVideoSession.getVideoDuration());
    localHashMap.put("dt_play_duration", paramVideoSession.getPlayedTime());
    localHashMap.put("dt_play_start_state_time", String.valueOf(paramVideoSession.getStartPosition()));
    return localHashMap;
  }
  
  private Map<String, Object> prepareStartParams(@NonNull VideoSession paramVideoSession)
  {
    HashMap localHashMap = new HashMap();
    if (paramVideoSession.getCustomParams() != null) {
      localHashMap.putAll(paramVideoSession.getCustomParams());
    }
    localHashMap.put("dt_content_type", String.valueOf(paramVideoSession.getContentType()));
    localHashMap.put("dt_video_contentid", paramVideoSession.getContentId());
    localHashMap.put("dt_start_type", paramVideoSession.getStartPlayType());
    localHashMap.put("dt_start_reason", paramVideoSession.getStartPlayReason());
    return localHashMap;
  }
  
  public void reportVideoEnd(Object paramObject, VideoSession paramVideoSession)
  {
    if (paramVideoSession == null)
    {
      Log.w("VideoEventReporter", "reportVideoEnd, videoSession is null");
      return;
    }
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("dt_video_end");
    localFinalData.putAll(prepareEndParams(paramVideoSession));
    paramVideoSession = VideoReportInner.getInstance().getEventDynamicParams();
    if (paramVideoSession != null) {
      paramVideoSession.setEventDynamicParams("dt_video_end", localFinalData.getEventParams());
    }
    FinalDataTarget.handle(paramObject, localFinalData);
  }
  
  public void reportVideoStart(Object paramObject, VideoSession paramVideoSession)
  {
    if (paramVideoSession == null)
    {
      Log.w("VideoEventReporter", "reportVideoStart, videoSession is null");
      return;
    }
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("dt_video_start");
    localFinalData.putAll(prepareStartParams(paramVideoSession));
    paramVideoSession = VideoReportInner.getInstance().getEventDynamicParams();
    if (paramVideoSession != null) {
      paramVideoSession.setEventDynamicParams("dt_video_start", localFinalData.getEventParams());
    }
    FinalDataTarget.handle(paramObject, localFinalData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.VideoEventReporter
 * JD-Core Version:    0.7.0.1
 */