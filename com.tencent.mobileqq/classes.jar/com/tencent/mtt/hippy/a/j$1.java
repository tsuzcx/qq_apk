package com.tencent.mtt.hippy.a;

import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import java.io.File;

class j$1
  implements HippyHttpAdapter.HttpTaskCallback
{
  j$1(j paramj, a parama, File paramFile, String paramString) {}
  
  public void onTaskFailed(HippyHttpRequest paramHippyHttpRequest, Throwable paramThrowable)
  {
    paramHippyHttpRequest = this.a;
    if (paramHippyHttpRequest != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not connect to development server.URL: ");
      localStringBuilder.append(this.c);
      localStringBuilder.append("  try to :adb reverse tcp:38989 tcp:38989 , message : ");
      localStringBuilder.append(paramThrowable.getMessage());
      paramHippyHttpRequest.a(new i(localStringBuilder.toString()));
    }
  }
  
  /* Error */
  public void onTaskSuccess(HippyHttpRequest paramHippyHttpRequest, com.tencent.mtt.hippy.adapter.http.HippyHttpResponse paramHippyHttpResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mtt/hippy/a/j$1:a	Lcom/tencent/mtt/hippy/a/a;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_2
    //   9: invokevirtual 70	com/tencent/mtt/hippy/adapter/http/HippyHttpResponse:getStatusCode	()Ljava/lang/Integer;
    //   12: invokevirtual 76	java/lang/Integer:intValue	()I
    //   15: sipush 200
    //   18: if_icmpne +330 -> 348
    //   21: aload_2
    //   22: invokevirtual 80	com/tencent/mtt/hippy/adapter/http/HippyHttpResponse:getInputStream	()Ljava/io/InputStream;
    //   25: ifnull +323 -> 348
    //   28: aload_0
    //   29: getfield 22	com/tencent/mtt/hippy/a/j$1:b	Ljava/io/File;
    //   32: astore 6
    //   34: aload 6
    //   36: ifnonnull +17 -> 53
    //   39: aload_0
    //   40: getfield 20	com/tencent/mtt/hippy/a/j$1:a	Lcom/tencent/mtt/hippy/a/a;
    //   43: aload_2
    //   44: invokevirtual 80	com/tencent/mtt/hippy/adapter/http/HippyHttpResponse:getInputStream	()Ljava/io/InputStream;
    //   47: invokeinterface 83 2 0
    //   52: return
    //   53: aconst_null
    //   54: astore 5
    //   56: aconst_null
    //   57: astore 4
    //   59: aload 4
    //   61: astore_1
    //   62: aload 6
    //   64: invokevirtual 89	java/io/File:exists	()Z
    //   67: ifeq +14 -> 81
    //   70: aload 4
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 22	com/tencent/mtt/hippy/a/j$1:b	Ljava/io/File;
    //   77: invokevirtual 92	java/io/File:delete	()Z
    //   80: pop
    //   81: aload 4
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 22	com/tencent/mtt/hippy/a/j$1:b	Ljava/io/File;
    //   88: invokevirtual 95	java/io/File:createNewFile	()Z
    //   91: pop
    //   92: aload 4
    //   94: astore_1
    //   95: new 97	java/io/FileOutputStream
    //   98: dup
    //   99: aload_0
    //   100: getfield 22	com/tencent/mtt/hippy/a/j$1:b	Ljava/io/File;
    //   103: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   106: astore 4
    //   108: sipush 2048
    //   111: newarray byte
    //   113: astore_1
    //   114: aload_2
    //   115: invokevirtual 80	com/tencent/mtt/hippy/adapter/http/HippyHttpResponse:getInputStream	()Ljava/io/InputStream;
    //   118: aload_1
    //   119: invokevirtual 106	java/io/InputStream:read	([B)I
    //   122: istore_3
    //   123: iload_3
    //   124: ifle +14 -> 138
    //   127: aload 4
    //   129: aload_1
    //   130: iconst_0
    //   131: iload_3
    //   132: invokevirtual 110	java/io/FileOutputStream:write	([BII)V
    //   135: goto -21 -> 114
    //   138: aload 4
    //   140: invokevirtual 113	java/io/FileOutputStream:flush	()V
    //   143: aload_0
    //   144: getfield 20	com/tencent/mtt/hippy/a/j$1:a	Lcom/tencent/mtt/hippy/a/a;
    //   147: ifnull +16 -> 163
    //   150: aload_0
    //   151: getfield 20	com/tencent/mtt/hippy/a/j$1:a	Lcom/tencent/mtt/hippy/a/a;
    //   154: aload_0
    //   155: getfield 22	com/tencent/mtt/hippy/a/j$1:b	Ljava/io/File;
    //   158: invokeinterface 115 2 0
    //   163: aload 4
    //   165: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   168: return
    //   169: astore_2
    //   170: new 32	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   177: astore_1
    //   178: goto +93 -> 271
    //   181: astore_2
    //   182: aload 4
    //   184: astore_1
    //   185: goto +112 -> 297
    //   188: astore_1
    //   189: aload 4
    //   191: astore_2
    //   192: aload_1
    //   193: astore 4
    //   195: goto +12 -> 207
    //   198: astore_2
    //   199: goto +98 -> 297
    //   202: astore 4
    //   204: aload 5
    //   206: astore_2
    //   207: aload_2
    //   208: astore_1
    //   209: new 32	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   216: astore 5
    //   218: aload_2
    //   219: astore_1
    //   220: aload 5
    //   222: ldc 120
    //   224: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_2
    //   229: astore_1
    //   230: aload 5
    //   232: aload 4
    //   234: invokevirtual 47	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   237: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_2
    //   242: astore_1
    //   243: ldc 122
    //   245: aload 5
    //   247: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 127	com/tencent/mtt/hippy/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_2
    //   254: ifnull +238 -> 492
    //   257: aload_2
    //   258: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   261: return
    //   262: astore_2
    //   263: new 32	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   270: astore_1
    //   271: aload_1
    //   272: ldc 120
    //   274: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_1
    //   279: aload_2
    //   280: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   283: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: ldc 122
    //   289: aload_1
    //   290: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 127	com/tencent/mtt/hippy/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: return
    //   297: aload_1
    //   298: ifnull +48 -> 346
    //   301: aload_1
    //   302: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   305: goto +41 -> 346
    //   308: astore_1
    //   309: new 32	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   316: astore 4
    //   318: aload 4
    //   320: ldc 120
    //   322: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 4
    //   328: aload_1
    //   329: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   332: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: ldc 122
    //   338: aload 4
    //   340: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 127	com/tencent/mtt/hippy/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: aload_2
    //   347: athrow
    //   348: aload_2
    //   349: invokevirtual 131	com/tencent/mtt/hippy/adapter/http/HippyHttpResponse:getErrorStream	()Ljava/io/InputStream;
    //   352: ifnull +68 -> 420
    //   355: new 133	java/lang/StringBuffer
    //   358: dup
    //   359: invokespecial 134	java/lang/StringBuffer:<init>	()V
    //   362: astore_1
    //   363: new 136	java/io/BufferedReader
    //   366: dup
    //   367: new 138	java/io/InputStreamReader
    //   370: dup
    //   371: aload_2
    //   372: invokevirtual 131	com/tencent/mtt/hippy/adapter/http/HippyHttpResponse:getErrorStream	()Ljava/io/InputStream;
    //   375: ldc 140
    //   377: invokespecial 143	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   380: invokespecial 146	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   383: astore_2
    //   384: aload_2
    //   385: invokevirtual 149	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   388: astore 4
    //   390: aload 4
    //   392: ifnull +20 -> 412
    //   395: aload_1
    //   396: aload 4
    //   398: invokevirtual 152	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   401: pop
    //   402: aload_1
    //   403: ldc 154
    //   405: invokevirtual 152	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   408: pop
    //   409: goto -25 -> 384
    //   412: aload_1
    //   413: invokevirtual 155	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   416: astore_1
    //   417: goto +6 -> 423
    //   420: ldc 157
    //   422: astore_1
    //   423: aload_0
    //   424: getfield 20	com/tencent/mtt/hippy/a/j$1:a	Lcom/tencent/mtt/hippy/a/a;
    //   427: astore_2
    //   428: aload_2
    //   429: ifnull +63 -> 492
    //   432: new 32	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   439: astore 4
    //   441: aload 4
    //   443: ldc 35
    //   445: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload 4
    //   451: aload_0
    //   452: getfield 24	com/tencent/mtt/hippy/a/j$1:c	Ljava/lang/String;
    //   455: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 4
    //   461: ldc 41
    //   463: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 4
    //   469: aload_1
    //   470: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload_2
    //   475: new 49	com/tencent/mtt/hippy/a/i
    //   478: dup
    //   479: aload 4
    //   481: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokespecial 55	com/tencent/mtt/hippy/a/i:<init>	(Ljava/lang/String;)V
    //   487: invokeinterface 60 2 0
    //   492: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	1
    //   0	493	1	paramHippyHttpRequest	HippyHttpRequest
    //   0	493	2	paramHippyHttpResponse	com.tencent.mtt.hippy.adapter.http.HippyHttpResponse
    //   122	10	3	i	int
    //   57	137	4	localObject1	Object
    //   202	31	4	localThrowable	Throwable
    //   316	164	4	localObject2	Object
    //   54	192	5	localStringBuilder	StringBuilder
    //   32	31	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   163	168	169	java/io/IOException
    //   108	114	181	finally
    //   114	123	181	finally
    //   127	135	181	finally
    //   138	163	181	finally
    //   108	114	188	java/lang/Throwable
    //   114	123	188	java/lang/Throwable
    //   127	135	188	java/lang/Throwable
    //   138	163	188	java/lang/Throwable
    //   62	70	198	finally
    //   73	81	198	finally
    //   84	92	198	finally
    //   95	108	198	finally
    //   209	218	198	finally
    //   220	228	198	finally
    //   230	241	198	finally
    //   243	253	198	finally
    //   62	70	202	java/lang/Throwable
    //   73	81	202	java/lang/Throwable
    //   84	92	202	java/lang/Throwable
    //   95	108	202	java/lang/Throwable
    //   257	261	262	java/io/IOException
    //   301	305	308	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.j.1
 * JD-Core Version:    0.7.0.1
 */