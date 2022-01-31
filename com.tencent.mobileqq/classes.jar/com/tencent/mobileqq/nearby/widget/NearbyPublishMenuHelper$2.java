package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import bepp;

public final class NearbyPublishMenuHelper$2
  implements Runnable
{
  public NearbyPublishMenuHelper$2(bepp parambepp, String paramString1, Context paramContext, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 32	android/os/Handler
    //   3: dup
    //   4: invokestatic 38	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   7: invokespecial 41	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   10: astore 4
    //   12: invokestatic 47	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: invokevirtual 51	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   18: astore 5
    //   20: aload 4
    //   22: new 53	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$1
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 56	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$1:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   30: invokevirtual 60	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   33: pop
    //   34: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   37: lstore_1
    //   38: aload_0
    //   39: getfield 17	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: iconst_1
    //   43: iconst_1
    //   44: sipush 1280
    //   47: sipush 1280
    //   50: invokestatic 71	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;IIII)Lorg/json/JSONObject;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnonnull +132 -> 187
    //   58: ldc 73
    //   60: astore_3
    //   61: aload 5
    //   63: invokevirtual 79	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   66: aload_3
    //   67: invokestatic 84	avpq:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: new 86	android/content/Intent
    //   73: dup
    //   74: aload_0
    //   75: getfield 19	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   78: ldc 88
    //   80: invokespecial 91	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   83: astore 6
    //   85: aload 6
    //   87: ldc 93
    //   89: aload_0
    //   90: getfield 21	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:b	Ljava/lang/String;
    //   93: invokevirtual 97	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   96: pop
    //   97: aload 6
    //   99: aload_0
    //   100: getfield 21	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:b	Ljava/lang/String;
    //   103: invokestatic 102	syb:a	(Landroid/content/Intent;Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 19	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   110: instanceof 104
    //   113: ifeq +82 -> 195
    //   116: aload_0
    //   117: getfield 19	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   120: checkcast 104	android/app/Activity
    //   123: aload 6
    //   125: sipush 1002
    //   128: invokevirtual 108	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   131: ldc 110
    //   133: iconst_1
    //   134: new 112	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   141: ldc 115
    //   143: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_3
    //   147: invokevirtual 125	java/lang/String:length	()I
    //   150: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc 130
    //   155: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   161: lload_1
    //   162: lsub
    //   163: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   166: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload 4
    //   174: new 144	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   177: dup
    //   178: aload_0
    //   179: invokespecial 145	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   182: invokevirtual 60	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   185: pop
    //   186: return
    //   187: aload_3
    //   188: invokevirtual 148	org/json/JSONObject:toString	()Ljava/lang/String;
    //   191: astore_3
    //   192: goto -131 -> 61
    //   195: aload_0
    //   196: getfield 19	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   199: aload 6
    //   201: invokevirtual 154	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   204: goto -73 -> 131
    //   207: astore_3
    //   208: aload 5
    //   210: invokevirtual 79	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   213: ldc 73
    //   215: invokestatic 84	avpq:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: ldc 110
    //   220: iconst_1
    //   221: new 112	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   228: ldc 156
    //   230: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_3
    //   234: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
    //   237: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload 4
    //   248: new 144	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   251: dup
    //   252: aload_0
    //   253: invokespecial 145	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   256: invokevirtual 60	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   259: pop
    //   260: return
    //   261: astore_3
    //   262: aload 5
    //   264: invokevirtual 79	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   267: ldc 73
    //   269: invokestatic 84	avpq:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: ldc 110
    //   274: iconst_1
    //   275: new 112	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   282: ldc 162
    //   284: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_3
    //   288: invokevirtual 163	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   291: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload 4
    //   302: new 144	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   305: dup
    //   306: aload_0
    //   307: invokespecial 145	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   310: invokevirtual 60	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   313: pop
    //   314: return
    //   315: astore_3
    //   316: aload 4
    //   318: new 144	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   321: dup
    //   322: aload_0
    //   323: invokespecial 145	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   326: invokevirtual 60	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   329: pop
    //   330: aload_3
    //   331: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	2
    //   37	125	1	l	long
    //   53	139	3	localObject1	Object
    //   207	27	3	localException	java.lang.Exception
    //   261	27	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   315	16	3	localObject2	Object
    //   10	307	4	localHandler	android.os.Handler
    //   18	245	5	localAppRuntime	mqq.app.AppRuntime
    //   83	117	6	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   20	54	207	java/lang/Exception
    //   61	131	207	java/lang/Exception
    //   131	172	207	java/lang/Exception
    //   187	192	207	java/lang/Exception
    //   195	204	207	java/lang/Exception
    //   20	54	261	java/lang/OutOfMemoryError
    //   61	131	261	java/lang/OutOfMemoryError
    //   131	172	261	java/lang/OutOfMemoryError
    //   187	192	261	java/lang/OutOfMemoryError
    //   195	204	261	java/lang/OutOfMemoryError
    //   20	54	315	finally
    //   61	131	315	finally
    //   131	172	315	finally
    //   187	192	315	finally
    //   195	204	315	finally
    //   208	246	315	finally
    //   262	300	315	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper.2
 * JD-Core Version:    0.7.0.1
 */