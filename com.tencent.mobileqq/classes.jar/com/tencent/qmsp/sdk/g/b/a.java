package com.tencent.qmsp.sdk.g.b;

public class a
{
  /* Error */
  public static a.a a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 15	com/tencent/qmsp/sdk/g/b/a:a	()Ljava/lang/String;
    //   3: astore_1
    //   4: new 17	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   11: astore_2
    //   12: aload_2
    //   13: ldc 23
    //   15: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_2
    //   20: invokestatic 33	java/lang/System:currentTimeMillis	()J
    //   23: invokevirtual 36	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_1
    //   28: aload_2
    //   29: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 45	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   35: pop
    //   36: invokestatic 51	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   39: invokestatic 54	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   42: if_acmpeq +165 -> 207
    //   45: aload_0
    //   46: invokevirtual 60	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   49: ldc 62
    //   51: iconst_0
    //   52: invokevirtual 68	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   55: pop
    //   56: new 70	com/tencent/qmsp/sdk/g/b/b
    //   59: dup
    //   60: invokespecial 71	com/tencent/qmsp/sdk/g/b/b:<init>	()V
    //   63: astore_2
    //   64: new 73	android/content/Intent
    //   67: dup
    //   68: ldc 75
    //   70: invokespecial 78	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   73: astore_1
    //   74: aload_1
    //   75: ldc 62
    //   77: invokevirtual 82	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   80: pop
    //   81: aload_0
    //   82: aload_1
    //   83: aload_2
    //   84: iconst_1
    //   85: invokevirtual 86	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   88: ifeq +104 -> 192
    //   91: invokestatic 15	com/tencent/qmsp/sdk/g/b/a:a	()Ljava/lang/String;
    //   94: ldc 88
    //   96: invokestatic 45	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   99: pop
    //   100: aload_2
    //   101: getfield 91	com/tencent/qmsp/sdk/g/b/b:a	Z
    //   104: ifne +49 -> 153
    //   107: aload_2
    //   108: iconst_1
    //   109: putfield 91	com/tencent/qmsp/sdk/g/b/b:a	Z
    //   112: aload_2
    //   113: getfield 95	com/tencent/qmsp/sdk/g/b/b:b	Ljava/util/concurrent/LinkedBlockingQueue;
    //   116: invokevirtual 101	java/util/concurrent/LinkedBlockingQueue:take	()Ljava/lang/Object;
    //   119: checkcast 103	android/os/IBinder
    //   122: invokestatic 108	com/tencent/qmsp/sdk/g/b/d$a:a	(Landroid/os/IBinder;)Lcom/tencent/qmsp/sdk/g/b/d;
    //   125: astore_1
    //   126: new 110	com/tencent/qmsp/sdk/g/b/a$a
    //   129: dup
    //   130: aload_1
    //   131: invokeinterface 114 1 0
    //   136: aload_1
    //   137: invokeinterface 118 1 0
    //   142: invokespecial 121	com/tencent/qmsp/sdk/g/b/a$a:<init>	(Ljava/lang/String;Z)V
    //   145: astore_1
    //   146: aload_0
    //   147: aload_2
    //   148: invokevirtual 125	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   151: aload_1
    //   152: areturn
    //   153: new 127	java/lang/IllegalStateException
    //   156: dup
    //   157: invokespecial 128	java/lang/IllegalStateException:<init>	()V
    //   160: athrow
    //   161: astore_1
    //   162: goto +23 -> 185
    //   165: ldc 130
    //   167: astore_1
    //   168: goto +6 -> 174
    //   171: ldc 132
    //   173: astore_1
    //   174: aload_1
    //   175: invokestatic 136	com/tencent/qmsp/sdk/base/c:b	(Ljava/lang/String;)V
    //   178: aload_0
    //   179: aload_2
    //   180: invokevirtual 125	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   183: aconst_null
    //   184: areturn
    //   185: aload_0
    //   186: aload_2
    //   187: invokevirtual 125	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   190: aload_1
    //   191: athrow
    //   192: ldc 138
    //   194: astore_0
    //   195: aload_0
    //   196: invokestatic 136	com/tencent/qmsp/sdk/base/c:b	(Ljava/lang/String;)V
    //   199: aconst_null
    //   200: areturn
    //   201: ldc 140
    //   203: astore_0
    //   204: goto -9 -> 195
    //   207: ldc 142
    //   209: invokestatic 136	com/tencent/qmsp/sdk/base/c:b	(Ljava/lang/String;)V
    //   212: new 127	java/lang/IllegalStateException
    //   215: dup
    //   216: ldc 142
    //   218: invokespecial 143	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   221: astore_0
    //   222: goto +5 -> 227
    //   225: aload_0
    //   226: athrow
    //   227: goto -2 -> 225
    //   230: astore_0
    //   231: goto -30 -> 201
    //   234: astore_1
    //   235: goto -64 -> 171
    //   238: astore_1
    //   239: goto -74 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramContext	android.content.Context
    //   3	149	1	localObject1	Object
    //   161	1	1	localObject2	Object
    //   167	24	1	str	String
    //   234	1	1	localRemoteException	android.os.RemoteException
    //   238	1	1	localInterruptedException	java.lang.InterruptedException
    //   11	176	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   100	146	161	finally
    //   153	161	161	finally
    //   174	178	161	finally
    //   45	56	230	android/content/pm/PackageManager$NameNotFoundException
    //   100	146	234	android/os/RemoteException
    //   153	161	234	android/os/RemoteException
    //   100	146	238	java/lang/InterruptedException
    //   153	161	238	java/lang/InterruptedException
  }
  
  private static String a()
  {
    return "AdId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.b.a
 * JD-Core Version:    0.7.0.1
 */