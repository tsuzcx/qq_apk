package com.tencent.ttpic.logic.watermark;

import android.media.AudioRecord;

public class FFTData
{
  public static final int BUFFER_SIZE = AudioRecord.getMinBufferSize(44100, 1, 2);
  private static final int DEFAULT_SIZE = 1024;
  private static final int SAMPLE_RATE_IN_HZ = 44100;
  public int[] mFFTBuffer;
  public int mFFTFreqMax = 22050;
  public int mFFTSize;
  public int mFFTSum = 0;
  
  public FFTData()
  {
    int i = BUFFER_SIZE;
    if (i > 0)
    {
      this.mFFTBuffer = new int[i];
      this.mFFTSize = i;
      return;
    }
    this.mFFTBuffer = new int[1024];
    this.mFFTSize = 1024;
  }
  
  public FFTData(int paramInt)
  {
    if (paramInt > 0)
    {
      this.mFFTBuffer = new int[paramInt];
      this.mFFTSize = paramInt;
      return;
    }
    this.mFFTBuffer = new int[1024];
    this.mFFTSize = 1024;
  }
  
  public FFTData(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      this.mFFTBuffer = new int[paramInt1];
      this.mFFTSize = paramInt1;
    }
    else
    {
      this.mFFTBuffer = new int[1024];
      this.mFFTSize = 1024;
    }
    this.mFFTFreqMax = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.FFTData
 * JD-Core Version:    0.7.0.1
 */