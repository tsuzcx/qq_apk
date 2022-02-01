package com.tencent.mobileqq.opencl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;

public class OpenclInfoManager
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString = "OpenclInfoManager";
  private static boolean jdField_a_of_type_Boolean = false;
  private static String b;
  
  static
  {
    a();
  }
  
  public static void a()
  {
    try
    {
      System.loadLibrary("oclInfo");
      jdField_a_of_type_Boolean = true;
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
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).edit();
      ((SharedPreferences.Editor)localObject).putString("param_ocl_gpuinfo", paramString);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveOclGpuInfo:");
        localStringBuilder.append(paramString);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  private String b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).getString("param_ocl_gpuinfo", "");
  }
  
  private native String nativeGetOclVersion();
  
  private native String nativeGetPlatformName();
  
  private native int nativeGetSupportedType();
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: getstatic 19	com/tencent/mobileqq/opencl/OpenclInfoManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: getstatic 126	com/tencent/mobileqq/opencl/OpenclInfoManager:b	Ljava/lang/String;
    //   9: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +11 -> 23
    //   15: getstatic 126	com/tencent/mobileqq/opencl/OpenclInfoManager:b	Ljava/lang/String;
    //   18: astore_3
    //   19: aload_2
    //   20: monitorexit
    //   21: aload_3
    //   22: areturn
    //   23: aload_0
    //   24: invokespecial 128	com/tencent/mobileqq/opencl/OpenclInfoManager:b	()Ljava/lang/String;
    //   27: putstatic 126	com/tencent/mobileqq/opencl/OpenclInfoManager:b	Ljava/lang/String;
    //   30: getstatic 126	com/tencent/mobileqq/opencl/OpenclInfoManager:b	Ljava/lang/String;
    //   33: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: istore_1
    //   37: iload_1
    //   38: ifeq +55 -> 93
    //   41: aload_0
    //   42: invokevirtual 131	com/tencent/mobileqq/opencl/OpenclInfoManager:nativeGetGPUInfo	()Ljava/lang/String;
    //   45: putstatic 126	com/tencent/mobileqq/opencl/OpenclInfoManager:b	Ljava/lang/String;
    //   48: aload_0
    //   49: getstatic 126	com/tencent/mobileqq/opencl/OpenclInfoManager:b	Ljava/lang/String;
    //   52: invokespecial 133	com/tencent/mobileqq/opencl/OpenclInfoManager:a	(Ljava/lang/String;)V
    //   55: goto +38 -> 93
    //   58: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +32 -> 93
    //   64: getstatic 95	com/tencent/mobileqq/opencl/OpenclInfoManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   67: iconst_2
    //   68: ldc 135
    //   70: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: goto +20 -> 93
    //   76: astore_3
    //   77: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +13 -> 93
    //   83: getstatic 95	com/tencent/mobileqq/opencl/OpenclInfoManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: iconst_2
    //   87: ldc 140
    //   89: aload_3
    //   90: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   93: aload_2
    //   94: monitorexit
    //   95: getstatic 126	com/tencent/mobileqq/opencl/OpenclInfoManager:b	Ljava/lang/String;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.opencl.OpenclInfoManager
 * JD-Core Version:    0.7.0.1
 */