package com.tencent.qphone.base.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

public class StringUtils
{
  public static final String MSF_LIB_BOOTV2 = "msfbootV2";
  public static final String MSF_LIB_CODEC_V2 = "codecwrapperV2";
  public static final String MSF_LIB_QUIC = "quic";
  
  public static String getIpAddrFromInt(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    localStringBuffer.append(String.valueOf(paramInt >>> 24));
    localStringBuffer.append(".");
    localStringBuffer.append(String.valueOf((0xFFFFFF & paramInt) >>> 16));
    localStringBuffer.append(".");
    localStringBuffer.append(String.valueOf((0xFFFF & paramInt) >>> 8));
    localStringBuffer.append(".");
    localStringBuffer.append(String.valueOf(paramInt & 0xFF));
    return localStringBuffer.toString();
  }
  
  public static boolean getLoadResult(int paramInt)
  {
    if ((paramInt & 0x2) == 2) {}
    while ((paramInt & 0x40000) == 262144) {
      return true;
    }
    return false;
  }
  
  public static String getPlatformString()
  {
    String str = Build.CPU_ABI;
    if ((str != null) && (str.contains("x86"))) {
      return "x86";
    }
    if ((str != null) && (str.contains("mip"))) {
      return "mips";
    }
    return "armeabi";
  }
  
  public static String getTxLib(Context paramContext)
  {
    return paramContext.getFilesDir().getParent() + "/txlib/";
  }
  
  public static boolean loadLibrary(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    boolean bool2 = true;
    if (paramContext == null) {
      return false;
    }
    paramContext = new File(paramString2);
    if (paramContext.exists()) {}
    boolean bool1;
    label125:
    for (;;)
    {
      try
      {
        System.load(paramContext.getAbsolutePath());
        bool1 = true;
        if ((bool1) || (TextUtils.isEmpty(paramString3))) {
          break label125;
        }
      }
      catch (Throwable paramString2)
      {
        QLog.e(paramString1, 1, "cannot load library " + paramContext.getAbsolutePath(), paramString2);
      }
      try
      {
        System.loadLibrary(paramString3);
        bool1 = bool2;
      }
      catch (Throwable paramContext)
      {
        QLog.e(paramString1, 1, "cannot load system library " + paramString3, paramContext);
        bool1 = false;
        continue;
      }
      return bool1;
      bool1 = false;
    }
  }
  
  public static boolean loadLibrary(String paramString1, String paramString2, Context paramContext)
  {
    boolean bool2;
    if (paramContext == null)
    {
      bool2 = false;
      return bool2;
    }
    File localFile2 = new File(getTxLib(paramContext) + "lib" + paramString2 + ".so");
    File localFile1 = localFile2;
    if (!localFile2.exists()) {
      localFile1 = new File(paramContext.getFilesDir().getParent() + "/lib/lib" + paramString2 + ".so");
    }
    if (localFile1.exists()) {}
    for (;;)
    {
      try
      {
        System.load(localFile1.getAbsolutePath());
        boolean bool1 = true;
        bool2 = bool1;
        if (bool1) {
          break;
        }
        bool1 = false;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        try
        {
          System.loadLibrary(paramString2);
          return true;
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          if (!QLog.isColorLevel()) {
            break label207;
          }
          QLog.d(paramString1, 2, "cannot load library " + paramString2);
        }
        paramContext = paramContext;
        if (QLog.isColorLevel()) {
          QLog.d(paramString1, 2, "cannot load library " + localFile1.getAbsolutePath());
        }
      }
    }
    label207:
    return false;
  }
  
  /* Error */
  public static int msfLoadSo(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 66
    //   7: invokestatic 144	com/tencent/qphone/base/util/StringUtils:getPlatformString	()Ljava/lang/String;
    //   10: invokevirtual 148	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   13: ifeq +76 -> 89
    //   16: getstatic 153	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   19: ifnull +20 -> 39
    //   22: getstatic 153	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   25: ifnull +18 -> 43
    //   28: getstatic 153	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   31: ldc 155
    //   33: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   36: ifeq +7 -> 43
    //   39: aconst_null
    //   40: invokestatic 164	com/tencent/commonsdk/soload/SoLoadUtilNew:setReport	(Lcom/tencent/commonsdk/soload/SoLoadReport;)V
    //   43: invokestatic 168	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   46: aload_1
    //   47: invokestatic 174	com/tencent/commonsdk/soload/SoLoadCore:loadSo	(Landroid/content/Context;Ljava/lang/String;)I
    //   50: istore_2
    //   51: aload_0
    //   52: iconst_1
    //   53: new 70	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   60: ldc 176
    //   62: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 178
    //   71: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: iload_2
    //   75: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 183	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: ldc 2
    //   86: monitorexit
    //   87: iload_2
    //   88: ireturn
    //   89: aload_0
    //   90: aload_1
    //   91: invokestatic 168	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   94: invokestatic 185	com/tencent/qphone/base/util/StringUtils:loadLibrary	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)Z
    //   97: istore_3
    //   98: aload_0
    //   99: iconst_1
    //   100: new 70	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   107: ldc 187
    //   109: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 189
    //   118: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_3
    //   122: invokevirtual 192	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   125: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: goto -47 -> 84
    //   134: astore_0
    //   135: ldc 2
    //   137: monitorexit
    //   138: aload_0
    //   139: athrow
    //   140: astore 4
    //   142: aload 4
    //   144: invokevirtual 195	java/lang/Throwable:printStackTrace	()V
    //   147: iconst_0
    //   148: istore_3
    //   149: goto -51 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramString1	String
    //   0	152	1	paramString2	String
    //   1	87	2	i	int
    //   97	52	3	bool	boolean
    //   140	3	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	39	134	finally
    //   39	43	134	finally
    //   43	84	134	finally
    //   89	98	134	finally
    //   98	131	134	finally
    //   142	147	134	finally
    //   89	98	140	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.StringUtils
 * JD-Core Version:    0.7.0.1
 */