package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Stts
  extends FullBox
{
  int entryCount;
  int[] sampleCount;
  int[] sampleDelta;
  
  public int getEntryCount()
  {
    return this.entryCount;
  }
  
  public int[] getSampleCount()
  {
    return this.sampleCount;
  }
  
  public int[] getSampleDelta()
  {
    return this.sampleDelta;
  }
  
  public void parse(Parsable paramParsable, Box paramBox)
  {
    super.parse(paramParsable, paramBox);
    this.entryCount = paramParsable.readInt();
    int i = this.entryCount;
    this.sampleCount = new int[i];
    this.sampleDelta = new int[i];
    paramParsable.readIntArrayInterleaved(i, new int[][] { this.sampleCount, this.sampleDelta });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stts
 * JD-Core Version:    0.7.0.1
 */