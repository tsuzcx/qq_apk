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
      l = System.currentTimeMillis();
      if ((this.this$1.this$0.needVoiceChange) && (this.this$1.this$0.mVoiceChanger != null))
      {
        Object localObject1 = new short[this.val$count / 2];
        ByteBuffer.wrap(this.val$fileBuffer).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get((short[])localObject1);
        localObject1 = this.this$1.this$0.mVoiceChanger.writeVoiceFrames((short[])localObject1);
        if (localObject1 == null) {
          throw new Exception("frames is null");
        }
      }
    }
    catch (IOException localIOException1)
    {
      long l;
      LogUtils.w(AudioRecorderCompat.TAG, "", localIOException1, new Object[0]);
      this.this$1.canSave = false;
      try
      {
        this.this$1.mMicfile.close();
        return;
      }
      catch (IOException localIOException3)
      {
        LogUtils.d(AudioRecorderCompat.TAG, "can't close?", localIOException3, new Object[0]);
      }
      this.this$1.mMicfile.write(localIOException1, 0, localIOException1.length);
      LogUtils.d(AudioRecorderCompat.TAG, "Process 1 recorded frame: " + (System.currentTimeMillis() - l) + " ms");
      synchronized (this.this$1.fileBuffers)
      {
        if (this.this$1.fileBuffers.size() < 8) {
          this.this$1.fileBuffers.add(this.val$fileBuffer);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtils.d(AudioRecorderCompat.TAG, "onRecord ERROR: ", localException, new Object[0]);
        try
        {
          this.this$1.mMicfile.close();
          return;
        }
        catch (IOException localIOException2)
        {
          LogUtils.d(AudioRecorderCompat.TAG, "can't close?", localIOException2, new Object[0]);
          return;
        }
        this.this$1.mMicfile.write(this.val$fileBuffer, 0, this.val$fileBuffer.length);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat.1
 * JD-Core Version:    0.7.0.1
 */