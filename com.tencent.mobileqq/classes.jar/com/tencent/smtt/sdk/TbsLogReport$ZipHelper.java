package com.tencent.smtt.sdk;

class TbsLogReport$ZipHelper
{
  private static final int BUFFER = 2048;
  private final String files;
  private final String zipFile;
  
  public TbsLogReport$ZipHelper(String paramString1, String paramString2)
  {
    this.files = paramString1;
    this.zipFile = paramString2;
  }
  
  /* Error */
  private static void replaceWrongZipByte(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 28	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 30
    //   7: invokespecial 33	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +58 -> 70
    //   15: aload_3
    //   16: astore_0
    //   17: ldc 35
    //   19: iconst_2
    //   20: invokestatic 41	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   23: istore_1
    //   24: aload_3
    //   25: astore_0
    //   26: aload_3
    //   27: ldc2_w 42
    //   30: invokevirtual 47	java/io/RandomAccessFile:seek	(J)V
    //   33: aload_3
    //   34: astore_0
    //   35: aload_3
    //   36: invokevirtual 51	java/io/RandomAccessFile:read	()I
    //   39: istore_2
    //   40: iload_2
    //   41: iload_1
    //   42: iand
    //   43: ifle +27 -> 70
    //   46: aload_3
    //   47: astore_0
    //   48: aload_3
    //   49: ldc2_w 42
    //   52: invokevirtual 47	java/io/RandomAccessFile:seek	(J)V
    //   55: aload_3
    //   56: astore_0
    //   57: aload_3
    //   58: iload_1
    //   59: iconst_m1
    //   60: ixor
    //   61: sipush 255
    //   64: iand
    //   65: iload_2
    //   66: iand
    //   67: invokevirtual 55	java/io/RandomAccessFile:write	(I)V
    //   70: aload_3
    //   71: ifnull +7 -> 78
    //   74: aload_3
    //   75: invokevirtual 58	java/io/RandomAccessFile:close	()V
    //   78: return
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   84: return
    //   85: astore 4
    //   87: aconst_null
    //   88: astore_3
    //   89: aload_3
    //   90: astore_0
    //   91: aload 4
    //   93: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   96: aload_3
    //   97: ifnull -19 -> 78
    //   100: aload_3
    //   101: invokevirtual 58	java/io/RandomAccessFile:close	()V
    //   104: return
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   110: return
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 58	java/io/RandomAccessFile:close	()V
    //   122: aload_3
    //   123: athrow
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   129: goto -7 -> 122
    //   132: astore_3
    //   133: goto -19 -> 114
    //   136: astore 4
    //   138: goto -49 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramFile	java.io.File
    //   23	38	1	i	int
    //   39	28	2	j	int
    //   10	91	3	localRandomAccessFile	java.io.RandomAccessFile
    //   111	12	3	localObject1	Object
    //   132	1	3	localObject2	Object
    //   85	7	4	localException1	java.lang.Exception
    //   136	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   74	78	79	java/io/IOException
    //   0	11	85	java/lang/Exception
    //   100	104	105	java/io/IOException
    //   0	11	111	finally
    //   118	122	124	java/io/IOException
    //   17	24	132	finally
    //   26	33	132	finally
    //   35	40	132	finally
    //   48	55	132	finally
    //   57	70	132	finally
    //   91	96	132	finally
    //   17	24	136	java/lang/Exception
    //   26	33	136	java/lang/Exception
    //   35	40	136	java/lang/Exception
    //   48	55	136	java/lang/Exception
    //   57	70	136	java/lang/Exception
  }
  
  /* Error */
  public void Zip()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_2
    //   5: new 65	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: getfield 19	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:zipFile	Ljava/lang/String;
    //   13: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   16: astore 4
    //   18: new 70	java/util/zip/ZipOutputStream
    //   21: dup
    //   22: new 72	java/io/BufferedOutputStream
    //   25: dup
    //   26: aload 4
    //   28: invokespecial 75	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: invokespecial 76	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore 6
    //   36: sipush 2048
    //   39: newarray byte
    //   41: astore 7
    //   43: aload_0
    //   44: getfield 17	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:files	Ljava/lang/String;
    //   47: astore 8
    //   49: new 78	java/io/FileInputStream
    //   52: dup
    //   53: aload 8
    //   55: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   58: astore 5
    //   60: new 81	java/io/BufferedInputStream
    //   63: dup
    //   64: aload 5
    //   66: sipush 2048
    //   69: invokespecial 84	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   72: astore_3
    //   73: aload 6
    //   75: new 86	java/util/zip/ZipEntry
    //   78: dup
    //   79: aload 8
    //   81: aload 8
    //   83: ldc 88
    //   85: invokevirtual 94	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   88: iconst_1
    //   89: iadd
    //   90: invokevirtual 98	java/lang/String:substring	(I)Ljava/lang/String;
    //   93: invokespecial 99	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   96: invokevirtual 103	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   99: aload_3
    //   100: aload 7
    //   102: iconst_0
    //   103: sipush 2048
    //   106: invokevirtual 106	java/io/BufferedInputStream:read	([BII)I
    //   109: istore_1
    //   110: iload_1
    //   111: iconst_m1
    //   112: if_icmpeq +80 -> 192
    //   115: aload 6
    //   117: aload 7
    //   119: iconst_0
    //   120: iload_1
    //   121: invokevirtual 109	java/util/zip/ZipOutputStream:write	([BII)V
    //   124: goto -25 -> 99
    //   127: astore 7
    //   129: aload 5
    //   131: astore_2
    //   132: aload 7
    //   134: astore 5
    //   136: aload 5
    //   138: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   141: aload_3
    //   142: ifnull +7 -> 149
    //   145: aload_3
    //   146: invokevirtual 110	java/io/BufferedInputStream:close	()V
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 111	java/io/FileInputStream:close	()V
    //   157: new 113	java/io/File
    //   160: dup
    //   161: aload_0
    //   162: getfield 19	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:zipFile	Ljava/lang/String;
    //   165: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   168: invokestatic 116	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:replaceWrongZipByte	(Ljava/io/File;)V
    //   171: aload 6
    //   173: ifnull +8 -> 181
    //   176: aload 6
    //   178: invokevirtual 117	java/util/zip/ZipOutputStream:close	()V
    //   181: aload 4
    //   183: ifnull +8 -> 191
    //   186: aload 4
    //   188: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   191: return
    //   192: aload 6
    //   194: invokevirtual 121	java/util/zip/ZipOutputStream:flush	()V
    //   197: aload 6
    //   199: invokevirtual 124	java/util/zip/ZipOutputStream:closeEntry	()V
    //   202: aload_3
    //   203: ifnull +7 -> 210
    //   206: aload_3
    //   207: invokevirtual 110	java/io/BufferedInputStream:close	()V
    //   210: aload 5
    //   212: ifnull -55 -> 157
    //   215: aload 5
    //   217: invokevirtual 111	java/io/FileInputStream:close	()V
    //   220: goto -63 -> 157
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   228: goto -71 -> 157
    //   231: astore_3
    //   232: aload 4
    //   234: astore_2
    //   235: aload 6
    //   237: astore 4
    //   239: aload_3
    //   240: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   243: aload 4
    //   245: ifnull +8 -> 253
    //   248: aload 4
    //   250: invokevirtual 117	java/util/zip/ZipOutputStream:close	()V
    //   253: aload_2
    //   254: ifnull -63 -> 191
    //   257: aload_2
    //   258: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   261: return
    //   262: astore_2
    //   263: aload_2
    //   264: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   267: return
    //   268: astore_2
    //   269: aload_2
    //   270: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   273: goto -63 -> 210
    //   276: astore_2
    //   277: aload 6
    //   279: astore_3
    //   280: aload_3
    //   281: ifnull +7 -> 288
    //   284: aload_3
    //   285: invokevirtual 117	java/util/zip/ZipOutputStream:close	()V
    //   288: aload 4
    //   290: ifnull +8 -> 298
    //   293: aload 4
    //   295: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   298: aload_2
    //   299: athrow
    //   300: astore_3
    //   301: aload_3
    //   302: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   305: goto -156 -> 149
    //   308: astore_2
    //   309: aload_2
    //   310: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   313: goto -156 -> 157
    //   316: astore_2
    //   317: aconst_null
    //   318: astore_3
    //   319: aconst_null
    //   320: astore 5
    //   322: aload_3
    //   323: ifnull +7 -> 330
    //   326: aload_3
    //   327: invokevirtual 110	java/io/BufferedInputStream:close	()V
    //   330: aload 5
    //   332: ifnull +8 -> 340
    //   335: aload 5
    //   337: invokevirtual 111	java/io/FileInputStream:close	()V
    //   340: aload_2
    //   341: athrow
    //   342: astore_3
    //   343: aload_3
    //   344: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   347: goto -17 -> 330
    //   350: astore_3
    //   351: aload_3
    //   352: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   355: goto -15 -> 340
    //   358: astore_2
    //   359: aload_2
    //   360: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   363: goto -182 -> 181
    //   366: astore_2
    //   367: aload_2
    //   368: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   371: return
    //   372: astore_3
    //   373: aload_3
    //   374: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   377: goto -124 -> 253
    //   380: astore_3
    //   381: aload_3
    //   382: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   385: goto -97 -> 288
    //   388: astore_3
    //   389: aload_3
    //   390: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   393: goto -95 -> 298
    //   396: astore_2
    //   397: aconst_null
    //   398: astore_3
    //   399: aconst_null
    //   400: astore 4
    //   402: goto -122 -> 280
    //   405: astore_2
    //   406: aconst_null
    //   407: astore_3
    //   408: goto -128 -> 280
    //   411: astore 5
    //   413: aload 4
    //   415: astore_3
    //   416: aload_2
    //   417: astore 4
    //   419: aload 5
    //   421: astore_2
    //   422: goto -142 -> 280
    //   425: astore_3
    //   426: aconst_null
    //   427: astore_2
    //   428: aload 5
    //   430: astore 4
    //   432: goto -193 -> 239
    //   435: astore_3
    //   436: aload 4
    //   438: astore_2
    //   439: aload 5
    //   441: astore 4
    //   443: goto -204 -> 239
    //   446: astore_2
    //   447: aconst_null
    //   448: astore_3
    //   449: goto -127 -> 322
    //   452: astore_2
    //   453: goto -131 -> 322
    //   456: astore 7
    //   458: aload_2
    //   459: astore 5
    //   461: aload 7
    //   463: astore_2
    //   464: goto -142 -> 322
    //   467: astore 5
    //   469: aconst_null
    //   470: astore_3
    //   471: goto -335 -> 136
    //   474: astore 7
    //   476: aconst_null
    //   477: astore_3
    //   478: aload 5
    //   480: astore_2
    //   481: aload 7
    //   483: astore 5
    //   485: goto -349 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	ZipHelper
    //   109	12	1	i	int
    //   4	150	2	localObject1	Object
    //   223	2	2	localIOException1	java.io.IOException
    //   234	24	2	localObject2	Object
    //   262	2	2	localIOException2	java.io.IOException
    //   268	2	2	localIOException3	java.io.IOException
    //   276	23	2	localObject3	Object
    //   308	2	2	localIOException4	java.io.IOException
    //   316	25	2	localObject4	Object
    //   358	2	2	localIOException5	java.io.IOException
    //   366	2	2	localIOException6	java.io.IOException
    //   396	1	2	localObject5	Object
    //   405	12	2	localObject6	Object
    //   421	18	2	localObject7	Object
    //   446	1	2	localObject8	Object
    //   452	7	2	localObject9	Object
    //   463	18	2	localObject10	Object
    //   72	135	3	localBufferedInputStream	java.io.BufferedInputStream
    //   231	9	3	localException1	java.lang.Exception
    //   279	6	3	localZipOutputStream1	java.util.zip.ZipOutputStream
    //   300	2	3	localIOException7	java.io.IOException
    //   318	9	3	localObject11	Object
    //   342	2	3	localIOException8	java.io.IOException
    //   350	2	3	localIOException9	java.io.IOException
    //   372	2	3	localIOException10	java.io.IOException
    //   380	2	3	localIOException11	java.io.IOException
    //   388	2	3	localIOException12	java.io.IOException
    //   398	18	3	localObject12	Object
    //   425	1	3	localException2	java.lang.Exception
    //   435	1	3	localException3	java.lang.Exception
    //   448	30	3	localObject13	Object
    //   16	426	4	localObject14	Object
    //   1	335	5	localObject15	Object
    //   411	29	5	localObject16	Object
    //   459	1	5	localObject17	Object
    //   467	12	5	localException4	java.lang.Exception
    //   483	1	5	localObject18	Object
    //   34	244	6	localZipOutputStream2	java.util.zip.ZipOutputStream
    //   41	77	7	arrayOfByte	byte[]
    //   127	6	7	localException5	java.lang.Exception
    //   456	6	7	localObject19	Object
    //   474	8	7	localException6	java.lang.Exception
    //   47	35	8	str	String
    // Exception table:
    //   from	to	target	type
    //   73	99	127	java/lang/Exception
    //   99	110	127	java/lang/Exception
    //   115	124	127	java/lang/Exception
    //   192	202	127	java/lang/Exception
    //   215	220	223	java/io/IOException
    //   36	49	231	java/lang/Exception
    //   145	149	231	java/lang/Exception
    //   153	157	231	java/lang/Exception
    //   157	171	231	java/lang/Exception
    //   206	210	231	java/lang/Exception
    //   215	220	231	java/lang/Exception
    //   224	228	231	java/lang/Exception
    //   269	273	231	java/lang/Exception
    //   301	305	231	java/lang/Exception
    //   309	313	231	java/lang/Exception
    //   326	330	231	java/lang/Exception
    //   335	340	231	java/lang/Exception
    //   340	342	231	java/lang/Exception
    //   343	347	231	java/lang/Exception
    //   351	355	231	java/lang/Exception
    //   257	261	262	java/io/IOException
    //   206	210	268	java/io/IOException
    //   36	49	276	finally
    //   145	149	276	finally
    //   153	157	276	finally
    //   157	171	276	finally
    //   206	210	276	finally
    //   215	220	276	finally
    //   224	228	276	finally
    //   269	273	276	finally
    //   301	305	276	finally
    //   309	313	276	finally
    //   326	330	276	finally
    //   335	340	276	finally
    //   340	342	276	finally
    //   343	347	276	finally
    //   351	355	276	finally
    //   145	149	300	java/io/IOException
    //   153	157	308	java/io/IOException
    //   49	60	316	finally
    //   326	330	342	java/io/IOException
    //   335	340	350	java/io/IOException
    //   176	181	358	java/io/IOException
    //   186	191	366	java/io/IOException
    //   248	253	372	java/io/IOException
    //   284	288	380	java/io/IOException
    //   293	298	388	java/io/IOException
    //   5	18	396	finally
    //   18	36	405	finally
    //   239	243	411	finally
    //   5	18	425	java/lang/Exception
    //   18	36	435	java/lang/Exception
    //   60	73	446	finally
    //   73	99	452	finally
    //   99	110	452	finally
    //   115	124	452	finally
    //   192	202	452	finally
    //   136	141	456	finally
    //   49	60	467	java/lang/Exception
    //   60	73	474	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.ZipHelper
 * JD-Core Version:    0.7.0.1
 */