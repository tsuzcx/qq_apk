package com.tencent.superplayer.player;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
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
import com.tencent.superplayer.api.ISuperPlayer.OnSubtitleDataListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoFrameOutputListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.ISuperPlayerPool;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.framecheck.EmptyVideoFrameCheckHelper;
import com.tencent.superplayer.framecheck.FrameComparePipeLine.OnVideoFrameCheckListener;
import com.tencent.superplayer.framecheck.IVideoFrameCheckHelper;
import com.tencent.superplayer.framecheck.VideoFrameCheckHelper;
import com.tencent.superplayer.preload.PreloadPlayerInfo;
import com.tencent.superplayer.preload.PreloadPlayerMgr;
import com.tencent.superplayer.report.ISPReporter;
import com.tencent.superplayer.report.SPReportHelper;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;
import com.tencent.superplayer.view.SPlayerVideoView;
import com.tencent.superplayer.view.SPlayerVideoView.SurfaceObject;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import java.util.Map;

public class SuperPlayerMgr
  implements ISuperPlayer, FrameComparePipeLine.OnVideoFrameCheckListener, SuperPlayerMgrInternal.SPlayerManagerInternalListener, ISPlayerVideoView.IVideoViewCallBack
{
  private static final String API_CALL_LOG_PREFIX = "api call : ";
  private static final String API_HANDLE_LOG_PREFIX = "api handle : ";
  private static final String FILENAME = "SuperPlayerMgr.java";
  private Context mContext;
  private int mEmergencyTime = 0;
  private int mEmergencyTimeForPrePlay = 0;
  private IVideoFrameCheckHelper mFrameCheckHelper = EmptyVideoFrameCheckHelper.getInstance();
  private HandlerThread mHandlerThread;
  private boolean mIsLoopback = false;
  private boolean mIsOutputMute = false;
  private boolean mIsSeeking = false;
  private SuperPlayerListenerMgr mListenerMgr;
  private Looper mLooper;
  private SuperPlayerState mPlayState;
  private SuperPlayerMgrInternal mPlayerMgrInternal;
  private String mPlayerTag;
  private SuperPlayerWrapper mPlayerWrapper;
  private ISPReporter mReporter = new SPReportHelper();
  private int mSafePlayTime = 0;
  private int mSafePlayTimeForPrePlay = 0;
  private int mSceneId;
  private SPlayerVideoView.SurfaceObject mSurfaceObjectForChange;
  private String mTAG;
  private String mToken;
  private ISPlayerVideoView mVideoView;
  private int mXYaxis = 0;
  
  public SuperPlayerMgr(Context paramContext, int paramInt, ISPlayerVideoView paramISPlayerVideoView)
  {
    this.mSceneId = paramInt;
    this.mContext = paramContext.getApplicationContext();
    this.mVideoView = paramISPlayerVideoView;
    init();
  }
  
  private String getThreadName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuperPlayer-");
    localStringBuilder.append(this.mPlayerTag);
    localStringBuilder.append("-");
    localStringBuilder.append(this.mSceneId);
    return localStringBuilder.toString();
  }
  
  private void handleOnCompletion()
  {
    this.mPlayState.changeStateAndNotify(7);
  }
  
  private void handleOnError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.mPlayState.changeStateAndNotify(9);
    paramISuperPlayer = this.mReporter;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramInt3);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString);
    paramISuperPlayer.onError((String)localObject, localStringBuilder.toString());
  }
  
  private void handleOnInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (paramInt != 105)
    {
      if (paramInt != 112)
      {
        if (paramInt != 113)
        {
          if (paramInt != 250)
          {
            if (paramInt != 251)
            {
              switch (paramInt)
              {
              default: 
                return;
              case 208: 
                paramISuperPlayer = null;
                if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo)) {
                  paramISuperPlayer = (TPPlayerMsg.TPMediaCodecInfo)paramObject;
                }
                if (paramISuperPlayer != null) {
                  this.mReporter.onCodecReuseInfo(paramISuperPlayer);
                }
              case 209: 
                this.mReporter.onVideoFrameCheckResult((int)paramLong1);
                return;
              }
              if ((paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo)) {
                this.mReporter.onDownloadProgressUpdate((TPPlayerMsg.TPDownLoadProgressInfo)paramObject);
              }
            }
            else if ((paramObject instanceof String))
            {
              this.mReporter.onPcdnDownloadFailed((String)paramObject);
            }
          }
          else if ((paramObject instanceof String))
          {
            paramISuperPlayer = (String)paramObject;
            if (!TextUtils.isEmpty(paramISuperPlayer)) {
              this.mReporter.onQuicInfoUpdate(paramISuperPlayer);
            }
          }
        }
        else if (!this.mIsSeeking) {
          this.mReporter.onVideoBufferEnd();
        }
      }
      else if (!this.mIsSeeking) {
        this.mReporter.onVideoBufferStart();
      }
    }
    else
    {
      this.mReporter.onFirstVideoFrameRendered();
      this.mFrameCheckHelper.onFirstFrameRendered();
    }
  }
  
  private void handleOnSeekComplete()
  {
    this.mIsSeeking = false;
    this.mReporter.onSeekComplete();
  }
  
  private void handleOnVideoPrepared()
  {
    LogUtil.i(this.mTAG, "handleOnVideoPrepared():");
    this.mPlayState.changeStateAndNotify(4);
    ISPlayerVideoView localISPlayerVideoView = this.mVideoView;
    if (localISPlayerVideoView != null) {
      localISPlayerVideoView.setFixedSize(getVideoWidth(), getVideoHeight());
    }
    this.mReporter.onPrepared();
  }
  
  private void init()
  {
    initTagAndToken();
    this.mPlayState = new SuperPlayerState(this.mPlayerTag);
    this.mHandlerThread = new HandlerThread(getThreadName());
    this.mHandlerThread.start();
    this.mLooper = this.mHandlerThread.getLooper();
    this.mPlayerMgrInternal = new SuperPlayerMgrInternal(this.mTAG, this.mLooper, this);
    this.mPlayerMgrInternal.setIsNeedBlockMessage(true);
    this.mListenerMgr = new SuperPlayerListenerMgr(this.mPlayerTag);
    if (this.mVideoView != null)
    {
      String str = this.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updatePlayerVideoView when init, mVideoView = ");
      localStringBuilder.append(this.mVideoView);
      LogUtil.i(str, localStringBuilder.toString());
      str = this.mTAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("日志过滤(View): 【");
      localStringBuilder.append(this.mVideoView.getLogTag());
      localStringBuilder.append("】, updatePlayerVideoView when init");
      LogUtil.d(str, localStringBuilder.toString());
      this.mVideoView.addViewCallBack(this);
    }
    this.mReporter.init(this, this.mSceneId);
    SuperPlayerSDKMgr.getPlayerPool().put(this);
  }
  
  private void initListenerForWrapper()
  {
    SuperPlayerMgr.WrapperListenerAdapter localWrapperListenerAdapter = new SuperPlayerMgr.WrapperListenerAdapter(new SuperPlayerListenerCallBack(this, this.mListenerMgr, this.mLooper));
    this.mPlayerWrapper.setOnVideoPreparedListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnCompletionListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnInfoListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnErrorListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnSeekCompleteListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnVideoSizeChangedListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnCaptureImageListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnDefinitionInfoListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnTVideoNetInfoUpdateListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnAudioFrameOutputListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnVideoFrameOutputListener(localWrapperListenerAdapter);
    this.mPlayerWrapper.setOnSubtitleDataListener(localWrapperListenerAdapter);
  }
  
  private void initTagAndToken()
  {
    this.mPlayerTag = CommonUtil.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mPlayerTag);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append("SuperPlayerMgr.java");
    this.mTAG = ((StringBuilder)localObject).toString();
    if ((SuperPlayerSDKMgr.getSdkOption() != null) && (SuperPlayerSDKMgr.getSdkOption().isAsyncInit))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(hashCode());
      this.mToken = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(Math.random());
      this.mToken = TVKUtils.getMd5(((StringBuilder)localObject).toString());
    }
    localObject = this.mToken;
    if ((localObject != null) && (((String)localObject).length() > 24)) {
      this.mToken = this.mToken.substring(8, 24);
    }
    localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initToken:");
    localStringBuilder.append(this.mToken);
    LogUtil.d((String)localObject, localStringBuilder.toString());
  }
  
  private void onPlayerOpen(SuperPlayerOption paramSuperPlayerOption)
  {
    if (paramSuperPlayerOption.enableVideoFrameCheck)
    {
      paramSuperPlayerOption = this.mFrameCheckHelper;
      if ((paramSuperPlayerOption instanceof VideoFrameCheckHelper)) {
        paramSuperPlayerOption.onPlayerReset();
      } else {
        this.mFrameCheckHelper = new VideoFrameCheckHelper();
      }
    }
    else
    {
      this.mFrameCheckHelper = EmptyVideoFrameCheckHelper.getInstance();
    }
    this.mFrameCheckHelper.setOnVideoFrameCheckListener(this);
    paramSuperPlayerOption = this.mVideoView;
    if ((paramSuperPlayerOption != null) && (paramSuperPlayerOption.isSurfaceReady()))
    {
      this.mPlayerWrapper.setSurface(paramSuperPlayerOption.getSurface());
      this.mFrameCheckHelper.updatePlayerVideoView(paramSuperPlayerOption);
    }
  }
  
  public void addExtReportData(String paramString1, String paramString2)
  {
    this.mReporter.addExtReportData(paramString1, paramString2);
  }
  
  public void addExtReportData(Map<String, String> paramMap)
  {
    this.mReporter.addExtReportData(paramMap);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    this.mPlayerMgrInternal.addSubtitleSource(paramString1, paramString2, paramString3);
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : captureImageInTime, positionMs:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height:");
    localStringBuilder.append(paramInt2);
    LogUtil.i(str, localStringBuilder.toString());
    return this.mPlayerMgrInternal.captureImageInTime(paramLong, paramInt1, paramInt2);
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : captureImageInTime, positionMs:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", requestedTimeMsToleranceBefore:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", requestedTimeMsToleranceAfter:");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(", requestedTimeLimit:");
    localStringBuilder.append(paramInt5);
    LogUtil.i(str, localStringBuilder.toString());
    return this.mPlayerMgrInternal.captureImageInTime(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    this.mPlayerMgrInternal.deselectTrack(paramInt, paramLong);
  }
  
  public int getBufferPercent()
  {
    return this.mPlayerMgrInternal.getBufferPercent();
  }
  
  public int getCurrentPlayerState()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getCurrentPlayerState();
    }
    return 0;
  }
  
  public long getCurrentPositionMs()
  {
    return this.mPlayerMgrInternal.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    return this.mPlayerMgrInternal.getDurationMs();
  }
  
  public long getFileSizeBytes()
  {
    return this.mPlayerMgrInternal.getFileSizeBytes();
  }
  
  public String getFlowId()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getFlowId();
    }
    return null;
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.mPlayerMgrInternal.getMediaInfo();
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    return this.mPlayerMgrInternal.getProgramInfo();
  }
  
  public String getStreamDumpInfo()
  {
    LogUtil.i(this.mTAG, "api call : getStreamDumpInfo");
    return this.mPlayerMgrInternal.getStreamDumpInfo();
  }
  
  public String getToken()
  {
    return this.mToken;
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    return this.mPlayerMgrInternal.getTrackInfo();
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
  
  public void handleAddSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      localSuperPlayerWrapper.addSubtitleSource(paramString1, paramString2, paramString3);
    }
  }
  
  public int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api handle : handleCaptureImageInTime, positionMs:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height:");
    localStringBuilder.append(paramInt2);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    localObject = this.mPlayerWrapper;
    if (localObject != null) {
      return ((SuperPlayerWrapper)localObject).captureImageInTime(paramLong, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api handle : handleCaptureImageInTime, positionMs:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", requestedTimeMsToleranceBefore:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", requestedTimeMsToleranceAfter:");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(", requestedTimeLimit:");
    localStringBuilder.append(paramInt5);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    localObject = this.mPlayerWrapper;
    if (localObject != null) {
      return ((SuperPlayerWrapper)localObject).captureImageInTime(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    return -1;
  }
  
  public void handleDeselectTrack(int paramInt, long paramLong)
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      localSuperPlayerWrapper.deselectTrack(paramInt, paramLong);
    }
  }
  
  public int handleGetBufferPercent()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getBufferPercent();
    }
    return 0;
  }
  
  public long handleGetCurrentPosition()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public long handleGetDuration()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getDurationMs();
    }
    return 0L;
  }
  
  public long handleGetFileSizeBytes()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getFileSizeBytes();
    }
    return 0L;
  }
  
  public MediaInfo handleGetMediaInfo()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getMediaInfo();
    }
    return null;
  }
  
  public TPProgramInfo[] handleGetProgramInfo()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getProgramInfo();
    }
    return null;
  }
  
  public String handleGetStreamDumpInfo()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getStreamDumpInfo();
    }
    return null;
  }
  
  public TPTrackInfo[] handleGetTrackInfo()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getTrackInfo();
    }
    return null;
  }
  
  public int handleGetVideoHeight()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getVideoHeight();
    }
    return 0;
  }
  
  public int handleGetVideoRotation()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getVideoRotation();
    }
    return 0;
  }
  
  public int handleGetVideoWidth()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      return localSuperPlayerWrapper.getVideoWidth();
    }
    return 0;
  }
  
  public boolean handleIsBuffering()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    return (localSuperPlayerWrapper != null) && (localSuperPlayerWrapper.isBuffering());
  }
  
  public void handleOpenMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    Object localObject1 = this.mTAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("api handle : handleOpenMediaPlayer, playerVideoInfo:");
    ((StringBuilder)localObject2).append(paramSuperPlayerVideoInfo);
    ((StringBuilder)localObject2).append(", startPostionMilsec:");
    ((StringBuilder)localObject2).append(paramLong);
    LogUtil.i((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = paramSuperPlayerOption;
    if (paramSuperPlayerOption == null) {
      localObject1 = SuperPlayerOption.obtain();
    }
    int i = 1;
    paramSuperPlayerOption = PreloadPlayerMgr.getInstance().getPlayerFromPool(this.mSceneId, paramSuperPlayerVideoInfo);
    localObject2 = this.mVideoView;
    if (paramSuperPlayerOption != null)
    {
      String str = this.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("复用预加载播放器, PlayerTag = 【");
      localStringBuilder.append(paramSuperPlayerOption.player.getPlayerTag());
      localStringBuilder.append("】");
      LogUtil.i(str, localStringBuilder.toString());
      this.mPlayerWrapper = paramSuperPlayerOption.player;
      this.mPlayerWrapper.updatePlayerTag(this.mPlayerTag);
      if (localObject2 != null) {
        ((ISPlayerVideoView)localObject2).changeSurfaceObject(paramSuperPlayerOption.videoView.getStoredSurfaceObject());
      } else {
        this.mSurfaceObjectForChange = paramSuperPlayerOption.videoView.getStoredSurfaceObject();
      }
    }
    else
    {
      LogUtil.i(this.mTAG, "不复用预加载播放器");
      if (this.mPlayerWrapper == null) {
        this.mPlayerWrapper = new SuperPlayerWrapper(this.mContext, this.mSceneId, this.mPlayerTag, this.mLooper);
      }
      if ((localObject2 != null) && (((ISPlayerVideoView)localObject2).isSurfaceReady()))
      {
        this.mPlayerWrapper.setSurface(((ISPlayerVideoView)localObject2).getSurface());
        this.mFrameCheckHelper.updatePlayerVideoView((ISPlayerVideoView)localObject2);
      }
      i = 0;
    }
    initListenerForWrapper();
    this.mPlayerMgrInternal.setIsNeedBlockMessage(false);
    this.mPlayerWrapper.updateIsPreloadingStatus(false);
    this.mPlayerWrapper.setBusinessDownloadStrategy(this.mEmergencyTime, this.mSafePlayTime, this.mEmergencyTimeForPrePlay, this.mSafePlayTimeForPrePlay);
    if (i == 0)
    {
      onPlayerOpen((SuperPlayerOption)localObject1);
      this.mPlayerWrapper.openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, (SuperPlayerOption)localObject1);
    }
  }
  
  public void handlePause()
  {
    LogUtil.i(this.mTAG, "api handle : handlePause:");
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      localSuperPlayerWrapper.pause();
    }
  }
  
  public void handlePauseDownload()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      localSuperPlayerWrapper.pauseDownload();
    }
  }
  
  public void handleRelease()
  {
    LogUtil.i(this.mTAG, "api handle : handleRelease:");
    this.mContext = null;
    Object localObject = this.mFrameCheckHelper;
    if (localObject != null) {
      ((IVideoFrameCheckHelper)localObject).onPlayerRelease();
    }
    localObject = this.mListenerMgr;
    if (localObject != null) {
      ((SuperPlayerListenerMgr)localObject).release();
    }
    localObject = this.mVideoView;
    if (localObject != null) {
      ((ISPlayerVideoView)localObject).removeViewCallBack(this);
    }
    localObject = this.mPlayerWrapper;
    if (localObject != null)
    {
      ((SuperPlayerWrapper)localObject).release();
      this.mPlayerWrapper = null;
    }
    if (this.mHandlerThread != null)
    {
      if (Build.VERSION.SDK_INT >= 18) {
        this.mHandlerThread.quitSafely();
      } else {
        this.mHandlerThread.quit();
      }
      this.mHandlerThread = null;
    }
  }
  
  public void handleReset()
  {
    LogUtil.i(this.mTAG, "api handle : handleReset:");
    Object localObject = this.mPlayerWrapper;
    if (localObject != null) {
      ((SuperPlayerWrapper)localObject).reset();
    }
    localObject = this.mFrameCheckHelper;
    if (localObject != null) {
      ((IVideoFrameCheckHelper)localObject).onPlayerReset();
    }
  }
  
  public void handleResumeDownload()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      localSuperPlayerWrapper.resumeDownload();
    }
  }
  
  public void handleSeekTo(int paramInt)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api handle : handleSeekTo, positionMilsec:");
    localStringBuilder.append(paramInt);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    localObject = this.mPlayerWrapper;
    if (localObject != null) {
      ((SuperPlayerWrapper)localObject).seekTo(paramInt);
    }
  }
  
  public void handleSeekTo(int paramInt1, int paramInt2)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api handle : handleSeekToAccuratePos, positionMilsec:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", mode:");
    localStringBuilder.append(paramInt2);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    localObject = this.mPlayerWrapper;
    if (localObject != null) {
      ((SuperPlayerWrapper)localObject).seekTo(paramInt1, paramInt2);
    }
  }
  
  public void handleSelectProgram(int paramInt, long paramLong)
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      localSuperPlayerWrapper.selectProgram(paramInt, paramLong);
    }
  }
  
  public void handleSelectTrack(int paramInt, long paramLong)
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      localSuperPlayerWrapper.selectTrack(paramInt, paramLong);
    }
  }
  
  public void handleSetBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if ((localSuperPlayerWrapper != null) && (localSuperPlayerWrapper != null)) {
      try
      {
        localSuperPlayerWrapper.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      catch (Throwable localThrowable)
      {
        LogUtil.e(this.mTAG, localThrowable);
      }
    }
  }
  
  public void handleSetLoopback(boolean paramBoolean)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api handle : handleSetLoopback, isLoopback:");
    localStringBuilder.append(paramBoolean);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    this.mIsLoopback = paramBoolean;
    localObject = this.mPlayerWrapper;
    if (localObject != null) {
      ((SuperPlayerWrapper)localObject).setLoopback(paramBoolean);
    }
  }
  
  public void handleSetLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api handle : handleSetLoopback, isLoopback:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", loopStartPositionMs:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", loopEndPositionMs:");
    localStringBuilder.append(paramLong2);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    localObject = this.mPlayerWrapper;
    if (localObject != null) {
      ((SuperPlayerWrapper)localObject).setLoopback(paramBoolean, paramLong1, paramLong2);
    }
  }
  
  public boolean handleSetOutputMute(boolean paramBoolean)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api handle : handleSetOutputMute, isMute:");
    localStringBuilder.append(paramBoolean);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    this.mIsOutputMute = paramBoolean;
    localObject = this.mPlayerWrapper;
    if (localObject != null) {
      ((SuperPlayerWrapper)localObject).setOutputMute(paramBoolean);
    }
    return true;
  }
  
  public void handleSetPlaySpeedRatio(float paramFloat)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api handle : handleSetPlaySpeedRatio, speedRatio:");
    localStringBuilder.append(paramFloat);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    localObject = this.mPlayerWrapper;
    if (localObject != null) {
      ((SuperPlayerWrapper)localObject).setPlaySpeedRatio(paramFloat);
    }
  }
  
  public void handleSetSurface(Surface paramSurface)
  {
    LogUtil.i(this.mTAG, "api handle : handleSetSurface");
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      localSuperPlayerWrapper.setSurface(paramSurface);
    }
  }
  
  public void handleStart()
  {
    LogUtil.i(this.mTAG, "api handle : handleStart:");
    Object localObject = this.mPlayerWrapper;
    if (localObject != null) {
      ((SuperPlayerWrapper)localObject).start();
    }
    localObject = this.mFrameCheckHelper;
    if (localObject != null) {
      ((IVideoFrameCheckHelper)localObject).onPlayerStart();
    }
  }
  
  public void handleStop()
  {
    LogUtil.i(this.mTAG, "api handle : handleStop:");
    Object localObject = this.mPlayerWrapper;
    if (localObject != null) {
      ((SuperPlayerWrapper)localObject).stop();
    }
    localObject = this.mFrameCheckHelper;
    if (localObject != null) {
      ((IVideoFrameCheckHelper)localObject).onPlayerStop();
    }
  }
  
  public void handleSwitchDefinition(String paramString, int paramInt)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api handle : handleSwitchDefinition, definition:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", mode:");
    localStringBuilder.append(paramInt);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    localObject = this.mPlayerWrapper;
    if (localObject != null) {
      ((SuperPlayerWrapper)localObject).switchDefinition(paramString, paramInt);
    }
  }
  
  public void handleSwitchDefinitionForUrl(String paramString, int paramInt)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api handle : handleSwitchDefinition, url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", mode:");
    localStringBuilder.append(paramInt);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    localObject = this.mPlayerWrapper;
    if (localObject != null) {
      ((SuperPlayerWrapper)localObject).switchDefinitionForUrl(paramString, paramInt);
    }
  }
  
  public void handleUpdatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    LogUtil.i(this.mTAG, "api handle : handleUpdatePlayerVideoView");
    if (this.mPlayerWrapper != null)
    {
      if ((paramISPlayerVideoView != null) && (paramISPlayerVideoView.isSurfaceReady()))
      {
        this.mPlayerWrapper.setSurface(paramISPlayerVideoView.getSurface());
        this.mFrameCheckHelper.updatePlayerVideoView(paramISPlayerVideoView);
        return;
      }
      this.mPlayerWrapper.setSurface(null);
      this.mFrameCheckHelper.updatePlayerVideoView(null);
    }
  }
  
  public boolean isBuffering()
  {
    return this.mPlayerMgrInternal.isBuffering();
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
  
  public void onPrePlayViewShow()
  {
    this.mReporter.onPrePlayViewShow();
  }
  
  public void onSurfaceChanged(Object paramObject) {}
  
  public void onSurfaceCreated(Object paramObject)
  {
    ISPlayerVideoView localISPlayerVideoView = this.mVideoView;
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api handle : onSurfaceCreated, mPlayerWrapper=");
    localStringBuilder.append(this.mPlayerWrapper);
    localStringBuilder.append(", videoView=");
    localStringBuilder.append(localISPlayerVideoView);
    localStringBuilder.append(", surface=");
    if (localISPlayerVideoView != null) {
      paramObject = localISPlayerVideoView.getSurface();
    } else {
      paramObject = null;
    }
    localStringBuilder.append(paramObject);
    LogUtil.i(str, localStringBuilder.toString());
    if ((localISPlayerVideoView != null) && (localISPlayerVideoView.getSurface() != null))
    {
      paramObject = this.mPlayerWrapper;
      if (paramObject != null)
      {
        paramObject.setSurface(localISPlayerVideoView.getSurface());
        this.mFrameCheckHelper.updatePlayerVideoView(localISPlayerVideoView);
        LogUtil.i(this.mTAG, "onSurfaceCreated view created. mediaPlayer.setSurface:");
        return;
      }
    }
    LogUtil.e(this.mTAG, "onSurfaceCreated view created. mVideoView.getViewSurface() = null");
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    LogUtil.i(this.mTAG, "api handle : onSurfaceDestroy");
    paramObject = this.mPlayerWrapper;
    if (paramObject != null) {
      paramObject.setSurface(null);
    }
  }
  
  public void onVideoFrameCheckResult(int paramInt)
  {
    this.mListenerMgr.onInfo(this, 209, paramInt, 0L, null);
  }
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : openMediaPlayer, videoInfo:");
    localStringBuilder.append(paramSuperPlayerVideoInfo);
    localStringBuilder.append(", startPositionMilsec:");
    localStringBuilder.append(paramLong);
    LogUtil.i(str, localStringBuilder.toString());
    if (this.mPlayState.getCurState() != 0)
    {
      paramContext = this.mTAG;
      paramSuperPlayerVideoInfo = new StringBuilder();
      paramSuperPlayerVideoInfo.append("api call : openMediaPlayer, failed, mPlayState.getCurState() =");
      paramSuperPlayerVideoInfo.append(this.mPlayState.getCurState());
      LogUtil.e(paramContext, paramSuperPlayerVideoInfo.toString());
      return;
    }
    this.mPlayState.changeStateAndNotify(3);
    this.mReporter.onOpenMediaPlayer(paramSuperPlayerVideoInfo, paramLong, null);
    this.mPlayerMgrInternal.openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, SuperPlayerOption.obtain());
  }
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : openMediaPlayer, videoInfo:");
    localStringBuilder.append(paramSuperPlayerVideoInfo);
    localStringBuilder.append(", startPositionMilsec:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", playerOption:");
    localStringBuilder.append(paramSuperPlayerOption);
    LogUtil.i(str, localStringBuilder.toString());
    if (this.mPlayState.getCurState() != 0)
    {
      paramContext = this.mTAG;
      paramSuperPlayerVideoInfo = new StringBuilder();
      paramSuperPlayerVideoInfo.append("api call : openMediaPlayer, failed, mPlayState.getCurState() =");
      paramSuperPlayerVideoInfo.append(this.mPlayState.getCurState());
      LogUtil.e(paramContext, paramSuperPlayerVideoInfo.toString());
      return;
    }
    this.mPlayState.changeStateAndNotify(3);
    this.mReporter.onOpenMediaPlayer(paramSuperPlayerVideoInfo, paramLong, paramSuperPlayerOption);
    this.mPlayerMgrInternal.openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, paramSuperPlayerOption);
  }
  
  public void pause()
  {
    LogUtil.i(this.mTAG, "api call : pause");
    this.mPlayState.changeStateAndNotify(6);
    this.mPlayerMgrInternal.pause();
  }
  
  public void pauseDownload()
  {
    LogUtil.i(this.mTAG, "api call : pauseDownload");
    this.mPlayerMgrInternal.pauseDownload();
  }
  
  public void release()
  {
    LogUtil.i(this.mTAG, "api call : release");
    if (this.mPlayState.getCurState() == 10)
    {
      String str = this.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("api call : release, failed, mPlayState.getCurState() == ");
      localStringBuilder.append(this.mPlayState.getCurState());
      LogUtil.e(str, localStringBuilder.toString());
      return;
    }
    this.mPlayState.changeStateAndNotify(10);
    this.mReporter.onRelease();
    SuperPlayerSDKMgr.getPlayerPool().remove(this);
    this.mPlayerMgrInternal.release();
  }
  
  public void reset()
  {
    LogUtil.i(this.mTAG, "api call : reset");
    if (this.mPlayState.getCurState() == 0)
    {
      String str = this.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("api call : reset, failed, mPlayState.getCurState() =");
      localStringBuilder.append(this.mPlayState.getCurState());
      LogUtil.e(str, localStringBuilder.toString());
      return;
    }
    this.mPlayState.changeStateAndNotify(0);
    this.mVideoView = null;
    this.mReporter.reset();
    this.mSurfaceObjectForChange = null;
    this.mPlayerMgrInternal.reset();
    this.mPlayerMgrInternal.setIsNeedBlockMessage(true);
  }
  
  public void resumeDownload()
  {
    LogUtil.i(this.mTAG, "api call : resumeDownload");
    this.mPlayerMgrInternal.resumeDownload();
  }
  
  public void seekTo(int paramInt)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : seekTo, positionMilsec:");
    localStringBuilder.append(paramInt);
    LogUtil.i(str, localStringBuilder.toString());
    this.mIsSeeking = true;
    this.mReporter.onSeek(getCurrentPositionMs(), paramInt);
    this.mPlayerMgrInternal.seekTo(paramInt);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : seekTo, positionMs:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", mode:");
    localStringBuilder.append(paramInt2);
    LogUtil.i(str, localStringBuilder.toString());
    this.mIsSeeking = true;
    this.mReporter.onSeek(getCurrentPositionMs(), paramInt1);
    this.mPlayerMgrInternal.seekTo(paramInt1, paramInt2);
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mPlayerMgrInternal.selectProgram(paramInt, paramLong);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mPlayerMgrInternal.selectTrack(paramInt, paramLong);
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mEmergencyTime = paramInt1;
    this.mSafePlayTime = paramInt2;
    this.mEmergencyTimeForPrePlay = paramInt3;
    this.mSafePlayTimeForPrePlay = paramInt4;
    this.mPlayerMgrInternal.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : setLoopback, isLoopback:");
    localStringBuilder.append(paramBoolean);
    LogUtil.i(str, localStringBuilder.toString());
    this.mPlayerMgrInternal.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : setLoopback, isLoopback:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", loopStartPositionMs:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", loopEndPositionMs:");
    localStringBuilder.append(paramLong2);
    LogUtil.i(str, localStringBuilder.toString());
    this.mPlayerMgrInternal.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener paramOnAudioFrameOutputListener)
  {
    this.mListenerMgr.setOnAudioFrameOutputListener(paramOnAudioFrameOutputListener);
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
  
  public void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener paramOnSubtitleDataListener)
  {
    this.mListenerMgr.setOnSubtitleDataListener(paramOnSubtitleDataListener);
  }
  
  public void setOnTVideoNetInfoUpdateListener(ISuperPlayer.OnTVideoNetInfoListener paramOnTVideoNetInfoListener)
  {
    this.mListenerMgr.setOnTVideoNetVideoInfoListener(paramOnTVideoNetInfoListener);
  }
  
  public void setOnVideoFrameOutputListener(ISuperPlayer.OnVideoFrameOutputListener paramOnVideoFrameOutputListener)
  {
    this.mListenerMgr.setOnVideoOutputFrameListener(paramOnVideoFrameOutputListener);
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
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : setOutputMute:");
    localStringBuilder.append(paramBoolean);
    LogUtil.i(str, localStringBuilder.toString());
    this.mPlayerMgrInternal.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    LogUtil.i(this.mTAG, "api call : setPlaySpeedRatio");
    this.mPlayerMgrInternal.setPlaySpeedRatio(paramFloat);
  }
  
  public void setPlayerActive()
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      localSuperPlayerWrapper.setPlayerActive();
    }
  }
  
  public void setReportContentId(String paramString)
  {
    SuperPlayerWrapper localSuperPlayerWrapper = this.mPlayerWrapper;
    if (localSuperPlayerWrapper != null) {
      localSuperPlayerWrapper.setReportContentId(paramString);
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    LogUtil.i(this.mTAG, "api call : setSurface");
    this.mPlayerMgrInternal.setSurface(paramSurface);
  }
  
  public void setXYaxis(int paramInt)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : setXYaxis, type=");
    localStringBuilder.append(paramInt);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    this.mXYaxis = paramInt;
    localObject = this.mVideoView;
    if (localObject != null) {
      ((ISPlayerVideoView)localObject).setXYaxis(paramInt);
    }
  }
  
  public void start()
  {
    LogUtil.i(this.mTAG, "api call : start");
    this.mPlayState.changeStateAndNotify(5);
    this.mReporter.onStart();
    this.mPlayerMgrInternal.start();
  }
  
  public void stop()
  {
    LogUtil.i(this.mTAG, "api call : stop");
    if ((this.mPlayState.getCurState() != 8) && (this.mPlayState.getCurState() != 0) && (this.mPlayState.getCurState() != 10))
    {
      this.mPlayState.changeStateAndNotify(8);
      this.mReporter.onStop();
      this.mPlayerMgrInternal.stop();
      return;
    }
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : stop, failed, mPlayState.getCurState() == ");
    localStringBuilder.append(this.mPlayState.getCurState());
    LogUtil.e(str, localStringBuilder.toString());
  }
  
  public void switchDefinition(String paramString, int paramInt)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : switchDefinition, definition:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", mode:");
    localStringBuilder.append(paramInt);
    LogUtil.i(str, localStringBuilder.toString());
    this.mPlayerMgrInternal.switchDefinition(paramString, paramInt);
  }
  
  public void switchDefinitionForUrl(String paramString, int paramInt)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : switchDefinitionForUrl, url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", mode:");
    localStringBuilder.append(paramInt);
    LogUtil.i(str, localStringBuilder.toString());
    this.mPlayerMgrInternal.switchDefinitionForUrl(paramString, paramInt);
  }
  
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : updatePlayerVideoView, mVideoView == videoView is ");
    boolean bool;
    if (this.mVideoView == paramISPlayerVideoView) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(", videoView=");
    localStringBuilder.append(paramISPlayerVideoView);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    if (paramISPlayerVideoView != null)
    {
      localObject = this.mTAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("日志过滤(View): 【");
      localStringBuilder.append(paramISPlayerVideoView.getLogTag());
      localStringBuilder.append("】, updatePlayerVideoView");
      LogUtil.d((String)localObject, localStringBuilder.toString());
    }
    localObject = this.mVideoView;
    if (localObject == paramISPlayerVideoView) {
      return;
    }
    if (localObject != null) {
      ((ISPlayerVideoView)localObject).removeViewCallBack(null);
    }
    this.mVideoView = paramISPlayerVideoView;
    localObject = this.mVideoView;
    if (localObject != null)
    {
      ((ISPlayerVideoView)localObject).addViewCallBack(this);
      this.mVideoView.setXYaxis(this.mXYaxis);
    }
    localObject = this.mSurfaceObjectForChange;
    if (localObject != null)
    {
      paramISPlayerVideoView = this.mVideoView;
      if (paramISPlayerVideoView != null) {
        paramISPlayerVideoView.changeSurfaceObject((SPlayerVideoView.SurfaceObject)localObject);
      }
      this.mSurfaceObjectForChange = null;
      return;
    }
    this.mPlayerMgrInternal.updatePlayerVideoView(paramISPlayerVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgr
 * JD-Core Version:    0.7.0.1
 */