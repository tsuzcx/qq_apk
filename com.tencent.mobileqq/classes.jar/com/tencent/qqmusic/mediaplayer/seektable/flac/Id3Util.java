package com.tencent.qqmusic.mediaplayer.seektable.flac;

public class Id3Util
{
  public static int synchsafe(int paramInt)
  {
    int k = 0;
    int i = 127;
    int j = paramInt;
    for (paramInt = k; (0x7FFFFFFF ^ i) > 0; paramInt = j)
    {
      j = j & i | ((i ^ 0xFFFFFFFF) & j) << 1;
      i = (i + 1 << 8) - 1;
    }
    return paramInt;
  }
  
  public static int unsynchsafe(int paramInt)
  {
    int j = 0;
    int i = 2130706432;
    while (i > 0)
    {
      j = j >> 1 | paramInt & i;
      i >>= 8;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.flac.Id3Util
 * JD-Core Version:    0.7.0.1
 */