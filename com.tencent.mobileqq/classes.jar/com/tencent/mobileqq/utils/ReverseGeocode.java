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
  
  /* Error */
  private static ReverseGeocode.Proxy a(Context paramContext)
  {
    // Byte code:
    //   0: new 27	com/tencent/mobileqq/utils/ReverseGeocode$Proxy
    //   3: dup
    //   4: invokespecial 28	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: getstatic 18	com/tencent/mobileqq/utils/ReverseGeocode:a	Landroid/net/Uri;
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 40	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore_0
    //   28: aload_0
    //   29: astore_1
    //   30: aload_0
    //   31: astore_2
    //   32: aload_0
    //   33: invokeinterface 46 1 0
    //   38: pop
    //   39: aload_0
    //   40: astore_1
    //   41: aload_0
    //   42: astore_2
    //   43: aload_0
    //   44: aload_0
    //   45: ldc 48
    //   47: invokeinterface 52 2 0
    //   52: invokeinterface 56 2 0
    //   57: astore 4
    //   59: aload 4
    //   61: astore_3
    //   62: aload 4
    //   64: ifnull +13 -> 77
    //   67: aload_0
    //   68: astore_1
    //   69: aload_0
    //   70: astore_2
    //   71: aload 4
    //   73: invokevirtual 62	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   76: astore_3
    //   77: aload_0
    //   78: astore_1
    //   79: aload_0
    //   80: astore_2
    //   81: aload_0
    //   82: aload_0
    //   83: ldc 64
    //   85: invokeinterface 52 2 0
    //   90: invokeinterface 56 2 0
    //   95: astore 7
    //   97: aload_0
    //   98: astore_1
    //   99: aload_0
    //   100: astore_2
    //   101: aload_0
    //   102: aload_0
    //   103: ldc 66
    //   105: invokeinterface 52 2 0
    //   110: invokeinterface 56 2 0
    //   115: astore 5
    //   117: aload 5
    //   119: astore 4
    //   121: aload 5
    //   123: ifnull +14 -> 137
    //   126: aload_0
    //   127: astore_1
    //   128: aload_0
    //   129: astore_2
    //   130: aload 5
    //   132: invokevirtual 62	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   135: astore 4
    //   137: aload_0
    //   138: astore_1
    //   139: aload_0
    //   140: astore_2
    //   141: aload_0
    //   142: invokeinterface 69 1 0
    //   147: aload_3
    //   148: ifnull +59 -> 207
    //   151: aload_0
    //   152: astore_1
    //   153: aload_0
    //   154: astore_2
    //   155: aload_3
    //   156: invokevirtual 73	java/lang/String:length	()I
    //   159: ifle +48 -> 207
    //   162: aload_0
    //   163: astore_1
    //   164: aload_0
    //   165: astore_2
    //   166: aload 7
    //   168: invokestatic 79	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   171: invokevirtual 82	java/lang/Integer:intValue	()I
    //   174: ifle +33 -> 207
    //   177: aload_0
    //   178: astore_1
    //   179: aload_0
    //   180: astore_2
    //   181: aload 6
    //   183: aload_3
    //   184: putfield 85	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: aload_0
    //   188: astore_1
    //   189: aload_0
    //   190: astore_2
    //   191: aload 6
    //   193: aload 7
    //   195: invokestatic 79	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   198: invokevirtual 82	java/lang/Integer:intValue	()I
    //   201: putfield 88	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:jdField_a_of_type_Int	I
    //   204: goto +132 -> 336
    //   207: aload 4
    //   209: ifnull +42 -> 251
    //   212: aload_0
    //   213: astore_1
    //   214: aload_0
    //   215: astore_2
    //   216: aload 4
    //   218: ldc 90
    //   220: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   223: ifeq +28 -> 251
    //   226: aload_0
    //   227: astore_1
    //   228: aload_0
    //   229: astore_2
    //   230: aload 6
    //   232: ldc 96
    //   234: putfield 85	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   237: aload_0
    //   238: astore_1
    //   239: aload_0
    //   240: astore_2
    //   241: aload 6
    //   243: bipush 80
    //   245: putfield 88	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:jdField_a_of_type_Int	I
    //   248: goto +88 -> 336
    //   251: aload 4
    //   253: ifnull +42 -> 295
    //   256: aload_0
    //   257: astore_1
    //   258: aload_0
    //   259: astore_2
    //   260: aload 4
    //   262: ldc 98
    //   264: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   267: ifeq +28 -> 295
    //   270: aload_0
    //   271: astore_1
    //   272: aload_0
    //   273: astore_2
    //   274: aload 6
    //   276: ldc 100
    //   278: putfield 85	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   281: aload_0
    //   282: astore_1
    //   283: aload_0
    //   284: astore_2
    //   285: aload 6
    //   287: bipush 80
    //   289: putfield 88	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:jdField_a_of_type_Int	I
    //   292: goto +44 -> 336
    //   295: aload 4
    //   297: ifnull +39 -> 336
    //   300: aload_0
    //   301: astore_1
    //   302: aload_0
    //   303: astore_2
    //   304: aload 4
    //   306: ldc 102
    //   308: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   311: ifeq +25 -> 336
    //   314: aload_0
    //   315: astore_1
    //   316: aload_0
    //   317: astore_2
    //   318: aload 6
    //   320: ldc 100
    //   322: putfield 85	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   325: aload_0
    //   326: astore_1
    //   327: aload_0
    //   328: astore_2
    //   329: aload 6
    //   331: bipush 80
    //   333: putfield 88	com/tencent/mobileqq/utils/ReverseGeocode$Proxy:jdField_a_of_type_Int	I
    //   336: aload_0
    //   337: ifnull +9 -> 346
    //   340: aload_0
    //   341: invokeinterface 69 1 0
    //   346: aload 6
    //   348: areturn
    //   349: goto +23 -> 372
    //   352: astore_0
    //   353: aload_1
    //   354: astore_2
    //   355: aload_0
    //   356: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   359: aload_1
    //   360: ifnull +9 -> 369
    //   363: aload_1
    //   364: invokeinterface 69 1 0
    //   369: aload 6
    //   371: areturn
    //   372: aload_2
    //   373: ifnull +9 -> 382
    //   376: aload_2
    //   377: invokeinterface 69 1 0
    //   382: aload 6
    //   384: areturn
    //   385: astore_0
    //   386: goto -37 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramContext	Context
    //   12	352	1	localContext	Context
    //   10	367	2	localObject1	Object
    //   61	123	3	localObject2	Object
    //   57	248	4	localObject3	Object
    //   115	16	5	str1	String
    //   7	376	6	localProxy	ReverseGeocode.Proxy
    //   95	99	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   13	28	352	java/lang/Exception
    //   32	39	352	java/lang/Exception
    //   43	59	352	java/lang/Exception
    //   71	77	352	java/lang/Exception
    //   81	97	352	java/lang/Exception
    //   101	117	352	java/lang/Exception
    //   130	137	352	java/lang/Exception
    //   141	147	352	java/lang/Exception
    //   155	162	352	java/lang/Exception
    //   166	177	352	java/lang/Exception
    //   181	187	352	java/lang/Exception
    //   191	204	352	java/lang/Exception
    //   216	226	352	java/lang/Exception
    //   230	237	352	java/lang/Exception
    //   241	248	352	java/lang/Exception
    //   260	270	352	java/lang/Exception
    //   274	281	352	java/lang/Exception
    //   285	292	352	java/lang/Exception
    //   304	314	352	java/lang/Exception
    //   318	325	352	java/lang/Exception
    //   329	336	352	java/lang/Exception
    //   13	28	385	finally
    //   32	39	385	finally
    //   43	59	385	finally
    //   71	77	385	finally
    //   81	97	385	finally
    //   101	117	385	finally
    //   130	137	385	finally
    //   141	147	385	finally
    //   155	162	385	finally
    //   166	177	385	finally
    //   181	187	385	finally
    //   191	204	385	finally
    //   216	226	385	finally
    //   230	237	385	finally
    //   241	248	385	finally
    //   260	270	385	finally
    //   274	281	385	finally
    //   285	292	385	finally
    //   304	314	385	finally
    //   318	325	385	finally
    //   329	336	385	finally
    //   355	359	385	finally
  }
  
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
          paramContext = a(paramContext);
          str = paramContext.jdField_a_of_type_JavaLangString;
          i = paramContext.jdField_a_of_type_Int;
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
    //   0: ldc 148
    //   2: astore 9
    //   4: new 133	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   11: astore 6
    //   13: aload 6
    //   15: ldc 155
    //   17: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 6
    //   23: dload_1
    //   24: invokevirtual 158	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 6
    //   30: ldc 160
    //   32: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 6
    //   38: dload_3
    //   39: invokevirtual 158	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 6
    //   45: ldc 162
    //   47: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 6
    //   53: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore 8
    //   58: new 164	org/apache/http/params/BasicHttpParams
    //   61: dup
    //   62: invokespecial 165	org/apache/http/params/BasicHttpParams:<init>	()V
    //   65: astore 6
    //   67: aload 6
    //   69: ldc2_w 166
    //   72: invokestatic 173	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   75: aload 6
    //   77: new 175	org/apache/http/conn/params/ConnPerRouteBean
    //   80: dup
    //   81: bipush 10
    //   83: invokespecial 178	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   86: invokestatic 182	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   89: aload 6
    //   91: bipush 10
    //   93: invokestatic 186	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   96: aload 6
    //   98: sipush 10000
    //   101: invokestatic 191	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   104: aload 6
    //   106: sipush 20000
    //   109: invokestatic 194	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   112: aload 6
    //   114: iconst_1
    //   115: invokestatic 198	org/apache/http/params/HttpConnectionParams:setTcpNoDelay	(Lorg/apache/http/params/HttpParams;Z)V
    //   118: aload 6
    //   120: sipush 8192
    //   123: invokestatic 201	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   126: aload 6
    //   128: getstatic 207	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   131: invokestatic 213	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   134: aload 6
    //   136: ldc 215
    //   138: invokestatic 219	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   141: new 221	org/apache/http/impl/client/DefaultHttpClient
    //   144: dup
    //   145: aload 6
    //   147: invokespecial 224	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   150: astore 10
    //   152: aload_0
    //   153: aload 10
    //   155: invokestatic 227	com/tencent/mobileqq/utils/ReverseGeocode:a	(Landroid/content/Context;Lorg/apache/http/client/HttpClient;)V
    //   158: aconst_null
    //   159: astore 6
    //   161: aconst_null
    //   162: astore 7
    //   164: new 229	java/io/InputStreamReader
    //   167: dup
    //   168: aload 10
    //   170: new 231	org/apache/http/client/methods/HttpGet
    //   173: dup
    //   174: aload 8
    //   176: invokespecial 234	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   179: invokeinterface 240 2 0
    //   184: invokeinterface 246 1 0
    //   189: invokeinterface 252 1 0
    //   194: invokespecial 255	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   197: astore_0
    //   198: new 257	java/io/BufferedReader
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 260	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   206: astore 7
    //   208: ldc 148
    //   210: astore 6
    //   212: aload 7
    //   214: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   217: astore 8
    //   219: aload 8
    //   221: ifnull +42 -> 263
    //   224: new 133	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   231: astore 10
    //   233: aload 10
    //   235: aload 6
    //   237: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 10
    //   243: aload 8
    //   245: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 10
    //   251: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: astore 8
    //   256: aload 8
    //   258: astore 6
    //   260: goto -48 -> 212
    //   263: aload_0
    //   264: invokevirtual 264	java/io/InputStreamReader:close	()V
    //   267: aload 7
    //   269: invokevirtual 265	java/io/BufferedReader:close	()V
    //   272: goto +122 -> 394
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 266	java/io/IOException:printStackTrace	()V
    //   280: goto +114 -> 394
    //   283: astore 6
    //   285: goto +205 -> 490
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
    //   314: goto +176 -> 490
    //   317: astore 6
    //   319: goto +23 -> 342
    //   322: astore 8
    //   324: aconst_null
    //   325: astore 7
    //   327: aload 6
    //   329: astore_0
    //   330: aload 8
    //   332: astore 6
    //   334: goto +156 -> 490
    //   337: astore 6
    //   339: aload 7
    //   341: astore_0
    //   342: aconst_null
    //   343: astore 10
    //   345: ldc 148
    //   347: astore 7
    //   349: aload 6
    //   351: astore 8
    //   353: aload 10
    //   355: astore 6
    //   357: aload 8
    //   359: invokevirtual 266	java/io/IOException:printStackTrace	()V
    //   362: aload_0
    //   363: ifnull +10 -> 373
    //   366: aload_0
    //   367: invokevirtual 264	java/io/InputStreamReader:close	()V
    //   370: goto +3 -> 373
    //   373: aload 6
    //   375: ifnull +15 -> 390
    //   378: aload 6
    //   380: invokevirtual 265	java/io/BufferedReader:close	()V
    //   383: goto +7 -> 390
    //   386: aload_0
    //   387: invokevirtual 266	java/io/IOException:printStackTrace	()V
    //   390: aload 7
    //   392: astore 6
    //   394: new 268	org/json/JSONObject
    //   397: dup
    //   398: aload 6
    //   400: invokespecial 269	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   403: ldc_w 271
    //   406: invokevirtual 275	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   409: astore_0
    //   410: aload_0
    //   411: iconst_0
    //   412: invokevirtual 281	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   415: astore 6
    //   417: aload 9
    //   419: astore_0
    //   420: aload 6
    //   422: ifnull +23 -> 445
    //   425: aload 6
    //   427: ldc_w 283
    //   430: invokevirtual 286	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   433: astore_0
    //   434: goto +11 -> 445
    //   437: astore_0
    //   438: aload_0
    //   439: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   442: aload 9
    //   444: astore_0
    //   445: aload_0
    //   446: ldc_w 288
    //   449: invokestatic 292	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   452: invokevirtual 295	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   455: istore 5
    //   457: aload_0
    //   458: astore 6
    //   460: iload 5
    //   462: iflt +15 -> 477
    //   465: aload_0
    //   466: iconst_0
    //   467: iload 5
    //   469: invokevirtual 299	java/lang/String:substring	(II)Ljava/lang/String;
    //   472: invokevirtual 129	java/lang/String:trim	()Ljava/lang/String;
    //   475: astore 6
    //   477: aload 6
    //   479: areturn
    //   480: astore 8
    //   482: aload 6
    //   484: astore 7
    //   486: aload 8
    //   488: astore 6
    //   490: aload_0
    //   491: ifnull +10 -> 501
    //   494: aload_0
    //   495: invokevirtual 264	java/io/InputStreamReader:close	()V
    //   498: goto +3 -> 501
    //   501: aload 7
    //   503: ifnull +15 -> 518
    //   506: aload 7
    //   508: invokevirtual 265	java/io/BufferedReader:close	()V
    //   511: goto +7 -> 518
    //   514: aload_0
    //   515: invokevirtual 266	java/io/IOException:printStackTrace	()V
    //   518: goto +6 -> 524
    //   521: aload 6
    //   523: athrow
    //   524: goto -3 -> 521
    //   527: astore_0
    //   528: ldc 148
    //   530: areturn
    //   531: astore_0
    //   532: goto -146 -> 386
    //   535: astore_0
    //   536: goto -22 -> 514
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	paramContext	Context
    //   0	539	1	paramDouble1	double
    //   0	539	3	paramDouble2	double
    //   0	539	5	paramInt	int
    //   0	539	6	paramHttpClient	HttpClient
    //   162	345	7	localObject1	Object
    //   56	249	8	localObject2	Object
    //   322	9	8	localObject3	Object
    //   351	7	8	localHttpClient	HttpClient
    //   480	7	8	localObject4	Object
    //   2	441	9	str	String
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
    //   425	434	437	org/json/JSONException
    //   357	362	480	finally
    //   394	410	527	org/json/JSONException
    //   366	370	531	java/io/IOException
    //   378	383	531	java/io/IOException
    //   494	498	535	java/io/IOException
    //   506	511	535	java/io/IOException
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ReverseGeocode
 * JD-Core Version:    0.7.0.1
 */