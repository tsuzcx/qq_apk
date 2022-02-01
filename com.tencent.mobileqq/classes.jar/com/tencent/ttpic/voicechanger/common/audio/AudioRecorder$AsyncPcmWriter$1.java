package com.tencent.ttpic.voicechanger.common.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.LinkedList;

class AudioRecorder$AsyncPcmWriter$1
  implements Runnable
{
  AudioRecorder$AsyncPcmWriter$1(AudioRecorder.AsyncPcmWriter paramAsyncPcmWriter, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      int j = this.val$count / 2;
      ??? = new short[j];
      ByteBuffer.wrap(this.val$fileBuffer).order(ByteOrder.BIG_ENDIAN).asShortBuffer().get((short[])???);
      int i = 0;
      while (i < j)
      {
        AudioRecorder.AsyncPcmWriter.access$200(this.this$1).writeShort(???[i]);
        i += 1;
      }
      synchronized (AudioRecorder.AsyncPcmWriter.access$300(this.this$1))
      {
        if (AudioRecorder.AsyncPcmWriter.access$300(this.this$1).size() < 8) {
          AudioRecorder.AsyncPcmWriter.access$300(this.this$1).add(this.val$fileBuffer);
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtils.d(AudioRecorder.access$000(), "onRecord ERROR: ", localException, new Object[0]);
      try
      {
        AudioRecorder.AsyncPcmWriter.access$200(this.this$1).close();
        return;
      }
      catch (IOException localIOException1)
      {
        LogUtils.d(AudioRecorder.access$000(), "can't close?", localIOException1, new Object[0]);
        return;
      }
    }
    catch (IOException localIOException2)
    {
      LogUtils.w(AudioRecorder.access$000(), "", localIOException2, new Object[0]);
      AudioRecorder.AsyncPcmWriter.access$402(this.this$1, false);
      try
      {
        AudioRecorder.AsyncPcmWriter.access$200(this.this$1).close();
        return;
      }
      catch (IOException localIOException3)
      {
        LogUtils.d(AudioRecorder.access$000(), "can't close?", localIOException3, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorder.AsyncPcmWriter.1
 * JD-Core Version:    0.7.0.1
 */