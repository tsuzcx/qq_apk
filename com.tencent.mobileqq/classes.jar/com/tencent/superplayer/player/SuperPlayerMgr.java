package com.tencent.superplayer.player;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioPcmDataListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoOutputFrameListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;

public class SuperPlayerMgr
  implements ISuperPlayer, SuperPlayerMgrInternal.SPlayerManagerInternalListener, ISPlayerVideoView.IVideoViewCallBack
{
  private static final String API_CALL_LOG_PREFIX = "api call : ";
  private static final String FILENAME = "SuperPlayerMgr.java";
  private static volatile int MGR_ID_BASE = 1000;
  private String TAG;
  private Context mContext;
  private HandlerThread mHandlerThread;
  private SuperPlayerListenerMgr mListenerMgr;
  private Looper mLooper;
  private int mMgrId;
  private SuperPlayerMgr.MgrListenerAdapter mMgrListenerAdpater;
  private SuperPlayerMgrCallBack mPlayerMgrCallBack;
  private SuperPlayerMgrInternal mPlayerMgrInternal;
  private SuperPlayerWrapper mPlayerWrapper;
  private String mTagPrefix;
  private ISPlayerVideoView mVideoView;
  
  public SuperPlayerMgr(Context paramContext, int paramInt, ISPlayerVideoView paramISPlayerVideoView)
  {
    int i = MGR_ID_BASE + 1;
    MGR_ID_BASE = i;
    this.mMgrId = i;
    this.mTagPrefix = ("MediaPlayerMgr-" + this.mMgrId);
    this.TAG = (this.mTagPrefix + "_" + "SuperPlayerMgr.java");
    initLooper();
    this.mContext = paramContext.getApplicationContext();
    this.mVideoView = paramISPlayerVideoView;
    this.mListenerMgr = new SuperPlayerListenerMgr(this.TAG);
    this.mPlayerMgrInternal = new SuperPlayerMgrInternal(this.TAG, this.mLooper, this);
    this.mPlayerMgrCallBack = new SuperPlayerMgrCallBack(this, this.mListenerMgr, this.mLooper);
    this.mMgrListenerAdpater = new SuperPlayerMgr.MgrListenerAdapter(this.mPlayerMgrCallBack);
    this.mPlayerWrapper = new SuperPlayerWrapper(this.mContext, paramInt, this.mTagPrefix, this.mLooper);
    if ((paramISPlayerVideoView != null) && (paramISPlayerVideoView.isSurfaceReady())) {
      this.mPlayerWrapper.updatePlayerVideoView(paramISPlayerVideoView);
    }
    initListener();
  }
  
  private void initListener()
  {
    this.mPlayerWrapper.setOnVideoPreparedListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnCompletionListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnInfoListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnErrorListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnSeekCompleteListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnVideoSizeChangedListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnVideoOutputFrameListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnAudioPcmDataListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnCaptureImageListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnDefinitionInfoListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnTVideoNetInfoUpdateListener(this.mMgrListenerAdpater);
    if (this.mVideoView != null) {
      this.mVideoView.addViewCallBack(this);
    }
  }
  
  private void initLooper()
  {
    this.mHandlerThread = new HandlerThread("SuperPlayerMgr-" + this.mMgrId);
    this.mHandlerThread.start();
    this.mLooper = this.mHandlerThread.getLooper();
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    return this.mPlayerMgrInternal.captureImageInTime(paramLong, paramInt1, paramInt2);
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return this.mPlayerMgrInternal.captureImageInTime(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public int getBufferPercent()
  {
    return this.mPlayerMgrInternal.getBufferPercent();
  }
  
  public long getCurrentPositionMs()
  {
    return this.mPlayerMgrInternal.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    return this.mPlayerMgrInternal.getDurationMs();
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.mPlayerMgrInternal.getMediaInfo();
  }
  
  public long getPlayedTime()
  {
    return this.mPlayerMgrInternal.getPlayedTime();
  }
  
  public String getStreamDumpInfo()
  {
    LogUtil.i(this.TAG, "api call : getStreamDumpInfo");
    return this.mPlayerMgrInternal.getStreamDumpInfo();
  }
  
  public int getVideoHeight()
  {
    return this.mPlayerMgrInternal.getVideoHeight();
  }
  
  public int getVideoRotation()
  {
    return this.mPlayerMgrInternal.getVideoRotation();
  }
  
  public ISPlayerVideoView getVideoView()
  {
    return this.mVideoView;
  }
  
  public int getVideoWidth()
  {
    return this.mPlayerMgrInternal.getVideoWidth();
  }
  
  public int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    return this.mPlayerWrapper.captureImageInTime(paramLong, paramInt1, paramInt2);
  }
  
  public int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return this.mPlayerWrapper.captureImageInTime(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public int handleGetBufferPercent()
  {
    return this.mPlayerWrapper.getBufferPercent();
  }
  
  public long handleGetCurrentPosition()
  {
    return this.mPlayerWrapper.getCurrentPositionMs();
  }
  
  public int handleGetDownloadSpeed(int paramInt)
  {
    return 0;
  }
  
  public long handleGetDuration()
  {
    return this.mPlayerWrapper.getDurationMs();
  }
  
  public MediaInfo handleGetMediaInfo()
  {
    return this.mPlayerWrapper.getMediaInfo();
  }
  
  public boolean handleGetOutputMute()
  {
    return this.mPlayerWrapper.isOutputMute();
  }
  
  public long handleGetPlayedTime()
  {
    return 0L;
  }
  
  public String handleGetStreamDumpInfo()
  {
    return this.mPlayerWrapper.getStreamDumpInfo();
  }
  
  public int handleGetVideoHeight()
  {
    return this.mPlayerWrapper.getVideoHeight();
  }
  
  public int handleGetVideoRotation()
  {
    return this.mPlayerWrapper.getVideoRotation();
  }
  
  public int handleGetVideoWidth()
  {
    return this.mPlayerWrapper.getVideoWidth();
  }
  
  public boolean handleIsLoopback()
  {
    return this.mPlayerWrapper.isLoopBack();
  }
  
  public boolean handleIsPausing()
  {
    return this.mPlayerWrapper.isPausing();
  }
  
  public boolean handleIsPlaying()
  {
    return this.mPlayerWrapper.isPlaying();
  }
  
  public boolean handleOnKeyEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean handleOnTouchEvent(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void handleOnVideoPrepared()
  {
    LogUtil.i(this.TAG, "handleOnVideoPrepared():");
    if ((this.mVideoView != null) && (this.mPlayerWrapper != null)) {
      this.mVideoView.setFixedSize(this.mPlayerWrapper.getVideoWidth(), this.mPlayerWrapper.getVideoHeight());
    }
  }
  
  public void handleOpenMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    this.mPlayerWrapper.openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong);
  }
  
  public void handlePause()
  {
    LogUtil.i(this.TAG, "handlePause:");
    this.mPlayerWrapper.pause();
  }
  
  public void handlePauseDownload()
  {
    this.mPlayerWrapper.pauseDownload();
  }
  
  public void handleRelease()
  {
    LogUtil.i(this.TAG, "handleRelease:");
    this.mPlayerWrapper.release();
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
  }
  
  public void handleReset()
  {
    LogUtil.i(this.TAG, "handleReset:");
    this.mPlayerWrapper.reset();
  }
  
  public void handleResumeDownload()
  {
    this.mPlayerWrapper.resumeDownload();
  }
  
  public void handleSeekTo(int paramInt)
  {
    LogUtil.i(this.TAG, "handleSeekTo, positionMilsec:" + paramInt);
    this.mPlayerWrapper.seekTo(paramInt);
  }
  
  public void handleSeekTo(int paramInt1, int paramInt2)
  {
    LogUtil.i(this.TAG, "handleSeekToAccuratePos, positionMilsec:" + paramInt1 + ", mode:" + paramInt2);
    this.mPlayerWrapper.seekTo(paramInt1, paramInt2);
  }
  
  public void handleSetAudioGainRatio(float paramFloat)
  {
    LogUtil.i(this.TAG, "handleSetAudioGainRatio, gainRatio:" + paramFloat);
  }
  
  public void handleSetLoopback(boolean paramBoolean)
  {
    LogUtil.i(this.TAG, "handleSetLoopback, isLoopback:" + paramBoolean);
    this.mPlayerWrapper.setLoopback(paramBoolean);
  }
  
  public void handleSetLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    LogUtil.i(this.TAG, "handleSetLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    this.mPlayerWrapper.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void handleSetOnAudioPcmDataListener(ISuperPlayer.OnAudioPcmDataListener paramOnAudioPcmDataListener)
  {
    this.mListenerMgr.setOnAudioPcmDataListener(paramOnAudioPcmDataListener);
  }
  
  public void handleSetOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.mListenerMgr.setOnCaptureImageListener(paramOnCaptureImageListener);
  }
  
  public void handleSetOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mListenerMgr.setOnCompletionListener(paramOnCompletionListener);
  }
  
  public void handleSetOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener paramOnDefinitionInfoListener)
  {
    this.mListenerMgr.setOnDefinitionInfoListener(paramOnDefinitionInfoListener);
  }
  
  public void handleSetOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mListenerMgr.setOnErrorListener(paramOnErrorListener);
  }
  
  public void handleSetOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener)
  {
    this.mListenerMgr.setOnInfoListener(paramOnInfoListener);
  }
  
  public void handleSetOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mListenerMgr.setOnSeekCompleteListener(paramOnSeekCompleteListener);
  }
  
  public void handleSetOnTVideoNetInfoListener(ISuperPlayer.OnTVideoNetInfoListener paramOnTVideoNetInfoListener)
  {
    this.mListenerMgr.setOnTVideoNetVideoInfoListener(paramOnTVideoNetInfoListener);
  }
  
  public void handleSetOnVideoOutputFrameListener(ISuperPlayer.OnVideoOutputFrameListener paramOnVideoOutputFrameListener)
  {
    this.mListenerMgr.setOnVideoOutputFrameListener(paramOnVideoOutputFrameListener);
  }
  
  public void handleSetOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    this.mListenerMgr.setOnVideoPreparedListener(paramOnVideoPreparedListener);
  }
  
  public void handleSetOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mListenerMgr.setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
  }
  
  public boolean handleSetOutputMute(boolean paramBoolean)
  {
    this.mPlayerWrapper.setOutputMute(paramBoolean);
    return true;
  }
  
  public void handleSetPlaySpeedRatio(float paramFloat)
  {
    LogUtil.i(this.TAG, "handleSetPlaySpeedRatio, speedRatio:" + paramFloat);
    this.mPlayerWrapper.setPlaySpeedRatio(paramFloat);
  }
  
  public void handleSetSurface(Surface paramSurface)
  {
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.setSurface(paramSurface);
    }
  }
  
  public void handleSetXYaxis(int paramInt)
  {
    this.mPlayerWrapper.setXYaxis(paramInt);
  }
  
  public void handleStart()
  {
    LogUtil.i(this.TAG, "handleStart:");
    this.mPlayerWrapper.start();
  }
  
  public void handleStop()
  {
    LogUtil.i(this.TAG, "handleStop:");
    this.mPlayerWrapper.stop();
  }
  
  public void handleSwitchDefinition(String paramString)
  {
    this.mPlayerWrapper.switchDefinition(paramString);
  }
  
  public void handleUpdatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    if (this.mPlayerWrapper != null)
    {
      if ((this.mVideoView != null) && (this.mVideoView.isSurfaceReady())) {
        this.mPlayerWrapper.updatePlayerVideoView(this.mVideoView);
      }
    }
    else {
      return;
    }
    this.mPlayerWrapper.updatePlayerVideoView(null);
  }
  
  public boolean isLoopBack()
  {
    return this.mPlayerMgrInternal.isLoopBack();
  }
  
  public boolean isOutputMute()
  {
    return this.mPlayerMgrInternal.isOutputMute();
  }
  
  public boolean isPausing()
  {
    return this.mPlayerMgrInternal.isPausing();
  }
  
  public boolean isPlaying()
  {
    return this.mPlayerMgrInternal.isPlaying();
  }
  
  public void onSurfaceChanged(Object paramObject) {}
  
  public void onSurfaceCreated(Object paramObject)
  {
    if ((this.mVideoView != null) && (this.mVideoView.getSurface() != null) && (this.mPlayerWrapper != null))
    {
      this.mPlayerWrapper.updatePlayerVideoView(this.mVideoView);
      LogUtil.i(this.TAG, "onSurfaceCreated view created. mediaPlayer.setSurface:");
      return;
    }
    LogUtil.e(this.TAG, "onSurfaceCreated view created. mVideoView.getViewSurface() = null");
  }
  
  public void onSurfaceDestroy(Object paramObject) {}
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    this.mPlayerMgrInternal.openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong);
  }
  
  public void pause()
  {
    LogUtil.i(this.TAG, "api call : pause");
    this.mPlayerMgrInternal.pause();
  }
  
  public void pauseDownload()
  {
    this.mPlayerMgrInternal.pauseDownload();
  }
  
  public void release()
  {
    LogUtil.i(this.TAG, "api call : release");
    this.mPlayerMgrInternal.release();
  }
  
  public void reset()
  {
    LogUtil.i(this.TAG, "api call : reset");
    if (this.mVideoView != null) {
      this.mVideoView.removeViewCallBack(null);
    }
    this.mVideoView = null;
    this.mPlayerMgrInternal.reset();
  }
  
  public void resumeDownload()
  {
    this.mPlayerMgrInternal.resumeDownload();
  }
  
  public void seekTo(int paramInt)
  {
    LogUtil.i(this.TAG, "api call : seekTo, positionMilsec:" + paramInt);
    this.mPlayerMgrInternal.seekTo(paramInt);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    LogUtil.i(this.TAG, "api call : seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    this.mPlayerMgrInternal.seekTo(paramInt1, paramInt2);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    this.mPlayerMgrInternal.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.mPlayerMgrInternal.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnAudioPcmDataListener(ISuperPlayer.OnAudioPcmDataListener paramOnAudioPcmDataListener)
  {
    this.mPlayerMgrInternal.setOnAudioPcmDataListener(paramOnAudioPcmDataListener);
  }
  
  public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.mPlayerMgrInternal.setOnCaptureImageListener(paramOnCaptureImageListener);
  }
  
  public void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mPlayerMgrInternal.setOnCompletionListener(paramOnCompletionListener);
  }
  
  public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener paramOnDefinitionInfoListener)
  {
    this.mPlayerMgrInternal.setOnDefinitionInfoListener(paramOnDefinitionInfoListener);
  }
  
  public void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mPlayerMgrInternal.setOnErrorListener(paramOnErrorListener);
  }
  
  public void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener)
  {
    this.mPlayerMgrInternal.setOnInfoListener(paramOnInfoListener);
  }
  
  public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mPlayerMgrInternal.setOnSeekCompleteListener(paramOnSeekCompleteListener);
  }
  
  public void setOnTVideoNetInfoUpdateListener(ISuperPlayer.OnTVideoNetInfoListener paramOnTVideoNetInfoListener)
  {
    this.mPlayerMgrInternal.setOnTVideoNetInfoUpdateListener(paramOnTVideoNetInfoListener);
  }
  
  public void setOnVideoOutputFrameListener(ISuperPlayer.OnVideoOutputFrameListener paramOnVideoOutputFrameListener)
  {
    this.mPlayerMgrInternal.setOnVideoOutputFrameListener(paramOnVideoOutputFrameListener);
  }
  
  public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    this.mPlayerMgrInternal.setOnVideoPreparedListener(paramOnVideoPreparedListener);
  }
  
  public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mPlayerMgrInternal.setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    LogUtil.i(this.TAG, "api call : setOutputMute:" + paramBoolean);
    this.mPlayerMgrInternal.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    LogUtil.i(this.TAG, "api call : setPlaySpeedRatio");
    this.mPlayerMgrInternal.setPlaySpeedRatio(paramFloat);
  }
  
  public void setSurface(Surface paramSurface)
  {
    LogUtil.i(this.TAG, "api call : setSurface");
    this.mPlayerMgrInternal.setSurface(paramSurface);
  }
  
  public void setXYaxis(int paramInt)
  {
    LogUtil.i(this.TAG, "api call : setXYaxis, type=" + paramInt);
    this.mPlayerMgrInternal.setXYaxis(paramInt);
  }
  
  public void start()
  {
    LogUtil.i(this.TAG, "api call : start");
    this.mPlayerMgrInternal.start();
  }
  
  public void stop()
  {
    LogUtil.i(this.TAG, "api call : stop");
    this.mPlayerMgrInternal.stop();
  }
  
  public void switchDefinition(String paramString)
  {
    this.mPlayerMgrInternal.switchDefinition(paramString);
  }
  
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    if (this.mVideoView == paramISPlayerVideoView) {
      return;
    }
    if (this.mVideoView != null) {
      this.mVideoView.removeViewCallBack(null);
    }
    this.mVideoView = paramISPlayerVideoView;
    if (this.mVideoView != null) {
      this.mVideoView.addViewCallBack(this);
    }
    LogUtil.i(this.TAG, "api call : updatePlayerVideoView");
    this.mPlayerMgrInternal.updatePlayerVideoView(paramISPlayerVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgr
 * JD-Core Version:    0.7.0.1
 */