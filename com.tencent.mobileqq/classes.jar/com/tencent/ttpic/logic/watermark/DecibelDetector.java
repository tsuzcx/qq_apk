package com.tencent.ttpic.logic.watermark;

import android.media.AudioRecord;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import java.util.Timer;

public class DecibelDetector
{
  private static final int DECIBEL_UPDATE_INTERVAL = 40;
  private static final int[] SAMPLE_RATE_IN_HZ = { 32000, 16000 };
  private static final String TAG = DecibelDetector.class.getSimpleName();
  private static DecibelDetector mInstance;
  private int BUFFER_SIZE;
  private short[] buffer;
  private final Object lock = new Object();
  private AudioRecord mAudioRecorder;
  private int mDecibel;
  private FFTData mFFTDataResult = new FFTData();
  private boolean mIsAudioRecordPermission = true;
  private int sampleRateInHZ;
  private Timer timer;
  
  private DecibelDetector()
  {
    int i = 0;
    while ((j < SAMPLE_RATE_IN_HZ.length) && (i <= 0))
    {
      this.sampleRateInHZ = SAMPLE_RATE_IN_HZ[j];
      i = AudioRecord.getMinBufferSize(this.sampleRateInHZ, 1, 2);
      j += 1;
    }
    j = i;
    if (i <= 0)
    {
      ReportUtil.report("DecibelDetector no support SampleRate");
      j = 1;
    }
    this.BUFFER_SIZE = j;
    this.buffer = new short[this.BUFFER_SIZE];
  }
  
  public static DecibelDetector getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DecibelDetector();
      }
      DecibelDetector localDecibelDetector = mInstance;
      return localDecibelDetector;
    }
    finally {}
  }
  
  public void destroy()
  {
    stop();
    synchronized (this.lock)
    {
      try
      {
        if (this.mAudioRecorder != null)
        {
          this.mAudioRecorder.stop();
          this.mAudioRecorder.release();
          this.mAudioRecorder = null;
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          if (this.mAudioRecorder != null)
          {
            this.mAudioRecorder.release();
            this.mAudioRecorder = null;
          }
        }
      }
    }
  }
  
  public int getDecibel()
  {
    return this.mDecibel;
  }
  
  public FFTData getFFTResult()
  {
    return this.mFFTDataResult;
  }
  
  public void init()
  {
    if ((this.mAudioRecorder != null) || (!this.mIsAudioRecordPermission)) {
      return;
    }
    synchronized (this.lock)
    {
      startRecord();
      return;
    }
  }
  
  public void resetPermission()
  {
    this.mIsAudioRecordPermission = true;
  }
  
  public void startRecord()
  {
    try
    {
      if (this.mAudioRecorder == null) {
        this.mAudioRecorder = new AudioRecord(1, this.sampleRateInHZ, 1, 2, this.BUFFER_SIZE);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        try
        {
          this.mAudioRecorder.startRecording();
          if (this.timer == null)
          {
            this.timer = new Timer();
            DecibelDetector.1 local1 = new DecibelDetector.1(this);
            this.timer.schedule(local1, 0L, 40L);
          }
          return;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          localIllegalStateException.printStackTrace();
          this.mAudioRecorder = null;
          this.mIsAudioRecordPermission = false;
        }
        localIllegalArgumentException = localIllegalArgumentException;
        LogUtils.e(localIllegalArgumentException);
      }
    }
  }
  
  public void stop()
  {
    if (this.timer != null)
    {
      this.timer.cancel();
      this.timer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.DecibelDetector
 * JD-Core Version:    0.7.0.1
 */