package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.api.IFileUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.QQFileUtil;
import java.io.File;
import java.util.ArrayList;

public class FileUtilImpl
  implements IFileUtil
{
  public String combinPath(String paramString1, String paramString2)
  {
    return QQFileUtil.a(paramString1, paramString2);
  }
  
  public boolean copyFile(File paramFile1, File paramFile2)
  {
    return QQFileUtil.a(paramFile1, paramFile2);
  }
  
  public boolean deleteFile(File paramFile)
  {
    return QQFileUtil.a(paramFile);
  }
  
  public boolean deleteFile(String paramString)
  {
    return QQFileUtil.c(paramString);
  }
  
  public void deleteSubFile(File paramFile)
  {
    QQFileUtil.a(paramFile);
  }
  
  public boolean fileExistsAndNotEmpty(String paramString)
  {
    return QQFileUtil.b(paramString);
  }
  
  public String filesizeToString(long paramLong)
  {
    return QQFileUtil.a(paramLong);
  }
  
  public String filesizeToString(long paramLong, int paramInt)
  {
    return QQFileUtil.a(paramLong, paramInt);
  }
  
  public Bitmap getBitmapByPath(String paramString)
  {
    return QQFileUtil.a(paramString);
  }
  
  public String getExtension(String paramString)
  {
    return QQFileUtil.a(paramString);
  }
  
  public String getFileDirectoryOf(String paramString)
  {
    return QQFileUtil.c(paramString);
  }
  
  public FileInfo getFileInfo(File paramFile)
  {
    return QQFileUtil.a(paramFile);
  }
  
  public String getFileNameNoEx(String paramString)
  {
    return QQFileUtil.b(paramString);
  }
  
  public long getFileSize(String paramString)
  {
    return QQFileUtil.a(paramString);
  }
  
  public ArrayList<FileInfo> getFiles(String paramString, boolean paramBoolean, int paramInt)
  {
    return QQFileUtil.a(paramString, paramBoolean, paramInt);
  }
  
  public String getThumbnailPath(Context paramContext)
  {
    return QQFileUtil.a(paramContext);
  }
  
  public boolean isFileExists(String paramString)
  {
    return QQFileUtil.a(paramString);
  }
  
  public boolean moveFile(File paramFile1, File paramFile2)
  {
    return QQFileUtil.b(paramFile1, paramFile2);
  }
  
  public boolean writeBitmapToFile(Bitmap paramBitmap, String paramString)
  {
    return QQFileUtil.a(paramBitmap, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileUtilImpl
 * JD-Core Version:    0.7.0.1
 */