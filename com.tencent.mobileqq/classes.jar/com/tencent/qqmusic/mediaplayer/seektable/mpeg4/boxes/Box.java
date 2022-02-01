package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import java.nio.charset.Charset;
import java.util.Arrays;

public abstract class Box
  implements IMpeg4Box
{
  private long largeSize;
  private int size;
  private byte[] type;
  private byte[] userType;
  
  public final long getSize()
  {
    long l = this.largeSize;
    if (l != 0L) {
      return l;
    }
    return this.size;
  }
  
  public final String getType()
  {
    return new String(this.type, Charset.defaultCharset());
  }
  
  public void parse(Parsable paramParsable, Box paramBox)
  {
    if (paramBox == null)
    {
      this.size = paramParsable.readInt();
      this.type = new byte[4];
      paramBox = this.type;
      paramParsable.readBytes(paramBox, 0, paramBox.length);
      int i = this.size;
      if (i == 1)
      {
        this.largeSize = paramParsable.readLong();
        if (this.largeSize == 0L)
        {
          paramParsable = new StringBuilder();
          paramParsable.append("invalid [");
          paramParsable.append(getType());
          paramParsable.append("]: largeSize is 0!");
          throw new InvalidBoxException(paramParsable.toString());
        }
      }
      else if (i == 0)
      {
        this.largeSize = paramParsable.available();
      }
      else
      {
        if (i < 8) {
          break label173;
        }
      }
      if (Arrays.equals(this.type, "uuid".getBytes()))
      {
        this.userType = new byte[16];
        paramBox = this.userType;
        paramParsable.readBytes(paramBox, 0, paramBox.length);
        return;
        label173:
        paramParsable = new StringBuilder();
        paramParsable.append("invalid [");
        paramParsable.append(getType());
        paramParsable.append("]: size is less than 8!");
        throw new InvalidBoxException(paramParsable.toString());
      }
    }
    else
    {
      this.size = paramBox.size;
      this.type = paramBox.type;
      this.largeSize = paramBox.largeSize;
      this.userType = paramBox.userType;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box
 * JD-Core Version:    0.7.0.1
 */