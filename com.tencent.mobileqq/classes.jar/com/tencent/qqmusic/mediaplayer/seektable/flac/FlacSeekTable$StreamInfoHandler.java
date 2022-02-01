package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

class FlacSeekTable$StreamInfoHandler
  implements FlacSeekTable.BlockHandler
{
  FlacSeekTable$StreamInfoHandler(FlacSeekTable paramFlacSeekTable) {}
  
  public boolean handle(Parsable paramParsable, int paramInt)
  {
    if (paramInt != 0) {
      return false;
    }
    paramParsable.skip(13L);
    byte[] arrayOfByte = new byte[3];
    paramParsable.readBytes(arrayOfByte, 0, arrayOfByte.length);
    paramParsable.skip(21L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable.StreamInfoHandler
 * JD-Core Version:    0.7.0.1
 */