package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.dtreport.video.VideoEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoDataManager;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import java.util.HashMap;
import java.util.Map;

public class VideoReportManager
{
  private static final String TAG = "VideoReportManager";
  private Map<Integer, VideoSession> bindVideoInfoMap = new HashMap();
  private VideoSession currentSession = null;
  private Map<String, VideoSession> historyPlayInfo = new HashMap();
  private VideoSession lastAdSession = null;
  private VideoSession lastVideoSession = null;
  private Map<Integer, Object> playerReportInfoMap = new HashMap();
  private Map<Integer, Integer> playerReportManagerMap = new HashMap();
  private Object syncObject = new Object();
  private Map<Integer, Long> videoStartPosition = new HashMap();
  private Map<Integer, Integer> videoState = new HashMap();
  
  private VideoReportManager()
  {
    Log.i("VideoReportManager", "create VideoReportManager!");
  }
  
  private void addHistoryPlayInfo(@NonNull VideoSession paramVideoSession)
  {
    this.historyPlayInfo.remove(paramVideoSession.getContentId());
    this.historyPlayInfo.put(paramVideoSession.getContentId(), paramVideoSession);
  }
  
  private void changeState(@NonNull Object paramObject, int paramInt)
  {
    this.videoState.remove(Integer.valueOf(paramObject.hashCode()));
    this.videoState.put(Integer.valueOf(paramObject.hashCode()), Integer.valueOf(paramInt));
  }
  
  private void dealPlayEnd(Object paramObject, int paramInt1, int paramInt2, String paramString)
  {
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    if (getPlayerState(paramObject) != 2)
    {
      Log.w("VideoReportManager", "state error，no need report! state=" + VideoReportPlayerUtils.stateToString(getPlayerState(paramObject)));
      VideoReportPlayerUtils.debugEnd(paramString, localDebugTime);
      return;
    }
    VideoSession localVideoSession = VideoDataManager.getInstance().getVideoInfo(paramObject);
    if (localVideoSession == null)
    {
      Log.w("VideoReportManager", paramString + " session is null!");
      VideoReportPlayerUtils.debugEnd(paramString, localDebugTime);
      return;
    }
    localVideoSession.end(VideoReportPlayerUtils.getCurrentPosition(paramObject), paramInt1);
    VideoEventReporter.getInstance().reportVideoEnd(paramObject, localVideoSession);
    addHistoryPlayInfo(localVideoSession);
    changeState(paramObject, paramInt2);
    VideoReportPlayerUtils.debugEnd(paramString, localDebugTime);
  }
  
  public static VideoReportManager getInstance()
  {
    return VideoReportManager.InstanceHolder.sInstance;
  }
  
  private int getPlayerState(Object paramObject)
  {
    if (this.videoState.get(Integer.valueOf(paramObject.hashCode())) != null) {
      return ((Integer)this.videoState.get(Integer.valueOf(paramObject.hashCode()))).intValue();
    }
    return -1;
  }
  
  private boolean isContinuePlay(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong1 - paramLong2) <= 2000L;
  }
  
  private boolean isCurrentVideoSessionValid(VideoSession paramVideoSession)
  {
    try
    {
      synchronized (this.syncObject)
      {
        if (this.bindVideoInfoMap.containsValue(paramVideoSession)) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramVideoSession)
    {
      Log.w("VideoReportManager", "isCurrentVideoSessionValid," + paramVideoSession.toString());
    }
  }
  
  private boolean isPlayAd(Object paramObject)
  {
    if ((this.playerReportManagerMap.containsKey(Integer.valueOf(paramObject.hashCode()))) && (this.playerReportManagerMap.get(Integer.valueOf(paramObject.hashCode())) != null))
    {
      int i = ((Integer)this.playerReportManagerMap.get(Integer.valueOf(paramObject.hashCode()))).intValue();
      if (this.playerReportInfoMap.containsKey(Integer.valueOf(i))) {
        return VideoReportPlayerUtils.isPlayAdByPlayer(this.playerReportInfoMap.get(Integer.valueOf(i)));
      }
    }
    return false;
  }
  
  private int playType(VideoSession paramVideoSession)
  {
    int j = 1;
    VideoSession localVideoSession;
    if (1 != paramVideoSession.getContentType())
    {
      localVideoSession = this.lastVideoSession;
      this.lastVideoSession = this.currentSession;
    }
    for (;;)
    {
      int i = j;
      if (localVideoSession != null)
      {
        i = j;
        if (!TextUtils.isEmpty(localVideoSession.getContentId()))
        {
          i = j;
          if (localVideoSession.getContentId().equals(paramVideoSession.getContentId())) {
            i = 2;
          }
        }
      }
      return i;
      localVideoSession = this.lastAdSession;
      this.lastAdSession = this.currentSession;
    }
  }
  
  private void putVideoInfoMap(int paramInt, VideoSession paramVideoSession)
  {
    synchronized (this.syncObject)
    {
      this.bindVideoInfoMap.put(Integer.valueOf(paramInt), paramVideoSession);
      return;
    }
  }
  
  private void removeVideoInfoMap(int paramInt)
  {
    synchronized (this.syncObject)
    {
      this.bindVideoInfoMap.remove(Integer.valueOf(paramInt));
      return;
    }
  }
  
  private int startPlayReason(VideoSession paramVideoSession, long paramLong)
  {
    VideoSession localVideoSession = (VideoSession)this.historyPlayInfo.get(paramVideoSession.getContentId());
    if ((localVideoSession != null) && (isContinuePlay(paramLong, localVideoSession.getEndPosition())))
    {
      if (paramVideoSession.getPageId() == localVideoSession.getPageId()) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  private long startPosition(Object paramObject)
  {
    long l = 0L;
    if (getPlayerState(paramObject) == 1)
    {
      if (this.videoStartPosition.get(Integer.valueOf(paramObject.hashCode())) != null) {
        l = ((Long)this.videoStartPosition.get(Integer.valueOf(paramObject.hashCode()))).longValue();
      }
      return l;
    }
    return VideoReportPlayerUtils.getCurrentPosition(paramObject);
  }
  
  public void bindVideoInfo(@NonNull Object paramObject, @NonNull VideoEntity paramVideoEntity)
  {
    if (!DTConfigConstants.config.videoReportSupport())
    {
      Log.w("VideoReportManager", "bindVideoInfo, videoReport not support!");
      return;
    }
    Log.i("VideoReportManager", "bindVideoInfo, instance=" + paramObject);
    this.currentSession = new VideoSession(paramVideoEntity);
    putVideoInfoMap(paramObject.hashCode(), this.currentSession);
  }
  
  public void getReportManager(Object paramObject1, Object paramObject2)
  {
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    Log.i("VideoReportManager", "getReportManager ptr=" + paramObject1 + ",reportManager=" + paramObject2);
    this.playerReportManagerMap.remove(Integer.valueOf(paramObject1.hashCode()));
    this.playerReportManagerMap.put(Integer.valueOf(paramObject2.hashCode()), Integer.valueOf(paramObject1.hashCode()));
    VideoReportPlayerUtils.debugEnd("getReportManager", localDebugTime);
  }
  
  public void onCompletion(Object paramObject)
  {
    Log.i("VideoReportManager", "onCompletion ptr=" + paramObject);
    dealPlayEnd(paramObject, 2, 4, "onCompletion");
  }
  
  public void onError(Object paramObject, int paramInt1, int paramInt2)
  {
    Log.i("VideoReportManager", "onError ptr=" + paramObject);
    dealPlayEnd(paramObject, 1, 4, "onError");
  }
  
  public void onInfo(Object paramObject, int paramInt, long paramLong1, long paramLong2)
  {
    if (getPlayerState(paramObject) != 2) {}
    do
    {
      return;
      if (paramInt == VideoReportPlayerUtils.convertEventIdToPlayer(1))
      {
        Log.i("VideoReportManager", "onInfo bufferStart,ptr=" + paramObject);
        localDebugTime = VideoReportPlayerUtils.debugStart();
        paramObject = VideoDataManager.getInstance().getVideoInfo(paramObject);
        if (paramObject != null) {
          paramObject.bufferStart();
        }
        VideoReportPlayerUtils.debugEnd("onInfo", localDebugTime);
        return;
      }
    } while (paramInt != VideoReportPlayerUtils.convertEventIdToPlayer(2));
    Log.i("VideoReportManager", "onInfo bufferEnd,ptr=" + paramObject);
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    paramObject = VideoDataManager.getInstance().getVideoInfo(paramObject);
    if (paramObject != null) {
      paramObject.bufferEnd();
    }
    VideoReportPlayerUtils.debugEnd("onInfo", localDebugTime);
  }
  
  public void onPrepared(Object paramObject)
  {
    Log.i("VideoReportManager", "onPrepared, ptr=" + paramObject);
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    if (paramObject != null) {
      changeState(paramObject, 1);
    }
    VideoReportPlayerUtils.debugEnd("onPrepared", localDebugTime);
  }
  
  public void pause(Object paramObject)
  {
    Log.i("VideoReportManager", "pause, ptr=" + paramObject);
    dealPlayEnd(paramObject, 3, 3, "pause");
  }
  
  public void release(Object paramObject)
  {
    Log.i("VideoReportManager", "release ,ptr=" + paramObject);
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    this.videoStartPosition.remove(Integer.valueOf(paramObject.hashCode()));
    this.videoState.remove(Integer.valueOf(paramObject.hashCode()));
    VideoDataManager.getInstance().removeVideoInfo(paramObject);
    if (this.playerReportManagerMap.containsKey(Integer.valueOf(paramObject.hashCode()))) {
      this.playerReportInfoMap.remove(this.playerReportManagerMap.get(Integer.valueOf(paramObject.hashCode())));
    }
    this.playerReportManagerMap.remove(Integer.valueOf(paramObject.hashCode()));
    VideoReportPlayerUtils.debugEnd("release", localDebugTime);
  }
  
  public void reset(Object paramObject)
  {
    Log.i("VideoReportManager", "reset, ptr=" + paramObject);
    dealPlayEnd(paramObject, 2, 4, "reset");
  }
  
  public void setReportInfo(Object paramObject1, Object paramObject2)
  {
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    Log.i("VideoReportManager", "setReportInfo,ptr=" + paramObject1);
    this.playerReportInfoMap.remove(Integer.valueOf(paramObject1.hashCode()));
    this.playerReportInfoMap.put(Integer.valueOf(paramObject1.hashCode()), paramObject2);
    VideoReportPlayerUtils.debugEnd("setReportInfo", localDebugTime);
  }
  
  public void setStartPosition(Object paramObject1, Object paramObject2)
  {
    Log.i("VideoReportManager", "setStartPosition,ptr=" + paramObject1);
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    if ((paramObject1 != null) && (VideoReportPlayerUtils.isSetStartPosition(paramObject2)))
    {
      long l = VideoReportPlayerUtils.getStartPosition(paramObject2);
      Log.i("VideoReportManager", "setStartPosition,positioin =" + l);
      this.videoStartPosition.put(Integer.valueOf(paramObject1.hashCode()), Long.valueOf(l));
    }
    VideoReportPlayerUtils.debugEnd("setStartPosition", localDebugTime);
  }
  
  public void start(Object paramObject)
  {
    Log.i("VideoReportManager", "start, ptr=" + paramObject);
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    if (this.currentSession == null)
    {
      Log.w("VideoReportManager", "not bind player. no need report!");
      VideoReportPlayerUtils.debugEnd("start", localDebugTime);
      return;
    }
    if (getPlayerState(paramObject) == 2)
    {
      Log.w("VideoReportManager", "state error，no need report! state=" + VideoReportPlayerUtils.stateToString(getPlayerState(paramObject)));
      VideoReportPlayerUtils.debugEnd("start", localDebugTime);
      return;
    }
    if (!isCurrentVideoSessionValid(this.currentSession))
    {
      Log.w("VideoReportManager", "has unbind player. no need report!");
      VideoReportPlayerUtils.debugEnd("start", localDebugTime);
      return;
    }
    if ((1 != this.currentSession.getContentType()) && (isPlayAd(paramObject))) {
      this.currentSession.setContentType(1);
    }
    VideoDataManager.getInstance().bindVideoInfo(paramObject, this.currentSession);
    VideoSession localVideoSession = this.currentSession;
    int i = playType(this.currentSession);
    long l = startPosition(paramObject);
    localVideoSession.start(startPlayReason(localVideoSession, l), l, i);
    VideoEventReporter.getInstance().reportVideoStart(paramObject, localVideoSession);
    changeState(paramObject, 2);
    VideoReportPlayerUtils.debugEnd("start", localDebugTime);
  }
  
  public void stop(Object paramObject)
  {
    Log.i("VideoReportManager", "stop, ptr=" + paramObject);
    dealPlayEnd(paramObject, 2, 4, "stop");
  }
  
  public void unbindVideoInfo(@NonNull Object paramObject)
  {
    if (!DTConfigConstants.config.videoReportSupport())
    {
      Log.w("VideoReportManager", "unbindVideoInfo, videoReport not support!");
      return;
    }
    Log.i("VideoReportManager", "unbindVideoInfo, instance=" + paramObject);
    removeVideoInfoMap(paramObject.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager
 * JD-Core Version:    0.7.0.1
 */