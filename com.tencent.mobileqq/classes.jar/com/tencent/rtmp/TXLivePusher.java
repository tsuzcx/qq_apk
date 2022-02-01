package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;

public class TXLivePusher
{
  public static final int RGB_BGRA = 4;
  public static final int RGB_RGBA = 5;
  public static final int YUV_420P = 3;
  public static final int YUV_420SP = 1;
  public static final int YUV_420YpCbCr = 2;
  private TXLivePusherImpl mTXTxLivePusherImpl;
  
  public TXLivePusher(Context paramContext)
  {
    this.mTXTxLivePusherImpl = new TXLivePusherImpl(paramContext);
  }
  
  public void callExperimentalAPI(String paramString)
  {
    this.mTXTxLivePusherImpl.f(paramString);
  }
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    this.mTXTxLivePusherImpl.f(paramInt);
  }
  
  public TXAudioEffectManager getAudioEffectManager()
  {
    return TXAudioEffectManagerImpl.getAutoCacheHolder();
  }
  
  public TXBeautyManager getBeautyManager()
  {
    return this.mTXTxLivePusherImpl.q();
  }
  
  public TXLivePushConfig getConfig()
  {
    return this.mTXTxLivePusherImpl.h();
  }
  
  public int getMaxZoom()
  {
    return this.mTXTxLivePusherImpl.p();
  }
  
  @Deprecated
  public int getMusicDuration(String paramString)
  {
    return this.mTXTxLivePusherImpl.c(paramString);
  }
  
  public boolean isPushing()
  {
    return this.mTXTxLivePusherImpl.l();
  }
  
  public void onLogRecord(String paramString)
  {
    this.mTXTxLivePusherImpl.e(paramString);
  }
  
  @Deprecated
  public boolean pauseBGM()
  {
    return this.mTXTxLivePusherImpl.t();
  }
  
  public void pausePusher()
  {
    this.mTXTxLivePusherImpl.j();
  }
  
  @Deprecated
  public boolean playBGM(String paramString)
  {
    return this.mTXTxLivePusherImpl.b(paramString);
  }
  
  @Deprecated
  public boolean resumeBGM()
  {
    return this.mTXTxLivePusherImpl.u();
  }
  
  public void resumePusher()
  {
    this.mTXTxLivePusherImpl.k();
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte)
  {
    this.mTXTxLivePusherImpl.a(paramArrayOfByte);
  }
  
  public int sendCustomVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mTXTxLivePusherImpl.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
  
  public int sendCustomVideoTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mTXTxLivePusherImpl.b(paramInt1, paramInt2, paramInt3);
  }
  
  @Deprecated
  public void sendMessage(byte[] paramArrayOfByte)
  {
    this.mTXTxLivePusherImpl.c(paramArrayOfByte);
  }
  
  public boolean sendMessageEx(byte[] paramArrayOfByte)
  {
    return this.mTXTxLivePusherImpl.b(paramArrayOfByte);
  }
  
  public void setAudioProcessListener(TXLivePusher.AudioCustomProcessListener paramAudioCustomProcessListener)
  {
    this.mTXTxLivePusherImpl.a(paramAudioCustomProcessListener);
  }
  
  public void setAudioVolumeEvaluationListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.mTXTxLivePusherImpl.a(paramITXAudioVolumeEvaluationListener);
  }
  
  @Deprecated
  public void setBGMNofify(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.mTXTxLivePusherImpl.a(paramOnBGMNotify);
  }
  
  @Deprecated
  public void setBGMPitch(float paramFloat)
  {
    this.mTXTxLivePusherImpl.d(paramFloat);
  }
  
  @Deprecated
  public boolean setBGMPosition(int paramInt)
  {
    return this.mTXTxLivePusherImpl.c(paramInt);
  }
  
  @Deprecated
  public boolean setBGMVolume(float paramFloat)
  {
    return this.mTXTxLivePusherImpl.b(paramFloat);
  }
  
  public boolean setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.mTXTxLivePusherImpl.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @Deprecated
  public void setChinLevel(int paramInt)
  {
    getBeautyManager().setChinLevel(paramInt);
  }
  
  public void setConfig(TXLivePushConfig paramTXLivePushConfig)
  {
    this.mTXTxLivePusherImpl.a(paramTXLivePushConfig);
  }
  
  public void setExposureCompensation(float paramFloat)
  {
    this.mTXTxLivePusherImpl.a(paramFloat);
  }
  
  @Deprecated
  public void setEyeScaleLevel(int paramInt)
  {
    getBeautyManager().setEyeScaleLevel(paramInt);
  }
  
  @Deprecated
  public void setFaceShortLevel(int paramInt)
  {
    getBeautyManager().setFaceShortLevel(paramInt);
  }
  
  @Deprecated
  public void setFaceSlimLevel(int paramInt)
  {
    getBeautyManager().setFaceSlimLevel(paramInt);
  }
  
  @Deprecated
  public void setFaceVLevel(int paramInt)
  {
    getBeautyManager().setFaceVLevel(paramInt);
  }
  
  @Deprecated
  public void setFilter(Bitmap paramBitmap)
  {
    getBeautyManager().setFilter(paramBitmap);
  }
  
  public void setFocusPosition(float paramFloat1, float paramFloat2)
  {
    this.mTXTxLivePusherImpl.a(paramFloat1, paramFloat2);
  }
  
  @Deprecated
  @TargetApi(18)
  public boolean setGreenScreenFile(String paramString)
  {
    getBeautyManager().setGreenScreenFile(paramString);
    return true;
  }
  
  @Deprecated
  public boolean setMicVolume(float paramFloat)
  {
    return this.mTXTxLivePusherImpl.c(paramFloat);
  }
  
  public boolean setMirror(boolean paramBoolean)
  {
    return this.mTXTxLivePusherImpl.c(paramBoolean);
  }
  
  @Deprecated
  public void setMotionMute(boolean paramBoolean)
  {
    getBeautyManager().setMotionMute(paramBoolean);
  }
  
  @Deprecated
  public void setMotionTmpl(String paramString)
  {
    getBeautyManager().setMotionTmpl(paramString);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.mTXTxLivePusherImpl.e(paramBoolean);
  }
  
  @Deprecated
  public void setNoseSlimLevel(int paramInt)
  {
    getBeautyManager().setNoseSlimLevel(paramInt);
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.mTXTxLivePusherImpl.a(paramITXLivePushListener);
  }
  
  public void setRenderRotation(int paramInt)
  {
    this.mTXTxLivePusherImpl.a(paramInt);
  }
  
  @Deprecated
  public void setReverb(int paramInt)
  {
    this.mTXTxLivePusherImpl.d(paramInt);
  }
  
  @Deprecated
  public void setSpecialRatio(float paramFloat)
  {
    getBeautyManager().setFilterStrength(paramFloat);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.mTXTxLivePusherImpl.a(paramSurface);
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    this.mTXTxLivePusherImpl.a(paramInt1, paramInt2);
  }
  
  public void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener paramVideoCustomProcessListener)
  {
    this.mTXTxLivePusherImpl.a(paramVideoCustomProcessListener);
  }
  
  public void setVideoQuality(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mTXTxLivePusherImpl.a(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    this.mTXTxLivePusherImpl.a(paramITXVideoRecordListener);
  }
  
  @Deprecated
  public void setVoiceChangerType(int paramInt)
  {
    this.mTXTxLivePusherImpl.e(paramInt);
  }
  
  public boolean setZoom(int paramInt)
  {
    return this.mTXTxLivePusherImpl.b(paramInt);
  }
  
  public void snapshot(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.mTXTxLivePusherImpl.a(paramITXSnapshotListener);
  }
  
  public void startCameraPreview(TXCloudVideoView paramTXCloudVideoView)
  {
    this.mTXTxLivePusherImpl.a(paramTXCloudVideoView);
  }
  
  public int startPusher(String paramString)
  {
    return this.mTXTxLivePusherImpl.a(paramString);
  }
  
  public int startRecord(String paramString)
  {
    return this.mTXTxLivePusherImpl.d(paramString);
  }
  
  public void startScreenCapture()
  {
    this.mTXTxLivePusherImpl.m();
  }
  
  @Deprecated
  public boolean stopBGM()
  {
    return this.mTXTxLivePusherImpl.r();
  }
  
  public void stopCameraPreview(boolean paramBoolean)
  {
    this.mTXTxLivePusherImpl.b(paramBoolean);
  }
  
  public void stopPusher()
  {
    this.mTXTxLivePusherImpl.i();
  }
  
  public void stopRecord()
  {
    this.mTXTxLivePusherImpl.v();
  }
  
  public void stopScreenCapture()
  {
    this.mTXTxLivePusherImpl.n();
  }
  
  public void switchCamera()
  {
    this.mTXTxLivePusherImpl.o();
  }
  
  public boolean turnOnFlashLight(boolean paramBoolean)
  {
    return this.mTXTxLivePusherImpl.d(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher
 * JD-Core Version:    0.7.0.1
 */