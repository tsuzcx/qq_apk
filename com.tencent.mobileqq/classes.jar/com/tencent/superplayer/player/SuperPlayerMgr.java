package com.tencent.superplayer.player;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoFrameOutputListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.ISuperPlayerPool;
import com.tencent.superplayer.api.SuperPlayerAudioInfo;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.framecheck.EmptyVideoFrameCheckHelper;
import com.tencent.superplayer.framecheck.FrameComparePipeLine.OnVideoFrameCheckListener;
import com.tencent.superplayer.framecheck.IVideoFrameCheckHelper;
import com.tencent.superplayer.framecheck.VideoFrameCheckHelper;
import com.tencent.superplayer.report.ISPReporter;
import com.tencent.superplayer.report.SPReportHelper;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;

public class SuperPlayerMgr
  implements ISuperPlayer, FrameComparePipeLine.OnVideoFrameCheckListener, SuperPlayerMgrInternal.SPlayerManagerInternalListener, ISPlayerVideoView.IVideoViewCallBack
{
  private static final String API_CALL_LOG_PREFIX = "api call : ";
  private static final String API_HANDLE_LOG_PREFIX = "api handle : ";
  private static final String FILENAME = "SuperPlayerMgr.java";
  private static volatile int MGR_ID_BASE = 1000;
  private String TAG;
  private Context mContext;
  private IVideoFrameCheckHelper mFrameCheckHelper = EmptyVideoFrameCheckHelper.getInstance();
  private HandlerThread mHandlerThread;
  private boolean mIsSeeking = false;
  private SuperPlayerListenerMgr mListenerMgr;
  private Looper mLooper;
  private int mMgrId;
  private SuperPlayerMgr.MgrListenerAdapter mMgrListenerAdpater;
  private SuperPlayerMgrCallBack mPlayerMgrCallBack;
  private SuperPlayerMgrInternal mPlayerMgrInternal;
  private SuperPlayerWrapper mPlayerWrapper;
  private ISPReporter mReporter = new SPReportHelper();
  private String mTagPrefix;
  private String mToken;
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
    this.mListenerMgr = new SuperPlayerListenerMgr(this.mTagPrefix);
    this.mPlayerMgrInternal = new SuperPlayerMgrInternal(this.TAG, this.mLooper, this);
    this.mPlayerMgrCallBack = new SuperPlayerMgrCallBack(this, this.mListenerMgr, this.mLooper);
    this.mMgrListenerAdpater = new SuperPlayerMgr.MgrListenerAdapter(this.mPlayerMgrCallBack);
    this.mPlayerWrapper = new SuperPlayerWrapper(this.mContext, paramInt, this.mTagPrefix, this.mLooper);
    if ((paramISPlayerVideoView != null) && (paramISPlayerVideoView.isSurfaceReady()))
    {
      this.mPlayerWrapper.updatePlayerVideoView(paramISPlayerVideoView);
      this.mFrameCheckHelper.updatePlayerVideoView(paramISPlayerVideoView);
    }
    initListener();
    initToken();
    SuperPlayerSDKMgr.getPlayerPool().put(this);
    this.mReporter.init(this, paramInt);
  }
  
  private void handleOnError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.mReporter.onError(paramInt1 + ":" + paramInt3, paramInt1 + ":" + paramInt3 + ":" + paramInt2 + ":" + paramString);
  }
  
  private void handleOnInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 207: 
    case 105: 
    case 112: 
    case 113: 
      do
      {
        do
        {
          do
          {
            return;
          } while (!(paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo));
          this.mReporter.onDownloadProgressUpdate((TPPlayerMsg.TPDownLoadProgressInfo)paramObject);
          return;
          this.mReporter.onFirstVideoFrameRendered();
          this.mFrameCheckHelper.onFirstFrameRendered();
          return;
        } while (this.mIsSeeking);
        this.mReporter.onVideoBufferStart();
        return;
      } while (this.mIsSeeking);
      this.mReporter.onVideoBufferEnd();
      return;
    case 208: 
      if (!(paramObject instanceof TPPlayerMsg.TPMediaCodecInfo)) {
        break;
      }
    }
    for (paramISuperPlayer = (TPPlayerMsg.TPMediaCodecInfo)paramObject;; paramISuperPlayer = null)
    {
      if (paramISuperPlayer != null) {
        this.mReporter.onCodecReuseInfo(paramISuperPlayer);
      }
      this.mReporter.onVideoFrameCheckResult((int)paramLong1);
      return;
    }
  }
  
  private void handleOnSeekComplete()
  {
    this.mIsSeeking = false;
  }
  
  private void handleOnVideoPrepared()
  {
    LogUtil.i(this.TAG, "handleOnVideoPrepared():");
    if ((this.mVideoView != null) && (this.mPlayerWrapper != null)) {
      this.mVideoView.setFixedSize(this.mPlayerWrapper.getVideoWidth(), this.mPlayerWrapper.getVideoHeight());
    }
    this.mReporter.onPrepared();
  }
  
  private void initListener()
  {
    this.mPlayerWrapper.setOnVideoPreparedListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnCompletionListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnInfoListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnErrorListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnSeekCompleteListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnVideoSizeChangedListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnCaptureImageListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnDefinitionInfoListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnTVideoNetInfoUpdateListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnAudioFrameOutputListener(this.mMgrListenerAdpater);
    this.mPlayerWrapper.setOnVideoFrameOutputListener(this.mMgrListenerAdpater);
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
  
  private void initToken()
  {
    this.mToken = TVKUtils.getMd5(SystemClock.uptimeMillis() + "-" + Math.random());
    if ((this.mToken != null) && (this.mToken.length() > 24)) {
      this.mToken = this.mToken.substring(8, 24);
    }
    LogUtil.d(this.TAG, "initToken:" + this.mToken);
  }
  
  private void onPlayerOpen(SuperPlayerOption paramSuperPlayerOption)
  {
    if (paramSuperPlayerOption.enableVideoFrameCheck) {
      if ((this.mFrameCheckHelper instanceof VideoFrameCheckHelper)) {
        this.mFrameCheckHelper.onPlayerReset();
      }
    }
    for (;;)
    {
      this.mFrameCheckHelper.setOnVideoFrameCheckListener(this);
      if ((this.mVideoView != null) && (this.mVideoView.isSurfaceReady()))
      {
        this.mPlayerWrapper.updatePlayerVideoView(this.mVideoView);
        this.mFrameCheckHelper.updatePlayerVideoView(this.mVideoView);
      }
      return;
      this.mFrameCheckHelper = new VideoFrameCheckHelper();
      continue;
      this.mFrameCheckHelper = EmptyVideoFrameCheckHelper.getInstance();
    }
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    LogUtil.i(this.TAG, "api call : captureImageInTime, positionMs:" + paramLong + ", width:" + paramInt1 + ", height:" + paramInt2);
    return this.mPlayerMgrInternal.captureImageInTime(paramLong, paramInt1, paramInt2);
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    LogUtil.i(this.TAG, "api call : captureImageInTime, positionMs:" + paramLong + ", width:" + paramInt1 + ", height:" + paramInt2 + ", requestedTimeMsToleranceBefore:" + paramInt3 + ", requestedTimeMsToleranceAfter:" + paramInt4 + ", requestedTimeLimit:" + paramInt5);
    return this.mPlayerMgrInternal.captureImageInTime(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public int getBufferPercent()
  {
    return this.mPlayerMgrInternal.getBufferPercent();
  }
  
  public int getCurrentPlayerState()
  {
    return this.mPlayerWrapper.getCurrentPlayerState();
  }
  
  public long getCurrentPositionMs()
  {
    return this.mPlayerMgrInternal.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    return this.mPlayerMgrInternal.getDurationMs();
  }
  
  public String getFlowId()
  {
    return this.mPlayerWrapper.getFlowId();
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
  
  public String getToken()
  {
    return this.mToken;
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
    LogUtil.i(this.TAG, "api handle : handleCaptureImageInTime, positionMs:" + paramLong + ", width:" + paramInt1 + ", height:" + paramInt2);
    return this.mPlayerWrapper.captureImageInTime(paramLong, paramInt1, paramInt2);
  }
  
  public int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    LogUtil.i(this.TAG, "api handle : handleCaptureImageInTime, positionMs:" + paramLong + ", width:" + paramInt1 + ", height:" + paramInt2 + ", requestedTimeMsToleranceBefore:" + paramInt3 + ", requestedTimeMsToleranceAfter:" + paramInt4 + ", requestedTimeLimit:" + paramInt5);
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
  
  public boolean handleIsBuffering()
  {
    return this.mPlayerWrapper.isBuffering();
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
  
  public void handleOpenMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    LogUtil.i(this.TAG, "api handle : handleOpenMediaPlayer, playerVideoInfo:" + paramSuperPlayerVideoInfo + ", startPostionMilsec:" + paramLong);
    onPlayerOpen(paramSuperPlayerOption);
    this.mPlayerWrapper.openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, paramSuperPlayerOption);
  }
  
  public void handlePause()
  {
    LogUtil.i(this.TAG, "api handle : handlePause:");
    this.mPlayerWrapper.pause();
  }
  
  public void handlePauseDownload()
  {
    this.mPlayerWrapper.pauseDownload();
  }
  
  public void handleRelease()
  {
    LogUtil.i(this.TAG, "api handle : handleRelease:");
    this.mContext = null;
    this.mVideoView = null;
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.release();
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    this.mFrameCheckHelper.onPlayerRelease();
  }
  
  public void handleReset()
  {
    LogUtil.i(this.TAG, "api handle : handleReset:");
    this.mPlayerWrapper.reset();
    this.mFrameCheckHelper.onPlayerReset();
  }
  
  public void handleResumeDownload()
  {
    this.mPlayerWrapper.resumeDownload();
  }
  
  public void handleSeekTo(int paramInt)
  {
    LogUtil.i(this.TAG, "api handle : handleSeekTo, positionMilsec:" + paramInt);
    this.mPlayerWrapper.seekTo(paramInt);
  }
  
  public void handleSeekTo(int paramInt1, int paramInt2)
  {
    LogUtil.i(this.TAG, "api handle : handleSeekToAccuratePos, positionMilsec:" + paramInt1 + ", mode:" + paramInt2);
    this.mPlayerWrapper.seekTo(paramInt1, paramInt2);
  }
  
  public void handleSetAudioGainRatio(float paramFloat)
  {
    LogUtil.i(this.TAG, "api handle : handleSetAudioGainRatio, gainRatio:" + paramFloat);
  }
  
  public void handleSetBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      this.mPlayerWrapper.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e(this.TAG, localThrowable);
    }
  }
  
  public void handleSetLoopback(boolean paramBoolean)
  {
    LogUtil.i(this.TAG, "api handle : handleSetLoopback, isLoopback:" + paramBoolean);
    this.mPlayerWrapper.setLoopback(paramBoolean);
  }
  
  public void handleSetLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    LogUtil.i(this.TAG, "api handle : handleSetLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    this.mPlayerWrapper.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public boolean handleSetOutputMute(boolean paramBoolean)
  {
    LogUtil.i(this.TAG, "api handle : handleSetOutputMute, isMute:" + paramBoolean);
    this.mPlayerWrapper.setOutputMute(paramBoolean);
    return true;
  }
  
  public void handleSetPlaySpeedRatio(float paramFloat)
  {
    LogUtil.i(this.TAG, "api handle : handleSetPlaySpeedRatio, speedRatio:" + paramFloat);
    this.mPlayerWrapper.setPlaySpeedRatio(paramFloat);
  }
  
  public void handleSetSurface(Surface paramSurface)
  {
    LogUtil.i(this.TAG, "api handle : handleSetSurface");
    if (this.mPlayerWrapper != null) {
      this.mPlayerWrapper.setSurface(paramSurface);
    }
  }
  
  public void handleSetXYaxis(int paramInt)
  {
    LogUtil.i(this.TAG, "api handle : handleSetXYaxis");
    this.mPlayerWrapper.setXYaxis(paramInt);
  }
  
  public void handleStart()
  {
    LogUtil.i(this.TAG, "api handle : handleStart:");
    this.mPlayerWrapper.start();
    this.mFrameCheckHelper.onPlayerStart();
  }
  
  public void handleStop()
  {
    LogUtil.i(this.TAG, "api handle : handleStop:");
    this.mPlayerWrapper.stop();
    this.mFrameCheckHelper.onPlayerStop();
  }
  
  public void handleSwitchDefinition(String paramString)
  {
    this.mPlayerWrapper.switchDefinition(paramString);
  }
  
  public void handleUpdatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    LogUtil.i(this.TAG, "api handle : handleUpdatePlayerVideoView");
    if (this.mPlayerWrapper != null)
    {
      if ((this.mVideoView != null) && (this.mVideoView.isSurfaceReady()))
      {
        this.mPlayerWrapper.updatePlayerVideoView(this.mVideoView);
        this.mFrameCheckHelper.updatePlayerVideoView(paramISPlayerVideoView);
      }
    }
    else {
      return;
    }
    this.mPlayerWrapper.updatePlayerVideoView(null);
    this.mFrameCheckHelper.updatePlayerVideoView(null);
  }
  
  public void handlerSetAudioPostFrameOptionInfo(SuperPlayerAudioInfo paramSuperPlayerAudioInfo)
  {
    this.mPlayerWrapper.setAudioPostFrameOptionInfo(paramSuperPlayerAudioInfo);
  }
  
  public boolean isBuffering()
  {
    return this.mPlayerMgrInternal.isBuffering();
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
  
  public void onPrePlayViewShow()
  {
    this.mReporter.onPrePlayViewShow();
  }
  
  public void onSurfaceChanged(Object paramObject) {}
  
  public void onSurfaceCreated(Object paramObject)
  {
    if ((this.mVideoView != null) && (this.mVideoView.getSurface() != null) && (this.mPlayerWrapper != null))
    {
      this.mPlayerWrapper.updatePlayerVideoView(this.mVideoView);
      this.mFrameCheckHelper.updatePlayerVideoView(this.mVideoView);
      LogUtil.i(this.TAG, "onSurfaceCreated view created. mediaPlayer.setSurface:");
      return;
    }
    LogUtil.e(this.TAG, "onSurfaceCreated view created. mVideoView.getViewSurface() = null");
  }
  
  public void onSurfaceDestroy(Object paramObject) {}
  
  public void onVideoFrameCheckResult(int paramInt)
  {
    this.mMgrListenerAdpater.onInfo(this, 209, paramInt, 0L, null);
  }
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    LogUtil.i(this.TAG, "api call : openMediaPlayer, videoInfo:" + paramSuperPlayerVideoInfo + ", startPositionMilsec:" + paramLong);
    openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, SuperPlayerOption.obtain());
  }
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    LogUtil.i(this.TAG, "api call : openMediaPlayer, videoInfo:" + paramSuperPlayerVideoInfo + ", startPositionMilsec:" + paramLong + ", playerOption:" + paramSuperPlayerOption);
    if (paramSuperPlayerOption == null) {
      paramSuperPlayerOption = SuperPlayerOption.obtain();
    }
    for (;;)
    {
      this.mReporter.onOpenMediaPlayer(paramSuperPlayerVideoInfo, paramLong, paramSuperPlayerOption);
      this.mPlayerMgrInternal.openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, paramSuperPlayerOption);
      return;
    }
  }
  
  public void pause()
  {
    LogUtil.i(this.TAG, "api call : pause");
    this.mPlayerMgrInternal.pause();
  }
  
  public void pauseDownload()
  {
    LogUtil.i(this.TAG, "api call : pauseDownload");
    this.mPlayerMgrInternal.pauseDownload();
  }
  
  public void release()
  {
    LogUtil.i(this.TAG, "api call : release");
    SuperPlayerSDKMgr.getPlayerPool().remove(this);
    this.mPlayerMgrInternal.release();
  }
  
  public void reset()
  {
    LogUtil.i(this.TAG, "api call : reset");
    this.mPlayerMgrInternal.reset();
    this.mReporter.reset();
  }
  
  public void resumeDownload()
  {
    LogUtil.i(this.TAG, "api call : resumeDownload");
    this.mPlayerMgrInternal.resumeDownload();
  }
  
  public void seekTo(int paramInt)
  {
    LogUtil.i(this.TAG, "api call : seekTo, positionMilsec:" + paramInt);
    this.mIsSeeking = true;
    this.mPlayerMgrInternal.seekTo(paramInt);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    LogUtil.i(this.TAG, "api call : seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    this.mIsSeeking = true;
    this.mPlayerMgrInternal.seekTo(paramInt1, paramInt2);
  }
  
  public void setAudioPostFrameOptionInfo(SuperPlayerAudioInfo paramSuperPlayerAudioInfo)
  {
    this.mPlayerMgrInternal.setAudioPostFrameOptionInfo(paramSuperPlayerAudioInfo);
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPlayerMgrInternal.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    LogUtil.i(this.TAG, "api call : setLoopback, isLoopback:" + paramBoolean);
    this.mPlayerMgrInternal.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    LogUtil.i(this.TAG, "api call : setLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    this.mPlayerMgrInternal.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener paramOnAudioFrameOutputListener)
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (paramOnAudioFrameOutputListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      localSuperPlayerWrapper.setEnableAudioFrameOutput(bool);
      this.mListenerMgr.setOnAudioFrameOutputListener(paramOnAudioFrameOutputListener);
      return;
    }
  }
  
  public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.mListenerMgr.setOnCaptureImageListener(paramOnCaptureImageListener);
  }
  
  public void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mListenerMgr.setOnCompletionListener(paramOnCompletionListener);
  }
  
  public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener paramOnDefinitionInfoListener)
  {
    this.mListenerMgr.setOnDefinitionInfoListener(paramOnDefinitionInfoListener);
  }
  
  public void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mListenerMgr.setOnErrorListener(paramOnErrorListener);
  }
  
  public void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener)
  {
    this.mListenerMgr.setOnInfoListener(paramOnInfoListener);
  }
  
  public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mListenerMgr.setOnSeekCompleteListener(paramOnSeekCompleteListener);
  }
  
  public void setOnTVideoNetInfoUpdateListener(ISuperPlayer.OnTVideoNetInfoListener paramOnTVideoNetInfoListener)
  {
    this.mListenerMgr.setOnTVideoNetVideoInfoListener(paramOnTVideoNetInfoListener);
  }
  
  public void setOnVideoFrameOutputListener(ISuperPlayer.OnVideoFrameOutputListener paramOnVideoFrameOutputListener)
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (paramOnVideoFrameOutputListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      localSuperPlayerWrapper.setEnableVideoFrameOutput(bool);
      this.mListenerMgr.setOnVideoOutputFrameListener(paramOnVideoFrameOutputListener);
      return;
    }
  }
  
  public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    this.mListenerMgr.setOnVideoPreparedListener(paramOnVideoPreparedListener);
  }
  
  public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mListenerMgr.setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
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
    if (this.mVideoView != null) {
      this.mVideoView.setXYaxis(paramInt);
    }
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
    this.mReporter.onStop();
    this.mPlayerMgrInternal.stop();
  }
  
  public void switchDefinition(String paramString)
  {
    LogUtil.i(this.TAG, "api call : switchDefinition, definition:" + paramString);
    this.mPlayerMgrInternal.switchDefinition(paramString);
  }
  
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("api call : updatePlayerVideoView, mVideoView == videoView is ");
    if (this.mVideoView == paramISPlayerVideoView) {}
    for (boolean bool = true;; bool = false)
    {
      LogUtil.i(str, bool + ", videoView=" + paramISPlayerVideoView);
      if (this.mVideoView != paramISPlayerVideoView) {
        break;
      }
      return;
    }
    if (this.mVideoView != null) {
      this.mVideoView.removeViewCallBack(null);
    }
    this.mVideoView = paramISPlayerVideoView;
    if (this.mVideoView != null) {
      this.mVideoView.addViewCallBack(this);
    }
    this.mPlayerMgrInternal.updatePlayerVideoView(paramISPlayerVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgr
 * JD-Core Version:    0.7.0.1
 */