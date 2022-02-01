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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class VideoReportManager
{
  private static final String TAG = "VideoReportManager";
  private Map<Integer, VideoSession> bindVideoInfoMap = new LinkedHashMap();
  private VideoSession currentSession = null;
  private Map<String, VideoSession> historyPlayInfo = new HashMap();
  private VideoSession lastAdSession = null;
  private VideoSession lastVideoSession = null;
  private OnInfoTaskManager onInfoTaskManager = new OnInfoTaskManager();
  private Map<Integer, VideoReportFlowInfo> playerInfoMap = new HashMap();
  private Map<Integer, Object> playerMap = new HashMap();
  private Map<Integer, Object> playerReportInfoMap = new HashMap();
  private final Object syncObject = new Object();
  
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
    getValidReportFlowInfo(paramObject).setVideoState(paramInt);
  }
  
  private VideoSession createAdSessionFromVideoSession(Object paramObject, VideoSession paramVideoSession)
  {
    return new VideoSession(new VideoEntity.Builder().setContentId(paramVideoSession.getContentId() + "_AD").addCustomParams(paramVideoSession.getCustomParams()).setContentType(1).bizReady(true).setVideoDuration(VideoReportPlayerUtils.getDuration(paramObject)).build(), new Object().hashCode());
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
    Object localObject = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    if (localObject == null)
    {
      Log.w("VideoReportManager", paramString + " playerInfo is null! ptr=" + paramObject);
      return;
    }
    localObject = ((VideoReportFlowInfo)localObject).getVideoSession();
    if (localObject == null)
    {
      Log.w("VideoReportManager", paramString + " session is null!");
      VideoReportPlayerUtils.debugEnd(paramString, localDebugTime);
      return;
    }
    if (((VideoSession)localObject).isIgnoreReport())
    {
      Log.w("VideoReportManager", "ignore, not need report!");
      VideoReportPlayerUtils.debugEnd(paramString, localDebugTime);
      return;
    }
    supplementReport(paramObject, (VideoSession)localObject, true);
    ((VideoSession)localObject).end(VideoReportPlayerUtils.getCurrentPosition(paramObject), paramInt1);
    VideoEventReporter.getInstance().reportVideoEnd(paramObject, (VideoSession)localObject);
    addHistoryPlayInfo((VideoSession)localObject);
    changeState(paramObject, paramInt2);
    VideoReportPlayerUtils.debugEnd(paramString, localDebugTime);
  }
  
  private void dealPlayStart(Object paramObject, boolean paramBoolean)
  {
    int i = 1;
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
    Object localObject2 = getCurrentPlaySession(paramObject);
    if (((VideoSession)localObject2).isIgnoreReport())
    {
      Log.w("VideoReportManager", "ignore, not need report!, ptr=" + paramObject);
      VideoReportPlayerUtils.debugEnd("start", localDebugTime);
      return;
    }
    Object localObject1 = localObject2;
    if (1 != ((VideoSession)localObject2).getContentType())
    {
      localObject1 = localObject2;
      if (isPlayAd(paramObject))
      {
        localObject1 = createAdSessionFromVideoSession(paramObject, (VideoSession)localObject2);
        putVideoInfoMap(((VideoSession)localObject1).getVideoPlayerObject(), (VideoSession)localObject1);
      }
    }
    if (!isCurrentVideoSessionValid((VideoSession)localObject1))
    {
      Log.w("VideoReportManager", "has unbind player. no need report!, ptr=" + paramObject);
      VideoReportPlayerUtils.debugEnd("start", localDebugTime);
      return;
    }
    int j = playType((VideoSession)localObject1);
    long l = startPosition(paramObject);
    if (!paramBoolean) {
      i = startPlayReason((VideoSession)localObject1, l);
    }
    ((VideoSession)localObject1).start(i, l, j);
    Log.w("VideoReportManager", "start, isBizReady=" + ((VideoSession)localObject1).isBizReady() + ", ptr=" + paramObject);
    if (((VideoSession)localObject1).isBizReady()) {
      VideoEventReporter.getInstance().reportVideoStart(paramObject, (VideoSession)localObject1);
    }
    this.playerMap.put(Integer.valueOf(((VideoSession)localObject1).getVideoPlayerObject()), paramObject);
    localObject2 = getValidReportFlowInfo(paramObject);
    ((VideoReportFlowInfo)localObject2).setVideoSession((VideoSession)localObject1);
    ((VideoReportFlowInfo)localObject2).setPlayerObject(((VideoSession)localObject1).getVideoPlayerObject());
    changeState(paramObject, 2);
    VideoReportPlayerUtils.debugEnd("start", localDebugTime);
  }
  
  private VideoSession getCurrentPlaySession(Object paramObject)
  {
    paramObject = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    if (paramObject == null) {
      paramObject = this.currentSession;
    }
    VideoSession localVideoSession;
    do
    {
      return paramObject;
      localVideoSession = paramObject.getVideoSession();
      if (localVideoSession != null) {
        return localVideoSession;
      }
      localVideoSession = getSessionByReportInfo(this.playerReportInfoMap.get(Integer.valueOf(paramObject.getReportManager())));
      paramObject = localVideoSession;
    } while (localVideoSession != null);
    return this.currentSession;
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
    VideoSession localVideoSession = null;
    String str = VideoReportPlayerUtils.getVidByReportInfo(paramObject);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    for (;;)
    {
      synchronized (this.syncObject)
      {
        Iterator localIterator = this.bindVideoInfoMap.values().iterator();
        paramObject = localVideoSession;
        if (localIterator.hasNext())
        {
          localVideoSession = (VideoSession)localIterator.next();
          if (str.equals(localVideoSession.getIdentifier())) {
            paramObject = localVideoSession;
          }
        }
        else
        {
          return paramObject;
        }
      }
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
    synchronized (this.syncObject)
    {
      boolean bool = this.bindVideoInfoMap.containsValue(paramVideoSession);
      return bool;
    }
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
    int j = 1;
    VideoSession localVideoSession;
    if (1 != paramVideoSession.getContentType())
    {
      localVideoSession = this.lastVideoSession;
      this.lastVideoSession = paramVideoSession;
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
      this.lastAdSession = paramVideoSession;
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
  
  private void resetSession(Object paramObject)
  {
    paramObject = getValidReportFlowInfo(paramObject);
    paramObject.setStartPosition(0L);
    paramObject.setVideoSession(null);
  }
  
  private int startPlayReason(VideoSession paramVideoSession, long paramLong)
  {
    VideoSession localVideoSession = (VideoSession)this.historyPlayInfo.get(paramVideoSession.getContentId());
    if (localVideoSession == null) {
      return 1;
    }
    int i;
    if (isContinuePlay(paramLong, localVideoSession.getEndPosition())) {
      if (paramVideoSession.getPageId() == localVideoSession.getPageId()) {
        i = 2;
      }
    }
    for (;;)
    {
      return i;
      i = 3;
      continue;
      i = 1;
    }
  }
  
  private long startPosition(Object paramObject)
  {
    if (getPlayerState(paramObject) == 1)
    {
      paramObject = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
      if (paramObject != null) {
        return paramObject.getStartPosition();
      }
    }
    else
    {
      return VideoReportPlayerUtils.getCurrentPosition(paramObject);
    }
    return 0L;
  }
  
  private void supplementReport(Object paramObject, VideoSession paramVideoSession, boolean paramBoolean)
  {
    try
    {
      if ((!paramVideoSession.isBizReady()) && (paramBoolean))
      {
        VideoEventReporter.getInstance().reportVideoStart(paramObject, paramVideoSession);
        paramVideoSession.bizReady();
      }
      return;
    }
    finally {}
  }
  
  public void bindVideoInfo(@NonNull Object paramObject, @NonNull VideoEntity paramVideoEntity)
  {
    for (;;)
    {
      try
      {
        if (!DTConfigConstants.config.videoReportSupport())
        {
          Log.w("VideoReportManager", "bindVideoInfo, videoReport not support!");
          return;
        }
        Log.i("VideoReportManager", "bindVideoInfo, instance=" + paramObject);
        localObject1 = this.playerMap.get(Integer.valueOf(paramObject.hashCode()));
        if (localObject1 == null) {
          break label192;
        }
        localObject1 = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(localObject1.hashCode()));
        if (localObject1 == null) {
          break label187;
        }
        localObject1 = ((VideoReportFlowInfo)localObject1).getVideoSession();
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          Log.i("VideoReportManager", "bindVideoInfo, update entity, instance=" + paramObject);
          ((VideoSession)localObject1).updateVideoEntity(paramVideoEntity);
          localObject2 = localObject1;
        }
        if (localObject2 == null)
        {
          this.currentSession = new VideoSession(paramVideoEntity, paramObject.hashCode());
          putVideoInfoMap(paramObject.hashCode(), this.currentSession);
          continue;
        }
        this.currentSession = localObject2;
      }
      finally {}
      continue;
      label187:
      Object localObject1 = null;
      continue;
      label192:
      Object localObject2 = null;
    }
  }
  
  public void getReportManager(Object paramObject1, Object paramObject2)
  {
    VideoReportPlayerUtils.DebugTime localDebugTime = VideoReportPlayerUtils.debugStart();
    Log.i("VideoReportManager", "getReportManager ptr=" + paramObject1 + ",reportManager=" + paramObject2);
    getValidReportFlowInfo(paramObject1).setReportManager(paramObject2.hashCode());
    VideoReportPlayerUtils.debugEnd("getReportManager", localDebugTime);
  }
  
  public VideoReportFlowInfo getVideoReportFlowInfo(Object paramObject)
  {
    if (paramObject != null)
    {
      VideoReportFlowInfo localVideoReportFlowInfo = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
      Log.w("VideoReportManager", "getVideoReportFlowInfo , ptr=" + paramObject + " ,flowInfo=" + localVideoReportFlowInfo);
      return localVideoReportFlowInfo;
    }
    return null;
  }
  
  public void loopEnd(Object paramObject)
  {
    Log.i("VideoReportManager", "loopEnd, ptr=" + paramObject);
    dealPlayEnd(paramObject, 2, 4, "stop");
  }
  
  public void loopStart(Object paramObject)
  {
    Log.i("VideoReportManager", "loopStart, ptr=" + paramObject);
    dealPlayStart(paramObject, true);
  }
  
  public void onCompletion(Object paramObject)
  {
    Log.i("VideoReportManager", "onCompletion ptr=" + paramObject);
    dealPlayEnd(paramObject, 2, 4, "onCompletion");
    resetSession(paramObject);
  }
  
  public void onError(Object paramObject, int paramInt1, int paramInt2)
  {
    Log.i("VideoReportManager", "onError ptr=" + paramObject);
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
    VideoReportFlowInfo localVideoReportFlowInfo = (VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(paramObject.hashCode()));
    if (localVideoReportFlowInfo != null)
    {
      removeVideoInfoMap(localVideoReportFlowInfo.getPlayerObject());
      this.playerReportInfoMap.remove(Integer.valueOf(localVideoReportFlowInfo.getReportManager()));
      this.playerMap.remove(Integer.valueOf(localVideoReportFlowInfo.getPlayerObject()));
    }
    this.playerInfoMap.remove(Integer.valueOf(paramObject.hashCode()));
    VideoReportPlayerUtils.debugEnd("release", localDebugTime);
  }
  
  public void reset(Object paramObject)
  {
    Log.i("VideoReportManager", "reset, ptr=" + paramObject);
    dealPlayEnd(paramObject, 2, 4, "reset");
    resetSession(paramObject);
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
      Log.i("VideoReportManager", "setStartPosition,position =" + l);
      getValidReportFlowInfo(paramObject1).setStartPosition(l);
    }
    VideoReportPlayerUtils.debugEnd("setStartPosition", localDebugTime);
  }
  
  public void start(Object paramObject)
  {
    Log.i("VideoReportManager", "start, ptr=" + paramObject);
    dealPlayStart(paramObject, false);
  }
  
  public void stop(Object paramObject)
  {
    Log.i("VideoReportManager", "stop, ptr=" + paramObject);
    dealPlayEnd(paramObject, 2, 4, "stop");
    resetSession(paramObject);
  }
  
  /* Error */
  public void unbindVideoInfo(@NonNull Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 400	com/tencent/qqlive/module/videoreport/dtreport/constants/DTConfigConstants:config	Lcom/tencent/qqlive/module/videoreport/dtreport/api/DTConfig;
    //   5: invokevirtual 405	com/tencent/qqlive/module/videoreport/dtreport/api/DTConfig:videoReportSupport	()Z
    //   8: ifne +14 -> 22
    //   11: ldc 8
    //   13: ldc_w 503
    //   16: invokestatic 177	com/tencent/qqlive/module/videoreport/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: ldc 8
    //   24: new 109	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 505
    //   34: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 67	com/tencent/qqlive/module/videoreport/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 156	java/lang/Object:hashCode	()I
    //   52: invokespecial 474	com/tencent/qqlive/module/videoreport/dtreport/video/logic/VideoReportManager:removeVideoInfoMap	(I)V
    //   55: goto -36 -> 19
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	VideoReportManager
    //   0	63	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	58	finally
    //   22	55	58	finally
  }
  
  public void updateVideoInfo(@NonNull Object paramObject, @NonNull VideoBaseEntity paramVideoBaseEntity)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        if (!DTConfigConstants.config.videoReportSupport())
        {
          Log.w("VideoReportManager", "updateVideoInfo, videoReport not support!");
          return;
        }
        Log.i("VideoReportManager", "updateVideoInfo, instance=" + paramObject);
        localObject = this.playerMap.get(Integer.valueOf(paramObject.hashCode()));
        if (localObject == null)
        {
          Log.w("VideoReportManager", "updateVideoInfo, no bind player");
          continue;
        }
        localVideoSession = ((VideoReportFlowInfo)this.playerInfoMap.get(Integer.valueOf(localObject.hashCode()))).getVideoSession();
      }
      finally {}
      VideoSession localVideoSession;
      if (localVideoSession == null)
      {
        Log.w("VideoReportManager", "updateVideoInfo, session is null, instance=" + paramObject);
      }
      else
      {
        localVideoSession.updateVideoEntity(paramVideoBaseEntity);
        if (localVideoSession.isIgnoreReport()) {
          Log.w("VideoReportManager", "updateVideoInfo, ignore report, instance=" + paramObject);
        } else {
          supplementReport(localObject, localVideoSession, paramVideoBaseEntity.isBizReady());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager
 * JD-Core Version:    0.7.0.1
 */