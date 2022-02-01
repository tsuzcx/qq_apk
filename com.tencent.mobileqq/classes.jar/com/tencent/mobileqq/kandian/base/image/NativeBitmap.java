package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SoLoadUtil;

public class NativeBitmap
{
  static boolean a = SoLoadUtil.a(BaseApplicationImpl.getApplication(), "readinjoybitmaps", 0, true);
  
  /* Error */
  static
  {
    // Byte code:
    //   0: invokestatic 17	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: ldc 19
    //   5: iconst_0
    //   6: iconst_1
    //   7: invokestatic 24	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;IZ)Z
    //   10: putstatic 26	com/tencent/mobileqq/kandian/base/image/NativeBitmap:a	Z
    //   13: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +136 -> 152
    //   19: new 34	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   26: astore_0
    //   27: aload_0
    //   28: ldc 39
    //   30: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_0
    //   35: getstatic 26	com/tencent/mobileqq/kandian/base/image/NativeBitmap:a	Z
    //   38: invokevirtual 46	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 48
    //   44: aload_0
    //   45: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 57	com/tencent/mobileqq/kandian/base/image/imageloader/Utils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: return
    //   52: astore_0
    //   53: goto +100 -> 153
    //   56: iconst_0
    //   57: putstatic 26	com/tencent/mobileqq/kandian/base/image/NativeBitmap:a	Z
    //   60: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq +10 -> 73
    //   66: ldc 48
    //   68: ldc 59
    //   70: invokestatic 57	com/tencent/mobileqq/kandian/base/image/imageloader/Utils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: getstatic 63	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   76: iconst_1
    //   77: if_icmpne +58 -> 135
    //   80: new 65	java/util/HashMap
    //   83: dup
    //   84: invokespecial 66	java/util/HashMap:<init>	()V
    //   87: astore_0
    //   88: aload_0
    //   89: ldc 68
    //   91: getstatic 74	android/os/Build:MODEL	Ljava/lang/String;
    //   94: invokevirtual 78	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: aload_0
    //   99: ldc 80
    //   101: getstatic 85	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   104: invokevirtual 78	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_0
    //   109: ldc 87
    //   111: getstatic 90	android/os/Build:BRAND	Ljava/lang/String;
    //   114: invokevirtual 78	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: invokestatic 17	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   121: invokestatic 96	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   124: aconst_null
    //   125: ldc 98
    //   127: iconst_0
    //   128: lconst_0
    //   129: lconst_0
    //   130: aload_0
    //   131: aconst_null
    //   132: invokevirtual 102	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   135: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +14 -> 152
    //   141: new 34	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   148: astore_0
    //   149: goto -122 -> 27
    //   152: return
    //   153: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +35 -> 191
    //   159: new 34	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   166: astore_1
    //   167: aload_1
    //   168: ldc 39
    //   170: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_1
    //   175: getstatic 26	com/tencent/mobileqq/kandian/base/image/NativeBitmap:a	Z
    //   178: invokevirtual 46	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: ldc 48
    //   184: aload_1
    //   185: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 57	com/tencent/mobileqq/kandian/base/image/imageloader/Utils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: goto +5 -> 196
    //   194: aload_0
    //   195: athrow
    //   196: goto -2 -> 194
    //   199: astore_0
    //   200: goto -144 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	19	0	localStringBuilder1	java.lang.StringBuilder
    //   52	1	0	localObject1	Object
    //   87	108	0	localObject2	Object
    //   199	1	0	localException	java.lang.Exception
    //   166	19	1	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	13	52	finally
    //   56	73	52	finally
    //   73	135	52	finally
    //   0	13	199	java/lang/Exception
  }
  
  public static native void nativePinBitmap(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.NativeBitmap
 * JD-Core Version:    0.7.0.1
 */