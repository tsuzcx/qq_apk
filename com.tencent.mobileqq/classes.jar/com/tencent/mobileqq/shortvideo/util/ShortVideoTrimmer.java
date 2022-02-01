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
    //   3: lstore 5
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
    //   50: astore 13
    //   52: invokestatic 126	com/tencent/mobileqq/shortvideo/VideoEnvironment:getShortVideoSoLibName	()Ljava/lang/String;
    //   55: astore 11
    //   57: getstatic 76	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:VIDEO_COMPRESS_TEST_ENV	Z
    //   60: ifne +39 -> 99
    //   63: new 128	java/io/File
    //   66: dup
    //   67: new 130	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   74: aload 13
    //   76: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 11
    //   81: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: invokevirtual 143	java/io/File:exists	()Z
    //   93: ifne +6 -> 99
    //   96: bipush 253
    //   98: ireturn
    //   99: aconst_null
    //   100: astore 9
    //   102: aconst_null
    //   103: astore 10
    //   105: new 145	java/lang/ProcessBuilder
    //   108: dup
    //   109: iconst_0
    //   110: anewarray 147	java/lang/String
    //   113: invokespecial 150	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   116: astore_0
    //   117: aload_0
    //   118: iconst_1
    //   119: invokevirtual 154	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   122: pop
    //   123: new 156	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 157	java/util/ArrayList:<init>	()V
    //   130: astore 12
    //   132: aload 12
    //   134: new 130	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   141: aload 13
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
    //   172: aload 12
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
    //   204: aload 12
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
    //   222: aload 12
    //   224: new 130	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   231: aload 13
    //   233: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 11
    //   238: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokeinterface 163 2 0
    //   249: pop
    //   250: aload_0
    //   251: aload 12
    //   253: invokevirtual 173	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   256: pop
    //   257: new 130	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   264: ldc 175
    //   266: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 12
    //   271: aload 12
    //   273: invokeinterface 179 1 0
    //   278: iconst_1
    //   279: isub
    //   280: invokeinterface 169 2 0
    //   285: checkcast 147	java/lang/String
    //   288: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   297: aload_0
    //   298: invokevirtual 183	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   301: astore 13
    //   303: getstatic 54	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   306: astore_0
    //   307: aload_0
    //   308: monitorenter
    //   309: aload 13
    //   311: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   314: aload_0
    //   315: monitorexit
    //   316: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   319: invokevirtual 187	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   322: ifne +256 -> 578
    //   325: aconst_null
    //   326: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   329: aload 13
    //   331: invokevirtual 192	java/lang/Process:destroy	()V
    //   334: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   337: iconst_1
    //   338: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   341: iconst_0
    //   342: ifeq +11 -> 353
    //   345: new 197	java/lang/NullPointerException
    //   348: dup
    //   349: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   352: athrow
    //   353: iconst_0
    //   354: ifeq +11 -> 365
    //   357: new 197	java/lang/NullPointerException
    //   360: dup
    //   361: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   364: athrow
    //   365: iconst_0
    //   366: ifeq -342 -> 24
    //   369: new 197	java/lang/NullPointerException
    //   372: dup
    //   373: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   376: athrow
    //   377: astore_0
    //   378: iconst_m1
    //   379: ireturn
    //   380: astore_1
    //   381: aload_0
    //   382: monitorexit
    //   383: aload_1
    //   384: athrow
    //   385: astore 13
    //   387: aconst_null
    //   388: astore_0
    //   389: aconst_null
    //   390: astore_1
    //   391: aconst_null
    //   392: astore 12
    //   394: sipush -1001
    //   397: istore 4
    //   399: aload 12
    //   401: astore 11
    //   403: aload_1
    //   404: astore 10
    //   406: aload_0
    //   407: astore 9
    //   409: aload 13
    //   411: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   414: aload 12
    //   416: astore 11
    //   418: aload_1
    //   419: astore 10
    //   421: aload_0
    //   422: astore 9
    //   424: new 130	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   431: ldc 203
    //   433: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 13
    //   438: invokevirtual 204	java/io/IOException:toString	()Ljava/lang/String;
    //   441: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   450: aload_0
    //   451: ifnull +7 -> 458
    //   454: aload_0
    //   455: invokevirtual 209	java/io/InputStream:close	()V
    //   458: aload_1
    //   459: ifnull +7 -> 466
    //   462: aload_1
    //   463: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   466: iload 4
    //   468: istore_3
    //   469: aload 12
    //   471: ifnull +11 -> 482
    //   474: aload 12
    //   476: invokevirtual 215	java/io/BufferedReader:close	()V
    //   479: iload 4
    //   481: istore_3
    //   482: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   485: lstore 7
    //   487: new 130	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   494: ldc 217
    //   496: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: lload 7
    //   501: lload 5
    //   503: lsub
    //   504: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   507: ldc 222
    //   509: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: iload_3
    //   513: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   516: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   522: iload_3
    //   523: ifeq +46 -> 569
    //   526: new 128	java/io/File
    //   529: dup
    //   530: aload_2
    //   531: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   534: astore_0
    //   535: aload_0
    //   536: invokevirtual 143	java/io/File:exists	()Z
    //   539: ifeq +30 -> 569
    //   542: aload_0
    //   543: invokevirtual 228	java/io/File:delete	()Z
    //   546: pop
    //   547: new 130	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   554: ldc 230
    //   556: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: iload_3
    //   560: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   569: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   572: iconst_1
    //   573: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   576: iload_3
    //   577: ireturn
    //   578: aload 13
    //   580: invokevirtual 234	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   583: astore_0
    //   584: new 211	java/io/InputStreamReader
    //   587: dup
    //   588: aload_0
    //   589: invokespecial 237	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   592: astore_1
    //   593: new 214	java/io/BufferedReader
    //   596: dup
    //   597: aload_1
    //   598: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   601: astore 12
    //   603: aload 12
    //   605: astore 11
    //   607: aload_1
    //   608: astore 10
    //   610: aload_0
    //   611: astore 9
    //   613: aload 13
    //   615: invokevirtual 243	java/lang/Process:waitFor	()I
    //   618: pop
    //   619: aload 12
    //   621: astore 11
    //   623: aload_1
    //   624: astore 10
    //   626: aload_0
    //   627: astore 9
    //   629: aload 13
    //   631: invokevirtual 246	java/lang/Process:exitValue	()I
    //   634: istore 4
    //   636: aload 12
    //   638: astore 11
    //   640: aload_1
    //   641: astore 10
    //   643: aload_0
    //   644: astore 9
    //   646: new 130	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   653: ldc 248
    //   655: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: iload 4
    //   660: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   663: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   669: aload 12
    //   671: astore 11
    //   673: aload_1
    //   674: astore 10
    //   676: aload_0
    //   677: astore 9
    //   679: aload 12
    //   681: invokevirtual 251	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   684: astore 14
    //   686: aload 14
    //   688: ifnull +39 -> 727
    //   691: aload 12
    //   693: astore 11
    //   695: aload_1
    //   696: astore 10
    //   698: aload_0
    //   699: astore 9
    //   701: new 130	java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   708: ldc 253
    //   710: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload 14
    //   715: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   724: goto -55 -> 669
    //   727: aload 12
    //   729: astore 11
    //   731: aload_1
    //   732: astore 10
    //   734: aload_0
    //   735: astore 9
    //   737: aload 13
    //   739: invokevirtual 192	java/lang/Process:destroy	()V
    //   742: aload 12
    //   744: astore 11
    //   746: aload_1
    //   747: astore 10
    //   749: aload_0
    //   750: astore 9
    //   752: getstatic 54	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   755: astore 14
    //   757: aload 12
    //   759: astore 11
    //   761: aload_1
    //   762: astore 10
    //   764: aload_0
    //   765: astore 9
    //   767: aload 14
    //   769: monitorenter
    //   770: aconst_null
    //   771: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   774: aload 14
    //   776: monitorexit
    //   777: aload 12
    //   779: astore 11
    //   781: aload_1
    //   782: astore 10
    //   784: aload_0
    //   785: astore 9
    //   787: ldc 255
    //   789: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   792: aload_0
    //   793: ifnull +7 -> 800
    //   796: aload_0
    //   797: invokevirtual 209	java/io/InputStream:close	()V
    //   800: aload_1
    //   801: ifnull +7 -> 808
    //   804: aload_1
    //   805: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   808: iload 4
    //   810: istore_3
    //   811: aload 12
    //   813: ifnull -331 -> 482
    //   816: aload 12
    //   818: invokevirtual 215	java/io/BufferedReader:close	()V
    //   821: iload 4
    //   823: istore_3
    //   824: goto -342 -> 482
    //   827: astore_0
    //   828: iload 4
    //   830: istore_3
    //   831: goto -349 -> 482
    //   834: astore 13
    //   836: aload 14
    //   838: monitorexit
    //   839: aload 12
    //   841: astore 11
    //   843: aload_1
    //   844: astore 10
    //   846: aload_0
    //   847: astore 9
    //   849: aload 13
    //   851: athrow
    //   852: astore 13
    //   854: sipush -1002
    //   857: istore 4
    //   859: aload 12
    //   861: astore 11
    //   863: aload_1
    //   864: astore 10
    //   866: aload_0
    //   867: astore 9
    //   869: aload 13
    //   871: invokevirtual 256	java/lang/InterruptedException:printStackTrace	()V
    //   874: aload 12
    //   876: astore 11
    //   878: aload_1
    //   879: astore 10
    //   881: aload_0
    //   882: astore 9
    //   884: new 130	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   891: ldc_w 258
    //   894: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: aload 13
    //   899: invokevirtual 259	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   902: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   911: aload_0
    //   912: ifnull +7 -> 919
    //   915: aload_0
    //   916: invokevirtual 209	java/io/InputStream:close	()V
    //   919: aload_1
    //   920: ifnull +7 -> 927
    //   923: aload_1
    //   924: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   927: iload 4
    //   929: istore_3
    //   930: aload 12
    //   932: ifnull -450 -> 482
    //   935: aload 12
    //   937: invokevirtual 215	java/io/BufferedReader:close	()V
    //   940: iload 4
    //   942: istore_3
    //   943: goto -461 -> 482
    //   946: astore_0
    //   947: iload 4
    //   949: istore_3
    //   950: goto -468 -> 482
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
    //   979: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   982: aload 12
    //   984: astore 11
    //   986: aload_1
    //   987: astore 10
    //   989: aload_0
    //   990: astore 9
    //   992: new 130	java/lang/StringBuilder
    //   995: dup
    //   996: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   999: ldc_w 262
    //   1002: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: aload 13
    //   1007: invokevirtual 263	java/lang/Exception:toString	()Ljava/lang/String;
    //   1010: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1016: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   1019: aload_0
    //   1020: ifnull +7 -> 1027
    //   1023: aload_0
    //   1024: invokevirtual 209	java/io/InputStream:close	()V
    //   1027: aload_1
    //   1028: ifnull +7 -> 1035
    //   1031: aload_1
    //   1032: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   1035: iload 4
    //   1037: istore_3
    //   1038: aload 12
    //   1040: ifnull -558 -> 482
    //   1043: aload 12
    //   1045: invokevirtual 215	java/io/BufferedReader:close	()V
    //   1048: iload 4
    //   1050: istore_3
    //   1051: goto -569 -> 482
    //   1054: astore_0
    //   1055: iload 4
    //   1057: istore_3
    //   1058: goto -576 -> 482
    //   1061: astore_1
    //   1062: aconst_null
    //   1063: astore_0
    //   1064: aload 9
    //   1066: astore_2
    //   1067: aload_0
    //   1068: ifnull +7 -> 1075
    //   1071: aload_0
    //   1072: invokevirtual 209	java/io/InputStream:close	()V
    //   1075: aload_2
    //   1076: ifnull +7 -> 1083
    //   1079: aload_2
    //   1080: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   1083: aload 10
    //   1085: ifnull +8 -> 1093
    //   1088: aload 10
    //   1090: invokevirtual 215	java/io/BufferedReader:close	()V
    //   1093: aload_1
    //   1094: athrow
    //   1095: astore_0
    //   1096: goto -527 -> 569
    //   1099: astore_0
    //   1100: goto -7 -> 1093
    //   1103: astore_1
    //   1104: aload 9
    //   1106: astore_2
    //   1107: goto -40 -> 1067
    //   1110: astore 9
    //   1112: aload_1
    //   1113: astore_2
    //   1114: aload 9
    //   1116: astore_1
    //   1117: goto -50 -> 1067
    //   1120: astore_1
    //   1121: aload 10
    //   1123: astore_2
    //   1124: aload 11
    //   1126: astore 10
    //   1128: aload 9
    //   1130: astore_0
    //   1131: goto -64 -> 1067
    //   1134: astore 13
    //   1136: aconst_null
    //   1137: astore_1
    //   1138: aconst_null
    //   1139: astore 12
    //   1141: goto -179 -> 962
    //   1144: astore 13
    //   1146: aconst_null
    //   1147: astore 12
    //   1149: goto -187 -> 962
    //   1152: astore 13
    //   1154: goto -192 -> 962
    //   1157: astore 13
    //   1159: aconst_null
    //   1160: astore_0
    //   1161: aconst_null
    //   1162: astore_1
    //   1163: aconst_null
    //   1164: astore 12
    //   1166: goto -312 -> 854
    //   1169: astore 13
    //   1171: aconst_null
    //   1172: astore_1
    //   1173: aconst_null
    //   1174: astore 12
    //   1176: goto -322 -> 854
    //   1179: astore 13
    //   1181: aconst_null
    //   1182: astore 12
    //   1184: goto -330 -> 854
    //   1187: astore_0
    //   1188: iload 4
    //   1190: istore_3
    //   1191: goto -709 -> 482
    //   1194: astore 13
    //   1196: aconst_null
    //   1197: astore_1
    //   1198: aconst_null
    //   1199: astore 12
    //   1201: goto -807 -> 394
    //   1204: astore 13
    //   1206: aconst_null
    //   1207: astore 12
    //   1209: goto -815 -> 394
    //   1212: astore 13
    //   1214: goto -820 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1217	0	paramContext	Context
    //   0	1217	1	paramString1	String
    //   0	1217	2	paramString2	String
    //   197	994	3	i	int
    //   194	995	4	j	int
    //   3	499	5	l1	long
    //   485	15	7	l2	long
    //   9	1096	9	localObject1	Object
    //   1110	19	9	localObject2	Object
    //   103	1024	10	localObject3	Object
    //   55	1070	11	localObject4	Object
    //   130	1078	12	localObject5	Object
    //   50	280	13	localObject6	Object
    //   385	353	13	localIOException1	java.io.IOException
    //   834	16	13	localObject7	Object
    //   852	46	13	localInterruptedException1	java.lang.InterruptedException
    //   953	53	13	localException1	Exception
    //   1134	1	13	localException2	Exception
    //   1144	1	13	localException3	Exception
    //   1152	1	13	localException4	Exception
    //   1157	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1169	1	13	localInterruptedException3	java.lang.InterruptedException
    //   1179	1	13	localInterruptedException4	java.lang.InterruptedException
    //   1194	1	13	localIOException2	java.io.IOException
    //   1204	1	13	localIOException3	java.io.IOException
    //   1212	1	13	localIOException4	java.io.IOException
    //   684	153	14	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   345	353	377	java/io/IOException
    //   357	365	377	java/io/IOException
    //   369	377	377	java/io/IOException
    //   309	316	380	finally
    //   381	383	380	finally
    //   105	196	385	java/io/IOException
    //   204	215	385	java/io/IOException
    //   222	309	385	java/io/IOException
    //   316	341	385	java/io/IOException
    //   383	385	385	java/io/IOException
    //   578	584	385	java/io/IOException
    //   796	800	827	java/io/IOException
    //   804	808	827	java/io/IOException
    //   816	821	827	java/io/IOException
    //   770	777	834	finally
    //   836	839	834	finally
    //   613	619	852	java/lang/InterruptedException
    //   629	636	852	java/lang/InterruptedException
    //   646	669	852	java/lang/InterruptedException
    //   679	686	852	java/lang/InterruptedException
    //   701	724	852	java/lang/InterruptedException
    //   737	742	852	java/lang/InterruptedException
    //   752	757	852	java/lang/InterruptedException
    //   767	770	852	java/lang/InterruptedException
    //   787	792	852	java/lang/InterruptedException
    //   849	852	852	java/lang/InterruptedException
    //   915	919	946	java/io/IOException
    //   923	927	946	java/io/IOException
    //   935	940	946	java/io/IOException
    //   105	196	953	java/lang/Exception
    //   204	215	953	java/lang/Exception
    //   222	309	953	java/lang/Exception
    //   316	341	953	java/lang/Exception
    //   383	385	953	java/lang/Exception
    //   578	584	953	java/lang/Exception
    //   1023	1027	1054	java/io/IOException
    //   1031	1035	1054	java/io/IOException
    //   1043	1048	1054	java/io/IOException
    //   105	196	1061	finally
    //   204	215	1061	finally
    //   222	309	1061	finally
    //   316	341	1061	finally
    //   383	385	1061	finally
    //   578	584	1061	finally
    //   526	569	1095	java/lang/Exception
    //   1071	1075	1099	java/io/IOException
    //   1079	1083	1099	java/io/IOException
    //   1088	1093	1099	java/io/IOException
    //   584	593	1103	finally
    //   593	603	1110	finally
    //   409	414	1120	finally
    //   424	450	1120	finally
    //   613	619	1120	finally
    //   629	636	1120	finally
    //   646	669	1120	finally
    //   679	686	1120	finally
    //   701	724	1120	finally
    //   737	742	1120	finally
    //   752	757	1120	finally
    //   767	770	1120	finally
    //   787	792	1120	finally
    //   849	852	1120	finally
    //   869	874	1120	finally
    //   884	911	1120	finally
    //   977	982	1120	finally
    //   992	1019	1120	finally
    //   584	593	1134	java/lang/Exception
    //   593	603	1144	java/lang/Exception
    //   613	619	1152	java/lang/Exception
    //   629	636	1152	java/lang/Exception
    //   646	669	1152	java/lang/Exception
    //   679	686	1152	java/lang/Exception
    //   701	724	1152	java/lang/Exception
    //   737	742	1152	java/lang/Exception
    //   752	757	1152	java/lang/Exception
    //   767	770	1152	java/lang/Exception
    //   787	792	1152	java/lang/Exception
    //   849	852	1152	java/lang/Exception
    //   105	196	1157	java/lang/InterruptedException
    //   204	215	1157	java/lang/InterruptedException
    //   222	309	1157	java/lang/InterruptedException
    //   316	341	1157	java/lang/InterruptedException
    //   383	385	1157	java/lang/InterruptedException
    //   578	584	1157	java/lang/InterruptedException
    //   584	593	1169	java/lang/InterruptedException
    //   593	603	1179	java/lang/InterruptedException
    //   454	458	1187	java/io/IOException
    //   462	466	1187	java/io/IOException
    //   474	479	1187	java/io/IOException
    //   584	593	1194	java/io/IOException
    //   593	603	1204	java/io/IOException
    //   613	619	1212	java/io/IOException
    //   629	636	1212	java/io/IOException
    //   646	669	1212	java/io/IOException
    //   679	686	1212	java/io/IOException
    //   701	724	1212	java/io/IOException
    //   737	742	1212	java/io/IOException
    //   752	757	1212	java/io/IOException
    //   767	770	1212	java/io/IOException
    //   787	792	1212	java/io/IOException
    //   849	852	1212	java/io/IOException
  }
  
  /* Error */
  public static int compressVideoNew(Context paramContext, String paramString1, String paramString2, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, ShortVideoTrimmer.ProcessCallBack paramProcessCallBack, bcyp parambcyp, bcyr parambcyr)
  {
    // Byte code:
    //   0: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   3: lstore 9
    //   5: new 101	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig
    //   8: dup
    //   9: invokespecial 266	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: iconst_1
    //   15: putfield 104	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:isNeedCompress	Z
    //   18: aload_3
    //   19: aload 6
    //   21: getfield 271	bcyr:c	I
    //   24: invokestatic 275	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: putfield 278	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:rotate	Ljava/lang/String;
    //   30: aload_3
    //   31: aload 6
    //   33: getfield 281	bcyr:jdField_a_of_type_Int	I
    //   36: putfield 284	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:srcWidth	I
    //   39: aload_3
    //   40: aload 6
    //   42: getfield 287	bcyr:jdField_b_of_type_Int	I
    //   45: putfield 290	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:srcHeight	I
    //   48: aload_3
    //   49: aload 6
    //   51: getfield 292	bcyr:d	I
    //   54: i2l
    //   55: putfield 295	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:duration	J
    //   58: aload_3
    //   59: aload 5
    //   61: getfield 298	bcyp:jdField_a_of_type_Int	I
    //   64: putfield 301	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:destWidth	I
    //   67: aload_3
    //   68: aload 5
    //   70: getfield 302	bcyp:jdField_b_of_type_Int	I
    //   73: putfield 305	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:destHeight	I
    //   76: aload_3
    //   77: bipush 25
    //   79: putfield 308	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:destQmax	I
    //   82: aload_3
    //   83: aload 5
    //   85: getfield 310	bcyp:jdField_b_of_type_Long	J
    //   88: putfield 313	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:desFrameRate	J
    //   91: aload_3
    //   92: aload 5
    //   94: getfield 315	bcyp:jdField_a_of_type_Long	J
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
    //   139: astore 15
    //   141: invokestatic 126	com/tencent/mobileqq/shortvideo/VideoEnvironment:getShortVideoSoLibName	()Ljava/lang/String;
    //   144: astore 14
    //   146: getstatic 76	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:VIDEO_COMPRESS_TEST_ENV	Z
    //   149: ifne +39 -> 188
    //   152: new 128	java/io/File
    //   155: dup
    //   156: new 130	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   163: aload 15
    //   165: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 14
    //   170: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: invokevirtual 143	java/io/File:exists	()Z
    //   182: ifne +6 -> 188
    //   185: bipush 253
    //   187: ireturn
    //   188: aconst_null
    //   189: astore_1
    //   190: aconst_null
    //   191: astore 5
    //   193: aconst_null
    //   194: astore_3
    //   195: new 145	java/lang/ProcessBuilder
    //   198: dup
    //   199: iconst_0
    //   200: anewarray 147	java/lang/String
    //   203: invokespecial 150	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   206: astore_0
    //   207: aload_0
    //   208: iconst_1
    //   209: invokevirtual 154	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   212: pop
    //   213: new 156	java/util/ArrayList
    //   216: dup
    //   217: invokespecial 157	java/util/ArrayList:<init>	()V
    //   220: astore 13
    //   222: aload 13
    //   224: new 130	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   231: aload 15
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
    //   262: aload 13
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
    //   297: aload 13
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
    //   319: aload 13
    //   321: new 130	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   328: aload 15
    //   330: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 14
    //   335: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokeinterface 163 2 0
    //   346: pop
    //   347: aload_0
    //   348: aload 13
    //   350: invokevirtual 173	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   353: pop
    //   354: new 130	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   361: ldc 175
    //   363: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 13
    //   368: aload 13
    //   370: invokeinterface 179 1 0
    //   375: iconst_1
    //   376: isub
    //   377: invokeinterface 169 2 0
    //   382: checkcast 147	java/lang/String
    //   385: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   394: aload_0
    //   395: invokevirtual 183	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   398: astore 14
    //   400: getstatic 54	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   403: astore_0
    //   404: aload_0
    //   405: monitorenter
    //   406: aload 14
    //   408: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   411: aload_0
    //   412: monitorexit
    //   413: aload 4
    //   415: ifnull +13 -> 428
    //   418: aload 4
    //   420: getstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   423: invokeinterface 327 2 0
    //   428: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   431: invokevirtual 187	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   434: ifne +274 -> 708
    //   437: aload 4
    //   439: ifnull +10 -> 449
    //   442: aload 4
    //   444: invokeinterface 330 1 0
    //   449: aconst_null
    //   450: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   453: aload 14
    //   455: invokevirtual 192	java/lang/Process:destroy	()V
    //   458: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   461: iconst_1
    //   462: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   465: iconst_0
    //   466: ifeq +11 -> 477
    //   469: new 197	java/lang/NullPointerException
    //   472: dup
    //   473: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   476: athrow
    //   477: iconst_0
    //   478: ifeq +11 -> 489
    //   481: new 197	java/lang/NullPointerException
    //   484: dup
    //   485: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   488: athrow
    //   489: iconst_0
    //   490: ifeq -378 -> 112
    //   493: new 197	java/lang/NullPointerException
    //   496: dup
    //   497: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   500: athrow
    //   501: astore_0
    //   502: iconst_m1
    //   503: ireturn
    //   504: astore 4
    //   506: aload_0
    //   507: monitorexit
    //   508: aload 4
    //   510: athrow
    //   511: astore 14
    //   513: aconst_null
    //   514: astore_0
    //   515: aconst_null
    //   516: astore_1
    //   517: aconst_null
    //   518: astore 4
    //   520: sipush -1001
    //   523: istore 8
    //   525: aload 4
    //   527: astore 6
    //   529: aload_1
    //   530: astore 5
    //   532: aload_0
    //   533: astore_3
    //   534: aload 14
    //   536: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   539: aload 4
    //   541: astore 6
    //   543: aload_1
    //   544: astore 5
    //   546: aload_0
    //   547: astore_3
    //   548: new 130	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   555: ldc 203
    //   557: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload 14
    //   562: invokevirtual 204	java/io/IOException:toString	()Ljava/lang/String;
    //   565: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   574: aload_0
    //   575: ifnull +7 -> 582
    //   578: aload_0
    //   579: invokevirtual 209	java/io/InputStream:close	()V
    //   582: aload_1
    //   583: ifnull +7 -> 590
    //   586: aload_1
    //   587: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   590: iload 8
    //   592: istore 7
    //   594: aload 4
    //   596: ifnull +12 -> 608
    //   599: aload 4
    //   601: invokevirtual 215	java/io/BufferedReader:close	()V
    //   604: iload 8
    //   606: istore 7
    //   608: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   611: lstore 11
    //   613: new 130	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   620: ldc 217
    //   622: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: lload 11
    //   627: lload 9
    //   629: lsub
    //   630: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   633: ldc 222
    //   635: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: iload 7
    //   640: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   643: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   649: iload 7
    //   651: ifeq +47 -> 698
    //   654: new 128	java/io/File
    //   657: dup
    //   658: aload_2
    //   659: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   662: astore_0
    //   663: aload_0
    //   664: invokevirtual 143	java/io/File:exists	()Z
    //   667: ifeq +31 -> 698
    //   670: aload_0
    //   671: invokevirtual 228	java/io/File:delete	()Z
    //   674: pop
    //   675: new 130	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   682: ldc 230
    //   684: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: iload 7
    //   689: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   692: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   698: getstatic 61	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:needCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   701: iconst_1
    //   702: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   705: iload 7
    //   707: ireturn
    //   708: aload 14
    //   710: invokevirtual 234	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   713: astore_0
    //   714: new 211	java/io/InputStreamReader
    //   717: dup
    //   718: aload_0
    //   719: invokespecial 237	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   722: astore_1
    //   723: new 214	java/io/BufferedReader
    //   726: dup
    //   727: aload_1
    //   728: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   731: astore 13
    //   733: aload 13
    //   735: astore 6
    //   737: aload_1
    //   738: astore 5
    //   740: aload_0
    //   741: astore_3
    //   742: aload 14
    //   744: invokevirtual 243	java/lang/Process:waitFor	()I
    //   747: pop
    //   748: aload 13
    //   750: astore 6
    //   752: aload_1
    //   753: astore 5
    //   755: aload_0
    //   756: astore_3
    //   757: aload 14
    //   759: invokevirtual 246	java/lang/Process:exitValue	()I
    //   762: istore 8
    //   764: aload 13
    //   766: astore 6
    //   768: aload_1
    //   769: astore 5
    //   771: aload_0
    //   772: astore_3
    //   773: new 130	java/lang/StringBuilder
    //   776: dup
    //   777: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   780: ldc 248
    //   782: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: iload 8
    //   787: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   790: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   796: aload 13
    //   798: astore 6
    //   800: aload_1
    //   801: astore 5
    //   803: aload_0
    //   804: astore_3
    //   805: aload 13
    //   807: invokevirtual 251	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   810: astore 15
    //   812: aload 15
    //   814: ifnull +38 -> 852
    //   817: aload 13
    //   819: astore 6
    //   821: aload_1
    //   822: astore 5
    //   824: aload_0
    //   825: astore_3
    //   826: new 130	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   833: ldc 253
    //   835: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload 15
    //   840: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   849: goto -53 -> 796
    //   852: aload 13
    //   854: astore 6
    //   856: aload_1
    //   857: astore 5
    //   859: aload_0
    //   860: astore_3
    //   861: aload 14
    //   863: invokevirtual 192	java/lang/Process:destroy	()V
    //   866: aload 4
    //   868: ifnull +19 -> 887
    //   871: aload 13
    //   873: astore 6
    //   875: aload_1
    //   876: astore 5
    //   878: aload_0
    //   879: astore_3
    //   880: aload 4
    //   882: invokeinterface 333 1 0
    //   887: aload 13
    //   889: astore 6
    //   891: aload_1
    //   892: astore 5
    //   894: aload_0
    //   895: astore_3
    //   896: getstatic 54	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:lock	Ljava/lang/Object;
    //   899: astore 4
    //   901: aload 13
    //   903: astore 6
    //   905: aload_1
    //   906: astore 5
    //   908: aload_0
    //   909: astore_3
    //   910: aload 4
    //   912: monitorenter
    //   913: aconst_null
    //   914: putstatic 185	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:process	Ljava/lang/Process;
    //   917: aload 4
    //   919: monitorexit
    //   920: aload 13
    //   922: astore 6
    //   924: aload_1
    //   925: astore 5
    //   927: aload_0
    //   928: astore_3
    //   929: ldc 255
    //   931: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   934: aload_0
    //   935: ifnull +7 -> 942
    //   938: aload_0
    //   939: invokevirtual 209	java/io/InputStream:close	()V
    //   942: aload_1
    //   943: ifnull +7 -> 950
    //   946: aload_1
    //   947: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   950: iload 8
    //   952: istore 7
    //   954: aload 13
    //   956: ifnull -348 -> 608
    //   959: aload 13
    //   961: invokevirtual 215	java/io/BufferedReader:close	()V
    //   964: iload 8
    //   966: istore 7
    //   968: goto -360 -> 608
    //   971: astore_0
    //   972: iload 8
    //   974: istore 7
    //   976: goto -368 -> 608
    //   979: astore 14
    //   981: aload 4
    //   983: monitorexit
    //   984: aload 13
    //   986: astore 6
    //   988: aload_1
    //   989: astore 5
    //   991: aload_0
    //   992: astore_3
    //   993: aload 14
    //   995: athrow
    //   996: astore_3
    //   997: aload 13
    //   999: astore 4
    //   1001: aload_3
    //   1002: astore 13
    //   1004: sipush -1002
    //   1007: istore 8
    //   1009: aload 4
    //   1011: astore 6
    //   1013: aload_1
    //   1014: astore 5
    //   1016: aload_0
    //   1017: astore_3
    //   1018: aload 13
    //   1020: invokevirtual 256	java/lang/InterruptedException:printStackTrace	()V
    //   1023: aload 4
    //   1025: astore 6
    //   1027: aload_1
    //   1028: astore 5
    //   1030: aload_0
    //   1031: astore_3
    //   1032: new 130	java/lang/StringBuilder
    //   1035: dup
    //   1036: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1039: ldc_w 258
    //   1042: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: aload 13
    //   1047: invokevirtual 259	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   1050: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1056: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   1059: aload_0
    //   1060: ifnull +7 -> 1067
    //   1063: aload_0
    //   1064: invokevirtual 209	java/io/InputStream:close	()V
    //   1067: aload_1
    //   1068: ifnull +7 -> 1075
    //   1071: aload_1
    //   1072: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   1075: iload 8
    //   1077: istore 7
    //   1079: aload 4
    //   1081: ifnull -473 -> 608
    //   1084: aload 4
    //   1086: invokevirtual 215	java/io/BufferedReader:close	()V
    //   1089: iload 8
    //   1091: istore 7
    //   1093: goto -485 -> 608
    //   1096: astore_0
    //   1097: iload 8
    //   1099: istore 7
    //   1101: goto -493 -> 608
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
    //   1129: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   1132: aload 4
    //   1134: astore 6
    //   1136: aload_1
    //   1137: astore 5
    //   1139: aload_0
    //   1140: astore_3
    //   1141: new 130	java/lang/StringBuilder
    //   1144: dup
    //   1145: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1148: ldc_w 262
    //   1151: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload 14
    //   1156: invokevirtual 263	java/lang/Exception:toString	()Ljava/lang/String;
    //   1159: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 108	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   1168: aload_0
    //   1169: ifnull +7 -> 1176
    //   1172: aload_0
    //   1173: invokevirtual 209	java/io/InputStream:close	()V
    //   1176: aload_1
    //   1177: ifnull +7 -> 1184
    //   1180: aload_1
    //   1181: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   1184: iload 8
    //   1186: istore 7
    //   1188: aload 4
    //   1190: ifnull -582 -> 608
    //   1193: aload 4
    //   1195: invokevirtual 215	java/io/BufferedReader:close	()V
    //   1198: iload 8
    //   1200: istore 7
    //   1202: goto -594 -> 608
    //   1205: astore_0
    //   1206: iload 8
    //   1208: istore 7
    //   1210: goto -602 -> 608
    //   1213: astore_0
    //   1214: aload 5
    //   1216: astore_2
    //   1217: aload_1
    //   1218: ifnull +7 -> 1225
    //   1221: aload_1
    //   1222: invokevirtual 209	java/io/InputStream:close	()V
    //   1225: aload_2
    //   1226: ifnull +7 -> 1233
    //   1229: aload_2
    //   1230: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   1233: aload_3
    //   1234: ifnull +7 -> 1241
    //   1237: aload_3
    //   1238: invokevirtual 215	java/io/BufferedReader:close	()V
    //   1241: aload_0
    //   1242: athrow
    //   1243: astore_0
    //   1244: goto -546 -> 698
    //   1247: astore_1
    //   1248: goto -7 -> 1241
    //   1251: astore_2
    //   1252: aload_0
    //   1253: astore_1
    //   1254: aload_2
    //   1255: astore_0
    //   1256: aload 5
    //   1258: astore_2
    //   1259: goto -42 -> 1217
    //   1262: astore_2
    //   1263: aload_0
    //   1264: astore 4
    //   1266: aload_2
    //   1267: astore_0
    //   1268: aload_1
    //   1269: astore_2
    //   1270: aload 4
    //   1272: astore_1
    //   1273: goto -56 -> 1217
    //   1276: astore_0
    //   1277: aload 5
    //   1279: astore_2
    //   1280: aload_3
    //   1281: astore_1
    //   1282: aload 6
    //   1284: astore_3
    //   1285: goto -68 -> 1217
    //   1288: astore 14
    //   1290: aconst_null
    //   1291: astore_1
    //   1292: aconst_null
    //   1293: astore 4
    //   1295: goto -182 -> 1113
    //   1298: astore 14
    //   1300: aconst_null
    //   1301: astore 4
    //   1303: goto -190 -> 1113
    //   1306: astore 14
    //   1308: aload 13
    //   1310: astore 4
    //   1312: goto -199 -> 1113
    //   1315: astore 13
    //   1317: aconst_null
    //   1318: astore_0
    //   1319: aconst_null
    //   1320: astore_1
    //   1321: aconst_null
    //   1322: astore 4
    //   1324: goto -320 -> 1004
    //   1327: astore 13
    //   1329: aconst_null
    //   1330: astore_1
    //   1331: aconst_null
    //   1332: astore 4
    //   1334: goto -330 -> 1004
    //   1337: astore 13
    //   1339: aconst_null
    //   1340: astore 4
    //   1342: goto -338 -> 1004
    //   1345: astore_0
    //   1346: iload 8
    //   1348: istore 7
    //   1350: goto -742 -> 608
    //   1353: astore 14
    //   1355: aconst_null
    //   1356: astore_1
    //   1357: aconst_null
    //   1358: astore 4
    //   1360: goto -840 -> 520
    //   1363: astore 14
    //   1365: aconst_null
    //   1366: astore 4
    //   1368: goto -848 -> 520
    //   1371: astore 14
    //   1373: aload 13
    //   1375: astore 4
    //   1377: goto -857 -> 520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1380	0	paramContext	Context
    //   0	1380	1	paramString1	String
    //   0	1380	2	paramString2	String
    //   0	1380	3	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1380	4	paramProcessCallBack	ShortVideoTrimmer.ProcessCallBack
    //   0	1380	5	parambcyp	bcyp
    //   0	1380	6	parambcyr	bcyr
    //   288	1061	7	i	int
    //   285	1062	8	j	int
    //   3	625	9	l1	long
    //   611	15	11	l2	long
    //   220	1089	13	localObject1	Object
    //   1315	1	13	localInterruptedException1	java.lang.InterruptedException
    //   1327	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1337	37	13	localInterruptedException3	java.lang.InterruptedException
    //   144	310	14	localObject2	Object
    //   511	351	14	localIOException1	java.io.IOException
    //   979	15	14	localObject3	Object
    //   1104	51	14	localException1	Exception
    //   1288	1	14	localException2	Exception
    //   1298	1	14	localException3	Exception
    //   1306	1	14	localException4	Exception
    //   1353	1	14	localIOException2	java.io.IOException
    //   1363	1	14	localIOException3	java.io.IOException
    //   1371	1	14	localIOException4	java.io.IOException
    //   139	700	15	str	String
    // Exception table:
    //   from	to	target	type
    //   469	477	501	java/io/IOException
    //   481	489	501	java/io/IOException
    //   493	501	501	java/io/IOException
    //   406	413	504	finally
    //   506	508	504	finally
    //   195	287	511	java/io/IOException
    //   297	310	511	java/io/IOException
    //   319	406	511	java/io/IOException
    //   418	428	511	java/io/IOException
    //   428	437	511	java/io/IOException
    //   442	449	511	java/io/IOException
    //   449	465	511	java/io/IOException
    //   508	511	511	java/io/IOException
    //   708	714	511	java/io/IOException
    //   938	942	971	java/io/IOException
    //   946	950	971	java/io/IOException
    //   959	964	971	java/io/IOException
    //   913	920	979	finally
    //   981	984	979	finally
    //   742	748	996	java/lang/InterruptedException
    //   757	764	996	java/lang/InterruptedException
    //   773	796	996	java/lang/InterruptedException
    //   805	812	996	java/lang/InterruptedException
    //   826	849	996	java/lang/InterruptedException
    //   861	866	996	java/lang/InterruptedException
    //   880	887	996	java/lang/InterruptedException
    //   896	901	996	java/lang/InterruptedException
    //   910	913	996	java/lang/InterruptedException
    //   929	934	996	java/lang/InterruptedException
    //   993	996	996	java/lang/InterruptedException
    //   1063	1067	1096	java/io/IOException
    //   1071	1075	1096	java/io/IOException
    //   1084	1089	1096	java/io/IOException
    //   195	287	1104	java/lang/Exception
    //   297	310	1104	java/lang/Exception
    //   319	406	1104	java/lang/Exception
    //   418	428	1104	java/lang/Exception
    //   428	437	1104	java/lang/Exception
    //   442	449	1104	java/lang/Exception
    //   449	465	1104	java/lang/Exception
    //   508	511	1104	java/lang/Exception
    //   708	714	1104	java/lang/Exception
    //   1172	1176	1205	java/io/IOException
    //   1180	1184	1205	java/io/IOException
    //   1193	1198	1205	java/io/IOException
    //   195	287	1213	finally
    //   297	310	1213	finally
    //   319	406	1213	finally
    //   418	428	1213	finally
    //   428	437	1213	finally
    //   442	449	1213	finally
    //   449	465	1213	finally
    //   508	511	1213	finally
    //   708	714	1213	finally
    //   654	698	1243	java/lang/Exception
    //   1221	1225	1247	java/io/IOException
    //   1229	1233	1247	java/io/IOException
    //   1237	1241	1247	java/io/IOException
    //   714	723	1251	finally
    //   723	733	1262	finally
    //   534	539	1276	finally
    //   548	574	1276	finally
    //   742	748	1276	finally
    //   757	764	1276	finally
    //   773	796	1276	finally
    //   805	812	1276	finally
    //   826	849	1276	finally
    //   861	866	1276	finally
    //   880	887	1276	finally
    //   896	901	1276	finally
    //   910	913	1276	finally
    //   929	934	1276	finally
    //   993	996	1276	finally
    //   1018	1023	1276	finally
    //   1032	1059	1276	finally
    //   1127	1132	1276	finally
    //   1141	1168	1276	finally
    //   714	723	1288	java/lang/Exception
    //   723	733	1298	java/lang/Exception
    //   742	748	1306	java/lang/Exception
    //   757	764	1306	java/lang/Exception
    //   773	796	1306	java/lang/Exception
    //   805	812	1306	java/lang/Exception
    //   826	849	1306	java/lang/Exception
    //   861	866	1306	java/lang/Exception
    //   880	887	1306	java/lang/Exception
    //   896	901	1306	java/lang/Exception
    //   910	913	1306	java/lang/Exception
    //   929	934	1306	java/lang/Exception
    //   993	996	1306	java/lang/Exception
    //   195	287	1315	java/lang/InterruptedException
    //   297	310	1315	java/lang/InterruptedException
    //   319	406	1315	java/lang/InterruptedException
    //   418	428	1315	java/lang/InterruptedException
    //   428	437	1315	java/lang/InterruptedException
    //   442	449	1315	java/lang/InterruptedException
    //   449	465	1315	java/lang/InterruptedException
    //   508	511	1315	java/lang/InterruptedException
    //   708	714	1315	java/lang/InterruptedException
    //   714	723	1327	java/lang/InterruptedException
    //   723	733	1337	java/lang/InterruptedException
    //   578	582	1345	java/io/IOException
    //   586	590	1345	java/io/IOException
    //   599	604	1345	java/io/IOException
    //   714	723	1353	java/io/IOException
    //   723	733	1363	java/io/IOException
    //   742	748	1371	java/io/IOException
    //   757	764	1371	java/io/IOException
    //   773	796	1371	java/io/IOException
    //   805	812	1371	java/io/IOException
    //   826	849	1371	java/io/IOException
    //   861	866	1371	java/io/IOException
    //   880	887	1371	java/io/IOException
    //   896	901	1371	java/io/IOException
    //   910	913	1371	java/io/IOException
    //   929	934	1371	java/io/IOException
    //   993	996	1371	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer
 * JD-Core Version:    0.7.0.1
 */