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
    //   45: astore_1
    //   46: aload_1
    //   47: checkcast 146	java/util/Map
    //   50: ldc 148
    //   52: ldc 150
    //   54: invokeinterface 154 3 0
    //   59: pop
    //   60: aload_1
    //   61: checkcast 146	java/util/Map
    //   64: ldc 156
    //   66: ldc 158
    //   68: invokeinterface 154 3 0
    //   73: pop
    //   74: aload_1
    //   75: checkcast 146	java/util/Map
    //   78: ldc 160
    //   80: getstatic 107	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   83: invokeinterface 154 3 0
    //   88: pop
    //   89: aload_0
    //   90: aload_1
    //   91: invokevirtual 164	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   94: astore_3
    //   95: aload_3
    //   96: ifnull +342 -> 438
    //   99: new 166	java/util/zip/GZIPOutputStream
    //   102: dup
    //   103: new 168	java/io/DataOutputStream
    //   106: dup
    //   107: aload_3
    //   108: invokevirtual 174	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   111: invokespecial 177	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   114: checkcast 179	java/io/OutputStream
    //   117: invokespecial 180	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   120: checkcast 182	java/io/Closeable
    //   123: astore 4
    //   125: aconst_null
    //   126: checkcast 96	java/lang/Throwable
    //   129: astore_2
    //   130: aload_2
    //   131: astore_1
    //   132: aload 4
    //   134: checkcast 166	java/util/zip/GZIPOutputStream
    //   137: astore 5
    //   139: aload_2
    //   140: astore_1
    //   141: aload_0
    //   142: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   145: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   148: invokevirtual 194	org/json/JSONObject:toString	()Ljava/lang/String;
    //   151: astore 6
    //   153: aload_2
    //   154: astore_1
    //   155: aload 6
    //   157: ldc 196
    //   159: invokestatic 199	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   162: aload_2
    //   163: astore_1
    //   164: ldc 201
    //   166: invokestatic 207	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   169: astore 7
    //   171: aload_2
    //   172: astore_1
    //   173: aload 7
    //   175: ldc 209
    //   177: invokestatic 199	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   180: aload 6
    //   182: ifnonnull +111 -> 293
    //   185: aload_2
    //   186: astore_1
    //   187: new 211	kotlin/TypeCastException
    //   190: dup
    //   191: ldc 213
    //   193: invokespecial 216	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   196: athrow
    //   197: astore_2
    //   198: aload_2
    //   199: astore_1
    //   200: aload_2
    //   201: athrow
    //   202: astore_2
    //   203: aload 4
    //   205: aload_1
    //   206: invokestatic 222	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   209: aload_2
    //   210: athrow
    //   211: astore_1
    //   212: aload_0
    //   213: iconst_0
    //   214: invokevirtual 82	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:setRetry	(I)V
    //   217: aload_0
    //   218: getfield 70	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   221: astore_2
    //   222: aload_2
    //   223: ifnull +15 -> 238
    //   226: aload_2
    //   227: sipush 600
    //   230: ldc 224
    //   232: iconst_0
    //   233: invokeinterface 230 4 0
    //   238: getstatic 235	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   241: ldc 41
    //   243: new 237	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   250: aload_1
    //   251: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: ldc 244
    //   256: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   263: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   266: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   269: ldc 249
    //   271: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: aload_1
    //   278: checkcast 96	java/lang/Throwable
    //   281: invokevirtual 254	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   284: aload_3
    //   285: ifnull -248 -> 37
    //   288: aload_3
    //   289: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   292: return
    //   293: aload_2
    //   294: astore_1
    //   295: aload 6
    //   297: aload 7
    //   299: invokevirtual 263	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   302: astore 6
    //   304: aload_2
    //   305: astore_1
    //   306: aload 6
    //   308: ldc_w 265
    //   311: invokestatic 199	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   314: aload_2
    //   315: astore_1
    //   316: aload 5
    //   318: aload 6
    //   320: invokevirtual 269	java/util/zip/GZIPOutputStream:write	([B)V
    //   323: aload_2
    //   324: astore_1
    //   325: aload 5
    //   327: invokevirtual 272	java/util/zip/GZIPOutputStream:finish	()V
    //   330: aload_2
    //   331: astore_1
    //   332: getstatic 277	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   335: astore 5
    //   337: aload 4
    //   339: aload_2
    //   340: invokestatic 222	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   343: getstatic 282	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   346: new 284	java/io/BufferedInputStream
    //   349: dup
    //   350: aload_3
    //   351: invokevirtual 288	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   354: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   357: checkcast 293	java/io/InputStream
    //   360: sipush 8192
    //   363: invokevirtual 299	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   366: astore_1
    //   367: getstatic 235	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   370: iconst_2
    //   371: anewarray 259	java/lang/String
    //   374: dup
    //   375: iconst_0
    //   376: ldc 41
    //   378: aastore
    //   379: dup
    //   380: iconst_1
    //   381: new 237	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   388: ldc_w 301
    //   391: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_1
    //   395: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: aastore
    //   402: invokevirtual 305	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   405: aload_0
    //   406: aload_1
    //   407: invokevirtual 309	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   410: ifeq +37 -> 447
    //   413: aload_0
    //   414: getfield 70	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   417: astore_1
    //   418: aload_1
    //   419: ifnull +19 -> 438
    //   422: aload_1
    //   423: sipush 200
    //   426: aload_0
    //   427: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   430: invokevirtual 312	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   433: invokeinterface 316 3 0
    //   438: aload_3
    //   439: ifnull -402 -> 37
    //   442: aload_3
    //   443: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   446: return
    //   447: aload_0
    //   448: invokevirtual 78	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:getRetry	()I
    //   451: ifle +88 -> 539
    //   454: aload_0
    //   455: invokestatic 322	java/lang/Math:random	()D
    //   458: iconst_5
    //   459: i2d
    //   460: dmul
    //   461: iconst_2
    //   462: i2d
    //   463: dadd
    //   464: d2l
    //   465: sipush 1000
    //   468: i2l
    //   469: lmul
    //   470: invokespecial 324	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:reSend	(J)V
    //   473: goto -35 -> 438
    //   476: astore_1
    //   477: getstatic 235	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   480: ldc 41
    //   482: new 237	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   489: aload_1
    //   490: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   493: ldc 244
    //   495: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_0
    //   499: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   502: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   505: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   508: ldc 249
    //   510: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: aload_1
    //   517: checkcast 96	java/lang/Throwable
    //   520: invokevirtual 254	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   523: aload_0
    //   524: ldc2_w 325
    //   527: invokespecial 324	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:reSend	(J)V
    //   530: aload_3
    //   531: ifnull -494 -> 37
    //   534: aload_3
    //   535: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   538: return
    //   539: aload_0
    //   540: aload_0
    //   541: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   544: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   547: ldc_w 328
    //   550: invokevirtual 332	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   553: aload_3
    //   554: invokevirtual 335	java/net/HttpURLConnection:getResponseCode	()I
    //   557: aload_1
    //   558: aload_0
    //   559: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   562: invokevirtual 338	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getEventName	()Ljava/lang/String;
    //   565: invokevirtual 342	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:addLost	(IILjava/lang/String;Ljava/lang/String;)V
    //   568: aload_0
    //   569: getfield 70	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   572: astore_2
    //   573: aload_2
    //   574: ifnull -136 -> 438
    //   577: aload_2
    //   578: sipush 700
    //   581: aload_1
    //   582: aload_0
    //   583: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   586: invokevirtual 312	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   589: invokeinterface 230 4 0
    //   594: goto -156 -> 438
    //   597: astore_1
    //   598: getstatic 235	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   601: ldc 41
    //   603: new 237	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   610: aload_1
    //   611: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   614: ldc 244
    //   616: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload_0
    //   620: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   623: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   626: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   629: ldc 249
    //   631: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: aload_1
    //   638: invokevirtual 254	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   641: aload_0
    //   642: iconst_0
    //   643: invokevirtual 82	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:setRetry	(I)V
    //   646: aload_3
    //   647: ifnull -610 -> 37
    //   650: aload_3
    //   651: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   654: return
    //   655: astore_1
    //   656: getstatic 235	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   659: ldc 41
    //   661: new 237	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   668: aload_1
    //   669: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   672: ldc 244
    //   674: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload_0
    //   678: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   681: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   684: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   687: ldc 249
    //   689: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: aload_1
    //   696: checkcast 96	java/lang/Throwable
    //   699: invokevirtual 254	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   702: goto -418 -> 284
    //   705: astore_1
    //   706: aload_3
    //   707: ifnull +7 -> 714
    //   710: aload_3
    //   711: invokevirtual 257	java/net/HttpURLConnection:disconnect	()V
    //   714: aload_1
    //   715: athrow
    //   716: astore_1
    //   717: getstatic 235	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   720: ldc 41
    //   722: new 237	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   729: aload_1
    //   730: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   733: ldc 244
    //   735: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: aload_0
    //   739: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   742: invokevirtual 188	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   745: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   748: ldc 249
    //   750: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: aload_1
    //   757: checkcast 96	java/lang/Throwable
    //   760: invokevirtual 254	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   763: goto -479 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	766	0	this	JsonUploadRunnable
    //   45	161	1	localObject1	java.lang.Object
    //   211	67	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   294	129	1	localObject2	java.lang.Object
    //   476	106	1	localException1	java.lang.Exception
    //   597	41	1	localThrowable1	java.lang.Throwable
    //   655	41	1	localException2	java.lang.Exception
    //   705	10	1	localObject3	java.lang.Object
    //   716	41	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   129	57	2	localThrowable2	java.lang.Throwable
    //   197	4	2	localThrowable3	java.lang.Throwable
    //   202	8	2	localObject4	java.lang.Object
    //   221	357	2	localReportResultCallback	IReporter.ReportResultCallback
    //   94	617	3	localHttpURLConnection	java.net.HttpURLConnection
    //   123	215	4	localCloseable	java.io.Closeable
    //   137	199	5	localObject5	java.lang.Object
    //   151	168	6	localObject6	java.lang.Object
    //   169	129	7	localCharset	java.nio.charset.Charset
    // Exception table:
    //   from	to	target	type
    //   132	139	197	java/lang/Throwable
    //   141	153	197	java/lang/Throwable
    //   155	162	197	java/lang/Throwable
    //   164	171	197	java/lang/Throwable
    //   173	180	197	java/lang/Throwable
    //   187	197	197	java/lang/Throwable
    //   295	304	197	java/lang/Throwable
    //   306	314	197	java/lang/Throwable
    //   316	323	197	java/lang/Throwable
    //   325	330	197	java/lang/Throwable
    //   332	337	197	java/lang/Throwable
    //   132	139	202	finally
    //   141	153	202	finally
    //   155	162	202	finally
    //   164	171	202	finally
    //   173	180	202	finally
    //   187	197	202	finally
    //   200	202	202	finally
    //   295	304	202	finally
    //   306	314	202	finally
    //   316	323	202	finally
    //   325	330	202	finally
    //   332	337	202	finally
    //   99	130	211	java/lang/OutOfMemoryError
    //   203	211	211	java/lang/OutOfMemoryError
    //   337	418	211	java/lang/OutOfMemoryError
    //   422	438	211	java/lang/OutOfMemoryError
    //   447	473	211	java/lang/OutOfMemoryError
    //   539	573	211	java/lang/OutOfMemoryError
    //   577	594	211	java/lang/OutOfMemoryError
    //   99	130	476	java/lang/Exception
    //   203	211	476	java/lang/Exception
    //   337	418	476	java/lang/Exception
    //   422	438	476	java/lang/Exception
    //   447	473	476	java/lang/Exception
    //   539	573	476	java/lang/Exception
    //   577	594	476	java/lang/Exception
    //   99	130	597	java/lang/Throwable
    //   203	211	597	java/lang/Throwable
    //   337	418	597	java/lang/Throwable
    //   422	438	597	java/lang/Throwable
    //   447	473	597	java/lang/Throwable
    //   539	573	597	java/lang/Throwable
    //   577	594	597	java/lang/Throwable
    //   217	222	655	java/lang/Exception
    //   226	238	655	java/lang/Exception
    //   238	284	655	java/lang/Exception
    //   99	130	705	finally
    //   203	211	705	finally
    //   212	217	705	finally
    //   217	222	705	finally
    //   226	238	705	finally
    //   238	284	705	finally
    //   337	418	705	finally
    //   422	438	705	finally
    //   447	473	705	finally
    //   477	530	705	finally
    //   539	573	705	finally
    //   577	594	705	finally
    //   598	646	705	finally
    //   656	702	705	finally
    //   717	763	705	finally
    //   217	222	716	java/lang/OutOfMemoryError
    //   226	238	716	java/lang/OutOfMemoryError
    //   238	284	716	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.JsonUploadRunnable
 * JD-Core Version:    0.7.0.1
 */