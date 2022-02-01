package com.tencent.video.decode;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class ShortVideoSoLoad
{
  private static String DEFAULT_SHORT_VIDEO_PATH;
  private static String PKG_NAME = "com.tencent.mobileqq";
  private static final String SHORT_VIDEO_SO_LIB = "/app_lib/QzoneVideoPlugin/";
  public static final int VIDEO_FILE_NOT_FIND = -2;
  public static final int VIDEO_INVALID_PARAM = -1;
  public static final int VIDEO_LOAD_ERROR = -3;
  public static final int VIDEO_LOAD_SUCCESS = 0;
  public static final int VIDEO_LOAD_UNINIT = -4;
  private static int VIDEO_SO_LOAD_STATUS = -4;
  public static final int VIDEO_SO_VERSION_ERR = -5;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getDataDirectory());
    localStringBuilder.append("/data/");
    localStringBuilder.append(PKG_NAME);
    localStringBuilder.append("/app_lib/QzoneVideoPlugin/");
    DEFAULT_SHORT_VIDEO_PATH = localStringBuilder.toString();
  }
  
  public static int LoadExtractedShortVideo(String paramString)
  {
    label62:
    try
    {
      if (VIDEO_SO_LOAD_STATUS == 0)
      {
        i = VIDEO_SO_LOAD_STATUS;
        return i;
      }
      if (paramString == null)
      {
        VIDEO_SO_LOAD_STATUS = -1;
        return -1;
      }
      boolean bool = new File(paramString).exists();
      if (!bool) {
        i = -2;
      }
    }
    finally {}
    try
    {
      System.load(paramString);
      i = 0;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      break label62;
    }
    int i = -3;
    VIDEO_SO_LOAD_STATUS = i;
    return i;
  }
  
  public static int getShortVideoSoLoadStatus()
  {
    try
    {
      int i = VIDEO_SO_LOAD_STATUS;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getShortVideoSoPath(Context paramContext)
  {
    if (paramContext == null) {
      return DEFAULT_SHORT_VIDEO_PATH;
    }
    paramContext = paramContext.getFilesDir();
    if (paramContext != null)
    {
      paramContext = new StringBuilder(String.valueOf(paramContext.getParent()));
      paramContext.append("/app_lib/QzoneVideoPlugin/");
      return paramContext.toString();
    }
    return DEFAULT_SHORT_VIDEO_PATH;
  }
  
  public static void setDefaultPackageName(String paramString)
  {
    try
    {
      PKG_NAME = paramString;
      paramString = new StringBuilder();
      paramString.append(Environment.getDataDirectory());
      paramString.append("/data/");
      paramString.append(PKG_NAME);
      paramString.append("/app_lib/QzoneVideoPlugin/");
      DEFAULT_SHORT_VIDEO_PATH = paramString.toString();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void setShortVideoSoLoadStatus(int paramInt)
  {
    try
    {
      VIDEO_SO_LOAD_STATUS = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.video.decode.ShortVideoSoLoad
 * JD-Core Version:    0.7.0.1
 */