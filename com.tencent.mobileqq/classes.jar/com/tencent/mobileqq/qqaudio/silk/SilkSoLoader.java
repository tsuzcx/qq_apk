package com.tencent.mobileqq.qqaudio.silk;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.qqaudio.QQAudioReporter;
import com.tencent.mobileqq.qqaudio.QQAudioSystemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class SilkSoLoader
{
  public static boolean a = false;
  
  public static String a()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplication.getContext());
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SilkSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/UnCompressPttSoTemp/");
    return localStringBuilder.toString();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    int i = QQAudioSystemInfo.d();
    String str = b();
    StringBuilder localStringBuilder1;
    if (i > 2)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(str);
      localStringBuilder1.append("lib");
      localStringBuilder1.append(paramString);
      localStringBuilder1.append("_658_v7.so");
      str = localStringBuilder1.toString();
    }
    else
    {
      str = "";
    }
    try
    {
      boolean bool1 = new File(str).exists();
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("start LoadPttSo: ");
        localStringBuilder1.append(str);
        localStringBuilder1.append(" soFileExist=");
        localStringBuilder1.append(bool1);
        QLog.i("SilkSoLoader", 2, localStringBuilder1.toString());
      }
      boolean bool2 = paramString.equals("codecsilk");
      if (bool2) {
        bool1 = false;
      }
      bool2 = true;
      if (bool1)
      {
        try
        {
          System.load(str);
          a = true;
          bool1 = bool2;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("load from txlib failed: ");
            localStringBuilder2.append(localUnsatisfiedLinkError.getMessage());
            QLog.i("SilkSoLoader", 2, localStringBuilder2.toString());
          }
          bool1 = SoLoadUtilNew.loadSoByName(paramContext, paramString);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("SilkSoLoader", 2, "no ptt so in txlib.");
        }
        bool1 = SoLoadUtilNew.loadSoByName(paramContext, paramString);
      }
      QQAudioReporter.a(a, paramString);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("load ");
        paramContext.append(str);
        paramContext.append(" result=");
        paramContext.append(a);
        QLog.i("SilkSoLoader", 2, paramContext.toString());
      }
      return bool1;
    }
    finally {}
  }
  
  public static String b()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplication.getContext());
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SilkSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/txPttlib/");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.silk.SilkSoLoader
 * JD-Core Version:    0.7.0.1
 */