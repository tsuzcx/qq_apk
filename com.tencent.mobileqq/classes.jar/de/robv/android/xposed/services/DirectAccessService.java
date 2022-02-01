package de.robv.android.xposed.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class DirectAccessService
  extends BaseService
{
  public boolean checkFileAccess(String paramString, int paramInt)
  {
    paramString = new File(paramString);
    if ((paramInt == 0) && (!paramString.exists())) {}
    while ((((paramInt & 0x4) != 0) && (!paramString.canRead())) || (((paramInt & 0x2) != 0) && (!paramString.canWrite())) || (((paramInt & 0x1) != 0) && (!paramString.canExecute()))) {
      return false;
    }
    return true;
  }
  
  public boolean checkFileExists(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public FileResult getFileInputStream(String paramString, long paramLong1, long paramLong2)
  {
    File localFile = new File(paramString);
    long l1 = localFile.length();
    long l2 = localFile.lastModified();
    if ((paramLong1 == l1) && (paramLong2 == l2)) {
      return new FileResult(l1, l2);
    }
    return new FileResult(new BufferedInputStream(new FileInputStream(paramString), 16384), l1, l2);
  }
  
  public InputStream getFileInputStream(String paramString)
  {
    return new BufferedInputStream(new FileInputStream(paramString), 16384);
  }
  
  public boolean hasDirectFileAccess()
  {
    return true;
  }
  
  public FileResult readFile(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    Object localObject = new File(paramString);
    long l1 = ((File)localObject).length();
    long l2 = ((File)localObject).lastModified();
    if ((paramLong1 == l1) && (paramLong2 == l2)) {
      return new FileResult(l1, l2);
    }
    if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
      return new FileResult(readFile(paramString), l1, l2);
    }
    if ((paramInt1 > 0) && (paramInt1 >= l1)) {
      throw new IllegalArgumentException("Offset " + paramInt1 + " is out of range for " + paramString);
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    if ((paramInt2 > 0) && (i + paramInt2 > l1)) {
      throw new IllegalArgumentException("Length " + paramInt2 + " is out of range for " + paramString);
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = (int)(l1 - i);
    }
    paramString = new byte[paramInt1];
    localObject = new FileInputStream((File)localObject);
    ((FileInputStream)localObject).skip(i);
    ((FileInputStream)localObject).read(paramString);
    ((FileInputStream)localObject).close();
    return new FileResult(paramString, l1, l2);
  }
  
  public FileResult readFile(String paramString, long paramLong1, long paramLong2)
  {
    File localFile = new File(paramString);
    long l1 = localFile.length();
    long l2 = localFile.lastModified();
    if ((paramLong1 == l1) && (paramLong2 == l2)) {
      return new FileResult(l1, l2);
    }
    return new FileResult(readFile(paramString), l1, l2);
  }
  
  public byte[] readFile(String paramString)
  {
    Object localObject = new File(paramString);
    paramString = new byte[(int)((File)localObject).length()];
    localObject = new FileInputStream((File)localObject);
    ((FileInputStream)localObject).read(paramString);
    ((FileInputStream)localObject).close();
    return paramString;
  }
  
  public FileResult statFile(String paramString)
  {
    paramString = new File(paramString);
    return new FileResult(paramString.length(), paramString.lastModified());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.services.DirectAccessService
 * JD-Core Version:    0.7.0.1
 */