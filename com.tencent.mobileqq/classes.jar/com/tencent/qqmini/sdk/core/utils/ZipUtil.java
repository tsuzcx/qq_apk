package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtil
{
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
    //   0: aload_1
    //   1: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +46 -> 50
    //   7: new 59	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: ldc 62
    //   18: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_1
    //   23: aload_0
    //   24: invokevirtual 72	java/lang/String:toString	()Ljava/lang/String;
    //   27: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_1
    //   32: ldc 74
    //   34: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: ldc 76
    //   40: aload_1
    //   41: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 83	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: bipush 9
    //   49: ireturn
    //   50: new 85	java/io/File
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 7
    //   60: aload 7
    //   62: invokevirtual 89	java/io/File:exists	()Z
    //   65: ifne +9 -> 74
    //   68: aload 7
    //   70: invokevirtual 92	java/io/File:mkdirs	()Z
    //   73: pop
    //   74: new 85	java/io/File
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore_0
    //   83: new 94	com/tencent/qqmini/sdk/core/utils/QZipFile
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 97	com/tencent/qqmini/sdk/core/utils/QZipFile:<init>	(Ljava/io/File;)V
    //   91: astore 11
    //   93: sipush 8192
    //   96: newarray byte
    //   98: astore 12
    //   100: new 59	java/lang/StringBuilder
    //   103: dup
    //   104: sipush 512
    //   107: invokespecial 100	java/lang/StringBuilder:<init>	(I)V
    //   110: astore 13
    //   112: aload 11
    //   114: invokevirtual 101	com/tencent/qqmini/sdk/core/utils/QZipFile:entries	()Ljava/util/Enumeration;
    //   117: astore 14
    //   119: aload 14
    //   121: invokeinterface 36 1 0
    //   126: istore 4
    //   128: iconst_0
    //   129: istore_2
    //   130: iload 4
    //   132: ifeq +526 -> 658
    //   135: aload 14
    //   137: invokeinterface 40 1 0
    //   142: checkcast 42	java/util/zip/ZipEntry
    //   145: astore 15
    //   147: aload 15
    //   149: invokevirtual 104	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   152: astore_0
    //   153: aload_0
    //   154: ldc 106
    //   156: invokevirtual 109	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   159: ifeq +6 -> 165
    //   162: goto -43 -> 119
    //   165: aload 13
    //   167: iconst_0
    //   168: aload 13
    //   170: invokevirtual 113	java/lang/StringBuilder:length	()I
    //   173: invokevirtual 117	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 13
    //   179: aload_1
    //   180: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 13
    //   186: getstatic 121	java/io/File:separator	Ljava/lang/String;
    //   189: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 13
    //   195: aload_0
    //   196: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 15
    //   202: invokevirtual 45	java/util/zip/ZipEntry:isDirectory	()Z
    //   205: ifeq +31 -> 236
    //   208: new 85	java/io/File
    //   211: dup
    //   212: aload 13
    //   214: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual 89	java/io/File:exists	()Z
    //   225: ifne -106 -> 119
    //   228: aload_0
    //   229: invokevirtual 92	java/io/File:mkdirs	()Z
    //   232: pop
    //   233: goto -114 -> 119
    //   236: aconst_null
    //   237: astore 7
    //   239: aconst_null
    //   240: astore 10
    //   242: aload 11
    //   244: aload 15
    //   246: invokevirtual 125	com/tencent/qqmini/sdk/core/utils/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   249: astore 8
    //   251: new 127	java/util/zip/CheckedInputStream
    //   254: dup
    //   255: aload 8
    //   257: new 129	java/util/zip/CRC32
    //   260: dup
    //   261: invokespecial 130	java/util/zip/CRC32:<init>	()V
    //   264: invokespecial 133	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   267: astore 9
    //   269: aload 10
    //   271: astore_0
    //   272: new 85	java/io/File
    //   275: dup
    //   276: new 68	java/lang/String
    //   279: dup
    //   280: aload 13
    //   282: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: ldc 135
    //   287: invokevirtual 139	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   290: ldc 141
    //   292: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   295: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   298: astore 7
    //   300: aload 10
    //   302: astore_0
    //   303: aload 7
    //   305: invokevirtual 89	java/io/File:exists	()Z
    //   308: ifne +33 -> 341
    //   311: aload 10
    //   313: astore_0
    //   314: aload 7
    //   316: invokevirtual 148	java/io/File:getParentFile	()Ljava/io/File;
    //   319: astore 16
    //   321: aload 10
    //   323: astore_0
    //   324: aload 16
    //   326: invokevirtual 89	java/io/File:exists	()Z
    //   329: ifne +12 -> 341
    //   332: aload 10
    //   334: astore_0
    //   335: aload 16
    //   337: invokevirtual 92	java/io/File:mkdirs	()Z
    //   340: pop
    //   341: aload 10
    //   343: astore_0
    //   344: new 150	java/io/BufferedOutputStream
    //   347: dup
    //   348: new 152	java/io/FileOutputStream
    //   351: dup
    //   352: aload 7
    //   354: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   357: invokespecial 156	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   360: invokestatic 162	com/tencent/qqmini/sdk/core/utils/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcom/tencent/qqmini/sdk/core/utils/RecycleableBufferedOutputStream;
    //   363: astore 7
    //   365: aload 7
    //   367: astore_0
    //   368: aload 15
    //   370: invokevirtual 49	java/util/zip/ZipEntry:getSize	()J
    //   373: lstore 5
    //   375: lload 5
    //   377: lconst_0
    //   378: lcmp
    //   379: ifle +40 -> 419
    //   382: aload 7
    //   384: astore_0
    //   385: aload 9
    //   387: aload 12
    //   389: iconst_0
    //   390: sipush 8192
    //   393: invokevirtual 166	java/util/zip/CheckedInputStream:read	([BII)I
    //   396: istore_2
    //   397: aload 7
    //   399: astore_0
    //   400: aload 7
    //   402: aload 12
    //   404: iconst_0
    //   405: iload_2
    //   406: invokevirtual 172	java/io/OutputStream:write	([BII)V
    //   409: lload 5
    //   411: iload_2
    //   412: i2l
    //   413: lsub
    //   414: lstore 5
    //   416: goto -41 -> 375
    //   419: aload 7
    //   421: astore_0
    //   422: aload 15
    //   424: invokevirtual 175	java/util/zip/ZipEntry:getCrc	()J
    //   427: aload 9
    //   429: invokevirtual 179	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   432: invokeinterface 184 1 0
    //   437: lcmp
    //   438: ifeq +91 -> 529
    //   441: iconst_4
    //   442: istore_3
    //   443: aload 7
    //   445: astore_0
    //   446: new 59	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   453: astore_1
    //   454: aload 7
    //   456: astore_0
    //   457: aload_1
    //   458: ldc 186
    //   460: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload 7
    //   466: astore_0
    //   467: aload_1
    //   468: aload 15
    //   470: invokevirtual 175	java/util/zip/ZipEntry:getCrc	()J
    //   473: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 7
    //   479: astore_0
    //   480: ldc 76
    //   482: aload_1
    //   483: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 192	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload 9
    //   491: invokevirtual 195	java/util/zip/CheckedInputStream:close	()V
    //   494: aload 8
    //   496: ifnull +11 -> 507
    //   499: aload 8
    //   501: invokevirtual 198	java/io/InputStream:close	()V
    //   504: goto +3 -> 507
    //   507: iload_3
    //   508: istore_2
    //   509: aload 7
    //   511: ifnull +147 -> 658
    //   514: aload 7
    //   516: invokevirtual 201	java/io/OutputStream:flush	()V
    //   519: aload 7
    //   521: invokevirtual 202	java/io/OutputStream:close	()V
    //   524: iload_3
    //   525: istore_2
    //   526: goto +132 -> 658
    //   529: aload 9
    //   531: invokevirtual 195	java/util/zip/CheckedInputStream:close	()V
    //   534: aload 8
    //   536: ifnull +11 -> 547
    //   539: aload 8
    //   541: invokevirtual 198	java/io/InputStream:close	()V
    //   544: goto +3 -> 547
    //   547: aload 7
    //   549: ifnull -430 -> 119
    //   552: aload 7
    //   554: invokevirtual 201	java/io/OutputStream:flush	()V
    //   557: aload 7
    //   559: invokevirtual 202	java/io/OutputStream:close	()V
    //   562: goto -443 -> 119
    //   565: astore_1
    //   566: aload_0
    //   567: astore 7
    //   569: aload 9
    //   571: astore_0
    //   572: goto +16 -> 588
    //   575: astore_1
    //   576: aconst_null
    //   577: astore_0
    //   578: goto +10 -> 588
    //   581: astore_1
    //   582: aconst_null
    //   583: astore 8
    //   585: aload 8
    //   587: astore_0
    //   588: aload_0
    //   589: ifnull +10 -> 599
    //   592: aload_0
    //   593: invokevirtual 195	java/util/zip/CheckedInputStream:close	()V
    //   596: goto +3 -> 599
    //   599: aload 8
    //   601: ifnull +11 -> 612
    //   604: aload 8
    //   606: invokevirtual 198	java/io/InputStream:close	()V
    //   609: goto +3 -> 612
    //   612: aload 7
    //   614: ifnull +13 -> 627
    //   617: aload 7
    //   619: invokevirtual 201	java/io/OutputStream:flush	()V
    //   622: aload 7
    //   624: invokevirtual 202	java/io/OutputStream:close	()V
    //   627: aload_1
    //   628: athrow
    //   629: astore_0
    //   630: aload_0
    //   631: invokevirtual 205	java/lang/Exception:printStackTrace	()V
    //   634: bipush 7
    //   636: istore_2
    //   637: goto +21 -> 658
    //   640: astore_0
    //   641: aload_0
    //   642: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   645: bipush 6
    //   647: istore_2
    //   648: goto +10 -> 658
    //   651: astore_0
    //   652: aload_0
    //   653: invokevirtual 207	java/io/FileNotFoundException:printStackTrace	()V
    //   656: iconst_5
    //   657: istore_2
    //   658: aload 11
    //   660: invokevirtual 208	com/tencent/qqmini/sdk/core/utils/QZipFile:close	()V
    //   663: iload_2
    //   664: ireturn
    //   665: astore_0
    //   666: aload_0
    //   667: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   670: bipush 8
    //   672: ireturn
    //   673: ldc 76
    //   675: ldc 210
    //   677: invokestatic 192	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   680: iconst_3
    //   681: ireturn
    //   682: ldc 76
    //   684: ldc 212
    //   686: invokestatic 192	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   689: iconst_2
    //   690: ireturn
    //   691: ldc 76
    //   693: ldc 214
    //   695: invokestatic 192	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   698: iconst_1
    //   699: ireturn
    //   700: astore_0
    //   701: goto -10 -> 691
    //   704: astore_0
    //   705: goto -23 -> 682
    //   708: astore_0
    //   709: goto -36 -> 673
    //   712: astore_0
    //   713: goto -219 -> 494
    //   716: astore_0
    //   717: goto -210 -> 507
    //   720: astore_0
    //   721: iload_3
    //   722: istore_2
    //   723: goto -65 -> 658
    //   726: astore_0
    //   727: goto -193 -> 534
    //   730: astore_0
    //   731: goto -184 -> 547
    //   734: astore_0
    //   735: goto -616 -> 119
    //   738: astore_0
    //   739: goto -140 -> 599
    //   742: astore_0
    //   743: goto -131 -> 612
    //   746: astore_0
    //   747: goto -120 -> 627
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	750	0	paramString1	String
    //   0	750	1	paramString2	String
    //   129	594	2	i	int
    //   442	280	3	j	int
    //   126	5	4	bool	boolean
    //   373	42	5	l	long
    //   58	565	7	localObject1	Object
    //   249	356	8	localInputStream	java.io.InputStream
    //   267	303	9	localCheckedInputStream	java.util.zip.CheckedInputStream
    //   240	102	10	localObject2	Object
    //   91	568	11	localQZipFile	QZipFile
    //   98	305	12	arrayOfByte	byte[]
    //   110	171	13	localStringBuilder	java.lang.StringBuilder
    //   117	19	14	localEnumeration	Enumeration
    //   145	324	15	localZipEntry	ZipEntry
    //   319	17	16	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   272	300	565	finally
    //   303	311	565	finally
    //   314	321	565	finally
    //   324	332	565	finally
    //   335	341	565	finally
    //   344	365	565	finally
    //   368	375	565	finally
    //   385	397	565	finally
    //   400	409	565	finally
    //   422	441	565	finally
    //   446	454	565	finally
    //   457	464	565	finally
    //   467	477	565	finally
    //   480	489	565	finally
    //   251	269	575	finally
    //   242	251	581	finally
    //   93	119	629	java/lang/Exception
    //   119	128	629	java/lang/Exception
    //   135	162	629	java/lang/Exception
    //   165	233	629	java/lang/Exception
    //   489	494	629	java/lang/Exception
    //   499	504	629	java/lang/Exception
    //   514	524	629	java/lang/Exception
    //   529	534	629	java/lang/Exception
    //   539	544	629	java/lang/Exception
    //   552	562	629	java/lang/Exception
    //   592	596	629	java/lang/Exception
    //   604	609	629	java/lang/Exception
    //   617	627	629	java/lang/Exception
    //   627	629	629	java/lang/Exception
    //   93	119	640	java/io/IOException
    //   119	128	640	java/io/IOException
    //   135	162	640	java/io/IOException
    //   165	233	640	java/io/IOException
    //   627	629	640	java/io/IOException
    //   93	119	651	java/io/FileNotFoundException
    //   119	128	651	java/io/FileNotFoundException
    //   135	162	651	java/io/FileNotFoundException
    //   165	233	651	java/io/FileNotFoundException
    //   489	494	651	java/io/FileNotFoundException
    //   499	504	651	java/io/FileNotFoundException
    //   514	524	651	java/io/FileNotFoundException
    //   529	534	651	java/io/FileNotFoundException
    //   539	544	651	java/io/FileNotFoundException
    //   552	562	651	java/io/FileNotFoundException
    //   592	596	651	java/io/FileNotFoundException
    //   604	609	651	java/io/FileNotFoundException
    //   617	627	651	java/io/FileNotFoundException
    //   627	629	651	java/io/FileNotFoundException
    //   658	663	665	java/io/IOException
    //   83	93	700	java/util/zip/ZipException
    //   83	93	704	java/io/IOException
    //   83	93	708	java/lang/Exception
    //   489	494	712	java/io/IOException
    //   499	504	716	java/io/IOException
    //   514	524	720	java/io/IOException
    //   529	534	726	java/io/IOException
    //   539	544	730	java/io/IOException
    //   552	562	734	java/io/IOException
    //   592	596	738	java/io/IOException
    //   604	609	742	java/io/IOException
    //   617	627	746	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.ZipUtil
 * JD-Core Version:    0.7.0.1
 */