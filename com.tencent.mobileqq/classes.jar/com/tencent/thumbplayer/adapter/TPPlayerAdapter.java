package com.tencent.thumbplayer.adapter;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnStateChangeListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.adapter.player.TPPlayerBaseFactory;
import com.tencent.thumbplayer.adapter.player.TPUrlDataSource;
import com.tencent.thumbplayer.adapter.strategy.ITPStrategy;
import com.tencent.thumbplayer.adapter.strategy.TPStrategyFactory;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyConfig;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyContext;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPPlayerState;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.log.TPBaseLogger;
import com.tencent.thumbplayer.log.TPLoggerContext;
import com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TPPlayerAdapter
  implements ITPPlayerAdapter, ITPPlayerBaseListener.IOnStateChangeListener
{
  private static final String TAG = "TPPlayerAdapter";
  private Context mContext;
  private boolean mIsRetrying;
  private TPBaseLogger mLogger;
  private ITPPlayerBase mPlayerBase;
  private TPPlayerAdapter.TPPlayerBaseCallback mPlayerCallback;
  private TPPlaybackParams mPlayerInitParams;
  private TPPlayerBaseListeners mPlayerListeners;
  private TPPlayerState mPlayerState;
  private int mPlayerType;
  private ITPInnerRichMediaSynchronizer mRichMediaProcessor;
  private TPPlayerStateStrategy mStateChecker;
  private TPLoggerContext mTPLoggerContext;
  private TPPlaybackInfo mTPPlaybackInfo;
  private ITPStrategy mTpStrategy;
  
  public TPPlayerAdapter(Context paramContext, @NonNull TPLoggerContext paramTPLoggerContext)
  {
    this.mTPLoggerContext = new TPLoggerContext(paramTPLoggerContext, "TPPlayerAdapter");
    this.mLogger = new TPBaseLogger(this.mTPLoggerContext);
    this.mContext = paramContext;
    this.mPlayerState = new TPPlayerState();
    this.mPlayerState.setOnPlayerStateChangeListener(this);
    this.mPlayerInitParams = new TPPlaybackParams();
    this.mPlayerCallback = new TPPlayerAdapter.TPPlayerBaseCallback(this, null);
    this.mPlayerListeners = new TPPlayerBaseListeners(this.mTPLoggerContext.getTag());
    this.mStateChecker = new TPPlayerStateStrategy(this.mPlayerState);
    this.mTPPlaybackInfo = new TPPlaybackInfo();
  }
  
  private void backupVideoInfo()
  {
    if (isThumbPlayer())
    {
      this.mTPPlaybackInfo = TPPlaybackInfo.parseInfo(getPropertyString(0));
      this.mTPPlaybackInfo.setVideoLevel((int)this.mPlayerBase.getPropertyLong(204));
      this.mTPPlaybackInfo.setVideoProfile((int)this.mPlayerBase.getPropertyLong(203));
      this.mTPPlaybackInfo.setAudioProfile((int)this.mPlayerBase.getPropertyLong(102));
      this.mTPPlaybackInfo.setVideoCodedId((int)this.mPlayerBase.getPropertyLong(201));
    }
    if (this.mTPPlaybackInfo == null) {
      this.mTPPlaybackInfo = new TPPlaybackInfo();
    }
    this.mTPPlaybackInfo.setDurationMs(this.mPlayerBase.getDurationMs());
    TPOptionalParam localTPOptionalParam = this.mPlayerInitParams.getOptionalParam(100);
    if (localTPOptionalParam != null) {
      this.mTPPlaybackInfo.setCurrentPositionMs(localTPOptionalParam.getParamLong().value);
    }
  }
  
  private ITPPlayerBase createPlayerBase(int paramInt, TPLoggerContext paramTPLoggerContext)
  {
    if (paramInt == 1) {}
    try
    {
      this.mLogger.info("to create androidPlayer");
      paramTPLoggerContext = TPPlayerBaseFactory.createSystemMediaPlayer(this.mContext, this.mPlayerInitParams.supportClip(), paramTPLoggerContext);
    }
    catch (Exception localException)
    {
      label99:
      StringBuilder localStringBuilder;
      Object localObject;
      label138:
      break label99;
    }
    if (paramInt == 2)
    {
      this.mLogger.info("to create thumbPlayer");
      paramTPLoggerContext = TPPlayerBaseFactory.createThumbPlayer(this.mContext, paramTPLoggerContext);
    }
    else if (paramInt == 3)
    {
      this.mLogger.info("to create thumbPlayer software dec");
      paramTPLoggerContext = TPPlayerBaseFactory.createThumbPlayer(this.mContext, paramTPLoggerContext);
    }
    else
    {
      this.mLogger.info("to create no Player");
      break label138;
      paramTPLoggerContext = this.mLogger;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("to create Player,");
      localStringBuilder.append(localObject.toString());
      paramTPLoggerContext.info(localStringBuilder.toString());
      paramTPLoggerContext = null;
    }
    if (paramTPLoggerContext == null)
    {
      this.mLogger.info("play is null!");
      return null;
    }
    this.mPlayerType = paramInt;
    setPlayerParamBeforePrepare(paramTPLoggerContext);
    return paramTPLoggerContext;
  }
  
  private ITPStrategy createPlayerStrategy(TPPlaybackParams paramTPPlaybackParams)
  {
    try
    {
      paramTPPlaybackParams = new TPStrategyConfig(paramTPPlaybackParams);
    }
    catch (IllegalArgumentException paramTPPlaybackParams)
    {
      label12:
      break label12;
    }
    paramTPPlaybackParams = new TPStrategyConfig(null);
    return TPStrategyFactory.createStrategy(paramTPPlaybackParams);
  }
  
  private void handleOnAudioFrameOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7)) {
      return;
    }
    this.mPlayerListeners.onAudioPcmOut(paramTPAudioFrameBuffer);
  }
  
  private TPPostProcessFrameBuffer handleOnAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7)) {
      return null;
    }
    return this.mPlayerListeners.onAudioProcessFrameOut(paramTPPostProcessFrameBuffer);
  }
  
  private void handleOnComplete()
  {
    if (!this.mStateChecker.validStateCallback(2))
    {
      this.mLogger.info("handleOnComplete, invalid state");
      return;
    }
    this.mPlayerState.changeState(7);
    this.mPlayerListeners.onCompletion();
  }
  
  private void handleOnError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (!this.mStateChecker.validStateCallback(4)) {
      return;
    }
    ITPStrategy localITPStrategy = this.mTpStrategy;
    TPPlaybackInfo localTPPlaybackInfo = this.mTPPlaybackInfo;
    int i = localITPStrategy.strategyForRetry(localTPPlaybackInfo, new TPStrategyContext(this.mPlayerType, paramInt1, paramInt2, localTPPlaybackInfo.getDefinition()));
    if (i == 0)
    {
      this.mPlayerState.changeState(10);
      this.mPlayerListeners.onError(paramInt1, paramInt2, paramLong1, paramLong2);
      return;
    }
    try
    {
      switchPlayer(i);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.mLogger.printException(localIllegalStateException);
      this.mPlayerState.changeState(10);
      this.mPlayerListeners.onError(paramInt1, paramInt2, paramLong1, paramLong2);
      return;
    }
    catch (IOException localIOException)
    {
      this.mLogger.printException(localIOException);
      this.mPlayerState.changeState(10);
      this.mPlayerListeners.onError(paramInt1, paramInt2, paramLong1, paramLong2);
    }
  }
  
  private void handleOnInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (this.mIsRetrying)
    {
      this.mLogger.info("handleOnInfo, mIsRetrying");
      return;
    }
    if (paramInt == 152)
    {
      TPPlaybackInfo localTPPlaybackInfo = this.mTPPlaybackInfo;
      if (localTPPlaybackInfo != null) {
        localTPPlaybackInfo.setCurrentPlayClipNo((int)paramLong1 + 1);
      }
    }
    this.mPlayerListeners.onInfo(paramInt, paramLong1, paramLong2, paramObject);
  }
  
  private void handleOnPrepared()
  {
    this.mPlayerListeners.onInfo(1000, this.mPlayerType, 0L, null);
    if (this.mIsRetrying)
    {
      if (this.mPlayerState.innerPlayState() != 3) {
        this.mLogger.warn("handleOnPrepared, invalid state, mIsRetrying.");
      }
    }
    else if (!this.mStateChecker.validStateCallback(1))
    {
      this.mLogger.info("handleOnPrepared, invalid state");
      return;
    }
    backupVideoInfo();
    setPlayerParamAfterPrepared(this.mPlayerBase);
    if (this.mIsRetrying)
    {
      this.mIsRetrying = false;
      TPBaseLogger localTPBaseLogger = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleOnPrepared, mIsRetrying, recoverState, state:");
      localStringBuilder.append(this.mPlayerState.state());
      localTPBaseLogger.info(localStringBuilder.toString());
      int i = this.mPlayerState.state();
      this.mPlayerState.changeState(4);
      if (this.mPlayerState.lastState() == 3) {
        this.mPlayerListeners.onPrepared();
      }
      this.mPlayerListeners.onInfo(1014, 0L, 0L, null);
      recoverPlayer(i);
      return;
    }
    this.mPlayerState.setInnerPlayStateState(4);
    this.mPlayerState.changeState(4);
    this.mPlayerListeners.onPrepared();
  }
  
  private void handleOnSeekComplete()
  {
    if (!this.mStateChecker.validStateCallback(5)) {
      return;
    }
    this.mPlayerListeners.onSeekComplete();
  }
  
  private void handleOnSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    if (!this.mStateChecker.validStateCallback(7))
    {
      this.mLogger.info("handleOnSubtitleData, invalid state");
      return;
    }
    this.mPlayerListeners.onSubtitleData(paramTPSubtitleData);
  }
  
  private void handleOnSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7))
    {
      this.mLogger.info("handleOnSubtitleFrameOut, invalid state");
      return;
    }
    this.mPlayerListeners.onSubtitleFrameOut(paramTPSubtitleFrameBuffer);
  }
  
  private void handleOnVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7))
    {
      this.mLogger.info("handleOnVideoFrameOut, invalid state");
      return;
    }
    this.mPlayerListeners.onVideoFrameOut(paramTPVideoFrameBuffer);
  }
  
  private TPPostProcessFrameBuffer handleOnVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7)) {
      return null;
    }
    return this.mPlayerListeners.onVideoProcessFrameOut(paramTPPostProcessFrameBuffer);
  }
  
  private void handleOnVideoSizeChange(long paramLong1, long paramLong2)
  {
    if (!this.mStateChecker.validStateCallback(6))
    {
      this.mLogger.info("handleOnVideoSizeChange, invalid state");
      return;
    }
    this.mTPPlaybackInfo.setHeight(paramLong2);
    this.mTPPlaybackInfo.setWidth(paramLong1);
    this.mPlayerListeners.onVideoSizeChanged(paramLong1, paramLong2);
  }
  
  private boolean isThumbPlayer()
  {
    int i = this.mPlayerType;
    return (i == 2) || (i == 3);
  }
  
  private void recoverPlayer(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 5) {
        return;
      }
      try
      {
        this.mPlayerBase.start();
        this.mPlayerState.changeState(5);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        this.mLogger.printException(localIllegalStateException);
      }
    }
  }
  
  private int selectPlayer()
  {
    if (this.mTpStrategy == null) {
      this.mTpStrategy = createPlayerStrategy(this.mPlayerInitParams);
    }
    return this.mTpStrategy.strategyForOpen(this.mTPPlaybackInfo);
  }
  
  private void setPlayerParamAfterPrepared(ITPPlayerBase paramITPPlayerBase)
  {
    TPProgramInfo[] arrayOfTPProgramInfo = getProgramInfo();
    if (arrayOfTPProgramInfo != null)
    {
      TPProgramInfo localTPProgramInfo = this.mPlayerInitParams.getSelectProgramInfo();
      if (localTPProgramInfo != null)
      {
        int i = 0;
        while (i < arrayOfTPProgramInfo.length)
        {
          if ((!TextUtils.isEmpty(localTPProgramInfo.url)) && (arrayOfTPProgramInfo[i] != null) && (localTPProgramInfo.url.equals(arrayOfTPProgramInfo[i].url)))
          {
            paramITPPlayerBase.selectProgram(i, -1L);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  private void setPlayerParamBeforePrepare(ITPPlayerBase paramITPPlayerBase)
  {
    paramITPPlayerBase.setOnInfoListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnPreparedListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnCompletionListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnErrorListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnSeekCompleteListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnVideoSizeChangedListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnSubtitleDataListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnSubtitleFrameOutListener(this.mPlayerCallback);
    if (isThumbPlayer())
    {
      paramITPPlayerBase.setOnVideoFrameOutListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnAudioPcmOutputListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnVideoProcessOutputListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnAudioProcessOutputListener(this.mPlayerCallback);
    }
    if (1 == this.mPlayerInitParams.dataSource().getType())
    {
      paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().fileDescriptor());
    }
    else if (3 == this.mPlayerInitParams.dataSource().getType())
    {
      i = this.mPlayerType;
      if (i == 2) {
        paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().getTpUrlDataSource().getSelfPlayerUrl(), this.mPlayerInitParams.dataSource().httpHeaders());
      } else if (i == 1) {
        paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().getTpUrlDataSource().getSystemPlayerUrl(), this.mPlayerInitParams.dataSource().httpHeaders());
      }
    }
    else if (2 == this.mPlayerInitParams.dataSource().getType())
    {
      paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().mediaAsset());
    }
    Object localObject1 = this.mPlayerInitParams.optionalParams().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramITPPlayerBase.setPlayerOptionalParam((TPOptionalParam)((Iterator)localObject1).next());
    }
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < this.mPlayerInitParams.getTrackInfos().size())
    {
      localObject1 = (TPTrackInfo)this.mPlayerInitParams.getTrackInfos().get(i);
      if (((TPTrackInfo)localObject1).trackType == 3)
      {
        localObject2 = this.mPlayerInitParams.subtitleSources().iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (TPPlaybackParams.SubtitleAttribute)((Iterator)localObject2).next();
        } while ((TextUtils.isEmpty(((TPPlaybackParams.SubtitleAttribute)localObject3).name)) || (!((TPPlaybackParams.SubtitleAttribute)localObject3).name.equals(((TPTrackInfo)localObject1).name)));
        paramITPPlayerBase.addSubtitleSource(((TPPlaybackParams.SubtitleAttribute)localObject3).url, ((TPPlaybackParams.SubtitleAttribute)localObject3).mimeType, ((TPPlaybackParams.SubtitleAttribute)localObject3).name);
      }
      else if (((TPTrackInfo)localObject1).trackType == 2)
      {
        localObject2 = this.mPlayerInitParams.audioTrackSources().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TPPlaybackParams.AudioTrackAttribute)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((TPPlaybackParams.AudioTrackAttribute)localObject3).name)) && (((TPPlaybackParams.AudioTrackAttribute)localObject3).name.equals(((TPTrackInfo)localObject1).name))) {
            paramITPPlayerBase.addAudioTrackSource(((TPPlaybackParams.AudioTrackAttribute)localObject3).url, ((TPPlaybackParams.AudioTrackAttribute)localObject3).name, ((TPPlaybackParams.AudioTrackAttribute)localObject3).audioTrackParams);
          }
        }
      }
      i += 1;
    }
    localObject1 = this.mPlayerInitParams.getSelectTrackAttributes().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TPPlaybackParams.SelectTrackAttribute)((Iterator)localObject1).next();
      if (((TPPlaybackParams.SelectTrackAttribute)localObject2).trackInfo.isSelected)
      {
        localObject3 = paramITPPlayerBase.getTrackInfo();
        if (localObject3 == null)
        {
          this.mLogger.error("playerTrackInfoList is null.");
        }
        else
        {
          i = 0;
          while (i < localObject3.length)
          {
            if (((TPPlaybackParams.SelectTrackAttribute)localObject2).trackInfo.name.equals(localObject3[i].name)) {
              paramITPPlayerBase.selectTrack(i, ((TPPlaybackParams.SelectTrackAttribute)localObject2).opaque);
            }
            i += 1;
          }
        }
      }
    }
    if (this.mPlayerInitParams.loopback() != null) {
      paramITPPlayerBase.setLoopback(this.mPlayerInitParams.loopback().isLoopback, this.mPlayerInitParams.loopback().startPositionMs, this.mPlayerInitParams.loopback().endPositionMs);
    }
    paramITPPlayerBase.setOutputMute(this.mPlayerInitParams.outputMute());
    if (this.mPlayerInitParams.audioGainRatio() != 0.0F) {
      paramITPPlayerBase.setAudioGainRatio(this.mPlayerInitParams.audioGainRatio());
    }
    if (this.mPlayerInitParams.speedRatio() != 0.0F) {
      paramITPPlayerBase.setPlaySpeedRatio(this.mPlayerInitParams.speedRatio());
    }
    if (!"".equals(this.mPlayerInitParams.audioNormalizeVolumeParams())) {
      paramITPPlayerBase.setAudioNormalizeVolumeParams(this.mPlayerInitParams.audioNormalizeVolumeParams());
    }
    if ((this.mPlayerInitParams.surface() instanceof SurfaceHolder)) {
      paramITPPlayerBase.setSurfaceHolder((SurfaceHolder)this.mPlayerInitParams.surface());
    } else if ((this.mPlayerInitParams.surface() instanceof Surface)) {
      paramITPPlayerBase.setSurface((Surface)this.mPlayerInitParams.surface());
    }
    paramITPPlayerBase.setPlayerOptionalParam(new TPOptionalParam().buildQueueInt(204, this.mTpStrategy.strategyForDec()));
  }
  
  private void switchPlayer(int paramInt)
  {
    this.mPlayerListeners.onInfo(1013, paramInt, 0L, null);
    Object localObject = this.mPlayerState;
    ((TPPlayerState)localObject).setLastState(((TPPlayerState)localObject).state());
    localObject = this.mPlayerBase;
    StringBuilder localStringBuilder;
    if (localObject != null)
    {
      long l = ((ITPPlayerBase)localObject).getCurrentPositionMs();
      localObject = this.mLogger;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchPlayer, current position:");
      localStringBuilder.append(l);
      ((TPBaseLogger)localObject).info(localStringBuilder.toString());
      this.mTPPlaybackInfo.setCurrentPositionMs(l);
      this.mTPPlaybackInfo.setPlayableDurationMs(this.mPlayerBase.getPlayableDurationMs());
      this.mPlayerBase.reset();
      this.mPlayerBase.release();
    }
    this.mPlayerBase = createPlayerBase(paramInt, this.mTPLoggerContext);
    if (this.mPlayerBase != null)
    {
      this.mIsRetrying = true;
      localObject = this.mLogger;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("switch player to type:");
      localStringBuilder.append(this.mPlayerType);
      ((TPBaseLogger)localObject).info(localStringBuilder.toString());
      if (this.mTPPlaybackInfo != null)
      {
        localObject = new TPOptionalParam().buildLong(100, this.mTPPlaybackInfo.getCurrentPositionMs());
        this.mPlayerBase.setPlayerOptionalParam((TPOptionalParam)localObject);
      }
      this.mPlayerState.setInnerPlayStateState(3);
      this.mPlayerBase.prepareAsync();
      return;
    }
    throw new RuntimeException("error , create player failed");
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
      if (localITPPlayerBase != null) {
        localITPPlayerBase.addAudioTrackSource(paramString1, paramString2, paramList);
      }
      this.mPlayerInitParams.addAudioTrackSource(paramString1, paramString2, paramList);
      return;
    }
    throw new IllegalStateException("error : addAudioTrackSource , state invalid");
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
      if (localITPPlayerBase != null) {
        localITPPlayerBase.addSubtitleSource(paramString1, paramString2, paramString3);
      }
      this.mPlayerInitParams.addSubtitleSource(paramString1, paramString2, paramString3);
      return;
    }
    throw new IllegalStateException("error : addSubtitleSource , state invalid");
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null)
    {
      localITPPlayerBase.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      return;
    }
    paramTPCaptureParams = new StringBuilder();
    paramTPCaptureParams.append("error , no player for capture :");
    paramTPCaptureParams.append(this.mPlayerState);
    throw new IllegalStateException(paramTPCaptureParams.toString());
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      TPTrackInfo[] arrayOfTPTrackInfo = getTrackInfo();
      if (arrayOfTPTrackInfo == null)
      {
        this.mLogger.error("fatal err, tpTrackInfos is null");
        return;
      }
      if ((paramInt >= 0) && (paramInt <= arrayOfTPTrackInfo.length - 1))
      {
        ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
        if (localITPPlayerBase != null) {
          localITPPlayerBase.deselectTrack(paramInt, paramLong);
        }
        this.mPlayerInitParams.setDeselectTrackInfo(paramInt, paramLong, arrayOfTPTrackInfo[paramInt]);
        return;
      }
      throw new IllegalArgumentException("error : track not found");
    }
    throw new IllegalStateException("error : deselectTrack , state invalid");
  }
  
  public int getCurrentPlayClipNo()
  {
    TPPlaybackInfo localTPPlaybackInfo = this.mTPPlaybackInfo;
    if (localTPPlaybackInfo != null) {
      return localTPPlaybackInfo.getCurrentPlayClipNo();
    }
    return 0;
  }
  
  public long getCurrentPositionMs()
  {
    if (!this.mStateChecker.validStateCall(12))
    {
      localObject = this.mTPPlaybackInfo;
      if (localObject != null) {
        return ((TPPlaybackInfo)localObject).getCurrentPositionMs();
      }
      return 0L;
    }
    Object localObject = this.mPlayerBase;
    if (localObject == null)
    {
      this.mLogger.warn("getCurrentPositionMs, mPlayerBase = null, return 0!");
      return 0L;
    }
    long l = ((ITPPlayerBase)localObject).getCurrentPositionMs();
    localObject = this.mTPPlaybackInfo;
    if (localObject != null) {
      ((TPPlaybackInfo)localObject).setCurrentPositionMs(l);
    }
    return l;
  }
  
  public int getCurrentState()
  {
    return this.mPlayerState.state();
  }
  
  public long getDurationMs()
  {
    Object localObject = this.mTPPlaybackInfo;
    if ((localObject != null) && (((TPPlaybackInfo)localObject).getDurationMs() > 0L)) {
      return this.mTPPlaybackInfo.getDurationMs();
    }
    if (!this.mStateChecker.validStateCall(11)) {
      return 0L;
    }
    localObject = this.mPlayerBase;
    if (localObject == null)
    {
      this.mLogger.warn("getDurationMs, mPlayerBase = null, return 0!");
      return 0L;
    }
    long l = ((ITPPlayerBase)localObject).getDurationMs();
    localObject = this.mTPPlaybackInfo;
    if (localObject != null) {
      ((TPPlaybackInfo)localObject).setDurationMs(l);
    }
    return l;
  }
  
  public int getNativePlayerId()
  {
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      return localITPPlayerBase.getNativePlayerId();
    }
    return 0;
  }
  
  public long getPlayableDurationMs()
  {
    if (!this.mStateChecker.validStateCall(12)) {
      return 0L;
    }
    Object localObject = this.mPlayerBase;
    if (localObject == null)
    {
      this.mLogger.warn("getBufferedDurationMs, mPlayerBase = null, return 0!");
      return 0L;
    }
    long l = ((ITPPlayerBase)localObject).getPlayableDurationMs();
    localObject = this.mTPPlaybackInfo;
    if (localObject != null) {
      ((TPPlaybackInfo)localObject).setPlayableDurationMs(l);
    }
    return l;
  }
  
  public TPPlaybackInfo getPlaybackInfo()
  {
    return this.mTPPlaybackInfo;
  }
  
  public int getPlayerType()
  {
    return this.mPlayerType;
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if ((localITPPlayerBase != null) && (localITPPlayerBase.getProgramInfo() != null)) {
      return this.mPlayerBase.getProgramInfo();
    }
    return new TPProgramInfo[0];
  }
  
  public long getPropertyLong(int paramInt)
  {
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      return localITPPlayerBase.getPropertyLong(paramInt);
    }
    this.mLogger.warn("getPropertyLong, mPlayerBase = null, return !");
    return -1L;
  }
  
  public String getPropertyString(int paramInt)
  {
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      return localITPPlayerBase.getPropertyString(paramInt);
    }
    this.mLogger.warn("getPropertyString, mPlayerBase = null, return !");
    return "";
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      return localITPPlayerBase.getTrackInfo();
    }
    return (TPTrackInfo[])this.mPlayerInitParams.getTrackInfos().toArray(new TPTrackInfo[0]);
  }
  
  public int getVideoHeight()
  {
    Object localObject = this.mTPPlaybackInfo;
    if ((localObject != null) && (((TPPlaybackInfo)localObject).getHeight() > 0L)) {
      return (int)this.mTPPlaybackInfo.getHeight();
    }
    if (!this.mStateChecker.validStateCall(13))
    {
      this.mLogger.warn("getVideoHeight, state error!");
      return 0;
    }
    localObject = this.mPlayerBase;
    if (localObject == null)
    {
      this.mLogger.warn("getVideoHeight, mPlayerBase = null, return 0!");
      return 0;
    }
    int i = ((ITPPlayerBase)localObject).getVideoHeight();
    localObject = this.mTPPlaybackInfo;
    if (localObject != null) {
      ((TPPlaybackInfo)localObject).setHeight(i);
    }
    return i;
  }
  
  public int getVideoWidth()
  {
    Object localObject = this.mTPPlaybackInfo;
    if ((localObject != null) && (((TPPlaybackInfo)localObject).getWidth() > 0L)) {
      return (int)this.mTPPlaybackInfo.getWidth();
    }
    if (!this.mStateChecker.validStateCall(13))
    {
      this.mLogger.warn("getVideoWidth, state error!");
      return 0;
    }
    localObject = this.mPlayerBase;
    if (localObject == null)
    {
      this.mLogger.warn("getVideoWidth, mPlayerBase = null, return 0!");
      return 0;
    }
    int i = ((ITPPlayerBase)localObject).getVideoWidth();
    localObject = this.mTPPlaybackInfo;
    if (localObject != null) {
      ((TPPlaybackInfo)localObject).setWidth(i);
    }
    return i;
  }
  
  public boolean isPlaying()
  {
    TPPlayerState localTPPlayerState = this.mPlayerState;
    return (localTPPlayerState != null) && (localTPPlayerState.state() == 5);
  }
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    this.mPlayerListeners.onStateChange(paramInt1, paramInt2);
  }
  
  public void pause()
  {
    if (!this.mStateChecker.validStateCall(6))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error , pause , state invalid , current state :");
      ((StringBuilder)localObject).append(this.mPlayerState);
      ((StringBuilder)localObject).append(", return");
      TPLogUtil.e("TPPlayerAdapter", ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.mPlayerBase;
    if (localObject != null) {
      if (this.mIsRetrying)
      {
        this.mPlayerState.changeState(6);
        return;
      }
    }
    try
    {
      ((ITPPlayerBase)localObject).pause();
      this.mPlayerState.changeState(6);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label97:
      break label97;
    }
    throw new IllegalStateException("error , pause ,state invalid");
    throw new IllegalStateException("error , pause , player is null");
  }
  
  public void prepare()
  {
    if (this.mStateChecker.validStateCall(1))
    {
      if (this.mPlayerInitParams.validDataSource())
      {
        this.mPlayerBase = createPlayerBase(selectPlayer(), this.mTPLoggerContext);
        if (this.mPlayerBase != null)
        {
          this.mPlayerState.setInnerPlayStateState(3);
          this.mPlayerState.changeState(3);
          this.mPlayerBase.prepare();
          return;
        }
        throw new RuntimeException("error , create player failed");
      }
      throw new IOException("error , prepare , data source invalid");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("error , prepare , state invalid , current state :");
    localStringBuilder.append(this.mPlayerState);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void prepareAsync()
  {
    if (this.mStateChecker.validStateCall(1))
    {
      if (this.mPlayerInitParams.validDataSource())
      {
        this.mPlayerBase = createPlayerBase(selectPlayer(), this.mTPLoggerContext);
        if (this.mPlayerBase != null)
        {
          this.mPlayerState.setInnerPlayStateState(3);
          this.mPlayerState.changeState(3);
          this.mPlayerBase.prepareAsync();
          return;
        }
        throw new RuntimeException("error , create player failed");
      }
      throw new IllegalStateException("error , prepare , state invalid , data source invalid");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("error , prepare , state invalid , current state :");
    localStringBuilder.append(this.mPlayerState);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void release()
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release, current state :");
    localStringBuilder.append(this.mPlayerState);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = this.mPlayerBase;
    if (localObject != null)
    {
      ((ITPPlayerBase)localObject).release();
      this.mPlayerBase = null;
    }
    this.mPlayerInitParams.reset();
    this.mPlayerListeners.clear();
    this.mTPPlaybackInfo = null;
    this.mTpStrategy = null;
    this.mIsRetrying = false;
    this.mPlayerState.changeState(11);
  }
  
  public void reset()
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reset, current state :");
    localStringBuilder.append(this.mPlayerState);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = this.mPlayerBase;
    if (localObject != null)
    {
      ((ITPPlayerBase)localObject).reset();
      this.mPlayerBase.release();
      this.mPlayerBase = null;
    }
    this.mPlayerInitParams.reset();
    this.mTPPlaybackInfo.clear();
    this.mTpStrategy = null;
    this.mIsRetrying = false;
    this.mPlayerState.changeState(1);
    this.mPlayerState.setLastState(1);
  }
  
  public void seekTo(int paramInt)
  {
    if (!this.mStateChecker.validStateCall(9))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error , seek to , state invalid , current state :");
      ((StringBuilder)localObject).append(this.mPlayerState);
      ((StringBuilder)localObject).append(", return");
      TPLogUtil.e("TPPlayerAdapter", ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.mPlayerBase;
    long l;
    if (localObject != null)
    {
      ((ITPPlayerBase)localObject).seekTo(paramInt);
      localObject = this.mRichMediaProcessor;
      if (localObject == null) {
        break label123;
      }
      l = paramInt;
    }
    try
    {
      ((ITPInnerRichMediaSynchronizer)localObject).seek(l);
      return;
    }
    catch (Exception localException)
    {
      label102:
      label123:
      break label102;
    }
    this.mLogger.warn("seekTo, rich media processor seek err.");
    return;
    this.mLogger.warn("seekTo, mPlayerBase = null!");
  }
  
  public void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    if (!this.mStateChecker.validStateCall(9))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error , seek to , state invalid , current state :");
      ((StringBuilder)localObject).append(this.mPlayerState);
      ((StringBuilder)localObject).append(", return");
      TPLogUtil.e("TPPlayerAdapter", ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.mPlayerBase;
    long l;
    if (localObject != null)
    {
      ((ITPPlayerBase)localObject).seekTo(paramInt1, paramInt2);
      localObject = this.mRichMediaProcessor;
      if (localObject == null) {
        break label124;
      }
      l = paramInt1;
    }
    try
    {
      ((ITPInnerRichMediaSynchronizer)localObject).seek(l);
      return;
    }
    catch (Exception localException)
    {
      label103:
      label124:
      break label103;
    }
    this.mLogger.warn("seekTo, rich media processor seek err.");
    return;
    this.mLogger.warn("seekTo, mPlayerBase = null!");
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    if (this.mStateChecker.validStateCall(18))
    {
      Object localObject2 = getProgramInfo();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new TPProgramInfo[0];
      }
      if ((paramInt >= 0) && (paramInt <= localObject1.length - 1))
      {
        localObject2 = this.mPlayerBase;
        if (localObject2 != null) {
          ((ITPPlayerBase)localObject2).selectProgram(paramInt, paramLong);
        }
        this.mPlayerInitParams.setSelectProgramInfo(localObject1[paramInt]);
        return;
      }
      throw new IllegalArgumentException("error : program index not found");
    }
    throw new IllegalStateException("error : selectProgram , state invalid");
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      TPTrackInfo[] arrayOfTPTrackInfo = getTrackInfo();
      if (arrayOfTPTrackInfo == null)
      {
        this.mLogger.error("fatal err, tpTrackInfos is null");
        return;
      }
      if ((paramInt >= 0) && (paramInt <= arrayOfTPTrackInfo.length - 1))
      {
        ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
        if (localITPPlayerBase != null) {
          localITPPlayerBase.selectTrack(paramInt, paramLong);
        }
        this.mPlayerInitParams.addSelectedTrackInfo(paramInt, paramLong, arrayOfTPTrackInfo[paramInt]);
        return;
      }
      throw new IllegalArgumentException("error : track not found");
    }
    throw new IllegalStateException("error : selectTrack , state invalid");
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      localObject = this.mPlayerBase;
      if (localObject != null) {
        ((ITPPlayerBase)localObject).setAudioGainRatio(paramFloat);
      } else {
        this.mLogger.info("setAudioGainRatio, mPlayerBase = null!");
      }
      this.mPlayerInitParams.setAudioGainRatio(paramFloat);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("error , setAudioGainRatio , state invalid , current state :");
    ((StringBuilder)localObject).append(this.mPlayerState);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
      if (localITPPlayerBase != null) {
        localITPPlayerBase.setAudioNormalizeVolumeParams(paramString);
      } else {
        this.mLogger.info("setAudioGainRatio, mPlayerBase = null!");
      }
      this.mPlayerInitParams.setAudioNormalizeVolumeParams(paramString);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("error , setAudioNormalizeVolumeParams , state invalid , current state :");
    paramString.append(this.mPlayerState);
    throw new IllegalStateException(paramString.toString());
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (!this.mStateChecker.validStateCall(2))
    {
      paramParcelFileDescriptor = new StringBuilder();
      paramParcelFileDescriptor.append("error , setDataSource , state invalid , current state :");
      paramParcelFileDescriptor.append(this.mPlayerState);
      paramParcelFileDescriptor.append(", return");
      TPLogUtil.e("TPPlayerAdapter", paramParcelFileDescriptor.toString());
      return;
    }
    if (paramParcelFileDescriptor != null)
    {
      this.mPlayerInitParams.setDataSource(paramParcelFileDescriptor);
      this.mPlayerState.changeState(2);
      return;
    }
    throw new IllegalArgumentException("error : setDataSource , pfd invalid");
  }
  
  public void setDataSource(TPUrlDataSource paramTPUrlDataSource)
  {
    setDataSource(paramTPUrlDataSource, null);
  }
  
  public void setDataSource(TPUrlDataSource paramTPUrlDataSource, Map<String, String> paramMap)
  {
    if (!this.mStateChecker.validStateCall(2))
    {
      paramTPUrlDataSource = new StringBuilder();
      paramTPUrlDataSource.append("error , setDataSource , state invalid , current state :");
      paramTPUrlDataSource.append(this.mPlayerState);
      paramTPUrlDataSource.append(", return");
      TPLogUtil.e("TPPlayerAdapter", paramTPUrlDataSource.toString());
      return;
    }
    if (paramTPUrlDataSource != null)
    {
      this.mPlayerInitParams.setDataSource(paramTPUrlDataSource, paramMap);
      this.mPlayerState.changeState(2);
      return;
    }
    throw new IllegalArgumentException("error : setDataSource , data source invalid");
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    if (!this.mStateChecker.validStateCall(2))
    {
      paramITPMediaAsset = new StringBuilder();
      paramITPMediaAsset.append("error , setDataSource , state invalid , current state :");
      paramITPMediaAsset.append(this.mPlayerState);
      paramITPMediaAsset.append(", return");
      TPLogUtil.e("TPPlayerAdapter", paramITPMediaAsset.toString());
      return;
    }
    if (paramITPMediaAsset != null)
    {
      this.mPlayerInitParams.setDataSource(paramITPMediaAsset);
      this.mPlayerState.changeState(2);
      return;
    }
    throw new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
  }
  
  public void setDataSource(String paramString) {}
  
  public void setDataSource(String paramString, Map<String, String> paramMap) {}
  
  public void setLoopback(boolean paramBoolean)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      localObject = this.mPlayerBase;
      if (localObject != null) {
        ((ITPPlayerBase)localObject).setLoopback(paramBoolean);
      } else {
        this.mLogger.info("setLoopback, mPlayerBase = null!");
      }
      this.mPlayerInitParams.setLoopback(paramBoolean);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("error , setLoopback , state invalid , current state :");
    ((StringBuilder)localObject).append(this.mPlayerState);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      localObject = this.mPlayerBase;
      if (localObject != null) {
        ((ITPPlayerBase)localObject).setLoopback(paramBoolean, paramLong1, paramLong2);
      } else {
        this.mLogger.info("setLoopback, mPlayerBase = null!");
      }
      this.mPlayerInitParams.setLoopback(paramBoolean, paramLong1, paramLong2);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("error , setLoopback , state invalid , current state :");
    ((StringBuilder)localObject).append(this.mPlayerState);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setOnAudioPcmOutputListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
  {
    this.mPlayerListeners.setOnAudioPcmOutListener(paramIOnAudioPcmOutListener);
  }
  
  public void setOnAudioProcessOutputListener(ITPPlayerBaseListener.IOnAudioProcessOutListener paramIOnAudioProcessOutListener)
  {
    this.mPlayerListeners.setOnAudioProcessFrameListener(paramIOnAudioProcessOutListener);
  }
  
  public void setOnCompletionListener(ITPPlayerBaseListener.IOnCompletionListener paramIOnCompletionListener)
  {
    this.mPlayerListeners.setOnCompletionListener(paramIOnCompletionListener);
  }
  
  public void setOnErrorListener(ITPPlayerBaseListener.IOnErrorListener paramIOnErrorListener)
  {
    this.mPlayerListeners.setOnErrorListener(paramIOnErrorListener);
  }
  
  public void setOnInfoListener(ITPPlayerBaseListener.IOnInfoListener paramIOnInfoListener)
  {
    this.mPlayerListeners.setOnInfoListener(paramIOnInfoListener);
  }
  
  public void setOnPlayerStateChangeListener(ITPPlayerBaseListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    this.mPlayerListeners.setOnStateChangeListener(paramIOnStateChangeListener);
  }
  
  public void setOnPreparedListener(ITPPlayerBaseListener.IOnPreparedListener paramIOnPreparedListener)
  {
    this.mPlayerListeners.setOnPreparedListener(paramIOnPreparedListener);
  }
  
  public void setOnSeekCompleteListener(ITPPlayerBaseListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.mPlayerListeners.setOnSeekCompleteListener(paramIOnSeekCompleteListener);
  }
  
  public void setOnSubtitleDataListener(ITPPlayerBaseListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    this.mPlayerListeners.setOnSubtitleDataListener(paramIOnSubtitleDataListener);
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerBaseListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    this.mPlayerListeners.setOnSubtitleFrameOutListener(paramIOnSubtitleFrameOutListener);
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    this.mPlayerListeners.setOnVideoFrameOutListener(paramIOnVideoFrameOutListener);
  }
  
  public void setOnVideoProcessOutputListener(ITPPlayerBaseListener.IOnVideoProcessOutListener paramIOnVideoProcessOutListener)
  {
    this.mPlayerListeners.setOnVideoProcessFrameListener(paramIOnVideoProcessOutListener);
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mPlayerListeners.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      localObject = this.mPlayerBase;
      if (localObject != null) {
        ((ITPPlayerBase)localObject).setOutputMute(paramBoolean);
      } else {
        this.mLogger.info("setOutputMute, mPlayerBase = null!");
      }
      this.mPlayerInitParams.setOutputMute(paramBoolean);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("error , setOutputMute , state invalid , current state :");
    ((StringBuilder)localObject).append(this.mPlayerState);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      localObject = this.mPlayerBase;
      if (localObject != null) {
        ((ITPPlayerBase)localObject).setPlaySpeedRatio(paramFloat);
      } else {
        this.mLogger.info("setPlaySpeedRatio, mPlayerBase = null!");
      }
      this.mPlayerInitParams.setSpeedRatio(paramFloat);
      localObject = this.mRichMediaProcessor;
      if (localObject == null) {}
    }
    try
    {
      ((ITPInnerRichMediaSynchronizer)localObject).setPlaybackRate(paramFloat);
      return;
    }
    catch (Exception localException)
    {
      label65:
      break label65;
    }
    this.mLogger.warn("setPlaySpeedRatio, rich media processor setPlaySpeedRatio err.");
    return;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("error , setPlaySpeedRatio , state invalid , current state :");
    ((StringBuilder)localObject).append(this.mPlayerState);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
      if (localITPPlayerBase != null) {
        localITPPlayerBase.setPlayerOptionalParam(paramTPOptionalParam);
      }
      this.mPlayerInitParams.addOptionalParams(paramTPOptionalParam);
      return;
    }
    throw new IllegalStateException("setPlayerOptionalParam , state invalid");
  }
  
  public void setRichMediaSynchronizer(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer)
  {
    if (paramITPRichMediaSynchronizer == null)
    {
      paramITPRichMediaSynchronizer = this.mRichMediaProcessor;
      if (paramITPRichMediaSynchronizer != null) {
        paramITPRichMediaSynchronizer.setInnerListener(null);
      }
      this.mRichMediaProcessor = null;
      return;
    }
    if ((paramITPRichMediaSynchronizer instanceof ITPInnerRichMediaSynchronizer))
    {
      this.mRichMediaProcessor = ((ITPInnerRichMediaSynchronizer)paramITPRichMediaSynchronizer);
      this.mRichMediaProcessor.setInnerListener(new TPPlayerAdapter.1(this));
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      localITPPlayerBase.setSurface(paramSurface);
    }
    this.mPlayerInitParams.setSurface(paramSurface);
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      localITPPlayerBase.setSurfaceHolder(paramSurfaceHolder);
    }
    this.mPlayerInitParams.setSurfaceHolder(paramSurfaceHolder);
  }
  
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (!this.mStateChecker.validStateCall(2)) {
      this.mLogger.error("setVideoInfo state invalid");
    }
    if (paramTPVideoInfo != null)
    {
      this.mTPPlaybackInfo.setHeight(paramTPVideoInfo.getHeight());
      this.mTPPlaybackInfo.setWidth(paramTPVideoInfo.getWidth());
      this.mTPPlaybackInfo.setDefinition(paramTPVideoInfo.getDefinition());
      this.mTPPlaybackInfo.setVideoCodedId(paramTPVideoInfo.getVideoCodecId());
    }
  }
  
  public void start()
  {
    if (!this.mStateChecker.validStateCall(5))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error , start , state invalid , current state :");
      ((StringBuilder)localObject).append(this.mPlayerState);
      ((StringBuilder)localObject).append(", return");
      TPLogUtil.e("TPPlayerAdapter", ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.mPlayerBase;
    if (localObject != null) {}
    try
    {
      ((ITPPlayerBase)localObject).start();
      this.mPlayerState.changeState(5);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label78:
      break label78;
    }
    throw new IllegalStateException("error , start ,state invalid");
    throw new IllegalStateException("error , start , player is null");
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 101	com/tencent/thumbplayer/adapter/TPPlayerAdapter:mStateChecker	Lcom/tencent/thumbplayer/adapter/TPPlayerStateStrategy;
    //   4: bipush 7
    //   6: invokevirtual 772	com/tencent/thumbplayer/adapter/TPPlayerStateStrategy:validStateCall	(I)Z
    //   9: ifne +46 -> 55
    //   12: new 264	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   19: astore_1
    //   20: aload_1
    //   21: ldc_w 1045
    //   24: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: aload_0
    //   30: getfield 67	com/tencent/thumbplayer/adapter/TPPlayerAdapter:mPlayerState	Lcom/tencent/thumbplayer/api/TPPlayerState;
    //   33: invokevirtual 790	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_1
    //   38: ldc_w 864
    //   41: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 12
    //   47: aload_1
    //   48: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 870	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: aload_0
    //   56: getfield 188	com/tencent/thumbplayer/adapter/TPPlayerAdapter:mPlayerBase	Lcom/tencent/thumbplayer/adapter/player/ITPPlayerBase;
    //   59: ifnull +57 -> 116
    //   62: aload_0
    //   63: getfield 67	com/tencent/thumbplayer/adapter/TPPlayerAdapter:mPlayerState	Lcom/tencent/thumbplayer/api/TPPlayerState;
    //   66: bipush 8
    //   68: invokevirtual 313	com/tencent/thumbplayer/api/TPPlayerState:changeState	(I)V
    //   71: aload_0
    //   72: getfield 188	com/tencent/thumbplayer/adapter/TPPlayerAdapter:mPlayerBase	Lcom/tencent/thumbplayer/adapter/player/ITPPlayerBase;
    //   75: invokeinterface 1047 1 0
    //   80: aload_0
    //   81: getfield 67	com/tencent/thumbplayer/adapter/TPPlayerAdapter:mPlayerState	Lcom/tencent/thumbplayer/api/TPPlayerState;
    //   84: bipush 9
    //   86: invokevirtual 313	com/tencent/thumbplayer/api/TPPlayerState:changeState	(I)V
    //   89: return
    //   90: astore_1
    //   91: goto +14 -> 105
    //   94: new 320	java/lang/IllegalStateException
    //   97: dup
    //   98: ldc_w 1049
    //   101: invokespecial 776	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   104: athrow
    //   105: aload_0
    //   106: getfield 67	com/tencent/thumbplayer/adapter/TPPlayerAdapter:mPlayerState	Lcom/tencent/thumbplayer/api/TPPlayerState;
    //   109: bipush 9
    //   111: invokevirtual 313	com/tencent/thumbplayer/api/TPPlayerState:changeState	(I)V
    //   114: aload_1
    //   115: athrow
    //   116: new 320	java/lang/IllegalStateException
    //   119: dup
    //   120: ldc_w 1051
    //   123: invokespecial 776	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   126: athrow
    //   127: astore_1
    //   128: goto -34 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	TPPlayerAdapter
    //   19	29	1	localStringBuilder	StringBuilder
    //   90	25	1	localObject	Object
    //   127	1	1	localIllegalStateException	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   62	80	90	finally
    //   94	105	90	finally
    //   62	80	127	java/lang/IllegalStateException
  }
  
  public void switchDefinition(TPUrlDataSource paramTPUrlDataSource, int paramInt, long paramLong)
  {
    if (this.mStateChecker.validStateCall(17))
    {
      this.mPlayerInitParams.setDataSource(paramTPUrlDataSource, null);
      if (this.mPlayerBase != null)
      {
        int i = this.mPlayerType;
        if (i == 2) {
          paramTPUrlDataSource = paramTPUrlDataSource.getSelfPlayerUrl();
        } else if (i == 1) {
          paramTPUrlDataSource = paramTPUrlDataSource.getSystemPlayerUrl();
        } else {
          paramTPUrlDataSource = "";
        }
        this.mPlayerBase.switchDefinition(paramTPUrlDataSource, paramInt, paramLong);
        return;
      }
      this.mLogger.warn("switchDefinition, mPlayerBase = null!");
      return;
    }
    paramTPUrlDataSource = new StringBuilder();
    paramTPUrlDataSource.append("error , switch definition , state invalid , current state :");
    paramTPUrlDataSource.append(this.mPlayerState);
    throw new IllegalStateException(paramTPUrlDataSource.toString());
  }
  
  public void switchDefinition(TPUrlDataSource paramTPUrlDataSource, Map<String, String> paramMap, int paramInt, long paramLong)
  {
    if (this.mStateChecker.validStateCall(17))
    {
      this.mPlayerInitParams.setDataSource(paramTPUrlDataSource, paramMap);
      if (this.mPlayerBase != null)
      {
        int i = this.mPlayerType;
        if (i == 2) {
          paramTPUrlDataSource = paramTPUrlDataSource.getSelfPlayerUrl();
        } else if (i == 1) {
          paramTPUrlDataSource = paramTPUrlDataSource.getSystemPlayerUrl();
        } else {
          paramTPUrlDataSource = "";
        }
        this.mPlayerBase.switchDefinition(paramTPUrlDataSource, paramMap, paramInt, paramLong);
        return;
      }
      this.mLogger.warn("switchDefinition, mPlayerBase = null!");
      return;
    }
    paramTPUrlDataSource = new StringBuilder();
    paramTPUrlDataSource.append("error , switch definition , state invalid , current state :");
    paramTPUrlDataSource.append(this.mPlayerState);
    throw new IllegalStateException(paramTPUrlDataSource.toString());
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    if (this.mStateChecker.validStateCall(17))
    {
      this.mPlayerInitParams.setDataSource(paramITPMediaAsset);
      ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
      if (localITPPlayerBase != null)
      {
        localITPPlayerBase.switchDefinition(paramITPMediaAsset, paramInt, paramLong);
        return;
      }
      this.mLogger.warn("switchDefinition, mPlayerBase = null!");
      return;
    }
    paramITPMediaAsset = new StringBuilder();
    paramITPMediaAsset.append("error , switch definition , state invalid , current state :");
    paramITPMediaAsset.append(this.mPlayerState);
    throw new IllegalStateException(paramITPMediaAsset.toString());
  }
  
  public void switchDefinition(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public void switchDefinition(String paramString, Map<String, String> paramMap, int paramInt, long paramLong) {}
  
  public void updateLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    this.mTPLoggerContext.update(paramTPLoggerContext, "TPPlayerAdapter");
    this.mLogger.updateContext(this.mTPLoggerContext);
    this.mPlayerListeners.updateTag(this.mTPLoggerContext.getTag());
    paramTPLoggerContext = this.mPlayerBase;
    if (paramTPLoggerContext != null) {
      paramTPLoggerContext.updateLoggerContext(this.mTPLoggerContext);
    }
  }
  
  public void updateVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      this.mLogger.error("updateVideoInfo state invalid");
    }
    if (paramTPVideoInfo != null)
    {
      this.mTPPlaybackInfo.setHeight(paramTPVideoInfo.getHeight());
      this.mTPPlaybackInfo.setWidth(paramTPVideoInfo.getWidth());
      this.mTPPlaybackInfo.setDefinition(paramTPVideoInfo.getDefinition());
      this.mTPPlaybackInfo.setVideoCodedId(paramTPVideoInfo.getVideoCodecId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerAdapter
 * JD-Core Version:    0.7.0.1
 */