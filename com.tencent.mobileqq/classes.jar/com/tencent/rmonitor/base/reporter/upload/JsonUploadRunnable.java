package com.tencent.rmonitor.base.reporter.upload;

import android.os.Handler;
import com.tencent.rmonitor.base.reporter.IReporter.ReportCallback;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable;", "Lcom/tencent/rmonitor/base/reporter/upload/ReporterUpload;", "Ljava/lang/Runnable;", "url", "Ljava/net/URL;", "handler", "Landroid/os/Handler;", "reportData", "Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "callback", "Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;", "(Ljava/net/URL;Landroid/os/Handler;Lcom/tencent/rmonitor/base/reporter/data/ReportData;Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;)V", "getRunnable", "request", "", "run", "upload", "connection", "Ljava/net/HttpURLConnection;", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class JsonUploadRunnable
  extends ReporterUpload
  implements Runnable
{
  public static final JsonUploadRunnable.Companion a = new JsonUploadRunnable.Companion(null);
  
  public JsonUploadRunnable(@NotNull URL paramURL, @NotNull Handler paramHandler, @NotNull ReportData paramReportData, @Nullable IReporter.ReportCallback paramReportCallback)
  {
    super(paramURL, paramHandler, paramReportData, paramReportCallback);
  }
  
  /* Error */
  private final void a(java.net.HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +333 -> 334
    //   4: new 70	java/util/zip/GZIPOutputStream
    //   7: dup
    //   8: new 72	java/io/DataOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokevirtual 78	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   16: invokespecial 81	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: checkcast 83	java/io/OutputStream
    //   22: invokespecial 84	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: checkcast 86	java/io/Closeable
    //   28: astore 14
    //   30: aconst_null
    //   31: checkcast 68	java/lang/Throwable
    //   34: astore 13
    //   36: aload 13
    //   38: astore 12
    //   40: aload 14
    //   42: checkcast 70	java/util/zip/GZIPOutputStream
    //   45: astore 15
    //   47: aload 13
    //   49: astore 12
    //   51: aload_0
    //   52: invokevirtual 90	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:c	()Lcom/tencent/rmonitor/base/reporter/data/ReportData;
    //   55: invokevirtual 96	com/tencent/rmonitor/base/reporter/data/ReportData:getParams	()Lorg/json/JSONObject;
    //   58: invokevirtual 102	org/json/JSONObject:toString	()Ljava/lang/String;
    //   61: astore 16
    //   63: aload 13
    //   65: astore 12
    //   67: aload 16
    //   69: ldc 104
    //   71: invokestatic 107	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   74: aload 13
    //   76: astore 12
    //   78: ldc 109
    //   80: invokestatic 115	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   83: astore 17
    //   85: aload 13
    //   87: astore 12
    //   89: aload 17
    //   91: ldc 117
    //   93: invokestatic 107	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   96: aload 16
    //   98: ifnull +203 -> 301
    //   101: aload 13
    //   103: astore 12
    //   105: aload 16
    //   107: aload 17
    //   109: invokevirtual 123	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   112: astore 16
    //   114: aload 13
    //   116: astore 12
    //   118: aload 16
    //   120: ldc 125
    //   122: invokestatic 107	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   125: aload 13
    //   127: astore 12
    //   129: aload 15
    //   131: aload 16
    //   133: invokevirtual 129	java/util/zip/GZIPOutputStream:write	([B)V
    //   136: aload 13
    //   138: astore 12
    //   140: aload 15
    //   142: invokevirtual 132	java/util/zip/GZIPOutputStream:finish	()V
    //   145: aload 13
    //   147: astore 12
    //   149: getstatic 138	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   152: astore 15
    //   154: aload 14
    //   156: aload 13
    //   158: invokestatic 144	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   161: getstatic 149	com/tencent/rmonitor/common/util/FileUtil:a	Lcom/tencent/rmonitor/common/util/FileUtil$Companion;
    //   164: new 151	java/io/BufferedInputStream
    //   167: dup
    //   168: aload_1
    //   169: invokevirtual 155	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   172: invokespecial 158	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   175: checkcast 160	java/io/InputStream
    //   178: sipush 8192
    //   181: invokevirtual 165	com/tencent/rmonitor/common/util/FileUtil$Companion:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   184: astore 12
    //   186: getstatic 171	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   189: astore 13
    //   191: new 173	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   198: astore 14
    //   200: aload 14
    //   202: ldc 177
    //   204: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 14
    //   210: aload 12
    //   212: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 13
    //   218: iconst_2
    //   219: anewarray 119	java/lang/String
    //   222: dup
    //   223: iconst_0
    //   224: ldc 183
    //   226: aastore
    //   227: dup
    //   228: iconst_1
    //   229: aload 14
    //   231: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: aastore
    //   235: invokevirtual 188	com/tencent/rmonitor/common/logger/Logger:i	([Ljava/lang/String;)V
    //   238: invokestatic 194	java/lang/Math:random	()D
    //   241: dstore_2
    //   242: iconst_5
    //   243: i2d
    //   244: dstore 4
    //   246: dload 4
    //   248: invokestatic 200	java/lang/Double:isNaN	(D)Z
    //   251: pop
    //   252: iconst_2
    //   253: i2d
    //   254: dstore 6
    //   256: dload 6
    //   258: invokestatic 200	java/lang/Double:isNaN	(D)Z
    //   261: pop
    //   262: dload_2
    //   263: dload 4
    //   265: dmul
    //   266: dload 6
    //   268: dadd
    //   269: d2l
    //   270: lstore 8
    //   272: sipush 1000
    //   275: i2l
    //   276: lstore 10
    //   278: aload_0
    //   279: aload 12
    //   281: aload_1
    //   282: invokevirtual 204	java/net/HttpURLConnection:getResponseCode	()I
    //   285: lload 8
    //   287: lload 10
    //   289: lmul
    //   290: getstatic 209	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable$upload$1$2:INSTANCE	Lcom/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable$upload$1$2;
    //   293: checkcast 211	kotlin/jvm/functions/Function0
    //   296: invokevirtual 214	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:a	(Ljava/lang/String;IJLkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    //   299: pop
    //   300: return
    //   301: aload 13
    //   303: astore 12
    //   305: new 216	kotlin/TypeCastException
    //   308: dup
    //   309: ldc 218
    //   311: invokespecial 221	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   314: athrow
    //   315: astore_1
    //   316: goto +9 -> 325
    //   319: astore_1
    //   320: aload_1
    //   321: astore 12
    //   323: aload_1
    //   324: athrow
    //   325: aload 14
    //   327: aload 12
    //   329: invokestatic 144	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   332: aload_1
    //   333: athrow
    //   334: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	JsonUploadRunnable
    //   0	335	1	paramHttpURLConnection	java.net.HttpURLConnection
    //   241	22	2	d1	double
    //   244	20	4	d2	double
    //   254	13	6	d3	double
    //   270	16	8	l1	long
    //   276	12	10	l2	long
    //   38	290	12	localObject1	java.lang.Object
    //   34	268	13	localObject2	java.lang.Object
    //   28	298	14	localObject3	java.lang.Object
    //   45	108	15	localObject4	java.lang.Object
    //   61	71	16	localObject5	java.lang.Object
    //   83	25	17	localCharset	java.nio.charset.Charset
    // Exception table:
    //   from	to	target	type
    //   40	47	315	finally
    //   51	63	315	finally
    //   67	74	315	finally
    //   78	85	315	finally
    //   89	96	315	finally
    //   105	114	315	finally
    //   118	125	315	finally
    //   129	136	315	finally
    //   140	145	315	finally
    //   149	154	315	finally
    //   305	315	315	finally
    //   323	325	315	finally
    //   40	47	319	java/lang/Throwable
    //   51	63	319	java/lang/Throwable
    //   67	74	319	java/lang/Throwable
    //   78	85	319	java/lang/Throwable
    //   89	96	319	java/lang/Throwable
    //   105	114	319	java/lang/Throwable
    //   118	125	319	java/lang/Throwable
    //   129	136	319	java/lang/Throwable
    //   140	145	319	java/lang/Throwable
    //   149	154	319	java/lang/Throwable
    //   305	315	319	java/lang/Throwable
  }
  
  @NotNull
  public Runnable a()
  {
    return (Runnable)this;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 230	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:b	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 236	android/os/SystemClock:elapsedRealtime	()J
    //   11: lstore_3
    //   12: new 238	java/util/HashMap
    //   15: dup
    //   16: invokespecial 239	java/util/HashMap:<init>	()V
    //   19: astore 9
    //   21: aload 9
    //   23: checkcast 241	java/util/Map
    //   26: astore 10
    //   28: aload 10
    //   30: ldc 243
    //   32: ldc 245
    //   34: invokeinterface 249 3 0
    //   39: pop
    //   40: aload 10
    //   42: ldc 251
    //   44: ldc 253
    //   46: invokeinterface 249 3 0
    //   51: pop
    //   52: aload 10
    //   54: ldc 255
    //   56: getstatic 261	com/tencent/rmonitor/base/meta/BaseInfo:token	Ljava/lang/String;
    //   59: invokeinterface 249 3 0
    //   64: pop
    //   65: getstatic 171	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   68: astore 10
    //   70: iconst_0
    //   71: istore 8
    //   73: iconst_0
    //   74: istore 7
    //   76: new 173	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   83: astore 11
    //   85: aload 11
    //   87: ldc_w 263
    //   90: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 11
    //   96: aload_0
    //   97: invokevirtual 267	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:e	()Ljava/net/URL;
    //   100: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 11
    //   106: ldc_w 272
    //   109: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 11
    //   115: aload_0
    //   116: invokevirtual 90	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:c	()Lcom/tencent/rmonitor/base/reporter/data/ReportData;
    //   119: invokevirtual 96	com/tencent/rmonitor/base/reporter/data/ReportData:getParams	()Lorg/json/JSONObject;
    //   122: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 10
    //   128: iconst_2
    //   129: anewarray 119	java/lang/String
    //   132: dup
    //   133: iconst_0
    //   134: ldc 183
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: aload 11
    //   141: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: aastore
    //   145: invokevirtual 188	com/tencent/rmonitor/common/logger/Logger:i	([Ljava/lang/String;)V
    //   148: aload_0
    //   149: aload 9
    //   151: invokevirtual 275	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:a	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   154: astore 9
    //   156: aload_0
    //   157: aload 9
    //   159: invokespecial 277	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:a	(Ljava/net/HttpURLConnection;)V
    //   162: aload 9
    //   164: ifnull +37 -> 201
    //   167: aload 9
    //   169: invokevirtual 204	java/net/HttpURLConnection:getResponseCode	()I
    //   172: sipush 200
    //   175: if_icmpne +17 -> 192
    //   178: aload 9
    //   180: invokevirtual 204	java/net/HttpURLConnection:getResponseCode	()I
    //   183: pop
    //   184: iconst_0
    //   185: istore_1
    //   186: iconst_1
    //   187: istore 7
    //   189: goto +14 -> 203
    //   192: aload 9
    //   194: invokevirtual 204	java/net/HttpURLConnection:getResponseCode	()I
    //   197: istore_1
    //   198: goto +5 -> 203
    //   201: iconst_0
    //   202: istore_1
    //   203: iload_1
    //   204: istore_2
    //   205: iload 7
    //   207: istore 8
    //   209: aload 9
    //   211: ifnull +458 -> 669
    //   214: aload 9
    //   216: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   219: iload_1
    //   220: istore_2
    //   221: iload 7
    //   223: istore 8
    //   225: goto +444 -> 669
    //   228: astore 10
    //   230: goto +458 -> 688
    //   233: astore 10
    //   235: getstatic 171	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   238: astore 11
    //   240: new 173	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   247: astore 12
    //   249: aload 12
    //   251: aload 10
    //   253: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 12
    //   259: ldc_w 282
    //   262: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 12
    //   268: aload_0
    //   269: invokevirtual 90	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:c	()Lcom/tencent/rmonitor/base/reporter/data/ReportData;
    //   272: invokevirtual 96	com/tencent/rmonitor/base/reporter/data/ReportData:getParams	()Lorg/json/JSONObject;
    //   275: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 12
    //   281: ldc_w 284
    //   284: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 11
    //   290: ldc 183
    //   292: aload 12
    //   294: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: aload 10
    //   299: invokevirtual 287	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   302: aload_0
    //   303: iconst_0
    //   304: invokevirtual 290	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:a	(I)V
    //   307: aload 9
    //   309: ifnull +358 -> 667
    //   312: aload 9
    //   314: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   317: goto +350 -> 667
    //   320: astore 10
    //   322: getstatic 171	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   325: astore 11
    //   327: new 173	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   334: astore 12
    //   336: aload 12
    //   338: aload 10
    //   340: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 12
    //   346: ldc_w 282
    //   349: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 12
    //   355: aload_0
    //   356: invokevirtual 90	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:c	()Lcom/tencent/rmonitor/base/reporter/data/ReportData;
    //   359: invokevirtual 96	com/tencent/rmonitor/base/reporter/data/ReportData:getParams	()Lorg/json/JSONObject;
    //   362: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 12
    //   368: ldc_w 284
    //   371: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload 11
    //   377: ldc 183
    //   379: aload 12
    //   381: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: aload 10
    //   386: checkcast 68	java/lang/Throwable
    //   389: invokevirtual 287	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   392: aload_0
    //   393: ldc2_w 291
    //   396: invokevirtual 295	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:a	(J)V
    //   399: aload 9
    //   401: ifnull +266 -> 667
    //   404: goto -92 -> 312
    //   407: astore 10
    //   409: aload_0
    //   410: iconst_0
    //   411: invokevirtual 290	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:a	(I)V
    //   414: aload_0
    //   415: invokevirtual 299	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:d	()Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;
    //   418: astore 11
    //   420: aload 11
    //   422: ifnull +17 -> 439
    //   425: aload 11
    //   427: sipush 600
    //   430: ldc_w 301
    //   433: iconst_0
    //   434: invokeinterface 306 4 0
    //   439: getstatic 171	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   442: astore 11
    //   444: new 173	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   451: astore 12
    //   453: aload 12
    //   455: aload 10
    //   457: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 12
    //   463: ldc_w 282
    //   466: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 12
    //   472: aload_0
    //   473: invokevirtual 90	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:c	()Lcom/tencent/rmonitor/base/reporter/data/ReportData;
    //   476: invokevirtual 96	com/tencent/rmonitor/base/reporter/data/ReportData:getParams	()Lorg/json/JSONObject;
    //   479: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 12
    //   485: ldc_w 284
    //   488: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 11
    //   494: ldc 183
    //   496: aload 12
    //   498: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: aload 10
    //   503: checkcast 68	java/lang/Throwable
    //   506: invokevirtual 287	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   509: goto +150 -> 659
    //   512: astore 10
    //   514: getstatic 171	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   517: astore 11
    //   519: new 173	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   526: astore 12
    //   528: aload 12
    //   530: aload 10
    //   532: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 12
    //   538: ldc_w 282
    //   541: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 12
    //   547: aload_0
    //   548: invokevirtual 90	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:c	()Lcom/tencent/rmonitor/base/reporter/data/ReportData;
    //   551: invokevirtual 96	com/tencent/rmonitor/base/reporter/data/ReportData:getParams	()Lorg/json/JSONObject;
    //   554: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 12
    //   560: ldc_w 284
    //   563: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 11
    //   569: ldc 183
    //   571: aload 12
    //   573: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: aload 10
    //   578: checkcast 68	java/lang/Throwable
    //   581: invokevirtual 287	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   584: goto +75 -> 659
    //   587: astore 10
    //   589: getstatic 171	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   592: astore 11
    //   594: new 173	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   601: astore 12
    //   603: aload 12
    //   605: aload 10
    //   607: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 12
    //   613: ldc_w 282
    //   616: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 12
    //   622: aload_0
    //   623: invokevirtual 90	com/tencent/rmonitor/base/reporter/upload/JsonUploadRunnable:c	()Lcom/tencent/rmonitor/base/reporter/data/ReportData;
    //   626: invokevirtual 96	com/tencent/rmonitor/base/reporter/data/ReportData:getParams	()Lorg/json/JSONObject;
    //   629: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 12
    //   635: ldc_w 284
    //   638: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: pop
    //   642: aload 11
    //   644: ldc 183
    //   646: aload 12
    //   648: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: aload 10
    //   653: checkcast 68	java/lang/Throwable
    //   656: invokevirtual 287	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   659: aload 9
    //   661: ifnull +6 -> 667
    //   664: goto -352 -> 312
    //   667: iconst_0
    //   668: istore_2
    //   669: invokestatic 236	android/os/SystemClock:elapsedRealtime	()J
    //   672: lstore 5
    //   674: invokestatic 311	com/tencent/rmonitor/base/reporter/DataReportSla:a	()Lcom/tencent/rmonitor/base/reporter/DataReportSla;
    //   677: iload 8
    //   679: iload_2
    //   680: lload 5
    //   682: lload_3
    //   683: lsub
    //   684: invokevirtual 314	com/tencent/rmonitor/base/reporter/DataReportSla:a	(ZIJ)V
    //   687: return
    //   688: aload 9
    //   690: ifnull +8 -> 698
    //   693: aload 9
    //   695: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   698: goto +6 -> 704
    //   701: aload 10
    //   703: athrow
    //   704: goto -3 -> 701
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	this	JsonUploadRunnable
    //   185	35	1	i	int
    //   204	476	2	j	int
    //   11	672	3	l1	long
    //   672	9	5	l2	long
    //   74	148	7	bool1	boolean
    //   71	607	8	bool2	boolean
    //   19	675	9	localObject1	java.lang.Object
    //   26	101	10	localObject2	java.lang.Object
    //   228	1	10	localObject3	java.lang.Object
    //   233	65	10	localThrowable	java.lang.Throwable
    //   320	65	10	localException1	java.lang.Exception
    //   407	95	10	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   512	65	10	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   587	115	10	localException2	java.lang.Exception
    //   83	560	11	localObject4	java.lang.Object
    //   247	400	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   156	162	228	finally
    //   167	184	228	finally
    //   192	198	228	finally
    //   235	307	228	finally
    //   322	399	228	finally
    //   409	414	228	finally
    //   414	420	228	finally
    //   425	439	228	finally
    //   439	509	228	finally
    //   514	584	228	finally
    //   589	659	228	finally
    //   156	162	233	java/lang/Throwable
    //   167	184	233	java/lang/Throwable
    //   192	198	233	java/lang/Throwable
    //   156	162	320	java/lang/Exception
    //   167	184	320	java/lang/Exception
    //   192	198	320	java/lang/Exception
    //   156	162	407	java/lang/OutOfMemoryError
    //   167	184	407	java/lang/OutOfMemoryError
    //   192	198	407	java/lang/OutOfMemoryError
    //   414	420	512	java/lang/OutOfMemoryError
    //   425	439	512	java/lang/OutOfMemoryError
    //   439	509	512	java/lang/OutOfMemoryError
    //   414	420	587	java/lang/Exception
    //   425	439	587	java/lang/Exception
    //   439	509	587	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.upload.JsonUploadRunnable
 * JD-Core Version:    0.7.0.1
 */