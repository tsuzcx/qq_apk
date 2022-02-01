package cooperation.ilive.plugin;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IliveAuthManager;
import cooperation.ilive.manager.IliveAuthManager.Callback;
import cooperation.ilive.util.ElapseStat;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0:");
    localStringBuilder.append(paramString7);
    return String.format("https://ilive.qq.com/cgi-bin/now/web/user/live_platform_login?account_id=%s&client_type=%s&device=%s&auth_appid=%s&auth_key=%s&version_code=%s&ext_data=%s", new Object[] { paramString1, paramString4, paramString5, paramString3, paramString2, paramString6, localStringBuilder.toString() });
  }
  
  public static void getStAuth(int paramInt)
  {
    mSource = paramInt;
    QLog.i("IliveAuth", 1, "start LiveAuth");
    IliveAuthManager.getInstance().getStAuth(mCallback, false);
  }
  
  public static void liveToken(String paramString1, String paramString2)
  {
    ElapseStat.a("liveToken");
    ThreadManagerV2.executeOnSubThread(new LiveAuth.2(paramString1, paramString2, System.currentTimeMillis()));
  }
  
  /* Error */
  private static byte[] request(java.net.URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 130	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   4: astore_0
    //   5: aload_0
    //   6: instanceof 132
    //   9: ifeq +422 -> 431
    //   12: aload_0
    //   13: checkcast 132	javax/net/ssl/HttpsURLConnection
    //   16: astore 7
    //   18: aload 7
    //   20: ldc 134
    //   22: invokevirtual 137	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   25: aload 7
    //   27: ldc 139
    //   29: ldc 141
    //   31: invokevirtual 144	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload 7
    //   36: iconst_1
    //   37: invokevirtual 148	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   40: new 150	java/io/DataOutputStream
    //   43: dup
    //   44: aload 7
    //   46: invokevirtual 154	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   49: invokespecial 157	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 160	java/io/DataOutputStream:flush	()V
    //   57: aload_0
    //   58: invokevirtual 163	java/io/DataOutputStream:close	()V
    //   61: aconst_null
    //   62: astore_1
    //   63: aconst_null
    //   64: astore 4
    //   66: aconst_null
    //   67: astore 5
    //   69: aconst_null
    //   70: astore_3
    //   71: aconst_null
    //   72: astore 6
    //   74: aload 7
    //   76: invokestatic 169	javax/net/ssl/SSLContext:getDefault	()Ljavax/net/ssl/SSLContext;
    //   79: invokevirtual 173	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   82: invokevirtual 177	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   85: aload 7
    //   87: invokevirtual 180	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   90: istore_2
    //   91: iload_2
    //   92: sipush 200
    //   95: if_icmpne +199 -> 294
    //   98: new 182	java/io/BufferedInputStream
    //   101: dup
    //   102: aload 7
    //   104: invokevirtual 186	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   107: invokespecial 189	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   110: astore_0
    //   111: new 191	java/io/ByteArrayOutputStream
    //   114: dup
    //   115: sipush 1024
    //   118: invokespecial 193	java/io/ByteArrayOutputStream:<init>	(I)V
    //   121: astore_1
    //   122: aload_0
    //   123: invokevirtual 196	java/io/BufferedInputStream:read	()I
    //   126: istore_2
    //   127: iload_2
    //   128: iconst_m1
    //   129: if_icmpeq +11 -> 140
    //   132: aload_1
    //   133: iload_2
    //   134: invokevirtual 199	java/io/ByteArrayOutputStream:write	(I)V
    //   137: goto -15 -> 122
    //   140: aload_1
    //   141: invokevirtual 203	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   144: astore_3
    //   145: aload_0
    //   146: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   149: goto +8 -> 157
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 207	java/lang/Exception:printStackTrace	()V
    //   157: aload_1
    //   158: invokevirtual 208	java/io/ByteArrayOutputStream:close	()V
    //   161: goto +8 -> 169
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 207	java/lang/Exception:printStackTrace	()V
    //   169: aload 7
    //   171: invokevirtual 211	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   174: aload_3
    //   175: areturn
    //   176: astore 4
    //   178: aload_0
    //   179: astore_3
    //   180: aload 4
    //   182: astore_0
    //   183: goto +209 -> 392
    //   186: astore_3
    //   187: aload_0
    //   188: astore 4
    //   190: aload_1
    //   191: astore_0
    //   192: aload 4
    //   194: astore_1
    //   195: goto +144 -> 339
    //   198: astore_3
    //   199: aload_0
    //   200: astore 4
    //   202: aload_1
    //   203: astore_0
    //   204: aload 4
    //   206: astore_1
    //   207: goto +143 -> 350
    //   210: astore_3
    //   211: aload_0
    //   212: astore 4
    //   214: aload_1
    //   215: astore_0
    //   216: aload 4
    //   218: astore_1
    //   219: goto +142 -> 361
    //   222: astore_3
    //   223: aload_0
    //   224: astore 4
    //   226: aload_1
    //   227: astore_0
    //   228: aload 4
    //   230: astore_1
    //   231: goto +141 -> 372
    //   234: astore 4
    //   236: aconst_null
    //   237: astore_1
    //   238: aload_0
    //   239: astore_3
    //   240: aload 4
    //   242: astore_0
    //   243: goto +149 -> 392
    //   246: astore_3
    //   247: aconst_null
    //   248: astore 4
    //   250: aload_0
    //   251: astore_1
    //   252: aload 4
    //   254: astore_0
    //   255: goto +84 -> 339
    //   258: astore_3
    //   259: aconst_null
    //   260: astore 4
    //   262: aload_0
    //   263: astore_1
    //   264: aload 4
    //   266: astore_0
    //   267: goto +83 -> 350
    //   270: astore_3
    //   271: aconst_null
    //   272: astore 4
    //   274: aload_0
    //   275: astore_1
    //   276: aload 4
    //   278: astore_0
    //   279: goto +82 -> 361
    //   282: astore_3
    //   283: aconst_null
    //   284: astore 4
    //   286: aload_0
    //   287: astore_1
    //   288: aload 4
    //   290: astore_0
    //   291: goto +81 -> 372
    //   294: new 52	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   301: astore_0
    //   302: aload_0
    //   303: ldc 213
    //   305: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload_0
    //   310: iload_2
    //   311: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: new 124	java/lang/Exception
    //   318: dup
    //   319: aload_0
    //   320: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokespecial 218	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   326: athrow
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_1
    //   330: goto +62 -> 392
    //   333: astore_3
    //   334: aconst_null
    //   335: astore_0
    //   336: aload 6
    //   338: astore_1
    //   339: new 124	java/lang/Exception
    //   342: dup
    //   343: ldc 220
    //   345: aload_3
    //   346: invokespecial 223	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   349: athrow
    //   350: new 124	java/lang/Exception
    //   353: dup
    //   354: ldc 225
    //   356: aload_3
    //   357: invokespecial 223	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: athrow
    //   361: new 124	java/lang/Exception
    //   364: dup
    //   365: ldc 227
    //   367: aload_3
    //   368: invokespecial 223	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   371: athrow
    //   372: new 124	java/lang/Exception
    //   375: dup
    //   376: ldc 229
    //   378: aload_3
    //   379: invokespecial 223	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   382: athrow
    //   383: astore 4
    //   385: aload_1
    //   386: astore_3
    //   387: aload_0
    //   388: astore_1
    //   389: aload 4
    //   391: astore_0
    //   392: aload_3
    //   393: ifnull +15 -> 408
    //   396: aload_3
    //   397: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   400: goto +8 -> 408
    //   403: astore_3
    //   404: aload_3
    //   405: invokevirtual 207	java/lang/Exception:printStackTrace	()V
    //   408: aload_1
    //   409: ifnull +15 -> 424
    //   412: aload_1
    //   413: invokevirtual 208	java/io/ByteArrayOutputStream:close	()V
    //   416: goto +8 -> 424
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 207	java/lang/Exception:printStackTrace	()V
    //   424: aload 7
    //   426: invokevirtual 211	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   429: aload_0
    //   430: athrow
    //   431: new 231	java/lang/IllegalStateException
    //   434: dup
    //   435: ldc 233
    //   437: invokespecial 234	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   440: athrow
    //   441: astore_0
    //   442: new 124	java/lang/Exception
    //   445: dup
    //   446: ldc 236
    //   448: aload_0
    //   449: invokespecial 223	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   452: astore_0
    //   453: goto +5 -> 458
    //   456: aload_0
    //   457: athrow
    //   458: goto -2 -> 456
    //   461: astore_3
    //   462: aconst_null
    //   463: astore_0
    //   464: goto -114 -> 350
    //   467: astore_3
    //   468: aconst_null
    //   469: astore_0
    //   470: aload 4
    //   472: astore_1
    //   473: goto -112 -> 361
    //   476: astore_3
    //   477: aconst_null
    //   478: astore_0
    //   479: aload 5
    //   481: astore_1
    //   482: goto -110 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	paramURL	java.net.URL
    //   0	485	1	paramArrayOfByte	byte[]
    //   90	221	2	i	int
    //   70	110	3	localObject1	Object
    //   186	1	3	localJSONException1	org.json.JSONException
    //   198	1	3	localIOException1	java.io.IOException
    //   210	1	3	localKeyManagementException1	java.security.KeyManagementException
    //   222	1	3	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   239	1	3	localURL1	java.net.URL
    //   246	1	3	localJSONException2	org.json.JSONException
    //   258	1	3	localIOException2	java.io.IOException
    //   270	1	3	localKeyManagementException2	java.security.KeyManagementException
    //   282	1	3	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   333	46	3	localJSONException3	org.json.JSONException
    //   386	11	3	arrayOfByte	byte[]
    //   403	2	3	localException	java.lang.Exception
    //   461	1	3	localIOException3	java.io.IOException
    //   467	1	3	localKeyManagementException3	java.security.KeyManagementException
    //   476	1	3	localNoSuchAlgorithmException3	java.security.NoSuchAlgorithmException
    //   64	1	4	localObject2	Object
    //   176	5	4	localObject3	Object
    //   188	41	4	localURL2	java.net.URL
    //   234	7	4	localObject4	Object
    //   248	41	4	localObject5	Object
    //   383	88	4	localObject6	Object
    //   67	413	5	localObject7	Object
    //   72	265	6	localObject8	Object
    //   16	409	7	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    // Exception table:
    //   from	to	target	type
    //   145	149	152	java/lang/Exception
    //   157	161	164	java/lang/Exception
    //   122	127	176	finally
    //   132	137	176	finally
    //   140	145	176	finally
    //   122	127	186	org/json/JSONException
    //   132	137	186	org/json/JSONException
    //   140	145	186	org/json/JSONException
    //   122	127	198	java/io/IOException
    //   132	137	198	java/io/IOException
    //   140	145	198	java/io/IOException
    //   122	127	210	java/security/KeyManagementException
    //   132	137	210	java/security/KeyManagementException
    //   140	145	210	java/security/KeyManagementException
    //   122	127	222	java/security/NoSuchAlgorithmException
    //   132	137	222	java/security/NoSuchAlgorithmException
    //   140	145	222	java/security/NoSuchAlgorithmException
    //   111	122	234	finally
    //   111	122	246	org/json/JSONException
    //   111	122	258	java/io/IOException
    //   111	122	270	java/security/KeyManagementException
    //   111	122	282	java/security/NoSuchAlgorithmException
    //   74	91	327	finally
    //   98	111	327	finally
    //   294	327	327	finally
    //   74	91	333	org/json/JSONException
    //   98	111	333	org/json/JSONException
    //   294	327	333	org/json/JSONException
    //   339	350	383	finally
    //   350	361	383	finally
    //   361	372	383	finally
    //   372	383	383	finally
    //   396	400	403	java/lang/Exception
    //   412	416	419	java/lang/Exception
    //   0	5	441	java/io/IOException
    //   74	91	461	java/io/IOException
    //   98	111	461	java/io/IOException
    //   294	327	461	java/io/IOException
    //   74	91	467	java/security/KeyManagementException
    //   98	111	467	java/security/KeyManagementException
    //   294	327	467	java/security/KeyManagementException
    //   74	91	476	java/security/NoSuchAlgorithmException
    //   98	111	476	java/security/NoSuchAlgorithmException
    //   294	327	476	java/security/NoSuchAlgorithmException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.plugin.LiveAuth
 * JD-Core Version:    0.7.0.1
 */