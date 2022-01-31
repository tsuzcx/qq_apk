package com.tencent.mobileqq.shortvideo.util;

import ahpw;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.SharedPreUtils;
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
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new ahpw());
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
    //   3: lstore 7
    //   5: aload_1
    //   6: invokestatic 58	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;
    //   9: astore 9
    //   11: aload 9
    //   13: getfield 62	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:jdField_a_of_type_Boolean	Z
    //   16: ifne +10 -> 26
    //   19: ldc 64
    //   21: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_1
    //   27: aload_2
    //   28: aload 9
    //   30: invokestatic 69	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;)[Ljava/lang/String;
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
    //   114: astore 13
    //   116: aload 13
    //   118: iconst_1
    //   119: invokevirtual 108	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   122: pop
    //   123: new 110	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 111	java/util/ArrayList:<init>	()V
    //   130: astore 11
    //   132: aload 11
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
    //   172: aload 11
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
    //   204: aload 11
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
    //   222: aload 11
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
    //   249: aload 13
    //   251: aload 11
    //   253: invokevirtual 129	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   256: pop
    //   257: new 85	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   264: ldc 131
    //   266: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 11
    //   271: aload 11
    //   273: invokeinterface 134 1 0
    //   278: iconst_1
    //   279: isub
    //   280: invokeinterface 125 2 0
    //   285: checkcast 101	java/lang/String
    //   288: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   297: aload 13
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
    //   486: lstore 5
    //   488: new 85	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   495: ldc 172
    //   497: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: lload 5
    //   502: lload 7
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
    //   486	15	5	l1	long
    //   3	500	7	l2	long
    //   9	1095	9	localObject1	Object
    //   1109	19	9	localObject2	Object
    //   101	1025	10	localObject3	Object
    //   130	994	11	localObject4	Object
    //   50	1157	12	localObject5	Object
    //   114	217	13	localObject6	Object
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
  public static int a(Context paramContext, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   3: lstore 8
    //   5: aload_1
    //   6: aload_3
    //   7: invokestatic 222	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;
    //   10: astore_3
    //   11: aload_3
    //   12: getfield 62	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:jdField_a_of_type_Boolean	Z
    //   15: ifne +10 -> 25
    //   18: ldc 64
    //   20: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   23: iconst_m1
    //   24: ireturn
    //   25: aload_1
    //   26: aload_2
    //   27: aload_3
    //   28: invokestatic 225	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:b	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;)[Ljava/lang/String;
    //   31: astore_1
    //   32: aload_1
    //   33: ifnonnull +11 -> 44
    //   36: ldc 71
    //   38: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   41: bipush 254
    //   43: ireturn
    //   44: aload_0
    //   45: invokestatic 77	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   48: astore 11
    //   50: invokestatic 82	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Ljava/lang/String;
    //   53: astore_0
    //   54: getstatic 83	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   57: ifne +38 -> 95
    //   60: new 32	java/io/File
    //   63: dup
    //   64: new 85	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   71: aload 11
    //   73: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_0
    //   77: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 97	java/io/File:exists	()Z
    //   89: ifne +6 -> 95
    //   92: bipush 253
    //   94: ireturn
    //   95: aconst_null
    //   96: astore_3
    //   97: aconst_null
    //   98: astore 10
    //   100: new 99	java/lang/ProcessBuilder
    //   103: dup
    //   104: iconst_0
    //   105: anewarray 101	java/lang/String
    //   108: invokespecial 104	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   111: astore 12
    //   113: aload 12
    //   115: iconst_1
    //   116: invokevirtual 108	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   119: pop
    //   120: new 110	java/util/ArrayList
    //   123: dup
    //   124: invokespecial 111	java/util/ArrayList:<init>	()V
    //   127: astore 13
    //   129: aload 13
    //   131: new 85	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   138: aload 11
    //   140: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc 113
    //   145: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokeinterface 119 2 0
    //   156: pop
    //   157: new 85	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   164: ldc 121
    //   166: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 13
    //   171: iconst_0
    //   172: invokeinterface 125 2 0
    //   177: checkcast 101	java/lang/String
    //   180: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   189: aload_1
    //   190: arraylength
    //   191: istore 5
    //   193: iconst_0
    //   194: istore 4
    //   196: iload 4
    //   198: iload 5
    //   200: if_icmpge +24 -> 224
    //   203: aload 13
    //   205: aload_1
    //   206: iload 4
    //   208: aaload
    //   209: invokeinterface 119 2 0
    //   214: pop
    //   215: iload 4
    //   217: iconst_1
    //   218: iadd
    //   219: istore 4
    //   221: goto -25 -> 196
    //   224: aload 13
    //   226: new 85	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   233: aload 11
    //   235: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_0
    //   239: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokeinterface 119 2 0
    //   250: pop
    //   251: aload 12
    //   253: aload 13
    //   255: invokevirtual 129	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   258: pop
    //   259: new 85	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   266: ldc 131
    //   268: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 13
    //   273: aload 13
    //   275: invokeinterface 134 1 0
    //   280: iconst_1
    //   281: isub
    //   282: invokeinterface 125 2 0
    //   287: checkcast 101	java/lang/String
    //   290: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   299: aload 12
    //   301: invokevirtual 138	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   304: astore 13
    //   306: getstatic 17	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   309: astore_0
    //   310: aload_0
    //   311: monitorenter
    //   312: aload 13
    //   314: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   317: aload_0
    //   318: monitorexit
    //   319: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   322: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   325: ifne +260 -> 585
    //   328: aconst_null
    //   329: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   332: aload 13
    //   334: invokevirtual 147	java/lang/Process:destroy	()V
    //   337: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   340: iconst_1
    //   341: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   344: iconst_0
    //   345: ifeq +11 -> 356
    //   348: new 152	java/lang/NullPointerException
    //   351: dup
    //   352: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   355: athrow
    //   356: iconst_0
    //   357: ifeq +11 -> 368
    //   360: new 152	java/lang/NullPointerException
    //   363: dup
    //   364: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   367: athrow
    //   368: iconst_0
    //   369: ifeq -346 -> 23
    //   372: new 152	java/lang/NullPointerException
    //   375: dup
    //   376: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   379: athrow
    //   380: astore_0
    //   381: iconst_m1
    //   382: ireturn
    //   383: astore_1
    //   384: aload_0
    //   385: monitorexit
    //   386: aload_1
    //   387: athrow
    //   388: astore 13
    //   390: aconst_null
    //   391: astore_0
    //   392: aconst_null
    //   393: astore_1
    //   394: aconst_null
    //   395: astore 12
    //   397: sipush -1001
    //   400: istore 5
    //   402: aload 12
    //   404: astore 11
    //   406: aload_1
    //   407: astore 10
    //   409: aload_0
    //   410: astore_3
    //   411: aload 13
    //   413: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   416: aload 12
    //   418: astore 11
    //   420: aload_1
    //   421: astore 10
    //   423: aload_0
    //   424: astore_3
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
    //   467: iload 5
    //   469: istore 4
    //   471: aload 12
    //   473: ifnull +12 -> 485
    //   476: aload 12
    //   478: invokevirtual 170	java/io/BufferedReader:close	()V
    //   481: iload 5
    //   483: istore 4
    //   485: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   488: lstore 6
    //   490: new 85	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   497: ldc 172
    //   499: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: lload 6
    //   504: lload 8
    //   506: lsub
    //   507: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: ldc 177
    //   512: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: iload 4
    //   517: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   520: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   526: iload 4
    //   528: ifeq +47 -> 575
    //   531: new 32	java/io/File
    //   534: dup
    //   535: aload_2
    //   536: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   539: astore_0
    //   540: aload_0
    //   541: invokevirtual 97	java/io/File:exists	()Z
    //   544: ifeq +31 -> 575
    //   547: aload_0
    //   548: invokevirtual 183	java/io/File:delete	()Z
    //   551: pop
    //   552: new 85	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   559: ldc 185
    //   561: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: iload 4
    //   566: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   569: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   575: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   578: iconst_1
    //   579: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   582: iload 4
    //   584: ireturn
    //   585: aload 13
    //   587: invokevirtual 189	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   590: astore_0
    //   591: new 166	java/io/InputStreamReader
    //   594: dup
    //   595: aload_0
    //   596: invokespecial 192	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   599: astore_1
    //   600: new 169	java/io/BufferedReader
    //   603: dup
    //   604: aload_1
    //   605: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   608: astore 12
    //   610: aload 12
    //   612: astore 11
    //   614: aload_1
    //   615: astore 10
    //   617: aload_0
    //   618: astore_3
    //   619: aload 13
    //   621: invokevirtual 198	java/lang/Process:waitFor	()I
    //   624: pop
    //   625: aload 12
    //   627: astore 11
    //   629: aload_1
    //   630: astore 10
    //   632: aload_0
    //   633: astore_3
    //   634: aload 13
    //   636: invokevirtual 201	java/lang/Process:exitValue	()I
    //   639: istore 5
    //   641: aload 12
    //   643: astore 11
    //   645: aload_1
    //   646: astore 10
    //   648: aload_0
    //   649: astore_3
    //   650: new 85	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   657: ldc 203
    //   659: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: iload 5
    //   664: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   667: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   673: aload 12
    //   675: astore 11
    //   677: aload_1
    //   678: astore 10
    //   680: aload_0
    //   681: astore_3
    //   682: aload 12
    //   684: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   687: astore 14
    //   689: aload 14
    //   691: ifnull +38 -> 729
    //   694: aload 12
    //   696: astore 11
    //   698: aload_1
    //   699: astore 10
    //   701: aload_0
    //   702: astore_3
    //   703: new 85	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   710: ldc 208
    //   712: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload 14
    //   717: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   723: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   726: goto -53 -> 673
    //   729: aload 12
    //   731: astore 11
    //   733: aload_1
    //   734: astore 10
    //   736: aload_0
    //   737: astore_3
    //   738: aload 13
    //   740: invokevirtual 147	java/lang/Process:destroy	()V
    //   743: aload 12
    //   745: astore 11
    //   747: aload_1
    //   748: astore 10
    //   750: aload_0
    //   751: astore_3
    //   752: getstatic 17	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   755: astore 14
    //   757: aload 12
    //   759: astore 11
    //   761: aload_1
    //   762: astore 10
    //   764: aload_0
    //   765: astore_3
    //   766: aload 14
    //   768: monitorenter
    //   769: aconst_null
    //   770: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   773: aload 14
    //   775: monitorexit
    //   776: aload 12
    //   778: astore 11
    //   780: aload_1
    //   781: astore 10
    //   783: aload_0
    //   784: astore_3
    //   785: ldc 210
    //   787: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   790: aload_0
    //   791: ifnull +7 -> 798
    //   794: aload_0
    //   795: invokevirtual 164	java/io/InputStream:close	()V
    //   798: aload_1
    //   799: ifnull +7 -> 806
    //   802: aload_1
    //   803: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   806: iload 5
    //   808: istore 4
    //   810: aload 12
    //   812: ifnull -327 -> 485
    //   815: aload 12
    //   817: invokevirtual 170	java/io/BufferedReader:close	()V
    //   820: iload 5
    //   822: istore 4
    //   824: goto -339 -> 485
    //   827: astore_0
    //   828: iload 5
    //   830: istore 4
    //   832: goto -347 -> 485
    //   835: astore 13
    //   837: aload 14
    //   839: monitorexit
    //   840: aload 12
    //   842: astore 11
    //   844: aload_1
    //   845: astore 10
    //   847: aload_0
    //   848: astore_3
    //   849: aload 13
    //   851: athrow
    //   852: astore 13
    //   854: sipush -1002
    //   857: istore 5
    //   859: aload 12
    //   861: astore 11
    //   863: aload_1
    //   864: astore 10
    //   866: aload_0
    //   867: astore_3
    //   868: aload 13
    //   870: invokevirtual 211	java/lang/InterruptedException:printStackTrace	()V
    //   873: aload 12
    //   875: astore 11
    //   877: aload_1
    //   878: astore 10
    //   880: aload_0
    //   881: astore_3
    //   882: new 85	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   889: ldc 213
    //   891: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: aload 13
    //   896: invokevirtual 214	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   899: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   908: aload_0
    //   909: ifnull +7 -> 916
    //   912: aload_0
    //   913: invokevirtual 164	java/io/InputStream:close	()V
    //   916: aload_1
    //   917: ifnull +7 -> 924
    //   920: aload_1
    //   921: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   924: iload 5
    //   926: istore 4
    //   928: aload 12
    //   930: ifnull -445 -> 485
    //   933: aload 12
    //   935: invokevirtual 170	java/io/BufferedReader:close	()V
    //   938: iload 5
    //   940: istore 4
    //   942: goto -457 -> 485
    //   945: astore_0
    //   946: iload 5
    //   948: istore 4
    //   950: goto -465 -> 485
    //   953: astore 13
    //   955: aconst_null
    //   956: astore_0
    //   957: aconst_null
    //   958: astore_1
    //   959: aconst_null
    //   960: astore 12
    //   962: sipush -1003
    //   965: istore 5
    //   967: aload 12
    //   969: astore 11
    //   971: aload_1
    //   972: astore 10
    //   974: aload_0
    //   975: astore_3
    //   976: aload 13
    //   978: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   981: aload 12
    //   983: astore 11
    //   985: aload_1
    //   986: astore 10
    //   988: aload_0
    //   989: astore_3
    //   990: new 85	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   997: ldc 217
    //   999: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: aload 13
    //   1004: invokevirtual 218	java/lang/Exception:toString	()Ljava/lang/String;
    //   1007: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   1016: aload_0
    //   1017: ifnull +7 -> 1024
    //   1020: aload_0
    //   1021: invokevirtual 164	java/io/InputStream:close	()V
    //   1024: aload_1
    //   1025: ifnull +7 -> 1032
    //   1028: aload_1
    //   1029: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1032: iload 5
    //   1034: istore 4
    //   1036: aload 12
    //   1038: ifnull -553 -> 485
    //   1041: aload 12
    //   1043: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1046: iload 5
    //   1048: istore 4
    //   1050: goto -565 -> 485
    //   1053: astore_0
    //   1054: iload 5
    //   1056: istore 4
    //   1058: goto -573 -> 485
    //   1061: astore_1
    //   1062: aconst_null
    //   1063: astore_0
    //   1064: aload_3
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
    //   1095: goto -520 -> 575
    //   1098: astore_0
    //   1099: goto -7 -> 1092
    //   1102: astore_1
    //   1103: aload_3
    //   1104: astore_2
    //   1105: goto -39 -> 1066
    //   1108: astore_3
    //   1109: aload_1
    //   1110: astore_2
    //   1111: aload_3
    //   1112: astore_1
    //   1113: goto -47 -> 1066
    //   1116: astore_1
    //   1117: aload 10
    //   1119: astore_2
    //   1120: aload 11
    //   1122: astore 10
    //   1124: aload_3
    //   1125: astore_0
    //   1126: goto -60 -> 1066
    //   1129: astore 13
    //   1131: aconst_null
    //   1132: astore_1
    //   1133: aconst_null
    //   1134: astore 12
    //   1136: goto -174 -> 962
    //   1139: astore 13
    //   1141: aconst_null
    //   1142: astore 12
    //   1144: goto -182 -> 962
    //   1147: astore 13
    //   1149: goto -187 -> 962
    //   1152: astore 13
    //   1154: aconst_null
    //   1155: astore_0
    //   1156: aconst_null
    //   1157: astore_1
    //   1158: aconst_null
    //   1159: astore 12
    //   1161: goto -307 -> 854
    //   1164: astore 13
    //   1166: aconst_null
    //   1167: astore_1
    //   1168: aconst_null
    //   1169: astore 12
    //   1171: goto -317 -> 854
    //   1174: astore 13
    //   1176: aconst_null
    //   1177: astore 12
    //   1179: goto -325 -> 854
    //   1182: astore_0
    //   1183: iload 5
    //   1185: istore 4
    //   1187: goto -702 -> 485
    //   1190: astore 13
    //   1192: aconst_null
    //   1193: astore_1
    //   1194: aconst_null
    //   1195: astore 12
    //   1197: goto -800 -> 397
    //   1200: astore 13
    //   1202: aconst_null
    //   1203: astore 12
    //   1205: goto -808 -> 397
    //   1208: astore 13
    //   1210: goto -813 -> 397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1213	0	paramContext	Context
    //   0	1213	1	paramString1	String
    //   0	1213	2	paramString2	String
    //   0	1213	3	paramQQAppInterface	QQAppInterface
    //   194	992	4	i	int
    //   191	993	5	j	int
    //   488	15	6	l1	long
    //   3	502	8	l2	long
    //   98	1025	10	localObject1	Object
    //   48	1073	11	localObject2	Object
    //   111	1093	12	localObject3	Object
    //   127	206	13	localObject4	Object
    //   388	351	13	localIOException1	java.io.IOException
    //   835	15	13	localObject5	Object
    //   852	43	13	localInterruptedException1	java.lang.InterruptedException
    //   953	50	13	localException1	Exception
    //   1129	1	13	localException2	Exception
    //   1139	1	13	localException3	Exception
    //   1147	1	13	localException4	Exception
    //   1152	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1164	1	13	localInterruptedException3	java.lang.InterruptedException
    //   1174	1	13	localInterruptedException4	java.lang.InterruptedException
    //   1190	1	13	localIOException2	java.io.IOException
    //   1200	1	13	localIOException3	java.io.IOException
    //   1208	1	13	localIOException4	java.io.IOException
    //   687	151	14	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   348	356	380	java/io/IOException
    //   360	368	380	java/io/IOException
    //   372	380	380	java/io/IOException
    //   312	319	383	finally
    //   384	386	383	finally
    //   100	193	388	java/io/IOException
    //   203	215	388	java/io/IOException
    //   224	312	388	java/io/IOException
    //   319	344	388	java/io/IOException
    //   386	388	388	java/io/IOException
    //   585	591	388	java/io/IOException
    //   794	798	827	java/io/IOException
    //   802	806	827	java/io/IOException
    //   815	820	827	java/io/IOException
    //   769	776	835	finally
    //   837	840	835	finally
    //   619	625	852	java/lang/InterruptedException
    //   634	641	852	java/lang/InterruptedException
    //   650	673	852	java/lang/InterruptedException
    //   682	689	852	java/lang/InterruptedException
    //   703	726	852	java/lang/InterruptedException
    //   738	743	852	java/lang/InterruptedException
    //   752	757	852	java/lang/InterruptedException
    //   766	769	852	java/lang/InterruptedException
    //   785	790	852	java/lang/InterruptedException
    //   849	852	852	java/lang/InterruptedException
    //   912	916	945	java/io/IOException
    //   920	924	945	java/io/IOException
    //   933	938	945	java/io/IOException
    //   100	193	953	java/lang/Exception
    //   203	215	953	java/lang/Exception
    //   224	312	953	java/lang/Exception
    //   319	344	953	java/lang/Exception
    //   386	388	953	java/lang/Exception
    //   585	591	953	java/lang/Exception
    //   1020	1024	1053	java/io/IOException
    //   1028	1032	1053	java/io/IOException
    //   1041	1046	1053	java/io/IOException
    //   100	193	1061	finally
    //   203	215	1061	finally
    //   224	312	1061	finally
    //   319	344	1061	finally
    //   386	388	1061	finally
    //   585	591	1061	finally
    //   531	575	1094	java/lang/Exception
    //   1070	1074	1098	java/io/IOException
    //   1078	1082	1098	java/io/IOException
    //   1087	1092	1098	java/io/IOException
    //   591	600	1102	finally
    //   600	610	1108	finally
    //   411	416	1116	finally
    //   425	451	1116	finally
    //   619	625	1116	finally
    //   634	641	1116	finally
    //   650	673	1116	finally
    //   682	689	1116	finally
    //   703	726	1116	finally
    //   738	743	1116	finally
    //   752	757	1116	finally
    //   766	769	1116	finally
    //   785	790	1116	finally
    //   849	852	1116	finally
    //   868	873	1116	finally
    //   882	908	1116	finally
    //   976	981	1116	finally
    //   990	1016	1116	finally
    //   591	600	1129	java/lang/Exception
    //   600	610	1139	java/lang/Exception
    //   619	625	1147	java/lang/Exception
    //   634	641	1147	java/lang/Exception
    //   650	673	1147	java/lang/Exception
    //   682	689	1147	java/lang/Exception
    //   703	726	1147	java/lang/Exception
    //   738	743	1147	java/lang/Exception
    //   752	757	1147	java/lang/Exception
    //   766	769	1147	java/lang/Exception
    //   785	790	1147	java/lang/Exception
    //   849	852	1147	java/lang/Exception
    //   100	193	1152	java/lang/InterruptedException
    //   203	215	1152	java/lang/InterruptedException
    //   224	312	1152	java/lang/InterruptedException
    //   319	344	1152	java/lang/InterruptedException
    //   386	388	1152	java/lang/InterruptedException
    //   585	591	1152	java/lang/InterruptedException
    //   591	600	1164	java/lang/InterruptedException
    //   600	610	1174	java/lang/InterruptedException
    //   455	459	1182	java/io/IOException
    //   463	467	1182	java/io/IOException
    //   476	481	1182	java/io/IOException
    //   591	600	1190	java/io/IOException
    //   600	610	1200	java/io/IOException
    //   619	625	1208	java/io/IOException
    //   634	641	1208	java/io/IOException
    //   650	673	1208	java/io/IOException
    //   682	689	1208	java/io/IOException
    //   703	726	1208	java/io/IOException
    //   738	743	1208	java/io/IOException
    //   752	757	1208	java/io/IOException
    //   766	769	1208	java/io/IOException
    //   785	790	1208	java/io/IOException
    //   849	852	1208	java/io/IOException
  }
  
  public static ShortVideoTrimmer.CompressConfig a(String paramString)
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
        localObject = new ShortVideoTrimmer.CompressConfig();
        localFile = new File(paramString);
        if (!localFile.exists())
        {
          ((ShortVideoTrimmer.CompressConfig)localObject).jdField_a_of_type_Boolean = false;
          a("[@] getCompressConfig : [!file.exists]");
        }
        paramString = a(paramString);
        if ((paramString != null) && (paramString.length == 5) && (paramString[0] == 0)) {
          break;
        }
        ((ShortVideoTrimmer.CompressConfig)localObject).jdField_a_of_type_Boolean = false;
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
  
  public static ShortVideoTrimmer.CompressConfig a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int i = 960;
    int j = 30;
    double d2 = 0.27D;
    double d3 = 0.067D;
    long l2 = 209715200L;
    long l1 = l2;
    double d1 = d3;
    double d6 = d2;
    int k = j;
    int m = i;
    double d4;
    double d5;
    int n;
    int i1;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = SharedPreUtils.r(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      l1 = l2;
      d1 = d3;
      d6 = d2;
      k = j;
      m = i;
      if (paramQQAppInterface != null)
      {
        l1 = l2;
        d1 = d3;
        d6 = d2;
        k = j;
        m = i;
        if (paramQQAppInterface.length() > 0)
        {
          a("[@] getCompressConfigNew : compressConfig = \" + compressConfig");
          paramQQAppInterface = paramQQAppInterface.split("\\|");
          l1 = l2;
          d1 = d3;
          d6 = d2;
          k = j;
          m = i;
          if (paramQQAppInterface != null)
          {
            l1 = l2;
            d1 = d3;
            d6 = d2;
            k = j;
            m = i;
            if (paramQQAppInterface.length >= 5)
            {
              d4 = d3;
              d5 = d2;
              n = j;
              i1 = i;
            }
          }
        }
      }
    }
    try
    {
      k = Integer.valueOf(paramQQAppInterface[0]).intValue();
      if (k > 0) {
        i = k;
      }
      d4 = d3;
      d5 = d2;
      n = j;
      i1 = i;
      k = Integer.valueOf(paramQQAppInterface[1]).intValue();
      if (k > 0) {
        j = k;
      }
      d4 = d3;
      d5 = d2;
      n = j;
      i1 = i;
      d1 = Double.valueOf(paramQQAppInterface[2]).doubleValue();
      if (d1 > 0.0D) {
        d2 = d1;
      }
      d4 = d3;
      d5 = d2;
      n = j;
      i1 = i;
      d1 = Double.valueOf(paramQQAppInterface[3]).doubleValue();
      if (d1 > 0.0D) {
        d3 = d1;
      }
      d4 = d3;
      d5 = d2;
      n = j;
      i1 = i;
      int i2 = Integer.valueOf(paramQQAppInterface[4]).intValue();
      l1 = l2;
      d1 = d3;
      d6 = d2;
      k = j;
      m = i;
      if (i2 > 0)
      {
        l1 = i2 * 1024 * 1024 * 8;
        m = i;
        k = j;
        d6 = d2;
        d1 = d3;
      }
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      File localFile;
      for (;;)
      {
        l1 = l2;
        d1 = d4;
        d6 = d5;
        k = n;
        m = i1;
        if (QLog.isColorLevel())
        {
          QLog.e("ShortVideoTrimmer", 2, "getCompressConfigNew -> get VideoCompressConfig Erro", paramQQAppInterface);
          l1 = l2;
          d1 = d4;
          d6 = d5;
          k = n;
          m = i1;
        }
      }
      paramQQAppInterface.jdField_a_of_type_JavaLangString = a(paramString[3]);
      paramQQAppInterface.jdField_a_of_type_Int = paramString[1];
      paramQQAppInterface.jdField_b_of_type_Int = paramString[2];
      i = (int)(paramString[4] / 1000.0D + 0.5D);
      if (i != 0) {
        break label704;
      }
      paramQQAppInterface.jdField_a_of_type_Boolean = false;
      a("[@] getCompressConfig : [sec == 0 OR video duration < 0.5 sec]");
      return paramQQAppInterface;
      paramQQAppInterface.jdField_c_of_type_Long = i;
      j = Math.max(paramString[1], paramString[2]);
      float f2 = m / j;
      f1 = f2;
      if (f2 <= 1.0F) {
        break label745;
      }
      f1 = 1.0F;
      paramQQAppInterface.jdField_c_of_type_Int = ((int)(paramString[1] * f1));
      paramQQAppInterface.jdField_d_of_type_Int = ((int)(paramString[2] * f1));
      paramQQAppInterface.jdField_e_of_type_Int = 25;
      a("[@] getCompressConfigNew : scaleRate = " + f1 + ", config.destWidth = " + paramQQAppInterface.jdField_c_of_type_Int + ", config.destHeight = " + paramQQAppInterface.jdField_d_of_type_Int);
      paramQQAppInterface.jdField_d_of_type_Long = k;
      a("[@] getCompressConfigNew : config.desFrameRate = " + paramQQAppInterface.jdField_d_of_type_Long + ", config.srcFrameRate = " + paramQQAppInterface.jdField_a_of_type_Long);
      paramQQAppInterface.jdField_b_of_type_Long = (localFile.length() / (i * 128));
      d3 = d6 * (paramQQAppInterface.jdField_c_of_type_Int * paramQQAppInterface.jdField_d_of_type_Int * paramQQAppInterface.jdField_d_of_type_Long);
      a("[@] getCompressConfigNew : dpsExp = " + d3 + ", config.srcBitrate = " + paramQQAppInterface.jdField_b_of_type_Long);
      d2 = d3;
      if (d3 <= paramQQAppInterface.jdField_b_of_type_Long * 1024L) {
        break label976;
      }
      d2 = paramQQAppInterface.jdField_b_of_type_Long * 1024L;
      if (paramQQAppInterface.jdField_c_of_type_Long * d2 <= l1) {
        break label1117;
      }
    }
    a("[@] getCompressConfigNew : getEncodeConfig, maxLength = " + m + ", maxFPS = " + k + ", density = " + d6 + ", minDensity = " + d1 + ", maxSize = " + l1);
    paramQQAppInterface = new ShortVideoTrimmer.CompressConfig();
    localFile = new File(paramString);
    if (!localFile.exists())
    {
      paramQQAppInterface.jdField_a_of_type_Boolean = false;
      a("[@] getCompressConfigNew : [!file.exists]");
    }
    paramString = a(paramString);
    if ((paramString == null) || (paramString.length != 5) || (paramString[0] != 0))
    {
      paramQQAppInterface.jdField_a_of_type_Boolean = false;
      a("[@] getCompressConfig : values=" + paramString);
      if (paramString != null) {
        a("[@] getCompressConfig : values.length=" + paramString.length + " err=" + paramString[0]);
      }
      return paramQQAppInterface;
    }
    label704:
    float f1;
    label745:
    d2 = (float)l1 / (paramQQAppInterface.jdField_a_of_type_Int * paramQQAppInterface.jdField_b_of_type_Int * f1 * f1 * (float)paramQQAppInterface.jdField_d_of_type_Long * (float)paramQQAppInterface.jdField_c_of_type_Long);
    label976:
    if (d2 < d1) {}
    for (;;)
    {
      a("[@] getCompressConfigNew : densityExp = " + d1);
      label1117:
      for (paramQQAppInterface.jdField_e_of_type_Long = ((int)(paramQQAppInterface.jdField_a_of_type_Int * paramQQAppInterface.jdField_b_of_type_Int * f1 * f1 * (float)paramQQAppInterface.jdField_d_of_type_Long * d1)); (f1 == 1.0F) && (paramQQAppInterface.jdField_b_of_type_Long * 1024L == paramQQAppInterface.jdField_e_of_type_Long); paramQQAppInterface.jdField_e_of_type_Long = ((int)d2))
      {
        paramQQAppInterface.jdField_a_of_type_Boolean = false;
        return paramQQAppInterface;
      }
      paramQQAppInterface.jdField_a_of_type_Boolean = true;
      return paramQQAppInterface;
      d1 = d2;
    }
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
    //   3: new 435	java/io/FileOutputStream
    //   6: dup
    //   7: aload_2
    //   8: invokespecial 436	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
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
    //   25: invokevirtual 440	java/io/InputStream:read	([BII)I
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
    //   64: invokevirtual 444	java/io/FileOutputStream:write	([BII)V
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
    //   84: invokevirtual 444	java/io/FileOutputStream:write	([BII)V
    //   87: iconst_1
    //   88: istore 6
    //   90: iload 6
    //   92: istore 5
    //   94: aload 7
    //   96: ifnull +12 -> 108
    //   99: aload 7
    //   101: invokevirtual 445	java/io/FileOutputStream:close	()V
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
    //   125: invokevirtual 445	java/io/FileOutputStream:close	()V
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
    //   141: invokevirtual 445	java/io/FileOutputStream:close	()V
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
    //   2: getstatic 481	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 17
    //   7: if_icmplt +131 -> 138
    //   10: new 483	android/media/MediaMetadataRetriever
    //   13: dup
    //   14: invokespecial 484	android/media/MediaMetadataRetriever:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: invokevirtual 487	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   23: aload_3
    //   24: bipush 18
    //   26: invokevirtual 490	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_3
    //   31: bipush 19
    //   33: invokevirtual 490	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_3
    //   39: bipush 24
    //   41: invokevirtual 490	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   44: astore 5
    //   46: aload_3
    //   47: bipush 9
    //   49: invokevirtual 490	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
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
    //   65: invokestatic 261	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   68: invokevirtual 264	java/lang/Integer:intValue	()I
    //   71: iastore
    //   72: aload_0
    //   73: iconst_2
    //   74: aload 4
    //   76: invokestatic 261	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   79: invokevirtual 264	java/lang/Integer:intValue	()I
    //   82: iastore
    //   83: aload_0
    //   84: iconst_3
    //   85: aload 5
    //   87: invokestatic 261	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   90: invokevirtual 264	java/lang/Integer:intValue	()I
    //   93: iastore
    //   94: aload_0
    //   95: iconst_4
    //   96: aload 6
    //   98: invokestatic 261	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   101: invokevirtual 264	java/lang/Integer:intValue	()I
    //   104: iastore
    //   105: aload_3
    //   106: invokevirtual 493	android/media/MediaMetadataRetriever:release	()V
    //   109: aload_0
    //   110: areturn
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_0
    //   114: ldc_w 286
    //   117: iconst_1
    //   118: ldc_w 495
    //   121: aload_2
    //   122: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_3
    //   126: invokevirtual 493	android/media/MediaMetadataRetriever:release	()V
    //   129: aload_0
    //   130: areturn
    //   131: astore_0
    //   132: aload_3
    //   133: invokevirtual 493	android/media/MediaMetadataRetriever:release	()V
    //   136: aload_0
    //   137: athrow
    //   138: aload_0
    //   139: invokestatic 499	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getRealProperties	(Ljava/lang/String;)Ljava/lang/String;
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +79 -> 223
    //   147: aload_0
    //   148: ldc_w 501
    //   151: invokevirtual 255	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   182: invokestatic 261	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   185: invokevirtual 264	java/lang/Integer:intValue	()I
    //   188: iastore
    //   189: iload_1
    //   190: iconst_1
    //   191: iadd
    //   192: istore_1
    //   193: goto -24 -> 169
    //   196: astore_0
    //   197: aload_0
    //   198: invokevirtual 502	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   201: ldc_w 504
    //   204: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   207: aconst_null
    //   208: astore_0
    //   209: goto -66 -> 143
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   217: ldc_w 506
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
  
  private static String[] a(String paramString1, String paramString2, ShortVideoTrimmer.CompressConfig paramCompressConfig)
  {
    String str1 = "1";
    if (a() >= 2) {
      str1 = "2";
    }
    String str2 = paramCompressConfig.jdField_c_of_type_Int + "x" + String.valueOf(paramCompressConfig.jdField_d_of_type_Int);
    a("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramCompressConfig.jdField_a_of_type_JavaLangString, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(paramCompressConfig.jdField_e_of_type_Int), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
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
    //   36: invokevirtual 598	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: iload_1
    //   41: ifeq +7 -> 48
    //   44: iload_2
    //   45: ifne +127 -> 172
    //   48: iconst_0
    //   49: putstatic 83	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   52: getstatic 481	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 16
    //   57: if_icmplt +87 -> 144
    //   60: new 85	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   67: aload 10
    //   69: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 600
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
    //   132: invokestatic 602	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Ljava/lang/String;)Z
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
    //   156: ldc_w 604
    //   159: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 9
    //   167: iconst_0
    //   168: istore_3
    //   169: goto -84 -> 85
    //   172: iconst_1
    //   173: putstatic 83	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   176: getstatic 481	android/os/Build$VERSION:SDK_INT	I
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
    //   208: new 606	java/io/FileInputStream
    //   211: dup
    //   212: aload 9
    //   214: invokespecial 607	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   217: astore_0
    //   218: ldc_w 609
    //   221: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   224: aload_0
    //   225: astore 8
    //   227: aload_0
    //   228: astore 7
    //   230: aload_0
    //   231: sipush 8192
    //   234: newarray byte
    //   236: aload 10
    //   238: invokestatic 611	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/io/InputStream;[BLjava/lang/String;)Z
    //   241: istore 6
    //   243: aload_0
    //   244: astore 8
    //   246: aload_0
    //   247: astore 7
    //   249: new 85	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 613
    //   259: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload 6
    //   264: invokevirtual 616	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
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
    //   299: invokevirtual 620	java/io/File:setExecutable	(ZZ)Z
    //   302: istore 4
    //   304: aload_0
    //   305: astore 8
    //   307: aload_0
    //   308: astore 7
    //   310: new 85	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 622
    //   320: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iload 4
    //   325: invokevirtual 616	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   328: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   334: aload_0
    //   335: ifnull +7 -> 342
    //   338: aload_0
    //   339: invokevirtual 164	java/io/InputStream:close	()V
    //   342: iload 4
    //   344: ireturn
    //   345: aload_0
    //   346: invokevirtual 628	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   349: iload_3
    //   350: invokevirtual 634	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   353: astore_0
    //   354: aload_0
    //   355: astore 8
    //   357: aload_0
    //   358: astore 7
    //   360: ldc_w 636
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
    //   389: ldc_w 638
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
  
  private static String[] b(String paramString1, String paramString2, ShortVideoTrimmer.CompressConfig paramCompressConfig)
  {
    String str1 = "1";
    if (a() >= 2) {
      str1 = "2";
    }
    String str2 = paramCompressConfig.jdField_c_of_type_Int + "x" + String.valueOf(paramCompressConfig.jdField_d_of_type_Int);
    a("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    String str3 = paramCompressConfig.jdField_e_of_type_Long / 1024L + "k";
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramCompressConfig.jdField_a_of_type_JavaLangString, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-bufsize", "800k", "-minrate", str3, "-maxrate", str3, "-b", str3, "-r", String.valueOf(paramCompressConfig.jdField_d_of_type_Long), "-bufsize", "800k", "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  public static native String getRealProperties(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer
 * JD-Core Version:    0.7.0.1
 */