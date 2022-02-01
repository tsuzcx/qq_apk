package com.tencent.richmediabrowser.utils;

public class FileUtils
{
  public static String stringForTime(long paramLong)
  {
    int k = (int)paramLong / 1000;
    int i = k % 60;
    int j = k / 60 % 60;
    k /= 3600;
    if (k > 0) {
      return String.format("%d:%02d:%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }).toString();
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */