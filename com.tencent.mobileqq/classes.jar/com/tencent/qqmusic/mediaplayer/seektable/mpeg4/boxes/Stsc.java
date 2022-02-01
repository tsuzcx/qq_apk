package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Stsc
  extends FullBox
{
  int entryCount;
  int[] firstChunk;
  int[] sampleDescIndex;
  int[] samplesPerChunk;
  
  public int getEntryCount()
  {
    return this.entryCount;
  }
  
  public int[] getFirstChunk()
  {
    return this.firstChunk;
  }
  
  public int[] getSampleDescIndex()
  {
    return this.sampleDescIndex;
  }
  
  public int[] getSamplesPerChunk()
  {
    return this.samplesPerChunk;
  }
  
  public void parse(Parsable paramParsable, Box paramBox)
  {
    super.parse(paramParsable, paramBox);
    this.entryCount = paramParsable.readInt();
    int i = this.entryCount;
    this.firstChunk = new int[i];
    this.samplesPerChunk = new int[i];
    this.sampleDescIndex = new int[i];
    paramParsable.readIntArrayInterleaved(i, new int[][] { this.firstChunk, this.samplesPerChunk, this.sampleDescIndex });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsc
 * JD-Core Version:    0.7.0.1
 */