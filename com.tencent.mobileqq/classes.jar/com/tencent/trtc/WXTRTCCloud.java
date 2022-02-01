package com.tencent.trtc;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class WXTRTCCloud
  extends TRTCCloudImpl
{
  private static final String TAG = "WXTRTCCloud";
  private static WXTRTCCloud sInstance;
  private HashMap<String, WXTRTCCloud.a> mMapAudioVolumeListener = new HashMap();
  private HashMap<String, Integer> mMapLastUserVolumes = new HashMap();
  private HashMap<String, WeakReference<ITXLivePlayListener>> mMapMainStreamPlayListener = new HashMap();
  private HashMap<String, WeakReference<ITXLivePlayListener>> mMapSubStreamPlayListener = new HashMap();
  private WeakReference<ITXLivePushListener> mPushListener = null;
  
  public WXTRTCCloud(Context paramContext)
  {
    super(paramContext);
    this.mConfig.X = false;
    this.mConfig.k = 1;
    this.mCaptureAndEnc.a(this.mConfig);
    this.mCaptureAndEnc.h(false);
    setLocalViewFillMode(0);
  }
  
  public static void destroySharedInstance()
  {
    try
    {
      if (sInstance != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("trtc_api destroy instance ");
        localStringBuilder.append(sInstance);
        TXCLog.i("WXTRTCCloud", localStringBuilder.toString());
        sInstance.destroy();
        sInstance = null;
      }
      return;
    }
    finally {}
  }
  
  public static WXTRTCCloud sharedInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new WXTRTCCloud(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  protected void checkDashBoard()
  {
    TXCloudVideoView localTXCloudVideoView = this.mRoomInfo.localView;
    if (localTXCloudVideoView != null)
    {
      CharSequence localCharSequence = getUploadStreamInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[STATUS]");
      localStringBuilder.append(localCharSequence.toString().replace("\n", ""));
      TXCLog.i("WXTRTCCloud", localStringBuilder.toString());
      runOnMainThread(new WXTRTCCloud.11(this, localTXCloudVideoView, localCharSequence));
    }
    this.mRoomInfo.forEachUser(new WXTRTCCloud.13(this));
  }
  
  public void enableBlackStream(boolean paramBoolean)
  {
    runOnMainThread(new WXTRTCCloud.18(this, paramBoolean));
    runOnSDKThread(new WXTRTCCloud.19(this, paramBoolean));
  }
  
  public void enterRoom(TRTCCloudDef.TRTCParams paramTRTCParams, int paramInt)
  {
    super.enterRoom(paramTRTCParams, paramInt);
  }
  
  public void exitRoom()
  {
    super.exitRoom();
    runOnSDKThread(new WXTRTCCloud.1(this));
  }
  
  public int getMaxZoom()
  {
    return this.mCaptureAndEnc.r();
  }
  
  protected void notifyEvent(String paramString, int paramInt, Bundle paramBundle)
  {
    super.notifyEvent(paramString, paramInt, paramBundle);
    runOnSDKThread(new WXTRTCCloud.9(this, paramString, paramInt, paramBundle));
  }
  
  public void notifySEIMessage(String paramString, byte[] paramArrayOfByte)
  {
    runOnSDKThread(new WXTRTCCloud.14(this, paramArrayOfByte, paramString));
  }
  
  public void notifyStatistics(TRTCStatistics paramTRTCStatistics)
  {
    runOnSDKThread(new WXTRTCCloud.10(this, paramTRTCStatistics));
  }
  
  public void notifyUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    runOnSDKThread(new WXTRTCCloud.6(this, paramArrayList));
  }
  
  public void pausePusher()
  {
    runOnSDKThread(new WXTRTCCloud.16(this));
  }
  
  public void registerAudioVolumeEvaluationListener(String paramString, boolean paramBoolean, WXTRTCCloud.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    runOnSDKThread(new WXTRTCCloud.4(this, paramString, paramBoolean, paramITXAudioVolumeEvaluationListener));
  }
  
  public void registerPlayListener(String paramString, boolean paramBoolean, ITXLivePlayListener paramITXLivePlayListener)
  {
    runOnSDKThread(new WXTRTCCloud.7(this, paramBoolean, paramString, paramITXLivePlayListener));
  }
  
  public void resumePusher()
  {
    runOnSDKThread(new WXTRTCCloud.17(this));
  }
  
  public void setConfig(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1 != this.mConfig.L) || (paramBoolean2 != this.mConfig.M))
    {
      this.mConfig.L = paramBoolean1;
      this.mConfig.M = paramBoolean2;
      this.mCaptureAndEnc.a(this.mConfig);
    }
  }
  
  public void setFocusPosition(float paramFloat1, float paramFloat2)
  {
    this.mCaptureAndEnc.a(paramFloat1, paramFloat2);
  }
  
  public void setLocalSurface(Surface paramSurface)
  {
    runOnSDKThread(new WXTRTCCloud.12(this, paramSurface));
  }
  
  public void setLocalSurfaceSize(int paramInt1, int paramInt2)
  {
    runOnSDKThread(new WXTRTCCloud.15(this, paramInt1, paramInt2));
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.mPushListener = new WeakReference(paramITXLivePushListener);
  }
  
  public void setRemoteSubStreamSurface(String paramString, Surface paramSurface)
  {
    runOnSDKThread(new WXTRTCCloud.2(this, paramString, paramSurface));
  }
  
  public void setRemoteSubStreamSurfaceSize(String paramString, int paramInt1, int paramInt2)
  {
    runOnSDKThread(new WXTRTCCloud.3(this, paramString, paramInt1, paramInt2));
  }
  
  public void setRemoteSurface(String paramString, Surface paramSurface)
  {
    runOnSDKThread(new WXTRTCCloud.20(this, paramString, paramSurface));
  }
  
  public void setRemoteSurfaceSize(String paramString, int paramInt1, int paramInt2)
  {
    runOnSDKThread(new WXTRTCCloud.21(this, paramString, paramInt1, paramInt2));
  }
  
  public void startLocalAudio()
  {
    this.mEnableEosMode = true;
    super.startLocalAudio();
  }
  
  public void unregisterAudioVolumeEvaluationListener(String paramString, boolean paramBoolean)
  {
    runOnSDKThread(new WXTRTCCloud.5(this, paramString, paramBoolean));
  }
  
  public void unregisterPlayListener(String paramString, boolean paramBoolean)
  {
    runOnSDKThread(new WXTRTCCloud.8(this, paramBoolean, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud
 * JD-Core Version:    0.7.0.1
 */