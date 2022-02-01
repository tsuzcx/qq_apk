package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public abstract class FullBox
  extends Box
{
  int flags;
  int version;
  
  public int getFlags()
  {
    return this.flags;
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  public void parse(Parsable paramParsable, Box paramBox)
  {
    super.parse(paramParsable, paramBox);
    paramBox = new byte[4];
    paramParsable.readBytes(paramBox, 0, 4);
    this.version = (paramBox[0] & 0xFF);
    this.flags = ((paramBox[1] & 0xFF) << 16 | (paramBox[2] & 0xFF) << 8 | paramBox[3] & 0xFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.FullBox
 * JD-Core Version:    0.7.0.1
 */