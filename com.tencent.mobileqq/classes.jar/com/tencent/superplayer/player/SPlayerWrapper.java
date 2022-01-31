package com.tencent.superplayer.player;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioPcmDataListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoOutputFrameListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.SPlayerLogUtil;
import com.tencent.superplayer.utils.SPlayerUtils;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.vinfo.VInfoGetter;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

class SPlayerWrapper
  implements ISuperPlayer, ISPlayerState
{
  private static final String API_CALL_LOG_PREFIX = "api call : ";
  private static final String FILENAME = "FCCPlayerWrapper.java";
  private static final String LISTENER_CALL_LOG_PREFIX = "inner listener called : ";
  private String TAG;
  private Context mContext;
  private boolean mIsLoopback;
  private boolean mIsOutputMute;
  private MediaInfo mMediaInfo;
  private SPlayerState mPlayState;
  private SPTPPlayer mPlayer;
  private ITPPlayerProxy mPlayerProxy;
  private long mSkipEndMilSec;
  private long mStartPositionMilSec;
  private String mTagPrefix;
  private VInfoGetter mVInfoGetter;
  private SuperPlayerVideoInfo mVideoInfo;
  private ISPlayerVideoView mVideoView;
  private SPlayerWrapper.WrapperInternalListenerAdapter mWrapperListenerAdapter;
  private SPlayerListenerManager mWrapperListeners;
  private int mXYaxis = 0;
  
  public SPlayerWrapper(Context paramContext, int paramInt, String paramString, Looper paramLooper)
  {
    this.mTagPrefix = paramString;
    this.TAG = (paramString + "_" + "FCCPlayerWrapper.java");
    this.mContext = paramContext.getApplicationContext();
    this.mPlayer = new SPTPPlayer(paramContext, paramLooper, paramInt);
    this.mPlayState = new SPlayerState(paramString);
    this.mWrapperListeners = new SPlayerListenerManager(paramString);
    this.mWrapperListenerAdapter = new SPlayerWrapper.WrapperInternalListenerAdapter(this, null);
    this.mVInfoGetter = new VInfoGetter(paramContext, paramLooper);
    this.mPlayerProxy = this.mPlayer.getPlayerProxy();
    initListener();
  }
  
  private void initListener()
  {
    this.mPlayer.setOnPreparedListener(this.mWrapperListenerAdapter);
    this.mPlayer.setOnCompletionListener(this.mWrapperListenerAdapter);
    this.mPlayer.setOnInfoListener(this.mWrapperListenerAdapter);
    this.mPlayer.setOnErrorListener(this.mWrapperListenerAdapter);
    this.mPlayer.setOnSeekCompleteListener(this.mWrapperListenerAdapter);
    this.mPlayer.setOnVideoSizeChangedListener(this.mWrapperListenerAdapter);
    this.mPlayer.setOnVideoFrameOutListener(this.mWrapperListenerAdapter);
    this.mVInfoGetter.setListener(this.mWrapperListenerAdapter);
  }
  
  private void innerDoOpenMediaPlayer(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        switch (paramSuperPlayerVideoInfo.getFormat())
        {
        default: 
          TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData(i);
          localTPDownloadParamData.setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
          Object localObject = new ArrayList();
          if (paramSuperPlayerVideoInfo.getPlayUrls() != null) {
            Collections.addAll((Collection)localObject, paramSuperPlayerVideoInfo.getPlayUrls());
          }
          localTPDownloadParamData.setUrlCdnidList((ArrayList)localObject);
          localObject = new TPVideoInfo.Builder();
          if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getFileId()))
          {
            ((TPVideoInfo.Builder)localObject).fileId(paramSuperPlayerVideoInfo.getFileId());
            ((TPVideoInfo.Builder)localObject).downloadParam(localTPDownloadParamData);
            this.mPlayer.setTPVideoInfo(((TPVideoInfo.Builder)localObject).build());
            this.mPlayer.setDataSource(paramSuperPlayerVideoInfo.getPlayUrl());
            this.mPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(100, this.mStartPositionMilSec));
            this.mPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(500, this.mSkipEndMilSec));
            this.mPlayer.prepareAsync();
            return;
          }
          ((TPVideoInfo.Builder)localObject).fileId(SPlayerUtils.calculateFileID(paramSuperPlayerVideoInfo.getPlayUrl()));
          continue;
          continue;
        }
      }
      catch (IOException paramSuperPlayerVideoInfo)
      {
        paramSuperPlayerVideoInfo.printStackTrace();
        SPlayerLogUtil.e(this.TAG, "handleOpenMediaPlayerByUrl:" + paramSuperPlayerVideoInfo.getMessage());
        return;
      }
      i = 5;
      continue;
      i = 3;
      continue;
      i = 1;
    }
  }
  
  private void internalReset()
  {
    this.mMediaInfo = null;
    this.mContext = null;
    this.mIsLoopback = false;
    this.mIsOutputMute = false;
    this.mSkipEndMilSec = 0L;
    this.mStartPositionMilSec = 0L;
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    TPCaptureParams localTPCaptureParams = new TPCaptureParams();
    localTPCaptureParams.width = paramInt1;
    localTPCaptureParams.height = paramInt2;
    localTPCaptureParams.format = 37;
    localTPCaptureParams.requestedTimeMsToleranceBefore = 0L;
    localTPCaptureParams.requestedTimeMsToleranceAfter = 0L;
    this.mPlayer.captureVideo(localTPCaptureParams, this.mWrapperListenerAdapter);
    return 1;
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    TPCaptureParams localTPCaptureParams = new TPCaptureParams();
    localTPCaptureParams.width = paramInt1;
    localTPCaptureParams.height = paramInt2;
    localTPCaptureParams.format = 37;
    localTPCaptureParams.requestedTimeMsToleranceBefore = paramInt3;
    localTPCaptureParams.requestedTimeMsToleranceAfter = paramInt4;
    this.mPlayer.captureVideo(localTPCaptureParams, this.mWrapperListenerAdapter);
    return 1;
  }
  
  public long getCurrentPositionMs()
  {
    return this.mPlayer.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    if (this.mMediaInfo != null) {
      return this.mMediaInfo.getDurationMs();
    }
    return this.mPlayer.getDurationMs();
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.mMediaInfo;
  }
  
  public long getPlayedTime()
  {
    return 0L;
  }
  
  public String getStreamDumpInfo()
  {
    if (this.mMediaInfo != null) {
      return this.mMediaInfo.getMediaInfoStr();
    }
    return null;
  }
  
  public int getVideoHeight()
  {
    if (this.mMediaInfo != null) {
      return this.mMediaInfo.getVideoHeight();
    }
    return this.mPlayer.getVideoHeight();
  }
  
  public int getVideoRotation()
  {
    if (this.mMediaInfo != null) {
      return this.mMediaInfo.getVideoRotation();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    if (this.mMediaInfo != null) {
      return this.mMediaInfo.getVideoWidth();
    }
    return this.mPlayer.getVideoWidth();
  }
  
  public boolean isLoopBack()
  {
    return this.mIsLoopback;
  }
  
  public boolean isOutputMute()
  {
    return this.mIsOutputMute;
  }
  
  public boolean isPausing()
  {
    return this.mPlayState.getCurState() == 6;
  }
  
  public boolean isPlaying()
  {
    return this.mPlayState.getCurState() == 5;
  }
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mStartPositionMilSec = paramLong;
    this.mVideoInfo = paramSuperPlayerVideoInfo;
    switch (paramSuperPlayerVideoInfo.getVideoSource())
    {
    case 2: 
    default: 
      return;
    case 1: 
      this.mPlayState.changeStateAndNotify(1);
      this.mVInfoGetter.doGetVInfo(paramSuperPlayerVideoInfo);
      return;
    }
    this.mPlayState.changeStateAndNotify(2);
    innerDoOpenMediaPlayer(paramSuperPlayerVideoInfo);
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mStartPositionMilSec = paramLong;
    paramContext = new SuperPlayerVideoInfo(3, 3, null);
    paramContext.setPlayUrl(paramString);
    this.mPlayState.changeStateAndNotify(2);
    innerDoOpenMediaPlayer(paramContext);
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mStartPositionMilSec = paramLong;
    paramContext = new SuperPlayerVideoInfo(3, 3, null);
    paramContext.setPlayUrl(paramString1);
    paramContext.setLocalSavePath(paramString3);
    paramContext.setFileId(paramString2);
    this.mPlayState.changeStateAndNotify(2);
    innerDoOpenMediaPlayer(paramContext);
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String[] paramArrayOfString, long paramLong, String paramString1, String paramString2)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mStartPositionMilSec = paramLong;
    paramContext = new SuperPlayerVideoInfo(3, 3, null);
    paramContext.setPlayUrls(paramArrayOfString);
    paramContext.setLocalSavePath(paramString2);
    paramContext.setFileId(paramString1);
    this.mPlayState.changeStateAndNotify(2);
    innerDoOpenMediaPlayer(paramContext);
  }
  
  public void pause()
  {
    SPlayerLogUtil.i(this.TAG, "api call : pause");
    this.mPlayer.pause();
    this.mPlayState.changeStateAndNotify(6);
  }
  
  public void prepareAsync()
  {
    SPlayerLogUtil.i(this.TAG, "api call : prepareAsync");
    this.mPlayer.prepareAsync();
  }
  
  public void release()
  {
    SPlayerLogUtil.i(this.TAG, "api call : release");
    this.mPlayer.release();
    this.mPlayState.changeStateAndNotify(10);
    internalReset();
  }
  
  public void reset()
  {
    SPlayerLogUtil.i(this.TAG, "api call : reset");
    this.mPlayer.reset();
    this.mPlayState.changeStateAndNotify(0);
  }
  
  public void seekTo(int paramInt)
  {
    SPlayerLogUtil.i(this.TAG, "api call : seekTo, positionMs:" + paramInt);
    this.mPlayer.seekTo(paramInt);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    SPlayerLogUtil.i(this.TAG, "api call : seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    this.mPlayer.seekTo(paramInt1, paramInt2);
  }
  
  public void setDataSource(String paramString)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setDataSource, url:" + paramString);
    this.mPlayer.setDataSource(paramString);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    this.mPlayer.setDataSource(paramString, paramMap);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setLoopback, isLoopback:" + paramBoolean);
    this.mIsLoopback = paramBoolean;
    this.mPlayer.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    this.mIsLoopback = paramBoolean;
    this.mPlayer.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnAudioPcmDataListener(ISuperPlayer.OnAudioPcmDataListener paramOnAudioPcmDataListener)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setOnAudioPcmOutputListener");
    this.mWrapperListeners.setOnAudioPcmDataListener(paramOnAudioPcmDataListener);
  }
  
  public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.mWrapperListeners.setOnCaptureImageListener(paramOnCaptureImageListener);
  }
  
  public void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setOnCompletionListener");
    this.mWrapperListeners.setOnCompletionListener(paramOnCompletionListener);
  }
  
  public void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setOnErrorListener");
    this.mWrapperListeners.setOnErrorListener(paramOnErrorListener);
  }
  
  public void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setOnInfoListener");
    this.mWrapperListeners.setOnInfoListener(paramOnInfoListener);
  }
  
  public void setOnPlayStateListener(ISPlayerState.OnPlayStateChangeListener paramOnPlayStateChangeListener)
  {
    this.mPlayState.setOnPlayStateListener(paramOnPlayStateChangeListener);
  }
  
  public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setOnSeekCompleteListener");
    this.mWrapperListeners.setOnSeekCompleteListener(paramOnSeekCompleteListener);
  }
  
  public void setOnVideoOutputFrameListener(ISuperPlayer.OnVideoOutputFrameListener paramOnVideoOutputFrameListener)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setOnVideoFrameOutListener");
    this.mWrapperListeners.setOnVideoOutputFrameListener(paramOnVideoOutputFrameListener);
  }
  
  public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setOnPreparedListener");
    this.mWrapperListeners.setOnVideoPreparedListener(paramOnVideoPreparedListener);
  }
  
  public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setOnVideoSizeChangedListener");
    this.mWrapperListeners.setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setOutputMute, isOutputMute:" + paramBoolean);
    this.mIsOutputMute = paramBoolean;
    this.mPlayer.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setPlaySpeedRatio, speedRatio:" + paramFloat);
    this.mPlayer.setPlaySpeedRatio(paramFloat);
  }
  
  public void setXYaxis(int paramInt)
  {
    SPlayerLogUtil.i(this.TAG, "api call : setXYaxis, type:" + paramInt);
    this.mXYaxis = paramInt;
    if (this.mVideoView != null) {
      this.mVideoView.setXYaxis(paramInt);
    }
  }
  
  public void start()
  {
    SPlayerLogUtil.i(this.TAG, "api call : start");
    this.mPlayer.start();
    this.mPlayState.changeStateAndNotify(5);
  }
  
  public void stop()
  {
    SPlayerLogUtil.i(this.TAG, "api call : stop");
    if (this.mPlayState.getCurState() == 8)
    {
      SPlayerLogUtil.e(this.TAG, "api call : stop, failed, mPlayState.getCurState() == IFCCPlayerState.STOPPED");
      return;
    }
    this.mPlayer.stop();
    this.mPlayState.changeStateAndNotify(8);
  }
  
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    this.mVideoView = paramISPlayerVideoView;
    if (paramISPlayerVideoView != null)
    {
      paramISPlayerVideoView.setXYaxis(this.mXYaxis);
      this.mPlayer.setSurface(paramISPlayerVideoView.getSurface());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */