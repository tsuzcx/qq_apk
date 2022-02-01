package com.tencent.ttpic.audio;

import com.tencent.ttpic.logic.watermark.DecibelDetector;

public enum LocalAudioDataManager
{
  INSTANCE;
  
  private static final int DECIBEL_UPDATE_INTERVAL = 500;
  private static final String TAG = LocalAudioDataManager.class.getSimpleName();
  private int mDecibel;
  private long mDecibelUpdateTimestamp = 0L;
  private boolean mNeedDecibel = false;
  private boolean mUseDecibelFromCameraRecorder = false;
  
  private LocalAudioDataManager() {}
  
  private int adjustDB(int paramInt)
  {
    double d = paramInt;
    Double.isNaN(d);
    return (int)(d * 0.65D + 40.0D);
  }
  
  public static LocalAudioDataManager getInstance()
  {
    return INSTANCE;
  }
  
  public void destroy()
  {
    destroyDecibelDetector();
  }
  
  public void destroyDecibelDetector()
  {
    DecibelDetector.getInstance().destroy();
  }
  
  public String getDB()
  {
    if (!this.mUseDecibelFromCameraRecorder)
    {
      DecibelDetector.getInstance().init();
      int i = DecibelDetector.getInstance().getDecibel();
      if (i != 0) {
        setDecibel(i);
      }
    }
    return String.valueOf(adjustDB(this.mDecibel));
  }
  
  public boolean needDecibel()
  {
    return this.mNeedDecibel;
  }
  
  public void reset()
  {
    this.mNeedDecibel = false;
    this.mUseDecibelFromCameraRecorder = false;
    this.mDecibelUpdateTimestamp = 0L;
  }
  
  public void setDecibel(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.mDecibelUpdateTimestamp > 500L)
    {
      this.mDecibel = paramInt;
      this.mDecibelUpdateTimestamp = l;
    }
  }
  
  public void setDecibelFromCameraRecorder(boolean paramBoolean)
  {
    this.mUseDecibelFromCameraRecorder = paramBoolean;
  }
  
  public void setNeedDB(boolean paramBoolean)
  {
    this.mNeedDecibel = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.audio.LocalAudioDataManager
 * JD-Core Version:    0.7.0.1
 */