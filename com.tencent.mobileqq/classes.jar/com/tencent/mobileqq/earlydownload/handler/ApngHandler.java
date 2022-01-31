package com.tencent.mobileqq.earlydownload.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.FontSoLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.ApngData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApngHandler
  extends EarlyHandler
{
  private static int a;
  public static AtomicBoolean a;
  public static AtomicBoolean b = new AtomicBoolean(false);
  private static AtomicBoolean c = new AtomicBoolean(false);
  private static AtomicBoolean d = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    for (;;)
    {
      String str1;
      try
      {
        str1 = FontSoLoader.a();
        boolean bool3 = TextUtils.isEmpty(str1);
        bool1 = bool2;
        if (!bool3) {}
        try
        {
          FileUtils.a(paramString1, str1, false);
          String str2 = FileUtils.b(str1 + "libAPNG700.so");
          if (QLog.isColorLevel()) {
            QLog.d("ApngHandler", 2, "LocalSoMD5=" + str2 + ", ServerSoMD5=" + paramString2);
          }
          if ((TextUtils.isEmpty(str2)) || (!str2.equalsIgnoreCase(paramString2))) {
            break label222;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApngHandler", 2, "uncompress zip success, filepath=" + paramString1);
          }
          bool1 = true;
        }
        catch (IOException paramString2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApngHandler", 2, "uncompress zip failed, filepath=" + paramString1, paramString2);
          paramString1 = new File(str1, "libAPNG700.so");
          bool1 = bool2;
          if (!paramString1.exists()) {
            continue;
          }
          paramString1.delete();
          bool1 = bool2;
          continue;
        }
        return bool1;
      }
      finally {}
      label222:
      paramString1 = new File(str1, "libAPNG700.so");
      boolean bool1 = bool2;
      if (paramString1.exists())
      {
        paramString1.delete();
        bool1 = bool2;
      }
    }
  }
  
  public static boolean c()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if (!BaseApplication.getContext().getSharedPreferences("early_qq.android.native.apng_v700", 0).getBoolean("apng_so_downloaded", false))
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("ApngHandler", 2, "isSoPrepared read from sp not download");
            bool1 = bool2;
          }
          return bool1;
        }
        if (d.get())
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApngHandler", 2, "isSoPrepared isUnziping can not load");
          bool1 = bool2;
          continue;
        }
        str = FontSoLoader.a();
      }
      finally {}
      String str;
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool2 = new File(str + "libAPNG700.so").exists();
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ApngHandler", 2, "isSoPrepared: " + bool2);
          bool1 = bool2;
        }
      }
    }
  }
  
  /* Error */
  public static boolean d_()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 22	com/tencent/mobileqq/earlydownload/handler/ApngHandler:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   8: invokevirtual 126	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   11: ifeq +26 -> 37
    //   14: iload_1
    //   15: istore_0
    //   16: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +13 -> 32
    //   22: ldc 70
    //   24: iconst_2
    //   25: ldc 141
    //   27: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: iload_1
    //   31: istore_0
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload_0
    //   36: ireturn
    //   37: invokestatic 35	com/etrump/mixlayout/FontSoLoader:a	()Ljava/lang/String;
    //   40: astore_2
    //   41: aload_2
    //   42: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +136 -> 181
    //   48: new 48	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   55: aload_2
    //   56: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 56
    //   61: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore_2
    //   68: invokestatic 143	com/tencent/mobileqq/earlydownload/handler/ApngHandler:c	()Z
    //   71: istore_0
    //   72: iload_0
    //   73: ifeq +108 -> 181
    //   76: aload_2
    //   77: invokestatic 148	java/lang/System:load	(Ljava/lang/String;)V
    //   80: getstatic 22	com/tencent/mobileqq/earlydownload/handler/ApngHandler:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   83: iconst_1
    //   84: invokevirtual 151	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   87: ldc 70
    //   89: iconst_1
    //   90: ldc 153
    //   92: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: iload_1
    //   96: istore_0
    //   97: goto -65 -> 32
    //   100: astore_3
    //   101: ldc 70
    //   103: iconst_1
    //   104: ldc 155
    //   106: aload_3
    //   107: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: new 92	java/io/File
    //   113: dup
    //   114: aload_2
    //   115: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: invokevirtual 101	java/io/File:delete	()Z
    //   121: pop
    //   122: getstatic 24	com/tencent/mobileqq/earlydownload/handler/ApngHandler:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   125: iconst_0
    //   126: invokevirtual 151	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   129: invokestatic 107	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   132: ldc 109
    //   134: iconst_0
    //   135: invokevirtual 113	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   138: invokeinterface 159 1 0
    //   143: ldc 115
    //   145: iconst_0
    //   146: invokeinterface 165 3 0
    //   151: invokeinterface 168 1 0
    //   156: pop
    //   157: aconst_null
    //   158: ldc 170
    //   160: ldc 172
    //   162: ldc 172
    //   164: ldc 174
    //   166: ldc 176
    //   168: iconst_0
    //   169: iconst_0
    //   170: ldc 178
    //   172: ldc 172
    //   174: ldc 172
    //   176: ldc 172
    //   178: invokestatic 183	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   181: iconst_0
    //   182: istore_0
    //   183: goto -151 -> 32
    //   186: astore_2
    //   187: ldc 2
    //   189: monitorexit
    //   190: aload_2
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	168	0	bool1	boolean
    //   1	95	1	bool2	boolean
    //   40	75	2	str	String
    //   186	5	2	localObject	Object
    //   100	7	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   76	95	100	java/lang/Throwable
    //   5	14	186	finally
    //   16	30	186	finally
    //   37	72	186	finally
    //   76	95	186	finally
    //   101	181	186	finally
  }
  
  public int a()
  {
    return 10005;
  }
  
  public Class a()
  {
    return ApngData.class;
  }
  
  public String a()
  {
    return "actEarlyNativeApng";
  }
  
  public void a(XmlData paramXmlData)
  {
    super.a(paramXmlData);
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngHandler", 2, "onDownloadFinish result = " + paramBoolean + "errCode = " + paramInt);
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngHandler", 2, "doOnDownloadSuccess");
    }
    Object localObject = (ApngData)a();
    if ((localObject != null) && (!c.get()))
    {
      if (!d.compareAndSet(false, true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApngHandler", 2, "doOnDownloadSuccess is unziping");
        }
        return;
      }
      if (!a(paramString, ((ApngData)localObject).SoMD5)) {
        break label185;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApngHandler", 2, "doOnDownloadSuccess Unzip success");
      }
      ((ApngData)localObject).apng_so_downloaded = true;
      EarlyDataFactory.a((XmlData)localObject, new String[] { "apng_so_downloaded" });
      c.set(true);
      d.set(false);
      d_();
      if (ThemeUtil.isNowThemeIsAnimate())
      {
        String str = ThemeUtil.getCurrentThemeInfo().getString("themePath");
        if (!TextUtils.isEmpty(str))
        {
          SkinEngine localSkinEngine = SkinEngine.getInstances();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label178;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
          localSkinEngine.setSkinRootPath((Context)localObject, str);
        }
      }
    }
    for (;;)
    {
      super.a(paramString);
      return;
      label178:
      localObject = BaseApplication.getContext();
      break;
      label185:
      if (QLog.isColorLevel()) {
        QLog.d("ApngHandler", 2, "doOnDownloadSuccess Unzip fail");
      }
      ((ApngData)localObject).loadState = 0;
      ((ApngData)localObject).apng_so_downloaded = false;
      ((ApngData)localObject).Version = 0;
      EarlyDataFactory.a((XmlData)localObject, new String[0]);
      c.set(false);
      d.set(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (jdField_a_of_type_Int < 3))
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      jdField_a_of_type_Int += 1;
      super.a(paramBoolean);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApngHandler", 2, "restartDownload isSoDownloading = " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " restartTime = " + jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public void b(XmlData paramXmlData)
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    super.b(paramXmlData);
  }
  
  public void c(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngHandler", 2, "onDownloadCancel");
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    super.c(paramXmlData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ApngHandler
 * JD-Core Version:    0.7.0.1
 */