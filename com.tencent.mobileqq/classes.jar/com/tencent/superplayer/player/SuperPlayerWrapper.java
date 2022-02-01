package com.tencent.superplayer.player;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo.Section;
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
import com.tencent.superplayer.api.SuperPlayerAudioInfo;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.CodecReuseHelper;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.vinfo.VInfoGetter;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.api.composition.TPMediaCompositionFactory;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class SuperPlayerWrapper
  implements ISuperPlayer, ISuperPlayerState
{
  private static final String API_CALL_LOG_PREFIX = "api call : ";
  private static final String FILENAME = "SuperPlayerWrapper.java";
  private static final String LISTENER_CALL_LOG_PREFIX = "inner listener called : ";
  private AtomicInteger mCaptureId = new AtomicInteger();
  private Context mContext;
  private String mFlowId;
  private boolean mIsBuffering;
  private boolean mIsLoopback;
  private boolean mIsOutputMute;
  private SuperPlayerListenerCallBack mListenerCallback;
  private SuperPlayerListenerMgr mListenerMgr;
  private Looper mLooper;
  private MediaInfo mMediaInfo;
  private SuperPlayerState mPlayState;
  private SuperPlayerOption mPlayerOption = SuperPlayerOption.obtain();
  private String mPlayerTag;
  private TPDefaultReportInfo mReportInfo;
  private int mSceneId = -1;
  private long mSkipEndMilSec;
  private long mStartPositionMilSec;
  private Surface mSurface;
  private String mTAG;
  private ITPPlayer mTPPlayer;
  private SuperPlayerWrapper.TPPlayerListenerAdapter mTPPlayerListenerAdapter;
  private VInfoGetter mVInfoGetter;
  private SuperPlayerVideoInfo mVideoInfo;
  
  public SuperPlayerWrapper(Context paramContext, int paramInt, String paramString, Looper paramLooper)
  {
    this.mPlayerTag = paramString;
    this.mTAG = (paramString + "-" + "SuperPlayerWrapper.java");
    this.mContext = paramContext.getApplicationContext();
    this.mSceneId = paramInt;
    this.mLooper = paramLooper;
    init();
  }
  
  private void init()
  {
    this.mTPPlayer = TPPlayerFactory.createTPPlayer(this.mContext, this.mLooper, this.mLooper);
    this.mPlayState = new SuperPlayerState(this.mPlayerTag);
    this.mListenerMgr = new SuperPlayerListenerMgr(this.mPlayerTag);
    this.mListenerCallback = new SuperPlayerListenerCallBack(this, this.mListenerMgr, this.mLooper);
    this.mTPPlayerListenerAdapter = new SuperPlayerWrapper.TPPlayerListenerAdapter(this, this.mListenerCallback);
    CommonUtil.a(CommonUtil.a(this.mSceneId));
    this.mTPPlayer.getPlayerProxy().setProxyServiceType(CommonUtil.a(this.mSceneId));
    this.mTPPlayer.setOnPreparedListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnCompletionListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnInfoListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnErrorListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnSeekCompleteListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnVideoSizeChangedListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnVideoFrameOutListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnAudioFrameOutputListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnSubtitleDataListener(this.mTPPlayerListenerAdapter);
    this.mReportInfo = new TPDefaultReportInfo();
    this.mReportInfo.scenesId = this.mSceneId;
    this.mTPPlayer.getReportManager().setReportInfoGetter(this.mReportInfo);
    this.mTPPlayer.addPlugin(new SuperPlayerWrapper.1(this));
    this.mVInfoGetter = new VInfoGetter(this.mContext, this.mLooper);
    this.mVInfoGetter.setListener(this.mTPPlayerListenerAdapter);
  }
  
  private void innerConfigPlayerOption(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerOption paramSuperPlayerOption)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramSuperPlayerOption.enableDownloadProxy != null) {
      bool1 = paramSuperPlayerOption.enableDownloadProxy.booleanValue();
    }
    for (;;)
    {
      if (!bool1) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(205, false));
      }
      this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(100, this.mStartPositionMilSec));
      if (this.mStartPositionMilSec > 0L) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(101, this.mPlayerOption.accurateSeekOnOpen));
      }
      this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(500, this.mSkipEndMilSec));
      if (this.mPlayerOption.enableVideoFrameOutput)
      {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(119, true));
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(203, 3L));
      }
      if (this.mPlayerOption.enableAudioFrameOutput)
      {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(120, true));
        setAudioOutputParmasInternal(this.mPlayerOption.audioFrameOutputOption);
      }
      paramSuperPlayerVideoInfo = this.mTPPlayer;
      TPOptionalParam localTPOptionalParam = new TPOptionalParam();
      if ((this.mPlayerOption.enableCodecReuse) && (CodecReuseHelper.get().isDeviceSupport())) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramSuperPlayerVideoInfo.setPlayerOptionalParam(localTPOptionalParam.buildBoolean(123, bool1));
        if (paramSuperPlayerOption.bufferPacketMinTotalDurationMs > 0L) {
          this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, paramSuperPlayerOption.bufferPacketMinTotalDurationMs));
        }
        if (paramSuperPlayerOption.preloadPacketDurationMs > 0L) {
          this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(103, paramSuperPlayerOption.preloadPacketDurationMs));
        }
        if (paramSuperPlayerOption.minBufferingPacketDurationMs > 0L) {
          this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(104, paramSuperPlayerOption.minBufferingPacketDurationMs));
        }
        return;
        if ((paramSuperPlayerVideoInfo.getVideoSource() == 3) && (paramSuperPlayerVideoInfo.getFormat() == 201))
        {
          bool1 = false;
          break;
        }
        if ((paramSuperPlayerVideoInfo.getFormat() != 103) && (paramSuperPlayerVideoInfo.getFormat() != 202) && (paramSuperPlayerVideoInfo.getFormat() != 204)) {
          break label448;
        }
        bool1 = false;
        break;
      }
      label448:
      bool1 = true;
    }
  }
  
  private void innerDoOpenMediaPlayer(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerOption paramSuperPlayerOption)
  {
    boolean bool = true;
    Object localObject1 = this.mTAG;
    Object localObject2 = new StringBuilder().append("api call : innerDoOpenMediaPlayer mSurface == null is ");
    if (this.mSurface == null) {}
    for (;;)
    {
      LogUtil.i((String)localObject1, bool);
      try
      {
        localObject1 = new TPVideoInfo.Builder();
        ((TPVideoInfo.Builder)localObject1).fileId(CommonUtil.a(paramSuperPlayerVideoInfo));
        ((TPVideoInfo.Builder)localObject1).downloadParam(innerInitDownloadParamData(paramSuperPlayerVideoInfo, paramSuperPlayerOption));
        this.mTPPlayer.setVideoInfo(((TPVideoInfo.Builder)localObject1).build());
        innerConfigPlayerOption(paramSuperPlayerVideoInfo, paramSuperPlayerOption);
        if (paramSuperPlayerVideoInfo.getFormat() == 303)
        {
          localObject1 = TPMediaCompositionFactory.createMediaTrack(1);
          paramSuperPlayerVideoInfo = paramSuperPlayerVideoInfo.getTVideoSectionList().iterator();
          while (paramSuperPlayerVideoInfo.hasNext())
          {
            localObject2 = (TVKVideoInfo.Section)paramSuperPlayerVideoInfo.next();
            if (TextUtils.isEmpty(((TVKVideoInfo.Section)localObject2).getUrl())) {
              return;
            }
            ITPMediaTrackClip localITPMediaTrackClip = TPMediaCompositionFactory.createMediaTrackClip(((TVKVideoInfo.Section)localObject2).getUrl(), 1, 0L, 0L);
            localITPMediaTrackClip.setOriginalDurationMs((((TVKVideoInfo.Section)localObject2).getDuration() * 1000.0D));
            ((ITPMediaTrack)localObject1).addTrackClip(localITPMediaTrackClip);
          }
          this.mTPPlayer.setDataSource((ITPMediaAsset)localObject1);
        }
      }
      catch (IOException paramSuperPlayerVideoInfo)
      {
        LogUtil.e(this.mTAG, "handleOpenMediaPlayerByUrl:" + paramSuperPlayerVideoInfo.getMessage());
        return;
      }
      for (;;)
      {
        if (paramSuperPlayerOption.isPrePlay) {
          this.mTPPlayer.setIsActive(false);
        }
        if (this.mSurface != null) {
          this.mTPPlayer.setSurface(this.mSurface);
        }
        this.mTPPlayer.prepareAsync();
        return;
        this.mTPPlayer.setDataSource(paramSuperPlayerVideoInfo.getPlayUrl(), paramSuperPlayerOption.httpHeader);
      }
      bool = false;
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
      LogUtil.i(this.mTAG, "innerHandleInfo mediaCodecInfo mediaType:" + paramObject.mediaType + ", infoType:" + paramObject.infoType + " ,msg:" + paramObject.msg);
      return false;
      this.mIsBuffering = true;
      return false;
      this.mIsBuffering = false;
      return false;
    }
  }
  
  private TPDownloadParamData innerInitDownloadParamData(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerOption paramSuperPlayerOption)
  {
    Object localObject2 = paramSuperPlayerVideoInfo.getTPDownloadParamData();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new TPDownloadParamData();
    }
    ((TPDownloadParamData)localObject1).setDlType(parseDownloadType(paramSuperPlayerVideoInfo));
    ((TPDownloadParamData)localObject1).setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
    localObject2 = new ArrayList();
    if (paramSuperPlayerVideoInfo.getPlayUrls() != null) {
      Collections.addAll((Collection)localObject2, paramSuperPlayerVideoInfo.getPlayUrls());
    }
    ((TPDownloadParamData)localObject1).setUrlCdnidList((ArrayList)localObject2);
    ((TPDownloadParamData)localObject1).setUrlCookieList(paramSuperPlayerVideoInfo.getCookie());
    ((TPDownloadParamData)localObject1).setUrlHostList(paramSuperPlayerVideoInfo.getUrlHostList());
    ((TPDownloadParamData)localObject1).setFileDuration(paramSuperPlayerVideoInfo.getVideoDurationMs());
    if (paramSuperPlayerOption.superPlayerDownOption.enableP2P) {}
    for (int i = 1;; i = 0)
    {
      ((TPDownloadParamData)localObject1).setFp2p(i);
      ((TPDownloadParamData)localObject1).setFlowId(UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform());
      localObject2 = ((TPDownloadParamData)localObject1).getExtInfoMap();
      paramSuperPlayerVideoInfo = (SuperPlayerVideoInfo)localObject2;
      if (localObject2 == null) {
        paramSuperPlayerVideoInfo = new HashMap();
      }
      paramSuperPlayerVideoInfo.put("dl_param_is_enable_quic", Boolean.valueOf(paramSuperPlayerOption.superPlayerDownOption.enableUseQuic));
      paramSuperPlayerVideoInfo.put("dl_param_is_enable_quic_plaintext", Boolean.valueOf(paramSuperPlayerOption.superPlayerDownOption.enableQuicPlaintext));
      paramSuperPlayerVideoInfo.put("dl_param_is_enable_quic_connection_migration", Boolean.valueOf(paramSuperPlayerOption.superPlayerDownOption.enableQuicConnectionMigration));
      paramSuperPlayerVideoInfo.put("dl_param_quic_congestion_type", Integer.valueOf(paramSuperPlayerOption.superPlayerDownOption.quicCongestionType));
      paramSuperPlayerVideoInfo.put("dl_param_enable_teg_pcdn", Boolean.valueOf(paramSuperPlayerOption.superPlayerDownOption.enablePcdn));
      ((TPDownloadParamData)localObject1).setExtInfoMap(paramSuperPlayerVideoInfo);
      return localObject1;
    }
  }
  
  private void internalInitMediaInfo()
  {
    if ((this.mPlayState.getCurState() != 4) && (this.mPlayState.getCurState() != 5) && (this.mPlayState.getCurState() != 6)) {}
    do
    {
      do
      {
        return;
      } while ((this.mMediaInfo != null) || (this.mTPPlayer == null));
      localObject = this.mTPPlayer.getPropertyString(0);
    } while (localObject == null);
    Object localObject = MediaInfo.obtainMediaInfoFromString(this.mPlayerTag, (String)localObject);
    ((MediaInfo)localObject).setDurationMs(this.mTPPlayer.getDurationMs());
    ((MediaInfo)localObject).setVideoRotation((int)this.mTPPlayer.getPropertyLong(205));
    this.mMediaInfo = ((MediaInfo)localObject);
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
  
  private int parseDownloadType(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (paramSuperPlayerVideoInfo == null) {
      return 0;
    }
    switch (paramSuperPlayerVideoInfo.getFormat())
    {
    default: 
      return 0;
    case 101: 
    case 301: 
      return 1;
    case 201: 
    case 401: 
      return 5;
    case 102: 
    case 302: 
      return 3;
    case 104: 
    case 107: 
      return 10;
    case 202: 
    case 402: 
      return 12;
    }
    return 2;
  }
  
  private void setAudioOutputParmasInternal(SuperPlayerAudioInfo paramSuperPlayerAudioInfo)
  {
    if (paramSuperPlayerAudioInfo == null) {}
    int i;
    do
    {
      return;
      i = paramSuperPlayerAudioInfo.getAudioSampleRateHZ();
      if (i > 0) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(350, i));
      }
      i = paramSuperPlayerAudioInfo.getAuidoOutPutFormat();
      if (i >= 0) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(351, i));
      }
      long l = paramSuperPlayerAudioInfo.getAudioChannelLayout();
      if (l > 0L) {
        this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(352, l));
      }
      i = paramSuperPlayerAudioInfo.getAudioSampleFrameSize();
    } while (i <= 0);
    this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(353, i));
  }
  
  public void addExtReportData(String paramString1, String paramString2) {}
  
  public void addExtReportData(Map<String, String> paramMap) {}
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    this.mTPPlayer.addSubtitleSource(paramString1, paramString2, paramString3);
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
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    this.mTPPlayer.deselectTrack(paramInt, paramLong);
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
    if ((localMediaInfo != null) && (localMediaInfo.getDurationMs() > 0L)) {
      return localMediaInfo.getDurationMs();
    }
    return this.mTPPlayer.getDurationMs();
  }
  
  public long getFileSizeBytes()
  {
    return this.mTPPlayer.getFileSizeBytes();
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
  
  public String getPlayerTag()
  {
    return this.mPlayerTag;
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    return this.mTPPlayer.getProgramInfo();
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
  
  public TPTrackInfo[] getTrackInfo()
  {
    return this.mTPPlayer.getTrackInfo();
  }
  
  public int getVideoHeight()
  {
    MediaInfo localMediaInfo = this.mMediaInfo;
    if ((localMediaInfo != null) && (localMediaInfo.getVideoHeight() > 0)) {
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
  
  @Deprecated
  public ISPlayerVideoView getVideoView()
  {
    return null;
  }
  
  public int getVideoWidth()
  {
    MediaInfo localMediaInfo = this.mMediaInfo;
    if ((localMediaInfo != null) && (localMediaInfo.getVideoWidth() > 0)) {
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
  
  @Deprecated
  public void onPrePlayViewShow() {}
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    openMediaPlayer(paramContext, paramSuperPlayerVideoInfo, paramLong, SuperPlayerOption.obtain());
  }
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
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
    LogUtil.i(this.mTAG, "api call : pause");
    this.mTPPlayer.pause();
    this.mPlayState.changeStateAndNotify(6);
  }
  
  public void pauseDownload()
  {
    this.mTPPlayer.pauseDownload();
  }
  
  public void release()
  {
    LogUtil.i(this.mTAG, "api call : release");
    internalReset();
    this.mContext = null;
    this.mSurface = null;
    this.mLooper = null;
    this.mTPPlayer.release();
    this.mListenerMgr.release();
    this.mPlayState.changeStateAndNotify(10);
  }
  
  public void reset()
  {
    LogUtil.i(this.mTAG, "api call : reset");
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
    LogUtil.i(this.mTAG, "api call : seekTo, positionMs:" + paramInt);
    try
    {
      this.mTPPlayer.seekTo(paramInt);
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e(this.mTAG, "api call : seekTo, positionMs:" + paramInt + ", error = " + localException.toString());
    }
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    LogUtil.i(this.mTAG, "api call : seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    try
    {
      this.mTPPlayer.seekTo(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e(this.mTAG, "api call : seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2 + ", error = " + localException.toString());
    }
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mTPPlayer.selectProgram(paramInt, paramLong);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mTPPlayer.selectTrack(paramInt, paramLong);
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mTPPlayer.setBusinessDownloadStrategy(CommonUtil.a(this.mSceneId), paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    LogUtil.i(this.mTAG, "api call : setLoopback, isLoopback:" + paramBoolean);
    this.mIsLoopback = paramBoolean;
    this.mTPPlayer.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    LogUtil.i(this.mTAG, "api call : setLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    this.mIsLoopback = paramBoolean;
    this.mTPPlayer.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener paramOnAudioFrameOutputListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnAudioPcmOutputListener");
    this.mListenerMgr.setOnAudioFrameOutputListener(paramOnAudioFrameOutputListener);
  }
  
  public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.mListenerMgr.setOnCaptureImageListener(paramOnCaptureImageListener);
  }
  
  public void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnCompletionListener");
    this.mListenerMgr.setOnCompletionListener(paramOnCompletionListener);
  }
  
  public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener paramOnDefinitionInfoListener)
  {
    this.mListenerMgr.setOnDefinitionInfoListener(paramOnDefinitionInfoListener);
  }
  
  public void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnErrorListener");
    this.mListenerMgr.setOnErrorListener(paramOnErrorListener);
  }
  
  public void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnInfoListener");
    this.mListenerMgr.setOnInfoListener(paramOnInfoListener);
  }
  
  public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnSeekCompleteListener");
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
    LogUtil.i(this.mTAG, "api call : setOnVideoFrameOutListener");
    this.mListenerMgr.setOnVideoOutputFrameListener(paramOnVideoFrameOutputListener);
  }
  
  public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnPreparedListener");
    this.mListenerMgr.setOnVideoPreparedListener(paramOnVideoPreparedListener);
  }
  
  public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    LogUtil.i(this.mTAG, "api call : setOnVideoSizeChangedListener");
    this.mListenerMgr.setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    LogUtil.i(this.mTAG, "api call : setOutputMute, isOutputMute:" + paramBoolean);
    this.mIsOutputMute = paramBoolean;
    this.mTPPlayer.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    LogUtil.i(this.mTAG, "api call : setPlaySpeedRatio, speedRatio:" + paramFloat);
    this.mTPPlayer.setPlaySpeedRatio(paramFloat);
  }
  
  public void setPlayerActive()
  {
    if ((this.mPlayerOption != null) && (this.mPlayerOption.isPrePlay)) {
      this.mTPPlayer.setIsActive(true);
    }
  }
  
  public void setReportContentId(String paramString)
  {
    if (this.mReportInfo != null) {
      this.mReportInfo.vid = paramString;
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder().append("api call : setSurface, surface = ").append(paramSurface).append(", mSurface == surface is ");
    if (this.mSurface == paramSurface) {}
    for (boolean bool = true;; bool = false)
    {
      LogUtil.i(str, bool);
      this.mSurface = paramSurface;
      if (this.mTPPlayer != null) {
        this.mTPPlayer.setSurface(paramSurface);
      }
      return;
    }
  }
  
  @Deprecated
  public void setXYaxis(int paramInt) {}
  
  public void start()
  {
    LogUtil.i(this.mTAG, "api call : start");
    if ((this.mPlayerOption != null) && (this.mPlayerOption.isPrePlay)) {
      this.mTPPlayer.setIsActive(true);
    }
    this.mTPPlayer.start();
    this.mPlayState.changeStateAndNotify(5);
  }
  
  public void stop()
  {
    LogUtil.i(this.mTAG, "api call : stop");
    if (this.mPlayState.getCurState() == 8)
    {
      LogUtil.e(this.mTAG, "api call : stop, failed, mPlayState.getCurState() == ISuperPlayerState.STOPPED");
      return;
    }
    this.mTPPlayer.stop();
    this.mPlayState.changeStateAndNotify(8);
  }
  
  public void switchDefinition(String paramString)
  {
    if ((this.mVideoInfo == null) || (this.mVideoInfo.getVideoSource() != 1))
    {
      LogUtil.e(this.mTAG, "api call : switchDefinition error");
      return;
    }
    long l = getCurrentPositionMs();
    this.mTPPlayer.stop();
    this.mTPPlayer.reset();
    this.mTPPlayer.setSurface(this.mSurface);
    this.mVideoInfo.setRequestDefinition(paramString);
    openMediaPlayer(this.mContext, this.mVideoInfo, l, this.mPlayerOption);
  }
  
  public void updateIsPreloadingStatus(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mListenerCallback.setIsBlockCallback(true);
      return;
    }
    this.mListenerCallback.setIsBlockCallback(false);
  }
  
  void updatePlayerTag(String paramString)
  {
    LogUtil.i(this.mTAG, "【Important】 updatePlayerTag from 【" + this.mPlayerTag + "】 to 【" + paramString + "】");
    this.mPlayerTag = paramString;
    this.mTAG = (paramString + "-" + "SuperPlayerWrapper.java");
    this.mPlayState.updatePlayerTag(this.mPlayerTag);
    this.mListenerMgr.updatePlayerTag(this.mPlayerTag);
  }
  
  @Deprecated
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */