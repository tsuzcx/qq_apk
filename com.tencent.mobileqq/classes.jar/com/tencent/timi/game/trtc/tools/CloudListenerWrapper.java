package com.tencent.timi.game.trtc.tools;

import android.os.Bundle;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCSpeedTestResult;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;

public class CloudListenerWrapper
  extends TRTCCloudListener
{
  private final CloudListenerInformer a;
  
  public CloudListenerWrapper(CloudListenerInformer paramCloudListenerInformer)
  {
    this.a = paramCloudListenerInformer;
  }
  
  private void a(String paramString, Object... paramVarArgs)
  {
    Printer.a(paramString, paramVarArgs);
  }
  
  public void onAudioEffectFinished(int paramInt1, int paramInt2)
  {
    a("onAudioEffectFinished", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.34(this, paramInt1, paramInt2));
    }
  }
  
  public void onAudioRouteChanged(int paramInt1, int paramInt2)
  {
    a("onAudioRouteChanged", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.24(this, paramInt1, paramInt2));
    }
  }
  
  public void onCameraDidReady()
  {
    a("onCameraDidReady", new Object[0]);
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.22(this));
    }
  }
  
  public void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    a("onConnectOtherRoom", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.5(this, paramString1, paramInt, paramString2));
    }
  }
  
  public void onConnectionLost()
  {
    a("onConnectionLost", new Object[0]);
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.18(this));
    }
  }
  
  public void onConnectionRecovery()
  {
    a("onConnectionRecovery", new Object[0]);
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.20(this));
    }
  }
  
  public void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    a("onDisConnectOtherRoom", new Object[] { Integer.valueOf(paramInt), paramString });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.6(this, paramInt, paramString));
    }
  }
  
  public void onEnterRoom(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("耗时:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("ms");
    a("onEnterRoom", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = this.a;
    if (localObject != null) {
      ((CloudListenerInformer)localObject).a(new CloudListenerWrapper.2(this, paramLong));
    }
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    a("onError", new Object[] { Integer.valueOf(paramInt), paramString, paramBundle });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.1(this, paramInt, paramString, paramBundle));
    }
  }
  
  public void onExitRoom(int paramInt)
  {
    a("onExitRoom", new Object[] { Integer.valueOf(paramInt) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.3(this, paramInt));
    }
  }
  
  public void onFirstAudioFrame(String paramString)
  {
    a("onFirstAudioFrame", new Object[] { paramString });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.13(this, paramString));
    }
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a("onFirstVideoFrame", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.12(this, paramString, paramInt1, paramInt2, paramInt3));
    }
  }
  
  public void onMicDidReady()
  {
    a("onMicDidReady", new Object[0]);
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.23(this));
    }
  }
  
  public void onMissCustomCmdMsg(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a("onMissCustomCmdMsg", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.27(this, paramString, paramInt1, paramInt2, paramInt3));
    }
  }
  
  public void onNetworkQuality(TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList) {}
  
  public void onRecvCustomCmdMsg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    a("onRecvCustomCmdMsg", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfByte });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.26(this, paramString, paramInt1, paramInt2, paramArrayOfByte));
    }
  }
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte)
  {
    a("onRecvSEIMsg", new Object[] { paramArrayOfByte });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.28(this, paramString, paramArrayOfByte));
    }
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    a("onRemoteUserEnterRoom", new Object[] { paramString });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.7(this, paramString));
    }
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    a("onRemoteUserLeaveRoom", new Object[] { paramString, Integer.valueOf(paramInt) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.8(this, paramString, paramInt));
    }
  }
  
  public void onSendFirstLocalAudioFrame()
  {
    a("onSendFirstLocalAudioFrame", new Object[0]);
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.15(this));
    }
  }
  
  public void onSendFirstLocalVideoFrame(int paramInt)
  {
    a("onSendFirstLocalVideoFrame", new Object[] { Integer.valueOf(paramInt) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.14(this, paramInt));
    }
  }
  
  public void onSetMixTranscodingConfig(int paramInt, String paramString)
  {
    a("onSetMixTranscodingConfig", new Object[] { Integer.valueOf(paramInt), paramString });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.33(this, paramInt, paramString));
    }
  }
  
  public void onSpeedTest(TRTCCloudDef.TRTCSpeedTestResult paramTRTCSpeedTestResult, int paramInt1, int paramInt2)
  {
    a("onSpeedTest", new Object[] { paramTRTCSpeedTestResult, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.21(this, paramTRTCSpeedTestResult, paramInt1, paramInt2));
    }
  }
  
  public void onStartPublishCDNStream(int paramInt, String paramString)
  {
    a("onStartPublishCDNStream", new Object[] { Integer.valueOf(paramInt), paramString });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.31(this, paramInt, paramString));
    }
  }
  
  public void onStartPublishing(int paramInt, String paramString)
  {
    a("onStartPublishing", new Object[] { Integer.valueOf(paramInt), paramString });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.29(this, paramInt, paramString));
    }
  }
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics) {}
  
  public void onStopPublishCDNStream(int paramInt, String paramString)
  {
    a("onStopPublishCDNStream", new Object[] { Integer.valueOf(paramInt), paramString });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.32(this, paramInt, paramString));
    }
  }
  
  public void onStopPublishing(int paramInt, String paramString)
  {
    a("onStopPublishing", new Object[] { Integer.valueOf(paramInt), paramString });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.30(this, paramInt, paramString));
    }
  }
  
  public void onSwitchRole(int paramInt, String paramString)
  {
    a("onSwitchRole", new Object[] { Integer.valueOf(paramInt), paramString });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.4(this, paramInt, paramString));
    }
  }
  
  public void onTryToReconnect()
  {
    a("onTryToReconnect", new Object[0]);
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.19(this));
    }
  }
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    a("onUserAudioAvailable", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.11(this, paramString, paramBoolean));
    }
  }
  
  public void onUserEnter(String paramString)
  {
    a("onUserEnter", new Object[] { paramString });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.16(this, paramString));
    }
  }
  
  public void onUserExit(String paramString, int paramInt)
  {
    a("onUserExit", new Object[] { paramString, Integer.valueOf(paramInt) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.17(this, paramString, paramInt));
    }
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    a("onUserSubStreamAvailable", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.10(this, paramString, paramBoolean));
    }
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    a("onUserVideoAvailable", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.9(this, paramString, paramBoolean));
    }
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    CloudListenerInformer localCloudListenerInformer = this.a;
    if (localCloudListenerInformer != null) {
      localCloudListenerInformer.a(new CloudListenerWrapper.25(this, paramArrayList, paramInt));
    }
  }
  
  public void onWarning(int paramInt, String paramString, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper
 * JD-Core Version:    0.7.0.1
 */