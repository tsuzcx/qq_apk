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
    //   1: astore 12
    //   3: aload_1
    //   4: getstatic 44	java/io/File:separator	Ljava/lang/String;
    //   7: invokevirtual 50	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   10: ifne +25 -> 35
    //   13: new 52	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   20: aload_1
    //   21: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 44	java/io/File:separator	Ljava/lang/String;
    //   27: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 12
    //   35: aconst_null
    //   36: astore_1
    //   37: new 63	com/tencent/commonsdk/zip/QZipFile
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 66	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   45: astore 8
    //   47: aload 8
    //   49: invokevirtual 70	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   52: astore 11
    //   54: aload 11
    //   56: invokeinterface 76 1 0
    //   61: ifeq +199 -> 260
    //   64: aload 11
    //   66: invokeinterface 80 1 0
    //   71: checkcast 82	java/util/zip/ZipEntry
    //   74: invokevirtual 85	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   77: astore 9
    //   79: aload 9
    //   81: getstatic 44	java/io/File:separator	Ljava/lang/String;
    //   84: invokevirtual 50	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   87: ifne -33 -> 54
    //   90: aload 9
    //   92: ldc 87
    //   94: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   97: ifne -43 -> 54
    //   100: new 41	java/io/File
    //   103: dup
    //   104: new 52	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   111: aload 12
    //   113: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 9
    //   118: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   127: astore 10
    //   129: aload_1
    //   130: astore 9
    //   132: aload 10
    //   134: ifnull +1227 -> 1361
    //   137: aload 10
    //   139: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   142: getstatic 98	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   145: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   148: ifeq +11 -> 159
    //   151: getstatic 98	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   154: astore 9
    //   156: goto +1205 -> 1361
    //   159: getstatic 107	android/os/Build$VERSION:SDK_INT	I
    //   162: bipush 7
    //   164: if_icmple +32 -> 196
    //   167: aload 10
    //   169: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   172: getstatic 110	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   175: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   178: ifeq +18 -> 196
    //   181: aload_1
    //   182: ifnonnull +14 -> 196
    //   185: getstatic 110	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   188: astore 9
    //   190: aload 9
    //   192: astore_1
    //   193: goto -64 -> 129
    //   196: getstatic 98	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   199: ldc 112
    //   201: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifeq +46 -> 250
    //   207: aload_1
    //   208: ifnonnull +42 -> 250
    //   211: aload 10
    //   213: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   216: ldc 114
    //   218: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifne +16 -> 237
    //   224: aload 10
    //   226: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   229: ldc 116
    //   231: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +16 -> 250
    //   237: aload 10
    //   239: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   242: astore 9
    //   244: aload 9
    //   246: astore_1
    //   247: goto -118 -> 129
    //   250: aload 10
    //   252: invokevirtual 120	java/io/File:getParentFile	()Ljava/io/File;
    //   255: astore 10
    //   257: goto -128 -> 129
    //   260: aload 8
    //   262: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   265: aconst_null
    //   266: astore 8
    //   268: aload_1
    //   269: astore 13
    //   271: aload 8
    //   273: ifnonnull +1080 -> 1353
    //   276: aload 13
    //   278: ifnull +1075 -> 1353
    //   281: new 63	com/tencent/commonsdk/zip/QZipFile
    //   284: dup
    //   285: aload_0
    //   286: invokespecial 66	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   289: astore_1
    //   290: aload_1
    //   291: astore 9
    //   293: sipush 4096
    //   296: newarray byte
    //   298: astore 16
    //   300: aload_1
    //   301: astore 9
    //   303: aload_1
    //   304: invokevirtual 70	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   307: astore 17
    //   309: aload 8
    //   311: astore_0
    //   312: aload_1
    //   313: astore 9
    //   315: aload 17
    //   317: invokeinterface 76 1 0
    //   322: ifeq +1028 -> 1350
    //   325: aload_1
    //   326: astore 9
    //   328: aload 17
    //   330: invokeinterface 80 1 0
    //   335: checkcast 82	java/util/zip/ZipEntry
    //   338: astore 19
    //   340: aload_1
    //   341: astore 9
    //   343: aload 19
    //   345: invokevirtual 85	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   348: astore 14
    //   350: aload_1
    //   351: astore 9
    //   353: aload 14
    //   355: getstatic 44	java/io/File:separator	Ljava/lang/String;
    //   358: invokevirtual 50	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   361: ifne -49 -> 312
    //   364: aload_1
    //   365: astore 9
    //   367: aload 14
    //   369: ldc 87
    //   371: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   374: ifne -62 -> 312
    //   377: aload_1
    //   378: astore 9
    //   380: new 41	java/io/File
    //   383: dup
    //   384: new 52	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   391: aload 12
    //   393: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload 14
    //   398: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   407: astore 8
    //   409: aload_1
    //   410: astore 9
    //   412: aload 14
    //   414: getstatic 44	java/io/File:separator	Ljava/lang/String;
    //   417: invokevirtual 130	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   420: istore_2
    //   421: iload_2
    //   422: iconst_m1
    //   423: if_icmpeq +924 -> 1347
    //   426: aload_1
    //   427: astore 9
    //   429: aload 14
    //   431: iload_2
    //   432: iconst_1
    //   433: iadd
    //   434: invokevirtual 134	java/lang/String:substring	(I)Ljava/lang/String;
    //   437: astore 14
    //   439: aload_1
    //   440: astore 9
    //   442: new 41	java/io/File
    //   445: dup
    //   446: new 52	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   453: aload 12
    //   455: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload 14
    //   460: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   469: astore 18
    //   471: iconst_0
    //   472: istore_3
    //   473: iload_3
    //   474: istore_2
    //   475: aload 8
    //   477: ifnull +21 -> 498
    //   480: aload_1
    //   481: astore 9
    //   483: aload 8
    //   485: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   488: aload 13
    //   490: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   493: ifeq +365 -> 858
    //   496: iconst_1
    //   497: istore_2
    //   498: iload_2
    //   499: ifeq +764 -> 1263
    //   502: aload_1
    //   503: astore 9
    //   505: aload 18
    //   507: invokevirtual 120	java/io/File:getParentFile	()Ljava/io/File;
    //   510: invokevirtual 137	java/io/File:mkdirs	()Z
    //   513: pop
    //   514: aconst_null
    //   515: astore 10
    //   517: aconst_null
    //   518: astore 9
    //   520: aload_1
    //   521: aload 19
    //   523: invokevirtual 141	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   526: astore 8
    //   528: aload 8
    //   530: astore 9
    //   532: aload 8
    //   534: astore 10
    //   536: new 143	java/io/FileOutputStream
    //   539: dup
    //   540: aload 18
    //   542: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   545: astore 15
    //   547: aload 8
    //   549: astore 11
    //   551: aload 15
    //   553: astore 9
    //   555: aload 8
    //   557: aload 16
    //   559: invokevirtual 152	java/io/InputStream:read	([B)I
    //   562: istore_2
    //   563: iload_2
    //   564: ifle +307 -> 871
    //   567: aload 8
    //   569: astore 11
    //   571: aload 15
    //   573: astore 9
    //   575: aload 15
    //   577: aload 16
    //   579: iconst_0
    //   580: iload_2
    //   581: invokevirtual 156	java/io/FileOutputStream:write	([BII)V
    //   584: goto -37 -> 547
    //   587: astore 9
    //   589: aload 15
    //   591: astore 10
    //   593: aload 9
    //   595: astore 15
    //   597: aload 8
    //   599: astore 11
    //   601: aload 10
    //   603: astore 9
    //   605: aload 15
    //   607: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   610: aload 8
    //   612: astore 11
    //   614: aload 10
    //   616: astore 9
    //   618: aload 15
    //   620: invokestatic 163	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   623: astore 15
    //   625: aload 15
    //   627: astore_0
    //   628: aload_1
    //   629: astore 9
    //   631: aload 10
    //   633: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   636: aload_1
    //   637: astore 9
    //   639: aload 8
    //   641: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   644: aload_0
    //   645: astore 8
    //   647: aload_0
    //   648: ifnonnull +690 -> 1338
    //   651: aload_1
    //   652: astore 9
    //   654: aload 18
    //   656: invokestatic 171	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   659: lstore 4
    //   661: aload_1
    //   662: astore 9
    //   664: aload 19
    //   666: invokevirtual 175	java/util/zip/ZipEntry:getCrc	()J
    //   669: lstore 6
    //   671: aload_1
    //   672: astore 9
    //   674: new 52	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   681: astore 8
    //   683: aload_1
    //   684: astore 9
    //   686: aload 8
    //   688: ldc 177
    //   690: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload_1
    //   695: astore 9
    //   697: aload 8
    //   699: aload 14
    //   701: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload_1
    //   706: astore 9
    //   708: aload 8
    //   710: ldc 179
    //   712: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload_1
    //   717: astore 9
    //   719: aload 8
    //   721: lload 6
    //   723: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload_1
    //   728: astore 9
    //   730: aload 8
    //   732: ldc 184
    //   734: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload_1
    //   739: astore 9
    //   741: aload 8
    //   743: lload 4
    //   745: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: lload 6
    //   751: lload 4
    //   753: lcmp
    //   754: ifeq +581 -> 1335
    //   757: aload_1
    //   758: astore 9
    //   760: aload 8
    //   762: ldc 186
    //   764: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload_1
    //   769: astore 9
    //   771: aload 8
    //   773: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: astore_0
    //   777: aload_1
    //   778: astore 9
    //   780: aload 18
    //   782: invokevirtual 189	java/io/File:delete	()Z
    //   785: pop
    //   786: aload_1
    //   787: astore 9
    //   789: ldc 191
    //   791: iconst_1
    //   792: aload 8
    //   794: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   800: aload_0
    //   801: astore 8
    //   803: aload_0
    //   804: ifnull +462 -> 1266
    //   807: aload_1
    //   808: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   811: aload_0
    //   812: areturn
    //   813: astore 9
    //   815: aconst_null
    //   816: astore 8
    //   818: aconst_null
    //   819: astore_1
    //   820: aload 9
    //   822: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   825: aload 9
    //   827: invokestatic 163	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   830: astore 9
    //   832: aload 8
    //   834: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   837: aload 9
    //   839: astore 8
    //   841: aload_1
    //   842: astore 13
    //   844: goto -573 -> 271
    //   847: astore_0
    //   848: aconst_null
    //   849: astore 8
    //   851: aload 8
    //   853: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   856: aload_0
    //   857: athrow
    //   858: aload_1
    //   859: astore 9
    //   861: aload 8
    //   863: invokevirtual 120	java/io/File:getParentFile	()Ljava/io/File;
    //   866: astore 8
    //   868: goto -395 -> 473
    //   871: aload 8
    //   873: astore 11
    //   875: aload 15
    //   877: astore 9
    //   879: aload 15
    //   881: invokevirtual 200	java/io/FileOutputStream:flush	()V
    //   884: aload_1
    //   885: astore 9
    //   887: aload 15
    //   889: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   892: aload_1
    //   893: astore 9
    //   895: aload 8
    //   897: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   900: aload_0
    //   901: astore 8
    //   903: aload_0
    //   904: ifnonnull +434 -> 1338
    //   907: aload_1
    //   908: astore 9
    //   910: aload 18
    //   912: invokestatic 171	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   915: lstore 4
    //   917: aload_1
    //   918: astore 9
    //   920: aload 19
    //   922: invokevirtual 175	java/util/zip/ZipEntry:getCrc	()J
    //   925: lstore 6
    //   927: aload_1
    //   928: astore 9
    //   930: new 52	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   937: astore 8
    //   939: aload_1
    //   940: astore 9
    //   942: aload 8
    //   944: ldc 177
    //   946: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload_1
    //   951: astore 9
    //   953: aload 8
    //   955: aload 14
    //   957: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: pop
    //   961: aload_1
    //   962: astore 9
    //   964: aload 8
    //   966: ldc 179
    //   968: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: pop
    //   972: aload_1
    //   973: astore 9
    //   975: aload 8
    //   977: lload 6
    //   979: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: aload_1
    //   984: astore 9
    //   986: aload 8
    //   988: ldc 184
    //   990: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: pop
    //   994: aload_1
    //   995: astore 9
    //   997: aload 8
    //   999: lload 4
    //   1001: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1004: pop
    //   1005: lload 6
    //   1007: lload 4
    //   1009: lcmp
    //   1010: ifeq +334 -> 1344
    //   1013: aload_1
    //   1014: astore 9
    //   1016: aload 8
    //   1018: ldc 186
    //   1020: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: pop
    //   1024: aload_1
    //   1025: astore 9
    //   1027: aload 8
    //   1029: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1032: astore_0
    //   1033: aload_1
    //   1034: astore 9
    //   1036: aload 18
    //   1038: invokevirtual 189	java/io/File:delete	()Z
    //   1041: pop
    //   1042: aload_1
    //   1043: astore 9
    //   1045: ldc 191
    //   1047: iconst_1
    //   1048: aload 8
    //   1050: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1056: goto -256 -> 800
    //   1059: astore_0
    //   1060: aload_1
    //   1061: astore 9
    //   1063: aload_0
    //   1064: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   1067: aload_1
    //   1068: astore 9
    //   1070: aload_0
    //   1071: invokestatic 163	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1074: astore_0
    //   1075: aload_1
    //   1076: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   1079: aload_0
    //   1080: areturn
    //   1081: astore 8
    //   1083: aconst_null
    //   1084: astore 10
    //   1086: aload 9
    //   1088: astore 11
    //   1090: aload_1
    //   1091: astore 9
    //   1093: aload 10
    //   1095: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   1098: aload_1
    //   1099: astore 9
    //   1101: aload 11
    //   1103: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   1106: aload_0
    //   1107: ifnonnull +142 -> 1249
    //   1110: aload_1
    //   1111: astore 9
    //   1113: aload 18
    //   1115: invokestatic 171	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1118: lstore 4
    //   1120: aload_1
    //   1121: astore 9
    //   1123: aload 19
    //   1125: invokevirtual 175	java/util/zip/ZipEntry:getCrc	()J
    //   1128: lstore 6
    //   1130: aload_1
    //   1131: astore 9
    //   1133: new 52	java/lang/StringBuilder
    //   1136: dup
    //   1137: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1140: astore_0
    //   1141: aload_1
    //   1142: astore 9
    //   1144: aload_0
    //   1145: ldc 177
    //   1147: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: pop
    //   1151: aload_1
    //   1152: astore 9
    //   1154: aload_0
    //   1155: aload 14
    //   1157: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: pop
    //   1161: aload_1
    //   1162: astore 9
    //   1164: aload_0
    //   1165: ldc 179
    //   1167: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: pop
    //   1171: aload_1
    //   1172: astore 9
    //   1174: aload_0
    //   1175: lload 6
    //   1177: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1180: pop
    //   1181: aload_1
    //   1182: astore 9
    //   1184: aload_0
    //   1185: ldc 184
    //   1187: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: pop
    //   1191: aload_1
    //   1192: astore 9
    //   1194: aload_0
    //   1195: lload 4
    //   1197: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1200: pop
    //   1201: lload 6
    //   1203: lload 4
    //   1205: lcmp
    //   1206: ifeq +30 -> 1236
    //   1209: aload_1
    //   1210: astore 9
    //   1212: aload_0
    //   1213: ldc 186
    //   1215: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: pop
    //   1219: aload_1
    //   1220: astore 9
    //   1222: aload_0
    //   1223: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1226: pop
    //   1227: aload_1
    //   1228: astore 9
    //   1230: aload 18
    //   1232: invokevirtual 189	java/io/File:delete	()Z
    //   1235: pop
    //   1236: aload_1
    //   1237: astore 9
    //   1239: ldc 191
    //   1241: iconst_1
    //   1242: aload_0
    //   1243: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1246: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1249: aload_1
    //   1250: astore 9
    //   1252: aload 8
    //   1254: athrow
    //   1255: astore_0
    //   1256: aload 9
    //   1258: invokestatic 126	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   1261: aload_0
    //   1262: athrow
    //   1263: aload_0
    //   1264: astore 8
    //   1266: aload 8
    //   1268: astore_0
    //   1269: goto -957 -> 312
    //   1272: astore_0
    //   1273: aconst_null
    //   1274: astore 9
    //   1276: goto -20 -> 1256
    //   1279: astore_0
    //   1280: aconst_null
    //   1281: astore_1
    //   1282: goto -222 -> 1060
    //   1285: astore 8
    //   1287: aload 9
    //   1289: astore 10
    //   1291: goto -201 -> 1090
    //   1294: astore 15
    //   1296: aconst_null
    //   1297: astore 9
    //   1299: aload 10
    //   1301: astore 8
    //   1303: aload 9
    //   1305: astore 10
    //   1307: goto -710 -> 597
    //   1310: astore_0
    //   1311: goto -460 -> 851
    //   1314: astore_0
    //   1315: goto -464 -> 851
    //   1318: astore 9
    //   1320: aconst_null
    //   1321: astore_1
    //   1322: goto -502 -> 820
    //   1325: astore 9
    //   1327: goto -507 -> 820
    //   1330: astore 9
    //   1332: goto -512 -> 820
    //   1335: goto -549 -> 786
    //   1338: aload 8
    //   1340: astore_0
    //   1341: goto -541 -> 800
    //   1344: goto -302 -> 1042
    //   1347: goto -908 -> 439
    //   1350: goto -543 -> 807
    //   1353: aload 8
    //   1355: astore_0
    //   1356: aconst_null
    //   1357: astore_1
    //   1358: goto -551 -> 807
    //   1361: aload 9
    //   1363: astore_1
    //   1364: goto -1310 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1367	0	paramString1	String
    //   0	1367	1	paramString2	String
    //   420	161	2	i	int
    //   472	2	3	j	int
    //   659	545	4	l1	long
    //   669	533	6	l2	long
    //   45	1004	8	localObject1	Object
    //   1081	172	8	localObject2	Object
    //   1264	3	8	str1	String
    //   1285	1	8	localObject3	Object
    //   1301	53	8	localObject4	Object
    //   77	497	9	localObject5	Object
    //   587	7	9	localIOException1	java.io.IOException
    //   603	185	9	localObject6	Object
    //   813	13	9	localIOException2	java.io.IOException
    //   830	474	9	localObject7	Object
    //   1318	1	9	localIOException3	java.io.IOException
    //   1325	1	9	localIOException4	java.io.IOException
    //   1330	32	9	localIOException5	java.io.IOException
    //   127	1179	10	localObject8	Object
    //   52	1050	11	localObject9	Object
    //   1	453	12	str2	String
    //   269	574	13	str3	String
    //   348	808	14	str4	String
    //   545	343	15	localObject10	Object
    //   1294	1	15	localIOException6	java.io.IOException
    //   298	280	16	arrayOfByte	byte[]
    //   307	22	17	localEnumeration	java.util.Enumeration
    //   469	762	18	localFile	File
    //   338	786	19	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   555	563	587	java/io/IOException
    //   575	584	587	java/io/IOException
    //   879	884	587	java/io/IOException
    //   37	47	813	java/io/IOException
    //   37	47	847	finally
    //   293	300	1059	java/io/IOException
    //   303	309	1059	java/io/IOException
    //   315	325	1059	java/io/IOException
    //   328	340	1059	java/io/IOException
    //   343	350	1059	java/io/IOException
    //   353	364	1059	java/io/IOException
    //   367	377	1059	java/io/IOException
    //   380	409	1059	java/io/IOException
    //   412	421	1059	java/io/IOException
    //   429	439	1059	java/io/IOException
    //   442	471	1059	java/io/IOException
    //   483	496	1059	java/io/IOException
    //   505	514	1059	java/io/IOException
    //   631	636	1059	java/io/IOException
    //   639	644	1059	java/io/IOException
    //   654	661	1059	java/io/IOException
    //   664	671	1059	java/io/IOException
    //   674	683	1059	java/io/IOException
    //   686	694	1059	java/io/IOException
    //   697	705	1059	java/io/IOException
    //   708	716	1059	java/io/IOException
    //   719	727	1059	java/io/IOException
    //   730	738	1059	java/io/IOException
    //   741	749	1059	java/io/IOException
    //   760	768	1059	java/io/IOException
    //   771	777	1059	java/io/IOException
    //   780	786	1059	java/io/IOException
    //   789	800	1059	java/io/IOException
    //   861	868	1059	java/io/IOException
    //   887	892	1059	java/io/IOException
    //   895	900	1059	java/io/IOException
    //   910	917	1059	java/io/IOException
    //   920	927	1059	java/io/IOException
    //   930	939	1059	java/io/IOException
    //   942	950	1059	java/io/IOException
    //   953	961	1059	java/io/IOException
    //   964	972	1059	java/io/IOException
    //   975	983	1059	java/io/IOException
    //   986	994	1059	java/io/IOException
    //   997	1005	1059	java/io/IOException
    //   1016	1024	1059	java/io/IOException
    //   1027	1033	1059	java/io/IOException
    //   1036	1042	1059	java/io/IOException
    //   1045	1056	1059	java/io/IOException
    //   1093	1098	1059	java/io/IOException
    //   1101	1106	1059	java/io/IOException
    //   1113	1120	1059	java/io/IOException
    //   1123	1130	1059	java/io/IOException
    //   1133	1141	1059	java/io/IOException
    //   1144	1151	1059	java/io/IOException
    //   1154	1161	1059	java/io/IOException
    //   1164	1171	1059	java/io/IOException
    //   1174	1181	1059	java/io/IOException
    //   1184	1191	1059	java/io/IOException
    //   1194	1201	1059	java/io/IOException
    //   1212	1219	1059	java/io/IOException
    //   1222	1227	1059	java/io/IOException
    //   1230	1236	1059	java/io/IOException
    //   1239	1249	1059	java/io/IOException
    //   1252	1255	1059	java/io/IOException
    //   520	528	1081	finally
    //   536	547	1081	finally
    //   293	300	1255	finally
    //   303	309	1255	finally
    //   315	325	1255	finally
    //   328	340	1255	finally
    //   343	350	1255	finally
    //   353	364	1255	finally
    //   367	377	1255	finally
    //   380	409	1255	finally
    //   412	421	1255	finally
    //   429	439	1255	finally
    //   442	471	1255	finally
    //   483	496	1255	finally
    //   505	514	1255	finally
    //   631	636	1255	finally
    //   639	644	1255	finally
    //   654	661	1255	finally
    //   664	671	1255	finally
    //   674	683	1255	finally
    //   686	694	1255	finally
    //   697	705	1255	finally
    //   708	716	1255	finally
    //   719	727	1255	finally
    //   730	738	1255	finally
    //   741	749	1255	finally
    //   760	768	1255	finally
    //   771	777	1255	finally
    //   780	786	1255	finally
    //   789	800	1255	finally
    //   861	868	1255	finally
    //   887	892	1255	finally
    //   895	900	1255	finally
    //   910	917	1255	finally
    //   920	927	1255	finally
    //   930	939	1255	finally
    //   942	950	1255	finally
    //   953	961	1255	finally
    //   964	972	1255	finally
    //   975	983	1255	finally
    //   986	994	1255	finally
    //   997	1005	1255	finally
    //   1016	1024	1255	finally
    //   1027	1033	1255	finally
    //   1036	1042	1255	finally
    //   1045	1056	1255	finally
    //   1063	1067	1255	finally
    //   1070	1075	1255	finally
    //   1093	1098	1255	finally
    //   1101	1106	1255	finally
    //   1113	1120	1255	finally
    //   1123	1130	1255	finally
    //   1133	1141	1255	finally
    //   1144	1151	1255	finally
    //   1154	1161	1255	finally
    //   1164	1171	1255	finally
    //   1174	1181	1255	finally
    //   1184	1191	1255	finally
    //   1194	1201	1255	finally
    //   1212	1219	1255	finally
    //   1222	1227	1255	finally
    //   1230	1236	1255	finally
    //   1239	1249	1255	finally
    //   1252	1255	1255	finally
    //   281	290	1272	finally
    //   281	290	1279	java/io/IOException
    //   555	563	1285	finally
    //   575	584	1285	finally
    //   605	610	1285	finally
    //   618	625	1285	finally
    //   879	884	1285	finally
    //   520	528	1294	java/io/IOException
    //   536	547	1294	java/io/IOException
    //   47	54	1310	finally
    //   54	129	1310	finally
    //   137	156	1310	finally
    //   159	181	1310	finally
    //   185	190	1310	finally
    //   196	207	1310	finally
    //   211	237	1310	finally
    //   237	244	1310	finally
    //   250	257	1310	finally
    //   820	832	1314	finally
    //   47	54	1318	java/io/IOException
    //   137	156	1325	java/io/IOException
    //   159	181	1325	java/io/IOException
    //   185	190	1325	java/io/IOException
    //   196	207	1325	java/io/IOException
    //   211	237	1325	java/io/IOException
    //   237	244	1325	java/io/IOException
    //   250	257	1325	java/io/IOException
    //   54	129	1330	java/io/IOException
  }
  
  /* Error */
  public static void extractPlugin(Context paramContext, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_2
    //   7: invokevirtual 207	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: astore 8
    //   12: new 52	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   19: ldc 209
    //   21: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload 8
    //   26: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 214	com/tencent/mobileqq/pluginsdk/DebugHelper:debug	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: ldc 216
    //   38: ldc 218
    //   40: invokevirtual 221	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 224	java/io/File:exists	()Z
    //   48: ifeq +8 -> 56
    //   51: aload_2
    //   52: invokevirtual 189	java/io/File:delete	()Z
    //   55: pop
    //   56: new 41	java/io/File
    //   59: dup
    //   60: new 52	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   67: aload 8
    //   69: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 17
    //   74: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore 8
    //   85: aload 8
    //   87: invokevirtual 224	java/io/File:exists	()Z
    //   90: ifeq +9 -> 99
    //   93: aload 8
    //   95: invokevirtual 189	java/io/File:delete	()Z
    //   98: pop
    //   99: aload 8
    //   101: invokevirtual 227	java/io/File:createNewFile	()Z
    //   104: pop
    //   105: aload_0
    //   106: invokevirtual 233	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   109: new 52	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   116: ldc 235
    //   118: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_1
    //   122: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 241	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   131: astore_0
    //   132: new 143	java/io/FileOutputStream
    //   135: dup
    //   136: aload 8
    //   138: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   141: astore_1
    //   142: sipush 8192
    //   145: newarray byte
    //   147: astore 6
    //   149: aload_0
    //   150: aload 6
    //   152: invokevirtual 152	java/io/InputStream:read	([B)I
    //   155: istore_3
    //   156: iload_3
    //   157: iconst_m1
    //   158: if_icmpeq +55 -> 213
    //   161: aload_1
    //   162: aload 6
    //   164: iconst_0
    //   165: iload_3
    //   166: invokevirtual 244	java/io/OutputStream:write	([BII)V
    //   169: goto -20 -> 149
    //   172: astore 6
    //   174: aload_1
    //   175: astore_2
    //   176: aload_0
    //   177: astore_1
    //   178: aload_2
    //   179: astore_0
    //   180: aload 6
    //   182: astore_2
    //   183: new 204	java/lang/Exception
    //   186: dup
    //   187: ldc 209
    //   189: aload_2
    //   190: invokespecial 247	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   193: athrow
    //   194: astore 6
    //   196: aload_0
    //   197: astore_2
    //   198: aload_1
    //   199: astore_0
    //   200: aload 6
    //   202: astore_1
    //   203: aload_0
    //   204: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   207: aload_2
    //   208: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   211: aload_1
    //   212: athrow
    //   213: aload_0
    //   214: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   217: aload_1
    //   218: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   221: aload_2
    //   222: invokevirtual 224	java/io/File:exists	()Z
    //   225: ifeq +102 -> 327
    //   228: aload_2
    //   229: invokevirtual 189	java/io/File:delete	()Z
    //   232: istore 4
    //   234: aload 8
    //   236: aload_2
    //   237: invokevirtual 251	java/io/File:renameTo	(Ljava/io/File;)Z
    //   240: istore 5
    //   242: ldc 191
    //   244: iconst_1
    //   245: new 52	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   252: ldc 209
    //   254: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: iload 4
    //   259: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   262: ldc_w 256
    //   265: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: iload 5
    //   270: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   273: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: return
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_0
    //   283: aload 6
    //   285: astore_2
    //   286: goto -83 -> 203
    //   289: astore_1
    //   290: aload 6
    //   292: astore_2
    //   293: goto -90 -> 203
    //   296: astore 6
    //   298: aload_1
    //   299: astore_2
    //   300: aload 6
    //   302: astore_1
    //   303: goto -100 -> 203
    //   306: astore_2
    //   307: aconst_null
    //   308: astore_0
    //   309: aload 7
    //   311: astore_1
    //   312: goto -129 -> 183
    //   315: astore_2
    //   316: aconst_null
    //   317: astore 6
    //   319: aload_0
    //   320: astore_1
    //   321: aload 6
    //   323: astore_0
    //   324: goto -141 -> 183
    //   327: iconst_1
    //   328: istore 4
    //   330: goto -96 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramContext	Context
    //   0	333	1	paramString	String
    //   0	333	2	paramFile	File
    //   155	11	3	i	int
    //   232	97	4	bool1	boolean
    //   240	29	5	bool2	boolean
    //   1	162	6	arrayOfByte	byte[]
    //   172	9	6	localException	java.lang.Exception
    //   194	97	6	localObject1	Object
    //   296	5	6	localObject2	Object
    //   317	5	6	localObject3	Object
    //   4	306	7	localObject4	Object
    //   10	225	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   142	149	172	java/lang/Exception
    //   149	156	172	java/lang/Exception
    //   161	169	172	java/lang/Exception
    //   183	194	194	finally
    //   105	132	280	finally
    //   132	142	289	finally
    //   142	149	296	finally
    //   149	156	296	finally
    //   161	169	296	finally
    //   105	132	306	java/lang/Exception
    //   132	142	315	java/lang/Exception
  }
  
  /* Error */
  public static String extractPluginAndGetMd5Code(Context paramContext, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_2
    //   7: invokevirtual 207	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: astore 8
    //   12: new 52	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   19: ldc 209
    //   21: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload 8
    //   26: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 214	com/tencent/mobileqq/pluginsdk/DebugHelper:debug	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: ldc 216
    //   38: ldc 218
    //   40: invokevirtual 221	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 224	java/io/File:exists	()Z
    //   48: ifeq +8 -> 56
    //   51: aload_2
    //   52: invokevirtual 189	java/io/File:delete	()Z
    //   55: pop
    //   56: new 41	java/io/File
    //   59: dup
    //   60: new 52	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   67: aload 8
    //   69: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 17
    //   74: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore 9
    //   85: aload 9
    //   87: invokevirtual 224	java/io/File:exists	()Z
    //   90: ifeq +9 -> 99
    //   93: aload 9
    //   95: invokevirtual 189	java/io/File:delete	()Z
    //   98: pop
    //   99: aload 9
    //   101: invokevirtual 227	java/io/File:createNewFile	()Z
    //   104: pop
    //   105: aload_0
    //   106: invokevirtual 233	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   109: new 52	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   116: ldc 235
    //   118: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_1
    //   122: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 241	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   131: astore_0
    //   132: new 143	java/io/FileOutputStream
    //   135: dup
    //   136: aload 9
    //   138: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   141: astore_1
    //   142: sipush 8192
    //   145: newarray byte
    //   147: astore 6
    //   149: aload_0
    //   150: aload 6
    //   152: invokevirtual 152	java/io/InputStream:read	([B)I
    //   155: istore_3
    //   156: iload_3
    //   157: iconst_m1
    //   158: if_icmpeq +55 -> 213
    //   161: aload_1
    //   162: aload 6
    //   164: iconst_0
    //   165: iload_3
    //   166: invokevirtual 244	java/io/OutputStream:write	([BII)V
    //   169: goto -20 -> 149
    //   172: astore 6
    //   174: aload_1
    //   175: astore_2
    //   176: aload_0
    //   177: astore_1
    //   178: aload_2
    //   179: astore_0
    //   180: aload 6
    //   182: astore_2
    //   183: new 204	java/lang/Exception
    //   186: dup
    //   187: ldc 209
    //   189: aload_2
    //   190: invokespecial 247	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   193: athrow
    //   194: astore 6
    //   196: aload_0
    //   197: astore_2
    //   198: aload_1
    //   199: astore_0
    //   200: aload 6
    //   202: astore_1
    //   203: aload_0
    //   204: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   207: aload_2
    //   208: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   211: aload_1
    //   212: athrow
    //   213: aload_0
    //   214: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   217: aload_1
    //   218: invokestatic 167	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   221: aload_2
    //   222: invokevirtual 224	java/io/File:exists	()Z
    //   225: ifeq +118 -> 343
    //   228: aload_2
    //   229: invokevirtual 189	java/io/File:delete	()Z
    //   232: istore 4
    //   234: aload 9
    //   236: aload_2
    //   237: invokevirtual 251	java/io/File:renameTo	(Ljava/io/File;)Z
    //   240: istore 5
    //   242: ldc_w 259
    //   245: astore_0
    //   246: iload 5
    //   248: ifeq +9 -> 257
    //   251: aload 8
    //   253: invokestatic 265	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   256: astore_0
    //   257: ldc 191
    //   259: iconst_1
    //   260: new 52	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   267: ldc 209
    //   269: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: iload 4
    //   274: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   277: ldc_w 256
    //   280: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: iload 5
    //   285: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   288: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload_0
    //   295: areturn
    //   296: astore_1
    //   297: aconst_null
    //   298: astore_0
    //   299: aload 6
    //   301: astore_2
    //   302: goto -99 -> 203
    //   305: astore_1
    //   306: aload 6
    //   308: astore_2
    //   309: goto -106 -> 203
    //   312: astore 6
    //   314: aload_1
    //   315: astore_2
    //   316: aload 6
    //   318: astore_1
    //   319: goto -116 -> 203
    //   322: astore_2
    //   323: aconst_null
    //   324: astore_0
    //   325: aload 7
    //   327: astore_1
    //   328: goto -145 -> 183
    //   331: astore_2
    //   332: aconst_null
    //   333: astore 6
    //   335: aload_0
    //   336: astore_1
    //   337: aload 6
    //   339: astore_0
    //   340: goto -157 -> 183
    //   343: iconst_1
    //   344: istore 4
    //   346: goto -112 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramContext	Context
    //   0	349	1	paramString	String
    //   0	349	2	paramFile	File
    //   155	11	3	i	int
    //   232	113	4	bool1	boolean
    //   240	44	5	bool2	boolean
    //   1	162	6	arrayOfByte	byte[]
    //   172	9	6	localException	java.lang.Exception
    //   194	113	6	localObject1	Object
    //   312	5	6	localObject2	Object
    //   333	5	6	localObject3	Object
    //   4	322	7	localObject4	Object
    //   10	242	8	str	String
    //   83	152	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   142	149	172	java/lang/Exception
    //   149	156	172	java/lang/Exception
    //   161	169	172	java/lang/Exception
    //   183	194	194	finally
    //   105	132	296	finally
    //   132	142	305	finally
    //   142	149	312	finally
    //   149	156	312	finally
    //   161	169	312	finally
    //   105	132	322	java/lang/Exception
    //   132	142	331	java/lang/Exception
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
    File localFile = (File)sInstallPathMap.get(paramString);
    Object localObject = localFile;
    if (localFile == null)
    {
      localObject = getPluginInstallDir(paramContext);
      if (localObject == null) {
        localObject = null;
      }
    }
    else
    {
      return localObject;
    }
    int i = paramString.lastIndexOf('.');
    if ((i != -1) && (!paramString.substring(i).equalsIgnoreCase(".apk"))) {
      paramContext = paramString.substring(0, i) + ".apk";
    }
    for (;;)
    {
      paramString = new File((File)localObject, paramContext);
      localObject = paramString;
      if (paramString == null) {
        break;
      }
      sInstallPathMap.put(paramContext, paramString);
      return paramString;
      paramContext = paramString;
      if (i == -1) {
        paramContext = paramString + ".apk";
      }
    }
  }
  
  public static File getInstalledPluginPath(Context paramContext, String paramString)
  {
    Object localObject = null;
    PluginBaseInfo localPluginBaseInfo = PluginBaseInfoHelper.createFromFile(getPluginCfgFile(getPluginInstallDir(paramContext), paramString), PluginBaseInfo.class);
    if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4) || (localPluginBaseInfo.mInstalledPath == null)) {
      paramContext = getInstallPluginPath(paramContext, paramString);
    }
    do
    {
      return paramContext;
      paramContext = localObject;
    } while (!PluginStatic.isValidPluginPath(localPluginBaseInfo.mInstalledPath));
    return new File(localPluginBaseInfo.mInstalledPath);
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
    return new File(paramFile, paramString + ".cfg");
  }
  
  public static File getPluginInstallDir(Context paramContext)
  {
    return paramContext.getDir("installed_plugin", 0);
  }
  
  public static File getPluginLibPath(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.endsWith(".apk")) {
      str = paramString.substring(0, paramString.length() - ".apk".length());
    }
    return new File(paramContext.getDir("lib", 0), str);
  }
  
  public static boolean isOsNeedReleaseDex()
  {
    return Build.VERSION.SDK_INT <= 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginUtils
 * JD-Core Version:    0.7.0.1
 */