package com.tencent.thumbplayer.api;

import android.os.ParcelFileDescriptor;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginBase;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginManager;
import java.util.Map;

public abstract interface ITPPlayer
{
  public static final String TP_MIMETYPE_TEXT_SUBRIP = "text/x-subrip";
  public static final String TP_MIMETYPE_TEXT_VTT = "text/vtt";
  public static final int TP_PLAYER_LOOPBACK_ENDPOSITION_DEFAULT = -1;
  public static final int TP_PLAYER_LOOPBACK_STARTPOSITION_DEFAULT = 0;
  public static final int TP_PLAYER_SEEK_MODE_ACCURATE_POSITION = 3;
  public static final int TP_PLAYER_SEEK_MODE_FREVIOUS_KFRAME = 1;
  public static final int TP_PLAYER_SEEK_MODE_NEXT_CLIP = 4;
  public static final int TP_PLAYER_SEEK_MODE_NEXT_KFRAME = 2;
  public static final int TP_PLAYER_SWITCH_DEF_AFTER_ALL_RESOURCE_CONSUME = 3;
  public static final int TP_PLAYER_SWITCH_DEF_FAST_WITH_KEEP_NO_BUFFERING = 2;
  public static final int TP_PLAYER_SWITCH_DEF_IMMEDIATELY = 1;
  
  public abstract void addAudioTrackSource(String paramString1, String paramString2);
  
  public abstract void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData);
  
  public abstract ITPPluginManager addPlugin(ITPPluginBase paramITPPluginBase);
  
  public abstract void addSubtitleSource(@NonNull String paramString1, String paramString2, @NonNull String paramString3);
  
  public abstract void addSubtitleSource(@NonNull String paramString1, String paramString2, @NonNull String paramString3, TPDownloadParamData paramTPDownloadParamData);
  
  public abstract void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack);
  
  public abstract void deselectTrack(int paramInt, long paramLong);
  
  public abstract int getBufferPercent();
  
  public abstract long getCurrentPositionMs();
  
  public abstract long getDurationMs();
  
  public abstract long getFileSizeBytes();
  
  public abstract long getPlayableDurationMs();
  
  public abstract ITPPlayerProxy getPlayerProxy();
  
  public abstract TPProgramInfo[] getProgramInfo();
  
  public abstract long getPropertyLong(int paramInt);
  
  public abstract String getPropertyString(int paramInt);
  
  public abstract ITPBusinessReportManager getReportManager();
  
  public abstract TPTrackInfo[] getTrackInfo();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void pause();
  
  public abstract void pauseDownload();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void resumeDownload();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void seekTo(int paramInt1, int paramInt2);
  
  public abstract void selectProgram(int paramInt, long paramLong);
  
  public abstract void selectTrack(int paramInt, long paramLong);
  
  public abstract void setAudioGainRatio(float paramFloat);
  
  public abstract void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor);
  
  public abstract void setDataSource(ITPMediaAsset paramITPMediaAsset);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setDataSource(String paramString, Map<String, String> paramMap);
  
  public abstract void setIsActive(boolean paramBoolean);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener paramIOnAudioFrameOutputListener);
  
  public abstract void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener);
  
  public abstract void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener);
  
  public abstract void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener);
  
  public abstract void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener);
  
  public abstract void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener);
  
  public abstract void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener);
  
  public abstract void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener);
  
  public abstract void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener);
  
  public abstract void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener);
  
  public abstract void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener);
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setPlaySpeedRatio(float paramFloat);
  
  public abstract void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setVideoInfo(TPVideoInfo paramTPVideoInfo);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void switchDefinition(@NonNull ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo);
  
  public abstract void switchDefinition(@NonNull ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt);
  
  public abstract void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo);
  
  public abstract void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.ITPPlayer
 * JD-Core Version:    0.7.0.1
 */