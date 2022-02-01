package com.tencent.mobileqq.tts.data;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public class TtsNetDataSource
  implements INetUrlDataSource
{
  private HttpsURLConnection a(TtsNetStreamParam paramTtsNetStreamParam)
  {
    HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)new URL("https://textts.qq.com/cgi-bin/tts").openConnection();
    localHttpsURLConnection.setRequestMethod("POST");
    localHttpsURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
    localHttpsURLConnection.setRequestProperty("Accept", "application/json");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(paramTtsNetStreamParam.uin);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(paramTtsNetStreamParam.sKey);
    localHttpsURLConnection.setRequestProperty("Cookie", localStringBuilder.toString());
    localHttpsURLConnection.setDoOutput(true);
    localHttpsURLConnection.setDoInput(true);
    try
    {
      paramTtsNetStreamParam = SSLContext.getDefault();
    }
    catch (NoSuchAlgorithmException paramTtsNetStreamParam)
    {
      QLog.e("TtsNetDataSource", 2, paramTtsNetStreamParam, new Object[0]);
      paramTtsNetStreamParam = null;
    }
    if (paramTtsNetStreamParam != null) {
      localHttpsURLConnection.setSSLSocketFactory(paramTtsNetStreamParam.getSocketFactory());
    }
    return localHttpsURLConnection;
  }
  
  private void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("playSuccess", paramString1);
    localHashMap.put("playError", paramString2);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "TTSPlayMonitor", true, 0L, 0L, localHashMap, "");
  }
  
  /* Error */
  public java.io.InputStream a(TtsNetStreamParam paramTtsNetStreamParam)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 140	com/tencent/mobileqq/tts/data/TtsNetDataSource:a	(Lcom/tencent/mobileqq/tts/data/TtsNetStreamParam;)Ljavax/net/ssl/HttpsURLConnection;
    //   5: astore 5
    //   7: new 142	com/google/gson/Gson
    //   10: dup
    //   11: invokespecial 143	com/google/gson/Gson:<init>	()V
    //   14: aload_1
    //   15: invokevirtual 147	com/google/gson/Gson:toJson	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: astore 4
    //   20: new 149	java/io/DataOutputStream
    //   23: dup
    //   24: aload 5
    //   26: invokevirtual 153	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   29: invokespecial 156	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore_2
    //   33: aload_2
    //   34: astore_3
    //   35: aload_2
    //   36: aload 4
    //   38: invokevirtual 162	java/lang/String:getBytes	()[B
    //   41: invokevirtual 166	java/io/DataOutputStream:write	([B)V
    //   44: aload_2
    //   45: astore_3
    //   46: aload_2
    //   47: invokevirtual 169	java/io/DataOutputStream:flush	()V
    //   50: goto +41 -> 91
    //   53: astore 4
    //   55: goto +13 -> 68
    //   58: astore_1
    //   59: aconst_null
    //   60: astore_3
    //   61: goto +102 -> 163
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_2
    //   68: aload_2
    //   69: astore_3
    //   70: ldc 90
    //   72: iconst_1
    //   73: ldc 171
    //   75: aload 4
    //   77: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload_2
    //   81: astore_3
    //   82: aload 5
    //   84: invokevirtual 177	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   87: aload_2
    //   88: ifnull +7 -> 95
    //   91: aload_2
    //   92: invokevirtual 180	java/io/DataOutputStream:close	()V
    //   95: aload 5
    //   97: invokevirtual 184	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   100: sipush 200
    //   103: if_icmpne +34 -> 137
    //   106: aload_1
    //   107: getfield 188	com/tencent/mobileqq/tts/data/TtsNetStreamParam:businessID	I
    //   110: iconst_1
    //   111: if_icmpne +11 -> 122
    //   114: aload_0
    //   115: ldc 190
    //   117: ldc 190
    //   119: invokespecial 192	com/tencent/mobileqq/tts/data/TtsNetDataSource:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: new 194	com/tencent/mobileqq/tts/data/ConnectionInputStreamWrapper
    //   125: dup
    //   126: aload 5
    //   128: aload 5
    //   130: invokevirtual 198	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   133: invokespecial 201	com/tencent/mobileqq/tts/data/ConnectionInputStreamWrapper:<init>	(Ljavax/net/ssl/HttpsURLConnection;Ljava/io/InputStream;)V
    //   136: areturn
    //   137: aload_1
    //   138: getfield 188	com/tencent/mobileqq/tts/data/TtsNetStreamParam:businessID	I
    //   141: iconst_1
    //   142: if_icmpne +18 -> 160
    //   145: aload 5
    //   147: invokevirtual 184	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   150: invokestatic 205	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   153: astore_1
    //   154: aload_0
    //   155: aload_1
    //   156: aload_1
    //   157: invokespecial 192	com/tencent/mobileqq/tts/data/TtsNetDataSource:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_1
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 180	java/io/DataOutputStream:close	()V
    //   171: aload_1
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	TtsNetDataSource
    //   0	173	1	paramTtsNetStreamParam	TtsNetStreamParam
    //   32	60	2	localDataOutputStream1	java.io.DataOutputStream
    //   34	134	3	localDataOutputStream2	java.io.DataOutputStream
    //   18	19	4	str	String
    //   53	1	4	localException1	java.lang.Exception
    //   64	12	4	localException2	java.lang.Exception
    //   5	141	5	localHttpsURLConnection	HttpsURLConnection
    // Exception table:
    //   from	to	target	type
    //   35	44	53	java/lang/Exception
    //   46	50	53	java/lang/Exception
    //   20	33	58	finally
    //   20	33	64	java/lang/Exception
    //   35	44	162	finally
    //   46	50	162	finally
    //   70	80	162	finally
    //   82	87	162	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.data.TtsNetDataSource
 * JD-Core Version:    0.7.0.1
 */