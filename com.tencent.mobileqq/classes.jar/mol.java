import android.text.TextUtils;
import java.util.concurrent.locks.ReentrantLock;

public class mol
{
  private static String jdField_a_of_type_JavaLangString;
  private static final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private static String jdField_b_of_type_JavaLangString;
  private static final ReentrantLock jdField_b_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private static String c;
  private static String d;
  
  public static String a()
  {
    if (TextUtils.isEmpty(c))
    {
      urk.d("OfflineEnvHelper", "getInnerOfflineDir, initEnv");
      a();
    }
    return c;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (a(paramString))
    {
      urk.d("OfflineEnvHelper", "getOfflineDir, isStoreInSD true");
      return b();
    }
    return a();
  }
  
  /* Error */
  private static void a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: sipush 10066
    //   5: ldc 56
    //   7: iconst_1
    //   8: invokestatic 61	axxj:a	(ILjava/lang/String;Z)Ljava/lang/String;
    //   11: astore 7
    //   13: aload 7
    //   15: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifne +268 -> 286
    //   21: new 63	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   28: aload 7
    //   30: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 70
    //   35: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore 6
    //   43: new 63	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   50: aload 7
    //   52: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 75
    //   57: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore 7
    //   65: new 77	java/io/File
    //   68: dup
    //   69: aload 6
    //   71: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 8
    //   76: aload 8
    //   78: invokevirtual 84	java/io/File:exists	()Z
    //   81: ifne +128 -> 209
    //   84: getstatic 19	mol:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   87: invokevirtual 87	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   90: istore_3
    //   91: iload_3
    //   92: ifeq +601 -> 693
    //   95: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   98: lstore 4
    //   100: new 77	java/io/File
    //   103: dup
    //   104: new 63	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   111: invokestatic 99	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   114: invokevirtual 102	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   117: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 104
    //   122: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: astore 9
    //   133: aload 9
    //   135: invokevirtual 84	java/io/File:exists	()Z
    //   138: ifeq +465 -> 603
    //   141: aload 8
    //   143: invokevirtual 107	java/io/File:mkdirs	()Z
    //   146: pop
    //   147: aload 9
    //   149: aload 8
    //   151: invokevirtual 111	java/io/File:renameTo	(Ljava/io/File;)Z
    //   154: ifeq +420 -> 574
    //   157: iconst_1
    //   158: istore_3
    //   159: getstatic 116	mof:a	Lmos;
    //   162: ldc 118
    //   164: iconst_1
    //   165: new 63	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   172: ldc 120
    //   174: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   180: lload 4
    //   182: lsub
    //   183: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   186: ldc 125
    //   188: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload_3
    //   192: invokevirtual 128	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   195: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokeinterface 133 4 0
    //   203: getstatic 19	mol:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   206: invokevirtual 136	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   209: aload 8
    //   211: invokevirtual 84	java/io/File:exists	()Z
    //   214: ifne +495 -> 709
    //   217: aload 8
    //   219: invokevirtual 107	java/io/File:mkdirs	()Z
    //   222: ifne +487 -> 709
    //   225: iconst_1
    //   226: istore_0
    //   227: new 77	java/io/File
    //   230: dup
    //   231: aload 7
    //   233: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   236: astore 8
    //   238: aload 8
    //   240: invokevirtual 84	java/io/File:exists	()Z
    //   243: ifne +471 -> 714
    //   246: aload 8
    //   248: invokevirtual 107	java/io/File:mkdirs	()Z
    //   251: ifne +463 -> 714
    //   254: iconst_1
    //   255: istore_1
    //   256: iload_0
    //   257: iload_1
    //   258: ior
    //   259: ifeq +460 -> 719
    //   262: getstatic 116	mof:a	Lmos;
    //   265: invokeinterface 138 1 0
    //   270: ifeq +16 -> 286
    //   273: getstatic 116	mof:a	Lmos;
    //   276: ldc 118
    //   278: iconst_2
    //   279: ldc 140
    //   281: invokeinterface 133 4 0
    //   286: sipush 10066
    //   289: ldc 56
    //   291: iconst_0
    //   292: invokestatic 61	axxj:a	(ILjava/lang/String;Z)Ljava/lang/String;
    //   295: astore 7
    //   297: aload 7
    //   299: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   302: ifne +271 -> 573
    //   305: new 63	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   312: aload 7
    //   314: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc 70
    //   319: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: astore 6
    //   327: new 63	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   334: aload 7
    //   336: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc 75
    //   341: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: astore 7
    //   349: new 77	java/io/File
    //   352: dup
    //   353: aload 6
    //   355: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   358: astore 8
    //   360: aload 8
    //   362: invokevirtual 84	java/io/File:exists	()Z
    //   365: ifne +131 -> 496
    //   368: getstatic 21	mol:jdField_b_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   371: invokevirtual 87	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   374: istore_3
    //   375: iload_3
    //   376: ifeq +475 -> 851
    //   379: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   382: lstore 4
    //   384: new 77	java/io/File
    //   387: dup
    //   388: new 63	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   395: invokestatic 146	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   398: invokevirtual 151	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   401: invokevirtual 102	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   404: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc 153
    //   409: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   418: astore 9
    //   420: aload 9
    //   422: invokevirtual 84	java/io/File:exists	()Z
    //   425: ifeq +336 -> 761
    //   428: aload 8
    //   430: invokevirtual 107	java/io/File:mkdirs	()Z
    //   433: pop
    //   434: aload 9
    //   436: aload 8
    //   438: invokevirtual 111	java/io/File:renameTo	(Ljava/io/File;)Z
    //   441: ifeq +291 -> 732
    //   444: iconst_1
    //   445: istore_3
    //   446: getstatic 116	mof:a	Lmos;
    //   449: ldc 118
    //   451: iconst_1
    //   452: new 63	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   459: ldc 155
    //   461: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   467: lload 4
    //   469: lsub
    //   470: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   473: ldc 125
    //   475: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: iload_3
    //   479: invokevirtual 128	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   482: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokeinterface 133 4 0
    //   490: getstatic 21	mol:jdField_b_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   493: invokevirtual 136	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   496: aload 8
    //   498: invokevirtual 84	java/io/File:exists	()Z
    //   501: ifne +366 -> 867
    //   504: aload 8
    //   506: invokevirtual 107	java/io/File:mkdirs	()Z
    //   509: ifne +358 -> 867
    //   512: iconst_1
    //   513: istore_0
    //   514: new 77	java/io/File
    //   517: dup
    //   518: aload 7
    //   520: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   523: astore 8
    //   525: aload 8
    //   527: invokevirtual 84	java/io/File:exists	()Z
    //   530: ifne +342 -> 872
    //   533: aload 8
    //   535: invokevirtual 107	java/io/File:mkdirs	()Z
    //   538: ifne +334 -> 872
    //   541: iload_2
    //   542: istore_1
    //   543: iload_0
    //   544: iload_1
    //   545: ior
    //   546: ifeq +331 -> 877
    //   549: getstatic 116	mof:a	Lmos;
    //   552: invokeinterface 138 1 0
    //   557: ifeq +16 -> 573
    //   560: getstatic 116	mof:a	Lmos;
    //   563: ldc 118
    //   565: iconst_2
    //   566: ldc 157
    //   568: invokeinterface 133 4 0
    //   573: return
    //   574: getstatic 116	mof:a	Lmos;
    //   577: invokeinterface 138 1 0
    //   582: ifeq +45 -> 627
    //   585: getstatic 116	mof:a	Lmos;
    //   588: ldc 118
    //   590: iconst_2
    //   591: ldc 159
    //   593: invokeinterface 133 4 0
    //   598: iconst_0
    //   599: istore_3
    //   600: goto -441 -> 159
    //   603: getstatic 116	mof:a	Lmos;
    //   606: invokeinterface 138 1 0
    //   611: ifeq +16 -> 627
    //   614: getstatic 116	mof:a	Lmos;
    //   617: ldc 118
    //   619: iconst_2
    //   620: ldc 161
    //   622: invokeinterface 133 4 0
    //   627: iconst_0
    //   628: istore_3
    //   629: goto -470 -> 159
    //   632: astore 9
    //   634: getstatic 19	mol:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   637: invokevirtual 136	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   640: aload 9
    //   642: athrow
    //   643: astore 9
    //   645: getstatic 116	mof:a	Lmos;
    //   648: invokeinterface 138 1 0
    //   653: ifeq -444 -> 209
    //   656: getstatic 116	mof:a	Lmos;
    //   659: ldc 118
    //   661: iconst_2
    //   662: new 63	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   669: ldc 163
    //   671: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload 9
    //   676: invokevirtual 164	java/lang/Exception:toString	()Ljava/lang/String;
    //   679: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: invokeinterface 133 4 0
    //   690: goto -481 -> 209
    //   693: getstatic 116	mof:a	Lmos;
    //   696: ldc 118
    //   698: iconst_1
    //   699: ldc 166
    //   701: invokeinterface 133 4 0
    //   706: goto -497 -> 209
    //   709: iconst_0
    //   710: istore_0
    //   711: goto -484 -> 227
    //   714: iconst_0
    //   715: istore_1
    //   716: goto -460 -> 256
    //   719: aload 6
    //   721: putstatic 168	mol:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   724: aload 7
    //   726: putstatic 170	mol:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   729: goto -443 -> 286
    //   732: getstatic 116	mof:a	Lmos;
    //   735: invokeinterface 138 1 0
    //   740: ifeq +45 -> 785
    //   743: getstatic 116	mof:a	Lmos;
    //   746: ldc 118
    //   748: iconst_2
    //   749: ldc 172
    //   751: invokeinterface 133 4 0
    //   756: iconst_0
    //   757: istore_3
    //   758: goto -312 -> 446
    //   761: getstatic 116	mof:a	Lmos;
    //   764: invokeinterface 138 1 0
    //   769: ifeq +16 -> 785
    //   772: getstatic 116	mof:a	Lmos;
    //   775: ldc 118
    //   777: iconst_2
    //   778: ldc 174
    //   780: invokeinterface 133 4 0
    //   785: iconst_0
    //   786: istore_3
    //   787: goto -341 -> 446
    //   790: astore 9
    //   792: getstatic 21	mol:jdField_b_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   795: invokevirtual 136	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   798: aload 9
    //   800: athrow
    //   801: astore 9
    //   803: getstatic 116	mof:a	Lmos;
    //   806: invokeinterface 138 1 0
    //   811: ifeq -315 -> 496
    //   814: getstatic 116	mof:a	Lmos;
    //   817: ldc 118
    //   819: iconst_2
    //   820: new 63	java/lang/StringBuilder
    //   823: dup
    //   824: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   827: ldc 176
    //   829: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: aload 9
    //   834: invokevirtual 164	java/lang/Exception:toString	()Ljava/lang/String;
    //   837: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokeinterface 133 4 0
    //   848: goto -352 -> 496
    //   851: getstatic 116	mof:a	Lmos;
    //   854: ldc 118
    //   856: iconst_1
    //   857: ldc 178
    //   859: invokeinterface 133 4 0
    //   864: goto -368 -> 496
    //   867: iconst_0
    //   868: istore_0
    //   869: goto -355 -> 514
    //   872: iconst_0
    //   873: istore_1
    //   874: goto -331 -> 543
    //   877: aload 6
    //   879: putstatic 25	mol:c	Ljava/lang/String;
    //   882: aload 7
    //   884: putstatic 180	mol:d	Ljava/lang/String;
    //   887: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   226	643	0	i	int
    //   255	619	1	j	int
    //   1	541	2	k	int
    //   90	697	3	bool	boolean
    //   98	370	4	l	long
    //   41	837	6	str1	String
    //   11	872	7	str2	String
    //   74	460	8	localFile1	java.io.File
    //   131	304	9	localFile2	java.io.File
    //   632	9	9	localObject1	Object
    //   643	32	9	localException1	java.lang.Exception
    //   790	9	9	localObject2	Object
    //   801	32	9	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   95	157	632	finally
    //   159	203	632	finally
    //   574	598	632	finally
    //   603	627	632	finally
    //   76	91	643	java/lang/Exception
    //   203	209	643	java/lang/Exception
    //   634	643	643	java/lang/Exception
    //   693	706	643	java/lang/Exception
    //   379	444	790	finally
    //   446	490	790	finally
    //   732	756	790	finally
    //   761	785	790	finally
    //   360	375	801	java/lang/Exception
    //   490	496	801	java/lang/Exception
    //   792	801	801	java/lang/Exception
    //   851	864	801	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          int i = Integer.valueOf(paramString).intValue();
          if ((i >= 1000) && (i < 2000)) {
            return false;
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!mof.a.a());
    mof.a.a("HtmlCheckUpdate", 2, "initEnv NumberFormatException");
    return true;
  }
  
  public static String b()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      urk.d("OfflineEnvHelper", "getSDOfflineDir, initEnv");
      a();
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (a(paramString)) {
      return d();
    }
    return c();
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(d)) {
      a();
    }
    return d;
  }
  
  public static String d()
  {
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
      a();
    }
    return jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     mol
 * JD-Core Version:    0.7.0.1
 */