package com.tencent.mobileqq.qqlive.trtc.engine;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.data.datareport.StatisticData;
import com.tencent.mobileqq.qqlive.data.datareport.StatisticData.LocalStatisticsData;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.ITRTCInnerCaptureEventListener;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.StatisticDataListener;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCSpeedTestResult;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCLocalStatistics;
import java.util.ArrayList;
import java.util.Iterator;

public class TRTCInnerCloudListener
  extends TRTCCloudListener
{
  private ITRTCRoomListener a;
  private ITRTCInnerCaptureEventListener b;
  private StatisticDataListener c;
  
  private boolean a(int paramInt)
  {
    return (paramInt == -7001) || (paramInt == -1309) || (paramInt == -1308);
  }
  
  public void a(ITRTCRoomListener paramITRTCRoomListener)
  {
    this.a = paramITRTCRoomListener;
  }
  
  public void a(ITRTCInnerCaptureEventListener paramITRTCInnerCaptureEventListener)
  {
    this.b = paramITRTCInnerCaptureEventListener;
  }
  
  public void a(StatisticDataListener paramStatisticDataListener)
  {
    this.c = paramStatisticDataListener;
  }
  
  public void onAudioRouteChanged(int paramInt1, int paramInt2)
  {
    super.onAudioRouteChanged(paramInt1, paramInt2);
  }
  
  public void onCameraDidReady()
  {
    super.onCameraDidReady();
  }
  
  public void onConnectionLost()
  {
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.a(1002, 0, null, null);
    }
  }
  
  public void onConnectionRecovery()
  {
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.a(1004, 0, null, null);
    }
  }
  
  public void onEnterRoom(long paramLong)
  {
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.a(paramLong, null);
    }
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((this.b != null) && (a(paramInt)))
    {
      this.b.a(paramInt, paramString, paramBundle);
      return;
    }
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.a(1000, paramInt, paramString, paramBundle);
    }
  }
  
  public void onExitRoom(int paramInt)
  {
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.a(paramInt);
    }
  }
  
  public void onMicDidReady()
  {
    super.onMicDidReady();
  }
  
  public void onNetworkQuality(TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    paramTRTCQuality = this.c;
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.a(paramString);
    }
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.a(paramString, paramInt);
    }
  }
  
  public void onScreenCapturePaused()
  {
    ITRTCInnerCaptureEventListener localITRTCInnerCaptureEventListener = this.b;
    if (localITRTCInnerCaptureEventListener == null) {
      return;
    }
    localITRTCInnerCaptureEventListener.a(0);
  }
  
  public void onScreenCaptureResumed()
  {
    ITRTCInnerCaptureEventListener localITRTCInnerCaptureEventListener = this.b;
    if (localITRTCInnerCaptureEventListener == null) {
      return;
    }
    localITRTCInnerCaptureEventListener.b(0);
  }
  
  public void onScreenCaptureStarted()
  {
    ITRTCInnerCaptureEventListener localITRTCInnerCaptureEventListener = this.b;
    if (localITRTCInnerCaptureEventListener == null) {
      return;
    }
    localITRTCInnerCaptureEventListener.a();
  }
  
  public void onScreenCaptureStopped(int paramInt)
  {
    ITRTCInnerCaptureEventListener localITRTCInnerCaptureEventListener = this.b;
    if (localITRTCInnerCaptureEventListener == null) {
      return;
    }
    localITRTCInnerCaptureEventListener.c(paramInt);
  }
  
  public void onSendFirstLocalAudioFrame()
  {
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.a();
    }
  }
  
  public void onSendFirstLocalVideoFrame(int paramInt)
  {
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.b(paramInt);
    }
  }
  
  public void onSpeedTest(TRTCCloudDef.TRTCSpeedTestResult paramTRTCSpeedTestResult, int paramInt1, int paramInt2)
  {
    super.onSpeedTest(paramTRTCSpeedTestResult, paramInt1, paramInt2);
  }
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics)
  {
    if (this.a != null)
    {
      StatisticData localStatisticData = new StatisticData();
      localStatisticData.appCpu = paramTRTCStatistics.appCpu;
      localStatisticData.downLoss = paramTRTCStatistics.downLoss;
      localStatisticData.rtt = paramTRTCStatistics.rtt;
      localStatisticData.upLoss = paramTRTCStatistics.upLoss;
      localStatisticData.sendBytes = paramTRTCStatistics.sendBytes;
      localStatisticData.receiveBytes = paramTRTCStatistics.receiveBytes;
      localStatisticData.localArray = new ArrayList();
      paramTRTCStatistics = paramTRTCStatistics.localArray.iterator();
      while (paramTRTCStatistics.hasNext())
      {
        TRTCStatistics.TRTCLocalStatistics localTRTCLocalStatistics = (TRTCStatistics.TRTCLocalStatistics)paramTRTCStatistics.next();
        StatisticData.LocalStatisticsData localLocalStatisticsData = new StatisticData.LocalStatisticsData();
        localLocalStatisticsData.audioBitrate = localTRTCLocalStatistics.audioBitrate;
        localLocalStatisticsData.width = localTRTCLocalStatistics.width;
        localLocalStatisticsData.height = localTRTCLocalStatistics.height;
        localLocalStatisticsData.frameRate = localTRTCLocalStatistics.frameRate;
        localLocalStatisticsData.videoBitrate = localTRTCLocalStatistics.videoBitrate;
        localLocalStatisticsData.audioSampleRate = localTRTCLocalStatistics.audioSampleRate;
        localLocalStatisticsData.audioCaptureState = localTRTCLocalStatistics.audioCaptureState;
        localLocalStatisticsData.streamType = localTRTCLocalStatistics.streamType;
        localStatisticData.localArray.add(localLocalStatisticsData);
      }
      paramTRTCStatistics = this.c;
      if (paramTRTCStatistics != null) {
        paramTRTCStatistics.a(localStatisticData);
      }
    }
  }
  
  public void onSwitchRoom(int paramInt, String paramString)
  {
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.a(paramInt, paramString);
    }
  }
  
  public void onTryToReconnect()
  {
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.a(1003, 0, null, null);
    }
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    super.onUserSubStreamAvailable(paramString, paramBoolean);
  }
  
  public void onWarning(int paramInt, String paramString, Bundle paramBundle)
  {
    ITRTCRoomListener localITRTCRoomListener = this.a;
    if (localITRTCRoomListener != null) {
      localITRTCRoomListener.a(1001, paramInt, paramString, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.engine.TRTCInnerCloudListener
 * JD-Core Version:    0.7.0.1
 */