package com.tencent.qqperf.monitor.crash.tools;

public class FdinfoRecordHelper
{
  /* Error */
  @android.annotation.TargetApi(21)
  public static java.lang.String a()
  {
    // Byte code:
    //   0: new 18	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: iconst_0
    //   10: istore_1
    //   11: iconst_0
    //   12: istore_3
    //   13: iconst_0
    //   14: istore_2
    //   15: new 21	java/io/File
    //   18: dup
    //   19: ldc 23
    //   21: invokespecial 26	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 5
    //   26: iload_1
    //   27: istore_0
    //   28: aload 5
    //   30: invokevirtual 30	java/io/File:exists	()Z
    //   33: ifeq +143 -> 176
    //   36: iload_1
    //   37: istore_0
    //   38: aload 5
    //   40: invokevirtual 33	java/io/File:isDirectory	()Z
    //   43: ifeq +133 -> 176
    //   46: getstatic 39	android/os/Build$VERSION:SDK_INT	I
    //   49: bipush 21
    //   51: if_icmplt +239 -> 290
    //   54: iconst_1
    //   55: istore_1
    //   56: goto +3 -> 59
    //   59: aload 5
    //   61: invokevirtual 43	java/io/File:listFiles	()[Ljava/io/File;
    //   64: astore 7
    //   66: aload 7
    //   68: arraylength
    //   69: istore 4
    //   71: iconst_0
    //   72: istore_0
    //   73: iload_2
    //   74: iload 4
    //   76: if_icmpge +100 -> 176
    //   79: aload 7
    //   81: iload_2
    //   82: aaload
    //   83: astore 5
    //   85: iload_1
    //   86: ifeq +16 -> 102
    //   89: aload 5
    //   91: invokevirtual 46	java/io/File:getPath	()Ljava/lang/String;
    //   94: invokestatic 52	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 5
    //   99: goto +10 -> 109
    //   102: aload 5
    //   104: invokevirtual 55	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   107: astore 5
    //   109: new 18	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   116: astore 8
    //   118: aload 8
    //   120: aload 5
    //   122: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 8
    //   128: ldc 61
    //   130: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: aload 8
    //   138: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: iload_0
    //   146: iconst_1
    //   147: iadd
    //   148: istore_0
    //   149: goto +15 -> 164
    //   152: astore 5
    //   154: ldc 66
    //   156: iconst_1
    //   157: ldc 68
    //   159: aload 5
    //   161: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: iload_2
    //   165: iconst_1
    //   166: iadd
    //   167: istore_2
    //   168: goto -95 -> 73
    //   171: astore 5
    //   173: goto +53 -> 226
    //   176: new 18	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   183: astore 5
    //   185: aload 5
    //   187: ldc 76
    //   189: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 5
    //   195: iload_0
    //   196: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 6
    //   202: aload 5
    //   204: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 6
    //   213: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: areturn
    //   217: iconst_0
    //   218: istore_0
    //   219: goto +29 -> 248
    //   222: astore 5
    //   224: iload_3
    //   225: istore_0
    //   226: ldc 66
    //   228: iconst_1
    //   229: ldc 81
    //   231: aload 5
    //   233: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: new 18	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   243: astore 5
    //   245: goto -60 -> 185
    //   248: new 18	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   255: astore 5
    //   257: aload 5
    //   259: ldc 76
    //   261: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 5
    //   267: iload_0
    //   268: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: goto -72 -> 200
    //   275: astore 5
    //   277: goto -60 -> 217
    //   280: astore 5
    //   282: goto -34 -> 248
    //   285: astore 5
    //   287: goto -39 -> 248
    //   290: iconst_0
    //   291: istore_1
    //   292: goto -233 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	241	0	i	int
    //   10	282	1	j	int
    //   14	154	2	k	int
    //   12	213	3	m	int
    //   69	8	4	n	int
    //   24	97	5	localObject1	Object
    //   152	8	5	localThrowable1	java.lang.Throwable
    //   171	1	5	localThrowable2	java.lang.Throwable
    //   183	20	5	localStringBuilder1	java.lang.StringBuilder
    //   222	10	5	localThrowable3	java.lang.Throwable
    //   243	23	5	localStringBuilder2	java.lang.StringBuilder
    //   275	1	5	localObject2	Object
    //   280	1	5	localObject3	Object
    //   285	1	5	localObject4	Object
    //   7	205	6	localStringBuilder3	java.lang.StringBuilder
    //   64	16	7	arrayOfFile	java.io.File[]
    //   116	21	8	localStringBuilder4	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   89	99	152	java/lang/Throwable
    //   102	109	152	java/lang/Throwable
    //   109	145	152	java/lang/Throwable
    //   154	164	171	java/lang/Throwable
    //   15	26	222	java/lang/Throwable
    //   28	36	222	java/lang/Throwable
    //   38	54	222	java/lang/Throwable
    //   59	71	222	java/lang/Throwable
    //   15	26	275	finally
    //   28	36	275	finally
    //   38	54	275	finally
    //   59	71	275	finally
    //   89	99	280	finally
    //   102	109	280	finally
    //   109	145	280	finally
    //   154	164	280	finally
    //   226	236	285	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.FdinfoRecordHelper
 * JD-Core Version:    0.7.0.1
 */