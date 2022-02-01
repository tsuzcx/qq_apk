package com.tencent.qqmini.minigame.audiorecorder;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiniGameLameMp3Recorder
{
  public static final String TAG = MiniGameLameMp3Recorder.class.getSimpleName();
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
    if (this.mEncodeThread != null) {
      return this.mEncodeThread.getAudioSource();
    }
    return 0;
  }
  
  public int getCallbackFrameSize()
  {
    if (this.mEncodeThread != null) {
      return this.mEncodeThread.getCallbackFrameSize();
    }
    return 0;
  }
  
  public int getInChannel()
  {
    if (this.mEncodeThread != null) {
      return this.mEncodeThread.getInChannel();
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
    if (this.mEncodeThread != null) {
      return this.mEncodeThread.getOutBitRate();
    }
    return 0;
  }
  
  public long getRecordDuration()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    Iterator localIterator = this.mPauseTimeList.iterator();
    for (l1 -= l2; localIterator.hasNext(); l1 -= ((Integer)localIterator.next()).intValue()) {}
    return l1;
  }
  
  public String getRecordFileFormat()
  {
    if (this.mEncodeThread != null) {
      return this.mEncodeThread.getRecordFileFormat();
    }
    return "";
  }
  
  public String getRecordFilePath()
  {
    if (this.mEncodeThread != null) {
      return this.mEncodeThread.getRecordFilePath();
    }
    return "";
  }
  
  public long getRecordFileSize()
  {
    Object localObject = getRecordFilePath();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return 0L;
      localObject = new File((String)localObject);
    } while (!((File)localObject).exists());
    return ((File)localObject).length();
  }
  
  public long getRecordTime()
  {
    return this.mRecordTime;
  }
  
  public int getSampleRate()
  {
    if (this.mEncodeThread != null) {
      return this.mEncodeThread.getSampleRate();
    }
    return 0;
  }
  
  public void initThread()
  {
    this.mEncodeThread = new MiniGameLameMp3EncodeThread(this.recorderHandler);
  }
  
  public boolean isPause()
  {
    return (this.mEncodeThread != null) && (this.mEncodeThread.isPause());
  }
  
  public boolean isRecordIdle()
  {
    return this.mEncodeThread == null;
  }
  
  public boolean isRecording()
  {
    return (this.mEncodeThread != null) && (this.mEncodeThread.isRecording());
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
    if (this.mEncodeThread != null) {
      this.mEncodeThread.setAudioSource(paramString);
    }
  }
  
  public void setCallbackFrameSize(int paramInt)
  {
    if (this.mEncodeThread != null) {
      this.mEncodeThread.setCallbackFrameSize(paramInt);
    }
  }
  
  public void setInChannel(int paramInt)
  {
    if (this.mEncodeThread != null) {
      this.mEncodeThread.setInChannel(paramInt);
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
    if (this.mEncodeThread != null) {
      this.mEncodeThread.setOutBitRate(paramInt);
    }
  }
  
  public void setRecordFileFormat(String paramString)
  {
    if (this.mEncodeThread != null) {
      this.mEncodeThread.setRecordFileFormat(paramString);
    }
  }
  
  public void setRecordFilePath(String paramString)
  {
    if (this.mEncodeThread != null) {
      this.mEncodeThread.setRecordFilePath(paramString);
    }
  }
  
  public void setRecordTime(long paramLong)
  {
    this.mRecordTime = paramLong;
  }
  
  public void setSampleRate(int paramInt)
  {
    if (this.mEncodeThread != null) {
      this.mEncodeThread.setSampleRate(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder
 * JD-Core Version:    0.7.0.1
 */