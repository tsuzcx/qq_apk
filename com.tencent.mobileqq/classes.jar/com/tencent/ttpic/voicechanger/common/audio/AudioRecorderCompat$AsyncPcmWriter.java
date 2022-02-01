package com.tencent.ttpic.voicechanger.common.audio;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.ttpic.baseutils.io.FileUtils;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class AudioRecorderCompat$AsyncPcmWriter
  extends HandlerThread
{
  private static final String T_TAG = "AudioRecorder.AsyncPcmWriter";
  private final LinkedList<byte[]> fileBuffers = new LinkedList();
  private Handler mHandler = null;
  private RandomAccessFile mMicfile = null;
  private int perBufSize;
  
  public AudioRecorderCompat$AsyncPcmWriter(AudioRecorderCompat paramAudioRecorderCompat, String paramString, int paramInt)
  {
    super(localStringBuilder.toString());
    FileUtils.delete(paramString);
    if (paramAudioRecorderCompat.mWrite2FileEnable) {
      this.mMicfile = new RandomAccessFile(paramString, "rw");
    }
    this.perBufSize = paramInt;
    start();
    this.mHandler = new Handler(getLooper());
    int i = 0;
    while (i < 4)
    {
      paramAudioRecorderCompat = new byte[paramInt];
      this.fileBuffers.add(paramAudioRecorderCompat);
      i += 1;
    }
  }
  
  public void onPrepare()
  {
    this.mHandler.post(new AudioRecorderCompat.AsyncPcmWriter.1(this));
  }
  
  public void onRecord(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.this$0.mWrite2FileEnable) {
      return;
    }
    synchronized (this.fileBuffers)
    {
      byte[] arrayOfByte;
      if (this.fileBuffers.size() > 0)
      {
        arrayOfByte = (byte[])this.fileBuffers.peek();
        this.fileBuffers.remove();
      }
      else
      {
        arrayOfByte = new byte[this.perBufSize];
      }
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
      this.mHandler.post(new AudioRecorderCompat.AsyncPcmWriter.2(this, arrayOfByte, paramInt));
      return;
    }
  }
  
  public void onStop()
  {
    this.mHandler.post(new AudioRecorderCompat.AsyncPcmWriter.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.AsyncPcmWriter
 * JD-Core Version:    0.7.0.1
 */