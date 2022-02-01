package com.tencent.superplayer.player;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
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
import com.tencent.superplayer.api.SuperPlayerAudioInfo;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.Utils;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.vinfo.VInfoGetter;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPPropertyID;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.tplayer.TPPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class SuperPlayerWrapper
  implements ISuperPlayer, ISuperPlayerState
{
  private static final String API_CALL_LOG_PREFIX = "api call : ";
  private static final String FILENAME = "SuperPlayerWrapper.java";
  private static final String LISTENER_CALL_LOG_PREFIX = "inner listener called : ";
  private String TAG;
  private SuperPlayerAudioInfo mAudioOptionInfo;
  private AtomicInteger mCaptureId = new AtomicInteger();
  private Context mContext;
  private String mFlowId;
  private boolean mIsBuffering;
  private boolean mIsEnableAudioFrameOutput;
  private boolean mIsEnableVideoFrameOutput;
  private boolean mIsLoopback;
  private boolean mIsOutputMute;
  private MediaInfo mMediaInfo;
  private SuperPlayerState mPlayState;
  private SuperPlayerOption mPlayerOption = SuperPlayerOption.obtain();
  private int mSceneId = -1;
  private long mSkipEndMilSec;
  private long mStartPositionMilSec;
  private ITPPlayer mTPPlayer;
  private SuperPlayerWrapper.TPPlayerListenerAdapter mTPPlayerListenerAdapter;
  private String mTagPrefix;
  private VInfoGetter mVInfoGetter;
  private SuperPlayerVideoInfo mVideoInfo;
  private ISPlayerVideoView mVideoView;
  private SuperPlayerListenerMgr mWrapperListenersMgr;
  private int mXYaxis = 0;
  
  public SuperPlayerWrapper(Context paramContext, int paramInt, String paramString, Looper paramLooper)
  {
    this.mTagPrefix = paramString;
    this.TAG = (paramString + "_" + "SuperPlayerWrapper.java");
    this.mContext = paramContext.getApplicationContext();
    this.mSceneId = paramInt;
    this.mTPPlayer = new TPPlayer(paramContext, paramLooper, paramLooper);
    this.mPlayState = new SuperPlayerState(paramString);
    this.mWrapperListenersMgr = new SuperPlayerListenerMgr(paramString);
    this.mTPPlayerListenerAdapter = new SuperPlayerWrapper.TPPlayerListenerAdapter(this, null);
    this.mVInfoGetter = new VInfoGetter(paramContext, paramLooper);
    init();
  }
  
  private void init()
  {
    Utils.initDataTransportDataFolder(Utils.getDownloadProxyServiceType(this.mSceneId));
    this.mTPPlayer.getPlayerProxy().setProxyServiceType(Utils.getDownloadProxyServiceType(this.mSceneId));
    this.mTPPlayer.setOnPreparedListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnCompletionListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnInfoListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnErrorListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnSeekCompleteListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnVideoSizeChangedListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnVideoFrameOutListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnAudioFrameOutputListener(this.mTPPlayerListenerAdapter);
    TPDefaultReportInfo localTPDefaultReportInfo = new TPDefaultReportInfo();
    localTPDefaultReportInfo.scenesId = this.mSceneId;
    this.mTPPlayer.getReportManager().setReportInfoGetter(localTPDefaultReportInfo);
    this.mTPPlayer.addPlugin(new SuperPlayerWrapper.1(this));
    this.mVInfoGetter.setListener(this.mTPPlayerListenerAdapter);
  }
  
  private void innerDoOpenMediaPlayer(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerOption paramSuperPlayerOption)
  {
    int j = 0;
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
          localTPDownloadParamData.setUrlCookieList(paramSuperPlayerVideoInfo.getCookie());
          localTPDownloadParamData.setUrlHostList(paramSuperPlayerVideoInfo.getUrlHostList());
          localTPDownloadParamData.setFileDuration(paramSuperPlayerVideoInfo.getVideoDurationMs());
          localObject = new TPVideoInfo.Builder();
          ((TPVideoInfo.Builder)localObject).fileId(Utils.calculateFileIDForVideoInfo(paramSuperPlayerVideoInfo));
          ((TPVideoInfo.Builder)localObject).downloadParam(localTPDownloadParamData);
          this.mTPPlayer.setVideoInfo(((TPVideoInfo.Builder)localObject).build());
          if ((paramSuperPlayerVideoInfo.getVideoSource() == 3) && (paramSuperPlayerVideoInfo.getFormat() == 201))
          {
            i = j;
            if (i == 0) {
              this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(205, false));
            }
            this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(100, this.mStartPositionMilSec));
            if (this.mStartPositionMilSec > 0L) {
              this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(101, this.mPlayerOption.accurateSeekOnOpen));
            }
            this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(500, this.mSkipEndMilSec));
            if (this.mIsEnableVideoFrameOutput)
            {
              this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(119, true));
              this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(203, 3L));
            }
            if (this.mIsEnableAudioFrameOutput)
            {
              this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(120, true));
              setAudioOutputParmasInternal();
            }
            if (paramSuperPlayerOption != null)
            {
              this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(123, this.mPlayerOption.enableCodecReuse));
              if (paramSuperPlayerOption.bufferPacketMinTotalDurationMs > 0L) {
                this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, paramSuperPlayerOption.bufferPacketMinTotalDurationMs));
              }
              if (paramSuperPlayerOption.preloadPacketDurationMs > 0L) {
                this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(103, paramSuperPlayerOption.preloadPacketDurationMs));
              }
              if (paramSuperPlayerOption.minBufferingPacketDurationMs > 0L) {
                this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(104, paramSuperPlayerOption.minBufferingPacketDurationMs));
              }
            }
            this.mTPPlayer.setDataSource(paramSuperPlayerVideoInfo.getPlayUrl());
            if ((paramSuperPlayerOption != null) && (paramSuperPlayerOption.isPrePlay)) {
              this.mTPPlayer.setIsActive(false);
            }
            if (this.mVideoView != null) {
              this.mTPPlayer.setSurface(this.mVideoView.getSurface());
            }
            this.mTPPlayer.prepareAsync();
            return;
          }
          i = j;
          if (paramSuperPlayerVideoInfo.getFormat() == 103) {
            continue;
          }
          int k = paramSuperPlayerVideoInfo.getFormat();
          i = j;
          if (k == 202) {
            continue;
          }
          i = 1;
          continue;
          i = 0;
        }
      }
      catch (IOException paramSuperPlayerVideoInfo)
      {
        paramSuperPlayerVideoInfo.printStackTrace();
        LogUtil.e(this.TAG, "handleOpenMediaPlayerByUrl:" + paramSuperPlayerVideoInfo.getMessage());
        return;
      }
      continue;
      int i = 5;
      continue;
      i = 3;
      continue;
      i = 1;
      continue;
      i = 10;
      continue;
      i = 11;
    }
  }
  
  private boolean innerHandleInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 502: 
      if (!(paramObject instanceof TPPlayerMsg.TPMediaCodecInfo)) {
        break;
      }
    }
    for (paramObject = (TPPlayerMsg.TPMediaCodecInfo)paramObject; paramObject != null; paramObject = null)
    {
      LogUtil.i(this.TAG, "innerHandleInfo mediaCodecInfo mediaType:" + paramObject.mediaType + ", infoType:" + paramObject.infoType + " ,msg:" + paramObject.msg);
      return false;
      this.mIsBuffering = true;
      return false;
      this.mIsBuffering = false;
      return false;
    }
  }
  
  private void internalInitMediaInfo()
  {
    if ((this.mMediaInfo == null) && (this.mTPPlayer != null))
    {
      Object localObject = this.mTPPlayer.getPropertyString(TPPropertyID.STRING_MEDIA_INFO);
      localObject = MediaInfo.obtainMediaInfoFromString(this.mTagPrefix, (String)localObject);
      ((MediaInfo)localObject).setDurationMs(this.mTPPlayer.getDurationMs());
      ((MediaInfo)localObject).setVideoRotation((int)this.mTPPlayer.getPropertyLong(TPPropertyID.LONG_VIDEO_ROTATION));
      this.mMediaInfo = ((MediaInfo)localObject);
    }
  }
  
  private void internalReset()
  {
    this.mMediaInfo = null;
    this.mIsLoopback = false;
    this.mIsOutputMute = false;
    this.mIsBuffering = false;
    this.mSkipEndMilSec = 0L;
    this.mStartPositionMilSec = 0L;
    this.mVideoInfo = null;
    this.mPlayerOption = SuperPlayerOption.obtain();
  }
  
  private void setAudioOutputParmasInternal()
  {
    if (this.mAudioOptionInfo == null) {}
    int i;
    do
    {
      return;
      i = this.mAudioOptionInfo.getAudioSampleRateHZ();
      if (i > 0) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(350, i));
      }
      i = this.mAudioOptionInfo.getAuidoOutPutFormat();
      if (i >= 0) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(351, i));
      }
      long l = this.mAudioOptionInfo.getAudioChannelLayout();
      if (l > 0L) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(352, l));
      }
      i = this.mAudioOptionInfo.getAudioSampleFrameSize();
    } while (i <= 0);
    this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(353, i));
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    TPCaptureParams localTPCaptureParams = new TPCaptureParams();
    localTPCaptureParams.requestedTimeMs = paramLong;
    localTPCaptureParams.width = paramInt1;
    localTPCaptureParams.height = paramInt2;
    localTPCaptureParams.format = 37;
    localTPCaptureParams.requestedTimeMsToleranceBefore = 0L;
    localTPCaptureParams.requestedTimeMsToleranceAfter = 0L;
    paramInt1 = this.mCaptureId.incrementAndGet();
    this.mTPPlayerListenerAdapter.setCaptureListener(new SuperPlayerWrapper.WrapperIdCaptureListener(this, paramInt1));
    this.mTPPlayer.captureVideo(localTPCaptureParams, this.mTPPlayerListenerAdapter);
    return paramInt1;
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    TPCaptureParams localTPCaptureParams = new TPCaptureParams();
    localTPCaptureParams.requestedTimeMs = paramLong;
    localTPCaptureParams.width = paramInt1;
    localTPCaptureParams.height = paramInt2;
    localTPCaptureParams.format = 37;
    localTPCaptureParams.requestedTimeMsToleranceBefore = paramInt3;
    localTPCaptureParams.requestedTimeMsToleranceAfter = paramInt4;
    paramInt1 = this.mCaptureId.incrementAndGet();
    this.mTPPlayerListenerAdapter.setCaptureListener(new SuperPlayerWrapper.WrapperIdCaptureListener(this, paramInt1));
    this.mTPPlayer.captureVideo(localTPCaptureParams, this.mTPPlayerListenerAdapter);
    return paramInt1;
  }
  
  public int getBufferPercent()
  {
    return this.mTPPlayer.getBufferPercent();
  }
  
  public int getCurrentPlayerState()
  {
    return this.mPlayState.getCurState();
  }
  
  public long getCurrentPositionMs()
  {
    return this.mTPPlayer.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    MediaInfo localMediaInfo = this.mMediaInfo;
    if (localMediaInfo != null) {
      return localMediaInfo.getDurationMs();
    }
    return this.mTPPlayer.getDurationMs();
  }
  
  public String getFlowId()
  {
    return this.mFlowId;
  }
  
  public MediaInfo getMediaInfo()
  {
    internalInitMediaInfo();
    return this.mMediaInfo;
  }
  
  public long getPlayedTime()
  {
    return 0L;
  }
  
  public String getStreamDumpInfo()
  {
    internalInitMediaInfo();
    MediaInfo localMediaInfo = this.mMediaInfo;
    if (localMediaInfo != null) {
      return localMediaInfo.getMediaInfoStr();
    }
    return null;
  }
  
  public String getToken()
  {
    return null;
  }
  
  public int getVideoHeight()
  {
    MediaInfo localMediaInfo = this.mMediaInfo;
    if (localMediaInfo != null) {
      return localMediaInfo.getVideoHeight();
    }
    return this.mTPPlayer.getVideoHeight();
  }
  
  public int getVideoRotation()
  {
    internalInitMediaInfo();
    MediaInfo localMediaInfo = this.mMediaInfo;
    if (localMediaInfo != null) {
      return localMediaInfo.getVideoRotation();
    }
    return 0;
  }
  
  public ISPlayerVideoView getVideoView()
  {
    return null;
  }
  
  public int getVideoWidth()
  {
    MediaInfo localMediaInfo = this.mMediaInfo;
    if (localMediaInfo != null) {
      return localMediaInfo.getVideoWidth();
    }
    return this.mTPPlayer.getVideoWidth();
  }
  
  public boolean isBuffering()
  {
    return this.mIsBuffering;
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
  
  public void onPrePlayViewShow() {}
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, SuperPlayerOption.obtain());
  }
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mStartPositionMilSec = paramLong;
    this.mVideoInfo = paramSuperPlayerVideoInfo;
    this.mPlayerOption = paramSuperPlayerOption;
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
    innerDoOpenMediaPlayer(paramSuperPlayerVideoInfo, this.mPlayerOption);
  }
  
  public void pause()
  {
    LogUtil.i(this.TAG, "api call : pause");
    this.mTPPlayer.pause();
    this.mPlayState.changeStateAndNotify(6);
  }
  
  public void pauseDownload()
  {
    this.mTPPlayer.pauseDownload();
  }
  
  public void release()
  {
    LogUtil.i(this.TAG, "api call : release");
    internalReset();
    this.mContext = null;
    this.mVideoView = null;
    this.mTPPlayer.release();
    this.mPlayState.changeStateAndNotify(10);
  }
  
  public void reset()
  {
    LogUtil.i(this.TAG, "api call : reset");
    internalReset();
    this.mTPPlayer.reset();
    this.mPlayState.changeStateAndNotify(0);
  }
  
  public void resumeDownload()
  {
    this.mTPPlayer.resumeDownload();
  }
  
  public void seekTo(int paramInt)
  {
    LogUtil.i(this.TAG, "api call : seekTo, positionMs:" + paramInt);
    this.mTPPlayer.seekTo(paramInt);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    LogUtil.i(this.TAG, "api call : seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    this.mTPPlayer.seekTo(paramInt1, paramInt2);
  }
  
  public void setAudioPostFrameOptionInfo(SuperPlayerAudioInfo paramSuperPlayerAudioInfo)
  {
    this.mAudioOptionInfo = paramSuperPlayerAudioInfo;
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mTPPlayer.setBusinessDownloadStrategy(Utils.getDownloadProxyServiceType(this.mSceneId), paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setDataSource(String paramString)
  {
    LogUtil.i(this.TAG, "api call : setDataSource, url:" + paramString);
    this.mTPPlayer.setDataSource(paramString);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    this.mTPPlayer.setDataSource(paramString, paramMap);
  }
  
  public void setEnableAudioFrameOutput(boolean paramBoolean)
  {
    this.mIsEnableAudioFrameOutput = paramBoolean;
    this.mAudioOptionInfo = null;
  }
  
  public void setEnableVideoFrameOutput(boolean paramBoolean)
  {
    this.mIsEnableVideoFrameOutput = paramBoolean;
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    LogUtil.i(this.TAG, "api call : setLoopback, isLoopback:" + paramBoolean);
    this.mIsLoopback = paramBoolean;
    this.mTPPlayer.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    LogUtil.i(this.TAG, "api call : setLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    this.mIsLoopback = paramBoolean;
    this.mTPPlayer.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener paramOnAudioFrameOutputListener)
  {
    LogUtil.i(this.TAG, "api call : setOnAudioPcmOutputListener");
    this.mWrapperListenersMgr.setOnAudioFrameOutputListener(paramOnAudioFrameOutputListener);
  }
  
  public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.mWrapperListenersMgr.setOnCaptureImageListener(paramOnCaptureImageListener);
  }
  
  public void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener)
  {
    LogUtil.i(this.TAG, "api call : setOnCompletionListener");
    this.mWrapperListenersMgr.setOnCompletionListener(paramOnCompletionListener);
  }
  
  public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener paramOnDefinitionInfoListener)
  {
    this.mWrapperListenersMgr.setOnDefinitionInfoListener(paramOnDefinitionInfoListener);
  }
  
  public void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener)
  {
    LogUtil.i(this.TAG, "api call : setOnErrorListener");
    this.mWrapperListenersMgr.setOnErrorListener(paramOnErrorListener);
  }
  
  public void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener)
  {
    LogUtil.i(this.TAG, "api call : setOnInfoListener");
    this.mWrapperListenersMgr.setOnInfoListener(paramOnInfoListener);
  }
  
  public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    LogUtil.i(this.TAG, "api call : setOnSeekCompleteListener");
    this.mWrapperListenersMgr.setOnSeekCompleteListener(paramOnSeekCompleteListener);
  }
  
  public void setOnTVideoNetInfoUpdateListener(ISuperPlayer.OnTVideoNetInfoListener paramOnTVideoNetInfoListener)
  {
    this.mWrapperListenersMgr.setOnTVideoNetVideoInfoListener(paramOnTVideoNetInfoListener);
  }
  
  public void setOnVideoFrameOutputListener(ISuperPlayer.OnVideoFrameOutputListener paramOnVideoFrameOutputListener)
  {
    LogUtil.i(this.TAG, "api call : setOnVideoFrameOutListener");
    this.mWrapperListenersMgr.setOnVideoOutputFrameListener(paramOnVideoFrameOutputListener);
  }
  
  public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    LogUtil.i(this.TAG, "api call : setOnPreparedListener");
    this.mWrapperListenersMgr.setOnVideoPreparedListener(paramOnVideoPreparedListener);
  }
  
  public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    LogUtil.i(this.TAG, "api call : setOnVideoSizeChangedListener");
    this.mWrapperListenersMgr.setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    LogUtil.i(this.TAG, "api call : setOutputMute, isOutputMute:" + paramBoolean);
    this.mIsOutputMute = paramBoolean;
    this.mTPPlayer.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    LogUtil.i(this.TAG, "api call : setPlaySpeedRatio, speedRatio:" + paramFloat);
    this.mTPPlayer.setPlaySpeedRatio(paramFloat);
  }
  
  public void setSurface(Surface paramSurface)
  {
    if (this.mTPPlayer != null) {
      this.mTPPlayer.setSurface(paramSurface);
    }
  }
  
  public void setXYaxis(int paramInt)
  {
    LogUtil.i(this.TAG, "api call : setXYaxis, type:" + paramInt);
    this.mXYaxis = paramInt;
  }
  
  public void start()
  {
    LogUtil.i(this.TAG, "api call : start");
    if ((this.mPlayerOption != null) && (this.mPlayerOption.isPrePlay)) {
      this.mTPPlayer.setIsActive(true);
    }
    this.mTPPlayer.start();
    this.mPlayState.changeStateAndNotify(5);
  }
  
  public void stop()
  {
    LogUtil.i(this.TAG, "api call : stop");
    if (this.mPlayState.getCurState() == 8)
    {
      LogUtil.e(this.TAG, "api call : stop, failed, mPlayState.getCurState() == ISuperPlayerState.STOPPED");
      return;
    }
    this.mTPPlayer.stop();
    this.mPlayState.changeStateAndNotify(8);
  }
  
  public void switchDefinition(String paramString)
  {
    if ((this.mVideoInfo == null) || (this.mVideoInfo.getVideoSource() != 1))
    {
      LogUtil.e(this.TAG, "api call : switchDefinition error");
      return;
    }
    long l = getCurrentPositionMs();
    this.mTPPlayer.stop();
    this.mTPPlayer.reset();
    this.mTPPlayer.setSurface(this.mVideoView.getSurface());
    this.mVideoInfo.setRequestDefinition(paramString);
    openMediaPlayer(this.mContext, this.mVideoInfo, l, this.mPlayerOption);
  }
  
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    this.mVideoView = paramISPlayerVideoView;
    if (paramISPlayerVideoView != null)
    {
      paramISPlayerVideoView.setXYaxis(this.mXYaxis);
      this.mTPPlayer.setSurface(paramISPlayerVideoView.getSurface());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */