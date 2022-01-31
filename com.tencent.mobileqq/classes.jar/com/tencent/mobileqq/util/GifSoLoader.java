package com.tencent.mobileqq.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GifSoLoader
{
  public static void a(String paramString)
  {
    if ((paramString != null) && ((paramString.contains("NativeGifFactory")) || (paramString.contains("NativeGifIndex8")) || (paramString.contains("libkIndexGif")) || (paramString.contains("libskia"))))
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
      if (QLog.isColorLevel()) {
        QLog.d("GifSoLoader", 2, String.format("Crash in libkIndexGif support library at %s process!", new Object[] { BaseApplicationImpl.getMobileQQ().getProcessName() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.GifSoLoader
 * JD-Core Version:    0.7.0.1
 */