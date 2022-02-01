package com.tencent.qapmsdk.base.reporter.uploaddata.runnable;

import android.os.Handler;
import com.tencent.qapmsdk.base.reporter.uploaddata.QAPMUpload;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/QAPMUpload;", "Ljava/lang/Runnable;", "url", "Ljava/net/URL;", "resultObject", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;", "callback", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "handler", "Landroid/os/Handler;", "(Ljava/net/URL;Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;Landroid/os/Handler;)V", "reSend", "", "delay", "", "request", "run", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class JsonUploadRunnable
  extends QAPMUpload
  implements Runnable
{
  public static final JsonUploadRunnable.Companion Companion = new JsonUploadRunnable.Companion(null);
  @NotNull
  public static final String TAG = "QAPM_base_JsonUploadRunnable";
  private final IReporter.ReportResultCallback callback;
  private final Handler handler;
  private final ResultObject resultObject;
  
  public JsonUploadRunnable(@NotNull URL paramURL, @NotNull ResultObject paramResultObject, @Nullable IReporter.ReportResultCallback paramReportResultCallback, @NotNull Handler paramHandler)
  {
    super(paramURL);
    this.resultObject = paramResultObject;
    this.callback = paramReportResultCallback;
    this.handler = paramHandler;
  }
  
  private final void reSend(long paramLong)
  {
    if (getRetry() > 0)
    {
      setRetry(getRetry() - 1);
      this.handler.postDelayed((Runnable)this, paramLong);
    }
  }
  
  public void request()
  {
    run();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 102	com/tencent/qapmsdk/base/config/SDKConfig:PURE_QAPM	Z
    //   3: ifeq +35 -> 38
    //   6: getstatic 107	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   9: checkcast 109	java/lang/CharSequence
    //   12: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +23 -> 38
    //   18: getstatic 121	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:INSTANCE	Lcom/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy;
    //   21: invokevirtual 125	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:getAuthorization	()Lcom/tencent/qapmsdk/base/reporter/authorization/Authorization;
    //   24: getstatic 129	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   27: getfield 134	com/tencent/qapmsdk/base/meta/UserMeta:appKey	Ljava/lang/String;
    //   30: iconst_1
    //   31: invokevirtual 140	com/tencent/qapmsdk/base/reporter/authorization/Authorization:getToken	(Ljava/lang/String;Z)Z
    //   34: ifne +4 -> 38
    //   37: return
    //   38: new 142	java/util/HashMap
    //   41: dup
    //   42: invokespecial 144	java/util/HashMap:<init>	()V
    //   45: astore 11
    //   47: aload 11
    //   49: checkcast 146	java/util/Map
    //   52: astore 12
    //   54: aload 12
    //   56: ldc 148
    //   58: ldc 150
    //   60: invokeinterface 154 3 0
    //   65: pop
    //   66: aload 12
    //   68: ldc 156
    //   70: ldc 158
    //   72: invokeinterface 154 3 0
    //   77: pop
    //   78: aload 12
    //   80: ldc 160
    //   82: getstatic 107	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   85: invokeinterface 154 3 0
    //   90: pop
    //   91: aload_0
    //   92: aload 11
    //   94: invokevirtual 164	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   97: astore 13
    //   99: aload 13
    //   101: ifnull +889 -> 990
    //   104: new 166	java/util/zip/GZIPOutputStream
    //   107: dup
    //   108: new 168	java/io/DataOutputStream
    //   111: dup
    //   112: aload 13
    //   114: invokevirtual 174	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   117: invokespecial 177	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   120: checkcast 179	java/io/OutputStream
    //   123: invokespecial 180	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   126: checkcast 182	java/io/Closeable
    //   129: astore 14
    //   131: aconst_null
    //   132: checkcast 96	java/lang/Throwable
    //   135: astore 12
    //   137: aload 12
    //   139: astore 11
    //   141: aload 14
    //   143: checkcast 166	java/util/zip/GZIPOutputStream
    //   146: astore 15
    //   148: aload 12
    //   150: astore 11
    //   152: aload_0
    //   153: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   156: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   159: invokevirtual 194	org/json/JSONObject:toString	()Ljava/lang/String;
    //   162: astore 16
    //   164: aload 12
    //   166: astore 11
    //   168: aload 16
    //   170: ldc 196
    //   172: invokestatic 199	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   175: aload 12
    //   177: astore 11
    //   179: ldc 201
    //   181: invokestatic 207	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   184: astore 17
    //   186: aload 12
    //   188: astore 11
    //   190: aload 17
    //   192: ldc 209
    //   194: invokestatic 199	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   197: aload 16
    //   199: ifnull +302 -> 501
    //   202: aload 12
    //   204: astore 11
    //   206: aload 16
    //   208: aload 17
    //   210: invokevirtual 215	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   213: astore 16
    //   215: aload 12
    //   217: astore 11
    //   219: aload 16
    //   221: ldc 217
    //   223: invokestatic 199	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   226: aload 12
    //   228: astore 11
    //   230: aload 15
    //   232: aload 16
    //   234: invokevirtual 221	java/util/zip/GZIPOutputStream:write	([B)V
    //   237: aload 12
    //   239: astore 11
    //   241: aload 15
    //   243: invokevirtual 224	java/util/zip/GZIPOutputStream:finish	()V
    //   246: aload 12
    //   248: astore 11
    //   250: getstatic 229	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   253: astore 15
    //   255: aload 14
    //   257: aload 12
    //   259: invokestatic 235	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   262: getstatic 240	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   265: new 242	java/io/BufferedInputStream
    //   268: dup
    //   269: aload 13
    //   271: invokevirtual 246	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   274: invokespecial 249	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   277: checkcast 251	java/io/InputStream
    //   280: sipush 8192
    //   283: invokevirtual 257	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   286: astore 11
    //   288: getstatic 262	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   291: astore 12
    //   293: new 264	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   300: astore 14
    //   302: aload 14
    //   304: ldc_w 267
    //   307: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 14
    //   313: aload 11
    //   315: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 12
    //   321: iconst_2
    //   322: anewarray 211	java/lang/String
    //   325: dup
    //   326: iconst_0
    //   327: ldc 41
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: aload 14
    //   334: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: aastore
    //   338: invokevirtual 276	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   341: aload_0
    //   342: aload 11
    //   344: invokevirtual 280	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   347: ifeq +34 -> 381
    //   350: aload_0
    //   351: getfield 70	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   354: astore 11
    //   356: aload 11
    //   358: ifnull +632 -> 990
    //   361: aload 11
    //   363: sipush 200
    //   366: aload_0
    //   367: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   370: invokevirtual 283	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   373: invokeinterface 289 3 0
    //   378: goto +612 -> 990
    //   381: aload_0
    //   382: invokevirtual 78	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:getRetry	()I
    //   385: ifle +52 -> 437
    //   388: invokestatic 295	java/lang/Math:random	()D
    //   391: dstore_1
    //   392: iconst_5
    //   393: i2d
    //   394: dstore_3
    //   395: dload_3
    //   396: invokestatic 301	java/lang/Double:isNaN	(D)Z
    //   399: pop
    //   400: iconst_2
    //   401: i2d
    //   402: dstore 5
    //   404: dload 5
    //   406: invokestatic 301	java/lang/Double:isNaN	(D)Z
    //   409: pop
    //   410: dload_1
    //   411: dload_3
    //   412: dmul
    //   413: dload 5
    //   415: dadd
    //   416: d2l
    //   417: lstore 7
    //   419: sipush 1000
    //   422: i2l
    //   423: lstore 9
    //   425: aload_0
    //   426: lload 7
    //   428: lload 9
    //   430: lmul
    //   431: invokespecial 303	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:reSend	(J)V
    //   434: goto +556 -> 990
    //   437: aload_0
    //   438: aload_0
    //   439: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   442: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   445: ldc_w 305
    //   448: invokevirtual 309	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   451: aload 13
    //   453: invokevirtual 312	java/net/HttpURLConnection:getResponseCode	()I
    //   456: aload 11
    //   458: aload_0
    //   459: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   462: invokevirtual 315	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getEventName	()Ljava/lang/String;
    //   465: invokevirtual 319	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:addLost	(IILjava/lang/String;Ljava/lang/String;)V
    //   468: aload_0
    //   469: getfield 70	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   472: astore 12
    //   474: aload 12
    //   476: ifnull +514 -> 990
    //   479: aload 12
    //   481: sipush 700
    //   484: aload 11
    //   486: aload_0
    //   487: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   490: invokevirtual 283	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   493: invokeinterface 323 4 0
    //   498: goto +492 -> 990
    //   501: aload 12
    //   503: astore 11
    //   505: new 325	kotlin/TypeCastException
    //   508: dup
    //   509: ldc_w 327
    //   512: invokespecial 330	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   515: athrow
    //   516: astore 12
    //   518: goto +12 -> 530
    //   521: astore 12
    //   523: aload 12
    //   525: astore 11
    //   527: aload 12
    //   529: athrow
    //   530: aload 14
    //   532: aload 11
    //   534: invokestatic 235	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   537: aload 12
    //   539: athrow
    //   540: astore 11
    //   542: goto +435 -> 977
    //   545: astore 11
    //   547: getstatic 262	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   550: astore 12
    //   552: new 264	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   559: astore 14
    //   561: aload 14
    //   563: aload 11
    //   565: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 14
    //   571: ldc_w 335
    //   574: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 14
    //   580: aload_0
    //   581: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   584: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   587: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 14
    //   593: ldc_w 337
    //   596: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 12
    //   602: ldc 41
    //   604: aload 14
    //   606: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: aload 11
    //   611: invokevirtual 341	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   614: aload_0
    //   615: iconst_0
    //   616: invokevirtual 82	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:setRetry	(I)V
    //   619: aload 13
    //   621: ifnull +377 -> 998
    //   624: aload 13
    //   626: invokevirtual 344	java/net/HttpURLConnection:disconnect	()V
    //   629: return
    //   630: astore 11
    //   632: getstatic 262	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   635: astore 12
    //   637: new 264	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   644: astore 14
    //   646: aload 14
    //   648: aload 11
    //   650: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: aload 14
    //   656: ldc_w 335
    //   659: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload 14
    //   665: aload_0
    //   666: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   669: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   672: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload 14
    //   678: ldc_w 337
    //   681: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 12
    //   687: ldc 41
    //   689: aload 14
    //   691: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: aload 11
    //   696: checkcast 96	java/lang/Throwable
    //   699: invokevirtual 341	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   702: aload_0
    //   703: ldc2_w 345
    //   706: invokespecial 303	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:reSend	(J)V
    //   709: aload 13
    //   711: ifnull +287 -> 998
    //   714: goto -90 -> 624
    //   717: astore 11
    //   719: aload_0
    //   720: iconst_0
    //   721: invokevirtual 82	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:setRetry	(I)V
    //   724: aload_0
    //   725: getfield 70	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   728: astore 12
    //   730: aload 12
    //   732: ifnull +17 -> 749
    //   735: aload 12
    //   737: sipush 600
    //   740: ldc_w 348
    //   743: iconst_0
    //   744: invokeinterface 323 4 0
    //   749: getstatic 262	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   752: astore 12
    //   754: new 264	java/lang/StringBuilder
    //   757: dup
    //   758: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   761: astore 14
    //   763: aload 14
    //   765: aload 11
    //   767: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload 14
    //   773: ldc_w 335
    //   776: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: pop
    //   780: aload 14
    //   782: aload_0
    //   783: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   786: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   789: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   792: pop
    //   793: aload 14
    //   795: ldc_w 337
    //   798: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload 12
    //   804: ldc 41
    //   806: aload 14
    //   808: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: aload 11
    //   813: checkcast 96	java/lang/Throwable
    //   816: invokevirtual 341	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   819: goto +150 -> 969
    //   822: astore 11
    //   824: getstatic 262	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   827: astore 12
    //   829: new 264	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   836: astore 14
    //   838: aload 14
    //   840: aload 11
    //   842: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload 14
    //   848: ldc_w 335
    //   851: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: aload 14
    //   857: aload_0
    //   858: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   861: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   864: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   867: pop
    //   868: aload 14
    //   870: ldc_w 337
    //   873: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: aload 12
    //   879: ldc 41
    //   881: aload 14
    //   883: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: aload 11
    //   888: checkcast 96	java/lang/Throwable
    //   891: invokevirtual 341	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   894: goto +75 -> 969
    //   897: astore 11
    //   899: getstatic 262	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   902: astore 12
    //   904: new 264	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   911: astore 14
    //   913: aload 14
    //   915: aload 11
    //   917: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: aload 14
    //   923: ldc_w 335
    //   926: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload 14
    //   932: aload_0
    //   933: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   936: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   939: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: aload 14
    //   945: ldc_w 337
    //   948: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: pop
    //   952: aload 12
    //   954: ldc 41
    //   956: aload 14
    //   958: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: aload 11
    //   963: checkcast 96	java/lang/Throwable
    //   966: invokevirtual 341	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   969: aload 13
    //   971: ifnull +27 -> 998
    //   974: goto -350 -> 624
    //   977: aload 13
    //   979: ifnull +8 -> 987
    //   982: aload 13
    //   984: invokevirtual 344	java/net/HttpURLConnection:disconnect	()V
    //   987: aload 11
    //   989: athrow
    //   990: aload 13
    //   992: ifnull +6 -> 998
    //   995: goto -371 -> 624
    //   998: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	999	0	this	JsonUploadRunnable
    //   391	20	1	d1	double
    //   394	18	3	d2	double
    //   402	12	5	d3	double
    //   417	10	7	l1	long
    //   423	6	9	l2	long
    //   45	488	11	localObject1	java.lang.Object
    //   540	1	11	localObject2	java.lang.Object
    //   545	65	11	localThrowable1	java.lang.Throwable
    //   630	65	11	localException1	java.lang.Exception
    //   717	95	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   822	65	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   897	91	11	localException2	java.lang.Exception
    //   52	450	12	localObject3	java.lang.Object
    //   516	1	12	localObject4	java.lang.Object
    //   521	17	12	localThrowable2	java.lang.Throwable
    //   550	403	12	localObject5	java.lang.Object
    //   97	894	13	localHttpURLConnection	java.net.HttpURLConnection
    //   129	828	14	localObject6	java.lang.Object
    //   146	108	15	localObject7	java.lang.Object
    //   162	71	16	localObject8	java.lang.Object
    //   184	25	17	localCharset	java.nio.charset.Charset
    // Exception table:
    //   from	to	target	type
    //   141	148	516	finally
    //   152	164	516	finally
    //   168	175	516	finally
    //   179	186	516	finally
    //   190	197	516	finally
    //   206	215	516	finally
    //   219	226	516	finally
    //   230	237	516	finally
    //   241	246	516	finally
    //   250	255	516	finally
    //   505	516	516	finally
    //   527	530	516	finally
    //   141	148	521	java/lang/Throwable
    //   152	164	521	java/lang/Throwable
    //   168	175	521	java/lang/Throwable
    //   179	186	521	java/lang/Throwable
    //   190	197	521	java/lang/Throwable
    //   206	215	521	java/lang/Throwable
    //   219	226	521	java/lang/Throwable
    //   230	237	521	java/lang/Throwable
    //   241	246	521	java/lang/Throwable
    //   250	255	521	java/lang/Throwable
    //   505	516	521	java/lang/Throwable
    //   104	137	540	finally
    //   255	356	540	finally
    //   361	378	540	finally
    //   381	392	540	finally
    //   425	434	540	finally
    //   437	474	540	finally
    //   479	498	540	finally
    //   530	540	540	finally
    //   547	619	540	finally
    //   632	709	540	finally
    //   719	724	540	finally
    //   724	730	540	finally
    //   735	749	540	finally
    //   749	819	540	finally
    //   824	894	540	finally
    //   899	969	540	finally
    //   104	137	545	java/lang/Throwable
    //   255	356	545	java/lang/Throwable
    //   361	378	545	java/lang/Throwable
    //   381	392	545	java/lang/Throwable
    //   425	434	545	java/lang/Throwable
    //   437	474	545	java/lang/Throwable
    //   479	498	545	java/lang/Throwable
    //   530	540	545	java/lang/Throwable
    //   104	137	630	java/lang/Exception
    //   255	356	630	java/lang/Exception
    //   361	378	630	java/lang/Exception
    //   381	392	630	java/lang/Exception
    //   425	434	630	java/lang/Exception
    //   437	474	630	java/lang/Exception
    //   479	498	630	java/lang/Exception
    //   530	540	630	java/lang/Exception
    //   104	137	717	java/lang/OutOfMemoryError
    //   255	356	717	java/lang/OutOfMemoryError
    //   361	378	717	java/lang/OutOfMemoryError
    //   381	392	717	java/lang/OutOfMemoryError
    //   425	434	717	java/lang/OutOfMemoryError
    //   437	474	717	java/lang/OutOfMemoryError
    //   479	498	717	java/lang/OutOfMemoryError
    //   530	540	717	java/lang/OutOfMemoryError
    //   724	730	822	java/lang/OutOfMemoryError
    //   735	749	822	java/lang/OutOfMemoryError
    //   749	819	822	java/lang/OutOfMemoryError
    //   724	730	897	java/lang/Exception
    //   735	749	897	java/lang/Exception
    //   749	819	897	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.JsonUploadRunnable
 * JD-Core Version:    0.7.0.1
 */