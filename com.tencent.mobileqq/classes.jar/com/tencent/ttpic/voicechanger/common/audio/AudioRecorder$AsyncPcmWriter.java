package com.tencent.ttpic.voicechanger.common.audio;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.ttpic.baseutils.io.FileUtils;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class AudioRecorder$AsyncPcmWriter
{
  private static final String T_TAG = "AudioRecorder.AsyncPcmWriter";
  private boolean canSave = true;
  private final LinkedList<byte[]> fileBuffers = new LinkedList();
  private Handler mHandler = null;
  private HandlerThread mHandlerThread = null;
  private RandomAccessFile mMicfile = null;
  private int perBufSize;
  
  public AudioRecorder$AsyncPcmWriter(AudioRecorder paramAudioRecorder, String paramString, int paramInt)
  {
    FileUtils.delete(paramString);
    this.perBufSize = paramInt;
    this.mMicfile = new RandomAccessFile(paramString, "rw");
    int i = 0;
    while (i < 4)
    {
      paramAudioRecorder = new byte[paramInt];
      this.fileBuffers.add(paramAudioRecorder);
      i += 1;
    }
  }
  
  public void onRecord(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.canSave) {
      return;
    }
    synchronized (this.fileBuffers)
    {
      if (this.fileBuffers.size() > 0)
      {
        arrayOfByte = (byte[])this.fileBuffers.peek();
        this.fileBuffers.remove();
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
        this.mHandler.post(new AudioRecorder.AsyncPcmWriter.1(this, paramInt, arrayOfByte));
        return;
      }
      byte[] arrayOfByte = new byte[this.perBufSize];
    }
  }
  
  public void onStop()
  {
    this.mHandler.post(new AudioRecorder.AsyncPcmWriter.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorder.AsyncPcmWriter
 * JD-Core Version:    0.7.0.1
 */