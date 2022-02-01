package com.tencent.ttpic.util;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;

public class NativeProperty
{
  private static final int ARM_FEATURE_ARMv7 = 1;
  private static final int ARM_FEATURE_NEON = 4;
  private static final int FAMILY_ARM = 1;
  private static final int FAMILY_ARM64 = 4;
  private static String cpuABI = "";
  private static int cpuFamily = 1;
  private static int cpuFeature;
  
  public static int cpuFeature()
  {
    return cpuFeature;
  }
  
  public static String getCpuABI()
  {
    return cpuABI;
  }
  
  /* Error */
  public static String getSystemProperty(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 40	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: astore_1
    //   6: new 42	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 45
    //   17: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: new 51	java/io/BufferedReader
    //   30: dup
    //   31: new 53	java/io/InputStreamReader
    //   34: dup
    //   35: aload_1
    //   36: aload_3
    //   37: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 60	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   43: invokevirtual 66	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   46: invokespecial 69	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   49: sipush 1024
    //   52: invokespecial 72	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   55: astore_1
    //   56: aload_1
    //   57: astore_0
    //   58: aload_1
    //   59: invokevirtual 75	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore_2
    //   63: aload_1
    //   64: astore_0
    //   65: aload_1
    //   66: invokevirtual 78	java/io/BufferedReader:close	()V
    //   69: aload_1
    //   70: invokevirtual 78	java/io/BufferedReader:close	()V
    //   73: aload_2
    //   74: areturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokestatic 84	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   80: aload_2
    //   81: areturn
    //   82: astore_2
    //   83: goto +12 -> 95
    //   86: astore_0
    //   87: aload_2
    //   88: astore_1
    //   89: goto +34 -> 123
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: astore_0
    //   97: aload_2
    //   98: invokestatic 84	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   101: aload_1
    //   102: ifnull +14 -> 116
    //   105: aload_1
    //   106: invokevirtual 78	java/io/BufferedReader:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokestatic 84	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_2
    //   119: aload_0
    //   120: astore_1
    //   121: aload_2
    //   122: astore_0
    //   123: aload_1
    //   124: ifnull +15 -> 139
    //   127: aload_1
    //   128: invokevirtual 78	java/io/BufferedReader:close	()V
    //   131: goto +8 -> 139
    //   134: astore_1
    //   135: aload_1
    //   136: invokestatic 84	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   139: aload_0
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   5	123	1	localObject1	Object
    //   134	2	1	localIOException1	java.io.IOException
    //   1	80	2	str	String
    //   82	6	2	localIOException2	java.io.IOException
    //   92	6	2	localIOException3	java.io.IOException
    //   118	4	2	localObject2	Object
    //   13	24	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	73	75	java/io/IOException
    //   58	63	82	java/io/IOException
    //   65	69	82	java/io/IOException
    //   2	56	86	finally
    //   2	56	92	java/io/IOException
    //   105	109	111	java/io/IOException
    //   58	63	118	finally
    //   65	69	118	finally
    //   97	101	118	finally
    //   127	131	134	java/io/IOException
  }
  
  public static boolean hasNeonFeature()
  {
    return (1 == cpuFamily) && ((cpuFeature & 0x4) != 0);
  }
  
  public static void init()
  {
    cpuABI = getSystemProperty("ro.product.cpu.abi");
    String str = cpuABI;
    if ((str != null) && (!str.equals("x86"))) {
      try
      {
        cpuFeature = nGetCpuInfo();
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        LogUtils.e(localUnsatisfiedLinkError);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("NativeProperty init error! ");
        localStringBuilder.append(localUnsatisfiedLinkError);
        ReportUtil.report(localStringBuilder.toString());
        return;
      }
    }
    cpuFeature = 5;
  }
  
  private static native int nGetCpuInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.NativeProperty
 * JD-Core Version:    0.7.0.1
 */