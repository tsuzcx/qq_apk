package com.tencent.mobileqq.pluginsdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"NewApi"})
public class PluginUtils
{
  private static final int BUFFER_LENGTH = 8192;
  public static final String CONFIG_FILE_EXTEND_NAME = ".cfg";
  private static final String SUFFIX_TMP = ".tmp";
  private static Map<String, File> sInstallPathMap = new ConcurrentHashMap();
  private static Map<String, PackageInfo> sPackageInfoMap = new ConcurrentHashMap();
  
  /* Error */
  public static String extractLibs(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 7
    //   3: ldc 41
    //   5: astore 15
    //   7: aload 7
    //   9: astore_1
    //   10: aload 7
    //   12: getstatic 46	java/io/File:separator	Ljava/lang/String;
    //   15: invokevirtual 52	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   18: ifne +31 -> 49
    //   21: new 54	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   28: astore_1
    //   29: aload_1
    //   30: aload 7
    //   32: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_1
    //   37: getstatic 46	java/io/File:separator	Ljava/lang/String;
    //   40: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_1
    //   45: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: astore 11
    //   52: new 65	com/tencent/commonsdk/zip/QZipFile
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 68	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   60: astore 8
    //   62: aload 8
    //   64: astore 9
    //   66: aload 8
    //   68: invokevirtual 72	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   71: astore 13
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: astore 10
    //   78: aload 8
    //   80: astore 9
    //   82: aload 13
    //   84: invokeinterface 78 1 0
    //   89: ifeq +339 -> 428
    //   92: aload_1
    //   93: astore 10
    //   95: aload 8
    //   97: astore 9
    //   99: aload 13
    //   101: invokeinterface 82 1 0
    //   106: checkcast 84	java/util/zip/ZipEntry
    //   109: invokevirtual 87	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   112: astore 7
    //   114: aload_1
    //   115: astore 10
    //   117: aload 8
    //   119: astore 9
    //   121: aload 7
    //   123: getstatic 46	java/io/File:separator	Ljava/lang/String;
    //   126: invokevirtual 52	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   129: ifne -54 -> 75
    //   132: aload_1
    //   133: astore 10
    //   135: aload 8
    //   137: astore 9
    //   139: aload 7
    //   141: ldc 41
    //   143: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   146: ifeq +6 -> 152
    //   149: goto -74 -> 75
    //   152: aload_1
    //   153: astore 10
    //   155: aload 8
    //   157: astore 9
    //   159: new 54	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   166: astore 12
    //   168: aload_1
    //   169: astore 10
    //   171: aload 8
    //   173: astore 9
    //   175: aload 12
    //   177: aload 11
    //   179: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_1
    //   184: astore 10
    //   186: aload 8
    //   188: astore 9
    //   190: aload 12
    //   192: aload 7
    //   194: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_1
    //   199: astore 10
    //   201: aload 8
    //   203: astore 9
    //   205: new 43	java/io/File
    //   208: dup
    //   209: aload 12
    //   211: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   217: astore 12
    //   219: aload_1
    //   220: astore 7
    //   222: aload 7
    //   224: astore_1
    //   225: aload 12
    //   227: ifnull -152 -> 75
    //   230: aload 7
    //   232: astore 10
    //   234: aload 8
    //   236: astore 9
    //   238: aload 12
    //   240: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   243: getstatic 98	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   246: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq +18 -> 267
    //   252: aload 7
    //   254: astore 10
    //   256: aload 8
    //   258: astore 9
    //   260: getstatic 98	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   263: astore_1
    //   264: goto -189 -> 75
    //   267: aload 7
    //   269: astore 10
    //   271: aload 8
    //   273: astore 9
    //   275: getstatic 107	android/os/Build$VERSION:SDK_INT	I
    //   278: bipush 7
    //   280: if_icmple +46 -> 326
    //   283: aload 7
    //   285: astore 10
    //   287: aload 8
    //   289: astore 9
    //   291: aload 12
    //   293: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   296: getstatic 110	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   299: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: ifeq +24 -> 326
    //   305: aload 7
    //   307: ifnonnull +19 -> 326
    //   310: aload 7
    //   312: astore 10
    //   314: aload 8
    //   316: astore 9
    //   318: getstatic 110	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   321: astore 7
    //   323: goto -101 -> 222
    //   326: aload 7
    //   328: astore 10
    //   330: aload 8
    //   332: astore 9
    //   334: getstatic 98	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   337: ldc 112
    //   339: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   342: ifeq +68 -> 410
    //   345: aload 7
    //   347: ifnonnull +63 -> 410
    //   350: aload 7
    //   352: astore 10
    //   354: aload 8
    //   356: astore 9
    //   358: aload 12
    //   360: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   363: ldc 114
    //   365: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   368: ifne +24 -> 392
    //   371: aload 7
    //   373: astore 10
    //   375: aload 8
    //   377: astore 9
    //   379: aload 12
    //   381: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   384: ldc 116
    //   386: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   389: ifeq +21 -> 410
    //   392: aload 7
    //   394: astore 10
    //   396: aload 8
    //   398: astore 9
    //   400: aload 12
    //   402: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   405: astore 7
    //   407: goto -185 -> 222
    //   410: aload 7
    //   412: astore 10
    //   414: aload 8
    //   416: astore 9
    //   418: aload 12
    //   420: invokevirtual 120	java/io/File:getParentFile	()Ljava/io/File;
    //   423: astore 12
    //   425: goto -203 -> 222
    //   428: aload 8
    //   430: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   433: aconst_null
    //   434: astore 7
    //   436: aload_1
    //   437: astore 14
    //   439: goto +52 -> 491
    //   442: astore_1
    //   443: goto +21 -> 464
    //   446: astore_1
    //   447: goto +14 -> 461
    //   450: astore_0
    //   451: aconst_null
    //   452: astore 9
    //   454: goto +1329 -> 1783
    //   457: astore_1
    //   458: aconst_null
    //   459: astore 8
    //   461: aconst_null
    //   462: astore 10
    //   464: aload 8
    //   466: astore 9
    //   468: aload_1
    //   469: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   472: aload 8
    //   474: astore 9
    //   476: aload_1
    //   477: invokestatic 133	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   480: astore 7
    //   482: aload 8
    //   484: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   487: aload 10
    //   489: astore 14
    //   491: aload 7
    //   493: ifnonnull +1278 -> 1771
    //   496: aload 14
    //   498: ifnull +1273 -> 1771
    //   501: new 65	com/tencent/commonsdk/zip/QZipFile
    //   504: dup
    //   505: aload_0
    //   506: invokespecial 68	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   509: astore_0
    //   510: aload_0
    //   511: astore 8
    //   513: aload_0
    //   514: astore 10
    //   516: sipush 4096
    //   519: newarray byte
    //   521: astore 16
    //   523: aload_0
    //   524: astore 8
    //   526: aload_0
    //   527: astore 10
    //   529: aload_0
    //   530: invokevirtual 72	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   533: astore 18
    //   535: aload 7
    //   537: astore_1
    //   538: aload 11
    //   540: astore 7
    //   542: aload_0
    //   543: astore 8
    //   545: aload_0
    //   546: astore 10
    //   548: aload 18
    //   550: invokeinterface 78 1 0
    //   555: ifeq +1154 -> 1709
    //   558: aload_0
    //   559: astore 8
    //   561: aload_0
    //   562: astore 10
    //   564: aload 18
    //   566: invokeinterface 82 1 0
    //   571: checkcast 84	java/util/zip/ZipEntry
    //   574: astore 20
    //   576: aload_0
    //   577: astore 8
    //   579: aload_0
    //   580: astore 10
    //   582: aload 20
    //   584: invokevirtual 87	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   587: astore 11
    //   589: aload_0
    //   590: astore 8
    //   592: aload_0
    //   593: astore 10
    //   595: aload 11
    //   597: getstatic 46	java/io/File:separator	Ljava/lang/String;
    //   600: invokevirtual 52	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   603: ifne +1103 -> 1706
    //   606: aload_0
    //   607: astore 8
    //   609: aload_0
    //   610: astore 10
    //   612: aload 11
    //   614: aload 15
    //   616: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   619: ifeq +6 -> 625
    //   622: goto +1084 -> 1706
    //   625: aload_0
    //   626: astore 8
    //   628: aload_0
    //   629: astore 10
    //   631: new 54	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   638: astore 9
    //   640: aload_0
    //   641: astore 8
    //   643: aload_0
    //   644: astore 10
    //   646: aload 9
    //   648: aload 7
    //   650: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: aload_0
    //   655: astore 8
    //   657: aload_0
    //   658: astore 10
    //   660: aload 9
    //   662: aload 11
    //   664: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload_0
    //   669: astore 8
    //   671: aload_0
    //   672: astore 10
    //   674: new 43	java/io/File
    //   677: dup
    //   678: aload 9
    //   680: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   686: astore 9
    //   688: aload_0
    //   689: astore 8
    //   691: aload_0
    //   692: astore 10
    //   694: aload 11
    //   696: getstatic 46	java/io/File:separator	Ljava/lang/String;
    //   699: invokevirtual 137	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   702: istore_2
    //   703: aload 11
    //   705: astore 17
    //   707: iload_2
    //   708: iconst_m1
    //   709: if_icmpeq +23 -> 732
    //   712: aload_0
    //   713: astore 8
    //   715: aload 11
    //   717: iload_2
    //   718: iconst_1
    //   719: iadd
    //   720: invokevirtual 141	java/lang/String:substring	(I)Ljava/lang/String;
    //   723: astore 17
    //   725: goto +7 -> 732
    //   728: astore_1
    //   729: goto +1014 -> 1743
    //   732: aload_0
    //   733: astore 8
    //   735: aload_0
    //   736: astore 10
    //   738: new 54	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   745: astore 11
    //   747: aload_0
    //   748: astore 8
    //   750: aload_0
    //   751: astore 10
    //   753: aload 11
    //   755: aload 7
    //   757: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload_0
    //   762: astore 8
    //   764: aload_0
    //   765: astore 10
    //   767: aload 11
    //   769: aload 17
    //   771: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload_0
    //   776: astore 8
    //   778: aload_0
    //   779: astore 10
    //   781: new 43	java/io/File
    //   784: dup
    //   785: aload 11
    //   787: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   793: astore 19
    //   795: aload 9
    //   797: astore 10
    //   799: aload 7
    //   801: astore 9
    //   803: aload 10
    //   805: ifnull +41 -> 846
    //   808: aload_0
    //   809: astore 8
    //   811: aload 10
    //   813: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   816: aload 14
    //   818: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   821: ifeq +8 -> 829
    //   824: iconst_1
    //   825: istore_2
    //   826: goto +22 -> 848
    //   829: aload_0
    //   830: astore 8
    //   832: aload 10
    //   834: invokevirtual 120	java/io/File:getParentFile	()Ljava/io/File;
    //   837: astore 10
    //   839: aload 9
    //   841: astore 7
    //   843: goto -44 -> 799
    //   846: iconst_0
    //   847: istore_2
    //   848: aload 9
    //   850: astore 7
    //   852: iload_2
    //   853: ifeq +853 -> 1706
    //   856: aload_0
    //   857: astore 8
    //   859: aload_0
    //   860: astore 10
    //   862: aload 19
    //   864: invokevirtual 120	java/io/File:getParentFile	()Ljava/io/File;
    //   867: invokevirtual 144	java/io/File:mkdirs	()Z
    //   870: pop
    //   871: aload_0
    //   872: aload 20
    //   874: invokevirtual 148	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   877: astore 7
    //   879: new 150	java/io/FileOutputStream
    //   882: dup
    //   883: aload 19
    //   885: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   888: astore 12
    //   890: aload 7
    //   892: aload 16
    //   894: invokevirtual 159	java/io/InputStream:read	([B)I
    //   897: istore_2
    //   898: iload_2
    //   899: ifle +33 -> 932
    //   902: aload_0
    //   903: astore 8
    //   905: aload 7
    //   907: astore 13
    //   909: aload 12
    //   911: astore 11
    //   913: aload 8
    //   915: astore 10
    //   917: aload 12
    //   919: aload 16
    //   921: iconst_0
    //   922: iload_2
    //   923: invokevirtual 163	java/io/FileOutputStream:write	([BII)V
    //   926: aload 8
    //   928: astore_0
    //   929: goto -39 -> 890
    //   932: aload_0
    //   933: astore 8
    //   935: aload 7
    //   937: astore 13
    //   939: aload 12
    //   941: astore 11
    //   943: aload 8
    //   945: astore 10
    //   947: aload 12
    //   949: invokevirtual 166	java/io/FileOutputStream:flush	()V
    //   952: aload 8
    //   954: astore 10
    //   956: aload 8
    //   958: astore 11
    //   960: aload 12
    //   962: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   965: aload 8
    //   967: astore 10
    //   969: aload 8
    //   971: astore 11
    //   973: aload 7
    //   975: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   978: aload_1
    //   979: ifnonnull +207 -> 1186
    //   982: aload 8
    //   984: astore 10
    //   986: aload 8
    //   988: astore 11
    //   990: aload 19
    //   992: invokestatic 174	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   995: lstore_3
    //   996: aload 8
    //   998: astore 10
    //   1000: aload 8
    //   1002: astore 11
    //   1004: aload 20
    //   1006: invokevirtual 178	java/util/zip/ZipEntry:getCrc	()J
    //   1009: lstore 5
    //   1011: aload 8
    //   1013: astore 10
    //   1015: aload 8
    //   1017: astore 11
    //   1019: new 54	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   1026: astore_0
    //   1027: aload 8
    //   1029: astore 10
    //   1031: aload 8
    //   1033: astore 11
    //   1035: aload_0
    //   1036: ldc 180
    //   1038: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: pop
    //   1042: aload 8
    //   1044: astore 10
    //   1046: aload 8
    //   1048: astore 11
    //   1050: aload_0
    //   1051: aload 17
    //   1053: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: aload 8
    //   1059: astore 10
    //   1061: aload 8
    //   1063: astore 11
    //   1065: aload_0
    //   1066: ldc 182
    //   1068: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: pop
    //   1072: aload 8
    //   1074: astore 10
    //   1076: aload 8
    //   1078: astore 11
    //   1080: aload_0
    //   1081: lload 5
    //   1083: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: aload 8
    //   1089: astore 10
    //   1091: aload 8
    //   1093: astore 11
    //   1095: aload_0
    //   1096: ldc 187
    //   1098: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload 8
    //   1104: astore 10
    //   1106: aload 8
    //   1108: astore 11
    //   1110: aload_0
    //   1111: lload_3
    //   1112: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1115: pop
    //   1116: lload 5
    //   1118: lload_3
    //   1119: lcmp
    //   1120: ifeq +45 -> 1165
    //   1123: aload 8
    //   1125: astore 10
    //   1127: aload 8
    //   1129: astore 11
    //   1131: aload_0
    //   1132: ldc 189
    //   1134: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload 8
    //   1140: astore 10
    //   1142: aload 8
    //   1144: astore 11
    //   1146: aload_0
    //   1147: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1150: astore_1
    //   1151: aload 8
    //   1153: astore 10
    //   1155: aload 8
    //   1157: astore 11
    //   1159: aload 19
    //   1161: invokevirtual 192	java/io/File:delete	()Z
    //   1164: pop
    //   1165: aload 8
    //   1167: astore 10
    //   1169: aload 8
    //   1171: astore 11
    //   1173: ldc 194
    //   1175: iconst_1
    //   1176: aload_0
    //   1177: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1183: goto +3 -> 1186
    //   1186: aload 8
    //   1188: astore_0
    //   1189: goto +616 -> 1805
    //   1192: astore 8
    //   1194: goto +10 -> 1204
    //   1197: astore 8
    //   1199: goto +289 -> 1488
    //   1202: astore 8
    //   1204: goto +32 -> 1236
    //   1207: astore 8
    //   1209: goto +13 -> 1222
    //   1212: astore 8
    //   1214: goto +19 -> 1233
    //   1217: astore 8
    //   1219: aconst_null
    //   1220: astore 7
    //   1222: aconst_null
    //   1223: astore 12
    //   1225: goto +263 -> 1488
    //   1228: astore 8
    //   1230: aconst_null
    //   1231: astore 7
    //   1233: aconst_null
    //   1234: astore 12
    //   1236: aload 7
    //   1238: astore 13
    //   1240: aload 12
    //   1242: astore 11
    //   1244: aload_0
    //   1245: astore 10
    //   1247: aload 8
    //   1249: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   1252: aload 7
    //   1254: astore 13
    //   1256: aload 12
    //   1258: astore 11
    //   1260: aload_0
    //   1261: astore 10
    //   1263: aload 8
    //   1265: invokestatic 133	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1268: astore 8
    //   1270: aload_0
    //   1271: astore 10
    //   1273: aload_0
    //   1274: astore 11
    //   1276: aload 12
    //   1278: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   1281: aload_0
    //   1282: astore 10
    //   1284: aload_0
    //   1285: astore 11
    //   1287: aload 7
    //   1289: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   1292: aload 8
    //   1294: ifnonnull +508 -> 1802
    //   1297: aload_0
    //   1298: astore 10
    //   1300: aload_0
    //   1301: astore 11
    //   1303: aload 19
    //   1305: invokestatic 174	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1308: lstore_3
    //   1309: aload_0
    //   1310: astore 10
    //   1312: aload_0
    //   1313: astore 11
    //   1315: aload 20
    //   1317: invokevirtual 178	java/util/zip/ZipEntry:getCrc	()J
    //   1320: lstore 5
    //   1322: aload_0
    //   1323: astore 10
    //   1325: aload_0
    //   1326: astore 11
    //   1328: new 54	java/lang/StringBuilder
    //   1331: dup
    //   1332: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   1335: astore 7
    //   1337: aload_0
    //   1338: astore 10
    //   1340: aload_0
    //   1341: astore 11
    //   1343: aload 7
    //   1345: ldc 180
    //   1347: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: aload_0
    //   1352: astore 10
    //   1354: aload_0
    //   1355: astore 11
    //   1357: aload 7
    //   1359: aload 17
    //   1361: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: pop
    //   1365: aload_0
    //   1366: astore 10
    //   1368: aload_0
    //   1369: astore 11
    //   1371: aload 7
    //   1373: ldc 182
    //   1375: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload_0
    //   1380: astore 10
    //   1382: aload_0
    //   1383: astore 11
    //   1385: aload 7
    //   1387: lload 5
    //   1389: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1392: pop
    //   1393: aload_0
    //   1394: astore 10
    //   1396: aload_0
    //   1397: astore 11
    //   1399: aload 7
    //   1401: ldc 187
    //   1403: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: pop
    //   1407: aload_0
    //   1408: astore 10
    //   1410: aload_0
    //   1411: astore 11
    //   1413: aload 7
    //   1415: lload_3
    //   1416: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1419: pop
    //   1420: lload 5
    //   1422: lload_3
    //   1423: lcmp
    //   1424: ifeq +372 -> 1796
    //   1427: aload_0
    //   1428: astore 10
    //   1430: aload_0
    //   1431: astore 11
    //   1433: aload 7
    //   1435: ldc 189
    //   1437: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1440: pop
    //   1441: aload_0
    //   1442: astore 10
    //   1444: aload_0
    //   1445: astore 11
    //   1447: aload 7
    //   1449: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1452: astore_1
    //   1453: aload_0
    //   1454: astore 10
    //   1456: aload_0
    //   1457: astore 11
    //   1459: aload 19
    //   1461: invokevirtual 192	java/io/File:delete	()Z
    //   1464: pop
    //   1465: goto +3 -> 1468
    //   1468: aload_0
    //   1469: astore 10
    //   1471: aload_0
    //   1472: astore 11
    //   1474: ldc 194
    //   1476: iconst_1
    //   1477: aload 7
    //   1479: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1482: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1485: goto +320 -> 1805
    //   1488: aload_0
    //   1489: astore 10
    //   1491: aload_0
    //   1492: astore 11
    //   1494: aload 12
    //   1496: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   1499: aload_0
    //   1500: astore 10
    //   1502: aload_0
    //   1503: astore 11
    //   1505: aload 7
    //   1507: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   1510: aload_1
    //   1511: ifnonnull +178 -> 1689
    //   1514: aload_0
    //   1515: astore 10
    //   1517: aload_0
    //   1518: astore 11
    //   1520: aload 19
    //   1522: invokestatic 174	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1525: lstore_3
    //   1526: aload_0
    //   1527: astore 10
    //   1529: aload_0
    //   1530: astore 11
    //   1532: aload 20
    //   1534: invokevirtual 178	java/util/zip/ZipEntry:getCrc	()J
    //   1537: lstore 5
    //   1539: aload_0
    //   1540: astore 10
    //   1542: aload_0
    //   1543: astore 11
    //   1545: new 54	java/lang/StringBuilder
    //   1548: dup
    //   1549: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   1552: astore_1
    //   1553: aload_0
    //   1554: astore 10
    //   1556: aload_0
    //   1557: astore 11
    //   1559: aload_1
    //   1560: ldc 180
    //   1562: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1565: pop
    //   1566: aload_0
    //   1567: astore 10
    //   1569: aload_0
    //   1570: astore 11
    //   1572: aload_1
    //   1573: aload 17
    //   1575: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1578: pop
    //   1579: aload_0
    //   1580: astore 10
    //   1582: aload_0
    //   1583: astore 11
    //   1585: aload_1
    //   1586: ldc 182
    //   1588: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: pop
    //   1592: aload_0
    //   1593: astore 10
    //   1595: aload_0
    //   1596: astore 11
    //   1598: aload_1
    //   1599: lload 5
    //   1601: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1604: pop
    //   1605: aload_0
    //   1606: astore 10
    //   1608: aload_0
    //   1609: astore 11
    //   1611: aload_1
    //   1612: ldc 187
    //   1614: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: pop
    //   1618: aload_0
    //   1619: astore 10
    //   1621: aload_0
    //   1622: astore 11
    //   1624: aload_1
    //   1625: lload_3
    //   1626: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1629: pop
    //   1630: lload 5
    //   1632: lload_3
    //   1633: lcmp
    //   1634: ifeq +39 -> 1673
    //   1637: aload_0
    //   1638: astore 10
    //   1640: aload_0
    //   1641: astore 11
    //   1643: aload_1
    //   1644: ldc 189
    //   1646: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: pop
    //   1650: aload_0
    //   1651: astore 10
    //   1653: aload_0
    //   1654: astore 11
    //   1656: aload_1
    //   1657: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1660: pop
    //   1661: aload_0
    //   1662: astore 10
    //   1664: aload_0
    //   1665: astore 11
    //   1667: aload 19
    //   1669: invokevirtual 192	java/io/File:delete	()Z
    //   1672: pop
    //   1673: aload_0
    //   1674: astore 10
    //   1676: aload_0
    //   1677: astore 11
    //   1679: ldc 194
    //   1681: iconst_1
    //   1682: aload_1
    //   1683: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1686: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1689: aload_0
    //   1690: astore 10
    //   1692: aload_0
    //   1693: astore 11
    //   1695: aload 8
    //   1697: athrow
    //   1698: astore_0
    //   1699: goto +65 -> 1764
    //   1702: astore_0
    //   1703: goto +22 -> 1725
    //   1706: goto -1164 -> 542
    //   1709: goto +67 -> 1776
    //   1712: astore_0
    //   1713: aload 8
    //   1715: astore 10
    //   1717: goto +47 -> 1764
    //   1720: astore_0
    //   1721: aload 10
    //   1723: astore 11
    //   1725: aload_0
    //   1726: astore_1
    //   1727: aload 11
    //   1729: astore_0
    //   1730: goto +13 -> 1743
    //   1733: astore_0
    //   1734: aconst_null
    //   1735: astore 10
    //   1737: goto +27 -> 1764
    //   1740: astore_1
    //   1741: aconst_null
    //   1742: astore_0
    //   1743: aload_1
    //   1744: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   1747: aload_1
    //   1748: invokestatic 133	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1751: astore_1
    //   1752: aload_0
    //   1753: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   1756: aload_1
    //   1757: areturn
    //   1758: astore_1
    //   1759: aload_0
    //   1760: astore 10
    //   1762: aload_1
    //   1763: astore_0
    //   1764: aload 10
    //   1766: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   1769: aload_0
    //   1770: athrow
    //   1771: aconst_null
    //   1772: astore_0
    //   1773: aload 7
    //   1775: astore_1
    //   1776: aload_0
    //   1777: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   1780: aload_1
    //   1781: areturn
    //   1782: astore_0
    //   1783: aload 9
    //   1785: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   1788: goto +5 -> 1793
    //   1791: aload_0
    //   1792: athrow
    //   1793: goto -2 -> 1791
    //   1796: aload 8
    //   1798: astore_1
    //   1799: goto -331 -> 1468
    //   1802: aload 8
    //   1804: astore_1
    //   1805: aload_1
    //   1806: ifnull +6 -> 1812
    //   1809: goto -33 -> 1776
    //   1812: aload 9
    //   1814: astore 7
    //   1816: goto -110 -> 1706
    //   1819: astore 8
    //   1821: aload 13
    //   1823: astore 7
    //   1825: aload 11
    //   1827: astore 12
    //   1829: aload 10
    //   1831: astore_0
    //   1832: goto -344 -> 1488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1835	0	paramString1	String
    //   0	1835	1	paramString2	String
    //   702	221	2	i	int
    //   995	638	3	l1	long
    //   1009	622	5	l2	long
    //   1	1823	7	localObject1	Object
    //   60	1127	8	localObject2	Object
    //   1192	1	8	localIOException1	java.io.IOException
    //   1197	1	8	localObject3	Object
    //   1202	1	8	localIOException2	java.io.IOException
    //   1207	1	8	localObject4	Object
    //   1212	1	8	localIOException3	java.io.IOException
    //   1217	1	8	localObject5	Object
    //   1228	36	8	localIOException4	java.io.IOException
    //   1268	535	8	str1	String
    //   1819	1	8	localObject6	Object
    //   64	1749	9	localObject7	Object
    //   76	1754	10	localObject8	Object
    //   50	1776	11	localObject9	Object
    //   166	1662	12	localObject10	Object
    //   71	1751	13	localObject11	Object
    //   437	380	14	localObject12	Object
    //   5	610	15	str2	String
    //   521	399	16	arrayOfByte	byte[]
    //   705	869	17	localObject13	Object
    //   533	32	18	localEnumeration	java.util.Enumeration
    //   793	875	19	localFile	File
    //   574	959	20	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   82	92	442	java/io/IOException
    //   99	114	442	java/io/IOException
    //   121	132	442	java/io/IOException
    //   139	149	442	java/io/IOException
    //   159	168	442	java/io/IOException
    //   175	183	442	java/io/IOException
    //   190	198	442	java/io/IOException
    //   205	219	442	java/io/IOException
    //   238	252	442	java/io/IOException
    //   260	264	442	java/io/IOException
    //   275	283	442	java/io/IOException
    //   291	305	442	java/io/IOException
    //   318	323	442	java/io/IOException
    //   334	345	442	java/io/IOException
    //   358	371	442	java/io/IOException
    //   379	392	442	java/io/IOException
    //   400	407	442	java/io/IOException
    //   418	425	442	java/io/IOException
    //   66	73	446	java/io/IOException
    //   52	62	450	finally
    //   52	62	457	java/io/IOException
    //   715	725	728	java/io/IOException
    //   811	824	728	java/io/IOException
    //   832	839	728	java/io/IOException
    //   917	926	1192	java/io/IOException
    //   947	952	1192	java/io/IOException
    //   890	898	1197	finally
    //   890	898	1202	java/io/IOException
    //   879	890	1207	finally
    //   879	890	1212	java/io/IOException
    //   871	879	1217	finally
    //   871	879	1228	java/io/IOException
    //   960	965	1698	finally
    //   973	978	1698	finally
    //   990	996	1698	finally
    //   1004	1011	1698	finally
    //   1019	1027	1698	finally
    //   1035	1042	1698	finally
    //   1050	1057	1698	finally
    //   1065	1072	1698	finally
    //   1080	1087	1698	finally
    //   1095	1102	1698	finally
    //   1110	1116	1698	finally
    //   1131	1138	1698	finally
    //   1146	1151	1698	finally
    //   1159	1165	1698	finally
    //   1173	1183	1698	finally
    //   1276	1281	1698	finally
    //   1287	1292	1698	finally
    //   1303	1309	1698	finally
    //   1315	1322	1698	finally
    //   1328	1337	1698	finally
    //   1343	1351	1698	finally
    //   1357	1365	1698	finally
    //   1371	1379	1698	finally
    //   1385	1393	1698	finally
    //   1399	1407	1698	finally
    //   1413	1420	1698	finally
    //   1433	1441	1698	finally
    //   1447	1453	1698	finally
    //   1459	1465	1698	finally
    //   1474	1485	1698	finally
    //   1494	1499	1698	finally
    //   1505	1510	1698	finally
    //   1520	1526	1698	finally
    //   1532	1539	1698	finally
    //   1545	1553	1698	finally
    //   1559	1566	1698	finally
    //   1572	1579	1698	finally
    //   1585	1592	1698	finally
    //   1598	1605	1698	finally
    //   1611	1618	1698	finally
    //   1624	1630	1698	finally
    //   1643	1650	1698	finally
    //   1656	1661	1698	finally
    //   1667	1673	1698	finally
    //   1679	1689	1698	finally
    //   1695	1698	1698	finally
    //   960	965	1702	java/io/IOException
    //   973	978	1702	java/io/IOException
    //   990	996	1702	java/io/IOException
    //   1004	1011	1702	java/io/IOException
    //   1019	1027	1702	java/io/IOException
    //   1035	1042	1702	java/io/IOException
    //   1050	1057	1702	java/io/IOException
    //   1065	1072	1702	java/io/IOException
    //   1080	1087	1702	java/io/IOException
    //   1095	1102	1702	java/io/IOException
    //   1110	1116	1702	java/io/IOException
    //   1131	1138	1702	java/io/IOException
    //   1146	1151	1702	java/io/IOException
    //   1159	1165	1702	java/io/IOException
    //   1173	1183	1702	java/io/IOException
    //   1276	1281	1702	java/io/IOException
    //   1287	1292	1702	java/io/IOException
    //   1303	1309	1702	java/io/IOException
    //   1315	1322	1702	java/io/IOException
    //   1328	1337	1702	java/io/IOException
    //   1343	1351	1702	java/io/IOException
    //   1357	1365	1702	java/io/IOException
    //   1371	1379	1702	java/io/IOException
    //   1385	1393	1702	java/io/IOException
    //   1399	1407	1702	java/io/IOException
    //   1413	1420	1702	java/io/IOException
    //   1433	1441	1702	java/io/IOException
    //   1447	1453	1702	java/io/IOException
    //   1459	1465	1702	java/io/IOException
    //   1474	1485	1702	java/io/IOException
    //   1494	1499	1702	java/io/IOException
    //   1505	1510	1702	java/io/IOException
    //   1520	1526	1702	java/io/IOException
    //   1532	1539	1702	java/io/IOException
    //   1545	1553	1702	java/io/IOException
    //   1559	1566	1702	java/io/IOException
    //   1572	1579	1702	java/io/IOException
    //   1585	1592	1702	java/io/IOException
    //   1598	1605	1702	java/io/IOException
    //   1611	1618	1702	java/io/IOException
    //   1624	1630	1702	java/io/IOException
    //   1643	1650	1702	java/io/IOException
    //   1656	1661	1702	java/io/IOException
    //   1667	1673	1702	java/io/IOException
    //   1679	1689	1702	java/io/IOException
    //   1695	1698	1702	java/io/IOException
    //   516	523	1712	finally
    //   529	535	1712	finally
    //   548	558	1712	finally
    //   564	576	1712	finally
    //   582	589	1712	finally
    //   595	606	1712	finally
    //   612	622	1712	finally
    //   631	640	1712	finally
    //   646	654	1712	finally
    //   660	668	1712	finally
    //   674	688	1712	finally
    //   694	703	1712	finally
    //   715	725	1712	finally
    //   738	747	1712	finally
    //   753	761	1712	finally
    //   767	775	1712	finally
    //   781	795	1712	finally
    //   811	824	1712	finally
    //   832	839	1712	finally
    //   862	871	1712	finally
    //   516	523	1720	java/io/IOException
    //   529	535	1720	java/io/IOException
    //   548	558	1720	java/io/IOException
    //   564	576	1720	java/io/IOException
    //   582	589	1720	java/io/IOException
    //   595	606	1720	java/io/IOException
    //   612	622	1720	java/io/IOException
    //   631	640	1720	java/io/IOException
    //   646	654	1720	java/io/IOException
    //   660	668	1720	java/io/IOException
    //   674	688	1720	java/io/IOException
    //   694	703	1720	java/io/IOException
    //   738	747	1720	java/io/IOException
    //   753	761	1720	java/io/IOException
    //   767	775	1720	java/io/IOException
    //   781	795	1720	java/io/IOException
    //   862	871	1720	java/io/IOException
    //   501	510	1733	finally
    //   501	510	1740	java/io/IOException
    //   1743	1752	1758	finally
    //   66	73	1782	finally
    //   82	92	1782	finally
    //   99	114	1782	finally
    //   121	132	1782	finally
    //   139	149	1782	finally
    //   159	168	1782	finally
    //   175	183	1782	finally
    //   190	198	1782	finally
    //   205	219	1782	finally
    //   238	252	1782	finally
    //   260	264	1782	finally
    //   275	283	1782	finally
    //   291	305	1782	finally
    //   318	323	1782	finally
    //   334	345	1782	finally
    //   358	371	1782	finally
    //   379	392	1782	finally
    //   400	407	1782	finally
    //   418	425	1782	finally
    //   468	472	1782	finally
    //   476	482	1782	finally
    //   917	926	1819	finally
    //   947	952	1819	finally
    //   1247	1252	1819	finally
    //   1263	1270	1819	finally
  }
  
  /* Error */
  public static void extractPlugin(Context paramContext, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 207	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: astore 7
    //   6: new 54	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc 209
    //   19: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 6
    //   25: aload 7
    //   27: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 6
    //   33: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 214	com/tencent/mobileqq/pluginsdk/DebugHelper:debug	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: ldc 216
    //   42: ldc 218
    //   44: invokevirtual 221	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 6
    //   49: aload_2
    //   50: invokevirtual 224	java/io/File:exists	()Z
    //   53: ifeq +8 -> 61
    //   56: aload_2
    //   57: invokevirtual 192	java/io/File:delete	()Z
    //   60: pop
    //   61: new 54	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   68: astore_1
    //   69: aload_1
    //   70: aload 7
    //   72: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_1
    //   77: ldc 17
    //   79: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: new 43	java/io/File
    //   86: dup
    //   87: aload_1
    //   88: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore 8
    //   96: aload 8
    //   98: invokevirtual 224	java/io/File:exists	()Z
    //   101: ifeq +9 -> 110
    //   104: aload 8
    //   106: invokevirtual 192	java/io/File:delete	()Z
    //   109: pop
    //   110: aload 8
    //   112: invokevirtual 227	java/io/File:createNewFile	()Z
    //   115: pop
    //   116: aconst_null
    //   117: astore_1
    //   118: aconst_null
    //   119: astore 7
    //   121: aload_0
    //   122: invokevirtual 233	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   125: astore_0
    //   126: new 54	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   133: astore 9
    //   135: aload 9
    //   137: ldc 235
    //   139: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 9
    //   145: aload 6
    //   147: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_0
    //   152: aload 9
    //   154: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 241	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   160: astore 6
    //   162: new 150	java/io/FileOutputStream
    //   165: dup
    //   166: aload 8
    //   168: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   171: astore_0
    //   172: sipush 8192
    //   175: newarray byte
    //   177: astore_1
    //   178: aload 6
    //   180: aload_1
    //   181: invokevirtual 159	java/io/InputStream:read	([B)I
    //   184: istore_3
    //   185: iload_3
    //   186: iconst_m1
    //   187: if_icmpeq +13 -> 200
    //   190: aload_0
    //   191: aload_1
    //   192: iconst_0
    //   193: iload_3
    //   194: invokevirtual 244	java/io/OutputStream:write	([BII)V
    //   197: goto -19 -> 178
    //   200: aload 6
    //   202: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   205: aload_0
    //   206: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   209: aload_2
    //   210: invokevirtual 224	java/io/File:exists	()Z
    //   213: ifeq +12 -> 225
    //   216: aload_2
    //   217: invokevirtual 192	java/io/File:delete	()Z
    //   220: istore 4
    //   222: goto +6 -> 228
    //   225: iconst_1
    //   226: istore 4
    //   228: aload 8
    //   230: aload_2
    //   231: invokevirtual 248	java/io/File:renameTo	(Ljava/io/File;)Z
    //   234: istore 5
    //   236: new 54	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   243: astore_0
    //   244: aload_0
    //   245: ldc 209
    //   247: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_0
    //   252: iload 4
    //   254: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_0
    //   259: ldc 253
    //   261: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_0
    //   266: iload 5
    //   268: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: ldc 194
    //   274: iconst_1
    //   275: aload_0
    //   276: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: return
    //   283: astore_1
    //   284: aload_0
    //   285: astore_2
    //   286: aload_1
    //   287: astore_0
    //   288: goto +12 -> 300
    //   291: astore_1
    //   292: aload_0
    //   293: astore_2
    //   294: goto +18 -> 312
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_2
    //   300: aload 6
    //   302: astore_1
    //   303: aload_0
    //   304: astore 6
    //   306: goto +40 -> 346
    //   309: astore_1
    //   310: aconst_null
    //   311: astore_2
    //   312: aload 6
    //   314: astore_0
    //   315: goto +16 -> 331
    //   318: astore 6
    //   320: aconst_null
    //   321: astore_2
    //   322: goto +24 -> 346
    //   325: astore_1
    //   326: aconst_null
    //   327: astore_2
    //   328: aload 7
    //   330: astore_0
    //   331: new 204	java/lang/Exception
    //   334: dup
    //   335: ldc 209
    //   337: aload_1
    //   338: invokespecial 256	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   341: athrow
    //   342: astore 6
    //   344: aload_0
    //   345: astore_1
    //   346: aload_1
    //   347: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   350: aload_2
    //   351: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   354: goto +6 -> 360
    //   357: aload 6
    //   359: athrow
    //   360: goto -3 -> 357
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramContext	Context
    //   0	363	1	paramString	String
    //   0	363	2	paramFile	File
    //   184	10	3	i	int
    //   220	33	4	bool1	boolean
    //   234	33	5	bool2	boolean
    //   13	300	6	localObject1	Object
    //   318	1	6	localObject2	Object
    //   342	16	6	localObject3	Object
    //   4	325	7	str	String
    //   94	135	8	localFile	File
    //   133	20	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   172	178	283	finally
    //   178	185	283	finally
    //   190	197	283	finally
    //   172	178	291	java/lang/Exception
    //   178	185	291	java/lang/Exception
    //   190	197	291	java/lang/Exception
    //   162	172	297	finally
    //   162	172	309	java/lang/Exception
    //   121	162	318	finally
    //   121	162	325	java/lang/Exception
    //   331	342	342	finally
  }
  
  /* Error */
  public static String extractPluginAndGetMd5Code(Context paramContext, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 207	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: astore 8
    //   6: new 54	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc 209
    //   19: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 6
    //   25: aload 8
    //   27: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 6
    //   33: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 214	com/tencent/mobileqq/pluginsdk/DebugHelper:debug	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: ldc 216
    //   42: ldc 218
    //   44: invokevirtual 221	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 6
    //   49: aload_2
    //   50: invokevirtual 224	java/io/File:exists	()Z
    //   53: ifeq +8 -> 61
    //   56: aload_2
    //   57: invokevirtual 192	java/io/File:delete	()Z
    //   60: pop
    //   61: new 54	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   68: astore_1
    //   69: aload_1
    //   70: aload 8
    //   72: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_1
    //   77: ldc 17
    //   79: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: new 43	java/io/File
    //   86: dup
    //   87: aload_1
    //   88: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore 9
    //   96: aload 9
    //   98: invokevirtual 224	java/io/File:exists	()Z
    //   101: ifeq +9 -> 110
    //   104: aload 9
    //   106: invokevirtual 192	java/io/File:delete	()Z
    //   109: pop
    //   110: aload 9
    //   112: invokevirtual 227	java/io/File:createNewFile	()Z
    //   115: pop
    //   116: aconst_null
    //   117: astore_1
    //   118: aconst_null
    //   119: astore 7
    //   121: aload_0
    //   122: invokevirtual 233	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   125: astore_0
    //   126: new 54	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   133: astore 10
    //   135: aload 10
    //   137: ldc 235
    //   139: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 10
    //   145: aload 6
    //   147: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_0
    //   152: aload 10
    //   154: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 241	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   160: astore 6
    //   162: new 150	java/io/FileOutputStream
    //   165: dup
    //   166: aload 9
    //   168: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   171: astore_0
    //   172: sipush 8192
    //   175: newarray byte
    //   177: astore_1
    //   178: aload 6
    //   180: aload_1
    //   181: invokevirtual 159	java/io/InputStream:read	([B)I
    //   184: istore_3
    //   185: iload_3
    //   186: iconst_m1
    //   187: if_icmpeq +13 -> 200
    //   190: aload_0
    //   191: aload_1
    //   192: iconst_0
    //   193: iload_3
    //   194: invokevirtual 244	java/io/OutputStream:write	([BII)V
    //   197: goto -19 -> 178
    //   200: aload 6
    //   202: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   205: aload_0
    //   206: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   209: aload_2
    //   210: invokevirtual 224	java/io/File:exists	()Z
    //   213: ifeq +12 -> 225
    //   216: aload_2
    //   217: invokevirtual 192	java/io/File:delete	()Z
    //   220: istore 4
    //   222: goto +6 -> 228
    //   225: iconst_1
    //   226: istore 4
    //   228: aload 9
    //   230: aload_2
    //   231: invokevirtual 248	java/io/File:renameTo	(Ljava/io/File;)Z
    //   234: istore 5
    //   236: iload 5
    //   238: ifeq +12 -> 250
    //   241: aload 8
    //   243: invokestatic 263	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   246: astore_0
    //   247: goto +7 -> 254
    //   250: ldc_w 265
    //   253: astore_0
    //   254: new 54	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   261: astore_1
    //   262: aload_1
    //   263: ldc 209
    //   265: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_1
    //   270: iload 4
    //   272: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_1
    //   277: ldc 253
    //   279: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_1
    //   284: iload 5
    //   286: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: ldc 194
    //   292: iconst_1
    //   293: aload_1
    //   294: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_0
    //   301: areturn
    //   302: astore_1
    //   303: aload_0
    //   304: astore_2
    //   305: aload_1
    //   306: astore_0
    //   307: goto +12 -> 319
    //   310: astore_1
    //   311: aload_0
    //   312: astore_2
    //   313: goto +18 -> 331
    //   316: astore_0
    //   317: aconst_null
    //   318: astore_2
    //   319: aload 6
    //   321: astore_1
    //   322: aload_0
    //   323: astore 6
    //   325: goto +40 -> 365
    //   328: astore_1
    //   329: aconst_null
    //   330: astore_2
    //   331: aload 6
    //   333: astore_0
    //   334: goto +16 -> 350
    //   337: astore 6
    //   339: aconst_null
    //   340: astore_2
    //   341: goto +24 -> 365
    //   344: astore_1
    //   345: aconst_null
    //   346: astore_2
    //   347: aload 7
    //   349: astore_0
    //   350: new 204	java/lang/Exception
    //   353: dup
    //   354: ldc 209
    //   356: aload_1
    //   357: invokespecial 256	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: athrow
    //   361: astore 6
    //   363: aload_0
    //   364: astore_1
    //   365: aload_1
    //   366: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   369: aload_2
    //   370: invokestatic 170	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   373: goto +6 -> 379
    //   376: aload 6
    //   378: athrow
    //   379: goto -3 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	paramContext	Context
    //   0	382	1	paramString	String
    //   0	382	2	paramFile	File
    //   184	10	3	i	int
    //   220	51	4	bool1	boolean
    //   234	51	5	bool2	boolean
    //   13	319	6	localObject1	Object
    //   337	1	6	localObject2	Object
    //   361	16	6	localObject3	Object
    //   119	229	7	localObject4	Object
    //   4	238	8	str	String
    //   94	135	9	localFile	File
    //   133	20	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   172	178	302	finally
    //   178	185	302	finally
    //   190	197	302	finally
    //   172	178	310	java/lang/Exception
    //   178	185	310	java/lang/Exception
    //   190	197	310	java/lang/Exception
    //   162	172	316	finally
    //   162	172	328	java/lang/Exception
    //   121	162	337	finally
    //   121	162	344	java/lang/Exception
    //   350	361	361	finally
  }
  
  public static String getExceptionInfo(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter, true));
    return localStringWriter.getBuffer().toString();
  }
  
  @Deprecated
  private static File getInstallPluginPath(Context paramContext, String paramString)
  {
    File localFile2 = (File)sInstallPathMap.get(paramString);
    File localFile1 = localFile2;
    if (localFile2 == null)
    {
      localFile1 = getPluginInstallDir(paramContext);
      if (localFile1 == null) {
        return null;
      }
      int i = paramString.lastIndexOf('.');
      if ((i != -1) && (!paramString.substring(i).equalsIgnoreCase(".apk")))
      {
        paramContext = new StringBuilder();
        paramContext.append(paramString.substring(0, i));
        paramContext.append(".apk");
        paramContext = paramContext.toString();
      }
      else
      {
        paramContext = paramString;
        if (i == -1)
        {
          paramContext = new StringBuilder();
          paramContext.append(paramString);
          paramContext.append(".apk");
          paramContext = paramContext.toString();
        }
      }
      localFile1 = new File(localFile1, paramContext);
      sInstallPathMap.put(paramContext, localFile1);
    }
    return localFile1;
  }
  
  public static File getInstalledPluginPath(Context paramContext, String paramString)
  {
    PluginBaseInfo localPluginBaseInfo = PluginBaseInfoHelper.createFromFile(getPluginCfgFile(getPluginInstallDir(paramContext), paramString), PluginBaseInfo.class);
    if ((localPluginBaseInfo != null) && (localPluginBaseInfo.mState == 4) && (localPluginBaseInfo.mInstalledPath != null))
    {
      if (PluginStatic.isValidPluginPath(localPluginBaseInfo.mInstalledPath)) {
        return new File(localPluginBaseInfo.mInstalledPath);
      }
      return null;
    }
    return getInstallPluginPath(paramContext, paramString);
  }
  
  public static String getMultiDexName(String paramString, int paramInt)
  {
    return String.format("%s_%d.dex", new Object[] { paramString.substring(0, paramString.lastIndexOf(".")), Integer.valueOf(paramInt) });
  }
  
  public static File getMultiDexSecondDex(Context paramContext, String paramString)
  {
    return new File(getPluginInstallDir(paramContext), getMultiDexName(paramString, 2));
  }
  
  public static File getOptimizedDexPath(Context paramContext)
  {
    return paramContext.getDir("odex", 0);
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    PackageInfo localPackageInfo = (PackageInfo)sPackageInfoMap.get(paramString);
    paramContext = localPackageInfo;
    if (localPackageInfo == null)
    {
      DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo start");
      localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, 128);
      DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo end");
      paramContext = localPackageInfo;
      if (localPackageInfo != null)
      {
        sPackageInfoMap.put(paramString, localPackageInfo);
        paramContext = localPackageInfo;
      }
    }
    return paramContext;
  }
  
  public static File getPluginCfgFile(File paramFile, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".cfg");
    return new File(paramFile, localStringBuilder.toString());
  }
  
  public static File getPluginInstallDir(Context paramContext)
  {
    return paramContext.getDir("installed_plugin", 0);
  }
  
  public static File getPluginLibPath(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.endsWith(".apk")) {
      str = paramString.substring(0, paramString.length() - 4);
    }
    return new File(paramContext.getDir("lib", 0), str);
  }
  
  public static boolean isOsNeedReleaseDex()
  {
    return Build.VERSION.SDK_INT <= 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginUtils
 * JD-Core Version:    0.7.0.1
 */