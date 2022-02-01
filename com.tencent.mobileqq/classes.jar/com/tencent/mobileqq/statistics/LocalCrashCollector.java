package com.tencent.mobileqq.statistics;

import android.os.Looper;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

public class LocalCrashCollector
  implements Runnable
{
  protected final MqqHandler a = new MqqWeakReferenceHandler(Looper.getMainLooper(), null, true);
  private StringBuilder b = new StringBuilder("");
  private int c;
  private AIOContext d;
  
  public LocalCrashCollector(AIOContext paramAIOContext)
  {
    this.d = paramAIOContext;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 8
    //   10: astore 4
    //   12: aload_0
    //   13: getfield 28	com/tencent/mobileqq/statistics/LocalCrashCollector:b	Ljava/lang/StringBuilder;
    //   16: invokevirtual 56	java/lang/StringBuilder:length	()I
    //   19: istore_2
    //   20: iconst_0
    //   21: istore_1
    //   22: iload_2
    //   23: ifle +23 -> 46
    //   26: aload 8
    //   28: astore 4
    //   30: aload_0
    //   31: getfield 28	com/tencent/mobileqq/statistics/LocalCrashCollector:b	Ljava/lang/StringBuilder;
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 28	com/tencent/mobileqq/statistics/LocalCrashCollector:b	Ljava/lang/StringBuilder;
    //   39: invokevirtual 56	java/lang/StringBuilder:length	()I
    //   42: invokevirtual 60	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 8
    //   48: astore 4
    //   50: new 62	java/io/File
    //   53: dup
    //   54: ldc 64
    //   56: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore 5
    //   61: aload 8
    //   63: astore 4
    //   65: aload 5
    //   67: invokevirtual 69	java/io/File:exists	()Z
    //   70: ifne +13 -> 83
    //   73: aload 8
    //   75: astore 4
    //   77: aload 5
    //   79: invokevirtual 72	java/io/File:mkdirs	()Z
    //   82: pop
    //   83: aload 8
    //   85: astore 4
    //   87: aload 5
    //   89: new 74	com/tencent/mobileqq/statistics/LocalCrashCollector$1
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 77	com/tencent/mobileqq/statistics/LocalCrashCollector$1:<init>	(Lcom/tencent/mobileqq/statistics/LocalCrashCollector;)V
    //   97: invokevirtual 81	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   100: astore 9
    //   102: aload 9
    //   104: ifnull +272 -> 376
    //   107: aload 8
    //   109: astore 4
    //   111: aload 9
    //   113: arraylength
    //   114: ifgt +6 -> 120
    //   117: goto +259 -> 376
    //   120: aload 8
    //   122: astore 4
    //   124: aload_0
    //   125: aload 9
    //   127: arraylength
    //   128: putfield 48	com/tencent/mobileqq/statistics/LocalCrashCollector:c	I
    //   131: aload 8
    //   133: astore 4
    //   135: aload 9
    //   137: new 83	com/tencent/mobileqq/statistics/LocalCrashCollector$2
    //   140: dup
    //   141: aload_0
    //   142: invokespecial 84	com/tencent/mobileqq/statistics/LocalCrashCollector$2:<init>	(Lcom/tencent/mobileqq/statistics/LocalCrashCollector;)V
    //   145: invokestatic 90	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   148: aload 8
    //   150: astore 4
    //   152: aload 9
    //   154: arraylength
    //   155: istore_2
    //   156: aconst_null
    //   157: astore_3
    //   158: iload_1
    //   159: iload_2
    //   160: if_icmpge +170 -> 330
    //   163: aload 9
    //   165: iload_1
    //   166: aaload
    //   167: astore 6
    //   169: new 92	java/io/FileReader
    //   172: dup
    //   173: aload 6
    //   175: invokespecial 95	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   178: astore 4
    //   180: aload 4
    //   182: astore 5
    //   184: aload 6
    //   186: invokevirtual 98	java/io/File:length	()J
    //   189: l2i
    //   190: newarray char
    //   192: astore_3
    //   193: aload 4
    //   195: astore 5
    //   197: aload 4
    //   199: aload_3
    //   200: invokevirtual 102	java/io/FileReader:read	([C)I
    //   203: pop
    //   204: aload 4
    //   206: astore 5
    //   208: aload_3
    //   209: invokestatic 108	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   212: astore_3
    //   213: aload 4
    //   215: astore 5
    //   217: aload_0
    //   218: getfield 28	com/tencent/mobileqq/statistics/LocalCrashCollector:b	Ljava/lang/StringBuilder;
    //   221: astore 6
    //   223: aload 4
    //   225: astore 5
    //   227: aload 6
    //   229: aload_3
    //   230: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 4
    //   236: astore 5
    //   238: aload 6
    //   240: ldc 114
    //   242: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 4
    //   248: astore_3
    //   249: goto +39 -> 288
    //   252: astore 6
    //   254: aload 4
    //   256: astore_3
    //   257: goto +16 -> 273
    //   260: astore 4
    //   262: aload_3
    //   263: astore 5
    //   265: aload 4
    //   267: astore_3
    //   268: goto +42 -> 310
    //   271: astore 6
    //   273: aload_3
    //   274: astore 5
    //   276: aload 6
    //   278: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   281: aload_3
    //   282: astore 4
    //   284: aload_3
    //   285: ifnull +14 -> 299
    //   288: aload 8
    //   290: astore 4
    //   292: aload_3
    //   293: invokevirtual 120	java/io/FileReader:close	()V
    //   296: aload_3
    //   297: astore 4
    //   299: aload 4
    //   301: astore_3
    //   302: iload_1
    //   303: iconst_1
    //   304: iadd
    //   305: istore_1
    //   306: goto -148 -> 158
    //   309: astore_3
    //   310: aload 5
    //   312: ifnull +12 -> 324
    //   315: aload 8
    //   317: astore 4
    //   319: aload 5
    //   321: invokevirtual 120	java/io/FileReader:close	()V
    //   324: aload 8
    //   326: astore 4
    //   328: aload_3
    //   329: athrow
    //   330: aload 8
    //   332: astore 4
    //   334: new 122	java/io/FileWriter
    //   337: dup
    //   338: ldc 124
    //   340: invokespecial 125	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   343: astore_3
    //   344: aload_3
    //   345: aload_0
    //   346: getfield 28	com/tencent/mobileqq/statistics/LocalCrashCollector:b	Ljava/lang/StringBuilder;
    //   349: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokevirtual 132	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   355: aload_3
    //   356: invokevirtual 135	java/io/FileWriter:flush	()V
    //   359: goto +26 -> 385
    //   362: astore 4
    //   364: goto +81 -> 445
    //   367: astore 4
    //   369: aload 4
    //   371: astore 5
    //   373: goto +40 -> 413
    //   376: aload 8
    //   378: astore 4
    //   380: aload_0
    //   381: iconst_0
    //   382: putfield 48	com/tencent/mobileqq/statistics/LocalCrashCollector:c	I
    //   385: aload_3
    //   386: ifnull +42 -> 428
    //   389: aload_3
    //   390: invokevirtual 136	java/io/FileWriter:close	()V
    //   393: goto +35 -> 428
    //   396: astore 5
    //   398: aload 4
    //   400: astore_3
    //   401: aload 5
    //   403: astore 4
    //   405: goto +40 -> 445
    //   408: astore 5
    //   410: aload 7
    //   412: astore_3
    //   413: aload_3
    //   414: astore 4
    //   416: aload 5
    //   418: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   421: aload_3
    //   422: ifnull +6 -> 428
    //   425: goto -36 -> 389
    //   428: aload_0
    //   429: getfield 41	com/tencent/mobileqq/statistics/LocalCrashCollector:a	Lmqq/os/MqqHandler;
    //   432: new 138	com/tencent/mobileqq/statistics/LocalCrashCollector$3
    //   435: dup
    //   436: aload_0
    //   437: invokespecial 139	com/tencent/mobileqq/statistics/LocalCrashCollector$3:<init>	(Lcom/tencent/mobileqq/statistics/LocalCrashCollector;)V
    //   440: invokevirtual 145	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   443: pop
    //   444: return
    //   445: aload_3
    //   446: ifnull +7 -> 453
    //   449: aload_3
    //   450: invokevirtual 136	java/io/FileWriter:close	()V
    //   453: goto +6 -> 459
    //   456: aload 4
    //   458: athrow
    //   459: goto -3 -> 456
    //   462: astore 4
    //   464: aload_3
    //   465: astore 4
    //   467: goto -168 -> 299
    //   470: astore 4
    //   472: goto -148 -> 324
    //   475: astore_3
    //   476: goto -48 -> 428
    //   479: astore_3
    //   480: goto -27 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	LocalCrashCollector
    //   21	285	1	i	int
    //   19	142	2	j	int
    //   7	295	3	localObject1	Object
    //   309	20	3	localObject2	Object
    //   343	122	3	localObject3	Object
    //   475	1	3	localException1	java.lang.Exception
    //   479	1	3	localException2	java.lang.Exception
    //   10	245	4	localObject4	Object
    //   260	6	4	localObject5	Object
    //   282	51	4	localObject6	Object
    //   362	1	4	localObject7	Object
    //   367	3	4	localException3	java.lang.Exception
    //   378	79	4	localObject8	Object
    //   462	1	4	localException4	java.lang.Exception
    //   465	1	4	localObject9	Object
    //   470	1	4	localException5	java.lang.Exception
    //   59	313	5	localObject10	Object
    //   396	6	5	localObject11	Object
    //   408	9	5	localException6	java.lang.Exception
    //   167	72	6	localObject12	Object
    //   252	1	6	localException7	java.lang.Exception
    //   271	6	6	localException8	java.lang.Exception
    //   4	407	7	localObject13	Object
    //   1	376	8	localObject14	Object
    //   100	64	9	arrayOfFile	java.io.File[]
    // Exception table:
    //   from	to	target	type
    //   184	193	252	java/lang/Exception
    //   197	204	252	java/lang/Exception
    //   208	213	252	java/lang/Exception
    //   217	223	252	java/lang/Exception
    //   227	234	252	java/lang/Exception
    //   238	246	252	java/lang/Exception
    //   169	180	260	finally
    //   169	180	271	java/lang/Exception
    //   184	193	309	finally
    //   197	204	309	finally
    //   208	213	309	finally
    //   217	223	309	finally
    //   227	234	309	finally
    //   238	246	309	finally
    //   276	281	309	finally
    //   344	359	362	finally
    //   344	359	367	java/lang/Exception
    //   12	20	396	finally
    //   30	46	396	finally
    //   50	61	396	finally
    //   65	73	396	finally
    //   77	83	396	finally
    //   87	102	396	finally
    //   111	117	396	finally
    //   124	131	396	finally
    //   135	148	396	finally
    //   152	156	396	finally
    //   292	296	396	finally
    //   319	324	396	finally
    //   328	330	396	finally
    //   334	344	396	finally
    //   380	385	396	finally
    //   416	421	396	finally
    //   12	20	408	java/lang/Exception
    //   30	46	408	java/lang/Exception
    //   50	61	408	java/lang/Exception
    //   65	73	408	java/lang/Exception
    //   77	83	408	java/lang/Exception
    //   87	102	408	java/lang/Exception
    //   111	117	408	java/lang/Exception
    //   124	131	408	java/lang/Exception
    //   135	148	408	java/lang/Exception
    //   152	156	408	java/lang/Exception
    //   328	330	408	java/lang/Exception
    //   334	344	408	java/lang/Exception
    //   380	385	408	java/lang/Exception
    //   292	296	462	java/lang/Exception
    //   319	324	470	java/lang/Exception
    //   389	393	475	java/lang/Exception
    //   449	453	479	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector
 * JD-Core Version:    0.7.0.1
 */