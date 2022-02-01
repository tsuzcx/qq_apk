package de.robv.android.xposed.services;

import java.util.Arrays;

public final class ZygoteService
  extends BaseService
{
  public native boolean checkFileAccess(String paramString, int paramInt);
  
  public FileResult readFile(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    FileResult localFileResult = statFile(paramString);
    if ((paramLong1 == localFileResult.size) && (paramLong2 == localFileResult.mtime)) {
      return localFileResult;
    }
    if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
      return new FileResult(readFile(paramString), localFileResult.size, localFileResult.mtime);
    }
    if ((paramInt1 > 0) && (paramInt1 >= localFileResult.size)) {
      throw new IllegalArgumentException("offset " + paramInt1 + " >= size " + localFileResult.size + " for " + paramString);
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    if ((paramInt2 > 0) && (i + paramInt2 > localFileResult.size)) {
      throw new IllegalArgumentException("offset " + i + " + length " + paramInt2 + " > size " + localFileResult.size + " for " + paramString);
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = (int)(localFileResult.size - i);
    }
    return new FileResult(Arrays.copyOfRange(readFile(paramString), i, i + paramInt1), localFileResult.size, localFileResult.mtime);
  }
  
  public FileResult readFile(String paramString, long paramLong1, long paramLong2)
  {
    FileResult localFileResult = statFile(paramString);
    if ((paramLong1 == localFileResult.size) && (paramLong2 == localFileResult.mtime)) {
      return localFileResult;
    }
    return new FileResult(readFile(paramString), localFileResult.size, localFileResult.mtime);
  }
  
  public native byte[] readFile(String paramString);
  
  public native FileResult statFile(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.services.ZygoteService
 * JD-Core Version:    0.7.0.1
 */