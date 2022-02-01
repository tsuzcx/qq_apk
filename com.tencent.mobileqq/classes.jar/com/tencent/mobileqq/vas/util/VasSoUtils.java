package com.tencent.mobileqq.vas.util;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class VasSoUtils
{
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: new 15	java/io/File
    //   8: dup
    //   9: new 17	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: getstatic 26	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: invokevirtual 37	java/io/File:exists	()Z
    //   43: istore_3
    //   44: iload_3
    //   45: ifne +8 -> 53
    //   48: ldc 2
    //   50: monitorexit
    //   51: iload_2
    //   52: ireturn
    //   53: new 17	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 26	java/io/File:separator	Ljava/lang/String;
    //   67: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 42	java/lang/System:load	(Ljava/lang/String;)V
    //   80: iconst_0
    //   81: istore_2
    //   82: goto -34 -> 48
    //   85: astore_0
    //   86: ldc 44
    //   88: iconst_1
    //   89: new 17	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   96: ldc 46
    //   98: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: invokevirtual 49	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   105: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload 4
    //   116: invokevirtual 58	java/io/File:delete	()Z
    //   119: pop
    //   120: iconst_2
    //   121: istore_2
    //   122: goto -74 -> 48
    //   125: astore_0
    //   126: ldc 2
    //   128: monitorexit
    //   129: aload_0
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString1	String
    //   0	131	1	paramString2	String
    //   1	121	2	i	int
    //   43	2	3	bool	boolean
    //   36	79	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   53	80	85	java/lang/Throwable
    //   5	44	125	finally
    //   53	80	125	finally
    //   86	120	125	finally
  }
  
  public static String a()
  {
    return BaseApplication.getContext().getFilesDir().getAbsolutePath() + File.separator + "vas_so" + File.separator;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.e("VasSoUtils", 1, "unCompressSo fail zipPath = " + paramString1 + " dstPath = " + paramString2);
    }
    for (;;)
    {
      return false;
      if (!new File(paramString1).exists())
      {
        QLog.e("VasSoUtils", 1, "unCompressSo fail src file not exists");
        return false;
      }
      String str = paramString2 + File.separator + "unzip_temp/";
      try
      {
        FileUtils.a(paramString1, str, false);
        paramString1 = new File(str + paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("VasSoUtils", 2, "unCompressSo tempfile = " + paramString1.getAbsolutePath());
        }
        if (!paramString1.exists())
        {
          QLog.e("VasSoUtils", 1, "unCompressSo fail so file not exists");
          return false;
        }
      }
      catch (IOException paramString1)
      {
        QLog.e("VasSoUtils", 1, "unCompressSo IOException: ", paramString1);
        return false;
      }
      paramString2 = paramString2 + File.separator + paramString3;
      paramString3 = new File(paramString2);
      boolean bool;
      if (paramString3.exists())
      {
        bool = paramString3.delete();
        QLog.d("VasSoUtils", 1, "unCompressSo so already exists, delete old so result = " + bool);
      }
      while (bool)
      {
        bool = paramString1.renameTo(paramString3);
        QLog.d("VasSoUtils", 1, "unCompressSo rename temp so to real path result = " + bool + "realpath = " + paramString2);
        return bool;
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.VasSoUtils
 * JD-Core Version:    0.7.0.1
 */