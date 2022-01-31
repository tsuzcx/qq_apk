package com.tencent.upload.network.route;

import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class d
{
  private final RouteFactory.ServerCategory a;
  private HashMap<String, RecentRouteSet> b = new HashMap();
  
  public d(RouteFactory.ServerCategory paramServerCategory)
  {
    this.a = paramServerCategory;
    b();
  }
  
  private String a(int paramInt)
  {
    return "upload_recent_route_" + paramInt + "_" + "_v2.0.1";
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: ldc 50
    //   2: ldc 52
    //   4: invokestatic 58	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aconst_null
    //   8: astore_1
    //   9: invokestatic 63	com/tencent/upload/common/a:a	()Landroid/content/Context;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +12 -> 26
    //   17: ldc 50
    //   19: ldc 65
    //   21: invokestatic 68	com/tencent/upload/common/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: invokespecial 70	com/tencent/upload/network/route/d:c	()V
    //   30: new 72	java/io/ObjectOutputStream
    //   33: dup
    //   34: new 74	java/io/BufferedOutputStream
    //   37: dup
    //   38: aload_2
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 21	com/tencent/upload/network/route/d:a	Lcom/tencent/upload/network/route/RouteFactory$ServerCategory;
    //   44: getfield 80	com/tencent/upload/network/route/RouteFactory$ServerCategory:code	I
    //   47: invokespecial 82	com/tencent/upload/network/route/d:a	(I)Ljava/lang/String;
    //   50: iconst_0
    //   51: invokevirtual 88	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   54: invokespecial 91	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: invokespecial 92	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: aload_2
    //   64: aload_0
    //   65: getfield 19	com/tencent/upload/network/route/d:b	Ljava/util/HashMap;
    //   68: invokevirtual 96	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   71: aload_2
    //   72: astore_1
    //   73: aload_0
    //   74: invokespecial 99	com/tencent/upload/network/route/d:d	()V
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 102	java/io/ObjectOutputStream:close	()V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_1
    //   88: ldc 50
    //   90: ldc 104
    //   92: aload_1
    //   93: invokestatic 107	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: goto -11 -> 85
    //   99: astore_3
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_2
    //   103: astore_1
    //   104: ldc 50
    //   106: ldc 109
    //   108: aload_3
    //   109: invokestatic 107	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_2
    //   113: ifnull -28 -> 85
    //   116: aload_2
    //   117: invokevirtual 102	java/io/ObjectOutputStream:close	()V
    //   120: goto -35 -> 85
    //   123: astore_1
    //   124: ldc 50
    //   126: ldc 104
    //   128: aload_1
    //   129: invokestatic 107	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: goto -47 -> 85
    //   135: astore_3
    //   136: aload_1
    //   137: astore_2
    //   138: aload_3
    //   139: astore_1
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 102	java/io/ObjectOutputStream:close	()V
    //   148: aload_1
    //   149: athrow
    //   150: astore_2
    //   151: ldc 50
    //   153: ldc 104
    //   155: aload_2
    //   156: invokestatic 107	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   159: goto -11 -> 148
    //   162: astore_3
    //   163: aload_1
    //   164: astore_2
    //   165: aload_3
    //   166: astore_1
    //   167: goto -27 -> 140
    //   170: astore_3
    //   171: goto -69 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	d
    //   8	65	1	localObject1	Object
    //   87	6	1	localException1	java.lang.Exception
    //   103	1	1	localObject2	Object
    //   123	14	1	localException2	java.lang.Exception
    //   139	28	1	localObject3	Object
    //   12	133	2	localObject4	Object
    //   150	6	2	localException3	java.lang.Exception
    //   164	1	2	localObject5	Object
    //   99	10	3	localException4	java.lang.Exception
    //   135	4	3	localObject6	Object
    //   162	4	3	localObject7	Object
    //   170	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   81	85	87	java/lang/Exception
    //   30	61	99	java/lang/Exception
    //   116	120	123	java/lang/Exception
    //   30	61	135	finally
    //   144	148	150	java/lang/Exception
    //   63	71	162	finally
    //   73	77	162	finally
    //   104	112	162	finally
    //   63	71	170	java/lang/Exception
    //   73	77	170	java/lang/Exception
  }
  
  /* Error */
  private boolean b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 50
    //   4: ldc 113
    //   6: invokestatic 58	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: invokestatic 63	com/tencent/upload/common/a:a	()Landroid/content/Context;
    //   12: astore 9
    //   14: aload 9
    //   16: ifnonnull +12 -> 28
    //   19: ldc 50
    //   21: ldc 115
    //   23: invokestatic 68	com/tencent/upload/common/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: aload 9
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 21	com/tencent/upload/network/route/d:a	Lcom/tencent/upload/network/route/RouteFactory$ServerCategory;
    //   35: getfield 80	com/tencent/upload/network/route/RouteFactory$ServerCategory:code	I
    //   38: invokespecial 82	com/tencent/upload/network/route/d:a	(I)Ljava/lang/String;
    //   41: invokevirtual 119	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: new 121	java/io/BufferedInputStream
    //   50: dup
    //   51: aload_1
    //   52: sipush 8192
    //   55: invokespecial 124	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   58: astore_2
    //   59: new 126	java/io/ObjectInputStream
    //   62: dup
    //   63: aload_2
    //   64: invokespecial 129	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore 5
    //   69: aload_1
    //   70: astore 4
    //   72: aload_2
    //   73: astore 7
    //   75: aload 5
    //   77: astore 8
    //   79: aload 5
    //   81: invokevirtual 133	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   84: astore_3
    //   85: aload_1
    //   86: astore 4
    //   88: aload_2
    //   89: astore 7
    //   91: aload 5
    //   93: astore 8
    //   95: aload_3
    //   96: instanceof 16
    //   99: ifeq +21 -> 120
    //   102: aload_1
    //   103: astore 4
    //   105: aload_2
    //   106: astore 7
    //   108: aload 5
    //   110: astore 8
    //   112: aload_0
    //   113: aload_3
    //   114: checkcast 16	java/util/HashMap
    //   117: putfield 19	com/tencent/upload/network/route/d:b	Ljava/util/HashMap;
    //   120: aload_1
    //   121: astore 4
    //   123: aload_2
    //   124: astore 7
    //   126: aload 5
    //   128: astore 8
    //   130: aload_0
    //   131: getfield 19	com/tencent/upload/network/route/d:b	Ljava/util/HashMap;
    //   134: ifnonnull +80 -> 214
    //   137: aload_1
    //   138: astore 4
    //   140: aload_2
    //   141: astore 7
    //   143: aload 5
    //   145: astore 8
    //   147: aload_0
    //   148: new 16	java/util/HashMap
    //   151: dup
    //   152: invokespecial 17	java/util/HashMap:<init>	()V
    //   155: putfield 19	com/tencent/upload/network/route/d:b	Ljava/util/HashMap;
    //   158: aload 5
    //   160: ifnull +18 -> 178
    //   163: aload_1
    //   164: astore 4
    //   166: aload_2
    //   167: astore 7
    //   169: aload 5
    //   171: astore 8
    //   173: aload 5
    //   175: invokevirtual 134	java/io/ObjectInputStream:close	()V
    //   178: aload 5
    //   180: ifnull +8 -> 188
    //   183: aload 5
    //   185: invokevirtual 134	java/io/ObjectInputStream:close	()V
    //   188: aload_2
    //   189: ifnull +7 -> 196
    //   192: aload_2
    //   193: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 138	java/io/FileInputStream:close	()V
    //   204: iconst_0
    //   205: ireturn
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   211: goto -7 -> 204
    //   214: aload_1
    //   215: astore 4
    //   217: aload_2
    //   218: astore 7
    //   220: aload 5
    //   222: astore 8
    //   224: aload_0
    //   225: invokespecial 99	com/tencent/upload/network/route/d:d	()V
    //   228: aload 5
    //   230: ifnull +8 -> 238
    //   233: aload 5
    //   235: invokevirtual 134	java/io/ObjectInputStream:close	()V
    //   238: aload_2
    //   239: ifnull +7 -> 246
    //   242: aload_2
    //   243: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   246: aload_1
    //   247: ifnull +7 -> 254
    //   250: aload_1
    //   251: invokevirtual 138	java/io/FileInputStream:close	()V
    //   254: iconst_1
    //   255: ireturn
    //   256: astore_1
    //   257: aload_1
    //   258: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   261: goto -7 -> 254
    //   264: astore_2
    //   265: aconst_null
    //   266: astore_2
    //   267: aconst_null
    //   268: astore_3
    //   269: ldc 50
    //   271: new 28	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   278: ldc 143
    //   280: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_0
    //   284: aload_0
    //   285: getfield 21	com/tencent/upload/network/route/d:a	Lcom/tencent/upload/network/route/RouteFactory$ServerCategory;
    //   288: getfield 80	com/tencent/upload/network/route/RouteFactory$ServerCategory:code	I
    //   291: invokespecial 82	com/tencent/upload/network/route/d:a	(I)Ljava/lang/String;
    //   294: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 145	com/tencent/upload/common/b:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload_3
    //   304: ifnull +7 -> 311
    //   307: aload_3
    //   308: invokevirtual 134	java/io/ObjectInputStream:close	()V
    //   311: aload_2
    //   312: ifnull +7 -> 319
    //   315: aload_2
    //   316: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   319: aload_1
    //   320: ifnull +7 -> 327
    //   323: aload_1
    //   324: invokevirtual 138	java/io/FileInputStream:close	()V
    //   327: iconst_0
    //   328: ireturn
    //   329: astore_1
    //   330: aload_1
    //   331: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   334: goto -7 -> 327
    //   337: astore_3
    //   338: aconst_null
    //   339: astore_2
    //   340: aconst_null
    //   341: astore_1
    //   342: aconst_null
    //   343: astore 6
    //   345: aload 6
    //   347: astore 4
    //   349: aload_2
    //   350: astore 7
    //   352: aload_1
    //   353: astore 8
    //   355: ldc 50
    //   357: ldc 147
    //   359: aload_3
    //   360: invokestatic 107	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   363: aload 6
    //   365: astore 4
    //   367: aload_2
    //   368: astore 7
    //   370: aload_1
    //   371: astore 8
    //   373: aload 9
    //   375: aload_0
    //   376: aload_0
    //   377: getfield 21	com/tencent/upload/network/route/d:a	Lcom/tencent/upload/network/route/RouteFactory$ServerCategory;
    //   380: getfield 80	com/tencent/upload/network/route/RouteFactory$ServerCategory:code	I
    //   383: invokespecial 82	com/tencent/upload/network/route/d:a	(I)Ljava/lang/String;
    //   386: invokevirtual 151	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   389: pop
    //   390: aload_1
    //   391: ifnull +7 -> 398
    //   394: aload_1
    //   395: invokevirtual 134	java/io/ObjectInputStream:close	()V
    //   398: aload_2
    //   399: ifnull +7 -> 406
    //   402: aload_2
    //   403: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   406: aload 6
    //   408: ifnull +8 -> 416
    //   411: aload 6
    //   413: invokevirtual 138	java/io/FileInputStream:close	()V
    //   416: iconst_0
    //   417: ireturn
    //   418: astore_3
    //   419: aload 6
    //   421: astore 4
    //   423: aload_2
    //   424: astore 7
    //   426: aload_1
    //   427: astore 8
    //   429: ldc 50
    //   431: ldc 153
    //   433: aload_3
    //   434: invokestatic 107	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   437: goto -47 -> 390
    //   440: astore_3
    //   441: aload 8
    //   443: astore_1
    //   444: aload 7
    //   446: astore_2
    //   447: aload_1
    //   448: ifnull +7 -> 455
    //   451: aload_1
    //   452: invokevirtual 134	java/io/ObjectInputStream:close	()V
    //   455: aload_2
    //   456: ifnull +7 -> 463
    //   459: aload_2
    //   460: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   463: aload 4
    //   465: ifnull +8 -> 473
    //   468: aload 4
    //   470: invokevirtual 138	java/io/FileInputStream:close	()V
    //   473: aload_3
    //   474: athrow
    //   475: astore_1
    //   476: aload_1
    //   477: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   480: goto -64 -> 416
    //   483: astore_1
    //   484: aload_1
    //   485: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   488: goto -15 -> 473
    //   491: astore_3
    //   492: aconst_null
    //   493: astore 4
    //   495: aconst_null
    //   496: astore_2
    //   497: aconst_null
    //   498: astore_1
    //   499: goto -52 -> 447
    //   502: astore_3
    //   503: aconst_null
    //   504: astore_2
    //   505: aconst_null
    //   506: astore 5
    //   508: aload_1
    //   509: astore 4
    //   511: aload 5
    //   513: astore_1
    //   514: goto -67 -> 447
    //   517: astore_3
    //   518: aconst_null
    //   519: astore 5
    //   521: aload_1
    //   522: astore 4
    //   524: aload 5
    //   526: astore_1
    //   527: goto -80 -> 447
    //   530: astore 4
    //   532: aload_3
    //   533: astore 5
    //   535: aload 4
    //   537: astore_3
    //   538: aload_1
    //   539: astore 4
    //   541: aload 5
    //   543: astore_1
    //   544: goto -97 -> 447
    //   547: astore_3
    //   548: aconst_null
    //   549: astore 4
    //   551: aconst_null
    //   552: astore_2
    //   553: aload_1
    //   554: astore 6
    //   556: aload 4
    //   558: astore_1
    //   559: goto -214 -> 345
    //   562: astore_3
    //   563: aconst_null
    //   564: astore 4
    //   566: aload_1
    //   567: astore 6
    //   569: aload 4
    //   571: astore_1
    //   572: goto -227 -> 345
    //   575: astore_3
    //   576: aload_1
    //   577: astore 6
    //   579: aload 5
    //   581: astore_1
    //   582: goto -237 -> 345
    //   585: astore_2
    //   586: aconst_null
    //   587: astore_3
    //   588: aconst_null
    //   589: astore_2
    //   590: goto -321 -> 269
    //   593: astore_3
    //   594: aconst_null
    //   595: astore_3
    //   596: goto -327 -> 269
    //   599: astore_3
    //   600: aload 5
    //   602: astore_3
    //   603: goto -334 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	d
    //   1	200	1	localObject1	Object
    //   206	45	1	localException1	java.lang.Exception
    //   256	68	1	localException2	java.lang.Exception
    //   329	2	1	localException3	java.lang.Exception
    //   341	111	1	localObject2	Object
    //   475	2	1	localException4	java.lang.Exception
    //   483	2	1	localException5	java.lang.Exception
    //   498	84	1	localObject3	Object
    //   44	199	2	localObject4	Object
    //   264	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   266	287	2	localObject5	Object
    //   585	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   589	1	2	localObject6	Object
    //   84	224	3	localObject7	Object
    //   337	23	3	localException6	java.lang.Exception
    //   418	16	3	localException7	java.lang.Exception
    //   440	34	3	localObject8	Object
    //   491	1	3	localObject9	Object
    //   502	1	3	localObject10	Object
    //   517	16	3	localObject11	Object
    //   537	1	3	localObject12	Object
    //   547	1	3	localException8	java.lang.Exception
    //   562	1	3	localException9	java.lang.Exception
    //   575	1	3	localException10	java.lang.Exception
    //   587	1	3	localObject13	Object
    //   593	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   595	1	3	localObject14	Object
    //   599	1	3	localFileNotFoundException4	java.io.FileNotFoundException
    //   602	1	3	localObject15	Object
    //   70	453	4	localObject16	Object
    //   530	6	4	localObject17	Object
    //   539	31	4	localObject18	Object
    //   67	534	5	localObject19	Object
    //   343	235	6	localObject20	Object
    //   73	372	7	localObject21	Object
    //   77	365	8	localObject22	Object
    //   12	362	9	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   183	188	206	java/lang/Exception
    //   192	196	206	java/lang/Exception
    //   200	204	206	java/lang/Exception
    //   233	238	256	java/lang/Exception
    //   242	246	256	java/lang/Exception
    //   250	254	256	java/lang/Exception
    //   28	45	264	java/io/FileNotFoundException
    //   307	311	329	java/lang/Exception
    //   315	319	329	java/lang/Exception
    //   323	327	329	java/lang/Exception
    //   28	45	337	java/lang/Exception
    //   355	363	418	java/lang/Exception
    //   373	390	418	java/lang/Exception
    //   79	85	440	finally
    //   95	102	440	finally
    //   112	120	440	finally
    //   130	137	440	finally
    //   147	158	440	finally
    //   173	178	440	finally
    //   224	228	440	finally
    //   355	363	440	finally
    //   373	390	440	finally
    //   429	437	440	finally
    //   394	398	475	java/lang/Exception
    //   402	406	475	java/lang/Exception
    //   411	416	475	java/lang/Exception
    //   451	455	483	java/lang/Exception
    //   459	463	483	java/lang/Exception
    //   468	473	483	java/lang/Exception
    //   28	45	491	finally
    //   47	59	502	finally
    //   59	69	517	finally
    //   269	303	530	finally
    //   47	59	547	java/lang/Exception
    //   59	69	562	java/lang/Exception
    //   79	85	575	java/lang/Exception
    //   95	102	575	java/lang/Exception
    //   112	120	575	java/lang/Exception
    //   130	137	575	java/lang/Exception
    //   147	158	575	java/lang/Exception
    //   173	178	575	java/lang/Exception
    //   224	228	575	java/lang/Exception
    //   47	59	585	java/io/FileNotFoundException
    //   59	69	593	java/io/FileNotFoundException
    //   79	85	599	java/io/FileNotFoundException
    //   95	102	599	java/io/FileNotFoundException
    //   112	120	599	java/io/FileNotFoundException
    //   130	137	599	java/io/FileNotFoundException
    //   147	158	599	java/io/FileNotFoundException
    //   173	178	599	java/io/FileNotFoundException
    //   224	228	599	java/io/FileNotFoundException
  }
  
  private void c()
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      Object localObject = this.b.keySet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          RecentRouteSet localRecentRouteSet = (RecentRouteSet)this.b.get(str);
          if (localRecentRouteSet != null)
          {
            long l = localRecentRouteSet.getTimeStamp();
            if ((l != 0L) && (System.currentTimeMillis() > l + UploadConfiguration.getRecentRouteExpire()))
            {
              ((Iterator)localObject).remove();
              b.b("RouteSetStorage", "removeExpired key:" + str + " contains:" + this.b.containsKey(str));
            }
          }
        }
      }
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      RecentRouteSet localRecentRouteSet = (RecentRouteSet)this.b.get(str);
      if (localRecentRouteSet != null) {
        b.b("RouteSetStorage", "mRecentRouteSetMap key=" + str + ",value=" + localRecentRouteSet);
      }
    }
  }
  
  public RecentRouteSet a(String paramString)
  {
    return (RecentRouteSet)this.b.get(paramString);
  }
  
  public void a(String paramString, RecentRouteSet paramRecentRouteSet)
  {
    this.b.put(paramString, paramRecentRouteSet);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.route.d
 * JD-Core Version:    0.7.0.1
 */