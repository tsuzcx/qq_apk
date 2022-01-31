package com.tencent.thumbplayer.tplayer;

import android.view.Surface;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import java.util.Map;

public abstract interface TPPlayerInternal$ITPPlayerSwitchThreadListener
{
  public abstract void handleAddAudioSource(String paramString1, String paramString2);
  
  public abstract void handleAddSubTitle(String paramString1, String paramString2, String paramString3);
  
  public abstract void handleDeselectTrack(int paramInt, long paramLong);
  
  public abstract long handleGetAdvRemainTime();
  
  public abstract int handleGetBufferPercent();
  
  public abstract int handleGetCurrentPlayClipNo();
  
  public abstract long handleGetCurrentPositionMs();
  
  public abstract long handleGetDurationMs();
  
  public abstract Object handleGetPlayInfo(long paramLong);
  
  public abstract Object handleGetPlayInfo(String paramString);
  
  public abstract long handleGetPlayerBufferLength();
  
  public abstract TPProgramInfo[] handleGetProgramInfo();
  
  public abstract long handleGetPropertyLong(int paramInt);
  
  public abstract String handleGetPropertyString(int paramInt);
  
  public abstract TPTrackInfo[] handleGetTrackInfo();
  
  public abstract int handleGetVideoHeight();
  
  public abstract int handleGetVideoWidth();
  
  public abstract void handleOnDownloadCdnUrlExpired(Map<String, String> paramMap);
  
  public abstract void handleOnDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void handleOnDownloadCdnUrlUpdate(String paramString);
  
  public abstract void handleOnDownloadError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void handleOnDownloadFinish();
  
  public abstract void handleOnDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public abstract void handleOnDownloadProtocolUpdate(String paramString1, String paramString2);
  
  public abstract void handleOnDownloadStatusUpdate(int paramInt);
  
  public abstract Object handleOnPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  public abstract void handlePause();
  
  public abstract void handlePrepareAsync();
  
  public abstract void handleRelease();
  
  public abstract void handleReset();
  
  public abstract void handleSeekTo(int paramInt1, int paramInt2);
  
  public abstract void handleSelectProgram(int paramInt, long paramLong);
  
  public abstract void handleSelectTrack(int paramInt, long paramLong);
  
  public abstract void handleSetAudioGainRatio(float paramFloat);
  
  public abstract void handleSetDataSource(TPThreadSwitchCommons.TPDataSourceParams paramTPDataSourceParams);
  
  public abstract void handleSetLoopback(boolean paramBoolean);
  
  public abstract void handleSetLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void handleSetOutputMute(boolean paramBoolean);
  
  public abstract void handleSetPlaySpeedRatio(float paramFloat);
  
  public abstract void handleSetPlayerOptionParams(TPOptionalParam paramTPOptionalParam);
  
  public abstract void handleSetSurface(Surface paramSurface);
  
  public abstract void handleStart();
  
  public abstract void handleStop();
  
  public abstract void handleSwitchDef(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo);
  
  public abstract void handleSwitchDef(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo);
  
  public abstract void handlerCaptureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack);
  
  public abstract void handlerSetVideoInfo(TPVideoInfo paramTPVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayerInternal.ITPPlayerSwitchThreadListener
 * JD-Core Version:    0.7.0.1
 */