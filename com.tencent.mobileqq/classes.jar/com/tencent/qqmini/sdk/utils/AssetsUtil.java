package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class AssetsUtil
{
  public static final String TAG = "AssetsUtil";
  
  /* Error */
  private static boolean copyAssetToFile(android.content.res.AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: new 19	java/io/FileOutputStream
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 22	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: astore 6
    //   19: aload 6
    //   21: invokevirtual 26	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   24: invokevirtual 32	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   27: astore 8
    //   29: new 34	java/io/BufferedInputStream
    //   32: dup
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 40	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: invokespecial 43	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   41: astore_0
    //   42: sipush 8192
    //   45: newarray byte
    //   47: astore 7
    //   49: aload_0
    //   50: aload 7
    //   52: invokevirtual 47	java/io/BufferedInputStream:read	([B)I
    //   55: istore_3
    //   56: iload_3
    //   57: iconst_m1
    //   58: if_icmpeq +106 -> 164
    //   61: aload 6
    //   63: aload 7
    //   65: iconst_0
    //   66: iload_3
    //   67: invokevirtual 51	java/io/FileOutputStream:write	([BII)V
    //   70: goto -21 -> 49
    //   73: astore 9
    //   75: aload_0
    //   76: astore 7
    //   78: aload 9
    //   80: astore_0
    //   81: ldc 8
    //   83: new 53	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   90: ldc 56
    //   92: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 62
    //   101: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_2
    //   105: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aload_0
    //   112: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload 7
    //   117: ifnull +8 -> 125
    //   120: aload 7
    //   122: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   125: iload 5
    //   127: istore 4
    //   129: aload 6
    //   131: ifnull +30 -> 161
    //   134: aload 6
    //   136: invokevirtual 79	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   139: invokevirtual 84	java/io/FileDescriptor:sync	()V
    //   142: aload 8
    //   144: ifnull +8 -> 152
    //   147: aload 8
    //   149: invokevirtual 89	java/nio/channels/FileLock:release	()V
    //   152: aload 6
    //   154: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   157: iload 5
    //   159: istore 4
    //   161: iload 4
    //   163: ireturn
    //   164: iconst_1
    //   165: istore 4
    //   167: aload_0
    //   168: ifnull +7 -> 175
    //   171: aload_0
    //   172: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   175: aload 6
    //   177: ifnull -16 -> 161
    //   180: aload 6
    //   182: invokevirtual 79	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   185: invokevirtual 84	java/io/FileDescriptor:sync	()V
    //   188: aload 8
    //   190: ifnull +8 -> 198
    //   193: aload 8
    //   195: invokevirtual 89	java/nio/channels/FileLock:release	()V
    //   198: aload 6
    //   200: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   203: iconst_1
    //   204: ireturn
    //   205: astore_0
    //   206: ldc 8
    //   208: new 53	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   215: ldc 56
    //   217: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_1
    //   221: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc 62
    //   226: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_2
    //   230: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: aload_0
    //   237: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   240: iconst_1
    //   241: ireturn
    //   242: astore_0
    //   243: ldc 8
    //   245: new 53	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   252: ldc 56
    //   254: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_1
    //   258: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 62
    //   263: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_2
    //   267: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: aload_0
    //   274: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   277: goto -102 -> 175
    //   280: astore_0
    //   281: ldc 8
    //   283: new 53	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   290: ldc 56
    //   292: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_1
    //   296: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc 62
    //   301: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_2
    //   305: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: aload_0
    //   312: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   315: aload 6
    //   317: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   320: iconst_1
    //   321: ireturn
    //   322: astore_0
    //   323: ldc 8
    //   325: new 53	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   332: ldc 56
    //   334: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_1
    //   338: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc 62
    //   343: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_2
    //   347: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: aload_0
    //   354: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   357: iconst_1
    //   358: ireturn
    //   359: astore_0
    //   360: aload 6
    //   362: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   365: aload_0
    //   366: athrow
    //   367: astore 6
    //   369: ldc 8
    //   371: new 53	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   378: ldc 56
    //   380: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_1
    //   384: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc 62
    //   389: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_2
    //   393: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: aload 6
    //   401: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   404: goto -39 -> 365
    //   407: astore_0
    //   408: ldc 8
    //   410: new 53	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   417: ldc 56
    //   419: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_1
    //   423: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: ldc 62
    //   428: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_2
    //   432: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: aload_0
    //   439: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   442: goto -317 -> 125
    //   445: astore_0
    //   446: ldc 8
    //   448: new 53	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   455: ldc 56
    //   457: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_1
    //   461: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc 62
    //   466: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload_2
    //   470: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: aload_0
    //   477: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   480: iconst_0
    //   481: ireturn
    //   482: astore_0
    //   483: ldc 8
    //   485: new 53	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   492: ldc 56
    //   494: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload_1
    //   498: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: ldc 62
    //   503: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: aload_2
    //   507: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: aload_0
    //   514: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   517: aload 6
    //   519: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   522: iconst_0
    //   523: ireturn
    //   524: astore_0
    //   525: ldc 8
    //   527: new 53	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   534: ldc 56
    //   536: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload_1
    //   540: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: ldc 62
    //   545: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_2
    //   549: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: aload_0
    //   556: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   559: iconst_0
    //   560: ireturn
    //   561: astore_0
    //   562: aload 6
    //   564: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   567: aload_0
    //   568: athrow
    //   569: astore 6
    //   571: ldc 8
    //   573: new 53	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   580: ldc 56
    //   582: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload_1
    //   586: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: ldc 62
    //   591: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload_2
    //   595: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: aload 6
    //   603: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   606: goto -39 -> 567
    //   609: astore_0
    //   610: aconst_null
    //   611: astore 9
    //   613: aconst_null
    //   614: astore 7
    //   616: aload 8
    //   618: astore 6
    //   620: aload 9
    //   622: astore 8
    //   624: aload 7
    //   626: ifnull +8 -> 634
    //   629: aload 7
    //   631: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   634: aload 6
    //   636: ifnull +26 -> 662
    //   639: aload 6
    //   641: invokevirtual 79	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   644: invokevirtual 84	java/io/FileDescriptor:sync	()V
    //   647: aload 8
    //   649: ifnull +8 -> 657
    //   652: aload 8
    //   654: invokevirtual 89	java/nio/channels/FileLock:release	()V
    //   657: aload 6
    //   659: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   662: aload_0
    //   663: athrow
    //   664: astore 7
    //   666: ldc 8
    //   668: new 53	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   675: ldc 56
    //   677: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload_1
    //   681: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: ldc 62
    //   686: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_2
    //   690: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: aload 7
    //   698: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   701: goto -67 -> 634
    //   704: astore 6
    //   706: ldc 8
    //   708: new 53	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   715: ldc 56
    //   717: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload_1
    //   721: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: ldc 62
    //   726: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload_2
    //   730: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: aload 6
    //   738: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   741: goto -79 -> 662
    //   744: astore 7
    //   746: ldc 8
    //   748: new 53	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   755: ldc 56
    //   757: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: aload_1
    //   761: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: ldc 62
    //   766: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload_2
    //   770: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: aload 7
    //   778: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   781: aload 6
    //   783: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   786: goto -124 -> 662
    //   789: astore 6
    //   791: ldc 8
    //   793: new 53	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   800: ldc 56
    //   802: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: aload_1
    //   806: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: ldc 62
    //   811: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: aload_2
    //   815: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   821: aload 6
    //   823: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   826: goto -164 -> 662
    //   829: astore_0
    //   830: aload 6
    //   832: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   835: aload_0
    //   836: athrow
    //   837: astore 6
    //   839: ldc 8
    //   841: new 53	java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   848: ldc 56
    //   850: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload_1
    //   854: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: ldc 62
    //   859: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload_2
    //   863: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: aload 6
    //   871: invokestatic 72	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   874: goto -39 -> 835
    //   877: astore_0
    //   878: aconst_null
    //   879: astore 8
    //   881: aconst_null
    //   882: astore 7
    //   884: goto -260 -> 624
    //   887: astore_0
    //   888: aconst_null
    //   889: astore 7
    //   891: goto -267 -> 624
    //   894: astore 9
    //   896: aload_0
    //   897: astore 7
    //   899: aload 9
    //   901: astore_0
    //   902: goto -278 -> 624
    //   905: astore_0
    //   906: goto -282 -> 624
    //   909: astore_0
    //   910: aconst_null
    //   911: astore 8
    //   913: aconst_null
    //   914: astore 9
    //   916: aload 7
    //   918: astore 6
    //   920: aload 9
    //   922: astore 7
    //   924: goto -843 -> 81
    //   927: astore_0
    //   928: aconst_null
    //   929: astore 8
    //   931: aconst_null
    //   932: astore 7
    //   934: goto -853 -> 81
    //   937: astore_0
    //   938: aconst_null
    //   939: astore 7
    //   941: goto -860 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	944	0	paramAssetManager	android.content.res.AssetManager
    //   0	944	1	paramString1	String
    //   0	944	2	paramString2	String
    //   55	12	3	i	int
    //   127	39	4	bool1	boolean
    //   1	157	5	bool2	boolean
    //   17	344	6	localFileOutputStream	java.io.FileOutputStream
    //   367	196	6	localIOException1	java.io.IOException
    //   569	33	6	localIOException2	java.io.IOException
    //   618	40	6	localObject1	Object
    //   704	78	6	localIOException3	java.io.IOException
    //   789	42	6	localIOException4	java.io.IOException
    //   837	33	6	localIOException5	java.io.IOException
    //   918	1	6	localObject2	Object
    //   7	623	7	localObject3	Object
    //   664	33	7	localIOException6	java.io.IOException
    //   744	33	7	localIOException7	java.io.IOException
    //   882	58	7	localObject4	Object
    //   4	926	8	localObject5	Object
    //   73	6	9	localIOException8	java.io.IOException
    //   611	10	9	localObject6	Object
    //   894	6	9	localObject7	Object
    //   914	7	9	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   42	49	73	java/io/IOException
    //   49	56	73	java/io/IOException
    //   61	70	73	java/io/IOException
    //   198	203	205	java/io/IOException
    //   171	175	242	java/io/IOException
    //   180	188	280	java/io/IOException
    //   193	198	280	java/io/IOException
    //   315	320	322	java/io/IOException
    //   180	188	359	finally
    //   193	198	359	finally
    //   281	315	359	finally
    //   360	365	367	java/io/IOException
    //   120	125	407	java/io/IOException
    //   152	157	445	java/io/IOException
    //   134	142	482	java/io/IOException
    //   147	152	482	java/io/IOException
    //   517	522	524	java/io/IOException
    //   134	142	561	finally
    //   147	152	561	finally
    //   483	517	561	finally
    //   562	567	569	java/io/IOException
    //   9	19	609	finally
    //   629	634	664	java/io/IOException
    //   657	662	704	java/io/IOException
    //   639	647	744	java/io/IOException
    //   652	657	744	java/io/IOException
    //   781	786	789	java/io/IOException
    //   639	647	829	finally
    //   652	657	829	finally
    //   746	781	829	finally
    //   830	835	837	java/io/IOException
    //   19	29	877	finally
    //   29	42	887	finally
    //   42	49	894	finally
    //   49	56	894	finally
    //   61	70	894	finally
    //   81	115	905	finally
    //   9	19	909	java/io/IOException
    //   19	29	927	java/io/IOException
    //   29	42	937	java/io/IOException
  }
  
  public static boolean copyFileOrDir(Context paramContext, String paramString1, String paramString2, List<String> paramList)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramList == null) || (paramList.size() <= 0)) {
      return false;
    }
    try
    {
      paramContext = paramContext.getAssets();
      Object localObject = new File(paramString2);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str))
        {
          localObject = new File(paramString2, str);
          if (!((File)localObject).exists()) {
            ((File)localObject).getParentFile().mkdirs();
          }
          str = paramString1 + File.separator + str;
          localObject = ((File)localObject).getAbsolutePath();
          if (!copyAssetToFile(paramContext, str, (String)localObject))
          {
            QMLog.e("AssetsUtil", String.format("copyAssetToFile from=%s, to=%s fail", new Object[] { str, localObject }));
            return false;
          }
        }
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      QMLog.e("AssetsUtil", String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", new Object[] { paramString1, paramString2 }), paramContext);
    }
    try
    {
      if (new File(paramString2).exists()) {
        FileUtils.delete(paramString2, false);
      }
      label239:
      return false;
    }
    catch (Throwable paramContext)
    {
      break label239;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.AssetsUtil
 * JD-Core Version:    0.7.0.1
 */