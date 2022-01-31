package com.tencent.mobileqq.extendfriend.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ExtendFriendResourceUtil
{
  public static final String[] a = { "expand_feed_bg1.png", "expand_feed_bg2.png", "expand_feed_bg3.png", "expand_feed_bg4.png", "expand_voice_logo1.png", "expand_voice_logo2.png", "expand_voice_logo3.png", "expand_voice_logo4.png", "expand_square_blank.png", "expand_voice_animation.json", "expand_summary_bg.png", "expand_summary_default_bg.png", "expand_guide_wording.png", "expand_guide_profile.png", "expand_guide_switch.png", "expand_summary_bg1.png", "expand_summary_bg2.png", "expand_summary_bg3.png", "expand_summary_bg4.png" };
  public static final String[] b = { "expand_summary_bg1.png", "expand_summary_bg2.png", "expand_summary_bg3.png", "expand_summary_bg4.png" };
  public static final String[] c = { "expand_feed_bg1.png", "expand_feed_bg2.png", "expand_feed_bg3.png", "expand_feed_bg4.png" };
  public static final String[] d = { "expand_voice_logo1.png", "expand_voice_logo2.png", "expand_voice_logo3.png", "expand_voice_logo4.png" };
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    Bitmap localBitmap = null;
    if ((TextUtils.isEmpty(paramString)) || (new File(paramString).exists())) {
      try
      {
        localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
        return localBitmap;
      }
      catch (Exception paramOptions)
      {
        QLog.d("ExtendFriendResourceUtil", 1, String.format("decodeFile fail, filePath=%s", new Object[] { paramString }), paramOptions);
        return null;
      }
      catch (OutOfMemoryError paramOptions)
      {
        QLog.d("ExtendFriendResourceUtil", 1, String.format("decodeFile fail, filePath=%s", new Object[] { paramString }), paramOptions);
        return null;
      }
    }
    QLog.d("ExtendFriendResourceUtil", 1, String.format("decodeFile fail, file not exists filePath=%s", new Object[] { paramString }));
    return null;
  }
  
  public static String a(String paramString)
  {
    return String.format("%s/%s", new Object[] { ExtendFriendResourceDownloader.a(), paramString });
  }
  
  public static boolean a()
  {
    return a(a(a));
  }
  
  public static boolean a(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!new File(str).exists())
      {
        QLog.e("ExtendFriendResourceUtil", 1, String.format("isFilesExist check fail. filePath=%s", new Object[] { str }));
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static String[] a(String[] paramArrayOfString)
  {
    String[] arrayOfString = null;
    if (paramArrayOfString != null)
    {
      arrayOfString = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        arrayOfString[i] = a(paramArrayOfString[i]);
        i += 1;
      }
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil
 * JD-Core Version:    0.7.0.1
 */