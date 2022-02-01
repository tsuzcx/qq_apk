package com.tencent.superplayer.player;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
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
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.CodecReuseHelper;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.TVideoUtil;
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
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.api.report.TPLiveReportInfo;
import com.tencent.thumbplayer.api.report.TPVodReportInfo;
import java.io.IOException;
import java.util.Map;
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
  private boolean mIsSwitchingTVideoDefn;
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
  private final AtomicInteger mSwitchDefnId = new AtomicInteger(1);
  private String mTAG;
  private ITPPlayer mTPPlayer;
  private SuperPlayerWrapper.TPPlayerListenerAdapter mTPPlayerListenerAdapter;
  private int mTVdieoSwitchDefnMode;
  private VInfoGetter mVInfoGetter;
  private SuperPlayerVideoInfo mVideoInfo;
  
  public SuperPlayerWrapper(Context paramContext, int paramInt, String paramString, Looper paramLooper)
  {
    this.mPlayerTag = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    localStringBuilder.append("SuperPlayerWrapper.java");
    this.mTAG = localStringBuilder.toString();
    this.mContext = paramContext.getApplicationContext();
    this.mSceneId = paramInt;
    this.mLooper = paramLooper;
    init();
  }
  
  private void init()
  {
    Context localContext = this.mContext;
    Looper localLooper = this.mLooper;
    this.mTPPlayer = TPPlayerFactory.createTPPlayer(localContext, localLooper, localLooper);
    this.mPlayState = new SuperPlayerState(this.mPlayerTag);
    this.mListenerMgr = new SuperPlayerListenerMgr(this.mPlayerTag);
    this.mListenerCallback = new SuperPlayerListenerCallBack(this, this.mListenerMgr, this.mLooper);
    this.mTPPlayerListenerAdapter = new SuperPlayerWrapper.TPPlayerListenerAdapter(this, this.mListenerCallback);
    CommonUtil.a(CommonUtil.b(this.mSceneId));
    this.mTPPlayer.getPlayerProxy().setProxyServiceType(CommonUtil.b(this.mSceneId));
    this.mTPPlayer.setOnPreparedListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnCompletionListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnInfoListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnErrorListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnSeekCompleteListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnVideoSizeChangedListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnVideoFrameOutListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnAudioFrameOutputListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.setOnSubtitleDataListener(this.mTPPlayerListenerAdapter);
    this.mTPPlayer.addPlugin(new SuperPlayerWrapper.1(this));
    this.mVInfoGetter = new VInfoGetter(this.mContext, this.mLooper);
    this.mVInfoGetter.setListener(this.mTPPlayerListenerAdapter);
  }
  
  private void innerConfigPlayerOption(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerOption paramSuperPlayerOption)
  {
    Object localObject = paramSuperPlayerOption.enableDownloadProxy;
    boolean bool2 = false;
    if (localObject != null) {
      bool1 = paramSuperPlayerOption.enableDownloadProxy.booleanValue();
    } else if (((paramSuperPlayerVideoInfo.getVideoSource() != 3) || (paramSuperPlayerVideoInfo.getFormat() != 201)) && (paramSuperPlayerVideoInfo.getFormat() != 103) && (paramSuperPlayerVideoInfo.getFormat() != 202) && (paramSuperPlayerVideoInfo.getFormat() != 204)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
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
    localObject = new TPOptionalParam();
    boolean bool1 = bool2;
    if (this.mPlayerOption.enableCodecReuse)
    {
      bool1 = bool2;
      if (CodecReuseHelper.get().isDeviceSupport()) {
        bool1 = true;
      }
    }
    paramSuperPlayerVideoInfo.setPlayerOptionalParam(((TPOptionalParam)localObject).buildBoolean(123, bool1));
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
  
  private void innerDoOpenMediaPlayer(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerOption paramSuperPlayerOption)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : innerDoOpenMediaPlayer mSurface == null is ");
    boolean bool;
    if (this.mSurface == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    try
    {
      localObject = new TPVideoInfo.Builder();
      ((TPVideoInfo.Builder)localObject).fileId(CommonUtil.a(paramSuperPlayerVideoInfo));
      ((TPVideoInfo.Builder)localObject).downloadParam(innerInitDownloadParamData(paramSuperPlayerVideoInfo, paramSuperPlayerOption));
      this.mTPPlayer.setVideoInfo(((TPVideoInfo.Builder)localObject).build());
      innerConfigPlayerOption(paramSuperPlayerVideoInfo, paramSuperPlayerOption);
      if (paramSuperPlayerOption.isPrePlay) {
        this.mTPPlayer.setIsActive(false);
      }
      if (paramSuperPlayerVideoInfo.getFormat() == 303) {
        this.mTPPlayer.setDataSource(TVideoUtil.a(paramSuperPlayerVideoInfo));
      } else if (paramSuperPlayerVideoInfo.getMediaAssert() != null) {
        this.mTPPlayer.setDataSource(paramSuperPlayerVideoInfo.getMediaAssert());
      } else {
        this.mTPPlayer.setDataSource(paramSuperPlayerVideoInfo.getPlayUrl(), paramSuperPlayerOption.httpHeader);
      }
      if (this.mSurface != null) {
        this.mTPPlayer.setSurface(this.mSurface);
      }
      this.mTPPlayer.prepareAsync();
      return;
    }
    catch (IOException paramSuperPlayerVideoInfo)
    {
      paramSuperPlayerOption = this.mTAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleOpenMediaPlayerByUrl:");
      ((StringBuilder)localObject).append(paramSuperPlayerVideoInfo.getMessage());
      LogUtil.e(paramSuperPlayerOption, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean innerHandleInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (paramInt != 200)
    {
      if (paramInt != 201)
      {
        if (paramInt != 502) {
          return false;
        }
        TPPlayerMsg.TPMediaCodecInfo localTPMediaCodecInfo = null;
        if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo)) {
          localTPMediaCodecInfo = (TPPlayerMsg.TPMediaCodecInfo)paramObject;
        }
        if (localTPMediaCodecInfo != null)
        {
          paramObject = this.mTAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("innerHandleInfo mediaCodecInfo mediaType:");
          localStringBuilder.append(localTPMediaCodecInfo.mediaType);
          localStringBuilder.append(", infoType:");
          localStringBuilder.append(localTPMediaCodecInfo.infoType);
          localStringBuilder.append(" ,msg:");
          localStringBuilder.append(localTPMediaCodecInfo.msg);
          LogUtil.i(paramObject, localStringBuilder.toString());
          return false;
        }
      }
      else
      {
        this.mIsBuffering = false;
        return false;
      }
    }
    else {
      this.mIsBuffering = true;
    }
    return false;
  }
  
  private TPDownloadParamData innerInitDownloadParamData(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerOption paramSuperPlayerOption)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void internalInitMediaInfo()
  {
    if ((this.mPlayState.getCurState() != 4) && (this.mPlayState.getCurState() != 5) && (this.mPlayState.getCurState() != 6)) {
      return;
    }
    if (this.mMediaInfo == null)
    {
      Object localObject = this.mTPPlayer;
      if (localObject != null)
      {
        localObject = ((ITPPlayer)localObject).getPropertyString(0);
        if (localObject != null)
        {
          localObject = MediaInfo.obtainMediaInfoFromString(this.mPlayerTag, (String)localObject);
          ((MediaInfo)localObject).setDurationMs(this.mTPPlayer.getDurationMs());
          ((MediaInfo)localObject).setVideoRotation((int)this.mTPPlayer.getPropertyLong(205));
          this.mMediaInfo = ((MediaInfo)localObject);
        }
      }
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
  
  private int parseDownloadType(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (paramSuperPlayerVideoInfo == null) {
      return 0;
    }
    int i = paramSuperPlayerVideoInfo.getFormat();
    if (i != 101)
    {
      if (i != 102) {
        if ((i != 104) && (i != 107)) {
          if (i != 201) {
            if (i != 202)
            {
              if (i == 401) {
                break label99;
              }
              if (i == 402) {}
            }
          }
        }
      }
      switch (i)
      {
      default: 
        return 0;
      case 303: 
        return 2;
        return 12;
        return 5;
        return 10;
      case 302: 
        label99:
        return 3;
      }
    }
    return 1;
  }
  
  private void setAudioOutputParmasInternal(SuperPlayerAudioInfo paramSuperPlayerAudioInfo)
  {
    if (paramSuperPlayerAudioInfo == null) {
      return;
    }
    int i = paramSuperPlayerAudioInfo.getAudioSampleRateHZ();
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
    if (i > 0) {
      this.mTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(353, i));
    }
  }
  
  private void setReportInfo(int paramInt)
  {
    if (CommonUtil.c(paramInt)) {
      this.mReportInfo = new TPLiveReportInfo();
    } else {
      this.mReportInfo = new TPVodReportInfo();
    }
    this.mReportInfo.scenesId = this.mSceneId;
    this.mTPPlayer.getReportManager().setReportInfoGetter(this.mReportInfo);
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
    int i = paramSuperPlayerVideoInfo.getVideoSource();
    if (i != 1)
    {
      if (i == 3)
      {
        this.mPlayState.changeStateAndNotify(2);
        innerDoOpenMediaPlayer(paramSuperPlayerVideoInfo, this.mPlayerOption);
      }
    }
    else
    {
      this.mPlayState.changeStateAndNotify(1);
      this.mVInfoGetter.doGetVInfo(paramSuperPlayerVideoInfo);
    }
    setReportInfo(paramSuperPlayerVideoInfo.getFormat());
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
    String str = this.mTAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("api call : seekTo, positionMs:");
    ((StringBuilder)localObject).append(paramInt);
    LogUtil.i(str, ((StringBuilder)localObject).toString());
    try
    {
      this.mTPPlayer.seekTo(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localObject = this.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("api call : seekTo, positionMs:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", error = ");
      localStringBuilder.append(localException.toString());
      LogUtil.e((String)localObject, localStringBuilder.toString());
    }
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    String str = this.mTAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("api call : seekTo, positionMs:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", mode:");
    ((StringBuilder)localObject).append(paramInt2);
    LogUtil.i(str, ((StringBuilder)localObject).toString());
    try
    {
      this.mTPPlayer.seekTo(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      localObject = this.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("api call : seekTo, positionMs:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", mode:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", error = ");
      localStringBuilder.append(localException.toString());
      LogUtil.e((String)localObject, localStringBuilder.toString());
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
    this.mTPPlayer.setBusinessDownloadStrategy(CommonUtil.b(this.mSceneId), paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : setLoopback, isLoopback:");
    localStringBuilder.append(paramBoolean);
    LogUtil.i(str, localStringBuilder.toString());
    this.mIsLoopback = paramBoolean;
    this.mTPPlayer.setLoopback(paramBoolean);
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
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : setOutputMute, isOutputMute:");
    localStringBuilder.append(paramBoolean);
    LogUtil.i(str, localStringBuilder.toString());
    this.mIsOutputMute = paramBoolean;
    this.mTPPlayer.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : setPlaySpeedRatio, speedRatio:");
    localStringBuilder.append(paramFloat);
    LogUtil.i(str, localStringBuilder.toString());
    this.mTPPlayer.setPlaySpeedRatio(paramFloat);
  }
  
  public void setPlayerActive()
  {
    SuperPlayerOption localSuperPlayerOption = this.mPlayerOption;
    if ((localSuperPlayerOption != null) && (localSuperPlayerOption.isPrePlay)) {
      this.mTPPlayer.setIsActive(true);
    }
  }
  
  public void setReportContentId(String paramString)
  {
    TPDefaultReportInfo localTPDefaultReportInfo = this.mReportInfo;
    if (localTPDefaultReportInfo != null) {
      localTPDefaultReportInfo.vid = paramString;
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("api call : setSurface, surface = ");
    localStringBuilder.append(paramSurface);
    localStringBuilder.append(", mSurface == surface is ");
    boolean bool;
    if (this.mSurface == paramSurface) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    this.mSurface = paramSurface;
    localObject = this.mTPPlayer;
    if (localObject != null) {
      ((ITPPlayer)localObject).setSurface(paramSurface);
    }
  }
  
  @Deprecated
  public void setXYaxis(int paramInt) {}
  
  public void start()
  {
    LogUtil.i(this.mTAG, "api call : start");
    SuperPlayerOption localSuperPlayerOption = this.mPlayerOption;
    if ((localSuperPlayerOption != null) && (localSuperPlayerOption.isPrePlay)) {
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
  
  public void switchDefinition(String paramString, int paramInt)
  {
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = this.mVideoInfo;
    if ((localSuperPlayerVideoInfo != null) && (localSuperPlayerVideoInfo.getVideoSource() == 1))
    {
      if (this.mIsSwitchingTVideoDefn)
      {
        LogUtil.e(this.mTAG, "api call : switchDefinition error, is switching defn");
        return;
      }
      this.mIsSwitchingTVideoDefn = true;
      this.mTVdieoSwitchDefnMode = paramInt;
      this.mVideoInfo.setRequestDefinition(paramString);
      this.mVInfoGetter.doGetVInfo(this.mVideoInfo);
      return;
    }
    LogUtil.e(this.mTAG, "api call : switchDefinition error, videoInfo invalid");
  }
  
  public void switchDefinitionForUrl(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mTPPlayer.switchDefinition(paramString, this.mSwitchDefnId.getAndIncrement(), null, paramInt);
    }
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
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【Important】 updatePlayerTag from 【");
    localStringBuilder.append(this.mPlayerTag);
    localStringBuilder.append("】 to 【");
    localStringBuilder.append(paramString);
    localStringBuilder.append("】");
    LogUtil.i((String)localObject, localStringBuilder.toString());
    this.mPlayerTag = paramString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append("SuperPlayerWrapper.java");
    this.mTAG = ((StringBuilder)localObject).toString();
    this.mPlayState.updatePlayerTag(this.mPlayerTag);
    this.mListenerMgr.updatePlayerTag(this.mPlayerTag);
  }
  
  @Deprecated
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */