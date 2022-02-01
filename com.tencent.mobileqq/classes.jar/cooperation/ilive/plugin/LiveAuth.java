package cooperation.ilive.plugin;

import blvl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IliveAuthManager;
import cooperation.ilive.manager.IliveAuthManager.Callback;

public class LiveAuth
{
  private static final String APP_ID = "1037";
  private static final String AUTH_APPID = "1037";
  private static final String CLIENT_TYPE = "16594";
  private static final String TAG = "IliveAuth";
  private static final String URL_ONLINE = "https://ilive.qq.com/cgi-bin/now/web/user/live_platform_login?account_id=%s&client_type=%s&device=%s&auth_appid=%s&auth_key=%s&version_code=%s&ext_data=%s";
  private static final String VERSION_CODE = "10000";
  private static IliveAuthManager.Callback mCallback = new LiveAuth.1();
  private static int mSource;
  
  private static String getLoginUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return String.format("https://ilive.qq.com/cgi-bin/now/web/user/live_platform_login?account_id=%s&client_type=%s&device=%s&auth_appid=%s&auth_key=%s&version_code=%s&ext_data=%s", new Object[] { paramString1, paramString4, paramString5, paramString3, paramString2, paramString6, "0:" + paramString7 });
  }
  
  public static void getStAuth(int paramInt)
  {
    mSource = paramInt;
    QLog.i("IliveAuth", 1, "start LiveAuth");
    IliveAuthManager.getInstance().getStAuth(mCallback);
  }
  
  public static void liveToken(String paramString1, String paramString2)
  {
    blvl.a("liveToken");
    ThreadManagerV2.executeOnSubThread(new LiveAuth.2(paramString1, paramString2, System.currentTimeMillis()));
  }
  
  /* Error */
  private static byte[] request(java.net.URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore_1
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_0
    //   17: invokevirtual 130	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   20: astore_0
    //   21: aload_0
    //   22: instanceof 132
    //   25: ifeq +321 -> 346
    //   28: aload_0
    //   29: checkcast 132	javax/net/ssl/HttpsURLConnection
    //   32: astore 8
    //   34: aload 8
    //   36: ldc 134
    //   38: invokevirtual 137	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   41: aload 8
    //   43: ldc 139
    //   45: ldc 141
    //   47: invokevirtual 144	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload 8
    //   52: iconst_1
    //   53: invokevirtual 148	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   56: new 150	java/io/DataOutputStream
    //   59: dup
    //   60: aload 8
    //   62: invokevirtual 154	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   65: invokespecial 157	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 160	java/io/DataOutputStream:flush	()V
    //   73: aload_0
    //   74: invokevirtual 163	java/io/DataOutputStream:close	()V
    //   77: aload 8
    //   79: invokestatic 169	javax/net/ssl/SSLContext:getDefault	()Ljavax/net/ssl/SSLContext;
    //   82: invokevirtual 173	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   85: invokevirtual 177	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   88: aload 8
    //   90: invokevirtual 180	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   93: istore_2
    //   94: iload_2
    //   95: sipush 200
    //   98: if_icmpne +148 -> 246
    //   101: new 182	java/io/BufferedInputStream
    //   104: dup
    //   105: aload 8
    //   107: invokevirtual 186	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   110: invokespecial 189	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   113: astore_0
    //   114: aload_1
    //   115: astore_3
    //   116: aload_0
    //   117: astore 4
    //   119: new 191	java/io/ByteArrayOutputStream
    //   122: dup
    //   123: sipush 1024
    //   126: invokespecial 193	java/io/ByteArrayOutputStream:<init>	(I)V
    //   129: astore_1
    //   130: aload_0
    //   131: invokevirtual 196	java/io/BufferedInputStream:read	()I
    //   134: istore_2
    //   135: iload_2
    //   136: iconst_m1
    //   137: if_icmpeq +65 -> 202
    //   140: aload_1
    //   141: iload_2
    //   142: invokevirtual 199	java/io/ByteArrayOutputStream:write	(I)V
    //   145: goto -15 -> 130
    //   148: astore_3
    //   149: new 124	java/lang/Exception
    //   152: dup
    //   153: ldc 201
    //   155: aload_3
    //   156: invokespecial 204	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   159: athrow
    //   160: astore 4
    //   162: aload_1
    //   163: astore_3
    //   164: aload 4
    //   166: astore_1
    //   167: aload_0
    //   168: ifnull +7 -> 175
    //   171: aload_0
    //   172: invokevirtual 205	java/io/BufferedInputStream:close	()V
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   183: aload 8
    //   185: invokevirtual 209	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   188: aload_1
    //   189: athrow
    //   190: astore_0
    //   191: new 124	java/lang/Exception
    //   194: dup
    //   195: ldc 211
    //   197: aload_0
    //   198: invokespecial 204	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: athrow
    //   202: aload_1
    //   203: invokevirtual 215	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   206: astore_3
    //   207: aload_0
    //   208: ifnull +7 -> 215
    //   211: aload_0
    //   212: invokevirtual 205	java/io/BufferedInputStream:close	()V
    //   215: aload_1
    //   216: ifnull +7 -> 223
    //   219: aload_1
    //   220: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   223: aload 8
    //   225: invokevirtual 209	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   228: aload_3
    //   229: areturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   235: goto -20 -> 215
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   243: goto -20 -> 223
    //   246: new 124	java/lang/Exception
    //   249: dup
    //   250: new 52	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   257: ldc 220
    //   259: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload_2
    //   263: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokespecial 225	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   272: athrow
    //   273: astore_3
    //   274: aconst_null
    //   275: astore_1
    //   276: aload 4
    //   278: astore_0
    //   279: goto -130 -> 149
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_0
    //   285: aload 5
    //   287: astore_3
    //   288: aload_0
    //   289: astore 4
    //   291: new 124	java/lang/Exception
    //   294: dup
    //   295: ldc 227
    //   297: aload_1
    //   298: invokespecial 204	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   301: athrow
    //   302: aload_0
    //   303: astore 4
    //   305: new 124	java/lang/Exception
    //   308: dup
    //   309: ldc 229
    //   311: aload_1
    //   312: invokespecial 204	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   315: athrow
    //   316: aload_0
    //   317: astore 4
    //   319: new 124	java/lang/Exception
    //   322: dup
    //   323: ldc 231
    //   325: aload_1
    //   326: invokespecial 204	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   329: athrow
    //   330: astore_0
    //   331: aload_0
    //   332: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   335: goto -160 -> 175
    //   338: astore_0
    //   339: aload_0
    //   340: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   343: goto -160 -> 183
    //   346: new 233	java/lang/IllegalStateException
    //   349: dup
    //   350: ldc 235
    //   352: invokespecial 236	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   355: athrow
    //   356: astore_1
    //   357: aconst_null
    //   358: astore_0
    //   359: goto -192 -> 167
    //   362: astore 4
    //   364: aload_1
    //   365: astore_3
    //   366: aload 4
    //   368: astore_1
    //   369: goto -202 -> 167
    //   372: astore_1
    //   373: aload 7
    //   375: astore_3
    //   376: goto -60 -> 316
    //   379: astore 4
    //   381: aload_1
    //   382: astore_3
    //   383: aload 4
    //   385: astore_1
    //   386: goto -70 -> 316
    //   389: astore_1
    //   390: aload 6
    //   392: astore_3
    //   393: goto -91 -> 302
    //   396: astore 4
    //   398: aload_1
    //   399: astore_3
    //   400: aload 4
    //   402: astore_1
    //   403: goto -101 -> 302
    //   406: astore_1
    //   407: aload 5
    //   409: astore_3
    //   410: goto -122 -> 288
    //   413: astore 4
    //   415: aload_1
    //   416: astore_3
    //   417: aload 4
    //   419: astore_1
    //   420: goto -132 -> 288
    //   423: astore_3
    //   424: aconst_null
    //   425: astore_1
    //   426: goto -277 -> 149
    //   429: astore_1
    //   430: aload 4
    //   432: astore_0
    //   433: goto -266 -> 167
    //   436: astore_1
    //   437: aconst_null
    //   438: astore_0
    //   439: aload 6
    //   441: astore_3
    //   442: goto -140 -> 302
    //   445: astore_1
    //   446: aconst_null
    //   447: astore_0
    //   448: aload 7
    //   450: astore_3
    //   451: goto -135 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	paramURL	java.net.URL
    //   0	454	1	paramArrayOfByte	byte[]
    //   93	170	2	i	int
    //   1	115	3	arrayOfByte1	byte[]
    //   148	8	3	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   163	66	3	arrayOfByte2	byte[]
    //   273	1	3	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   287	130	3	localObject1	Object
    //   423	1	3	localNoSuchAlgorithmException3	java.security.NoSuchAlgorithmException
    //   441	10	3	localObject2	Object
    //   14	104	4	localURL1	java.net.URL
    //   160	117	4	localObject3	Object
    //   289	29	4	localURL2	java.net.URL
    //   362	5	4	localObject4	Object
    //   379	5	4	localJSONException	org.json.JSONException
    //   396	5	4	localIOException	java.io.IOException
    //   413	18	4	localKeyManagementException	java.security.KeyManagementException
    //   3	405	5	localObject5	Object
    //   6	434	6	localObject6	Object
    //   9	440	7	localObject7	Object
    //   32	192	8	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    // Exception table:
    //   from	to	target	type
    //   130	135	148	java/security/NoSuchAlgorithmException
    //   140	145	148	java/security/NoSuchAlgorithmException
    //   202	207	148	java/security/NoSuchAlgorithmException
    //   149	160	160	finally
    //   16	21	190	java/io/IOException
    //   211	215	230	java/lang/Exception
    //   219	223	238	java/lang/Exception
    //   77	94	273	java/security/NoSuchAlgorithmException
    //   101	114	273	java/security/NoSuchAlgorithmException
    //   246	273	273	java/security/NoSuchAlgorithmException
    //   77	94	282	java/security/KeyManagementException
    //   101	114	282	java/security/KeyManagementException
    //   246	273	282	java/security/KeyManagementException
    //   171	175	330	java/lang/Exception
    //   179	183	338	java/lang/Exception
    //   77	94	356	finally
    //   101	114	356	finally
    //   246	273	356	finally
    //   130	135	362	finally
    //   140	145	362	finally
    //   202	207	362	finally
    //   119	130	372	org/json/JSONException
    //   130	135	379	org/json/JSONException
    //   140	145	379	org/json/JSONException
    //   202	207	379	org/json/JSONException
    //   119	130	389	java/io/IOException
    //   130	135	396	java/io/IOException
    //   140	145	396	java/io/IOException
    //   202	207	396	java/io/IOException
    //   119	130	406	java/security/KeyManagementException
    //   130	135	413	java/security/KeyManagementException
    //   140	145	413	java/security/KeyManagementException
    //   202	207	413	java/security/KeyManagementException
    //   119	130	423	java/security/NoSuchAlgorithmException
    //   119	130	429	finally
    //   291	302	429	finally
    //   305	316	429	finally
    //   319	330	429	finally
    //   77	94	436	java/io/IOException
    //   101	114	436	java/io/IOException
    //   246	273	436	java/io/IOException
    //   77	94	445	org/json/JSONException
    //   101	114	445	org/json/JSONException
    //   246	273	445	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.plugin.LiveAuth
 * JD-Core Version:    0.7.0.1
 */