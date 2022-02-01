package com.tencent.thumbplayer.core.drm.httpclient;

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
    //   1: getfield 18	com/tencent/thumbplayer/core/drm/httpclient/BasicNetwork:mHttpDataSrcFactory	Lcom/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$Factory;
    //   4: aload_1
    //   5: invokevirtual 54	com/tencent/thumbplayer/core/drm/httpclient/Request:getTimeoutMs	()I
    //   8: invokeinterface 60 2 0
    //   13: astore 6
    //   15: aload_1
    //   16: invokevirtual 64	com/tencent/thumbplayer/core/drm/httpclient/Request:getHeaders	()Ljava/util/Map;
    //   19: ifnull +71 -> 90
    //   22: aload_1
    //   23: invokevirtual 64	com/tencent/thumbplayer/core/drm/httpclient/Request:getHeaders	()Ljava/util/Map;
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
    //   91: invokevirtual 101	com/tencent/thumbplayer/core/drm/httpclient/Request:getUrl	()Ljava/lang/String;
    //   94: astore 5
    //   96: iconst_0
    //   97: istore_3
    //   98: new 103	com/tencent/thumbplayer/core/drm/httpclient/DataSourceInputStream
    //   101: dup
    //   102: aload 6
    //   104: new 105	com/tencent/thumbplayer/core/drm/httpclient/DataSpec
    //   107: dup
    //   108: aload 5
    //   110: invokestatic 111	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   113: aload_1
    //   114: invokevirtual 114	com/tencent/thumbplayer/core/drm/httpclient/Request:getHttpMethod	()I
    //   117: aload_1
    //   118: invokevirtual 118	com/tencent/thumbplayer/core/drm/httpclient/Request:getPostBody	()[B
    //   121: lconst_0
    //   122: lconst_0
    //   123: ldc2_w 119
    //   126: aconst_null
    //   127: iconst_1
    //   128: invokespecial 123	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:<init>	(Landroid/net/Uri;I[BJJJLjava/lang/String;I)V
    //   131: invokespecial 126	com/tencent/thumbplayer/core/drm/httpclient/DataSourceInputStream:<init>	(Lcom/tencent/thumbplayer/core/drm/httpclient/DataSource;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   134: astore 7
    //   136: aload 7
    //   138: invokestatic 132	com/tencent/thumbplayer/core/drm/httpclient/Util:toByteArray	(Ljava/io/InputStream;)[B
    //   141: aload 6
    //   143: invokeinterface 135 1 0
    //   148: invokestatic 141	com/tencent/thumbplayer/core/drm/httpclient/Response:success	([BLjava/util/Map;)Lcom/tencent/thumbplayer/core/drm/httpclient/Response;
    //   151: astore 5
    //   153: aload 7
    //   155: invokestatic 145	com/tencent/thumbplayer/core/drm/httpclient/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   158: aload 5
    //   160: areturn
    //   161: astore_1
    //   162: goto +65 -> 227
    //   165: astore 8
    //   167: aload 8
    //   169: getfield 148	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   172: sipush 307
    //   175: if_icmpeq +70 -> 245
    //   178: aload 8
    //   180: getfield 148	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException:responseCode	I
    //   183: sipush 308
    //   186: if_icmpne +54 -> 240
    //   189: goto +56 -> 245
    //   192: iload_3
    //   193: ifeq +13 -> 206
    //   196: aload 8
    //   198: invokestatic 150	com/tencent/thumbplayer/core/drm/httpclient/BasicNetwork:getRedirectUrl	(Lcom/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException;)Ljava/lang/String;
    //   201: astore 5
    //   203: goto +6 -> 209
    //   206: aconst_null
    //   207: astore 5
    //   209: aload 5
    //   211: ifnull +13 -> 224
    //   214: aload 7
    //   216: invokestatic 145	com/tencent/thumbplayer/core/drm/httpclient/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   219: iload_2
    //   220: istore_3
    //   221: goto -123 -> 98
    //   224: aload 8
    //   226: athrow
    //   227: aload 7
    //   229: invokestatic 145	com/tencent/thumbplayer/core/drm/httpclient/Util:closeQuietly	(Ljava/io/Closeable;)V
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
    //   136	153	165	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.BasicNetwork
 * JD-Core Version:    0.7.0.1
 */