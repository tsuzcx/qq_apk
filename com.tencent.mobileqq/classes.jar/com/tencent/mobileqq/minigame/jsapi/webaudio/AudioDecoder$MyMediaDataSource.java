package com.tencent.mobileqq.minigame.jsapi.webaudio;

import android.media.MediaDataSource;
import android.support.annotation.RequiresApi;

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
    if (this.inputData == null) {
      return -1L;
    }
    return this.inputData.length;
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.inputData == null) {}
    while ((paramLong < 0L) || (paramLong >= this.inputData.length)) {
      return -1;
    }
    if (paramInt2 + paramLong < this.inputData.length) {}
    for (long l = paramInt2;; l = this.inputData.length - paramLong)
    {
      System.arraycopy(this.inputData, (int)paramLong, paramArrayOfByte, paramInt1, (int)l);
      return (int)l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.AudioDecoder.MyMediaDataSource
 * JD-Core Version:    0.7.0.1
 */