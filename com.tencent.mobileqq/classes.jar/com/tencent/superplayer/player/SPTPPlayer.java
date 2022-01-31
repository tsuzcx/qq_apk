package com.tencent.superplayer.player;

import android.content.Context;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import com.tencent.superplayer.utils.SPlayerUtils;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.tplayer.TPPlayer;
import java.util.Map;

class SPTPPlayer
  implements ISPTPPlayer
{
  private String TAG = "FCCTPPlayer.java";
  private Context mContext;
  private SPTPPlayerListeners mListeners;
  private int mSceneId = -1;
  private TPPlayerListeners mTPListeners;
  private ITPPlayer mTPPlayer;
  
  public SPTPPlayer(Context paramContext, Looper paramLooper, int paramInt)
  {
    this.mContext = paramContext;
    this.mTPPlayer = new TPPlayer(paramContext, paramLooper);
    this.mSceneId = paramInt;
    init();
  }
  
  private void init()
  {
    SPlayerUtils.initDataTransportDataFolder(SPlayerUtils.getDownloadProxyServiceType(this.mSceneId));
    this.mListeners = new SPTPPlayerListeners(this.TAG);
    this.mTPListeners = new TPPlayerListeners(this, this.mListeners);
    this.mTPPlayer.setOnPreparedListener(this.mTPListeners);
    this.mTPPlayer.setOnCompletionListener(this.mTPListeners);
    this.mTPPlayer.setOnInfoListener(this.mTPListeners);
    this.mTPPlayer.setOnErrorListener(this.mTPListeners);
    this.mTPPlayer.setOnSeekCompleteListener(this.mTPListeners);
    this.mTPPlayer.setOnVideoSizeChangedListener(this.mTPListeners);
    this.mTPPlayer.setOnVideoFrameOutListener(this.mTPListeners);
    TPDefaultReportInfo localTPDefaultReportInfo = new TPDefaultReportInfo();
    localTPDefaultReportInfo.scenesId = this.mSceneId;
    this.mTPPlayer.getReportManager().setReportInfoGetter(localTPDefaultReportInfo);
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, ISPTPPlayer.IOnCaptureCallback paramIOnCaptureCallback)
  {
    this.mListeners.setOnCaptureListener(paramIOnCaptureCallback);
    this.mTPPlayer.captureVideo(paramTPCaptureParams, this.mTPListeners);
  }
  
  public int getBufferPercent()
  {
    return this.mTPPlayer.getBufferPercent();
  }
  
  public long getCurrentPositionMs()
  {
    return this.mTPPlayer.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    return this.mTPPlayer.getDurationMs();
  }
  
  public ITPPlayerProxy getPlayerProxy()
  {
    ITPPlayerProxy localITPPlayerProxy = this.mTPPlayer.getPlayerProxy();
    localITPPlayerProxy.setProxyServiceType(SPlayerUtils.getDownloadProxyServiceType(this.mSceneId));
    return localITPPlayerProxy;
  }
  
  public long getPropertyLong(int paramInt)
  {
    return this.mTPPlayer.getPropertyLong(paramInt);
  }
  
  public String getPropertyString(int paramInt)
  {
    return this.mTPPlayer.getPropertyString(paramInt);
  }
  
  public ITPBusinessReportManager getReportManager()
  {
    return this.mTPPlayer.getReportManager();
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    return this.mTPPlayer.getTrackInfo();
  }
  
  public int getVideoHeight()
  {
    return this.mTPPlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    return this.mTPPlayer.getVideoWidth();
  }
  
  public void pause()
  {
    this.mTPPlayer.pause();
  }
  
  public void prepareAsync()
  {
    this.mTPPlayer.prepareAsync();
  }
  
  public void release()
  {
    this.mTPPlayer.release();
  }
  
  public void reset()
  {
    this.mTPPlayer.reset();
  }
  
  public void seekTo(int paramInt)
  {
    this.mTPPlayer.seekTo(paramInt);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    this.mTPPlayer.seekTo(paramInt1, paramInt2);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    this.mTPPlayer.setAudioGainRatio(paramFloat);
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mTPPlayer.setDataSource(paramParcelFileDescriptor);
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    this.mTPPlayer.setDataSource(paramITPMediaAsset);
  }
  
  public void setDataSource(String paramString)
  {
    this.mTPPlayer.setDataSource(paramString);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    this.mTPPlayer.setDataSource(paramString, paramMap);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    this.mTPPlayer.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.mTPPlayer.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnCompletionListener(ISPTPPlayer.IOnCompletionListener paramIOnCompletionListener)
  {
    this.mListeners.setOnCompletionListener(paramIOnCompletionListener);
  }
  
  public void setOnErrorListener(ISPTPPlayer.IOnErrorListener paramIOnErrorListener)
  {
    this.mListeners.setOnErrorListener(paramIOnErrorListener);
  }
  
  public void setOnInfoListener(ISPTPPlayer.IOnInfoListener paramIOnInfoListener)
  {
    this.mListeners.setOnInfoListener(paramIOnInfoListener);
  }
  
  public void setOnPreparedListener(ISPTPPlayer.IOnPreparedListener paramIOnPreparedListener)
  {
    this.mListeners.setOnPreparedListener(paramIOnPreparedListener);
  }
  
  public void setOnSeekCompleteListener(ISPTPPlayer.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.mListeners.setOnSeekCompleteListener(paramIOnSeekCompleteListener);
  }
  
  public void setOnVideoFrameOutListener(ISPTPPlayer.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    this.mListeners.setOnVideoFrameOutListener(paramIOnVideoFrameOutListener);
  }
  
  public void setOnVideoSizeChangedListener(ISPTPPlayer.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mListeners.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    this.mTPPlayer.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    this.mTPPlayer.setPlaySpeedRatio(paramFloat);
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    this.mTPPlayer.setPlayerOptionalParam(paramTPOptionalParam);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.mTPPlayer.setSurface(paramSurface);
  }
  
  public void setTPVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    this.mTPPlayer.setVideoInfo(paramTPVideoInfo);
  }
  
  public void start()
  {
    this.mTPPlayer.start();
  }
  
  public void stop()
  {
    this.mTPPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SPTPPlayer
 * JD-Core Version:    0.7.0.1
 */