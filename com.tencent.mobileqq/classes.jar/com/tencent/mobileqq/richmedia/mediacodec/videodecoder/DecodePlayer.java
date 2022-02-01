package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.SimpleAudioPlayer;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.mobileqq.sveffects.libsveffects.BuildConfig;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class DecodePlayer
  implements HWDecodeListener
{
  public static final int STATE_CANCELED = 2;
  public static final int STATE_ERROR = -1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_PAUSED = 4;
  public static final int STATE_PLAYBACK_COMPLETED = 5;
  public static final int STATE_PLAYING = 3;
  public static final int STATE_PREPARING = 1;
  public static final int STATE_STOPING = 6;
  private static final String TAG = "DecodePlayer";
  private HWVideoDecoder hwVideoDecoder = null;
  private final DecodePlayer.AudioDecodeConfig mAudioDecodeConfig = new DecodePlayer.AudioDecodeConfig();
  private int mAudioOffsetMs = 0;
  private long mCurrentDecodeTimestampNs = -1L;
  private AtomicInteger mCurrentState = new AtomicInteger(0);
  private HWDecodeListener mHWDecodeListener;
  private SimpleAudioPlayer mSimpleAudioPlayer;
  private final DecodeConfig mVideoDecodeConfig = new DecodeConfig();
  public long videoDuration = 0L;
  
  public int getCurrentState()
  {
    return this.mCurrentState.get();
  }
  
  public HWVideoDecoder getDecoder()
  {
    return this.hwVideoDecoder;
  }
  
  public int getSpeedType()
  {
    return this.mVideoDecodeConfig.speedType;
  }
  
  public String getVideoFilePath()
  {
    return this.mVideoDecodeConfig.inputFilePath;
  }
  
  public void onDecodeCancel()
  {
    this.mCurrentState.set(2);
    SdkContext.getInstance().getLogger().d("DecodePlayer", "onDecodeCancel");
    HWDecodeListener localHWDecodeListener = this.mHWDecodeListener;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeCancel();
    }
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    Logger localLogger = SdkContext.getInstance().getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDecodeError errorCode = ");
    localStringBuilder.append(paramInt);
    localLogger.e("DecodePlayer", localStringBuilder.toString(), paramThrowable);
    stopMusic();
    if (!BuildConfig.DEBUG) {
      return;
    }
    throw new RuntimeException(paramThrowable);
  }
  
  public void onDecodeFinish()
  {
    this.mCurrentState.set(5);
    SdkContext.getInstance().getLogger().d("DecodePlayer", "onDecodeFinish");
    stopMusic();
    HWDecodeListener localHWDecodeListener = this.mHWDecodeListener;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeFinish();
    }
  }
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    HWDecodeListener localHWDecodeListener = this.mHWDecodeListener;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeFrame(paramLong1, paramLong2);
    }
  }
  
  public void onDecodeRepeat()
  {
    SdkContext.getInstance().getLogger().d("DecodePlayer", "onDecodeRepeat");
    HWDecodeListener localHWDecodeListener = this.mHWDecodeListener;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeRepeat();
    }
  }
  
  public void onDecodeSeekTo(long paramLong)
  {
    int i = (int)paramLong;
    this.mAudioOffsetMs = i;
    this.mCurrentDecodeTimestampNs = System.nanoTime();
    if ((FileUtil.fileExistsAndNotEmpty(this.mAudioDecodeConfig.audioFilePath)) && (this.mSimpleAudioPlayer != null) && (!VideoPrefsUtil.getMaterialMute()))
    {
      this.mSimpleAudioPlayer.setAudioStream(3);
      this.mSimpleAudioPlayer.seekPlay(this.mAudioDecodeConfig.audioFilePath, i);
    }
  }
  
  public void onDecodeStart()
  {
    this.mCurrentState.set(3);
    SdkContext.getInstance().getLogger().d("DecodePlayer", "onDecodeStart");
    HWDecodeListener localHWDecodeListener = this.mHWDecodeListener;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeStart();
    }
  }
  
  public void resumeMusic()
  {
    SimpleAudioPlayer localSimpleAudioPlayer = this.mSimpleAudioPlayer;
    if ((localSimpleAudioPlayer != null) && (!localSimpleAudioPlayer.isPlaying()) && (this.mCurrentState.get() == 3) && (FileUtil.fileExistsAndNotEmpty(this.mAudioDecodeConfig.audioFilePath)))
    {
      this.mSimpleAudioPlayer.setAudioStream(3);
      this.mSimpleAudioPlayer.seekPlay(this.mAudioDecodeConfig.audioFilePath, (int)((System.nanoTime() - this.mCurrentDecodeTimestampNs) / 1000000L) + this.mAudioOffsetMs);
    }
  }
  
  public void setDecodeListener(HWDecodeListener paramHWDecodeListener)
  {
    this.mHWDecodeListener = paramHWDecodeListener;
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    this.mVideoDecodeConfig.inputFilePath = paramString1;
    if ((FileUtil.fileExistsAndNotEmpty(paramString2)) && (this.mSimpleAudioPlayer == null)) {
      this.mSimpleAudioPlayer = new SimpleAudioPlayer();
    }
    this.mAudioDecodeConfig.audioFilePath = paramString2;
    if (SdkContext.getInstance().getLogger().isEnable())
    {
      paramString1 = SdkContext.getInstance().getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFilePath: videoFilePath = ");
      localStringBuilder.append(this.mVideoDecodeConfig.inputFilePath);
      localStringBuilder.append(" ; audioFilePath = ");
      localStringBuilder.append(paramString2);
      paramString1.d("DecodePlayer", localStringBuilder.toString());
    }
    this.videoDuration = VideoUtil.getDurationOfVideo(this.mVideoDecodeConfig.inputFilePath);
    this.mAudioDecodeConfig.videoDurationMs = this.videoDuration;
  }
  
  public void setNOSleep(boolean paramBoolean)
  {
    this.mVideoDecodeConfig.noSleep = paramBoolean;
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.mVideoDecodeConfig.repeat = paramBoolean;
    this.mAudioDecodeConfig.repeat = paramBoolean;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.mVideoDecodeConfig.speedType = paramInt;
    this.mAudioDecodeConfig.speedType = paramInt;
    this.hwVideoDecoder.setSpeedType(paramInt);
  }
  
  public void setSyncDecode(boolean paramBoolean)
  {
    this.mVideoDecodeConfig.syncDecode = paramBoolean;
  }
  
  public void setVideoDecodeConfig(DecodeConfig paramDecodeConfig)
  {
    this.mVideoDecodeConfig.copyFrom(paramDecodeConfig);
  }
  
  public void startPlay(int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    if (!TextUtils.isEmpty(this.mVideoDecodeConfig.inputFilePath))
    {
      this.mCurrentState.set(1);
      this.hwVideoDecoder.startDecode(this.mVideoDecodeConfig, paramInt, paramOnFrameAvailableListener, this);
      if ((FileUtil.fileExistsAndNotEmpty(this.mAudioDecodeConfig.audioFilePath)) && (this.mSimpleAudioPlayer != null) && (!VideoPrefsUtil.getMaterialMute()))
      {
        this.mSimpleAudioPlayer.setAudioStream(3);
        this.mSimpleAudioPlayer.play(this.mAudioDecodeConfig.audioFilePath);
      }
      this.mAudioOffsetMs = 0;
      this.mCurrentDecodeTimestampNs = System.nanoTime();
      return;
    }
    throw new RuntimeException("startPlay failed. videoFilePath is empty.");
  }
  
  public void stopMusic()
  {
    SimpleAudioPlayer localSimpleAudioPlayer = this.mSimpleAudioPlayer;
    if ((localSimpleAudioPlayer != null) && (localSimpleAudioPlayer.isPlaying())) {
      this.mSimpleAudioPlayer.stop();
    }
  }
  
  public void stopPlay()
  {
    this.mCurrentState.set(6);
    this.hwVideoDecoder.stopDecode();
    SimpleAudioPlayer localSimpleAudioPlayer = this.mSimpleAudioPlayer;
    if ((localSimpleAudioPlayer != null) && (localSimpleAudioPlayer.isPlaying())) {
      this.mSimpleAudioPlayer.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer
 * JD-Core Version:    0.7.0.1
 */