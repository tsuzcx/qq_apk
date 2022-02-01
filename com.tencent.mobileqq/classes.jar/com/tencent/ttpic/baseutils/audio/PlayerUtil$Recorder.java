package com.tencent.ttpic.baseutils.audio;

import android.media.MediaRecorder;

public class PlayerUtil$Recorder
  extends MediaRecorder
{
  private boolean isRecording;
  
  public boolean isRecording()
  {
    return this.isRecording;
  }
  
  public void release()
  {
    try
    {
      super.release();
      this.isRecording = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void reset()
  {
    if (!this.isRecording) {
      return;
    }
    try
    {
      super.reset();
      this.isRecording = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void start()
  {
    if (this.isRecording) {
      return;
    }
    try
    {
      super.start();
      this.isRecording = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stop()
  {
    if (!this.isRecording) {
      return;
    }
    try
    {
      super.stop();
      this.isRecording = false;
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.audio.PlayerUtil.Recorder
 * JD-Core Version:    0.7.0.1
 */