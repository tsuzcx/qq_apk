package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.dtreport.video.VideoEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity.Builder;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.OnInfoTaskManager;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoReportManager
{
  private static final String TAG = "VideoReportManager";
  private Map<Integer, VideoSession> bindVideoInfoMap = Collections.synchronizedMap(new LinkedHashMap());
  private VideoSession currentSession = null;
  private Map<String, VideoSession> historyPlayInfo = new HashMap();
  private VideoSession lastVideoSession = null;
  private OnInfoTaskManager onInfoTaskManager = new OnInfoTaskManager();
  private Map<Integer, VideoReportFlowInfo> playerInfoMap = new ConcurrentHashMap();
  private Map<Integer, Object> playerMap = new ConcurrentHashMap();
  private Map<Integer, Object> playerReportInfoMap = new HashMap();
  private final Object syncObject = new Object();
  
  private VideoReportManager()
  {
    Log.i("VideoReportManager", "create VideoReportManager!");
  }
  
  private void addHistoryPlayInfo(@NonNull VideoSession paramVideoSession)
  {
    String str = generateHistoryPlayInfoKey(paramVideoSession);
    this.historyPlayInfo.put(str, paramVideoSession);
  }
  
  private void changeState(@NonNull Object paramObject, int paramInt)
  {
    getValidReportFlowInfo(paramObject).setVideoState(paramInt);
  }
  
  private VideoSession createAdSessionFromVideoSession(Object paramObject, VideoSession paramVideoSession)
  {
    return new VideoSession(new VideoEntity.Builder().setContentId(paramVideoSession.getContentId()).addCustomParams(paramVideoSession.getCustomParams()).setContentType(1).bizReady(true).setVideoDuration(VideoReportPlayerUtils.getDuration(paramObject)).build(), new Object().hashCode());
  }
  
  private void dealPlayEnd(Object paramObject, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject1 = VideoReportPlayerUtils.debugStart();
    if (getPlayerState(paramObject) != 2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("state error，no need report! state=");
      ((StringBuilder)localObject2).append(VideoReportPlayerUtils.stateToString(getPlayerState(paramObject)));
      Log.w("VideoReportManager", ((StringBuilder)localObject2).toString());
      VideoReportPlayerUtils.debugEnd(paramString, (VideoReportPlayerUtils.DebugTime)localObject1);
      return;
    }
    Object localObject2 = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" playerInfo is null! ptr=");
      ((StringBuilder)localObject1).append(paramObject);
      Log.w("VideoReportManager", ((StringBuilder)localObject1).toString());
      return;
    }
    localObject2 = ((VideoReportFlowInfo)localObject2).getVideoSession();
    if (localObject2 == null)
    {
      paramObject = new StringBuilder();
      paramObject.append(paramString);
      paramObject.append(" session is null!");
      Log.w("VideoReportManager", paramObject.toString());
      VideoReportPlayerUtils.debugEnd(paramString, (VideoReportPlayerUtils.DebugTime)localObject1);
      return;
    }
    if (((VideoSession)localObject2).isIgnoreReport())
    {
      Log.w("VideoReportManager", "ignore, not need report!");
      VideoReportPlayerUtils.debugEnd(paramString, (VideoReportPlayerUtils.DebugTime)localObject1);
      return;
    }
    supplementReportOnPlayEnd(paramObject, (VideoSession)localObject2);
    ((VideoSession)localObject2).end(VideoReportPlayerUtils.getCurrentPosition(paramObject), paramInt1);
    changeState(paramObject, paramInt2);
    VideoEventReporter.getInstance().reportVideoEnd(paramObject, (VideoSession)localObject2);
    addHistoryPlayInfo((VideoSession)localObject2);
    VideoReportPlayerUtils.debugEnd(paramString, (VideoReportPlayerUtils.DebugTime)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("dealPlayEnd endReason:");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" ,endState:");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" ,endTag:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" ,ptr=");
    ((StringBuilder)localObject1).append(paramObject);
    Log.i("VideoReportManager", ((StringBuilder)localObject1).toString());
    VideoHeartBeatManager.getInstance().stopStagingHeartBeat();
  }
  
  private void dealPlayStart(Object paramObject, boolean paramBoolean)
  {
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    if (this.currentSession == null)
    {
      Log.w("VideoReportManager", "not bind player. no need report!");
      VideoReportPlayerUtils.debugEnd("start", localDebugTime);
      return;
    }
    if (getPlayerState(paramObject) == 2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("state error，no need report! state=");
      ((StringBuilder)localObject1).append(VideoReportPlayerUtils.stateToString(getPlayerState(paramObject)));
      Log.w("VideoReportManager", ((StringBuilder)localObject1).toString());
      VideoReportPlayerUtils.debugEnd("start", localDebugTime);
      return;
    }
    Object localObject2 = getCurrentPlaySession(paramObject);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[VideoPlayReport] dealPlayStart getCurrentPlaySession, ");
    ((StringBuilder)localObject1).append(VideoReportPlayerUtils.sessionLog((VideoSession)localObject2));
    Log.i("VideoReportManager", ((StringBuilder)localObject1).toString());
    if (((VideoSession)localObject2).isIgnoreReport())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ignore, not need report!, ptr=");
      ((StringBuilder)localObject1).append(paramObject);
      Log.w("VideoReportManager", ((StringBuilder)localObject1).toString());
      VideoReportPlayerUtils.debugEnd("start", localDebugTime);
      return;
    }
    int j = ((VideoSession)localObject2).getContentType();
    int i = 1;
    localObject1 = localObject2;
    if (1 != j)
    {
      localObject1 = localObject2;
      if (isPlayAd(paramObject))
      {
        localObject1 = createAdSessionFromVideoSession(paramObject, (VideoSession)localObject2);
        this.bindVideoInfoMap.put(Integer.valueOf(((VideoSession)localObject1).getVideoPlayerObject()), localObject1);
      }
    }
    if (!isCurrentVideoSessionValid((VideoSession)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("has unbind player. no need report!, ptr=");
      ((StringBuilder)localObject1).append(paramObject);
      Log.w("VideoReportManager", ((StringBuilder)localObject1).toString());
      VideoReportPlayerUtils.debugEnd("start", localDebugTime);
      return;
    }
    j = playType((VideoSession)localObject1);
    long l = startPosition(paramObject, paramBoolean);
    if (!paramBoolean) {
      i = startPlayReason((VideoSession)localObject1, l);
    }
    ((VideoSession)localObject1).start(i, l, j);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("start, isBizReady=");
    ((StringBuilder)localObject2).append(((VideoSession)localObject1).isBizReady());
    ((StringBuilder)localObject2).append(", ptr=");
    ((StringBuilder)localObject2).append(paramObject);
    Log.w("VideoReportManager", ((StringBuilder)localObject2).toString());
    if (((VideoSession)localObject1).isBizReady()) {
      VideoPageUtils.reportOrSaveStartEvent(paramObject, (VideoSession)localObject1);
    } else {
      VideoPageUtils.saveStartEvent(paramObject, (VideoSession)localObject1);
    }
    this.playerMap.put(Integer.valueOf(((VideoSession)localObject1).getVideoPlayerObject()), paramObject);
    localObject2 = getValidReportFlowInfo(paramObject);
    ((VideoReportFlowInfo)localObject2).setVideoSession((VideoSession)localObject1);
    ((VideoReportFlowInfo)localObject2).setPlayerObject(((VideoSession)localObject1).getVideoPlayerObject());
    changeState(paramObject, 2);
    VideoReportPlayerUtils.debugEnd("start", localDebugTime);
    VideoHeartBeatManager.getInstance().startStagingHeartBeat();
  }
  
  private String generateHistoryPlayInfoKey(@NonNull VideoSession paramVideoSession)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVideoSession.getContentId());
    localStringBuilder.append("_");
    localStringBuilder.append(paramVideoSession.getContentType());
    return localStringBuilder.toString();
  }
  
  private VideoSession getCurrentPlaySession(Object paramObject)
  {
    paramObject = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    if (paramObject == null) {
      return this.currentSession;
    }
    VideoSession localVideoSession = paramObject.getVideoSession();
    if (localVideoSession != null) {
      return localVideoSession;
    }
    paramObject = getSessionByReportInfo(this.playerReportInfoMap.get(Integer.valueOf(paramObject.getReportManager())));
    if (paramObject != null) {
      return paramObject;
    }
    return this.currentSession;
  }
  
  private VideoSession getHistoryPlayInfo(@NonNull VideoSession paramVideoSession)
  {
    paramVideoSession = generateHistoryPlayInfoKey(paramVideoSession);
    return (VideoSession)this.historyPlayInfo.get(paramVideoSession);
  }
  
  public static VideoReportManager getInstance()
  {
    return VideoReportManager.InstanceHolder.sInstance;
  }
  
  private int getPlayerState(Object paramObject)
  {
    paramObject = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    if (paramObject != null) {
      return paramObject.getVideoState();
    }
    return -1;
  }
  
  private VideoSession getSessionByReportInfo(Object paramObject)
  {
    String str = VideoReportPlayerUtils.getVidByReportInfo(paramObject);
    boolean bool = TextUtils.isEmpty(str);
    VideoSession localVideoSession = null;
    if (bool) {
      return null;
    }
    int i;
    if (VideoReportPlayerUtils.isPlayAdByPlayer(paramObject)) {
      i = 1;
    } else {
      i = 2;
    }
    synchronized (this.syncObject)
    {
      Iterator localIterator = this.bindVideoInfoMap.values().iterator();
      for (paramObject = localVideoSession; localIterator.hasNext(); paramObject = localVideoSession)
      {
        label63:
        localVideoSession = (VideoSession)localIterator.next();
        if ((!str.equals(localVideoSession.getIdentifier())) || (i != localVideoSession.getContentType())) {
          break label63;
        }
      }
      return paramObject;
    }
    for (;;)
    {
      throw paramObject;
    }
  }
  
  @NonNull
  private VideoReportFlowInfo getValidReportFlowInfo(Object paramObject)
  {
    VideoReportFlowInfo localVideoReportFlowInfo2 = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    VideoReportFlowInfo localVideoReportFlowInfo1 = localVideoReportFlowInfo2;
    if (localVideoReportFlowInfo2 == null)
    {
      localVideoReportFlowInfo1 = new VideoReportFlowInfo();
      this.playerInfoMap.put(Integer.valueOf(paramObject.hashCode()), localVideoReportFlowInfo1);
    }
    return localVideoReportFlowInfo1;
  }
  
  private boolean isContinuePlay(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong1 - paramLong2) <= 2000L;
  }
  
  private boolean isCurrentVideoSessionValid(VideoSession paramVideoSession)
  {
    return this.bindVideoInfoMap.containsValue(paramVideoSession);
  }
  
  private boolean isPlayAd(Object paramObject)
  {
    paramObject = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    if (paramObject != null)
    {
      int i = paramObject.getReportManager();
      return VideoReportPlayerUtils.isPlayAdByPlayer(this.playerReportInfoMap.get(Integer.valueOf(i)));
    }
    return false;
  }
  
  private int playType(VideoSession paramVideoSession)
  {
    int i;
    if (DTConfigConstants.config.newPlayTypeSupport()) {
      i = playTypeV2(paramVideoSession);
    } else {
      i = playTypeV1(paramVideoSession);
    }
    this.lastVideoSession = paramVideoSession;
    return i;
  }
  
  private int playTypeV1(VideoSession paramVideoSession)
  {
    VideoSession localVideoSession = this.lastVideoSession;
    if ((localVideoSession != null) && (TextUtils.equals(localVideoSession.getContentId(), paramVideoSession.getContentId()))) {
      return 2;
    }
    return 1;
  }
  
  private int playTypeV2(VideoSession paramVideoSession)
  {
    Iterator localIterator = this.historyPlayInfo.values().iterator();
    while (localIterator.hasNext())
    {
      VideoSession localVideoSession = (VideoSession)localIterator.next();
      if (TextUtils.equals(paramVideoSession.getContentId(), localVideoSession.getContentId())) {
        return 2;
      }
    }
    return 1;
  }
  
  private void reportStartEvent(Object paramObject, @NonNull VideoSession paramVideoSession)
  {
    if (paramVideoSession.getStartParams() != null)
    {
      VideoEventReporter.getInstance().reportVideoStart(paramObject, paramVideoSession.getStartParams());
      paramVideoSession.setStartParams(null);
    }
    else
    {
      VideoEventReporter.getInstance().reportVideoStart(paramObject, paramVideoSession);
    }
    paramVideoSession.bizReady();
    paramVideoSession.setForceReportStart(false);
  }
  
  private void resetSession(Object paramObject)
  {
    paramObject = getValidReportFlowInfo(paramObject);
    paramObject.setStartPosition(0L);
    paramObject.setLoopStartPositionMs(0L);
    paramObject.setVideoSession(null);
  }
  
  private int startPlayReason(VideoSession paramVideoSession, long paramLong)
  {
    VideoSession localVideoSession = getHistoryPlayInfo(paramVideoSession);
    int j = 1;
    int i = j;
    if (localVideoSession != null)
    {
      i = j;
      if (localVideoSession.getEndPosition() != 0L)
      {
        if (paramLong == 0L) {
          return 1;
        }
        i = j;
        if (isContinuePlay(paramLong, localVideoSession.getEndPosition()))
        {
          if (paramVideoSession.getPageId() == localVideoSession.getPageId()) {
            return 2;
          }
          i = 3;
        }
      }
    }
    return i;
  }
  
  private long startPosition(Object paramObject, boolean paramBoolean)
  {
    VideoReportFlowInfo localVideoReportFlowInfo = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    long l = 0L;
    if (paramBoolean)
    {
      if (localVideoReportFlowInfo != null) {
        l = localVideoReportFlowInfo.getLoopStartPositionMs();
      }
      return l;
    }
    if (getPlayerState(paramObject) == 1)
    {
      if (localVideoReportFlowInfo != null) {
        l = localVideoReportFlowInfo.getStartPosition();
      } else {
        l = 0L;
      }
      if (l > 0L) {
        return l;
      }
    }
    return VideoReportPlayerUtils.getCurrentPosition(paramObject);
  }
  
  private void supplementReport(Object paramObject, VideoSession paramVideoSession, boolean paramBoolean)
  {
    try
    {
      if ((!paramVideoSession.isBizReady()) && (paramBoolean))
      {
        paramBoolean = VideoPageUtils.isNeedGetPageInfo("dt_video_start", paramVideoSession);
        if (paramBoolean) {
          return;
        }
        reportStartEvent(paramObject, paramVideoSession);
      }
      return;
    }
    finally {}
  }
  
  private void supplementReportOnPlayEnd(Object paramObject, VideoSession paramVideoSession)
  {
    try
    {
      if ((!paramVideoSession.isBizReady()) || (paramVideoSession.isForceReportStart()))
      {
        VideoPageUtils.updateVideoSession("dt_video_end", paramVideoSession);
        reportStartEvent(paramObject, paramVideoSession);
      }
      return;
    }
    finally {}
  }
  
  private void updateBindVideoInfo(Object paramObject, VideoBaseEntity paramVideoBaseEntity)
  {
    paramObject = (VideoSession)this.bindVideoInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    if (paramObject == null) {
      return;
    }
    paramObject.updateVideoEntity(paramVideoBaseEntity);
    if (paramVideoBaseEntity.isBizReady()) {
      paramObject.bizReady();
    }
  }
  
  public void bindVideoInfo(@NonNull Object paramObject, @NonNull VideoEntity paramVideoEntity)
  {
    try
    {
      if (!DTConfigConstants.config.videoReportSupport())
      {
        Log.w("VideoReportManager", "bindVideoInfo, videoReport not support!");
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[VideoPlayReport] bindVideoInfo, ");
      ((StringBuilder)localObject1).append(VideoReportPlayerUtils.entityLog(paramVideoEntity));
      Log.i("VideoReportManager", ((StringBuilder)localObject1).toString());
      Object localObject3 = this.playerMap.get(Integer.valueOf(paramObject.hashCode()));
      Object localObject2 = null;
      localObject1 = null;
      if (localObject3 != null)
      {
        localObject2 = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(localObject3.hashCode()));
        if (localObject2 != null) {
          localObject1 = ((VideoReportFlowInfo)localObject2).getVideoSession();
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("bindVideoInfo, update entity, instance=");
          ((StringBuilder)localObject2).append(paramObject);
          Log.i("VideoReportManager", ((StringBuilder)localObject2).toString());
          ((VideoSession)localObject1).updateVideoEntity(paramVideoEntity);
          localObject2 = localObject1;
        }
      }
      if (localObject2 == null) {
        this.currentSession = new VideoSession(paramVideoEntity, paramObject.hashCode());
      } else {
        this.currentSession = ((VideoSession)localObject2);
      }
      this.bindVideoInfoMap.put(Integer.valueOf(paramObject.hashCode()), this.currentSession);
      return;
    }
    finally {}
  }
  
  public Map<Integer, VideoReportFlowInfo> getPlayerInfoMap()
  {
    return this.playerInfoMap;
  }
  
  public Map<Integer, Object> getPlayerMap()
  {
    return this.playerMap;
  }
  
  public void getReportManager(Object paramObject1, Object paramObject2)
  {
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getReportManager ptr=");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append(",reportManager=");
    localStringBuilder.append(paramObject2);
    Log.i("VideoReportManager", localStringBuilder.toString());
    getValidReportFlowInfo(paramObject1).setReportManager(paramObject2.hashCode());
    VideoReportPlayerUtils.debugEnd("getReportManager", localDebugTime);
  }
  
  public VideoReportFlowInfo getVideoReportFlowInfo(Object paramObject)
  {
    if (paramObject != null)
    {
      VideoReportFlowInfo localVideoReportFlowInfo = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVideoReportFlowInfo , ptr=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" ,flowInfo=");
      localStringBuilder.append(localVideoReportFlowInfo);
      Log.w("VideoReportManager", localStringBuilder.toString());
      return localVideoReportFlowInfo;
    }
    return null;
  }
  
  public void loopEnd(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loopEnd, ptr=");
    localStringBuilder.append(paramObject);
    Log.i("VideoReportManager", localStringBuilder.toString());
    dealPlayEnd(paramObject, 2, 4, "stop");
  }
  
  public void loopStart(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loopStart, ptr=");
    localStringBuilder.append(paramObject);
    Log.i("VideoReportManager", localStringBuilder.toString());
    dealPlayStart(paramObject, true);
  }
  
  public void onCompletion(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCompletion ptr=");
    localStringBuilder.append(paramObject);
    Log.i("VideoReportManager", localStringBuilder.toString());
    dealPlayEnd(paramObject, 2, 4, "onCompletion");
    resetSession(paramObject);
  }
  
  public void onError(Object paramObject, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError ptr=");
    localStringBuilder.append(paramObject);
    Log.i("VideoReportManager", localStringBuilder.toString());
    dealPlayEnd(paramObject, 1, 4, "onError");
    resetSession(paramObject);
  }
  
  public void onInfo(Object paramObject, int paramInt, long paramLong1, long paramLong2)
  {
    int i = getPlayerState(paramObject);
    this.onInfoTaskManager.doTask(i, paramObject, paramInt, paramLong1, paramLong2);
  }
  
  public void onPrepared(Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPrepared, ptr=");
    ((StringBuilder)localObject).append(paramObject);
    Log.i("VideoReportManager", ((StringBuilder)localObject).toString());
    localObject = VideoReportPlayerUtils.debugStart();
    if (paramObject != null) {
      changeState(paramObject, 1);
    }
    VideoReportPlayerUtils.debugEnd("onPrepared", (VideoReportPlayerUtils.DebugTime)localObject);
  }
  
  public void pause(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pause, ptr=");
    localStringBuilder.append(paramObject);
    Log.i("VideoReportManager", localStringBuilder.toString());
    dealPlayEnd(paramObject, 3, 3, "pause");
  }
  
  public void release(Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release ,ptr=");
    ((StringBuilder)localObject).append(paramObject);
    Log.i("VideoReportManager", ((StringBuilder)localObject).toString());
    localObject = VideoReportPlayerUtils.debugStart();
    VideoReportFlowInfo localVideoReportFlowInfo = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    if (localVideoReportFlowInfo != null)
    {
      this.bindVideoInfoMap.remove(Integer.valueOf(localVideoReportFlowInfo.getPlayerObject()));
      this.playerReportInfoMap.remove(Integer.valueOf(localVideoReportFlowInfo.getReportManager()));
      this.playerMap.remove(Integer.valueOf(localVideoReportFlowInfo.getPlayerObject()));
    }
    this.playerInfoMap.remove(Integer.valueOf(paramObject.hashCode()));
    VideoReportPlayerUtils.debugEnd("release", (VideoReportPlayerUtils.DebugTime)localObject);
  }
  
  public void reset(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reset, ptr=");
    localStringBuilder.append(paramObject);
    Log.i("VideoReportManager", localStringBuilder.toString());
    dealPlayEnd(paramObject, 2, 4, "reset");
    resetSession(paramObject);
  }
  
  public void seekTo(Object paramObject, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("seekTo, ptr=");
    ((StringBuilder)localObject1).append(paramObject);
    ((StringBuilder)localObject1).append(", positionMs=");
    ((StringBuilder)localObject1).append(paramInt);
    Log.i("VideoReportManager", ((StringBuilder)localObject1).toString());
    localObject1 = VideoReportPlayerUtils.debugStart();
    if (getPlayerState(paramObject) != 2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("state error，no need report! state=");
      ((StringBuilder)localObject2).append(VideoReportPlayerUtils.stateToString(getPlayerState(paramObject)));
      Log.w("VideoReportManager", ((StringBuilder)localObject2).toString());
      VideoReportPlayerUtils.debugEnd("seekTo", (VideoReportPlayerUtils.DebugTime)localObject1);
      return;
    }
    Object localObject2 = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("seekTo playerInfo is null! ptr=");
      ((StringBuilder)localObject1).append(paramObject);
      Log.w("VideoReportManager", ((StringBuilder)localObject1).toString());
      return;
    }
    localObject2 = ((VideoReportFlowInfo)localObject2).getVideoSession();
    if (localObject2 == null)
    {
      Log.w("VideoReportManager", "seekTo session is null!");
      VideoReportPlayerUtils.debugEnd("seekTo", (VideoReportPlayerUtils.DebugTime)localObject1);
      return;
    }
    ((VideoSession)localObject2).seekTo(VideoReportPlayerUtils.getCurrentPosition(paramObject), paramInt);
  }
  
  public void setLoopback(Object paramObject, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setLoopback,ptr=");
    ((StringBuilder)localObject).append(paramObject);
    Log.i("VideoReportManager", ((StringBuilder)localObject).toString());
    localObject = VideoReportPlayerUtils.debugStart();
    if ((paramBoolean) && (paramObject != null)) {
      getValidReportFlowInfo(paramObject).setLoopStartPositionMs(paramLong1);
    }
    VideoReportPlayerUtils.debugEnd("setLoopback", (VideoReportPlayerUtils.DebugTime)localObject);
  }
  
  public void setPlaySpeedRatio(Object paramObject, float paramFloat)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setPlaySpeedRatio, ptr=");
    ((StringBuilder)localObject1).append(paramObject);
    ((StringBuilder)localObject1).append(", speedRatio=");
    ((StringBuilder)localObject1).append(paramFloat);
    Log.i("VideoReportManager", ((StringBuilder)localObject1).toString());
    localObject1 = VideoReportPlayerUtils.debugStart();
    if (getPlayerState(paramObject) != 2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("state error，no need report! state=");
      ((StringBuilder)localObject2).append(VideoReportPlayerUtils.stateToString(getPlayerState(paramObject)));
      Log.w("VideoReportManager", ((StringBuilder)localObject2).toString());
      VideoReportPlayerUtils.debugEnd("setPlaySpeedRatio", (VideoReportPlayerUtils.DebugTime)localObject1);
      return;
    }
    Object localObject2 = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setPlaySpeedRatio playerInfo is null! ptr=");
      ((StringBuilder)localObject1).append(paramObject);
      Log.w("VideoReportManager", ((StringBuilder)localObject1).toString());
      return;
    }
    localObject2 = ((VideoReportFlowInfo)localObject2).getVideoSession();
    if (localObject2 == null)
    {
      Log.w("VideoReportManager", "setPlaySpeedRatio session is null!");
      VideoReportPlayerUtils.debugEnd("seekTo", (VideoReportPlayerUtils.DebugTime)localObject1);
      return;
    }
    ((VideoSession)localObject2).speedRatioPlay(paramFloat, VideoReportPlayerUtils.getCurrentPosition(paramObject));
  }
  
  public void setReportInfo(Object paramObject1, Object paramObject2)
  {
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setReportInfo,ptr=");
    localStringBuilder.append(paramObject1);
    Log.i("VideoReportManager", localStringBuilder.toString());
    this.playerReportInfoMap.remove(Integer.valueOf(paramObject1.hashCode()));
    this.playerReportInfoMap.put(Integer.valueOf(paramObject1.hashCode()), paramObject2);
    VideoReportPlayerUtils.debugEnd("setReportInfo", localDebugTime);
  }
  
  public void setStartPosition(Object paramObject1, Object paramObject2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setStartPosition,ptr=");
    ((StringBuilder)localObject).append(paramObject1);
    Log.i("VideoReportManager", ((StringBuilder)localObject).toString());
    localObject = VideoReportPlayerUtils.debugStart();
    if ((paramObject1 != null) && (VideoReportPlayerUtils.isSetStartPosition(paramObject2)))
    {
      long l = VideoReportPlayerUtils.getStartPosition(paramObject2);
      paramObject2 = new StringBuilder();
      paramObject2.append("setStartPosition,position =");
      paramObject2.append(l);
      Log.i("VideoReportManager", paramObject2.toString());
      getValidReportFlowInfo(paramObject1).setStartPosition(l);
    }
    VideoReportPlayerUtils.debugEnd("setStartPosition", (VideoReportPlayerUtils.DebugTime)localObject);
  }
  
  public void start(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlayReport] start -->, ptr=");
    localStringBuilder.append(paramObject);
    Log.i("VideoReportManager", localStringBuilder.toString());
    dealPlayStart(paramObject, false);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlayReport] start <--, ptr=");
    localStringBuilder.append(paramObject);
    Log.i("VideoReportManager", localStringBuilder.toString());
  }
  
  public void stop(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop, ptr=");
    localStringBuilder.append(paramObject);
    Log.i("VideoReportManager", localStringBuilder.toString());
    dealPlayEnd(paramObject, 2, 4, "stop");
    resetSession(paramObject);
  }
  
  public void unbindVideoInfo(@NonNull Object paramObject)
  {
    try
    {
      if (!DTConfigConstants.config.videoReportSupport())
      {
        Log.w("VideoReportManager", "unbindVideoInfo, videoReport not support!");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unbindVideoInfo, instance=");
      localStringBuilder.append(paramObject);
      Log.i("VideoReportManager", localStringBuilder.toString());
      this.bindVideoInfoMap.remove(Integer.valueOf(paramObject.hashCode()));
      return;
    }
    finally {}
  }
  
  public void updateVideoInfo(@NonNull Object paramObject, @NonNull VideoBaseEntity paramVideoBaseEntity)
  {
    try
    {
      if (!DTConfigConstants.config.videoReportSupport())
      {
        Log.w("VideoReportManager", "updateVideoInfo, videoReport not support!");
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateVideoInfo, instance=");
      ((StringBuilder)localObject1).append(paramObject);
      Log.i("VideoReportManager", ((StringBuilder)localObject1).toString());
      localObject1 = this.playerMap.get(Integer.valueOf(paramObject.hashCode()));
      if (localObject1 == null)
      {
        Log.w("VideoReportManager", "updateVideoInfo, no bind player");
        updateBindVideoInfo(paramObject, paramVideoBaseEntity);
        return;
      }
      Object localObject2 = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(localObject1.hashCode()));
      if (localObject2 == null)
      {
        Log.w("VideoReportManager", "updateVideoInfo, flowInfo is null");
        return;
      }
      localObject2 = ((VideoReportFlowInfo)localObject2).getVideoSession();
      if (localObject2 == null)
      {
        paramVideoBaseEntity = new StringBuilder();
        paramVideoBaseEntity.append("updateVideoInfo, session is null, instance=");
        paramVideoBaseEntity.append(paramObject);
        Log.w("VideoReportManager", paramVideoBaseEntity.toString());
        return;
      }
      ((VideoSession)localObject2).updateVideoEntity(paramVideoBaseEntity);
      if (((VideoSession)localObject2).isIgnoreReport())
      {
        paramVideoBaseEntity = new StringBuilder();
        paramVideoBaseEntity.append("updateVideoInfo, ignore report, instance=");
        paramVideoBaseEntity.append(paramObject);
        Log.w("VideoReportManager", paramVideoBaseEntity.toString());
        return;
      }
      supplementReport(localObject1, (VideoSession)localObject2, paramVideoBaseEntity.isBizReady());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager
 * JD-Core Version:    0.7.0.1
 */