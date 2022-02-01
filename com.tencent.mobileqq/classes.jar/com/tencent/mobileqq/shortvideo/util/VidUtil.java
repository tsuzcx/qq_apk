package com.tencent.mobileqq.shortvideo.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class VidUtil
{
  private static final SimpleDateFormat sVidSimpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINESE);
  
  public static String generateVid()
  {
    synchronized (sVidSimpleDateFormat)
    {
      int i = new Random().nextInt(10000);
      String str = sVidSimpleDateFormat.format(new Date()) + "_" + i;
      return str;
    }
  }
  
  public static String getVidFromSourceDirFile(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    return paramFile.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.VidUtil
 * JD-Core Version:    0.7.0.1
 */