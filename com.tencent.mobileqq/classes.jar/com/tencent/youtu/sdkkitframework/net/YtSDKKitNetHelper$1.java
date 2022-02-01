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
    //   83: ifnull +66 -> 149
    //   86: aload_0
    //   87: getfield 23	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$requestHeader	Ljava/util/HashMap;
    //   90: invokevirtual 103	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   93: invokeinterface 109 1 0
    //   98: astore_2
    //   99: aload_2
    //   100: invokeinterface 115 1 0
    //   105: ifeq +44 -> 149
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
    //   149: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   152: ldc 139
    //   154: invokestatic 145	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   157: aload_0
    //   158: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   161: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   164: invokevirtual 149	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   167: astore_2
    //   168: new 151	java/io/BufferedWriter
    //   171: dup
    //   172: new 153	java/io/OutputStreamWriter
    //   175: dup
    //   176: aload_2
    //   177: ldc 155
    //   179: invokespecial 158	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   182: invokespecial 161	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   185: astore_3
    //   186: aload_3
    //   187: aload_0
    //   188: getfield 25	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$requestContent	Ljava/lang/String;
    //   191: invokevirtual 164	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   194: aload_3
    //   195: invokevirtual 167	java/io/BufferedWriter:flush	()V
    //   198: aload_3
    //   199: invokevirtual 170	java/io/BufferedWriter:close	()V
    //   202: aload_2
    //   203: invokevirtual 173	java/io/OutputStream:close	()V
    //   206: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   209: ldc 175
    //   211: invokestatic 145	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   214: aload_0
    //   215: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   218: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   221: invokevirtual 178	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   224: istore_1
    //   225: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   228: ldc 180
    //   230: invokestatic 145	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   233: aload_0
    //   234: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   237: invokestatic 40	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$100	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljava/util/HashMap;
    //   240: invokestatic 46	android/os/Process:myTid	()I
    //   243: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: invokevirtual 184	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   249: ifne +40 -> 289
    //   252: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   255: ldc 186
    //   257: invokestatic 189	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload_0
    //   261: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   264: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   267: invokevirtual 192	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   270: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   273: ldc 194
    //   275: invokestatic 145	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   278: aload_0
    //   279: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   282: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   285: invokevirtual 192	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   288: return
    //   289: iload_1
    //   290: sipush 200
    //   293: if_icmpne +93 -> 386
    //   296: new 196	java/io/BufferedReader
    //   299: dup
    //   300: new 198	java/io/InputStreamReader
    //   303: dup
    //   304: aload_0
    //   305: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   308: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   311: invokevirtual 202	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   314: invokespecial 205	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   317: invokespecial 208	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   320: astore_3
    //   321: new 210	java/lang/StringBuffer
    //   324: dup
    //   325: ldc 212
    //   327: invokespecial 213	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   330: astore_2
    //   331: aload_3
    //   332: invokevirtual 216	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   335: astore 4
    //   337: aload 4
    //   339: ifnull +10 -> 349
    //   342: aload_2
    //   343: aload 4
    //   345: invokevirtual 220	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   348: pop
    //   349: aload_3
    //   350: invokevirtual 221	java/io/BufferedReader:close	()V
    //   353: new 58	java/util/HashMap
    //   356: dup
    //   357: invokespecial 222	java/util/HashMap:<init>	()V
    //   360: astore_3
    //   361: aload_3
    //   362: ldc 224
    //   364: aload_2
    //   365: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   368: invokevirtual 62	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   371: pop
    //   372: aload_0
    //   373: getfield 27	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$parser	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$IYtSDKKitNetResponseParser;
    //   376: aload_3
    //   377: aconst_null
    //   378: invokeinterface 233 3 0
    //   383: goto +139 -> 522
    //   386: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   389: astore_2
    //   390: new 235	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   397: astore_3
    //   398: aload_3
    //   399: ldc 238
    //   401: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_3
    //   406: iload_1
    //   407: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_2
    //   412: aload_3
    //   413: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 248	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload_0
    //   420: getfield 27	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$parser	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$IYtSDKKitNetResponseParser;
    //   423: astore_2
    //   424: new 235	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   431: astore_3
    //   432: aload_3
    //   433: ldc 250
    //   435: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload_3
    //   440: iload_1
    //   441: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_2
    //   446: aconst_null
    //   447: new 252	java/lang/Exception
    //   450: dup
    //   451: aload_3
    //   452: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokespecial 253	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   458: invokeinterface 233 3 0
    //   463: goto +59 -> 522
    //   466: astore_2
    //   467: goto +74 -> 541
    //   470: astore_2
    //   471: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   474: astore_3
    //   475: new 235	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   482: astore 4
    //   484: aload 4
    //   486: ldc 238
    //   488: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 4
    //   494: aload_2
    //   495: invokevirtual 256	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   498: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload_3
    //   503: aload 4
    //   505: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 248	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: aload_0
    //   512: getfield 27	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:val$parser	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$IYtSDKKitNetResponseParser;
    //   515: aconst_null
    //   516: aload_2
    //   517: invokeinterface 233 3 0
    //   522: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   525: ldc 194
    //   527: invokestatic 145	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   530: aload_0
    //   531: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   534: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   537: invokevirtual 192	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   540: return
    //   541: invokestatic 137	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$300	()Ljava/lang/String;
    //   544: ldc 194
    //   546: invokestatic 145	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   549: aload_0
    //   550: getfield 19	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper$1:this$0	Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;
    //   553: invokestatic 81	com/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper:access$200	(Lcom/tencent/youtu/sdkkitframework/net/YtSDKKitNetHelper;)Ljavax/net/ssl/HttpsURLConnection;
    //   556: invokevirtual 192	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   559: goto +5 -> 564
    //   562: aload_2
    //   563: athrow
    //   564: goto -2 -> 562
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	567	0	this	1
    //   224	217	1	i	int
    //   35	411	2	localObject1	Object
    //   466	1	2	localObject2	Object
    //   470	93	2	localIOException	java.io.IOException
    //   117	386	3	localObject3	Object
    //   335	169	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	99	466	finally
    //   99	146	466	finally
    //   149	270	466	finally
    //   296	337	466	finally
    //   342	349	466	finally
    //   349	383	466	finally
    //   386	463	466	finally
    //   471	522	466	finally
    //   0	99	470	java/io/IOException
    //   99	146	470	java/io/IOException
    //   149	270	470	java/io/IOException
    //   296	337	470	java/io/IOException
    //   342	349	470	java/io/IOException
    //   349	383	470	java/io/IOException
    //   386	463	470	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper.1
 * JD-Core Version:    0.7.0.1
 */