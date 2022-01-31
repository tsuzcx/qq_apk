package com.tencent.mobileqq.ptt;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.qphone.base.util.QLog;

public class PttSoLoader
{
  public static boolean a;
  
  public static String a()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplicationImpl.sApplication);
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return str + "/UnCompressPttSoTemp/";
  }
  
  /* Error */
  public static boolean a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 61	com/tencent/av/core/VcSystemInfo:f	()I
    //   5: istore_2
    //   6: invokestatic 64	com/tencent/mobileqq/ptt/PttSoLoader:b	()Ljava/lang/String;
    //   9: astore 6
    //   11: ldc 40
    //   13: astore 5
    //   15: iload_2
    //   16: iconst_2
    //   17: if_icmple +34 -> 51
    //   20: new 42	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   27: aload 6
    //   29: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 66
    //   34: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 68
    //   43: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore 5
    //   51: ldc 32
    //   53: monitorenter
    //   54: new 70	java/io/File
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: invokevirtual 76	java/io/File:exists	()Z
    //   66: istore 4
    //   68: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +29 -> 100
    //   74: ldc 32
    //   76: iconst_2
    //   77: new 42	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   84: ldc 78
    //   86: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 5
    //   91: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 38	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: iload 4
    //   102: ifeq +113 -> 215
    //   105: aload 5
    //   107: invokestatic 83	java/lang/System:load	(Ljava/lang/String;)V
    //   110: iconst_1
    //   111: putstatic 85	com/tencent/mobileqq/ptt/PttSoLoader:a	Z
    //   114: ldc 32
    //   116: monitorexit
    //   117: getstatic 85	com/tencent/mobileqq/ptt/PttSoLoader:a	Z
    //   120: aload_1
    //   121: invokestatic 90	com/tencent/mobileqq/transfile/PttInfoCollector:a	(ZLjava/lang/String;)V
    //   124: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +40 -> 167
    //   130: ldc 32
    //   132: iconst_2
    //   133: new 42	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   140: ldc 92
    //   142: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 5
    //   147: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 94
    //   152: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: getstatic 85	com/tencent/mobileqq/ptt/PttSoLoader:a	Z
    //   158: invokevirtual 97	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 38	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: iload_3
    //   168: ireturn
    //   169: astore 6
    //   171: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +32 -> 206
    //   177: ldc 32
    //   179: iconst_2
    //   180: new 42	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   187: ldc 99
    //   189: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 6
    //   194: invokevirtual 102	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 38	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: aload_1
    //   208: invokestatic 107	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   211: istore_3
    //   212: goto -98 -> 114
    //   215: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +11 -> 229
    //   221: ldc 32
    //   223: iconst_2
    //   224: ldc 109
    //   226: invokestatic 38	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: aload_1
    //   231: invokestatic 107	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   234: istore_3
    //   235: goto -121 -> 114
    //   238: astore_0
    //   239: ldc 32
    //   241: monitorexit
    //   242: aload_0
    //   243: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramContext	android.content.Context
    //   0	244	1	paramString	String
    //   5	13	2	i	int
    //   1	234	3	bool1	boolean
    //   66	35	4	bool2	boolean
    //   13	133	5	str1	String
    //   9	19	6	str2	String
    //   169	24	6	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   105	114	169	java/lang/UnsatisfiedLinkError
    //   54	100	238	finally
    //   105	114	238	finally
    //   114	117	238	finally
    //   171	206	238	finally
    //   206	212	238	finally
    //   215	229	238	finally
    //   229	235	238	finally
    //   239	242	238	finally
  }
  
  public static String b()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplicationImpl.sApplication);
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return str + "/txPttlib/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttSoLoader
 * JD-Core Version:    0.7.0.1
 */