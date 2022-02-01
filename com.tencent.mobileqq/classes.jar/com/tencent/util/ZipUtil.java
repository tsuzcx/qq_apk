package com.tencent.util;

public class ZipUtil
{
  /* Error */
  public static void a(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 9
    //   14: new 17	java/io/File
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 20	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 24	java/io/File:listFiles	()[Ljava/io/File;
    //   25: astore 7
    //   27: aload 7
    //   29: ifnull +31 -> 60
    //   32: aload 7
    //   34: arraylength
    //   35: istore 4
    //   37: iconst_0
    //   38: istore_3
    //   39: iload_3
    //   40: iload 4
    //   42: if_icmpge +18 -> 60
    //   45: aload 7
    //   47: iload_3
    //   48: aaload
    //   49: invokevirtual 28	java/io/File:delete	()Z
    //   52: pop
    //   53: iload_3
    //   54: iconst_1
    //   55: iadd
    //   56: istore_3
    //   57: goto -18 -> 39
    //   60: new 30	com/tencent/commonsdk/zip/QZipInputStream
    //   63: dup
    //   64: new 32	java/io/BufferedInputStream
    //   67: dup
    //   68: aload_0
    //   69: invokevirtual 38	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   72: aload_1
    //   73: invokevirtual 44	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   76: invokespecial 47	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   79: invokespecial 48	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   82: astore 7
    //   84: aconst_null
    //   85: astore_0
    //   86: aload 7
    //   88: invokevirtual 52	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +268 -> 361
    //   96: sipush 4096
    //   99: newarray byte
    //   101: astore 8
    //   103: aload_1
    //   104: invokevirtual 58	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +30 -> 139
    //   112: aload_1
    //   113: ldc 60
    //   115: invokevirtual 66	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   118: istore 5
    //   120: iload 5
    //   122: ifeq +17 -> 139
    //   125: aload_0
    //   126: ifnull -40 -> 86
    //   129: aload_0
    //   130: astore 8
    //   132: aload_0
    //   133: invokevirtual 71	java/io/BufferedOutputStream:close	()V
    //   136: goto -50 -> 86
    //   139: new 73	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   146: astore 6
    //   148: aload 6
    //   150: aload_2
    //   151: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 6
    //   157: aload_1
    //   158: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: new 17	java/io/File
    //   165: dup
    //   166: aload 6
    //   168: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokespecial 20	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: astore_1
    //   175: new 17	java/io/File
    //   178: dup
    //   179: aload_1
    //   180: invokevirtual 84	java/io/File:getParent	()Ljava/lang/String;
    //   183: invokespecial 20	java/io/File:<init>	(Ljava/lang/String;)V
    //   186: astore 6
    //   188: aload 6
    //   190: invokevirtual 87	java/io/File:exists	()Z
    //   193: ifne +9 -> 202
    //   196: aload 6
    //   198: invokevirtual 90	java/io/File:mkdirs	()Z
    //   201: pop
    //   202: new 92	java/io/FileOutputStream
    //   205: dup
    //   206: aload_1
    //   207: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   210: astore_1
    //   211: new 68	java/io/BufferedOutputStream
    //   214: dup
    //   215: aload_1
    //   216: sipush 4096
    //   219: invokespecial 98	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   222: astore 6
    //   224: aload 7
    //   226: aload 8
    //   228: iconst_0
    //   229: sipush 4096
    //   232: invokevirtual 102	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   235: istore_3
    //   236: iload_3
    //   237: iconst_m1
    //   238: if_icmpeq +15 -> 253
    //   241: aload 6
    //   243: aload 8
    //   245: iconst_0
    //   246: iload_3
    //   247: invokevirtual 106	java/io/BufferedOutputStream:write	([BII)V
    //   250: goto -26 -> 224
    //   253: aload 6
    //   255: invokevirtual 109	java/io/BufferedOutputStream:flush	()V
    //   258: aload_1
    //   259: invokevirtual 110	java/io/FileOutputStream:flush	()V
    //   262: aload 6
    //   264: invokevirtual 71	java/io/BufferedOutputStream:close	()V
    //   267: aload_1
    //   268: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   271: aload 6
    //   273: astore_0
    //   274: goto -188 -> 86
    //   277: astore_2
    //   278: aload 6
    //   280: astore_0
    //   281: goto +20 -> 301
    //   284: goto +43 -> 327
    //   287: astore_2
    //   288: goto +13 -> 301
    //   291: aload_0
    //   292: astore 6
    //   294: goto +33 -> 327
    //   297: astore_2
    //   298: aload 9
    //   300: astore_1
    //   301: aload_0
    //   302: ifnull +10 -> 312
    //   305: aload_0
    //   306: invokevirtual 71	java/io/BufferedOutputStream:close	()V
    //   309: goto +3 -> 312
    //   312: aload_1
    //   313: ifnull +7 -> 320
    //   316: aload_1
    //   317: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   320: aload_2
    //   321: athrow
    //   322: aconst_null
    //   323: astore_1
    //   324: aload_0
    //   325: astore 6
    //   327: aload 6
    //   329: ifnull +11 -> 340
    //   332: aload 6
    //   334: invokevirtual 71	java/io/BufferedOutputStream:close	()V
    //   337: goto +3 -> 340
    //   340: aload 6
    //   342: astore_0
    //   343: aload_1
    //   344: ifnull -258 -> 86
    //   347: aload 6
    //   349: astore 8
    //   351: aload_1
    //   352: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   355: aload 6
    //   357: astore_0
    //   358: goto -272 -> 86
    //   361: aload 7
    //   363: invokevirtual 112	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   366: return
    //   367: astore_0
    //   368: aload 7
    //   370: astore_1
    //   371: goto +10 -> 381
    //   374: goto +25 -> 399
    //   377: astore_0
    //   378: aload 6
    //   380: astore_1
    //   381: aload_1
    //   382: ifnull +15 -> 397
    //   385: aload_1
    //   386: invokevirtual 112	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   389: goto +8 -> 397
    //   392: astore_1
    //   393: aload_1
    //   394: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   397: aload_0
    //   398: athrow
    //   399: aload 7
    //   401: ifnull +14 -> 415
    //   404: aload 7
    //   406: invokevirtual 112	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   409: return
    //   410: astore_0
    //   411: aload_0
    //   412: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   415: return
    //   416: astore_0
    //   417: aload 8
    //   419: astore 7
    //   421: goto -22 -> 399
    //   424: astore_0
    //   425: goto -51 -> 374
    //   428: astore_1
    //   429: goto -107 -> 322
    //   432: astore_0
    //   433: aload 8
    //   435: astore_0
    //   436: goto -350 -> 86
    //   439: astore 6
    //   441: goto -150 -> 291
    //   444: astore_0
    //   445: goto -161 -> 284
    //   448: astore_0
    //   449: goto -182 -> 267
    //   452: astore_0
    //   453: goto -182 -> 271
    //   456: astore_0
    //   457: goto -145 -> 312
    //   460: astore_0
    //   461: goto -141 -> 320
    //   464: astore_0
    //   465: goto -125 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	paramContext	android.content.Context
    //   0	468	1	paramString1	java.lang.String
    //   0	468	2	paramString2	java.lang.String
    //   38	209	3	i	int
    //   35	8	4	j	int
    //   118	3	5	bool	boolean
    //   6	373	6	localObject1	Object
    //   439	1	6	localException	java.lang.Exception
    //   25	395	7	localObject2	Object
    //   9	425	8	localObject3	Object
    //   12	287	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   224	236	277	finally
    //   241	250	277	finally
    //   253	262	277	finally
    //   211	224	287	finally
    //   96	108	297	finally
    //   112	120	297	finally
    //   139	202	297	finally
    //   202	211	297	finally
    //   86	92	367	finally
    //   132	136	367	finally
    //   262	267	367	finally
    //   267	271	367	finally
    //   305	309	367	finally
    //   316	320	367	finally
    //   320	322	367	finally
    //   332	337	367	finally
    //   351	355	367	finally
    //   14	27	377	finally
    //   32	37	377	finally
    //   45	53	377	finally
    //   60	84	377	finally
    //   385	389	392	java/io/IOException
    //   361	366	410	java/io/IOException
    //   404	409	410	java/io/IOException
    //   14	27	416	java/lang/Exception
    //   32	37	416	java/lang/Exception
    //   45	53	416	java/lang/Exception
    //   60	84	416	java/lang/Exception
    //   86	92	424	java/lang/Exception
    //   132	136	424	java/lang/Exception
    //   262	267	424	java/lang/Exception
    //   267	271	424	java/lang/Exception
    //   305	309	424	java/lang/Exception
    //   316	320	424	java/lang/Exception
    //   320	322	424	java/lang/Exception
    //   332	337	424	java/lang/Exception
    //   351	355	424	java/lang/Exception
    //   96	108	428	java/lang/Exception
    //   112	120	428	java/lang/Exception
    //   139	202	428	java/lang/Exception
    //   202	211	428	java/lang/Exception
    //   132	136	432	java/io/IOException
    //   351	355	432	java/io/IOException
    //   211	224	439	java/lang/Exception
    //   224	236	444	java/lang/Exception
    //   241	250	444	java/lang/Exception
    //   253	262	444	java/lang/Exception
    //   262	267	448	java/io/IOException
    //   267	271	452	java/io/IOException
    //   305	309	456	java/io/IOException
    //   316	320	460	java/io/IOException
    //   332	337	464	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.ZipUtil
 * JD-Core Version:    0.7.0.1
 */