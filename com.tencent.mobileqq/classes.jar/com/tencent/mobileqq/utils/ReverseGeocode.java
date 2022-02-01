package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.Proxy;
import android.net.Uri;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.params.HttpParams;

public class ReverseGeocode
{
  private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
  
  private static String a(Context paramContext)
  {
    String str;
    int i;
    if (paramContext == null)
    {
      str = Proxy.getDefaultHost();
      i = Proxy.getDefaultPort();
    }
    else
    {
      if (!AppNetConnInfo.isMobileConn()) {
        break label143;
      }
      str = Proxy.getHost(paramContext);
      int j = Proxy.getPort(paramContext);
      if ((str != null) && (str.trim().length() != 0))
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        str = Proxy.getDefaultHost();
        j = Proxy.getDefaultPort();
        if ((str != null) && (str.trim().length() != 0))
        {
          i = j;
          if (j > 0) {}
        }
        else
        {
          paramContext = b(paramContext);
          str = paramContext.a;
          i = paramContext.b;
        }
      }
    }
    if ((str != null) && (str.trim().length() > 0))
    {
      paramContext = new StringBuilder();
      paramContext.append(str);
      paramContext.append(":");
      paramContext.append(i);
      return paramContext.toString();
    }
    return "";
    label143:
    return null;
  }
  
  /* Error */
  public static String a(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, HttpClient paramHttpClient)
  {
    // Byte code:
    //   0: ldc 83
    //   2: astore 9
    //   4: new 68	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   11: astore 6
    //   13: aload 6
    //   15: ldc 90
    //   17: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 6
    //   23: dload_1
    //   24: invokevirtual 93	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 6
    //   30: ldc 95
    //   32: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 6
    //   38: dload_3
    //   39: invokevirtual 93	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 6
    //   45: ldc 97
    //   47: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 6
    //   53: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore 8
    //   58: new 99	org/apache/http/params/BasicHttpParams
    //   61: dup
    //   62: invokespecial 100	org/apache/http/params/BasicHttpParams:<init>	()V
    //   65: astore 6
    //   67: aload 6
    //   69: ldc2_w 101
    //   72: invokestatic 108	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   75: aload 6
    //   77: new 110	org/apache/http/conn/params/ConnPerRouteBean
    //   80: dup
    //   81: bipush 10
    //   83: invokespecial 113	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   86: invokestatic 117	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   89: aload 6
    //   91: bipush 10
    //   93: invokestatic 121	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   96: aload 6
    //   98: sipush 10000
    //   101: invokestatic 126	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   104: aload 6
    //   106: sipush 20000
    //   109: invokestatic 129	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   112: aload 6
    //   114: iconst_1
    //   115: invokestatic 133	org/apache/http/params/HttpConnectionParams:setTcpNoDelay	(Lorg/apache/http/params/HttpParams;Z)V
    //   118: aload 6
    //   120: sipush 8192
    //   123: invokestatic 136	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   126: aload 6
    //   128: getstatic 142	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   131: invokestatic 148	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   134: aload 6
    //   136: ldc 150
    //   138: invokestatic 154	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   141: new 156	org/apache/http/impl/client/DefaultHttpClient
    //   144: dup
    //   145: aload 6
    //   147: invokespecial 159	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   150: astore 10
    //   152: aload_0
    //   153: aload 10
    //   155: invokestatic 162	com/tencent/mobileqq/utils/ReverseGeocode:a	(Landroid/content/Context;Lorg/apache/http/client/HttpClient;)V
    //   158: aconst_null
    //   159: astore 6
    //   161: aconst_null
    //   162: astore 7
    //   164: new 164	java/io/InputStreamReader
    //   167: dup
    //   168: aload 10
    //   170: new 166	org/apache/http/client/methods/HttpGet
    //   173: dup
    //   174: aload 8
    //   176: invokespecial 169	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   179: invokeinterface 175 2 0
    //   184: invokeinterface 181 1 0
    //   189: invokeinterface 187 1 0
    //   194: invokespecial 190	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   197: astore_0
    //   198: new 192	java/io/BufferedReader
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   206: astore 7
    //   208: ldc 83
    //   210: astore 6
    //   212: aload 7
    //   214: invokevirtual 198	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   217: astore 8
    //   219: aload 8
    //   221: ifnull +42 -> 263
    //   224: new 68	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   231: astore 10
    //   233: aload 10
    //   235: aload 6
    //   237: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 10
    //   243: aload 8
    //   245: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 10
    //   251: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: astore 8
    //   256: aload 8
    //   258: astore 6
    //   260: goto -48 -> 212
    //   263: aload_0
    //   264: invokevirtual 201	java/io/InputStreamReader:close	()V
    //   267: aload 7
    //   269: invokevirtual 202	java/io/BufferedReader:close	()V
    //   272: goto +122 -> 394
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   280: goto +114 -> 394
    //   283: astore 6
    //   285: goto +202 -> 487
    //   288: astore 10
    //   290: aload 6
    //   292: astore 8
    //   294: aload 7
    //   296: astore 6
    //   298: aload 8
    //   300: astore 7
    //   302: aload 10
    //   304: astore 8
    //   306: goto +51 -> 357
    //   309: astore 6
    //   311: aconst_null
    //   312: astore 7
    //   314: goto +173 -> 487
    //   317: astore 6
    //   319: goto +23 -> 342
    //   322: astore 8
    //   324: aconst_null
    //   325: astore 7
    //   327: aload 6
    //   329: astore_0
    //   330: aload 8
    //   332: astore 6
    //   334: goto +153 -> 487
    //   337: astore 6
    //   339: aload 7
    //   341: astore_0
    //   342: aconst_null
    //   343: astore 10
    //   345: ldc 83
    //   347: astore 7
    //   349: aload 6
    //   351: astore 8
    //   353: aload 10
    //   355: astore 6
    //   357: aload 8
    //   359: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   362: aload_0
    //   363: ifnull +10 -> 373
    //   366: aload_0
    //   367: invokevirtual 201	java/io/InputStreamReader:close	()V
    //   370: goto +3 -> 373
    //   373: aload 6
    //   375: ifnull +15 -> 390
    //   378: aload 6
    //   380: invokevirtual 202	java/io/BufferedReader:close	()V
    //   383: goto +7 -> 390
    //   386: aload_0
    //   387: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   390: aload 7
    //   392: astore 6
    //   394: new 207	org/json/JSONObject
    //   397: dup
    //   398: aload 6
    //   400: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   403: ldc 210
    //   405: invokevirtual 214	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   408: astore_0
    //   409: aload_0
    //   410: iconst_0
    //   411: invokevirtual 220	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   414: astore 6
    //   416: aload 9
    //   418: astore_0
    //   419: aload 6
    //   421: ifnull +22 -> 443
    //   424: aload 6
    //   426: ldc 222
    //   428: invokevirtual 226	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   431: astore_0
    //   432: goto +11 -> 443
    //   435: astore_0
    //   436: aload_0
    //   437: invokevirtual 227	org/json/JSONException:printStackTrace	()V
    //   440: aload 9
    //   442: astore_0
    //   443: aload_0
    //   444: ldc 228
    //   446: invokestatic 233	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   449: invokevirtual 237	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   452: istore 5
    //   454: aload_0
    //   455: astore 6
    //   457: iload 5
    //   459: iflt +15 -> 474
    //   462: aload_0
    //   463: iconst_0
    //   464: iload 5
    //   466: invokevirtual 241	java/lang/String:substring	(II)Ljava/lang/String;
    //   469: invokevirtual 51	java/lang/String:trim	()Ljava/lang/String;
    //   472: astore 6
    //   474: aload 6
    //   476: areturn
    //   477: astore 8
    //   479: aload 6
    //   481: astore 7
    //   483: aload 8
    //   485: astore 6
    //   487: aload_0
    //   488: ifnull +10 -> 498
    //   491: aload_0
    //   492: invokevirtual 201	java/io/InputStreamReader:close	()V
    //   495: goto +3 -> 498
    //   498: aload 7
    //   500: ifnull +15 -> 515
    //   503: aload 7
    //   505: invokevirtual 202	java/io/BufferedReader:close	()V
    //   508: goto +7 -> 515
    //   511: aload_0
    //   512: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   515: goto +6 -> 521
    //   518: aload 6
    //   520: athrow
    //   521: goto -3 -> 518
    //   524: astore_0
    //   525: ldc 83
    //   527: areturn
    //   528: astore_0
    //   529: goto -143 -> 386
    //   532: astore_0
    //   533: goto -22 -> 511
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	536	0	paramContext	Context
    //   0	536	1	paramDouble1	double
    //   0	536	3	paramDouble2	double
    //   0	536	5	paramInt	int
    //   0	536	6	paramHttpClient	HttpClient
    //   162	342	7	localObject1	Object
    //   56	249	8	localObject2	Object
    //   322	9	8	localObject3	Object
    //   351	7	8	localHttpClient	HttpClient
    //   477	7	8	localObject4	Object
    //   2	439	9	str	String
    //   150	100	10	localObject5	Object
    //   288	15	10	localIOException	java.io.IOException
    //   343	11	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   263	272	275	java/io/IOException
    //   212	219	283	finally
    //   224	256	283	finally
    //   212	219	288	java/io/IOException
    //   224	256	288	java/io/IOException
    //   198	208	309	finally
    //   198	208	317	java/io/IOException
    //   164	198	322	finally
    //   164	198	337	java/io/IOException
    //   424	432	435	org/json/JSONException
    //   357	362	477	finally
    //   394	409	524	org/json/JSONException
    //   366	370	528	java/io/IOException
    //   378	383	528	java/io/IOException
    //   491	495	532	java/io/IOException
    //   503	508	532	java/io/IOException
  }
  
  public static void a(Context paramContext, HttpClient paramHttpClient)
  {
    paramHttpClient.getParams().removeParameter("http.route.default-proxy");
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      paramContext = paramContext.split(":");
      if ((paramContext != null) && (paramContext.length == 2))
      {
        paramContext = new HttpHost(paramContext[0], Integer.valueOf(paramContext[1]).intValue());
        paramHttpClient.getParams().setParameter("http.route.default-proxy", paramContext);
      }
    }
  }
  
  /* Error */
  private static ReverseGeocode.Proxy b(Context paramContext)
  {
    // Byte code:
    //   0: new 60	com/tencent/mobileqq/utils/ReverseGeocode$Proxy
    //   3: dup
    //   4: invokespecial 280	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: invokevirtual 286	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: getstatic 18	com/tencent/mobileqq/utils/ReverseGeocode:a	Landroid/net/Uri;
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 292	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore_0
    //   28: aload_0
    //   29: astore_1
    //   30: aload_0
    //   31: astore_2
    //   32: aload_0
    //   33: invokeinterface 297 1 0
    //   38: pop
    //   39: aload_0
    //   40: astore_1
    //   41: aload_0
    //   42: astore_2
    //   43: aload_0
    //   44: aload_0
    //   45: ldc_w 299
    //   48: invokeinterface 302 2 0
    //   53: invokeinterface 304 2 0
    //   58: astore 4
    //   60: aload 4
    //   62: astore_3
    //   63: aload 4
    //   65: ifnull +13 -> 78
    //   68: aload_0
    //   69: astore_1
    //   70: aload_0
    //   71: astore_2
    //   72: aload 4
    //   74: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   77: astore_3
    //   78: aload_0
    //   79: astore_1
    //   80: aload_0
    //   81: astore_2
    //   82: aload_0
    //   83: aload_0
    //   84: ldc_w 309
    //   87: invokeinterface 302 2 0
    //   92: invokeinterface 304 2 0
    //   97: astore 7
    //   99: aload_0
    //   100: astore_1
    //   101: aload_0
    //   102: astore_2
    //   103: aload_0
    //   104: aload_0
    //   105: ldc_w 311
    //   108: invokeinterface 302 2 0
    //   113: invokeinterface 304 2 0
    //   118: astore 5
    //   120: aload 5
    //   122: astore 4
    //   124: aload 5
    //   126: ifnull +14 -> 140
    //   129: aload_0
    //   130: astore_1
    //   131: aload_0
    //   132: astore_2
    //   133: aload 5
    //   135: invokevirtual 307	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   138: astore 4
    //   140: aload_0
    //   141: astore_1
    //   142: aload_0
    //   143: astore_2
    //   144: aload_0
    //   145: invokeinterface 312 1 0
    //   150: aload_3
    //   151: ifnull +59 -> 210
    //   154: aload_0
    //   155: astore_1
    //   156: aload_0
    //   157: astore_2
    //   158: aload_3
    //   159: invokevirtual 54	java/lang/String:length	()I
    //   162: ifle +48 -> 210
    //   165: aload_0
    //   166: astore_1
    //   167: aload_0
    //   168: astore_2
    //   169: aload 7
    //   171: invokestatic 267	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   174: invokevirtual 270	java/lang/Integer:intValue	()I
    //   177: ifle +33 -> 210
    //   180: aload_0
    //   181: astore_1
    //   182: aload_0
    //   183: astore_2
    //   184: aload 6
    //   186: aload_3
    //   187: putfield 63	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:a	Ljava/lang/String;
    //   190: aload_0
    //   191: astore_1
    //   192: aload_0
    //   193: astore_2
    //   194: aload 6
    //   196: aload 7
    //   198: invokestatic 267	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   201: invokevirtual 270	java/lang/Integer:intValue	()I
    //   204: putfield 66	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:b	I
    //   207: goto +138 -> 345
    //   210: aload 4
    //   212: ifnull +44 -> 256
    //   215: aload_0
    //   216: astore_1
    //   217: aload_0
    //   218: astore_2
    //   219: aload 4
    //   221: ldc_w 314
    //   224: invokevirtual 317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   227: ifeq +29 -> 256
    //   230: aload_0
    //   231: astore_1
    //   232: aload_0
    //   233: astore_2
    //   234: aload 6
    //   236: ldc_w 319
    //   239: putfield 63	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:a	Ljava/lang/String;
    //   242: aload_0
    //   243: astore_1
    //   244: aload_0
    //   245: astore_2
    //   246: aload 6
    //   248: bipush 80
    //   250: putfield 66	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:b	I
    //   253: goto +92 -> 345
    //   256: aload 4
    //   258: ifnull +44 -> 302
    //   261: aload_0
    //   262: astore_1
    //   263: aload_0
    //   264: astore_2
    //   265: aload 4
    //   267: ldc_w 321
    //   270: invokevirtual 317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   273: ifeq +29 -> 302
    //   276: aload_0
    //   277: astore_1
    //   278: aload_0
    //   279: astore_2
    //   280: aload 6
    //   282: ldc_w 323
    //   285: putfield 63	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:a	Ljava/lang/String;
    //   288: aload_0
    //   289: astore_1
    //   290: aload_0
    //   291: astore_2
    //   292: aload 6
    //   294: bipush 80
    //   296: putfield 66	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:b	I
    //   299: goto +46 -> 345
    //   302: aload 4
    //   304: ifnull +41 -> 345
    //   307: aload_0
    //   308: astore_1
    //   309: aload_0
    //   310: astore_2
    //   311: aload 4
    //   313: ldc_w 325
    //   316: invokevirtual 317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   319: ifeq +26 -> 345
    //   322: aload_0
    //   323: astore_1
    //   324: aload_0
    //   325: astore_2
    //   326: aload 6
    //   328: ldc_w 323
    //   331: putfield 63	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:a	Ljava/lang/String;
    //   334: aload_0
    //   335: astore_1
    //   336: aload_0
    //   337: astore_2
    //   338: aload 6
    //   340: bipush 80
    //   342: putfield 66	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:b	I
    //   345: aload_0
    //   346: ifnull +9 -> 355
    //   349: aload_0
    //   350: invokeinterface 312 1 0
    //   355: aload 6
    //   357: areturn
    //   358: goto +23 -> 381
    //   361: astore_0
    //   362: aload_1
    //   363: astore_2
    //   364: aload_0
    //   365: invokevirtual 326	java/lang/Exception:printStackTrace	()V
    //   368: aload_1
    //   369: ifnull +9 -> 378
    //   372: aload_1
    //   373: invokeinterface 312 1 0
    //   378: aload 6
    //   380: areturn
    //   381: aload_2
    //   382: ifnull +9 -> 391
    //   385: aload_2
    //   386: invokeinterface 312 1 0
    //   391: aload 6
    //   393: areturn
    //   394: astore_0
    //   395: goto -37 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	paramContext	Context
    //   12	361	1	localContext	Context
    //   10	376	2	localObject1	Object
    //   62	125	3	localObject2	Object
    //   58	254	4	localObject3	Object
    //   118	16	5	str1	String
    //   7	385	6	localProxy	ReverseGeocode.Proxy
    //   97	100	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   13	28	361	java/lang/Exception
    //   32	39	361	java/lang/Exception
    //   43	60	361	java/lang/Exception
    //   72	78	361	java/lang/Exception
    //   82	99	361	java/lang/Exception
    //   103	120	361	java/lang/Exception
    //   133	140	361	java/lang/Exception
    //   144	150	361	java/lang/Exception
    //   158	165	361	java/lang/Exception
    //   169	180	361	java/lang/Exception
    //   184	190	361	java/lang/Exception
    //   194	207	361	java/lang/Exception
    //   219	230	361	java/lang/Exception
    //   234	242	361	java/lang/Exception
    //   246	253	361	java/lang/Exception
    //   265	276	361	java/lang/Exception
    //   280	288	361	java/lang/Exception
    //   292	299	361	java/lang/Exception
    //   311	322	361	java/lang/Exception
    //   326	334	361	java/lang/Exception
    //   338	345	361	java/lang/Exception
    //   13	28	394	finally
    //   32	39	394	finally
    //   43	60	394	finally
    //   72	78	394	finally
    //   82	99	394	finally
    //   103	120	394	finally
    //   133	140	394	finally
    //   144	150	394	finally
    //   158	165	394	finally
    //   169	180	394	finally
    //   184	190	394	finally
    //   194	207	394	finally
    //   219	230	394	finally
    //   234	242	394	finally
    //   246	253	394	finally
    //   265	276	394	finally
    //   280	288	394	finally
    //   292	299	394	finally
    //   311	322	394	finally
    //   326	334	394	finally
    //   338	345	394	finally
    //   364	368	394	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ReverseGeocode
 * JD-Core Version:    0.7.0.1
 */