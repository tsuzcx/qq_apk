package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Co64
  extends FullBox
{
  private long[] chunkOffset;
  private int entryCount;
  
  public long[] getChunkOffset()
  {
    return this.chunkOffset;
  }
  
  public int getEntryCount()
  {
    return this.entryCount;
  }
  
  public void parse(Parsable paramParsable, Box paramBox)
  {
    super.parse(paramParsable, paramBox);
    this.entryCount = paramParsable.readInt();
    this.chunkOffset = paramParsable.readLongArray(this.entryCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Co64
 * JD-Core Version:    0.7.0.1
 */