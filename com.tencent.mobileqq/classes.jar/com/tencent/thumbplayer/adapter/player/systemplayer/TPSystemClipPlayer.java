package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.adapter.TPPlaybackInfo;
import com.tencent.thumbplayer.adapter.TPPlaybackParams;
import com.tencent.thumbplayer.adapter.TPPlaybackParams.AudioTrackAttribute;
import com.tencent.thumbplayer.adapter.TPPlaybackParams.LoopbackAttribute;
import com.tencent.thumbplayer.adapter.TPPlaybackParams.SubtitleAttribute;
import com.tencent.thumbplayer.adapter.TPPlayerBaseListeners;
import com.tencent.thumbplayer.adapter.TPPlayerDataSource;
import com.tencent.thumbplayer.adapter.TPPlayerStateStrategy;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
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
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.composition.TPMediaComposition;
import com.tencent.thumbplayer.composition.TPMediaCompositionTrack;
import com.tencent.thumbplayer.composition.TPMediaCompositionTrackClip;
import com.tencent.thumbplayer.log.TPBaseLogger;
import com.tencent.thumbplayer.log.TPLoggerContext;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TPSystemClipPlayer
  implements ITPPlayerBase
{
  private static final String TAG = "TPSystemClipPlayer";
  private boolean isPlayingClip;
  private boolean isSwitchingDef;
  private List<ITPMediaTrackClip> mClipList;
  private Context mContext;
  private int mCurrentClip = 0;
  private TPBaseLogger mLogger;
  private ITPPlayerBase mPlayerBase;
  private TPSystemClipPlayer.TPPlayerBaseCallback mPlayerCallback;
  private TPPlaybackParams mPlayerInitParams;
  private TPPlayerBaseListeners mPlayerListeners;
  private TPPlayerState mPlayerState;
  private TPPlayerStateStrategy mStateChecker;
  private LinkedList<Long> mSwitchingDefTagQueue;
  private TPLoggerContext mTPLoggerContext;
  private TPPlaybackInfo mTPPlaybackInfo;
  
  public TPSystemClipPlayer(Context paramContext, TPLoggerContext paramTPLoggerContext)
  {
    this.mTPLoggerContext = new TPLoggerContext(paramTPLoggerContext, "TPSystemClipPlayer");
    this.mLogger = new TPBaseLogger(this.mTPLoggerContext);
    this.mContext = paramContext;
    this.mPlayerState = new TPPlayerState();
    this.mPlayerInitParams = new TPPlaybackParams();
    this.mPlayerCallback = new TPSystemClipPlayer.TPPlayerBaseCallback(this, null);
    this.mPlayerListeners = new TPPlayerBaseListeners(this.mLogger.getTag());
    this.mStateChecker = new TPPlayerStateStrategy(this.mPlayerState);
    this.mClipList = new ArrayList();
  }
  
  private ITPPlayerBase createPlayerBase()
  {
    TPSystemMediaPlayer localTPSystemMediaPlayer = new TPSystemMediaPlayer(this.mContext, this.mTPLoggerContext);
    if (this.mTPPlaybackInfo == null) {
      this.mTPPlaybackInfo = new TPPlaybackInfo();
    }
    setPlayerParamBeforePrepare(localTPSystemMediaPlayer);
    return localTPSystemMediaPlayer;
  }
  
  private List<ITPMediaTrackClip> getClipListWithAsset(ITPMediaAsset paramITPMediaAsset)
  {
    boolean bool = paramITPMediaAsset instanceof TPMediaComposition;
    if ((!bool) && (!(paramITPMediaAsset instanceof TPMediaCompositionTrack)) && (!(paramITPMediaAsset instanceof TPMediaCompositionTrackClip))) {
      throw new IllegalStateException("system mediaPlayer : media asset is illegal source!");
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (bool)
    {
      paramITPMediaAsset = ((TPMediaComposition)paramITPMediaAsset).getAllAVTracks();
      if ((!TPCommonUtils.isEmpty(paramITPMediaAsset)) && (paramITPMediaAsset.get(0) != null)) {
        paramITPMediaAsset = ((ITPMediaTrack)paramITPMediaAsset.get(0)).getAllTrackClips();
      } else {
        throw new IllegalStateException("empty av tracks when set data source!");
      }
    }
    else if ((paramITPMediaAsset instanceof TPMediaCompositionTrack))
    {
      paramITPMediaAsset = ((TPMediaCompositionTrack)paramITPMediaAsset).getAllTrackClips();
    }
    else
    {
      localArrayList.add((ITPMediaTrackClip)paramITPMediaAsset);
      paramITPMediaAsset = localArrayList;
    }
    long l = 0L;
    while (i < paramITPMediaAsset.size())
    {
      ((ITPMediaTrackClip)paramITPMediaAsset.get(i)).setStartPositionMs(l);
      l += ((ITPMediaTrackClip)paramITPMediaAsset.get(i)).getOriginalDurationMs();
      i += 1;
    }
    return paramITPMediaAsset;
  }
  
  private ITPMediaTrackClip getCurrentClip()
  {
    return (ITPMediaTrackClip)this.mClipList.get(this.mCurrentClip);
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
    if (!this.mStateChecker.validStateCallback(2)) {
      return;
    }
    if (this.mCurrentClip >= this.mClipList.size() - 1)
    {
      this.mPlayerState.changeState(7);
      this.mPlayerListeners.onCompletion();
      return;
    }
    try
    {
      switchPlayer(this.mCurrentClip + 1, 0L);
      return;
    }
    catch (IOException localIOException)
    {
      TPBaseLogger localTPBaseLogger = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleOnComplete:");
      localStringBuilder.append(localIOException.toString());
      localTPBaseLogger.info(localStringBuilder.toString());
    }
  }
  
  private void handleOnError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (!this.mStateChecker.validStateCallback(4)) {
      return;
    }
    this.mPlayerListeners.onError(paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  private void handleOnInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (!this.mStateChecker.validStateCallback(3)) {
      return;
    }
    this.mPlayerListeners.onInfo(paramInt, paramLong1, paramLong2, paramObject);
  }
  
  private void handleOnPrepared()
  {
    Object localObject = this.mPlayerListeners;
    if (localObject != null) {
      ((TPPlayerBaseListeners)localObject).onInfo(152, this.mCurrentClip, 0L, null);
    }
    if (this.isPlayingClip)
    {
      start();
      if ((this.isSwitchingDef) && (this.mPlayerListeners != null) && (!TPCommonUtils.isEmpty(this.mSwitchingDefTagQueue)))
      {
        localObject = (Long)this.mSwitchingDefTagQueue.poll();
        if (localObject != null) {
          this.mPlayerListeners.onInfo(3, ((Long)localObject).longValue(), 0L, null);
        }
        this.isSwitchingDef = false;
      }
      return;
    }
    if (!this.mStateChecker.validStateCallback(1)) {
      return;
    }
    this.mPlayerState.changeState(4);
    localObject = this.mPlayerListeners;
    if (localObject != null) {
      ((TPPlayerBaseListeners)localObject).onPrepared();
    }
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
    if (!this.mStateChecker.validStateCallback(7)) {
      return;
    }
    this.mPlayerListeners.onSubtitleData(paramTPSubtitleData);
  }
  
  private void handleOnVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    if (!this.mStateChecker.validStateCallback(7)) {
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
    if (!this.mStateChecker.validStateCallback(6)) {
      return;
    }
    this.mTPPlaybackInfo.setHeight(paramLong2);
    this.mTPPlaybackInfo.setWidth(paramLong1);
    this.mPlayerListeners.onVideoSizeChanged(paramLong1, paramLong2);
  }
  
  private void selectClipPlayer(int paramInt)
  {
    int i = 0;
    while (i < this.mClipList.size())
    {
      long l1 = ((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs();
      long l2 = paramInt;
      if ((l1 <= l2) && (l2 <= ((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs() + ((ITPMediaTrackClip)this.mClipList.get(i)).getOriginalDurationMs())) {
        try
        {
          switchPlayer(i, l2 - ((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs());
        }
        catch (IOException localIOException)
        {
          TPBaseLogger localTPBaseLogger = this.mLogger;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("selectClipPlayer:");
          localStringBuilder.append(localIOException.toString());
          localTPBaseLogger.info(localStringBuilder.toString());
        }
      }
      i += 1;
    }
  }
  
  private void setPlayerParamAfterPrepared(ITPPlayerBase paramITPPlayerBase)
  {
    TPTrackInfo[] arrayOfTPTrackInfo = getTrackInfo();
    if (arrayOfTPTrackInfo == null) {
      return;
    }
    int i = 0;
    while (i < arrayOfTPTrackInfo.length)
    {
      int j = arrayOfTPTrackInfo[i].getTrackType();
      TPTrackInfo localTPTrackInfo = this.mPlayerInitParams.getTrackInfoByType(j);
      if (arrayOfTPTrackInfo[i].equals(localTPTrackInfo)) {
        paramITPPlayerBase.selectTrack(i, -1L);
      }
      i += 1;
    }
  }
  
  private void setPlayerParamBeforePrepare(ITPPlayerBase paramITPPlayerBase)
  {
    if (1 == this.mPlayerInitParams.dataSource().getType()) {
      paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().fileDescriptor());
    }
    if (this.mPlayerInitParams.dataSource().getType() == 0) {
      paramITPPlayerBase.setDataSource(this.mPlayerInitParams.dataSource().url(), this.mPlayerInitParams.dataSource().httpHeaders());
    }
    Iterator localIterator = this.mPlayerInitParams.optionalParams().iterator();
    while (localIterator.hasNext()) {
      paramITPPlayerBase.setPlayerOptionalParam((TPOptionalParam)localIterator.next());
    }
    localIterator = this.mPlayerInitParams.subtitleSources().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (TPPlaybackParams.SubtitleAttribute)localIterator.next();
      paramITPPlayerBase.addSubtitleSource(((TPPlaybackParams.SubtitleAttribute)localObject).url, ((TPPlaybackParams.SubtitleAttribute)localObject).mimeType, ((TPPlaybackParams.SubtitleAttribute)localObject).name);
    }
    localIterator = this.mPlayerInitParams.audioTrackSources().iterator();
    while (localIterator.hasNext())
    {
      localObject = (TPPlaybackParams.AudioTrackAttribute)localIterator.next();
      paramITPPlayerBase.addAudioTrackSource(((TPPlaybackParams.AudioTrackAttribute)localObject).url, ((TPPlaybackParams.AudioTrackAttribute)localObject).name, ((TPPlaybackParams.AudioTrackAttribute)localObject).audioTrackParams);
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
    if ((this.mPlayerInitParams.surface() instanceof SurfaceHolder)) {
      paramITPPlayerBase.setSurfaceHolder((SurfaceHolder)this.mPlayerInitParams.surface());
    } else if ((this.mPlayerInitParams.surface() instanceof Surface)) {
      paramITPPlayerBase.setSurface((Surface)this.mPlayerInitParams.surface());
    }
    paramITPPlayerBase.setOnInfoListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnPreparedListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnCompletionListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnErrorListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnSeekCompleteListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnVideoSizeChangedListener(this.mPlayerCallback);
    paramITPPlayerBase.setOnSubtitleDataListener(this.mPlayerCallback);
  }
  
  private void switchPlayer(int paramInt, long paramLong)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchPlayer: clipNo:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("   startPostion:");
    localStringBuilder.append(paramLong);
    ((TPBaseLogger)localObject).debug(localStringBuilder.toString());
    localObject = this.mPlayerBase;
    if (localObject != null) {
      ((ITPPlayerBase)localObject).release();
    }
    this.isPlayingClip = true;
    this.mCurrentClip = paramInt;
    this.mPlayerInitParams.setDataSource(((ITPMediaTrackClip)this.mClipList.get(this.mCurrentClip)).getFilePath());
    this.mPlayerBase = createPlayerBase();
    if (this.mPlayerBase != null)
    {
      localObject = new TPOptionalParam().buildLong(100, paramLong);
      this.mPlayerBase.setPlayerOptionalParam((TPOptionalParam)localObject);
      this.mPlayerBase.prepare();
      return;
    }
    throw new RuntimeException("error , create player failed");
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    this.mLogger.error("addAudioTrackSource not supported.");
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    this.mLogger.error("addSubtitleSource not supported.");
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      localITPPlayerBase.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
    }
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    this.mLogger.error("deselectTrack not supported.");
  }
  
  public long getCurrentPositionMs()
  {
    long l = 0L;
    int i = 0;
    while ((i < this.mClipList.size()) && (i < this.mCurrentClip))
    {
      l += ((ITPMediaTrackClip)this.mClipList.get(i)).getOriginalDurationMs();
      i += 1;
    }
    if (!this.mStateChecker.validStateCall(12)) {
      return l;
    }
    return l + this.mPlayerBase.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    Iterator localIterator = this.mClipList.iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((ITPMediaTrackClip)localIterator.next()).getOriginalDurationMs()) {}
    return l;
  }
  
  public int getNativePlayerId()
  {
    return 0;
  }
  
  public long getPlayableDurationMs()
  {
    if (!this.mStateChecker.validStateCall(15))
    {
      TPPlaybackInfo localTPPlaybackInfo = this.mTPPlaybackInfo;
      if (localTPPlaybackInfo != null) {
        return localTPPlaybackInfo.getPlayableDurationMs();
      }
      return 0L;
    }
    return this.mPlayerBase.getPlayableDurationMs();
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    this.mLogger.error("getProgramInfo not supported.");
    return new TPProgramInfo[0];
  }
  
  public long getPropertyLong(int paramInt)
  {
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      return localITPPlayerBase.getPropertyLong(paramInt);
    }
    return -1L;
  }
  
  public String getPropertyString(int paramInt)
  {
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      return localITPPlayerBase.getPropertyString(paramInt);
    }
    return "";
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    this.mLogger.error("getTrackInfo not supported.");
    return new TPTrackInfo[0];
  }
  
  public int getVideoHeight()
  {
    TPPlaybackInfo localTPPlaybackInfo = this.mTPPlaybackInfo;
    if (localTPPlaybackInfo == null) {
      return 0;
    }
    if (localTPPlaybackInfo.getHeight() > 0L) {}
    for (long l = this.mTPPlaybackInfo.getHeight();; l = this.mTPPlaybackInfo.getHeight())
    {
      return (int)l;
      if (!this.mStateChecker.validStateCall(13)) {
        return 0;
      }
      this.mTPPlaybackInfo.setHeight(this.mPlayerBase.getVideoHeight());
    }
  }
  
  public int getVideoWidth()
  {
    TPPlaybackInfo localTPPlaybackInfo = this.mTPPlaybackInfo;
    if (localTPPlaybackInfo == null) {
      return 0;
    }
    if (localTPPlaybackInfo.getWidth() > 0L) {}
    for (long l = this.mTPPlaybackInfo.getWidth();; l = this.mTPPlaybackInfo.getWidth())
    {
      return (int)l;
      if (!this.mStateChecker.validStateCall(13)) {
        return 0;
      }
      this.mTPPlaybackInfo.setWidth(this.mPlayerBase.getVideoWidth());
    }
  }
  
  public void pause()
  {
    if (!this.mStateChecker.validStateCall(6)) {
      return;
    }
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {}
    try
    {
      localITPPlayerBase.pause();
      this.mPlayerState.changeState(6);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label38:
      break label38;
    }
    throw new IllegalStateException("error , pause ,state invalid");
    throw new IllegalStateException("error , pause , player is null");
  }
  
  public void prepare()
  {
    if (!this.mStateChecker.validStateCall(1)) {
      return;
    }
    if (this.mPlayerInitParams.validDataSource())
    {
      this.mPlayerBase = createPlayerBase();
      if (this.mPlayerBase != null)
      {
        this.mPlayerState.changeState(3);
        this.mPlayerBase.prepare();
        return;
      }
      throw new RuntimeException("error , create player failed");
    }
    throw new IOException("error , prepare , data source invalid");
  }
  
  public void prepareAsync()
  {
    if (!this.mStateChecker.validStateCall(1)) {
      return;
    }
    if (this.mPlayerInitParams.validDataSource())
    {
      this.mPlayerBase = createPlayerBase();
      if (this.mPlayerBase != null)
      {
        this.mPlayerState.changeState(3);
        this.mPlayerBase.prepareAsync();
        return;
      }
      throw new RuntimeException("error , create player failed");
    }
    throw new IllegalStateException("error , prepare , state invalid , data source invalid");
  }
  
  public void release()
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release, current state:");
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
    this.mPlayerState.changeState(11);
  }
  
  public void reset()
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reset, current state:");
    localStringBuilder.append(this.mPlayerState);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = this.mPlayerBase;
    if (localObject != null) {
      ((ITPPlayerBase)localObject).reset();
    }
    this.mPlayerInitParams.reset();
    this.mPlayerListeners.clear();
    this.mPlayerState.changeState(1);
  }
  
  public void seekTo(int paramInt)
  {
    if (!this.mStateChecker.validStateCall(9)) {
      return;
    }
    long l = paramInt;
    if ((l >= getCurrentClip().getStartPositionMs()) && (l <= getCurrentClip().getStartPositionMs() + getCurrentClip().getOriginalDurationMs()))
    {
      if (this.mPlayerBase != null)
      {
        TPBaseLogger localTPBaseLogger = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("seek to:");
        localStringBuilder.append(paramInt);
        localTPBaseLogger.debug(localStringBuilder.toString());
        this.mPlayerBase.seekTo((int)(l - getCurrentClip().getStartPositionMs()));
      }
    }
    else {
      selectClipPlayer(paramInt);
    }
  }
  
  public void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    if (!this.mStateChecker.validStateCall(9)) {
      return;
    }
    long l = paramInt1;
    if ((l >= getCurrentClip().getStartPositionMs()) && (l <= getCurrentClip().getStartPositionMs() + getCurrentClip().getOriginalDurationMs()))
    {
      if (this.mPlayerBase != null)
      {
        TPBaseLogger localTPBaseLogger = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("seek to:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("/mode=");
        localStringBuilder.append(paramInt2);
        localTPBaseLogger.debug(localStringBuilder.toString());
        this.mPlayerBase.seekTo((int)(l - getCurrentClip().getStartPositionMs()), paramInt2);
      }
    }
    else {
      selectClipPlayer(paramInt1);
    }
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mLogger.error("selectProgram not supported.");
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mLogger.error("selectTrack not supported.");
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      return;
    }
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      localITPPlayerBase.setAudioGainRatio(paramFloat);
    }
    this.mPlayerInitParams.setAudioGainRatio(paramFloat);
  }
  
  public void setAudioNormalizeVolumeParams(String paramString) {}
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mPlayerInitParams.setDataSource(paramParcelFileDescriptor);
    this.mPlayerState.changeState(2);
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    paramITPMediaAsset = getClipListWithAsset(paramITPMediaAsset);
    try
    {
      this.mClipList = paramITPMediaAsset;
      this.mPlayerInitParams.setDataSource(((ITPMediaTrackClip)this.mClipList.get(this.mCurrentClip)).getFilePath());
      this.mPlayerState.changeState(2);
      return;
    }
    catch (Exception paramITPMediaAsset)
    {
      this.mLogger.printException(paramITPMediaAsset);
      throw new IllegalStateException("exception when system clip player set data source!");
    }
  }
  
  public void setDataSource(String paramString)
  {
    setDataSource(paramString, null);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    this.mPlayerInitParams.setDataSource(paramString, paramMap);
    this.mPlayerState.changeState(2);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      return;
    }
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      localITPPlayerBase.setLoopback(paramBoolean);
    }
    this.mPlayerInitParams.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      return;
    }
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      localITPPlayerBase.setLoopback(paramBoolean, paramLong1, paramLong2);
    }
    this.mPlayerInitParams.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnAudioPcmOutputListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
  {
    throw new IllegalStateException("system Mediaplayer cannot support audio frame out");
  }
  
  public void setOnAudioProcessOutputListener(ITPPlayerBaseListener.IOnAudioProcessOutListener paramIOnAudioProcessOutListener)
  {
    throw new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
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
  
  public void setOnSubtitleFrameOutListener(ITPPlayerBaseListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener) {}
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    throw new IllegalStateException("system Mediaplayer cannot support video frame out");
  }
  
  public void setOnVideoProcessOutputListener(ITPPlayerBaseListener.IOnVideoProcessOutListener paramIOnVideoProcessOutListener)
  {
    throw new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mPlayerListeners.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      return;
    }
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      localITPPlayerBase.setOutputMute(paramBoolean);
    }
    this.mPlayerInitParams.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    if (!this.mStateChecker.validStateCall(3)) {
      return;
    }
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {
      localITPPlayerBase.setPlaySpeedRatio(paramFloat);
    }
    this.mPlayerInitParams.setSpeedRatio(paramFloat);
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    if (this.mStateChecker.validStateCall(3))
    {
      if (paramTPOptionalParam.getKey() == 100)
      {
        int j = (int)paramTPOptionalParam.getParamLong().value;
        localObject = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start position:");
        localStringBuilder.append(j);
        ((TPBaseLogger)localObject).debug(localStringBuilder.toString());
        int i = 0;
        while (i < this.mClipList.size())
        {
          long l1 = ((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs();
          long l2 = j;
          if ((l1 <= l2) && (l2 <= ((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs() + ((ITPMediaTrackClip)this.mClipList.get(i)).getOriginalDurationMs()))
          {
            this.mCurrentClip = i;
            this.mPlayerInitParams.setDataSource(((ITPMediaTrackClip)this.mClipList.get(i)).getFilePath());
            paramTPOptionalParam.getParamLong().value = (l2 - ((ITPMediaTrackClip)this.mClipList.get(i)).getStartPositionMs());
          }
          i += 1;
        }
      }
      Object localObject = this.mPlayerBase;
      if (localObject != null) {
        ((ITPPlayerBase)localObject).setPlayerOptionalParam(paramTPOptionalParam);
      }
      this.mPlayerInitParams.addOptionalParams(paramTPOptionalParam);
      return;
    }
    paramTPOptionalParam = new IllegalStateException("setPlayerOptionalParam , state invalid");
    for (;;)
    {
      throw paramTPOptionalParam;
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    if (this.mStateChecker.validStateCall(4))
    {
      ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
      if (localITPPlayerBase != null) {
        localITPPlayerBase.setSurface(paramSurface);
      }
      this.mPlayerInitParams.setSurface(paramSurface);
      return;
    }
    throw new IllegalStateException("setSurface , state invalid");
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    if (this.mStateChecker.validStateCall(4))
    {
      ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
      if (localITPPlayerBase != null) {
        localITPPlayerBase.setSurfaceHolder(paramSurfaceHolder);
      }
      this.mPlayerInitParams.setSurfaceHolder(paramSurfaceHolder);
      return;
    }
    throw new IllegalStateException("setSurfaceHolder , state invalid");
  }
  
  public void start()
  {
    if (!this.mStateChecker.validStateCall(5)) {
      return;
    }
    ITPPlayerBase localITPPlayerBase = this.mPlayerBase;
    if (localITPPlayerBase != null) {}
    try
    {
      localITPPlayerBase.start();
      this.mPlayerState.changeState(5);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label36:
      break label36;
    }
    throw new IllegalStateException("error , start ,state invalid");
    throw new IllegalStateException("error , start , player is null");
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 99	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemClipPlayer:mStateChecker	Lcom/tencent/thumbplayer/adapter/TPPlayerStateStrategy;
    //   4: bipush 7
    //   6: invokevirtual 578	com/tencent/thumbplayer/adapter/TPPlayerStateStrategy:validStateCall	(I)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: getfield 308	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemClipPlayer:mPlayerBase	Lcom/tencent/thumbplayer/adapter/player/ITPPlayerBase;
    //   17: ifnull +57 -> 74
    //   20: aload_0
    //   21: getfield 69	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemClipPlayer:mPlayerState	Lcom/tencent/thumbplayer/api/TPPlayerState;
    //   24: bipush 8
    //   26: invokevirtual 254	com/tencent/thumbplayer/api/TPPlayerState:changeState	(I)V
    //   29: aload_0
    //   30: getfield 308	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemClipPlayer:mPlayerBase	Lcom/tencent/thumbplayer/adapter/player/ITPPlayerBase;
    //   33: invokeinterface 752 1 0
    //   38: aload_0
    //   39: getfield 69	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemClipPlayer:mPlayerState	Lcom/tencent/thumbplayer/api/TPPlayerState;
    //   42: bipush 9
    //   44: invokevirtual 254	com/tencent/thumbplayer/api/TPPlayerState:changeState	(I)V
    //   47: return
    //   48: astore_1
    //   49: goto +14 -> 63
    //   52: new 189	java/lang/IllegalStateException
    //   55: dup
    //   56: ldc_w 621
    //   59: invokespecial 192	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: aload_0
    //   64: getfield 69	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemClipPlayer:mPlayerState	Lcom/tencent/thumbplayer/api/TPPlayerState;
    //   67: bipush 9
    //   69: invokevirtual 254	com/tencent/thumbplayer/api/TPPlayerState:changeState	(I)V
    //   72: aload_1
    //   73: athrow
    //   74: new 189	java/lang/IllegalStateException
    //   77: dup
    //   78: ldc_w 754
    //   81: invokespecial 192	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   84: athrow
    //   85: astore_1
    //   86: goto -34 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	TPSystemClipPlayer
    //   48	25	1	localObject	Object
    //   85	1	1	localIllegalStateException	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   20	38	48	finally
    //   52	63	48	finally
    //   20	38	85	java/lang/IllegalStateException
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    paramITPMediaAsset = getClipListWithAsset(paramITPMediaAsset);
    if (!TPCommonUtils.isEmpty(paramITPMediaAsset))
    {
      long l = getCurrentPositionMs();
      try
      {
        this.mClipList = paramITPMediaAsset;
        this.isSwitchingDef = true;
        if (TPCommonUtils.isEmpty(this.mSwitchingDefTagQueue)) {
          this.mSwitchingDefTagQueue = new LinkedList();
        }
        this.mSwitchingDefTagQueue.offer(Long.valueOf(paramLong));
        paramITPMediaAsset = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("try to switch definition with system clip player, current clipNo:");
        localStringBuilder.append(this.mCurrentClip);
        paramITPMediaAsset.info(localStringBuilder.toString());
        selectClipPlayer((int)l);
        return;
      }
      catch (Exception paramITPMediaAsset)
      {
        this.mLogger.printException(paramITPMediaAsset);
        throw new IllegalStateException("exception when system clip player switch definition!");
      }
    }
    throw new IllegalStateException("exception when switch Definition with clip mediaAsset empty source!");
  }
  
  public void switchDefinition(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public void switchDefinition(String paramString, Map<String, String> paramMap, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public void updateLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    this.mLogger.updateContext(new TPLoggerContext(paramTPLoggerContext, "TPSystemClipPlayer"));
    TPPlayerBaseListeners localTPPlayerBaseListeners = this.mPlayerListeners;
    if ((localTPPlayerBaseListeners != null) && (paramTPLoggerContext != null)) {
      localTPPlayerBaseListeners.updateTag(this.mLogger.getTPLoggerContext().getTag());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemClipPlayer
 * JD-Core Version:    0.7.0.1
 */