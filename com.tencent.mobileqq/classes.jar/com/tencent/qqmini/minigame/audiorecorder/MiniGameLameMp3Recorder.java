package com.tencent.qqmini.minigame.audiorecorder;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiniGameLameMp3Recorder
{
  public static final String TAG = "MiniGameLameMp3Recorder";
  private MiniGameLameMp3Recorder.AudioRecordListener mAudioRecordListener;
  private MiniGameLameMp3EncodeThread mEncodeThread;
  private long mPauseTime;
  private List<Integer> mPauseTimeList = new ArrayList();
  private long mRecordTime;
  private long mStartTime;
  private long maxRecordTime = 600000L;
  private long minRecordTime = 1000L;
  private final MiniGameLameMp3Recorder.RecorderHandler recorderHandler = new MiniGameLameMp3Recorder.RecorderHandler(this);
  
  public int getAudioSource()
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      return localMiniGameLameMp3EncodeThread.getAudioSource();
    }
    return 0;
  }
  
  public int getCallbackFrameSize()
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      return localMiniGameLameMp3EncodeThread.getCallbackFrameSize();
    }
    return 0;
  }
  
  public int getInChannel()
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      return localMiniGameLameMp3EncodeThread.getInChannel();
    }
    return 0;
  }
  
  public long getMaxRecordTime()
  {
    return this.maxRecordTime;
  }
  
  public long getMinRecordTime()
  {
    return this.minRecordTime;
  }
  
  public int getOutBitRate()
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      return localMiniGameLameMp3EncodeThread.getOutBitRate();
    }
    return 0;
  }
  
  public long getRecordDuration()
  {
    long l = System.currentTimeMillis() - this.mStartTime;
    Iterator localIterator = this.mPauseTimeList.iterator();
    while (localIterator.hasNext()) {
      l -= ((Integer)localIterator.next()).intValue();
    }
    return l;
  }
  
  public String getRecordFileFormat()
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      return localMiniGameLameMp3EncodeThread.getRecordFileFormat();
    }
    return "";
  }
  
  public String getRecordFilePath()
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      return localMiniGameLameMp3EncodeThread.getRecordFilePath();
    }
    return "";
  }
  
  public long getRecordFileSize()
  {
    Object localObject = getRecordFilePath();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return 0L;
    }
    localObject = new File((String)localObject);
    if (((File)localObject).exists()) {
      return ((File)localObject).length();
    }
    return 0L;
  }
  
  public long getRecordTime()
  {
    return this.mRecordTime;
  }
  
  public int getSampleRate()
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      return localMiniGameLameMp3EncodeThread.getSampleRate();
    }
    return 0;
  }
  
  public void initThread()
  {
    this.mEncodeThread = new MiniGameLameMp3EncodeThread(this.recorderHandler);
  }
  
  public boolean isPause()
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    return (localMiniGameLameMp3EncodeThread != null) && (localMiniGameLameMp3EncodeThread.isPause());
  }
  
  public boolean isRecordIdle()
  {
    return this.mEncodeThread == null;
  }
  
  public boolean isRecording()
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    return (localMiniGameLameMp3EncodeThread != null) && (localMiniGameLameMp3EncodeThread.isRecording());
  }
  
  public void recordPause()
  {
    if ((isRecording()) && (!isPause()))
    {
      this.mPauseTime = System.currentTimeMillis();
      this.mEncodeThread.pauseRecord();
    }
  }
  
  public void recordResume()
  {
    if ((isRecording()) && (isPause()))
    {
      int i = (int)(System.currentTimeMillis() - this.mPauseTime);
      if (i > 0) {
        this.mPauseTimeList.add(Integer.valueOf(i));
      }
      this.mEncodeThread.resumeRecord();
    }
  }
  
  public void recordStart()
  {
    this.mPauseTimeList.clear();
    this.mStartTime = System.currentTimeMillis();
    this.mEncodeThread.startRecord();
  }
  
  public void recordStop()
  {
    if (isRecording()) {
      this.mEncodeThread.stopRecord();
    }
  }
  
  public void setAudioRecordListener(MiniGameLameMp3Recorder.AudioRecordListener paramAudioRecordListener)
  {
    this.mAudioRecordListener = paramAudioRecordListener;
  }
  
  public void setAudioSource(String paramString)
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      localMiniGameLameMp3EncodeThread.setAudioSource(paramString);
    }
  }
  
  public void setCallbackFrameSize(int paramInt)
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      localMiniGameLameMp3EncodeThread.setCallbackFrameSize(paramInt);
    }
  }
  
  public void setInChannel(int paramInt)
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      localMiniGameLameMp3EncodeThread.setInChannel(paramInt);
    }
  }
  
  public void setMaxRecordTime(long paramLong)
  {
    this.maxRecordTime = paramLong;
  }
  
  public void setMinRecordTime(long paramLong)
  {
    this.minRecordTime = paramLong;
  }
  
  public void setOutBitRate(int paramInt)
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      localMiniGameLameMp3EncodeThread.setOutBitRate(paramInt);
    }
  }
  
  public void setRecordFileFormat(String paramString)
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      localMiniGameLameMp3EncodeThread.setRecordFileFormat(paramString);
    }
  }
  
  public void setRecordFilePath(String paramString)
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      localMiniGameLameMp3EncodeThread.setRecordFilePath(paramString);
    }
  }
  
  public void setRecordTime(long paramLong)
  {
    this.mRecordTime = paramLong;
  }
  
  public void setSampleRate(int paramInt)
  {
    MiniGameLameMp3EncodeThread localMiniGameLameMp3EncodeThread = this.mEncodeThread;
    if (localMiniGameLameMp3EncodeThread != null) {
      localMiniGameLameMp3EncodeThread.setSampleRate(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder
 * JD-Core Version:    0.7.0.1
 */