package com.tencent.qqmusic.mediaplayer.seektable.mp3;

class Mp3DecodeBase
{
  static boolean hasId3v2(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt < 3) {
        return false;
      }
      if ((paramArrayOfByte[0] == 73) && (paramArrayOfByte[1] == 68) && (paramArrayOfByte[2] == 51)) {
        return true;
      }
    }
    return false;
  }
  
  static boolean isVBRIVBRHeader(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt < 4) {
        return false;
      }
      if ((paramArrayOfByte[0] == 86) && (paramArrayOfByte[1] == 66) && (paramArrayOfByte[2] == 82) && (paramArrayOfByte[3] == 73)) {
        return true;
      }
    }
    return false;
  }
  
  static boolean isXingVBRheader(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt < 4) {
        return false;
      }
      if ((paramArrayOfByte[0] == 88) && (paramArrayOfByte[1] == 105) && (paramArrayOfByte[2] == 110) && (paramArrayOfByte[3] == 103)) {
        return true;
      }
      if ((paramArrayOfByte[0] == 73) && (paramArrayOfByte[1] == 110) && (paramArrayOfByte[2] == 102) && (paramArrayOfByte[3] == 111)) {
        return true;
      }
    }
    return false;
  }
  
  static int readByte(byte[] paramArrayOfByte, int paramInt)
  {
    return readByte(paramArrayOfByte, 0, paramInt);
  }
  
  static int readByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt2 >= 1) && (paramArrayOfByte.length >= paramInt2 + paramInt1)) {
      return paramArrayOfByte[paramInt1] & 0xFF;
    }
    return -1;
  }
  
  static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    return readInt(paramArrayOfByte, 0, paramInt);
  }
  
  static int readInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt2 >= 4) && (paramArrayOfByte.length >= paramInt2 + paramInt1))
    {
      paramInt2 = paramArrayOfByte[paramInt1];
      int i = paramArrayOfByte[(paramInt1 + 1)];
      int j = paramArrayOfByte[(paramInt1 + 2)];
      return paramArrayOfByte[(paramInt1 + 3)] & 0xFF | (paramInt2 & 0xFF) << 24 | (i & 0xFF) << 16 | (j & 0xFF) << 8;
    }
    return -1;
  }
  
  static long readLong(byte[] paramArrayOfByte, int paramInt)
  {
    return readLong(paramArrayOfByte, 0, paramInt);
  }
  
  static long readLong(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt2 >= 4) && (paramArrayOfByte.length >= paramInt2 + paramInt1))
    {
      paramInt2 = paramArrayOfByte[paramInt1];
      int i = paramArrayOfByte[(paramInt1 + 1)];
      int j = paramArrayOfByte[(paramInt1 + 2)];
      return paramArrayOfByte[(paramInt1 + 3)] & 0xFF | (paramInt2 & 0xFF) << 24 | (i & 0xFF) << 16 | (j & 0xFF) << 8;
    }
    return -1L;
  }
  
  static int readShort(byte[] paramArrayOfByte, int paramInt)
  {
    return readShort(paramArrayOfByte, 0, paramInt);
  }
  
  static int readShort(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt2 >= 2) && (paramArrayOfByte.length >= paramInt2 + paramInt1))
    {
      paramInt2 = paramArrayOfByte[paramInt1];
      return paramArrayOfByte[(paramInt1 + 1)] & 0xFF | (paramInt2 & 0xFF) << 8;
    }
    return -1;
  }
  
  static int readUnsignedInt24(byte[] paramArrayOfByte, int paramInt)
  {
    return readUnsignedInt24(paramArrayOfByte, 0, paramInt);
  }
  
  static int readUnsignedInt24(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt2 >= 3) && (paramArrayOfByte.length >= paramInt2 + paramInt1))
    {
      paramInt2 = paramArrayOfByte[paramInt1];
      int i = paramArrayOfByte[(paramInt1 + 1)];
      return paramArrayOfByte[(paramInt1 + 2)] & 0xFF | (paramInt2 & 0xFF) << 16 | (i & 0xFF) << 8;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3DecodeBase
 * JD-Core Version:    0.7.0.1
 */