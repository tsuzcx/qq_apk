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
  private static final String TAG_LOAD_MSF = "LoadMSFSo";
  
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
    if ((paramInt & 0x2) == 2) {
      return true;
    }
    return (paramInt & 0x40000) == 262144;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getParent());
    localStringBuilder.append("/txlib/");
    return localStringBuilder.toString();
  }
  
  public static boolean loadLibrary(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = new File(paramString2);
    boolean bool1;
    if (paramContext.exists()) {
      try
      {
        System.load(paramContext.getAbsolutePath());
        bool1 = true;
      }
      catch (Throwable paramString2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cannot load library ");
        localStringBuilder.append(paramContext.getAbsolutePath());
        QLog.e(paramString1, 1, localStringBuilder.toString(), paramString2);
      }
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(paramString3)) {
        try
        {
          System.loadLibrary(paramString3);
          return true;
        }
        catch (Throwable paramContext)
        {
          paramString2 = new StringBuilder();
          paramString2.append("cannot load system library ");
          paramString2.append(paramString3);
          QLog.e(paramString1, 1, paramString2.toString(), paramContext);
          bool2 = false;
        }
      }
    }
    return bool2;
  }
  
  public static boolean loadLibrary(String paramString1, String paramString2, Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getTxLib(paramContext));
    ((StringBuilder)localObject).append("lib");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(".so");
    File localFile = new File(((StringBuilder)localObject).toString());
    localObject = localFile;
    if (!localFile.exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getFilesDir().getParent());
      ((StringBuilder)localObject).append("/lib/lib");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(".so");
      localObject = new File(((StringBuilder)localObject).toString());
    }
    if (((File)localObject).exists()) {}
    try
    {
      System.load(((File)localObject).getAbsolutePath());
      bool = true;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      boolean bool;
      label154:
      break label154;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("cannot load library ");
      paramContext.append(((File)localObject).getAbsolutePath());
      QLog.d(paramString1, 2, paramContext.toString());
    }
    bool = false;
    if (!bool) {}
    try
    {
      System.loadLibrary(paramString2);
      return true;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      label206:
      break label206;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("cannot load library ");
      paramContext.append(paramString2);
      QLog.d(paramString1, 2, paramContext.toString());
    }
    return false;
    return bool;
  }
  
  /* Error */
  public static int msfLoadSo(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 123	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   7: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +46 -> 56
    //   13: new 73	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: ldc 147
    //   26: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: ldc 149
    //   41: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 17
    //   47: iconst_2
    //   48: aload 4
    //   50: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: ldc 2
    //   58: monitorexit
    //   59: ldc 51
    //   61: ireturn
    //   62: astore_0
    //   63: goto +192 -> 255
    //   66: astore 4
    //   68: iconst_0
    //   69: istore_2
    //   70: ldc 17
    //   72: iconst_1
    //   73: aload 4
    //   75: iconst_0
    //   76: anewarray 4	java/lang/Object
    //   79: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   82: ldc 69
    //   84: invokestatic 154	com/tencent/qphone/base/util/StringUtils:getPlatformString	()Ljava/lang/String;
    //   87: invokevirtual 158	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   90: ifeq +90 -> 180
    //   93: getstatic 163	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   96: ifnull +20 -> 116
    //   99: getstatic 163	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   102: ifnull +18 -> 120
    //   105: getstatic 163	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   108: ldc 165
    //   110: invokevirtual 168	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   113: ifeq +7 -> 120
    //   116: aconst_null
    //   117: invokestatic 174	com/tencent/commonsdk/soload/SoLoadUtilNew:setReport	(Lcom/tencent/commonsdk/soload/SoLoadReport;)V
    //   120: invokestatic 178	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   123: aload_1
    //   124: invokestatic 184	com/tencent/commonsdk/soload/SoLoadCore:loadSo	(Landroid/content/Context;Ljava/lang/String;)I
    //   127: istore_2
    //   128: new 73	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   135: astore 4
    //   137: aload 4
    //   139: ldc 186
    //   141: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 4
    //   147: aload_1
    //   148: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 4
    //   154: ldc 188
    //   156: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 4
    //   162: iload_2
    //   163: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_0
    //   168: iconst_1
    //   169: aload 4
    //   171: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: goto +73 -> 250
    //   180: aload_0
    //   181: aload_1
    //   182: invokestatic 178	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   185: invokestatic 195	com/tencent/qphone/base/util/StringUtils:loadLibrary	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)Z
    //   188: istore_3
    //   189: goto +12 -> 201
    //   192: astore 4
    //   194: aload 4
    //   196: invokevirtual 198	java/lang/Throwable:printStackTrace	()V
    //   199: iconst_0
    //   200: istore_3
    //   201: new 73	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   208: astore 4
    //   210: aload 4
    //   212: ldc 200
    //   214: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 4
    //   220: aload_1
    //   221: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 4
    //   227: ldc 202
    //   229: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 4
    //   235: iload_3
    //   236: invokevirtual 205	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_0
    //   241: iconst_1
    //   242: aload 4
    //   244: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: ldc 2
    //   252: monitorexit
    //   253: iload_2
    //   254: ireturn
    //   255: ldc 2
    //   257: monitorexit
    //   258: aload_0
    //   259: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramString1	String
    //   0	260	1	paramString2	String
    //   69	185	2	i	int
    //   188	48	3	bool	boolean
    //   20	29	4	localStringBuilder1	StringBuilder
    //   66	8	4	localThrowable1	Throwable
    //   135	35	4	localStringBuilder2	StringBuilder
    //   192	3	4	localThrowable2	Throwable
    //   208	35	4	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	56	62	finally
    //   70	116	62	finally
    //   116	120	62	finally
    //   120	177	62	finally
    //   180	189	62	finally
    //   194	199	62	finally
    //   201	250	62	finally
    //   3	56	66	java/lang/Throwable
    //   180	189	192	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.StringUtils
 * JD-Core Version:    0.7.0.1
 */