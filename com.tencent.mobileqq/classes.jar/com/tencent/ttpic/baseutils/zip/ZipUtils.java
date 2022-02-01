package com.tencent.ttpic.baseutils.zip;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils
{
  private static final String TAG = ZipUtils.class.getSimpleName();
  
  private static void doZip(ZipOutputStream paramZipOutputStream, File paramFile, String paramString, byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramZipOutputStream != null) && (paramFile != null))
    {
      if (!paramFile.exists()) {
        throw new FileNotFoundException("Target File is missing");
      }
      if (TextUtils.isEmpty(paramString))
      {
        paramString = paramFile.getName();
        if (!paramFile.isFile()) {
          break label163;
        }
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            paramFile = new BufferedInputStream(new FileInputStream(paramFile));
            try
            {
              paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
              i = paramFile.read(paramArrayOfByte, 0, paramArrayOfByte.length);
              if (-1 != i)
              {
                paramZipOutputStream.write(paramArrayOfByte, 0, i);
                continue;
                if (paramFile == null) {}
              }
            }
            catch (IOException paramZipOutputStream) {}
          }
          catch (IOException paramZipOutputStream)
          {
            int j;
            paramFile = null;
            continue;
          }
          try
          {
            paramFile.close();
            throw paramZipOutputStream;
            paramString = paramString + File.separator + paramFile.getName();
            break;
            try
            {
              paramFile.close();
              return;
            }
            catch (IOException paramZipOutputStream)
            {
              paramZipOutputStream.printStackTrace();
              return;
            }
          }
          catch (IOException paramFile)
          {
            paramFile.printStackTrace();
          }
        }
        label163:
        if (paramFile.isDirectory())
        {
          paramFile = paramFile.listFiles();
          if (paramFile != null)
          {
            j = paramFile.length;
            if (i < j)
            {
              doZip(paramZipOutputStream, paramFile[i], paramString, paramArrayOfByte);
              i += 1;
            }
          }
        }
      }
    }
    throw new IOException("I/O Object got NullPointerException");
  }
  
  /* Error */
  public static String unZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: ldc 2
    //   11: monitorenter
    //   12: aload_0
    //   13: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +9 -> 27
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload 5
    //   26: areturn
    //   27: new 26	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 30	java/io/File:exists	()Z
    //   40: ifeq -19 -> 21
    //   43: new 26	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 5
    //   53: aload 5
    //   55: invokevirtual 30	java/io/File:exists	()Z
    //   58: ifne +9 -> 67
    //   61: aload 5
    //   63: invokevirtual 113	java/io/File:mkdirs	()Z
    //   66: pop
    //   67: new 53	java/io/FileInputStream
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: astore 7
    //   77: new 115	java/util/zip/ZipInputStream
    //   80: dup
    //   81: new 51	java/io/BufferedInputStream
    //   84: dup
    //   85: aload 7
    //   87: invokespecial 59	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: invokespecial 116	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: astore 11
    //   95: aconst_null
    //   96: astore 4
    //   98: aconst_null
    //   99: astore 5
    //   101: aload 6
    //   103: astore_0
    //   104: aload 11
    //   106: invokevirtual 120	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   109: astore 8
    //   111: aload 8
    //   113: ifnull +575 -> 688
    //   116: getstatic 16	com/tencent/ttpic/baseutils/zip/ZipUtils:TAG	Ljava/lang/String;
    //   119: new 81	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   126: ldc 122
    //   128: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload 8
    //   133: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 131	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload 8
    //   144: invokevirtual 132	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   147: astore 6
    //   149: aload 6
    //   151: ldc 134
    //   153: invokevirtual 139	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   156: ifne -52 -> 104
    //   159: aload 8
    //   161: invokevirtual 140	java/util/zip/ZipEntry:isDirectory	()Z
    //   164: ifeq +107 -> 271
    //   167: new 81	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   174: aload_1
    //   175: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: getstatic 89	java/io/File:separator	Ljava/lang/String;
    //   181: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 6
    //   186: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: astore 6
    //   194: getstatic 16	com/tencent/ttpic/baseutils/zip/ZipUtils:TAG	Ljava/lang/String;
    //   197: new 81	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   204: ldc 142
    //   206: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 6
    //   211: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 131	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: new 26	java/io/File
    //   223: dup
    //   224: aload 6
    //   226: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   229: astore 8
    //   231: aload 8
    //   233: invokevirtual 30	java/io/File:exists	()Z
    //   236: ifne +9 -> 245
    //   239: aload 8
    //   241: invokevirtual 113	java/io/File:mkdirs	()Z
    //   244: pop
    //   245: aload 6
    //   247: aconst_null
    //   248: invokestatic 147	com/tencent/ttpic/baseutils/io/FileUtils:deleteFiles	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload_0
    //   252: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   255: ifeq +558 -> 813
    //   258: aload 8
    //   260: invokevirtual 150	java/io/File:getPath	()Ljava/lang/String;
    //   263: astore 6
    //   265: aload 6
    //   267: astore_0
    //   268: goto +545 -> 813
    //   271: sipush 4096
    //   274: newarray byte
    //   276: astore 10
    //   278: new 81	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   285: aload_1
    //   286: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: getstatic 89	java/io/File:separator	Ljava/lang/String;
    //   292: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 6
    //   297: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: astore 6
    //   305: getstatic 16	com/tencent/ttpic/baseutils/zip/ZipUtils:TAG	Ljava/lang/String;
    //   308: new 81	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   315: ldc 152
    //   317: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 6
    //   322: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 131	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: new 26	java/io/File
    //   334: dup
    //   335: aload 6
    //   337: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   340: astore 6
    //   342: new 154	java/io/FileOutputStream
    //   345: dup
    //   346: aload 6
    //   348: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   351: astore 6
    //   353: new 157	java/io/BufferedOutputStream
    //   356: dup
    //   357: aload 6
    //   359: sipush 4096
    //   362: invokespecial 160	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   365: astore 5
    //   367: aload 5
    //   369: astore 9
    //   371: aload 6
    //   373: astore 8
    //   375: aload 11
    //   377: aload 10
    //   379: invokevirtual 163	java/util/zip/ZipInputStream:read	([B)I
    //   382: istore_2
    //   383: iload_2
    //   384: iconst_m1
    //   385: if_icmpeq +89 -> 474
    //   388: aload 5
    //   390: astore 9
    //   392: aload 6
    //   394: astore 8
    //   396: aload 5
    //   398: aload 10
    //   400: iconst_0
    //   401: iload_2
    //   402: invokevirtual 164	java/io/BufferedOutputStream:write	([BII)V
    //   405: goto -38 -> 367
    //   408: astore 10
    //   410: aload 5
    //   412: astore 4
    //   414: aload 4
    //   416: astore 9
    //   418: aload 6
    //   420: astore 8
    //   422: aload 10
    //   424: invokestatic 168	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   427: aload 4
    //   429: ifnull +8 -> 437
    //   432: aload 4
    //   434: invokevirtual 169	java/io/BufferedOutputStream:close	()V
    //   437: aload 4
    //   439: astore 9
    //   441: aload 6
    //   443: astore 8
    //   445: aload 6
    //   447: ifnull +16 -> 463
    //   450: aload 6
    //   452: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   455: aload 6
    //   457: astore 8
    //   459: aload 4
    //   461: astore 9
    //   463: aload 9
    //   465: astore 4
    //   467: aload 8
    //   469: astore 5
    //   471: goto -367 -> 104
    //   474: aload 5
    //   476: astore 9
    //   478: aload 6
    //   480: astore 8
    //   482: aload 5
    //   484: invokevirtual 173	java/io/BufferedOutputStream:flush	()V
    //   487: aload 5
    //   489: ifnull +8 -> 497
    //   492: aload 5
    //   494: invokevirtual 169	java/io/BufferedOutputStream:close	()V
    //   497: aload 5
    //   499: astore 9
    //   501: aload 6
    //   503: astore 8
    //   505: aload 6
    //   507: ifnull -44 -> 463
    //   510: aload 6
    //   512: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   515: aload 5
    //   517: astore 9
    //   519: aload 6
    //   521: astore 8
    //   523: goto -60 -> 463
    //   526: astore 4
    //   528: aload 4
    //   530: invokestatic 168	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   533: aload 5
    //   535: astore 9
    //   537: aload 6
    //   539: astore 8
    //   541: goto -78 -> 463
    //   544: astore 5
    //   546: aload 7
    //   548: astore_1
    //   549: aload_0
    //   550: astore 4
    //   552: aload 11
    //   554: astore_0
    //   555: aload 5
    //   557: invokestatic 168	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   560: aload_0
    //   561: ifnull +7 -> 568
    //   564: aload_0
    //   565: invokevirtual 174	java/util/zip/ZipInputStream:close	()V
    //   568: aload 4
    //   570: astore 5
    //   572: aload_1
    //   573: ifnull -552 -> 21
    //   576: aload_1
    //   577: invokevirtual 175	java/io/FileInputStream:close	()V
    //   580: aload 4
    //   582: astore 5
    //   584: goto -563 -> 21
    //   587: astore_0
    //   588: aload_0
    //   589: invokestatic 168	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   592: aload 4
    //   594: astore 5
    //   596: goto -575 -> 21
    //   599: astore_0
    //   600: ldc 2
    //   602: monitorexit
    //   603: aload_0
    //   604: athrow
    //   605: astore 5
    //   607: aload 5
    //   609: invokestatic 168	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   612: aload 4
    //   614: astore 9
    //   616: aload 6
    //   618: astore 8
    //   620: goto -157 -> 463
    //   623: astore_0
    //   624: aload 11
    //   626: astore_1
    //   627: aload_1
    //   628: ifnull +7 -> 635
    //   631: aload_1
    //   632: invokevirtual 174	java/util/zip/ZipInputStream:close	()V
    //   635: aload 7
    //   637: ifnull +8 -> 645
    //   640: aload 7
    //   642: invokevirtual 175	java/io/FileInputStream:close	()V
    //   645: aload_0
    //   646: athrow
    //   647: astore_1
    //   648: aload 9
    //   650: astore 4
    //   652: aload 8
    //   654: astore 6
    //   656: aload 4
    //   658: ifnull +8 -> 666
    //   661: aload 4
    //   663: invokevirtual 169	java/io/BufferedOutputStream:close	()V
    //   666: aload 6
    //   668: ifnull +8 -> 676
    //   671: aload 6
    //   673: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   676: aload_1
    //   677: athrow
    //   678: astore 4
    //   680: aload 4
    //   682: invokestatic 168	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   685: goto -9 -> 676
    //   688: aload 11
    //   690: ifnull +8 -> 698
    //   693: aload 11
    //   695: invokevirtual 174	java/util/zip/ZipInputStream:close	()V
    //   698: aload_0
    //   699: astore 5
    //   701: aload 7
    //   703: ifnull -682 -> 21
    //   706: aload 7
    //   708: invokevirtual 175	java/io/FileInputStream:close	()V
    //   711: aload_0
    //   712: astore 5
    //   714: goto -693 -> 21
    //   717: astore_1
    //   718: aload_1
    //   719: invokestatic 168	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   722: aload_0
    //   723: astore 5
    //   725: goto -704 -> 21
    //   728: astore_1
    //   729: aload_1
    //   730: invokestatic 168	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   733: goto -88 -> 645
    //   736: astore_0
    //   737: aconst_null
    //   738: astore_1
    //   739: aconst_null
    //   740: astore 7
    //   742: goto -115 -> 627
    //   745: astore_0
    //   746: aconst_null
    //   747: astore_1
    //   748: goto -121 -> 627
    //   751: astore 5
    //   753: aload_0
    //   754: astore 4
    //   756: aload_1
    //   757: astore 7
    //   759: aload 5
    //   761: astore_0
    //   762: aload 4
    //   764: astore_1
    //   765: goto -138 -> 627
    //   768: astore 5
    //   770: aconst_null
    //   771: astore_0
    //   772: aconst_null
    //   773: astore_1
    //   774: goto -219 -> 555
    //   777: astore 5
    //   779: aconst_null
    //   780: astore_0
    //   781: aload 7
    //   783: astore_1
    //   784: goto -229 -> 555
    //   787: astore_1
    //   788: aload 5
    //   790: astore 6
    //   792: goto -136 -> 656
    //   795: astore_1
    //   796: goto -140 -> 656
    //   799: astore 10
    //   801: aload 5
    //   803: astore 6
    //   805: goto -391 -> 414
    //   808: astore 10
    //   810: goto -396 -> 414
    //   813: goto -709 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	816	0	paramString1	String
    //   0	816	1	paramString2	String
    //   382	20	2	i	int
    //   16	2	3	bool	boolean
    //   4	462	4	localObject1	Object
    //   526	3	4	localIOException1	IOException
    //   550	112	4	localObject2	Object
    //   678	3	4	localIOException2	IOException
    //   754	9	4	str1	String
    //   7	527	5	localObject3	Object
    //   544	12	5	localIOException3	IOException
    //   570	25	5	localObject4	Object
    //   605	3	5	localIOException4	IOException
    //   699	25	5	str2	String
    //   751	9	5	localObject5	Object
    //   768	1	5	localIOException5	IOException
    //   777	25	5	localIOException6	IOException
    //   1	803	6	localObject6	Object
    //   75	707	7	localObject7	Object
    //   109	544	8	localObject8	Object
    //   369	280	9	localObject9	Object
    //   276	123	10	arrayOfByte	byte[]
    //   408	15	10	localIOException7	IOException
    //   799	1	10	localIOException8	IOException
    //   808	1	10	localIOException9	IOException
    //   93	601	11	localZipInputStream	ZipInputStream
    // Exception table:
    //   from	to	target	type
    //   375	383	408	java/io/IOException
    //   396	405	408	java/io/IOException
    //   482	487	408	java/io/IOException
    //   492	497	526	java/io/IOException
    //   510	515	526	java/io/IOException
    //   104	111	544	java/io/IOException
    //   116	245	544	java/io/IOException
    //   245	265	544	java/io/IOException
    //   271	342	544	java/io/IOException
    //   528	533	544	java/io/IOException
    //   607	612	544	java/io/IOException
    //   676	678	544	java/io/IOException
    //   680	685	544	java/io/IOException
    //   564	568	587	java/io/IOException
    //   576	580	587	java/io/IOException
    //   12	17	599	finally
    //   27	36	599	finally
    //   36	67	599	finally
    //   564	568	599	finally
    //   576	580	599	finally
    //   588	592	599	finally
    //   631	635	599	finally
    //   640	645	599	finally
    //   645	647	599	finally
    //   693	698	599	finally
    //   706	711	599	finally
    //   718	722	599	finally
    //   729	733	599	finally
    //   432	437	605	java/io/IOException
    //   450	455	605	java/io/IOException
    //   104	111	623	finally
    //   116	245	623	finally
    //   245	265	623	finally
    //   271	342	623	finally
    //   432	437	623	finally
    //   450	455	623	finally
    //   492	497	623	finally
    //   510	515	623	finally
    //   528	533	623	finally
    //   607	612	623	finally
    //   661	666	623	finally
    //   671	676	623	finally
    //   676	678	623	finally
    //   680	685	623	finally
    //   375	383	647	finally
    //   396	405	647	finally
    //   422	427	647	finally
    //   482	487	647	finally
    //   661	666	678	java/io/IOException
    //   671	676	678	java/io/IOException
    //   693	698	717	java/io/IOException
    //   706	711	717	java/io/IOException
    //   631	635	728	java/io/IOException
    //   640	645	728	java/io/IOException
    //   67	77	736	finally
    //   77	95	745	finally
    //   555	560	751	finally
    //   67	77	768	java/io/IOException
    //   77	95	777	java/io/IOException
    //   342	353	787	finally
    //   353	367	795	finally
    //   342	353	799	java/io/IOException
    //   353	367	808	java/io/IOException
  }
  
  public static byte[] unZip(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
        localZipInputStream = new ZipInputStream(localByteArrayInputStream);
        paramArrayOfByte = null;
        try
        {
          if (localZipInputStream.getNextEntry() == null) {
            continue;
          }
          byte[] arrayOfByte1 = new byte[1024];
          localByteArrayOutputStream = new ByteArrayOutputStream();
          int i = localZipInputStream.read(arrayOfByte1, 0, arrayOfByte1.length);
          if (i == -1) {
            continue;
          }
          localByteArrayOutputStream.write(arrayOfByte1, 0, i);
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        ByteArrayInputStream localByteArrayInputStream;
        ZipInputStream localZipInputStream;
        ByteArrayOutputStream localByteArrayOutputStream;
        byte[] arrayOfByte2;
        paramArrayOfByte = null;
        continue;
        continue;
      }
      return paramArrayOfByte;
      arrayOfByte2 = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        paramArrayOfByte = arrayOfByte2;
      }
      catch (Exception localException4)
      {
        paramArrayOfByte = localException2;
        Exception localException3 = localException4;
      }
    }
    localZipInputStream.close();
    localByteArrayInputStream.close();
    return paramArrayOfByte;
  }
  
  public static boolean zip(File paramFile1, File paramFile2)
  {
    return zip(new File[] { paramFile1 }, paramFile2);
  }
  
  /* Error */
  public static boolean zip(File[] paramArrayOfFile, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +138 -> 142
    //   7: aload_0
    //   8: arraylength
    //   9: iconst_1
    //   10: if_icmplt +132 -> 142
    //   13: aload_1
    //   14: ifnull +128 -> 142
    //   17: sipush 4096
    //   20: newarray byte
    //   22: astore 5
    //   24: new 64	java/util/zip/ZipOutputStream
    //   27: dup
    //   28: new 157	java/io/BufferedOutputStream
    //   31: dup
    //   32: new 154	java/io/FileOutputStream
    //   35: dup
    //   36: aload_1
    //   37: iconst_0
    //   38: invokespecial 204	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   41: invokespecial 207	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   44: invokespecial 208	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   47: astore_1
    //   48: aload_0
    //   49: arraylength
    //   50: istore_3
    //   51: iconst_0
    //   52: istore_2
    //   53: iload_2
    //   54: iload_3
    //   55: if_icmpge +20 -> 75
    //   58: aload_1
    //   59: aload_0
    //   60: iload_2
    //   61: aaload
    //   62: aconst_null
    //   63: aload 5
    //   65: invokestatic 104	com/tencent/ttpic/baseutils/zip/ZipUtils:doZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   68: iload_2
    //   69: iconst_1
    //   70: iadd
    //   71: istore_2
    //   72: goto -19 -> 53
    //   75: aload_1
    //   76: invokevirtual 209	java/util/zip/ZipOutputStream:flush	()V
    //   79: aload_1
    //   80: invokevirtual 212	java/util/zip/ZipOutputStream:closeEntry	()V
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 213	java/util/zip/ZipOutputStream:close	()V
    //   91: iconst_1
    //   92: ireturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   98: iconst_1
    //   99: ireturn
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_0
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 213	java/util/zip/ZipOutputStream:close	()V
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   118: iconst_0
    //   119: ireturn
    //   120: astore_0
    //   121: aload 4
    //   123: astore_1
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 213	java/util/zip/ZipOutputStream:close	()V
    //   132: aload_0
    //   133: athrow
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   139: goto -7 -> 132
    //   142: iconst_0
    //   143: ireturn
    //   144: astore_0
    //   145: goto -21 -> 124
    //   148: astore_0
    //   149: aload_1
    //   150: astore_0
    //   151: goto -48 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramArrayOfFile	File[]
    //   0	154	1	paramFile	File
    //   52	20	2	i	int
    //   50	6	3	j	int
    //   1	121	4	localObject	Object
    //   22	42	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   87	91	93	java/io/IOException
    //   17	48	100	java/io/IOException
    //   107	111	113	java/io/IOException
    //   17	48	120	finally
    //   128	132	134	java/io/IOException
    //   48	51	144	finally
    //   58	68	144	finally
    //   75	83	144	finally
    //   48	51	148	java/io/IOException
    //   58	68	148	java/io/IOException
    //   75	83	148	java/io/IOException
  }
  
  public static byte[] zip(byte[] paramArrayOfByte)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ZipOutputStream localZipOutputStream = new ZipOutputStream(localByteArrayOutputStream);
      ZipEntry localZipEntry = new ZipEntry("placeHolder.dat");
      localZipEntry.setSize(paramArrayOfByte.length);
      localZipOutputStream.putNextEntry(localZipEntry);
      localZipOutputStream.write(paramArrayOfByte);
      localZipOutputStream.closeEntry();
      localZipOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.zip.ZipUtils
 * JD-Core Version:    0.7.0.1
 */