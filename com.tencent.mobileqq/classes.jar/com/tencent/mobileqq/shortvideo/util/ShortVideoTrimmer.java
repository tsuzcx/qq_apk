package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
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
  public static final long CODE_RATE = 1688L;
  public static final int CONFIG_LONG_EDGE_DEFAULT = 640;
  public static final int ORIENTATION_DOWN = 2;
  public static final int ORIENTATION_LEFT = 1;
  public static final int ORIENTATION_RIGHT = 3;
  public static final int ORIENTATION_UP = 0;
  public static final String TAG = "ShortVideoTrimmer";
  public static final int VIDEO_COMPRESS_ARGS_ERR = -2;
  public static final String VIDEO_COMPRESS_BIN_NAME = "QQVideoTrimProcess";
  public static final int VIDEO_COMPRESS_NOTFIND_SO_ERR = -3;
  public static final int VIDEO_COMPRESS_NO_NEED = -1;
  private static boolean VIDEO_COMPRESS_TEST_ENV = false;
  public static final String VIDEO_TRIM_PIC = "trim_process_pic";
  public static final String VIDEO_TRIM_PIE = "trim_process_pie";
  static final Object lock = new Object();
  public static AtomicBoolean needCompress = new AtomicBoolean(true);
  static Process process;
  public static int sCpuCores;
  
  private static void PrintLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoTrimmer", 2, paramString);
    }
    if (VIDEO_COMPRESS_TEST_ENV) {
      Log.d("ShortVideoTrimmer", paramString);
    }
  }
  
  /* Error */
  public static int compressVideo(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: aload_1
    //   6: invokestatic 99	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getCompressConfig	(Ljava/lang/String;)Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;
    //   9: astore 9
    //   11: aload 9
    //   13: getfield 104	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:isNeedCompress	Z
    //   16: ifne +10 -> 26
    //   19: ldc 106
    //   21: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_1
    //   27: aload_2
    //   28: aload 9
    //   30: invokestatic 112	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:generateCommand	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;)[Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +11 -> 46
    //   38: ldc 114
    //   40: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   43: bipush 254
    //   45: ireturn
    //   46: aload_0
    //   47: invokestatic 120	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   50: astore 12
    //   52: invokestatic 126	com/tencent/mobileqq/shortvideo/VideoEnvironment:getShortVideoSoLibName	()Ljava/lang/String;
    //   55: astore_0
    //   56: getstatic 76	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:VIDEO_COMPRESS_TEST_ENV	Z
    //   59: ifne +38 -> 97
    //   62: new 128	java/io/File
    //   65: dup
    //   66: new 130	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   73: aload 12
    //   75: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokevirtual 143	java/io/File:exists	()Z
    //   91: ifne +6 -> 97
    //   94: bipush 253
    //   96: ireturn
    //   97: aconst_null
    //   98: astore 9
    //   100: aconst_null
    //   101: astore 10
    //   103: new 145	java/lang/ProcessBuilder
    //   106: dup
    //   107: iconst_0
    //   108: anewarray 147	java/lang/String
    //   111: invokespecial 150	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   114: astore 11
    //   116: aload 11
    //   118: iconst_1
    //   119: invokevirtual 154	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   122: pop
    //   123: new 156	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 157	java/util/ArrayList:<init>	()V
    //   130: astore 13
    //   132: aload 13
    //   134: new 130	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   141: aload 12
    //   143: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 28
    //   148: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokeinterface 163 2 0
    //   159: pop
    //   160: new 130	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   167: ldc 165
    //   169: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 13
    //   174: iconst_0
    //   175: invokeinterface 169 2 0
    //   180: checkcast 147	java/lang/String
    //   183: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
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
    //   209: invokeinterface 163 2 0
    //   214: pop
    //   215: iload_3
    //   216: iconst_1
    //   217: iadd
    //   218: istore_3
    //   219: goto -21 -> 198
    //   222: aload 13
    //   224: new 130	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   231: aload 12
    //   233: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokeinterface 163 2 0
    //   248: pop
    //   249: aload 11
    //   251: aload 13
    //   253: invokevirtual 173	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   256: pop
    //   257: new 130	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   264: ldc 175
    //   266: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 13
    //   271: aload 13
    //   273: invokeinterface 179 1 0
    //   278: iconst_1
    //   279: isub
    //   280: invokeinterface 169 2 0
    //   285: checkcast 147	java/lang/String
    //   288: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   297: aload 11
    //   299: invokevirtual 183	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   302: astore 13
    //   304: getstatic 54	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   307: astore_0
    //   308: aload_0
    //   309: monitorenter
    //   310: aload 13
    //   312: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   315: aload_0
    //   316: monitorexit
    //   317: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   320: invokevirtual 187	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   323: ifne +256 -> 579
    //   326: aconst_null
    //   327: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   330: aload 13
    //   332: invokevirtual 192	java/lang/Process:destroy	()V
    //   335: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   338: iconst_1
    //   339: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   342: iconst_0
    //   343: ifeq +11 -> 354
    //   346: new 197	java/lang/NullPointerException
    //   349: dup
    //   350: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   353: athrow
    //   354: iconst_0
    //   355: ifeq +11 -> 366
    //   358: new 197	java/lang/NullPointerException
    //   361: dup
    //   362: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   365: athrow
    //   366: iconst_0
    //   367: ifeq -343 -> 24
    //   370: new 197	java/lang/NullPointerException
    //   373: dup
    //   374: invokespecial 198	java/lang/NullPointerException:<init>	()V
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
    //   412: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   415: aload 12
    //   417: astore 11
    //   419: aload_1
    //   420: astore 10
    //   422: aload_0
    //   423: astore 9
    //   425: new 130	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   432: ldc 203
    //   434: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload 13
    //   439: invokevirtual 204	java/io/IOException:toString	()Ljava/lang/String;
    //   442: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   451: aload_0
    //   452: ifnull +7 -> 459
    //   455: aload_0
    //   456: invokevirtual 209	java/io/InputStream:close	()V
    //   459: aload_1
    //   460: ifnull +7 -> 467
    //   463: aload_1
    //   464: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   467: iload 4
    //   469: istore_3
    //   470: aload 12
    //   472: ifnull +11 -> 483
    //   475: aload 12
    //   477: invokevirtual 215	java/io/BufferedReader:close	()V
    //   480: iload 4
    //   482: istore_3
    //   483: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   486: lstore 5
    //   488: new 130	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   495: ldc 217
    //   497: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: lload 5
    //   502: lload 7
    //   504: lsub
    //   505: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   508: ldc 222
    //   510: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: iload_3
    //   514: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   517: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   523: iload_3
    //   524: ifeq +46 -> 570
    //   527: new 128	java/io/File
    //   530: dup
    //   531: aload_2
    //   532: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   535: astore_0
    //   536: aload_0
    //   537: invokevirtual 143	java/io/File:exists	()Z
    //   540: ifeq +30 -> 570
    //   543: aload_0
    //   544: invokevirtual 228	java/io/File:delete	()Z
    //   547: pop
    //   548: new 130	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   555: ldc 230
    //   557: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: iload_3
    //   561: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   564: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   570: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   573: iconst_1
    //   574: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   577: iload_3
    //   578: ireturn
    //   579: aload 13
    //   581: invokevirtual 234	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   584: astore_0
    //   585: new 211	java/io/InputStreamReader
    //   588: dup
    //   589: aload_0
    //   590: invokespecial 237	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   593: astore_1
    //   594: new 214	java/io/BufferedReader
    //   597: dup
    //   598: aload_1
    //   599: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   602: astore 12
    //   604: aload 12
    //   606: astore 11
    //   608: aload_1
    //   609: astore 10
    //   611: aload_0
    //   612: astore 9
    //   614: aload 13
    //   616: invokevirtual 243	java/lang/Process:waitFor	()I
    //   619: pop
    //   620: aload 12
    //   622: astore 11
    //   624: aload_1
    //   625: astore 10
    //   627: aload_0
    //   628: astore 9
    //   630: aload 13
    //   632: invokevirtual 246	java/lang/Process:exitValue	()I
    //   635: istore 4
    //   637: aload 12
    //   639: astore 11
    //   641: aload_1
    //   642: astore 10
    //   644: aload_0
    //   645: astore 9
    //   647: new 130	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   654: ldc 248
    //   656: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: iload 4
    //   661: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   664: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   670: aload 12
    //   672: astore 11
    //   674: aload_1
    //   675: astore 10
    //   677: aload_0
    //   678: astore 9
    //   680: aload 12
    //   682: invokevirtual 251	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   685: astore 14
    //   687: aload 14
    //   689: ifnull +39 -> 728
    //   692: aload 12
    //   694: astore 11
    //   696: aload_1
    //   697: astore 10
    //   699: aload_0
    //   700: astore 9
    //   702: new 130	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   709: ldc 253
    //   711: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload 14
    //   716: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   725: goto -55 -> 670
    //   728: aload 12
    //   730: astore 11
    //   732: aload_1
    //   733: astore 10
    //   735: aload_0
    //   736: astore 9
    //   738: aload 13
    //   740: invokevirtual 192	java/lang/Process:destroy	()V
    //   743: aload 12
    //   745: astore 11
    //   747: aload_1
    //   748: astore 10
    //   750: aload_0
    //   751: astore 9
    //   753: getstatic 54	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   756: astore 14
    //   758: aload 12
    //   760: astore 11
    //   762: aload_1
    //   763: astore 10
    //   765: aload_0
    //   766: astore 9
    //   768: aload 14
    //   770: monitorenter
    //   771: aconst_null
    //   772: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   775: aload 14
    //   777: monitorexit
    //   778: aload 12
    //   780: astore 11
    //   782: aload_1
    //   783: astore 10
    //   785: aload_0
    //   786: astore 9
    //   788: ldc 255
    //   790: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   793: aload_0
    //   794: ifnull +7 -> 801
    //   797: aload_0
    //   798: invokevirtual 209	java/io/InputStream:close	()V
    //   801: aload_1
    //   802: ifnull +7 -> 809
    //   805: aload_1
    //   806: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   809: iload 4
    //   811: istore_3
    //   812: aload 12
    //   814: ifnull -331 -> 483
    //   817: aload 12
    //   819: invokevirtual 215	java/io/BufferedReader:close	()V
    //   822: iload 4
    //   824: istore_3
    //   825: goto -342 -> 483
    //   828: astore_0
    //   829: iload 4
    //   831: istore_3
    //   832: goto -349 -> 483
    //   835: astore 13
    //   837: aload 14
    //   839: monitorexit
    //   840: aload 12
    //   842: astore 11
    //   844: aload_1
    //   845: astore 10
    //   847: aload_0
    //   848: astore 9
    //   850: aload 13
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
    //   872: invokevirtual 256	java/lang/InterruptedException:printStackTrace	()V
    //   875: aload 12
    //   877: astore 11
    //   879: aload_1
    //   880: astore 10
    //   882: aload_0
    //   883: astore 9
    //   885: new 130	java/lang/StringBuilder
    //   888: dup
    //   889: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   892: ldc_w 258
    //   895: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: aload 13
    //   900: invokevirtual 259	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   903: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   912: aload_0
    //   913: ifnull +7 -> 920
    //   916: aload_0
    //   917: invokevirtual 209	java/io/InputStream:close	()V
    //   920: aload_1
    //   921: ifnull +7 -> 928
    //   924: aload_1
    //   925: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   928: iload 4
    //   930: istore_3
    //   931: aload 12
    //   933: ifnull -450 -> 483
    //   936: aload 12
    //   938: invokevirtual 215	java/io/BufferedReader:close	()V
    //   941: iload 4
    //   943: istore_3
    //   944: goto -461 -> 483
    //   947: astore_0
    //   948: iload 4
    //   950: istore_3
    //   951: goto -468 -> 483
    //   954: astore 13
    //   956: aconst_null
    //   957: astore_0
    //   958: aconst_null
    //   959: astore_1
    //   960: aconst_null
    //   961: astore 12
    //   963: sipush -1003
    //   966: istore 4
    //   968: aload 12
    //   970: astore 11
    //   972: aload_1
    //   973: astore 10
    //   975: aload_0
    //   976: astore 9
    //   978: aload 13
    //   980: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   983: aload 12
    //   985: astore 11
    //   987: aload_1
    //   988: astore 10
    //   990: aload_0
    //   991: astore 9
    //   993: new 130	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1000: ldc_w 262
    //   1003: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: aload 13
    //   1008: invokevirtual 263	java/lang/Exception:toString	()Ljava/lang/String;
    //   1011: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1017: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   1020: aload_0
    //   1021: ifnull +7 -> 1028
    //   1024: aload_0
    //   1025: invokevirtual 209	java/io/InputStream:close	()V
    //   1028: aload_1
    //   1029: ifnull +7 -> 1036
    //   1032: aload_1
    //   1033: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   1036: iload 4
    //   1038: istore_3
    //   1039: aload 12
    //   1041: ifnull -558 -> 483
    //   1044: aload 12
    //   1046: invokevirtual 215	java/io/BufferedReader:close	()V
    //   1049: iload 4
    //   1051: istore_3
    //   1052: goto -569 -> 483
    //   1055: astore_0
    //   1056: iload 4
    //   1058: istore_3
    //   1059: goto -576 -> 483
    //   1062: astore_1
    //   1063: aconst_null
    //   1064: astore_0
    //   1065: aload 9
    //   1067: astore_2
    //   1068: aload_0
    //   1069: ifnull +7 -> 1076
    //   1072: aload_0
    //   1073: invokevirtual 209	java/io/InputStream:close	()V
    //   1076: aload_2
    //   1077: ifnull +7 -> 1084
    //   1080: aload_2
    //   1081: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   1084: aload 10
    //   1086: ifnull +8 -> 1094
    //   1089: aload 10
    //   1091: invokevirtual 215	java/io/BufferedReader:close	()V
    //   1094: aload_1
    //   1095: athrow
    //   1096: astore_0
    //   1097: goto -527 -> 570
    //   1100: astore_0
    //   1101: goto -7 -> 1094
    //   1104: astore_1
    //   1105: aload 9
    //   1107: astore_2
    //   1108: goto -40 -> 1068
    //   1111: astore 9
    //   1113: aload_1
    //   1114: astore_2
    //   1115: aload 9
    //   1117: astore_1
    //   1118: goto -50 -> 1068
    //   1121: astore_1
    //   1122: aload 10
    //   1124: astore_2
    //   1125: aload 11
    //   1127: astore 10
    //   1129: aload 9
    //   1131: astore_0
    //   1132: goto -64 -> 1068
    //   1135: astore 13
    //   1137: aconst_null
    //   1138: astore_1
    //   1139: aconst_null
    //   1140: astore 12
    //   1142: goto -179 -> 963
    //   1145: astore 13
    //   1147: aconst_null
    //   1148: astore 12
    //   1150: goto -187 -> 963
    //   1153: astore 13
    //   1155: goto -192 -> 963
    //   1158: astore 13
    //   1160: aconst_null
    //   1161: astore_0
    //   1162: aconst_null
    //   1163: astore_1
    //   1164: aconst_null
    //   1165: astore 12
    //   1167: goto -312 -> 855
    //   1170: astore 13
    //   1172: aconst_null
    //   1173: astore_1
    //   1174: aconst_null
    //   1175: astore 12
    //   1177: goto -322 -> 855
    //   1180: astore 13
    //   1182: aconst_null
    //   1183: astore 12
    //   1185: goto -330 -> 855
    //   1188: astore_0
    //   1189: iload 4
    //   1191: istore_3
    //   1192: goto -709 -> 483
    //   1195: astore 13
    //   1197: aconst_null
    //   1198: astore_1
    //   1199: aconst_null
    //   1200: astore 12
    //   1202: goto -807 -> 395
    //   1205: astore 13
    //   1207: aconst_null
    //   1208: astore 12
    //   1210: goto -815 -> 395
    //   1213: astore 13
    //   1215: goto -820 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1218	0	paramContext	Context
    //   0	1218	1	paramString1	String
    //   0	1218	2	paramString2	String
    //   197	995	3	i	int
    //   194	996	4	j	int
    //   486	15	5	l1	long
    //   3	500	7	l2	long
    //   9	1097	9	localObject1	Object
    //   1111	19	9	localObject2	Object
    //   101	1027	10	localObject3	Object
    //   114	1012	11	localObject4	Object
    //   50	1159	12	localObject5	Object
    //   130	201	13	localObject6	Object
    //   386	353	13	localIOException1	java.io.IOException
    //   835	16	13	localObject7	Object
    //   853	46	13	localInterruptedException1	java.lang.InterruptedException
    //   954	53	13	localException1	Exception
    //   1135	1	13	localException2	Exception
    //   1145	1	13	localException3	Exception
    //   1153	1	13	localException4	Exception
    //   1158	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1170	1	13	localInterruptedException3	java.lang.InterruptedException
    //   1180	1	13	localInterruptedException4	java.lang.InterruptedException
    //   1195	1	13	localIOException2	java.io.IOException
    //   1205	1	13	localIOException3	java.io.IOException
    //   1213	1	13	localIOException4	java.io.IOException
    //   685	153	14	localObject8	Object
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
    //   916	920	947	java/io/IOException
    //   924	928	947	java/io/IOException
    //   936	941	947	java/io/IOException
    //   103	196	954	java/lang/Exception
    //   204	215	954	java/lang/Exception
    //   222	310	954	java/lang/Exception
    //   317	342	954	java/lang/Exception
    //   384	386	954	java/lang/Exception
    //   579	585	954	java/lang/Exception
    //   1024	1028	1055	java/io/IOException
    //   1032	1036	1055	java/io/IOException
    //   1044	1049	1055	java/io/IOException
    //   103	196	1062	finally
    //   204	215	1062	finally
    //   222	310	1062	finally
    //   317	342	1062	finally
    //   384	386	1062	finally
    //   579	585	1062	finally
    //   527	570	1096	java/lang/Exception
    //   1072	1076	1100	java/io/IOException
    //   1080	1084	1100	java/io/IOException
    //   1089	1094	1100	java/io/IOException
    //   585	594	1104	finally
    //   594	604	1111	finally
    //   410	415	1121	finally
    //   425	451	1121	finally
    //   614	620	1121	finally
    //   630	637	1121	finally
    //   647	670	1121	finally
    //   680	687	1121	finally
    //   702	725	1121	finally
    //   738	743	1121	finally
    //   753	758	1121	finally
    //   768	771	1121	finally
    //   788	793	1121	finally
    //   850	853	1121	finally
    //   870	875	1121	finally
    //   885	912	1121	finally
    //   978	983	1121	finally
    //   993	1020	1121	finally
    //   585	594	1135	java/lang/Exception
    //   594	604	1145	java/lang/Exception
    //   614	620	1153	java/lang/Exception
    //   630	637	1153	java/lang/Exception
    //   647	670	1153	java/lang/Exception
    //   680	687	1153	java/lang/Exception
    //   702	725	1153	java/lang/Exception
    //   738	743	1153	java/lang/Exception
    //   753	758	1153	java/lang/Exception
    //   768	771	1153	java/lang/Exception
    //   788	793	1153	java/lang/Exception
    //   850	853	1153	java/lang/Exception
    //   103	196	1158	java/lang/InterruptedException
    //   204	215	1158	java/lang/InterruptedException
    //   222	310	1158	java/lang/InterruptedException
    //   317	342	1158	java/lang/InterruptedException
    //   384	386	1158	java/lang/InterruptedException
    //   579	585	1158	java/lang/InterruptedException
    //   585	594	1170	java/lang/InterruptedException
    //   594	604	1180	java/lang/InterruptedException
    //   455	459	1188	java/io/IOException
    //   463	467	1188	java/io/IOException
    //   475	480	1188	java/io/IOException
    //   585	594	1195	java/io/IOException
    //   594	604	1205	java/io/IOException
    //   614	620	1213	java/io/IOException
    //   630	637	1213	java/io/IOException
    //   647	670	1213	java/io/IOException
    //   680	687	1213	java/io/IOException
    //   702	725	1213	java/io/IOException
    //   738	743	1213	java/io/IOException
    //   753	758	1213	java/io/IOException
    //   768	771	1213	java/io/IOException
    //   788	793	1213	java/io/IOException
    //   850	853	1213	java/io/IOException
  }
  
  /* Error */
  public static int compressVideoNew(Context paramContext, String paramString1, String paramString2, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, ShortVideoTrimmer.ProcessCallBack paramProcessCallBack, bbrv parambbrv, bbrx parambbrx)
  {
    // Byte code:
    //   0: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   3: lstore 11
    //   5: new 101	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig
    //   8: dup
    //   9: invokespecial 266	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: iconst_1
    //   15: putfield 104	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:isNeedCompress	Z
    //   18: aload_3
    //   19: aload 6
    //   21: getfield 271	bbrx:c	I
    //   24: invokestatic 275	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: putfield 278	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:rotate	Ljava/lang/String;
    //   30: aload_3
    //   31: aload 6
    //   33: getfield 281	bbrx:jdField_a_of_type_Int	I
    //   36: putfield 284	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:srcWidth	I
    //   39: aload_3
    //   40: aload 6
    //   42: getfield 287	bbrx:jdField_b_of_type_Int	I
    //   45: putfield 290	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:srcHeight	I
    //   48: aload_3
    //   49: aload 6
    //   51: getfield 292	bbrx:d	I
    //   54: i2l
    //   55: putfield 295	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:duration	J
    //   58: aload_3
    //   59: aload 5
    //   61: getfield 298	bbrv:jdField_a_of_type_Int	I
    //   64: putfield 301	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:destWidth	I
    //   67: aload_3
    //   68: aload 5
    //   70: getfield 302	bbrv:jdField_b_of_type_Int	I
    //   73: putfield 305	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:destHeight	I
    //   76: aload_3
    //   77: bipush 25
    //   79: putfield 308	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:destQmax	I
    //   82: aload_3
    //   83: aload 5
    //   85: getfield 310	bbrv:jdField_b_of_type_Long	J
    //   88: putfield 313	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:desFrameRate	J
    //   91: aload_3
    //   92: aload 5
    //   94: getfield 315	bbrv:jdField_a_of_type_Long	J
    //   97: putfield 318	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:destBitrate	J
    //   100: aload_3
    //   101: getfield 104	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:isNeedCompress	Z
    //   104: ifne +10 -> 114
    //   107: ldc 106
    //   109: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   112: iconst_m1
    //   113: ireturn
    //   114: aload_1
    //   115: aload_2
    //   116: aload_3
    //   117: invokestatic 321	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:generateCommandNew	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;)[Ljava/lang/String;
    //   120: astore 6
    //   122: aload 6
    //   124: ifnonnull +11 -> 135
    //   127: ldc 114
    //   129: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   132: bipush 254
    //   134: ireturn
    //   135: aload_0
    //   136: invokestatic 120	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   139: astore 13
    //   141: invokestatic 126	com/tencent/mobileqq/shortvideo/VideoEnvironment:getShortVideoSoLibName	()Ljava/lang/String;
    //   144: astore_0
    //   145: getstatic 76	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:VIDEO_COMPRESS_TEST_ENV	Z
    //   148: ifne +38 -> 186
    //   151: new 128	java/io/File
    //   154: dup
    //   155: new 130	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   162: aload 13
    //   164: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   177: invokevirtual 143	java/io/File:exists	()Z
    //   180: ifne +6 -> 186
    //   183: bipush 253
    //   185: ireturn
    //   186: aconst_null
    //   187: astore_1
    //   188: aconst_null
    //   189: astore 5
    //   191: aconst_null
    //   192: astore_3
    //   193: new 145	java/lang/ProcessBuilder
    //   196: dup
    //   197: iconst_0
    //   198: anewarray 147	java/lang/String
    //   201: invokespecial 150	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   204: astore 14
    //   206: aload 14
    //   208: iconst_1
    //   209: invokevirtual 154	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   212: pop
    //   213: new 156	java/util/ArrayList
    //   216: dup
    //   217: invokespecial 157	java/util/ArrayList:<init>	()V
    //   220: astore 15
    //   222: aload 15
    //   224: new 130	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   231: aload 13
    //   233: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc 28
    //   238: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokeinterface 163 2 0
    //   249: pop
    //   250: new 130	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   257: ldc 165
    //   259: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 15
    //   264: iconst_0
    //   265: invokeinterface 169 2 0
    //   270: checkcast 147	java/lang/String
    //   273: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
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
    //   304: invokeinterface 163 2 0
    //   309: pop
    //   310: iload 7
    //   312: iconst_1
    //   313: iadd
    //   314: istore 7
    //   316: goto -26 -> 290
    //   319: aload 15
    //   321: new 130	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   328: aload 13
    //   330: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokeinterface 163 2 0
    //   345: pop
    //   346: aload 14
    //   348: aload 15
    //   350: invokevirtual 173	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   353: pop
    //   354: new 130	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   361: ldc 175
    //   363: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 15
    //   368: aload 15
    //   370: invokeinterface 179 1 0
    //   375: iconst_1
    //   376: isub
    //   377: invokeinterface 169 2 0
    //   382: checkcast 147	java/lang/String
    //   385: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   394: aload 14
    //   396: invokevirtual 183	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   399: astore 14
    //   401: getstatic 54	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   404: astore_0
    //   405: aload_0
    //   406: monitorenter
    //   407: aload 14
    //   409: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   412: aload_0
    //   413: monitorexit
    //   414: aload 4
    //   416: ifnull +13 -> 429
    //   419: aload 4
    //   421: getstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   424: invokeinterface 327 2 0
    //   429: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   432: invokevirtual 187	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   435: ifne +274 -> 709
    //   438: aload 4
    //   440: ifnull +10 -> 450
    //   443: aload 4
    //   445: invokeinterface 330 1 0
    //   450: aconst_null
    //   451: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   454: aload 14
    //   456: invokevirtual 192	java/lang/Process:destroy	()V
    //   459: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   462: iconst_1
    //   463: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   466: iconst_0
    //   467: ifeq +11 -> 478
    //   470: new 197	java/lang/NullPointerException
    //   473: dup
    //   474: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   477: athrow
    //   478: iconst_0
    //   479: ifeq +11 -> 490
    //   482: new 197	java/lang/NullPointerException
    //   485: dup
    //   486: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   489: athrow
    //   490: iconst_0
    //   491: ifeq -379 -> 112
    //   494: new 197	java/lang/NullPointerException
    //   497: dup
    //   498: invokespecial 198	java/lang/NullPointerException:<init>	()V
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
    //   537: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   540: aload 4
    //   542: astore 6
    //   544: aload_1
    //   545: astore 5
    //   547: aload_0
    //   548: astore_3
    //   549: new 130	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   556: ldc 203
    //   558: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload 14
    //   563: invokevirtual 204	java/io/IOException:toString	()Ljava/lang/String;
    //   566: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   575: aload_0
    //   576: ifnull +7 -> 583
    //   579: aload_0
    //   580: invokevirtual 209	java/io/InputStream:close	()V
    //   583: aload_1
    //   584: ifnull +7 -> 591
    //   587: aload_1
    //   588: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   591: iload 8
    //   593: istore 7
    //   595: aload 4
    //   597: ifnull +12 -> 609
    //   600: aload 4
    //   602: invokevirtual 215	java/io/BufferedReader:close	()V
    //   605: iload 8
    //   607: istore 7
    //   609: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   612: lstore 9
    //   614: new 130	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   621: ldc 217
    //   623: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: lload 9
    //   628: lload 11
    //   630: lsub
    //   631: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   634: ldc 222
    //   636: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: iload 7
    //   641: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   644: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   650: iload 7
    //   652: ifeq +47 -> 699
    //   655: new 128	java/io/File
    //   658: dup
    //   659: aload_2
    //   660: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   663: astore_0
    //   664: aload_0
    //   665: invokevirtual 143	java/io/File:exists	()Z
    //   668: ifeq +31 -> 699
    //   671: aload_0
    //   672: invokevirtual 228	java/io/File:delete	()Z
    //   675: pop
    //   676: new 130	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   683: ldc 230
    //   685: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: iload 7
    //   690: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   693: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   699: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   702: iconst_1
    //   703: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   706: iload 7
    //   708: ireturn
    //   709: aload 14
    //   711: invokevirtual 234	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   714: astore_0
    //   715: new 211	java/io/InputStreamReader
    //   718: dup
    //   719: aload_0
    //   720: invokespecial 237	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   723: astore_1
    //   724: new 214	java/io/BufferedReader
    //   727: dup
    //   728: aload_1
    //   729: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   732: astore 13
    //   734: aload 13
    //   736: astore 6
    //   738: aload_1
    //   739: astore 5
    //   741: aload_0
    //   742: astore_3
    //   743: aload 14
    //   745: invokevirtual 243	java/lang/Process:waitFor	()I
    //   748: pop
    //   749: aload 13
    //   751: astore 6
    //   753: aload_1
    //   754: astore 5
    //   756: aload_0
    //   757: astore_3
    //   758: aload 14
    //   760: invokevirtual 246	java/lang/Process:exitValue	()I
    //   763: istore 8
    //   765: aload 13
    //   767: astore 6
    //   769: aload_1
    //   770: astore 5
    //   772: aload_0
    //   773: astore_3
    //   774: new 130	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   781: ldc 248
    //   783: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: iload 8
    //   788: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   791: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   797: aload 13
    //   799: astore 6
    //   801: aload_1
    //   802: astore 5
    //   804: aload_0
    //   805: astore_3
    //   806: aload 13
    //   808: invokevirtual 251	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   811: astore 15
    //   813: aload 15
    //   815: ifnull +38 -> 853
    //   818: aload 13
    //   820: astore 6
    //   822: aload_1
    //   823: astore 5
    //   825: aload_0
    //   826: astore_3
    //   827: new 130	java/lang/StringBuilder
    //   830: dup
    //   831: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   834: ldc 253
    //   836: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: aload 15
    //   841: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   850: goto -53 -> 797
    //   853: aload 13
    //   855: astore 6
    //   857: aload_1
    //   858: astore 5
    //   860: aload_0
    //   861: astore_3
    //   862: aload 14
    //   864: invokevirtual 192	java/lang/Process:destroy	()V
    //   867: aload 4
    //   869: ifnull +19 -> 888
    //   872: aload 13
    //   874: astore 6
    //   876: aload_1
    //   877: astore 5
    //   879: aload_0
    //   880: astore_3
    //   881: aload 4
    //   883: invokeinterface 333 1 0
    //   888: aload 13
    //   890: astore 6
    //   892: aload_1
    //   893: astore 5
    //   895: aload_0
    //   896: astore_3
    //   897: getstatic 54	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   900: astore 14
    //   902: aload 13
    //   904: astore 6
    //   906: aload_1
    //   907: astore 5
    //   909: aload_0
    //   910: astore_3
    //   911: aload 14
    //   913: monitorenter
    //   914: aconst_null
    //   915: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   918: aload 14
    //   920: monitorexit
    //   921: aload 13
    //   923: astore 6
    //   925: aload_1
    //   926: astore 5
    //   928: aload_0
    //   929: astore_3
    //   930: ldc 255
    //   932: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   935: aload_0
    //   936: ifnull +7 -> 943
    //   939: aload_0
    //   940: invokevirtual 209	java/io/InputStream:close	()V
    //   943: aload_1
    //   944: ifnull +7 -> 951
    //   947: aload_1
    //   948: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   951: iload 8
    //   953: istore 7
    //   955: aload 13
    //   957: ifnull -348 -> 609
    //   960: aload 13
    //   962: invokevirtual 215	java/io/BufferedReader:close	()V
    //   965: iload 8
    //   967: istore 7
    //   969: goto -360 -> 609
    //   972: astore_0
    //   973: iload 8
    //   975: istore 7
    //   977: goto -368 -> 609
    //   980: astore 4
    //   982: aload 14
    //   984: monitorexit
    //   985: aload 13
    //   987: astore 6
    //   989: aload_1
    //   990: astore 5
    //   992: aload_0
    //   993: astore_3
    //   994: aload 4
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
    //   1021: invokevirtual 256	java/lang/InterruptedException:printStackTrace	()V
    //   1024: aload 4
    //   1026: astore 6
    //   1028: aload_1
    //   1029: astore 5
    //   1031: aload_0
    //   1032: astore_3
    //   1033: new 130	java/lang/StringBuilder
    //   1036: dup
    //   1037: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1040: ldc_w 258
    //   1043: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: aload 13
    //   1048: invokevirtual 259	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   1051: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   1060: aload_0
    //   1061: ifnull +7 -> 1068
    //   1064: aload_0
    //   1065: invokevirtual 209	java/io/InputStream:close	()V
    //   1068: aload_1
    //   1069: ifnull +7 -> 1076
    //   1072: aload_1
    //   1073: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   1076: iload 8
    //   1078: istore 7
    //   1080: aload 4
    //   1082: ifnull -473 -> 609
    //   1085: aload 4
    //   1087: invokevirtual 215	java/io/BufferedReader:close	()V
    //   1090: iload 8
    //   1092: istore 7
    //   1094: goto -485 -> 609
    //   1097: astore_0
    //   1098: iload 8
    //   1100: istore 7
    //   1102: goto -493 -> 609
    //   1105: astore 14
    //   1107: aconst_null
    //   1108: astore_0
    //   1109: aconst_null
    //   1110: astore_1
    //   1111: aconst_null
    //   1112: astore 4
    //   1114: sipush -1003
    //   1117: istore 8
    //   1119: aload 4
    //   1121: astore 6
    //   1123: aload_1
    //   1124: astore 5
    //   1126: aload_0
    //   1127: astore_3
    //   1128: aload 14
    //   1130: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   1133: aload 4
    //   1135: astore 6
    //   1137: aload_1
    //   1138: astore 5
    //   1140: aload_0
    //   1141: astore_3
    //   1142: new 130	java/lang/StringBuilder
    //   1145: dup
    //   1146: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1149: ldc_w 262
    //   1152: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: aload 14
    //   1157: invokevirtual 263	java/lang/Exception:toString	()Ljava/lang/String;
    //   1160: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1166: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   1169: aload_0
    //   1170: ifnull +7 -> 1177
    //   1173: aload_0
    //   1174: invokevirtual 209	java/io/InputStream:close	()V
    //   1177: aload_1
    //   1178: ifnull +7 -> 1185
    //   1181: aload_1
    //   1182: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   1185: iload 8
    //   1187: istore 7
    //   1189: aload 4
    //   1191: ifnull -582 -> 609
    //   1194: aload 4
    //   1196: invokevirtual 215	java/io/BufferedReader:close	()V
    //   1199: iload 8
    //   1201: istore 7
    //   1203: goto -594 -> 609
    //   1206: astore_0
    //   1207: iload 8
    //   1209: istore 7
    //   1211: goto -602 -> 609
    //   1214: astore_0
    //   1215: aload 5
    //   1217: astore_2
    //   1218: aload_1
    //   1219: ifnull +7 -> 1226
    //   1222: aload_1
    //   1223: invokevirtual 209	java/io/InputStream:close	()V
    //   1226: aload_2
    //   1227: ifnull +7 -> 1234
    //   1230: aload_2
    //   1231: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   1234: aload_3
    //   1235: ifnull +7 -> 1242
    //   1238: aload_3
    //   1239: invokevirtual 215	java/io/BufferedReader:close	()V
    //   1242: aload_0
    //   1243: athrow
    //   1244: astore_0
    //   1245: goto -546 -> 699
    //   1248: astore_1
    //   1249: goto -7 -> 1242
    //   1252: astore_2
    //   1253: aload_0
    //   1254: astore_1
    //   1255: aload_2
    //   1256: astore_0
    //   1257: aload 5
    //   1259: astore_2
    //   1260: goto -42 -> 1218
    //   1263: astore 4
    //   1265: aload_1
    //   1266: astore_2
    //   1267: aload_0
    //   1268: astore_1
    //   1269: aload 4
    //   1271: astore_0
    //   1272: goto -54 -> 1218
    //   1275: astore_0
    //   1276: aload 5
    //   1278: astore_2
    //   1279: aload_3
    //   1280: astore_1
    //   1281: aload 6
    //   1283: astore_3
    //   1284: goto -66 -> 1218
    //   1287: astore 14
    //   1289: aconst_null
    //   1290: astore_1
    //   1291: aconst_null
    //   1292: astore 4
    //   1294: goto -180 -> 1114
    //   1297: astore 14
    //   1299: aconst_null
    //   1300: astore 4
    //   1302: goto -188 -> 1114
    //   1305: astore 14
    //   1307: aload 13
    //   1309: astore 4
    //   1311: goto -197 -> 1114
    //   1314: astore 13
    //   1316: aconst_null
    //   1317: astore_0
    //   1318: aconst_null
    //   1319: astore_1
    //   1320: aconst_null
    //   1321: astore 4
    //   1323: goto -318 -> 1005
    //   1326: astore 13
    //   1328: aconst_null
    //   1329: astore_1
    //   1330: aconst_null
    //   1331: astore 4
    //   1333: goto -328 -> 1005
    //   1336: astore 13
    //   1338: aconst_null
    //   1339: astore 4
    //   1341: goto -336 -> 1005
    //   1344: astore_0
    //   1345: iload 8
    //   1347: istore 7
    //   1349: goto -740 -> 609
    //   1352: astore 14
    //   1354: aconst_null
    //   1355: astore_1
    //   1356: aconst_null
    //   1357: astore 4
    //   1359: goto -838 -> 521
    //   1362: astore 14
    //   1364: aconst_null
    //   1365: astore 4
    //   1367: goto -846 -> 521
    //   1370: astore 14
    //   1372: aload 13
    //   1374: astore 4
    //   1376: goto -855 -> 521
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1379	0	paramContext	Context
    //   0	1379	1	paramString1	String
    //   0	1379	2	paramString2	String
    //   0	1379	3	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1379	4	paramProcessCallBack	ShortVideoTrimmer.ProcessCallBack
    //   0	1379	5	parambbrv	bbrv
    //   0	1379	6	parambbrx	bbrx
    //   288	1060	7	i	int
    //   285	1061	8	j	int
    //   612	15	9	l1	long
    //   3	626	11	l2	long
    //   139	1169	13	localObject1	Object
    //   1314	1	13	localInterruptedException1	java.lang.InterruptedException
    //   1326	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1336	37	13	localInterruptedException3	java.lang.InterruptedException
    //   204	251	14	localObject2	Object
    //   512	351	14	localIOException1	java.io.IOException
    //   900	83	14	localObject3	Object
    //   1105	51	14	localException1	Exception
    //   1287	1	14	localException2	Exception
    //   1297	1	14	localException3	Exception
    //   1305	1	14	localException4	Exception
    //   1352	1	14	localIOException2	java.io.IOException
    //   1362	1	14	localIOException3	java.io.IOException
    //   1370	1	14	localIOException4	java.io.IOException
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
    //   1064	1068	1097	java/io/IOException
    //   1072	1076	1097	java/io/IOException
    //   1085	1090	1097	java/io/IOException
    //   193	287	1105	java/lang/Exception
    //   297	310	1105	java/lang/Exception
    //   319	407	1105	java/lang/Exception
    //   419	429	1105	java/lang/Exception
    //   429	438	1105	java/lang/Exception
    //   443	450	1105	java/lang/Exception
    //   450	466	1105	java/lang/Exception
    //   509	512	1105	java/lang/Exception
    //   709	715	1105	java/lang/Exception
    //   1173	1177	1206	java/io/IOException
    //   1181	1185	1206	java/io/IOException
    //   1194	1199	1206	java/io/IOException
    //   193	287	1214	finally
    //   297	310	1214	finally
    //   319	407	1214	finally
    //   419	429	1214	finally
    //   429	438	1214	finally
    //   443	450	1214	finally
    //   450	466	1214	finally
    //   509	512	1214	finally
    //   709	715	1214	finally
    //   655	699	1244	java/lang/Exception
    //   1222	1226	1248	java/io/IOException
    //   1230	1234	1248	java/io/IOException
    //   1238	1242	1248	java/io/IOException
    //   715	724	1252	finally
    //   724	734	1263	finally
    //   535	540	1275	finally
    //   549	575	1275	finally
    //   743	749	1275	finally
    //   758	765	1275	finally
    //   774	797	1275	finally
    //   806	813	1275	finally
    //   827	850	1275	finally
    //   862	867	1275	finally
    //   881	888	1275	finally
    //   897	902	1275	finally
    //   911	914	1275	finally
    //   930	935	1275	finally
    //   994	997	1275	finally
    //   1019	1024	1275	finally
    //   1033	1060	1275	finally
    //   1128	1133	1275	finally
    //   1142	1169	1275	finally
    //   715	724	1287	java/lang/Exception
    //   724	734	1297	java/lang/Exception
    //   743	749	1305	java/lang/Exception
    //   758	765	1305	java/lang/Exception
    //   774	797	1305	java/lang/Exception
    //   806	813	1305	java/lang/Exception
    //   827	850	1305	java/lang/Exception
    //   862	867	1305	java/lang/Exception
    //   881	888	1305	java/lang/Exception
    //   897	902	1305	java/lang/Exception
    //   911	914	1305	java/lang/Exception
    //   930	935	1305	java/lang/Exception
    //   994	997	1305	java/lang/Exception
    //   193	287	1314	java/lang/InterruptedException
    //   297	310	1314	java/lang/InterruptedException
    //   319	407	1314	java/lang/InterruptedException
    //   419	429	1314	java/lang/InterruptedException
    //   429	438	1314	java/lang/InterruptedException
    //   443	450	1314	java/lang/InterruptedException
    //   450	466	1314	java/lang/InterruptedException
    //   509	512	1314	java/lang/InterruptedException
    //   709	715	1314	java/lang/InterruptedException
    //   715	724	1326	java/lang/InterruptedException
    //   724	734	1336	java/lang/InterruptedException
    //   579	583	1344	java/io/IOException
    //   587	591	1344	java/io/IOException
    //   600	605	1344	java/io/IOException
    //   715	724	1352	java/io/IOException
    //   724	734	1362	java/io/IOException
    //   743	749	1370	java/io/IOException
    //   758	765	1370	java/io/IOException
    //   774	797	1370	java/io/IOException
    //   806	813	1370	java/io/IOException
    //   827	850	1370	java/io/IOException
    //   862	867	1370	java/io/IOException
    //   881	888	1370	java/io/IOException
    //   897	902	1370	java/io/IOException
    //   911	914	1370	java/io/IOException
    //   930	935	1370	java/io/IOException
    //   994	997	1370	java/io/IOException
  }
  
  /* Error */
  public static boolean copyResPieAndPicBuildInMode(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 339	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   6: invokevirtual 345	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: iload_0
    //   10: invokevirtual 351	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   13: astore 4
    //   15: aload 4
    //   17: astore 5
    //   19: aload 4
    //   21: sipush 8192
    //   24: newarray byte
    //   26: aload_1
    //   27: invokestatic 355	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:readInputStreamToFile	(Ljava/io/InputStream;[BLjava/lang/String;)Z
    //   30: istore_2
    //   31: iload_2
    //   32: ifeq +136 -> 168
    //   35: aload 4
    //   37: astore 5
    //   39: new 128	java/io/File
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: iconst_1
    //   48: iconst_1
    //   49: invokevirtual 359	java/io/File:setExecutable	(ZZ)Z
    //   52: istore_3
    //   53: iload_3
    //   54: istore_2
    //   55: iload_2
    //   56: istore_3
    //   57: aload 4
    //   59: ifnull +10 -> 69
    //   62: aload 4
    //   64: invokevirtual 209	java/io/InputStream:close	()V
    //   67: iload_2
    //   68: istore_3
    //   69: iload_3
    //   70: ireturn
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   76: iload_2
    //   77: ireturn
    //   78: astore 4
    //   80: iconst_0
    //   81: istore_2
    //   82: aconst_null
    //   83: astore_1
    //   84: aload 4
    //   86: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   89: iload_2
    //   90: istore_3
    //   91: aload_1
    //   92: ifnull -23 -> 69
    //   95: aload_1
    //   96: invokevirtual 209	java/io/InputStream:close	()V
    //   99: iload_2
    //   100: ireturn
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   106: iload_2
    //   107: ireturn
    //   108: astore_1
    //   109: aload 5
    //   111: ifnull +8 -> 119
    //   114: aload 5
    //   116: invokevirtual 209	java/io/InputStream:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   128: goto -9 -> 119
    //   131: astore 4
    //   133: aload_1
    //   134: astore 5
    //   136: aload 4
    //   138: astore_1
    //   139: goto -30 -> 109
    //   142: astore 5
    //   144: iconst_0
    //   145: istore_2
    //   146: aload 4
    //   148: astore_1
    //   149: aload 5
    //   151: astore 4
    //   153: goto -69 -> 84
    //   156: astore 5
    //   158: aload 4
    //   160: astore_1
    //   161: aload 5
    //   163: astore 4
    //   165: goto -81 -> 84
    //   168: goto -113 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramInt	int
    //   0	171	1	paramString	String
    //   30	116	2	bool1	boolean
    //   52	39	3	bool2	boolean
    //   13	50	4	localInputStream	java.io.InputStream
    //   78	7	4	localException1	Exception
    //   121	3	4	localIOException	java.io.IOException
    //   131	16	4	localObject1	Object
    //   151	13	4	localException2	Exception
    //   1	134	5	localObject2	Object
    //   142	8	5	localException3	Exception
    //   156	6	5	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   62	67	71	java/io/IOException
    //   3	15	78	java/lang/Exception
    //   95	99	101	java/io/IOException
    //   3	15	108	finally
    //   19	31	108	finally
    //   39	53	108	finally
    //   114	119	121	java/io/IOException
    //   84	89	131	finally
    //   19	31	142	java/lang/Exception
    //   39	53	156	java/lang/Exception
  }
  
  private static String[] generateCommand(String paramString1, String paramString2, ShortVideoTrimmer.CompressConfig paramCompressConfig)
  {
    String str1 = "1";
    if (getCpuCores() >= 2) {
      str1 = "2";
    }
    String str2 = paramCompressConfig.destWidth + "x" + String.valueOf(paramCompressConfig.destHeight);
    PrintLog("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramCompressConfig.rotate, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(paramCompressConfig.destQmax), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  private static String[] generateCommandNew(String paramString1, String paramString2, ShortVideoTrimmer.CompressConfig paramCompressConfig)
  {
    String str1 = "1";
    if (getCpuCores() >= 2) {
      str1 = "2";
    }
    String str2 = paramCompressConfig.destWidth + "x" + String.valueOf(paramCompressConfig.destHeight);
    PrintLog("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    String str3 = paramCompressConfig.destBitrate / 1024L + "k";
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramCompressConfig.rotate, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-bufsize", "800k", "-minrate", str3, "-maxrate", str3, "-b", str3, "-r", String.valueOf(paramCompressConfig.desFrameRate), "-bufsize", "800k", "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  public static ShortVideoTrimmer.CompressConfig getCompressConfig(String paramString)
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
          ((ShortVideoTrimmer.CompressConfig)localObject).isNeedCompress = false;
          PrintLog("[@] getCompressConfig : [!file.exists]");
        }
        paramString = getVideoProperty(paramString);
        if ((paramString != null) && (paramString.length == 5) && (paramString[0] == 0)) {
          break;
        }
        ((ShortVideoTrimmer.CompressConfig)localObject).isNeedCompress = false;
        PrintLog("[@] getCompressConfig : values=" + paramString);
        if (paramString != null) {
          PrintLog("[@] getCompressConfig : values.length=" + paramString.length + " err=" + paramString[0]);
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
    localNumberFormatException.rotate = getVideoRotate(paramString[3]);
    localNumberFormatException.srcWidth = paramString[1];
    localNumberFormatException.srcHeight = paramString[2];
    int i = (int)(paramString[4] / 1000.0D + 0.5D);
    if (i == 0)
    {
      localNumberFormatException.isNeedCompress = false;
      PrintLog("[@] getCompressConfig : [sec == 0 OR video duration < 0.5 sec]");
      return localNumberFormatException;
    }
    localNumberFormatException.duration = i;
    localNumberFormatException.srcBitrate = (localFile.length() / (i * 128));
    i = Math.max(paramString[1], paramString[2]);
    if (i <= j + 60)
    {
      if (localNumberFormatException.srcBitrate > 1688L)
      {
        localNumberFormatException.isNeedCompress = true;
        localNumberFormatException.destQmax = 25;
        localNumberFormatException.destWidth = paramString[1];
        localNumberFormatException.destHeight = paramString[2];
        return localNumberFormatException;
      }
      localNumberFormatException.isNeedCompress = false;
      PrintLog("[@] getCompressConfig : [kbps > CODE_RATE] judge Failure...");
      return localNumberFormatException;
    }
    localNumberFormatException.isNeedCompress = true;
    float f = j / i;
    localNumberFormatException.destWidth = ((int)(paramString[1] * f));
    localNumberFormatException.destHeight = ((int)(f * paramString[2]));
    localNumberFormatException.destQmax = 25;
    return localNumberFormatException;
  }
  
  public static int getCpuCores()
  {
    if (sCpuCores == 0) {}
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new ShortVideoTrimmer.1CpuFilter());
      if (arrayOfFile == null) {
        return 1;
      }
      sCpuCores = arrayOfFile.length;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        sCpuCores = 1;
      }
    }
    return sCpuCores;
  }
  
  public static Process getProcess()
  {
    synchronized (lock)
    {
      Process localProcess = process;
      return localProcess;
    }
  }
  
  public static native String getRealProperties(String paramString);
  
  /* Error */
  @android.annotation.TargetApi(17)
  public static int[] getVideoProperty(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 563	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 17
    //   7: if_icmplt +130 -> 137
    //   10: new 565	android/media/MediaMetadataRetriever
    //   13: dup
    //   14: invokespecial 566	android/media/MediaMetadataRetriever:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: invokevirtual 569	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   23: aload_3
    //   24: bipush 18
    //   26: invokevirtual 572	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_3
    //   31: bipush 19
    //   33: invokevirtual 572	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_3
    //   39: bipush 24
    //   41: invokevirtual 572	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   44: astore 5
    //   46: aload_3
    //   47: bipush 9
    //   49: invokevirtual 572	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
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
    //   65: invokestatic 493	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   68: invokevirtual 496	java/lang/Integer:intValue	()I
    //   71: iastore
    //   72: aload_0
    //   73: iconst_2
    //   74: aload 4
    //   76: invokestatic 493	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   79: invokevirtual 496	java/lang/Integer:intValue	()I
    //   82: iastore
    //   83: aload_0
    //   84: iconst_3
    //   85: aload 5
    //   87: invokestatic 493	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   90: invokevirtual 496	java/lang/Integer:intValue	()I
    //   93: iastore
    //   94: aload_0
    //   95: iconst_4
    //   96: aload 6
    //   98: invokestatic 493	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   101: invokevirtual 496	java/lang/Integer:intValue	()I
    //   104: iastore
    //   105: aload_3
    //   106: invokevirtual 575	android/media/MediaMetadataRetriever:release	()V
    //   109: aload_0
    //   110: areturn
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_0
    //   114: ldc 23
    //   116: iconst_1
    //   117: ldc_w 577
    //   120: aload_2
    //   121: invokestatic 517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_3
    //   125: invokevirtual 575	android/media/MediaMetadataRetriever:release	()V
    //   128: aload_0
    //   129: areturn
    //   130: astore_0
    //   131: aload_3
    //   132: invokevirtual 575	android/media/MediaMetadataRetriever:release	()V
    //   135: aload_0
    //   136: athrow
    //   137: aload_0
    //   138: invokestatic 579	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getRealProperties	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore_0
    //   142: aload_0
    //   143: ifnull +79 -> 222
    //   146: aload_0
    //   147: ldc_w 581
    //   150: invokevirtual 488	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   153: astore_3
    //   154: aload_3
    //   155: ifnull +67 -> 222
    //   158: aload_3
    //   159: arraylength
    //   160: ifle +62 -> 222
    //   163: aload_3
    //   164: arraylength
    //   165: newarray int
    //   167: astore_2
    //   168: aload_2
    //   169: astore_0
    //   170: iload_1
    //   171: aload_3
    //   172: arraylength
    //   173: if_icmpge -64 -> 109
    //   176: aload_2
    //   177: iload_1
    //   178: aload_3
    //   179: iload_1
    //   180: aaload
    //   181: invokestatic 493	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   184: invokevirtual 496	java/lang/Integer:intValue	()I
    //   187: iastore
    //   188: iload_1
    //   189: iconst_1
    //   190: iadd
    //   191: istore_1
    //   192: goto -24 -> 168
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 582	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   200: ldc_w 584
    //   203: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   206: aconst_null
    //   207: astore_0
    //   208: goto -66 -> 142
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   216: ldc_w 586
    //   219: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_2
    //   225: goto -111 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramString	String
    //   1	191	1	i	int
    //   29	36	2	str1	String
    //   111	10	2	localException1	Exception
    //   167	10	2	arrayOfInt	int[]
    //   224	1	2	localException2	Exception
    //   17	162	3	localObject	Object
    //   36	39	4	str2	String
    //   44	42	5	str3	String
    //   52	45	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   18	58	111	java/lang/Exception
    //   18	58	130	finally
    //   62	105	130	finally
    //   114	124	130	finally
    //   137	142	195	java/lang/UnsatisfiedLinkError
    //   170	188	211	java/lang/Exception
    //   62	105	224	java/lang/Exception
  }
  
  public static String getVideoRotate(int paramInt)
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
  
  /* Error */
  @android.annotation.TargetApi(9)
  private static boolean initTrimProcessFile(Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: invokestatic 120	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore 10
    //   15: new 128	java/io/File
    //   18: dup
    //   19: aload 10
    //   21: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 9
    //   26: aload 9
    //   28: invokevirtual 143	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 9
    //   36: invokevirtual 599	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: iload_1
    //   41: ifeq +7 -> 48
    //   44: iload_2
    //   45: ifne +125 -> 170
    //   48: iconst_0
    //   49: putstatic 76	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:VIDEO_COMPRESS_TEST_ENV	Z
    //   52: getstatic 563	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 16
    //   57: if_icmplt +86 -> 143
    //   60: new 130	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   67: aload 10
    //   69: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 40
    //   74: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 9
    //   82: iconst_0
    //   83: istore_3
    //   84: new 130	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   91: aload 10
    //   93: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 28
    //   98: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore 10
    //   106: new 128	java/io/File
    //   109: dup
    //   110: aload 10
    //   112: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: invokevirtual 143	java/io/File:exists	()Z
    //   118: ifeq +80 -> 198
    //   121: getstatic 76	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:VIDEO_COMPRESS_TEST_ENV	Z
    //   124: ifne +74 -> 198
    //   127: aload 9
    //   129: aload 10
    //   131: invokestatic 603	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:trimBinMd5Judge	(Ljava/lang/String;Ljava/lang/String;)Z
    //   134: ifeq +64 -> 198
    //   137: iconst_1
    //   138: istore 4
    //   140: iload 4
    //   142: ireturn
    //   143: new 130	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   150: aload 10
    //   152: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 37
    //   157: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 9
    //   165: iconst_0
    //   166: istore_3
    //   167: goto -83 -> 84
    //   170: iconst_1
    //   171: putstatic 76	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:VIDEO_COMPRESS_TEST_ENV	Z
    //   174: getstatic 563	android/os/Build$VERSION:SDK_INT	I
    //   177: bipush 16
    //   179: if_icmplt +11 -> 190
    //   182: iload_1
    //   183: istore_3
    //   184: aconst_null
    //   185: astore 9
    //   187: goto -103 -> 84
    //   190: iload_2
    //   191: istore_3
    //   192: aconst_null
    //   193: astore 9
    //   195: goto -111 -> 84
    //   198: iload_1
    //   199: ifeq +7 -> 206
    //   202: iload_2
    //   203: ifne +140 -> 343
    //   206: new 605	java/io/FileInputStream
    //   209: dup
    //   210: aload 9
    //   212: invokespecial 606	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   215: astore_0
    //   216: ldc_w 608
    //   219: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   222: aload_0
    //   223: astore 8
    //   225: aload_0
    //   226: astore 7
    //   228: aload_0
    //   229: sipush 8192
    //   232: newarray byte
    //   234: aload 10
    //   236: invokestatic 355	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:readInputStreamToFile	(Ljava/io/InputStream;[BLjava/lang/String;)Z
    //   239: istore 6
    //   241: aload_0
    //   242: astore 8
    //   244: aload_0
    //   245: astore 7
    //   247: new 130	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 610
    //   257: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: iload 6
    //   262: invokevirtual 613	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   265: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   271: iload 6
    //   273: istore 4
    //   275: iload 6
    //   277: ifeq +55 -> 332
    //   280: aload_0
    //   281: astore 8
    //   283: aload_0
    //   284: astore 7
    //   286: new 128	java/io/File
    //   289: dup
    //   290: aload 10
    //   292: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   295: iconst_1
    //   296: iconst_1
    //   297: invokevirtual 359	java/io/File:setExecutable	(ZZ)Z
    //   300: istore 4
    //   302: aload_0
    //   303: astore 8
    //   305: aload_0
    //   306: astore 7
    //   308: new 130	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 615
    //   318: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: iload 4
    //   323: invokevirtual 613	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   326: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   332: aload_0
    //   333: ifnull +7 -> 340
    //   336: aload_0
    //   337: invokevirtual 209	java/io/InputStream:close	()V
    //   340: iload 4
    //   342: ireturn
    //   343: aload_0
    //   344: invokevirtual 345	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   347: iload_3
    //   348: invokevirtual 351	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   351: astore_0
    //   352: aload_0
    //   353: astore 8
    //   355: aload_0
    //   356: astore 7
    //   358: ldc_w 617
    //   361: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   364: goto -142 -> 222
    //   367: astore_0
    //   368: aload 8
    //   370: astore 7
    //   372: aload_0
    //   373: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   376: aload 8
    //   378: astore 7
    //   380: new 130	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 619
    //   390: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_0
    //   394: invokevirtual 263	java/lang/Exception:toString	()Ljava/lang/String;
    //   397: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   406: iload 5
    //   408: istore 4
    //   410: aload 8
    //   412: ifnull -272 -> 140
    //   415: aload 8
    //   417: invokevirtual 209	java/io/InputStream:close	()V
    //   420: iconst_0
    //   421: ireturn
    //   422: astore_0
    //   423: aload_0
    //   424: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   427: iconst_0
    //   428: ireturn
    //   429: astore_0
    //   430: aload_0
    //   431: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   434: goto -94 -> 340
    //   437: astore_0
    //   438: aload 7
    //   440: ifnull +8 -> 448
    //   443: aload 7
    //   445: invokevirtual 209	java/io/InputStream:close	()V
    //   448: aload_0
    //   449: athrow
    //   450: astore 7
    //   452: aload 7
    //   454: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   457: goto -9 -> 448
    //   460: astore 8
    //   462: aload_0
    //   463: astore 7
    //   465: aload 8
    //   467: astore_0
    //   468: goto -30 -> 438
    //   471: astore 7
    //   473: aload_0
    //   474: astore 8
    //   476: aload 7
    //   478: astore_0
    //   479: goto -111 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	paramContext	Context
    //   0	482	1	paramInt1	int
    //   0	482	2	paramInt2	int
    //   83	265	3	i	int
    //   138	271	4	bool1	boolean
    //   7	400	5	bool2	boolean
    //   239	37	6	bool3	boolean
    //   1	443	7	localObject1	Object
    //   450	3	7	localIOException	java.io.IOException
    //   463	1	7	localContext1	Context
    //   471	6	7	localException	Exception
    //   4	412	8	localContext2	Context
    //   460	6	8	localObject2	Object
    //   474	1	8	localContext3	Context
    //   24	187	9	localObject3	Object
    //   13	278	10	str	String
    // Exception table:
    //   from	to	target	type
    //   206	216	367	java/lang/Exception
    //   228	241	367	java/lang/Exception
    //   247	271	367	java/lang/Exception
    //   286	302	367	java/lang/Exception
    //   308	332	367	java/lang/Exception
    //   343	352	367	java/lang/Exception
    //   358	364	367	java/lang/Exception
    //   415	420	422	java/io/IOException
    //   336	340	429	java/io/IOException
    //   206	216	437	finally
    //   228	241	437	finally
    //   247	271	437	finally
    //   286	302	437	finally
    //   308	332	437	finally
    //   343	352	437	finally
    //   358	364	437	finally
    //   372	376	437	finally
    //   380	406	437	finally
    //   443	448	450	java/io/IOException
    //   216	222	460	finally
    //   216	222	471	java/lang/Exception
  }
  
  public static boolean initVideoTrim(Context paramContext, int paramInt1, int paramInt2)
  {
    boolean bool2 = initTrimProcessFile(paramContext, paramInt1, paramInt2);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (VideoEnvironment.loadAVCodecSo("AVCodec", paramContext) != 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  /* Error */
  private static boolean readInputStreamToFile(java.io.InputStream paramInputStream, byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 630	java/io/FileOutputStream
    //   6: dup
    //   7: aload_2
    //   8: invokespecial 631	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
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
    //   25: invokevirtual 635	java/io/InputStream:read	([BII)I
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
    //   64: invokevirtual 639	java/io/FileOutputStream:write	([BII)V
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
    //   84: invokevirtual 639	java/io/FileOutputStream:write	([BII)V
    //   87: iconst_1
    //   88: istore 6
    //   90: iload 6
    //   92: istore 5
    //   94: aload 7
    //   96: ifnull +12 -> 108
    //   99: aload 7
    //   101: invokevirtual 640	java/io/FileOutputStream:close	()V
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
    //   117: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   120: aload_0
    //   121: ifnull -13 -> 108
    //   124: aload_0
    //   125: invokevirtual 640	java/io/FileOutputStream:close	()V
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
    //   141: invokevirtual 640	java/io/FileOutputStream:close	()V
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
  
  private static boolean trimBinMd5Judge(String paramString1, String paramString2)
  {
    if (!new File(paramString1).exists()) {}
    do
    {
      return true;
      paramString1 = MD5.getFileMd5(paramString1);
      paramString2 = MD5.getFileMd5(paramString2);
      paramString1 = HexUtil.bytes2HexStr(paramString1);
      paramString2 = HexUtil.bytes2HexStr(paramString2);
      PrintLog("[@] trimBinMd5Judge : pieMd5=" + paramString1 + "  outMd5=" + paramString2);
    } while ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer
 * JD-Core Version:    0.7.0.1
 */