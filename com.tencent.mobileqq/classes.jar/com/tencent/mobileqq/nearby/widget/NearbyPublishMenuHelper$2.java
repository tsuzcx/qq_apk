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
    //   0: new 34	android/os/Handler
    //   3: dup
    //   4: invokestatic 40	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   7: invokespecial 43	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   10: astore 4
    //   12: invokestatic 49	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: invokevirtual 53	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   18: astore 5
    //   20: aload 4
    //   22: new 55	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$1
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 58	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$1:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   30: invokevirtual 62	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   33: pop
    //   34: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   37: lstore_1
    //   38: aload_0
    //   39: getfield 19	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:b	Ljava/lang/String;
    //   42: iconst_1
    //   43: iconst_1
    //   44: sipush 1280
    //   47: sipush 1280
    //   50: invokestatic 73	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;IIII)Lorg/json/JSONObject;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnonnull +9 -> 64
    //   58: ldc 75
    //   60: astore_3
    //   61: goto +8 -> 69
    //   64: aload_3
    //   65: invokevirtual 81	org/json/JSONObject:toString	()Ljava/lang/String;
    //   68: astore_3
    //   69: aload 5
    //   71: invokevirtual 86	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   74: aload_3
    //   75: invokestatic 91	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: new 93	android/content/Intent
    //   81: dup
    //   82: aload_0
    //   83: getfield 21	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:c	Landroid/content/Context;
    //   86: ldc 95
    //   88: invokespecial 98	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   91: astore 6
    //   93: aload 6
    //   95: ldc 100
    //   97: aload_0
    //   98: getfield 23	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:d	Ljava/lang/String;
    //   101: invokevirtual 104	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   104: pop
    //   105: ldc 106
    //   107: invokestatic 112	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   110: checkcast 106	com/tencent/biz/pubaccount/util/api/IPublicAccountUtil
    //   113: aload 6
    //   115: aload_0
    //   116: getfield 23	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:d	Ljava/lang/String;
    //   119: invokeinterface 116 3 0
    //   124: aload_0
    //   125: getfield 21	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:c	Landroid/content/Context;
    //   128: instanceof 118
    //   131: ifeq +21 -> 152
    //   134: aload_0
    //   135: getfield 21	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:c	Landroid/content/Context;
    //   138: checkcast 118	android/app/Activity
    //   141: aload 6
    //   143: sipush 1002
    //   146: invokevirtual 122	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   149: goto +12 -> 161
    //   152: aload_0
    //   153: getfield 21	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:c	Landroid/content/Context;
    //   156: aload 6
    //   158: invokevirtual 128	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   161: new 130	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   168: astore 6
    //   170: aload 6
    //   172: ldc 133
    //   174: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 6
    //   180: aload_3
    //   181: invokevirtual 143	java/lang/String:length	()I
    //   184: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 6
    //   190: ldc 148
    //   192: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 6
    //   198: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   201: lload_1
    //   202: lsub
    //   203: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: ldc 153
    //   209: iconst_1
    //   210: aload 6
    //   212: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: new 161	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   221: dup
    //   222: aload_0
    //   223: invokespecial 162	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   226: astore_3
    //   227: goto +126 -> 353
    //   230: astore_3
    //   231: goto +130 -> 361
    //   234: astore_3
    //   235: aload 5
    //   237: invokevirtual 86	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   240: ldc 75
    //   242: invokestatic 91	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: new 130	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   252: astore 5
    //   254: aload 5
    //   256: ldc 164
    //   258: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 5
    //   264: aload_3
    //   265: invokevirtual 165	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   268: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: ldc 153
    //   274: iconst_1
    //   275: aload 5
    //   277: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: new 161	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   286: dup
    //   287: aload_0
    //   288: invokespecial 162	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   291: astore_3
    //   292: goto +61 -> 353
    //   295: astore_3
    //   296: aload 5
    //   298: invokevirtual 86	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   301: ldc 75
    //   303: invokestatic 91	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: new 130	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   313: astore 5
    //   315: aload 5
    //   317: ldc 170
    //   319: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 5
    //   325: aload_3
    //   326: invokevirtual 171	java/lang/Exception:toString	()Ljava/lang/String;
    //   329: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: ldc 153
    //   335: iconst_1
    //   336: aload 5
    //   338: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: new 161	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   347: dup
    //   348: aload_0
    //   349: invokespecial 162	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   352: astore_3
    //   353: aload 4
    //   355: aload_3
    //   356: invokevirtual 62	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   359: pop
    //   360: return
    //   361: aload 4
    //   363: new 161	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   366: dup
    //   367: aload_0
    //   368: invokespecial 162	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   371: invokevirtual 62	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   374: pop
    //   375: aload_3
    //   376: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	2
    //   37	165	1	l	long
    //   53	174	3	localObject1	Object
    //   230	1	3	localObject2	Object
    //   234	31	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   291	1	3	local21	NearbyPublishMenuHelper.2.2
    //   295	31	3	localException	java.lang.Exception
    //   352	24	3	local22	NearbyPublishMenuHelper.2.2
    //   10	352	4	localHandler	android.os.Handler
    //   18	319	5	localObject3	Object
    //   91	120	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   20	54	230	finally
    //   64	69	230	finally
    //   69	149	230	finally
    //   152	161	230	finally
    //   161	218	230	finally
    //   235	283	230	finally
    //   296	344	230	finally
    //   20	54	234	java/lang/OutOfMemoryError
    //   64	69	234	java/lang/OutOfMemoryError
    //   69	149	234	java/lang/OutOfMemoryError
    //   152	161	234	java/lang/OutOfMemoryError
    //   161	218	234	java/lang/OutOfMemoryError
    //   20	54	295	java/lang/Exception
    //   64	69	295	java/lang/Exception
    //   69	149	295	java/lang/Exception
    //   152	161	295	java/lang/Exception
    //   161	218	295	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper.2
 * JD-Core Version:    0.7.0.1
 */