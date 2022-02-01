package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public class Mp3SeekTable
  implements SeekTable
{
  private final Mp3FrameInfoParse.Mp3Info mInfo = new Mp3FrameInfoParse.Mp3Info();
  
  private static long timeToBytePositionInCbr(Mp3FrameInfoParse.Mp3Info paramMp3Info, long paramLong)
  {
    if ((paramMp3Info != null) && (paramMp3Info.bit_rate > 0) && (paramLong >= 0L))
    {
      long l = paramMp3Info.bit_rate / 8 * paramLong;
      paramLong = l;
      if (paramMp3Info.idv2Size > 0) {
        paramLong = l + paramMp3Info.idv2Size;
      }
      return paramLong;
    }
    return -1L;
  }
  
  private static long timeToBytePositionInVBRIVbr(Mp3FrameInfoParse.Mp3Info paramMp3Info, long paramLong)
  {
    if ((paramMp3Info != null) && (paramMp3Info.toc_table != null) && (paramMp3Info.fileLengthInBytes > 0L) && (paramMp3Info.firstFramePosition >= 0L) && (paramMp3Info.duration > 0L) && (paramLong >= 0L))
    {
      long l2 = paramMp3Info.fileLengthInBytes;
      long l1 = paramMp3Info.firstFramePosition;
      int i = paramMp3Info.entry_count;
      long[] arrayOfLong = paramMp3Info.toc_table;
      long l3 = paramMp3Info.duration;
      double d1 = paramLong;
      Double.isNaN(d1);
      double d2 = l3;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      int j = i + 1;
      d2 = j;
      Double.isNaN(d2);
      int k = (int)(d1 * d2);
      if (k >= 0) {
        l1 = arrayOfLong[k];
      }
      if (k < i) {
        l2 = arrayOfLong[(k + 1)];
      }
      long l5 = k;
      long l4 = j;
      l5 = l5 * l3 / l4;
      l3 = (k + 1) * l3 / l4;
      if (l2 == l1)
      {
        paramLong = 0L;
      }
      else
      {
        d1 = l2 - l1;
        Double.isNaN(d1);
        d2 = paramLong - l5;
        Double.isNaN(d2);
        double d3 = l3 - l5;
        Double.isNaN(d3);
        paramLong = (d1 * 1.0D * d2 / d3);
      }
      return l1 + paramLong;
    }
    return -1L;
  }
  
  private static long timeToBytePositionInXingVbr(Mp3FrameInfoParse.Mp3Info paramMp3Info, long paramLong)
  {
    if ((paramMp3Info != null) && (paramMp3Info.toc_table != null) && (paramMp3Info.fileLengthInBytes > 0L) && (paramMp3Info.firstFramePosition >= 0L) && (paramMp3Info.duration >= 0L) && (paramLong >= 0L))
    {
      long l1 = paramMp3Info.fileLengthInBytes;
      long l3 = paramMp3Info.firstFramePosition;
      long[] arrayOfLong = paramMp3Info.toc_table;
      long l2 = paramMp3Info.duration;
      double d1 = paramLong;
      Double.isNaN(d1);
      double d2 = l2;
      Double.isNaN(d2);
      d2 = d1 * 100.0D / d2;
      d1 = 0.0D;
      if (d2 > 0.0D) {
        if (d2 >= 100.0D)
        {
          d1 = 256.0D;
        }
        else
        {
          int i = (int)d2;
          float f1;
          if (i == 0) {
            f1 = 0.0F;
          } else {
            f1 = (float)arrayOfLong[i];
          }
          float f2;
          if (i < 99) {
            f2 = (float)arrayOfLong[(i + 1)];
          } else {
            f2 = 256.0F;
          }
          d1 = f1;
          double d3 = f2 - f1;
          double d4 = i;
          Double.isNaN(d4);
          Double.isNaN(d3);
          Double.isNaN(d1);
          d1 += d3 * (d2 - d4);
        }
      }
      d2 = l1;
      Double.isNaN(d2);
      l2 = Math.round(d1 * 0.00390625D * d2) + l3;
      l1 = l3 + l1 - 1L;
      paramLong = l1;
      if (paramMp3Info.idv2Size > 0) {
        paramLong = l1 - paramMp3Info.idv2Size;
      }
      if (l2 < paramLong) {
        return l2;
      }
      return paramLong;
    }
    return -1L;
  }
  
  public void parse(IDataSource paramIDataSource)
  {
    Mp3FrameInfoParse.parseFrameInfo(new TrackPositionDataSource(paramIDataSource), this.mInfo);
  }
  
  public long seek(long paramLong)
  {
    if (paramLong < 0L) {
      return -1L;
    }
    int i = this.mInfo.VBRType;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return -1L;
        }
        return timeToBytePositionInXingVbr(this.mInfo, paramLong);
      }
      return timeToBytePositionInVBRIVbr(this.mInfo, paramLong);
    }
    return timeToBytePositionInCbr(this.mInfo, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3SeekTable
 * JD-Core Version:    0.7.0.1
 */