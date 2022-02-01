package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import com.tencent.mobileqq.widget.QQProgressDialog;

final class NearbyPublishMenuHelper$2
  implements Runnable
{
  NearbyPublishMenuHelper$2(QQProgressDialog paramQQProgressDialog, String paramString1, Context paramContext, String paramString2) {}
  
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
    //   55: ifnonnull +142 -> 197
    //   58: ldc 73
    //   60: astore_3
    //   61: aload 5
    //   63: invokevirtual 79	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   66: aload_3
    //   67: invokestatic 84	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper:b	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   97: ldc 99
    //   99: invokestatic 105	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   102: checkcast 99	com/tencent/biz/pubaccount/util/api/IPublicAccountUtil
    //   105: aload 6
    //   107: aload_0
    //   108: getfield 21	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:b	Ljava/lang/String;
    //   111: invokeinterface 109 3 0
    //   116: aload_0
    //   117: getfield 19	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   120: instanceof 111
    //   123: ifeq +82 -> 205
    //   126: aload_0
    //   127: getfield 19	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   130: checkcast 111	android/app/Activity
    //   133: aload 6
    //   135: sipush 1002
    //   138: invokevirtual 115	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   141: ldc 117
    //   143: iconst_1
    //   144: new 119	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   151: ldc 122
    //   153: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_3
    //   157: invokevirtual 132	java/lang/String:length	()I
    //   160: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: ldc 137
    //   165: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   171: lload_1
    //   172: lsub
    //   173: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   176: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload 4
    //   184: new 151	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   187: dup
    //   188: aload_0
    //   189: invokespecial 152	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   192: invokevirtual 60	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   195: pop
    //   196: return
    //   197: aload_3
    //   198: invokevirtual 155	org/json/JSONObject:toString	()Ljava/lang/String;
    //   201: astore_3
    //   202: goto -141 -> 61
    //   205: aload_0
    //   206: getfield 19	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   209: aload 6
    //   211: invokevirtual 161	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   214: goto -73 -> 141
    //   217: astore_3
    //   218: aload 5
    //   220: invokevirtual 79	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   223: ldc 73
    //   225: invokestatic 84	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: ldc 117
    //   230: iconst_1
    //   231: new 119	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   238: ldc 163
    //   240: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_3
    //   244: invokevirtual 164	java/lang/Exception:toString	()Ljava/lang/String;
    //   247: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: aload 4
    //   258: new 151	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   261: dup
    //   262: aload_0
    //   263: invokespecial 152	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   266: invokevirtual 60	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   269: pop
    //   270: return
    //   271: astore_3
    //   272: aload 5
    //   274: invokevirtual 79	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   277: ldc 73
    //   279: invokestatic 84	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: ldc 117
    //   284: iconst_1
    //   285: new 119	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   292: ldc 169
    //   294: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_3
    //   298: invokevirtual 170	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   301: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: aload 4
    //   312: new 151	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   315: dup
    //   316: aload_0
    //   317: invokespecial 152	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   320: invokevirtual 60	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   323: pop
    //   324: return
    //   325: astore_3
    //   326: aload 4
    //   328: new 151	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   331: dup
    //   332: aload_0
    //   333: invokespecial 152	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   336: invokevirtual 60	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   339: pop
    //   340: aload_3
    //   341: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	2
    //   37	135	1	l	long
    //   53	149	3	localObject1	Object
    //   217	27	3	localException	java.lang.Exception
    //   271	27	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   325	16	3	localObject2	Object
    //   10	317	4	localHandler	android.os.Handler
    //   18	255	5	localAppRuntime	mqq.app.AppRuntime
    //   83	127	6	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   20	54	217	java/lang/Exception
    //   61	141	217	java/lang/Exception
    //   141	182	217	java/lang/Exception
    //   197	202	217	java/lang/Exception
    //   205	214	217	java/lang/Exception
    //   20	54	271	java/lang/OutOfMemoryError
    //   61	141	271	java/lang/OutOfMemoryError
    //   141	182	271	java/lang/OutOfMemoryError
    //   197	202	271	java/lang/OutOfMemoryError
    //   205	214	271	java/lang/OutOfMemoryError
    //   20	54	325	finally
    //   61	141	325	finally
    //   141	182	325	finally
    //   197	202	325	finally
    //   205	214	325	finally
    //   218	256	325	finally
    //   272	310	325	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper.2
 * JD-Core Version:    0.7.0.1
 */