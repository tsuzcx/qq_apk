package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import axln;
import axlo;
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
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new axln());
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
    //   6: invokestatic 58	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)Laxlo;
    //   9: astore 9
    //   11: aload 9
    //   13: getfield 62	axlo:jdField_a_of_type_Boolean	Z
    //   16: ifne +10 -> 26
    //   19: ldc 64
    //   21: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_1
    //   27: aload_2
    //   28: aload 9
    //   30: invokestatic 69	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Ljava/lang/String;Laxlo;)[Ljava/lang/String;
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
    //   55: astore 13
    //   57: getstatic 83	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   60: ifne +39 -> 99
    //   63: new 32	java/io/File
    //   66: dup
    //   67: new 85	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   74: aload 12
    //   76: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 13
    //   81: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: invokevirtual 97	java/io/File:exists	()Z
    //   93: ifne +6 -> 99
    //   96: bipush 253
    //   98: ireturn
    //   99: aconst_null
    //   100: astore 9
    //   102: aconst_null
    //   103: astore 10
    //   105: new 99	java/lang/ProcessBuilder
    //   108: dup
    //   109: iconst_0
    //   110: anewarray 101	java/lang/String
    //   113: invokespecial 104	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   116: astore 11
    //   118: aload 11
    //   120: iconst_1
    //   121: invokevirtual 108	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   124: pop
    //   125: new 110	java/util/ArrayList
    //   128: dup
    //   129: invokespecial 111	java/util/ArrayList:<init>	()V
    //   132: astore_0
    //   133: aload_0
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
    //   172: aload_0
    //   173: iconst_0
    //   174: invokeinterface 125 2 0
    //   179: checkcast 101	java/lang/String
    //   182: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   191: aload_1
    //   192: arraylength
    //   193: istore 4
    //   195: iconst_0
    //   196: istore_3
    //   197: iload_3
    //   198: iload 4
    //   200: if_icmpge +20 -> 220
    //   203: aload_0
    //   204: aload_1
    //   205: iload_3
    //   206: aaload
    //   207: invokeinterface 119 2 0
    //   212: pop
    //   213: iload_3
    //   214: iconst_1
    //   215: iadd
    //   216: istore_3
    //   217: goto -20 -> 197
    //   220: aload_0
    //   221: new 85	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   228: aload 12
    //   230: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 13
    //   235: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokeinterface 119 2 0
    //   246: pop
    //   247: aload 11
    //   249: aload_0
    //   250: invokevirtual 129	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   253: pop
    //   254: new 85	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   261: ldc 131
    //   263: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_0
    //   267: aload_0
    //   268: invokeinterface 134 1 0
    //   273: iconst_1
    //   274: isub
    //   275: invokeinterface 125 2 0
    //   280: checkcast 101	java/lang/String
    //   283: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   292: aload 11
    //   294: invokevirtual 138	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   297: astore 13
    //   299: getstatic 17	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   302: astore_0
    //   303: aload_0
    //   304: monitorenter
    //   305: aload 13
    //   307: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   310: aload_0
    //   311: monitorexit
    //   312: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   315: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   318: ifne +256 -> 574
    //   321: aconst_null
    //   322: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   325: aload 13
    //   327: invokevirtual 147	java/lang/Process:destroy	()V
    //   330: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   333: iconst_1
    //   334: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   337: iconst_0
    //   338: ifeq +11 -> 349
    //   341: new 152	java/lang/NullPointerException
    //   344: dup
    //   345: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   348: athrow
    //   349: iconst_0
    //   350: ifeq +11 -> 361
    //   353: new 152	java/lang/NullPointerException
    //   356: dup
    //   357: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   360: athrow
    //   361: iconst_0
    //   362: ifeq -338 -> 24
    //   365: new 152	java/lang/NullPointerException
    //   368: dup
    //   369: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   372: athrow
    //   373: astore_0
    //   374: iconst_m1
    //   375: ireturn
    //   376: astore_1
    //   377: aload_0
    //   378: monitorexit
    //   379: aload_1
    //   380: athrow
    //   381: astore 13
    //   383: aconst_null
    //   384: astore_0
    //   385: aconst_null
    //   386: astore_1
    //   387: aconst_null
    //   388: astore 12
    //   390: sipush -1001
    //   393: istore 4
    //   395: aload 12
    //   397: astore 11
    //   399: aload_1
    //   400: astore 10
    //   402: aload_0
    //   403: astore 9
    //   405: aload 13
    //   407: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   410: aload 12
    //   412: astore 11
    //   414: aload_1
    //   415: astore 10
    //   417: aload_0
    //   418: astore 9
    //   420: new 85	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   427: ldc 158
    //   429: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 13
    //   434: invokevirtual 159	java/io/IOException:toString	()Ljava/lang/String;
    //   437: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   446: aload_0
    //   447: ifnull +7 -> 454
    //   450: aload_0
    //   451: invokevirtual 164	java/io/InputStream:close	()V
    //   454: aload_1
    //   455: ifnull +7 -> 462
    //   458: aload_1
    //   459: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   462: iload 4
    //   464: istore_3
    //   465: aload 12
    //   467: ifnull +11 -> 478
    //   470: aload 12
    //   472: invokevirtual 170	java/io/BufferedReader:close	()V
    //   475: iload 4
    //   477: istore_3
    //   478: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   481: lstore 7
    //   483: new 85	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   490: ldc 172
    //   492: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: lload 7
    //   497: lload 5
    //   499: lsub
    //   500: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   503: ldc 177
    //   505: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: iload_3
    //   509: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   518: iload_3
    //   519: ifeq +46 -> 565
    //   522: new 32	java/io/File
    //   525: dup
    //   526: aload_2
    //   527: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   530: astore_0
    //   531: aload_0
    //   532: invokevirtual 97	java/io/File:exists	()Z
    //   535: ifeq +30 -> 565
    //   538: aload_0
    //   539: invokevirtual 183	java/io/File:delete	()Z
    //   542: pop
    //   543: new 85	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   550: ldc 185
    //   552: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: iload_3
    //   556: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   565: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   568: iconst_1
    //   569: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   572: iload_3
    //   573: ireturn
    //   574: aload 13
    //   576: invokevirtual 189	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   579: astore_0
    //   580: new 166	java/io/InputStreamReader
    //   583: dup
    //   584: aload_0
    //   585: invokespecial 192	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   588: astore_1
    //   589: new 169	java/io/BufferedReader
    //   592: dup
    //   593: aload_1
    //   594: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   597: astore 12
    //   599: aload 12
    //   601: astore 11
    //   603: aload_1
    //   604: astore 10
    //   606: aload_0
    //   607: astore 9
    //   609: aload 13
    //   611: invokevirtual 198	java/lang/Process:waitFor	()I
    //   614: pop
    //   615: aload 12
    //   617: astore 11
    //   619: aload_1
    //   620: astore 10
    //   622: aload_0
    //   623: astore 9
    //   625: aload 13
    //   627: invokevirtual 201	java/lang/Process:exitValue	()I
    //   630: istore 4
    //   632: aload 12
    //   634: astore 11
    //   636: aload_1
    //   637: astore 10
    //   639: aload_0
    //   640: astore 9
    //   642: new 85	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   649: ldc 203
    //   651: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: iload 4
    //   656: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   659: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   665: aload 12
    //   667: astore 11
    //   669: aload_1
    //   670: astore 10
    //   672: aload_0
    //   673: astore 9
    //   675: aload 12
    //   677: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   680: astore 14
    //   682: aload 14
    //   684: ifnull +39 -> 723
    //   687: aload 12
    //   689: astore 11
    //   691: aload_1
    //   692: astore 10
    //   694: aload_0
    //   695: astore 9
    //   697: new 85	java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   704: ldc 208
    //   706: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload 14
    //   711: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   720: goto -55 -> 665
    //   723: aload 12
    //   725: astore 11
    //   727: aload_1
    //   728: astore 10
    //   730: aload_0
    //   731: astore 9
    //   733: aload 13
    //   735: invokevirtual 147	java/lang/Process:destroy	()V
    //   738: aload 12
    //   740: astore 11
    //   742: aload_1
    //   743: astore 10
    //   745: aload_0
    //   746: astore 9
    //   748: getstatic 17	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   751: astore 14
    //   753: aload 12
    //   755: astore 11
    //   757: aload_1
    //   758: astore 10
    //   760: aload_0
    //   761: astore 9
    //   763: aload 14
    //   765: monitorenter
    //   766: aconst_null
    //   767: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   770: aload 14
    //   772: monitorexit
    //   773: aload 12
    //   775: astore 11
    //   777: aload_1
    //   778: astore 10
    //   780: aload_0
    //   781: astore 9
    //   783: ldc 210
    //   785: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   788: aload_0
    //   789: ifnull +7 -> 796
    //   792: aload_0
    //   793: invokevirtual 164	java/io/InputStream:close	()V
    //   796: aload_1
    //   797: ifnull +7 -> 804
    //   800: aload_1
    //   801: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   804: iload 4
    //   806: istore_3
    //   807: aload 12
    //   809: ifnull -331 -> 478
    //   812: aload 12
    //   814: invokevirtual 170	java/io/BufferedReader:close	()V
    //   817: iload 4
    //   819: istore_3
    //   820: goto -342 -> 478
    //   823: astore_0
    //   824: iload 4
    //   826: istore_3
    //   827: goto -349 -> 478
    //   830: astore 13
    //   832: aload 14
    //   834: monitorexit
    //   835: aload 12
    //   837: astore 11
    //   839: aload_1
    //   840: astore 10
    //   842: aload_0
    //   843: astore 9
    //   845: aload 13
    //   847: athrow
    //   848: astore 13
    //   850: sipush -1002
    //   853: istore 4
    //   855: aload 12
    //   857: astore 11
    //   859: aload_1
    //   860: astore 10
    //   862: aload_0
    //   863: astore 9
    //   865: aload 13
    //   867: invokevirtual 211	java/lang/InterruptedException:printStackTrace	()V
    //   870: aload 12
    //   872: astore 11
    //   874: aload_1
    //   875: astore 10
    //   877: aload_0
    //   878: astore 9
    //   880: new 85	java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   887: ldc 213
    //   889: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: aload 13
    //   894: invokevirtual 214	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   897: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   906: aload_0
    //   907: ifnull +7 -> 914
    //   910: aload_0
    //   911: invokevirtual 164	java/io/InputStream:close	()V
    //   914: aload_1
    //   915: ifnull +7 -> 922
    //   918: aload_1
    //   919: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   922: iload 4
    //   924: istore_3
    //   925: aload 12
    //   927: ifnull -449 -> 478
    //   930: aload 12
    //   932: invokevirtual 170	java/io/BufferedReader:close	()V
    //   935: iload 4
    //   937: istore_3
    //   938: goto -460 -> 478
    //   941: astore_0
    //   942: iload 4
    //   944: istore_3
    //   945: goto -467 -> 478
    //   948: astore 13
    //   950: aconst_null
    //   951: astore_0
    //   952: aconst_null
    //   953: astore_1
    //   954: aconst_null
    //   955: astore 12
    //   957: sipush -1003
    //   960: istore 4
    //   962: aload 12
    //   964: astore 11
    //   966: aload_1
    //   967: astore 10
    //   969: aload_0
    //   970: astore 9
    //   972: aload 13
    //   974: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   977: aload 12
    //   979: astore 11
    //   981: aload_1
    //   982: astore 10
    //   984: aload_0
    //   985: astore 9
    //   987: new 85	java/lang/StringBuilder
    //   990: dup
    //   991: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   994: ldc 217
    //   996: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: aload 13
    //   1001: invokevirtual 218	java/lang/Exception:toString	()Ljava/lang/String;
    //   1004: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   1013: aload_0
    //   1014: ifnull +7 -> 1021
    //   1017: aload_0
    //   1018: invokevirtual 164	java/io/InputStream:close	()V
    //   1021: aload_1
    //   1022: ifnull +7 -> 1029
    //   1025: aload_1
    //   1026: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1029: iload 4
    //   1031: istore_3
    //   1032: aload 12
    //   1034: ifnull -556 -> 478
    //   1037: aload 12
    //   1039: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1042: iload 4
    //   1044: istore_3
    //   1045: goto -567 -> 478
    //   1048: astore_0
    //   1049: iload 4
    //   1051: istore_3
    //   1052: goto -574 -> 478
    //   1055: astore_1
    //   1056: aconst_null
    //   1057: astore_0
    //   1058: aload 9
    //   1060: astore_2
    //   1061: aload_0
    //   1062: ifnull +7 -> 1069
    //   1065: aload_0
    //   1066: invokevirtual 164	java/io/InputStream:close	()V
    //   1069: aload_2
    //   1070: ifnull +7 -> 1077
    //   1073: aload_2
    //   1074: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1077: aload 10
    //   1079: ifnull +8 -> 1087
    //   1082: aload 10
    //   1084: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1087: aload_1
    //   1088: athrow
    //   1089: astore_0
    //   1090: goto -525 -> 565
    //   1093: astore_0
    //   1094: goto -7 -> 1087
    //   1097: astore_1
    //   1098: aload 9
    //   1100: astore_2
    //   1101: goto -40 -> 1061
    //   1104: astore 9
    //   1106: aload_1
    //   1107: astore_2
    //   1108: aload 9
    //   1110: astore_1
    //   1111: goto -50 -> 1061
    //   1114: astore_1
    //   1115: aload 10
    //   1117: astore_2
    //   1118: aload 11
    //   1120: astore 10
    //   1122: aload 9
    //   1124: astore_0
    //   1125: goto -64 -> 1061
    //   1128: astore 13
    //   1130: aconst_null
    //   1131: astore_1
    //   1132: aconst_null
    //   1133: astore 12
    //   1135: goto -178 -> 957
    //   1138: astore 13
    //   1140: aconst_null
    //   1141: astore 12
    //   1143: goto -186 -> 957
    //   1146: astore 13
    //   1148: goto -191 -> 957
    //   1151: astore 13
    //   1153: aconst_null
    //   1154: astore_0
    //   1155: aconst_null
    //   1156: astore_1
    //   1157: aconst_null
    //   1158: astore 12
    //   1160: goto -310 -> 850
    //   1163: astore 13
    //   1165: aconst_null
    //   1166: astore_1
    //   1167: aconst_null
    //   1168: astore 12
    //   1170: goto -320 -> 850
    //   1173: astore 13
    //   1175: aconst_null
    //   1176: astore 12
    //   1178: goto -328 -> 850
    //   1181: astore_0
    //   1182: iload 4
    //   1184: istore_3
    //   1185: goto -707 -> 478
    //   1188: astore 13
    //   1190: aconst_null
    //   1191: astore_1
    //   1192: aconst_null
    //   1193: astore 12
    //   1195: goto -805 -> 390
    //   1198: astore 13
    //   1200: aconst_null
    //   1201: astore 12
    //   1203: goto -813 -> 390
    //   1206: astore 13
    //   1208: goto -818 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1211	0	paramContext	Context
    //   0	1211	1	paramString1	String
    //   0	1211	2	paramString2	String
    //   196	989	3	i	int
    //   193	990	4	j	int
    //   3	495	5	l1	long
    //   481	15	7	l2	long
    //   9	1090	9	localObject1	Object
    //   1104	19	9	localObject2	Object
    //   103	1018	10	localObject3	Object
    //   116	1003	11	localObject4	Object
    //   50	1152	12	localObject5	Object
    //   55	271	13	localObject6	Object
    //   381	353	13	localIOException1	java.io.IOException
    //   830	16	13	localObject7	Object
    //   848	45	13	localInterruptedException1	java.lang.InterruptedException
    //   948	52	13	localException1	Exception
    //   1128	1	13	localException2	Exception
    //   1138	1	13	localException3	Exception
    //   1146	1	13	localException4	Exception
    //   1151	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1163	1	13	localInterruptedException3	java.lang.InterruptedException
    //   1173	1	13	localInterruptedException4	java.lang.InterruptedException
    //   1188	1	13	localIOException2	java.io.IOException
    //   1198	1	13	localIOException3	java.io.IOException
    //   1206	1	13	localIOException4	java.io.IOException
    //   680	153	14	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   341	349	373	java/io/IOException
    //   353	361	373	java/io/IOException
    //   365	373	373	java/io/IOException
    //   305	312	376	finally
    //   377	379	376	finally
    //   105	195	381	java/io/IOException
    //   203	213	381	java/io/IOException
    //   220	305	381	java/io/IOException
    //   312	337	381	java/io/IOException
    //   379	381	381	java/io/IOException
    //   574	580	381	java/io/IOException
    //   792	796	823	java/io/IOException
    //   800	804	823	java/io/IOException
    //   812	817	823	java/io/IOException
    //   766	773	830	finally
    //   832	835	830	finally
    //   609	615	848	java/lang/InterruptedException
    //   625	632	848	java/lang/InterruptedException
    //   642	665	848	java/lang/InterruptedException
    //   675	682	848	java/lang/InterruptedException
    //   697	720	848	java/lang/InterruptedException
    //   733	738	848	java/lang/InterruptedException
    //   748	753	848	java/lang/InterruptedException
    //   763	766	848	java/lang/InterruptedException
    //   783	788	848	java/lang/InterruptedException
    //   845	848	848	java/lang/InterruptedException
    //   910	914	941	java/io/IOException
    //   918	922	941	java/io/IOException
    //   930	935	941	java/io/IOException
    //   105	195	948	java/lang/Exception
    //   203	213	948	java/lang/Exception
    //   220	305	948	java/lang/Exception
    //   312	337	948	java/lang/Exception
    //   379	381	948	java/lang/Exception
    //   574	580	948	java/lang/Exception
    //   1017	1021	1048	java/io/IOException
    //   1025	1029	1048	java/io/IOException
    //   1037	1042	1048	java/io/IOException
    //   105	195	1055	finally
    //   203	213	1055	finally
    //   220	305	1055	finally
    //   312	337	1055	finally
    //   379	381	1055	finally
    //   574	580	1055	finally
    //   522	565	1089	java/lang/Exception
    //   1065	1069	1093	java/io/IOException
    //   1073	1077	1093	java/io/IOException
    //   1082	1087	1093	java/io/IOException
    //   580	589	1097	finally
    //   589	599	1104	finally
    //   405	410	1114	finally
    //   420	446	1114	finally
    //   609	615	1114	finally
    //   625	632	1114	finally
    //   642	665	1114	finally
    //   675	682	1114	finally
    //   697	720	1114	finally
    //   733	738	1114	finally
    //   748	753	1114	finally
    //   763	766	1114	finally
    //   783	788	1114	finally
    //   845	848	1114	finally
    //   865	870	1114	finally
    //   880	906	1114	finally
    //   972	977	1114	finally
    //   987	1013	1114	finally
    //   580	589	1128	java/lang/Exception
    //   589	599	1138	java/lang/Exception
    //   609	615	1146	java/lang/Exception
    //   625	632	1146	java/lang/Exception
    //   642	665	1146	java/lang/Exception
    //   675	682	1146	java/lang/Exception
    //   697	720	1146	java/lang/Exception
    //   733	738	1146	java/lang/Exception
    //   748	753	1146	java/lang/Exception
    //   763	766	1146	java/lang/Exception
    //   783	788	1146	java/lang/Exception
    //   845	848	1146	java/lang/Exception
    //   105	195	1151	java/lang/InterruptedException
    //   203	213	1151	java/lang/InterruptedException
    //   220	305	1151	java/lang/InterruptedException
    //   312	337	1151	java/lang/InterruptedException
    //   379	381	1151	java/lang/InterruptedException
    //   574	580	1151	java/lang/InterruptedException
    //   580	589	1163	java/lang/InterruptedException
    //   589	599	1173	java/lang/InterruptedException
    //   450	454	1181	java/io/IOException
    //   458	462	1181	java/io/IOException
    //   470	475	1181	java/io/IOException
    //   580	589	1188	java/io/IOException
    //   589	599	1198	java/io/IOException
    //   609	615	1206	java/io/IOException
    //   625	632	1206	java/io/IOException
    //   642	665	1206	java/io/IOException
    //   675	682	1206	java/io/IOException
    //   697	720	1206	java/io/IOException
    //   733	738	1206	java/io/IOException
    //   748	753	1206	java/io/IOException
    //   763	766	1206	java/io/IOException
    //   783	788	1206	java/io/IOException
    //   845	848	1206	java/io/IOException
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString1, String paramString2, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, axlp paramaxlp, axfd paramaxfd, axff paramaxff)
  {
    // Byte code:
    //   0: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   3: lstore 9
    //   5: new 60	axlo
    //   8: dup
    //   9: invokespecial 220	axlo:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: iconst_1
    //   15: putfield 62	axlo:jdField_a_of_type_Boolean	Z
    //   18: aload_3
    //   19: aload 6
    //   21: getfield 225	axff:jdField_c_of_type_Int	I
    //   24: invokestatic 229	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: putfield 232	axlo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: aload_3
    //   31: aload 6
    //   33: getfield 233	axff:jdField_a_of_type_Int	I
    //   36: putfield 234	axlo:jdField_a_of_type_Int	I
    //   39: aload_3
    //   40: aload 6
    //   42: getfield 237	axff:jdField_b_of_type_Int	I
    //   45: putfield 238	axlo:jdField_b_of_type_Int	I
    //   48: aload_3
    //   49: aload 6
    //   51: getfield 241	axff:jdField_d_of_type_Int	I
    //   54: i2l
    //   55: putfield 244	axlo:jdField_c_of_type_Long	J
    //   58: aload_3
    //   59: aload 5
    //   61: getfield 247	axfd:jdField_a_of_type_Int	I
    //   64: putfield 248	axlo:jdField_c_of_type_Int	I
    //   67: aload_3
    //   68: aload 5
    //   70: getfield 249	axfd:jdField_b_of_type_Int	I
    //   73: putfield 250	axlo:jdField_d_of_type_Int	I
    //   76: aload_3
    //   77: bipush 25
    //   79: putfield 253	axlo:jdField_e_of_type_Int	I
    //   82: aload_3
    //   83: aload 5
    //   85: getfield 255	axfd:jdField_b_of_type_Long	J
    //   88: putfield 257	axlo:jdField_d_of_type_Long	J
    //   91: aload_3
    //   92: aload 5
    //   94: getfield 259	axfd:jdField_a_of_type_Long	J
    //   97: putfield 261	axlo:jdField_e_of_type_Long	J
    //   100: aload_3
    //   101: getfield 62	axlo:jdField_a_of_type_Boolean	Z
    //   104: ifne +10 -> 114
    //   107: ldc 64
    //   109: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   112: iconst_m1
    //   113: ireturn
    //   114: aload_1
    //   115: aload_2
    //   116: aload_3
    //   117: invokestatic 263	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:b	(Ljava/lang/String;Ljava/lang/String;Laxlo;)[Ljava/lang/String;
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
    //   144: astore_0
    //   145: getstatic 83	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   148: ifne +38 -> 186
    //   151: new 32	java/io/File
    //   154: dup
    //   155: new 85	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   162: aload 13
    //   164: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   177: invokevirtual 97	java/io/File:exists	()Z
    //   180: ifne +6 -> 186
    //   183: bipush 253
    //   185: ireturn
    //   186: aconst_null
    //   187: astore_1
    //   188: aconst_null
    //   189: astore 5
    //   191: aconst_null
    //   192: astore_3
    //   193: new 99	java/lang/ProcessBuilder
    //   196: dup
    //   197: iconst_0
    //   198: anewarray 101	java/lang/String
    //   201: invokespecial 104	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   204: astore 14
    //   206: aload 14
    //   208: iconst_1
    //   209: invokevirtual 108	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   212: pop
    //   213: new 110	java/util/ArrayList
    //   216: dup
    //   217: invokespecial 111	java/util/ArrayList:<init>	()V
    //   220: astore 15
    //   222: aload 15
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
    //   262: aload 15
    //   264: iconst_0
    //   265: invokeinterface 125 2 0
    //   270: checkcast 101	java/lang/String
    //   273: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   282: aload 6
    //   284: arraylength
    //   285: istore 8
    //   287: iconst_0
    //   288: istore 7
    //   290: iload 7
    //   292: iload 8
    //   294: if_icmpge +25 -> 319
    //   297: aload 15
    //   299: aload 6
    //   301: iload 7
    //   303: aaload
    //   304: invokeinterface 119 2 0
    //   309: pop
    //   310: iload 7
    //   312: iconst_1
    //   313: iadd
    //   314: istore 7
    //   316: goto -26 -> 290
    //   319: aload 15
    //   321: new 85	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   328: aload 13
    //   330: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokeinterface 119 2 0
    //   345: pop
    //   346: aload 14
    //   348: aload 15
    //   350: invokevirtual 129	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   353: pop
    //   354: new 85	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   361: ldc 131
    //   363: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 15
    //   368: aload 15
    //   370: invokeinterface 134 1 0
    //   375: iconst_1
    //   376: isub
    //   377: invokeinterface 125 2 0
    //   382: checkcast 101	java/lang/String
    //   385: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   394: aload 14
    //   396: invokevirtual 138	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   399: astore 14
    //   401: getstatic 17	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   404: astore_0
    //   405: aload_0
    //   406: monitorenter
    //   407: aload 14
    //   409: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   412: aload_0
    //   413: monitorexit
    //   414: aload 4
    //   416: ifnull +13 -> 429
    //   419: aload 4
    //   421: getstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   424: invokeinterface 268 2 0
    //   429: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   432: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   435: ifne +274 -> 709
    //   438: aload 4
    //   440: ifnull +10 -> 450
    //   443: aload 4
    //   445: invokeinterface 270 1 0
    //   450: aconst_null
    //   451: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   454: aload 14
    //   456: invokevirtual 147	java/lang/Process:destroy	()V
    //   459: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   462: iconst_1
    //   463: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   466: iconst_0
    //   467: ifeq +11 -> 478
    //   470: new 152	java/lang/NullPointerException
    //   473: dup
    //   474: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   477: athrow
    //   478: iconst_0
    //   479: ifeq +11 -> 490
    //   482: new 152	java/lang/NullPointerException
    //   485: dup
    //   486: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   489: athrow
    //   490: iconst_0
    //   491: ifeq -379 -> 112
    //   494: new 152	java/lang/NullPointerException
    //   497: dup
    //   498: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   501: athrow
    //   502: astore_0
    //   503: iconst_m1
    //   504: ireturn
    //   505: astore 4
    //   507: aload_0
    //   508: monitorexit
    //   509: aload 4
    //   511: athrow
    //   512: astore 14
    //   514: aconst_null
    //   515: astore_0
    //   516: aconst_null
    //   517: astore_1
    //   518: aconst_null
    //   519: astore 4
    //   521: sipush -1001
    //   524: istore 8
    //   526: aload 4
    //   528: astore 6
    //   530: aload_1
    //   531: astore 5
    //   533: aload_0
    //   534: astore_3
    //   535: aload 14
    //   537: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   540: aload 4
    //   542: astore 6
    //   544: aload_1
    //   545: astore 5
    //   547: aload_0
    //   548: astore_3
    //   549: new 85	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   556: ldc 158
    //   558: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload 14
    //   563: invokevirtual 159	java/io/IOException:toString	()Ljava/lang/String;
    //   566: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   575: aload_0
    //   576: ifnull +7 -> 583
    //   579: aload_0
    //   580: invokevirtual 164	java/io/InputStream:close	()V
    //   583: aload_1
    //   584: ifnull +7 -> 591
    //   587: aload_1
    //   588: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   591: iload 8
    //   593: istore 7
    //   595: aload 4
    //   597: ifnull +12 -> 609
    //   600: aload 4
    //   602: invokevirtual 170	java/io/BufferedReader:close	()V
    //   605: iload 8
    //   607: istore 7
    //   609: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   612: lstore 11
    //   614: new 85	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   621: ldc 172
    //   623: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: lload 11
    //   628: lload 9
    //   630: lsub
    //   631: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   634: ldc 177
    //   636: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: iload 7
    //   641: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   644: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   650: iload 7
    //   652: ifeq +47 -> 699
    //   655: new 32	java/io/File
    //   658: dup
    //   659: aload_2
    //   660: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   663: astore_0
    //   664: aload_0
    //   665: invokevirtual 97	java/io/File:exists	()Z
    //   668: ifeq +31 -> 699
    //   671: aload_0
    //   672: invokevirtual 183	java/io/File:delete	()Z
    //   675: pop
    //   676: new 85	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   683: ldc 185
    //   685: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: iload 7
    //   690: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   693: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   699: getstatic 24	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   702: iconst_1
    //   703: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   706: iload 7
    //   708: ireturn
    //   709: aload 14
    //   711: invokevirtual 189	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   714: astore_0
    //   715: new 166	java/io/InputStreamReader
    //   718: dup
    //   719: aload_0
    //   720: invokespecial 192	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   723: astore_1
    //   724: new 169	java/io/BufferedReader
    //   727: dup
    //   728: aload_1
    //   729: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   732: astore 13
    //   734: aload 13
    //   736: astore 6
    //   738: aload_1
    //   739: astore 5
    //   741: aload_0
    //   742: astore_3
    //   743: aload 14
    //   745: invokevirtual 198	java/lang/Process:waitFor	()I
    //   748: pop
    //   749: aload 13
    //   751: astore 6
    //   753: aload_1
    //   754: astore 5
    //   756: aload_0
    //   757: astore_3
    //   758: aload 14
    //   760: invokevirtual 201	java/lang/Process:exitValue	()I
    //   763: istore 8
    //   765: aload 13
    //   767: astore 6
    //   769: aload_1
    //   770: astore 5
    //   772: aload_0
    //   773: astore_3
    //   774: new 85	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   781: ldc 203
    //   783: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: iload 8
    //   788: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   791: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   797: aload 13
    //   799: astore 6
    //   801: aload_1
    //   802: astore 5
    //   804: aload_0
    //   805: astore_3
    //   806: aload 13
    //   808: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   811: astore 15
    //   813: aload 15
    //   815: ifnull +38 -> 853
    //   818: aload 13
    //   820: astore 6
    //   822: aload_1
    //   823: astore 5
    //   825: aload_0
    //   826: astore_3
    //   827: new 85	java/lang/StringBuilder
    //   830: dup
    //   831: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   834: ldc 208
    //   836: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: aload 15
    //   841: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   850: goto -53 -> 797
    //   853: aload 13
    //   855: astore 6
    //   857: aload_1
    //   858: astore 5
    //   860: aload_0
    //   861: astore_3
    //   862: aload 14
    //   864: invokevirtual 147	java/lang/Process:destroy	()V
    //   867: aload 4
    //   869: ifnull +19 -> 888
    //   872: aload 13
    //   874: astore 6
    //   876: aload_1
    //   877: astore 5
    //   879: aload_0
    //   880: astore_3
    //   881: aload 4
    //   883: invokeinterface 272 1 0
    //   888: aload 13
    //   890: astore 6
    //   892: aload_1
    //   893: astore 5
    //   895: aload_0
    //   896: astore_3
    //   897: getstatic 17	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   900: astore 4
    //   902: aload 13
    //   904: astore 6
    //   906: aload_1
    //   907: astore 5
    //   909: aload_0
    //   910: astore_3
    //   911: aload 4
    //   913: monitorenter
    //   914: aconst_null
    //   915: putstatic 140	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   918: aload 4
    //   920: monitorexit
    //   921: aload 13
    //   923: astore 6
    //   925: aload_1
    //   926: astore 5
    //   928: aload_0
    //   929: astore_3
    //   930: ldc 210
    //   932: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   935: aload_0
    //   936: ifnull +7 -> 943
    //   939: aload_0
    //   940: invokevirtual 164	java/io/InputStream:close	()V
    //   943: aload_1
    //   944: ifnull +7 -> 951
    //   947: aload_1
    //   948: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   951: iload 8
    //   953: istore 7
    //   955: aload 13
    //   957: ifnull -348 -> 609
    //   960: aload 13
    //   962: invokevirtual 170	java/io/BufferedReader:close	()V
    //   965: iload 8
    //   967: istore 7
    //   969: goto -360 -> 609
    //   972: astore_0
    //   973: iload 8
    //   975: istore 7
    //   977: goto -368 -> 609
    //   980: astore 14
    //   982: aload 4
    //   984: monitorexit
    //   985: aload 13
    //   987: astore 6
    //   989: aload_1
    //   990: astore 5
    //   992: aload_0
    //   993: astore_3
    //   994: aload 14
    //   996: athrow
    //   997: astore_3
    //   998: aload 13
    //   1000: astore 4
    //   1002: aload_3
    //   1003: astore 13
    //   1005: sipush -1002
    //   1008: istore 8
    //   1010: aload 4
    //   1012: astore 6
    //   1014: aload_1
    //   1015: astore 5
    //   1017: aload_0
    //   1018: astore_3
    //   1019: aload 13
    //   1021: invokevirtual 211	java/lang/InterruptedException:printStackTrace	()V
    //   1024: aload 4
    //   1026: astore 6
    //   1028: aload_1
    //   1029: astore 5
    //   1031: aload_0
    //   1032: astore_3
    //   1033: new 85	java/lang/StringBuilder
    //   1036: dup
    //   1037: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1040: ldc 213
    //   1042: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: aload 13
    //   1047: invokevirtual 214	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   1050: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1056: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   1059: aload_0
    //   1060: ifnull +7 -> 1067
    //   1063: aload_0
    //   1064: invokevirtual 164	java/io/InputStream:close	()V
    //   1067: aload_1
    //   1068: ifnull +7 -> 1075
    //   1071: aload_1
    //   1072: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1075: iload 8
    //   1077: istore 7
    //   1079: aload 4
    //   1081: ifnull -472 -> 609
    //   1084: aload 4
    //   1086: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1089: iload 8
    //   1091: istore 7
    //   1093: goto -484 -> 609
    //   1096: astore_0
    //   1097: iload 8
    //   1099: istore 7
    //   1101: goto -492 -> 609
    //   1104: astore 14
    //   1106: aconst_null
    //   1107: astore_0
    //   1108: aconst_null
    //   1109: astore_1
    //   1110: aconst_null
    //   1111: astore 4
    //   1113: sipush -1003
    //   1116: istore 8
    //   1118: aload 4
    //   1120: astore 6
    //   1122: aload_1
    //   1123: astore 5
    //   1125: aload_0
    //   1126: astore_3
    //   1127: aload 14
    //   1129: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   1132: aload 4
    //   1134: astore 6
    //   1136: aload_1
    //   1137: astore 5
    //   1139: aload_0
    //   1140: astore_3
    //   1141: new 85	java/lang/StringBuilder
    //   1144: dup
    //   1145: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1148: ldc 217
    //   1150: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: aload 14
    //   1155: invokevirtual 218	java/lang/Exception:toString	()Ljava/lang/String;
    //   1158: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1164: invokestatic 66	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   1167: aload_0
    //   1168: ifnull +7 -> 1175
    //   1171: aload_0
    //   1172: invokevirtual 164	java/io/InputStream:close	()V
    //   1175: aload_1
    //   1176: ifnull +7 -> 1183
    //   1179: aload_1
    //   1180: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1183: iload 8
    //   1185: istore 7
    //   1187: aload 4
    //   1189: ifnull -580 -> 609
    //   1192: aload 4
    //   1194: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1197: iload 8
    //   1199: istore 7
    //   1201: goto -592 -> 609
    //   1204: astore_0
    //   1205: iload 8
    //   1207: istore 7
    //   1209: goto -600 -> 609
    //   1212: astore_0
    //   1213: aload 5
    //   1215: astore_2
    //   1216: aload_1
    //   1217: ifnull +7 -> 1224
    //   1220: aload_1
    //   1221: invokevirtual 164	java/io/InputStream:close	()V
    //   1224: aload_2
    //   1225: ifnull +7 -> 1232
    //   1228: aload_2
    //   1229: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1232: aload_3
    //   1233: ifnull +7 -> 1240
    //   1236: aload_3
    //   1237: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1240: aload_0
    //   1241: athrow
    //   1242: astore_0
    //   1243: goto -544 -> 699
    //   1246: astore_1
    //   1247: goto -7 -> 1240
    //   1250: astore_2
    //   1251: aload_0
    //   1252: astore_1
    //   1253: aload_2
    //   1254: astore_0
    //   1255: aload 5
    //   1257: astore_2
    //   1258: goto -42 -> 1216
    //   1261: astore 4
    //   1263: aload_1
    //   1264: astore_2
    //   1265: aload_0
    //   1266: astore_1
    //   1267: aload 4
    //   1269: astore_0
    //   1270: goto -54 -> 1216
    //   1273: astore_0
    //   1274: aload 5
    //   1276: astore_2
    //   1277: aload_3
    //   1278: astore_1
    //   1279: aload 6
    //   1281: astore_3
    //   1282: goto -66 -> 1216
    //   1285: astore 14
    //   1287: aconst_null
    //   1288: astore_1
    //   1289: aconst_null
    //   1290: astore 4
    //   1292: goto -179 -> 1113
    //   1295: astore 14
    //   1297: aconst_null
    //   1298: astore 4
    //   1300: goto -187 -> 1113
    //   1303: astore 14
    //   1305: aload 13
    //   1307: astore 4
    //   1309: goto -196 -> 1113
    //   1312: astore 13
    //   1314: aconst_null
    //   1315: astore_0
    //   1316: aconst_null
    //   1317: astore_1
    //   1318: aconst_null
    //   1319: astore 4
    //   1321: goto -316 -> 1005
    //   1324: astore 13
    //   1326: aconst_null
    //   1327: astore_1
    //   1328: aconst_null
    //   1329: astore 4
    //   1331: goto -326 -> 1005
    //   1334: astore 13
    //   1336: aconst_null
    //   1337: astore 4
    //   1339: goto -334 -> 1005
    //   1342: astore_0
    //   1343: iload 8
    //   1345: istore 7
    //   1347: goto -738 -> 609
    //   1350: astore 14
    //   1352: aconst_null
    //   1353: astore_1
    //   1354: aconst_null
    //   1355: astore 4
    //   1357: goto -836 -> 521
    //   1360: astore 14
    //   1362: aconst_null
    //   1363: astore 4
    //   1365: goto -844 -> 521
    //   1368: astore 14
    //   1370: aload 13
    //   1372: astore 4
    //   1374: goto -853 -> 521
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1377	0	paramContext	Context
    //   0	1377	1	paramString1	String
    //   0	1377	2	paramString2	String
    //   0	1377	3	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1377	4	paramaxlp	axlp
    //   0	1377	5	paramaxfd	axfd
    //   0	1377	6	paramaxff	axff
    //   288	1058	7	i	int
    //   285	1059	8	j	int
    //   3	626	9	l1	long
    //   612	15	11	l2	long
    //   139	1167	13	localObject1	Object
    //   1312	1	13	localInterruptedException1	java.lang.InterruptedException
    //   1324	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1334	37	13	localInterruptedException3	java.lang.InterruptedException
    //   204	251	14	localObject2	Object
    //   512	351	14	localIOException1	java.io.IOException
    //   980	15	14	localObject3	Object
    //   1104	50	14	localException1	Exception
    //   1285	1	14	localException2	Exception
    //   1295	1	14	localException3	Exception
    //   1303	1	14	localException4	Exception
    //   1350	1	14	localIOException2	java.io.IOException
    //   1360	1	14	localIOException3	java.io.IOException
    //   1368	1	14	localIOException4	java.io.IOException
    //   220	620	15	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   470	478	502	java/io/IOException
    //   482	490	502	java/io/IOException
    //   494	502	502	java/io/IOException
    //   407	414	505	finally
    //   507	509	505	finally
    //   193	287	512	java/io/IOException
    //   297	310	512	java/io/IOException
    //   319	407	512	java/io/IOException
    //   419	429	512	java/io/IOException
    //   429	438	512	java/io/IOException
    //   443	450	512	java/io/IOException
    //   450	466	512	java/io/IOException
    //   509	512	512	java/io/IOException
    //   709	715	512	java/io/IOException
    //   939	943	972	java/io/IOException
    //   947	951	972	java/io/IOException
    //   960	965	972	java/io/IOException
    //   914	921	980	finally
    //   982	985	980	finally
    //   743	749	997	java/lang/InterruptedException
    //   758	765	997	java/lang/InterruptedException
    //   774	797	997	java/lang/InterruptedException
    //   806	813	997	java/lang/InterruptedException
    //   827	850	997	java/lang/InterruptedException
    //   862	867	997	java/lang/InterruptedException
    //   881	888	997	java/lang/InterruptedException
    //   897	902	997	java/lang/InterruptedException
    //   911	914	997	java/lang/InterruptedException
    //   930	935	997	java/lang/InterruptedException
    //   994	997	997	java/lang/InterruptedException
    //   1063	1067	1096	java/io/IOException
    //   1071	1075	1096	java/io/IOException
    //   1084	1089	1096	java/io/IOException
    //   193	287	1104	java/lang/Exception
    //   297	310	1104	java/lang/Exception
    //   319	407	1104	java/lang/Exception
    //   419	429	1104	java/lang/Exception
    //   429	438	1104	java/lang/Exception
    //   443	450	1104	java/lang/Exception
    //   450	466	1104	java/lang/Exception
    //   509	512	1104	java/lang/Exception
    //   709	715	1104	java/lang/Exception
    //   1171	1175	1204	java/io/IOException
    //   1179	1183	1204	java/io/IOException
    //   1192	1197	1204	java/io/IOException
    //   193	287	1212	finally
    //   297	310	1212	finally
    //   319	407	1212	finally
    //   419	429	1212	finally
    //   429	438	1212	finally
    //   443	450	1212	finally
    //   450	466	1212	finally
    //   509	512	1212	finally
    //   709	715	1212	finally
    //   655	699	1242	java/lang/Exception
    //   1220	1224	1246	java/io/IOException
    //   1228	1232	1246	java/io/IOException
    //   1236	1240	1246	java/io/IOException
    //   715	724	1250	finally
    //   724	734	1261	finally
    //   535	540	1273	finally
    //   549	575	1273	finally
    //   743	749	1273	finally
    //   758	765	1273	finally
    //   774	797	1273	finally
    //   806	813	1273	finally
    //   827	850	1273	finally
    //   862	867	1273	finally
    //   881	888	1273	finally
    //   897	902	1273	finally
    //   911	914	1273	finally
    //   930	935	1273	finally
    //   994	997	1273	finally
    //   1019	1024	1273	finally
    //   1033	1059	1273	finally
    //   1127	1132	1273	finally
    //   1141	1167	1273	finally
    //   715	724	1285	java/lang/Exception
    //   724	734	1295	java/lang/Exception
    //   743	749	1303	java/lang/Exception
    //   758	765	1303	java/lang/Exception
    //   774	797	1303	java/lang/Exception
    //   806	813	1303	java/lang/Exception
    //   827	850	1303	java/lang/Exception
    //   862	867	1303	java/lang/Exception
    //   881	888	1303	java/lang/Exception
    //   897	902	1303	java/lang/Exception
    //   911	914	1303	java/lang/Exception
    //   930	935	1303	java/lang/Exception
    //   994	997	1303	java/lang/Exception
    //   193	287	1312	java/lang/InterruptedException
    //   297	310	1312	java/lang/InterruptedException
    //   319	407	1312	java/lang/InterruptedException
    //   419	429	1312	java/lang/InterruptedException
    //   429	438	1312	java/lang/InterruptedException
    //   443	450	1312	java/lang/InterruptedException
    //   450	466	1312	java/lang/InterruptedException
    //   509	512	1312	java/lang/InterruptedException
    //   709	715	1312	java/lang/InterruptedException
    //   715	724	1324	java/lang/InterruptedException
    //   724	734	1334	java/lang/InterruptedException
    //   579	583	1342	java/io/IOException
    //   587	591	1342	java/io/IOException
    //   600	605	1342	java/io/IOException
    //   715	724	1350	java/io/IOException
    //   724	734	1360	java/io/IOException
    //   743	749	1368	java/io/IOException
    //   758	765	1368	java/io/IOException
    //   774	797	1368	java/io/IOException
    //   806	813	1368	java/io/IOException
    //   827	850	1368	java/io/IOException
    //   862	867	1368	java/io/IOException
    //   881	888	1368	java/io/IOException
    //   897	902	1368	java/io/IOException
    //   911	914	1368	java/io/IOException
    //   930	935	1368	java/io/IOException
    //   994	997	1368	java/io/IOException
  }
  
  public static axlo a(String paramString)
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
        localObject = new axlo();
        localFile = new File(paramString);
        if (!localFile.exists())
        {
          ((axlo)localObject).jdField_a_of_type_Boolean = false;
          a("[@] getCompressConfig : [!file.exists]");
        }
        paramString = a(paramString);
        if ((paramString != null) && (paramString.length == 5) && (paramString[0] == 0)) {
          break;
        }
        ((axlo)localObject).jdField_a_of_type_Boolean = false;
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
  
  private static String[] a(String paramString1, String paramString2, axlo paramaxlo)
  {
    String str1 = "1";
    if (a() >= 2) {
      str1 = "2";
    }
    String str2 = paramaxlo.jdField_c_of_type_Int + "x" + String.valueOf(paramaxlo.jdField_d_of_type_Int);
    a("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramaxlo.jdField_a_of_type_JavaLangString, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(paramaxlo.jdField_e_of_type_Int), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
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
  
  private static String[] b(String paramString1, String paramString2, axlo paramaxlo)
  {
    String str1 = "1";
    if (a() >= 2) {
      str1 = "2";
    }
    String str2 = paramaxlo.jdField_c_of_type_Int + "x" + String.valueOf(paramaxlo.jdField_d_of_type_Int);
    a("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    String str3 = paramaxlo.jdField_e_of_type_Long / 1024L + "k";
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramaxlo.jdField_a_of_type_JavaLangString, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-bufsize", "800k", "-minrate", str3, "-maxrate", str3, "-b", str3, "-r", String.valueOf(paramaxlo.jdField_d_of_type_Long), "-bufsize", "800k", "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  public static native String getRealProperties(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer
 * JD-Core Version:    0.7.0.1
 */