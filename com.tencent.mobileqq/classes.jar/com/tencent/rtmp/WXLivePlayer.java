package com.tencent.rtmp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.WXTRTCCloud;
import com.tencent.trtc.WXTRTCCloud.ITXAudioVolumeEvaluationListener;
import java.lang.ref.WeakReference;

public class WXLivePlayer
  extends TXLivePlayer
  implements ITXLivePlayListener, WXTRTCCloud.ITXAudioVolumeEvaluationListener
{
  private static final String RTC_ADDRESS1 = "room://cloud.tencent.com/rtc";
  private static final String RTC_ADDRESS2 = "room://rtc.tencent.com";
  private static final String RTMP_PROXY_ADDRESS = "room://";
  private static final String TAG = "WXLivePlayer";
  private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener = null;
  private int mAudioVolumeNotifyInterval = 0;
  private boolean mIsRtmpProxy = false;
  private boolean mIsTRTC = false;
  private boolean mMuteAudio = false;
  private boolean mMuteVideo = false;
  private WXLivePlayConfig mPlayConfig = new WXLivePlayConfig();
  private WeakReference<ITXLivePlayListener> mPlayListener = null;
  private int mRenderMode = 1;
  private int mRenderRotation = 0;
  private String mStreamType = "";
  private Surface mSurface = null;
  private int mSurfaceHeight = 0;
  private int mSurfaceWidth = 0;
  private WXTRTCCloud mTRTCCloud = null;
  private boolean mTRTCPlaying = false;
  private String mUserId = "";
  private TXCloudVideoView mVideoView = null;
  
  public WXLivePlayer(Context paramContext)
  {
    super(paramContext);
    this.mTRTCCloud = WXTRTCCloud.sharedInstance(paramContext);
  }
  
  private boolean isRtmpProxyUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!paramString.startsWith("room://cloud.tencent.com/rtc"))
    {
      if (paramString.startsWith("room://rtc.tencent.com")) {
        return false;
      }
      return paramString.startsWith("room://");
    }
    return false;
  }
  
  private boolean isTRTCPlayerUrl(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("room://cloud.tencent.com/rtc")) || (paramString.startsWith("room://rtc.tencent.com"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean parseTRTCParams(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = paramString.split("[?&]");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = paramString[i];
        if (localCharSequence.indexOf("=") != -1)
        {
          Object localObject = localCharSequence.split("[=]");
          if (localObject.length == 2)
          {
            localCharSequence = localObject[0];
            localObject = localObject[1];
            if ((!TextUtils.isEmpty(localCharSequence)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
              if (localCharSequence.equalsIgnoreCase("userid")) {
                this.mUserId = ((String)localObject);
              } else if (localCharSequence.equalsIgnoreCase("streamtype")) {
                this.mStreamType = ((String)localObject);
              }
            }
          }
        }
        i += 1;
      }
      return true;
    }
    catch (Exception paramString)
    {
      TXCLog.e("WXLivePlayer", "parse trtc params failed.", paramString);
      if (TextUtils.isEmpty(this.mStreamType)) {
        this.mStreamType = "main";
      }
      if (TextUtils.isEmpty(this.mUserId)) {
        return false;
      }
    }
  }
  
  private void resetParams()
  {
    this.mIsTRTC = false;
    this.mTRTCPlaying = false;
    this.mUserId = "";
    this.mStreamType = "";
  }
  
  public void apiOnlineLog(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append("[API] WXLivePlayer(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString = paramString.toString();
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(str);
      Monitor.a(1, localStringBuilder.toString(), "", 0, "");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    TXCLog.i("WXLivePlayer", localStringBuilder.toString());
  }
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    this.mAudioVolumeNotifyInterval = paramInt;
    super.enableAudioVolumeEvaluation(paramInt);
  }
  
  protected void finalize()
  {
    this.mTRTCCloud = null;
  }
  
  public boolean isPlaying()
  {
    if (this.mIsTRTC) {
      return this.mTRTCPlaying;
    }
    return super.isPlaying();
  }
  
  public void muteAudio(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("muteAudio mute: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", userId: ");
    ((StringBuilder)localObject).append(this.mUserId);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool;
    if ((!this.mIsTRTC) && (!this.mIsRtmpProxy)) {
      bool = false;
    } else {
      bool = true;
    }
    apiOnlineLog((String)localObject, bool);
    super.setMute(paramBoolean);
    this.mMuteAudio = paramBoolean;
    if ((this.mIsTRTC) && (this.mTRTCPlaying)) {
      this.mTRTCCloud.muteRemoteAudio(this.mUserId, paramBoolean);
    }
  }
  
  public void muteVideo(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("muteVideo mute: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", userId: ");
    ((StringBuilder)localObject).append(this.mUserId);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool;
    if ((!this.mIsTRTC) && (!this.mIsRtmpProxy)) {
      bool = false;
    } else {
      bool = true;
    }
    apiOnlineLog((String)localObject, bool);
    this.mMuteVideo = paramBoolean;
    if ((this.mIsTRTC) && (this.mTRTCPlaying)) {
      this.mTRTCCloud.muteRemoteVideoStream(this.mUserId, paramBoolean);
    }
  }
  
  public void onAudioVolumeEvaluationNotify(int paramInt)
  {
    TXLivePlayer.ITXAudioVolumeEvaluationListener localITXAudioVolumeEvaluationListener = this.mAudioVolumeListener;
    if (localITXAudioVolumeEvaluationListener != null) {
      localITXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(paramInt);
    }
  }
  
  public void onNetStatus(Bundle paramBundle)
  {
    Object localObject = this.mPlayListener;
    if (localObject != null)
    {
      localObject = (ITXLivePlayListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((ITXLivePlayListener)localObject).onNetStatus(paramBundle);
      }
    }
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayEvent event: ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool;
    if ((!this.mIsTRTC) && (!this.mIsRtmpProxy)) {
      bool = false;
    } else {
      bool = true;
    }
    apiOnlineLog((String)localObject, bool);
    localObject = this.mPlayListener;
    if (localObject != null)
    {
      localObject = (ITXLivePlayListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((ITXLivePlayListener)localObject).onPlayEvent(paramInt, paramBundle);
      }
    }
  }
  
  public void setAudioRoute(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setAudioRoute audioRoute: ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool;
    if ((!this.mIsTRTC) && (!this.mIsRtmpProxy)) {
      bool = false;
    } else {
      bool = true;
    }
    apiOnlineLog((String)localObject, bool);
    TXCAudioEngine.setAudioRoute(paramInt);
  }
  
  public void setAudioVolumeEvaluationListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    super.setAudioVolumeEvaluationListener(paramITXAudioVolumeEvaluationListener);
    this.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setConfig(WXLivePlayConfig paramWXLivePlayConfig)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setConfig config: ");
    ((StringBuilder)localObject).append(paramWXLivePlayConfig);
    if (((StringBuilder)localObject).toString() != null) {
      localObject = paramWXLivePlayConfig.toString();
    } else {
      localObject = "";
    }
    boolean bool;
    if ((!this.mIsTRTC) && (!this.mIsRtmpProxy)) {
      bool = false;
    } else {
      bool = true;
    }
    apiOnlineLog((String)localObject, bool);
    super.setConfig(paramWXLivePlayConfig);
    this.mPlayConfig = paramWXLivePlayConfig;
  }
  
  public void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    super.setPlayListener(paramITXLivePlayListener);
    this.mPlayListener = new WeakReference(paramITXLivePlayListener);
  }
  
  public void setPlayerView(TXCloudVideoView paramTXCloudVideoView)
  {
    super.setPlayerView(paramTXCloudVideoView);
    this.mVideoView = paramTXCloudVideoView;
  }
  
  public void setRenderMode(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRenderMode mode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", userId: ");
    localStringBuilder.append(this.mUserId);
    apiOnlineLog(localStringBuilder.toString(), false);
    super.setRenderMode(paramInt);
    if (paramInt == 0) {
      this.mRenderMode = 0;
    } else if (paramInt == 1) {
      this.mRenderMode = 1;
    }
    if ((this.mIsTRTC) && (this.mTRTCPlaying))
    {
      if (this.mStreamType.equalsIgnoreCase("aux"))
      {
        this.mTRTCCloud.setRemoteSubStreamViewFillMode(this.mUserId, this.mRenderMode);
        return;
      }
      this.mTRTCCloud.setRemoteViewFillMode(this.mUserId, this.mRenderMode);
    }
  }
  
  public void setRenderRotation(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRenderRotation rotation: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", userId: ");
    localStringBuilder.append(this.mUserId);
    apiOnlineLog(localStringBuilder.toString(), false);
    super.setRenderRotation(paramInt);
    if (paramInt == 270) {
      this.mRenderRotation = 3;
    } else if (paramInt == 0) {
      this.mRenderRotation = 0;
    }
    if ((this.mIsTRTC) && (this.mTRTCPlaying))
    {
      if (this.mStreamType.equalsIgnoreCase("aux"))
      {
        this.mTRTCCloud.setRemoteSubStreamViewRotation(this.mUserId, this.mRenderRotation);
        return;
      }
      this.mTRTCCloud.setRemoteViewRotation(this.mUserId, this.mRenderRotation);
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    super.setSurface(paramSurface);
    this.mSurface = paramSurface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSurface userId: ");
    localStringBuilder.append(this.mUserId);
    localStringBuilder.append(", surface: ");
    localStringBuilder.append(paramSurface);
    apiOnlineLog(localStringBuilder.toString(), false);
    if ((this.mIsTRTC) && (this.mTRTCPlaying) && (!TextUtils.isEmpty(this.mUserId)) && (!TextUtils.isEmpty(this.mStreamType)))
    {
      if (this.mStreamType.equalsIgnoreCase("aux"))
      {
        this.mTRTCCloud.setRemoteSubStreamSurface(this.mUserId, this.mSurface);
        return;
      }
      this.mTRTCCloud.setRemoteSurface(this.mUserId, this.mSurface);
    }
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    super.setSurfaceSize(paramInt1, paramInt2);
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSurfaceSize width: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", userId: ");
    localStringBuilder.append(this.mUserId);
    apiOnlineLog(localStringBuilder.toString(), false);
    if ((this.mIsTRTC) && (this.mTRTCPlaying) && (!TextUtils.isEmpty(this.mUserId)) && (!TextUtils.isEmpty(this.mStreamType)))
    {
      if (this.mStreamType.equalsIgnoreCase("aux"))
      {
        this.mTRTCCloud.setRemoteSubStreamSurfaceSize(this.mUserId, paramInt1, paramInt2);
        return;
      }
      this.mTRTCCloud.setRemoteSurfaceSize(this.mUserId, paramInt1, paramInt2);
    }
  }
  
  public void showDebugLog(boolean paramBoolean)
  {
    Object localObject = this.mVideoView;
    if (localObject != null) {
      ((TXCloudVideoView)localObject).showLog(paramBoolean);
    }
    localObject = this.mTRTCCloud;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 0;
    }
    ((WXTRTCCloud)localObject).showDebugView(i);
  }
  
  public void snapshot(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    if (this.mIsTRTC)
    {
      if (this.mTRTCPlaying)
      {
        if (this.mStreamType.equalsIgnoreCase("aux"))
        {
          this.mTRTCCloud.snapshotVideo(this.mUserId, 2, new WXLivePlayer.1(this, paramITXSnapshotListener));
          return;
        }
        this.mTRTCCloud.snapshotVideo(this.mUserId, 0, new WXLivePlayer.2(this, paramITXSnapshotListener));
      }
    }
    else {
      super.snapshot(paramITXSnapshotListener);
    }
  }
  
  public int startPlay(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    this.mIsRtmpProxy = isRtmpProxyUrl(paramString);
    this.mIsTRTC = isTRTCPlayerUrl(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startPlay url:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" type:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", isTRTC: ");
    ((StringBuilder)localObject).append(this.mIsTRTC);
    ((StringBuilder)localObject).append(", userId: ");
    ((StringBuilder)localObject).append(this.mUserId);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool;
    if ((!this.mIsTRTC) && (!this.mIsRtmpProxy)) {
      bool = false;
    } else {
      bool = true;
    }
    apiOnlineLog((String)localObject, bool);
    if (this.mIsTRTC)
    {
      if (parseTRTCParams(paramString))
      {
        this.mTRTCCloud.muteRemoteAudio(this.mUserId, this.mMuteAudio);
        this.mTRTCCloud.muteRemoteVideoStream(this.mUserId, this.mMuteVideo);
        if (this.mStreamType.equalsIgnoreCase("main"))
        {
          this.mTRTCCloud.setRemoteVideoStreamType(this.mUserId, 0);
          this.mTRTCCloud.startRemoteView(this.mUserId, this.mVideoView);
          this.mTRTCCloud.setRemoteSurface(this.mUserId, this.mSurface);
          this.mTRTCCloud.setRemoteSurfaceSize(this.mUserId, this.mSurfaceWidth, this.mSurfaceHeight);
        }
        else if (this.mStreamType.equalsIgnoreCase("small"))
        {
          this.mTRTCCloud.setRemoteVideoStreamType(this.mUserId, 1);
          this.mTRTCCloud.startRemoteView(this.mUserId, this.mVideoView);
          this.mTRTCCloud.setRemoteSurface(this.mUserId, this.mSurface);
          this.mTRTCCloud.setRemoteSurfaceSize(this.mUserId, this.mSurfaceWidth, this.mSurfaceHeight);
        }
        else if (this.mStreamType.equalsIgnoreCase("aux"))
        {
          this.mTRTCCloud.startRemoteSubStreamView(this.mUserId, this.mVideoView);
          this.mTRTCCloud.setRemoteSubStreamSurface(this.mUserId, this.mSurface);
          this.mTRTCCloud.setRemoteSubStreamSurfaceSize(this.mUserId, this.mSurfaceWidth, this.mSurfaceHeight);
          bool = true;
          break label412;
        }
        bool = false;
        label412:
        if (bool) {
          this.mTRTCCloud.setRemoteSubStreamViewFillMode(this.mUserId, this.mRenderMode);
        } else {
          this.mTRTCCloud.setRemoteViewFillMode(this.mUserId, this.mRenderMode);
        }
        if (bool) {
          this.mTRTCCloud.setRemoteSubStreamViewRotation(this.mUserId, this.mRenderRotation);
        } else {
          this.mTRTCCloud.setRemoteViewRotation(this.mUserId, this.mRenderRotation);
        }
        this.mTRTCCloud.registerAudioVolumeEvaluationListener(this.mUserId, bool, this);
        this.mTRTCCloud.registerPlayListener(this.mUserId, bool, this);
        this.mTRTCPlaying = true;
        return 0;
      }
      TXCLog.e("WXLivePlayer", "parse playUrl failed!!!");
      return -1;
    }
    super.enableAudioVolumeEvaluation(this.mAudioVolumeNotifyInterval);
    return super.startPlay(paramString, paramInt);
  }
  
  public int stopPlay(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stopPlay isNeedClearLastImg: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", isTRTC: ");
    ((StringBuilder)localObject).append(this.mIsTRTC);
    ((StringBuilder)localObject).append(", userId: ");
    ((StringBuilder)localObject).append(this.mUserId);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool1 = this.mIsTRTC;
    boolean bool2 = true;
    if ((!bool1) && (!this.mIsRtmpProxy)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    apiOnlineLog((String)localObject, bool1);
    if (paramBoolean)
    {
      localObject = this.mVideoView;
      if (localObject != null) {
        ((TXCloudVideoView)localObject).setVisibility(8);
      }
    }
    if (this.mIsTRTC)
    {
      if (this.mStreamType.equalsIgnoreCase("main"))
      {
        this.mTRTCCloud.stopRemoteView(this.mUserId);
      }
      else if (this.mStreamType.equalsIgnoreCase("small"))
      {
        this.mTRTCCloud.stopRemoteView(this.mUserId);
      }
      else if (this.mStreamType.equalsIgnoreCase("aux"))
      {
        this.mTRTCCloud.stopRemoteSubStreamView(this.mUserId);
        paramBoolean = bool2;
        break label217;
      }
      paramBoolean = false;
      label217:
      this.mTRTCCloud.unregisterAudioVolumeEvaluationListener(this.mUserId, paramBoolean);
      this.mTRTCCloud.unregisterPlayListener(this.mUserId, paramBoolean);
      resetParams();
      return 0;
    }
    resetParams();
    return super.stopPlay(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePlayer
 * JD-Core Version:    0.7.0.1
 */