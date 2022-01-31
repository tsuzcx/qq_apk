package com.tencent.mobileqq.utils;

import aknm;
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
  private static aknm a(Context paramContext)
  {
    // Byte code:
    //   0: new 27	aknm
    //   3: dup
    //   4: invokespecial 28	aknm:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 18	com/tencent/mobileqq/utils/ReverseGeocode:a	Landroid/net/Uri;
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 40	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokeinterface 46 1 0
    //   32: pop
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_1
    //   37: ldc 48
    //   39: invokeinterface 52 2 0
    //   44: invokeinterface 56 2 0
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +286 -> 337
    //   54: aload_1
    //   55: astore_0
    //   56: aload_2
    //   57: invokevirtual 62	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   60: astore_2
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: aload_1
    //   65: ldc 64
    //   67: invokeinterface 52 2 0
    //   72: invokeinterface 56 2 0
    //   77: astore 6
    //   79: aload_1
    //   80: astore_0
    //   81: aload_1
    //   82: aload_1
    //   83: ldc 66
    //   85: invokeinterface 52 2 0
    //   90: invokeinterface 56 2 0
    //   95: astore 4
    //   97: aload 4
    //   99: astore_3
    //   100: aload 4
    //   102: ifnull +11 -> 113
    //   105: aload_1
    //   106: astore_0
    //   107: aload 4
    //   109: invokevirtual 62	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   112: astore_3
    //   113: aload_1
    //   114: astore_0
    //   115: aload_1
    //   116: invokeinterface 69 1 0
    //   121: aload_2
    //   122: ifnull +61 -> 183
    //   125: aload_1
    //   126: astore_0
    //   127: aload_2
    //   128: invokevirtual 73	java/lang/String:length	()I
    //   131: ifle +52 -> 183
    //   134: aload_1
    //   135: astore_0
    //   136: aload 6
    //   138: invokestatic 79	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   141: invokevirtual 82	java/lang/Integer:intValue	()I
    //   144: ifle +39 -> 183
    //   147: aload_1
    //   148: astore_0
    //   149: aload 5
    //   151: aload_2
    //   152: putfield 85	aknm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   155: aload_1
    //   156: astore_0
    //   157: aload 5
    //   159: aload 6
    //   161: invokestatic 79	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   164: invokevirtual 82	java/lang/Integer:intValue	()I
    //   167: putfield 88	aknm:jdField_a_of_type_Int	I
    //   170: aload_1
    //   171: ifnull +9 -> 180
    //   174: aload_1
    //   175: invokeinterface 69 1 0
    //   180: aload 5
    //   182: areturn
    //   183: aload_3
    //   184: ifnull +55 -> 239
    //   187: aload_1
    //   188: astore_0
    //   189: aload_3
    //   190: ldc 90
    //   192: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   195: ifeq +44 -> 239
    //   198: aload_1
    //   199: astore_0
    //   200: aload 5
    //   202: ldc 96
    //   204: putfield 85	aknm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   207: aload_1
    //   208: astore_0
    //   209: aload 5
    //   211: bipush 80
    //   213: putfield 88	aknm:jdField_a_of_type_Int	I
    //   216: goto -46 -> 170
    //   219: astore_2
    //   220: aload_1
    //   221: astore_0
    //   222: aload_2
    //   223: invokevirtual 99	java/lang/Exception:printStackTrace	()V
    //   226: aload_1
    //   227: ifnull +9 -> 236
    //   230: aload_1
    //   231: invokeinterface 69 1 0
    //   236: aload 5
    //   238: areturn
    //   239: aload_3
    //   240: ifnull +49 -> 289
    //   243: aload_1
    //   244: astore_0
    //   245: aload_3
    //   246: ldc 101
    //   248: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   251: ifeq +38 -> 289
    //   254: aload_1
    //   255: astore_0
    //   256: aload 5
    //   258: ldc 103
    //   260: putfield 85	aknm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   263: aload_1
    //   264: astore_0
    //   265: aload 5
    //   267: bipush 80
    //   269: putfield 88	aknm:jdField_a_of_type_Int	I
    //   272: goto -102 -> 170
    //   275: astore_1
    //   276: aload_0
    //   277: ifnull +9 -> 286
    //   280: aload_0
    //   281: invokeinterface 69 1 0
    //   286: aload 5
    //   288: areturn
    //   289: aload_3
    //   290: ifnull -120 -> 170
    //   293: aload_1
    //   294: astore_0
    //   295: aload_3
    //   296: ldc 105
    //   298: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   301: ifeq -131 -> 170
    //   304: aload_1
    //   305: astore_0
    //   306: aload 5
    //   308: ldc 103
    //   310: putfield 85	aknm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   313: aload_1
    //   314: astore_0
    //   315: aload 5
    //   317: bipush 80
    //   319: putfield 88	aknm:jdField_a_of_type_Int	I
    //   322: goto -152 -> 170
    //   325: astore_0
    //   326: aconst_null
    //   327: astore_0
    //   328: goto -52 -> 276
    //   331: astore_2
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -114 -> 220
    //   337: goto -276 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramContext	Context
    //   23	241	1	localCursor	android.database.Cursor
    //   275	39	1	localObject1	Object
    //   333	1	1	localObject2	Object
    //   49	103	2	str1	String
    //   219	4	2	localException1	java.lang.Exception
    //   331	1	2	localException2	java.lang.Exception
    //   99	197	3	str2	String
    //   95	13	4	str3	String
    //   7	309	5	localaknm	aknm
    //   77	83	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   26	33	219	java/lang/Exception
    //   35	50	219	java/lang/Exception
    //   56	61	219	java/lang/Exception
    //   63	79	219	java/lang/Exception
    //   81	97	219	java/lang/Exception
    //   107	113	219	java/lang/Exception
    //   115	121	219	java/lang/Exception
    //   127	134	219	java/lang/Exception
    //   136	147	219	java/lang/Exception
    //   149	155	219	java/lang/Exception
    //   157	170	219	java/lang/Exception
    //   189	198	219	java/lang/Exception
    //   200	207	219	java/lang/Exception
    //   209	216	219	java/lang/Exception
    //   245	254	219	java/lang/Exception
    //   256	263	219	java/lang/Exception
    //   265	272	219	java/lang/Exception
    //   295	304	219	java/lang/Exception
    //   306	313	219	java/lang/Exception
    //   315	322	219	java/lang/Exception
    //   26	33	275	finally
    //   35	50	275	finally
    //   56	61	275	finally
    //   63	79	275	finally
    //   81	97	275	finally
    //   107	113	275	finally
    //   115	121	275	finally
    //   127	134	275	finally
    //   136	147	275	finally
    //   149	155	275	finally
    //   157	170	275	finally
    //   189	198	275	finally
    //   200	207	275	finally
    //   209	216	275	finally
    //   222	226	275	finally
    //   245	254	275	finally
    //   256	263	275	finally
    //   265	272	275	finally
    //   295	304	275	finally
    //   306	313	275	finally
    //   315	322	275	finally
    //   9	24	325	finally
    //   9	24	331	java/lang/Exception
  }
  
  private static String a(Context paramContext)
  {
    String str2 = "";
    String str1;
    int i;
    if (paramContext == null)
    {
      str1 = Proxy.getDefaultHost();
      i = Proxy.getDefaultPort();
    }
    for (;;)
    {
      paramContext = str2;
      if (str1 != null)
      {
        paramContext = str2;
        if (str1.trim().length() > 0) {
          paramContext = str1 + ":" + i;
        }
      }
      return paramContext;
      if (!AppNetConnInfo.isMobileConn()) {
        break;
      }
      str1 = Proxy.getHost(paramContext);
      int j = Proxy.getPort(paramContext);
      if ((str1 != null) && (str1.trim().length() != 0))
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        str1 = Proxy.getDefaultHost();
        j = Proxy.getDefaultPort();
        if ((str1 != null) && (str1.trim().length() != 0))
        {
          i = j;
          if (j > 0) {}
        }
        else
        {
          paramContext = a(paramContext);
          str1 = paramContext.jdField_a_of_type_JavaLangString;
          i = paramContext.jdField_a_of_type_Int;
        }
      }
    }
    return null;
  }
  
  /* Error */
  public static String a(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, HttpClient paramHttpClient)
  {
    // Byte code:
    //   0: new 121	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   7: ldc 155
    //   9: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: dload_1
    //   13: invokevirtual 158	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   16: ldc 160
    //   18: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: dload_3
    //   22: invokevirtual 158	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   25: ldc 162
    //   27: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 6
    //   35: new 164	org/apache/http/params/BasicHttpParams
    //   38: dup
    //   39: invokespecial 165	org/apache/http/params/BasicHttpParams:<init>	()V
    //   42: astore 7
    //   44: aload 7
    //   46: ldc2_w 166
    //   49: invokestatic 173	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   52: aload 7
    //   54: new 175	org/apache/http/conn/params/ConnPerRouteBean
    //   57: dup
    //   58: bipush 10
    //   60: invokespecial 178	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   63: invokestatic 182	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   66: aload 7
    //   68: bipush 10
    //   70: invokestatic 186	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   73: aload 7
    //   75: sipush 10000
    //   78: invokestatic 191	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   81: aload 7
    //   83: sipush 20000
    //   86: invokestatic 194	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   89: aload 7
    //   91: iconst_1
    //   92: invokestatic 198	org/apache/http/params/HttpConnectionParams:setTcpNoDelay	(Lorg/apache/http/params/HttpParams;Z)V
    //   95: aload 7
    //   97: sipush 8192
    //   100: invokestatic 201	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   103: aload 7
    //   105: getstatic 207	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   108: invokestatic 213	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   111: aload 7
    //   113: ldc 215
    //   115: invokestatic 219	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   118: new 221	org/apache/http/impl/client/DefaultHttpClient
    //   121: dup
    //   122: aload 7
    //   124: invokespecial 224	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   127: astore 7
    //   129: aload_0
    //   130: aload 7
    //   132: invokestatic 227	com/tencent/mobileqq/utils/ReverseGeocode:a	(Landroid/content/Context;Lorg/apache/http/client/HttpClient;)V
    //   135: new 229	java/io/BufferedReader
    //   138: dup
    //   139: new 231	java/io/InputStreamReader
    //   142: dup
    //   143: aload 7
    //   145: new 233	org/apache/http/client/methods/HttpGet
    //   148: dup
    //   149: aload 6
    //   151: invokespecial 236	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   154: invokeinterface 242 2 0
    //   159: invokeinterface 248 1 0
    //   164: invokeinterface 254 1 0
    //   169: invokespecial 257	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   172: invokespecial 260	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   175: astore 7
    //   177: ldc 108
    //   179: astore_0
    //   180: aload 7
    //   182: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   185: astore 8
    //   187: aload_0
    //   188: astore 6
    //   190: aload 8
    //   192: ifnull +43 -> 235
    //   195: new 121	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   202: aload_0
    //   203: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 8
    //   208: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore 6
    //   216: aload 6
    //   218: astore_0
    //   219: goto -39 -> 180
    //   222: astore 6
    //   224: ldc 108
    //   226: astore_0
    //   227: aload 6
    //   229: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   232: aload_0
    //   233: astore 6
    //   235: new 266	org/json/JSONObject
    //   238: dup
    //   239: aload 6
    //   241: invokespecial 267	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   244: ldc_w 269
    //   247: invokevirtual 273	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   250: astore_0
    //   251: aload_0
    //   252: iconst_0
    //   253: invokevirtual 279	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   256: astore 7
    //   258: ldc 108
    //   260: astore 6
    //   262: aload 6
    //   264: astore_0
    //   265: aload 7
    //   267: ifnull +12 -> 279
    //   270: aload 7
    //   272: ldc_w 281
    //   275: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore_0
    //   279: aload_0
    //   280: ldc_w 286
    //   283: invokevirtual 289	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   286: istore 5
    //   288: aload_0
    //   289: astore 6
    //   291: iload 5
    //   293: iflt +15 -> 308
    //   296: aload_0
    //   297: iconst_0
    //   298: iload 5
    //   300: invokevirtual 293	java/lang/String:substring	(II)Ljava/lang/String;
    //   303: invokevirtual 119	java/lang/String:trim	()Ljava/lang/String;
    //   306: astore 6
    //   308: aload 6
    //   310: areturn
    //   311: astore_0
    //   312: ldc 108
    //   314: areturn
    //   315: astore_0
    //   316: aload_0
    //   317: invokevirtual 294	org/json/JSONException:printStackTrace	()V
    //   320: aload 6
    //   322: astore_0
    //   323: goto -44 -> 279
    //   326: astore 6
    //   328: goto -101 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramContext	Context
    //   0	331	1	paramDouble1	double
    //   0	331	3	paramDouble2	double
    //   0	331	5	paramInt	int
    //   0	331	6	paramHttpClient	HttpClient
    //   42	229	7	localObject	Object
    //   185	22	8	str	String
    // Exception table:
    //   from	to	target	type
    //   135	177	222	java/io/IOException
    //   235	251	311	org/json/JSONException
    //   270	279	315	org/json/JSONException
    //   180	187	326	java/io/IOException
    //   195	216	326	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ReverseGeocode
 * JD-Core Version:    0.7.0.1
 */