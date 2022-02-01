package de.robv.android.xposed.services;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public abstract class BaseService
{
  public static final int F_OK = 0;
  public static final int R_OK = 4;
  public static final int W_OK = 2;
  public static final int X_OK = 1;
  
  static void ensureAbsolutePath(String paramString)
  {
    if (!paramString.startsWith("/")) {
      throw new IllegalArgumentException("Only absolute filenames are allowed: " + paramString);
    }
  }
  
  static void throwCommonIOException(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      if (paramString1 == null) {
        break;
      }
    }
    for (;;)
    {
      throw new IOException(paramString1);
      if (paramString1 != null) {}
      for (;;)
      {
        throw new FileNotFoundException(paramString1);
        paramString1 = "Permission denied: " + paramString2;
      }
      if (paramString1 != null) {}
      for (;;)
      {
        throw new FileNotFoundException(paramString1);
        paramString1 = "No such file or directory: " + paramString2;
      }
      throw new OutOfMemoryError(paramString1);
      if (paramString1 != null) {}
      for (;;)
      {
        throw new FileNotFoundException(paramString1);
        paramString1 = "Is a directory: " + paramString2;
      }
      paramString1 = "Error " + paramInt + paramString3 + paramString2;
    }
  }
  
  public abstract boolean checkFileAccess(String paramString, int paramInt);
  
  public boolean checkFileExists(String paramString)
  {
    return checkFileAccess(paramString, 0);
  }
  
  public FileResult getFileInputStream(String paramString, long paramLong1, long paramLong2)
  {
    paramString = readFile(paramString, paramLong1, paramLong2);
    if (paramString.content == null) {
      return paramString;
    }
    return new FileResult(new ByteArrayInputStream(paramString.content), paramString.size, paramString.mtime);
  }
  
  public InputStream getFileInputStream(String paramString)
  {
    return new ByteArrayInputStream(readFile(paramString));
  }
  
  public long getFileModificationTime(String paramString)
  {
    return statFile(paramString).mtime;
  }
  
  public long getFileSize(String paramString)
  {
    return statFile(paramString).size;
  }
  
  public boolean hasDirectFileAccess()
  {
    return false;
  }
  
  public abstract FileResult readFile(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public abstract FileResult readFile(String paramString, long paramLong1, long paramLong2);
  
  public abstract byte[] readFile(String paramString);
  
  public abstract FileResult statFile(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.services.BaseService
 * JD-Core Version:    0.7.0.1
 */