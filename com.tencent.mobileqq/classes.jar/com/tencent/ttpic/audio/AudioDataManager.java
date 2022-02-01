package com.tencent.ttpic.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.logic.watermark.DecibelDetector;
import com.tencent.ttpic.logic.watermark.FFTData;
import java.util.Arrays;

public enum AudioDataManager
{
  INSTANCE;
  
  private static final String TAG = AudioDataManager.class.getSimpleName();
  private int mDecibel;
  private FFTData mFFTDataResult = new FFTData();
  private boolean mHasMusic;
  private boolean mUseDecibelFromCameraRecorder = false;
  private boolean needDecible;
  
  private AudioDataManager() {}
  
  public static AudioDataManager getInstance()
  {
    return INSTANCE;
  }
  
  private void reset()
  {
    this.needDecible = false;
    this.mDecibel = 0;
    this.mUseDecibelFromCameraRecorder = false;
    resetFFTData();
  }
  
  private void resetFFTData()
  {
    Arrays.fill(this.mFFTDataResult.mFFTBuffer, 0);
    this.mFFTDataResult.mFFTSum = 0;
  }
  
  public void destroy()
  {
    DecibelDetector.getInstance().destroy();
  }
  
  public int getDecibel()
  {
    if (this.mHasMusic) {
      return this.mDecibel;
    }
    if (!this.mUseDecibelFromCameraRecorder)
    {
      DecibelDetector.getInstance().init();
      int i = DecibelDetector.getInstance().getDecibel();
      if (i != 0) {
        setMicDecibel(i);
      }
    }
    return this.mDecibel;
  }
  
  public FFTData getFFTResult()
  {
    if (this.mHasMusic) {
      return this.mFFTDataResult;
    }
    if (!this.mUseDecibelFromCameraRecorder)
    {
      DecibelDetector.getInstance().init();
      FFTData localFFTData = DecibelDetector.getInstance().getFFTResult();
      if (localFFTData != null) {
        setFFTData(localFFTData);
      }
    }
    return this.mFFTDataResult;
  }
  
  public boolean isUsePcmDecibel()
  {
    return this.mHasMusic;
  }
  
  public boolean needMicDecibel()
  {
    return (this.needDecible) && (!this.mHasMusic);
  }
  
  public void resetPermission()
  {
    DecibelDetector.getInstance().resetPermission();
  }
  
  public void setDecibel(int paramInt)
  {
    this.mDecibel = paramInt;
  }
  
  public void setDecibelFromCameraRecorder(boolean paramBoolean)
  {
    this.mUseDecibelFromCameraRecorder = paramBoolean;
  }
  
  public void setFFTData(FFTData paramFFTData)
  {
    if (paramFFTData == null) {
      return;
    }
    this.mFFTDataResult.mFFTBuffer = Arrays.copyOf(paramFFTData.mFFTBuffer, paramFFTData.mFFTSize);
    this.mFFTDataResult.mFFTSum = paramFFTData.mFFTSum;
    this.mFFTDataResult.mFFTSize = paramFFTData.mFFTSize;
    this.mFFTDataResult.mFFTFreqMax = paramFFTData.mFFTFreqMax;
  }
  
  public void setMicDecibel(int paramInt)
  {
    MicAudioAdjustManager.getInstance().setMicDecibel(paramInt);
    setDecibel(paramInt);
  }
  
  public void setMusic(boolean paramBoolean)
  {
    this.mHasMusic = paramBoolean;
  }
  
  public void setNeedDecible(boolean paramBoolean)
  {
    reset();
    this.needDecible = paramBoolean;
  }
  
  public void setPcmDecibel(int paramInt)
  {
    LogUtils.d(TAG, "[decibel] pcm = " + paramInt);
    setDecibel(paramInt);
  }
  
  public void setPcmFFTDataReset()
  {
    resetFFTData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.audio.AudioDataManager
 * JD-Core Version:    0.7.0.1
 */