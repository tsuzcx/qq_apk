package com.tencent.qqmusic.mediaplayer.util;

import java.io.InputStream;

public class StreamUtils
{
  public static long skipForBufferStream(InputStream paramInputStream, long paramLong)
  {
    if (paramInputStream != null)
    {
      if (paramLong <= 0L) {
        return 0L;
      }
      long l2 = paramLong;
      long l1 = 0L;
      long l3;
      long l4;
      do
      {
        l3 = l2 - l1;
        l4 = paramInputStream.skip(l3);
        if (l4 <= 0L) {
          break;
        }
        l2 = l3;
        l1 = l4;
      } while (l4 < l3);
      if (l4 > 0L) {
        return paramLong;
      }
      return paramLong - l3;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.StreamUtils
 * JD-Core Version:    0.7.0.1
 */