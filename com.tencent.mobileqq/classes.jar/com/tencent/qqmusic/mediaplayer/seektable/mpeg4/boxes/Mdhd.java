package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Mdhd
  extends FullBox
{
  long creationTime;
  long duration;
  long modificationTime;
  byte[] remaining;
  int timeScale;
  
  public long getCreationTime()
  {
    return this.creationTime;
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public long getModificationTime()
  {
    return this.modificationTime;
  }
  
  public int getTimeScale()
  {
    return this.timeScale;
  }
  
  public void parse(Parsable paramParsable, Box paramBox)
  {
    super.parse(paramParsable, paramBox);
    if (this.version == 1)
    {
      this.creationTime = paramParsable.readLong();
      this.modificationTime = paramParsable.readLong();
      this.timeScale = paramParsable.readInt();
      this.duration = paramParsable.readLong();
    }
    else
    {
      this.creationTime = paramParsable.readInt();
      this.modificationTime = paramParsable.readInt();
      this.timeScale = paramParsable.readInt();
      this.duration = paramParsable.readInt();
    }
    this.remaining = new byte[4];
    paramBox = this.remaining;
    paramParsable.readBytes(paramBox, 0, paramBox.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Mdhd
 * JD-Core Version:    0.7.0.1
 */