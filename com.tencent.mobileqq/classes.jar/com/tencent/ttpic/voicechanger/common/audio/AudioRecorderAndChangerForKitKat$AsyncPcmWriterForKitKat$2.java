package com.tencent.ttpic.voicechanger.common.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.io.RandomAccessFile;

class AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat$2
  implements Runnable
{
  AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat$2(AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat paramAsyncPcmWriterForKitKat) {}
  
  public void run()
  {
    this.this$1.this$0.tryReleaseChanger();
    if (this.this$1.canSave) {}
    try
    {
      this.this$1.mMicfile.close();
      if (this.this$1.this$0.mListener != null)
      {
        this.this$1.this$0.mListener.onAudioRecordFinish();
        this.this$1.this$0.mListener = null;
      }
      this.this$1.quit();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        LogUtils.d(AudioRecorderCompat.TAG, "can't close?", localIOException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat.2
 * JD-Core Version:    0.7.0.1
 */