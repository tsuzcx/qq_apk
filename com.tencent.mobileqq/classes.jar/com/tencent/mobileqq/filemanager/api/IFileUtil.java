package com.tencent.mobileqq.filemanager.api;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IFileUtil
  extends QRouteApi
{
  public abstract String combinPath(String paramString1, String paramString2);
  
  public abstract boolean copyFile(File paramFile1, File paramFile2);
  
  public abstract boolean deleteFile(File paramFile);
  
  public abstract boolean deleteFile(String paramString);
  
  public abstract void deleteSubFile(File paramFile);
  
  public abstract boolean fileExistsAndNotEmpty(String paramString);
  
  public abstract String filesizeToString(long paramLong);
  
  public abstract String filesizeToString(long paramLong, int paramInt);
  
  public abstract Bitmap getBitmapByPath(String paramString);
  
  public abstract String getExtension(String paramString);
  
  public abstract String getFileDirectoryOf(String paramString);
  
  public abstract FileInfo getFileInfo(File paramFile);
  
  public abstract String getFileNameNoEx(String paramString);
  
  public abstract long getFileSize(String paramString);
  
  public abstract ArrayList<FileInfo> getFiles(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract String getThumbnailPath(Context paramContext);
  
  public abstract boolean isFileExists(String paramString);
  
  public abstract boolean moveFile(File paramFile1, File paramFile2);
  
  public abstract boolean writeBitmapToFile(Bitmap paramBitmap, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IFileUtil
 * JD-Core Version:    0.7.0.1
 */