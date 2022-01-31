package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import axlp;
import axlq;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoTrimmer
{
  public static int a;
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  static Process jdField_a_of_type_JavaLangProcess;
  public static AtomicBoolean a;
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  }
  
  public static int a()
  {
    if (jdField_a_of_type_Int == 0) {}
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new axlp());
      if (arrayOfFile == null) {
        return 1;
      }
      jdField_a_of_type_Int = arrayOfFile.length;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        jdField_a_of_type_Int = 1;
      }
    }
    return jdField_a_of_type_Int;
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_1
    //   6: invokestatic 58	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)Laxlq;
    //   9: astore 9
    //   11: aload 9
    //   13: getfield 62	axlq:jdField_a_of_type_Boolean	Z
    //   16: ifne +10 -> 26
    //   19: ldc 64
    //   21: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_1
    //   27: aload_2
    //   28: aload 9
    //   30: invokestatic 69	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Ljava/lang/String;Laxlq;)[Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +11 -> 46
    //   38: ldc 71
    //   40: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   43: bipush 254
    //   45: ireturn
    //   46: aload_0
    //   47: invokestatic 77	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   50: astore 12
    //   52: invokestatic 82	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Ljava/lang/String;
    //   55: astore_0
    //   56: getstatic 83	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   59: ifne +38 -> 97
    //   62: new 32	java/io/File
    //   65: dup
    //   66: new 85	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   73: aload 12
    //   75: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokevirtual 97	java/io/File:exists	()Z
    //   91: ifne +6 -> 97
    //   94: bipush 253
    //   96: ireturn
    //   97: aconst_null
    //   98: astore 9
    //   100: aconst_null
    //   101: astore 10
    //   103: new 99	java/lang/ProcessBuilder
    //   106: dup
    //   107: iconst_0
    //   108: anewarray 101	java/lang/String
    //   111: invokespecial 104	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   114: astore 11
    //   116: aload 11
    //   118: iconst_1
    //   119: invokevirtual 108	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   122: pop
    //   123: new 110	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 111	java/util/ArrayList:<init>	()V
    //   130: astore 13
    //   132: aload 13
    //   134: new 85	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   141: aload 12
    //   143: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 113
    //   148: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokeinterface 119 2 0
    //   159: pop
    //   160: new 85	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   167: ldc 121
    //   169: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 13
    //   174: iconst_0
    //   175: invokeinterface 125 2 0
    //   180: checkcast 101	java/lang/String
    //   183: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   192: aload_1
    //   193: arraylength
    //   194: istore 4
    //   196: iconst_0
    //   197: istore_3
    //   198: iload_3
    //   199: iload 4
    //   201: if_icmpge +21 -> 222
    //   204: aload 13
    //   206: aload_1
    //   207: iload_3
    //   208: aaload
    //   209: invokeinterface 119 2 0
    //   214: pop
    //   215: iload_3
    //   216: iconst_1
    //   217: iadd
    //   218: istore_3
    //   219: goto -21 -> 198
    //   222: aload 13
    //   224: new 85	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   231: aload 12
    //   233: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokeinterface 119 2 0
    //   248: pop
    //   249: aload 11
    //   251: aload 13
    //   253: invokevirtual 129	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   256: pop
    //   257: new 85	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   264: ldc 131
    //   266: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 13
    //   271: aload 13
    //   273: invokeinterface 134 1 0
    //   278: iconst_1
    //   279: isub
    //   280: invokeinterface 125 2 0
    //   285: checkcast 101	java/lang/String
    //   288: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   297: aload 11
    //   299: invokevirtual 138	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   302: astore 13
    //   304: getstatic 17	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   307: astore_0
    //   308: aload_0
    //   309: monitorenter
    //   310: aload 13
    //   312: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   315: aload_0
    //   316: monitorexit
    //   317: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   320: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   323: ifne +256 -> 579
    //   326: aconst_null
    //   327: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   330: aload 13
    //   332: invokevirtual 147	java/lang/Process:destroy	()V
    //   335: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   338: iconst_1
    //   339: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   342: iconst_0
    //   343: ifeq +11 -> 354
    //   346: new 152	java/lang/NullPointerException
    //   349: dup
    //   350: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   353: athrow
    //   354: iconst_0
    //   355: ifeq +11 -> 366
    //   358: new 152	java/lang/NullPointerException
    //   361: dup
    //   362: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   365: athrow
    //   366: iconst_0
    //   367: ifeq -343 -> 24
    //   370: new 152	java/lang/NullPointerException
    //   373: dup
    //   374: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   377: athrow
    //   378: astore_0
    //   379: iconst_m1
    //   380: ireturn
    //   381: astore_1
    //   382: aload_0
    //   383: monitorexit
    //   384: aload_1
    //   385: athrow
    //   386: astore 13
    //   388: aconst_null
    //   389: astore_0
    //   390: aconst_null
    //   391: astore_1
    //   392: aconst_null
    //   393: astore 12
    //   395: sipush -1001
    //   398: istore 4
    //   400: aload 12
    //   402: astore 11
    //   404: aload_1
    //   405: astore 10
    //   407: aload_0
    //   408: astore 9
    //   410: aload 13
    //   412: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   415: aload 12
    //   417: astore 11
    //   419: aload_1
    //   420: astore 10
    //   422: aload_0
    //   423: astore 9
    //   425: new 85	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   432: ldc 158
    //   434: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload 13
    //   439: invokevirtual 159	java/io/IOException:toString	()Ljava/lang/String;
    //   442: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   451: aload_0
    //   452: ifnull +7 -> 459
    //   455: aload_0
    //   456: invokevirtual 164	java/io/InputStream:close	()V
    //   459: aload_1
    //   460: ifnull +7 -> 467
    //   463: aload_1
    //   464: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   467: iload 4
    //   469: istore_3
    //   470: aload 12
    //   472: ifnull +11 -> 483
    //   475: aload 12
    //   477: invokevirtual 170	java/io/BufferedReader:close	()V
    //   480: iload 4
    //   482: istore_3
    //   483: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   486: lstore 7
    //   488: new 85	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   495: ldc 172
    //   497: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: lload 7
    //   502: lload 5
    //   504: lsub
    //   505: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   508: ldc 177
    //   510: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: iload_3
    //   514: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   517: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   523: iload_3
    //   524: ifeq +46 -> 570
    //   527: new 32	java/io/File
    //   530: dup
    //   531: aload_2
    //   532: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   535: astore_0
    //   536: aload_0
    //   537: invokevirtual 97	java/io/File:exists	()Z
    //   540: ifeq +30 -> 570
    //   543: aload_0
    //   544: invokevirtual 183	java/io/File:delete	()Z
    //   547: pop
    //   548: new 85	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   555: ldc 185
    //   557: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: iload_3
    //   561: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   564: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   570: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   573: iconst_1
    //   574: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   577: iload_3
    //   578: ireturn
    //   579: aload 13
    //   581: invokevirtual 189	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   584: astore_0
    //   585: new 166	java/io/InputStreamReader
    //   588: dup
    //   589: aload_0
    //   590: invokespecial 192	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   593: astore_1
    //   594: new 169	java/io/BufferedReader
    //   597: dup
    //   598: aload_1
    //   599: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   602: astore 12
    //   604: aload 12
    //   606: astore 11
    //   608: aload_1
    //   609: astore 10
    //   611: aload_0
    //   612: astore 9
    //   614: aload 13
    //   616: invokevirtual 198	java/lang/Process:waitFor	()I
    //   619: pop
    //   620: aload 12
    //   622: astore 11
    //   624: aload_1
    //   625: astore 10
    //   627: aload_0
    //   628: astore 9
    //   630: aload 13
    //   632: invokevirtual 201	java/lang/Process:exitValue	()I
    //   635: istore 4
    //   637: aload 12
    //   639: astore 11
    //   641: aload_1
    //   642: astore 10
    //   644: aload_0
    //   645: astore 9
    //   647: new 85	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   654: ldc 203
    //   656: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: iload 4
    //   661: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   664: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   670: aload 12
    //   672: astore 11
    //   674: aload_1
    //   675: astore 10
    //   677: aload_0
    //   678: astore 9
    //   680: aload 12
    //   682: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   685: astore 14
    //   687: aload 14
    //   689: ifnull +39 -> 728
    //   692: aload 12
    //   694: astore 11
    //   696: aload_1
    //   697: astore 10
    //   699: aload_0
    //   700: astore 9
    //   702: new 85	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   709: ldc 208
    //   711: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload 14
    //   716: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   725: goto -55 -> 670
    //   728: aload 12
    //   730: astore 11
    //   732: aload_1
    //   733: astore 10
    //   735: aload_0
    //   736: astore 9
    //   738: aload 13
    //   740: invokevirtual 147	java/lang/Process:destroy	()V
    //   743: aload 12
    //   745: astore 11
    //   747: aload_1
    //   748: astore 10
    //   750: aload_0
    //   751: astore 9
    //   753: getstatic 17	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   756: astore 13
    //   758: aload 12
    //   760: astore 11
    //   762: aload_1
    //   763: astore 10
    //   765: aload_0
    //   766: astore 9
    //   768: aload 13
    //   770: monitorenter
    //   771: aconst_null
    //   772: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   775: aload 13
    //   777: monitorexit
    //   778: aload 12
    //   780: astore 11
    //   782: aload_1
    //   783: astore 10
    //   785: aload_0
    //   786: astore 9
    //   788: ldc 210
    //   790: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   793: aload_0
    //   794: ifnull +7 -> 801
    //   797: aload_0
    //   798: invokevirtual 164	java/io/InputStream:close	()V
    //   801: aload_1
    //   802: ifnull +7 -> 809
    //   805: aload_1
    //   806: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   809: iload 4
    //   811: istore_3
    //   812: aload 12
    //   814: ifnull -331 -> 483
    //   817: aload 12
    //   819: invokevirtual 170	java/io/BufferedReader:close	()V
    //   822: iload 4
    //   824: istore_3
    //   825: goto -342 -> 483
    //   828: astore_0
    //   829: iload 4
    //   831: istore_3
    //   832: goto -349 -> 483
    //   835: astore 14
    //   837: aload 13
    //   839: monitorexit
    //   840: aload 12
    //   842: astore 11
    //   844: aload_1
    //   845: astore 10
    //   847: aload_0
    //   848: astore 9
    //   850: aload 14
    //   852: athrow
    //   853: astore 13
    //   855: sipush -1002
    //   858: istore 4
    //   860: aload 12
    //   862: astore 11
    //   864: aload_1
    //   865: astore 10
    //   867: aload_0
    //   868: astore 9
    //   870: aload 13
    //   872: invokevirtual 211	java/lang/InterruptedException:printStackTrace	()V
    //   875: aload 12
    //   877: astore 11
    //   879: aload_1
    //   880: astore 10
    //   882: aload_0
    //   883: astore 9
    //   885: new 85	java/lang/StringBuilder
    //   888: dup
    //   889: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   892: ldc 213
    //   894: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: aload 13
    //   899: invokevirtual 214	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   902: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   911: aload_0
    //   912: ifnull +7 -> 919
    //   915: aload_0
    //   916: invokevirtual 164	java/io/InputStream:close	()V
    //   919: aload_1
    //   920: ifnull +7 -> 927
    //   923: aload_1
    //   924: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   927: iload 4
    //   929: istore_3
    //   930: aload 12
    //   932: ifnull -449 -> 483
    //   935: aload 12
    //   937: invokevirtual 170	java/io/BufferedReader:close	()V
    //   940: iload 4
    //   942: istore_3
    //   943: goto -460 -> 483
    //   946: astore_0
    //   947: iload 4
    //   949: istore_3
    //   950: goto -467 -> 483
    //   953: astore 13
    //   955: aconst_null
    //   956: astore_0
    //   957: aconst_null
    //   958: astore_1
    //   959: aconst_null
    //   960: astore 12
    //   962: sipush -1003
    //   965: istore 4
    //   967: aload 12
    //   969: astore 11
    //   971: aload_1
    //   972: astore 10
    //   974: aload_0
    //   975: astore 9
    //   977: aload 13
    //   979: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   982: aload 12
    //   984: astore 11
    //   986: aload_1
    //   987: astore 10
    //   989: aload_0
    //   990: astore 9
    //   992: new 85	java/lang/StringBuilder
    //   995: dup
    //   996: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   999: ldc 217
    //   1001: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload 13
    //   1006: invokevirtual 218	java/lang/Exception:toString	()Ljava/lang/String;
    //   1009: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   1018: aload_0
    //   1019: ifnull +7 -> 1026
    //   1022: aload_0
    //   1023: invokevirtual 164	java/io/InputStream:close	()V
    //   1026: aload_1
    //   1027: ifnull +7 -> 1034
    //   1030: aload_1
    //   1031: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1034: iload 4
    //   1036: istore_3
    //   1037: aload 12
    //   1039: ifnull -556 -> 483
    //   1042: aload 12
    //   1044: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1047: iload 4
    //   1049: istore_3
    //   1050: goto -567 -> 483
    //   1053: astore_0
    //   1054: iload 4
    //   1056: istore_3
    //   1057: goto -574 -> 483
    //   1060: astore_1
    //   1061: aconst_null
    //   1062: astore_0
    //   1063: aload 9
    //   1065: astore_2
    //   1066: aload_0
    //   1067: ifnull +7 -> 1074
    //   1070: aload_0
    //   1071: invokevirtual 164	java/io/InputStream:close	()V
    //   1074: aload_2
    //   1075: ifnull +7 -> 1082
    //   1078: aload_2
    //   1079: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1082: aload 10
    //   1084: ifnull +8 -> 1092
    //   1087: aload 10
    //   1089: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1092: aload_1
    //   1093: athrow
    //   1094: astore_0
    //   1095: goto -525 -> 570
    //   1098: astore_0
    //   1099: goto -7 -> 1092
    //   1102: astore_1
    //   1103: aload 9
    //   1105: astore_2
    //   1106: goto -40 -> 1066
    //   1109: astore 9
    //   1111: aload_1
    //   1112: astore_2
    //   1113: aload 9
    //   1115: astore_1
    //   1116: goto -50 -> 1066
    //   1119: astore_1
    //   1120: aload 10
    //   1122: astore_2
    //   1123: aload 11
    //   1125: astore 10
    //   1127: aload 9
    //   1129: astore_0
    //   1130: goto -64 -> 1066
    //   1133: astore 13
    //   1135: aconst_null
    //   1136: astore_1
    //   1137: aconst_null
    //   1138: astore 12
    //   1140: goto -178 -> 962
    //   1143: astore 13
    //   1145: aconst_null
    //   1146: astore 12
    //   1148: goto -186 -> 962
    //   1151: astore 13
    //   1153: goto -191 -> 962
    //   1156: astore 13
    //   1158: aconst_null
    //   1159: astore_0
    //   1160: aconst_null
    //   1161: astore_1
    //   1162: aconst_null
    //   1163: astore 12
    //   1165: goto -310 -> 855
    //   1168: astore 13
    //   1170: aconst_null
    //   1171: astore_1
    //   1172: aconst_null
    //   1173: astore 12
    //   1175: goto -320 -> 855
    //   1178: astore 13
    //   1180: aconst_null
    //   1181: astore 12
    //   1183: goto -328 -> 855
    //   1186: astore_0
    //   1187: iload 4
    //   1189: istore_3
    //   1190: goto -707 -> 483
    //   1193: astore 13
    //   1195: aconst_null
    //   1196: astore_1
    //   1197: aconst_null
    //   1198: astore 12
    //   1200: goto -805 -> 395
    //   1203: astore 13
    //   1205: aconst_null
    //   1206: astore 12
    //   1208: goto -813 -> 395
    //   1211: astore 13
    //   1213: goto -818 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1216	0	paramContext	Context
    //   0	1216	1	paramString1	String
    //   0	1216	2	paramString2	String
    //   197	993	3	i	int
    //   194	994	4	j	int
    //   3	500	5	l1	long
    //   486	15	7	l2	long
    //   9	1095	9	localObject1	Object
    //   1109	19	9	localObject2	Object
    //   101	1025	10	localObject3	Object
    //   114	1010	11	localObject4	Object
    //   50	1157	12	localObject5	Object
    //   130	201	13	localObject6	Object
    //   386	353	13	localIOException1	java.io.IOException
    //   756	82	13	localObject7	Object
    //   853	45	13	localInterruptedException1	java.lang.InterruptedException
    //   953	52	13	localException1	Exception
    //   1133	1	13	localException2	Exception
    //   1143	1	13	localException3	Exception
    //   1151	1	13	localException4	Exception
    //   1156	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1168	1	13	localInterruptedException3	java.lang.InterruptedException
    //   1178	1	13	localInterruptedException4	java.lang.InterruptedException
    //   1193	1	13	localIOException2	java.io.IOException
    //   1203	1	13	localIOException3	java.io.IOException
    //   1211	1	13	localIOException4	java.io.IOException
    //   685	30	14	str	String
    //   835	16	14	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   346	354	378	java/io/IOException
    //   358	366	378	java/io/IOException
    //   370	378	378	java/io/IOException
    //   310	317	381	finally
    //   382	384	381	finally
    //   103	196	386	java/io/IOException
    //   204	215	386	java/io/IOException
    //   222	310	386	java/io/IOException
    //   317	342	386	java/io/IOException
    //   384	386	386	java/io/IOException
    //   579	585	386	java/io/IOException
    //   797	801	828	java/io/IOException
    //   805	809	828	java/io/IOException
    //   817	822	828	java/io/IOException
    //   771	778	835	finally
    //   837	840	835	finally
    //   614	620	853	java/lang/InterruptedException
    //   630	637	853	java/lang/InterruptedException
    //   647	670	853	java/lang/InterruptedException
    //   680	687	853	java/lang/InterruptedException
    //   702	725	853	java/lang/InterruptedException
    //   738	743	853	java/lang/InterruptedException
    //   753	758	853	java/lang/InterruptedException
    //   768	771	853	java/lang/InterruptedException
    //   788	793	853	java/lang/InterruptedException
    //   850	853	853	java/lang/InterruptedException
    //   915	919	946	java/io/IOException
    //   923	927	946	java/io/IOException
    //   935	940	946	java/io/IOException
    //   103	196	953	java/lang/Exception
    //   204	215	953	java/lang/Exception
    //   222	310	953	java/lang/Exception
    //   317	342	953	java/lang/Exception
    //   384	386	953	java/lang/Exception
    //   579	585	953	java/lang/Exception
    //   1022	1026	1053	java/io/IOException
    //   1030	1034	1053	java/io/IOException
    //   1042	1047	1053	java/io/IOException
    //   103	196	1060	finally
    //   204	215	1060	finally
    //   222	310	1060	finally
    //   317	342	1060	finally
    //   384	386	1060	finally
    //   579	585	1060	finally
    //   527	570	1094	java/lang/Exception
    //   1070	1074	1098	java/io/IOException
    //   1078	1082	1098	java/io/IOException
    //   1087	1092	1098	java/io/IOException
    //   585	594	1102	finally
    //   594	604	1109	finally
    //   410	415	1119	finally
    //   425	451	1119	finally
    //   614	620	1119	finally
    //   630	637	1119	finally
    //   647	670	1119	finally
    //   680	687	1119	finally
    //   702	725	1119	finally
    //   738	743	1119	finally
    //   753	758	1119	finally
    //   768	771	1119	finally
    //   788	793	1119	finally
    //   850	853	1119	finally
    //   870	875	1119	finally
    //   885	911	1119	finally
    //   977	982	1119	finally
    //   992	1018	1119	finally
    //   585	594	1133	java/lang/Exception
    //   594	604	1143	java/lang/Exception
    //   614	620	1151	java/lang/Exception
    //   630	637	1151	java/lang/Exception
    //   647	670	1151	java/lang/Exception
    //   680	687	1151	java/lang/Exception
    //   702	725	1151	java/lang/Exception
    //   738	743	1151	java/lang/Exception
    //   753	758	1151	java/lang/Exception
    //   768	771	1151	java/lang/Exception
    //   788	793	1151	java/lang/Exception
    //   850	853	1151	java/lang/Exception
    //   103	196	1156	java/lang/InterruptedException
    //   204	215	1156	java/lang/InterruptedException
    //   222	310	1156	java/lang/InterruptedException
    //   317	342	1156	java/lang/InterruptedException
    //   384	386	1156	java/lang/InterruptedException
    //   579	585	1156	java/lang/InterruptedException
    //   585	594	1168	java/lang/InterruptedException
    //   594	604	1178	java/lang/InterruptedException
    //   455	459	1186	java/io/IOException
    //   463	467	1186	java/io/IOException
    //   475	480	1186	java/io/IOException
    //   585	594	1193	java/io/IOException
    //   594	604	1203	java/io/IOException
    //   614	620	1211	java/io/IOException
    //   630	637	1211	java/io/IOException
    //   647	670	1211	java/io/IOException
    //   680	687	1211	java/io/IOException
    //   702	725	1211	java/io/IOException
    //   738	743	1211	java/io/IOException
    //   753	758	1211	java/io/IOException
    //   768	771	1211	java/io/IOException
    //   788	793	1211	java/io/IOException
    //   850	853	1211	java/io/IOException
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString1, String paramString2, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, axlr paramaxlr, axff paramaxff, axfh paramaxfh)
  {
    // Byte code:
    //   0: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   3: lstore 11
    //   5: new 60	axlq
    //   8: dup
    //   9: invokespecial 220	axlq:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: iconst_1
    //   15: putfield 62	axlq:jdField_a_of_type_Boolean	Z
    //   18: aload_3
    //   19: aload 6
    //   21: getfield 225	axfh:jdField_c_of_type_Int	I
    //   24: invokestatic 229	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: putfield 232	axlq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: aload_3
    //   31: aload 6
    //   33: getfield 233	axfh:jdField_a_of_type_Int	I
    //   36: putfield 234	axlq:jdField_a_of_type_Int	I
    //   39: aload_3
    //   40: aload 6
    //   42: getfield 237	axfh:jdField_b_of_type_Int	I
    //   45: putfield 238	axlq:jdField_b_of_type_Int	I
    //   48: aload_3
    //   49: aload 6
    //   51: getfield 241	axfh:jdField_d_of_type_Int	I
    //   54: i2l
    //   55: putfield 244	axlq:jdField_c_of_type_Long	J
    //   58: aload_3
    //   59: aload 5
    //   61: getfield 247	axff:jdField_a_of_type_Int	I
    //   64: putfield 248	axlq:jdField_c_of_type_Int	I
    //   67: aload_3
    //   68: aload 5
    //   70: getfield 249	axff:jdField_b_of_type_Int	I
    //   73: putfield 250	axlq:jdField_d_of_type_Int	I
    //   76: aload_3
    //   77: bipush 25
    //   79: putfield 253	axlq:jdField_e_of_type_Int	I
    //   82: aload_3
    //   83: aload 5
    //   85: getfield 255	axff:jdField_b_of_type_Long	J
    //   88: putfield 257	axlq:jdField_d_of_type_Long	J
    //   91: aload_3
    //   92: aload 5
    //   94: getfield 259	axff:jdField_a_of_type_Long	J
    //   97: putfield 261	axlq:jdField_e_of_type_Long	J
    //   100: aload_3
    //   101: getfield 62	axlq:jdField_a_of_type_Boolean	Z
    //   104: ifne +10 -> 114
    //   107: ldc 64
    //   109: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   112: iconst_m1
    //   113: ireturn
    //   114: aload_1
    //   115: aload_2
    //   116: aload_3
    //   117: invokestatic 263	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:b	(Ljava/lang/String;Ljava/lang/String;Laxlq;)[Ljava/lang/String;
    //   120: astore 6
    //   122: aload 6
    //   124: ifnonnull +11 -> 135
    //   127: ldc 71
    //   129: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   132: bipush 254
    //   134: ireturn
    //   135: aload_0
    //   136: invokestatic 77	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   139: astore 13
    //   141: invokestatic 82	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Ljava/lang/String;
    //   144: astore 15
    //   146: getstatic 83	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   149: ifne +39 -> 188
    //   152: new 32	java/io/File
    //   155: dup
    //   156: new 85	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   163: aload 13
    //   165: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 15
    //   170: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: invokevirtual 97	java/io/File:exists	()Z
    //   182: ifne +6 -> 188
    //   185: bipush 253
    //   187: ireturn
    //   188: aconst_null
    //   189: astore_1
    //   190: aconst_null
    //   191: astore 5
    //   193: aconst_null
    //   194: astore_3
    //   195: new 99	java/lang/ProcessBuilder
    //   198: dup
    //   199: iconst_0
    //   200: anewarray 101	java/lang/String
    //   203: invokespecial 104	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   206: astore 14
    //   208: aload 14
    //   210: iconst_1
    //   211: invokevirtual 108	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   214: pop
    //   215: new 110	java/util/ArrayList
    //   218: dup
    //   219: invokespecial 111	java/util/ArrayList:<init>	()V
    //   222: astore_0
    //   223: aload_0
    //   224: new 85	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   231: aload 13
    //   233: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc 113
    //   238: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokeinterface 119 2 0
    //   249: pop
    //   250: new 85	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   257: ldc 121
    //   259: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_0
    //   263: iconst_0
    //   264: invokeinterface 125 2 0
    //   269: checkcast 101	java/lang/String
    //   272: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   281: aload 6
    //   283: arraylength
    //   284: istore 8
    //   286: iconst_0
    //   287: istore 7
    //   289: iload 7
    //   291: iload 8
    //   293: if_icmpge +24 -> 317
    //   296: aload_0
    //   297: aload 6
    //   299: iload 7
    //   301: aaload
    //   302: invokeinterface 119 2 0
    //   307: pop
    //   308: iload 7
    //   310: iconst_1
    //   311: iadd
    //   312: istore 7
    //   314: goto -25 -> 289
    //   317: aload_0
    //   318: new 85	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   325: aload 13
    //   327: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 15
    //   332: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokeinterface 119 2 0
    //   343: pop
    //   344: aload 14
    //   346: aload_0
    //   347: invokevirtual 129	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   350: pop
    //   351: new 85	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   358: ldc 131
    //   360: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_0
    //   364: aload_0
    //   365: invokeinterface 134 1 0
    //   370: iconst_1
    //   371: isub
    //   372: invokeinterface 125 2 0
    //   377: checkcast 101	java/lang/String
    //   380: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   389: aload 14
    //   391: invokevirtual 138	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   394: astore 14
    //   396: getstatic 17	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   399: astore_0
    //   400: aload_0
    //   401: monitorenter
    //   402: aload 14
    //   404: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   407: aload_0
    //   408: monitorexit
    //   409: aload 4
    //   411: ifnull +13 -> 424
    //   414: aload 4
    //   416: getstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   419: invokeinterface 268 2 0
    //   424: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   427: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   430: ifne +274 -> 704
    //   433: aload 4
    //   435: ifnull +10 -> 445
    //   438: aload 4
    //   440: invokeinterface 270 1 0
    //   445: aconst_null
    //   446: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   449: aload 14
    //   451: invokevirtual 147	java/lang/Process:destroy	()V
    //   454: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   457: iconst_1
    //   458: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   461: iconst_0
    //   462: ifeq +11 -> 473
    //   465: new 152	java/lang/NullPointerException
    //   468: dup
    //   469: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   472: athrow
    //   473: iconst_0
    //   474: ifeq +11 -> 485
    //   477: new 152	java/lang/NullPointerException
    //   480: dup
    //   481: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   484: athrow
    //   485: iconst_0
    //   486: ifeq -374 -> 112
    //   489: new 152	java/lang/NullPointerException
    //   492: dup
    //   493: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   496: athrow
    //   497: astore_0
    //   498: iconst_m1
    //   499: ireturn
    //   500: astore 4
    //   502: aload_0
    //   503: monitorexit
    //   504: aload 4
    //   506: athrow
    //   507: astore 14
    //   509: aconst_null
    //   510: astore_0
    //   511: aconst_null
    //   512: astore_1
    //   513: aconst_null
    //   514: astore 4
    //   516: sipush -1001
    //   519: istore 8
    //   521: aload 4
    //   523: astore 6
    //   525: aload_1
    //   526: astore 5
    //   528: aload_0
    //   529: astore_3
    //   530: aload 14
    //   532: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   535: aload 4
    //   537: astore 6
    //   539: aload_1
    //   540: astore 5
    //   542: aload_0
    //   543: astore_3
    //   544: new 85	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   551: ldc 158
    //   553: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 14
    //   558: invokevirtual 159	java/io/IOException:toString	()Ljava/lang/String;
    //   561: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   570: aload_0
    //   571: ifnull +7 -> 578
    //   574: aload_0
    //   575: invokevirtual 164	java/io/InputStream:close	()V
    //   578: aload_1
    //   579: ifnull +7 -> 586
    //   582: aload_1
    //   583: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   586: iload 8
    //   588: istore 7
    //   590: aload 4
    //   592: ifnull +12 -> 604
    //   595: aload 4
    //   597: invokevirtual 170	java/io/BufferedReader:close	()V
    //   600: iload 8
    //   602: istore 7
    //   604: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   607: lstore 9
    //   609: new 85	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   616: ldc 172
    //   618: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: lload 9
    //   623: lload 11
    //   625: lsub
    //   626: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   629: ldc 177
    //   631: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: iload 7
    //   636: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   639: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   645: iload 7
    //   647: ifeq +47 -> 694
    //   650: new 32	java/io/File
    //   653: dup
    //   654: aload_2
    //   655: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   658: astore_0
    //   659: aload_0
    //   660: invokevirtual 97	java/io/File:exists	()Z
    //   663: ifeq +31 -> 694
    //   666: aload_0
    //   667: invokevirtual 183	java/io/File:delete	()Z
    //   670: pop
    //   671: new 85	java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   678: ldc 185
    //   680: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: iload 7
    //   685: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   688: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   694: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   697: iconst_1
    //   698: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   701: iload 7
    //   703: ireturn
    //   704: aload 14
    //   706: invokevirtual 189	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   709: astore_0
    //   710: new 166	java/io/InputStreamReader
    //   713: dup
    //   714: aload_0
    //   715: invokespecial 192	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   718: astore_1
    //   719: new 169	java/io/BufferedReader
    //   722: dup
    //   723: aload_1
    //   724: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   727: astore 13
    //   729: aload 13
    //   731: astore 6
    //   733: aload_1
    //   734: astore 5
    //   736: aload_0
    //   737: astore_3
    //   738: aload 14
    //   740: invokevirtual 198	java/lang/Process:waitFor	()I
    //   743: pop
    //   744: aload 13
    //   746: astore 6
    //   748: aload_1
    //   749: astore 5
    //   751: aload_0
    //   752: astore_3
    //   753: aload 14
    //   755: invokevirtual 201	java/lang/Process:exitValue	()I
    //   758: istore 8
    //   760: aload 13
    //   762: astore 6
    //   764: aload_1
    //   765: astore 5
    //   767: aload_0
    //   768: astore_3
    //   769: new 85	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   776: ldc 203
    //   778: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: iload 8
    //   783: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   786: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   789: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   792: aload 13
    //   794: astore 6
    //   796: aload_1
    //   797: astore 5
    //   799: aload_0
    //   800: astore_3
    //   801: aload 13
    //   803: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   806: astore 15
    //   808: aload 15
    //   810: ifnull +38 -> 848
    //   813: aload 13
    //   815: astore 6
    //   817: aload_1
    //   818: astore 5
    //   820: aload_0
    //   821: astore_3
    //   822: new 85	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   829: ldc 208
    //   831: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: aload 15
    //   836: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   845: goto -53 -> 792
    //   848: aload 13
    //   850: astore 6
    //   852: aload_1
    //   853: astore 5
    //   855: aload_0
    //   856: astore_3
    //   857: aload 14
    //   859: invokevirtual 147	java/lang/Process:destroy	()V
    //   862: aload 4
    //   864: ifnull +19 -> 883
    //   867: aload 13
    //   869: astore 6
    //   871: aload_1
    //   872: astore 5
    //   874: aload_0
    //   875: astore_3
    //   876: aload 4
    //   878: invokeinterface 272 1 0
    //   883: aload 13
    //   885: astore 6
    //   887: aload_1
    //   888: astore 5
    //   890: aload_0
    //   891: astore_3
    //   892: getstatic 17	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   895: astore 14
    //   897: aload 13
    //   899: astore 6
    //   901: aload_1
    //   902: astore 5
    //   904: aload_0
    //   905: astore_3
    //   906: aload 14
    //   908: monitorenter
    //   909: aconst_null
    //   910: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   913: aload 14
    //   915: monitorexit
    //   916: aload 13
    //   918: astore 6
    //   920: aload_1
    //   921: astore 5
    //   923: aload_0
    //   924: astore_3
    //   925: ldc 210
    //   927: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   930: aload_0
    //   931: ifnull +7 -> 938
    //   934: aload_0
    //   935: invokevirtual 164	java/io/InputStream:close	()V
    //   938: aload_1
    //   939: ifnull +7 -> 946
    //   942: aload_1
    //   943: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   946: iload 8
    //   948: istore 7
    //   950: aload 13
    //   952: ifnull -348 -> 604
    //   955: aload 13
    //   957: invokevirtual 170	java/io/BufferedReader:close	()V
    //   960: iload 8
    //   962: istore 7
    //   964: goto -360 -> 604
    //   967: astore_0
    //   968: iload 8
    //   970: istore 7
    //   972: goto -368 -> 604
    //   975: astore 4
    //   977: aload 14
    //   979: monitorexit
    //   980: aload 13
    //   982: astore 6
    //   984: aload_1
    //   985: astore 5
    //   987: aload_0
    //   988: astore_3
    //   989: aload 4
    //   991: athrow
    //   992: astore_3
    //   993: aload 13
    //   995: astore 4
    //   997: aload_3
    //   998: astore 13
    //   1000: sipush -1002
    //   1003: istore 8
    //   1005: aload 4
    //   1007: astore 6
    //   1009: aload_1
    //   1010: astore 5
    //   1012: aload_0
    //   1013: astore_3
    //   1014: aload 13
    //   1016: invokevirtual 211	java/lang/InterruptedException:printStackTrace	()V
    //   1019: aload 4
    //   1021: astore 6
    //   1023: aload_1
    //   1024: astore 5
    //   1026: aload_0
    //   1027: astore_3
    //   1028: new 85	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1035: ldc 213
    //   1037: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: aload 13
    //   1042: invokevirtual 214	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   1045: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   1054: aload_0
    //   1055: ifnull +7 -> 1062
    //   1058: aload_0
    //   1059: invokevirtual 164	java/io/InputStream:close	()V
    //   1062: aload_1
    //   1063: ifnull +7 -> 1070
    //   1066: aload_1
    //   1067: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1070: iload 8
    //   1072: istore 7
    //   1074: aload 4
    //   1076: ifnull -472 -> 604
    //   1079: aload 4
    //   1081: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1084: iload 8
    //   1086: istore 7
    //   1088: goto -484 -> 604
    //   1091: astore_0
    //   1092: iload 8
    //   1094: istore 7
    //   1096: goto -492 -> 604
    //   1099: astore 14
    //   1101: aconst_null
    //   1102: astore_0
    //   1103: aconst_null
    //   1104: astore_1
    //   1105: aconst_null
    //   1106: astore 4
    //   1108: sipush -1003
    //   1111: istore 8
    //   1113: aload 4
    //   1115: astore 6
    //   1117: aload_1
    //   1118: astore 5
    //   1120: aload_0
    //   1121: astore_3
    //   1122: aload 14
    //   1124: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   1127: aload 4
    //   1129: astore 6
    //   1131: aload_1
    //   1132: astore 5
    //   1134: aload_0
    //   1135: astore_3
    //   1136: new 85	java/lang/StringBuilder
    //   1139: dup
    //   1140: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1143: ldc 217
    //   1145: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: aload 14
    //   1150: invokevirtual 218	java/lang/Exception:toString	()Ljava/lang/String;
    //   1153: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1159: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   1162: aload_0
    //   1163: ifnull +7 -> 1170
    //   1166: aload_0
    //   1167: invokevirtual 164	java/io/InputStream:close	()V
    //   1170: aload_1
    //   1171: ifnull +7 -> 1178
    //   1174: aload_1
    //   1175: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1178: iload 8
    //   1180: istore 7
    //   1182: aload 4
    //   1184: ifnull -580 -> 604
    //   1187: aload 4
    //   1189: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1192: iload 8
    //   1194: istore 7
    //   1196: goto -592 -> 604
    //   1199: astore_0
    //   1200: iload 8
    //   1202: istore 7
    //   1204: goto -600 -> 604
    //   1207: astore_0
    //   1208: aload 5
    //   1210: astore_2
    //   1211: aload_1
    //   1212: ifnull +7 -> 1219
    //   1215: aload_1
    //   1216: invokevirtual 164	java/io/InputStream:close	()V
    //   1219: aload_2
    //   1220: ifnull +7 -> 1227
    //   1223: aload_2
    //   1224: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1227: aload_3
    //   1228: ifnull +7 -> 1235
    //   1231: aload_3
    //   1232: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1235: aload_0
    //   1236: athrow
    //   1237: astore_0
    //   1238: goto -544 -> 694
    //   1241: astore_1
    //   1242: goto -7 -> 1235
    //   1245: astore_2
    //   1246: aload_0
    //   1247: astore_1
    //   1248: aload_2
    //   1249: astore_0
    //   1250: aload 5
    //   1252: astore_2
    //   1253: goto -42 -> 1211
    //   1256: astore 4
    //   1258: aload_1
    //   1259: astore_2
    //   1260: aload_0
    //   1261: astore_1
    //   1262: aload 4
    //   1264: astore_0
    //   1265: goto -54 -> 1211
    //   1268: astore_0
    //   1269: aload 5
    //   1271: astore_2
    //   1272: aload_3
    //   1273: astore_1
    //   1274: aload 6
    //   1276: astore_3
    //   1277: goto -66 -> 1211
    //   1280: astore 14
    //   1282: aconst_null
    //   1283: astore_1
    //   1284: aconst_null
    //   1285: astore 4
    //   1287: goto -179 -> 1108
    //   1290: astore 14
    //   1292: aconst_null
    //   1293: astore 4
    //   1295: goto -187 -> 1108
    //   1298: astore 14
    //   1300: aload 13
    //   1302: astore 4
    //   1304: goto -196 -> 1108
    //   1307: astore 13
    //   1309: aconst_null
    //   1310: astore_0
    //   1311: aconst_null
    //   1312: astore_1
    //   1313: aconst_null
    //   1314: astore 4
    //   1316: goto -316 -> 1000
    //   1319: astore 13
    //   1321: aconst_null
    //   1322: astore_1
    //   1323: aconst_null
    //   1324: astore 4
    //   1326: goto -326 -> 1000
    //   1329: astore 13
    //   1331: aconst_null
    //   1332: astore 4
    //   1334: goto -334 -> 1000
    //   1337: astore_0
    //   1338: iload 8
    //   1340: istore 7
    //   1342: goto -738 -> 604
    //   1345: astore 14
    //   1347: aconst_null
    //   1348: astore_1
    //   1349: aconst_null
    //   1350: astore 4
    //   1352: goto -836 -> 516
    //   1355: astore 14
    //   1357: aconst_null
    //   1358: astore 4
    //   1360: goto -844 -> 516
    //   1363: astore 14
    //   1365: aload 13
    //   1367: astore 4
    //   1369: goto -853 -> 516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1372	0	paramContext	Context
    //   0	1372	1	paramString1	String
    //   0	1372	2	paramString2	String
    //   0	1372	3	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1372	4	paramaxlr	axlr
    //   0	1372	5	paramaxff	axff
    //   0	1372	6	paramaxfh	axfh
    //   287	1054	7	i	int
    //   284	1055	8	j	int
    //   607	15	9	l1	long
    //   3	621	11	l2	long
    //   139	1162	13	localObject1	Object
    //   1307	1	13	localInterruptedException1	java.lang.InterruptedException
    //   1319	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1329	37	13	localInterruptedException3	java.lang.InterruptedException
    //   206	244	14	localObject2	Object
    //   507	351	14	localIOException1	java.io.IOException
    //   895	83	14	localObject3	Object
    //   1099	50	14	localException1	Exception
    //   1280	1	14	localException2	Exception
    //   1290	1	14	localException3	Exception
    //   1298	1	14	localException4	Exception
    //   1345	1	14	localIOException2	java.io.IOException
    //   1355	1	14	localIOException3	java.io.IOException
    //   1363	1	14	localIOException4	java.io.IOException
    //   144	691	15	str	String
    // Exception table:
    //   from	to	target	type
    //   465	473	497	java/io/IOException
    //   477	485	497	java/io/IOException
    //   489	497	497	java/io/IOException
    //   402	409	500	finally
    //   502	504	500	finally
    //   195	286	507	java/io/IOException
    //   296	308	507	java/io/IOException
    //   317	402	507	java/io/IOException
    //   414	424	507	java/io/IOException
    //   424	433	507	java/io/IOException
    //   438	445	507	java/io/IOException
    //   445	461	507	java/io/IOException
    //   504	507	507	java/io/IOException
    //   704	710	507	java/io/IOException
    //   934	938	967	java/io/IOException
    //   942	946	967	java/io/IOException
    //   955	960	967	java/io/IOException
    //   909	916	975	finally
    //   977	980	975	finally
    //   738	744	992	java/lang/InterruptedException
    //   753	760	992	java/lang/InterruptedException
    //   769	792	992	java/lang/InterruptedException
    //   801	808	992	java/lang/InterruptedException
    //   822	845	992	java/lang/InterruptedException
    //   857	862	992	java/lang/InterruptedException
    //   876	883	992	java/lang/InterruptedException
    //   892	897	992	java/lang/InterruptedException
    //   906	909	992	java/lang/InterruptedException
    //   925	930	992	java/lang/InterruptedException
    //   989	992	992	java/lang/InterruptedException
    //   1058	1062	1091	java/io/IOException
    //   1066	1070	1091	java/io/IOException
    //   1079	1084	1091	java/io/IOException
    //   195	286	1099	java/lang/Exception
    //   296	308	1099	java/lang/Exception
    //   317	402	1099	java/lang/Exception
    //   414	424	1099	java/lang/Exception
    //   424	433	1099	java/lang/Exception
    //   438	445	1099	java/lang/Exception
    //   445	461	1099	java/lang/Exception
    //   504	507	1099	java/lang/Exception
    //   704	710	1099	java/lang/Exception
    //   1166	1170	1199	java/io/IOException
    //   1174	1178	1199	java/io/IOException
    //   1187	1192	1199	java/io/IOException
    //   195	286	1207	finally
    //   296	308	1207	finally
    //   317	402	1207	finally
    //   414	424	1207	finally
    //   424	433	1207	finally
    //   438	445	1207	finally
    //   445	461	1207	finally
    //   504	507	1207	finally
    //   704	710	1207	finally
    //   650	694	1237	java/lang/Exception
    //   1215	1219	1241	java/io/IOException
    //   1223	1227	1241	java/io/IOException
    //   1231	1235	1241	java/io/IOException
    //   710	719	1245	finally
    //   719	729	1256	finally
    //   530	535	1268	finally
    //   544	570	1268	finally
    //   738	744	1268	finally
    //   753	760	1268	finally
    //   769	792	1268	finally
    //   801	808	1268	finally
    //   822	845	1268	finally
    //   857	862	1268	finally
    //   876	883	1268	finally
    //   892	897	1268	finally
    //   906	909	1268	finally
    //   925	930	1268	finally
    //   989	992	1268	finally
    //   1014	1019	1268	finally
    //   1028	1054	1268	finally
    //   1122	1127	1268	finally
    //   1136	1162	1268	finally
    //   710	719	1280	java/lang/Exception
    //   719	729	1290	java/lang/Exception
    //   738	744	1298	java/lang/Exception
    //   753	760	1298	java/lang/Exception
    //   769	792	1298	java/lang/Exception
    //   801	808	1298	java/lang/Exception
    //   822	845	1298	java/lang/Exception
    //   857	862	1298	java/lang/Exception
    //   876	883	1298	java/lang/Exception
    //   892	897	1298	java/lang/Exception
    //   906	909	1298	java/lang/Exception
    //   925	930	1298	java/lang/Exception
    //   989	992	1298	java/lang/Exception
    //   195	286	1307	java/lang/InterruptedException
    //   296	308	1307	java/lang/InterruptedException
    //   317	402	1307	java/lang/InterruptedException
    //   414	424	1307	java/lang/InterruptedException
    //   424	433	1307	java/lang/InterruptedException
    //   438	445	1307	java/lang/InterruptedException
    //   445	461	1307	java/lang/InterruptedException
    //   504	507	1307	java/lang/InterruptedException
    //   704	710	1307	java/lang/InterruptedException
    //   710	719	1319	java/lang/InterruptedException
    //   719	729	1329	java/lang/InterruptedException
    //   574	578	1337	java/io/IOException
    //   582	586	1337	java/io/IOException
    //   595	600	1337	java/io/IOException
    //   710	719	1345	java/io/IOException
    //   719	729	1355	java/io/IOException
    //   738	744	1363	java/io/IOException
    //   753	760	1363	java/io/IOException
    //   769	792	1363	java/io/IOException
    //   801	808	1363	java/io/IOException
    //   822	845	1363	java/io/IOException
    //   857	862	1363	java/io/IOException
    //   876	883	1363	java/io/IOException
    //   892	897	1363	java/io/IOException
    //   906	909	1363	java/io/IOException
    //   925	930	1363	java/io/IOException
    //   989	992	1363	java/io/IOException
  }
  
  public static axlq a(String paramString)
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.lvcc.name(), "640|640|384|768|30");
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length <= 1)) {}
    }
    int j;
    File localFile;
    for (;;)
    {
      try
      {
        i = Integer.valueOf(localObject[1]).intValue();
        j = i;
        if (i <= 0) {
          j = 640;
        }
        localObject = new axlq();
        localFile = new File(paramString);
        if (!localFile.exists())
        {
          ((axlq)localObject).jdField_a_of_type_Boolean = false;
          a("[@] getCompressConfig : [!file.exists]");
        }
        paramString = a(paramString);
        if ((paramString != null) && (paramString.length == 5) && (paramString[0] == 0)) {
          break;
        }
        ((axlq)localObject).jdField_a_of_type_Boolean = false;
        a("[@] getCompressConfig : values=" + paramString);
        if (paramString != null) {
          a("[@] getCompressConfig : values.length=" + paramString.length + " err=" + paramString[0]);
        }
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoTrimmer", 2, "getCompressConfig -> get DpcConfig Erro", localNumberFormatException);
        }
      }
      i = 0;
    }
    localNumberFormatException.jdField_a_of_type_JavaLangString = a(paramString[3]);
    localNumberFormatException.jdField_a_of_type_Int = paramString[1];
    localNumberFormatException.jdField_b_of_type_Int = paramString[2];
    int i = (int)(paramString[4] / 1000.0D + 0.5D);
    if (i == 0)
    {
      localNumberFormatException.jdField_a_of_type_Boolean = false;
      a("[@] getCompressConfig : [sec == 0 OR video duration < 0.5 sec]");
      return localNumberFormatException;
    }
    localNumberFormatException.jdField_c_of_type_Long = i;
    localNumberFormatException.jdField_b_of_type_Long = (localFile.length() / (i * 128));
    i = Math.max(paramString[1], paramString[2]);
    if (i <= j + 60)
    {
      if (localNumberFormatException.jdField_b_of_type_Long > 1688L)
      {
        localNumberFormatException.jdField_a_of_type_Boolean = true;
        localNumberFormatException.jdField_e_of_type_Int = 25;
        localNumberFormatException.jdField_c_of_type_Int = paramString[1];
        localNumberFormatException.jdField_d_of_type_Int = paramString[2];
        return localNumberFormatException;
      }
      localNumberFormatException.jdField_a_of_type_Boolean = false;
      a("[@] getCompressConfig : [kbps > CODE_RATE] judge Failure...");
      return localNumberFormatException;
    }
    localNumberFormatException.jdField_a_of_type_Boolean = true;
    float f = j / i;
    localNumberFormatException.jdField_c_of_type_Int = ((int)(paramString[1] * f));
    localNumberFormatException.jdField_d_of_type_Int = ((int)(f * paramString[2]));
    localNumberFormatException.jdField_e_of_type_Int = 25;
    return localNumberFormatException;
  }
  
  public static Process a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Process localProcess = jdField_a_of_type_JavaLangProcess;
      return localProcess;
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0";
    case 0: 
      return "0";
    case 1: 
      return "90";
    case 2: 
      return "180";
    }
    return "270";
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoTrimmer", 2, paramString);
    }
    if (jdField_a_of_type_Boolean) {
      Log.d("ShortVideoTrimmer", paramString);
    }
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    boolean bool2 = b(paramContext, paramInt1, paramInt2);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (VideoEnvironment.a("AVCodec", paramContext) != 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  /* Error */
  private static boolean a(java.io.InputStream paramInputStream, byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 384	java/io/FileOutputStream
    //   6: dup
    //   7: aload_2
    //   8: invokespecial 385	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: iconst_0
    //   14: istore_3
    //   15: aload 7
    //   17: astore_2
    //   18: aload_0
    //   19: aload_1
    //   20: iload_3
    //   21: aload_1
    //   22: arraylength
    //   23: iload_3
    //   24: isub
    //   25: invokevirtual 389	java/io/InputStream:read	([BII)I
    //   28: istore 4
    //   30: iload 4
    //   32: iconst_m1
    //   33: if_icmpeq +39 -> 72
    //   36: iload_3
    //   37: iload 4
    //   39: iadd
    //   40: istore 4
    //   42: iload 4
    //   44: istore_3
    //   45: aload 7
    //   47: astore_2
    //   48: iload 4
    //   50: aload_1
    //   51: arraylength
    //   52: if_icmpne -37 -> 15
    //   55: aload 7
    //   57: astore_2
    //   58: aload 7
    //   60: aload_1
    //   61: iconst_0
    //   62: iload 4
    //   64: invokevirtual 393	java/io/FileOutputStream:write	([BII)V
    //   67: iconst_0
    //   68: istore_3
    //   69: goto -54 -> 15
    //   72: iload_3
    //   73: ifeq +14 -> 87
    //   76: aload 7
    //   78: astore_2
    //   79: aload 7
    //   81: aload_1
    //   82: iconst_0
    //   83: iload_3
    //   84: invokevirtual 393	java/io/FileOutputStream:write	([BII)V
    //   87: iconst_1
    //   88: istore 6
    //   90: iload 6
    //   92: istore 5
    //   94: aload 7
    //   96: ifnull +12 -> 108
    //   99: aload 7
    //   101: invokevirtual 394	java/io/FileOutputStream:close	()V
    //   104: iload 6
    //   106: istore 5
    //   108: iload 5
    //   110: ireturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: astore_2
    //   116: aload_1
    //   117: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   120: aload_0
    //   121: ifnull -13 -> 108
    //   124: aload_0
    //   125: invokevirtual 394	java/io/FileOutputStream:close	()V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_0
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 394	java/io/FileOutputStream:close	()V
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: iconst_1
    //   148: ireturn
    //   149: astore_1
    //   150: goto -6 -> 144
    //   153: astore_0
    //   154: goto -18 -> 136
    //   157: astore_1
    //   158: aload 7
    //   160: astore_0
    //   161: goto -47 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramInputStream	java.io.InputStream
    //   0	164	1	paramArrayOfByte	byte[]
    //   0	164	2	paramString	String
    //   14	70	3	i	int
    //   28	35	4	j	int
    //   1	108	5	bool1	boolean
    //   88	17	6	bool2	boolean
    //   11	148	7	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   3	13	111	java/io/IOException
    //   124	128	130	java/io/IOException
    //   3	13	133	finally
    //   99	104	146	java/io/IOException
    //   140	144	149	java/io/IOException
    //   18	30	153	finally
    //   48	55	153	finally
    //   58	67	153	finally
    //   79	87	153	finally
    //   116	120	153	finally
    //   18	30	157	java/io/IOException
    //   48	55	157	java/io/IOException
    //   58	67	157	java/io/IOException
    //   79	87	157	java/io/IOException
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (!new File(paramString1).exists()) {}
    do
    {
      return true;
      paramString1 = MD5.getFileMd5(paramString1);
      paramString2 = MD5.getFileMd5(paramString2);
      paramString1 = HexUtil.bytes2HexStr(paramString1);
      paramString2 = HexUtil.bytes2HexStr(paramString2);
      a("[@] trimBinMd5Judge : pieMd5=" + paramString1 + "  outMd5=" + paramString2);
    } while ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2)));
    return false;
  }
  
  /* Error */
  @android.annotation.TargetApi(17)
  public static int[] a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 430	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 17
    //   7: if_icmplt +131 -> 138
    //   10: new 432	android/media/MediaMetadataRetriever
    //   13: dup
    //   14: invokespecial 433	android/media/MediaMetadataRetriever:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: invokevirtual 436	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   23: aload_3
    //   24: bipush 18
    //   26: invokevirtual 439	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_3
    //   31: bipush 19
    //   33: invokevirtual 439	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_3
    //   39: bipush 24
    //   41: invokevirtual 439	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   44: astore 5
    //   46: aload_3
    //   47: bipush 9
    //   49: invokevirtual 439	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   52: astore 6
    //   54: iconst_5
    //   55: newarray int
    //   57: astore_0
    //   58: aload_0
    //   59: iconst_0
    //   60: iconst_0
    //   61: iastore
    //   62: aload_0
    //   63: iconst_1
    //   64: aload_2
    //   65: invokestatic 307	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   68: invokevirtual 310	java/lang/Integer:intValue	()I
    //   71: iastore
    //   72: aload_0
    //   73: iconst_2
    //   74: aload 4
    //   76: invokestatic 307	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   79: invokevirtual 310	java/lang/Integer:intValue	()I
    //   82: iastore
    //   83: aload_0
    //   84: iconst_3
    //   85: aload 5
    //   87: invokestatic 307	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   90: invokevirtual 310	java/lang/Integer:intValue	()I
    //   93: iastore
    //   94: aload_0
    //   95: iconst_4
    //   96: aload 6
    //   98: invokestatic 307	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   101: invokevirtual 310	java/lang/Integer:intValue	()I
    //   104: iastore
    //   105: aload_3
    //   106: invokevirtual 442	android/media/MediaMetadataRetriever:release	()V
    //   109: aload_0
    //   110: areturn
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_0
    //   114: ldc_w 331
    //   117: iconst_1
    //   118: ldc_w 444
    //   121: aload_2
    //   122: invokestatic 336	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_3
    //   126: invokevirtual 442	android/media/MediaMetadataRetriever:release	()V
    //   129: aload_0
    //   130: areturn
    //   131: astore_0
    //   132: aload_3
    //   133: invokevirtual 442	android/media/MediaMetadataRetriever:release	()V
    //   136: aload_0
    //   137: athrow
    //   138: aload_0
    //   139: invokestatic 448	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getRealProperties	(Ljava/lang/String;)Ljava/lang/String;
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +79 -> 223
    //   147: aload_0
    //   148: ldc_w 450
    //   151: invokevirtual 302	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   154: astore_3
    //   155: aload_3
    //   156: ifnull +67 -> 223
    //   159: aload_3
    //   160: arraylength
    //   161: ifle +62 -> 223
    //   164: aload_3
    //   165: arraylength
    //   166: newarray int
    //   168: astore_2
    //   169: aload_2
    //   170: astore_0
    //   171: iload_1
    //   172: aload_3
    //   173: arraylength
    //   174: if_icmpge -65 -> 109
    //   177: aload_2
    //   178: iload_1
    //   179: aload_3
    //   180: iload_1
    //   181: aaload
    //   182: invokestatic 307	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   185: invokevirtual 310	java/lang/Integer:intValue	()I
    //   188: iastore
    //   189: iload_1
    //   190: iconst_1
    //   191: iadd
    //   192: istore_1
    //   193: goto -24 -> 169
    //   196: astore_0
    //   197: aload_0
    //   198: invokevirtual 451	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   201: ldc_w 453
    //   204: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   207: aconst_null
    //   208: astore_0
    //   209: goto -66 -> 143
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   217: ldc_w 455
    //   220: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   223: aconst_null
    //   224: areturn
    //   225: astore_2
    //   226: goto -112 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramString	String
    //   1	192	1	i	int
    //   29	36	2	str1	String
    //   111	11	2	localException1	Exception
    //   168	10	2	arrayOfInt	int[]
    //   225	1	2	localException2	Exception
    //   17	163	3	localObject	Object
    //   36	39	4	str2	String
    //   44	42	5	str3	String
    //   52	45	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   18	58	111	java/lang/Exception
    //   18	58	131	finally
    //   62	105	131	finally
    //   114	125	131	finally
    //   138	143	196	java/lang/UnsatisfiedLinkError
    //   171	189	212	java/lang/Exception
    //   62	105	225	java/lang/Exception
  }
  
  private static String[] a(String paramString1, String paramString2, axlq paramaxlq)
  {
    String str1 = "1";
    if (a() >= 2) {
      str1 = "2";
    }
    String str2 = paramaxlq.jdField_c_of_type_Int + "x" + String.valueOf(paramaxlq.jdField_d_of_type_Int);
    a("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramaxlq.jdField_a_of_type_JavaLangString, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(paramaxlq.jdField_e_of_type_Int), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  /* Error */
  @android.annotation.TargetApi(9)
  private static boolean b(Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: invokestatic 77	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore 10
    //   15: new 32	java/io/File
    //   18: dup
    //   19: aload 10
    //   21: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 9
    //   26: aload 9
    //   28: invokevirtual 97	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 9
    //   36: invokevirtual 545	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: iload_1
    //   41: ifeq +7 -> 48
    //   44: iload_2
    //   45: ifne +127 -> 172
    //   48: iconst_0
    //   49: putstatic 83	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   52: getstatic 430	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 16
    //   57: if_icmplt +87 -> 144
    //   60: new 85	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   67: aload 10
    //   69: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 547
    //   75: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 9
    //   83: iconst_0
    //   84: istore_3
    //   85: new 85	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   92: aload 10
    //   94: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 113
    //   99: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore 10
    //   107: new 32	java/io/File
    //   110: dup
    //   111: aload 10
    //   113: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: invokevirtual 97	java/io/File:exists	()Z
    //   119: ifeq +81 -> 200
    //   122: getstatic 83	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   125: ifne +75 -> 200
    //   128: aload 9
    //   130: aload 10
    //   132: invokestatic 549	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   135: ifeq +65 -> 200
    //   138: iconst_1
    //   139: istore 4
    //   141: iload 4
    //   143: ireturn
    //   144: new 85	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   151: aload 10
    //   153: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 551
    //   159: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 9
    //   167: iconst_0
    //   168: istore_3
    //   169: goto -84 -> 85
    //   172: iconst_1
    //   173: putstatic 83	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   176: getstatic 430	android/os/Build$VERSION:SDK_INT	I
    //   179: bipush 16
    //   181: if_icmplt +11 -> 192
    //   184: iload_1
    //   185: istore_3
    //   186: aconst_null
    //   187: astore 9
    //   189: goto -104 -> 85
    //   192: iload_2
    //   193: istore_3
    //   194: aconst_null
    //   195: astore 9
    //   197: goto -112 -> 85
    //   200: iload_1
    //   201: ifeq +7 -> 208
    //   204: iload_2
    //   205: ifne +140 -> 345
    //   208: new 553	java/io/FileInputStream
    //   211: dup
    //   212: aload 9
    //   214: invokespecial 554	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   217: astore_0
    //   218: ldc_w 556
    //   221: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   224: aload_0
    //   225: astore 8
    //   227: aload_0
    //   228: astore 7
    //   230: aload_0
    //   231: sipush 8192
    //   234: newarray byte
    //   236: aload 10
    //   238: invokestatic 558	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/io/InputStream;[BLjava/lang/String;)Z
    //   241: istore 6
    //   243: aload_0
    //   244: astore 8
    //   246: aload_0
    //   247: astore 7
    //   249: new 85	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 560
    //   259: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload 6
    //   264: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   267: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   273: iload 6
    //   275: istore 4
    //   277: iload 6
    //   279: ifeq +55 -> 334
    //   282: aload_0
    //   283: astore 8
    //   285: aload_0
    //   286: astore 7
    //   288: new 32	java/io/File
    //   291: dup
    //   292: aload 10
    //   294: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   297: iconst_1
    //   298: iconst_1
    //   299: invokevirtual 567	java/io/File:setExecutable	(ZZ)Z
    //   302: istore 4
    //   304: aload_0
    //   305: astore 8
    //   307: aload_0
    //   308: astore 7
    //   310: new 85	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 569
    //   320: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iload 4
    //   325: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   328: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   334: aload_0
    //   335: ifnull +7 -> 342
    //   338: aload_0
    //   339: invokevirtual 164	java/io/InputStream:close	()V
    //   342: iload 4
    //   344: ireturn
    //   345: aload_0
    //   346: invokevirtual 575	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   349: iload_3
    //   350: invokevirtual 581	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   353: astore_0
    //   354: aload_0
    //   355: astore 8
    //   357: aload_0
    //   358: astore 7
    //   360: ldc_w 583
    //   363: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   366: goto -142 -> 224
    //   369: astore_0
    //   370: aload 8
    //   372: astore 7
    //   374: aload_0
    //   375: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   378: aload 8
    //   380: astore 7
    //   382: new 85	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   389: ldc_w 585
    //   392: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_0
    //   396: invokevirtual 218	java/lang/Exception:toString	()Ljava/lang/String;
    //   399: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   408: iload 5
    //   410: istore 4
    //   412: aload 8
    //   414: ifnull -273 -> 141
    //   417: aload 8
    //   419: invokevirtual 164	java/io/InputStream:close	()V
    //   422: iconst_0
    //   423: ireturn
    //   424: astore_0
    //   425: aload_0
    //   426: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   429: iconst_0
    //   430: ireturn
    //   431: astore_0
    //   432: aload_0
    //   433: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   436: goto -94 -> 342
    //   439: astore_0
    //   440: aload 7
    //   442: ifnull +8 -> 450
    //   445: aload 7
    //   447: invokevirtual 164	java/io/InputStream:close	()V
    //   450: aload_0
    //   451: athrow
    //   452: astore 7
    //   454: aload 7
    //   456: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   459: goto -9 -> 450
    //   462: astore 8
    //   464: aload_0
    //   465: astore 7
    //   467: aload 8
    //   469: astore_0
    //   470: goto -30 -> 440
    //   473: astore 7
    //   475: aload_0
    //   476: astore 8
    //   478: aload 7
    //   480: astore_0
    //   481: goto -111 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	paramContext	Context
    //   0	484	1	paramInt1	int
    //   0	484	2	paramInt2	int
    //   84	266	3	i	int
    //   139	272	4	bool1	boolean
    //   7	402	5	bool2	boolean
    //   241	37	6	bool3	boolean
    //   1	445	7	localObject1	Object
    //   452	3	7	localIOException	java.io.IOException
    //   465	1	7	localContext1	Context
    //   473	6	7	localException	Exception
    //   4	414	8	localContext2	Context
    //   462	6	8	localObject2	Object
    //   476	1	8	localContext3	Context
    //   24	189	9	localObject3	Object
    //   13	280	10	str	String
    // Exception table:
    //   from	to	target	type
    //   208	218	369	java/lang/Exception
    //   230	243	369	java/lang/Exception
    //   249	273	369	java/lang/Exception
    //   288	304	369	java/lang/Exception
    //   310	334	369	java/lang/Exception
    //   345	354	369	java/lang/Exception
    //   360	366	369	java/lang/Exception
    //   417	422	424	java/io/IOException
    //   338	342	431	java/io/IOException
    //   208	218	439	finally
    //   230	243	439	finally
    //   249	273	439	finally
    //   288	304	439	finally
    //   310	334	439	finally
    //   345	354	439	finally
    //   360	366	439	finally
    //   374	378	439	finally
    //   382	408	439	finally
    //   445	450	452	java/io/IOException
    //   218	224	462	finally
    //   218	224	473	java/lang/Exception
  }
  
  private static String[] b(String paramString1, String paramString2, axlq paramaxlq)
  {
    String str1 = "1";
    if (a() >= 2) {
      str1 = "2";
    }
    String str2 = paramaxlq.jdField_c_of_type_Int + "x" + String.valueOf(paramaxlq.jdField_d_of_type_Int);
    a("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    String str3 = paramaxlq.jdField_e_of_type_Long / 1024L + "k";
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramaxlq.jdField_a_of_type_JavaLangString, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-bufsize", "800k", "-minrate", str3, "-maxrate", str3, "-b", str3, "-r", String.valueOf(paramaxlq.jdField_d_of_type_Long), "-bufsize", "800k", "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  public static native String getRealProperties(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer
 * JD-Core Version:    0.7.0.1
 */