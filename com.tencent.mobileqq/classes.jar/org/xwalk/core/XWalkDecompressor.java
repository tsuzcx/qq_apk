package org.xwalk.core;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.InputStream;

public class XWalkDecompressor
{
  private static final int LZMA_OUTSIZE = 8;
  private static final int LZMA_PROP_SIZE = 5;
  private static final String[] MANDATORY_LIBRARIES = { "libxwalkcore.so" };
  private static final int STREAM_BUFFER_SIZE = 1048576;
  private static final String TAG = "XWalkLib";
  
  /* Error */
  public static void copyApkToLocal(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 35	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 38
    //   11: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_3
    //   16: aload_0
    //   17: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: ldc 17
    //   23: aload_3
    //   24: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 51	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aconst_null
    //   31: astore_3
    //   32: aconst_null
    //   33: astore 4
    //   35: new 53	java/io/FileInputStream
    //   38: dup
    //   39: new 55	java/io/File
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: astore_0
    //   51: new 55	java/io/File
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 65	java/io/File:exists	()Z
    //   64: ifeq +8 -> 72
    //   67: aload_1
    //   68: invokevirtual 68	java/io/File:delete	()Z
    //   71: pop
    //   72: new 70	java/io/FileOutputStream
    //   75: dup
    //   76: aload_1
    //   77: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: astore_1
    //   81: sipush 1024
    //   84: newarray byte
    //   86: astore_3
    //   87: aload_0
    //   88: aload_3
    //   89: invokevirtual 75	java/io/FileInputStream:read	([B)I
    //   92: istore_2
    //   93: iload_2
    //   94: ifle +13 -> 107
    //   97: aload_1
    //   98: aload_3
    //   99: iconst_0
    //   100: iload_2
    //   101: invokevirtual 79	java/io/FileOutputStream:write	([BII)V
    //   104: goto -17 -> 87
    //   107: aload_0
    //   108: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   111: aload_1
    //   112: astore_0
    //   113: goto +61 -> 174
    //   116: astore_3
    //   117: goto +68 -> 185
    //   120: astore_3
    //   121: goto +16 -> 137
    //   124: astore 4
    //   126: aload_3
    //   127: astore_1
    //   128: aload 4
    //   130: astore_3
    //   131: goto +54 -> 185
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_0
    //   138: astore 4
    //   140: aload_1
    //   141: astore_0
    //   142: goto +18 -> 160
    //   145: astore 4
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_3
    //   150: astore_1
    //   151: aload 4
    //   153: astore_3
    //   154: goto +31 -> 185
    //   157: astore_3
    //   158: aconst_null
    //   159: astore_0
    //   160: ldc 87
    //   162: aload_3
    //   163: invokevirtual 90	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   166: invokestatic 93	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload 4
    //   171: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   174: aload_0
    //   175: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   178: return
    //   179: astore_3
    //   180: aload_0
    //   181: astore_1
    //   182: aload 4
    //   184: astore_0
    //   185: aload_0
    //   186: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   189: aload_1
    //   190: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   193: goto +5 -> 198
    //   196: aload_3
    //   197: athrow
    //   198: goto -2 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramString1	String
    //   0	201	1	paramString2	String
    //   92	9	2	i	int
    //   7	92	3	localObject1	Object
    //   116	1	3	localObject2	Object
    //   120	7	3	localException1	java.lang.Exception
    //   130	1	3	localObject3	Object
    //   134	16	3	localException2	java.lang.Exception
    //   153	1	3	localObject4	Object
    //   157	6	3	localException3	java.lang.Exception
    //   179	18	3	localObject5	Object
    //   33	1	4	localObject6	Object
    //   124	5	4	localObject7	Object
    //   138	1	4	str	String
    //   145	38	4	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   81	87	116	finally
    //   87	93	116	finally
    //   97	104	116	finally
    //   81	87	120	java/lang/Exception
    //   87	93	120	java/lang/Exception
    //   97	104	120	java/lang/Exception
    //   51	72	124	finally
    //   72	81	124	finally
    //   51	72	134	java/lang/Exception
    //   72	81	134	java/lang/Exception
    //   35	51	145	finally
    //   35	51	157	java/lang/Exception
    //   160	169	179	finally
  }
  
  /* Error */
  public static boolean decompressDownloadFullZip(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 35	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc 99
    //   13: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 5
    //   19: aload_0
    //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 5
    //   26: ldc 101
    //   28: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 5
    //   34: iload_1
    //   35: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 17
    //   41: aload 5
    //   43: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 107	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: invokestatic 113	android/os/SystemClock:uptimeMillis	()J
    //   52: lstore_3
    //   53: aconst_null
    //   54: astore 7
    //   56: aconst_null
    //   57: astore 8
    //   59: new 115	java/util/zip/ZipFile
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 116	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   67: astore 6
    //   69: aload 6
    //   71: invokevirtual 120	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   74: astore 8
    //   76: aload 8
    //   78: invokeinterface 125 1 0
    //   83: ifeq +283 -> 366
    //   86: aload 8
    //   88: invokeinterface 129 1 0
    //   93: checkcast 131	java/util/zip/ZipEntry
    //   96: astore_0
    //   97: aload_0
    //   98: invokevirtual 134	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   101: ldc 136
    //   103: invokestatic 142	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 5
    //   108: new 35	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   115: astore 9
    //   117: aload 9
    //   119: ldc 144
    //   121: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 9
    //   127: aload 5
    //   129: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: ldc 17
    //   135: aload 9
    //   137: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 107	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload 5
    //   145: ldc 146
    //   147: invokevirtual 150	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   150: ifne -74 -> 76
    //   153: aload 5
    //   155: ldc 152
    //   157: invokevirtual 150	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   160: ifne -84 -> 76
    //   163: aload_0
    //   164: invokevirtual 155	java/util/zip/ZipEntry:isDirectory	()Z
    //   167: ifeq +6 -> 173
    //   170: goto -94 -> 76
    //   173: aload 6
    //   175: aload_0
    //   176: invokevirtual 159	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   179: astore_0
    //   180: aload 5
    //   182: ldc 161
    //   184: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq +19 -> 206
    //   190: new 55	java/io/File
    //   193: dup
    //   194: iload_1
    //   195: invokestatic 171	org/xwalk/core/XWalkEnvironment:getDownloadApkPath	(I)Ljava/lang/String;
    //   198: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 5
    //   203: goto +18 -> 221
    //   206: new 55	java/io/File
    //   209: dup
    //   210: iload_1
    //   211: aload 5
    //   213: invokestatic 175	org/xwalk/core/XWalkEnvironment:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
    //   216: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   219: astore 5
    //   221: aload 5
    //   223: invokevirtual 65	java/io/File:exists	()Z
    //   226: ifne +27 -> 253
    //   229: aload 5
    //   231: invokevirtual 179	java/io/File:getParentFile	()Ljava/io/File;
    //   234: astore 9
    //   236: aload 9
    //   238: invokevirtual 65	java/io/File:exists	()Z
    //   241: ifne +18 -> 259
    //   244: aload 9
    //   246: invokevirtual 182	java/io/File:mkdirs	()Z
    //   249: pop
    //   250: goto +9 -> 259
    //   253: aload 5
    //   255: invokevirtual 68	java/io/File:delete	()Z
    //   258: pop
    //   259: new 70	java/io/FileOutputStream
    //   262: dup
    //   263: aload 5
    //   265: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   268: astore 5
    //   270: ldc 13
    //   272: newarray byte
    //   274: astore 9
    //   276: aload_0
    //   277: aload 9
    //   279: invokevirtual 185	java/io/InputStream:read	([B)I
    //   282: istore_2
    //   283: iload_2
    //   284: iconst_m1
    //   285: if_icmpeq +22 -> 307
    //   288: aload 5
    //   290: aload 9
    //   292: iconst_0
    //   293: iload_2
    //   294: invokevirtual 188	java/io/OutputStream:write	([BII)V
    //   297: aload_0
    //   298: aload 9
    //   300: invokevirtual 185	java/io/InputStream:read	([B)I
    //   303: istore_2
    //   304: goto -21 -> 283
    //   307: aload 5
    //   309: invokevirtual 191	java/io/OutputStream:close	()V
    //   312: aload_0
    //   313: invokevirtual 192	java/io/InputStream:close	()V
    //   316: goto -240 -> 76
    //   319: astore 8
    //   321: aload 5
    //   323: astore 7
    //   325: aload 8
    //   327: astore 5
    //   329: goto +213 -> 542
    //   332: astore 8
    //   334: aload_0
    //   335: astore 7
    //   337: aload 5
    //   339: astore_0
    //   340: aload 8
    //   342: astore 5
    //   344: goto +88 -> 432
    //   347: astore 5
    //   349: goto +193 -> 542
    //   352: astore 5
    //   354: aconst_null
    //   355: astore 8
    //   357: aload_0
    //   358: astore 7
    //   360: aload 8
    //   362: astore_0
    //   363: goto +69 -> 432
    //   366: aload 6
    //   368: invokevirtual 193	java/util/zip/ZipFile:close	()V
    //   371: invokestatic 198	java/lang/System:gc	()V
    //   374: new 35	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   381: astore_0
    //   382: aload_0
    //   383: ldc 200
    //   385: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_0
    //   390: invokestatic 113	android/os/SystemClock:uptimeMillis	()J
    //   393: lload_3
    //   394: lsub
    //   395: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload_0
    //   400: ldc 205
    //   402: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: ldc 17
    //   408: aload_0
    //   409: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 51	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: iconst_1
    //   416: ireturn
    //   417: astore 5
    //   419: aconst_null
    //   420: astore_0
    //   421: goto +121 -> 542
    //   424: astore 5
    //   426: aconst_null
    //   427: astore 7
    //   429: aload 7
    //   431: astore_0
    //   432: aload 6
    //   434: astore 8
    //   436: aload 7
    //   438: astore 6
    //   440: goto +22 -> 462
    //   443: astore 5
    //   445: aconst_null
    //   446: astore 6
    //   448: aload 6
    //   450: astore_0
    //   451: goto +91 -> 542
    //   454: astore 5
    //   456: aconst_null
    //   457: astore 6
    //   459: aload 6
    //   461: astore_0
    //   462: new 35	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   469: astore 7
    //   471: aload 7
    //   473: ldc 207
    //   475: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 7
    //   481: aload 5
    //   483: invokevirtual 210	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   486: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: ldc 17
    //   492: aload 7
    //   494: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 93	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: aload 8
    //   502: ifnull +8 -> 510
    //   505: aload 8
    //   507: invokevirtual 193	java/util/zip/ZipFile:close	()V
    //   510: aload_0
    //   511: ifnull +7 -> 518
    //   514: aload_0
    //   515: invokevirtual 191	java/io/OutputStream:close	()V
    //   518: aload 6
    //   520: ifnull +8 -> 528
    //   523: aload 6
    //   525: invokevirtual 192	java/io/InputStream:close	()V
    //   528: iconst_0
    //   529: ireturn
    //   530: astore 5
    //   532: aload_0
    //   533: astore 7
    //   535: aload 6
    //   537: astore_0
    //   538: aload 8
    //   540: astore 6
    //   542: aload 6
    //   544: ifnull +8 -> 552
    //   547: aload 6
    //   549: invokevirtual 193	java/util/zip/ZipFile:close	()V
    //   552: aload 7
    //   554: ifnull +8 -> 562
    //   557: aload 7
    //   559: invokevirtual 191	java/io/OutputStream:close	()V
    //   562: aload_0
    //   563: ifnull +7 -> 570
    //   566: aload_0
    //   567: invokevirtual 192	java/io/InputStream:close	()V
    //   570: goto +6 -> 576
    //   573: aload 5
    //   575: athrow
    //   576: goto -3 -> 573
    //   579: astore_0
    //   580: goto -209 -> 371
    //   583: astore_0
    //   584: iconst_0
    //   585: ireturn
    //   586: astore_0
    //   587: goto -17 -> 570
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	paramString	String
    //   0	590	1	paramInt	int
    //   282	22	2	i	int
    //   52	342	3	l	long
    //   7	336	5	localObject1	Object
    //   347	1	5	localObject2	Object
    //   352	1	5	localIOException1	java.io.IOException
    //   417	1	5	localObject3	Object
    //   424	1	5	localIOException2	java.io.IOException
    //   443	1	5	localObject4	Object
    //   454	28	5	localIOException3	java.io.IOException
    //   530	44	5	localObject5	Object
    //   67	481	6	localObject6	Object
    //   54	504	7	localObject7	Object
    //   57	30	8	localEnumeration	java.util.Enumeration
    //   319	7	8	localObject8	Object
    //   332	9	8	localIOException4	java.io.IOException
    //   355	184	8	localObject9	Object
    //   115	184	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   270	283	319	finally
    //   288	304	319	finally
    //   307	312	319	finally
    //   270	283	332	java/io/IOException
    //   288	304	332	java/io/IOException
    //   307	312	332	java/io/IOException
    //   180	203	347	finally
    //   206	221	347	finally
    //   221	250	347	finally
    //   253	259	347	finally
    //   259	270	347	finally
    //   312	316	347	finally
    //   180	203	352	java/io/IOException
    //   206	221	352	java/io/IOException
    //   221	250	352	java/io/IOException
    //   253	259	352	java/io/IOException
    //   259	270	352	java/io/IOException
    //   312	316	352	java/io/IOException
    //   69	76	417	finally
    //   76	170	417	finally
    //   173	180	417	finally
    //   69	76	424	java/io/IOException
    //   76	170	424	java/io/IOException
    //   173	180	424	java/io/IOException
    //   59	69	443	finally
    //   59	69	454	java/io/IOException
    //   462	500	530	finally
    //   366	371	579	java/lang/Exception
    //   505	510	583	java/lang/Exception
    //   514	518	583	java/lang/Exception
    //   523	528	583	java/lang/Exception
    //   547	552	586	java/lang/Exception
    //   557	562	586	java/lang/Exception
    //   566	570	586	java/lang/Exception
  }
  
  /* Error */
  public static boolean decompressDownloadPatchZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 35	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc 216
    //   13: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 5
    //   19: aload_0
    //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 17
    //   26: aload 5
    //   28: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 51	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: invokestatic 113	android/os/SystemClock:uptimeMillis	()J
    //   37: lstore_3
    //   38: aconst_null
    //   39: astore 7
    //   41: aconst_null
    //   42: astore 5
    //   44: aconst_null
    //   45: astore 8
    //   47: new 115	java/util/zip/ZipFile
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 116	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   55: astore 6
    //   57: aload 6
    //   59: invokevirtual 120	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   62: astore 10
    //   64: aconst_null
    //   65: astore_0
    //   66: aload 8
    //   68: astore 5
    //   70: aload_0
    //   71: astore 7
    //   73: aload_0
    //   74: astore 8
    //   76: aload 10
    //   78: invokeinterface 125 1 0
    //   83: ifeq +286 -> 369
    //   86: aload_0
    //   87: astore 7
    //   89: aload_0
    //   90: astore 8
    //   92: aload 10
    //   94: invokeinterface 129 1 0
    //   99: checkcast 131	java/util/zip/ZipEntry
    //   102: astore 11
    //   104: aload_0
    //   105: astore 7
    //   107: aload_0
    //   108: astore 8
    //   110: aload 11
    //   112: invokevirtual 134	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   115: ldc 136
    //   117: invokestatic 142	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 9
    //   122: aload_0
    //   123: astore 7
    //   125: aload_0
    //   126: astore 8
    //   128: aload 9
    //   130: ldc 146
    //   132: invokevirtual 150	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   135: ifne -65 -> 70
    //   138: aload_0
    //   139: astore 7
    //   141: aload_0
    //   142: astore 8
    //   144: aload 9
    //   146: ldc 152
    //   148: invokevirtual 150	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   151: ifne -81 -> 70
    //   154: aload_0
    //   155: astore 7
    //   157: aload_0
    //   158: astore 8
    //   160: aload 11
    //   162: invokevirtual 155	java/util/zip/ZipEntry:isDirectory	()Z
    //   165: ifeq +6 -> 171
    //   168: goto -98 -> 70
    //   171: aload_0
    //   172: astore 7
    //   174: aload_0
    //   175: astore 8
    //   177: aload_0
    //   178: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   181: aload_0
    //   182: astore 7
    //   184: aload_0
    //   185: astore 8
    //   187: aload 6
    //   189: aload 11
    //   191: invokevirtual 159	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   194: astore_0
    //   195: aload_0
    //   196: astore 7
    //   198: aload_0
    //   199: astore 8
    //   201: new 55	java/io/File
    //   204: dup
    //   205: aload_1
    //   206: aload 9
    //   208: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: astore 9
    //   213: aload_0
    //   214: astore 7
    //   216: aload_0
    //   217: astore 8
    //   219: aload 9
    //   221: invokevirtual 65	java/io/File:exists	()Z
    //   224: ifne +45 -> 269
    //   227: aload_0
    //   228: astore 7
    //   230: aload_0
    //   231: astore 8
    //   233: aload 9
    //   235: invokevirtual 179	java/io/File:getParentFile	()Ljava/io/File;
    //   238: astore 11
    //   240: aload_0
    //   241: astore 7
    //   243: aload_0
    //   244: astore 8
    //   246: aload 11
    //   248: invokevirtual 65	java/io/File:exists	()Z
    //   251: ifne +30 -> 281
    //   254: aload_0
    //   255: astore 7
    //   257: aload_0
    //   258: astore 8
    //   260: aload 11
    //   262: invokevirtual 182	java/io/File:mkdirs	()Z
    //   265: pop
    //   266: goto +15 -> 281
    //   269: aload_0
    //   270: astore 7
    //   272: aload_0
    //   273: astore 8
    //   275: aload 9
    //   277: invokevirtual 68	java/io/File:delete	()Z
    //   280: pop
    //   281: aload_0
    //   282: astore 7
    //   284: aload_0
    //   285: astore 8
    //   287: aload 5
    //   289: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   292: aload_0
    //   293: astore 7
    //   295: aload_0
    //   296: astore 8
    //   298: new 70	java/io/FileOutputStream
    //   301: dup
    //   302: aload 9
    //   304: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   307: astore 9
    //   309: ldc 13
    //   311: newarray byte
    //   313: astore 5
    //   315: aload_0
    //   316: aload 5
    //   318: invokevirtual 185	java/io/InputStream:read	([B)I
    //   321: istore_2
    //   322: iload_2
    //   323: iconst_m1
    //   324: if_icmpeq +22 -> 346
    //   327: aload 9
    //   329: aload 5
    //   331: iconst_0
    //   332: iload_2
    //   333: invokevirtual 188	java/io/OutputStream:write	([BII)V
    //   336: aload_0
    //   337: aload 5
    //   339: invokevirtual 185	java/io/InputStream:read	([B)I
    //   342: istore_2
    //   343: goto -21 -> 322
    //   346: aload 9
    //   348: astore 5
    //   350: goto -280 -> 70
    //   353: astore 5
    //   355: aload 9
    //   357: astore_1
    //   358: goto +183 -> 541
    //   361: astore 5
    //   363: aload 9
    //   365: astore_1
    //   366: goto +97 -> 463
    //   369: aload 6
    //   371: invokevirtual 193	java/util/zip/ZipFile:close	()V
    //   374: aload 5
    //   376: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   379: aload_0
    //   380: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   383: invokestatic 198	java/lang/System:gc	()V
    //   386: new 35	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   393: astore_0
    //   394: aload_0
    //   395: ldc 200
    //   397: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload_0
    //   402: invokestatic 113	android/os/SystemClock:uptimeMillis	()J
    //   405: lload_3
    //   406: lsub
    //   407: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_0
    //   412: ldc 205
    //   414: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: ldc 17
    //   420: aload_0
    //   421: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 51	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   427: iconst_1
    //   428: ireturn
    //   429: astore_1
    //   430: aload 7
    //   432: astore_0
    //   433: goto +118 -> 551
    //   436: astore 7
    //   438: aload 5
    //   440: astore_1
    //   441: aload 8
    //   443: astore_0
    //   444: aload 7
    //   446: astore 5
    //   448: goto +15 -> 463
    //   451: astore_1
    //   452: aconst_null
    //   453: astore_0
    //   454: goto +97 -> 551
    //   457: astore 5
    //   459: aconst_null
    //   460: astore_0
    //   461: aload_0
    //   462: astore_1
    //   463: goto +23 -> 486
    //   466: astore_1
    //   467: aconst_null
    //   468: astore 6
    //   470: aload 6
    //   472: astore_0
    //   473: goto +78 -> 551
    //   476: astore 5
    //   478: aconst_null
    //   479: astore_0
    //   480: aload_0
    //   481: astore_1
    //   482: aload 7
    //   484: astore 6
    //   486: new 35	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   493: astore 7
    //   495: aload 7
    //   497: ldc 207
    //   499: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 7
    //   505: aload 5
    //   507: invokevirtual 210	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   510: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: ldc 17
    //   516: aload 7
    //   518: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 93	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   524: aload 6
    //   526: invokevirtual 193	java/util/zip/ZipFile:close	()V
    //   529: aload_1
    //   530: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   533: aload_0
    //   534: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   537: iconst_0
    //   538: ireturn
    //   539: astore 5
    //   541: aload_1
    //   542: astore 7
    //   544: aload 5
    //   546: astore_1
    //   547: aload 7
    //   549: astore 5
    //   551: aload 6
    //   553: invokevirtual 193	java/util/zip/ZipFile:close	()V
    //   556: aload 5
    //   558: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   561: aload_0
    //   562: invokestatic 85	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   565: goto +5 -> 570
    //   568: aload_1
    //   569: athrow
    //   570: goto -2 -> 568
    //   573: astore_1
    //   574: goto -200 -> 374
    //   577: astore 5
    //   579: goto -50 -> 529
    //   582: astore 6
    //   584: goto -28 -> 556
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	587	0	paramString1	String
    //   0	587	1	paramString2	String
    //   321	22	2	i	int
    //   37	369	3	l	long
    //   7	342	5	localObject1	Object
    //   353	1	5	localObject2	Object
    //   361	78	5	localIOException1	java.io.IOException
    //   446	1	5	localObject3	Object
    //   457	1	5	localIOException2	java.io.IOException
    //   476	30	5	localIOException3	java.io.IOException
    //   539	6	5	localObject4	Object
    //   549	8	5	localObject5	Object
    //   577	1	5	localIOException4	java.io.IOException
    //   55	497	6	localObject6	Object
    //   582	1	6	localIOException5	java.io.IOException
    //   39	392	7	str1	String
    //   436	47	7	localIOException6	java.io.IOException
    //   493	55	7	localObject7	Object
    //   45	397	8	str2	String
    //   120	244	9	localObject8	Object
    //   62	31	10	localEnumeration	java.util.Enumeration
    //   102	159	11	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   309	322	353	finally
    //   327	343	353	finally
    //   309	322	361	java/io/IOException
    //   327	343	361	java/io/IOException
    //   76	86	429	finally
    //   92	104	429	finally
    //   110	122	429	finally
    //   128	138	429	finally
    //   144	154	429	finally
    //   160	168	429	finally
    //   177	181	429	finally
    //   187	195	429	finally
    //   201	213	429	finally
    //   219	227	429	finally
    //   233	240	429	finally
    //   246	254	429	finally
    //   260	266	429	finally
    //   275	281	429	finally
    //   287	292	429	finally
    //   298	309	429	finally
    //   76	86	436	java/io/IOException
    //   92	104	436	java/io/IOException
    //   110	122	436	java/io/IOException
    //   128	138	436	java/io/IOException
    //   144	154	436	java/io/IOException
    //   160	168	436	java/io/IOException
    //   177	181	436	java/io/IOException
    //   187	195	436	java/io/IOException
    //   201	213	436	java/io/IOException
    //   219	227	436	java/io/IOException
    //   233	240	436	java/io/IOException
    //   246	254	436	java/io/IOException
    //   260	266	436	java/io/IOException
    //   275	281	436	java/io/IOException
    //   287	292	436	java/io/IOException
    //   298	309	436	java/io/IOException
    //   57	64	451	finally
    //   57	64	457	java/io/IOException
    //   47	57	466	finally
    //   47	57	476	java/io/IOException
    //   486	524	539	finally
    //   369	374	573	java/io/IOException
    //   369	374	573	java/lang/NullPointerException
    //   524	529	577	java/io/IOException
    //   524	529	577	java/lang/NullPointerException
    //   551	556	582	java/io/IOException
    //   551	556	582	java/lang/NullPointerException
  }
  
  /* Error */
  private static void extractLzmaToFile(InputStream paramInputStream, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 222	java/io/BufferedInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   8: astore_0
    //   9: new 227	java/io/BufferedOutputStream
    //   12: dup
    //   13: new 70	java/io/FileOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 230	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore 11
    //   26: aload_0
    //   27: astore 7
    //   29: aload 11
    //   31: astore 8
    //   33: iconst_5
    //   34: newarray byte
    //   36: astore 9
    //   38: iconst_0
    //   39: istore_2
    //   40: aload_0
    //   41: astore 7
    //   43: aload 11
    //   45: astore 8
    //   47: aload_0
    //   48: aload 9
    //   50: iconst_0
    //   51: iconst_5
    //   52: invokevirtual 233	java/io/InputStream:read	([BII)I
    //   55: iconst_5
    //   56: if_icmpne +152 -> 208
    //   59: aload_0
    //   60: astore 7
    //   62: aload 11
    //   64: astore 8
    //   66: new 235	com/tencent/luggage/wxa/te/b
    //   69: dup
    //   70: invokespecial 236	com/tencent/luggage/wxa/te/b:<init>	()V
    //   73: astore 10
    //   75: aload_0
    //   76: astore 7
    //   78: aload 11
    //   80: astore 8
    //   82: aload 10
    //   84: aload 9
    //   86: invokevirtual 239	com/tencent/luggage/wxa/te/b:a	([B)Z
    //   89: ifeq +101 -> 190
    //   92: lconst_0
    //   93: lstore 4
    //   95: iload_2
    //   96: bipush 8
    //   98: if_icmpge +36 -> 134
    //   101: aload_0
    //   102: astore 7
    //   104: aload 11
    //   106: astore 8
    //   108: aload_0
    //   109: invokevirtual 242	java/io/InputStream:read	()I
    //   112: istore_3
    //   113: iload_3
    //   114: ifge +248 -> 362
    //   117: aload_0
    //   118: astore 7
    //   120: aload 11
    //   122: astore 8
    //   124: ldc 17
    //   126: ldc 244
    //   128: invokestatic 247	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: goto +231 -> 362
    //   134: aload_0
    //   135: astore 7
    //   137: aload 11
    //   139: astore 8
    //   141: aload 10
    //   143: aload_0
    //   144: aload 11
    //   146: lload 4
    //   148: invokevirtual 250	com/tencent/luggage/wxa/te/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;J)Z
    //   151: istore 6
    //   153: iload 6
    //   155: ifeq +18 -> 173
    //   158: aload 11
    //   160: invokevirtual 253	java/io/OutputStream:flush	()V
    //   163: aload 11
    //   165: invokevirtual 191	java/io/OutputStream:close	()V
    //   168: aload_0
    //   169: invokevirtual 192	java/io/InputStream:close	()V
    //   172: return
    //   173: aload_0
    //   174: astore 7
    //   176: aload 11
    //   178: astore 8
    //   180: new 97	java/io/IOException
    //   183: dup
    //   184: ldc 255
    //   186: invokespecial 256	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   189: athrow
    //   190: aload_0
    //   191: astore 7
    //   193: aload 11
    //   195: astore 8
    //   197: new 97	java/io/IOException
    //   200: dup
    //   201: ldc_w 258
    //   204: invokespecial 256	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   207: athrow
    //   208: aload_0
    //   209: astore 7
    //   211: aload 11
    //   213: astore 8
    //   215: new 97	java/io/IOException
    //   218: dup
    //   219: ldc_w 260
    //   222: invokespecial 256	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   225: athrow
    //   226: astore 9
    //   228: aload_0
    //   229: astore 10
    //   231: aload 11
    //   233: astore_0
    //   234: goto +42 -> 276
    //   237: astore_1
    //   238: aconst_null
    //   239: astore 8
    //   241: goto +75 -> 316
    //   244: astore 9
    //   246: aconst_null
    //   247: astore 7
    //   249: aload_0
    //   250: astore 10
    //   252: aload 7
    //   254: astore_0
    //   255: goto +21 -> 276
    //   258: astore_1
    //   259: aconst_null
    //   260: astore 8
    //   262: aload 8
    //   264: astore_0
    //   265: goto +51 -> 316
    //   268: astore 9
    //   270: aconst_null
    //   271: astore 10
    //   273: aload 10
    //   275: astore_0
    //   276: aload 10
    //   278: astore 7
    //   280: aload_0
    //   281: astore 8
    //   283: aload_1
    //   284: invokevirtual 263	java/io/File:isFile	()Z
    //   287: ifeq +15 -> 302
    //   290: aload 10
    //   292: astore 7
    //   294: aload_0
    //   295: astore 8
    //   297: aload_1
    //   298: invokevirtual 68	java/io/File:delete	()Z
    //   301: pop
    //   302: aload 10
    //   304: astore 7
    //   306: aload_0
    //   307: astore 8
    //   309: aload 9
    //   311: athrow
    //   312: astore_1
    //   313: aload 7
    //   315: astore_0
    //   316: aload 8
    //   318: invokevirtual 253	java/io/OutputStream:flush	()V
    //   321: aload 8
    //   323: invokevirtual 191	java/io/OutputStream:close	()V
    //   326: aload_0
    //   327: invokevirtual 192	java/io/InputStream:close	()V
    //   330: goto +5 -> 335
    //   333: aload_1
    //   334: athrow
    //   335: goto -2 -> 333
    //   338: astore_1
    //   339: goto -176 -> 163
    //   342: astore_1
    //   343: goto -175 -> 168
    //   346: astore_0
    //   347: return
    //   348: astore 7
    //   350: goto -29 -> 321
    //   353: astore 7
    //   355: goto -29 -> 326
    //   358: astore_0
    //   359: goto -29 -> 330
    //   362: lload 4
    //   364: iload_3
    //   365: i2l
    //   366: iload_2
    //   367: bipush 8
    //   369: imul
    //   370: lshl
    //   371: lor
    //   372: lstore 4
    //   374: iload_2
    //   375: iconst_1
    //   376: iadd
    //   377: istore_2
    //   378: goto -283 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	paramInputStream	InputStream
    //   0	381	1	paramFile	java.io.File
    //   39	339	2	i	int
    //   112	253	3	j	int
    //   93	280	4	l	long
    //   151	3	6	bool	boolean
    //   27	287	7	localObject1	Object
    //   348	1	7	localIOException1	java.io.IOException
    //   353	1	7	localIOException2	java.io.IOException
    //   31	291	8	localObject2	Object
    //   36	49	9	arrayOfByte	byte[]
    //   226	1	9	localIOException3	java.io.IOException
    //   244	1	9	localIOException4	java.io.IOException
    //   268	42	9	localIOException5	java.io.IOException
    //   73	230	10	localObject3	Object
    //   24	208	11	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   33	38	226	java/io/IOException
    //   47	59	226	java/io/IOException
    //   66	75	226	java/io/IOException
    //   82	92	226	java/io/IOException
    //   108	113	226	java/io/IOException
    //   124	131	226	java/io/IOException
    //   141	153	226	java/io/IOException
    //   180	190	226	java/io/IOException
    //   197	208	226	java/io/IOException
    //   215	226	226	java/io/IOException
    //   9	26	237	finally
    //   9	26	244	java/io/IOException
    //   0	9	258	finally
    //   0	9	268	java/io/IOException
    //   33	38	312	finally
    //   47	59	312	finally
    //   66	75	312	finally
    //   82	92	312	finally
    //   108	113	312	finally
    //   124	131	312	finally
    //   141	153	312	finally
    //   180	190	312	finally
    //   197	208	312	finally
    //   215	226	312	finally
    //   283	290	312	finally
    //   297	302	312	finally
    //   309	312	312	finally
    //   158	163	338	java/io/IOException
    //   158	163	338	java/lang/NullPointerException
    //   163	168	342	java/io/IOException
    //   163	168	342	java/lang/NullPointerException
    //   168	172	346	java/io/IOException
    //   168	172	346	java/lang/NullPointerException
    //   316	321	348	java/io/IOException
    //   316	321	348	java/lang/NullPointerException
    //   321	326	353	java/io/IOException
    //   321	326	353	java/lang/NullPointerException
    //   326	330	358	java/io/IOException
    //   326	330	358	java/lang/NullPointerException
  }
  
  /* Error */
  public static boolean extractResource(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 35	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc_w 267
    //   14: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 7
    //   20: aload_0
    //   21: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: ldc 17
    //   27: aload 7
    //   29: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 107	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokestatic 113	android/os/SystemClock:uptimeMillis	()J
    //   38: lstore 5
    //   40: aconst_null
    //   41: astore 9
    //   43: aconst_null
    //   44: astore 7
    //   46: new 115	java/util/zip/ZipFile
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 116	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   54: astore 8
    //   56: aload_2
    //   57: arraylength
    //   58: istore 4
    //   60: iconst_0
    //   61: istore_3
    //   62: iload_3
    //   63: iload 4
    //   65: if_icmpge +318 -> 383
    //   68: aload_2
    //   69: iload_3
    //   70: aaload
    //   71: astore 7
    //   73: aload 7
    //   75: invokestatic 271	org/xwalk/core/XWalkDecompressor:isNativeLibrary	(Ljava/lang/String;)Z
    //   78: ifeq +63 -> 141
    //   81: new 35	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   88: astore_0
    //   89: aload_0
    //   90: ldc_w 273
    //   93: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_0
    //   98: getstatic 276	java/io/File:separator	Ljava/lang/String;
    //   101: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_0
    //   106: ldc_w 278
    //   109: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_0
    //   114: getstatic 276	java/io/File:separator	Ljava/lang/String;
    //   117: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_0
    //   122: aload 7
    //   124: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 8
    //   130: aload_0
    //   131: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokevirtual 282	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   137: astore_0
    //   138: goto +63 -> 201
    //   141: aload 7
    //   143: invokestatic 285	org/xwalk/core/XWalkDecompressor:isAsset	(Ljava/lang/String;)Z
    //   146: ifeq +47 -> 193
    //   149: new 35	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   156: astore_0
    //   157: aload_0
    //   158: ldc_w 287
    //   161: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_0
    //   166: getstatic 276	java/io/File:separator	Ljava/lang/String;
    //   169: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_0
    //   174: aload 7
    //   176: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 8
    //   182: aload_0
    //   183: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokevirtual 282	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   189: astore_0
    //   190: goto +11 -> 201
    //   193: aload 8
    //   195: aload 7
    //   197: invokevirtual 282	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   200: astore_0
    //   201: aload_0
    //   202: ifnonnull +85 -> 287
    //   205: aload 7
    //   207: invokestatic 290	org/xwalk/core/XWalkDecompressor:isClassesDex	(Ljava/lang/String;)Z
    //   210: ifeq +38 -> 248
    //   213: new 35	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   220: astore_0
    //   221: aload_0
    //   222: aload 7
    //   224: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_0
    //   229: ldc_w 292
    //   232: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: ldc 17
    //   238: aload_0
    //   239: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 107	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: goto +131 -> 376
    //   248: new 35	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   255: astore_0
    //   256: aload_0
    //   257: aload 7
    //   259: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_0
    //   264: ldc_w 294
    //   267: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: ldc 17
    //   273: aload_0
    //   274: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 93	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload 8
    //   282: invokevirtual 193	java/util/zip/ZipFile:close	()V
    //   285: iconst_0
    //   286: ireturn
    //   287: new 35	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   294: astore 9
    //   296: aload 9
    //   298: ldc_w 296
    //   301: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 9
    //   307: aload 7
    //   309: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 17
    //   315: aload 9
    //   317: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 51	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: new 55	java/io/File
    //   326: dup
    //   327: aload_1
    //   328: aload 7
    //   330: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: astore 9
    //   335: aload 9
    //   337: invokevirtual 263	java/io/File:isFile	()Z
    //   340: ifeq +17 -> 357
    //   343: aload 9
    //   345: invokevirtual 65	java/io/File:exists	()Z
    //   348: ifeq +9 -> 357
    //   351: aload 9
    //   353: invokevirtual 68	java/io/File:delete	()Z
    //   356: pop
    //   357: aload 8
    //   359: aload_0
    //   360: invokevirtual 159	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   363: new 55	java/io/File
    //   366: dup
    //   367: aload_1
    //   368: aload 7
    //   370: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: invokestatic 299	org/xwalk/core/XWalkDecompressor:extractStreamToFile	(Ljava/io/InputStream;Ljava/io/File;)V
    //   376: iload_3
    //   377: iconst_1
    //   378: iadd
    //   379: istore_3
    //   380: goto -318 -> 62
    //   383: aload 8
    //   385: invokevirtual 193	java/util/zip/ZipFile:close	()V
    //   388: invokestatic 198	java/lang/System:gc	()V
    //   391: new 35	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   398: astore_0
    //   399: aload_0
    //   400: ldc_w 301
    //   403: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload_0
    //   408: invokestatic 113	android/os/SystemClock:uptimeMillis	()J
    //   411: lload 5
    //   413: lsub
    //   414: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload_0
    //   419: ldc 205
    //   421: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: ldc 17
    //   427: aload_0
    //   428: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 51	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: iconst_1
    //   435: ireturn
    //   436: astore_0
    //   437: goto +74 -> 511
    //   440: astore_1
    //   441: aload 8
    //   443: astore_0
    //   444: goto +15 -> 459
    //   447: astore_0
    //   448: aload 7
    //   450: astore 8
    //   452: goto +59 -> 511
    //   455: astore_1
    //   456: aload 9
    //   458: astore_0
    //   459: aload_0
    //   460: astore 7
    //   462: new 35	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   469: astore_2
    //   470: aload_0
    //   471: astore 7
    //   473: aload_2
    //   474: ldc_w 303
    //   477: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload_0
    //   482: astore 7
    //   484: aload_2
    //   485: aload_1
    //   486: invokevirtual 210	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   489: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload_0
    //   494: astore 7
    //   496: ldc 17
    //   498: aload_2
    //   499: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 93	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   505: aload_0
    //   506: invokevirtual 193	java/util/zip/ZipFile:close	()V
    //   509: iconst_0
    //   510: ireturn
    //   511: aload 8
    //   513: invokevirtual 193	java/util/zip/ZipFile:close	()V
    //   516: goto +5 -> 521
    //   519: aload_0
    //   520: athrow
    //   521: goto -2 -> 519
    //   524: astore_0
    //   525: iconst_0
    //   526: ireturn
    //   527: astore_0
    //   528: goto -140 -> 388
    //   531: astore_0
    //   532: iconst_0
    //   533: ireturn
    //   534: astore_1
    //   535: goto -19 -> 516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	paramString1	String
    //   0	538	1	paramString2	String
    //   0	538	2	paramArrayOfString	String[]
    //   61	319	3	i	int
    //   58	8	4	j	int
    //   38	374	5	l	long
    //   7	488	7	localObject1	Object
    //   54	458	8	localObject2	Object
    //   41	416	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   56	60	436	finally
    //   73	138	436	finally
    //   141	190	436	finally
    //   193	201	436	finally
    //   205	245	436	finally
    //   248	280	436	finally
    //   287	357	436	finally
    //   357	376	436	finally
    //   56	60	440	java/io/IOException
    //   73	138	440	java/io/IOException
    //   141	190	440	java/io/IOException
    //   193	201	440	java/io/IOException
    //   205	245	440	java/io/IOException
    //   248	280	440	java/io/IOException
    //   287	357	440	java/io/IOException
    //   357	376	440	java/io/IOException
    //   46	56	447	finally
    //   462	470	447	finally
    //   473	481	447	finally
    //   484	493	447	finally
    //   496	505	447	finally
    //   46	56	455	java/io/IOException
    //   280	285	524	java/io/IOException
    //   280	285	524	java/lang/NullPointerException
    //   383	388	527	java/io/IOException
    //   383	388	527	java/lang/NullPointerException
    //   505	509	531	java/io/IOException
    //   505	509	531	java/lang/NullPointerException
    //   511	516	534	java/io/IOException
    //   511	516	534	java/lang/NullPointerException
  }
  
  /* Error */
  private static void extractStreamToFile(InputStream paramInputStream, java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 306	java/io/InputStream:available	()I
    //   4: pop
    //   5: new 70	java/io/FileOutputStream
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: ldc 13
    //   20: newarray byte
    //   22: astore 5
    //   24: aload 4
    //   26: astore_3
    //   27: aload_0
    //   28: aload 5
    //   30: invokevirtual 185	java/io/InputStream:read	([B)I
    //   33: istore_2
    //   34: iload_2
    //   35: iflt +18 -> 53
    //   38: aload 4
    //   40: astore_3
    //   41: aload 4
    //   43: aload 5
    //   45: iconst_0
    //   46: iload_2
    //   47: invokevirtual 188	java/io/OutputStream:write	([BII)V
    //   50: goto -26 -> 24
    //   53: aload 4
    //   55: invokevirtual 253	java/io/OutputStream:flush	()V
    //   58: aload 4
    //   60: invokevirtual 191	java/io/OutputStream:close	()V
    //   63: aload_0
    //   64: invokevirtual 192	java/io/InputStream:close	()V
    //   67: return
    //   68: astore 5
    //   70: goto +14 -> 84
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_3
    //   76: goto +33 -> 109
    //   79: astore 5
    //   81: aconst_null
    //   82: astore 4
    //   84: aload 4
    //   86: astore_3
    //   87: aload_1
    //   88: invokevirtual 263	java/io/File:isFile	()Z
    //   91: ifeq +11 -> 102
    //   94: aload 4
    //   96: astore_3
    //   97: aload_1
    //   98: invokevirtual 68	java/io/File:delete	()Z
    //   101: pop
    //   102: aload 4
    //   104: astore_3
    //   105: aload 5
    //   107: athrow
    //   108: astore_1
    //   109: aload_3
    //   110: invokevirtual 253	java/io/OutputStream:flush	()V
    //   113: aload_3
    //   114: invokevirtual 191	java/io/OutputStream:close	()V
    //   117: aload_0
    //   118: invokevirtual 192	java/io/InputStream:close	()V
    //   121: goto +5 -> 126
    //   124: aload_1
    //   125: athrow
    //   126: goto -2 -> 124
    //   129: astore_1
    //   130: goto -72 -> 58
    //   133: astore_1
    //   134: goto -71 -> 63
    //   137: astore_0
    //   138: return
    //   139: astore 4
    //   141: goto -28 -> 113
    //   144: astore_3
    //   145: goto -28 -> 117
    //   148: astore_0
    //   149: goto -28 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramInputStream	InputStream
    //   0	152	1	paramFile	java.io.File
    //   33	14	2	i	int
    //   17	97	3	localFileOutputStream1	java.io.FileOutputStream
    //   144	1	3	localIOException1	java.io.IOException
    //   13	90	4	localFileOutputStream2	java.io.FileOutputStream
    //   139	1	4	localIOException2	java.io.IOException
    //   22	22	5	arrayOfByte	byte[]
    //   68	1	5	localIOException3	java.io.IOException
    //   79	27	5	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   18	24	68	java/io/IOException
    //   27	34	68	java/io/IOException
    //   41	50	68	java/io/IOException
    //   0	15	73	finally
    //   0	15	79	java/io/IOException
    //   18	24	108	finally
    //   27	34	108	finally
    //   41	50	108	finally
    //   87	94	108	finally
    //   97	102	108	finally
    //   105	108	108	finally
    //   53	58	129	java/io/IOException
    //   53	58	129	java/lang/NullPointerException
    //   58	63	133	java/io/IOException
    //   58	63	133	java/lang/NullPointerException
    //   63	67	137	java/io/IOException
    //   63	67	137	java/lang/NullPointerException
    //   109	113	139	java/io/IOException
    //   109	113	139	java/lang/NullPointerException
    //   113	117	144	java/io/IOException
    //   113	117	144	java/lang/NullPointerException
    //   117	121	148	java/io/IOException
    //   117	121	148	java/lang/NullPointerException
  }
  
  private static boolean isAsset(String paramString)
  {
    return (paramString.endsWith(".dat")) || (paramString.endsWith(".pak")) || (paramString.endsWith(".js"));
  }
  
  private static boolean isClassesDex(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.endsWith("classes.dex");
  }
  
  private static boolean isNativeLibrary(String paramString)
  {
    return paramString.endsWith(".so");
  }
  
  private static InputStream openRawResource(String paramString)
  {
    Context localContext = XWalkEnvironment.getApplicationContext();
    Resources localResources = localContext.getResources();
    return localResources.openRawResource(localResources.getIdentifier(paramString.split("\\.")[0], "raw", localContext.getPackageName()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkDecompressor
 * JD-Core Version:    0.7.0.1
 */