package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

public abstract interface TVK_IMediaPlayer
{
  public abstract void addDanmuContent(String paramString1, String paramString2);
  
  public abstract void addDanmuContentForLocal(String paramString);
  
  public abstract void attachControllerView();
  
  public abstract void attachControllerView(Properties paramProperties);
  
  public abstract void attachDanmuView();
  
  public abstract int captureImageInTime(int paramInt1, int paramInt2);
  
  public abstract long getAdCurrentPosition();
  
  public abstract String[] getAudioTrackList();
  
  public abstract int getBufferPercent();
  
  public abstract long getCurrentPostion();
  
  public abstract String getCurrentSubText();
  
  public abstract int getDownloadSpeed(int paramInt);
  
  public abstract long getDuration();
  
  public abstract long getFirsFrameCost();
  
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
  
  public abstract void openMediaPlayerByUrl(Context paramContext, String[] paramArrayOfString, long paramLong1, long paramLong2, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, TVK_UserInfo paramTVK_UserInfo, String paramString);
  
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
  
  public abstract void setExtractFrameModeInfo(boolean paramBoolean, HashSet<Integer> paramHashSet);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setNextLoopVideoInfo(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString);
  
  public abstract void setOnAdClickedListener(TVK_IMediaPlayer.OnAdClickedListener paramOnAdClickedListener);
  
  public abstract void setOnAudioOutputFrameListener(TVK_IMediaPlayer.onAudioOutputFrameListener paramonAudioOutputFrameListener);
  
  public abstract void setOnCaptureImageListener(TVK_IMediaPlayer.OnCaptureImageListener paramOnCaptureImageListener);
  
  public abstract void setOnCompletionListener(TVK_IMediaPlayer.OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnControllerClickListener(TVK_IMediaPlayer.OnControllerClickListener paramOnControllerClickListener);
  
  public abstract void setOnDanmuCallback(TVK_IMediaPlayer.DanmuCallback paramDanmuCallback);
  
  public abstract void setOnDanmuStateCallBack(TVK_IMediaPlayer.OnDanmuStateCallBack paramOnDanmuStateCallBack);
  
  public abstract void setOnDownloadCallback(TVK_IMediaPlayer.OnDownloadCallbackListener paramOnDownloadCallbackListener);
  
  public abstract void setOnErrorListener(TVK_IMediaPlayer.OnErrorListener paramOnErrorListener);
  
  public abstract void setOnExternalSubtitleInfoListener(TVK_IMediaPlayer.OnExternalSubtitleInfoListener paramOnExternalSubtitleInfoListener);
  
  public abstract void setOnExtractFrameListener(TVK_IMediaPlayer.OnExtractFrameListener paramOnExtractFrameListener);
  
  public abstract void setOnGetUserInfoListener(TVK_IMediaPlayer.OnGetUserInfoListener paramOnGetUserInfoListener);
  
  public abstract void setOnInfoListener(TVK_IMediaPlayer.OnInfoListener paramOnInfoListener);
  
  public abstract void setOnLogoPositonlistener(TVK_IMediaPlayer.OnLogoPositonlistener paramOnLogoPositonlistener);
  
  public abstract void setOnMidAdListener(TVK_IMediaPlayer.OnMidAdListener paramOnMidAdListener);
  
  public abstract void setOnNetVideoInfoListener(TVK_IMediaPlayer.OnNetVideoInfoListener paramOnNetVideoInfoListener);
  
  public abstract void setOnPermissionTimeoutListener(TVK_IMediaPlayer.OnPermissionTimeoutListener paramOnPermissionTimeoutListener);
  
  public abstract void setOnPostrollAdListener(TVK_IMediaPlayer.OnPostrollAdListener paramOnPostrollAdListener);
  
  public abstract void setOnPreAdListener(TVK_IMediaPlayer.OnPreAdListener paramOnPreAdListener);
  
  public abstract void setOnSeekCompleteListener(TVK_IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnVideoOutputFrameListener(TVK_IMediaPlayer.OnVideoOutputFrameListener paramOnVideoOutputFrameListener);
  
  public abstract void setOnVideoPreparedListener(TVK_IMediaPlayer.OnVideoPreparedListener paramOnVideoPreparedListener);
  
  public abstract void setOnVideoPreparingListener(TVK_IMediaPlayer.OnVideoPreparingListener paramOnVideoPreparingListener);
  
  public abstract void setOnVideoSizeChangedListener(TVK_IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  public abstract boolean setOutputMute(boolean paramBoolean);
  
  public abstract void setTcpTimeOut(int paramInt1, int paramInt2);
  
  public abstract void setVideoScaleParam(int paramInt1, int paramInt2, float paramFloat);
  
  public abstract void setXYaxis(int paramInt);
  
  public abstract void skipAd();
  
  public abstract void start();
  
  public abstract void startPlayDanmu();
  
  public abstract void stop();
  
  public abstract void stopPlayDanmu();
  
  public abstract void switchDefinition(TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString);
  
  public abstract void switchDefinition(String paramString);
  
  public abstract void updatePlayerVideoView(IVideoViewBase paramIVideoViewBase);
  
  public abstract void updateUserInfo(TVK_UserInfo paramTVK_UserInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer
 * JD-Core Version:    0.7.0.1
 */