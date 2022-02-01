package cooperation.qzone.statistic.access;

import cooperation.qzone.statistic.access.concept.Deliverer;

public class HttpDeliverer
  extends Deliverer
{
  public static final int DEFAULT_CONNECT_TIMEOUT = 60000;
  public static final int DEFAULT_READ_TIMEOUT = 60000;
  public static final String GET = "GET";
  public static final String GZIP = "gzip";
  public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
  public static final String HEADER_HOST = "Host";
  public static final String HEADER_X_ONLINE_HOST = "X-Online-Host";
  public static final int HTTP_CLIENT_ERROR = 400;
  public static final int HTTP_CODE_ERROR = 4096;
  public static final int HTTP_CONNECT_ERROR = 1024;
  public static final int HTTP_REDIRECT = 300;
  public static final int HTTP_SERVER_ERROR = 500;
  public static final int HTTP_SUCCESS = 200;
  public static final int HTTP_URL_NOT_AVALIBLE = 2048;
  public static final String POST = "POST";
  public static final char PROTOCOL_HOST_SPLITTER = '/';
  public static final char PROTOCOL_PORT_SPLITTER = ':';
  public static final String PROTOCOL_PREFIX = "https://";
  public static final int PROTOCOL_PREFIX_LENGTH = "https://".length();
  public static final String TAG = "Statistic.Deliverer";
  protected boolean gzipEnabled = true;
  protected HttpMultiServer servers = new HttpDeliverer.1(this, "https://wspeed.qq.com/w.cgi", false);
  
  public HttpDeliverer(String paramString)
  {
    setServerURL(paramString);
  }
  
  public static int doRequest(String paramString1, String paramString2, String paramString3, boolean paramBoolean, HttpDeliverer.IProxy paramIProxy, int paramInt1, int paramInt2, String paramString4)
  {
    if (paramString3 == null) {}
    for (paramString3 = null;; paramString3 = paramString3.getBytes()) {
      return doRequest(paramString1, paramString2, paramString3, paramBoolean, paramIProxy, paramInt1, paramInt2, paramString4);
    }
  }
  
  /* Error */
  public static int doRequest(String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, HttpDeliverer.IProxy paramIProxy, int paramInt1, int paramInt2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 14
    //   9: aconst_null
    //   10: astore 11
    //   12: sipush 4096
    //   15: istore 8
    //   17: aload 4
    //   19: ifnull +460 -> 479
    //   22: aload 14
    //   24: astore 9
    //   26: aload_0
    //   27: invokestatic 105	cooperation/qzone/statistic/access/HttpDeliverer:splitUrl	(Ljava/lang/String;)[Ljava/lang/String;
    //   30: astore 10
    //   32: aload 14
    //   34: astore 9
    //   36: new 107	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   43: aload 4
    //   45: invokevirtual 114	cooperation/qzone/statistic/access/HttpDeliverer$IProxy:toString	()Ljava/lang/String;
    //   48: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload 10
    //   53: iconst_1
    //   54: aaload
    //   55: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_0
    //   62: aload 14
    //   64: astore 9
    //   66: aload_0
    //   67: invokevirtual 122	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   70: ldc 47
    //   72: invokevirtual 126	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   75: ifeq +158 -> 233
    //   78: aload 14
    //   80: astore 9
    //   82: new 128	java/net/URL
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 130	java/net/URL:<init>	(Ljava/lang/String;)V
    //   90: invokevirtual 134	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   93: checkcast 136	java/net/HttpURLConnection
    //   96: astore_0
    //   97: aload_0
    //   98: iload 6
    //   100: invokevirtual 140	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   103: aload_0
    //   104: iload 5
    //   106: invokevirtual 143	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   109: aload_0
    //   110: iconst_0
    //   111: invokevirtual 147	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   114: aload_0
    //   115: aload_1
    //   116: invokevirtual 150	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   119: aload_0
    //   120: iconst_1
    //   121: invokevirtual 153	java/net/HttpURLConnection:setDoInput	(Z)V
    //   124: aload 7
    //   126: ifnull +19 -> 145
    //   129: aload 7
    //   131: invokevirtual 63	java/lang/String:length	()I
    //   134: ifle +11 -> 145
    //   137: aload_0
    //   138: ldc 20
    //   140: aload 7
    //   142: invokevirtual 157	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: iload_3
    //   146: ifeq +11 -> 157
    //   149: aload_0
    //   150: ldc 17
    //   152: ldc 14
    //   154: invokevirtual 157	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload 4
    //   159: ifnull +13 -> 172
    //   162: aload_0
    //   163: ldc 23
    //   165: aload 10
    //   167: iconst_0
    //   168: aaload
    //   169: invokevirtual 157	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_2
    //   173: ifnull +121 -> 294
    //   176: aload_0
    //   177: iconst_1
    //   178: invokevirtual 160	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   181: aload_0
    //   182: invokevirtual 164	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   185: astore_1
    //   186: iload_3
    //   187: ifeq +60 -> 247
    //   190: new 166	java/util/zip/GZIPOutputStream
    //   193: dup
    //   194: aload_1
    //   195: invokespecial 169	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   198: astore_1
    //   199: aload_1
    //   200: aload_2
    //   201: invokevirtual 173	java/util/zip/GZIPOutputStream:write	([B)V
    //   204: aload_1
    //   205: invokevirtual 176	java/util/zip/GZIPOutputStream:flush	()V
    //   208: aload_1
    //   209: invokevirtual 179	java/util/zip/GZIPOutputStream:close	()V
    //   212: aload_0
    //   213: invokevirtual 182	java/net/HttpURLConnection:getResponseCode	()I
    //   216: istore 5
    //   218: iload 5
    //   220: istore 6
    //   222: aload_0
    //   223: ifnull +253 -> 476
    //   226: aload_0
    //   227: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   230: iload 5
    //   232: ireturn
    //   233: aload 14
    //   235: astore 9
    //   237: ldc 47
    //   239: aload_0
    //   240: invokevirtual 189	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   243: astore_0
    //   244: goto -166 -> 78
    //   247: aload_1
    //   248: aload_2
    //   249: invokevirtual 192	java/io/OutputStream:write	([B)V
    //   252: aload_1
    //   253: invokevirtual 193	java/io/OutputStream:flush	()V
    //   256: aload_1
    //   257: invokevirtual 194	java/io/OutputStream:close	()V
    //   260: goto -48 -> 212
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual 197	java/net/MalformedURLException:printStackTrace	()V
    //   268: sipush 2048
    //   271: istore 5
    //   273: aload_0
    //   274: ifnull -44 -> 230
    //   277: aload_0
    //   278: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   281: sipush 2048
    //   284: ireturn
    //   285: astore_0
    //   286: aload_0
    //   287: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   290: sipush 2048
    //   293: ireturn
    //   294: aload_0
    //   295: iconst_0
    //   296: invokevirtual 160	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   299: goto -87 -> 212
    //   302: astore_1
    //   303: aload_0
    //   304: astore 9
    //   306: aload_1
    //   307: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   310: sipush 1024
    //   313: istore 5
    //   315: aload_0
    //   316: ifnull -86 -> 230
    //   319: aload_0
    //   320: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   323: sipush 1024
    //   326: ireturn
    //   327: astore_0
    //   328: aload_0
    //   329: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   332: sipush 1024
    //   335: ireturn
    //   336: astore_0
    //   337: aload_0
    //   338: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   341: iload 5
    //   343: ireturn
    //   344: astore_1
    //   345: aload 12
    //   347: astore_0
    //   348: aload_0
    //   349: astore 9
    //   351: aload_1
    //   352: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   355: iload 8
    //   357: istore 6
    //   359: aload_0
    //   360: ifnull +116 -> 476
    //   363: aload_0
    //   364: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   367: sipush 4096
    //   370: ireturn
    //   371: astore_0
    //   372: aload_0
    //   373: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   376: sipush 4096
    //   379: ireturn
    //   380: astore_1
    //   381: aload 13
    //   383: astore_0
    //   384: aload_0
    //   385: astore 9
    //   387: aload_1
    //   388: invokevirtual 200	java/lang/Error:printStackTrace	()V
    //   391: iload 8
    //   393: istore 6
    //   395: aload_0
    //   396: ifnull +80 -> 476
    //   399: aload_0
    //   400: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   403: sipush 4096
    //   406: ireturn
    //   407: astore_0
    //   408: aload_0
    //   409: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   412: sipush 4096
    //   415: ireturn
    //   416: astore_0
    //   417: aload 9
    //   419: ifnull +8 -> 427
    //   422: aload 9
    //   424: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   427: aload_0
    //   428: athrow
    //   429: astore_1
    //   430: aload_1
    //   431: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   434: goto -7 -> 427
    //   437: astore_1
    //   438: aload_0
    //   439: astore 9
    //   441: aload_1
    //   442: astore_0
    //   443: goto -26 -> 417
    //   446: astore_1
    //   447: aload_0
    //   448: astore 9
    //   450: aload_1
    //   451: astore_0
    //   452: goto -35 -> 417
    //   455: astore_1
    //   456: goto -72 -> 384
    //   459: astore_1
    //   460: goto -112 -> 348
    //   463: astore_1
    //   464: aload 11
    //   466: astore_0
    //   467: goto -164 -> 303
    //   470: astore_1
    //   471: aconst_null
    //   472: astore_0
    //   473: goto -209 -> 264
    //   476: iload 6
    //   478: ireturn
    //   479: aconst_null
    //   480: astore 10
    //   482: goto -420 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	paramString1	String
    //   0	485	1	paramString2	String
    //   0	485	2	paramArrayOfByte	byte[]
    //   0	485	3	paramBoolean	boolean
    //   0	485	4	paramIProxy	HttpDeliverer.IProxy
    //   0	485	5	paramInt1	int
    //   0	485	6	paramInt2	int
    //   0	485	7	paramString3	String
    //   15	377	8	i	int
    //   24	425	9	localObject1	java.lang.Object
    //   30	451	10	arrayOfString	String[]
    //   10	455	11	localObject2	java.lang.Object
    //   1	345	12	localObject3	java.lang.Object
    //   4	378	13	localObject4	java.lang.Object
    //   7	227	14	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   97	124	263	java/net/MalformedURLException
    //   129	145	263	java/net/MalformedURLException
    //   149	157	263	java/net/MalformedURLException
    //   162	172	263	java/net/MalformedURLException
    //   176	186	263	java/net/MalformedURLException
    //   190	212	263	java/net/MalformedURLException
    //   212	218	263	java/net/MalformedURLException
    //   247	260	263	java/net/MalformedURLException
    //   294	299	263	java/net/MalformedURLException
    //   277	281	285	java/lang/Exception
    //   97	124	302	java/io/IOException
    //   129	145	302	java/io/IOException
    //   149	157	302	java/io/IOException
    //   162	172	302	java/io/IOException
    //   176	186	302	java/io/IOException
    //   190	212	302	java/io/IOException
    //   212	218	302	java/io/IOException
    //   247	260	302	java/io/IOException
    //   294	299	302	java/io/IOException
    //   319	323	327	java/lang/Exception
    //   226	230	336	java/lang/Exception
    //   26	32	344	java/lang/Exception
    //   36	62	344	java/lang/Exception
    //   66	78	344	java/lang/Exception
    //   82	97	344	java/lang/Exception
    //   237	244	344	java/lang/Exception
    //   363	367	371	java/lang/Exception
    //   26	32	380	java/lang/Error
    //   36	62	380	java/lang/Error
    //   66	78	380	java/lang/Error
    //   82	97	380	java/lang/Error
    //   237	244	380	java/lang/Error
    //   399	403	407	java/lang/Exception
    //   26	32	416	finally
    //   36	62	416	finally
    //   66	78	416	finally
    //   82	97	416	finally
    //   237	244	416	finally
    //   306	310	416	finally
    //   351	355	416	finally
    //   387	391	416	finally
    //   422	427	429	java/lang/Exception
    //   97	124	437	finally
    //   129	145	437	finally
    //   149	157	437	finally
    //   162	172	437	finally
    //   176	186	437	finally
    //   190	212	437	finally
    //   212	218	437	finally
    //   247	260	437	finally
    //   294	299	437	finally
    //   264	268	446	finally
    //   97	124	455	java/lang/Error
    //   129	145	455	java/lang/Error
    //   149	157	455	java/lang/Error
    //   162	172	455	java/lang/Error
    //   176	186	455	java/lang/Error
    //   190	212	455	java/lang/Error
    //   212	218	455	java/lang/Error
    //   247	260	455	java/lang/Error
    //   294	299	455	java/lang/Error
    //   97	124	459	java/lang/Exception
    //   129	145	459	java/lang/Exception
    //   149	157	459	java/lang/Exception
    //   162	172	459	java/lang/Exception
    //   176	186	459	java/lang/Exception
    //   190	212	459	java/lang/Exception
    //   212	218	459	java/lang/Exception
    //   247	260	459	java/lang/Exception
    //   294	299	459	java/lang/Exception
    //   26	32	463	java/io/IOException
    //   36	62	463	java/io/IOException
    //   66	78	463	java/io/IOException
    //   82	97	463	java/io/IOException
    //   237	244	463	java/io/IOException
    //   26	32	470	java/net/MalformedURLException
    //   36	62	470	java/net/MalformedURLException
    //   66	78	470	java/net/MalformedURLException
    //   82	97	470	java/net/MalformedURLException
    //   237	244	470	java/net/MalformedURLException
  }
  
  public static String[] splitUrl(String paramString)
  {
    String[] arrayOfString = new String[2];
    if ((paramString == null) || (paramString.length() < PROTOCOL_PREFIX_LENGTH)) {
      return arrayOfString;
    }
    if (paramString.toLowerCase().startsWith("https://"))
    {
      int j = paramString.indexOf('/', PROTOCOL_PREFIX_LENGTH);
      int i = j;
      if (j <= PROTOCOL_PREFIX_LENGTH) {
        i = paramString.length();
      }
      arrayOfString[0] = paramString.substring(PROTOCOL_PREFIX_LENGTH, i);
      if (i >= paramString.length()) {
        break label100;
      }
      arrayOfString[1] = paramString.substring(i, paramString.length());
    }
    for (;;)
    {
      return arrayOfString;
      paramString = "https://".concat(paramString);
      break;
      label100:
      arrayOfString[1] = "";
    }
  }
  
  public int deliver(String paramString, int paramInt)
  {
    int i;
    if (paramInt < 1)
    {
      i = -1;
      return i;
    }
    String str2 = getServers().getDefaultServer();
    String str1;
    if (paramInt == 1)
    {
      str1 = "GET";
      label27:
      i = doRequest(str2, str1, paramString, this.gzipEnabled, getProxy(), 60000, 60000, null);
      if (i == 200) {
        break label132;
      }
      str2 = getServers().getOptionalServer();
      if (str2 == null) {
        break label132;
      }
      if (paramInt != 1) {
        break label125;
      }
      str1 = "GET";
    }
    label79:
    for (paramInt = doRequest(str2, str1, paramString, this.gzipEnabled, getProxy(), 60000, 60000, getServers().getOptionalRedirectHost());; paramInt = i)
    {
      i = paramInt;
      if (paramInt != 200) {
        break;
      }
      return 0;
      str1 = "POST";
      break label27;
      label125:
      str1 = "POST";
      break label79;
    }
  }
  
  public HttpDeliverer.IProxy getProxy()
  {
    return null;
  }
  
  public HttpMultiServer getServers()
  {
    return this.servers;
  }
  
  public void setGZipEnabled(boolean paramBoolean)
  {
    this.gzipEnabled = paramBoolean;
  }
  
  public void setServerURL(String paramString)
  {
    getServers().setDefaultServer(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.statistic.access.HttpDeliverer
 * JD-Core Version:    0.7.0.1
 */