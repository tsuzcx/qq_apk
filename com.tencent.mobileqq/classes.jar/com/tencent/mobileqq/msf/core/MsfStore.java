package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class MsfStore
{
  static NativeConfigStore nativeConfigStore;
  public static int sLoadCfg = 0;
  private static String tag = "MSF.C.MsfStore";
  
  public static NativeConfigStore getNativeConfigStore()
  {
    return nativeConfigStore;
  }
  
  public String get(String paramString)
  {
    return null;
  }
  
  public String[] getArray(String paramString)
  {
    return null;
  }
  
  /* Error */
  public boolean init(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 33	com/tencent/msf/boot/config/NativeConfigStore
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 36	com/tencent/msf/boot/config/NativeConfigStore:<init>	(Landroid/content/Context;)V
    //   10: putstatic 23	com/tencent/mobileqq/msf/core/MsfStore:nativeConfigStore	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   13: aload_1
    //   14: invokestatic 42	com/tencent/mobileqq/msf/core/c:a	(Landroid/content/Context;)Ljava/lang/String;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +32 -> 51
    //   22: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +12 -> 37
    //   28: getstatic 50	com/tencent/mobileqq/msf/core/MsfStore:tag	Ljava/lang/String;
    //   31: iconst_2
    //   32: ldc 52
    //   34: invokestatic 56	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: getstatic 23	com/tencent/mobileqq/msf/core/MsfStore:nativeConfigStore	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   40: getfield 60	com/tencent/msf/boot/config/NativeConfigStore:loadSaveRootSucc	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   43: iconst_0
    //   44: invokevirtual 66	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   47: aload_0
    //   48: monitorexit
    //   49: iconst_0
    //   50: ireturn
    //   51: getstatic 23	com/tencent/mobileqq/msf/core/MsfStore:nativeConfigStore	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   54: aload_2
    //   55: invokevirtual 70	com/tencent/msf/boot/config/NativeConfigStore:setSaveRootPath	(Ljava/lang/String;)V
    //   58: getstatic 23	com/tencent/mobileqq/msf/core/MsfStore:nativeConfigStore	Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   61: aload_1
    //   62: iconst_0
    //   63: invokevirtual 74	com/tencent/msf/boot/config/NativeConfigStore:loadConfig	(Landroid/content/Context;Z)I
    //   66: putstatic 76	com/tencent/mobileqq/msf/core/MsfStore:sLoadCfg	I
    //   69: aload_0
    //   70: monitorexit
    //   71: iconst_1
    //   72: ireturn
    //   73: astore_1
    //   74: getstatic 50	com/tencent/mobileqq/msf/core/MsfStore:tag	Ljava/lang/String;
    //   77: astore_2
    //   78: new 78	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   85: astore_3
    //   86: aload_3
    //   87: ldc 81
    //   89: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_3
    //   94: aload_1
    //   95: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_2
    //   100: iconst_1
    //   101: aload_3
    //   102: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: aload_1
    //   106: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload_0
    //   110: monitorexit
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	MsfStore
    //   0	118	1	paramContext	android.content.Context
    //   17	83	2	str	String
    //   85	17	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	69	73	java/lang/Throwable
    //   2	18	113	finally
    //   22	37	113	finally
    //   37	47	113	finally
    //   51	69	113	finally
    //   74	109	113	finally
  }
  
  public void reportLoadCfgTempFile()
  {
    if (sLoadCfg != 0)
    {
      HashMap localHashMap = new HashMap(8);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(sLoadCfg);
      localStringBuilder.append("");
      localHashMap.put("ret", localStringBuilder.toString());
      MsfCore.sCore.statReporter.a("EvtLodCfgTempFileReport", true, 0L, 0L, localHashMap, false, false);
      QLog.d(tag, 1, "check load config find temp file");
    }
  }
  
  public void save(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.MsfStore
 * JD-Core Version:    0.7.0.1
 */