package com.tencent.qqlive.module.videoreport.dtreport.video;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoPlayRecorder;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoHeartBeatSpUtils;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoPageUtils;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
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
    localHashMap.put("dt_content_type", String.valueOf(paramVideoSession.getContentType()));
    localHashMap.put("dt_start_type", paramVideoSession.getStartPlayType());
    localHashMap.put("dt_start_reason", paramVideoSession.getStartPlayReason());
    localHashMap.put("dt_video_starttime", Long.valueOf(paramVideoSession.getVideoStartTime()));
    localHashMap.put("dt_video_endtime", Long.valueOf(paramVideoSession.getVideoEndTime()));
    localHashMap.put("dt_seek_record", paramVideoSession.getSeekRecord());
    localHashMap.put("dt_speed_ratio", paramVideoSession.getSpeedRatioRecord());
    localHashMap.put("dt_sum_play_duration", Long.valueOf(VideoPlayRecorder.getSumPlayDuration(paramVideoSession)));
    localHashMap.put("dt_video_index", Integer.valueOf(VideoPlayRecorder.getVideoIndex(paramVideoSession)));
    if (VideoPageUtils.isEndOpen()) {
      setCurPageParam(localHashMap, paramVideoSession);
    }
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
    localHashMap.put("dt_play_start_state_time", String.valueOf(paramVideoSession.getStartPosition()));
    localHashMap.put("dt_video_length", paramVideoSession.getVideoDuration());
    localHashMap.put("dt_video_starttime", Long.valueOf(paramVideoSession.getVideoStartTime()));
    localHashMap.put("dt_video_index", Integer.valueOf(VideoPlayRecorder.getVideoIndex(paramVideoSession)));
    if (VideoPageUtils.isStartOpen()) {
      setCurPageParam(localHashMap, paramVideoSession);
    }
    return localHashMap;
  }
  
  private void setCurPageParam(Map<String, Object> paramMap, @NonNull VideoSession paramVideoSession)
  {
    paramVideoSession = paramVideoSession.getCurPage();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setCurPageParam pageInfo>>>");
    ((StringBuilder)localObject).append(paramVideoSession);
    Log.i("VideoEventReporter", ((StringBuilder)localObject).toString());
    if (paramVideoSession != null)
    {
      paramVideoSession = BaseUtils.copyNonNull(paramVideoSession);
      localObject = paramVideoSession.remove("ref_pg");
      if ((localObject instanceof Map)) {
        paramVideoSession.put("ref_pg", BaseUtils.copyNonNull((Map)localObject));
      }
      paramMap.put("cur_pg", paramVideoSession);
    }
  }
  
  public void reportVideoEnd(Object paramObject, VideoSession paramVideoSession)
  {
    if (paramVideoSession == null)
    {
      Log.w("VideoEventReporter", "reportVideoEnd, videoSession is null");
      return;
    }
    VideoPageUtils.updateVideoSessionOnPlayEnd(paramVideoSession);
    reportVideoEnd(paramObject, prepareEndParams(paramVideoSession));
  }
  
  public void reportVideoEnd(Object paramObject, Map<String, Object> paramMap)
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("dt_video_end");
    localFinalData.putAll(paramMap);
    paramMap = VideoReportInner.getInstance().getEventDynamicParams();
    if (paramMap != null) {
      paramMap.setEventDynamicParams("dt_video_end", localFinalData.getEventParams());
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
    reportVideoStart(paramObject, prepareStartParams(paramVideoSession));
  }
  
  public void reportVideoStart(Object paramObject, Map<String, Object> paramMap)
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("dt_video_start");
    localFinalData.putAll(paramMap);
    paramMap = VideoReportInner.getInstance().getEventDynamicParams();
    if (paramMap != null) {
      paramMap.setEventDynamicParams("dt_video_start", localFinalData.getEventParams());
    }
    FinalDataTarget.handle(paramObject, localFinalData);
  }
  
  public void saveEndEvent(VideoSession paramVideoSession)
  {
    VideoPageUtils.updateVideoSessionOnPlayEnd(paramVideoSession);
    VideoHeartBeatSpUtils.saveEndEvent(prepareEndParams(paramVideoSession));
  }
  
  public void saveStartedEventInMemory(@NonNull VideoSession paramVideoSession)
  {
    paramVideoSession.setStartParams(prepareStartParams(paramVideoSession));
  }
  
  public void stashVideoEnd(Object paramObject, VideoSession paramVideoSession)
  {
    VideoPageUtils.updateVideoSessionOnPlayEnd(paramVideoSession);
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("dt_video_end");
    localFinalData.putAll(prepareEndParams(paramVideoSession));
    paramVideoSession = VideoReportInner.getInstance().getEventDynamicParams();
    if (paramVideoSession != null) {
      paramVideoSession.setEventDynamicParams("dt_video_end", localFinalData.getEventParams());
    }
    FinalDataTarget.handleWithStash(paramObject, localFinalData);
  }
  
  public void stashVideoStart(Object paramObject, VideoSession paramVideoSession)
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("dt_video_start");
    localFinalData.putAll(prepareStartParams(paramVideoSession));
    paramVideoSession = VideoReportInner.getInstance().getEventDynamicParams();
    if (paramVideoSession != null) {
      paramVideoSession.setEventDynamicParams("dt_video_start", localFinalData.getEventParams());
    }
    FinalDataTarget.handleWithStash(paramObject, localFinalData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.VideoEventReporter
 * JD-Core Version:    0.7.0.1
 */