package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Stsz
  extends FullBox
{
  @Nullable
  int[] entrySize;
  int sampleCount;
  int sampleSize;
  
  public int[] getEntrySize()
  {
    return this.entrySize;
  }
  
  public int getSampleCount()
  {
    return this.sampleCount;
  }
  
  public int getSampleSize()
  {
    return this.sampleSize;
  }
  
  public void parse(Parsable paramParsable, Box paramBox)
  {
    super.parse(paramParsable, paramBox);
    this.sampleSize = paramParsable.readInt();
    this.sampleCount = paramParsable.readInt();
    if (this.sampleSize == 0) {
      this.entrySize = paramParsable.readIntArray(this.sampleCount);
    }
    if (this.sampleSize == 0)
    {
      if (this.sampleCount != 0) {
        return;
      }
      throw new InvalidBoxException("invalide stsz: both [sample_count] and [sample_size] is 0!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsz
 * JD-Core Version:    0.7.0.1
 */