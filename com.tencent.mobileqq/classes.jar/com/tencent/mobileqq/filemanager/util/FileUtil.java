package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.api.IFileUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.File;
import java.util.ArrayList;

public class FileUtil
{
  public static IFileUtil a()
  {
    return (IFileUtil)QRoute.api(IFileUtil.class);
  }
  
  public static String a(long paramLong)
  {
    return a().filesizeToString(paramLong);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    return a().filesizeToString(paramLong, paramInt);
  }
  
  public static String a(Context paramContext)
  {
    return a().getThumbnailPath(paramContext);
  }
  
  public static String a(String paramString)
  {
    return a().getExtension(paramString);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a().combinPath(paramString1, paramString2);
  }
  
  public static ArrayList<FileInfo> a(String paramString, boolean paramBoolean, int paramInt)
  {
    return a().getFiles(paramString, paramBoolean, paramInt);
  }
  
  public static boolean a(Bitmap paramBitmap, String paramString)
  {
    return a().writeBitmapToFile(paramBitmap, paramString);
  }
  
  public static boolean a(File paramFile)
  {
    return a().deleteFile(paramFile);
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return a().copyFile(paramFile1, paramFile2);
  }
  
  public static void b(File paramFile)
  {
    a().deleteSubFile(paramFile);
  }
  
  public static boolean b(String paramString)
  {
    return a().fileExistsAndNotEmpty(paramString);
  }
  
  public static FileInfo c(File paramFile)
  {
    return a().getFileInfo(paramFile);
  }
  
  public static String c(String paramString)
  {
    return a().getFileDirectoryOf(paramString);
  }
  
  public static boolean d(String paramString)
  {
    return a().isFileExists(paramString);
  }
  
  public static boolean e(String paramString)
  {
    return a().deleteFile(paramString);
  }
  
  public static long f(String paramString)
  {
    return a().getFileSize(paramString);
  }
  
  public static String g(String paramString)
  {
    return a().getFileNameNoEx(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */