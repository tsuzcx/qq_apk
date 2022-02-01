package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.qqcommon.api.IFileUtilsApi;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class FileUtilsApiImpl
  implements IFileUtilsApi
{
  public void createFileIfNotExits(String paramString)
  {
    FileUtils.createFileIfNotExits(paramString);
  }
  
  public void delete(String paramString, boolean paramBoolean)
  {
    FileUtils.delete(paramString, paramBoolean);
  }
  
  public void deleteDirectory(String paramString)
  {
    FileUtils.deleteDirectory(paramString);
  }
  
  public String estimateFileType(String paramString)
  {
    return FileUtils.estimateFileType(paramString);
  }
  
  public String estimateFileType(byte[] paramArrayOfByte)
  {
    return FileUtils.estimateFileType(paramArrayOfByte);
  }
  
  public boolean fileExists(String paramString)
  {
    return FileUtils.fileExists(paramString);
  }
  
  public boolean fileExistsAndNotEmpty(String paramString)
  {
    return FileUtils.fileExistsAndNotEmpty(paramString);
  }
  
  public boolean moveFile(String paramString1, String paramString2)
  {
    return FileUtils.moveFile(paramString1, paramString2);
  }
  
  public String readFileContent(File paramFile)
  {
    return FileUtils.readFileContent(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.impl.FileUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */