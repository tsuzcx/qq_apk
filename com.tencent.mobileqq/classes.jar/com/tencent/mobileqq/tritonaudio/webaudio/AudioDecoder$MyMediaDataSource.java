package com.tencent.mobileqq.tritonaudio.webaudio;

import android.media.MediaDataSource;
import androidx.annotation.RequiresApi;

@RequiresApi(api=23)
class AudioDecoder$MyMediaDataSource
  extends MediaDataSource
{
  private byte[] inputData;
  
  public AudioDecoder$MyMediaDataSource(AudioDecoder paramAudioDecoder, byte[] paramArrayOfByte)
  {
    this.inputData = paramArrayOfByte;
  }
  
  public void close() {}
  
  public long getSize()
  {
    byte[] arrayOfByte = this.inputData;
    if (arrayOfByte == null) {
      return -1L;
    }
    return arrayOfByte.length;
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this.inputData;
    if (arrayOfByte == null) {
      return -1;
    }
    if (paramLong >= 0L)
    {
      if (paramLong >= arrayOfByte.length) {
        return -1;
      }
      long l = paramInt2;
      if (paramLong + l >= arrayOfByte.length) {
        l = arrayOfByte.length - paramLong;
      }
      arrayOfByte = this.inputData;
      paramInt2 = (int)paramLong;
      int i = (int)l;
      System.arraycopy(arrayOfByte, paramInt2, paramArrayOfByte, paramInt1, i);
      return i;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.AudioDecoder.MyMediaDataSource
 * JD-Core Version:    0.7.0.1
 */