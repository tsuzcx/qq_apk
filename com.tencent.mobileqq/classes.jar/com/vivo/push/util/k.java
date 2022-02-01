package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.vivo.push.c.r.a;
import com.vivo.push.model.InsideNotificationItem;
import java.util.List;

public final class k
  extends AsyncTask<String, Void, List<Bitmap>>
{
  private Context a;
  private InsideNotificationItem b;
  private long c;
  private boolean d;
  private int e = 0;
  private r.a f;
  
  public k(Context paramContext, InsideNotificationItem paramInsideNotificationItem, long paramLong, boolean paramBoolean, r.a parama)
  {
    this.a = paramContext;
    this.b = paramInsideNotificationItem;
    this.c = paramLong;
    this.d = paramBoolean;
    this.f = parama;
  }
  
  /* Error */
  private List<Bitmap> a(String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 26	com/vivo/push/util/k:a	Landroid/content/Context;
    //   5: invokestatic 48	com/vivo/push/cache/ClientConfigManagerImpl:getInstance	(Landroid/content/Context;)Lcom/vivo/push/cache/ClientConfigManagerImpl;
    //   8: invokevirtual 52	com/vivo/push/cache/ClientConfigManagerImpl:getNotifyStyle	()I
    //   11: putfield 24	com/vivo/push/util/k:e	I
    //   14: aload_0
    //   15: getfield 32	com/vivo/push/util/k:d	Z
    //   18: istore 4
    //   20: aconst_null
    //   21: astore 8
    //   23: iload 4
    //   25: ifne +13 -> 38
    //   28: ldc 54
    //   30: ldc 56
    //   32: invokestatic 61	com/vivo/push/util/o:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   35: pop
    //   36: aconst_null
    //   37: areturn
    //   38: new 63	java/util/ArrayList
    //   41: dup
    //   42: invokespecial 64	java/util/ArrayList:<init>	()V
    //   45: astore 9
    //   47: iconst_0
    //   48: istore_2
    //   49: iload_2
    //   50: iconst_2
    //   51: if_icmpge +292 -> 343
    //   54: aload_1
    //   55: iload_2
    //   56: aaload
    //   57: astore 5
    //   59: new 66	java/lang/StringBuilder
    //   62: dup
    //   63: ldc 68
    //   65: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: astore 6
    //   70: aload 6
    //   72: aload 5
    //   74: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 6
    //   80: ldc 77
    //   82: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 6
    //   88: iload_2
    //   89: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 54
    //   95: aload 6
    //   97: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 61	com/vivo/push/util/o:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   103: pop
    //   104: aload 5
    //   106: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifne +214 -> 323
    //   112: new 92	java/net/URL
    //   115: dup
    //   116: aload 5
    //   118: invokespecial 93	java/net/URL:<init>	(Ljava/lang/String;)V
    //   121: invokevirtual 97	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   124: checkcast 99	java/net/HttpURLConnection
    //   127: astore 5
    //   129: aload 5
    //   131: sipush 30000
    //   134: invokevirtual 103	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   137: aload 5
    //   139: iconst_1
    //   140: invokevirtual 107	java/net/HttpURLConnection:setDoInput	(Z)V
    //   143: aload 5
    //   145: iconst_0
    //   146: invokevirtual 110	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   149: aload 5
    //   151: invokevirtual 113	java/net/HttpURLConnection:connect	()V
    //   154: aload 5
    //   156: invokevirtual 116	java/net/HttpURLConnection:getResponseCode	()I
    //   159: istore_3
    //   160: ldc 54
    //   162: ldc 118
    //   164: iload_3
    //   165: invokestatic 124	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   168: invokevirtual 128	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   171: invokestatic 130	com/vivo/push/util/o:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: iload_3
    //   176: sipush 200
    //   179: if_icmpne +28 -> 207
    //   182: aload 5
    //   184: invokevirtual 134	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   187: astore 6
    //   189: aload 6
    //   191: astore 5
    //   193: aload 6
    //   195: invokestatic 140	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   198: astore 7
    //   200: aload 7
    //   202: astore 5
    //   204: goto +10 -> 214
    //   207: aconst_null
    //   208: astore 6
    //   210: aload 6
    //   212: astore 5
    //   214: aload 5
    //   216: astore 7
    //   218: aload 6
    //   220: ifnull +77 -> 297
    //   223: aload 6
    //   225: invokevirtual 145	java/io/InputStream:close	()V
    //   228: aload 5
    //   230: astore 7
    //   232: goto +65 -> 297
    //   235: astore_1
    //   236: aload 8
    //   238: astore 5
    //   240: goto +71 -> 311
    //   243: aconst_null
    //   244: astore 6
    //   246: aload 6
    //   248: astore 5
    //   250: ldc 54
    //   252: ldc 147
    //   254: invokestatic 149	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: aload 6
    //   260: ifnull +34 -> 294
    //   263: aload 6
    //   265: invokevirtual 145	java/io/InputStream:close	()V
    //   268: goto +26 -> 294
    //   271: aconst_null
    //   272: astore 6
    //   274: aload 6
    //   276: astore 5
    //   278: ldc 54
    //   280: ldc 151
    //   282: invokestatic 149	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   285: pop
    //   286: aload 6
    //   288: ifnull +6 -> 294
    //   291: goto -28 -> 263
    //   294: aconst_null
    //   295: astore 7
    //   297: aload 9
    //   299: aload 7
    //   301: invokeinterface 157 2 0
    //   306: pop
    //   307: goto +29 -> 336
    //   310: astore_1
    //   311: aload 5
    //   313: ifnull +8 -> 321
    //   316: aload 5
    //   318: invokevirtual 145	java/io/InputStream:close	()V
    //   321: aload_1
    //   322: athrow
    //   323: iload_2
    //   324: ifne +12 -> 336
    //   327: aload 9
    //   329: aconst_null
    //   330: invokeinterface 157 2 0
    //   335: pop
    //   336: iload_2
    //   337: iconst_1
    //   338: iadd
    //   339: istore_2
    //   340: goto -291 -> 49
    //   343: aload 9
    //   345: areturn
    //   346: astore 5
    //   348: goto -77 -> 271
    //   351: astore 5
    //   353: goto -110 -> 243
    //   356: astore 5
    //   358: goto -84 -> 274
    //   361: astore 5
    //   363: goto -117 -> 246
    //   366: astore 6
    //   368: aload 5
    //   370: astore 7
    //   372: goto -75 -> 297
    //   375: astore 5
    //   377: goto -83 -> 294
    //   380: astore 5
    //   382: goto -61 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	k
    //   0	385	1	paramVarArgs	String[]
    //   48	292	2	i	int
    //   159	21	3	j	int
    //   18	6	4	bool	boolean
    //   57	260	5	localObject1	java.lang.Object
    //   346	1	5	localMalformedURLException1	java.net.MalformedURLException
    //   351	1	5	localIOException1	java.io.IOException
    //   356	1	5	localMalformedURLException2	java.net.MalformedURLException
    //   361	8	5	localIOException2	java.io.IOException
    //   375	1	5	localException1	java.lang.Exception
    //   380	1	5	localException2	java.lang.Exception
    //   68	219	6	localObject2	java.lang.Object
    //   366	1	6	localException3	java.lang.Exception
    //   198	173	7	localObject3	java.lang.Object
    //   21	216	8	localObject4	java.lang.Object
    //   45	299	9	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   112	175	235	finally
    //   182	189	235	finally
    //   193	200	310	finally
    //   250	258	310	finally
    //   278	286	310	finally
    //   112	175	346	java/net/MalformedURLException
    //   182	189	346	java/net/MalformedURLException
    //   112	175	351	java/io/IOException
    //   182	189	351	java/io/IOException
    //   193	200	356	java/net/MalformedURLException
    //   193	200	361	java/io/IOException
    //   223	228	366	java/lang/Exception
    //   263	268	375	java/lang/Exception
    //   316	321	380	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.k
 * JD-Core Version:    0.7.0.1
 */