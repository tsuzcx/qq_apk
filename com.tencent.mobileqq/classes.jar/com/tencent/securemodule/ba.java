package com.tencent.securemodule;

import android.content.Context;
import java.io.File;

public class ba
{
  /* Error */
  private static int a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 12	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 20	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: iconst_m1
    //   17: ireturn
    //   18: aconst_null
    //   19: astore_3
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore_0
    //   25: new 22	java/io/FileInputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 29	java/io/FileInputStream:read	()I
    //   38: pop
    //   39: aload_1
    //   40: iconst_4
    //   41: newarray byte
    //   43: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   46: pop
    //   47: bipush 16
    //   49: newarray byte
    //   51: astore_0
    //   52: aload_1
    //   53: aload_0
    //   54: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   57: bipush 16
    //   59: if_icmpne +83 -> 142
    //   62: new 34	java/io/ByteArrayOutputStream
    //   65: dup
    //   66: invokespecial 37	java/io/ByteArrayOutputStream:<init>	()V
    //   69: astore_3
    //   70: sipush 1024
    //   73: newarray byte
    //   75: astore 4
    //   77: aload_1
    //   78: aload 4
    //   80: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   83: istore_2
    //   84: iload_2
    //   85: iconst_m1
    //   86: if_icmpeq +14 -> 100
    //   89: aload_3
    //   90: aload 4
    //   92: iconst_0
    //   93: iload_2
    //   94: invokevirtual 41	java/io/ByteArrayOutputStream:write	([BII)V
    //   97: goto -20 -> 77
    //   100: aload_3
    //   101: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   104: invokestatic 51	com/tencent/securemodule/az:b	([B)[B
    //   107: astore 4
    //   109: aload_3
    //   110: invokevirtual 54	java/io/ByteArrayOutputStream:close	()V
    //   113: aload 4
    //   115: aload_0
    //   116: invokestatic 60	java/util/Arrays:equals	([B[B)Z
    //   119: ifeq +23 -> 142
    //   122: ldc 62
    //   124: ldc 64
    //   126: invokestatic 69	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   129: aload_1
    //   130: invokevirtual 70	java/io/FileInputStream:close	()V
    //   133: iconst_0
    //   134: ireturn
    //   135: astore_0
    //   136: aload_0
    //   137: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   140: iconst_0
    //   141: ireturn
    //   142: aload_1
    //   143: invokevirtual 70	java/io/FileInputStream:close	()V
    //   146: goto +71 -> 217
    //   149: astore_0
    //   150: goto +70 -> 220
    //   153: astore_3
    //   154: goto +20 -> 174
    //   157: astore_3
    //   158: goto +37 -> 195
    //   161: astore_3
    //   162: aload_0
    //   163: astore_1
    //   164: aload_3
    //   165: astore_0
    //   166: goto +54 -> 220
    //   169: astore_0
    //   170: aload_3
    //   171: astore_1
    //   172: aload_0
    //   173: astore_3
    //   174: aload_1
    //   175: astore_0
    //   176: aload_3
    //   177: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   180: aload_1
    //   181: ifnull +36 -> 217
    //   184: aload_1
    //   185: invokevirtual 70	java/io/FileInputStream:close	()V
    //   188: goto +29 -> 217
    //   191: astore_3
    //   192: aload 4
    //   194: astore_1
    //   195: aload_1
    //   196: astore_0
    //   197: aload_3
    //   198: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   201: aload_1
    //   202: ifnull +15 -> 217
    //   205: aload_1
    //   206: invokevirtual 70	java/io/FileInputStream:close	()V
    //   209: goto +8 -> 217
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   217: bipush 254
    //   219: ireturn
    //   220: aload_1
    //   221: ifnull +15 -> 236
    //   224: aload_1
    //   225: invokevirtual 70	java/io/FileInputStream:close	()V
    //   228: goto +8 -> 236
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   236: goto +5 -> 241
    //   239: aload_0
    //   240: athrow
    //   241: goto -2 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramContext	Context
    //   0	244	1	paramString	String
    //   83	11	2	i	int
    //   19	91	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   153	1	3	localException	java.lang.Exception
    //   157	1	3	localIOException1	java.io.IOException
    //   161	10	3	localObject	Object
    //   173	4	3	localContext	Context
    //   191	7	3	localIOException2	java.io.IOException
    //   21	172	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   129	133	135	java/io/IOException
    //   34	77	149	finally
    //   77	84	149	finally
    //   89	97	149	finally
    //   100	129	149	finally
    //   34	77	153	java/lang/Exception
    //   77	84	153	java/lang/Exception
    //   89	97	153	java/lang/Exception
    //   100	129	153	java/lang/Exception
    //   34	77	157	java/io/IOException
    //   77	84	157	java/io/IOException
    //   89	97	157	java/io/IOException
    //   100	129	157	java/io/IOException
    //   25	34	161	finally
    //   176	180	161	finally
    //   197	201	161	finally
    //   25	34	169	java/lang/Exception
    //   25	34	191	java/io/IOException
    //   142	146	212	java/io/IOException
    //   184	188	212	java/io/IOException
    //   205	209	212	java/io/IOException
    //   224	228	231	java/io/IOException
  }
  
  public static int a(Context paramContext, String paramString, boolean paramBoolean)
  {
    ae localae = new ae(paramContext);
    localae.a(paramContext.getCacheDir().getAbsolutePath());
    localae.b("qqsecure.info");
    localae.a(null);
    while (localae.a(paramString, false) == -7) {}
    paramString = new StringBuilder();
    paramString.append(paramContext.getCacheDir().getAbsolutePath());
    paramString.append("/qqsecure.info");
    paramString = paramString.toString();
    int i = a(paramContext, paramString);
    if (i != 0) {
      return i;
    }
    i = b(paramContext, paramString);
    if (i != 0) {
      return i;
    }
    if (paramBoolean) {
      new Thread(new bb()).start();
    }
    return 0;
  }
  
  /* Error */
  private static int b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 12	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 12
    //   10: aload 12
    //   12: invokevirtual 20	java/io/File:exists	()Z
    //   15: ifne +5 -> 20
    //   18: iconst_m1
    //   19: ireturn
    //   20: aconst_null
    //   21: astore 8
    //   23: aconst_null
    //   24: astore 9
    //   26: aconst_null
    //   27: astore 10
    //   29: aconst_null
    //   30: astore 4
    //   32: aconst_null
    //   33: astore 6
    //   35: aconst_null
    //   36: astore 11
    //   38: aconst_null
    //   39: astore_3
    //   40: aconst_null
    //   41: astore 7
    //   43: new 22	java/io/FileInputStream
    //   46: dup
    //   47: aload 12
    //   49: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: astore_1
    //   53: aload 7
    //   55: astore_3
    //   56: aload 8
    //   58: astore 4
    //   60: aload 9
    //   62: astore 5
    //   64: aload 10
    //   66: astore 6
    //   68: new 105	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   75: astore 11
    //   77: aload 7
    //   79: astore_3
    //   80: aload 8
    //   82: astore 4
    //   84: aload 9
    //   86: astore 5
    //   88: aload 10
    //   90: astore 6
    //   92: aload 11
    //   94: aload_0
    //   95: invokevirtual 135	android/content/Context:getFilesDir	()Ljava/io/File;
    //   98: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   101: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 7
    //   107: astore_3
    //   108: aload 8
    //   110: astore 4
    //   112: aload 9
    //   114: astore 5
    //   116: aload 10
    //   118: astore 6
    //   120: aload 11
    //   122: ldc 137
    //   124: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 7
    //   130: astore_3
    //   131: aload 8
    //   133: astore 4
    //   135: aload 9
    //   137: astore 5
    //   139: aload 10
    //   141: astore 6
    //   143: aload 11
    //   145: ldc 139
    //   147: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 7
    //   153: astore_3
    //   154: aload 8
    //   156: astore 4
    //   158: aload 9
    //   160: astore 5
    //   162: aload 10
    //   164: astore 6
    //   166: aload 11
    //   168: ldc 141
    //   170: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 7
    //   176: astore_3
    //   177: aload 8
    //   179: astore 4
    //   181: aload 9
    //   183: astore 5
    //   185: aload 10
    //   187: astore 6
    //   189: new 12	java/io/File
    //   192: dup
    //   193: aload 11
    //   195: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore_0
    //   202: aload 7
    //   204: astore_3
    //   205: aload 8
    //   207: astore 4
    //   209: aload 9
    //   211: astore 5
    //   213: aload 10
    //   215: astore 6
    //   217: aload_0
    //   218: invokevirtual 20	java/io/File:exists	()Z
    //   221: ifeq +50 -> 271
    //   224: aload 7
    //   226: astore_3
    //   227: aload 8
    //   229: astore 4
    //   231: aload 9
    //   233: astore 5
    //   235: aload 10
    //   237: astore 6
    //   239: aload_0
    //   240: invokevirtual 144	java/io/File:delete	()Z
    //   243: pop
    //   244: aload 7
    //   246: astore_3
    //   247: aload 8
    //   249: astore 4
    //   251: aload 9
    //   253: astore 5
    //   255: aload 10
    //   257: astore 6
    //   259: new 146	java/io/FileOutputStream
    //   262: dup
    //   263: aload_0
    //   264: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   267: astore_0
    //   268: goto +445 -> 713
    //   271: aload 7
    //   273: astore_3
    //   274: aload 8
    //   276: astore 4
    //   278: aload 9
    //   280: astore 5
    //   282: aload 10
    //   284: astore 6
    //   286: aload_0
    //   287: invokevirtual 150	java/io/File:getParentFile	()Ljava/io/File;
    //   290: invokevirtual 153	java/io/File:mkdirs	()Z
    //   293: pop
    //   294: aload 7
    //   296: astore_3
    //   297: aload 8
    //   299: astore 4
    //   301: aload 9
    //   303: astore 5
    //   305: aload 10
    //   307: astore 6
    //   309: aload_0
    //   310: invokevirtual 156	java/io/File:createNewFile	()Z
    //   313: pop
    //   314: aload 7
    //   316: astore_3
    //   317: aload 8
    //   319: astore 4
    //   321: aload 9
    //   323: astore 5
    //   325: aload 10
    //   327: astore 6
    //   329: new 146	java/io/FileOutputStream
    //   332: dup
    //   333: aload_0
    //   334: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   337: astore_0
    //   338: goto +375 -> 713
    //   341: aload_0
    //   342: astore_3
    //   343: aload_0
    //   344: astore 4
    //   346: aload_0
    //   347: astore 5
    //   349: aload_0
    //   350: astore 6
    //   352: aload_1
    //   353: bipush 21
    //   355: newarray byte
    //   357: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   360: pop
    //   361: aload_0
    //   362: astore_3
    //   363: aload_0
    //   364: astore 4
    //   366: aload_0
    //   367: astore 5
    //   369: aload_0
    //   370: astore 6
    //   372: sipush 1024
    //   375: newarray byte
    //   377: astore 7
    //   379: aload_0
    //   380: astore_3
    //   381: aload_0
    //   382: astore 4
    //   384: aload_0
    //   385: astore 5
    //   387: aload_0
    //   388: astore 6
    //   390: aload_1
    //   391: aload 7
    //   393: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   396: istore_2
    //   397: iload_2
    //   398: iconst_m1
    //   399: if_icmpeq +25 -> 424
    //   402: aload_0
    //   403: astore_3
    //   404: aload_0
    //   405: astore 4
    //   407: aload_0
    //   408: astore 5
    //   410: aload_0
    //   411: astore 6
    //   413: aload_0
    //   414: aload 7
    //   416: iconst_0
    //   417: iload_2
    //   418: invokevirtual 157	java/io/FileOutputStream:write	([BII)V
    //   421: goto -42 -> 379
    //   424: aload_1
    //   425: invokevirtual 70	java/io/FileInputStream:close	()V
    //   428: goto +8 -> 436
    //   431: astore_1
    //   432: aload_1
    //   433: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   436: aload_0
    //   437: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   440: goto +8 -> 448
    //   443: astore_0
    //   444: aload_0
    //   445: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   448: aload 12
    //   450: invokevirtual 144	java/io/File:delete	()Z
    //   453: pop
    //   454: iconst_0
    //   455: ireturn
    //   456: astore_0
    //   457: goto +210 -> 667
    //   460: astore 5
    //   462: aload 4
    //   464: astore_3
    //   465: aload_1
    //   466: astore 4
    //   468: goto +37 -> 505
    //   471: astore_0
    //   472: aload 5
    //   474: astore_3
    //   475: aload_1
    //   476: astore 4
    //   478: aload_0
    //   479: astore 5
    //   481: goto +75 -> 556
    //   484: astore 5
    //   486: aload 6
    //   488: astore_3
    //   489: aload_1
    //   490: astore 4
    //   492: goto +115 -> 607
    //   495: astore_0
    //   496: aconst_null
    //   497: astore_1
    //   498: goto +169 -> 667
    //   501: astore 5
    //   503: aconst_null
    //   504: astore_3
    //   505: aload 4
    //   507: astore_1
    //   508: aload_3
    //   509: astore_0
    //   510: aload 5
    //   512: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   515: aload 4
    //   517: ifnull +16 -> 533
    //   520: aload 4
    //   522: invokevirtual 70	java/io/FileInputStream:close	()V
    //   525: goto +8 -> 533
    //   528: astore_0
    //   529: aload_0
    //   530: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   533: aload_3
    //   534: ifnull +117 -> 651
    //   537: aload_3
    //   538: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   541: goto +110 -> 651
    //   544: astore_0
    //   545: goto +102 -> 647
    //   548: astore 5
    //   550: aconst_null
    //   551: astore_3
    //   552: aload 6
    //   554: astore 4
    //   556: aload 4
    //   558: astore_1
    //   559: aload_3
    //   560: astore_0
    //   561: aload 5
    //   563: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   566: aload 4
    //   568: ifnull +16 -> 584
    //   571: aload 4
    //   573: invokevirtual 70	java/io/FileInputStream:close	()V
    //   576: goto +8 -> 584
    //   579: astore_0
    //   580: aload_0
    //   581: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   584: aload_3
    //   585: ifnull +66 -> 651
    //   588: aload_3
    //   589: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   592: goto +59 -> 651
    //   595: astore_0
    //   596: goto +51 -> 647
    //   599: astore 5
    //   601: aconst_null
    //   602: astore_3
    //   603: aload 11
    //   605: astore 4
    //   607: aload 4
    //   609: astore_1
    //   610: aload_3
    //   611: astore_0
    //   612: aload 5
    //   614: invokevirtual 159	java/io/FileNotFoundException:printStackTrace	()V
    //   617: aload 4
    //   619: ifnull +16 -> 635
    //   622: aload 4
    //   624: invokevirtual 70	java/io/FileInputStream:close	()V
    //   627: goto +8 -> 635
    //   630: astore_0
    //   631: aload_0
    //   632: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   635: aload_3
    //   636: ifnull +15 -> 651
    //   639: aload_3
    //   640: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   643: goto +8 -> 651
    //   646: astore_0
    //   647: aload_0
    //   648: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   651: aload 12
    //   653: invokevirtual 144	java/io/File:delete	()Z
    //   656: pop
    //   657: bipush 254
    //   659: ireturn
    //   660: astore 4
    //   662: aload_0
    //   663: astore_3
    //   664: aload 4
    //   666: astore_0
    //   667: aload_1
    //   668: ifnull +15 -> 683
    //   671: aload_1
    //   672: invokevirtual 70	java/io/FileInputStream:close	()V
    //   675: goto +8 -> 683
    //   678: astore_1
    //   679: aload_1
    //   680: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   683: aload_3
    //   684: ifnull +15 -> 699
    //   687: aload_3
    //   688: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   691: goto +8 -> 699
    //   694: astore_1
    //   695: aload_1
    //   696: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   699: aload 12
    //   701: invokevirtual 144	java/io/File:delete	()Z
    //   704: pop
    //   705: goto +5 -> 710
    //   708: aload_0
    //   709: athrow
    //   710: goto -2 -> 708
    //   713: goto -372 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	paramContext	Context
    //   0	716	1	paramString	String
    //   396	22	2	i	int
    //   39	649	3	localObject1	Object
    //   30	593	4	localObject2	Object
    //   660	5	4	localObject3	Object
    //   62	347	5	localObject4	Object
    //   460	13	5	localException1	java.lang.Exception
    //   479	1	5	localContext	Context
    //   484	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   501	10	5	localException2	java.lang.Exception
    //   548	14	5	localIOException	java.io.IOException
    //   599	14	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   33	520	6	localObject5	Object
    //   41	374	7	arrayOfByte	byte[]
    //   21	297	8	localObject6	Object
    //   24	298	9	localObject7	Object
    //   27	299	10	localObject8	Object
    //   36	568	11	localStringBuilder	StringBuilder
    //   8	692	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   424	428	431	java/io/IOException
    //   436	440	443	java/io/IOException
    //   68	77	456	finally
    //   92	105	456	finally
    //   120	128	456	finally
    //   143	151	456	finally
    //   166	174	456	finally
    //   189	202	456	finally
    //   217	224	456	finally
    //   239	244	456	finally
    //   259	268	456	finally
    //   286	294	456	finally
    //   309	314	456	finally
    //   329	338	456	finally
    //   352	361	456	finally
    //   372	379	456	finally
    //   390	397	456	finally
    //   413	421	456	finally
    //   68	77	460	java/lang/Exception
    //   92	105	460	java/lang/Exception
    //   120	128	460	java/lang/Exception
    //   143	151	460	java/lang/Exception
    //   166	174	460	java/lang/Exception
    //   189	202	460	java/lang/Exception
    //   217	224	460	java/lang/Exception
    //   239	244	460	java/lang/Exception
    //   259	268	460	java/lang/Exception
    //   286	294	460	java/lang/Exception
    //   309	314	460	java/lang/Exception
    //   329	338	460	java/lang/Exception
    //   352	361	460	java/lang/Exception
    //   372	379	460	java/lang/Exception
    //   390	397	460	java/lang/Exception
    //   413	421	460	java/lang/Exception
    //   68	77	471	java/io/IOException
    //   92	105	471	java/io/IOException
    //   120	128	471	java/io/IOException
    //   143	151	471	java/io/IOException
    //   166	174	471	java/io/IOException
    //   189	202	471	java/io/IOException
    //   217	224	471	java/io/IOException
    //   239	244	471	java/io/IOException
    //   259	268	471	java/io/IOException
    //   286	294	471	java/io/IOException
    //   309	314	471	java/io/IOException
    //   329	338	471	java/io/IOException
    //   352	361	471	java/io/IOException
    //   372	379	471	java/io/IOException
    //   390	397	471	java/io/IOException
    //   413	421	471	java/io/IOException
    //   68	77	484	java/io/FileNotFoundException
    //   92	105	484	java/io/FileNotFoundException
    //   120	128	484	java/io/FileNotFoundException
    //   143	151	484	java/io/FileNotFoundException
    //   166	174	484	java/io/FileNotFoundException
    //   189	202	484	java/io/FileNotFoundException
    //   217	224	484	java/io/FileNotFoundException
    //   239	244	484	java/io/FileNotFoundException
    //   259	268	484	java/io/FileNotFoundException
    //   286	294	484	java/io/FileNotFoundException
    //   309	314	484	java/io/FileNotFoundException
    //   329	338	484	java/io/FileNotFoundException
    //   352	361	484	java/io/FileNotFoundException
    //   372	379	484	java/io/FileNotFoundException
    //   390	397	484	java/io/FileNotFoundException
    //   413	421	484	java/io/FileNotFoundException
    //   43	53	495	finally
    //   43	53	501	java/lang/Exception
    //   520	525	528	java/io/IOException
    //   537	541	544	java/io/IOException
    //   43	53	548	java/io/IOException
    //   571	576	579	java/io/IOException
    //   588	592	595	java/io/IOException
    //   43	53	599	java/io/FileNotFoundException
    //   622	627	630	java/io/IOException
    //   639	643	646	java/io/IOException
    //   510	515	660	finally
    //   561	566	660	finally
    //   612	617	660	finally
    //   671	675	678	java/io/IOException
    //   687	691	694	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.ba
 * JD-Core Version:    0.7.0.1
 */