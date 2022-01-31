package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.DeviceInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import java.util.Arrays;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

class g
{
  private static StatLogger d = ;
  private static g e = null;
  private static Context f = null;
  DefaultHttpClient a = null;
  Handler b = null;
  StringBuilder c = new StringBuilder(4096);
  private long g = 0L;
  
  private g(Context paramContext)
  {
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("StatDispatcher");
      localHandlerThread.start();
      this.b = new Handler(localHandlerThread.getLooper());
      f = paramContext.getApplicationContext();
      this.g = (System.currentTimeMillis() / 1000L);
      paramContext = new BasicHttpParams();
      HttpConnectionParams.setStaleCheckingEnabled(paramContext, false);
      HttpConnectionParams.setConnectionTimeout(paramContext, 10000);
      HttpConnectionParams.setSoTimeout(paramContext, 10000);
      this.a = new DefaultHttpClient(paramContext);
      this.a.setKeepAliveStrategy(new h(this));
      return;
    }
    catch (Throwable paramContext)
    {
      d.e(paramContext);
    }
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
      if (com.tencent.stat.a.a.i.c((String)localObject))
      {
        if (StatConfig.isDebugEnable()) {
          d.i("update mid:" + (String)localObject);
        }
        com.tencent.stat.a.a.d locald = new com.tencent.stat.a.a.d();
        locald.a = af.a(f).b(f).getImei();
        locald.b = af.a(f).b(f).getMac();
        locald.d = System.currentTimeMillis();
        locald.c = ((String)localObject);
        com.tencent.stat.a.a.h.a(f).a(locald);
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
        StatCommonHelper.updateCheckTime(f);
        StatCommonHelper.writeDiffTimeFromServer(f, j);
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      d.w(paramJSONObject);
    }
  }
  
  static g b(Context paramContext)
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new g(paramContext);
      }
      return e;
    }
    finally {}
  }
  
  void a(com.tencent.stat.event.d paramd, StatDispatchCallback paramStatDispatchCallback)
  {
    b(Arrays.asList(new String[] { paramd.g() }), paramStatDispatchCallback);
  }
  
  /* Error */
  void a(List<?> paramList, StatDispatchCallback paramStatDispatchCallback)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnull +12 -> 16
    //   7: aload_1
    //   8: invokeinterface 250 1 0
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: aload_1
    //   18: invokeinterface 254 1 0
    //   23: istore 5
    //   25: aload_0
    //   26: getfield 50	com/tencent/stat/g:c	Ljava/lang/StringBuilder;
    //   29: iconst_0
    //   30: aload_0
    //   31: getfield 50	com/tencent/stat/g:c	Ljava/lang/StringBuilder;
    //   34: invokevirtual 257	java/lang/StringBuilder:length	()I
    //   37: invokevirtual 261	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_0
    //   42: getfield 50	com/tencent/stat/g:c	Ljava/lang/StringBuilder;
    //   45: ldc_w 263
    //   48: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: iconst_0
    //   53: istore_3
    //   54: iload_3
    //   55: iload 5
    //   57: if_icmpge +43 -> 100
    //   60: aload_0
    //   61: getfield 50	com/tencent/stat/g:c	Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: iload_3
    //   66: invokeinterface 267 2 0
    //   71: invokevirtual 268	java/lang/Object:toString	()Ljava/lang/String;
    //   74: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: iload_3
    //   79: iload 5
    //   81: iconst_1
    //   82: isub
    //   83: if_icmpeq +1114 -> 1197
    //   86: aload_0
    //   87: getfield 50	com/tencent/stat/g:c	Ljava/lang/StringBuilder;
    //   90: ldc_w 270
    //   93: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: goto +1100 -> 1197
    //   100: aload_0
    //   101: getfield 50	com/tencent/stat/g:c	Ljava/lang/StringBuilder;
    //   104: ldc_w 272
    //   107: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_0
    //   112: getfield 50	com/tencent/stat/g:c	Ljava/lang/StringBuilder;
    //   115: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 273	java/lang/String:length	()I
    //   123: istore 6
    //   125: new 45	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   132: invokestatic 276	com/tencent/stat/StatConfig:getStatReportUrl	()Ljava/lang/String;
    //   135: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 278
    //   141: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: getfield 52	com/tencent/stat/g:g	J
    //   148: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   151: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 9
    //   156: aload_0
    //   157: aload_0
    //   158: getfield 52	com/tencent/stat/g:g	J
    //   161: lconst_1
    //   162: ladd
    //   163: putfield 52	com/tencent/stat/g:g	J
    //   166: invokestatic 140	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   169: ifeq +51 -> 220
    //   172: getstatic 28	com/tencent/stat/g:d	Lcom/tencent/stat/common/StatLogger;
    //   175: new 45	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 263
    //   185: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 9
    //   190: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 283
    //   196: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: iload 6
    //   201: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: ldc_w 285
    //   207: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokevirtual 155	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   220: new 287	org/apache/http/client/methods/HttpPost
    //   223: dup
    //   224: aload 9
    //   226: invokespecial 288	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   229: astore 11
    //   231: aload 11
    //   233: ldc_w 290
    //   236: ldc_w 292
    //   239: invokevirtual 296	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload 11
    //   244: ldc_w 298
    //   247: ldc_w 300
    //   250: invokevirtual 303	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload 11
    //   255: ldc_w 305
    //   258: invokevirtual 308	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   261: getstatic 32	com/tencent/stat/g:f	Landroid/content/Context;
    //   264: invokestatic 314	com/tencent/stat/NetworkManager:getInstance	(Landroid/content/Context;)Lcom/tencent/stat/NetworkManager;
    //   267: invokevirtual 318	com/tencent/stat/NetworkManager:getHttpProxy	()Lorg/apache/http/HttpHost;
    //   270: astore 12
    //   272: aload 11
    //   274: ldc_w 320
    //   277: ldc_w 322
    //   280: invokevirtual 296	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload 12
    //   285: ifnonnull +423 -> 708
    //   288: aload_0
    //   289: getfield 41	com/tencent/stat/g:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   292: invokevirtual 326	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   295: ldc_w 328
    //   298: invokeinterface 333 2 0
    //   303: pop
    //   304: new 335	java/io/ByteArrayOutputStream
    //   307: dup
    //   308: iload 6
    //   310: invokespecial 336	java/io/ByteArrayOutputStream:<init>	(I)V
    //   313: astore 10
    //   315: aload_1
    //   316: ldc_w 338
    //   319: invokevirtual 342	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   322: astore 9
    //   324: aload 9
    //   326: arraylength
    //   327: istore 5
    //   329: iload 4
    //   331: istore_3
    //   332: iload 6
    //   334: getstatic 346	com/tencent/stat/StatConfig:o	I
    //   337: if_icmple +5 -> 342
    //   340: iconst_1
    //   341: istore_3
    //   342: aload 9
    //   344: astore_1
    //   345: iload_3
    //   346: ifeq +170 -> 516
    //   349: aload 11
    //   351: ldc_w 320
    //   354: invokevirtual 308	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   357: new 45	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 322
    //   367: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: ldc_w 348
    //   373: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: astore_1
    //   380: aload 11
    //   382: ldc_w 320
    //   385: aload_1
    //   386: invokevirtual 296	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload 12
    //   391: ifnull +20 -> 411
    //   394: aload 11
    //   396: ldc_w 350
    //   399: invokevirtual 308	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   402: aload 11
    //   404: ldc_w 350
    //   407: aload_1
    //   408: invokevirtual 296	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: aload 10
    //   413: iconst_4
    //   414: newarray byte
    //   416: invokevirtual 354	java/io/ByteArrayOutputStream:write	([B)V
    //   419: new 356	java/util/zip/GZIPOutputStream
    //   422: dup
    //   423: aload 10
    //   425: invokespecial 359	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   428: astore_1
    //   429: aload_1
    //   430: aload 9
    //   432: invokevirtual 360	java/util/zip/GZIPOutputStream:write	([B)V
    //   435: aload_1
    //   436: invokevirtual 363	java/util/zip/GZIPOutputStream:close	()V
    //   439: aload 10
    //   441: invokevirtual 367	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   444: astore 9
    //   446: aload 9
    //   448: iconst_0
    //   449: iconst_4
    //   450: invokestatic 373	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   453: iload 5
    //   455: invokevirtual 377	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   458: pop
    //   459: aload 9
    //   461: astore_1
    //   462: invokestatic 140	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   465: ifeq +51 -> 516
    //   468: getstatic 28	com/tencent/stat/g:d	Lcom/tencent/stat/common/StatLogger;
    //   471: new 45	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   478: ldc_w 379
    //   481: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: iload 5
    //   486: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   489: ldc_w 381
    //   492: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload 9
    //   497: arraylength
    //   498: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   501: ldc_w 383
    //   504: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokevirtual 385	com/tencent/stat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   513: aload 9
    //   515: astore_1
    //   516: aload 11
    //   518: new 387	org/apache/http/entity/ByteArrayEntity
    //   521: dup
    //   522: aload_1
    //   523: invokestatic 392	com/tencent/stat/common/d:a	([B)[B
    //   526: invokespecial 394	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   529: invokevirtual 398	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   532: aload_0
    //   533: getfield 41	com/tencent/stat/g:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   536: aload 11
    //   538: invokevirtual 402	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   541: astore_1
    //   542: aload_1
    //   543: invokeinterface 408 1 0
    //   548: astore 9
    //   550: aload_1
    //   551: invokeinterface 412 1 0
    //   556: invokeinterface 417 1 0
    //   561: istore_3
    //   562: aload 9
    //   564: invokeinterface 422 1 0
    //   569: lstore 7
    //   571: invokestatic 140	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   574: ifeq +40 -> 614
    //   577: getstatic 28	com/tencent/stat/g:d	Lcom/tencent/stat/common/StatLogger;
    //   580: new 45	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 424
    //   590: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: iload_3
    //   594: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   597: ldc_w 426
    //   600: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: lload 7
    //   605: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   608: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokevirtual 155	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   614: lload 7
    //   616: lconst_0
    //   617: lcmp
    //   618: ifgt +194 -> 812
    //   621: getstatic 28	com/tencent/stat/g:d	Lcom/tencent/stat/common/StatLogger;
    //   624: ldc_w 428
    //   627: invokevirtual 430	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   630: aload_2
    //   631: ifnull +9 -> 640
    //   634: aload_2
    //   635: invokeinterface 435 1 0
    //   640: aload 9
    //   642: invokestatic 440	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   645: pop
    //   646: return
    //   647: astore_1
    //   648: aload_1
    //   649: ifnull -633 -> 16
    //   652: getstatic 28	com/tencent/stat/g:d	Lcom/tencent/stat/common/StatLogger;
    //   655: aload_1
    //   656: invokevirtual 443	com/tencent/stat/common/StatLogger:error	(Ljava/lang/Throwable;)V
    //   659: aload_2
    //   660: ifnull +9 -> 669
    //   663: aload_2
    //   664: invokeinterface 435 1 0
    //   669: aload_1
    //   670: instanceof 445
    //   673: ifeq +507 -> 1180
    //   676: invokestatic 448	java/lang/System:gc	()V
    //   679: aload_0
    //   680: aconst_null
    //   681: putfield 50	com/tencent/stat/g:c	Ljava/lang/StringBuilder;
    //   684: aload_0
    //   685: new 45	java/lang/StringBuilder
    //   688: dup
    //   689: sipush 2048
    //   692: invokespecial 48	java/lang/StringBuilder:<init>	(I)V
    //   695: putfield 50	com/tencent/stat/g:c	Ljava/lang/StringBuilder;
    //   698: getstatic 32	com/tencent/stat/g:f	Landroid/content/Context;
    //   701: invokestatic 314	com/tencent/stat/NetworkManager:getInstance	(Landroid/content/Context;)Lcom/tencent/stat/NetworkManager;
    //   704: invokevirtual 451	com/tencent/stat/NetworkManager:onDispatchFailed	()V
    //   707: return
    //   708: invokestatic 140	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   711: ifeq +33 -> 744
    //   714: getstatic 28	com/tencent/stat/g:d	Lcom/tencent/stat/common/StatLogger;
    //   717: new 45	java/lang/StringBuilder
    //   720: dup
    //   721: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   724: ldc_w 453
    //   727: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: aload 12
    //   732: invokevirtual 458	org/apache/http/HttpHost:toHostString	()Ljava/lang/String;
    //   735: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokevirtual 385	com/tencent/stat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   744: aload 11
    //   746: ldc_w 350
    //   749: ldc_w 322
    //   752: invokevirtual 296	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   755: aload_0
    //   756: getfield 41	com/tencent/stat/g:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   759: invokevirtual 326	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   762: ldc_w 328
    //   765: aload 12
    //   767: invokeinterface 462 3 0
    //   772: pop
    //   773: aload 11
    //   775: ldc_w 464
    //   778: getstatic 467	com/tencent/stat/StatConfig:k	Ljava/lang/String;
    //   781: invokevirtual 296	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   784: aload 11
    //   786: ldc_w 469
    //   789: ldc_w 471
    //   792: invokevirtual 296	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   795: aload 11
    //   797: ldc_w 473
    //   800: ldc_w 475
    //   803: invokevirtual 296	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   806: goto -502 -> 304
    //   809: astore_1
    //   810: aload_1
    //   811: athrow
    //   812: aload 9
    //   814: invokeinterface 479 1 0
    //   819: astore 11
    //   821: new 481	java/io/DataInputStream
    //   824: dup
    //   825: aload 11
    //   827: invokespecial 484	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   830: astore 12
    //   832: aload 9
    //   834: invokeinterface 422 1 0
    //   839: l2i
    //   840: newarray byte
    //   842: astore 9
    //   844: aload 12
    //   846: aload 9
    //   848: invokevirtual 487	java/io/DataInputStream:readFully	([B)V
    //   851: aload 11
    //   853: invokevirtual 490	java/io/InputStream:close	()V
    //   856: aload 12
    //   858: invokevirtual 491	java/io/DataInputStream:close	()V
    //   861: aload_1
    //   862: ldc_w 320
    //   865: invokeinterface 495 2 0
    //   870: astore 12
    //   872: aload 9
    //   874: astore_1
    //   875: aload 12
    //   877: ifnull +28 -> 905
    //   880: aload 12
    //   882: invokeinterface 500 1 0
    //   887: ldc_w 502
    //   890: invokevirtual 505	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   893: ifeq +118 -> 1011
    //   896: aload 9
    //   898: invokestatic 508	com/tencent/stat/common/StatCommonHelper:deocdeGZipContent	([B)[B
    //   901: invokestatic 510	com/tencent/stat/common/d:b	([B)[B
    //   904: astore_1
    //   905: new 232	java/lang/String
    //   908: dup
    //   909: aload_1
    //   910: ldc_w 338
    //   913: invokespecial 513	java/lang/String:<init>	([BLjava/lang/String;)V
    //   916: astore 9
    //   918: invokestatic 140	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   921: ifeq +30 -> 951
    //   924: getstatic 28	com/tencent/stat/g:d	Lcom/tencent/stat/common/StatLogger;
    //   927: new 45	java/lang/StringBuilder
    //   930: dup
    //   931: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   934: ldc_w 515
    //   937: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: aload 9
    //   942: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: invokevirtual 155	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   951: new 125	org/json/JSONObject
    //   954: dup
    //   955: aload 9
    //   957: invokespecial 516	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   960: astore 9
    //   962: iload_3
    //   963: sipush 200
    //   966: if_icmpne +144 -> 1110
    //   969: aload_0
    //   970: aload 9
    //   972: invokespecial 518	com/tencent/stat/g:a	(Lorg/json/JSONObject;)V
    //   975: aload_2
    //   976: ifnull +20 -> 996
    //   979: aload 9
    //   981: ldc_w 520
    //   984: invokevirtual 523	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   987: ifne +105 -> 1092
    //   990: aload_2
    //   991: invokeinterface 526 1 0
    //   996: aload 11
    //   998: invokevirtual 490	java/io/InputStream:close	()V
    //   1001: aload 10
    //   1003: invokevirtual 527	java/io/ByteArrayOutputStream:close	()V
    //   1006: aconst_null
    //   1007: astore_1
    //   1008: goto -360 -> 648
    //   1011: aload 12
    //   1013: invokeinterface 500 1 0
    //   1018: ldc_w 529
    //   1021: invokevirtual 505	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1024: ifeq +15 -> 1039
    //   1027: aload 9
    //   1029: invokestatic 510	com/tencent/stat/common/d:b	([B)[B
    //   1032: invokestatic 508	com/tencent/stat/common/StatCommonHelper:deocdeGZipContent	([B)[B
    //   1035: astore_1
    //   1036: goto -131 -> 905
    //   1039: aload 12
    //   1041: invokeinterface 500 1 0
    //   1046: ldc_w 292
    //   1049: invokevirtual 505	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1052: ifeq +12 -> 1064
    //   1055: aload 9
    //   1057: invokestatic 508	com/tencent/stat/common/StatCommonHelper:deocdeGZipContent	([B)[B
    //   1060: astore_1
    //   1061: goto -156 -> 905
    //   1064: aload 9
    //   1066: astore_1
    //   1067: aload 12
    //   1069: invokeinterface 500 1 0
    //   1074: ldc_w 322
    //   1077: invokevirtual 505	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1080: ifeq -175 -> 905
    //   1083: aload 9
    //   1085: invokestatic 510	com/tencent/stat/common/d:b	([B)[B
    //   1088: astore_1
    //   1089: goto -184 -> 905
    //   1092: getstatic 28	com/tencent/stat/g:d	Lcom/tencent/stat/common/StatLogger;
    //   1095: ldc_w 531
    //   1098: invokevirtual 533	com/tencent/stat/common/StatLogger:error	(Ljava/lang/Object;)V
    //   1101: aload_2
    //   1102: invokeinterface 435 1 0
    //   1107: goto -111 -> 996
    //   1110: getstatic 28	com/tencent/stat/g:d	Lcom/tencent/stat/common/StatLogger;
    //   1113: new 45	java/lang/StringBuilder
    //   1116: dup
    //   1117: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1120: ldc_w 535
    //   1123: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: iload_3
    //   1127: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1130: ldc_w 537
    //   1133: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: new 232	java/lang/String
    //   1139: dup
    //   1140: aload_1
    //   1141: ldc_w 338
    //   1144: invokespecial 513	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1147: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokevirtual 533	com/tencent/stat/common/StatLogger:error	(Ljava/lang/Object;)V
    //   1156: aload_2
    //   1157: ifnull -161 -> 996
    //   1160: aload_2
    //   1161: invokeinterface 435 1 0
    //   1166: goto -170 -> 996
    //   1169: astore_2
    //   1170: getstatic 28	com/tencent/stat/g:d	Lcom/tencent/stat/common/StatLogger;
    //   1173: aload_2
    //   1174: invokevirtual 120	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1177: goto -508 -> 669
    //   1180: aload_1
    //   1181: instanceof 539
    //   1184: ifne -486 -> 698
    //   1187: aload_1
    //   1188: instanceof 541
    //   1191: ifeq -493 -> 698
    //   1194: goto -496 -> 698
    //   1197: iload_3
    //   1198: iconst_1
    //   1199: iadd
    //   1200: istore_3
    //   1201: goto -1147 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1204	0	this	g
    //   0	1204	1	paramList	List<?>
    //   0	1204	2	paramStatDispatchCallback	StatDispatchCallback
    //   53	1148	3	i	int
    //   1	329	4	j	int
    //   23	462	5	k	int
    //   123	215	6	m	int
    //   569	46	7	l	long
    //   154	930	9	localObject1	Object
    //   313	689	10	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   229	768	11	localObject2	Object
    //   270	798	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	52	647	java/lang/Throwable
    //   60	78	647	java/lang/Throwable
    //   86	97	647	java/lang/Throwable
    //   100	220	647	java/lang/Throwable
    //   220	283	647	java/lang/Throwable
    //   288	304	647	java/lang/Throwable
    //   304	329	647	java/lang/Throwable
    //   332	340	647	java/lang/Throwable
    //   349	389	647	java/lang/Throwable
    //   394	411	647	java/lang/Throwable
    //   411	459	647	java/lang/Throwable
    //   462	513	647	java/lang/Throwable
    //   516	614	647	java/lang/Throwable
    //   621	630	647	java/lang/Throwable
    //   634	640	647	java/lang/Throwable
    //   640	646	647	java/lang/Throwable
    //   708	744	647	java/lang/Throwable
    //   744	806	647	java/lang/Throwable
    //   812	872	647	java/lang/Throwable
    //   880	905	647	java/lang/Throwable
    //   905	951	647	java/lang/Throwable
    //   951	962	647	java/lang/Throwable
    //   969	975	647	java/lang/Throwable
    //   979	996	647	java/lang/Throwable
    //   996	1006	647	java/lang/Throwable
    //   1011	1036	647	java/lang/Throwable
    //   1039	1061	647	java/lang/Throwable
    //   1067	1089	647	java/lang/Throwable
    //   1092	1107	647	java/lang/Throwable
    //   1110	1156	647	java/lang/Throwable
    //   1160	1166	647	java/lang/Throwable
    //   25	52	809	finally
    //   60	78	809	finally
    //   86	97	809	finally
    //   100	220	809	finally
    //   220	283	809	finally
    //   288	304	809	finally
    //   304	329	809	finally
    //   332	340	809	finally
    //   349	389	809	finally
    //   394	411	809	finally
    //   411	459	809	finally
    //   462	513	809	finally
    //   516	614	809	finally
    //   621	630	809	finally
    //   634	640	809	finally
    //   640	646	809	finally
    //   708	744	809	finally
    //   744	806	809	finally
    //   812	872	809	finally
    //   880	905	809	finally
    //   905	951	809	finally
    //   951	962	809	finally
    //   969	975	809	finally
    //   979	996	809	finally
    //   996	1006	809	finally
    //   1011	1036	809	finally
    //   1039	1061	809	finally
    //   1067	1089	809	finally
    //   1092	1107	809	finally
    //   1110	1156	809	finally
    //   1160	1166	809	finally
    //   663	669	1169	java/lang/Throwable
  }
  
  void b(List<?> paramList, StatDispatchCallback paramStatDispatchCallback)
  {
    if (this.b != null) {
      this.b.post(new i(this, paramList, paramStatDispatchCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.stat.g
 * JD-Core Version:    0.7.0.1
 */