package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.qqmusic.mediaplayer.util.Logger;

class Mp3FrameInfoParse
{
  private static final int[][][] BitrateTable;
  private static final int DECODE_ERROR_IO_READ = -3;
  private static final int DECODE_ERROR_MEMORY_ALLOC = -2;
  private static final int DECODE_ERROR_SUCCESS = 0;
  private static final int DECODE_FAIL = -1;
  private static final int[][] SAMPLE_PER_FRAME = { { 384, 1152, 1152 }, { 384, 1152, 576 }, { 384, 1152, 576 } };
  private static final int[][] SAMPLE_RATE_TABLE;
  private static final String TAG = "Mp3FrameInfoParse";
  public static final int VBR_TYPE_CBR = 0;
  public static final int VBR_TYPE_VBRI = 1;
  public static final int VBR_TYPE_XING = 2;
  
  static
  {
    int[] arrayOfInt1 = { 0, 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384 };
    BitrateTable = new int[][][] { { { 0, 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448 }, arrayOfInt1, { 0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320 } }, { { 0, 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256 }, { 0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 }, { 0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 } } };
    arrayOfInt1 = new int[] { 0, 0, 0 };
    int[] arrayOfInt2 = { 44100, 48000, 32000 };
    SAMPLE_RATE_TABLE = new int[][] { { 11025, 12000, 8000 }, arrayOfInt1, { 22050, 24000, 16000 }, arrayOfInt2 };
  }
  
  private static boolean IsMp3Header(TrackPositionDataSource paramTrackPositionDataSource, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Mp3FrameInfoParse.Mp3Info paramMp3Info)
  {
    if ((paramArrayOfByte != null) && (paramMp3Info != null))
    {
      int i = paramInt2 + 1;
      int k = paramArrayOfByte[i] >> 3 & 0x3;
      if (1 == k) {
        return false;
      }
      i = paramArrayOfByte[i] >> 1 & 0x3;
      if (i == 0) {
        return false;
      }
      int n = 4 - i;
      i = paramInt2 + 2;
      int i1 = paramArrayOfByte[i] >> 4 & 0xF;
      if (15 == i1) {
        return false;
      }
      int i2 = paramArrayOfByte[i] >> 2 & 0x3;
      if (3 == i2) {
        return false;
      }
      int m = paramArrayOfByte[(paramInt2 + 3)];
      int i3 = paramArrayOfByte[i] >> 1 & 0x1;
      if (k == 3) {
        i = 0;
      } else {
        i = 1;
      }
      int j;
      if (1 == n)
      {
        j = BitrateTable[i][0][i1] * 12000 / SAMPLE_RATE_TABLE[k][i2] + i3 << 2;
      }
      else
      {
        if (2 == n) {
          j = BitrateTable[i][1][i1] * 144000 / SAMPLE_RATE_TABLE[k][i2];
        } else {
          j = BitrateTable[i][2][i1] * 144000 / (SAMPLE_RATE_TABLE[k][i2] << i);
        }
        j += i3;
      }
      if (j > 0)
      {
        long l1 = paramTrackPositionDataSource.getCurPosition();
        long l2 = paramInt1;
        long l3 = paramInt2;
        long l4 = j;
        if (paramTrackPositionDataSource.seek(l1 - l2 + l3 + l4) < 0L) {
          return false;
        }
        byte[] arrayOfByte = new byte[4];
        if (paramTrackPositionDataSource.read(arrayOfByte, 4) == -1) {
          return false;
        }
        paramInt1 = Mp3DecodeBase.readInt(paramArrayOfByte, paramInt2, 4);
        paramInt2 = Mp3DecodeBase.readInt(arrayOfByte, 4);
        paramTrackPositionDataSource.seek(l1);
        if ((paramInt1 != 0) && (paramInt2 != 0) && ((paramInt1 & 0xFFFE0C00) == (paramInt2 & 0xFFFE0C00)))
        {
          paramTrackPositionDataSource = new StringBuilder();
          paramTrackPositionDataSource.append("FirstFrameSize = ");
          paramTrackPositionDataSource.append(j);
          Logger.i("Mp3FrameInfoParse", paramTrackPositionDataSource.toString());
          paramMp3Info.firstFrameSize = l4;
          if (k == 3) {}
          do
          {
            paramInt1 = 0;
            break;
            if (k == 2)
            {
              paramInt1 = 1;
              break;
            }
          } while (k != 0);
          paramInt1 = 2;
          paramInt2 = 2;
          paramMp3Info.mpeg_version = paramInt1;
          paramMp3Info.layer = n;
          paramMp3Info.sample_rate = SAMPLE_RATE_TABLE[k][i2];
          paramMp3Info.bit_rate = BitrateTable[i][(n - 1)][i1];
          paramInt1 = paramInt2;
          if ((m >> 6 & 0x3) == 3) {
            paramInt1 = 1;
          }
          paramMp3Info.channels = paramInt1;
          return true;
        }
        return false;
      }
      paramMp3Info.firstFrameSize = -1L;
      return false;
    }
    return false;
  }
  
  public static int parseFrameInfo(TrackPositionDataSource paramTrackPositionDataSource, Mp3FrameInfoParse.Mp3Info paramMp3Info)
  {
    int j = -1;
    if (paramTrackPositionDataSource == null) {
      return -1;
    }
    Object localObject = new byte[1024];
    if (paramTrackPositionDataSource.read((byte[])localObject, 1024) < 1024) {
      return -2;
    }
    if (Mp3DecodeBase.hasId3v2((byte[])localObject, 4))
    {
      Logger.i("Mp3FrameInfoParse", "hasId3v2");
      skipId3v2(paramTrackPositionDataSource, (byte[])localObject, paramMp3Info);
    }
    else
    {
      paramTrackPositionDataSource.seek(0L);
    }
    long l2 = paramTrackPositionDataSource.getSize();
    long l4 = paramMp3Info.idv2Size;
    long l1 = l2;
    if (l4 > 0L)
    {
      l1 = l2;
      if (l2 > l4) {
        l1 = l2 - l4;
      }
    }
    int k = 0;
    long l3 = paramTrackPositionDataSource.getCurPosition();
    l2 = l3;
    if (l4 > 0L) {
      l2 = l3 - l4;
    }
    if (l2 >= l1 / 10L) {
      return -3;
    }
    if ((k >= 3) && (paramTrackPositionDataSource.seek(paramTrackPositionDataSource.getCurPosition() - 3L) < 0L)) {
      return -3;
    }
    int n = paramTrackPositionDataSource.read((byte[])localObject, 1024);
    if (n == j)
    {
      paramMp3Info.firstFramePosition = -1L;
      return -3;
    }
    int m = k + n;
    int i = 0;
    for (;;)
    {
      k = m;
      if (i + 4 > n) {
        break;
      }
      if ((255 == (localObject[i] & 0xFF)) && (224 == (localObject[(i + 1)] & 0xE0)) && (IsMp3Header(paramTrackPositionDataSource, (byte[])localObject, 1024, i, paramMp3Info)))
      {
        paramMp3Info.firstFramePosition = (paramMp3Info.idv2Size + m - n + i);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("FirstFramePos = ");
        ((StringBuilder)localObject).append(paramMp3Info.firstFramePosition);
        Logger.i("Mp3FrameInfoParse", ((StringBuilder)localObject).toString());
        if (paramTrackPositionDataSource.seek(paramMp3Info.firstFramePosition) < 0L) {
          return -1;
        }
        boolean bool = parseVBRFrameInfo(paramTrackPositionDataSource, paramMp3Info);
        if (paramTrackPositionDataSource.seek(0L) >= 0L)
        {
          if (!bool) {
            return -1;
          }
          return 0;
        }
        return -1;
      }
      j = -1;
      i += 1;
    }
  }
  
  private static boolean parseVBRFrameInfo(TrackPositionDataSource paramTrackPositionDataSource, Mp3FrameInfoParse.Mp3Info paramMp3Info)
  {
    if (paramTrackPositionDataSource != null)
    {
      if (paramMp3Info == null) {
        return false;
      }
      long l2 = paramMp3Info.sample_rate;
      int i = paramMp3Info.channels;
      byte[] arrayOfByte = new byte[1024];
      int j = paramMp3Info.mpeg_version;
      long l1 = 21L;
      if (j == 0)
      {
        if (i != 1) {
          l1 = 36L;
        }
      }
      else if (i == 1) {
        l1 = 13L;
      }
      if (paramTrackPositionDataSource.seek(paramTrackPositionDataSource.getCurPosition() + l1) < 0L) {
        return false;
      }
      if (paramTrackPositionDataSource.read(arrayOfByte, 1024) < 1024) {
        return false;
      }
      if (Mp3DecodeBase.isXingVBRheader(arrayOfByte, 4))
      {
        Logger.i("Mp3FrameInfoParse", "is Xing VBR");
        paramMp3Info.VBRType = 2;
        paramMp3Info.isVbr = 1;
        parseXingInfo(arrayOfByte, l2, paramMp3Info);
      }
      for (;;)
      {
        return true;
        if (paramTrackPositionDataSource.seek(paramTrackPositionDataSource.getCurPosition() - (l1 + 1024)) < 0L) {
          return false;
        }
        if (paramTrackPositionDataSource.seek(paramTrackPositionDataSource.getCurPosition() + 36L) < 0L) {
          return false;
        }
        if (paramTrackPositionDataSource.read(arrayOfByte, 1024) < 1024) {
          return false;
        }
        if (Mp3DecodeBase.isVBRIVBRHeader(arrayOfByte, 4))
        {
          Logger.i("Mp3FrameInfoParse", "is VBRI VBR");
          paramMp3Info.VBRType = 1;
          paramMp3Info.isVbr = 1;
          parseVBRIInfo(paramMp3Info, arrayOfByte, l2);
        }
        else
        {
          Logger.i("Mp3FrameInfoParse", "is CBR");
          paramMp3Info.VBRType = 0;
          l1 = paramTrackPositionDataSource.getSize();
          if (paramMp3Info.fileLengthInBytes <= 0L) {
            paramMp3Info.fileLengthInBytes = l1;
          }
          paramMp3Info.duration = (((float)(paramMp3Info.fileLengthInBytes - paramMp3Info.idv2Size) * 8.0F / paramMp3Info.bit_rate));
        }
      }
    }
    return false;
  }
  
  private static void parseVBRIInfo(Mp3FrameInfoParse.Mp3Info paramMp3Info, byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayOfByte != null)
    {
      if (paramMp3Info == null) {
        return;
      }
      long l1 = Mp3DecodeBase.readLong(paramArrayOfByte, 10, 4);
      paramMp3Info.fileLengthInBytes = l1;
      long l2 = Mp3DecodeBase.readLong(paramArrayOfByte, 14, 4);
      int i;
      int j;
      if ((l2 > 0L) && (paramLong > 0L))
      {
        i = paramMp3Info.mpeg_version;
        j = paramMp3Info.layer;
        paramMp3Info.lengthInFrames = l2;
        double d1 = l2 * SAMPLE_PER_FRAME[i][(j - 1)];
        Double.isNaN(d1);
        double d2 = paramLong;
        Double.isNaN(d2);
        paramMp3Info.duration = ((d1 * 1.0D / d2 * 1000.0D));
      }
      int i1 = Mp3DecodeBase.readShort(paramArrayOfByte, 18, 2);
      int i2 = Mp3DecodeBase.readShort(paramArrayOfByte, 20, 2);
      int i3 = Mp3DecodeBase.readShort(paramArrayOfByte, 22, 2);
      int k = 24;
      if ((i1 > 0) && (i2 > 0))
      {
        int i4 = i1 + 1;
        long[] arrayOfLong1 = new long[i4];
        j = 0;
        paramLong = l1;
        if (paramMp3Info.firstFramePosition > 0L) {
          j = (int)(0 + paramMp3Info.firstFramePosition);
        }
        i = j;
        if (paramMp3Info.firstFrameSize > 0L) {
          i = (int)(j + paramMp3Info.firstFrameSize);
        }
        int n = 1;
        int m = i;
        j = k;
        k = n;
        long[] arrayOfLong2;
        for (;;)
        {
          arrayOfLong2 = arrayOfLong1;
          if (k >= i4) {
            break;
          }
          i = -1;
          if (i3 == 1)
          {
            i = Mp3DecodeBase.readByte(paramArrayOfByte, j, 1);
            j += 1;
          }
          for (;;)
          {
            break;
            if (i3 == 2)
            {
              i = Mp3DecodeBase.readShort(paramArrayOfByte, j, 2);
              j += 2;
            }
            else if (i3 == 3)
            {
              i = Mp3DecodeBase.readUnsignedInt24(paramArrayOfByte, j, 3);
              j += 3;
            }
            else if (i3 == 4)
            {
              i = Mp3DecodeBase.readInt(paramArrayOfByte, j, 4);
              j += 4;
            }
            else
            {
              arrayOfLong1 = null;
            }
          }
          if (i < 0)
          {
            arrayOfLong2 = arrayOfLong1;
            break;
          }
          i = m + i * i2;
          if (i >= paramLong) {
            i = (int)paramLong;
          }
          arrayOfLong1[k] = i;
          k += 1;
          m = i;
        }
        paramMp3Info.entry_count = i1;
        paramMp3Info.entry_size = i3;
        paramMp3Info.scale_factor = i2;
        paramMp3Info.toc_table = arrayOfLong2;
      }
    }
  }
  
  private static void parseXingInfo(byte[] paramArrayOfByte, long paramLong, Mp3FrameInfoParse.Mp3Info paramMp3Info)
  {
    if (paramArrayOfByte != null)
    {
      if (paramMp3Info == null) {
        return;
      }
      Object localObject = null;
      int k = Mp3DecodeBase.readInt(paramArrayOfByte, 4, 4);
      int i = 8;
      if ((k & 0x1) == 1)
      {
        long l = Mp3DecodeBase.readLong(paramArrayOfByte, 8, 4) - 1L;
        if ((l > 0L) && (paramLong > 0L))
        {
          i = paramMp3Info.mpeg_version;
          j = paramMp3Info.layer;
          paramMp3Info.lengthInFrames = l;
          double d1 = l * SAMPLE_PER_FRAME[i][(j - 1)];
          Double.isNaN(d1);
          double d2 = paramLong;
          Double.isNaN(d2);
          paramMp3Info.duration = ((d1 * 1.0D / d2 * 1000.0D));
        }
        i = 12;
      }
      int j = i;
      if ((k & 0x2) == 2)
      {
        paramMp3Info.fileLengthInBytes = Mp3DecodeBase.readLong(paramArrayOfByte, i, 4);
        j = i + 4;
      }
      if ((k & 0x4) == 4)
      {
        long[] arrayOfLong = new long[100];
        i = 0;
        for (;;)
        {
          localObject = arrayOfLong;
          if (i >= 100) {
            break;
          }
          arrayOfLong[i] = (paramArrayOfByte[(i + j)] & 0xFF);
          i += 1;
        }
      }
      if ((k > 0) && (localObject != null))
      {
        paramMp3Info.toc_table = localObject;
        paramMp3Info.flag_value = k;
      }
    }
  }
  
  private static void skipId3v2(TrackPositionDataSource paramTrackPositionDataSource, byte[] paramArrayOfByte, Mp3FrameInfoParse.Mp3Info paramMp3Info)
  {
    if (paramTrackPositionDataSource != null)
    {
      if (paramArrayOfByte == null) {
        return;
      }
      if ((paramArrayOfByte[0] == 73) && (paramArrayOfByte[1] == 68) && (paramArrayOfByte[2] == 51))
      {
        int i = ((paramArrayOfByte[6] & 0x7F) << 21) + ((paramArrayOfByte[7] & 0x7F) << 14) + ((paramArrayOfByte[8] & 0x7F) << 7) + (paramArrayOfByte[9] & 0x7F);
        int k;
        if ((paramArrayOfByte[5] & 0x10) != 0)
        {
          i += 20;
          k = 1;
        }
        else
        {
          i += 10;
          k = 0;
        }
        if (paramTrackPositionDataSource.seek(i) < 0L) {
          return;
        }
        int j = i;
        if (k == 0)
        {
          paramArrayOfByte = new byte[1];
          for (k = paramTrackPositionDataSource.read(paramArrayOfByte, 1);; k = paramTrackPositionDataSource.read(paramArrayOfByte, 1))
          {
            j = i;
            if (paramArrayOfByte[0] != 0) {
              break;
            }
            j = i;
            if (k != 1) {
              break;
            }
            i += 1;
          }
        }
        paramMp3Info.idv2Size = j;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("id3V2 Size: ");
        paramArrayOfByte.append(paramMp3Info.idv2Size);
        Logger.i("Mp3FrameInfoParse", paramArrayOfByte.toString());
        paramTrackPositionDataSource.seek(j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3FrameInfoParse
 * JD-Core Version:    0.7.0.1
 */