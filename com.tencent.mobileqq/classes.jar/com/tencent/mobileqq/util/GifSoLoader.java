package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class GifSoLoader
{
  public static String a(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      return null;
    }
    File localFile = paramContext.getFilesDir();
    paramContext = localObject;
    if (localFile != null)
    {
      paramContext = new StringBuilder();
      paramContext.append(localFile.getParent());
      paramContext.append("/lib/");
      paramContext = paramContext.toString();
    }
    return paramContext;
  }
  
  public static void a(String paramString)
  {
    if ((paramString != null) && ((paramString.contains("NativeGifFactory")) || (paramString.contains("NativeGifIndex8")) || (paramString.contains("libkIndexGif")) || (paramString.contains("libskia"))))
    {
      MobileQQ.sMobileQQ.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
      if (QLog.isColorLevel()) {
        QLog.d("GifSoLoader", 2, String.format("Crash in libkIndexGif support library at %s process!", new Object[] { MobileQQ.sMobileQQ.getQQProcessName() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.GifSoLoader
 * JD-Core Version:    0.7.0.1
 */