package com.tencent.turingfd.sdk.xq;

public class private
{
  /* Error */
  public static int a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: invokevirtual 20	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   8: astore 6
    //   10: iconst_1
    //   11: istore 5
    //   13: aload 6
    //   15: ifnonnull +6 -> 21
    //   18: goto +28 -> 46
    //   21: getstatic 26	com/tencent/turingfd/sdk/xq/import:l	[I
    //   24: invokestatic 29	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   27: astore 7
    //   29: aload 6
    //   31: aload 7
    //   33: sipush 128
    //   36: invokevirtual 35	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   39: pop
    //   40: iconst_1
    //   41: istore 4
    //   43: goto +6 -> 49
    //   46: iconst_0
    //   47: istore 4
    //   49: iconst_0
    //   50: iload 4
    //   52: iconst_0
    //   53: invokestatic 40	com/tencent/turingfd/sdk/xq/const:a	(IZI)I
    //   56: istore_2
    //   57: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   60: pop2
    //   61: new 42	java/lang/String
    //   64: dup
    //   65: getstatic 45	com/tencent/turingfd/sdk/xq/import:n	[I
    //   68: invokestatic 29	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   71: invokestatic 50	com/tencent/turingfd/sdk/xq/instanceof:a	(Ljava/lang/String;)[B
    //   74: invokespecial 54	java/lang/String:<init>	([B)V
    //   77: astore 6
    //   79: aload 6
    //   81: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: ifeq +6 -> 90
    //   87: goto +72 -> 159
    //   90: aload 6
    //   92: ldc 62
    //   94: invokevirtual 66	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   97: astore 6
    //   99: aload 6
    //   101: ifnull +58 -> 159
    //   104: aload 6
    //   106: arraylength
    //   107: ifne +6 -> 113
    //   110: goto +49 -> 159
    //   113: aload_0
    //   114: invokevirtual 70	android/content/Context:getPackageName	()Ljava/lang/String;
    //   117: astore 7
    //   119: aload 6
    //   121: arraylength
    //   122: istore_3
    //   123: iconst_0
    //   124: istore_1
    //   125: iload_1
    //   126: iload_3
    //   127: if_icmpge +32 -> 159
    //   130: aload 7
    //   132: aload 6
    //   134: iload_1
    //   135: aaload
    //   136: invokestatic 73	com/tencent/turingfd/sdk/xq/private:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   139: istore 4
    //   141: iload 4
    //   143: ifeq +9 -> 152
    //   146: iconst_1
    //   147: istore 4
    //   149: goto +13 -> 162
    //   152: iload_1
    //   153: iconst_1
    //   154: iadd
    //   155: istore_1
    //   156: goto -31 -> 125
    //   159: iconst_0
    //   160: istore 4
    //   162: iload_2
    //   163: iload 4
    //   165: iconst_1
    //   166: invokestatic 40	com/tencent/turingfd/sdk/xq/const:a	(IZI)I
    //   169: istore_1
    //   170: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   173: pop2
    //   174: new 4	java/lang/Object
    //   177: dup
    //   178: invokespecial 76	java/lang/Object:<init>	()V
    //   181: astore 6
    //   183: new 78	java/util/concurrent/atomic/AtomicReference
    //   186: dup
    //   187: invokespecial 79	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   190: astore 7
    //   192: new 81	java/util/concurrent/atomic/AtomicBoolean
    //   195: dup
    //   196: iconst_0
    //   197: invokespecial 84	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   200: astore 8
    //   202: aload 7
    //   204: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   207: invokevirtual 94	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   210: new 96	android/os/Handler
    //   213: dup
    //   214: aload_0
    //   215: invokevirtual 100	android/content/Context:getMainLooper	()Landroid/os/Looper;
    //   218: invokespecial 103	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   221: new 105	com/tencent/turingfd/sdk/xq/package
    //   224: dup
    //   225: aload 8
    //   227: aload 7
    //   229: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   232: aload 6
    //   234: invokespecial 108	com/tencent/turingfd/sdk/xq/package:<init>	(Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicReference;JLjava/lang/Object;)V
    //   237: invokevirtual 112	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   240: pop
    //   241: aload 6
    //   243: monitorenter
    //   244: aload 6
    //   246: ldc2_w 113
    //   249: invokevirtual 118	java/lang/Object:wait	(J)V
    //   252: goto +7 -> 259
    //   255: astore_0
    //   256: goto +66 -> 322
    //   259: aload 6
    //   261: monitorexit
    //   262: aload 8
    //   264: iconst_1
    //   265: invokevirtual 120	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   268: iload_1
    //   269: aload 7
    //   271: invokevirtual 124	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   274: checkcast 86	java/lang/Boolean
    //   277: invokevirtual 128	java/lang/Boolean:booleanValue	()Z
    //   280: iconst_2
    //   281: invokestatic 40	com/tencent/turingfd/sdk/xq/const:a	(IZI)I
    //   284: istore_1
    //   285: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   288: pop2
    //   289: getstatic 131	com/tencent/turingfd/sdk/xq/import:F0	[I
    //   292: invokestatic 29	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   295: astore_0
    //   296: invokestatic 137	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   299: aload_0
    //   300: invokevirtual 141	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   303: pop
    //   304: iload 5
    //   306: istore 4
    //   308: goto +6 -> 314
    //   311: iconst_0
    //   312: istore 4
    //   314: iload_1
    //   315: iload 4
    //   317: iconst_3
    //   318: invokestatic 40	com/tencent/turingfd/sdk/xq/const:a	(IZI)I
    //   321: ireturn
    //   322: aload 6
    //   324: monitorexit
    //   325: goto +5 -> 330
    //   328: aload_0
    //   329: athrow
    //   330: goto -2 -> 328
    //   333: astore 6
    //   335: goto -289 -> 46
    //   338: astore 6
    //   340: goto -181 -> 159
    //   343: astore_0
    //   344: goto -85 -> 259
    //   347: astore_0
    //   348: goto -37 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramContext	android.content.Context
    //   124	191	1	i	int
    //   56	107	2	j	int
    //   122	6	3	k	int
    //   41	275	4	bool1	boolean
    //   11	294	5	bool2	boolean
    //   8	315	6	localObject1	Object
    //   333	1	6	localObject2	Object
    //   338	1	6	localObject3	Object
    //   27	243	7	localObject4	Object
    //   200	63	8	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    // Exception table:
    //   from	to	target	type
    //   244	252	255	finally
    //   259	262	255	finally
    //   322	325	255	finally
    //   29	40	333	finally
    //   61	87	338	finally
    //   90	99	338	finally
    //   104	110	338	finally
    //   113	123	338	finally
    //   130	141	338	finally
    //   244	252	343	java/lang/InterruptedException
    //   289	304	347	finally
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return false;
    }
    int i = paramString2.indexOf('/');
    if (i == -1) {
      return false;
    }
    String str = paramString2.substring(i).trim();
    if (!str.startsWith("/data/")) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/data/");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    if (str.startsWith(localStringBuilder.toString())) {
      return false;
    }
    boolean bool = str.endsWith(".so");
    if ((!bool) && (str.endsWith(".jar"))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!bool) && (i == 0)) {
      return false;
    }
    return paramString2.contains(import.a(import.m));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.private
 * JD-Core Version:    0.7.0.1
 */