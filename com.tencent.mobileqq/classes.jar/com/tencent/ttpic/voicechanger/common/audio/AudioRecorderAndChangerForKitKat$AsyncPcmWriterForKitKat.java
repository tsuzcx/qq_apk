package com.tencent.ttpic.voicechanger.common.audio;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.ttpic.baseutils.io.FileUtils;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat
  extends HandlerThread
{
  protected static final String T_TAG = "AudioRecorder.AsyncPcmWriterForKitKat";
  protected boolean canSave = true;
  protected final LinkedList<byte[]> fileBuffers = new LinkedList();
  protected Handler mHandler = null;
  protected RandomAccessFile mMicfile = null;
  protected int perBufSize;
  
  public AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat(AudioRecorderAndChangerForKitKat paramAudioRecorderAndChangerForKitKat, String paramString, int paramInt)
  {
    super(paramAudioRecorderAndChangerForKitKat.toString());
    FileUtils.delete(paramString);
    this.perBufSize = paramInt;
    this.mMicfile = new RandomAccessFile(paramString, "rw");
    start();
    this.mHandler = new Handler(getLooper());
    int i = 0;
    while (i < 4)
    {
      paramAudioRecorderAndChangerForKitKat = new byte[paramInt];
      this.fileBuffers.add(paramAudioRecorderAndChangerForKitKat);
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
      this.mHandler.post(new AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat.1(this, paramInt, arrayOfByte));
      return;
    }
  }
  
  public void onStop()
  {
    this.mHandler.post(new AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat
 * JD-Core Version:    0.7.0.1
 */