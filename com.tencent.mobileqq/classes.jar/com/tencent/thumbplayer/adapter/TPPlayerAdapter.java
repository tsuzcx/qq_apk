package com.tencent.thumbplayer.adapter;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnStateChangeListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
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
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPPlayerState;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPPropertyID;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.utils.TPEnumUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TPPlayerAdapter
  implements ITPPlayerAdapter, ITPPlayerBaseListener.IOnStateChangeListener
{
  private static final String TAG = "TPThumbPlayer[TPPlayerAdapter.java]";
  private Context mContext;
  private boolean mIsRetrying;
  private ITPPlayerBase mPlayerBase;
  private TPPlayerAdapter.TPPlayerBaseCallback mPlayerCallback;
  private TPPlaybackParams mPlayerInitParams;
  private TPPlayerBaseListeners mPlayerListeners;
  private TPPlayerState mPlayerState;
  private int mPlayerType;
  private TPPlayerStateStrategy mStateChecker;
  private TPPlaybackInfo mTPPlaybackInfo;
  private ITPStrategy mTpStrategy;
  
  public TPPlayerAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPlayerState = new TPPlayerState();
    this.mPlayerState.setOnPlayerStateChangeListener(this);
    this.mPlayerInitParams = new TPPlaybackParams();
    this.mPlayerCallback = new TPPlayerAdapter.TPPlayerBaseCallback(this, null);
    this.mPlayerListeners = new TPPlayerBaseListeners("TPThumbPlayer[TPPlayerAdapter.java]");
    this.mStateChecker = new TPPlayerStateStrategy(this.mPlayerState);
    this.mTPPlaybackInfo = new TPPlaybackInfo();
  }
  
  private void backupVideoInfo()
  {
    if (isThumbPlayer())
    {
      this.mTPPlaybackInfo = TPPlaybackInfo.parseInfo(getPropertyString(TPPropertyID.STRING_MEDIA_INFO));
      this.mTPPlaybackInfo.setVideoLevel((int)this.mPlayerBase.getPropertyLong(TPPropertyID.LONG_VIDEO_LEVEL));
      this.mTPPlaybackInfo.setVideoProfile((int)this.mPlayerBase.getPropertyLong(TPPropertyID.LONG_VIDEO_PROFILE));
      this.mTPPlaybackInfo.setVideoProfile((int)this.mPlayerBase.getPropertyLong(TPPropertyID.LONG_AUDIO_PROFILE));
      this.mTPPlaybackInfo.setVideoCodedId((int)this.mPlayerBase.getPropertyLong(TPPropertyID.LONG_VIDEO_CODEC_ID));
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
  
  private ITPPlayerBase createPlayerBase(int paramInt)
  {
    if (paramInt == 1) {}
    try
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create androidPlayer");
      ITPPlayerBase localITPPlayerBase1 = TPPlayerBaseFactory.createSystemMediaPlayer(this.mContext, this.mPlayerInitParams.supportClip());
      while (localITPPlayerBase1 == null)
      {
        TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "play is null!");
        return null;
        if (paramInt == 2)
        {
          TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create thumbPlayer");
          localITPPlayerBase1 = TPPlayerBaseFactory.createThumbPlayer(this.mContext);
        }
        else
        {
          TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create no Player");
          localITPPlayerBase1 = null;
        }
      }
    }
    catch (Exception localException)
    {
      ITPPlayerBase localITPPlayerBase2;
      for (;;)
      {
        TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create Player," + localException.toString());
        localITPPlayerBase2 = null;
      }
      this.mPlayerType = paramInt;
      setPlayerParamBeforePrepare(localITPPlayerBase2);
      return localITPPlayerBase2;
    }
  }
  
  private ITPStrategy createPlayerStrategy(TPPlaybackParams paramTPPlaybackParams)
  {
    try
    {
      paramTPPlaybackParams = new TPStrategyConfig(paramTPPlaybackParams);
      return TPStrategyFactory.createStrategy(paramTPPlaybackParams);
    }
    catch (IllegalArgumentException paramTPPlaybackParams)
    {
      for (;;)
      {
        paramTPPlaybackParams = new TPStrategyConfig(null);
      }
    }
  }
  
  private void handleOnAudioFrameOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7)) {
      return;
    }
    this.mPlayerListeners.onAudioPcmOut(paramTPAudioFrameBuffer);
  }
  
  private void handleOnComplete()
  {
    if (!this.mStateChecker.validStateCallback(2))
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnComplete, invalid state");
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
    int i = this.mTpStrategy.strategyForRetry(this.mTPPlaybackInfo, new TPStrategyContext(this.mPlayerType, paramInt1, paramInt2));
    if (i == 0)
    {
      this.mPlayerListeners.onError(paramInt1, paramInt2, paramLong1, paramLong2);
      return;
    }
    try
    {
      switchPlayer(i);
      return;
    }
    catch (IOException localIOException)
    {
      this.mPlayerListeners.onError(paramInt1, paramInt2, paramLong1, paramLong2);
    }
  }
  
  private void handleOnInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (this.mIsRetrying)
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnInfo, mIsRetrying");
      return;
    }
    if ((paramInt == 152) && (this.mTPPlaybackInfo != null)) {
      this.mTPPlaybackInfo.setCurrentPlayClipNo((int)paramLong1 + 1);
    }
    this.mPlayerListeners.onInfo(paramInt, paramLong1, paramLong2, paramObject);
  }
  
  private void handleOnPrepared()
  {
    this.mPlayerListeners.onInfo(1000, this.mPlayerType, 0L, null);
    if (this.mIsRetrying)
    {
      recoverState();
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnPrepared, mIsRetrying,recoverState!");
      return;
    }
    if (!this.mStateChecker.validStateCallback(1))
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnPrepared, invalid state");
      return;
    }
    backupVideoInfo();
    this.mPlayerState.changeState(4);
    this.mPlayerListeners.onPrepared();
    setPlayerParamAfterPrepared(this.mPlayerBase);
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
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnSubtitleData, invalid state");
      return;
    }
    this.mPlayerListeners.onSubtitleData(paramTPSubtitleData);
  }
  
  private void handleOnSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7))
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnSubtitleFrameOut, invalid state");
      return;
    }
    this.mPlayerListeners.onSubtitleFrameOut(paramTPSubtitleFrameBuffer);
  }
  
  private void handleOnVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7))
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnVideoFrameOut, invalid state");
      return;
    }
    this.mPlayerListeners.onVideoFrameOut(paramTPVideoFrameBuffer);
  }
  
  private void handleOnVideoSizeChange(long paramLong1, long paramLong2)
  {
    if (!this.mStateChecker.validStateCallback(6))
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnVideoSizeChange, invalid state");
      return;
    }
    this.mTPPlaybackInfo.setHeight(paramLong2);
    this.mTPPlaybackInfo.setWidth(paramLong1);
    this.mPlayerListeners.onVideoSizeChanged(paramLong1, paramLong2);
  }
  
  private boolean isThumbPlayer()
  {
    return this.mPlayerType == 2;
  }
  
  private void recoverState()
  {
    if (this.mPlayerState.state() != 6) {
      start();
    }
    this.mIsRetrying = false;
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
    TPProgramInfo localTPProgramInfo;
    int i;
    if (arrayOfTPProgramInfo != null)
    {
      localTPProgramInfo = this.mPlayerInitParams.getSelectProgramInfo();
      if (localTPProgramInfo != null) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < arrayOfTPProgramInfo.length)
      {
        if ((!TextUtils.isEmpty(localTPProgramInfo.name)) && (arrayOfTPProgramInfo[i] != null) && (localTPProgramInfo.name.equals(arrayOfTPProgramInfo[i].name))) {
          paramITPPlayerBase.selectProgram(i, -1L);
        }
      }
      else {
        return;
      }
      i += 1;
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
    if (isThumbPlayer())
    {
      paramITPPlayerBase.setOnVideoFrameOutListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnAudioPcmOutputListener(this.mPlayerCallback);
      paramITPPlayerBase.setOnSubtitleFrameOutListener(this.mPlayerCallback);
    }
    if (1 == this.mPlayerInitParams.dataSource().getType()) {
      paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().fileDescriptor());
    }
    for (;;)
    {
      localObject1 = this.mPlayerInitParams.optionalParams().iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramITPPlayerBase.setPlayerOptionalParam((TPOptionalParam)((Iterator)localObject1).next());
      }
      if (3 == this.mPlayerInitParams.dataSource().getType())
      {
        if (this.mPlayerType == 2) {
          paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().getTpUrlDataSource().getSelfPlayerUrl(), this.mPlayerInitParams.dataSource().httpHeaders());
        } else if (this.mPlayerType == 1) {
          paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().getTpUrlDataSource().getSystemPlayerUrl(), this.mPlayerInitParams.dataSource().httpHeaders());
        }
      }
      else if (2 == this.mPlayerInitParams.dataSource().getType()) {
        paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().mediaAsset());
      }
    }
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < this.mPlayerInitParams.getTrackInfos().size())
    {
      localObject1 = (TPTrackInfo)this.mPlayerInitParams.getTrackInfos().get(i);
      if (((TPTrackInfo)localObject1).trackType == 3)
      {
        localObject2 = this.mPlayerInitParams.subtitleSources().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TPPlaybackParams.SubtitleAttribute)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((TPPlaybackParams.SubtitleAttribute)localObject3).name)) && (((TPPlaybackParams.SubtitleAttribute)localObject3).name.equals(((TPTrackInfo)localObject1).name)))
          {
            paramITPPlayerBase.addSubtitleSource(((TPPlaybackParams.SubtitleAttribute)localObject3).url, ((TPPlaybackParams.SubtitleAttribute)localObject3).mimeType, ((TPPlaybackParams.SubtitleAttribute)localObject3).name);
            label425:
            break label455;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (((TPTrackInfo)localObject1).trackType == 2)
        {
          localObject2 = this.mPlayerInitParams.audioTrackSources().iterator();
          label455:
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (TPPlaybackParams.AudioTrackAttribute)((Iterator)localObject2).next();
            if ((TextUtils.isEmpty(((TPPlaybackParams.AudioTrackAttribute)localObject3).name)) || (!((TPPlaybackParams.AudioTrackAttribute)localObject3).name.equals(((TPTrackInfo)localObject1).name))) {
              break label425;
            }
            paramITPPlayerBase.addAudioTrackSource(((TPPlaybackParams.AudioTrackAttribute)localObject3).url, ((TPPlaybackParams.AudioTrackAttribute)localObject3).name, ((TPPlaybackParams.AudioTrackAttribute)localObject3).audioTrackParams);
          }
        }
      }
    }
    Object localObject1 = this.mPlayerInitParams.getSelectTrackAttributes().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TPPlaybackParams.SelectTrackAttribute)((Iterator)localObject1).next();
      if (((TPPlaybackParams.SelectTrackAttribute)localObject2).trackInfo.isSelected)
      {
        localObject3 = paramITPPlayerBase.getTrackInfo();
        if (localObject3 == null)
        {
          TPLogUtil.e("TPThumbPlayer[TPPlayerAdapter.java]", "playerTrackInfoList is null.");
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
    if (this.mPlayerInitParams.surface() != null) {
      paramITPPlayerBase.setSurface(this.mPlayerInitParams.surface());
    }
    paramITPPlayerBase.setPlayerOptionalParam(new TPOptionalParam().buildQueueInt(204, this.mTpStrategy.strategyForDec()));
  }
  
  private void switchPlayer(int paramInt)
  {
    if (this.mPlayerBase != null)
    {
      this.mTPPlaybackInfo.setCurrentPositionMs(this.mPlayerBase.getCurrentPositionMs());
      this.mTPPlaybackInfo.setPlayableDurationMs(this.mPlayerBase.getPlayableDurationMs());
      this.mPlayerBase.release();
    }
    this.mPlayerBase = createPlayerBase(paramInt);
    if (this.mPlayerBase == null) {
      throw new RuntimeException("error , create player failed");
    }
    this.mIsRetrying = true;
    TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "switch player to type:" + this.mPlayerType);
    if (this.mTPPlaybackInfo != null)
    {
      TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(100, this.mTPPlaybackInfo.getCurrentPositionMs());
      this.mPlayerBase.setPlayerOptionalParam(localTPOptionalParam);
    }
    this.mPlayerBase.prepare();
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error : addAudioTrackSource , state invalid");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.addAudioTrackSource(paramString1, paramString2, paramList);
    }
    this.mPlayerInitParams.addAudioTrackSource(paramString1, paramString2, paramList);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error : addSubtitleSource , state invalid");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.addSubtitleSource(paramString1, paramString2, paramString3);
    }
    this.mPlayerInitParams.addSubtitleSource(paramString1, paramString2, paramString3);
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    if (this.mPlayerBase != null)
    {
      this.mPlayerBase.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      return;
    }
    throw new IllegalStateException("error , no player for capture :" + this.mPlayerState);
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error : deselectTrack , state invalid");
    }
    TPTrackInfo[] arrayOfTPTrackInfo = getTrackInfo();
    if (arrayOfTPTrackInfo == null)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayerAdapter.java]", "fatal err, tpTrackInfos is null");
      return;
    }
    if ((paramInt < 0) || (paramInt > arrayOfTPTrackInfo.length - 1)) {
      throw new IllegalArgumentException("error : track not found");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.deselectTrack(paramInt, paramLong);
    }
    this.mPlayerInitParams.setDeselectTrackInfo(paramInt, paramLong, arrayOfTPTrackInfo[paramInt]);
  }
  
  public int getCurrentPlayClipNo()
  {
    if (this.mTPPlaybackInfo != null) {
      return this.mTPPlaybackInfo.getCurrentPlayClipNo();
    }
    return 0;
  }
  
  public long getCurrentPositionMs()
  {
    long l1 = 0L;
    if (!this.mStateChecker.validStateCall(12)) {
      if (this.mTPPlaybackInfo != null) {
        l1 = this.mTPPlaybackInfo.getCurrentPositionMs();
      }
    }
    long l2;
    do
    {
      return l1;
      if (this.mPlayerBase == null)
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "getCurrentPositionMs, mPlayerBase = null, return 0!");
        return 0L;
      }
      l2 = this.mPlayerBase.getCurrentPositionMs();
      l1 = l2;
    } while (this.mTPPlaybackInfo == null);
    this.mTPPlaybackInfo.setCurrentPositionMs(l2);
    return l2;
  }
  
  public long getDurationMs()
  {
    long l1 = 0L;
    if ((this.mTPPlaybackInfo != null) && (this.mTPPlaybackInfo.getDurationMs() > 0L)) {
      l1 = this.mTPPlaybackInfo.getDurationMs();
    }
    long l2;
    do
    {
      do
      {
        return l1;
      } while (!this.mStateChecker.validStateCall(11));
      if (this.mPlayerBase == null)
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "getDurationMs, mPlayerBase = null, return 0!");
        return 0L;
      }
      l2 = this.mPlayerBase.getDurationMs();
      l1 = l2;
    } while (this.mTPPlaybackInfo == null);
    this.mTPPlaybackInfo.setDurationMs(l2);
    return l2;
  }
  
  public int getNativePlayerId()
  {
    if (this.mPlayerBase != null) {
      return this.mPlayerBase.getNativePlayerId();
    }
    return 0;
  }
  
  public long getPlayableDurationMs()
  {
    long l1 = 0L;
    if (!this.mStateChecker.validStateCall(12)) {}
    long l2;
    do
    {
      return l1;
      if (this.mPlayerBase == null)
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "getBufferedDurationMs, mPlayerBase = null, return 0!");
        return 0L;
      }
      l2 = this.mPlayerBase.getPlayableDurationMs();
      l1 = l2;
    } while (this.mTPPlaybackInfo == null);
    this.mTPPlaybackInfo.setPlayableDurationMs(l2);
    return l2;
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
    if ((this.mPlayerBase != null) && (this.mPlayerBase.getProgramInfo() != null)) {
      return this.mPlayerBase.getProgramInfo();
    }
    return new TPProgramInfo[0];
  }
  
  public long getPropertyLong(int paramInt)
  {
    if (this.mPlayerBase != null) {
      return this.mPlayerBase.getPropertyLong(paramInt);
    }
    TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "getPropertyLong, mPlayerBase = null, return !");
    return -1L;
  }
  
  public String getPropertyString(int paramInt)
  {
    if (this.mPlayerBase != null) {
      return this.mPlayerBase.getPropertyString(paramInt);
    }
    TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "getPropertyString, mPlayerBase = null, return !");
    return "";
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    if (this.mPlayerBase != null) {
      return this.mPlayerBase.getTrackInfo();
    }
    return (TPTrackInfo[])this.mPlayerInitParams.getTrackInfos().toArray(new TPTrackInfo[0]);
  }
  
  public int getVideoHeight()
  {
    int i;
    if ((this.mTPPlaybackInfo != null) && (this.mTPPlaybackInfo.getHeight() > 0L)) {
      i = (int)this.mTPPlaybackInfo.getHeight();
    }
    int j;
    do
    {
      return i;
      if (!this.mStateChecker.validStateCall(13))
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoHeight, state error!");
        return 0;
      }
      if (this.mPlayerBase == null)
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoHeight, mPlayerBase = null, return 0!");
        return 0;
      }
      j = this.mPlayerBase.getVideoHeight();
      i = j;
    } while (this.mTPPlaybackInfo == null);
    this.mTPPlaybackInfo.setHeight(j);
    return j;
  }
  
  public int getVideoWidth()
  {
    int i;
    if ((this.mTPPlaybackInfo != null) && (this.mTPPlaybackInfo.getWidth() > 0L)) {
      i = (int)this.mTPPlaybackInfo.getWidth();
    }
    int j;
    do
    {
      return i;
      if (!this.mStateChecker.validStateCall(13))
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoWidth, state error!");
        return 0;
      }
      if (this.mPlayerBase == null)
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoWidth, mPlayerBase = null, return 0!");
        return 0;
      }
      j = this.mPlayerBase.getVideoWidth();
      i = j;
    } while (this.mTPPlaybackInfo == null);
    this.mTPPlaybackInfo.setWidth(j);
    return j;
  }
  
  public boolean isPlaying()
  {
    return (this.mPlayerState != null) && (this.mPlayerState.state() == 5);
  }
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    this.mPlayerListeners.onStateChange(paramInt1, paramInt2);
  }
  
  public void pause()
  {
    if (!this.mStateChecker.validStateCall(6)) {
      throw new IllegalStateException("error , pause , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase == null) {
      throw new IllegalStateException("error , pause , player is null");
    }
    try
    {
      this.mPlayerBase.pause();
      this.mPlayerState.changeState(6);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IllegalStateException("error , pause ,state invalid");
    }
  }
  
  public void prepare()
  {
    if (!this.mStateChecker.validStateCall(1)) {
      throw new IllegalStateException("error , prepare , state invalid , current state :" + this.mPlayerState);
    }
    if (!this.mPlayerInitParams.validDataSource()) {
      throw new IOException("error , prepare , data source invalid");
    }
    this.mPlayerBase = createPlayerBase(selectPlayer());
    if (this.mPlayerBase == null) {
      throw new RuntimeException("error , create player failed");
    }
    this.mPlayerState.changeState(3);
    this.mPlayerBase.prepare();
  }
  
  public void prepareAsync()
  {
    if (!this.mStateChecker.validStateCall(1)) {
      throw new IllegalStateException("error , prepare , state invalid , current state :" + this.mPlayerState);
    }
    if (!this.mPlayerInitParams.validDataSource()) {
      throw new IllegalStateException("error , prepare , state invalid , data source invalid");
    }
    this.mPlayerBase = createPlayerBase(selectPlayer());
    if (this.mPlayerBase == null) {
      throw new RuntimeException("error , create player failed");
    }
    this.mPlayerState.changeState(3);
    this.mPlayerBase.prepareAsync();
  }
  
  public void release()
  {
    TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "release");
    if (!this.mStateChecker.validStateCall(16)) {
      throw new IllegalStateException("error , release , state invalid , current state :" + this.mPlayerState);
    }
    try
    {
      if (this.mPlayerBase != null)
      {
        this.mPlayerBase.release();
        this.mPlayerBase = null;
      }
      return;
    }
    catch (Exception localException)
    {
      throw new IllegalStateException("error , release , exception");
    }
    finally
    {
      this.mPlayerInitParams.reset();
      this.mPlayerListeners.clear();
      this.mTPPlaybackInfo = null;
      this.mTpStrategy = null;
      this.mPlayerState.changeState(10);
    }
  }
  
  public void reset()
  {
    TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "reset");
    if (!this.mStateChecker.validStateCall(8)) {
      throw new IllegalStateException("error , reset , state invalid , current state :" + this.mPlayerState);
    }
    try
    {
      if (this.mPlayerBase != null)
      {
        this.mPlayerBase.reset();
        this.mPlayerBase.release();
        this.mPlayerBase = null;
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IllegalStateException("error , reset ,state invalid");
    }
    finally
    {
      this.mPlayerInitParams.reset();
      this.mTPPlaybackInfo.clear();
      this.mTpStrategy = null;
      this.mPlayerState.changeState(1);
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (!this.mStateChecker.validStateCall(9))
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayerAdapter.java]", "error , seek to , state invalid , current state :" + this.mPlayerState + ", return");
      return;
    }
    if (this.mPlayerBase != null)
    {
      this.mPlayerBase.seekTo(paramInt);
      return;
    }
    TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "seekTo, mPlayerBase = null!");
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    if (!this.mStateChecker.validStateCall(9))
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayerAdapter.java]", "error , seek to , state invalid , current state :" + this.mPlayerState + ", return");
      return;
    }
    if (this.mPlayerBase != null)
    {
      this.mPlayerBase.seekTo(paramInt1, paramInt2);
      return;
    }
    TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "seekTo, mPlayerBase = null!");
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    if (!this.mStateChecker.validStateCall(18)) {
      throw new IllegalStateException("error : selectProgram , state invalid");
    }
    TPProgramInfo[] arrayOfTPProgramInfo2 = getProgramInfo();
    TPProgramInfo[] arrayOfTPProgramInfo1 = arrayOfTPProgramInfo2;
    if (arrayOfTPProgramInfo2 == null) {
      arrayOfTPProgramInfo1 = new TPProgramInfo[0];
    }
    if ((paramInt < 0) || (paramInt > arrayOfTPProgramInfo1.length - 1)) {
      throw new IllegalArgumentException("error : program index not found");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.selectProgram(paramInt, paramLong);
    }
    this.mPlayerInitParams.setSelectProgramInfo(arrayOfTPProgramInfo1[paramInt]);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error : selectTrack , state invalid");
    }
    TPTrackInfo[] arrayOfTPTrackInfo = getTrackInfo();
    if (arrayOfTPTrackInfo == null)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayerAdapter.java]", "fatal err, tpTrackInfos is null");
      return;
    }
    if ((paramInt < 0) || (paramInt > arrayOfTPTrackInfo.length - 1)) {
      throw new IllegalArgumentException("error : track not found");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.selectTrack(paramInt, paramLong);
    }
    this.mPlayerInitParams.addSelectedTrackInfo(paramInt, paramLong, arrayOfTPTrackInfo[paramInt]);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error , setAudioGainRatio , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setAudioGainRatio(paramFloat);
    }
    for (;;)
    {
      this.mPlayerInitParams.setAudioGainRatio(paramFloat);
      return;
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (!this.mStateChecker.validStateCall(2)) {
      throw new IllegalStateException("error : setDataSource , state invalid");
    }
    if (paramParcelFileDescriptor == null) {
      throw new IllegalArgumentException("error : setDataSource , pfd invalid");
    }
    this.mPlayerInitParams.setDataSource(paramParcelFileDescriptor);
    this.mPlayerState.changeState(2);
  }
  
  public void setDataSource(TPUrlDataSource paramTPUrlDataSource)
  {
    setDataSource(paramTPUrlDataSource, null);
  }
  
  public void setDataSource(TPUrlDataSource paramTPUrlDataSource, Map<String, String> paramMap)
  {
    if (!this.mStateChecker.validStateCall(2)) {
      throw new IllegalStateException("error : setDataSource , state invalid");
    }
    if (paramTPUrlDataSource == null) {
      throw new IllegalArgumentException("error : setDataSource , data source invalid");
    }
    this.mPlayerInitParams.setDataSource(paramTPUrlDataSource, paramMap);
    this.mPlayerState.changeState(2);
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    if (!this.mStateChecker.validStateCall(2)) {
      throw new IllegalStateException("error : setDataSource , state invalid");
    }
    if (paramITPMediaAsset == null) {
      throw new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
    }
    this.mPlayerInitParams.setDataSource(paramITPMediaAsset);
    this.mPlayerState.changeState(2);
  }
  
  public void setDataSource(String paramString) {}
  
  public void setDataSource(String paramString, Map<String, String> paramMap) {}
  
  public void setLoopback(boolean paramBoolean)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error , setLoopback , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setLoopback(paramBoolean);
    }
    for (;;)
    {
      this.mPlayerInitParams.setLoopback(paramBoolean);
      return;
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "setLoopback, mPlayerBase = null!");
    }
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error , setLoopback , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setLoopback(paramBoolean, paramLong1, paramLong2);
    }
    for (;;)
    {
      this.mPlayerInitParams.setLoopback(paramBoolean, paramLong1, paramLong2);
      return;
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "setLoopback, mPlayerBase = null!");
    }
  }
  
  public void setOnAudioPcmOutputListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
  {
    this.mPlayerListeners.setOnAudioPcmOutListener(paramIOnAudioPcmOutListener);
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
    this.mPlayerListeners.setOnSubtitleFrameOutLisener(paramIOnSubtitleFrameOutListener);
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    this.mPlayerListeners.setOnVideoFrameOutListener(paramIOnVideoFrameOutListener);
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mPlayerListeners.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error , setOutputMute , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setOutputMute(paramBoolean);
    }
    for (;;)
    {
      this.mPlayerInitParams.setOutputMute(paramBoolean);
      return;
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "setOutputMute, mPlayerBase = null!");
    }
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("error , setPlaySpeedRatio , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setPlaySpeedRatio(paramFloat);
    }
    for (;;)
    {
      this.mPlayerInitParams.setSpeedRatio(paramFloat);
      return;
      TPLogUtil.i("TPThumbPlayer[TPPlayerAdapter.java]", "setPlaySpeedRatio, mPlayerBase = null!");
    }
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      throw new IllegalStateException("setPlayerOptionalParam , state invalid");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setPlayerOptionalParam(paramTPOptionalParam);
    }
    this.mPlayerInitParams.addOptionalParams(paramTPOptionalParam);
  }
  
  public void setSurface(Surface paramSurface)
  {
    if (!this.mStateChecker.validStateCall(4)) {
      throw new IllegalStateException("setSurface , state invalid");
    }
    if (this.mPlayerBase != null) {
      this.mPlayerBase.setSurface(paramSurface);
    }
    this.mPlayerInitParams.setSurface(paramSurface);
  }
  
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (!this.mStateChecker.validStateCall(2)) {
      TPLogUtil.e("TPThumbPlayer[TPPlayerAdapter.java]", "setVideoInfo state invalid");
    }
    if (paramTPVideoInfo != null)
    {
      this.mTPPlaybackInfo.setHeight(paramTPVideoInfo.getHeight());
      this.mTPPlaybackInfo.setWidth(paramTPVideoInfo.getWidth());
      this.mTPPlaybackInfo.setVideoCodedId(TPEnumUtils.convertCodecType2Inner(paramTPVideoInfo.getVideoCodecId()));
    }
  }
  
  public void start()
  {
    if (!this.mStateChecker.validStateCall(5)) {
      throw new IllegalStateException("error , start , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase == null) {
      throw new IllegalStateException("error , start , player is null");
    }
    try
    {
      this.mPlayerBase.start();
      this.mPlayerState.changeState(5);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IllegalStateException("error , start ,state invalid");
    }
  }
  
  public void stop()
  {
    if (!this.mStateChecker.validStateCall(7)) {
      throw new IllegalStateException("error , stop , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase == null) {
      throw new IllegalStateException("error , stop , player is null");
    }
    try
    {
      this.mPlayerBase.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IllegalStateException("error , pause ,state invalid");
    }
    finally
    {
      this.mPlayerState.changeState(8);
    }
  }
  
  public void switchDefinition(TPUrlDataSource paramTPUrlDataSource, int paramInt, long paramLong)
  {
    if (!this.mStateChecker.validStateCall(17)) {
      throw new IllegalStateException("error , switch definition , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null)
    {
      String str = "";
      if (this.mPlayerType == 2) {
        str = paramTPUrlDataSource.getSelfPlayerUrl();
      }
      for (;;)
      {
        this.mPlayerBase.switchDefinition(str, paramInt, paramLong);
        return;
        if (this.mPlayerType == 1) {
          str = paramTPUrlDataSource.getSystemPlayerUrl();
        }
      }
    }
    TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "switchDefinition, mPlayerBase = null!");
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, int paramInt, long paramLong)
  {
    if (!this.mStateChecker.validStateCall(17)) {
      throw new IllegalStateException("error , switch definition , state invalid , current state :" + this.mPlayerState);
    }
    if (this.mPlayerBase != null)
    {
      this.mPlayerBase.switchDefinition(paramITPMediaAsset, paramInt, paramLong);
      return;
    }
    TPLogUtil.w("TPThumbPlayer[TPPlayerAdapter.java]", "switchDefinition, mPlayerBase = null!");
  }
  
  public void switchDefinition(String paramString, int paramInt, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerAdapter
 * JD-Core Version:    0.7.0.1
 */