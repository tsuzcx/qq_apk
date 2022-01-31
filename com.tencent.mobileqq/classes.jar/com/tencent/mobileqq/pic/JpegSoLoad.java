package com.tencent.mobileqq.pic;

import android.content.Context;
import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class JpegSoLoad
{
  public static final int FILE_NOT_FIND = -2;
  public static final int INVALID_PARAM = -1;
  private static final String JPEG_SO_LIB = "/jpeglib/";
  public static final int LOAD_ERROR = -3;
  public static final int LOAD_SUCCESS = 0;
  private static final String PKG_NAME = "com.tencent.mobileqq";
  public static final String SO_NAME = "jpegc_above820";
  
  public static int LoadJpegExtractedSo(String paramString, Context paramContext)
  {
    int j = 0;
    if (paramString == null) {
      return -1;
    }
    paramContext = getJpegSolibPath(paramContext);
    paramContext = paramContext + getLibActualName(paramString);
    int i;
    if (!new File(paramContext).exists())
    {
      i = -2;
      if (i == 0) {
        break label138;
      }
    }
    label138:
    for (;;)
    {
      for (;;)
      {
        try
        {
          System.loadLibrary(paramString);
          i = j;
        }
        catch (UnsatisfiedLinkError paramString)
        {
          continue;
        }
        QLog.d("JpegSoLoad", 2, "LoadJpegExtractedSo:" + i + " path:" + paramContext + " length:" + new File(paramContext).length());
        return i;
        try
        {
          System.load(paramContext);
          i = 0;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          i = -3;
        }
      }
      break;
    }
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
  
  public static String getLibActualName(String paramString)
  {
    return "lib" + paramString + ".so";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegSoLoad
 * JD-Core Version:    0.7.0.1
 */