package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import java.util.List;
import java.util.Map;

public class BasicNetwork
  implements Network
{
  private static final int MAX_MANUAL_REDIRECTS = 5;
  private final HttpDataSource.Factory mHttpDataSrcFactory;
  
  public BasicNetwork(HttpDataSource.Factory paramFactory)
  {
    this.mHttpDataSrcFactory = paramFactory;
  }
  
  private static String getRedirectUrl(HttpDataSource.InvalidResponseCodeException paramInvalidResponseCodeException)
  {
    paramInvalidResponseCodeException = paramInvalidResponseCodeException.headerFields;
    if (paramInvalidResponseCodeException != null)
    {
      paramInvalidResponseCodeException = (List)paramInvalidResponseCodeException.get("Location");
      if ((paramInvalidResponseCodeException != null) && (!paramInvalidResponseCodeException.isEmpty())) {
        return (String)paramInvalidResponseCodeException.get(0);
      }
    }
    return null;
  }
  
  /* Error */
  public Response performRequest(Request paramRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/BasicNetwork:mHttpDataSrcFactory	Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$Factory;
    //   4: aload_1
    //   5: invokevirtual 54	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getTimeoutMs	()I
    //   8: invokeinterface 60 2 0
    //   13: astore 6
    //   15: aload_1
    //   16: invokevirtual 64	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getHeaders	()Ljava/util/Map;
    //   19: ifnull +71 -> 90
    //   22: aload_1
    //   23: invokevirtual 64	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getHeaders	()Ljava/util/Map;
    //   26: invokeinterface 68 1 0
    //   31: invokeinterface 74 1 0
    //   36: astore 5
    //   38: aload 5
    //   40: invokeinterface 79 1 0
    //   45: ifeq +45 -> 90
    //   48: aload 5
    //   50: invokeinterface 83 1 0
    //   55: checkcast 85	java/util/Map$Entry
    //   58: astore 7
    //   60: aload 6
    //   62: aload 7
    //   64: invokeinterface 88 1 0
    //   69: checkcast 46	java/lang/String
    //   72: aload 7
    //   74: invokeinterface 91 1 0
    //   79: checkcast 46	java/lang/String
    //   82: invokeinterface 97 3 0
    //   87: goto -49 -> 38
    //   90: aload_1
    //   91: invokevirtual 101	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getUrl	()Ljava/lang/String;
    //   94: astore 5
    //   96: iconst_0
    //   97: istore_3
    //   98: new 103	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSourceInputStream
    //   101: dup
    //   102: aload 6
    //   104: new 105	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec
    //   107: dup
    //   108: aload 5
    //   110: invokestatic 111	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   113: aload_1
    //   114: invokevirtual 114	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getHttpMethod	()I
    //   117: aload_1
    //   118: invokevirtual 118	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getPostBody	()[B
    //   121: lconst_0
    //   122: lconst_0
    //   123: ldc2_w 119
    //   126: aconst_null
    //   127: iconst_1
    //   128: invokespecial 123	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec:<init>	(Landroid/net/Uri;I[BJJJLjava/lang/String;I)V
    //   131: invokespecial 126	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSourceInputStream:<init>	(Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSource;Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;)V
    //   134: astore 7
    //   136: aload 7
    //   138: invokestatic 132	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Util:toByteArray	(Ljava/io/InputStream;)[B
    //   141: aload 6
    //   143: invokeinterface 135 1 0
    //   148: invokestatic 141	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Response:success	([BLjava/util/Map;)Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/Response;
    //   151: astore 5
    //   153: aload 7
    //   155: invokestatic 145	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   158: aload 5
    //   160: areturn
    //   161: astore_1
    //   162: goto +65 -> 227
    //   165: astore 8
    //   167: aload 8
    //   169: getfield 148	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   172: sipush 307
    //   175: if_icmpeq +70 -> 245
    //   178: aload 8
    //   180: getfield 148	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   183: sipush 308
    //   186: if_icmpne +54 -> 240
    //   189: goto +56 -> 245
    //   192: iload_3
    //   193: ifeq +13 -> 206
    //   196: aload 8
    //   198: invokestatic 150	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/BasicNetwork:getRedirectUrl	(Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException;)Ljava/lang/String;
    //   201: astore 5
    //   203: goto +6 -> 209
    //   206: aconst_null
    //   207: astore 5
    //   209: aload 5
    //   211: ifnull +13 -> 224
    //   214: aload 7
    //   216: invokestatic 145	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   219: iload_2
    //   220: istore_3
    //   221: goto -123 -> 98
    //   224: aload 8
    //   226: athrow
    //   227: aload 7
    //   229: invokestatic 145	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   232: goto +5 -> 237
    //   235: aload_1
    //   236: athrow
    //   237: goto -2 -> 235
    //   240: iload_3
    //   241: istore_2
    //   242: goto +24 -> 266
    //   245: iload_3
    //   246: iconst_1
    //   247: iadd
    //   248: istore 4
    //   250: iload 4
    //   252: istore_2
    //   253: iload_3
    //   254: iconst_5
    //   255: if_icmpge +11 -> 266
    //   258: iconst_1
    //   259: istore_3
    //   260: iload 4
    //   262: istore_2
    //   263: goto -71 -> 192
    //   266: iconst_0
    //   267: istore_3
    //   268: goto -76 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	BasicNetwork
    //   0	271	1	paramRequest	Request
    //   219	44	2	i	int
    //   97	171	3	j	int
    //   248	13	4	k	int
    //   36	174	5	localObject1	Object
    //   13	129	6	localHttpDataSource	HttpDataSource
    //   58	170	7	localObject2	Object
    //   165	60	8	localInvalidResponseCodeException	HttpDataSource.InvalidResponseCodeException
    // Exception table:
    //   from	to	target	type
    //   136	153	161	finally
    //   167	189	161	finally
    //   196	203	161	finally
    //   224	227	161	finally
    //   136	153	165	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException
  }
  
  /* Error */
  public void performRequest(Request paramRequest, IWriteFuncListener paramIWriteFuncListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/BasicNetwork:mHttpDataSrcFactory	Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$Factory;
    //   4: aload_1
    //   5: invokevirtual 54	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getTimeoutMs	()I
    //   8: invokeinterface 60 2 0
    //   13: astore 13
    //   15: aload_1
    //   16: invokevirtual 64	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getHeaders	()Ljava/util/Map;
    //   19: ifnull +71 -> 90
    //   22: aload_1
    //   23: invokevirtual 64	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getHeaders	()Ljava/util/Map;
    //   26: invokeinterface 68 1 0
    //   31: invokeinterface 74 1 0
    //   36: astore 10
    //   38: aload 10
    //   40: invokeinterface 79 1 0
    //   45: ifeq +45 -> 90
    //   48: aload 10
    //   50: invokeinterface 83 1 0
    //   55: checkcast 85	java/util/Map$Entry
    //   58: astore 11
    //   60: aload 13
    //   62: aload 11
    //   64: invokeinterface 88 1 0
    //   69: checkcast 46	java/lang/String
    //   72: aload 11
    //   74: invokeinterface 91 1 0
    //   79: checkcast 46	java/lang/String
    //   82: invokeinterface 97 3 0
    //   87: goto -49 -> 38
    //   90: aload_1
    //   91: invokevirtual 101	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getUrl	()Ljava/lang/String;
    //   94: astore 10
    //   96: iconst_0
    //   97: istore 6
    //   99: new 103	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSourceInputStream
    //   102: dup
    //   103: aload 13
    //   105: new 105	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec
    //   108: dup
    //   109: aload 10
    //   111: invokestatic 111	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   114: aload_1
    //   115: invokevirtual 114	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getHttpMethod	()I
    //   118: aload_1
    //   119: invokevirtual 118	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Request:getPostBody	()[B
    //   122: lconst_0
    //   123: lconst_0
    //   124: ldc2_w 119
    //   127: aconst_null
    //   128: iconst_1
    //   129: invokespecial 123	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec:<init>	(Landroid/net/Uri;I[BJJJLjava/lang/String;I)V
    //   132: invokespecial 126	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSourceInputStream:<init>	(Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSource;Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;)V
    //   135: astore 12
    //   137: iconst_1
    //   138: istore 8
    //   140: sipush 4096
    //   143: newarray byte
    //   145: astore 10
    //   147: iconst_0
    //   148: istore 4
    //   150: iload 4
    //   152: istore 7
    //   154: iload 4
    //   156: istore_3
    //   157: aload 12
    //   159: aload 10
    //   161: invokevirtual 157	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSourceInputStream:read	([B)I
    //   164: istore 9
    //   166: iload 9
    //   168: iconst_m1
    //   169: if_icmpeq +71 -> 240
    //   172: iload 4
    //   174: istore 5
    //   176: iload 4
    //   178: ifne +30 -> 208
    //   181: aload_2
    //   182: ifnull +246 -> 428
    //   185: iload 4
    //   187: istore 7
    //   189: iload 4
    //   191: istore_3
    //   192: aload_2
    //   193: aload 13
    //   195: invokeinterface 135 1 0
    //   200: invokeinterface 163 2 0
    //   205: goto +223 -> 428
    //   208: iload 5
    //   210: istore 4
    //   212: aload_2
    //   213: ifnull -63 -> 150
    //   216: iload 5
    //   218: istore 7
    //   220: iload 5
    //   222: istore_3
    //   223: aload_2
    //   224: aload 10
    //   226: iload 9
    //   228: invokeinterface 167 3 0
    //   233: iload 5
    //   235: istore 4
    //   237: goto -87 -> 150
    //   240: aload_2
    //   241: ifnull +22 -> 263
    //   244: iload 4
    //   246: ifeq +17 -> 263
    //   249: aload_2
    //   250: invokeinterface 170 1 0
    //   255: goto +8 -> 263
    //   258: astore_1
    //   259: aload_1
    //   260: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   263: aload 12
    //   265: invokestatic 145	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   268: return
    //   269: astore 11
    //   271: iload 7
    //   273: istore 4
    //   275: goto +14 -> 289
    //   278: astore_1
    //   279: iconst_0
    //   280: istore_3
    //   281: goto +112 -> 393
    //   284: astore 11
    //   286: iconst_0
    //   287: istore 4
    //   289: iload 4
    //   291: istore_3
    //   292: aload 11
    //   294: getfield 148	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   297: sipush 307
    //   300: if_icmpeq +134 -> 434
    //   303: iload 4
    //   305: istore_3
    //   306: iload 6
    //   308: istore 5
    //   310: aload 11
    //   312: getfield 148	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   315: sipush 308
    //   318: if_icmpne +139 -> 457
    //   321: goto +113 -> 434
    //   324: iload_3
    //   325: ifeq +16 -> 341
    //   328: iload 4
    //   330: istore_3
    //   331: aload 11
    //   333: invokestatic 150	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/BasicNetwork:getRedirectUrl	(Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException;)Ljava/lang/String;
    //   336: astore 10
    //   338: goto +6 -> 344
    //   341: aconst_null
    //   342: astore 10
    //   344: aload 10
    //   346: ifnull +40 -> 386
    //   349: aload_2
    //   350: ifnull +24 -> 374
    //   353: iload 4
    //   355: ifeq +19 -> 374
    //   358: aload_2
    //   359: invokeinterface 170 1 0
    //   364: goto +10 -> 374
    //   367: astore 11
    //   369: aload 11
    //   371: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   374: aload 12
    //   376: invokestatic 145	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   379: iload 5
    //   381: istore 6
    //   383: goto -284 -> 99
    //   386: iload 4
    //   388: istore_3
    //   389: aload 11
    //   391: athrow
    //   392: astore_1
    //   393: aload_2
    //   394: ifnull +21 -> 415
    //   397: iload_3
    //   398: ifeq +17 -> 415
    //   401: aload_2
    //   402: invokeinterface 170 1 0
    //   407: goto +8 -> 415
    //   410: astore_2
    //   411: aload_2
    //   412: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   415: aload 12
    //   417: invokestatic 145	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   420: goto +5 -> 425
    //   423: aload_1
    //   424: athrow
    //   425: goto -2 -> 423
    //   428: iconst_1
    //   429: istore 5
    //   431: goto -223 -> 208
    //   434: iload 6
    //   436: iconst_1
    //   437: iadd
    //   438: istore_3
    //   439: iload 6
    //   441: iconst_5
    //   442: if_icmpge +12 -> 454
    //   445: iload_3
    //   446: istore 5
    //   448: iload 8
    //   450: istore_3
    //   451: goto -127 -> 324
    //   454: iload_3
    //   455: istore 5
    //   457: iconst_0
    //   458: istore_3
    //   459: goto -135 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	BasicNetwork
    //   0	462	1	paramRequest	Request
    //   0	462	2	paramIWriteFuncListener	IWriteFuncListener
    //   156	303	3	i	int
    //   148	239	4	j	int
    //   174	282	5	k	int
    //   97	346	6	m	int
    //   152	120	7	n	int
    //   138	311	8	i1	int
    //   164	63	9	i2	int
    //   36	309	10	localObject	Object
    //   58	15	11	localEntry	java.util.Map.Entry
    //   269	1	11	localInvalidResponseCodeException1	HttpDataSource.InvalidResponseCodeException
    //   284	48	11	localInvalidResponseCodeException2	HttpDataSource.InvalidResponseCodeException
    //   367	23	11	localException	java.lang.Exception
    //   135	281	12	localDataSourceInputStream	DataSourceInputStream
    //   13	181	13	localHttpDataSource	HttpDataSource
    // Exception table:
    //   from	to	target	type
    //   249	255	258	java/lang/Exception
    //   157	166	269	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException
    //   192	205	269	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException
    //   223	233	269	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException
    //   140	147	278	finally
    //   140	147	284	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$InvalidResponseCodeException
    //   358	364	367	java/lang/Exception
    //   157	166	392	finally
    //   192	205	392	finally
    //   223	233	392	finally
    //   292	303	392	finally
    //   310	321	392	finally
    //   331	338	392	finally
    //   389	392	392	finally
    //   401	407	410	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.BasicNetwork
 * JD-Core Version:    0.7.0.1
 */