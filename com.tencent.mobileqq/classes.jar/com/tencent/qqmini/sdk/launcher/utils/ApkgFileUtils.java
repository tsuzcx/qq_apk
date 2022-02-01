package com.tencent.qqmini.sdk.launcher.utils;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class ApkgFileUtils
{
  public static String TAG = "ApkgFileUtils";
  
  public static HashMap<String, ApkgFileUtils.WxapkgFile> getFileMapFromApkg(File paramFile)
  {
    if (!isApkgFileExist(paramFile)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
      if (localRandomAccessFile.readByte() == -66)
      {
        localRandomAccessFile.seek(14L);
        int j = localRandomAccessFile.readInt();
        int i = 0;
        while (i < j)
        {
          int k = localRandomAccessFile.readInt();
          paramFile = new byte[k];
          localRandomAccessFile.read(paramFile, 0, k);
          String str = new File(new String(paramFile, 0, k)).getAbsolutePath();
          paramFile = str;
          if (str.charAt(0) == '/') {
            paramFile = str.substring(1);
          }
          localHashMap.put(paramFile, new ApkgFileUtils.WxapkgFile(paramFile, localRandomAccessFile.readInt(), localRandomAccessFile.readInt()));
          i += 1;
        }
      }
      throw new RuntimeException("File type error");
    }
    catch (Throwable paramFile)
    {
      QMLog.e(TAG, "getFileMapFromApkg fail", paramFile);
    }
    return localHashMap;
  }
  
  public static boolean isApkgFileExist(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory())
      {
        if (paramFile.canRead()) {
          return true;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("File '");
        localStringBuilder.append(paramFile);
        localStringBuilder.append("' cannot be read");
        throw new IOException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("File '");
      localStringBuilder.append(paramFile);
      localStringBuilder.append("' exists but is a directory");
      throw new IOException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("File '");
    localStringBuilder.append(paramFile);
    localStringBuilder.append("' does not exist");
    throw new FileNotFoundException(localStringBuilder.toString());
  }
  
  public static byte[] readApkgToByte(File paramFile, int paramInt1, int paramInt2)
  {
    if (!isApkgFileExist(paramFile)) {
      return null;
    }
    try
    {
      paramFile = new RandomAccessFile(paramFile, "r");
      paramFile.seek(paramInt1);
      byte[] arrayOfByte = new byte[paramInt2];
      paramFile.read(arrayOfByte, 0, paramInt2);
      return arrayOfByte;
    }
    catch (Throwable paramFile)
    {
      QMLog.e(TAG, "readApkgToByte fail", paramFile);
    }
    return null;
  }
  
  public static String readApkgToStr(File paramFile, int paramInt1, int paramInt2)
  {
    if (paramFile != null) {
      try
      {
        if (paramFile.exists())
        {
          paramFile = readApkgToString(paramFile, paramInt1, paramInt2);
          return paramFile;
        }
      }
      catch (Throwable paramFile)
      {
        QMLog.e(TAG, "readApkgToStr fail", paramFile);
        return "";
      }
    }
    return null;
  }
  
  public static ByteArrayInputStream readApkgToStream(File paramFile, int paramInt1, int paramInt2)
  {
    if (paramFile != null) {
      try
      {
        if (!paramFile.exists()) {
          return null;
        }
        paramFile = readToStream(paramFile, paramInt1, paramInt2);
        return paramFile;
      }
      catch (Throwable paramFile)
      {
        QMLog.e(TAG, "readToStream fail", paramFile);
      }
    }
    return null;
  }
  
  public static String readApkgToString(File paramFile, int paramInt1, int paramInt2)
  {
    paramFile = readApkgToByte(paramFile, paramInt1, paramInt2);
    if (paramFile != null) {
      return new String(paramFile);
    }
    return null;
  }
  
  public static ByteArrayInputStream readToStream(File paramFile, int paramInt1, int paramInt2)
  {
    paramFile = readApkgToByte(paramFile, paramInt1, paramInt2);
    if (paramFile != null) {
      return new ByteArrayInputStream(paramFile);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.ApkgFileUtils
 * JD-Core Version:    0.7.0.1
 */