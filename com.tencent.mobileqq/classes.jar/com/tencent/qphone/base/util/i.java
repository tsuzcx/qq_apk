package com.tencent.qphone.base.util;

public class i
{
  private static final String a = "ThreadUtils";
  
  /* Error */
  public static void a(java.lang.StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 20	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 23
    //   13: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 4
    //   19: invokestatic 33	android/os/Process:myPid	()I
    //   22: invokevirtual 36	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 4
    //   28: ldc 38
    //   30: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 4
    //   36: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 6
    //   41: aload_0
    //   42: ldc 44
    //   44: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   51: lstore_2
    //   52: aconst_null
    //   53: astore 5
    //   55: aconst_null
    //   56: astore 4
    //   58: new 52	java/io/File
    //   61: dup
    //   62: aload 6
    //   64: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: invokevirtual 59	java/io/File:list	()[Ljava/lang/String;
    //   70: astore 7
    //   72: aconst_null
    //   73: astore 4
    //   75: iconst_0
    //   76: istore_1
    //   77: iload_1
    //   78: aload 7
    //   80: arraylength
    //   81: if_icmpge +245 -> 326
    //   84: new 20	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   91: astore 5
    //   93: aload 5
    //   95: aload 6
    //   97: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 5
    //   103: ldc 61
    //   105: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 5
    //   111: aload 7
    //   113: iload_1
    //   114: aaload
    //   115: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 5
    //   121: ldc 63
    //   123: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: new 52	java/io/File
    //   130: dup
    //   131: aload 5
    //   133: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   139: astore 8
    //   141: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   144: lload_2
    //   145: lsub
    //   146: ldc2_w 64
    //   149: lcmp
    //   150: ifle +34 -> 184
    //   153: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +170 -> 326
    //   159: ldc 8
    //   161: iconst_2
    //   162: iconst_2
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: ldc 73
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: aload_0
    //   174: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: aastore
    //   178: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   181: goto +145 -> 326
    //   184: aload 4
    //   186: astore 5
    //   188: aload 8
    //   190: invokevirtual 80	java/io/File:exists	()Z
    //   193: ifeq +122 -> 315
    //   196: new 82	java/io/BufferedReader
    //   199: dup
    //   200: new 84	java/io/FileReader
    //   203: dup
    //   204: aload 8
    //   206: invokespecial 87	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   209: bipush 64
    //   211: invokespecial 90	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   214: astore 5
    //   216: aload 5
    //   218: invokevirtual 93	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   221: astore 4
    //   223: aload 4
    //   225: ifnull +262 -> 487
    //   228: aload 4
    //   230: ldc 95
    //   232: invokevirtual 101	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   235: ifeq -19 -> 216
    //   238: aload 4
    //   240: ldc 103
    //   242: invokevirtual 107	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   245: iconst_1
    //   246: aaload
    //   247: invokevirtual 110	java/lang/String:trim	()Ljava/lang/String;
    //   250: astore 4
    //   252: goto +3 -> 255
    //   255: aload_0
    //   256: aload 4
    //   258: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload_0
    //   263: ldc 112
    //   265: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 5
    //   271: invokevirtual 115	java/io/BufferedReader:close	()V
    //   274: aconst_null
    //   275: astore 5
    //   277: goto +38 -> 315
    //   280: astore 4
    //   282: ldc 8
    //   284: iconst_2
    //   285: ldc 117
    //   287: aload 4
    //   289: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   292: goto +23 -> 315
    //   295: astore_0
    //   296: aload 5
    //   298: astore 4
    //   300: goto +154 -> 454
    //   303: astore 4
    //   305: aload 5
    //   307: astore_0
    //   308: aload 4
    //   310: astore 5
    //   312: goto +120 -> 432
    //   315: iload_1
    //   316: iconst_1
    //   317: iadd
    //   318: istore_1
    //   319: aload 5
    //   321: astore 4
    //   323: goto -246 -> 77
    //   326: aload_0
    //   327: ldc 123
    //   329: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_0
    //   334: aload 7
    //   336: arraylength
    //   337: invokevirtual 36	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +41 -> 385
    //   347: ldc 8
    //   349: iconst_2
    //   350: iconst_4
    //   351: anewarray 4	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: ldc 125
    //   358: aastore
    //   359: dup
    //   360: iconst_1
    //   361: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   364: lload_2
    //   365: lsub
    //   366: invokestatic 131	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   369: aastore
    //   370: dup
    //   371: iconst_2
    //   372: ldc 133
    //   374: aastore
    //   375: dup
    //   376: iconst_3
    //   377: aload_0
    //   378: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: aastore
    //   382: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   385: aload 4
    //   387: ifnull +66 -> 453
    //   390: aload 4
    //   392: invokevirtual 115	java/io/BufferedReader:close	()V
    //   395: return
    //   396: astore_0
    //   397: ldc 8
    //   399: iconst_2
    //   400: ldc 117
    //   402: aload_0
    //   403: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   406: return
    //   407: astore_0
    //   408: goto +46 -> 454
    //   411: astore 5
    //   413: aload 4
    //   415: astore_0
    //   416: goto +16 -> 432
    //   419: astore_0
    //   420: goto +34 -> 454
    //   423: astore 4
    //   425: aload 5
    //   427: astore_0
    //   428: aload 4
    //   430: astore 5
    //   432: aload_0
    //   433: astore 4
    //   435: ldc 8
    //   437: iconst_2
    //   438: ldc 117
    //   440: aload 5
    //   442: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   445: aload_0
    //   446: ifnull +7 -> 453
    //   449: aload_0
    //   450: invokevirtual 115	java/io/BufferedReader:close	()V
    //   453: return
    //   454: aload 4
    //   456: ifnull +23 -> 479
    //   459: aload 4
    //   461: invokevirtual 115	java/io/BufferedReader:close	()V
    //   464: goto +15 -> 479
    //   467: astore 4
    //   469: ldc 8
    //   471: iconst_2
    //   472: ldc 117
    //   474: aload 4
    //   476: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   479: goto +5 -> 484
    //   482: aload_0
    //   483: athrow
    //   484: goto -2 -> 482
    //   487: aconst_null
    //   488: astore 4
    //   490: goto -235 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	paramStringBuilder	java.lang.StringBuilder
    //   76	243	1	i	int
    //   51	314	2	l	long
    //   7	250	4	localObject1	Object
    //   280	8	4	localIOException1	java.io.IOException
    //   298	1	4	localObject2	Object
    //   303	6	4	localException1	java.lang.Exception
    //   321	93	4	localObject3	Object
    //   423	6	4	localException2	java.lang.Exception
    //   433	27	4	localStringBuilder	java.lang.StringBuilder
    //   467	8	4	localIOException2	java.io.IOException
    //   488	1	4	localObject4	Object
    //   53	267	5	localObject5	Object
    //   411	15	5	localException3	java.lang.Exception
    //   430	11	5	localException4	java.lang.Exception
    //   39	57	6	str	String
    //   70	265	7	arrayOfString	String[]
    //   139	66	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   269	274	280	java/io/IOException
    //   216	223	295	finally
    //   228	252	295	finally
    //   255	269	295	finally
    //   269	274	295	finally
    //   282	292	295	finally
    //   216	223	303	java/lang/Exception
    //   228	252	303	java/lang/Exception
    //   255	269	303	java/lang/Exception
    //   269	274	303	java/lang/Exception
    //   282	292	303	java/lang/Exception
    //   390	395	396	java/io/IOException
    //   449	453	396	java/io/IOException
    //   77	181	407	finally
    //   188	216	407	finally
    //   326	385	407	finally
    //   77	181	411	java/lang/Exception
    //   188	216	411	java/lang/Exception
    //   326	385	411	java/lang/Exception
    //   58	72	419	finally
    //   435	445	419	finally
    //   58	72	423	java/lang/Exception
    //   459	464	467	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.i
 * JD-Core Version:    0.7.0.1
 */