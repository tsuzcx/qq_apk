package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PluginUtils
{
  public static final String CONFIG_FILE_EXTEND_NAME = ".cfg";
  private static final int a = 8192;
  private static Map b = new ConcurrentHashMap();
  private static Map c = new ConcurrentHashMap();
  private static final String d = ".tmp";
  
  private static File a(Context paramContext, String paramString)
  {
    File localFile = (File)b.get(paramString);
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
      b.put(paramContext, paramString);
      return paramString;
      paramContext = paramString;
      if (i == -1) {
        paramContext = paramString + ".apk";
      }
    }
  }
  
  /* Error */
  public static String extractLibs(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 12
    //   3: aload_1
    //   4: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   7: invokevirtual 94	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   10: ifne +25 -> 35
    //   13: new 65	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   20: aload_1
    //   21: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   27: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 12
    //   35: aconst_null
    //   36: astore_1
    //   37: new 96	com/tencent/commonsdk/zip/QZipFile
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 99	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   45: astore 8
    //   47: aload 8
    //   49: invokevirtual 103	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   52: astore 11
    //   54: aload 11
    //   56: invokeinterface 109 1 0
    //   61: ifeq +199 -> 260
    //   64: aload 11
    //   66: invokeinterface 113 1 0
    //   71: checkcast 115	java/util/zip/ZipEntry
    //   74: invokevirtual 118	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   77: astore 9
    //   79: aload 9
    //   81: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   84: invokevirtual 94	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   87: ifne -33 -> 54
    //   90: aload 9
    //   92: ldc 120
    //   94: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   97: ifne -43 -> 54
    //   100: new 43	java/io/File
    //   103: dup
    //   104: new 65	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   111: aload 12
    //   113: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 9
    //   118: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   127: astore 10
    //   129: aload_1
    //   130: astore 9
    //   132: aload 10
    //   134: ifnull +990 -> 1124
    //   137: aload 10
    //   139: invokevirtual 126	java/io/File:getName	()Ljava/lang/String;
    //   142: getstatic 131	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   145: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   148: ifeq +11 -> 159
    //   151: getstatic 131	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   154: astore 9
    //   156: goto +968 -> 1124
    //   159: getstatic 140	android/os/Build$VERSION:SDK_INT	I
    //   162: bipush 7
    //   164: if_icmple +32 -> 196
    //   167: aload 10
    //   169: invokevirtual 126	java/io/File:getName	()Ljava/lang/String;
    //   172: getstatic 143	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   175: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   178: ifeq +18 -> 196
    //   181: aload_1
    //   182: ifnonnull +14 -> 196
    //   185: getstatic 143	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   188: astore 9
    //   190: aload 9
    //   192: astore_1
    //   193: goto -64 -> 129
    //   196: getstatic 131	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   199: ldc 145
    //   201: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifeq +46 -> 250
    //   207: aload_1
    //   208: ifnonnull +42 -> 250
    //   211: aload 10
    //   213: invokevirtual 126	java/io/File:getName	()Ljava/lang/String;
    //   216: ldc 147
    //   218: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifne +16 -> 237
    //   224: aload 10
    //   226: invokevirtual 126	java/io/File:getName	()Ljava/lang/String;
    //   229: ldc 149
    //   231: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +16 -> 250
    //   237: aload 10
    //   239: invokevirtual 126	java/io/File:getName	()Ljava/lang/String;
    //   242: astore 9
    //   244: aload 9
    //   246: astore_1
    //   247: goto -118 -> 129
    //   250: aload 10
    //   252: invokevirtual 153	java/io/File:getParentFile	()Ljava/io/File;
    //   255: astore 10
    //   257: goto -128 -> 129
    //   260: aload 8
    //   262: invokestatic 159	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   265: aconst_null
    //   266: astore 8
    //   268: aload_1
    //   269: astore 13
    //   271: aload 8
    //   273: astore_1
    //   274: aload_1
    //   275: ifnonnull +841 -> 1116
    //   278: aload 13
    //   280: ifnull +836 -> 1116
    //   283: new 96	com/tencent/commonsdk/zip/QZipFile
    //   286: dup
    //   287: aload_0
    //   288: invokespecial 99	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   291: astore 8
    //   293: sipush 4096
    //   296: newarray byte
    //   298: astore 16
    //   300: aload 8
    //   302: invokevirtual 103	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   305: astore 17
    //   307: aload_1
    //   308: astore_0
    //   309: aload 17
    //   311: invokeinterface 109 1 0
    //   316: ifeq +797 -> 1113
    //   319: aload 17
    //   321: invokeinterface 113 1 0
    //   326: checkcast 115	java/util/zip/ZipEntry
    //   329: astore 19
    //   331: aload 19
    //   333: invokevirtual 118	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   336: astore 14
    //   338: aload 14
    //   340: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   343: invokevirtual 94	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   346: ifne -37 -> 309
    //   349: aload 14
    //   351: ldc 120
    //   353: invokevirtual 124	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   356: ifne -47 -> 309
    //   359: new 43	java/io/File
    //   362: dup
    //   363: new 65	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   370: aload 12
    //   372: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload 14
    //   377: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   386: astore_1
    //   387: aload 14
    //   389: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   392: invokevirtual 162	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   395: istore_2
    //   396: iload_2
    //   397: iconst_m1
    //   398: if_icmpeq +712 -> 1110
    //   401: aload 14
    //   403: iload_2
    //   404: iconst_1
    //   405: iadd
    //   406: invokevirtual 57	java/lang/String:substring	(I)Ljava/lang/String;
    //   409: astore 14
    //   411: new 43	java/io/File
    //   414: dup
    //   415: new 65	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   422: aload 12
    //   424: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 14
    //   429: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   438: astore 18
    //   440: iconst_0
    //   441: istore_3
    //   442: iload_3
    //   443: istore_2
    //   444: aload_1
    //   445: ifnull +17 -> 462
    //   448: aload_1
    //   449: invokevirtual 126	java/io/File:getName	()Ljava/lang/String;
    //   452: aload 13
    //   454: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   457: ifeq +289 -> 746
    //   460: iconst_1
    //   461: istore_2
    //   462: iload_2
    //   463: ifeq +558 -> 1021
    //   466: aload 18
    //   468: invokevirtual 153	java/io/File:getParentFile	()Ljava/io/File;
    //   471: invokevirtual 165	java/io/File:mkdirs	()Z
    //   474: pop
    //   475: aconst_null
    //   476: astore 10
    //   478: aconst_null
    //   479: astore 9
    //   481: aload 8
    //   483: aload 19
    //   485: invokevirtual 169	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   488: astore_1
    //   489: aload_1
    //   490: astore 9
    //   492: aload_1
    //   493: astore 10
    //   495: new 171	java/io/FileOutputStream
    //   498: dup
    //   499: aload 18
    //   501: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   504: astore 11
    //   506: aload_1
    //   507: astore 10
    //   509: aload 11
    //   511: astore 9
    //   513: aload_1
    //   514: aload 16
    //   516: invokevirtual 180	java/io/InputStream:read	([B)I
    //   519: istore_2
    //   520: iload_2
    //   521: ifle +233 -> 754
    //   524: aload_1
    //   525: astore 10
    //   527: aload 11
    //   529: astore 9
    //   531: aload 11
    //   533: aload 16
    //   535: iconst_0
    //   536: iload_2
    //   537: invokevirtual 184	java/io/FileOutputStream:write	([BII)V
    //   540: goto -34 -> 506
    //   543: astore 15
    //   545: aload_1
    //   546: astore 10
    //   548: aload 11
    //   550: astore 9
    //   552: aload 15
    //   554: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   557: aload_1
    //   558: astore 10
    //   560: aload 11
    //   562: astore 9
    //   564: aload 15
    //   566: invokestatic 191	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   569: astore 15
    //   571: aload 11
    //   573: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   576: aload_1
    //   577: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   580: aload 15
    //   582: ifnonnull +522 -> 1104
    //   585: aload 18
    //   587: invokestatic 199	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   590: lstore 4
    //   592: aload 19
    //   594: invokevirtual 203	java/util/zip/ZipEntry:getCrc	()J
    //   597: lstore 6
    //   599: new 65	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   606: astore_1
    //   607: aload_1
    //   608: ldc 205
    //   610: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload_1
    //   615: aload 14
    //   617: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload_1
    //   622: ldc 207
    //   624: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload_1
    //   629: lload 6
    //   631: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload_1
    //   636: ldc 212
    //   638: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: pop
    //   642: aload_1
    //   643: lload 4
    //   645: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: lload 6
    //   651: lload 4
    //   653: lcmp
    //   654: ifeq +444 -> 1098
    //   657: aload_1
    //   658: ldc 214
    //   660: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload_1
    //   665: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: astore_0
    //   669: aload 18
    //   671: invokevirtual 217	java/io/File:delete	()Z
    //   674: pop
    //   675: ldc 219
    //   677: iconst_1
    //   678: aload_1
    //   679: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   685: aload_0
    //   686: astore_1
    //   687: aload_0
    //   688: ifnull +335 -> 1023
    //   691: aload 8
    //   693: invokestatic 159	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   696: aload_0
    //   697: areturn
    //   698: astore 9
    //   700: aconst_null
    //   701: astore 8
    //   703: aconst_null
    //   704: astore_1
    //   705: aload 9
    //   707: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   710: aload 9
    //   712: invokestatic 191	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   715: astore 9
    //   717: aload 8
    //   719: invokestatic 159	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   722: aload 9
    //   724: astore 8
    //   726: aload_1
    //   727: astore 13
    //   729: aload 8
    //   731: astore_1
    //   732: goto -458 -> 274
    //   735: astore_0
    //   736: aconst_null
    //   737: astore 8
    //   739: aload 8
    //   741: invokestatic 159	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   744: aload_0
    //   745: athrow
    //   746: aload_1
    //   747: invokevirtual 153	java/io/File:getParentFile	()Ljava/io/File;
    //   750: astore_1
    //   751: goto -309 -> 442
    //   754: aload_1
    //   755: astore 10
    //   757: aload 11
    //   759: astore 9
    //   761: aload 11
    //   763: invokevirtual 227	java/io/FileOutputStream:flush	()V
    //   766: aload 11
    //   768: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   771: aload_1
    //   772: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   775: aload_0
    //   776: astore_1
    //   777: aload_0
    //   778: ifnonnull +352 -> 1130
    //   781: aload 18
    //   783: invokestatic 199	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   786: lstore 4
    //   788: aload 19
    //   790: invokevirtual 203	java/util/zip/ZipEntry:getCrc	()J
    //   793: lstore 6
    //   795: new 65	java/lang/StringBuilder
    //   798: dup
    //   799: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   802: astore_1
    //   803: aload_1
    //   804: ldc 205
    //   806: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload_1
    //   811: aload 14
    //   813: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload_1
    //   818: ldc 207
    //   820: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload_1
    //   825: lload 6
    //   827: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload_1
    //   832: ldc 212
    //   834: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: pop
    //   838: aload_1
    //   839: lload 4
    //   841: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: lload 6
    //   847: lload 4
    //   849: lcmp
    //   850: ifeq +21 -> 871
    //   853: aload_1
    //   854: ldc 214
    //   856: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload_1
    //   861: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: astore_0
    //   865: aload 18
    //   867: invokevirtual 217	java/io/File:delete	()Z
    //   870: pop
    //   871: ldc 219
    //   873: iconst_1
    //   874: aload_1
    //   875: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: aload_0
    //   882: astore_1
    //   883: goto +247 -> 1130
    //   886: aload 9
    //   888: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   891: aload 10
    //   893: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   896: aload_0
    //   897: ifnonnull +103 -> 1000
    //   900: aload 18
    //   902: invokestatic 199	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   905: lstore 4
    //   907: aload 19
    //   909: invokevirtual 203	java/util/zip/ZipEntry:getCrc	()J
    //   912: lstore 6
    //   914: new 65	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   921: astore_0
    //   922: aload_0
    //   923: ldc 205
    //   925: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload_0
    //   930: aload 14
    //   932: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: aload_0
    //   937: ldc 207
    //   939: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: aload_0
    //   944: lload 6
    //   946: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload_0
    //   951: ldc 212
    //   953: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: aload_0
    //   958: lload 4
    //   960: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: lload 6
    //   966: lload 4
    //   968: lcmp
    //   969: ifeq +21 -> 990
    //   972: aload_0
    //   973: ldc 214
    //   975: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload_0
    //   980: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   983: pop
    //   984: aload 18
    //   986: invokevirtual 217	java/io/File:delete	()Z
    //   989: pop
    //   990: ldc 219
    //   992: iconst_1
    //   993: aload_0
    //   994: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1000: aload_1
    //   1001: athrow
    //   1002: astore_1
    //   1003: aload 8
    //   1005: astore_0
    //   1006: aload_1
    //   1007: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   1010: aload_1
    //   1011: invokestatic 191	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1014: astore_1
    //   1015: aload_0
    //   1016: invokestatic 159	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   1019: aload_1
    //   1020: areturn
    //   1021: aload_0
    //   1022: astore_1
    //   1023: aload_1
    //   1024: astore_0
    //   1025: goto -716 -> 309
    //   1028: astore_0
    //   1029: aconst_null
    //   1030: astore 8
    //   1032: aload 8
    //   1034: invokestatic 159	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   1037: aload_0
    //   1038: athrow
    //   1039: astore_0
    //   1040: goto -8 -> 1032
    //   1043: astore_1
    //   1044: aload_0
    //   1045: astore 8
    //   1047: aload_1
    //   1048: astore_0
    //   1049: goto -17 -> 1032
    //   1052: astore_1
    //   1053: aconst_null
    //   1054: astore_0
    //   1055: goto -49 -> 1006
    //   1058: astore_1
    //   1059: goto -173 -> 886
    //   1062: astore 15
    //   1064: aconst_null
    //   1065: astore 11
    //   1067: aload 9
    //   1069: astore_1
    //   1070: goto -525 -> 545
    //   1073: astore_0
    //   1074: goto -335 -> 739
    //   1077: astore_0
    //   1078: goto -339 -> 739
    //   1081: astore 9
    //   1083: aconst_null
    //   1084: astore_1
    //   1085: goto -380 -> 705
    //   1088: astore 9
    //   1090: goto -385 -> 705
    //   1093: astore 9
    //   1095: goto -390 -> 705
    //   1098: aload 15
    //   1100: astore_0
    //   1101: goto -426 -> 675
    //   1104: aload 15
    //   1106: astore_0
    //   1107: goto -422 -> 685
    //   1110: goto -699 -> 411
    //   1113: goto -422 -> 691
    //   1116: aconst_null
    //   1117: astore 8
    //   1119: aload_1
    //   1120: astore_0
    //   1121: goto -430 -> 691
    //   1124: aload 9
    //   1126: astore_1
    //   1127: goto -1073 -> 54
    //   1130: aload_1
    //   1131: astore_0
    //   1132: goto -447 -> 685
    //   1135: astore_1
    //   1136: aconst_null
    //   1137: astore 9
    //   1139: goto -253 -> 886
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1142	0	paramString1	String
    //   0	1142	1	paramString2	String
    //   395	142	2	i	int
    //   441	2	3	j	int
    //   590	377	4	l1	long
    //   597	368	6	l2	long
    //   45	1073	8	localObject1	Object
    //   77	486	9	localObject2	Object
    //   698	13	9	localIOException1	java.io.IOException
    //   715	353	9	localObject3	Object
    //   1081	1	9	localIOException2	java.io.IOException
    //   1088	1	9	localIOException3	java.io.IOException
    //   1093	32	9	localIOException4	java.io.IOException
    //   1137	1	9	localObject4	Object
    //   127	765	10	localObject5	Object
    //   52	1014	11	localObject6	Object
    //   1	422	12	str1	String
    //   269	459	13	str2	String
    //   336	595	14	str3	String
    //   543	22	15	localIOException5	java.io.IOException
    //   569	12	15	str4	String
    //   1062	43	15	localIOException6	java.io.IOException
    //   298	236	16	arrayOfByte	byte[]
    //   305	15	17	localEnumeration	java.util.Enumeration
    //   438	547	18	localFile	File
    //   329	579	19	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   513	520	543	java/io/IOException
    //   531	540	543	java/io/IOException
    //   761	766	543	java/io/IOException
    //   37	47	698	java/io/IOException
    //   37	47	735	finally
    //   293	307	1002	java/io/IOException
    //   309	396	1002	java/io/IOException
    //   401	411	1002	java/io/IOException
    //   411	440	1002	java/io/IOException
    //   448	460	1002	java/io/IOException
    //   466	475	1002	java/io/IOException
    //   571	580	1002	java/io/IOException
    //   585	649	1002	java/io/IOException
    //   657	675	1002	java/io/IOException
    //   675	685	1002	java/io/IOException
    //   746	751	1002	java/io/IOException
    //   766	775	1002	java/io/IOException
    //   781	845	1002	java/io/IOException
    //   853	871	1002	java/io/IOException
    //   871	881	1002	java/io/IOException
    //   886	896	1002	java/io/IOException
    //   900	964	1002	java/io/IOException
    //   972	990	1002	java/io/IOException
    //   990	1000	1002	java/io/IOException
    //   1000	1002	1002	java/io/IOException
    //   283	293	1028	finally
    //   293	307	1039	finally
    //   309	396	1039	finally
    //   401	411	1039	finally
    //   411	440	1039	finally
    //   448	460	1039	finally
    //   466	475	1039	finally
    //   571	580	1039	finally
    //   585	649	1039	finally
    //   657	675	1039	finally
    //   675	685	1039	finally
    //   746	751	1039	finally
    //   766	775	1039	finally
    //   781	845	1039	finally
    //   853	871	1039	finally
    //   871	881	1039	finally
    //   886	896	1039	finally
    //   900	964	1039	finally
    //   972	990	1039	finally
    //   990	1000	1039	finally
    //   1000	1002	1039	finally
    //   1006	1015	1043	finally
    //   283	293	1052	java/io/IOException
    //   513	520	1058	finally
    //   531	540	1058	finally
    //   552	557	1058	finally
    //   564	571	1058	finally
    //   761	766	1058	finally
    //   481	489	1062	java/io/IOException
    //   495	506	1062	java/io/IOException
    //   47	54	1073	finally
    //   54	129	1073	finally
    //   137	156	1073	finally
    //   159	181	1073	finally
    //   185	190	1073	finally
    //   196	207	1073	finally
    //   211	237	1073	finally
    //   237	244	1073	finally
    //   250	257	1073	finally
    //   705	717	1077	finally
    //   47	54	1081	java/io/IOException
    //   137	156	1088	java/io/IOException
    //   159	181	1088	java/io/IOException
    //   185	190	1088	java/io/IOException
    //   196	207	1088	java/io/IOException
    //   211	237	1088	java/io/IOException
    //   237	244	1088	java/io/IOException
    //   250	257	1088	java/io/IOException
    //   54	129	1093	java/io/IOException
    //   481	489	1135	finally
    //   495	506	1135	finally
  }
  
  /* Error */
  public static void extractPlugin(Context paramContext, String paramString, File paramFile)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_2
    //   7: invokevirtual 234	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: astore 8
    //   12: new 65	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   19: ldc 236
    //   21: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload 8
    //   26: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 241	com/tencent/mobileqq/pluginsdk/DebugHelper:debug	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: ldc 243
    //   38: ldc 245
    //   40: invokevirtual 248	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 251	java/io/File:exists	()Z
    //   48: ifeq +8 -> 56
    //   51: aload_2
    //   52: invokevirtual 217	java/io/File:delete	()Z
    //   55: pop
    //   56: new 43	java/io/File
    //   59: dup
    //   60: new 65	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   67: aload 8
    //   69: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 21
    //   74: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore 8
    //   85: aload 8
    //   87: invokevirtual 251	java/io/File:exists	()Z
    //   90: ifeq +9 -> 99
    //   93: aload 8
    //   95: invokevirtual 217	java/io/File:delete	()Z
    //   98: pop
    //   99: aload 8
    //   101: invokevirtual 254	java/io/File:createNewFile	()Z
    //   104: pop
    //   105: aload_0
    //   106: invokevirtual 260	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   109: new 65	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 262
    //   119: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_1
    //   123: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokevirtual 268	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   132: astore_0
    //   133: new 171	java/io/FileOutputStream
    //   136: dup
    //   137: aload 8
    //   139: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   142: astore_1
    //   143: sipush 8192
    //   146: newarray byte
    //   148: astore 6
    //   150: aload_0
    //   151: aload 6
    //   153: invokevirtual 180	java/io/InputStream:read	([B)I
    //   156: istore_3
    //   157: iload_3
    //   158: iconst_m1
    //   159: if_icmpeq +55 -> 214
    //   162: aload_1
    //   163: aload 6
    //   165: iconst_0
    //   166: iload_3
    //   167: invokevirtual 271	java/io/OutputStream:write	([BII)V
    //   170: goto -20 -> 150
    //   173: astore 6
    //   175: aload_1
    //   176: astore_2
    //   177: aload_0
    //   178: astore_1
    //   179: aload_2
    //   180: astore_0
    //   181: aload 6
    //   183: astore_2
    //   184: new 231	java/lang/Exception
    //   187: dup
    //   188: ldc 236
    //   190: aload_2
    //   191: invokespecial 274	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   194: athrow
    //   195: astore 6
    //   197: aload_0
    //   198: astore_2
    //   199: aload_1
    //   200: astore_0
    //   201: aload 6
    //   203: astore_1
    //   204: aload_0
    //   205: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   208: aload_2
    //   209: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   212: aload_1
    //   213: athrow
    //   214: aload_0
    //   215: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   218: aload_1
    //   219: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   222: aload_2
    //   223: invokevirtual 251	java/io/File:exists	()Z
    //   226: ifeq +102 -> 328
    //   229: aload_2
    //   230: invokevirtual 217	java/io/File:delete	()Z
    //   233: istore 4
    //   235: aload 8
    //   237: aload_2
    //   238: invokevirtual 278	java/io/File:renameTo	(Ljava/io/File;)Z
    //   241: istore 5
    //   243: ldc 219
    //   245: iconst_1
    //   246: new 65	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   253: ldc 236
    //   255: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: iload 4
    //   260: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   263: ldc_w 283
    //   266: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: iload 5
    //   271: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   274: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: return
    //   281: astore_1
    //   282: aconst_null
    //   283: astore_0
    //   284: aload 6
    //   286: astore_2
    //   287: goto -83 -> 204
    //   290: astore_1
    //   291: aload 6
    //   293: astore_2
    //   294: goto -90 -> 204
    //   297: astore 6
    //   299: aload_1
    //   300: astore_2
    //   301: aload 6
    //   303: astore_1
    //   304: goto -100 -> 204
    //   307: astore_2
    //   308: aconst_null
    //   309: astore_0
    //   310: aload 7
    //   312: astore_1
    //   313: goto -129 -> 184
    //   316: astore_2
    //   317: aconst_null
    //   318: astore 6
    //   320: aload_0
    //   321: astore_1
    //   322: aload 6
    //   324: astore_0
    //   325: goto -141 -> 184
    //   328: iconst_1
    //   329: istore 4
    //   331: goto -96 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramContext	Context
    //   0	334	1	paramString	String
    //   0	334	2	paramFile	File
    //   156	11	3	i	int
    //   233	97	4	bool1	boolean
    //   241	29	5	bool2	boolean
    //   1	163	6	arrayOfByte	byte[]
    //   173	9	6	localException	Exception
    //   195	97	6	localObject1	Object
    //   297	5	6	localObject2	Object
    //   318	5	6	localObject3	Object
    //   4	307	7	localObject4	Object
    //   10	226	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   143	150	173	java/lang/Exception
    //   150	157	173	java/lang/Exception
    //   162	170	173	java/lang/Exception
    //   184	195	195	finally
    //   105	133	281	finally
    //   133	143	290	finally
    //   143	150	297	finally
    //   150	157	297	finally
    //   162	170	297	finally
    //   105	133	307	java/lang/Exception
    //   133	143	316	java/lang/Exception
  }
  
  /* Error */
  public static String extractPluginAndGetMd5Code(Context paramContext, String paramString, File paramFile)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_2
    //   7: invokevirtual 234	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: astore 8
    //   12: new 65	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   19: ldc 236
    //   21: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload 8
    //   26: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 241	com/tencent/mobileqq/pluginsdk/DebugHelper:debug	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: ldc 243
    //   38: ldc 245
    //   40: invokevirtual 248	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 251	java/io/File:exists	()Z
    //   48: ifeq +8 -> 56
    //   51: aload_2
    //   52: invokevirtual 217	java/io/File:delete	()Z
    //   55: pop
    //   56: new 43	java/io/File
    //   59: dup
    //   60: new 65	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   67: aload 8
    //   69: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 21
    //   74: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore 9
    //   85: aload 9
    //   87: invokevirtual 251	java/io/File:exists	()Z
    //   90: ifeq +9 -> 99
    //   93: aload 9
    //   95: invokevirtual 217	java/io/File:delete	()Z
    //   98: pop
    //   99: aload 9
    //   101: invokevirtual 254	java/io/File:createNewFile	()Z
    //   104: pop
    //   105: aload_0
    //   106: invokevirtual 260	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   109: new 65	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 262
    //   119: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_1
    //   123: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokevirtual 268	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   132: astore_0
    //   133: new 171	java/io/FileOutputStream
    //   136: dup
    //   137: aload 9
    //   139: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   142: astore_1
    //   143: sipush 8192
    //   146: newarray byte
    //   148: astore 6
    //   150: aload_0
    //   151: aload 6
    //   153: invokevirtual 180	java/io/InputStream:read	([B)I
    //   156: istore_3
    //   157: iload_3
    //   158: iconst_m1
    //   159: if_icmpeq +55 -> 214
    //   162: aload_1
    //   163: aload 6
    //   165: iconst_0
    //   166: iload_3
    //   167: invokevirtual 271	java/io/OutputStream:write	([BII)V
    //   170: goto -20 -> 150
    //   173: astore 6
    //   175: aload_1
    //   176: astore_2
    //   177: aload_0
    //   178: astore_1
    //   179: aload_2
    //   180: astore_0
    //   181: aload 6
    //   183: astore_2
    //   184: new 231	java/lang/Exception
    //   187: dup
    //   188: ldc 236
    //   190: aload_2
    //   191: invokespecial 274	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   194: athrow
    //   195: astore 6
    //   197: aload_0
    //   198: astore_2
    //   199: aload_1
    //   200: astore_0
    //   201: aload 6
    //   203: astore_1
    //   204: aload_0
    //   205: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   208: aload_2
    //   209: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   212: aload_1
    //   213: athrow
    //   214: aload_0
    //   215: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   218: aload_1
    //   219: invokestatic 195	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   222: aload_2
    //   223: invokevirtual 251	java/io/File:exists	()Z
    //   226: ifeq +118 -> 344
    //   229: aload_2
    //   230: invokevirtual 217	java/io/File:delete	()Z
    //   233: istore 4
    //   235: aload 9
    //   237: aload_2
    //   238: invokevirtual 278	java/io/File:renameTo	(Ljava/io/File;)Z
    //   241: istore 5
    //   243: ldc_w 287
    //   246: astore_0
    //   247: iload 5
    //   249: ifeq +9 -> 258
    //   252: aload 8
    //   254: invokestatic 293	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   257: astore_0
    //   258: ldc 219
    //   260: iconst_1
    //   261: new 65	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   268: ldc 236
    //   270: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload 4
    //   275: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   278: ldc_w 283
    //   281: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: iload 5
    //   286: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload_0
    //   296: areturn
    //   297: astore_1
    //   298: aconst_null
    //   299: astore_0
    //   300: aload 6
    //   302: astore_2
    //   303: goto -99 -> 204
    //   306: astore_1
    //   307: aload 6
    //   309: astore_2
    //   310: goto -106 -> 204
    //   313: astore 6
    //   315: aload_1
    //   316: astore_2
    //   317: aload 6
    //   319: astore_1
    //   320: goto -116 -> 204
    //   323: astore_2
    //   324: aconst_null
    //   325: astore_0
    //   326: aload 7
    //   328: astore_1
    //   329: goto -145 -> 184
    //   332: astore_2
    //   333: aconst_null
    //   334: astore 6
    //   336: aload_0
    //   337: astore_1
    //   338: aload 6
    //   340: astore_0
    //   341: goto -157 -> 184
    //   344: iconst_1
    //   345: istore 4
    //   347: goto -112 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramContext	Context
    //   0	350	1	paramString	String
    //   0	350	2	paramFile	File
    //   156	11	3	i	int
    //   233	113	4	bool1	boolean
    //   241	44	5	bool2	boolean
    //   1	163	6	arrayOfByte	byte[]
    //   173	9	6	localException	Exception
    //   195	113	6	localObject1	Object
    //   313	5	6	localObject2	Object
    //   334	5	6	localObject3	Object
    //   4	323	7	localObject4	Object
    //   10	243	8	str	String
    //   83	153	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   143	150	173	java/lang/Exception
    //   150	157	173	java/lang/Exception
    //   162	170	173	java/lang/Exception
    //   184	195	195	finally
    //   105	133	297	finally
    //   133	143	306	finally
    //   143	150	313	finally
    //   150	157	313	finally
    //   162	170	313	finally
    //   105	133	323	java/lang/Exception
    //   133	143	332	java/lang/Exception
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
  
  public static File getInstalledPluginPath(Context paramContext, String paramString)
  {
    Object localObject = null;
    PluginBaseInfo localPluginBaseInfo = PluginBaseInfoHelper.createFromFile(getPluginCfgFile(getPluginInstallDir(paramContext), paramString), PluginBaseInfo.class);
    if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4) || (localPluginBaseInfo.mInstalledPath == null)) {
      paramContext = a(paramContext, paramString);
    }
    do
    {
      return paramContext;
      paramContext = localObject;
    } while (!PluginStatic.a(localPluginBaseInfo.mInstalledPath));
    return new File(localPluginBaseInfo.mInstalledPath);
  }
  
  public static String getMultiDexJarName(String paramString, int paramInt)
  {
    return String.format("%s_%d.jar", new Object[] { paramString.substring(0, paramString.lastIndexOf(".")), Integer.valueOf(paramInt) });
  }
  
  public static File getMultiDexSecondDex(Context paramContext, String paramString)
  {
    return new File(getPluginInstallDir(paramContext), getMultiDexJarName(paramString, 2));
  }
  
  public static File getOptimizedDexPath(Context paramContext)
  {
    return paramContext.getDir("odex", 0);
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    PackageInfo localPackageInfo = (PackageInfo)c.get(paramString);
    paramContext = localPackageInfo;
    if (localPackageInfo == null)
    {
      DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo start");
      localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, 128);
      DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo end");
      paramContext = localPackageInfo;
      if (localPackageInfo != null)
      {
        c.put(paramString, localPackageInfo);
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
  
  static class a
    extends Exception
  {
    private static final long a = 1L;
    
    public a(String paramString)
    {
      super();
    }
    
    public a(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  static class b
    extends Exception
  {
    private static final long a = 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginUtils
 * JD-Core Version:    0.7.0.1
 */