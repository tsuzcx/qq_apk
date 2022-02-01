package com.tencent.ttpic.voicechanger.common.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.LinkedList;

class AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat$1
  implements Runnable
{
  AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat$1(AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat paramAsyncPcmWriterForKitKat, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((this.this$1.this$0.needVoiceChange) && (this.this$1.this$0.mVoiceChanger != null))
      {
        ??? = new short[this.val$count / 2];
        ByteBuffer.wrap(this.val$fileBuffer).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get((short[])???);
        ??? = this.this$1.this$0.mVoiceChanger.writeVoiceFrames((short[])???);
        if (??? != null) {
          this.this$1.mMicfile.write((byte[])???, 0, ???.length);
        } else {
          throw new Exception("frames is null");
        }
      }
      else
      {
        this.this$1.mMicfile.write(this.val$fileBuffer, 0, this.val$fileBuffer.length);
      }
      ??? = AudioRecorderCompat.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Process 1 recorded frame: ");
      localStringBuilder.append(System.currentTimeMillis() - l);
      localStringBuilder.append(" ms");
      LogUtils.d((String)???, localStringBuilder.toString());
      synchronized (this.this$1.fileBuffers)
      {
        if (this.this$1.fileBuffers.size() < 8) {
          this.this$1.fileBuffers.add(this.val$fileBuffer);
        }
        return;
      }
      AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat localAsyncPcmWriterForKitKat;
      return;
    }
    catch (Exception localException)
    {
      LogUtils.d(AudioRecorderCompat.TAG, "onRecord ERROR: ", localException, new Object[0]);
      try
      {
        this.this$1.mMicfile.close();
        return;
      }
      catch (IOException localIOException1)
      {
        LogUtils.d(AudioRecorderCompat.TAG, "can't close?", localIOException1, new Object[0]);
        return;
      }
    }
    catch (IOException localIOException2)
    {
      LogUtils.w(AudioRecorderCompat.TAG, "", localIOException2, new Object[0]);
      localAsyncPcmWriterForKitKat = this.this$1;
      localAsyncPcmWriterForKitKat.canSave = false;
      try
      {
        localAsyncPcmWriterForKitKat.mMicfile.close();
        return;
      }
      catch (IOException localIOException3)
      {
        LogUtils.d(AudioRecorderCompat.TAG, "can't close?", localIOException3, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat.1
 * JD-Core Version:    0.7.0.1
 */