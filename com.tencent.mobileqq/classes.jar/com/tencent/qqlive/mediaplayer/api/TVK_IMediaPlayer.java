package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.Map;
import java.util.Properties;

public abstract interface TVK_IMediaPlayer
{
  public abstract void addDanmuContent(String paramString1, String paramString2);
  
  public abstract void addDanmuContentForLocal(String paramString);
  
  public abstract void attachControllerView()
    throws IllegalStateException, IllegalAccessException;
  
  public abstract void attachControllerView(Properties paramProperties)
    throws IllegalStateException, IllegalAccessException;
  
  public abstract void attachDanmuView()
    throws IllegalStateException, IllegalAccessException;
  
  public abstract int captureImageInTime(int paramInt1, int paramInt2)
    throws IllegalStateException, IllegalArgumentException, IllegalAccessException;
  
  public abstract long getAdCurrentPosition();
  
  public abstract String[] getAudioTrackList();
  
  public abstract int getBufferPercent();
  
  public abstract long getCurrentPostion();
  
  public abstract String getCurrentSubText();
  
  public abstract int getDownloadSpeed(int paramInt);
  
  public abstract long getDuration();
  
  public abstract String getHlsTagInfo(String paramString);
  
  public abstract boolean getOutputMute();
  
  public abstract Properties getPlayDetailsTime();
  
  public abstract long getPlayedTime();
  
  public abstract boolean getRecommandState();
  
  public abstract String getStreamDumpInfo();
  
  public abstract String[] getSubtitleList();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void informShowRecommend();
  
  public abstract boolean isADRunning();
  
  public abstract boolean isAdMidPagePresent();
  
  public abstract boolean isCgiCached(Context paramContext, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString);
  
  public abstract boolean isContinuePlaying();
  
  public abstract boolean isNeedPlayPostrollAd();
  
  public abstract boolean isPauseing();
  
  public abstract boolean isPlaying();
  
  public abstract boolean isPlayingAD();
  
  public abstract int isVideoCached(Context paramContext, String paramString1, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString2);
  
  public abstract void onClickPause();
  
  public abstract void onClickPause(ViewGroup paramViewGroup);
  
  public abstract boolean onKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract void onSkipAdResult(boolean paramBoolean);
  
  public abstract boolean onTouchEvent(View paramView, MotionEvent paramMotionEvent);
  
  public abstract void openMediaPlayer(Context paramContext, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString, long paramLong1, long paramLong2);
  
  public abstract void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong1, long paramLong2);
  
  public abstract void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong1, long paramLong2, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
  
  public abstract void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong1, long paramLong2, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
  
  public abstract void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong1, long paramLong2, Map<String, String> paramMap, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
  
  public abstract void openMediaPlayerByUrl(Context paramContext, String[] paramArrayOfString, long paramLong1, long paramLong2, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, TVK_UserInfo paramTVK_UserInfo);
  
  public abstract void pause();
  
  public abstract void pauseDownload();
  
  public abstract void release();
  
  public abstract void removeAdMidPagePresent();
  
  public abstract void removeAllListener();
  
  public abstract void resumeDownload();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setAdMaxWin();
  
  public abstract void setAdMinWin();
  
  public abstract void setAdServerHandler(Object paramObject);
  
  public abstract void setAudioGainRatio(float paramFloat);
  
  public abstract boolean setCurrentAudioTrack(int paramInt);
  
  public abstract boolean setCurrentSubtitle(int paramInt);
  
  public abstract void setDownloadNetworkChange(int paramInt);
  
  public abstract boolean setExternalSubtitlePath(String paramString1, String paramString2, int paramInt);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setNextLoopVideoInfo(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString);
  
  public abstract void setOnAdClickedListener(OnAdClickedListener paramOnAdClickedListener);
  
  public abstract void setOnAudioOutputFrameListener(onAudioOutputFrameListener paramonAudioOutputFrameListener);
  
  public abstract void setOnCaptureImageListener(OnCaptureImageListener paramOnCaptureImageListener);
  
  public abstract void setOnCompletionListener(OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnControllerClickListener(OnControllerClickListener paramOnControllerClickListener);
  
  public abstract void setOnDanmuCallback(DanmuCallback paramDanmuCallback);
  
  public abstract void setOnDanmuStateCallBack(OnDanmuStateCallBack paramOnDanmuStateCallBack);
  
  public abstract void setOnDownloadCallback(OnDownloadCallbackListener paramOnDownloadCallbackListener);
  
  public abstract void setOnErrorListener(OnErrorListener paramOnErrorListener);
  
  public abstract void setOnExternalSubtitleInfoListener(OnExternalSubtitleInfoListener paramOnExternalSubtitleInfoListener);
  
  public abstract void setOnGetUserInfoListener(OnGetUserInfoListener paramOnGetUserInfoListener);
  
  public abstract void setOnInfoListener(OnInfoListener paramOnInfoListener);
  
  public abstract void setOnLogoPositonlistener(OnLogoPositonlistener paramOnLogoPositonlistener);
  
  public abstract void setOnMidAdListener(OnMidAdListener paramOnMidAdListener);
  
  public abstract void setOnNetVideoInfoListener(OnNetVideoInfoListener paramOnNetVideoInfoListener);
  
  public abstract void setOnPermissionTimeoutListener(OnPermissionTimeoutListener paramOnPermissionTimeoutListener);
  
  public abstract void setOnPostrollAdListener(OnPostrollAdListener paramOnPostrollAdListener);
  
  public abstract void setOnPreAdListener(OnPreAdListener paramOnPreAdListener);
  
  public abstract void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnVideoOutputFrameListener(OnVideoOutputFrameListener paramOnVideoOutputFrameListener);
  
  public abstract void setOnVideoPreparedListener(OnVideoPreparedListener paramOnVideoPreparedListener);
  
  public abstract void setOnVideoPreparingListener(OnVideoPreparingListener paramOnVideoPreparingListener);
  
  public abstract void setOnVideoSizeChangedListener(OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  public abstract boolean setOutputMute(boolean paramBoolean);
  
  public abstract void setTcpTimeOut(int paramInt1, int paramInt2);
  
  public abstract void setVideoScaleParam(int paramInt1, int paramInt2, float paramFloat);
  
  public abstract void setXYaxis(int paramInt);
  
  public abstract void skipAd();
  
  public abstract void start();
  
  public abstract void startPlayDanmu();
  
  public abstract void stop();
  
  public abstract void stopPlayDanmu();
  
  public abstract void switchDefinition(TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract void switchDefinition(String paramString)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract void updatePlayerVideoView(IVideoViewBase paramIVideoViewBase);
  
  public abstract void updateUserInfo(TVK_UserInfo paramTVK_UserInfo);
  
  public static abstract interface DanmuCallback
  {
    public abstract void onDanmaClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
  }
  
  public static abstract interface OnAdClickedListener
  {
    public abstract void onAdExitFullScreenClick(TVK_IMediaPlayer paramTVK_IMediaPlayer);
    
    public abstract void onAdFullScreenClick(TVK_IMediaPlayer paramTVK_IMediaPlayer);
    
    public abstract void onAdReturnClick(TVK_IMediaPlayer paramTVK_IMediaPlayer);
    
    public abstract void onAdSkipClick(TVK_IMediaPlayer paramTVK_IMediaPlayer, boolean paramBoolean);
    
    public abstract void onAdWarnerTipClick(TVK_IMediaPlayer paramTVK_IMediaPlayer);
    
    public abstract void onLandingViewClosed(TVK_IMediaPlayer paramTVK_IMediaPlayer);
  }
  
  public static abstract interface OnCaptureImageListener
  {
    public abstract void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2);
    
    public abstract void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap);
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer);
  }
  
  public static abstract interface OnControllerClickListener
  {
    public abstract void onAttationClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
    
    public abstract void onBackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
    
    public abstract void onBackOnFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
    
    public abstract void onCacheClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
    
    public abstract void onFeedbackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
    
    public abstract void onFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
    
    public abstract void onReopenClick(TVK_NetVideoInfo.RecommadInfo paramRecommadInfo);
  }
  
  public static abstract interface OnDanmuStateCallBack
  {
    public abstract void OnGetDanmuState(Boolean paramBoolean, String paramString);
  }
  
  public static abstract interface OnDownloadCallbackListener
  {
    public abstract void OnDownloadCallback(String paramString);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject);
  }
  
  public static abstract interface OnExternalSubtitleInfoListener
  {
    public abstract void onExernalSubtilteInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, boolean paramBoolean, int paramInt);
  }
  
  public static abstract interface OnFreeNewWorkFlowListener
  {
    public abstract String onFreeNewWorkFlow(TVK_IMediaPlayer paramTVK_IMediaPlayer, String paramString);
  }
  
  public static abstract interface OnGetUserInfoListener
  {
    public abstract TVK_UserInfo onGetUserInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer);
  }
  
  public static abstract interface OnGetVideoPlayUrlListener
  {
    public abstract void onGetVideoPlayUrl(TVK_IMediaPlayer paramTVK_IMediaPlayer, String paramString);
    
    public abstract void onGetVideoPlayUrlFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer);
  }
  
  public static abstract interface OnInfoListener
  {
    public abstract boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject);
  }
  
  public static abstract interface OnLogoPositonlistener
  {
    public abstract void onLogoPosition(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
    
    public abstract void onOriginalLogoPosition(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  }
  
  public static abstract interface OnMidAdListener
  {
    public abstract void onMidAdCountdown(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong);
    
    public abstract void onMidAdEndCountdown(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong);
    
    public abstract void onMidAdPlayCompleted(TVK_IMediaPlayer paramTVK_IMediaPlayer);
    
    public abstract void onMidAdStartCountdown(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong1, long paramLong2);
  }
  
  public static abstract interface OnNetVideoInfoListener
  {
    public abstract void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo);
  }
  
  public static abstract interface OnPermissionTimeoutListener
  {
    public abstract void onPermissionTimeout(TVK_IMediaPlayer paramTVK_IMediaPlayer);
  }
  
  public static abstract interface OnPostrollAdListener
  {
    public abstract void onPostrollAdPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong);
    
    public abstract void onPostrollAdPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer);
  }
  
  public static abstract interface OnPreAdListener
  {
    public abstract void onPreAdPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong);
    
    public abstract void onPreAdPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer);
  }
  
  public static abstract interface OnVideoOutputFrameListener
  {
    public abstract void OnVideoOutputFrame(TVK_IMediaPlayer paramTVK_IMediaPlayer, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface OnVideoPreparedListener
  {
    public abstract void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer);
  }
  
  public static abstract interface OnVideoPreparingListener
  {
    public abstract void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer);
  }
  
  public static abstract interface OnVideoSizeChangedListener
  {
    public abstract void onVideoSizeChanged(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2);
  }
  
  public static abstract interface onAudioOutputFrameListener
  {
    public abstract void onAudioOutputFrame(TVK_IMediaPlayer paramTVK_IMediaPlayer, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer
 * JD-Core Version:    0.7.0.1
 */