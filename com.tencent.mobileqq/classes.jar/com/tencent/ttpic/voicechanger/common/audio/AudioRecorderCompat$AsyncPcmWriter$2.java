package com.tencent.ttpic.voicechanger.common.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.LinkedList;

class AudioRecorderCompat$AsyncPcmWriter$2
  implements Runnable
{
  AudioRecorderCompat$AsyncPcmWriter$2(AudioRecorderCompat.AsyncPcmWriter paramAsyncPcmWriter, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject2 = this.val$fileBuffer;
      ??? = localObject2;
      if (this.this$1.this$0.mVoiceChangeEnable)
      {
        ??? = localObject2;
        if (this.this$1.this$0.mVoiceChanger != null)
        {
          ??? = new short[this.val$count / 2];
          ByteBuffer.wrap(this.val$fileBuffer).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get((short[])???);
          ??? = this.this$1.this$0.mVoiceChanger.writeVoiceFrames((short[])???);
          if (??? == null) {
            throw new Exception("frames is null");
          }
        }
      }
      if ((this.this$1.this$0.mRealPackerEnable) && (this.this$1.this$0.mPcmPacker != null)) {
        this.this$1.this$0.mPcmPacker.encodeBytes((byte[])???);
      } else {
        AudioRecorderCompat.AsyncPcmWriter.access$000(this.this$1).write((byte[])???, 0, ???.length);
      }
      ??? = AudioRecorderCompat.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Process 1 recorded frame: ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject2).append(" ms");
      LogUtils.d((String)???, ((StringBuilder)localObject2).toString());
      synchronized (AudioRecorderCompat.AsyncPcmWriter.access$100(this.this$1))
      {
        if (AudioRecorderCompat.AsyncPcmWriter.access$100(this.this$1).size() < 8) {
          AudioRecorderCompat.AsyncPcmWriter.access$100(this.this$1).add(this.val$fileBuffer);
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtils.e(AudioRecorderCompat.TAG, "onRecord() - ERROR", new Object[] { localException.getMessage() });
      try
      {
        AudioRecorderCompat.AsyncPcmWriter.access$000(this.this$1).close();
        return;
      }
      catch (IOException localIOException)
      {
        LogUtils.d(AudioRecorderCompat.TAG, "can't close?", localIOException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.AsyncPcmWriter.2
 * JD-Core Version:    0.7.0.1
 */