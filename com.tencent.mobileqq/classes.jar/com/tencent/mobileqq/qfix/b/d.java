package com.tencent.mobileqq.qfix.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class d
{
  private static void a(String paramString)
  {
    Log.e("ResourcePatch", paramString);
  }
  
  /* Error */
  public static void a(ZipEntry paramZipEntry, File paramFile, long paramLong, java.util.zip.ZipOutputStream paramZipOutputStream)
  {
    // Byte code:
    //   0: new 22	java/util/zip/ZipEntry
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 25	java/util/zip/ZipEntry:<init>	(Ljava/util/zip/ZipEntry;)V
    //   8: astore_0
    //   9: aload_0
    //   10: iconst_0
    //   11: invokevirtual 29	java/util/zip/ZipEntry:setMethod	(I)V
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 35	java/io/File:length	()J
    //   19: invokevirtual 39	java/util/zip/ZipEntry:setSize	(J)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 35	java/io/File:length	()J
    //   27: invokevirtual 42	java/util/zip/ZipEntry:setCompressedSize	(J)V
    //   30: aload_0
    //   31: lload_2
    //   32: invokevirtual 45	java/util/zip/ZipEntry:setCrc	(J)V
    //   35: new 47	java/io/BufferedInputStream
    //   38: dup
    //   39: new 49	java/io/FileInputStream
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 55	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_1
    //   51: aload 4
    //   53: new 22	java/util/zip/ZipEntry
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 25	java/util/zip/ZipEntry:<init>	(Ljava/util/zip/ZipEntry;)V
    //   61: invokevirtual 60	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   64: sipush 16384
    //   67: newarray byte
    //   69: astore_0
    //   70: aload_1
    //   71: aload_0
    //   72: invokevirtual 64	java/io/BufferedInputStream:read	([B)I
    //   75: istore 5
    //   77: iload 5
    //   79: iconst_m1
    //   80: if_icmpeq +15 -> 95
    //   83: aload 4
    //   85: aload_0
    //   86: iconst_0
    //   87: iload 5
    //   89: invokevirtual 68	java/util/zip/ZipOutputStream:write	([BII)V
    //   92: goto -22 -> 70
    //   95: aload 4
    //   97: invokevirtual 71	java/util/zip/ZipOutputStream:closeEntry	()V
    //   100: aload_1
    //   101: invokevirtual 74	java/io/BufferedInputStream:close	()V
    //   104: return
    //   105: astore_0
    //   106: goto +6 -> 112
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 74	java/io/BufferedInputStream:close	()V
    //   120: goto +5 -> 125
    //   123: aload_0
    //   124: athrow
    //   125: goto -2 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramZipEntry	ZipEntry
    //   0	128	1	paramFile	File
    //   0	128	2	paramLong	long
    //   0	128	4	paramZipOutputStream	java.util.zip.ZipOutputStream
    //   75	13	5	i	int
    // Exception table:
    //   from	to	target	type
    //   51	70	105	finally
    //   70	77	105	finally
    //   83	92	105	finally
    //   95	100	105	finally
    //   35	51	109	finally
  }
  
  /* Error */
  public static void a(ZipFile paramZipFile, ZipEntry paramZipEntry, java.util.zip.ZipOutputStream paramZipOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 81	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   5: astore_0
    //   6: aload_2
    //   7: new 22	java/util/zip/ZipEntry
    //   10: dup
    //   11: aload_1
    //   12: invokevirtual 85	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   15: invokespecial 87	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 60	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   21: sipush 16384
    //   24: newarray byte
    //   26: astore 4
    //   28: aload_0
    //   29: aload 4
    //   31: invokevirtual 90	java/io/InputStream:read	([B)I
    //   34: istore_3
    //   35: iload_3
    //   36: iconst_m1
    //   37: if_icmpeq +14 -> 51
    //   40: aload_2
    //   41: aload 4
    //   43: iconst_0
    //   44: iload_3
    //   45: invokevirtual 68	java/util/zip/ZipOutputStream:write	([BII)V
    //   48: goto -20 -> 28
    //   51: aload_2
    //   52: invokevirtual 71	java/util/zip/ZipOutputStream:closeEntry	()V
    //   55: new 92	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   62: astore_2
    //   63: aload_2
    //   64: ldc 95
    //   66: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_2
    //   71: aload_1
    //   72: invokevirtual 85	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   75: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_2
    //   80: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 104	com/tencent/mobileqq/qfix/b/d:a	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 105	java/io/InputStream:close	()V
    //   94: return
    //   95: astore_2
    //   96: goto +6 -> 102
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_0
    //   102: new 92	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   109: astore 4
    //   111: aload 4
    //   113: ldc 95
    //   115: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 4
    //   121: aload_1
    //   122: invokevirtual 85	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   125: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 4
    //   131: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 104	com/tencent/mobileqq/qfix/b/d:a	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: ifnull +7 -> 145
    //   141: aload_0
    //   142: invokevirtual 105	java/io/InputStream:close	()V
    //   145: goto +5 -> 150
    //   148: aload_2
    //   149: athrow
    //   150: goto -2 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramZipFile	ZipFile
    //   0	153	1	paramZipEntry	ZipEntry
    //   0	153	2	paramZipOutputStream	java.util.zip.ZipOutputStream
    //   34	11	3	i	int
    //   26	104	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	28	95	finally
    //   28	35	95	finally
    //   40	48	95	finally
    //   51	55	95	finally
    //   0	6	99	finally
  }
  
  /* Error */
  private static boolean a(@NonNull Context paramContext, File paramFile1, File paramFile2, e parame, File paramFile3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 115	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   4: astore_0
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 117
    //   11: invokestatic 104	com/tencent/mobileqq/qfix/b/d:a	(Ljava/lang/String;)V
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 123	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   20: astore 8
    //   22: aconst_null
    //   23: astore 7
    //   25: new 57	java/util/zip/ZipOutputStream
    //   28: dup
    //   29: new 125	java/io/FileOutputStream
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 126	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: invokespecial 129	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   40: astore 6
    //   42: new 77	java/util/zip/ZipFile
    //   45: dup
    //   46: aload 8
    //   48: invokespecial 130	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: new 77	java/util/zip/ZipFile
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 131	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   60: astore_0
    //   61: aload_3
    //   62: aload 4
    //   64: aload_1
    //   65: new 31	java/io/File
    //   68: dup
    //   69: aload 8
    //   71: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: invokestatic 135	com/tencent/mobileqq/qfix/b/d:a	(Lcom/tencent/mobileqq/qfix/b/e;Ljava/io/File;Ljava/io/File;Ljava/io/File;)Z
    //   77: pop
    //   78: aload_2
    //   79: invokevirtual 139	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   82: astore_1
    //   83: aload_1
    //   84: invokeinterface 145 1 0
    //   89: istore 5
    //   91: iload 5
    //   93: ifeq +112 -> 205
    //   96: aload_1
    //   97: invokeinterface 149 1 0
    //   102: checkcast 22	java/util/zip/ZipEntry
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +86 -> 195
    //   112: aload 4
    //   114: invokevirtual 85	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   117: astore 7
    //   119: aload 7
    //   121: ldc 151
    //   123: invokevirtual 157	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   126: ifeq +6 -> 132
    //   129: goto -46 -> 83
    //   132: aload_3
    //   133: getfield 163	com/tencent/mobileqq/qfix/b/e:l	Ljava/util/Set;
    //   136: aload 7
    //   138: invokeinterface 168 2 0
    //   143: ifne -60 -> 83
    //   146: aload_3
    //   147: getfield 171	com/tencent/mobileqq/qfix/b/e:m	Ljava/util/Set;
    //   150: aload 7
    //   152: invokeinterface 168 2 0
    //   157: ifne -74 -> 83
    //   160: aload_3
    //   161: getfield 174	com/tencent/mobileqq/qfix/b/e:n	Ljava/util/Set;
    //   164: aload 7
    //   166: invokeinterface 168 2 0
    //   171: ifne -88 -> 83
    //   174: aload 7
    //   176: ldc 176
    //   178: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifne -98 -> 83
    //   184: aload_2
    //   185: aload 4
    //   187: aload 6
    //   189: invokestatic 181	com/tencent/mobileqq/qfix/b/d:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/util/zip/ZipOutputStream;)V
    //   192: goto -109 -> 83
    //   195: new 183	java/lang/RuntimeException
    //   198: dup
    //   199: ldc 185
    //   201: invokespecial 186	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   204: athrow
    //   205: aload_2
    //   206: ldc 176
    //   208: invokevirtual 190	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   211: astore_1
    //   212: aload_1
    //   213: ifnull +390 -> 603
    //   216: aload_2
    //   217: aload_1
    //   218: aload 6
    //   220: invokestatic 181	com/tencent/mobileqq/qfix/b/d:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/util/zip/ZipOutputStream;)V
    //   223: aload_3
    //   224: getfield 163	com/tencent/mobileqq/qfix/b/e:l	Ljava/util/Set;
    //   227: invokeinterface 194 1 0
    //   232: astore 4
    //   234: aload 4
    //   236: invokeinterface 199 1 0
    //   241: istore 5
    //   243: iload 5
    //   245: ifeq +109 -> 354
    //   248: aload 4
    //   250: invokeinterface 202 1 0
    //   255: checkcast 153	java/lang/String
    //   258: astore_1
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual 190	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   264: astore 7
    //   266: aload 7
    //   268: ifnull +46 -> 314
    //   271: new 92	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   278: astore 8
    //   280: aload 8
    //   282: ldc 204
    //   284: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 8
    //   290: aload_1
    //   291: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 8
    //   297: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 104	com/tencent/mobileqq/qfix/b/d:a	(Ljava/lang/String;)V
    //   303: aload_0
    //   304: aload 7
    //   306: aload 6
    //   308: invokestatic 181	com/tencent/mobileqq/qfix/b/d:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/util/zip/ZipOutputStream;)V
    //   311: goto -77 -> 234
    //   314: new 92	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   321: astore_3
    //   322: aload_3
    //   323: ldc 206
    //   325: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_3
    //   330: aload_1
    //   331: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_3
    //   336: ldc 208
    //   338: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: new 183	java/lang/RuntimeException
    //   345: dup
    //   346: aload_3
    //   347: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokespecial 186	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   353: athrow
    //   354: aload_3
    //   355: getfield 171	com/tencent/mobileqq/qfix/b/e:m	Ljava/util/Set;
    //   358: invokeinterface 194 1 0
    //   363: astore 4
    //   365: aload 4
    //   367: invokeinterface 199 1 0
    //   372: ifeq +109 -> 481
    //   375: aload 4
    //   377: invokeinterface 202 1 0
    //   382: checkcast 153	java/lang/String
    //   385: astore_1
    //   386: aload_0
    //   387: aload_1
    //   388: invokevirtual 190	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   391: astore 7
    //   393: aload 7
    //   395: ifnull +46 -> 441
    //   398: new 92	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   405: astore 8
    //   407: aload 8
    //   409: ldc 210
    //   411: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 8
    //   417: aload_1
    //   418: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 8
    //   424: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 104	com/tencent/mobileqq/qfix/b/d:a	(Ljava/lang/String;)V
    //   430: aload_0
    //   431: aload 7
    //   433: aload 6
    //   435: invokestatic 181	com/tencent/mobileqq/qfix/b/d:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/util/zip/ZipOutputStream;)V
    //   438: goto -73 -> 365
    //   441: new 92	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   448: astore_3
    //   449: aload_3
    //   450: ldc 212
    //   452: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload_3
    //   457: aload_1
    //   458: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload_3
    //   463: ldc 208
    //   465: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: new 183	java/lang/RuntimeException
    //   472: dup
    //   473: aload_3
    //   474: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokespecial 186	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   480: athrow
    //   481: aload_3
    //   482: getfield 174	com/tencent/mobileqq/qfix/b/e:n	Ljava/util/Set;
    //   485: invokeinterface 194 1 0
    //   490: astore_1
    //   491: aload_1
    //   492: invokeinterface 199 1 0
    //   497: ifeq +96 -> 593
    //   500: aload_1
    //   501: invokeinterface 202 1 0
    //   506: checkcast 153	java/lang/String
    //   509: astore 4
    //   511: aload_3
    //   512: getfield 216	com/tencent/mobileqq/qfix/b/e:o	Ljava/util/Map;
    //   515: aload 4
    //   517: invokeinterface 222 2 0
    //   522: checkcast 224	com/tencent/mobileqq/qfix/b/e$a
    //   525: astore 7
    //   527: aload_2
    //   528: aload 4
    //   530: invokevirtual 190	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   533: aload 7
    //   535: getfield 228	com/tencent/mobileqq/qfix/b/e$a:c	Ljava/io/File;
    //   538: aload 7
    //   540: getfield 232	com/tencent/mobileqq/qfix/b/e$a:b	J
    //   543: aload 6
    //   545: invokestatic 234	com/tencent/mobileqq/qfix/b/d:a	(Ljava/util/zip/ZipEntry;Ljava/io/File;JLjava/util/zip/ZipOutputStream;)V
    //   548: aload 7
    //   550: getfield 228	com/tencent/mobileqq/qfix/b/e$a:c	Ljava/io/File;
    //   553: invokestatic 239	com/tencent/mobileqq/qfix/b/f:a	(Ljava/io/File;)Z
    //   556: pop
    //   557: new 92	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   564: astore 7
    //   566: aload 7
    //   568: ldc 241
    //   570: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 7
    //   576: aload 4
    //   578: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 7
    //   584: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 104	com/tencent/mobileqq/qfix/b/d:a	(Ljava/lang/String;)V
    //   590: goto -99 -> 491
    //   593: aload 6
    //   595: invokestatic 244	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   598: aload_2
    //   599: astore_1
    //   600: goto +102 -> 702
    //   603: new 183	java/lang/RuntimeException
    //   606: dup
    //   607: ldc 246
    //   609: invokespecial 186	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   612: athrow
    //   613: astore_1
    //   614: aload 6
    //   616: astore_3
    //   617: goto +102 -> 719
    //   620: astore_1
    //   621: goto +34 -> 655
    //   624: astore_1
    //   625: aconst_null
    //   626: astore_0
    //   627: aload 6
    //   629: astore_3
    //   630: goto +89 -> 719
    //   633: astore_1
    //   634: aconst_null
    //   635: astore_0
    //   636: goto +19 -> 655
    //   639: astore_1
    //   640: aconst_null
    //   641: astore_2
    //   642: aload_2
    //   643: astore_0
    //   644: aload 6
    //   646: astore_3
    //   647: goto +72 -> 719
    //   650: astore_1
    //   651: aconst_null
    //   652: astore_2
    //   653: aload_2
    //   654: astore_0
    //   655: aload 6
    //   657: astore_3
    //   658: aload_1
    //   659: astore 4
    //   661: aload_2
    //   662: astore_1
    //   663: goto +22 -> 685
    //   666: astore_1
    //   667: aconst_null
    //   668: astore_2
    //   669: aload_2
    //   670: astore_3
    //   671: aload_3
    //   672: astore_0
    //   673: goto +46 -> 719
    //   676: astore 4
    //   678: aconst_null
    //   679: astore_1
    //   680: aload_1
    //   681: astore_0
    //   682: aload 7
    //   684: astore_3
    //   685: aload 4
    //   687: invokevirtual 249	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   690: invokestatic 104	com/tencent/mobileqq/qfix/b/d:a	(Ljava/lang/String;)V
    //   693: aload 4
    //   695: invokevirtual 252	java/lang/Throwable:printStackTrace	()V
    //   698: aload_3
    //   699: invokestatic 244	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   702: aload_1
    //   703: invokestatic 244	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   706: aload_0
    //   707: invokestatic 244	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   710: iconst_0
    //   711: ireturn
    //   712: astore 4
    //   714: aload_1
    //   715: astore_2
    //   716: aload 4
    //   718: astore_1
    //   719: aload_3
    //   720: invokestatic 244	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   723: aload_2
    //   724: invokestatic 244	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   727: aload_0
    //   728: invokestatic 244	com/tencent/mobileqq/qfix/b/f:a	(Ljava/lang/Object;)V
    //   731: goto +5 -> 736
    //   734: aload_1
    //   735: athrow
    //   736: goto -2 -> 734
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	739	0	paramContext	Context
    //   0	739	1	paramFile1	File
    //   0	739	2	paramFile2	File
    //   0	739	3	parame	e
    //   0	739	4	paramFile3	File
    //   89	155	5	bool	boolean
    //   40	616	6	localZipOutputStream	java.util.zip.ZipOutputStream
    //   23	660	7	localObject1	Object
    //   20	403	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   61	83	613	finally
    //   83	91	613	finally
    //   96	107	613	finally
    //   112	129	613	finally
    //   132	192	613	finally
    //   195	205	613	finally
    //   205	212	613	finally
    //   216	234	613	finally
    //   234	243	613	finally
    //   248	266	613	finally
    //   271	311	613	finally
    //   314	354	613	finally
    //   354	365	613	finally
    //   365	393	613	finally
    //   398	438	613	finally
    //   441	481	613	finally
    //   481	491	613	finally
    //   491	590	613	finally
    //   603	613	613	finally
    //   61	83	620	java/lang/Throwable
    //   83	91	620	java/lang/Throwable
    //   96	107	620	java/lang/Throwable
    //   112	129	620	java/lang/Throwable
    //   132	192	620	java/lang/Throwable
    //   195	205	620	java/lang/Throwable
    //   205	212	620	java/lang/Throwable
    //   216	234	620	java/lang/Throwable
    //   234	243	620	java/lang/Throwable
    //   248	266	620	java/lang/Throwable
    //   271	311	620	java/lang/Throwable
    //   314	354	620	java/lang/Throwable
    //   354	365	620	java/lang/Throwable
    //   365	393	620	java/lang/Throwable
    //   398	438	620	java/lang/Throwable
    //   441	481	620	java/lang/Throwable
    //   481	491	620	java/lang/Throwable
    //   491	590	620	java/lang/Throwable
    //   603	613	620	java/lang/Throwable
    //   52	61	624	finally
    //   52	61	633	java/lang/Throwable
    //   42	52	639	finally
    //   42	52	650	java/lang/Throwable
    //   25	42	666	finally
    //   25	42	676	java/lang/Throwable
    //   685	698	712	finally
  }
  
  public static boolean a(@NonNull Context paramContext, String paramString1, String paramString2, File paramFile)
  {
    paramString2 = e.a(paramString2);
    File localFile1 = new File(new File(paramString1), "res_tmp");
    File localFile2 = new File(localFile1, "resources.apk");
    if (!a.a(paramContext)) {
      return false;
    }
    if (localFile2.exists()) {
      if (a(localFile2, paramString2.j)) {
        a("the target patch has exist.");
      }
    }
    label99:
    do
    {
      return a.a(paramContext, localFile2.getAbsolutePath());
      localFile2.delete();
      break label99;
      localFile1.mkdirs();
      paramString1 = b.a(paramFile);
      if (!f.a(paramString1, paramString2.k))
      {
        paramContext = new StringBuilder();
        paramContext.append("the MD5 mismatch, expected: ");
        paramContext.append(paramString2.k);
        paramContext.append(", actual:");
        paramContext.append(paramString1);
        a(paramContext.toString());
        return false;
      }
    } while (!a(paramContext, paramFile, localFile2, paramString2, localFile1));
    return false;
  }
  
  private static boolean a(e parame, File paramFile1, File paramFile2, File paramFile3)
  {
    if (parame.n != null)
    {
      if (parame.n.isEmpty()) {
        return true;
      }
      paramFile2 = new ZipFile(paramFile2);
      paramFile3 = new ZipFile(paramFile3);
      parame = parame.o.entrySet().iterator();
      while (parame.hasNext())
      {
        Object localObject1 = (Map.Entry)parame.next();
        System.nanoTime();
        Object localObject2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (e.a)((Map.Entry)localObject1).getValue();
        if (localObject1 == null) {
          return false;
        }
        ((e.a)localObject1).c = new File(paramFile1, (String)localObject2);
        if (!TextUtils.isEmpty(((e.a)localObject1).a))
        {
          if (((e.a)localObject1).a.length() != 32) {
            return false;
          }
          ZipEntry localZipEntry = paramFile2.getEntry((String)localObject2);
          if (localZipEntry == null) {
            return false;
          }
          localObject2 = paramFile3.getEntry((String)localObject2);
          if (localObject2 == null) {
            return false;
          }
          com.tencent.mobileqq.qfix.a.a.a(paramFile3.getInputStream((ZipEntry)localObject2), paramFile2.getInputStream(localZipEntry), ((e.a)localObject1).c);
          if (!TextUtils.equals(((e.a)localObject1).a, b.a(((e.a)localObject1).c)))
          {
            parame = new StringBuilder();
            parame.append("large file '");
            parame.append(((e.a)localObject1).c);
            parame.append("' md5 mismatch");
            a(parame.toString());
            f.a(((e.a)localObject1).c);
          }
        }
        else
        {
          return false;
        }
      }
    }
    return true;
  }
  
  private static boolean a(File paramFile, String paramString)
  {
    return f.a(b.a(paramFile, "resources.arsc"), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.b.d
 * JD-Core Version:    0.7.0.1
 */