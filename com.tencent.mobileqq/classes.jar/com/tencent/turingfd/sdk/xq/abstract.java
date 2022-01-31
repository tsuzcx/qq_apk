package com.tencent.turingfd.sdk.xq;

public class abstract
{
  public static final long mc = ;
  public static String nc = "";
  
  /* Error */
  public static String a(android.content.Context paramContext, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: new 31	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc 36
    //   13: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 7
    //   19: getstatic 18	com/tencent/turingfd/sdk/xq/abstract:mc	J
    //   22: invokevirtual 43	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 7
    //   28: ldc 45
    //   30: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 7
    //   36: ldc 47
    //   38: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 7
    //   44: new 31	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   51: ldc 20
    //   53: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokestatic 16	java/lang/System:currentTimeMillis	()J
    //   59: getstatic 18	com/tencent/turingfd/sdk/xq/abstract:mc	J
    //   62: lsub
    //   63: invokevirtual 43	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 7
    //   75: ldc 45
    //   77: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 7
    //   83: ldc 53
    //   85: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: iload_1
    //   90: ifeq +289 -> 379
    //   93: ldc 55
    //   95: astore 5
    //   97: aload 7
    //   99: aload 5
    //   101: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 7
    //   107: ldc 45
    //   109: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 7
    //   115: ldc 57
    //   117: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 7
    //   123: new 31	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   130: ldc 20
    //   132: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: iload_2
    //   136: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_0
    //   147: ldc 62
    //   149: invokestatic 68	com/tencent/turingfd/sdk/xq/extends:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   152: astore 6
    //   154: aload 6
    //   156: astore 5
    //   158: aload 6
    //   160: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   163: ifeq +7 -> 170
    //   166: ldc 76
    //   168: astore 5
    //   170: aload 5
    //   172: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   175: ifne +27 -> 202
    //   178: aload 7
    //   180: ldc 45
    //   182: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 7
    //   188: ldc 78
    //   190: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 7
    //   196: aload 5
    //   198: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_0
    //   203: ldc 80
    //   205: iconst_0
    //   206: invokevirtual 86	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   209: ldc 88
    //   211: iconst_0
    //   212: invokeinterface 94 3 0
    //   217: istore_2
    //   218: iload_2
    //   219: ifle +26 -> 245
    //   222: aload 7
    //   224: ldc 45
    //   226: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 7
    //   232: ldc 96
    //   234: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 7
    //   240: iload_2
    //   241: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_0
    //   246: ldc 98
    //   248: invokestatic 68	com/tencent/turingfd/sdk/xq/extends:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   251: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +27 -> 281
    //   257: aload 7
    //   259: ldc 45
    //   261: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 7
    //   267: ldc 100
    //   269: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 7
    //   275: ldc 55
    //   277: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: getstatic 22	com/tencent/turingfd/sdk/xq/abstract:nc	Ljava/lang/String;
    //   284: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   287: ifeq +137 -> 424
    //   290: ldc 20
    //   292: astore 6
    //   294: invokestatic 106	android/os/Process:myPid	()I
    //   297: istore_2
    //   298: aload 6
    //   300: astore 5
    //   302: aload_0
    //   303: ldc 108
    //   305: invokevirtual 112	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   308: checkcast 114	android/app/ActivityManager
    //   311: invokevirtual 118	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   314: invokeinterface 124 1 0
    //   319: astore 8
    //   321: aload 6
    //   323: astore_0
    //   324: aload_0
    //   325: astore 5
    //   327: aload_0
    //   328: astore 6
    //   330: aload 8
    //   332: invokeinterface 130 1 0
    //   337: ifeq +57 -> 394
    //   340: aload_0
    //   341: astore 5
    //   343: aload 8
    //   345: invokeinterface 134 1 0
    //   350: checkcast 136	android/app/ActivityManager$RunningAppProcessInfo
    //   353: astore 6
    //   355: aload_0
    //   356: astore 5
    //   358: aload 6
    //   360: getfield 140	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   363: iload_2
    //   364: if_icmpne +22 -> 386
    //   367: aload_0
    //   368: astore 5
    //   370: aload 6
    //   372: getfield 143	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   375: astore_0
    //   376: goto -52 -> 324
    //   379: ldc 76
    //   381: astore 5
    //   383: goto -286 -> 97
    //   386: goto -10 -> 376
    //   389: astore_0
    //   390: aload 5
    //   392: astore 6
    //   394: aload 6
    //   396: putstatic 22	com/tencent/turingfd/sdk/xq/abstract:nc	Ljava/lang/String;
    //   399: aload 7
    //   401: ldc 45
    //   403: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 7
    //   409: ldc 145
    //   411: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 7
    //   417: getstatic 22	com/tencent/turingfd/sdk/xq/abstract:nc	Ljava/lang/String;
    //   420: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: invokestatic 151	com/tencent/turingfd/sdk/xq/private:getInstance	()Lcom/tencent/turingfd/sdk/xq/private;
    //   427: ldc 153
    //   429: invokevirtual 157	com/tencent/turingfd/sdk/xq/private:g	(Ljava/lang/String;)Ljava/lang/String;
    //   432: astore 8
    //   434: aload 8
    //   436: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   439: ifeq +42 -> 481
    //   442: ldc 20
    //   444: astore_0
    //   445: aload_0
    //   446: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   449: ifeq +26 -> 475
    //   452: aload 7
    //   454: ldc 45
    //   456: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 7
    //   462: ldc 159
    //   464: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 7
    //   470: aload_0
    //   471: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 7
    //   477: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: areturn
    //   481: new 161	java/io/File
    //   484: dup
    //   485: aload 8
    //   487: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   490: astore 5
    //   492: aconst_null
    //   493: astore_0
    //   494: new 166	java/io/RandomAccessFile
    //   497: dup
    //   498: aload 5
    //   500: ldc 168
    //   502: invokespecial 171	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   505: astore 5
    //   507: aload 5
    //   509: astore_0
    //   510: aload 5
    //   512: invokevirtual 174	java/io/RandomAccessFile:length	()J
    //   515: lstore_3
    //   516: lload_3
    //   517: l2i
    //   518: istore_2
    //   519: iload_2
    //   520: i2l
    //   521: lload_3
    //   522: lcmp
    //   523: ifne +75 -> 598
    //   526: aload 5
    //   528: astore_0
    //   529: iload_2
    //   530: newarray byte
    //   532: astore 6
    //   534: aload 5
    //   536: astore_0
    //   537: aload 5
    //   539: aload 6
    //   541: invokevirtual 178	java/io/RandomAccessFile:readFully	([B)V
    //   544: aload 6
    //   546: astore_0
    //   547: aload 5
    //   549: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   552: aload 6
    //   554: astore_0
    //   555: aload_0
    //   556: arraylength
    //   557: ifeq -115 -> 442
    //   560: aload_0
    //   561: ldc 183
    //   563: invokevirtual 189	java/lang/String:getBytes	()[B
    //   566: invokestatic 194	com/tencent/turingfd/sdk/xq/for:a	([B[B)[B
    //   569: astore_0
    //   570: new 161	java/io/File
    //   573: dup
    //   574: aload 8
    //   576: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   579: invokevirtual 197	java/io/File:deleteOnExit	()V
    //   582: new 185	java/lang/String
    //   585: dup
    //   586: aload_0
    //   587: invokespecial 199	java/lang/String:<init>	([B)V
    //   590: astore_0
    //   591: goto -146 -> 445
    //   594: astore_0
    //   595: goto -153 -> 442
    //   598: aload 5
    //   600: astore_0
    //   601: new 29	java/io/IOException
    //   604: dup
    //   605: ldc 20
    //   607: invokespecial 200	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   610: athrow
    //   611: astore_0
    //   612: aload 5
    //   614: astore_0
    //   615: iconst_0
    //   616: newarray byte
    //   618: astore 6
    //   620: aload 5
    //   622: ifnull +80 -> 702
    //   625: aload 6
    //   627: astore_0
    //   628: aload 5
    //   630: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   633: aload 6
    //   635: astore_0
    //   636: goto -81 -> 555
    //   639: astore_0
    //   640: aconst_null
    //   641: astore 5
    //   643: goto -31 -> 612
    //   646: astore 5
    //   648: aload 5
    //   650: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   653: goto -98 -> 555
    //   656: astore 6
    //   658: aload_0
    //   659: astore 5
    //   661: aload 6
    //   663: astore_0
    //   664: aload 5
    //   666: ifnull +8 -> 674
    //   669: aload 5
    //   671: invokevirtual 181	java/io/RandomAccessFile:close	()V
    //   674: aload_0
    //   675: athrow
    //   676: astore 5
    //   678: aload 5
    //   680: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   683: goto -9 -> 674
    //   686: astore 5
    //   688: goto -106 -> 582
    //   691: astore 6
    //   693: aload_0
    //   694: astore 5
    //   696: aload 6
    //   698: astore_0
    //   699: goto -35 -> 664
    //   702: aload 6
    //   704: astore_0
    //   705: goto -150 -> 555
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	paramContext	android.content.Context
    //   0	708	1	paramBoolean	boolean
    //   0	708	2	paramInt	int
    //   515	7	3	l	long
    //   95	547	5	localObject1	Object
    //   646	3	5	localIOException1	java.io.IOException
    //   659	11	5	localContext1	android.content.Context
    //   676	3	5	localIOException2	java.io.IOException
    //   686	1	5	localThrowable	java.lang.Throwable
    //   694	1	5	localContext2	android.content.Context
    //   152	482	6	localObject2	Object
    //   656	6	6	localObject3	Object
    //   691	12	6	localObject4	Object
    //   7	469	7	localStringBuilder	java.lang.StringBuilder
    //   319	256	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   302	321	389	java/lang/Throwable
    //   330	340	389	java/lang/Throwable
    //   343	355	389	java/lang/Throwable
    //   358	367	389	java/lang/Throwable
    //   370	376	389	java/lang/Throwable
    //   582	591	594	java/lang/Throwable
    //   510	516	611	java/lang/Throwable
    //   529	534	611	java/lang/Throwable
    //   537	544	611	java/lang/Throwable
    //   601	611	611	java/lang/Throwable
    //   494	507	639	java/lang/Throwable
    //   547	552	646	java/io/IOException
    //   628	633	646	java/io/IOException
    //   494	507	656	finally
    //   669	674	676	java/io/IOException
    //   570	582	686	java/lang/Throwable
    //   510	516	691	finally
    //   529	534	691	finally
    //   537	544	691	finally
    //   601	611	691	finally
    //   615	620	691	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.abstract
 * JD-Core Version:    0.7.0.1
 */