package com.tencent.ttpic.voicechanger.common.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.io.RandomAccessFile;

class AudioRecorderCompat$AsyncPcmWriter$3
  implements Runnable
{
  AudioRecorderCompat$AsyncPcmWriter$3(AudioRecorderCompat.AsyncPcmWriter paramAsyncPcmWriter) {}
  
  public void run()
  {
    this.this$1.this$0.tryReleaseChanger();
    this.this$1.this$0.tryReleasePacker();
    this.this$1.this$0.tryReleaseRecognizer();
    try
    {
      if ((this.this$1.this$0.mWrite2FileEnable) && (AudioRecorderCompat.AsyncPcmWriter.access$000(this.this$1) != null)) {
        AudioRecorderCompat.AsyncPcmWriter.access$000(this.this$1).close();
      }
    }
    catch (IOException localIOException)
    {
      LogUtils.d(AudioRecorderCompat.TAG, "can't close?", localIOException, new Object[0]);
    }
    if (this.this$1.this$0.mListener != null)
    {
      this.this$1.this$0.mListener.onAudioRecordFinish();
      this.this$1.this$0.mListener = null;
    }
    this.this$1.quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.AsyncPcmWriter.3
 * JD-Core Version:    0.7.0.1
 */