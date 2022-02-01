import android.text.TextUtils;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.RecycleableBufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

public class npo
{
  /* Error */
  public static int a(File paramFile, String paramString, npp paramnpp)
  {
    // Byte code:
    //   0: new 14	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 18	java/util/ArrayList:<init>	()V
    //   7: pop
    //   8: new 20	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore 7
    //   18: aload 7
    //   20: invokevirtual 27	java/io/File:exists	()Z
    //   23: ifne +9 -> 32
    //   26: aload 7
    //   28: invokevirtual 30	java/io/File:mkdir	()Z
    //   31: pop
    //   32: aconst_null
    //   33: astore 7
    //   35: new 32	com/tencent/commonsdk/zip/QZipFile
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 35	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   43: astore 8
    //   45: aload 8
    //   47: invokevirtual 39	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   50: astore 12
    //   52: aload 12
    //   54: invokeinterface 44 1 0
    //   59: ifeq +519 -> 578
    //   62: aload 12
    //   64: invokeinterface 48 1 0
    //   69: checkcast 50	java/util/zip/ZipEntry
    //   72: astore 13
    //   74: aload 13
    //   76: invokevirtual 54	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   79: ldc 56
    //   81: invokevirtual 62	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   84: ifne -32 -> 52
    //   87: sipush 8192
    //   90: newarray byte
    //   92: astore 14
    //   94: aload_2
    //   95: ifnull -43 -> 52
    //   98: aload_2
    //   99: aload 13
    //   101: invokeinterface 67 2 0
    //   106: ifeq -54 -> 52
    //   109: new 20	java/io/File
    //   112: dup
    //   113: new 58	java/lang/String
    //   116: dup
    //   117: new 69	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   124: aload_1
    //   125: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: getstatic 78	java/io/File:separator	Ljava/lang/String;
    //   131: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 13
    //   136: invokevirtual 54	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   139: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: ldc 83
    //   147: invokevirtual 87	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   150: ldc 89
    //   152: invokespecial 92	java/lang/String:<init>	([BLjava/lang/String;)V
    //   155: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore 15
    //   160: aload 13
    //   162: invokevirtual 95	java/util/zip/ZipEntry:isDirectory	()Z
    //   165: ifeq +80 -> 245
    //   168: aload 15
    //   170: invokevirtual 27	java/io/File:exists	()Z
    //   173: ifne -121 -> 52
    //   176: aload 15
    //   178: invokevirtual 30	java/io/File:mkdir	()Z
    //   181: pop
    //   182: goto -130 -> 52
    //   185: astore_2
    //   186: aload 8
    //   188: astore_1
    //   189: ldc 97
    //   191: iconst_1
    //   192: new 69	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   199: ldc 99
    //   201: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_2
    //   205: invokevirtual 102	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   208: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 104
    //   213: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: iconst_m1
    //   227: istore 4
    //   229: iload 4
    //   231: istore_3
    //   232: aload_1
    //   233: ifnull +10 -> 243
    //   236: aload_1
    //   237: invokevirtual 116	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   240: iload 4
    //   242: istore_3
    //   243: iload_3
    //   244: ireturn
    //   245: aconst_null
    //   246: astore 7
    //   248: aconst_null
    //   249: astore 10
    //   251: aload 8
    //   253: aload 13
    //   255: invokevirtual 120	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   258: astore 9
    //   260: new 122	java/util/zip/CheckedInputStream
    //   263: dup
    //   264: aload 9
    //   266: new 124	java/util/zip/CRC32
    //   269: dup
    //   270: invokespecial 125	java/util/zip/CRC32:<init>	()V
    //   273: invokespecial 128	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   276: astore 11
    //   278: new 130	java/io/BufferedOutputStream
    //   281: dup
    //   282: new 132	java/io/FileOutputStream
    //   285: dup
    //   286: aload 15
    //   288: invokespecial 133	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   291: invokespecial 136	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   294: invokestatic 142	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   297: astore 10
    //   299: aload 10
    //   301: astore 7
    //   303: aload 13
    //   305: invokevirtual 146	java/util/zip/ZipEntry:getSize	()J
    //   308: lstore 5
    //   310: lload 5
    //   312: lconst_0
    //   313: lcmp
    //   314: ifle +42 -> 356
    //   317: aload 10
    //   319: astore 7
    //   321: aload 11
    //   323: aload 14
    //   325: iconst_0
    //   326: sipush 8192
    //   329: invokevirtual 150	java/util/zip/CheckedInputStream:read	([BII)I
    //   332: istore_3
    //   333: aload 10
    //   335: astore 7
    //   337: aload 10
    //   339: aload 14
    //   341: iconst_0
    //   342: iload_3
    //   343: invokevirtual 156	java/io/OutputStream:write	([BII)V
    //   346: lload 5
    //   348: iload_3
    //   349: i2l
    //   350: lsub
    //   351: lstore 5
    //   353: goto -43 -> 310
    //   356: aload 10
    //   358: astore 7
    //   360: aload 13
    //   362: invokevirtual 159	java/util/zip/ZipEntry:getCrc	()J
    //   365: aload 11
    //   367: invokevirtual 163	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   370: invokeinterface 168 1 0
    //   375: lcmp
    //   376: ifeq +100 -> 476
    //   379: aload 10
    //   381: astore 7
    //   383: ldc 97
    //   385: iconst_1
    //   386: new 69	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   393: ldc 170
    //   395: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 13
    //   400: invokevirtual 54	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   403: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: ldc 104
    //   408: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_0
    //   412: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: bipush 252
    //   423: istore_3
    //   424: aload 11
    //   426: ifnull +8 -> 434
    //   429: aload 11
    //   431: invokevirtual 171	java/util/zip/CheckedInputStream:close	()V
    //   434: aload 9
    //   436: ifnull +8 -> 444
    //   439: aload 9
    //   441: invokevirtual 174	java/io/InputStream:close	()V
    //   444: aload 10
    //   446: ifnull +13 -> 459
    //   449: aload 10
    //   451: invokevirtual 177	java/io/OutputStream:flush	()V
    //   454: aload 10
    //   456: invokevirtual 178	java/io/OutputStream:close	()V
    //   459: aload 8
    //   461: ifnull -218 -> 243
    //   464: aload 8
    //   466: invokevirtual 116	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   469: bipush 252
    //   471: ireturn
    //   472: astore_0
    //   473: bipush 252
    //   475: ireturn
    //   476: aload 11
    //   478: ifnull +8 -> 486
    //   481: aload 11
    //   483: invokevirtual 171	java/util/zip/CheckedInputStream:close	()V
    //   486: aload 9
    //   488: ifnull +8 -> 496
    //   491: aload 9
    //   493: invokevirtual 174	java/io/InputStream:close	()V
    //   496: aload 10
    //   498: ifnull -446 -> 52
    //   501: aload 10
    //   503: invokevirtual 177	java/io/OutputStream:flush	()V
    //   506: aload 10
    //   508: invokevirtual 178	java/io/OutputStream:close	()V
    //   511: goto -459 -> 52
    //   514: astore 7
    //   516: goto -464 -> 52
    //   519: astore_1
    //   520: aconst_null
    //   521: astore 7
    //   523: aconst_null
    //   524: astore_2
    //   525: aload 10
    //   527: astore 9
    //   529: aload_2
    //   530: ifnull +7 -> 537
    //   533: aload_2
    //   534: invokevirtual 171	java/util/zip/CheckedInputStream:close	()V
    //   537: aload 7
    //   539: ifnull +8 -> 547
    //   542: aload 7
    //   544: invokevirtual 174	java/io/InputStream:close	()V
    //   547: aload 9
    //   549: ifnull +13 -> 562
    //   552: aload 9
    //   554: invokevirtual 177	java/io/OutputStream:flush	()V
    //   557: aload 9
    //   559: invokevirtual 178	java/io/OutputStream:close	()V
    //   562: aload_1
    //   563: athrow
    //   564: astore_0
    //   565: aload 8
    //   567: astore_1
    //   568: aload_1
    //   569: ifnull +7 -> 576
    //   572: aload_1
    //   573: invokevirtual 116	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   576: aload_0
    //   577: athrow
    //   578: aload 8
    //   580: ifnull +8 -> 588
    //   583: aload 8
    //   585: invokevirtual 116	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   588: iconst_0
    //   589: ireturn
    //   590: astore_1
    //   591: goto -157 -> 434
    //   594: astore_1
    //   595: goto -151 -> 444
    //   598: astore 7
    //   600: goto -114 -> 486
    //   603: astore 7
    //   605: goto -109 -> 496
    //   608: astore_2
    //   609: goto -72 -> 537
    //   612: astore_2
    //   613: goto -66 -> 547
    //   616: astore_0
    //   617: goto -29 -> 588
    //   620: astore_0
    //   621: iconst_m1
    //   622: ireturn
    //   623: astore_1
    //   624: goto -48 -> 576
    //   627: astore_0
    //   628: aconst_null
    //   629: astore_1
    //   630: goto -62 -> 568
    //   633: astore_0
    //   634: goto -66 -> 568
    //   637: astore_2
    //   638: aload 7
    //   640: astore_1
    //   641: goto -452 -> 189
    //   644: astore_2
    //   645: goto -83 -> 562
    //   648: astore_1
    //   649: aconst_null
    //   650: astore_2
    //   651: aload 9
    //   653: astore 7
    //   655: aload 10
    //   657: astore 9
    //   659: goto -130 -> 529
    //   662: astore_1
    //   663: aload 9
    //   665: astore 10
    //   667: aload 7
    //   669: astore 9
    //   671: aload 11
    //   673: astore_2
    //   674: aload 10
    //   676: astore 7
    //   678: goto -149 -> 529
    //   681: astore_0
    //   682: goto -223 -> 459
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	paramFile	File
    //   0	685	1	paramString	String
    //   0	685	2	paramnpp	npp
    //   231	193	3	i	int
    //   227	14	4	j	int
    //   308	44	5	l	long
    //   16	366	7	localObject1	Object
    //   514	1	7	localIOException1	IOException
    //   521	22	7	localObject2	Object
    //   598	1	7	localIOException2	IOException
    //   603	36	7	localIOException3	IOException
    //   653	24	7	localObject3	Object
    //   43	541	8	localQZipFile	QZipFile
    //   258	412	9	localObject4	Object
    //   249	426	10	localObject5	Object
    //   276	396	11	localCheckedInputStream	java.util.zip.CheckedInputStream
    //   50	13	12	localEnumeration	Enumeration
    //   72	327	13	localZipEntry	ZipEntry
    //   92	248	14	arrayOfByte	byte[]
    //   158	129	15	localFile	File
    // Exception table:
    //   from	to	target	type
    //   45	52	185	java/lang/Throwable
    //   52	94	185	java/lang/Throwable
    //   98	182	185	java/lang/Throwable
    //   429	434	185	java/lang/Throwable
    //   439	444	185	java/lang/Throwable
    //   449	459	185	java/lang/Throwable
    //   481	486	185	java/lang/Throwable
    //   491	496	185	java/lang/Throwable
    //   501	511	185	java/lang/Throwable
    //   533	537	185	java/lang/Throwable
    //   542	547	185	java/lang/Throwable
    //   552	562	185	java/lang/Throwable
    //   562	564	185	java/lang/Throwable
    //   464	469	472	java/lang/Exception
    //   501	511	514	java/io/IOException
    //   251	260	519	finally
    //   45	52	564	finally
    //   52	94	564	finally
    //   98	182	564	finally
    //   429	434	564	finally
    //   439	444	564	finally
    //   449	459	564	finally
    //   481	486	564	finally
    //   491	496	564	finally
    //   501	511	564	finally
    //   533	537	564	finally
    //   542	547	564	finally
    //   552	562	564	finally
    //   562	564	564	finally
    //   429	434	590	java/io/IOException
    //   439	444	594	java/io/IOException
    //   481	486	598	java/io/IOException
    //   491	496	603	java/io/IOException
    //   533	537	608	java/io/IOException
    //   542	547	612	java/io/IOException
    //   583	588	616	java/lang/Exception
    //   236	240	620	java/lang/Exception
    //   572	576	623	java/lang/Exception
    //   35	45	627	finally
    //   189	226	633	finally
    //   35	45	637	java/lang/Throwable
    //   552	562	644	java/io/IOException
    //   260	278	648	finally
    //   278	299	662	finally
    //   303	310	662	finally
    //   321	333	662	finally
    //   337	346	662	finally
    //   360	379	662	finally
    //   383	421	662	finally
    //   449	459	681	java/io/IOException
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 189	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +39 -> 43
    //   7: ldc 97
    //   9: iconst_4
    //   10: new 69	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   17: ldc 191
    //   19: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: invokevirtual 192	java/lang/String:toString	()Ljava/lang/String;
    //   26: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 194
    //   31: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: bipush 9
    //   42: ireturn
    //   43: invokestatic 197	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   46: ifeq +40 -> 86
    //   49: ldc 97
    //   51: iconst_4
    //   52: new 69	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   59: ldc 191
    //   61: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 192	java/lang/String:toString	()Ljava/lang/String;
    //   68: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 199
    //   73: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: new 20	java/io/File
    //   89: dup
    //   90: aload_1
    //   91: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore 6
    //   96: aload 6
    //   98: invokevirtual 27	java/io/File:exists	()Z
    //   101: ifne +9 -> 110
    //   104: aload 6
    //   106: invokevirtual 205	java/io/File:mkdirs	()Z
    //   109: pop
    //   110: new 20	java/io/File
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore_0
    //   119: new 32	com/tencent/commonsdk/zip/QZipFile
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 35	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   127: astore 9
    //   129: iconst_0
    //   130: istore_3
    //   131: sipush 8192
    //   134: newarray byte
    //   136: astore 8
    //   138: new 69	java/lang/StringBuilder
    //   141: dup
    //   142: sipush 512
    //   145: invokespecial 208	java/lang/StringBuilder:<init>	(I)V
    //   148: astore 10
    //   150: aload 9
    //   152: invokevirtual 39	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   155: astore 11
    //   157: iload_3
    //   158: istore_2
    //   159: aload 11
    //   161: invokeinterface 44 1 0
    //   166: ifeq +607 -> 773
    //   169: aload 11
    //   171: invokeinterface 48 1 0
    //   176: checkcast 50	java/util/zip/ZipEntry
    //   179: astore 12
    //   181: aload 12
    //   183: invokevirtual 54	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   186: astore_0
    //   187: aload_0
    //   188: ldc 56
    //   190: invokevirtual 62	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   193: ifne -36 -> 157
    //   196: aload 10
    //   198: iconst_0
    //   199: aload 10
    //   201: invokevirtual 212	java/lang/StringBuilder:length	()I
    //   204: invokevirtual 216	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 10
    //   210: aload_1
    //   211: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: getstatic 78	java/io/File:separator	Ljava/lang/String;
    //   217: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 12
    //   227: invokevirtual 95	java/util/zip/ZipEntry:isDirectory	()Z
    //   230: ifeq +116 -> 346
    //   233: new 20	java/io/File
    //   236: dup
    //   237: aload 10
    //   239: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 27	java/io/File:exists	()Z
    //   250: ifne -93 -> 157
    //   253: aload_0
    //   254: invokevirtual 205	java/io/File:mkdirs	()Z
    //   257: pop
    //   258: goto -101 -> 157
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual 219	java/io/FileNotFoundException:printStackTrace	()V
    //   266: iconst_5
    //   267: istore_2
    //   268: aload 9
    //   270: invokevirtual 116	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   273: iload_2
    //   274: ireturn
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   280: bipush 8
    //   282: ireturn
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 221	java/util/zip/ZipException:printStackTrace	()V
    //   288: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +11 -> 302
    //   294: ldc 97
    //   296: iconst_2
    //   297: ldc 226
    //   299: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: iconst_1
    //   303: ireturn
    //   304: astore_0
    //   305: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +11 -> 319
    //   311: ldc 97
    //   313: iconst_2
    //   314: ldc 228
    //   316: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload_0
    //   320: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   323: iconst_2
    //   324: ireturn
    //   325: astore_0
    //   326: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +11 -> 340
    //   332: ldc 97
    //   334: iconst_2
    //   335: ldc 230
    //   337: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload_0
    //   341: invokevirtual 231	java/lang/Exception:printStackTrace	()V
    //   344: iconst_3
    //   345: ireturn
    //   346: aconst_null
    //   347: astore 7
    //   349: aload 9
    //   351: aload 12
    //   353: invokevirtual 120	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   356: astore_0
    //   357: new 122	java/util/zip/CheckedInputStream
    //   360: dup
    //   361: aload_0
    //   362: new 124	java/util/zip/CRC32
    //   365: dup
    //   366: invokespecial 125	java/util/zip/CRC32:<init>	()V
    //   369: invokespecial 128	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   372: astore 6
    //   374: new 20	java/io/File
    //   377: dup
    //   378: new 58	java/lang/String
    //   381: dup
    //   382: aload 10
    //   384: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: ldc 83
    //   389: invokevirtual 87	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   392: ldc 89
    //   394: invokespecial 92	java/lang/String:<init>	([BLjava/lang/String;)V
    //   397: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   400: astore 7
    //   402: aload 7
    //   404: invokevirtual 27	java/io/File:exists	()Z
    //   407: ifne +24 -> 431
    //   410: aload 7
    //   412: invokevirtual 235	java/io/File:getParentFile	()Ljava/io/File;
    //   415: astore 13
    //   417: aload 13
    //   419: invokevirtual 27	java/io/File:exists	()Z
    //   422: ifne +9 -> 431
    //   425: aload 13
    //   427: invokevirtual 205	java/io/File:mkdirs	()Z
    //   430: pop
    //   431: new 130	java/io/BufferedOutputStream
    //   434: dup
    //   435: new 132	java/io/FileOutputStream
    //   438: dup
    //   439: aload 7
    //   441: invokespecial 133	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   444: invokespecial 136	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   447: invokestatic 142	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   450: astore 7
    //   452: aload 12
    //   454: invokevirtual 146	java/util/zip/ZipEntry:getSize	()J
    //   457: lstore 4
    //   459: lload 4
    //   461: lconst_0
    //   462: lcmp
    //   463: ifle +34 -> 497
    //   466: aload 6
    //   468: aload 8
    //   470: iconst_0
    //   471: sipush 8192
    //   474: invokevirtual 150	java/util/zip/CheckedInputStream:read	([BII)I
    //   477: istore_2
    //   478: aload 7
    //   480: aload 8
    //   482: iconst_0
    //   483: iload_2
    //   484: invokevirtual 156	java/io/OutputStream:write	([BII)V
    //   487: lload 4
    //   489: iload_2
    //   490: i2l
    //   491: lsub
    //   492: lstore 4
    //   494: goto -35 -> 459
    //   497: aload 12
    //   499: invokevirtual 159	java/util/zip/ZipEntry:getCrc	()J
    //   502: aload 6
    //   504: invokevirtual 163	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   507: invokeinterface 168 1 0
    //   512: lcmp
    //   513: ifeq +84 -> 597
    //   516: iconst_4
    //   517: istore_2
    //   518: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq +32 -> 553
    //   524: ldc 97
    //   526: iconst_2
    //   527: new 69	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   534: ldc 237
    //   536: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload 12
    //   541: invokevirtual 159	java/util/zip/ZipEntry:getCrc	()J
    //   544: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   547: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   553: aload 6
    //   555: ifnull +8 -> 563
    //   558: aload 6
    //   560: invokevirtual 171	java/util/zip/CheckedInputStream:close	()V
    //   563: aload_0
    //   564: ifnull +7 -> 571
    //   567: aload_0
    //   568: invokevirtual 174	java/io/InputStream:close	()V
    //   571: aload 7
    //   573: ifnull +200 -> 773
    //   576: aload 7
    //   578: invokevirtual 177	java/io/OutputStream:flush	()V
    //   581: aload 7
    //   583: invokevirtual 178	java/io/OutputStream:close	()V
    //   586: iconst_4
    //   587: istore_2
    //   588: goto -320 -> 268
    //   591: astore_0
    //   592: iconst_4
    //   593: istore_2
    //   594: goto -326 -> 268
    //   597: aload 6
    //   599: ifnull +8 -> 607
    //   602: aload 6
    //   604: invokevirtual 171	java/util/zip/CheckedInputStream:close	()V
    //   607: aload_0
    //   608: ifnull +7 -> 615
    //   611: aload_0
    //   612: invokevirtual 174	java/io/InputStream:close	()V
    //   615: aload 7
    //   617: ifnull -460 -> 157
    //   620: aload 7
    //   622: invokevirtual 177	java/io/OutputStream:flush	()V
    //   625: aload 7
    //   627: invokevirtual 178	java/io/OutputStream:close	()V
    //   630: goto -473 -> 157
    //   633: astore_0
    //   634: goto -477 -> 157
    //   637: astore_0
    //   638: aconst_null
    //   639: astore_1
    //   640: aconst_null
    //   641: astore 6
    //   643: aload 6
    //   645: ifnull +8 -> 653
    //   648: aload 6
    //   650: invokevirtual 171	java/util/zip/CheckedInputStream:close	()V
    //   653: aload 7
    //   655: ifnull +8 -> 663
    //   658: aload 7
    //   660: invokevirtual 174	java/io/InputStream:close	()V
    //   663: aload_1
    //   664: ifnull +11 -> 675
    //   667: aload_1
    //   668: invokevirtual 177	java/io/OutputStream:flush	()V
    //   671: aload_1
    //   672: invokevirtual 178	java/io/OutputStream:close	()V
    //   675: aload_0
    //   676: athrow
    //   677: astore_0
    //   678: aload_0
    //   679: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   682: bipush 6
    //   684: istore_2
    //   685: goto -417 -> 268
    //   688: astore_0
    //   689: aload_0
    //   690: invokevirtual 231	java/lang/Exception:printStackTrace	()V
    //   693: bipush 7
    //   695: istore_2
    //   696: goto -428 -> 268
    //   699: astore_1
    //   700: goto -137 -> 563
    //   703: astore_0
    //   704: goto -133 -> 571
    //   707: astore 6
    //   709: goto -102 -> 607
    //   712: astore_0
    //   713: goto -98 -> 615
    //   716: astore 6
    //   718: goto -65 -> 653
    //   721: astore 6
    //   723: goto -60 -> 663
    //   726: astore_1
    //   727: goto -52 -> 675
    //   730: astore 8
    //   732: aconst_null
    //   733: astore_1
    //   734: aload_0
    //   735: astore 7
    //   737: aconst_null
    //   738: astore 6
    //   740: aload 8
    //   742: astore_0
    //   743: goto -100 -> 643
    //   746: astore 8
    //   748: aconst_null
    //   749: astore_1
    //   750: aload_0
    //   751: astore 7
    //   753: aload 8
    //   755: astore_0
    //   756: goto -113 -> 643
    //   759: astore 8
    //   761: aload 7
    //   763: astore_1
    //   764: aload_0
    //   765: astore 7
    //   767: aload 8
    //   769: astore_0
    //   770: goto -127 -> 643
    //   773: goto -505 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	776	0	paramString1	String
    //   0	776	1	paramString2	String
    //   158	538	2	i	int
    //   130	28	3	j	int
    //   457	36	4	l	long
    //   94	555	6	localObject1	Object
    //   707	1	6	localIOException1	IOException
    //   716	1	6	localIOException2	IOException
    //   721	1	6	localIOException3	IOException
    //   738	1	6	localObject2	Object
    //   347	419	7	localObject3	Object
    //   136	345	8	arrayOfByte	byte[]
    //   730	11	8	localObject4	Object
    //   746	8	8	localObject5	Object
    //   759	9	8	localObject6	Object
    //   127	223	9	localQZipFile	QZipFile
    //   148	235	10	localStringBuilder	StringBuilder
    //   155	15	11	localEnumeration	Enumeration
    //   179	361	12	localZipEntry	ZipEntry
    //   415	11	13	localFile	File
    // Exception table:
    //   from	to	target	type
    //   131	157	261	java/io/FileNotFoundException
    //   159	258	261	java/io/FileNotFoundException
    //   558	563	261	java/io/FileNotFoundException
    //   567	571	261	java/io/FileNotFoundException
    //   576	586	261	java/io/FileNotFoundException
    //   602	607	261	java/io/FileNotFoundException
    //   611	615	261	java/io/FileNotFoundException
    //   620	630	261	java/io/FileNotFoundException
    //   648	653	261	java/io/FileNotFoundException
    //   658	663	261	java/io/FileNotFoundException
    //   667	675	261	java/io/FileNotFoundException
    //   675	677	261	java/io/FileNotFoundException
    //   268	273	275	java/io/IOException
    //   119	129	283	java/util/zip/ZipException
    //   119	129	304	java/io/IOException
    //   119	129	325	java/lang/Exception
    //   576	586	591	java/io/IOException
    //   620	630	633	java/io/IOException
    //   349	357	637	finally
    //   131	157	677	java/io/IOException
    //   159	258	677	java/io/IOException
    //   675	677	677	java/io/IOException
    //   131	157	688	java/lang/Exception
    //   159	258	688	java/lang/Exception
    //   558	563	688	java/lang/Exception
    //   567	571	688	java/lang/Exception
    //   576	586	688	java/lang/Exception
    //   602	607	688	java/lang/Exception
    //   611	615	688	java/lang/Exception
    //   620	630	688	java/lang/Exception
    //   648	653	688	java/lang/Exception
    //   658	663	688	java/lang/Exception
    //   667	675	688	java/lang/Exception
    //   675	677	688	java/lang/Exception
    //   558	563	699	java/io/IOException
    //   567	571	703	java/io/IOException
    //   602	607	707	java/io/IOException
    //   611	615	712	java/io/IOException
    //   648	653	716	java/io/IOException
    //   658	663	721	java/io/IOException
    //   667	675	726	java/io/IOException
    //   357	374	730	finally
    //   374	431	746	finally
    //   431	452	746	finally
    //   452	459	759	finally
    //   466	487	759	finally
    //   497	516	759	finally
    //   518	553	759	finally
  }
  
  public static long a(String paramString)
  {
    long l2;
    if (TextUtils.isEmpty(paramString)) {
      l2 = -1L;
    }
    for (;;)
    {
      return l2;
      try
      {
        paramString = new QZipFile(paramString).entries();
        long l1 = 0L;
        l2 = l1;
        if (!paramString.hasMoreElements()) {
          continue;
        }
        ZipEntry localZipEntry = (ZipEntry)paramString.nextElement();
        if (!localZipEntry.isDirectory())
        {
          l2 = localZipEntry.getSize();
          l1 = l2 + l1;
        }
        for (;;)
        {
          break;
        }
      }
      catch (Exception paramString)
      {
        return -1L;
      }
    }
  }
  
  public static String a(ZipEntry paramZipEntry)
  {
    return new String(paramZipEntry.getName().getBytes("GB2312"), "8859_1");
  }
  
  public static ArrayList<String> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = a(paramFile);
    while (paramFile.hasMoreElements()) {
      localArrayList.add(new String(a((ZipEntry)paramFile.nextElement()).getBytes("GB2312"), "8859_1"));
    }
    return localArrayList;
  }
  
  public static Enumeration<?> a(File paramFile)
  {
    return new QZipFile(paramFile).entries();
  }
  
  private static void a(QZipInputStream paramQZipInputStream, File paramFile)
  {
    localObject = null;
    File localFile = null;
    byte[] arrayOfByte = new byte[8192];
    try
    {
      paramFile = RecycleableBufferedOutputStream.obtain(new FileOutputStream(paramFile));
      for (;;)
      {
        localFile = paramFile;
        localObject = paramFile;
        int i = paramQZipInputStream.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          break;
        }
        localFile = paramFile;
        localObject = paramFile;
        paramFile.write(arrayOfByte, 0, i);
      }
      try
      {
        ((OutputStream)localObject).close();
        throw paramQZipInputStream;
      }
      catch (IOException paramFile)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramFile);
          }
        }
      }
    }
    catch (Exception paramQZipInputStream)
    {
      localObject = localFile;
      if (QLog.isColorLevel())
      {
        localObject = localFile;
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramQZipInputStream);
      }
      if (localFile != null) {}
      try
      {
        localFile.close();
        do
        {
          do
          {
            return;
          } while (paramFile == null);
          try
          {
            paramFile.close();
            return;
          }
          catch (IOException paramQZipInputStream) {}
        } while (!QLog.isColorLevel());
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramQZipInputStream);
        return;
      }
      catch (IOException paramQZipInputStream)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramQZipInputStream);
        return;
      }
    }
    finally
    {
      if (localObject == null) {}
    }
  }
  
  /* Error */
  public static void a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 32	com/tencent/commonsdk/zip/QZipFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 35	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 39	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   17: astore 6
    //   19: sipush 8192
    //   22: newarray byte
    //   24: astore 7
    //   26: aload 6
    //   28: invokeinterface 44 1 0
    //   33: ifeq +304 -> 337
    //   36: aload 6
    //   38: invokeinterface 48 1 0
    //   43: checkcast 50	java/util/zip/ZipEntry
    //   46: astore 4
    //   48: aload 4
    //   50: invokevirtual 54	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   53: ldc 56
    //   55: invokevirtual 62	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifne -32 -> 26
    //   61: aload 4
    //   63: invokevirtual 95	java/util/zip/ZipEntry:isDirectory	()Z
    //   66: ifeq +123 -> 189
    //   69: invokestatic 197	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   72: ifeq +33 -> 105
    //   75: ldc 97
    //   77: iconst_4
    //   78: new 69	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 272
    //   88: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 4
    //   93: invokevirtual 54	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   96: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: new 58	java/lang/String
    //   108: dup
    //   109: new 69	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   116: aload_1
    //   117: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 4
    //   122: invokevirtual 54	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   125: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: ldc 83
    //   133: invokevirtual 87	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   136: ldc 89
    //   138: invokespecial 92	java/lang/String:<init>	([BLjava/lang/String;)V
    //   141: astore_0
    //   142: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +29 -> 174
    //   148: ldc 97
    //   150: iconst_2
    //   151: new 69	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 274
    //   161: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: new 20	java/io/File
    //   177: dup
    //   178: aload_0
    //   179: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   182: invokevirtual 30	java/io/File:mkdir	()Z
    //   185: pop
    //   186: goto -160 -> 26
    //   189: new 20	java/io/File
    //   192: dup
    //   193: new 69	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   200: aload_1
    //   201: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 4
    //   206: invokevirtual 54	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   209: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   218: astore_0
    //   219: aload_0
    //   220: invokevirtual 235	java/io/File:getParentFile	()Ljava/io/File;
    //   223: invokevirtual 205	java/io/File:mkdirs	()Z
    //   226: pop
    //   227: new 132	java/io/FileOutputStream
    //   230: dup
    //   231: aload_0
    //   232: invokespecial 133	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   235: invokestatic 142	cooperation/qzone/util/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcooperation/qzone/util/RecycleableBufferedOutputStream;
    //   238: astore_0
    //   239: aload 5
    //   241: aload 4
    //   243: invokevirtual 120	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   246: astore 4
    //   248: aload 4
    //   250: aload 7
    //   252: iconst_0
    //   253: sipush 8192
    //   256: invokevirtual 275	java/io/InputStream:read	([BII)I
    //   259: istore_2
    //   260: iload_2
    //   261: iconst_m1
    //   262: if_icmpeq +46 -> 308
    //   265: aload_0
    //   266: aload 7
    //   268: iconst_0
    //   269: iload_2
    //   270: invokevirtual 156	java/io/OutputStream:write	([BII)V
    //   273: goto -25 -> 248
    //   276: astore 5
    //   278: aload_0
    //   279: astore_3
    //   280: aload 4
    //   282: astore_1
    //   283: aload 5
    //   285: astore_0
    //   286: aload_1
    //   287: ifnull +7 -> 294
    //   290: aload_1
    //   291: invokevirtual 174	java/io/InputStream:close	()V
    //   294: aload_3
    //   295: ifnull +11 -> 306
    //   298: aload_3
    //   299: invokevirtual 177	java/io/OutputStream:flush	()V
    //   302: aload_3
    //   303: invokevirtual 178	java/io/OutputStream:close	()V
    //   306: aload_0
    //   307: athrow
    //   308: aload 4
    //   310: ifnull +8 -> 318
    //   313: aload 4
    //   315: invokevirtual 174	java/io/InputStream:close	()V
    //   318: aload_0
    //   319: ifnull -293 -> 26
    //   322: aload_0
    //   323: invokevirtual 177	java/io/OutputStream:flush	()V
    //   326: aload_0
    //   327: invokevirtual 178	java/io/OutputStream:close	()V
    //   330: goto -304 -> 26
    //   333: astore_0
    //   334: goto -308 -> 26
    //   337: aload 5
    //   339: invokevirtual 116	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   342: return
    //   343: astore 4
    //   345: goto -27 -> 318
    //   348: astore_1
    //   349: goto -55 -> 294
    //   352: astore_1
    //   353: goto -47 -> 306
    //   356: astore_0
    //   357: aconst_null
    //   358: astore_1
    //   359: goto -73 -> 286
    //   362: astore 4
    //   364: aconst_null
    //   365: astore_1
    //   366: aload_0
    //   367: astore_3
    //   368: aload 4
    //   370: astore_0
    //   371: goto -85 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramFile	File
    //   0	374	1	paramString	String
    //   259	11	2	i	int
    //   1	367	3	localFile	File
    //   46	268	4	localObject1	Object
    //   343	1	4	localIOException	IOException
    //   362	7	4	localObject2	Object
    //   10	230	5	localQZipFile	QZipFile
    //   276	62	5	localObject3	Object
    //   17	20	6	localEnumeration	Enumeration
    //   24	243	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   248	260	276	finally
    //   265	273	276	finally
    //   322	330	333	java/io/IOException
    //   313	318	343	java/io/IOException
    //   290	294	348	java/io/IOException
    //   298	306	352	java/io/IOException
    //   227	239	356	finally
    //   239	248	362	finally
  }
  
  public static int b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ZipUtils", 2, "unZipFile2 参数错误：zipFilePath:" + paramString1 + ",folderPath:" + paramString2);
      }
      return -1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ZipUtils", 4, "unZipFile2 new file:" + paramString1 + ", folderPath:" + paramString2);
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ZipUtils", 4, "unZipFile2  zipFilePath doesn't exist");
      }
      return -2;
    }
    Object localObject1 = new File(paramString2);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    int i;
    try
    {
      paramString1 = new QZipInputStream(new BufferedInputStream(new FileInputStream(paramString1)));
    }
    catch (Throwable paramString1)
    {
      try
      {
        localObject1 = new StringBuilder(512);
        for (;;)
        {
          localObject2 = paramString1.getNextEntry();
          if (localObject2 == null) {
            break label457;
          }
          ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          localObject3 = ((ZipEntry)localObject2).getName();
          if (QLog.isDevelopLevel()) {
            QLog.d("ZipUtils", 4, "unZipFile2 folderPath:" + paramString2 + ",ZipEntry name: " + (String)localObject3);
          }
          ((StringBuilder)localObject1).append(paramString2).append(File.separator).append((String)localObject3);
          if (!((ZipEntry)localObject2).isDirectory()) {
            break;
          }
          localObject2 = new File(((StringBuilder)localObject1).toString());
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
        }
      }
      catch (FileNotFoundException paramString2)
      {
        for (;;)
        {
          Object localObject3;
          i = -3;
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
          }
          if (paramString1 == null) {
            break label549;
          }
          try
          {
            paramString1.close();
            return -3;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -3;
          }
          paramString1 = paramString1;
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, " unZipFile2  解压错误：", paramString1);
          }
          paramString1 = null;
          continue;
          Object localObject2 = new File(((StringBuilder)localObject1).toString());
          if (!((File)localObject2).exists())
          {
            localObject3 = ((File)localObject2).getParentFile();
            if (!((File)localObject3).exists()) {
              ((File)localObject3).mkdirs();
            }
          }
          a(paramString1, (File)localObject2);
        }
      }
      catch (IOException paramString2)
      {
        i = -4;
        if (QLog.isColorLevel()) {
          QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
        }
        if (paramString1 != null)
        {
          try
          {
            paramString1.close();
            return -4;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -4;
          }
          if (paramString1 == null) {
            break label551;
          }
          try
          {
            paramString1.close();
            return 0;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return 0;
          }
        }
      }
      catch (Exception paramString2)
      {
        label457:
        i = -5;
        if (QLog.isColorLevel()) {
          QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
        }
        if (paramString1 != null) {
          try
          {
            paramString1.close();
            return -5;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -5;
          }
        }
      }
      finally
      {
        if (paramString1 != null) {}
        try
        {
          paramString1.close();
          throw paramString2;
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
    }
    label549:
    return i;
    label551:
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     npo
 * JD-Core Version:    0.7.0.1
 */