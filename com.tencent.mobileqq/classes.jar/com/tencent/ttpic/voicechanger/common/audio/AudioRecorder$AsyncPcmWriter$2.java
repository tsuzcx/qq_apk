package com.tencent.ttpic.voicechanger.common.audio;

import android.os.HandlerThread;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.io.RandomAccessFile;

class AudioRecorder$AsyncPcmWriter$2
  implements Runnable
{
  AudioRecorder$AsyncPcmWriter$2(AudioRecorder.AsyncPcmWriter paramAsyncPcmWriter) {}
  
  public void run()
  {
    if (AudioRecorder.AsyncPcmWriter.access$400(this.this$1)) {
      try
      {
        AudioRecorder.AsyncPcmWriter.access$200(this.this$1).close();
      }
      catch (IOException localIOException)
      {
        LogUtils.d(AudioRecorder.access$000(), "can't close?", localIOException, new Object[0]);
      }
    }
    if (AudioRecorder.AsyncPcmWriter.access$500(this.this$1) != null)
    {
      if (ApiHelper.hasJellyBeanMR2())
      {
        AudioRecorder.AsyncPcmWriter.access$500(this.this$1).quitSafely();
        return;
      }
      AudioRecorder.AsyncPcmWriter.access$500(this.this$1).quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorder.AsyncPcmWriter.2
 * JD-Core Version:    0.7.0.1
 */