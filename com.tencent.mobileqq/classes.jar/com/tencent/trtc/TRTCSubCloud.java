package com.tencent.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

public class TRTCSubCloud
  extends TRTCCloudImpl
{
  private static final String TAG = "com.tencent.trtc.TRTCSubCloud";
  protected WeakReference<TRTCCloudImpl> mMainCloud = null;
  private TRTCSubCloud.a mVolumeLevelCalTask = null;
  
  public TRTCSubCloud(Context paramContext, WeakReference<TRTCCloudImpl> paramWeakReference, f paramf)
  {
    super(paramContext, paramf);
    this.mRoomInfo.muteLocalAudio = true;
    this.mRoomInfo.muteLocalVideo = true;
    this.mMainCloud = paramWeakReference;
  }
  
  public void ConnectOtherRoom(String paramString)
  {
    super.ConnectOtherRoom(paramString);
  }
  
  public void DisconnectOtherRoom()
  {
    super.DisconnectOtherRoom();
  }
  
  public void callExperimentalAPI(String paramString)
  {
    if (paramString != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("callExperimentalAPI  ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", roomid = ");
      if (this.mRoomInfo.roomId != -1L) {
        localObject1 = Long.valueOf(this.mRoomInfo.roomId);
      } else {
        localObject1 = this.mRoomInfo.strRoomId;
      }
      ((StringBuilder)localObject2).append(localObject1);
      apiOnlineLog(((StringBuilder)localObject2).toString());
    }
    Object localObject2 = "";
    Object localObject3 = null;
    Object localObject1 = localObject2;
    try
    {
      Object localObject4 = new JSONObject(paramString);
      localObject1 = localObject2;
      if (!((JSONObject)localObject4).has("api"))
      {
        localObject1 = localObject2;
        localObject4 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject4).append("callExperimentalAPI[lack api or illegal type]: ");
        localObject1 = localObject2;
        ((StringBuilder)localObject4).append(paramString);
        localObject1 = localObject2;
        apiLog(((StringBuilder)localObject4).toString());
        return;
      }
      localObject1 = localObject2;
      localObject2 = ((JSONObject)localObject4).getString("api");
      localObject1 = localObject2;
      if (!((JSONObject)localObject4).has("params")) {
        return;
      }
      localObject1 = localObject2;
      localObject4 = ((JSONObject)localObject4).getJSONObject("params");
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    catch (Exception localException)
    {
      label204:
      break label204;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("callExperimentalAPI[failed]: ");
    ((StringBuilder)localObject2).append(paramString);
    apiLog(((StringBuilder)localObject2).toString());
    localObject2 = localObject3;
    if (((String)localObject1).equals("setEncodedDataProcessingListener"))
    {
      setEncodedDataProcessingListener((JSONObject)localObject2);
      return;
    }
    runOnSDKThread(new TRTCSubCloud.8(this, (String)localObject1, (JSONObject)localObject2, paramString));
  }
  
  protected void collectCustomCaptureFps() {}
  
  public TRTCCloud createSubCloud()
  {
    return null;
  }
  
  public void destroy()
  {
    runOnSDKThread(new TRTCSubCloud.1(this));
  }
  
  public void enableAudioEarMonitoring(boolean paramBoolean) {}
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    super.enableAudioVolumeEvaluation(paramInt);
  }
  
  public void enableCustomAudioCapture(boolean paramBoolean) {}
  
  public void enableCustomVideoCapture(boolean paramBoolean) {}
  
  public int enableEncSmallVideoStream(boolean paramBoolean, TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam)
  {
    return -1;
  }
  
  public boolean enableTorch(boolean paramBoolean)
  {
    return false;
  }
  
  public void enterRoom(TRTCCloudDef.TRTCParams paramTRTCParams, int paramInt)
  {
    if (paramTRTCParams == null)
    {
      apiLog("enter room, param nil!");
      onEnterRoom(-3316, "enter room param null");
      return;
    }
    TRTCCloudDef.TRTCParams localTRTCParams = new TRTCCloudDef.TRTCParams(paramTRTCParams);
    long l;
    if ((localTRTCParams.sdkAppId != 0) && (!TextUtils.isEmpty(localTRTCParams.userId)) && (!TextUtils.isEmpty(localTRTCParams.userSig)))
    {
      l = 0xFFFFFFFF & localTRTCParams.roomId;
      localObject1 = localTRTCParams.businessInfo;
      paramTRTCParams = "";
      if ((l != 0L) && ((localTRTCParams.roomId != -1) || (TextUtils.isEmpty(localTRTCParams.businessInfo))))
      {
        localObject2 = localObject1;
      }
      else
      {
        if (l == 0L) {
          paramTRTCParams = localTRTCParams.strRoomId;
        } else {
          paramTRTCParams = "";
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
    }
    try
    {
      localObject2 = new JSONObject((String)localObject1);
      localObject1 = new StringBuilder("");
      ((StringBuilder)localObject1).append(((JSONObject)localObject2).optString("strGroupId").toString());
      ((JSONObject)localObject2).remove("strGroupId");
      ((JSONObject)localObject2).remove("Role");
      if (localTRTCParams.roomId != -1) {
        break label455;
      }
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    catch (Exception paramTRTCParams)
    {
      for (;;)
      {
        label306:
        continue;
        localObject1 = paramTRTCParams;
      }
    }
    if (((JSONObject)localObject2).length() != 0)
    {
      paramTRTCParams = ((JSONObject)localObject2).toString();
    }
    else
    {
      paramTRTCParams = "";
      break label306;
      paramTRTCParams = new StringBuilder();
      paramTRTCParams.append("enter room, room id error, busInfo ");
      paramTRTCParams.append(localTRTCParams.businessInfo);
      apiLog(paramTRTCParams.toString());
      localObject1 = "";
      paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject1;
      break label306;
      localObject2 = localObject1;
      localObject1 = paramTRTCParams;
      paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject2;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      onEnterRoom(-3318, "room id invalid.");
      return;
    }
    Object localObject2 = paramTRTCParams;
    paramTRTCParams = (TRTCCloudDef.TRTCParams)localObject1;
    runOnSDKThread(new TRTCSubCloud.2(this, paramTRTCParams, l, localTRTCParams, paramInt, (String)localObject2, localTRTCParams.role, System.currentTimeMillis()));
    return;
    paramTRTCParams = new StringBuilder();
    paramTRTCParams.append("enterRoom param invalid:");
    paramTRTCParams.append(localTRTCParams);
    apiLog(paramTRTCParams.toString());
    if (localTRTCParams.sdkAppId == 0) {
      onEnterRoom(-3317, "enter room sdkAppId invalid.");
    }
    if (TextUtils.isEmpty(localTRTCParams.userSig)) {
      onEnterRoom(-3320, "enter room userSig invalid.");
    }
    if (TextUtils.isEmpty(localTRTCParams.userId)) {
      onEnterRoom(-3319, "enter room userId invalid.");
    }
  }
  
  public void exitRoom()
  {
    runOnSDKThread(new TRTCSubCloud.3(this));
  }
  
  protected void exitRoomInternal(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitRoomInternal reqExit: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", reason: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", mRoomState: ");
    localStringBuilder.append(this.mRoomState);
    apiLog(localStringBuilder.toString());
    if (this.mRoomState == 0)
    {
      clearRemoteMuteStates();
      apiLog("exitRoom ignore when no in room");
      return;
    }
    this.mRoomState = 0;
    this.mRoomType = 0;
    stopCollectStatus();
    this.mRoomInfo.forEachUser(new TRTCSubCloud.4(this));
    if (paramBoolean) {
      nativeExitRoom(this.mNativeRtcContext);
    }
    this.mRoomInfo.clear();
    this.mRenderListenerMap.clear();
  }
  
  public void finalize()
  {
    this.mSDKHandler = null;
    super.finalize();
  }
  
  public int getAudioCaptureVolume()
  {
    return 0;
  }
  
  public int getAudioPlayoutVolume()
  {
    return 0;
  }
  
  public int getBGMDuration(String paramString)
  {
    return 0;
  }
  
  public TXBeautyManager getBeautyManager()
  {
    return null;
  }
  
  public boolean isCameraAutoFocusFaceModeSupported()
  {
    return false;
  }
  
  public boolean isCameraFocusPositionInPreviewSupported()
  {
    return false;
  }
  
  public boolean isCameraTorchSupported()
  {
    return false;
  }
  
  public boolean isCameraZoomSupported()
  {
    return false;
  }
  
  public void muteAllRemoteAudio(boolean paramBoolean)
  {
    super.muteAllRemoteAudio(paramBoolean);
  }
  
  public void muteAllRemoteVideoStreams(boolean paramBoolean)
  {
    super.muteAllRemoteVideoStreams(paramBoolean);
  }
  
  public void muteLocalAudio(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCSubCloud.7(this, paramBoolean));
  }
  
  public void muteLocalVideo(boolean paramBoolean)
  {
    runOnSDKThread(new TRTCSubCloud.6(this, paramBoolean));
  }
  
  public void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    super.muteRemoteAudio(paramString, paramBoolean);
  }
  
  public void muteRemoteVideoStream(String paramString, boolean paramBoolean)
  {
    super.muteRemoteVideoStream(paramString, paramBoolean);
  }
  
  public void onAudioQosChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onAudioQosChanged(this, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onIdrFpsChanged(int paramInt)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onIdrFpsChanged(this, paramInt);
    }
  }
  
  public void onVideoConfigChanged(int paramInt, boolean paramBoolean)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onVideoConfigChanged(this, paramInt, paramBoolean);
    }
  }
  
  public void onVideoQosChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mMainCloud.get();
    if (localTRTCCloudImpl != null) {
      localTRTCCloudImpl.onVideoQosChanged(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
  }
  
  public void pauseAudioEffect(int paramInt) {}
  
  public void pauseBGM() {}
  
  public void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam paramTRTCAudioEffectParam) {}
  
  public void playBGM(String paramString, TRTCCloud.BGMNotify paramBGMNotify) {}
  
  public void resumeAudioEffect(int paramInt) {}
  
  public void resumeBGM() {}
  
  public void selectMotionTmpl(String paramString) {}
  
  public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame) {}
  
  public boolean sendCustomCmdMsg(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    return super.sendCustomCmdMsg(paramInt, paramArrayOfByte, paramBoolean1, paramBoolean2);
  }
  
  public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame) {}
  
  public boolean sendSEIMsg(byte[] paramArrayOfByte, int paramInt)
  {
    return super.sendSEIMsg(paramArrayOfByte, paramInt);
  }
  
  public void setAllAudioEffectsVolume(int paramInt) {}
  
  public void setAudioCaptureVolume(int paramInt) {}
  
  public void setAudioEffectVolume(int paramInt1, int paramInt2) {}
  
  public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener paramTRTCAudioFrameListener)
  {
    runOnSDKThread(new TRTCSubCloud.9(this, paramTRTCAudioFrameListener));
  }
  
  public void setAudioPlayoutVolume(int paramInt) {}
  
  public void setAudioRoute(int paramInt) {}
  
  public void setBGMPlayoutVolume(int paramInt) {}
  
  public int setBGMPosition(int paramInt)
  {
    return 0;
  }
  
  public void setBGMPublishVolume(int paramInt) {}
  
  public void setBGMVolume(int paramInt) {}
  
  public void setBeautyStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setChinLevel(int paramInt) {}
  
  public void setDebugViewMargin(String paramString, TRTCCloud.TRTCViewMargin paramTRTCViewMargin)
  {
    super.setDebugViewMargin(paramString, paramTRTCViewMargin);
  }
  
  public void setDefaultStreamRecvMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.setDefaultStreamRecvMode(paramBoolean1, paramBoolean2);
  }
  
  public void setEyeScaleLevel(int paramInt) {}
  
  public void setFaceShortLevel(int paramInt) {}
  
  public void setFaceSlimLevel(int paramInt) {}
  
  public void setFaceVLevel(int paramInt) {}
  
  public void setFilter(Bitmap paramBitmap) {}
  
  public void setFilterConcentration(float paramFloat) {}
  
  public void setFocusPosition(int paramInt1, int paramInt2) {}
  
  public void setGSensorMode(int paramInt) {}
  
  public boolean setGreenScreenFile(String paramString)
  {
    return false;
  }
  
  public void setListener(TRTCCloudListener paramTRTCCloudListener)
  {
    super.setListener(paramTRTCCloudListener);
  }
  
  public void setListenerHandler(Handler paramHandler)
  {
    super.setListenerHandler(paramHandler);
  }
  
  public int setLocalVideoRenderListener(int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    return -1;
  }
  
  public void setLocalViewFillMode(int paramInt) {}
  
  public void setLocalViewMirror(int paramInt) {}
  
  public void setLocalViewRotation(int paramInt) {}
  
  public void setMicVolumeOnMixing(int paramInt) {}
  
  public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig)
  {
    super.setMixTranscodingConfig(paramTRTCTranscodingConfig);
  }
  
  public void setMotionMute(boolean paramBoolean) {}
  
  public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam paramTRTCNetworkQosParam) {}
  
  public void setNoseSlimLevel(int paramInt) {}
  
  public int setPriorRemoteVideoStreamType(int paramInt)
  {
    return super.setPriorRemoteVideoStreamType(paramInt);
  }
  
  public void setRemoteAudioVolume(String paramString, int paramInt)
  {
    super.setRemoteAudioVolume(paramString, paramInt);
  }
  
  public void setRemoteSubStreamViewFillMode(String paramString, int paramInt)
  {
    super.setRemoteSubStreamViewFillMode(paramString, paramInt);
  }
  
  public void setRemoteSubStreamViewRotation(String paramString, int paramInt)
  {
    super.setRemoteSubStreamViewRotation(paramString, paramInt);
  }
  
  public int setRemoteVideoRenderListener(String paramString, int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoRenderListener paramTRTCVideoRenderListener)
  {
    return super.setRemoteVideoRenderListener(paramString, paramInt1, paramInt2, paramTRTCVideoRenderListener);
  }
  
  public int setRemoteVideoStreamType(String paramString, int paramInt)
  {
    return super.setRemoteVideoStreamType(paramString, paramInt);
  }
  
  public void setRemoteViewFillMode(String paramString, int paramInt)
  {
    super.setRemoteViewFillMode(paramString, paramInt);
  }
  
  public void setRemoteViewRotation(String paramString, int paramInt)
  {
    super.setRemoteViewRotation(paramString, paramInt);
  }
  
  public void setReverbType(int paramInt) {}
  
  public void setSystemVolumeType(int paramInt) {}
  
  public void setVideoEncoderMirror(boolean paramBoolean) {}
  
  public void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam) {}
  
  public void setVideoEncoderRotation(int paramInt) {}
  
  public boolean setVoiceChangerType(int paramInt)
  {
    return false;
  }
  
  public void setWatermark(Bitmap paramBitmap, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void setZoom(int paramInt) {}
  
  public void showDebugView(int paramInt)
  {
    super.showDebugView(paramInt);
  }
  
  public void snapshotVideo(String paramString, int paramInt, TRTCCloudListener.TRTCSnapshotListener paramTRTCSnapshotListener)
  {
    apiLog(String.format("snapshotVideo user:%s streamType:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    runOnSDKThread(new TRTCSubCloud.5(this, paramString, paramInt, paramTRTCSnapshotListener));
  }
  
  public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams paramTRTCAudioRecordingParams)
  {
    return -1;
  }
  
  public void startLocalAudio() {}
  
  public void startLocalPreview(boolean paramBoolean, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam)
  {
    super.startPublishCDNStream(paramTRTCPublishCDNParam);
  }
  
  public void startPublishing(String paramString, int paramInt)
  {
    super.startPublishing(paramString, paramInt);
  }
  
  public void startRemoteSubStreamView(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    super.startRemoteSubStreamView(paramString, paramTXCloudVideoView);
  }
  
  public void startRemoteView(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    super.startRemoteView(paramString, paramTXCloudVideoView);
  }
  
  public void startSpeedTest(int paramInt, String paramString1, String paramString2) {}
  
  protected void startVolumeLevelCal(boolean paramBoolean)
  {
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(paramBoolean, this.mAudioVolumeEvalInterval);
    if (paramBoolean)
    {
      if (this.mVolumeLevelCalTask == null)
      {
        this.mVolumeLevelCalTask = new TRTCSubCloud.a(this);
        this.mSDKHandler.postDelayed(this.mVolumeLevelCalTask, this.mAudioVolumeEvalInterval);
      }
    }
    else
    {
      this.mVolumeLevelCalTask = null;
      this.mAudioVolumeEvalInterval = 0;
    }
  }
  
  public void stopAllAudioEffects() {}
  
  public void stopAllRemoteView()
  {
    super.stopAllRemoteView();
  }
  
  public void stopAudioEffect(int paramInt) {}
  
  public void stopAudioRecording() {}
  
  public void stopBGM() {}
  
  public void stopLocalAudio() {}
  
  public void stopLocalPreview() {}
  
  public void stopPublishCDNStream()
  {
    super.stopPublishCDNStream();
  }
  
  public void stopPublishing()
  {
    super.stopPublishing();
  }
  
  public void stopRemoteSubStreamView(String paramString)
  {
    super.stopRemoteSubStreamView(paramString);
  }
  
  public void stopRemoteView(String paramString)
  {
    super.stopRemoteView(paramString);
  }
  
  public void stopSpeedTest() {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
  
  public void switchCamera() {}
  
  public void switchRole(int paramInt)
  {
    super.switchRole(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud
 * JD-Core Version:    0.7.0.1
 */