package com.tencent.mobileqq.now.netchannel.websso;

import android.util.Log;
import java.net.URL;
import java.util.concurrent.Callable;

public class WebServiceSSO$WebServiceSSOSender$RequestCallable
  implements Callable<byte[]>
{
  final int a;
  final String b;
  final byte[] c;
  
  public WebServiceSSO$WebServiceSSOSender$RequestCallable(WebServiceSSO.WebServiceSSOSender paramWebServiceSSOSender, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramArrayOfByte;
  }
  
  /* Error */
  private byte[] a(URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: aload_2
    //   2: invokestatic 44	okhttp3/RequestBody:create	(Lokhttp3/MediaType;[B)Lokhttp3/RequestBody;
    //   5: astore_2
    //   6: new 46	okhttp3/Request$Builder
    //   9: dup
    //   10: invokespecial 47	okhttp3/Request$Builder:<init>	()V
    //   13: aload_1
    //   14: invokevirtual 51	okhttp3/Request$Builder:url	(Ljava/net/URL;)Lokhttp3/Request$Builder;
    //   17: aload_2
    //   18: invokevirtual 55	okhttp3/Request$Builder:post	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   21: invokevirtual 59	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 19	com/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender$RequestCallable:d	Lcom/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender;
    //   29: getfield 65	com/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender:f	Lcom/tencent/mobileqq/now/netchannel/websso/WebServiceSSO;
    //   32: invokestatic 71	com/tencent/mobileqq/now/netchannel/websso/WebServiceSSO:e	(Lcom/tencent/mobileqq/now/netchannel/websso/WebServiceSSO;)Lokhttp3/OkHttpClient;
    //   35: aload_1
    //   36: invokevirtual 77	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   39: invokeinterface 83 1 0
    //   44: astore 5
    //   46: aload 5
    //   48: invokevirtual 89	okhttp3/Response:isSuccessful	()Z
    //   51: istore 4
    //   53: iload 4
    //   55: ifne +15 -> 70
    //   58: aload 5
    //   60: ifnull +8 -> 68
    //   63: aload 5
    //   65: invokevirtual 92	okhttp3/Response:close	()V
    //   68: aconst_null
    //   69: areturn
    //   70: aload 5
    //   72: invokevirtual 96	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   75: invokevirtual 102	okhttp3/ResponseBody:contentLength	()J
    //   78: pop2
    //   79: aload 5
    //   81: invokevirtual 96	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   84: invokevirtual 106	okhttp3/ResponseBody:bytes	()[B
    //   87: astore_1
    //   88: new 108	org/json/JSONObject
    //   91: dup
    //   92: new 110	java/lang/String
    //   95: dup
    //   96: aload_1
    //   97: invokespecial 113	java/lang/String:<init>	([B)V
    //   100: invokespecial 116	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   103: astore_2
    //   104: aload_2
    //   105: ldc 118
    //   107: invokevirtual 122	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   110: istore_3
    //   111: aload_2
    //   112: ldc 124
    //   114: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore_2
    //   118: new 130	com/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender$SSOException
    //   121: dup
    //   122: aload_0
    //   123: getfield 19	com/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender$RequestCallable:d	Lcom/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender;
    //   126: iload_3
    //   127: aload_2
    //   128: invokespecial 133	com/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender$SSOException:<init>	(Lcom/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender;ILjava/lang/String;)V
    //   131: athrow
    //   132: aload_0
    //   133: getfield 19	com/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender$RequestCallable:d	Lcom/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender;
    //   136: astore_2
    //   137: new 135	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   144: astore 6
    //   146: aload 6
    //   148: ldc 138
    //   150: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 6
    //   156: new 110	java/lang/String
    //   159: dup
    //   160: aload_1
    //   161: invokespecial 113	java/lang/String:<init>	([B)V
    //   164: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: new 130	com/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender$SSOException
    //   171: dup
    //   172: aload_2
    //   173: bipush 253
    //   175: aload 6
    //   177: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokespecial 133	com/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender$SSOException:<init>	(Lcom/tencent/mobileqq/now/netchannel/websso/WebServiceSSO$WebServiceSSOSender;ILjava/lang/String;)V
    //   183: athrow
    //   184: aload 5
    //   186: ifnull +8 -> 194
    //   189: aload 5
    //   191: invokevirtual 92	okhttp3/Response:close	()V
    //   194: aload_1
    //   195: areturn
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_1
    //   199: goto +7 -> 206
    //   202: astore_1
    //   203: aload_1
    //   204: athrow
    //   205: astore_2
    //   206: aload 5
    //   208: ifnull +20 -> 228
    //   211: aload_1
    //   212: ifnull +11 -> 223
    //   215: aload 5
    //   217: invokevirtual 92	okhttp3/Response:close	()V
    //   220: goto +8 -> 228
    //   223: aload 5
    //   225: invokevirtual 92	okhttp3/Response:close	()V
    //   228: aload_2
    //   229: athrow
    //   230: astore_1
    //   231: new 135	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   238: astore_2
    //   239: aload_2
    //   240: ldc 148
    //   242: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_2
    //   247: aload_1
    //   248: invokevirtual 149	java/io/IOException:toString	()Ljava/lang/String;
    //   251: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc 151
    //   257: aload_2
    //   258: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 156	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   264: pop
    //   265: aload_1
    //   266: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   269: aconst_null
    //   270: areturn
    //   271: astore_2
    //   272: goto -88 -> 184
    //   275: astore_2
    //   276: goto -144 -> 132
    //   279: astore_1
    //   280: goto -52 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	RequestCallable
    //   0	283	1	paramURL	URL
    //   0	283	2	paramArrayOfByte	byte[]
    //   110	17	3	i	int
    //   51	3	4	bool	boolean
    //   44	180	5	localResponse	okhttp3.Response
    //   144	32	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	53	196	finally
    //   70	88	196	finally
    //   88	104	196	finally
    //   104	132	196	finally
    //   132	184	196	finally
    //   46	53	202	java/lang/Throwable
    //   70	88	202	java/lang/Throwable
    //   88	104	202	java/lang/Throwable
    //   104	132	202	java/lang/Throwable
    //   132	184	202	java/lang/Throwable
    //   203	205	205	finally
    //   25	46	230	java/io/IOException
    //   63	68	230	java/io/IOException
    //   189	194	230	java/io/IOException
    //   215	220	230	java/io/IOException
    //   223	228	230	java/io/IOException
    //   228	230	230	java/io/IOException
    //   88	104	271	java/lang/Exception
    //   104	132	275	org/json/JSONException
    //   215	220	279	java/lang/Throwable
  }
  
  public byte[] a()
  {
    if (WebServiceSSO.c(this.d.f)) {
      localObject = "https://test.tim.qq.com/v4/";
    } else {
      localObject = "https://open.tim.qq.com/v4/";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("NowSSOSvcProxy");
    localStringBuilder.append("/");
    localStringBuilder.append(this.b);
    localStringBuilder.append(WebServiceSSO.d(this.d.f));
    Object localObject = new URL(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebServiceSSO--send url=");
    localStringBuilder.append(((URL)localObject).toString());
    Log.d("RequestCallable", localStringBuilder.toString());
    return a((URL)localObject, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO.WebServiceSSOSender.RequestCallable
 * JD-Core Version:    0.7.0.1
 */