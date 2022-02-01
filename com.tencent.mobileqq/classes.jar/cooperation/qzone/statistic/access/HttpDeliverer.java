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
  public static final int PROTOCOL_PREFIX_LENGTH = 8;
  public static final String TAG = "Statistic.Deliverer";
  protected boolean gzipEnabled = true;
  protected HttpMultiServer servers = new HttpDeliverer.1(this, "https://wspeed.qq.com/w.cgi", false);
  
  public HttpDeliverer(String paramString)
  {
    setServerURL(paramString);
  }
  
  public static int doRequest(String paramString1, String paramString2, String paramString3, boolean paramBoolean, HttpDeliverer.IProxy paramIProxy, int paramInt1, int paramInt2, String paramString4)
  {
    if (paramString3 == null) {
      paramString3 = null;
    } else {
      paramString3 = paramString3.getBytes();
    }
    return doRequest(paramString1, paramString2, paramString3, paramBoolean, paramIProxy, paramInt1, paramInt2, paramString4);
  }
  
  /* Error */
  public static int doRequest(String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, HttpDeliverer.IProxy paramIProxy, int paramInt1, int paramInt2, String paramString3)
  {
    // Byte code:
    //   0: sipush 4096
    //   3: istore 8
    //   5: aconst_null
    //   6: astore 11
    //   8: aconst_null
    //   9: astore 12
    //   11: aconst_null
    //   12: astore 13
    //   14: aconst_null
    //   15: astore 14
    //   17: aconst_null
    //   18: astore 15
    //   20: aload 4
    //   22: ifnull +471 -> 493
    //   25: aload 15
    //   27: astore 9
    //   29: aload_0
    //   30: invokestatic 100	cooperation/qzone/statistic/access/HttpDeliverer:splitUrl	(Ljava/lang/String;)[Ljava/lang/String;
    //   33: astore 10
    //   35: aload 15
    //   37: astore 9
    //   39: new 102	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   46: astore_0
    //   47: aload 15
    //   49: astore 9
    //   51: aload_0
    //   52: aload 4
    //   54: invokevirtual 109	cooperation/qzone/statistic/access/HttpDeliverer$IProxy:toString	()Ljava/lang/String;
    //   57: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 15
    //   63: astore 9
    //   65: aload_0
    //   66: aload 10
    //   68: iconst_1
    //   69: aaload
    //   70: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 15
    //   76: astore 9
    //   78: aload_0
    //   79: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_0
    //   83: goto +3 -> 86
    //   86: aload 15
    //   88: astore 9
    //   90: aload_0
    //   91: invokevirtual 117	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   94: ldc 47
    //   96: invokevirtual 121	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   99: ifeq +6 -> 105
    //   102: goto +14 -> 116
    //   105: aload 15
    //   107: astore 9
    //   109: ldc 47
    //   111: aload_0
    //   112: invokevirtual 125	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_0
    //   116: aload 15
    //   118: astore 9
    //   120: new 127	java/net/URL
    //   123: dup
    //   124: aload_0
    //   125: invokespecial 129	java/net/URL:<init>	(Ljava/lang/String;)V
    //   128: invokevirtual 133	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   131: checkcast 135	java/net/HttpURLConnection
    //   134: astore_0
    //   135: aload_0
    //   136: iload 6
    //   138: invokevirtual 139	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   141: aload_0
    //   142: iload 5
    //   144: invokevirtual 142	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   147: aload_0
    //   148: iconst_0
    //   149: invokevirtual 146	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 149	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: iconst_1
    //   159: invokevirtual 152	java/net/HttpURLConnection:setDoInput	(Z)V
    //   162: aload 7
    //   164: ifnull +19 -> 183
    //   167: aload 7
    //   169: invokevirtual 156	java/lang/String:length	()I
    //   172: ifle +11 -> 183
    //   175: aload_0
    //   176: ldc 20
    //   178: aload 7
    //   180: invokevirtual 160	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: iload_3
    //   184: ifeq +11 -> 195
    //   187: aload_0
    //   188: ldc 17
    //   190: ldc 14
    //   192: invokevirtual 160	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload 4
    //   197: ifnull +13 -> 210
    //   200: aload_0
    //   201: ldc 23
    //   203: aload 10
    //   205: iconst_0
    //   206: aaload
    //   207: invokevirtual 160	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_2
    //   211: ifnull +58 -> 269
    //   214: aload_0
    //   215: iconst_1
    //   216: invokevirtual 163	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   219: aload_0
    //   220: invokevirtual 167	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   223: astore_1
    //   224: iload_3
    //   225: ifeq +28 -> 253
    //   228: new 169	java/util/zip/GZIPOutputStream
    //   231: dup
    //   232: aload_1
    //   233: invokespecial 172	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   236: astore_1
    //   237: aload_1
    //   238: aload_2
    //   239: invokevirtual 176	java/util/zip/GZIPOutputStream:write	([B)V
    //   242: aload_1
    //   243: invokevirtual 179	java/util/zip/GZIPOutputStream:flush	()V
    //   246: aload_1
    //   247: invokevirtual 182	java/util/zip/GZIPOutputStream:close	()V
    //   250: goto +24 -> 274
    //   253: aload_1
    //   254: aload_2
    //   255: invokevirtual 185	java/io/OutputStream:write	([B)V
    //   258: aload_1
    //   259: invokevirtual 186	java/io/OutputStream:flush	()V
    //   262: aload_1
    //   263: invokevirtual 187	java/io/OutputStream:close	()V
    //   266: goto +8 -> 274
    //   269: aload_0
    //   270: iconst_0
    //   271: invokevirtual 163	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   274: aload_0
    //   275: invokevirtual 190	java/net/HttpURLConnection:getResponseCode	()I
    //   278: istore 6
    //   280: iload 6
    //   282: istore 5
    //   284: aload_0
    //   285: ifnull +187 -> 472
    //   288: iload 6
    //   290: istore 5
    //   292: aload_0
    //   293: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   296: iload 6
    //   298: ireturn
    //   299: astore_0
    //   300: aload_0
    //   301: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   304: iload 5
    //   306: ireturn
    //   307: astore_2
    //   308: aload_0
    //   309: astore_1
    //   310: aload_2
    //   311: astore_0
    //   312: goto +163 -> 475
    //   315: astore_1
    //   316: goto +26 -> 342
    //   319: astore_1
    //   320: goto +53 -> 373
    //   323: astore_1
    //   324: goto +80 -> 404
    //   327: astore_1
    //   328: goto +112 -> 440
    //   331: astore_0
    //   332: aload 9
    //   334: astore_1
    //   335: goto +140 -> 475
    //   338: astore_1
    //   339: aload 11
    //   341: astore_0
    //   342: aload_0
    //   343: astore 9
    //   345: aload_1
    //   346: invokevirtual 197	java/lang/Error:printStackTrace	()V
    //   349: iload 8
    //   351: istore 5
    //   353: aload_0
    //   354: ifnull +118 -> 472
    //   357: iload 8
    //   359: istore 5
    //   361: aload_0
    //   362: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   365: sipush 4096
    //   368: ireturn
    //   369: astore_1
    //   370: aload 12
    //   372: astore_0
    //   373: aload_0
    //   374: astore 9
    //   376: aload_1
    //   377: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   380: iload 8
    //   382: istore 5
    //   384: aload_0
    //   385: ifnull +87 -> 472
    //   388: iload 8
    //   390: istore 5
    //   392: aload_0
    //   393: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   396: sipush 4096
    //   399: ireturn
    //   400: astore_1
    //   401: aload 13
    //   403: astore_0
    //   404: aload_0
    //   405: astore 9
    //   407: aload_1
    //   408: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   411: sipush 1024
    //   414: istore 6
    //   416: iload 6
    //   418: istore 5
    //   420: aload_0
    //   421: ifnull +51 -> 472
    //   424: iload 6
    //   426: istore 5
    //   428: aload_0
    //   429: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   432: sipush 1024
    //   435: ireturn
    //   436: astore_1
    //   437: aload 14
    //   439: astore_0
    //   440: aload_0
    //   441: astore 9
    //   443: aload_1
    //   444: invokevirtual 199	java/net/MalformedURLException:printStackTrace	()V
    //   447: sipush 2048
    //   450: istore 6
    //   452: iload 6
    //   454: istore 5
    //   456: aload_0
    //   457: ifnull +15 -> 472
    //   460: iload 6
    //   462: istore 5
    //   464: aload_0
    //   465: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   468: iload 6
    //   470: istore 5
    //   472: iload 5
    //   474: ireturn
    //   475: aload_1
    //   476: ifnull +15 -> 491
    //   479: aload_1
    //   480: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   483: goto +8 -> 491
    //   486: astore_1
    //   487: aload_1
    //   488: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   491: aload_0
    //   492: athrow
    //   493: aconst_null
    //   494: astore 10
    //   496: goto -410 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	paramString1	String
    //   0	499	1	paramString2	String
    //   0	499	2	paramArrayOfByte	byte[]
    //   0	499	3	paramBoolean	boolean
    //   0	499	4	paramIProxy	HttpDeliverer.IProxy
    //   0	499	5	paramInt1	int
    //   0	499	6	paramInt2	int
    //   0	499	7	paramString3	String
    //   3	386	8	i	int
    //   27	415	9	localObject1	java.lang.Object
    //   33	462	10	arrayOfString	String[]
    //   6	334	11	localObject2	java.lang.Object
    //   9	362	12	localObject3	java.lang.Object
    //   12	390	13	localObject4	java.lang.Object
    //   15	423	14	localObject5	java.lang.Object
    //   18	99	15	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   292	296	299	java/lang/Exception
    //   361	365	299	java/lang/Exception
    //   392	396	299	java/lang/Exception
    //   428	432	299	java/lang/Exception
    //   464	468	299	java/lang/Exception
    //   135	162	307	finally
    //   167	183	307	finally
    //   187	195	307	finally
    //   200	210	307	finally
    //   214	224	307	finally
    //   228	250	307	finally
    //   253	266	307	finally
    //   269	274	307	finally
    //   274	280	307	finally
    //   135	162	315	java/lang/Error
    //   167	183	315	java/lang/Error
    //   187	195	315	java/lang/Error
    //   200	210	315	java/lang/Error
    //   214	224	315	java/lang/Error
    //   228	250	315	java/lang/Error
    //   253	266	315	java/lang/Error
    //   269	274	315	java/lang/Error
    //   274	280	315	java/lang/Error
    //   135	162	319	java/lang/Exception
    //   167	183	319	java/lang/Exception
    //   187	195	319	java/lang/Exception
    //   200	210	319	java/lang/Exception
    //   214	224	319	java/lang/Exception
    //   228	250	319	java/lang/Exception
    //   253	266	319	java/lang/Exception
    //   269	274	319	java/lang/Exception
    //   274	280	319	java/lang/Exception
    //   135	162	323	java/io/IOException
    //   167	183	323	java/io/IOException
    //   187	195	323	java/io/IOException
    //   200	210	323	java/io/IOException
    //   214	224	323	java/io/IOException
    //   228	250	323	java/io/IOException
    //   253	266	323	java/io/IOException
    //   269	274	323	java/io/IOException
    //   274	280	323	java/io/IOException
    //   135	162	327	java/net/MalformedURLException
    //   167	183	327	java/net/MalformedURLException
    //   187	195	327	java/net/MalformedURLException
    //   200	210	327	java/net/MalformedURLException
    //   214	224	327	java/net/MalformedURLException
    //   228	250	327	java/net/MalformedURLException
    //   253	266	327	java/net/MalformedURLException
    //   269	274	327	java/net/MalformedURLException
    //   274	280	327	java/net/MalformedURLException
    //   29	35	331	finally
    //   39	47	331	finally
    //   51	61	331	finally
    //   65	74	331	finally
    //   78	83	331	finally
    //   90	102	331	finally
    //   109	116	331	finally
    //   120	135	331	finally
    //   345	349	331	finally
    //   376	380	331	finally
    //   407	411	331	finally
    //   443	447	331	finally
    //   29	35	338	java/lang/Error
    //   39	47	338	java/lang/Error
    //   51	61	338	java/lang/Error
    //   65	74	338	java/lang/Error
    //   78	83	338	java/lang/Error
    //   90	102	338	java/lang/Error
    //   109	116	338	java/lang/Error
    //   120	135	338	java/lang/Error
    //   29	35	369	java/lang/Exception
    //   39	47	369	java/lang/Exception
    //   51	61	369	java/lang/Exception
    //   65	74	369	java/lang/Exception
    //   78	83	369	java/lang/Exception
    //   90	102	369	java/lang/Exception
    //   109	116	369	java/lang/Exception
    //   120	135	369	java/lang/Exception
    //   29	35	400	java/io/IOException
    //   39	47	400	java/io/IOException
    //   51	61	400	java/io/IOException
    //   65	74	400	java/io/IOException
    //   78	83	400	java/io/IOException
    //   90	102	400	java/io/IOException
    //   109	116	400	java/io/IOException
    //   120	135	400	java/io/IOException
    //   29	35	436	java/net/MalformedURLException
    //   39	47	436	java/net/MalformedURLException
    //   51	61	436	java/net/MalformedURLException
    //   65	74	436	java/net/MalformedURLException
    //   78	83	436	java/net/MalformedURLException
    //   90	102	436	java/net/MalformedURLException
    //   109	116	436	java/net/MalformedURLException
    //   120	135	436	java/net/MalformedURLException
    //   479	483	486	java/lang/Exception
  }
  
  public static String[] splitUrl(String paramString)
  {
    String[] arrayOfString = new String[2];
    if (paramString != null)
    {
      if (paramString.length() < PROTOCOL_PREFIX_LENGTH) {
        return arrayOfString;
      }
      if (!paramString.toLowerCase().startsWith("https://")) {
        paramString = "https://".concat(paramString);
      }
      int j = paramString.indexOf('/', PROTOCOL_PREFIX_LENGTH);
      int i = j;
      if (j <= PROTOCOL_PREFIX_LENGTH) {
        i = paramString.length();
      }
      arrayOfString[0] = paramString.substring(PROTOCOL_PREFIX_LENGTH, i);
      if (i < paramString.length())
      {
        arrayOfString[1] = paramString.substring(i, paramString.length());
        return arrayOfString;
      }
      arrayOfString[1] = "";
    }
    return arrayOfString;
  }
  
  public int deliver(String paramString, int paramInt)
  {
    if (paramInt < 1) {
      return -1;
    }
    String str2 = getServers().getDefaultServer();
    String str1;
    if (paramInt == 1) {
      str1 = "GET";
    } else {
      str1 = "POST";
    }
    int j = doRequest(str2, str1, paramString, this.gzipEnabled, getProxy(), 60000, 60000, null);
    int i = j;
    if (j != 200)
    {
      str2 = getServers().getOptionalServer();
      i = j;
      if (str2 != null)
      {
        if (paramInt == 1) {
          str1 = "GET";
        } else {
          str1 = "POST";
        }
        i = doRequest(str2, str1, paramString, this.gzipEnabled, getProxy(), 60000, 60000, getServers().getOptionalRedirectHost());
      }
    }
    paramInt = i;
    if (i == 200) {
      paramInt = 0;
    }
    return paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.statistic.access.HttpDeliverer
 * JD-Core Version:    0.7.0.1
 */