import android.text.TextUtils;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.qphone.base.util.QLog;
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

public class nay
{
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 20	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +39 -> 43
    //   7: ldc 22
    //   9: iconst_4
    //   10: new 24	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   17: ldc 30
    //   19: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: invokevirtual 40	java/lang/String:toString	()Ljava/lang/String;
    //   26: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 42
    //   31: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 49	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: bipush 9
    //   42: ireturn
    //   43: invokestatic 53	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   46: ifeq +40 -> 86
    //   49: ldc 22
    //   51: iconst_4
    //   52: new 24	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   59: ldc 30
    //   61: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 40	java/lang/String:toString	()Ljava/lang/String;
    //   68: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 55
    //   73: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: new 60	java/io/File
    //   89: dup
    //   90: aload_1
    //   91: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore 6
    //   96: aload 6
    //   98: invokevirtual 66	java/io/File:exists	()Z
    //   101: ifne +9 -> 110
    //   104: aload 6
    //   106: invokevirtual 69	java/io/File:mkdirs	()Z
    //   109: pop
    //   110: new 60	java/io/File
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore_0
    //   119: new 71	com/tencent/commonsdk/zip/QZipFile
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 74	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   127: astore 9
    //   129: iconst_0
    //   130: istore_3
    //   131: sipush 8192
    //   134: newarray byte
    //   136: astore 8
    //   138: new 24	java/lang/StringBuilder
    //   141: dup
    //   142: sipush 512
    //   145: invokespecial 77	java/lang/StringBuilder:<init>	(I)V
    //   148: astore 10
    //   150: aload 9
    //   152: invokevirtual 81	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   155: astore 11
    //   157: iload_3
    //   158: istore_2
    //   159: aload 11
    //   161: invokeinterface 86 1 0
    //   166: ifeq +593 -> 759
    //   169: aload 11
    //   171: invokeinterface 90 1 0
    //   176: checkcast 92	java/util/zip/ZipEntry
    //   179: astore 12
    //   181: aload 12
    //   183: invokevirtual 95	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   186: astore_0
    //   187: aload_0
    //   188: ldc 97
    //   190: invokevirtual 100	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   193: ifne -36 -> 157
    //   196: aload 10
    //   198: iconst_0
    //   199: aload 10
    //   201: invokevirtual 104	java/lang/StringBuilder:length	()I
    //   204: invokevirtual 108	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 10
    //   210: aload_1
    //   211: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: getstatic 112	java/io/File:separator	Ljava/lang/String;
    //   217: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 12
    //   227: invokevirtual 115	java/util/zip/ZipEntry:isDirectory	()Z
    //   230: ifeq +116 -> 346
    //   233: new 60	java/io/File
    //   236: dup
    //   237: aload 10
    //   239: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 66	java/io/File:exists	()Z
    //   250: ifne -93 -> 157
    //   253: aload_0
    //   254: invokevirtual 69	java/io/File:mkdirs	()Z
    //   257: pop
    //   258: goto -101 -> 157
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual 118	java/io/FileNotFoundException:printStackTrace	()V
    //   266: iconst_5
    //   267: istore_2
    //   268: aload 9
    //   270: invokevirtual 121	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   273: iload_2
    //   274: ireturn
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   280: bipush 8
    //   282: ireturn
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 123	java/util/zip/ZipException:printStackTrace	()V
    //   288: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +11 -> 302
    //   294: ldc 22
    //   296: iconst_2
    //   297: ldc 128
    //   299: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: iconst_1
    //   303: ireturn
    //   304: astore_0
    //   305: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +11 -> 319
    //   311: ldc 22
    //   313: iconst_2
    //   314: ldc 130
    //   316: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload_0
    //   320: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   323: iconst_2
    //   324: ireturn
    //   325: astore_0
    //   326: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +11 -> 340
    //   332: ldc 22
    //   334: iconst_2
    //   335: ldc 132
    //   337: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload_0
    //   341: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   344: iconst_3
    //   345: ireturn
    //   346: aconst_null
    //   347: astore 7
    //   349: aload 9
    //   351: aload 12
    //   353: invokevirtual 137	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   356: astore_0
    //   357: new 139	java/util/zip/CheckedInputStream
    //   360: dup
    //   361: aload_0
    //   362: new 141	java/util/zip/CRC32
    //   365: dup
    //   366: invokespecial 142	java/util/zip/CRC32:<init>	()V
    //   369: invokespecial 145	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   372: astore 6
    //   374: new 60	java/io/File
    //   377: dup
    //   378: new 36	java/lang/String
    //   381: dup
    //   382: aload 10
    //   384: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: ldc 147
    //   389: invokevirtual 151	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   392: ldc 153
    //   394: invokespecial 156	java/lang/String:<init>	([BLjava/lang/String;)V
    //   397: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   400: astore 7
    //   402: aload 7
    //   404: invokevirtual 66	java/io/File:exists	()Z
    //   407: ifne +24 -> 431
    //   410: aload 7
    //   412: invokevirtual 160	java/io/File:getParentFile	()Ljava/io/File;
    //   415: astore 13
    //   417: aload 13
    //   419: invokevirtual 66	java/io/File:exists	()Z
    //   422: ifne +9 -> 431
    //   425: aload 13
    //   427: invokevirtual 69	java/io/File:mkdirs	()Z
    //   430: pop
    //   431: new 162	java/io/BufferedOutputStream
    //   434: dup
    //   435: new 164	java/io/FileOutputStream
    //   438: dup
    //   439: aload 7
    //   441: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   444: invokespecial 168	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   447: invokestatic 173	bhpa:a	(Ljava/io/OutputStream;)Lbhpa;
    //   450: astore 7
    //   452: aload 12
    //   454: invokevirtual 177	java/util/zip/ZipEntry:getSize	()J
    //   457: lstore 4
    //   459: lload 4
    //   461: lconst_0
    //   462: lcmp
    //   463: ifle +34 -> 497
    //   466: aload 6
    //   468: aload 8
    //   470: iconst_0
    //   471: sipush 8192
    //   474: invokevirtual 181	java/util/zip/CheckedInputStream:read	([BII)I
    //   477: istore_2
    //   478: aload 7
    //   480: aload 8
    //   482: iconst_0
    //   483: iload_2
    //   484: invokevirtual 187	java/io/OutputStream:write	([BII)V
    //   487: lload 4
    //   489: iload_2
    //   490: i2l
    //   491: lsub
    //   492: lstore 4
    //   494: goto -35 -> 459
    //   497: aload 12
    //   499: invokevirtual 190	java/util/zip/ZipEntry:getCrc	()J
    //   502: aload 6
    //   504: invokevirtual 194	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   507: invokeinterface 199 1 0
    //   512: lcmp
    //   513: ifeq +79 -> 592
    //   516: iconst_4
    //   517: istore_2
    //   518: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq +32 -> 553
    //   524: ldc 22
    //   526: iconst_2
    //   527: new 24	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   534: ldc 201
    //   536: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload 12
    //   541: invokevirtual 190	java/util/zip/ZipEntry:getCrc	()J
    //   544: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   547: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   553: aload 6
    //   555: ifnull +8 -> 563
    //   558: aload 6
    //   560: invokevirtual 205	java/util/zip/CheckedInputStream:close	()V
    //   563: aload_0
    //   564: ifnull +7 -> 571
    //   567: aload_0
    //   568: invokevirtual 208	java/io/InputStream:close	()V
    //   571: aload 7
    //   573: ifnull +186 -> 759
    //   576: aload 7
    //   578: invokevirtual 209	java/io/OutputStream:close	()V
    //   581: iconst_4
    //   582: istore_2
    //   583: goto -315 -> 268
    //   586: astore_0
    //   587: iconst_4
    //   588: istore_2
    //   589: goto -321 -> 268
    //   592: aload 6
    //   594: ifnull +8 -> 602
    //   597: aload 6
    //   599: invokevirtual 205	java/util/zip/CheckedInputStream:close	()V
    //   602: aload_0
    //   603: ifnull +7 -> 610
    //   606: aload_0
    //   607: invokevirtual 208	java/io/InputStream:close	()V
    //   610: aload 7
    //   612: ifnull -455 -> 157
    //   615: aload 7
    //   617: invokevirtual 209	java/io/OutputStream:close	()V
    //   620: goto -463 -> 157
    //   623: astore_0
    //   624: goto -467 -> 157
    //   627: astore_0
    //   628: aconst_null
    //   629: astore_1
    //   630: aconst_null
    //   631: astore 6
    //   633: aload 6
    //   635: ifnull +8 -> 643
    //   638: aload 6
    //   640: invokevirtual 205	java/util/zip/CheckedInputStream:close	()V
    //   643: aload 7
    //   645: ifnull +8 -> 653
    //   648: aload 7
    //   650: invokevirtual 208	java/io/InputStream:close	()V
    //   653: aload_1
    //   654: ifnull +7 -> 661
    //   657: aload_1
    //   658: invokevirtual 209	java/io/OutputStream:close	()V
    //   661: aload_0
    //   662: athrow
    //   663: astore_0
    //   664: aload_0
    //   665: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   668: bipush 6
    //   670: istore_2
    //   671: goto -403 -> 268
    //   674: astore_0
    //   675: aload_0
    //   676: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   679: bipush 7
    //   681: istore_2
    //   682: goto -414 -> 268
    //   685: astore_1
    //   686: goto -123 -> 563
    //   689: astore_0
    //   690: goto -119 -> 571
    //   693: astore 6
    //   695: goto -93 -> 602
    //   698: astore_0
    //   699: goto -89 -> 610
    //   702: astore 6
    //   704: goto -61 -> 643
    //   707: astore 6
    //   709: goto -56 -> 653
    //   712: astore_1
    //   713: goto -52 -> 661
    //   716: astore 8
    //   718: aconst_null
    //   719: astore_1
    //   720: aload_0
    //   721: astore 7
    //   723: aconst_null
    //   724: astore 6
    //   726: aload 8
    //   728: astore_0
    //   729: goto -96 -> 633
    //   732: astore 8
    //   734: aconst_null
    //   735: astore_1
    //   736: aload_0
    //   737: astore 7
    //   739: aload 8
    //   741: astore_0
    //   742: goto -109 -> 633
    //   745: astore 8
    //   747: aload 7
    //   749: astore_1
    //   750: aload_0
    //   751: astore 7
    //   753: aload 8
    //   755: astore_0
    //   756: goto -123 -> 633
    //   759: goto -491 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	paramString1	String
    //   0	762	1	paramString2	String
    //   158	524	2	i	int
    //   130	28	3	j	int
    //   457	36	4	l	long
    //   94	545	6	localObject1	Object
    //   693	1	6	localIOException1	IOException
    //   702	1	6	localIOException2	IOException
    //   707	1	6	localIOException3	IOException
    //   724	1	6	localObject2	Object
    //   347	405	7	localObject3	Object
    //   136	345	8	arrayOfByte	byte[]
    //   716	11	8	localObject4	Object
    //   732	8	8	localObject5	Object
    //   745	9	8	localObject6	Object
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
    //   576	581	261	java/io/FileNotFoundException
    //   597	602	261	java/io/FileNotFoundException
    //   606	610	261	java/io/FileNotFoundException
    //   615	620	261	java/io/FileNotFoundException
    //   638	643	261	java/io/FileNotFoundException
    //   648	653	261	java/io/FileNotFoundException
    //   657	661	261	java/io/FileNotFoundException
    //   661	663	261	java/io/FileNotFoundException
    //   268	273	275	java/io/IOException
    //   119	129	283	java/util/zip/ZipException
    //   119	129	304	java/io/IOException
    //   119	129	325	java/lang/Exception
    //   576	581	586	java/io/IOException
    //   615	620	623	java/io/IOException
    //   349	357	627	finally
    //   131	157	663	java/io/IOException
    //   159	258	663	java/io/IOException
    //   661	663	663	java/io/IOException
    //   131	157	674	java/lang/Exception
    //   159	258	674	java/lang/Exception
    //   558	563	674	java/lang/Exception
    //   567	571	674	java/lang/Exception
    //   576	581	674	java/lang/Exception
    //   597	602	674	java/lang/Exception
    //   606	610	674	java/lang/Exception
    //   615	620	674	java/lang/Exception
    //   638	643	674	java/lang/Exception
    //   648	653	674	java/lang/Exception
    //   657	661	674	java/lang/Exception
    //   661	663	674	java/lang/Exception
    //   558	563	685	java/io/IOException
    //   567	571	689	java/io/IOException
    //   597	602	693	java/io/IOException
    //   606	610	698	java/io/IOException
    //   638	643	702	java/io/IOException
    //   648	653	707	java/io/IOException
    //   657	661	712	java/io/IOException
    //   357	374	716	finally
    //   374	431	732	finally
    //   431	452	732	finally
    //   452	459	745	finally
    //   466	487	745	finally
    //   497	516	745	finally
    //   518	553	745	finally
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
      paramFile = bhpa.a(new FileOutputStream(paramFile));
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
    //   2: new 71	com/tencent/commonsdk/zip/QZipFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 74	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 81	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   17: astore 6
    //   19: sipush 8192
    //   22: newarray byte
    //   24: astore 7
    //   26: aload 6
    //   28: invokeinterface 86 1 0
    //   33: ifeq +294 -> 327
    //   36: aload 6
    //   38: invokeinterface 90 1 0
    //   43: checkcast 92	java/util/zip/ZipEntry
    //   46: astore 4
    //   48: aload 4
    //   50: invokevirtual 95	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   53: ldc 97
    //   55: invokevirtual 100	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifne -32 -> 26
    //   61: aload 4
    //   63: invokevirtual 115	java/util/zip/ZipEntry:isDirectory	()Z
    //   66: ifeq +121 -> 187
    //   69: invokestatic 53	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   72: ifeq +32 -> 104
    //   75: ldc 22
    //   77: iconst_4
    //   78: new 24	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   85: ldc 245
    //   87: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 4
    //   92: invokevirtual 95	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: new 36	java/lang/String
    //   107: dup
    //   108: new 24	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   115: aload_1
    //   116: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 4
    //   121: invokevirtual 95	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   124: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: ldc 147
    //   132: invokevirtual 151	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   135: ldc 153
    //   137: invokespecial 156	java/lang/String:<init>	([BLjava/lang/String;)V
    //   140: astore_0
    //   141: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +28 -> 172
    //   147: ldc 22
    //   149: iconst_2
    //   150: new 24	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   157: ldc 247
    //   159: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: new 60	java/io/File
    //   175: dup
    //   176: aload_0
    //   177: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   180: invokevirtual 250	java/io/File:mkdir	()Z
    //   183: pop
    //   184: goto -158 -> 26
    //   187: new 60	java/io/File
    //   190: dup
    //   191: new 24	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   198: aload_1
    //   199: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 4
    //   204: invokevirtual 95	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   207: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 160	java/io/File:getParentFile	()Ljava/io/File;
    //   221: invokevirtual 69	java/io/File:mkdirs	()Z
    //   224: pop
    //   225: new 164	java/io/FileOutputStream
    //   228: dup
    //   229: aload_0
    //   230: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   233: invokestatic 173	bhpa:a	(Ljava/io/OutputStream;)Lbhpa;
    //   236: astore_0
    //   237: aload 5
    //   239: aload 4
    //   241: invokevirtual 137	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   244: astore 4
    //   246: aload 4
    //   248: aload 7
    //   250: iconst_0
    //   251: sipush 8192
    //   254: invokevirtual 251	java/io/InputStream:read	([BII)I
    //   257: istore_2
    //   258: iload_2
    //   259: iconst_m1
    //   260: if_icmpeq +42 -> 302
    //   263: aload_0
    //   264: aload 7
    //   266: iconst_0
    //   267: iload_2
    //   268: invokevirtual 187	java/io/OutputStream:write	([BII)V
    //   271: goto -25 -> 246
    //   274: astore 5
    //   276: aload_0
    //   277: astore_3
    //   278: aload 4
    //   280: astore_1
    //   281: aload 5
    //   283: astore_0
    //   284: aload_1
    //   285: ifnull +7 -> 292
    //   288: aload_1
    //   289: invokevirtual 208	java/io/InputStream:close	()V
    //   292: aload_3
    //   293: ifnull +7 -> 300
    //   296: aload_3
    //   297: invokevirtual 209	java/io/OutputStream:close	()V
    //   300: aload_0
    //   301: athrow
    //   302: aload 4
    //   304: ifnull +8 -> 312
    //   307: aload 4
    //   309: invokevirtual 208	java/io/InputStream:close	()V
    //   312: aload_0
    //   313: ifnull -287 -> 26
    //   316: aload_0
    //   317: invokevirtual 209	java/io/OutputStream:close	()V
    //   320: goto -294 -> 26
    //   323: astore_0
    //   324: goto -298 -> 26
    //   327: aload 5
    //   329: invokevirtual 121	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   332: return
    //   333: astore 4
    //   335: goto -23 -> 312
    //   338: astore_1
    //   339: goto -47 -> 292
    //   342: astore_1
    //   343: goto -43 -> 300
    //   346: astore_0
    //   347: aconst_null
    //   348: astore_1
    //   349: goto -65 -> 284
    //   352: astore 4
    //   354: aconst_null
    //   355: astore_1
    //   356: aload_0
    //   357: astore_3
    //   358: aload 4
    //   360: astore_0
    //   361: goto -77 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	paramFile	File
    //   0	364	1	paramString	String
    //   257	11	2	i	int
    //   1	357	3	localFile	File
    //   46	262	4	localObject1	Object
    //   333	1	4	localIOException	IOException
    //   352	7	4	localObject2	Object
    //   10	228	5	localQZipFile	QZipFile
    //   274	54	5	localObject3	Object
    //   17	20	6	localEnumeration	Enumeration
    //   24	241	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   246	258	274	finally
    //   263	271	274	finally
    //   316	320	323	java/io/IOException
    //   307	312	333	java/io/IOException
    //   288	292	338	java/io/IOException
    //   296	300	342	java/io/IOException
    //   225	237	346	finally
    //   237	246	352	finally
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
            break label448;
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
            break label538;
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
            break label540;
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
        label448:
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
    label538:
    return i;
    label540:
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     nay
 * JD-Core Version:    0.7.0.1
 */