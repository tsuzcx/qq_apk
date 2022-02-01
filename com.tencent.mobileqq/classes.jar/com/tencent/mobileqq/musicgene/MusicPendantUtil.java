package com.tencent.mobileqq.musicgene;

import android.text.TextUtils;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;

public class MusicPendantUtil
{
  public static String a = "";
  
  public static String a()
  {
    if (TextUtils.isEmpty(a)) {}
    try
    {
      a = QQPlayerService.a(6, "MusicPendantUtil");
      return a;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicPendantUtil", 1, "MusicPendantManager() exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPendantUtil
 * JD-Core Version:    0.7.0.1
 */