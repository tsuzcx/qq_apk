package com.tencent.mobileqq.pic;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public final class JpegSoLoad
{
  public static final int FILE_NOT_FIND = -2;
  public static final int INVALID_PARAM = -1;
  private static final String JPEG_SO_LIB = "/jpeglib/";
  public static final int LOAD_ERROR = -3;
  public static final int LOAD_SUCCESS = 0;
  private static final String PKG_NAME = "com.tencent.mobileqq";
  public static final String SO_NAME = "jpegc_above665";
  
  public static int LoadJpegExtractedSo(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    String str = getJpegSolibPath(null) + getLibActualName(paramString);
    int i;
    if (!new File(str).exists()) {
      i = -2;
    }
    while (i != 0)
    {
      try
      {
        System.loadLibrary(paramString);
        return 0;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        return i;
      }
      try
      {
        System.load(str);
        i = 0;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        i = -3;
      }
    }
    return i;
  }
  
  public static String getJpegSolibPath(Context paramContext)
  {
    if (paramContext == null) {
      return Environment.getDataDirectory() + "/data/" + "com.tencent.mobileqq" + "/jpeglib/";
    }
    File localFile = paramContext.getFilesDir();
    if (localFile != null) {
      return localFile.getParent() + "/jpeglib/";
    }
    return Environment.getDataDirectory() + "/data/" + paramContext.getPackageName() + "/jpeglib/";
  }
  
  private static String getLibActualName(String paramString)
  {
    return "lib" + paramString + ".so";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegSoLoad
 * JD-Core Version:    0.7.0.1
 */