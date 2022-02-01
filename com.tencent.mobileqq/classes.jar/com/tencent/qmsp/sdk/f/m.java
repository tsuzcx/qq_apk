package com.tencent.qmsp.sdk.f;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

public class m
{
  /* Error */
  public static int a(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 18	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +608 -> 612
    //   7: aload_1
    //   8: invokestatic 18	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +6 -> 17
    //   14: goto +598 -> 612
    //   17: new 20	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   24: astore 4
    //   26: aload 4
    //   28: ldc 26
    //   30: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 4
    //   36: aload_0
    //   37: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 4
    //   43: ldc 32
    //   45: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: aload_1
    //   52: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 34
    //   58: iconst_2
    //   59: aload 4
    //   61: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 43	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: new 45	java/io/File
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore 4
    //   77: aload 4
    //   79: invokevirtual 52	java/io/File:exists	()Z
    //   82: ifne +14 -> 96
    //   85: ldc 34
    //   87: iconst_2
    //   88: ldc 54
    //   90: invokestatic 43	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: bipush 254
    //   95: ireturn
    //   96: new 45	java/io/File
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 52	java/io/File:exists	()Z
    //   109: ifne +8 -> 117
    //   112: aload_0
    //   113: invokevirtual 57	java/io/File:mkdirs	()Z
    //   116: pop
    //   117: aconst_null
    //   118: astore_0
    //   119: new 59	com/tencent/qmsp/sdk/f/i
    //   122: dup
    //   123: new 61	java/io/BufferedInputStream
    //   126: dup
    //   127: new 63	java/io/FileInputStream
    //   130: dup
    //   131: aload 4
    //   133: invokespecial 66	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   136: invokespecial 69	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   139: invokespecial 70	com/tencent/qmsp/sdk/f/i:<init>	(Ljava/io/InputStream;)V
    //   142: astore 4
    //   144: aload 4
    //   146: astore_0
    //   147: goto +41 -> 188
    //   150: astore 4
    //   152: new 20	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   159: astore 5
    //   161: aload 5
    //   163: ldc 72
    //   165: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 5
    //   171: aload 4
    //   173: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc 34
    //   179: iconst_1
    //   180: aload 5
    //   182: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 78	com/tencent/qmsp/sdk/f/g:b	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iconst_0
    //   189: istore_2
    //   190: iconst_0
    //   191: istore_3
    //   192: new 20	java/lang/StringBuilder
    //   195: dup
    //   196: sipush 512
    //   199: invokespecial 81	java/lang/StringBuilder:<init>	(I)V
    //   202: astore 4
    //   204: aload_0
    //   205: invokevirtual 85	com/tencent/qmsp/sdk/f/i:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   208: astore 5
    //   210: aload 5
    //   212: ifnull +206 -> 418
    //   215: aload 4
    //   217: iconst_0
    //   218: aload 4
    //   220: invokevirtual 89	java/lang/StringBuilder:length	()I
    //   223: invokevirtual 93	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 5
    //   229: invokevirtual 98	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   232: astore 6
    //   234: aload 6
    //   236: ifnull -32 -> 204
    //   239: aload 6
    //   241: ldc 100
    //   243: invokevirtual 105	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   246: ifeq +6 -> 252
    //   249: goto -45 -> 204
    //   252: new 20	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   259: astore 7
    //   261: aload 7
    //   263: ldc 107
    //   265: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 7
    //   271: aload_1
    //   272: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 7
    //   278: ldc 109
    //   280: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 7
    //   286: aload 6
    //   288: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: ldc 34
    //   294: iconst_2
    //   295: aload 7
    //   297: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 43	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 4
    //   305: aload_1
    //   306: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 4
    //   312: getstatic 113	java/io/File:separator	Ljava/lang/String;
    //   315: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 4
    //   321: aload 6
    //   323: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 5
    //   329: invokevirtual 116	java/util/zip/ZipEntry:isDirectory	()Z
    //   332: ifeq +34 -> 366
    //   335: new 45	java/io/File
    //   338: dup
    //   339: aload 4
    //   341: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   347: astore 5
    //   349: aload 5
    //   351: invokevirtual 52	java/io/File:exists	()Z
    //   354: ifne -150 -> 204
    //   357: aload 5
    //   359: invokevirtual 57	java/io/File:mkdirs	()Z
    //   362: pop
    //   363: goto -159 -> 204
    //   366: new 45	java/io/File
    //   369: dup
    //   370: aload 4
    //   372: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   378: astore 5
    //   380: aload 5
    //   382: invokevirtual 52	java/io/File:exists	()Z
    //   385: ifne +24 -> 409
    //   388: aload 5
    //   390: invokevirtual 120	java/io/File:getParentFile	()Ljava/io/File;
    //   393: astore 6
    //   395: aload 6
    //   397: invokevirtual 52	java/io/File:exists	()Z
    //   400: ifne +9 -> 409
    //   403: aload 6
    //   405: invokevirtual 57	java/io/File:mkdirs	()Z
    //   408: pop
    //   409: aload_0
    //   410: aload 5
    //   412: invokestatic 123	com/tencent/qmsp/sdk/f/m:a	(Lcom/tencent/qmsp/sdk/f/i;Ljava/io/File;)V
    //   415: goto -211 -> 204
    //   418: aload_0
    //   419: ifnull +173 -> 592
    //   422: aload_0
    //   423: invokevirtual 128	java/util/zip/ZipInputStream:close	()V
    //   426: iconst_0
    //   427: ireturn
    //   428: astore_0
    //   429: aload_0
    //   430: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   433: iload_3
    //   434: ireturn
    //   435: astore_1
    //   436: goto +158 -> 594
    //   439: astore_1
    //   440: bipush 251
    //   442: istore_3
    //   443: new 20	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   450: astore 4
    //   452: aload 4
    //   454: ldc 133
    //   456: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 4
    //   462: aload_1
    //   463: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: ldc 34
    //   469: iconst_1
    //   470: aload 4
    //   472: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 78	com/tencent/qmsp/sdk/f/g:b	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: iload_3
    //   479: istore_2
    //   480: aload_0
    //   481: ifnull +111 -> 592
    //   484: iload_3
    //   485: istore_2
    //   486: goto +100 -> 586
    //   489: astore_1
    //   490: bipush 252
    //   492: istore_3
    //   493: new 20	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   500: astore 4
    //   502: aload 4
    //   504: ldc 133
    //   506: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 4
    //   512: aload_1
    //   513: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: ldc 34
    //   519: iconst_1
    //   520: aload 4
    //   522: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 78	com/tencent/qmsp/sdk/f/g:b	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: iload_3
    //   529: istore_2
    //   530: aload_0
    //   531: ifnull +61 -> 592
    //   534: iload_3
    //   535: istore_2
    //   536: goto +50 -> 586
    //   539: astore_1
    //   540: bipush 253
    //   542: istore_3
    //   543: new 20	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   550: astore 4
    //   552: aload 4
    //   554: ldc 133
    //   556: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 4
    //   562: aload_1
    //   563: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: ldc 34
    //   569: iconst_1
    //   570: aload 4
    //   572: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 78	com/tencent/qmsp/sdk/f/g:b	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: iload_3
    //   579: istore_2
    //   580: aload_0
    //   581: ifnull +11 -> 592
    //   584: iload_3
    //   585: istore_2
    //   586: iload_2
    //   587: istore_3
    //   588: aload_0
    //   589: invokevirtual 128	java/util/zip/ZipInputStream:close	()V
    //   592: iload_2
    //   593: ireturn
    //   594: aload_0
    //   595: ifnull +15 -> 610
    //   598: aload_0
    //   599: invokevirtual 128	java/util/zip/ZipInputStream:close	()V
    //   602: goto +8 -> 610
    //   605: astore_0
    //   606: aload_0
    //   607: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   610: aload_1
    //   611: athrow
    //   612: new 20	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   619: astore 4
    //   621: aload 4
    //   623: ldc 135
    //   625: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload 4
    //   631: aload_0
    //   632: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload 4
    //   638: ldc 137
    //   640: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 4
    //   646: aload_1
    //   647: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: ldc 34
    //   653: iconst_1
    //   654: aload 4
    //   656: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 78	com/tencent/qmsp/sdk/f/g:b	(Ljava/lang/String;ILjava/lang/String;)V
    //   662: iconst_m1
    //   663: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	paramString1	java.lang.String
    //   0	664	1	paramString2	java.lang.String
    //   189	404	2	i	int
    //   191	397	3	j	int
    //   24	121	4	localObject1	Object
    //   150	22	4	localObject2	Object
    //   202	453	4	localStringBuilder1	StringBuilder
    //   159	252	5	localObject3	Object
    //   232	172	6	localObject4	Object
    //   259	37	7	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   119	144	150	finally
    //   422	426	428	java/io/IOException
    //   588	592	428	java/io/IOException
    //   192	204	435	finally
    //   204	210	435	finally
    //   215	234	435	finally
    //   239	249	435	finally
    //   252	261	435	finally
    //   261	276	435	finally
    //   276	363	435	finally
    //   366	409	435	finally
    //   409	415	435	finally
    //   443	478	435	finally
    //   493	528	435	finally
    //   543	578	435	finally
    //   192	204	439	java/lang/Exception
    //   204	210	439	java/lang/Exception
    //   215	234	439	java/lang/Exception
    //   239	249	439	java/lang/Exception
    //   252	261	439	java/lang/Exception
    //   261	276	439	java/lang/Exception
    //   276	363	439	java/lang/Exception
    //   366	409	439	java/lang/Exception
    //   409	415	439	java/lang/Exception
    //   192	204	489	java/io/IOException
    //   204	210	489	java/io/IOException
    //   215	234	489	java/io/IOException
    //   239	249	489	java/io/IOException
    //   252	261	489	java/io/IOException
    //   261	276	489	java/io/IOException
    //   276	363	489	java/io/IOException
    //   366	409	489	java/io/IOException
    //   409	415	489	java/io/IOException
    //   192	204	539	java/io/FileNotFoundException
    //   204	210	539	java/io/FileNotFoundException
    //   215	234	539	java/io/FileNotFoundException
    //   239	249	539	java/io/FileNotFoundException
    //   252	261	539	java/io/FileNotFoundException
    //   261	276	539	java/io/FileNotFoundException
    //   276	363	539	java/io/FileNotFoundException
    //   366	409	539	java/io/FileNotFoundException
    //   409	415	539	java/io/FileNotFoundException
    //   598	602	605	java/io/IOException
  }
  
  private static void a(i parami, File paramFile)
  {
    byte[] arrayOfByte = new byte[8192];
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        paramFile = j.a(new FileOutputStream(paramFile));
        localObject1 = paramFile;
        localObject2 = paramFile;
        int i = parami.read(arrayOfByte, 0, arrayOfByte.length);
        if (i != -1)
        {
          localObject1 = paramFile;
          localObject2 = paramFile;
          paramFile.write(arrayOfByte, 0, i);
          continue;
        }
        if (paramFile == null) {
          continue;
        }
      }
      catch (Exception parami) {}finally
      {
        continue;
        localObject2 = localObject1;
        paramFile = new StringBuilder();
        localObject2 = localObject1;
        paramFile.append("unZipFile2 Unzip the error");
        localObject2 = localObject1;
        paramFile.append(parami);
        localObject2 = localObject1;
        g.b("Qp.ZU", 1, paramFile.toString());
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((j)localObject1).close();
          return;
        }
        catch (IOException parami)
        {
          paramFile = new StringBuilder();
        }
        continue;
        return;
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((j)localObject2).close();
        }
        catch (IOException paramFile)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("unZipFile2 Unzip the error");
          ((StringBuilder)localObject1).append(paramFile);
          g.b("Qp.ZU", 1, ((StringBuilder)localObject1).toString());
        }
        break label226;
      }
      try
      {
        paramFile.close();
        return;
      }
      catch (IOException parami)
      {
        paramFile = new StringBuilder();
        paramFile.append("unZipFile2 Unzip the error");
        paramFile.append(parami);
        g.b("Qp.ZU", 1, paramFile.toString());
        return;
      }
    }
    label226:
    for (;;)
    {
      throw parami;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.m
 * JD-Core Version:    0.7.0.1
 */