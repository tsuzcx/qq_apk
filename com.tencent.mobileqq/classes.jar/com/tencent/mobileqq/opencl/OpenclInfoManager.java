package com.tencent.mobileqq.opencl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;
import mqq.app.MobileQQ;

public class OpenclInfoManager
{
  private static String a = "OpenclInfoManager";
  private static boolean b = false;
  private static String c;
  private static Object d = new Object();
  
  static
  {
    a();
  }
  
  public static void a()
  {
    try
    {
      System.loadLibrary("oclInfo");
      b = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      System.out.println(localUnsatisfiedLinkError);
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.startsWith("err")) {
        return;
      }
      Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("qmcf_gpu_config", 4).edit();
      ((SharedPreferences.Editor)localObject).putString("param_ocl_gpuinfo", paramString);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveOclGpuInfo:");
        localStringBuilder.append(paramString);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  private String c()
  {
    return MobileQQ.sMobileQQ.getSharedPreferences("qmcf_gpu_config", 4).getString("param_ocl_gpuinfo", "");
  }
  
  private native String nativeGetOclVersion();
  
  private native String nativeGetPlatformName();
  
  private native int nativeGetSupportedType();
  
  /* Error */
  public String b()
  {
    // Byte code:
    //   0: getstatic 21	com/tencent/mobileqq/opencl/OpenclInfoManager:d	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: getstatic 128	com/tencent/mobileqq/opencl/OpenclInfoManager:c	Ljava/lang/String;
    //   9: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +11 -> 23
    //   15: getstatic 128	com/tencent/mobileqq/opencl/OpenclInfoManager:c	Ljava/lang/String;
    //   18: astore_3
    //   19: aload_2
    //   20: monitorexit
    //   21: aload_3
    //   22: areturn
    //   23: aload_0
    //   24: invokespecial 130	com/tencent/mobileqq/opencl/OpenclInfoManager:c	()Ljava/lang/String;
    //   27: putstatic 128	com/tencent/mobileqq/opencl/OpenclInfoManager:c	Ljava/lang/String;
    //   30: getstatic 128	com/tencent/mobileqq/opencl/OpenclInfoManager:c	Ljava/lang/String;
    //   33: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: istore_1
    //   37: iload_1
    //   38: ifeq +55 -> 93
    //   41: aload_0
    //   42: invokevirtual 133	com/tencent/mobileqq/opencl/OpenclInfoManager:nativeGetGPUInfo	()Ljava/lang/String;
    //   45: putstatic 128	com/tencent/mobileqq/opencl/OpenclInfoManager:c	Ljava/lang/String;
    //   48: aload_0
    //   49: getstatic 128	com/tencent/mobileqq/opencl/OpenclInfoManager:c	Ljava/lang/String;
    //   52: invokespecial 135	com/tencent/mobileqq/opencl/OpenclInfoManager:a	(Ljava/lang/String;)V
    //   55: goto +38 -> 93
    //   58: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +32 -> 93
    //   64: getstatic 97	com/tencent/mobileqq/opencl/OpenclInfoManager:a	Ljava/lang/String;
    //   67: iconst_2
    //   68: ldc 137
    //   70: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: goto +20 -> 93
    //   76: astore_3
    //   77: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +13 -> 93
    //   83: getstatic 97	com/tencent/mobileqq/opencl/OpenclInfoManager:a	Ljava/lang/String;
    //   86: iconst_2
    //   87: ldc 141
    //   89: aload_3
    //   90: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   93: aload_2
    //   94: monitorexit
    //   95: getstatic 128	com/tencent/mobileqq/opencl/OpenclInfoManager:c	Ljava/lang/String;
    //   98: areturn
    //   99: astore_3
    //   100: aload_2
    //   101: monitorexit
    //   102: aload_3
    //   103: athrow
    //   104: astore_3
    //   105: goto -47 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	OpenclInfoManager
    //   36	2	1	bool	boolean
    //   3	98	2	localObject1	Object
    //   18	4	3	str	String
    //   76	14	3	localException	java.lang.Exception
    //   99	4	3	localObject2	Object
    //   104	1	3	localUnsatisfiedLinkError	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   41	55	76	java/lang/Exception
    //   6	21	99	finally
    //   23	37	99	finally
    //   41	55	99	finally
    //   58	73	99	finally
    //   77	93	99	finally
    //   93	95	99	finally
    //   100	102	99	finally
    //   41	55	104	java/lang/UnsatisfiedLinkError
  }
  
  public native String nativeGetGPUInfo();
  
  public native int nativeGetGPUUnit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.opencl.OpenclInfoManager
 * JD-Core Version:    0.7.0.1
 */