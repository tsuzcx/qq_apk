package com.tencent.trtc;

import android.os.Bundle;
import java.util.ArrayList;

public abstract class TRTCCloudListener
{
  @Deprecated
  public void onAudioEffectFinished(int paramInt1, int paramInt2) {}
  
  public void onAudioRouteChanged(int paramInt1, int paramInt2) {}
  
  public void onCameraDidReady() {}
  
  public void onConnectOtherRoom(String paramString1, int paramInt, String paramString2) {}
  
  public void onConnectionLost() {}
  
  public void onConnectionRecovery() {}
  
  public void onDisConnectOtherRoom(int paramInt, String paramString) {}
  
  public void onEnterRoom(long paramLong) {}
  
  public void onError(int paramInt, String paramString, Bundle paramBundle) {}
  
  public void onExitRoom(int paramInt) {}
  
  public void onFirstAudioFrame(String paramString) {}
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onLocalRecordBegin(int paramInt, String paramString) {}
  
  public void onLocalRecordComplete(int paramInt, String paramString) {}
  
  public void onLocalRecording(long paramLong, String paramString) {}
  
  public void onMicDidReady() {}
  
  public void onMissCustomCmdMsg(String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onNetworkQuality(TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList) {}
  
  public void onRecvCustomCmdMsg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte) {}
  
  public void onRemoteUserEnterRoom(String paramString) {}
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt) {}
  
  public void onScreenCapturePaused() {}
  
  public void onScreenCaptureResumed() {}
  
  public void onScreenCaptureStarted() {}
  
  public void onScreenCaptureStopped(int paramInt) {}
  
  public void onSendFirstLocalAudioFrame() {}
  
  public void onSendFirstLocalVideoFrame(int paramInt) {}
  
  public void onSetMixTranscodingConfig(int paramInt, String paramString) {}
  
  public void onSpeedTest(TRTCCloudDef.TRTCSpeedTestResult paramTRTCSpeedTestResult, int paramInt1, int paramInt2) {}
  
  public void onStartPublishCDNStream(int paramInt, String paramString) {}
  
  public void onStartPublishing(int paramInt, String paramString) {}
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics) {}
  
  public void onStopPublishCDNStream(int paramInt, String paramString) {}
  
  public void onStopPublishing(int paramInt, String paramString) {}
  
  public void onSwitchRole(int paramInt, String paramString) {}
  
  public void onSwitchRoom(int paramInt, String paramString) {}
  
  public void onTryToReconnect() {}
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean) {}
  
  @Deprecated
  public void onUserEnter(String paramString) {}
  
  @Deprecated
  public void onUserExit(String paramString, int paramInt) {}
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean) {}
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean) {}
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt) {}
  
  public void onWarning(int paramInt, String paramString, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudListener
 * JD-Core Version:    0.7.0.1
 */