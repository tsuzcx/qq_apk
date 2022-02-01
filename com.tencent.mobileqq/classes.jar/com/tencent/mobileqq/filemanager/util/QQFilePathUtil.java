package com.tencent.mobileqq.filemanager.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class QQFilePathUtil
{
  private static File a(String paramString1, String paramString2)
  {
    paramString1 = QQFileManagerUtilImpl.n(paramString1);
    QQFileManagerUtilImpl.g(paramString1);
    File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getAbsolutePath());
    localStringBuilder.append("/QQ/");
    localFile = new File(localStringBuilder.toString());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getAbsolutePath());
    localStringBuilder.append("/");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString1 = new File(QQFileManagerUtilImpl.o(localStringBuilder.toString()));
    try
    {
      paramString1.createNewFile();
      return paramString1;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return null;
    }
    String str = QQFileManagerUtilImpl.n(paramString);
    Object localObject4 = "";
    Object localObject3 = str;
    Object localObject2 = localObject4;
    Object localObject1 = localObject4;
    try
    {
      if (str.indexOf('.') >= 0) {
        break label158;
      }
      localObject1 = localObject4;
      localObject2 = new StringBuilder();
      localObject1 = localObject4;
      ((StringBuilder)localObject2).append(".");
      localObject1 = localObject4;
      ((StringBuilder)localObject2).append(FileUtils.estimateFileType(paramString));
      localObject1 = localObject4;
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append(str);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    catch (Exception localException)
    {
      label142:
      label158:
      int i;
      int j;
      long l;
      break label142;
    }
    QLog.e("FilePathUtil<FileAssistant>", 1, "copyMediaFileToMediaStorage: get file ext error");
    localObject2 = localObject1;
    localObject3 = str;
    i = QQFileManagerUtilImpl.g((String)localObject3);
    if ((i != 2) && (i != 0))
    {
      paramString = new StringBuilder();
      paramString.append("unsupport type:");
      paramString.append(i);
      QLog.w("FilePathUtil<FileAssistant>", 1, paramString.toString());
      return null;
    }
    localObject1 = BaseApplication.getContext();
    str = MimeTypesTools.getMimeType((Context)localObject1, (String)localObject3);
    j = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getImageDegree(paramString);
    localObject4 = new ContentValues();
    ((ContentValues)localObject4).put("title", (String)localObject3);
    ((ContentValues)localObject4).put("_display_name", (String)localObject3);
    ((ContentValues)localObject4).put("description", (String)localObject3);
    ((ContentValues)localObject4).put("mime_type", str);
    localObject2 = a(paramString, (String)localObject2);
    if (localObject2 == null) {
      return null;
    }
    if (new File(paramString).renameTo((File)localObject2))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("rename :");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(" to:");
      ((StringBuilder)localObject3).append(((File)localObject2).getAbsolutePath());
      QLog.i("FilePathUtil<FileAssistant>", 1, ((StringBuilder)localObject3).toString());
    }
    paramString = ((File)localObject2).getAbsolutePath();
    ((ContentValues)localObject4).put("_data", paramString);
    if (i == 0)
    {
      ((ContentValues)localObject4).put("datetaken", Long.valueOf(System.currentTimeMillis()));
      ((ContentValues)localObject4).put("orientation", Integer.valueOf(j));
      ((Context)localObject1).getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (ContentValues)localObject4);
      return paramString;
    }
    if (i == 2)
    {
      l = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getDuration(paramString);
      ((ContentValues)localObject4).put("datetaken", Long.valueOf(System.currentTimeMillis()));
      ((ContentValues)localObject4).put("duration", Long.valueOf(l));
      ((Context)localObject1).getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, (ContentValues)localObject4);
    }
    return paramString;
  }
  
  public static String b(String paramString)
  {
    boolean bool = FileUtils.fileExistsAndNotEmpty(paramString);
    Object localObject5 = null;
    if (!bool) {
      return null;
    }
    String str = QQFileManagerUtilImpl.n(paramString);
    Object localObject4 = "";
    Object localObject3 = str;
    Object localObject2 = localObject4;
    Object localObject1 = localObject4;
    try
    {
      if (str.indexOf('.') >= 0) {
        break label163;
      }
      localObject1 = localObject4;
      localObject2 = new StringBuilder();
      localObject1 = localObject4;
      ((StringBuilder)localObject2).append(".");
      localObject1 = localObject4;
      ((StringBuilder)localObject2).append(FileUtils.estimateFileType(paramString));
      localObject1 = localObject4;
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      localObject3 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append(str);
      localObject1 = localObject2;
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = localObject2;
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    catch (Exception localException)
    {
      label147:
      int i;
      int j;
      ContentValues localContentValues;
      long l;
      break label147;
    }
    QLog.e("FilePathUtil<FileAssistant>", 1, "copyMediaFileToMediaStorage: get file ext error");
    localObject2 = localObject1;
    localObject3 = str;
    label163:
    i = QQFileManagerUtilImpl.g((String)localObject3);
    if ((i != 2) && (i != 0))
    {
      paramString = new StringBuilder();
      paramString.append("unsupport type:");
      paramString.append(i);
      QLog.w("FilePathUtil<FileAssistant>", 1, paramString.toString());
      return null;
    }
    localObject4 = BaseApplication.getContext();
    str = MimeTypesTools.getMimeType((Context)localObject4, (String)localObject3);
    j = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getImageDegree(paramString);
    localContentValues = new ContentValues();
    localContentValues.put("title", (String)localObject3);
    localContentValues.put("_display_name", (String)localObject3);
    localContentValues.put("description", (String)localObject3);
    localContentValues.put("mime_type", str);
    localObject3 = a(paramString, (String)localObject2);
    if (localObject3 == null) {
      return null;
    }
    localObject2 = ((File)localObject3).getAbsolutePath();
    localContentValues.put("_data", (String)localObject2);
    if (i == 0)
    {
      localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
      localContentValues.put("orientation", Integer.valueOf(j));
      localObject1 = ((Context)localObject4).getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues);
    }
    else
    {
      localObject1 = localObject5;
      if (i == 2)
      {
        l = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getDuration(paramString);
        localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        localContentValues.put("duration", Long.valueOf(l));
        localObject1 = ((Context)localObject4).getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localContentValues);
      }
    }
    if (QQFileUtilsImpl.a((Context)localObject4, paramString, (Uri)localObject1))
    {
      paramString = ((File)localObject3).getAbsolutePath();
      localObject1 = new QQFilePathUtil.1();
      MediaScannerConnection.scanFile((Context)localObject4, new String[] { paramString }, new String[] { str }, (MediaScannerConnection.OnScanCompletedListener)localObject1);
    }
    return localObject2;
  }
  
  public static String c(String paramString)
  {
    return paramString;
  }
  
  public static boolean d(String paramString)
  {
    return FileUtils.fileExistsAndNotEmpty(c(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFilePathUtil
 * JD-Core Version:    0.7.0.1
 */