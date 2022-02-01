package com.tencent.qqmini.v8rt.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.File;

public class AssetUtil
{
  public static final String LOG_TAG = "AssetUtil";
  
  /* Error */
  public static boolean copyAssetToFile(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: new 19	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   16: aload_2
    //   17: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 26
    //   22: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 10
    //   30: new 32	java/io/FileOutputStream
    //   33: dup
    //   34: aload 10
    //   36: invokespecial 35	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   39: astore 5
    //   41: aload 5
    //   43: astore 7
    //   45: aload 9
    //   47: astore 6
    //   49: new 37	java/io/BufferedInputStream
    //   52: dup
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 43	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   58: invokespecial 46	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_0
    //   62: sipush 8192
    //   65: newarray byte
    //   67: astore 6
    //   69: aload_0
    //   70: aload 6
    //   72: invokevirtual 50	java/io/BufferedInputStream:read	([B)I
    //   75: istore_3
    //   76: iload_3
    //   77: iconst_m1
    //   78: if_icmpeq +110 -> 188
    //   81: aload 5
    //   83: aload 6
    //   85: iconst_0
    //   86: iload_3
    //   87: invokevirtual 56	java/io/OutputStream:write	([BII)V
    //   90: goto -21 -> 69
    //   93: astore 6
    //   95: aload_0
    //   96: astore 8
    //   98: aload 6
    //   100: astore_0
    //   101: aload 5
    //   103: astore 7
    //   105: aload 8
    //   107: astore 6
    //   109: ldc 8
    //   111: new 19	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   118: ldc 58
    //   120: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 60
    //   129: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_2
    //   133: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 62
    //   138: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   145: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   154: pop
    //   155: aload 8
    //   157: ifnull +8 -> 165
    //   160: aload 8
    //   162: invokevirtual 74	java/io/BufferedInputStream:close	()V
    //   165: aload 5
    //   167: ifnull +19 -> 186
    //   170: aload 5
    //   172: checkcast 32	java/io/FileOutputStream
    //   175: invokevirtual 78	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   178: invokevirtual 83	java/io/FileDescriptor:sync	()V
    //   181: aload 5
    //   183: invokevirtual 84	java/io/OutputStream:close	()V
    //   186: iconst_0
    //   187: ireturn
    //   188: new 86	java/io/File
    //   191: dup
    //   192: aload 10
    //   194: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   197: new 86	java/io/File
    //   200: dup
    //   201: aload_2
    //   202: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   205: invokevirtual 91	java/io/File:renameTo	(Ljava/io/File;)Z
    //   208: istore 4
    //   210: aload_0
    //   211: ifnull +7 -> 218
    //   214: aload_0
    //   215: invokevirtual 74	java/io/BufferedInputStream:close	()V
    //   218: aload 5
    //   220: ifnull +19 -> 239
    //   223: aload 5
    //   225: checkcast 32	java/io/FileOutputStream
    //   228: invokevirtual 78	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   231: invokevirtual 83	java/io/FileDescriptor:sync	()V
    //   234: aload 5
    //   236: invokevirtual 84	java/io/OutputStream:close	()V
    //   239: iload 4
    //   241: ireturn
    //   242: astore_0
    //   243: ldc 8
    //   245: new 19	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   252: ldc 58
    //   254: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_1
    //   258: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 60
    //   263: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_2
    //   267: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 62
    //   272: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_0
    //   276: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   279: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   288: pop
    //   289: goto -71 -> 218
    //   292: astore_0
    //   293: ldc 8
    //   295: new 19	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   302: ldc 58
    //   304: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc 60
    //   313: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_2
    //   317: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc 62
    //   322: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_0
    //   326: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   329: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   338: pop
    //   339: goto -100 -> 239
    //   342: astore_0
    //   343: ldc 8
    //   345: new 19	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   352: ldc 58
    //   354: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_1
    //   358: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc 60
    //   363: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_2
    //   367: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: ldc 62
    //   372: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_0
    //   376: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   379: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   388: pop
    //   389: aload 5
    //   391: invokevirtual 84	java/io/OutputStream:close	()V
    //   394: goto -155 -> 239
    //   397: astore_0
    //   398: ldc 8
    //   400: new 19	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   407: ldc 58
    //   409: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_1
    //   413: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: ldc 60
    //   418: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_2
    //   422: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc 62
    //   427: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_0
    //   431: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   434: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   443: pop
    //   444: goto -205 -> 239
    //   447: astore_0
    //   448: aload 5
    //   450: invokevirtual 84	java/io/OutputStream:close	()V
    //   453: aload_0
    //   454: athrow
    //   455: astore 5
    //   457: ldc 8
    //   459: new 19	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   466: ldc 58
    //   468: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload_1
    //   472: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: ldc 60
    //   477: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload_2
    //   481: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: ldc 62
    //   486: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 5
    //   491: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   494: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   503: pop
    //   504: goto -51 -> 453
    //   507: astore_0
    //   508: ldc 8
    //   510: new 19	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   517: ldc 58
    //   519: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: aload_1
    //   523: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: ldc 60
    //   528: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_2
    //   532: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: ldc 62
    //   537: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_0
    //   541: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   544: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   553: pop
    //   554: goto -389 -> 165
    //   557: astore_0
    //   558: ldc 8
    //   560: new 19	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   567: ldc 58
    //   569: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_1
    //   573: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: ldc 60
    //   578: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload_2
    //   582: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: ldc 62
    //   587: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_0
    //   591: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   594: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   603: pop
    //   604: goto -418 -> 186
    //   607: astore_0
    //   608: ldc 8
    //   610: new 19	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   617: ldc 58
    //   619: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: aload_1
    //   623: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: ldc 60
    //   628: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload_2
    //   632: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: ldc 62
    //   637: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: aload_0
    //   641: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   644: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   653: pop
    //   654: aload 5
    //   656: invokevirtual 84	java/io/OutputStream:close	()V
    //   659: goto -473 -> 186
    //   662: astore_0
    //   663: ldc 8
    //   665: new 19	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   672: ldc 58
    //   674: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload_1
    //   678: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: ldc 60
    //   683: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_2
    //   687: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: ldc 62
    //   692: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: aload_0
    //   696: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   699: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   708: pop
    //   709: goto -523 -> 186
    //   712: astore_0
    //   713: aload 5
    //   715: invokevirtual 84	java/io/OutputStream:close	()V
    //   718: aload_0
    //   719: athrow
    //   720: astore 5
    //   722: ldc 8
    //   724: new 19	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   731: ldc 58
    //   733: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload_1
    //   737: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: ldc 60
    //   742: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: aload_2
    //   746: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: ldc 62
    //   751: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload 5
    //   756: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   759: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   768: pop
    //   769: goto -51 -> 718
    //   772: astore_0
    //   773: aconst_null
    //   774: astore 5
    //   776: aload 6
    //   778: ifnull +8 -> 786
    //   781: aload 6
    //   783: invokevirtual 74	java/io/BufferedInputStream:close	()V
    //   786: aload 5
    //   788: ifnull +19 -> 807
    //   791: aload 5
    //   793: checkcast 32	java/io/FileOutputStream
    //   796: invokevirtual 78	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   799: invokevirtual 83	java/io/FileDescriptor:sync	()V
    //   802: aload 5
    //   804: invokevirtual 84	java/io/OutputStream:close	()V
    //   807: aload_0
    //   808: athrow
    //   809: astore 6
    //   811: ldc 8
    //   813: new 19	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   820: ldc 58
    //   822: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: aload_1
    //   826: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: ldc 60
    //   831: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: aload_2
    //   835: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: ldc 62
    //   840: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: aload 6
    //   845: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   848: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   857: pop
    //   858: goto -72 -> 786
    //   861: astore 5
    //   863: ldc 8
    //   865: new 19	java/lang/StringBuilder
    //   868: dup
    //   869: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   872: ldc 58
    //   874: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: aload_1
    //   878: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: ldc 60
    //   883: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: aload_2
    //   887: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: ldc 62
    //   892: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: aload 5
    //   897: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   900: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   909: pop
    //   910: goto -103 -> 807
    //   913: astore 6
    //   915: ldc 8
    //   917: new 19	java/lang/StringBuilder
    //   920: dup
    //   921: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   924: ldc 58
    //   926: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: aload_1
    //   930: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: ldc 60
    //   935: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload_2
    //   939: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: ldc 62
    //   944: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: aload 6
    //   949: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   952: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   958: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   961: pop
    //   962: aload 5
    //   964: invokevirtual 84	java/io/OutputStream:close	()V
    //   967: goto -160 -> 807
    //   970: astore 5
    //   972: ldc 8
    //   974: new 19	java/lang/StringBuilder
    //   977: dup
    //   978: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   981: ldc 58
    //   983: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload_1
    //   987: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: ldc 60
    //   992: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: aload_2
    //   996: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: ldc 62
    //   1001: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload 5
    //   1006: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1009: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1018: pop
    //   1019: goto -212 -> 807
    //   1022: astore_0
    //   1023: aload 5
    //   1025: invokevirtual 84	java/io/OutputStream:close	()V
    //   1028: aload_0
    //   1029: athrow
    //   1030: astore 5
    //   1032: ldc 8
    //   1034: new 19	java/lang/StringBuilder
    //   1037: dup
    //   1038: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1041: ldc 58
    //   1043: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: aload_1
    //   1047: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: ldc 60
    //   1052: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: aload_2
    //   1056: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: ldc 62
    //   1061: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload 5
    //   1066: invokevirtual 65	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1069: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1075: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1078: pop
    //   1079: goto -51 -> 1028
    //   1082: astore_0
    //   1083: aload 7
    //   1085: astore 5
    //   1087: goto -311 -> 776
    //   1090: astore 6
    //   1092: aload_0
    //   1093: astore 7
    //   1095: aload 6
    //   1097: astore_0
    //   1098: aload 7
    //   1100: astore 6
    //   1102: goto -326 -> 776
    //   1105: astore_0
    //   1106: aconst_null
    //   1107: astore 5
    //   1109: goto -1008 -> 101
    //   1112: astore_0
    //   1113: goto -1012 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1116	0	paramAssetManager	AssetManager
    //   0	1116	1	paramString1	String
    //   0	1116	2	paramString2	String
    //   75	12	3	i	int
    //   208	32	4	bool	boolean
    //   39	410	5	localFileOutputStream	java.io.FileOutputStream
    //   455	259	5	localIOException1	java.io.IOException
    //   720	35	5	localIOException2	java.io.IOException
    //   774	29	5	localObject1	Object
    //   861	102	5	localIOException3	java.io.IOException
    //   970	54	5	localIOException4	java.io.IOException
    //   1030	35	5	localIOException5	java.io.IOException
    //   1085	23	5	localObject2	Object
    //   1	83	6	localObject3	Object
    //   93	6	6	localIOException6	java.io.IOException
    //   107	675	6	localObject4	Object
    //   809	35	6	localIOException7	java.io.IOException
    //   913	35	6	localIOException8	java.io.IOException
    //   1090	6	6	localObject5	Object
    //   1100	1	6	localObject6	Object
    //   43	1056	7	localObject7	Object
    //   7	154	8	localAssetManager	AssetManager
    //   4	42	9	localObject8	Object
    //   28	165	10	str	String
    // Exception table:
    //   from	to	target	type
    //   62	69	93	java/io/IOException
    //   69	76	93	java/io/IOException
    //   81	90	93	java/io/IOException
    //   188	210	93	java/io/IOException
    //   214	218	242	java/io/IOException
    //   234	239	292	java/io/IOException
    //   223	234	342	java/io/IOException
    //   389	394	397	java/io/IOException
    //   223	234	447	finally
    //   343	389	447	finally
    //   448	453	455	java/io/IOException
    //   160	165	507	java/io/IOException
    //   181	186	557	java/io/IOException
    //   170	181	607	java/io/IOException
    //   654	659	662	java/io/IOException
    //   170	181	712	finally
    //   608	654	712	finally
    //   713	718	720	java/io/IOException
    //   9	41	772	finally
    //   781	786	809	java/io/IOException
    //   802	807	861	java/io/IOException
    //   791	802	913	java/io/IOException
    //   962	967	970	java/io/IOException
    //   791	802	1022	finally
    //   915	962	1022	finally
    //   1023	1028	1030	java/io/IOException
    //   49	62	1082	finally
    //   109	155	1082	finally
    //   62	69	1090	finally
    //   69	76	1090	finally
    //   81	90	1090	finally
    //   188	210	1090	finally
    //   9	41	1105	java/io/IOException
    //   49	62	1112	java/io/IOException
  }
  
  public static boolean copyAssetsDir(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return false;
      try
      {
        AssetManager localAssetManager = paramContext.getAssets();
        String[] arrayOfString1 = localAssetManager.list(paramString1);
        if ((arrayOfString1 != null) && (arrayOfString1.length != 0))
        {
          localObject1 = new File(paramString2);
          if (!((File)localObject1).exists()) {
            ((File)localObject1).mkdir();
          }
          int j = arrayOfString1.length;
          i = 0;
          if (i < j)
          {
            localObject1 = arrayOfString1[i];
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = new File(paramString2, (String)localObject1);
              if (!((File)localObject2).exists()) {
                ((File)localObject2).getParentFile().mkdirs();
              }
              localObject1 = paramString1 + File.separator + (String)localObject1;
              localObject2 = ((File)localObject2).getAbsolutePath();
              String[] arrayOfString2 = localAssetManager.list((String)localObject1);
              if ((arrayOfString2 == null) || (arrayOfString2.length == 0))
              {
                if (copyAssetToFile(localAssetManager, (String)localObject1, (String)localObject2)) {
                  break label274;
                }
                Logger.e("AssetUtil", String.format("copyAssetToFile from=%s, to=%s fail", new Object[] { localObject1, localObject2 }));
                return false;
              }
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          Object localObject1;
          int i;
          Object localObject2;
          for (;;)
          {
            Logger.e("AssetUtil", String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", new Object[] { paramString1, paramString2 }), paramContext);
            try
            {
              paramContext = new File(paramString2);
              if (!paramContext.exists()) {
                break;
              }
              FileUtil.deleteFile(paramContext);
              return false;
            }
            catch (Throwable paramContext)
            {
              return false;
            }
          }
          copyAssetsDir(paramContext, (String)localObject1, (String)localObject2);
          label274:
          i += 1;
        }
      }
    }
    return true;
  }
  
  /* Error */
  public static String loadAssetTextAsString(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 19	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   10: astore 5
    //   12: new 160	java/io/BufferedReader
    //   15: dup
    //   16: new 162	java/io/InputStreamReader
    //   19: dup
    //   20: aload_0
    //   21: invokevirtual 107	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   24: aload_1
    //   25: invokevirtual 43	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: invokespecial 163	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: invokespecial 166	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore_3
    //   35: iconst_1
    //   36: istore_2
    //   37: aload_3
    //   38: astore_0
    //   39: aload_3
    //   40: invokevirtual 169	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload 6
    //   47: ifnull +96 -> 143
    //   50: iload_2
    //   51: ifeq +62 -> 113
    //   54: iconst_0
    //   55: istore_2
    //   56: aload_3
    //   57: astore_0
    //   58: aload 5
    //   60: aload 6
    //   62: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: goto -29 -> 37
    //   69: astore_0
    //   70: aload_3
    //   71: astore_0
    //   72: ldc 8
    //   74: new 19	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   81: ldc 171
    //   83: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   96: pop
    //   97: aload 4
    //   99: astore_0
    //   100: aload_3
    //   101: ifnull +10 -> 111
    //   104: aload_3
    //   105: invokevirtual 172	java/io/BufferedReader:close	()V
    //   108: aload 4
    //   110: astore_0
    //   111: aload_0
    //   112: areturn
    //   113: aload_3
    //   114: astore_0
    //   115: aload 5
    //   117: bipush 10
    //   119: invokevirtual 175	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: goto -67 -> 56
    //   126: astore 4
    //   128: aload_0
    //   129: astore_3
    //   130: aload 4
    //   132: astore_0
    //   133: aload_3
    //   134: ifnull +7 -> 141
    //   137: aload_3
    //   138: invokevirtual 172	java/io/BufferedReader:close	()V
    //   141: aload_0
    //   142: athrow
    //   143: aload_3
    //   144: astore_0
    //   145: aload 5
    //   147: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore 5
    //   152: aload 5
    //   154: astore 4
    //   156: aload 4
    //   158: astore_0
    //   159: aload_3
    //   160: ifnull -49 -> 111
    //   163: aload_3
    //   164: invokevirtual 172	java/io/BufferedReader:close	()V
    //   167: aload 4
    //   169: areturn
    //   170: astore_0
    //   171: ldc 8
    //   173: new 19	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   180: ldc 177
    //   182: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_1
    //   186: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   195: pop
    //   196: aload 4
    //   198: areturn
    //   199: astore_0
    //   200: ldc 8
    //   202: new 19	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   209: ldc 177
    //   211: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   224: pop
    //   225: aconst_null
    //   226: areturn
    //   227: astore_3
    //   228: ldc 8
    //   230: new 19	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   237: ldc 177
    //   239: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_1
    //   243: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   252: pop
    //   253: goto -112 -> 141
    //   256: astore_0
    //   257: aconst_null
    //   258: astore_3
    //   259: goto -126 -> 133
    //   262: astore_0
    //   263: aconst_null
    //   264: astore_3
    //   265: goto -195 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	paramContext	Context
    //   0	268	1	paramString	String
    //   36	20	2	i	int
    //   34	130	3	localObject1	Object
    //   227	1	3	localIOException	java.io.IOException
    //   258	7	3	localObject2	Object
    //   1	108	4	localObject3	Object
    //   126	5	4	localObject4	Object
    //   154	43	4	localObject5	Object
    //   10	143	5	localObject6	Object
    //   43	18	6	str	String
    // Exception table:
    //   from	to	target	type
    //   39	45	69	java/io/IOException
    //   58	66	69	java/io/IOException
    //   115	123	69	java/io/IOException
    //   145	152	69	java/io/IOException
    //   39	45	126	finally
    //   58	66	126	finally
    //   72	97	126	finally
    //   115	123	126	finally
    //   145	152	126	finally
    //   163	167	170	java/io/IOException
    //   104	108	199	java/io/IOException
    //   137	141	227	java/io/IOException
    //   3	35	256	finally
    //   3	35	262	java/io/IOException
  }
  
  /* Error */
  public static String loadFileAsString(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 115	java/io/File:exists	()Z
    //   16: ifeq +81 -> 97
    //   19: aload_0
    //   20: invokevirtual 184	java/io/File:isDirectory	()Z
    //   23: ifeq +35 -> 58
    //   26: ldc 8
    //   28: new 19	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   35: ldc 186
    //   37: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: ldc 191
    //   46: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   55: pop
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: invokevirtual 194	java/io/File:canRead	()Z
    //   62: ifne +67 -> 129
    //   65: ldc 8
    //   67: new 19	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   74: ldc 186
    //   76: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: ldc 196
    //   85: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: aconst_null
    //   96: areturn
    //   97: ldc 8
    //   99: new 19	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   106: ldc 186
    //   108: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: ldc 198
    //   117: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 71	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   126: pop
    //   127: aconst_null
    //   128: areturn
    //   129: new 200	java/io/FileInputStream
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 203	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   137: astore_3
    //   138: new 162	java/io/InputStreamReader
    //   141: dup
    //   142: aload_3
    //   143: ldc 205
    //   145: invokespecial 208	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   148: astore_2
    //   149: aload_0
    //   150: invokevirtual 212	java/io/File:length	()J
    //   153: l2i
    //   154: istore_1
    //   155: iload_1
    //   156: sipush 12288
    //   159: if_icmple +100 -> 259
    //   162: sipush 4096
    //   165: newarray char
    //   167: astore_0
    //   168: new 19	java/lang/StringBuilder
    //   171: dup
    //   172: sipush 12288
    //   175: invokespecial 215	java/lang/StringBuilder:<init>	(I)V
    //   178: astore 5
    //   180: aload_2
    //   181: aload_0
    //   182: invokevirtual 218	java/io/InputStreamReader:read	([C)I
    //   185: istore_1
    //   186: iconst_m1
    //   187: iload_1
    //   188: if_icmpeq +42 -> 230
    //   191: aload 5
    //   193: aload_0
    //   194: iconst_0
    //   195: iload_1
    //   196: invokevirtual 221	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: goto -20 -> 180
    //   203: astore_0
    //   204: aload_2
    //   205: astore_0
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 224	java/io/InputStream:close	()V
    //   214: aload 4
    //   216: astore_3
    //   217: aload_0
    //   218: ifnull -208 -> 10
    //   221: aload_0
    //   222: invokevirtual 225	java/io/InputStreamReader:close	()V
    //   225: aconst_null
    //   226: areturn
    //   227: astore_0
    //   228: aconst_null
    //   229: areturn
    //   230: aload 5
    //   232: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore_0
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 224	java/io/InputStream:close	()V
    //   244: aload_0
    //   245: astore_3
    //   246: aload_2
    //   247: ifnull -237 -> 10
    //   250: aload_2
    //   251: invokevirtual 225	java/io/InputStreamReader:close	()V
    //   254: aload_0
    //   255: areturn
    //   256: astore_2
    //   257: aload_0
    //   258: areturn
    //   259: iload_1
    //   260: newarray char
    //   262: astore_0
    //   263: new 140	java/lang/String
    //   266: dup
    //   267: aload_0
    //   268: iconst_0
    //   269: aload_2
    //   270: aload_0
    //   271: invokevirtual 218	java/io/InputStreamReader:read	([C)I
    //   274: invokespecial 228	java/lang/String:<init>	([CII)V
    //   277: astore_0
    //   278: goto -42 -> 236
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_3
    //   284: aconst_null
    //   285: astore_2
    //   286: aload_3
    //   287: ifnull +7 -> 294
    //   290: aload_3
    //   291: invokevirtual 224	java/io/InputStream:close	()V
    //   294: aload_2
    //   295: ifnull +7 -> 302
    //   298: aload_2
    //   299: invokevirtual 225	java/io/InputStreamReader:close	()V
    //   302: aload_0
    //   303: athrow
    //   304: astore_3
    //   305: goto -61 -> 244
    //   308: astore_2
    //   309: goto -95 -> 214
    //   312: astore_3
    //   313: goto -19 -> 294
    //   316: astore_2
    //   317: goto -15 -> 302
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_2
    //   323: goto -37 -> 286
    //   326: astore_0
    //   327: goto -41 -> 286
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_0
    //   333: aconst_null
    //   334: astore_3
    //   335: goto -129 -> 206
    //   338: astore_0
    //   339: aconst_null
    //   340: astore_0
    //   341: goto -135 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramFile	File
    //   154	106	1	i	int
    //   148	103	2	localInputStreamReader	java.io.InputStreamReader
    //   256	14	2	localException1	java.lang.Exception
    //   285	14	2	localObject1	Object
    //   308	1	2	localException2	java.lang.Exception
    //   316	1	2	localException3	java.lang.Exception
    //   322	1	2	localObject2	Object
    //   9	282	3	localObject3	Object
    //   304	1	3	localException4	java.lang.Exception
    //   312	1	3	localException5	java.lang.Exception
    //   334	1	3	localObject4	Object
    //   1	214	4	localObject5	Object
    //   178	53	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   149	155	203	java/lang/Exception
    //   162	180	203	java/lang/Exception
    //   180	186	203	java/lang/Exception
    //   191	200	203	java/lang/Exception
    //   230	236	203	java/lang/Exception
    //   259	278	203	java/lang/Exception
    //   221	225	227	java/lang/Exception
    //   250	254	256	java/lang/Exception
    //   129	138	281	finally
    //   240	244	304	java/lang/Exception
    //   210	214	308	java/lang/Exception
    //   290	294	312	java/lang/Exception
    //   298	302	316	java/lang/Exception
    //   138	149	320	finally
    //   149	155	326	finally
    //   162	180	326	finally
    //   180	186	326	finally
    //   191	200	326	finally
    //   230	236	326	finally
    //   259	278	326	finally
    //   129	138	330	java/lang/Exception
    //   138	149	338	java/lang/Exception
  }
  
  public static String loadFileAsString(String paramString)
  {
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (!localFile.isFile()))
    {
      Logger.e("AssetUtil", "can not open file " + paramString);
      return null;
    }
    return loadFileAsString(localFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.AssetUtil
 * JD-Core Version:    0.7.0.1
 */