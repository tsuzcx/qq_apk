package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtil
{
  private static final String TAG = "ZipUtil";
  
  public static long getUncompressedFileSize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1L;
    }
    try
    {
      paramString = new ZipFile(paramString).entries();
      long l1 = 0L;
      while (paramString.hasMoreElements())
      {
        ZipEntry localZipEntry = (ZipEntry)paramString.nextElement();
        if (!localZipEntry.isDirectory())
        {
          long l2 = localZipEntry.getSize();
          l1 += l2;
        }
      }
      return l1;
    }
    catch (Exception paramString) {}
    return -1L;
  }
  
  /* Error */
  public static int unZipFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 63	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc 66
    //   13: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 7
    //   19: aload_0
    //   20: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 7
    //   26: ldc 72
    //   28: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 7
    //   34: aload_1
    //   35: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 8
    //   41: aload 7
    //   43: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 82	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +46 -> 99
    //   56: new 63	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: ldc 84
    //   67: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_1
    //   72: aload_0
    //   73: invokevirtual 87	java/lang/String:toString	()Ljava/lang/String;
    //   76: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_1
    //   81: ldc 89
    //   83: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: ldc 91
    //   89: aload_1
    //   90: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 82	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: bipush 9
    //   98: ireturn
    //   99: new 93	java/io/File
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: astore 7
    //   109: aload 7
    //   111: invokevirtual 97	java/io/File:exists	()Z
    //   114: ifne +9 -> 123
    //   117: aload 7
    //   119: invokevirtual 100	java/io/File:mkdirs	()Z
    //   122: pop
    //   123: new 93	java/io/File
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: astore_0
    //   132: new 102	com/tencent/qqmini/sdk/core/utils/QZipFile
    //   135: dup
    //   136: aload_0
    //   137: invokespecial 105	com/tencent/qqmini/sdk/core/utils/QZipFile:<init>	(Ljava/io/File;)V
    //   140: astore 11
    //   142: sipush 8192
    //   145: newarray byte
    //   147: astore 12
    //   149: new 63	java/lang/StringBuilder
    //   152: dup
    //   153: sipush 512
    //   156: invokespecial 108	java/lang/StringBuilder:<init>	(I)V
    //   159: astore 13
    //   161: aload 11
    //   163: invokevirtual 109	com/tencent/qqmini/sdk/core/utils/QZipFile:entries	()Ljava/util/Enumeration;
    //   166: astore 14
    //   168: aload 14
    //   170: invokeinterface 40 1 0
    //   175: istore 4
    //   177: iconst_0
    //   178: istore_2
    //   179: iload 4
    //   181: ifeq +526 -> 707
    //   184: aload 14
    //   186: invokeinterface 44 1 0
    //   191: checkcast 46	java/util/zip/ZipEntry
    //   194: astore 15
    //   196: aload 15
    //   198: invokevirtual 112	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   201: astore_0
    //   202: aload_0
    //   203: ldc 114
    //   205: invokevirtual 117	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   208: ifeq +6 -> 214
    //   211: goto -43 -> 168
    //   214: aload 13
    //   216: iconst_0
    //   217: aload 13
    //   219: invokevirtual 121	java/lang/StringBuilder:length	()I
    //   222: invokevirtual 125	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 13
    //   228: aload_1
    //   229: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 13
    //   235: getstatic 128	java/io/File:separator	Ljava/lang/String;
    //   238: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 13
    //   244: aload_0
    //   245: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 15
    //   251: invokevirtual 49	java/util/zip/ZipEntry:isDirectory	()Z
    //   254: ifeq +31 -> 285
    //   257: new 93	java/io/File
    //   260: dup
    //   261: aload 13
    //   263: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   269: astore_0
    //   270: aload_0
    //   271: invokevirtual 97	java/io/File:exists	()Z
    //   274: ifne -106 -> 168
    //   277: aload_0
    //   278: invokevirtual 100	java/io/File:mkdirs	()Z
    //   281: pop
    //   282: goto -114 -> 168
    //   285: aconst_null
    //   286: astore 7
    //   288: aconst_null
    //   289: astore 10
    //   291: aload 11
    //   293: aload 15
    //   295: invokevirtual 132	com/tencent/qqmini/sdk/core/utils/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   298: astore 8
    //   300: new 134	java/util/zip/CheckedInputStream
    //   303: dup
    //   304: aload 8
    //   306: new 136	java/util/zip/CRC32
    //   309: dup
    //   310: invokespecial 137	java/util/zip/CRC32:<init>	()V
    //   313: invokespecial 140	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   316: astore 9
    //   318: aload 10
    //   320: astore_0
    //   321: new 93	java/io/File
    //   324: dup
    //   325: new 86	java/lang/String
    //   328: dup
    //   329: aload 13
    //   331: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: ldc 142
    //   336: invokevirtual 146	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   339: ldc 148
    //   341: invokespecial 151	java/lang/String:<init>	([BLjava/lang/String;)V
    //   344: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   347: astore 7
    //   349: aload 10
    //   351: astore_0
    //   352: aload 7
    //   354: invokevirtual 97	java/io/File:exists	()Z
    //   357: ifne +33 -> 390
    //   360: aload 10
    //   362: astore_0
    //   363: aload 7
    //   365: invokevirtual 155	java/io/File:getParentFile	()Ljava/io/File;
    //   368: astore 16
    //   370: aload 10
    //   372: astore_0
    //   373: aload 16
    //   375: invokevirtual 97	java/io/File:exists	()Z
    //   378: ifne +12 -> 390
    //   381: aload 10
    //   383: astore_0
    //   384: aload 16
    //   386: invokevirtual 100	java/io/File:mkdirs	()Z
    //   389: pop
    //   390: aload 10
    //   392: astore_0
    //   393: new 157	java/io/BufferedOutputStream
    //   396: dup
    //   397: new 159	java/io/FileOutputStream
    //   400: dup
    //   401: aload 7
    //   403: invokespecial 160	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   406: invokespecial 163	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   409: invokestatic 169	com/tencent/qqmini/sdk/core/utils/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcom/tencent/qqmini/sdk/core/utils/RecycleableBufferedOutputStream;
    //   412: astore 7
    //   414: aload 7
    //   416: astore_0
    //   417: aload 15
    //   419: invokevirtual 53	java/util/zip/ZipEntry:getSize	()J
    //   422: lstore 5
    //   424: lload 5
    //   426: lconst_0
    //   427: lcmp
    //   428: ifle +40 -> 468
    //   431: aload 7
    //   433: astore_0
    //   434: aload 9
    //   436: aload 12
    //   438: iconst_0
    //   439: sipush 8192
    //   442: invokevirtual 173	java/util/zip/CheckedInputStream:read	([BII)I
    //   445: istore_2
    //   446: aload 7
    //   448: astore_0
    //   449: aload 7
    //   451: aload 12
    //   453: iconst_0
    //   454: iload_2
    //   455: invokevirtual 179	java/io/OutputStream:write	([BII)V
    //   458: lload 5
    //   460: iload_2
    //   461: i2l
    //   462: lsub
    //   463: lstore 5
    //   465: goto -41 -> 424
    //   468: aload 7
    //   470: astore_0
    //   471: aload 15
    //   473: invokevirtual 182	java/util/zip/ZipEntry:getCrc	()J
    //   476: aload 9
    //   478: invokevirtual 186	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   481: invokeinterface 191 1 0
    //   486: lcmp
    //   487: ifeq +91 -> 578
    //   490: iconst_4
    //   491: istore_3
    //   492: aload 7
    //   494: astore_0
    //   495: new 63	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   502: astore_1
    //   503: aload 7
    //   505: astore_0
    //   506: aload_1
    //   507: ldc 193
    //   509: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload 7
    //   515: astore_0
    //   516: aload_1
    //   517: aload 15
    //   519: invokevirtual 182	java/util/zip/ZipEntry:getCrc	()J
    //   522: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 7
    //   528: astore_0
    //   529: ldc 91
    //   531: aload_1
    //   532: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 199	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   538: aload 9
    //   540: invokevirtual 202	java/util/zip/CheckedInputStream:close	()V
    //   543: aload 8
    //   545: ifnull +11 -> 556
    //   548: aload 8
    //   550: invokevirtual 205	java/io/InputStream:close	()V
    //   553: goto +3 -> 556
    //   556: iload_3
    //   557: istore_2
    //   558: aload 7
    //   560: ifnull +147 -> 707
    //   563: aload 7
    //   565: invokevirtual 208	java/io/OutputStream:flush	()V
    //   568: aload 7
    //   570: invokevirtual 209	java/io/OutputStream:close	()V
    //   573: iload_3
    //   574: istore_2
    //   575: goto +132 -> 707
    //   578: aload 9
    //   580: invokevirtual 202	java/util/zip/CheckedInputStream:close	()V
    //   583: aload 8
    //   585: ifnull +11 -> 596
    //   588: aload 8
    //   590: invokevirtual 205	java/io/InputStream:close	()V
    //   593: goto +3 -> 596
    //   596: aload 7
    //   598: ifnull -430 -> 168
    //   601: aload 7
    //   603: invokevirtual 208	java/io/OutputStream:flush	()V
    //   606: aload 7
    //   608: invokevirtual 209	java/io/OutputStream:close	()V
    //   611: goto -443 -> 168
    //   614: astore_1
    //   615: aload_0
    //   616: astore 7
    //   618: aload 9
    //   620: astore_0
    //   621: goto +16 -> 637
    //   624: astore_1
    //   625: aconst_null
    //   626: astore_0
    //   627: goto +10 -> 637
    //   630: astore_1
    //   631: aconst_null
    //   632: astore 8
    //   634: aload 8
    //   636: astore_0
    //   637: aload_0
    //   638: ifnull +10 -> 648
    //   641: aload_0
    //   642: invokevirtual 202	java/util/zip/CheckedInputStream:close	()V
    //   645: goto +3 -> 648
    //   648: aload 8
    //   650: ifnull +11 -> 661
    //   653: aload 8
    //   655: invokevirtual 205	java/io/InputStream:close	()V
    //   658: goto +3 -> 661
    //   661: aload 7
    //   663: ifnull +13 -> 676
    //   666: aload 7
    //   668: invokevirtual 208	java/io/OutputStream:flush	()V
    //   671: aload 7
    //   673: invokevirtual 209	java/io/OutputStream:close	()V
    //   676: aload_1
    //   677: athrow
    //   678: astore_0
    //   679: aload_0
    //   680: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   683: bipush 7
    //   685: istore_2
    //   686: goto +21 -> 707
    //   689: astore_0
    //   690: aload_0
    //   691: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   694: bipush 6
    //   696: istore_2
    //   697: goto +10 -> 707
    //   700: astore_0
    //   701: aload_0
    //   702: invokevirtual 214	java/io/FileNotFoundException:printStackTrace	()V
    //   705: iconst_5
    //   706: istore_2
    //   707: aload 11
    //   709: invokevirtual 215	com/tencent/qqmini/sdk/core/utils/QZipFile:close	()V
    //   712: iload_2
    //   713: ireturn
    //   714: astore_0
    //   715: aload_0
    //   716: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   719: bipush 8
    //   721: ireturn
    //   722: ldc 91
    //   724: ldc 217
    //   726: invokestatic 199	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   729: iconst_3
    //   730: ireturn
    //   731: ldc 91
    //   733: ldc 219
    //   735: invokestatic 199	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   738: iconst_2
    //   739: ireturn
    //   740: ldc 91
    //   742: ldc 221
    //   744: invokestatic 199	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: iconst_1
    //   748: ireturn
    //   749: astore_0
    //   750: goto -10 -> 740
    //   753: astore_0
    //   754: goto -23 -> 731
    //   757: astore_0
    //   758: goto -36 -> 722
    //   761: astore_0
    //   762: goto -219 -> 543
    //   765: astore_0
    //   766: goto -210 -> 556
    //   769: astore_0
    //   770: iload_3
    //   771: istore_2
    //   772: goto -65 -> 707
    //   775: astore_0
    //   776: goto -193 -> 583
    //   779: astore_0
    //   780: goto -184 -> 596
    //   783: astore_0
    //   784: goto -616 -> 168
    //   787: astore_0
    //   788: goto -140 -> 648
    //   791: astore_0
    //   792: goto -131 -> 661
    //   795: astore_0
    //   796: goto -120 -> 676
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	799	0	paramString1	String
    //   0	799	1	paramString2	String
    //   178	594	2	i	int
    //   491	280	3	j	int
    //   175	5	4	bool	boolean
    //   422	42	5	l	long
    //   7	665	7	localObject1	Object
    //   298	356	8	localInputStream	java.io.InputStream
    //   316	303	9	localCheckedInputStream	java.util.zip.CheckedInputStream
    //   289	102	10	localObject2	Object
    //   140	568	11	localQZipFile	QZipFile
    //   147	305	12	arrayOfByte	byte[]
    //   159	171	13	localStringBuilder	java.lang.StringBuilder
    //   166	19	14	localEnumeration	Enumeration
    //   194	324	15	localZipEntry	ZipEntry
    //   368	17	16	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   321	349	614	finally
    //   352	360	614	finally
    //   363	370	614	finally
    //   373	381	614	finally
    //   384	390	614	finally
    //   393	414	614	finally
    //   417	424	614	finally
    //   434	446	614	finally
    //   449	458	614	finally
    //   471	490	614	finally
    //   495	503	614	finally
    //   506	513	614	finally
    //   516	526	614	finally
    //   529	538	614	finally
    //   300	318	624	finally
    //   291	300	630	finally
    //   142	168	678	java/lang/Exception
    //   168	177	678	java/lang/Exception
    //   184	211	678	java/lang/Exception
    //   214	282	678	java/lang/Exception
    //   538	543	678	java/lang/Exception
    //   548	553	678	java/lang/Exception
    //   563	573	678	java/lang/Exception
    //   578	583	678	java/lang/Exception
    //   588	593	678	java/lang/Exception
    //   601	611	678	java/lang/Exception
    //   641	645	678	java/lang/Exception
    //   653	658	678	java/lang/Exception
    //   666	676	678	java/lang/Exception
    //   676	678	678	java/lang/Exception
    //   142	168	689	java/io/IOException
    //   168	177	689	java/io/IOException
    //   184	211	689	java/io/IOException
    //   214	282	689	java/io/IOException
    //   676	678	689	java/io/IOException
    //   142	168	700	java/io/FileNotFoundException
    //   168	177	700	java/io/FileNotFoundException
    //   184	211	700	java/io/FileNotFoundException
    //   214	282	700	java/io/FileNotFoundException
    //   538	543	700	java/io/FileNotFoundException
    //   548	553	700	java/io/FileNotFoundException
    //   563	573	700	java/io/FileNotFoundException
    //   578	583	700	java/io/FileNotFoundException
    //   588	593	700	java/io/FileNotFoundException
    //   601	611	700	java/io/FileNotFoundException
    //   641	645	700	java/io/FileNotFoundException
    //   653	658	700	java/io/FileNotFoundException
    //   666	676	700	java/io/FileNotFoundException
    //   676	678	700	java/io/FileNotFoundException
    //   707	712	714	java/io/IOException
    //   132	142	749	java/util/zip/ZipException
    //   132	142	753	java/io/IOException
    //   132	142	757	java/lang/Exception
    //   538	543	761	java/io/IOException
    //   548	553	765	java/io/IOException
    //   563	573	769	java/io/IOException
    //   578	583	775	java/io/IOException
    //   588	593	779	java/io/IOException
    //   601	611	783	java/io/IOException
    //   641	645	787	java/io/IOException
    //   653	658	791	java/io/IOException
    //   666	676	795	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.ZipUtil
 * JD-Core Version:    0.7.0.1
 */