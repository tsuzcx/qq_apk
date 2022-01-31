package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.a.a.a.a.g;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.l;
import java.util.Arrays;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

class i
{
  private static StatLogger d = ;
  private static i e = null;
  private static Context f = null;
  DefaultHttpClient a;
  com.tencent.wxop.stat.common.e b;
  StringBuilder c;
  private long g;
  
  /* Error */
  private i(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 38	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 40	com/tencent/wxop/stat/i:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 42	com/tencent/wxop/stat/i:b	Lcom/tencent/wxop/stat/common/e;
    //   14: aload_0
    //   15: new 44	java/lang/StringBuilder
    //   18: dup
    //   19: sipush 4096
    //   22: invokespecial 47	java/lang/StringBuilder:<init>	(I)V
    //   25: putfield 49	com/tencent/wxop/stat/i:c	Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: lconst_0
    //   30: putfield 51	com/tencent/wxop/stat/i:g	J
    //   33: aload_1
    //   34: invokevirtual 57	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   37: putstatic 31	com/tencent/wxop/stat/i:f	Landroid/content/Context;
    //   40: aload_0
    //   41: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   44: ldc2_w 64
    //   47: ldiv
    //   48: putfield 51	com/tencent/wxop/stat/i:g	J
    //   51: aload_0
    //   52: new 67	com/tencent/wxop/stat/common/e
    //   55: dup
    //   56: invokespecial 68	com/tencent/wxop/stat/common/e:<init>	()V
    //   59: putfield 42	com/tencent/wxop/stat/i:b	Lcom/tencent/wxop/stat/common/e;
    //   62: invokestatic 74	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   65: istore_2
    //   66: iload_2
    //   67: ifeq +65 -> 132
    //   70: ldc 76
    //   72: invokestatic 82	java/util/logging/Logger:getLogger	(Ljava/lang/String;)Ljava/util/logging/Logger;
    //   75: getstatic 88	java/util/logging/Level:FINER	Ljava/util/logging/Level;
    //   78: invokevirtual 92	java/util/logging/Logger:setLevel	(Ljava/util/logging/Level;)V
    //   81: ldc 94
    //   83: invokestatic 82	java/util/logging/Logger:getLogger	(Ljava/lang/String;)Ljava/util/logging/Logger;
    //   86: getstatic 88	java/util/logging/Level:FINER	Ljava/util/logging/Level;
    //   89: invokevirtual 92	java/util/logging/Logger:setLevel	(Ljava/util/logging/Level;)V
    //   92: ldc 96
    //   94: ldc 98
    //   96: invokestatic 102	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   99: pop
    //   100: ldc 104
    //   102: ldc 106
    //   104: invokestatic 102	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: pop
    //   108: ldc 108
    //   110: ldc 110
    //   112: invokestatic 102	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   115: pop
    //   116: ldc 112
    //   118: ldc 110
    //   120: invokestatic 102	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   123: pop
    //   124: ldc 114
    //   126: ldc 110
    //   128: invokestatic 102	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: pop
    //   132: new 116	org/apache/http/params/BasicHttpParams
    //   135: dup
    //   136: invokespecial 117	org/apache/http/params/BasicHttpParams:<init>	()V
    //   139: astore_1
    //   140: aload_1
    //   141: iconst_0
    //   142: invokestatic 123	org/apache/http/params/HttpConnectionParams:setStaleCheckingEnabled	(Lorg/apache/http/params/HttpParams;Z)V
    //   145: aload_1
    //   146: sipush 10000
    //   149: invokestatic 127	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   152: aload_1
    //   153: sipush 10000
    //   156: invokestatic 130	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   159: aload_0
    //   160: new 132	org/apache/http/impl/client/DefaultHttpClient
    //   163: dup
    //   164: aload_1
    //   165: invokespecial 135	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   168: putfield 40	com/tencent/wxop/stat/i:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   171: aload_0
    //   172: getfield 40	com/tencent/wxop/stat/i:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   175: new 137	com/tencent/wxop/stat/j
    //   178: dup
    //   179: aload_0
    //   180: invokespecial 140	com/tencent/wxop/stat/j:<init>	(Lcom/tencent/wxop/stat/i;)V
    //   183: invokevirtual 144	org/apache/http/impl/client/DefaultHttpClient:setKeepAliveStrategy	(Lorg/apache/http/conn/ConnectionKeepAliveStrategy;)V
    //   186: return
    //   187: astore_1
    //   188: getstatic 27	com/tencent/wxop/stat/i:d	Lcom/tencent/wxop/stat/common/StatLogger;
    //   191: aload_1
    //   192: invokevirtual 149	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   195: return
    //   196: astore_1
    //   197: goto -65 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	i
    //   0	200	1	paramContext	Context
    //   65	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   33	66	187	java/lang/Throwable
    //   132	186	187	java/lang/Throwable
    //   70	132	196	java/lang/Throwable
  }
  
  static Context a()
  {
    return f;
  }
  
  static void a(Context paramContext)
  {
    f = paramContext.getApplicationContext();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = paramJSONObject.optString("mid");
      if (com.tencent.a.a.a.a.h.c((String)localObject))
      {
        if (StatConfig.isDebugEnable()) {
          d.i("update mid:" + (String)localObject);
        }
        g.C(f).a((String)localObject);
      }
      if (!paramJSONObject.isNull("cfg"))
      {
        localObject = paramJSONObject.getJSONObject("cfg");
        StatConfig.a(f, (JSONObject)localObject);
      }
      if (!paramJSONObject.isNull("ncts"))
      {
        int i = paramJSONObject.getInt("ncts");
        int j = (int)(i - System.currentTimeMillis() / 1000L);
        if (StatConfig.isDebugEnable()) {
          d.i("server time:" + i + ", diff time:" + j);
        }
        l.x(f);
        l.a(f, j);
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      d.w(paramJSONObject);
    }
  }
  
  static i b(Context paramContext)
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new i(paramContext);
      }
      return e;
    }
    finally {}
  }
  
  void a(com.tencent.wxop.stat.event.e parame, h paramh)
  {
    b(Arrays.asList(new String[] { parame.g() }), paramh);
  }
  
  /* Error */
  void a(List<?> paramList, h paramh)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnull +12 -> 16
    //   7: aload_1
    //   8: invokeinterface 246 1 0
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: aload_1
    //   18: invokeinterface 250 1 0
    //   23: istore 5
    //   25: aload_1
    //   26: iconst_0
    //   27: invokeinterface 254 2 0
    //   32: pop
    //   33: aload_0
    //   34: getfield 49	com/tencent/wxop/stat/i:c	Ljava/lang/StringBuilder;
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 49	com/tencent/wxop/stat/i:c	Ljava/lang/StringBuilder;
    //   42: invokevirtual 257	java/lang/StringBuilder:length	()I
    //   45: invokevirtual 261	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_0
    //   50: getfield 49	com/tencent/wxop/stat/i:c	Ljava/lang/StringBuilder;
    //   53: ldc_w 263
    //   56: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: iconst_0
    //   61: istore_3
    //   62: iload_3
    //   63: iload 5
    //   65: if_icmpge +43 -> 108
    //   68: aload_0
    //   69: getfield 49	com/tencent/wxop/stat/i:c	Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: iload_3
    //   74: invokeinterface 254 2 0
    //   79: invokevirtual 264	java/lang/Object:toString	()Ljava/lang/String;
    //   82: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: iload_3
    //   87: iload 5
    //   89: iconst_1
    //   90: isub
    //   91: if_icmpeq +1095 -> 1186
    //   94: aload_0
    //   95: getfield 49	com/tencent/wxop/stat/i:c	Ljava/lang/StringBuilder;
    //   98: ldc_w 266
    //   101: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: goto +1081 -> 1186
    //   108: aload_0
    //   109: getfield 49	com/tencent/wxop/stat/i:c	Ljava/lang/StringBuilder;
    //   112: ldc_w 268
    //   115: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_0
    //   120: getfield 49	com/tencent/wxop/stat/i:c	Ljava/lang/StringBuilder;
    //   123: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 269	java/lang/String:length	()I
    //   131: istore 6
    //   133: new 44	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   140: invokestatic 273	com/tencent/wxop/stat/StatConfig:getStatReportUrl	()Ljava/lang/String;
    //   143: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 275
    //   149: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 51	com/tencent/wxop/stat/i:g	J
    //   156: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   159: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore 9
    //   164: aload_0
    //   165: aload_0
    //   166: getfield 51	com/tencent/wxop/stat/i:g	J
    //   169: lconst_1
    //   170: ladd
    //   171: putfield 51	com/tencent/wxop/stat/i:g	J
    //   174: invokestatic 74	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   177: ifeq +48 -> 225
    //   180: getstatic 27	com/tencent/wxop/stat/i:d	Lcom/tencent/wxop/stat/common/StatLogger;
    //   183: new 44	java/lang/StringBuilder
    //   186: dup
    //   187: ldc_w 263
    //   190: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload 9
    //   195: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 280
    //   201: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload 6
    //   206: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: ldc_w 282
    //   212: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokevirtual 180	com/tencent/wxop/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   225: new 284	org/apache/http/client/methods/HttpPost
    //   228: dup
    //   229: aload 9
    //   231: invokespecial 285	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   234: astore 11
    //   236: aload 11
    //   238: ldc_w 287
    //   241: ldc_w 289
    //   244: invokevirtual 293	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload 11
    //   249: ldc_w 295
    //   252: ldc_w 297
    //   255: invokevirtual 300	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload 11
    //   260: ldc_w 302
    //   263: invokevirtual 305	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   266: getstatic 31	com/tencent/wxop/stat/i:f	Landroid/content/Context;
    //   269: invokestatic 310	com/tencent/wxop/stat/a:a	(Landroid/content/Context;)Lcom/tencent/wxop/stat/a;
    //   272: invokevirtual 313	com/tencent/wxop/stat/a:a	()Lorg/apache/http/HttpHost;
    //   275: astore 12
    //   277: aload 11
    //   279: ldc_w 315
    //   282: ldc_w 317
    //   285: invokevirtual 293	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload 12
    //   290: ifnonnull +417 -> 707
    //   293: aload_0
    //   294: getfield 40	com/tencent/wxop/stat/i:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   297: invokevirtual 321	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   300: ldc_w 323
    //   303: invokeinterface 328 2 0
    //   308: pop
    //   309: new 330	java/io/ByteArrayOutputStream
    //   312: dup
    //   313: iload 6
    //   315: invokespecial 331	java/io/ByteArrayOutputStream:<init>	(I)V
    //   318: astore 10
    //   320: aload_1
    //   321: ldc_w 333
    //   324: invokevirtual 337	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   327: astore 9
    //   329: aload 9
    //   331: arraylength
    //   332: istore 5
    //   334: iload 4
    //   336: istore_3
    //   337: iload 6
    //   339: getstatic 341	com/tencent/wxop/stat/StatConfig:o	I
    //   342: if_icmple +5 -> 347
    //   345: iconst_1
    //   346: istore_3
    //   347: aload 9
    //   349: astore_1
    //   350: iload_3
    //   351: ifeq +167 -> 518
    //   354: aload 11
    //   356: ldc_w 315
    //   359: invokevirtual 305	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   362: new 44	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 317
    //   372: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc_w 343
    //   378: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: astore_1
    //   385: aload 11
    //   387: ldc_w 315
    //   390: aload_1
    //   391: invokevirtual 293	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload 12
    //   396: ifnull +20 -> 416
    //   399: aload 11
    //   401: ldc_w 345
    //   404: invokevirtual 305	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   407: aload 11
    //   409: ldc_w 345
    //   412: aload_1
    //   413: invokevirtual 293	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload 10
    //   418: iconst_4
    //   419: newarray byte
    //   421: invokevirtual 349	java/io/ByteArrayOutputStream:write	([B)V
    //   424: new 351	java/util/zip/GZIPOutputStream
    //   427: dup
    //   428: aload 10
    //   430: invokespecial 354	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   433: astore_1
    //   434: aload_1
    //   435: aload 9
    //   437: invokevirtual 355	java/util/zip/GZIPOutputStream:write	([B)V
    //   440: aload_1
    //   441: invokevirtual 358	java/util/zip/GZIPOutputStream:close	()V
    //   444: aload 10
    //   446: invokevirtual 362	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   449: astore 9
    //   451: aload 9
    //   453: iconst_0
    //   454: iconst_4
    //   455: invokestatic 368	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   458: iload 5
    //   460: invokevirtual 372	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   463: pop
    //   464: aload 9
    //   466: astore_1
    //   467: invokestatic 74	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   470: ifeq +48 -> 518
    //   473: getstatic 27	com/tencent/wxop/stat/i:d	Lcom/tencent/wxop/stat/common/StatLogger;
    //   476: new 44	java/lang/StringBuilder
    //   479: dup
    //   480: ldc_w 374
    //   483: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   486: iload 5
    //   488: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: ldc_w 376
    //   494: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 9
    //   499: arraylength
    //   500: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: ldc_w 378
    //   506: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokevirtual 380	com/tencent/wxop/stat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   515: aload 9
    //   517: astore_1
    //   518: aload 11
    //   520: new 382	org/apache/http/entity/ByteArrayEntity
    //   523: dup
    //   524: aload_1
    //   525: invokestatic 387	com/tencent/wxop/stat/common/f:a	([B)[B
    //   528: invokespecial 389	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   531: invokevirtual 393	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   534: aload_0
    //   535: getfield 40	com/tencent/wxop/stat/i:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   538: aload 11
    //   540: invokevirtual 397	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   543: astore_1
    //   544: aload_1
    //   545: invokeinterface 403 1 0
    //   550: astore 9
    //   552: aload_1
    //   553: invokeinterface 407 1 0
    //   558: invokeinterface 412 1 0
    //   563: istore_3
    //   564: aload 9
    //   566: invokeinterface 417 1 0
    //   571: lstore 7
    //   573: invokestatic 74	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   576: ifeq +37 -> 613
    //   579: getstatic 27	com/tencent/wxop/stat/i:d	Lcom/tencent/wxop/stat/common/StatLogger;
    //   582: new 44	java/lang/StringBuilder
    //   585: dup
    //   586: ldc_w 419
    //   589: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   592: iload_3
    //   593: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: ldc_w 421
    //   599: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: lload 7
    //   604: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   607: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokevirtual 180	com/tencent/wxop/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   613: lload 7
    //   615: lconst_0
    //   616: lcmp
    //   617: ifgt +191 -> 808
    //   620: getstatic 27	com/tencent/wxop/stat/i:d	Lcom/tencent/wxop/stat/common/StatLogger;
    //   623: ldc_w 423
    //   626: invokevirtual 425	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   629: aload_2
    //   630: ifnull +9 -> 639
    //   633: aload_2
    //   634: invokeinterface 429 1 0
    //   639: aload 9
    //   641: invokestatic 434	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   644: pop
    //   645: return
    //   646: astore_1
    //   647: aload_1
    //   648: ifnull -632 -> 16
    //   651: getstatic 27	com/tencent/wxop/stat/i:d	Lcom/tencent/wxop/stat/common/StatLogger;
    //   654: aload_1
    //   655: invokevirtual 437	com/tencent/wxop/stat/common/StatLogger:error	(Ljava/lang/Throwable;)V
    //   658: aload_2
    //   659: ifnull +9 -> 668
    //   662: aload_2
    //   663: invokeinterface 429 1 0
    //   668: aload_1
    //   669: instanceof 439
    //   672: ifeq +25 -> 697
    //   675: invokestatic 442	java/lang/System:gc	()V
    //   678: aload_0
    //   679: aconst_null
    //   680: putfield 49	com/tencent/wxop/stat/i:c	Ljava/lang/StringBuilder;
    //   683: aload_0
    //   684: new 44	java/lang/StringBuilder
    //   687: dup
    //   688: sipush 2048
    //   691: invokespecial 47	java/lang/StringBuilder:<init>	(I)V
    //   694: putfield 49	com/tencent/wxop/stat/i:c	Ljava/lang/StringBuilder;
    //   697: getstatic 31	com/tencent/wxop/stat/i:f	Landroid/content/Context;
    //   700: invokestatic 310	com/tencent/wxop/stat/a:a	(Landroid/content/Context;)Lcom/tencent/wxop/stat/a;
    //   703: invokevirtual 444	com/tencent/wxop/stat/a:d	()V
    //   706: return
    //   707: invokestatic 74	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   710: ifeq +30 -> 740
    //   713: getstatic 27	com/tencent/wxop/stat/i:d	Lcom/tencent/wxop/stat/common/StatLogger;
    //   716: new 44	java/lang/StringBuilder
    //   719: dup
    //   720: ldc_w 446
    //   723: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   726: aload 12
    //   728: invokevirtual 451	org/apache/http/HttpHost:toHostString	()Ljava/lang/String;
    //   731: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokevirtual 380	com/tencent/wxop/stat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   740: aload 11
    //   742: ldc_w 345
    //   745: ldc_w 317
    //   748: invokevirtual 293	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload_0
    //   752: getfield 40	com/tencent/wxop/stat/i:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   755: invokevirtual 321	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   758: ldc_w 323
    //   761: aload 12
    //   763: invokeinterface 455 3 0
    //   768: pop
    //   769: aload 11
    //   771: ldc_w 457
    //   774: getstatic 461	com/tencent/wxop/stat/StatConfig:k	Ljava/lang/String;
    //   777: invokevirtual 293	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   780: aload 11
    //   782: ldc_w 463
    //   785: ldc_w 465
    //   788: invokevirtual 293	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   791: aload 11
    //   793: ldc_w 467
    //   796: ldc_w 469
    //   799: invokevirtual 293	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: goto -493 -> 309
    //   805: astore_1
    //   806: aload_1
    //   807: athrow
    //   808: lload 7
    //   810: lconst_0
    //   811: lcmp
    //   812: ifle +354 -> 1166
    //   815: aload 9
    //   817: invokeinterface 473 1 0
    //   822: astore 11
    //   824: new 475	java/io/DataInputStream
    //   827: dup
    //   828: aload 11
    //   830: invokespecial 478	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   833: astore 12
    //   835: aload 9
    //   837: invokeinterface 417 1 0
    //   842: l2i
    //   843: newarray byte
    //   845: astore 9
    //   847: aload 12
    //   849: aload 9
    //   851: invokevirtual 481	java/io/DataInputStream:readFully	([B)V
    //   854: aload 11
    //   856: invokevirtual 484	java/io/InputStream:close	()V
    //   859: aload 12
    //   861: invokevirtual 485	java/io/DataInputStream:close	()V
    //   864: aload_1
    //   865: ldc_w 315
    //   868: invokeinterface 489 2 0
    //   873: astore 12
    //   875: aload 9
    //   877: astore_1
    //   878: aload 12
    //   880: ifnull +28 -> 908
    //   883: aload 12
    //   885: invokeinterface 494 1 0
    //   890: ldc_w 496
    //   893: invokevirtual 499	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   896: ifeq +115 -> 1011
    //   899: aload 9
    //   901: invokestatic 500	com/tencent/wxop/stat/common/l:a	([B)[B
    //   904: invokestatic 502	com/tencent/wxop/stat/common/f:b	([B)[B
    //   907: astore_1
    //   908: new 228	java/lang/String
    //   911: dup
    //   912: aload_1
    //   913: ldc_w 333
    //   916: invokespecial 505	java/lang/String:<init>	([BLjava/lang/String;)V
    //   919: astore 9
    //   921: invokestatic 74	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   924: ifeq +27 -> 951
    //   927: getstatic 27	com/tencent/wxop/stat/i:d	Lcom/tencent/wxop/stat/common/StatLogger;
    //   930: new 44	java/lang/StringBuilder
    //   933: dup
    //   934: ldc_w 507
    //   937: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   940: aload 9
    //   942: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: invokevirtual 180	com/tencent/wxop/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   951: new 154	org/json/JSONObject
    //   954: dup
    //   955: aload 9
    //   957: invokespecial 508	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   960: astore 9
    //   962: iload_3
    //   963: sipush 200
    //   966: if_icmpne +144 -> 1110
    //   969: aload_0
    //   970: aload 9
    //   972: invokespecial 510	com/tencent/wxop/stat/i:a	(Lorg/json/JSONObject;)V
    //   975: aload_2
    //   976: ifnull +20 -> 996
    //   979: aload 9
    //   981: ldc_w 512
    //   984: invokevirtual 515	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   987: ifne +105 -> 1092
    //   990: aload_2
    //   991: invokeinterface 517 1 0
    //   996: aload 11
    //   998: invokevirtual 484	java/io/InputStream:close	()V
    //   1001: aload 10
    //   1003: invokevirtual 518	java/io/ByteArrayOutputStream:close	()V
    //   1006: aconst_null
    //   1007: astore_1
    //   1008: goto -361 -> 647
    //   1011: aload 12
    //   1013: invokeinterface 494 1 0
    //   1018: ldc_w 520
    //   1021: invokevirtual 499	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1024: ifeq +15 -> 1039
    //   1027: aload 9
    //   1029: invokestatic 502	com/tencent/wxop/stat/common/f:b	([B)[B
    //   1032: invokestatic 500	com/tencent/wxop/stat/common/l:a	([B)[B
    //   1035: astore_1
    //   1036: goto -128 -> 908
    //   1039: aload 12
    //   1041: invokeinterface 494 1 0
    //   1046: ldc_w 289
    //   1049: invokevirtual 499	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1052: ifeq +12 -> 1064
    //   1055: aload 9
    //   1057: invokestatic 500	com/tencent/wxop/stat/common/l:a	([B)[B
    //   1060: astore_1
    //   1061: goto -153 -> 908
    //   1064: aload 9
    //   1066: astore_1
    //   1067: aload 12
    //   1069: invokeinterface 494 1 0
    //   1074: ldc_w 317
    //   1077: invokevirtual 499	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1080: ifeq -172 -> 908
    //   1083: aload 9
    //   1085: invokestatic 502	com/tencent/wxop/stat/common/f:b	([B)[B
    //   1088: astore_1
    //   1089: goto -181 -> 908
    //   1092: getstatic 27	com/tencent/wxop/stat/i:d	Lcom/tencent/wxop/stat/common/StatLogger;
    //   1095: ldc_w 522
    //   1098: invokevirtual 524	com/tencent/wxop/stat/common/StatLogger:error	(Ljava/lang/Object;)V
    //   1101: aload_2
    //   1102: invokeinterface 429 1 0
    //   1107: goto -111 -> 996
    //   1110: getstatic 27	com/tencent/wxop/stat/i:d	Lcom/tencent/wxop/stat/common/StatLogger;
    //   1113: new 44	java/lang/StringBuilder
    //   1116: dup
    //   1117: ldc_w 526
    //   1120: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1123: iload_3
    //   1124: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1127: ldc_w 528
    //   1130: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: new 228	java/lang/String
    //   1136: dup
    //   1137: aload_1
    //   1138: ldc_w 333
    //   1141: invokespecial 505	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1144: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1150: invokevirtual 524	com/tencent/wxop/stat/common/StatLogger:error	(Ljava/lang/Object;)V
    //   1153: aload_2
    //   1154: ifnull -158 -> 996
    //   1157: aload_2
    //   1158: invokeinterface 429 1 0
    //   1163: goto -167 -> 996
    //   1166: aload 9
    //   1168: invokestatic 434	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1171: pop
    //   1172: goto -171 -> 1001
    //   1175: astore_2
    //   1176: getstatic 27	com/tencent/wxop/stat/i:d	Lcom/tencent/wxop/stat/common/StatLogger;
    //   1179: aload_2
    //   1180: invokevirtual 149	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1183: goto -515 -> 668
    //   1186: iload_3
    //   1187: iconst_1
    //   1188: iadd
    //   1189: istore_3
    //   1190: goto -1128 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1193	0	this	i
    //   0	1193	1	paramList	List<?>
    //   0	1193	2	paramh	h
    //   61	1129	3	i	int
    //   1	334	4	j	int
    //   23	464	5	k	int
    //   131	212	6	m	int
    //   571	238	7	l	long
    //   162	1005	9	localObject1	Object
    //   318	684	10	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   234	763	11	localObject2	Object
    //   275	793	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   33	60	646	java/lang/Throwable
    //   68	86	646	java/lang/Throwable
    //   94	105	646	java/lang/Throwable
    //   108	225	646	java/lang/Throwable
    //   225	288	646	java/lang/Throwable
    //   293	309	646	java/lang/Throwable
    //   309	334	646	java/lang/Throwable
    //   337	345	646	java/lang/Throwable
    //   354	394	646	java/lang/Throwable
    //   399	416	646	java/lang/Throwable
    //   416	464	646	java/lang/Throwable
    //   467	515	646	java/lang/Throwable
    //   518	613	646	java/lang/Throwable
    //   620	629	646	java/lang/Throwable
    //   633	639	646	java/lang/Throwable
    //   639	645	646	java/lang/Throwable
    //   707	740	646	java/lang/Throwable
    //   740	802	646	java/lang/Throwable
    //   815	875	646	java/lang/Throwable
    //   883	908	646	java/lang/Throwable
    //   908	951	646	java/lang/Throwable
    //   951	962	646	java/lang/Throwable
    //   969	975	646	java/lang/Throwable
    //   979	996	646	java/lang/Throwable
    //   996	1001	646	java/lang/Throwable
    //   1001	1006	646	java/lang/Throwable
    //   1011	1036	646	java/lang/Throwable
    //   1039	1061	646	java/lang/Throwable
    //   1067	1089	646	java/lang/Throwable
    //   1092	1107	646	java/lang/Throwable
    //   1110	1153	646	java/lang/Throwable
    //   1157	1163	646	java/lang/Throwable
    //   1166	1172	646	java/lang/Throwable
    //   33	60	805	finally
    //   68	86	805	finally
    //   94	105	805	finally
    //   108	225	805	finally
    //   225	288	805	finally
    //   293	309	805	finally
    //   309	334	805	finally
    //   337	345	805	finally
    //   354	394	805	finally
    //   399	416	805	finally
    //   416	464	805	finally
    //   467	515	805	finally
    //   518	613	805	finally
    //   620	629	805	finally
    //   633	639	805	finally
    //   639	645	805	finally
    //   707	740	805	finally
    //   740	802	805	finally
    //   815	875	805	finally
    //   883	908	805	finally
    //   908	951	805	finally
    //   951	962	805	finally
    //   969	975	805	finally
    //   979	996	805	finally
    //   996	1001	805	finally
    //   1001	1006	805	finally
    //   1011	1036	805	finally
    //   1039	1061	805	finally
    //   1067	1089	805	finally
    //   1092	1107	805	finally
    //   1110	1153	805	finally
    //   1157	1163	805	finally
    //   1166	1172	805	finally
    //   662	668	1175	java/lang/Throwable
  }
  
  void b(List<?> paramList, h paramh)
  {
    if (this.b != null) {
      this.b.a(new k(this, paramList, paramh));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.i
 * JD-Core Version:    0.7.0.1
 */