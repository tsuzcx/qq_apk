package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

@QAPI(process={"all"})
public abstract interface IFileUtilsApi
  extends QRouteApi
{
  public static final String API_FILE_TYPE_JPEG = "jpg";
  
  public abstract void createFileIfNotExits(String paramString);
  
  public abstract void delete(String paramString, boolean paramBoolean);
  
  public abstract void deleteDirectory(String paramString);
  
  public abstract String estimateFileType(String paramString);
  
  public abstract String estimateFileType(byte[] paramArrayOfByte);
  
  public abstract boolean fileExists(String paramString);
  
  public abstract boolean fileExistsAndNotEmpty(String paramString);
  
  public abstract boolean moveFile(String paramString1, String paramString2);
  
  public abstract String readFileContent(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.IFileUtilsApi
 * JD-Core Version:    0.7.0.1
 */