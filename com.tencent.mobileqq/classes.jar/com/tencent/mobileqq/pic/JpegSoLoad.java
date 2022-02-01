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
    if (paramString == null) {
      return -1;
    }
    paramContext = getJpegSolibPath(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(getLibActualName(paramString));
    paramContext = localStringBuilder.toString();
    if (!new File(paramContext).exists()) {
      i = -2;
    }
    try
    {
      System.load(paramContext);
      i = 0;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label72:
      break label72;
    }
    i = -3;
    j = i;
    if (i != 0) {}
    try
    {
      System.loadLibrary(paramString);
      j = 0;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        j = i;
      }
    }
    paramString = new StringBuilder();
    paramString.append("LoadJpegExtractedSo:");
    paramString.append(j);
    paramString.append(" path:");
    paramString.append(paramContext);
    paramString.append(" length:");
    paramString.append(new File(paramContext).length());
    QLog.d("JpegSoLoad", 2, paramString.toString());
    return j;
  }
  
  public static String getJpegSolibPath(Context paramContext)
  {
    if (paramContext == null)
    {
      paramContext = new StringBuilder();
      paramContext.append(Environment.getDataDirectory());
      paramContext.append("/data/");
      paramContext.append("com.tencent.mobileqq");
      paramContext.append("/jpeglib/");
      return paramContext.toString();
    }
    Object localObject = paramContext.getFilesDir();
    if (localObject != null)
    {
      paramContext = new StringBuilder();
      paramContext.append(((File)localObject).getParent());
      paramContext.append("/jpeglib/");
      return paramContext.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getDataDirectory());
    ((StringBuilder)localObject).append("/data/");
    ((StringBuilder)localObject).append(paramContext.getPackageName());
    ((StringBuilder)localObject).append("/jpeglib/");
    return ((StringBuilder)localObject).toString();
  }
  
  public static String getLibActualName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegSoLoad
 * JD-Core Version:    0.7.0.1
 */