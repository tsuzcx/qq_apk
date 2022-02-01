package com.tencent.video.decode;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class ShortVideoSoLoad
{
  private static String DEFAULT_SHORT_VIDEO_PATH = Environment.getDataDirectory() + "/data/" + PKG_NAME + "/app_lib/QzoneVideoPlugin/";
  private static String PKG_NAME = "com.tencent.mobileqq";
  private static final String SHORT_VIDEO_SO_LIB = "/app_lib/QzoneVideoPlugin/";
  public static final int VIDEO_FILE_NOT_FIND = -2;
  public static final int VIDEO_INVALID_PARAM = -1;
  public static final int VIDEO_LOAD_ERROR = -3;
  public static final int VIDEO_LOAD_SUCCESS = 0;
  public static final int VIDEO_LOAD_UNINIT = -4;
  private static int VIDEO_SO_LOAD_STATUS = -4;
  public static final int VIDEO_SO_VERSION_ERR = -5;
  
  public static int LoadExtractedShortVideo(String paramString)
  {
    try
    {
      if (VIDEO_SO_LOAD_STATUS == 0) {
        i = VIDEO_SO_LOAD_STATUS;
      }
      for (;;)
      {
        return i;
        if (paramString != null) {
          break;
        }
        i = -1;
        VIDEO_SO_LOAD_STATUS = -1;
      }
      if (new File(paramString).exists()) {
        break label61;
      }
    }
    finally {}
    int i = -2;
    for (;;)
    {
      VIDEO_SO_LOAD_STATUS = i;
      break;
      try
      {
        label61:
        System.load(paramString);
        i = 0;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        i = -3;
      }
    }
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
    if (paramContext != null) {
      return paramContext.getParent() + "/app_lib/QzoneVideoPlugin/";
    }
    return DEFAULT_SHORT_VIDEO_PATH;
  }
  
  public static void setDefaultPackageName(String paramString)
  {
    try
    {
      PKG_NAME = paramString;
      DEFAULT_SHORT_VIDEO_PATH = Environment.getDataDirectory() + "/data/" + PKG_NAME + "/app_lib/QzoneVideoPlugin/";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.video.decode.ShortVideoSoLoad
 * JD-Core Version:    0.7.0.1
 */