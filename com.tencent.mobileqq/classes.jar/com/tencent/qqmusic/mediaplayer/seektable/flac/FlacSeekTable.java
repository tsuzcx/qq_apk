package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.Arrays;
import java.util.HashSet;

public class FlacSeekTable
  implements SeekTable
{
  private static final int SEEK_POINT_SIZE = 18;
  private static final byte TYPE_SEEKTABLE = 3;
  private static final byte TYPE_STREAMINFO = 0;
  private long firstFrameOffset;
  private long[] offsets;
  private long[] sampleNumbers;
  private int sampleRate = 0;
  
  public FlacSeekTable(int paramInt)
  {
    this.sampleRate = paramInt;
  }
  
  private static int binarySearchFloor(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Arrays.binarySearch(paramArrayOfLong, paramLong);
    if (i < 0) {
      i = -(i + 2);
    } else if (!paramBoolean1) {
      i -= 1;
    }
    int j = i;
    if (paramBoolean2) {
      j = Math.max(0, i);
    }
    return j;
  }
  
  private static boolean seekToFirstFrame(Parsable paramParsable)
  {
    byte[] arrayOfByte1 = new byte[1];
    byte[] arrayOfByte2 = new byte[3];
    int i = 0;
    while (paramParsable.available() > 0L)
    {
      if (i != 0)
      {
        arrayOfByte1 = new byte[2];
        paramParsable.readBytes(arrayOfByte1, 0, arrayOfByte1.length);
        if (((arrayOfByte1[0] & 0xFF) != 255) || ((arrayOfByte1[1] & 0xFF) >> 2 != 62)) {
          break;
        }
        return true;
      }
      paramParsable.readBytes(arrayOfByte1, 0, arrayOfByte1.length);
      if ((0xFF & arrayOfByte1[0]) >> 7 == 1) {
        i = 1;
      }
      paramParsable.readBytes(arrayOfByte2, 0, arrayOfByte2.length);
      paramParsable.skip(BytesUtil.from(arrayOfByte2));
    }
    return false;
  }
  
  private static boolean seekToFlac(Parsable paramParsable)
  {
    byte[] arrayOfByte = new byte[4];
    int i = arrayOfByte.length;
    boolean bool2 = false;
    paramParsable.readBytes(arrayOfByte, 0, i);
    if ((arrayOfByte[0] == 73) && (arrayOfByte[1] == 68) && (arrayOfByte[2] == 51))
    {
      paramParsable.skip(2L);
      paramParsable.skip(Id3Util.unsynchsafe(paramParsable.readInt()));
      paramParsable.readBytes(arrayOfByte, 0, arrayOfByte.length);
    }
    boolean bool1 = bool2;
    if (arrayOfByte[0] == 102)
    {
      bool1 = bool2;
      if (arrayOfByte[1] == 76)
      {
        bool1 = bool2;
        if (arrayOfByte[2] == 97)
        {
          bool1 = bool2;
          if (arrayOfByte[3] == 67) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean walkThrough(Parsable paramParsable, FlacSeekTable.BlockHandler... paramVarArgs)
  {
    byte[] arrayOfByte1 = new byte[1];
    byte[] arrayOfByte2 = new byte[3];
    HashSet localHashSet = new HashSet();
    while ((localHashSet.size() < paramVarArgs.length) && (paramParsable.available() > 0L))
    {
      paramParsable.readBytes(arrayOfByte1, 0, arrayOfByte1.length);
      int j = arrayOfByte1[0];
      int k = paramVarArgs.length;
      int i = 0;
      boolean bool = false;
      while (i < k)
      {
        FlacSeekTable.BlockHandler localBlockHandler = paramVarArgs[i];
        bool = localBlockHandler.handle(paramParsable, j & 0x7F);
        if (bool)
        {
          localHashSet.add(Integer.valueOf(localBlockHandler.hashCode()));
          break;
        }
        i += 1;
      }
      if (!bool)
      {
        if ((arrayOfByte1[0] & 0xFF) >> 7 == 1) {
          break;
        }
        paramParsable.readBytes(arrayOfByte2, 0, arrayOfByte2.length);
        paramParsable.skip(BytesUtil.from(arrayOfByte2));
      }
    }
    return localHashSet.size() == paramVarArgs.length;
  }
  
  public long[] getOffsetRangeOfSample(int paramInt)
  {
    paramInt = binarySearchFloor(this.sampleNumbers, paramInt, true, true);
    int i = paramInt + 1;
    long[] arrayOfLong = this.offsets;
    if (i >= arrayOfLong.length) {
      return new long[] { this.firstFrameOffset + arrayOfLong[paramInt], -1L };
    }
    long l = this.firstFrameOffset;
    return new long[] { arrayOfLong[paramInt] + l, l + arrayOfLong[i] };
  }
  
  public void parse(IDataSource paramIDataSource)
  {
    ParsableInputStreamWrapper localParsableInputStreamWrapper = new ParsableInputStreamWrapper(paramIDataSource);
    if (!seekToFlac(localParsableInputStreamWrapper)) {
      return;
    }
    if (this.sampleRate == 0)
    {
      paramIDataSource = new FlacSeekTable.BlockHandler[2];
      paramIDataSource[0] = new FlacSeekTable.SeektableHandler(this);
      paramIDataSource[1] = new FlacSeekTable.StreamInfoHandler(this);
    }
    else
    {
      paramIDataSource = new FlacSeekTable.BlockHandler[1];
      paramIDataSource[0] = new FlacSeekTable.SeektableHandler(this);
    }
    if (walkThrough(localParsableInputStreamWrapper, paramIDataSource)) {
      return;
    }
    throw new InvalidBoxException("lack one or more critical BLOCK(s) to create seek table!");
  }
  
  public long seek(long paramLong)
  {
    double d = paramLong;
    Double.isNaN(d);
    int i = (int)(Math.round(d / 1000.0D) * this.sampleRate);
    i = binarySearchFloor(this.sampleNumbers, i, true, true);
    return this.firstFrameOffset + this.offsets[i];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable
 * JD-Core Version:    0.7.0.1
 */