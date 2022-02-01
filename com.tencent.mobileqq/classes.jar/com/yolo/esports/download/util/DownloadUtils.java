package com.yolo.esports.download.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.utils.Logger;
import java.io.File;

public class DownloadUtils
{
  private static final String[] a = { " ", "<", ">", "|", ":", "/", "\\", "\"" };
  
  public static String a()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (localBaseApplication == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localBaseApplication.getFilesDir().getAbsolutePath());
    localStringBuilder.append("/yoloesports/download/");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[genFileNameFromUrl] url = ");
    localStringBuilder.append(paramString);
    Logger.a("DownloadUtils_", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = b(MD5.b(paramString));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[genFileNameFromUrl] fileName = ");
    localStringBuilder.append(paramString);
    Logger.a("DownloadUtils_", localStringBuilder.toString());
    return paramString;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[filterUnSupportStr] before = ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("DownloadUtils_", ((StringBuilder)localObject).toString());
    localObject = a;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramString.replace(localObject[i], "_");
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[filterUnSupportStr] end = ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("DownloadUtils_", ((StringBuilder)localObject).toString());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.util.DownloadUtils
 * JD-Core Version:    0.7.0.1
 */