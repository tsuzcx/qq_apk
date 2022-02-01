package com.tencent.qqprotect.common;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;

public class QCC
{
  private static Handler a = new Handler(ThreadManager.getFileThreadLooper());
  
  public static void a()
  {
    b(false);
  }
  
  private static void a(long paramLong)
  {
    QCC.1 local1 = new QCC.1();
    a.postDelayed(local1, paramLong);
  }
  
  private static void b(int paramInt, byte[] paramArrayOfByte)
  {
    ThreadManager.post(new QCC.3(paramInt, paramArrayOfByte), 5, null, true);
  }
  
  /* Error */
  private static void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 58
    //   8: iconst_2
    //   9: ldc 60
    //   11: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: getstatic 70	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   17: aconst_null
    //   18: invokevirtual 74	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   21: checkcast 76	com/tencent/mobileqq/app/QQAppInterface
    //   24: astore 6
    //   26: aload 6
    //   28: ifnonnull +10 -> 38
    //   31: ldc2_w 77
    //   34: invokestatic 80	com/tencent/qqprotect/common/QCC:a	(J)V
    //   37: return
    //   38: aload 6
    //   40: invokevirtual 84	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   43: ldc 86
    //   45: iconst_0
    //   46: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   49: astore 6
    //   51: iload_0
    //   52: ifne +41 -> 93
    //   55: aload 6
    //   57: ldc 94
    //   59: lconst_0
    //   60: invokeinterface 100 4 0
    //   65: lstore_2
    //   66: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   69: lstore 4
    //   71: lload 4
    //   73: lload_2
    //   74: lsub
    //   75: lstore_2
    //   76: lload_2
    //   77: ldc2_w 77
    //   80: lcmp
    //   81: ifge +12 -> 93
    //   84: ldc2_w 77
    //   87: lload_2
    //   88: lsub
    //   89: invokestatic 80	com/tencent/qqprotect/common/QCC:a	(J)V
    //   92: return
    //   93: aload 6
    //   95: invokeinterface 110 1 0
    //   100: astore 6
    //   102: aload 6
    //   104: ldc 94
    //   106: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   109: invokeinterface 116 4 0
    //   114: pop
    //   115: aload 6
    //   117: invokeinterface 119 1 0
    //   122: pop
    //   123: ldc 121
    //   125: invokestatic 126	com/tencent/startrail/T:a	(Ljava/lang/String;)I
    //   128: istore_1
    //   129: iload_1
    //   130: ifeq +47 -> 177
    //   133: iload_1
    //   134: bipush 8
    //   136: invokestatic 129	com/tencent/startrail/T:a	(II)[B
    //   139: astore 6
    //   141: aload 6
    //   143: ifnull +15 -> 158
    //   146: aload 6
    //   148: arraylength
    //   149: ifle +9 -> 158
    //   152: iconst_1
    //   153: aload 6
    //   155: invokestatic 32	com/tencent/qqprotect/common/QCC:b	(I[B)V
    //   158: iload_1
    //   159: invokestatic 132	com/tencent/startrail/T:a	(I)V
    //   162: goto +15 -> 177
    //   165: astore 6
    //   167: goto +17 -> 184
    //   170: astore 6
    //   172: aload 6
    //   174: invokevirtual 135	java/lang/Throwable:printStackTrace	()V
    //   177: ldc2_w 77
    //   180: invokestatic 80	com/tencent/qqprotect/common/QCC:a	(J)V
    //   183: return
    //   184: ldc2_w 77
    //   187: invokestatic 80	com/tencent/qqprotect/common/QCC:a	(J)V
    //   190: aload 6
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramBoolean	boolean
    //   128	31	1	i	int
    //   65	23	2	l1	long
    //   69	3	4	l2	long
    //   24	130	6	localObject1	Object
    //   165	1	6	localObject2	Object
    //   170	21	6	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	14	165	finally
    //   14	26	165	finally
    //   38	51	165	finally
    //   55	71	165	finally
    //   93	129	165	finally
    //   133	141	165	finally
    //   146	158	165	finally
    //   158	162	165	finally
    //   172	177	165	finally
    //   0	14	170	java/lang/Throwable
    //   14	26	170	java/lang/Throwable
    //   38	51	170	java/lang/Throwable
    //   55	71	170	java/lang/Throwable
    //   93	129	170	java/lang/Throwable
    //   133	141	170	java/lang/Throwable
    //   146	158	170	java/lang/Throwable
    //   158	162	170	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.common.QCC
 * JD-Core Version:    0.7.0.1
 */