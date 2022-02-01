package com.tencent.mobileqq.shortvideo.gesture;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class GestureUtil
{
  public static int a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return 11;
    }
    if (TextUtils.isEmpty(paramDownloadInfo.MD5_so))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, String.format("getEnableFlag, %s", new Object[] { paramDownloadInfo }));
      }
      return 11;
    }
    int i;
    if (paramDownloadInfo.enable)
    {
      if ((d(paramDownloadInfo)) && (c(paramDownloadInfo))) {
        i = 1;
      } else {
        i = 11;
      }
    }
    else {
      i = 2;
    }
    int j;
    if (paramDownloadInfo.gameEnable)
    {
      if ((d(paramDownloadInfo)) && (b(paramDownloadInfo))) {
        j = 1;
      } else {
        j = 11;
      }
    }
    else {
      j = 2;
    }
    if (j != 11)
    {
      if (i == 11) {
        return 11;
      }
      if ((j == 2) && (i == 2)) {
        return 2;
      }
      return 1;
    }
    return 11;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("model");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static boolean a(DownloadInfo paramDownloadInfo)
  {
    boolean bool2 = false;
    if (paramDownloadInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramDownloadInfo.url_zip_gamemodel))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramDownloadInfo.MD5_zip_gamemodel))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramDownloadInfo.gamemodel_fullname)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AVSoUtils.b());
    localStringBuilder.append("so763");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static boolean b(DownloadInfo paramDownloadInfo)
  {
    String str = paramDownloadInfo.MD5_zip_gamemodel;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c());
    ((StringBuilder)localObject).append(paramDownloadInfo.gamemodel_fullname);
    paramDownloadInfo = ((StringBuilder)localObject).toString();
    localObject = DownloadInfo.getSP().getString("gamemodel_zip_md5", null);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str)))
    {
      if (!FileUtils.fileExists(paramDownloadInfo))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavGesture", 4, String.format("isGameModelReady, file no exist,  fileName[%s]", new Object[] { paramDownloadInfo }));
        }
        return false;
      }
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("isGameModelReady, sp_md5[%s], xmlMd5[%s]", new Object[] { localObject, str }));
    }
    return false;
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("gamemodel");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static boolean c(DownloadInfo paramDownloadInfo)
  {
    String str = paramDownloadInfo.MD5_zip_model;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append(paramDownloadInfo.model_fullname);
    paramDownloadInfo = ((StringBuilder)localObject).toString();
    localObject = DownloadInfo.getSP().getString("model_zip_md5", null);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str)))
    {
      if (!FileUtils.fileExists(paramDownloadInfo))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavGesture", 4, String.format("isModelReady, file no exist,  fileName[%s]", new Object[] { paramDownloadInfo }));
        }
        return false;
      }
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("isModelReady, sp_md5[%s], xmlMd5[%s]", new Object[] { localObject, str }));
    }
    return false;
  }
  
  public static boolean d(DownloadInfo paramDownloadInfo)
  {
    String str = paramDownloadInfo.MD5_zip_so;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b());
    ((StringBuilder)localObject).append(paramDownloadInfo.so_fullname);
    paramDownloadInfo = ((StringBuilder)localObject).toString();
    localObject = DownloadInfo.getSP().getString("so_zip_md5", null);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str)))
    {
      if (!FileUtils.fileExists(paramDownloadInfo))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavGesture", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { paramDownloadInfo }));
        }
        return false;
      }
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { localObject, str }));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureUtil
 * JD-Core Version:    0.7.0.1
 */