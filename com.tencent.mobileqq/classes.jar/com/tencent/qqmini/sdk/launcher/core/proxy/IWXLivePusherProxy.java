package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import org.json.JSONObject;

public abstract interface IWXLivePusherProxy
{
  public static final String CLASS_NAME_TX_CLOUD_VIDEO_VIEW = "com.tencent.rtmp.ui.TXCloudVideoView";
  
  public abstract void enableAGC(boolean paramBoolean);
  
  public abstract void enableANS(boolean paramBoolean);
  
  public abstract void enableAudioEarMonitoring(boolean paramBoolean);
  
  public abstract void enablePureAudioPush(boolean paramBoolean);
  
  public abstract void initInstance(Context paramContext);
  
  public abstract boolean isPushing();
  
  public abstract Object newITXLivePushListener(TXLivePushListenerReflect.ITXLivePushListener paramITXLivePushListener);
  
  public abstract Object newITXSnapshotListener(TXLivePushListenerReflect.ITXSnapshotListener paramITXSnapshotListener);
  
  public abstract Object newOnBGMNotify(TXLivePushListenerReflect.OnBGMNotify paramOnBGMNotify);
  
  public abstract boolean pauseBGM();
  
  public abstract void pausePusher();
  
  public abstract boolean playBGM(String paramString);
  
  public abstract boolean resumeBGM();
  
  public abstract void resumePusher();
  
  public abstract boolean sendMessageEx(byte[] paramArrayOfByte);
  
  public abstract void setAudioSampleRate(int paramInt);
  
  public abstract void setBGMNofify(Object paramObject);
  
  public abstract void setBGMPosition(int paramInt);
  
  public abstract boolean setBGMVolume(float paramFloat);
  
  public abstract void setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setConfig();
  
  public abstract void setEnableCamera(JSONObject paramJSONObject, Object paramObject);
  
  public abstract void setEnableZoom(boolean paramBoolean);
  
  public abstract void setFrontCamera(boolean paramBoolean);
  
  public abstract void setHomeOrientation(int paramInt);
  
  public abstract void setLocalVideoMirrorType(int paramInt);
  
  public abstract void setMaxVideoBitrate(int paramInt);
  
  public abstract void setMicVolume(float paramFloat);
  
  public abstract void setMinVideoBitrate(int paramInt);
  
  public abstract void setMirror(boolean paramBoolean);
  
  public abstract void setMode(JSONObject paramJSONObject);
  
  public abstract void setMuted(boolean paramBoolean);
  
  public abstract void setPauseFlag(int paramInt);
  
  public abstract void setPauseImg(Bitmap paramBitmap);
  
  public abstract void setPushListener(Object paramObject);
  
  public abstract void setPusherUrl(String paramString);
  
  public abstract void setRenderRotation(int paramInt);
  
  public abstract void setReverb(int paramInt);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setSurfaceSize(int paramInt1, int paramInt2);
  
  public abstract void setTouchFocus(boolean paramBoolean);
  
  public abstract void setVideoEncodeGop(int paramInt);
  
  public abstract void setVideoQuality(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setVideoResolution(int paramInt);
  
  public abstract void setVideoResolution(int paramInt1, int paramInt2);
  
  public abstract void setVolumeType(int paramInt);
  
  public abstract void setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void showDebugLog(boolean paramBoolean);
  
  public abstract void snapshot(Object paramObject);
  
  public abstract void startAudioRecord();
  
  public abstract void startCameraPreview(Object paramObject);
  
  public abstract int startDumpAudioData(String paramString);
  
  public abstract boolean startPusher(String paramString);
  
  public abstract void stopAudioRecord();
  
  public abstract boolean stopBGM();
  
  public abstract void stopCameraPreview(boolean paramBoolean);
  
  public abstract void stopDumpAudioData();
  
  public abstract void stopPusher();
  
  public abstract void switchCamera();
  
  public abstract void toggleTorch(Object paramObject);
  
  public abstract boolean turnOnFlashLight(boolean paramBoolean);
  
  public abstract void txCloudVideoView_disableLog(Boolean paramBoolean, Object paramObject);
  
  public abstract void txLivePlayer_setVisibility(int paramInt, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
 * JD-Core Version:    0.7.0.1
 */