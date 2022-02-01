package org.xwalk.core;

public class XWalkUpdater$HybridUpdateConfig
  extends XWalkUpdater.EmbededUpdateConfig
{
  public XWalkUpdater$HybridUpdateConfig(int paramInt, String paramString1, String paramString2)
  {
    super(paramInt, paramString1, paramString2);
    this.alreadyUnZiped = true;
  }
  
  /* Error */
  public boolean copyPackageToLocal(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 25	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   3: invokevirtual 31	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 5
    //   11: aload 4
    //   13: aload_1
    //   14: invokevirtual 37	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore 4
    //   19: new 39	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   26: astore_1
    //   27: aload_1
    //   28: aload_0
    //   29: invokevirtual 46	org/xwalk/core/XWalkUpdater$HybridUpdateConfig:getDownloadPath	()Ljava/lang/String;
    //   32: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_1
    //   37: ldc 52
    //   39: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 5
    //   49: new 57	java/io/FileOutputStream
    //   52: dup
    //   53: aload 5
    //   55: invokespecial 60	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: ldc 61
    //   61: newarray byte
    //   63: astore 6
    //   65: aload 4
    //   67: aload 6
    //   69: invokevirtual 67	java/io/InputStream:read	([B)I
    //   72: istore_3
    //   73: iload_3
    //   74: iconst_m1
    //   75: if_icmpeq +14 -> 89
    //   78: aload_1
    //   79: aload 6
    //   81: iconst_0
    //   82: iload_3
    //   83: invokevirtual 73	java/io/OutputStream:write	([BII)V
    //   86: goto -21 -> 65
    //   89: aload_1
    //   90: invokevirtual 76	java/io/OutputStream:flush	()V
    //   93: aload 4
    //   95: ifnull +8 -> 103
    //   98: aload 4
    //   100: invokevirtual 79	java/io/InputStream:close	()V
    //   103: aload_1
    //   104: invokevirtual 80	java/io/OutputStream:close	()V
    //   107: new 82	java/io/File
    //   110: dup
    //   111: aload 5
    //   113: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: astore 4
    //   118: aload 4
    //   120: invokevirtual 86	java/io/File:getParent	()Ljava/lang/String;
    //   123: astore_1
    //   124: aload 4
    //   126: invokevirtual 89	java/io/File:getName	()Ljava/lang/String;
    //   129: astore 4
    //   131: new 39	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   138: astore 6
    //   140: aload 6
    //   142: aload 4
    //   144: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 6
    //   150: ldc 91
    //   152: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 6
    //   158: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: astore 4
    //   163: new 39	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   170: astore 6
    //   172: aload 6
    //   174: aload_1
    //   175: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 6
    //   181: getstatic 95	java/io/File:separator	Ljava/lang/String;
    //   184: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 6
    //   190: aload 4
    //   192: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 6
    //   198: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore_1
    //   202: aload_1
    //   203: invokestatic 101	com/tencent/xweb/util/c:b	(Ljava/lang/String;)Z
    //   206: pop
    //   207: aload_1
    //   208: aload 5
    //   210: invokestatic 106	com/tencent/xweb/xwalk/u:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   213: ifne +22 -> 235
    //   216: ldc2_w 107
    //   219: ldc2_w 109
    //   222: lconst_1
    //   223: invokestatic 115	com/tencent/xweb/util/h:a	(JJJ)V
    //   226: ldc 117
    //   228: ldc 119
    //   230: invokestatic 123	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: iconst_0
    //   234: ireturn
    //   235: aload 5
    //   237: invokestatic 101	com/tencent/xweb/util/c:b	(Ljava/lang/String;)Z
    //   240: pop
    //   241: new 39	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   248: astore 4
    //   250: aload 4
    //   252: invokestatic 25	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   255: invokestatic 126	com/tencent/xweb/util/c:a	(Landroid/content/Context;)Ljava/lang/String;
    //   258: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 4
    //   264: getstatic 95	java/io/File:separator	Ljava/lang/String;
    //   267: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 4
    //   273: ldc 128
    //   275: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 4
    //   281: getstatic 95	java/io/File:separator	Ljava/lang/String;
    //   284: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 4
    //   290: ldc 130
    //   292: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: new 82	java/io/File
    //   299: dup
    //   300: aload 4
    //   302: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   308: astore 4
    //   310: new 39	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   317: astore 5
    //   319: aload 5
    //   321: aload_1
    //   322: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 5
    //   328: getstatic 95	java/io/File:separator	Ljava/lang/String;
    //   331: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 5
    //   337: ldc 130
    //   339: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: new 82	java/io/File
    //   346: dup
    //   347: aload 5
    //   349: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   355: astore 5
    //   357: aload 5
    //   359: invokevirtual 134	java/io/File:exists	()Z
    //   362: ifeq +37 -> 399
    //   365: aload 5
    //   367: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   370: aload_2
    //   371: invokestatic 140	com/tencent/xweb/util/d:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   374: ifeq +12 -> 386
    //   377: ldc 142
    //   379: ldc 144
    //   381: invokestatic 123	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: iconst_1
    //   385: ireturn
    //   386: ldc 142
    //   388: ldc 146
    //   390: invokestatic 123	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload 5
    //   395: invokevirtual 149	java/io/File:delete	()Z
    //   398: pop
    //   399: aload 4
    //   401: invokevirtual 134	java/io/File:exists	()Z
    //   404: ifne +22 -> 426
    //   407: ldc2_w 107
    //   410: ldc2_w 150
    //   413: lconst_1
    //   414: invokestatic 115	com/tencent/xweb/util/h:a	(JJJ)V
    //   417: ldc 117
    //   419: ldc 153
    //   421: invokestatic 123	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: iconst_0
    //   425: ireturn
    //   426: aload 4
    //   428: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   431: aload_2
    //   432: invokestatic 140	com/tencent/xweb/util/d:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   435: ifne +25 -> 460
    //   438: ldc 117
    //   440: ldc 155
    //   442: invokestatic 123	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: ldc2_w 107
    //   448: ldc2_w 156
    //   451: lconst_1
    //   452: invokestatic 115	com/tencent/xweb/util/h:a	(JJJ)V
    //   455: aload_0
    //   456: iconst_0
    //   457: putfield 160	org/xwalk/core/XWalkUpdater$HybridUpdateConfig:isMatchMd5	Z
    //   460: aload 4
    //   462: aload 5
    //   464: invokestatic 163	com/tencent/xweb/util/c:a	(Ljava/io/File;Ljava/io/File;)Z
    //   467: ifne +22 -> 489
    //   470: ldc 117
    //   472: ldc 165
    //   474: invokestatic 123	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: ldc2_w 107
    //   480: ldc2_w 166
    //   483: lconst_1
    //   484: invokestatic 115	com/tencent/xweb/util/h:a	(JJJ)V
    //   487: iconst_0
    //   488: ireturn
    //   489: new 82	java/io/File
    //   492: dup
    //   493: aload_1
    //   494: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   497: astore_1
    //   498: aload_1
    //   499: invokevirtual 170	java/io/File:isDirectory	()Z
    //   502: ifne +12 -> 514
    //   505: ldc 117
    //   507: ldc 172
    //   509: invokestatic 123	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: iconst_0
    //   513: ireturn
    //   514: aload_1
    //   515: invokevirtual 176	java/io/File:listFiles	()[Ljava/io/File;
    //   518: aload_0
    //   519: invokevirtual 46	org/xwalk/core/XWalkUpdater$HybridUpdateConfig:getDownloadPath	()Ljava/lang/String;
    //   522: iconst_0
    //   523: invokestatic 179	com/tencent/xweb/xwalk/u:a	([Ljava/io/File;Ljava/lang/String;I)Z
    //   526: ifne +22 -> 548
    //   529: ldc2_w 107
    //   532: ldc2_w 180
    //   535: lconst_1
    //   536: invokestatic 115	com/tencent/xweb/util/h:a	(JJJ)V
    //   539: ldc 117
    //   541: ldc 183
    //   543: invokestatic 123	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: iconst_0
    //   547: ireturn
    //   548: iconst_1
    //   549: ireturn
    //   550: astore_2
    //   551: goto +101 -> 652
    //   554: astore_2
    //   555: goto +12 -> 567
    //   558: astore_2
    //   559: aconst_null
    //   560: astore_1
    //   561: goto +91 -> 652
    //   564: astore_2
    //   565: aconst_null
    //   566: astore_1
    //   567: goto +20 -> 587
    //   570: astore_2
    //   571: aconst_null
    //   572: astore 4
    //   574: aload 4
    //   576: astore_1
    //   577: goto +75 -> 652
    //   580: astore_2
    //   581: aconst_null
    //   582: astore_1
    //   583: aload 5
    //   585: astore 4
    //   587: aload_2
    //   588: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   591: new 39	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   598: astore 5
    //   600: aload 5
    //   602: ldc 188
    //   604: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 5
    //   610: aload_2
    //   611: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   614: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: ldc 142
    //   620: aload 5
    //   622: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 123	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 4
    //   630: ifnull +11 -> 641
    //   633: aload 4
    //   635: invokevirtual 79	java/io/InputStream:close	()V
    //   638: goto +3 -> 641
    //   641: aload_1
    //   642: ifnull +7 -> 649
    //   645: aload_1
    //   646: invokevirtual 80	java/io/OutputStream:close	()V
    //   649: iconst_0
    //   650: ireturn
    //   651: astore_2
    //   652: aload 4
    //   654: ifnull +11 -> 665
    //   657: aload 4
    //   659: invokevirtual 79	java/io/InputStream:close	()V
    //   662: goto +3 -> 665
    //   665: aload_1
    //   666: ifnull +7 -> 673
    //   669: aload_1
    //   670: invokevirtual 80	java/io/OutputStream:close	()V
    //   673: goto +5 -> 678
    //   676: aload_2
    //   677: athrow
    //   678: goto -2 -> 676
    //   681: astore 4
    //   683: goto -580 -> 103
    //   686: astore_1
    //   687: goto -580 -> 107
    //   690: astore_2
    //   691: goto -50 -> 641
    //   694: astore_1
    //   695: iconst_0
    //   696: ireturn
    //   697: astore 4
    //   699: goto -34 -> 665
    //   702: astore_1
    //   703: goto -30 -> 673
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	706	0	this	HybridUpdateConfig
    //   0	706	1	paramString1	String
    //   0	706	2	paramString2	String
    //   72	11	3	i	int
    //   6	652	4	localObject1	java.lang.Object
    //   681	1	4	localException1	java.lang.Exception
    //   697	1	4	localException2	java.lang.Exception
    //   9	612	5	localObject2	java.lang.Object
    //   63	134	6	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   59	65	550	finally
    //   65	73	550	finally
    //   78	86	550	finally
    //   89	93	550	finally
    //   59	65	554	java/lang/Exception
    //   65	73	554	java/lang/Exception
    //   78	86	554	java/lang/Exception
    //   89	93	554	java/lang/Exception
    //   19	59	558	finally
    //   19	59	564	java/lang/Exception
    //   11	19	570	finally
    //   11	19	580	java/lang/Exception
    //   587	628	651	finally
    //   98	103	681	java/lang/Exception
    //   103	107	686	java/io/IOException
    //   633	638	690	java/lang/Exception
    //   645	649	694	java/io/IOException
    //   657	662	697	java/lang/Exception
    //   669	673	702	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.HybridUpdateConfig
 * JD-Core Version:    0.7.0.1
 */