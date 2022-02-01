package com.tencent.youtu.sdkkitframework.net;

import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;

class YtSDKKitNetHelper$1
  implements Runnable
{
  YtSDKKitNetHelper$1(YtSDKKitNetHelper paramYtSDKKitNetHelper, String paramString1, HashMap paramHashMap, String paramString2, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   4: invokestatic 40	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$100	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljava/util/HashMap;
    //   7: invokestatic 46	android/os/Process:myTid	()I
    //   10: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: aload_0
    //   14: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   17: invokestatic 56	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$000	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljava/lang/Thread;
    //   20: invokevirtual 62	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: pop
    //   24: new 64	java/net/URL
    //   27: dup
    //   28: aload_0
    //   29: getfield 21	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$url	Ljava/lang/String;
    //   32: invokespecial 67	java/net/URL:<init>	(Ljava/lang/String;)V
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   40: aload_2
    //   41: invokevirtual 71	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   44: checkcast 73	javax/net/ssl/HttpsURLConnection
    //   47: invokestatic 77	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$202	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;Ljavax/net/ssl/HttpsURLConnection;)Ljavax/net/ssl/HttpsURLConnection;
    //   50: pop
    //   51: aload_0
    //   52: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   55: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   58: ldc 83
    //   60: invokevirtual 86	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   67: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   70: invokestatic 92	com/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework;
    //   73: invokevirtual 95	com/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework:getNetworkRequestTimeoutMS	()I
    //   76: invokevirtual 99	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   79: aload_0
    //   80: getfield 23	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$requestHeader	Ljava/util/HashMap;
    //   83: ifnull +125 -> 208
    //   86: aload_0
    //   87: getfield 23	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$requestHeader	Ljava/util/HashMap;
    //   90: invokevirtual 103	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   93: invokeinterface 109 1 0
    //   98: astore_2
    //   99: aload_2
    //   100: invokeinterface 115 1 0
    //   105: ifeq +103 -> 208
    //   108: aload_2
    //   109: invokeinterface 119 1 0
    //   114: checkcast 121	java/util/Map$Entry
    //   117: astore_3
    //   118: aload_0
    //   119: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   122: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   125: aload_3
    //   126: invokeinterface 124 1 0
    //   131: checkcast 126	java/lang/String
    //   134: aload_3
    //   135: invokeinterface 129 1 0
    //   140: checkcast 126	java/lang/String
    //   143: invokevirtual 133	javax/net/ssl/HttpsURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: goto -47 -> 99
    //   149: astore_2
    //   150: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   153: new 139	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   160: ldc 142
    //   162: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_2
    //   166: invokevirtual 149	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   169: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 157	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_0
    //   179: getfield 27	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$parser	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$IYtSDKKitNetResponseParser;
    //   182: aconst_null
    //   183: aload_2
    //   184: invokeinterface 163 3 0
    //   189: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   192: ldc 165
    //   194: invokestatic 169	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   197: aload_0
    //   198: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   201: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   204: invokevirtual 172	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   207: return
    //   208: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   211: ldc 174
    //   213: invokestatic 169	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   216: aload_0
    //   217: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   220: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   223: invokevirtual 178	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   226: astore_2
    //   227: new 180	java/io/BufferedWriter
    //   230: dup
    //   231: new 182	java/io/OutputStreamWriter
    //   234: dup
    //   235: aload_2
    //   236: ldc 184
    //   238: invokespecial 187	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   241: invokespecial 190	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   244: astore_3
    //   245: aload_3
    //   246: aload_0
    //   247: getfield 25	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$requestContent	Ljava/lang/String;
    //   250: invokevirtual 193	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   253: aload_3
    //   254: invokevirtual 196	java/io/BufferedWriter:flush	()V
    //   257: aload_3
    //   258: invokevirtual 199	java/io/BufferedWriter:close	()V
    //   261: aload_2
    //   262: invokevirtual 202	java/io/OutputStream:close	()V
    //   265: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   268: ldc 204
    //   270: invokestatic 169	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   273: aload_0
    //   274: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   277: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   280: invokevirtual 207	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   283: istore_1
    //   284: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   287: ldc 209
    //   289: invokestatic 169	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   292: aload_0
    //   293: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   296: invokestatic 40	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$100	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljava/util/HashMap;
    //   299: invokestatic 46	android/os/Process:myTid	()I
    //   302: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   305: invokevirtual 213	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   308: ifne +40 -> 348
    //   311: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   314: ldc 215
    //   316: invokestatic 218	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload_0
    //   320: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   323: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   326: invokevirtual 172	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   329: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   332: ldc 165
    //   334: invokestatic 169	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   337: aload_0
    //   338: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   341: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   344: invokevirtual 172	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   347: return
    //   348: iload_1
    //   349: sipush 200
    //   352: if_icmpne +109 -> 461
    //   355: new 220	java/io/BufferedReader
    //   358: dup
    //   359: new 222	java/io/InputStreamReader
    //   362: dup
    //   363: aload_0
    //   364: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   367: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   370: invokevirtual 226	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   373: invokespecial 229	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   376: invokespecial 232	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   379: astore_3
    //   380: new 234	java/lang/StringBuffer
    //   383: dup
    //   384: ldc 236
    //   386: invokespecial 237	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   389: astore_2
    //   390: aload_3
    //   391: invokevirtual 240	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   394: astore 4
    //   396: aload 4
    //   398: ifnull +10 -> 408
    //   401: aload_2
    //   402: aload 4
    //   404: invokevirtual 243	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   407: pop
    //   408: aload_3
    //   409: invokevirtual 244	java/io/BufferedReader:close	()V
    //   412: new 58	java/util/HashMap
    //   415: dup
    //   416: invokespecial 245	java/util/HashMap:<init>	()V
    //   419: astore_3
    //   420: aload_3
    //   421: ldc 247
    //   423: aload_2
    //   424: invokevirtual 248	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   427: invokevirtual 62	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   430: pop
    //   431: aload_0
    //   432: getfield 27	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$parser	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$IYtSDKKitNetResponseParser;
    //   435: aload_3
    //   436: aconst_null
    //   437: invokeinterface 163 3 0
    //   442: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   445: ldc 165
    //   447: invokestatic 169	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   450: aload_0
    //   451: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   454: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   457: invokevirtual 172	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   460: return
    //   461: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   464: new 139	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   471: ldc 142
    //   473: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: iload_1
    //   477: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 157	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: aload_0
    //   487: getfield 27	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$parser	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$IYtSDKKitNetResponseParser;
    //   490: aconst_null
    //   491: new 253	java/lang/Exception
    //   494: dup
    //   495: new 139	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   502: ldc 255
    //   504: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: iload_1
    //   508: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   511: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokespecial 256	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   517: invokeinterface 163 3 0
    //   522: goto -80 -> 442
    //   525: astore_2
    //   526: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   529: ldc 165
    //   531: invokestatic 169	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   534: aload_0
    //   535: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   538: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   541: invokevirtual 172	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   544: aload_2
    //   545: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	546	0	this	1
    //   283	225	1	i	int
    //   35	74	2	localObject1	Object
    //   149	35	2	localIOException	java.io.IOException
    //   226	198	2	localObject2	Object
    //   525	20	2	localObject3	Object
    //   117	319	3	localObject4	Object
    //   394	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	99	149	java/io/IOException
    //   99	146	149	java/io/IOException
    //   208	329	149	java/io/IOException
    //   355	396	149	java/io/IOException
    //   401	408	149	java/io/IOException
    //   408	442	149	java/io/IOException
    //   461	522	149	java/io/IOException
    //   0	99	525	finally
    //   99	146	525	finally
    //   150	189	525	finally
    //   208	329	525	finally
    //   355	396	525	finally
    //   401	408	525	finally
    //   408	442	525	finally
    //   461	522	525	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper.1
 * JD-Core Version:    0.7.0.1
 */