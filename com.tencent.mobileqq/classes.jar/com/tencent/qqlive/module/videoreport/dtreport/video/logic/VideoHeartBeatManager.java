package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor;
import com.tencent.qqlive.module.videoreport.dtreport.video.VideoEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class VideoHeartBeatManager
{
  private static final int MAX_STAGING_HEARTBEAT_INTERVAL = 1800000;
  private static final int MIN_STAGING_HEARTBEAT_INTERVAL = 60000;
  private static final String TAG = "VideoHeartBeatManager";
  private boolean isHeartBeatStarted = false;
  private boolean isInitStagingHeartBeatProcessor = false;
  private HeartBeatProcessor mStagingHeartBeatProcessor;
  private int mTimePinInterval;
  
  private VideoHeartBeatManager()
  {
    Log.i("VideoHeartBeatManager", "create VideoHeartBeatManager!");
  }
  
  public static VideoHeartBeatManager getInstance()
  {
    return VideoHeartBeatManager.InstanceHolder.sInstance;
  }
  
  private boolean hasStartedPlayer()
  {
    Object localObject = VideoReportManager.getInstance().getPlayerInfoMap();
    if (localObject == null) {
      return false;
    }
    localObject = ((Map)localObject).values();
    if (((Collection)localObject).isEmpty()) {
      return false;
    }
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((VideoReportFlowInfo)((Iterator)localObject).next()).getVideoState() == 2) {
        return true;
      }
    }
    return false;
  }
  
  private void initHeartBeatProcessor()
  {
    if (this.isInitStagingHeartBeatProcessor) {
      return;
    }
    this.mTimePinInterval = (VideoReportInner.getInstance().getConfiguration().getVideoHeartBeatInterval() * 1000);
    int i = this.mTimePinInterval;
    if (i < 60000) {
      this.mTimePinInterval = 60000;
    } else if (i > 1800000) {
      this.mTimePinInterval = 1800000;
    }
    this.mStagingHeartBeatProcessor = new HeartBeatProcessor(true, this.mTimePinInterval);
    this.mStagingHeartBeatProcessor.setHeartBeatCallback(new VideoHeartBeatManager.1(this));
    this.isInitStagingHeartBeatProcessor = true;
  }
  
  private void saveEndEvent()
  {
    Log.i("VideoHeartBeatManager", "saveEndEvent");
    Object localObject2 = VideoReportManager.getInstance().getPlayerMap();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = VideoReportManager.getInstance().getPlayerInfoMap();
    if (localObject1 == null) {
      return;
    }
    localObject2 = ((Map)localObject2).values();
    if (((Collection)localObject2).isEmpty())
    {
      Log.i("VideoHeartBeatManager", "saveEndEvent isEmpty");
      return;
    }
    Iterator localIterator = ((Collection)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = localIterator.next();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("saveEndEvent playerObject:");
      ((StringBuilder)localObject3).append(localObject2);
      Log.i("VideoHeartBeatManager", ((StringBuilder)localObject3).toString());
      if (localObject2 == null) {
        return;
      }
      localObject3 = (VideoReportFlowInfo)((Map)localObject1).get(Integer.valueOf(localObject2.hashCode()));
      if (localObject3 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("saveEndEvent playerInfo is null! ptr=");
        ((StringBuilder)localObject1).append(localObject2);
        Log.w("VideoHeartBeatManager", ((StringBuilder)localObject1).toString());
        return;
      }
      if (((VideoReportFlowInfo)localObject3).getVideoState() != 2)
      {
        Log.w("VideoHeartBeatManager", "saveEndEvent videoState is not STARTED");
        return;
      }
      localObject3 = ((VideoReportFlowInfo)localObject3).getVideoSession();
      if (localObject3 == null)
      {
        Log.w("VideoHeartBeatManager", "saveEndEvent session is null!");
        return;
      }
      if (((VideoSession)localObject3).isIgnoreReport())
      {
        Log.w("VideoHeartBeatManager", "saveEndEvent ignore, not need report!");
        return;
      }
      ((VideoSession)localObject3).stagingEnd(VideoReportPlayerUtils.getCurrentPosition(localObject2), 4);
      VideoEventReporter.getInstance().stashVideoEnd(localObject2, (VideoSession)localObject3);
    }
  }
  
  public void startStagingHeartBeat()
  {
    Log.i("VideoHeartBeatManager", "startStagingHeartBeat");
    if (this.isHeartBeatStarted) {
      return;
    }
    initHeartBeatProcessor();
    this.mStagingHeartBeatProcessor.start();
    this.isHeartBeatStarted = true;
  }
  
  public void stopStagingHeartBeat()
  {
    Log.i("VideoHeartBeatManager", "stopStagingHeartBeat");
    if ((!hasStartedPlayer()) && (this.isInitStagingHeartBeatProcessor))
    {
      this.mStagingHeartBeatProcessor.stop();
      this.isHeartBeatStarted = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoHeartBeatManager
 * JD-Core Version:    0.7.0.1
 */