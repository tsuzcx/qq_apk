package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.qqcommon.api.IFileUtilsApi;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class FileUtilsApiImpl
  implements IFileUtilsApi
{
  public void createFileIfNotExits(String paramString)
  {
    FileUtils.c(paramString);
  }
  
  public void delete(String paramString, boolean paramBoolean)
  {
    FileUtils.a(paramString, paramBoolean);
  }
  
  public void deleteDirectory(String paramString)
  {
    FileUtils.a(paramString);
  }
  
  public String estimateFileType(String paramString)
  {
    return FileUtils.b(paramString);
  }
  
  public String estimateFileType(byte[] paramArrayOfByte)
  {
    return FileUtils.a(paramArrayOfByte);
  }
  
  public boolean fileExists(String paramString)
  {
    return FileUtils.a(paramString);
  }
  
  public boolean fileExistsAndNotEmpty(String paramString)
  {
    return FileUtils.b(paramString);
  }
  
  public boolean moveFile(String paramString1, String paramString2)
  {
    return FileUtils.b(paramString1, paramString2);
  }
  
  public String readFileContent(File paramFile)
  {
    return FileUtils.a(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.impl.FileUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */