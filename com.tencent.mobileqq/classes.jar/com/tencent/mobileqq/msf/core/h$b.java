package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Looper;

class h$b
  extends Handler
{
  public h$b(h paramh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 24	android/os/Message:what	I
    //   4: istore_2
    //   5: iload_2
    //   6: iconst_1
    //   7: if_icmpeq +382 -> 389
    //   10: iload_2
    //   11: iconst_2
    //   12: if_icmpeq +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   20: invokestatic 29	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/mobileqq/msf/core/h;)Z
    //   23: ifeq +47 -> 70
    //   26: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +40 -> 69
    //   32: new 37	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   39: astore_1
    //   40: aload_1
    //   41: ldc 42
    //   43: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_1
    //   48: aload_0
    //   49: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   52: getfield 50	com/tencent/mobileqq/msf/core/h:b	Landroid/net/Network;
    //   55: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 55
    //   61: iconst_2
    //   62: aload_1
    //   63: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: return
    //   70: aload_0
    //   71: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   74: invokevirtual 65	com/tencent/mobileqq/msf/core/h:a	()Z
    //   77: ifne +47 -> 124
    //   80: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +40 -> 123
    //   86: new 37	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   93: astore_1
    //   94: aload_1
    //   95: ldc 67
    //   97: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_1
    //   102: aload_0
    //   103: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   106: getfield 50	com/tencent/mobileqq/msf/core/h:b	Landroid/net/Network;
    //   109: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: ldc 55
    //   115: iconst_2
    //   116: aload_1
    //   117: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: return
    //   124: aload_0
    //   125: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   128: invokestatic 29	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/mobileqq/msf/core/h;)Z
    //   131: ifne +326 -> 457
    //   134: aload_0
    //   135: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   138: getfield 71	com/tencent/mobileqq/msf/core/h:e	Ljava/util/concurrent/LinkedBlockingQueue;
    //   141: invokevirtual 77	java/util/concurrent/LinkedBlockingQueue:size	()I
    //   144: ifle +313 -> 457
    //   147: aload_0
    //   148: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   151: getfield 71	com/tencent/mobileqq/msf/core/h:e	Ljava/util/concurrent/LinkedBlockingQueue;
    //   154: invokevirtual 81	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
    //   157: checkcast 83	com/tencent/qphone/base/remote/ToServiceMsg
    //   160: astore 4
    //   162: aload 4
    //   164: ifnonnull +6 -> 170
    //   167: goto -43 -> 124
    //   170: new 85	com/tencent/mobileqq/msf/core/quicksend/g
    //   173: dup
    //   174: invokespecial 86	com/tencent/mobileqq/msf/core/quicksend/g:<init>	()V
    //   177: astore 5
    //   179: aload 5
    //   181: invokestatic 92	android/os/SystemClock:elapsedRealtime	()J
    //   184: putfield 95	com/tencent/mobileqq/msf/core/quicksend/g:b	J
    //   187: aload 5
    //   189: aload 5
    //   191: getfield 95	com/tencent/mobileqq/msf/core/quicksend/g:b	J
    //   194: putfield 98	com/tencent/mobileqq/msf/core/quicksend/g:j	J
    //   197: aload 5
    //   199: aload 5
    //   201: getfield 95	com/tencent/mobileqq/msf/core/quicksend/g:b	J
    //   204: putfield 101	com/tencent/mobileqq/msf/core/quicksend/g:g	J
    //   207: aload_0
    //   208: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   211: aload 4
    //   213: invokestatic 104	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/mobileqq/msf/core/h;Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   216: astore 6
    //   218: aload 4
    //   220: invokevirtual 108	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   223: ldc 110
    //   225: invokevirtual 116	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   228: ifeq +91 -> 319
    //   231: aload 4
    //   233: invokevirtual 108	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   236: ldc 110
    //   238: invokevirtual 120	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   241: ifnull +78 -> 319
    //   244: aload 4
    //   246: invokevirtual 108	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   249: ldc 110
    //   251: invokevirtual 120	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   254: checkcast 122	java/lang/String
    //   257: astore_3
    //   258: aload_3
    //   259: astore_1
    //   260: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +59 -> 322
    //   266: new 37	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   273: astore_1
    //   274: aload_1
    //   275: ldc 124
    //   277: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_1
    //   282: aload 4
    //   284: invokevirtual 127	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   287: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_1
    //   292: ldc 132
    //   294: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_1
    //   299: aload_3
    //   300: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: ldc 55
    //   306: iconst_2
    //   307: aload_1
    //   308: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload_3
    //   315: astore_1
    //   316: goto +6 -> 322
    //   319: ldc 134
    //   321: astore_1
    //   322: aload_0
    //   323: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   326: invokestatic 136	com/tencent/mobileqq/msf/core/h:b	(Lcom/tencent/mobileqq/msf/core/h;)Z
    //   329: ifne +23 -> 352
    //   332: aload_0
    //   333: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   336: aload 4
    //   338: aload 5
    //   340: aload 6
    //   342: aload_1
    //   343: invokestatic 139	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/mobileqq/msf/core/h;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/mobileqq/msf/core/quicksend/g;Ljava/lang/String;Ljava/lang/String;)Z
    //   346: ifne +6 -> 352
    //   349: goto -225 -> 124
    //   352: aload_0
    //   353: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   356: aload 5
    //   358: aload 4
    //   360: invokestatic 142	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/mobileqq/msf/core/h;Lcom/tencent/mobileqq/msf/core/quicksend/g;Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   363: pop
    //   364: aload_0
    //   365: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   368: invokestatic 136	com/tencent/mobileqq/msf/core/h:b	(Lcom/tencent/mobileqq/msf/core/h;)Z
    //   371: ifne -247 -> 124
    //   374: aload_0
    //   375: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   378: getfield 145	com/tencent/mobileqq/msf/core/h:a	Lcom/tencent/mobileqq/msf/core/net/b;
    //   381: invokeinterface 150 1 0
    //   386: goto -262 -> 124
    //   389: aload_0
    //   390: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   393: getfield 71	com/tencent/mobileqq/msf/core/h:e	Ljava/util/concurrent/LinkedBlockingQueue;
    //   396: invokevirtual 153	java/util/concurrent/LinkedBlockingQueue:clear	()V
    //   399: aload_0
    //   400: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   403: getfield 145	com/tencent/mobileqq/msf/core/h:a	Lcom/tencent/mobileqq/msf/core/net/b;
    //   406: invokeinterface 150 1 0
    //   411: aload_0
    //   412: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   415: getfield 145	com/tencent/mobileqq/msf/core/h:a	Lcom/tencent/mobileqq/msf/core/net/b;
    //   418: invokeinterface 155 1 0
    //   423: aload_0
    //   424: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   427: invokestatic 158	com/tencent/mobileqq/msf/core/h:c	(Lcom/tencent/mobileqq/msf/core/h;)Landroid/content/Context;
    //   430: invokestatic 163	com/tencent/mobileqq/msf/core/net/l:c	(Landroid/content/Context;)V
    //   433: return
    //   434: astore_1
    //   435: goto +23 -> 458
    //   438: astore_1
    //   439: ldc 55
    //   441: iconst_1
    //   442: aload_1
    //   443: invokevirtual 166	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   446: aload_1
    //   447: invokestatic 170	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   450: aload_1
    //   451: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   454: goto -31 -> 423
    //   457: return
    //   458: aload_0
    //   459: getfield 10	com/tencent/mobileqq/msf/core/h$b:a	Lcom/tencent/mobileqq/msf/core/h;
    //   462: invokestatic 158	com/tencent/mobileqq/msf/core/h:c	(Lcom/tencent/mobileqq/msf/core/h;)Landroid/content/Context;
    //   465: invokestatic 163	com/tencent/mobileqq/msf/core/net/l:c	(Landroid/content/Context;)V
    //   468: goto +5 -> 473
    //   471: aload_1
    //   472: athrow
    //   473: goto -2 -> 471
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	b
    //   0	476	1	paramMessage	android.os.Message
    //   4	9	2	i	int
    //   257	58	3	str1	java.lang.String
    //   160	199	4	localToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   177	180	5	localg	com.tencent.mobileqq.msf.core.quicksend.g
    //   216	125	6	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   389	423	434	finally
    //   439	454	434	finally
    //   389	423	438	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.h.b
 * JD-Core Version:    0.7.0.1
 */