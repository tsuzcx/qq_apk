package com.tencent.qapmsdk.base.reporter.uploaddata.runnable;

import android.os.Handler;
import com.tencent.qapmsdk.base.reporter.uploaddata.QAPMUpload;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/QAPMUpload;", "Ljava/lang/Runnable;", "url", "Ljava/net/URL;", "resultObject", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;", "callback", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "handler", "Landroid/os/Handler;", "originalPath", "", "(Ljava/net/URL;Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;Landroid/os/Handler;Ljava/lang/String;)V", "buffer", "Ljava/lang/StringBuffer;", "getBuffer", "()Ljava/lang/StringBuffer;", "generateAfterStream", "generateBeforeStream", "disposition", "generateDisposition", "fileName", "generateReqBackup", "getUploadFilePath", "reSend", "", "request", "run", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class FileUploadRunnable
  extends QAPMUpload
  implements Runnable
{
  private static final String BOUNDARY = "27182818284590452353602874713526";
  public static final FileUploadRunnable.Companion Companion = new FileUploadRunnable.Companion(null);
  private static final String TAG = "QAPM_base_FileUploadRunnable";
  @NotNull
  private final StringBuffer buffer;
  private final IReporter.ReportResultCallback callback;
  private final Handler handler;
  private final String originalPath;
  private final ResultObject resultObject;
  
  public FileUploadRunnable(@NotNull URL paramURL, @NotNull ResultObject paramResultObject, @Nullable IReporter.ReportResultCallback paramReportResultCallback, @NotNull Handler paramHandler, @NotNull String paramString)
  {
    super(paramURL);
    this.resultObject = paramResultObject;
    this.callback = paramReportResultCallback;
    this.handler = paramHandler;
    this.originalPath = paramString;
    this.buffer = new StringBuffer(512);
  }
  
  private final String generateAfterStream()
  {
    this.buffer.delete(0, this.buffer.length());
    this.buffer.append("\r\n--").append("27182818284590452353602874713526").append("\r\n");
    String str = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "buffer.toString()");
    return str;
  }
  
  private final String generateBeforeStream(String paramString)
  {
    this.buffer.delete(0, this.buffer.length());
    this.buffer.append("--").append("27182818284590452353602874713526").append("\r\n").append(paramString).append("\r\n\r\n");
    paramString = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "buffer.toString()");
    return paramString;
  }
  
  private final String generateDisposition(String paramString)
  {
    this.buffer.delete(0, this.buffer.length());
    this.buffer.append("Content-Disposition: form-data; name=\"uploadedfile\"; filename=\"").append(paramString).append("\"");
    paramString = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "buffer.toString()");
    return paramString;
  }
  
  private final String generateReqBackup()
  {
    this.buffer.delete(0, this.buffer.length());
    this.buffer.append("Content-Disposition: form-data; name=\"_json\"\r\n\r\n").append(this.resultObject.getParams().toString()).append("\r\n--").append("27182818284590452353602874713526").append("--\r\n");
    String str = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "buffer.toString()");
    return str;
  }
  
  private final String getUploadFilePath()
  {
    int i;
    Object localObject;
    if (((CharSequence)this.originalPath).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label31;
      }
      localObject = "";
    }
    label31:
    String str1;
    FileUtil.Companion localCompanion;
    String str2;
    do
    {
      return localObject;
      i = 0;
      break;
      localObject = new File(this.originalPath);
      if ((((File)localObject).isFile()) && (((File)localObject).canRead())) {
        return this.originalPath;
      }
      if ((!((File)localObject).isDirectory()) || (!((File)localObject).canRead())) {
        break label153;
      }
      str1 = new File(((File)localObject).getParent(), "out_" + System.currentTimeMillis() + ".zip").getAbsolutePath();
      localCompanion = FileUtil.Companion;
      str2 = this.originalPath;
      Intrinsics.checkExpressionValueIsNotNull(str1, "zipFilePath");
      localObject = str1;
    } while (FileUtil.Companion.zipFiles$default(localCompanion, str2, str1, false, 4, null));
    return "";
    label153:
    return "";
  }
  
  private final void reSend()
  {
    if (getRetry() > 0)
    {
      setRetry(getRetry() - 1);
      this.handler.postDelayed((Runnable)this, 1800000L);
    }
  }
  
  @NotNull
  public final StringBuffer getBuffer()
  {
    return this.buffer;
  }
  
  public void request()
  {
    run();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 237	com/tencent/qapmsdk/base/config/SDKConfig:PURE_QAPM	Z
    //   3: ifeq +35 -> 38
    //   6: getstatic 242	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   9: checkcast 146	java/lang/CharSequence
    //   12: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +23 -> 38
    //   18: getstatic 254	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:INSTANCE	Lcom/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy;
    //   21: invokevirtual 258	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:getAuthorization	()Lcom/tencent/qapmsdk/base/reporter/authorization/Authorization;
    //   24: getstatic 262	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   27: getfield 267	com/tencent/qapmsdk/base/meta/UserMeta:appKey	Ljava/lang/String;
    //   30: iconst_1
    //   31: invokevirtual 273	com/tencent/qapmsdk/base/reporter/authorization/Authorization:getToken	(Ljava/lang/String;Z)Z
    //   34: ifne +4 -> 38
    //   37: return
    //   38: aload_0
    //   39: invokespecial 275	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:getUploadFilePath	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: checkcast 146	java/lang/CharSequence
    //   47: invokeinterface 147 1 0
    //   52: ifne +38 -> 90
    //   55: iconst_1
    //   56: istore_1
    //   57: iload_1
    //   58: ifeq +37 -> 95
    //   61: aload_0
    //   62: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   65: astore_2
    //   66: aload_2
    //   67: ifnull -30 -> 37
    //   70: aload_2
    //   71: sipush 601
    //   74: ldc_w 277
    //   77: aload_0
    //   78: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   81: invokevirtual 280	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   84: invokeinterface 286 4 0
    //   89: return
    //   90: iconst_0
    //   91: istore_1
    //   92: goto -35 -> 57
    //   95: new 150	java/io/File
    //   98: dup
    //   99: aload_2
    //   100: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   103: astore 7
    //   105: new 288	java/util/HashMap
    //   108: dup
    //   109: invokespecial 289	java/util/HashMap:<init>	()V
    //   112: astore_2
    //   113: aload_2
    //   114: checkcast 291	java/util/Map
    //   117: ldc_w 293
    //   120: ldc_w 295
    //   123: invokeinterface 299 3 0
    //   128: pop
    //   129: aload_2
    //   130: checkcast 291	java/util/Map
    //   133: ldc_w 301
    //   136: getstatic 242	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   139: invokeinterface 299 3 0
    //   144: pop
    //   145: aload_0
    //   146: aload_2
    //   147: invokevirtual 305	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   150: astore 6
    //   152: aload 6
    //   154: ifnull +324 -> 478
    //   157: new 307	java/io/DataOutputStream
    //   160: dup
    //   161: aload 6
    //   163: invokevirtual 313	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   166: invokespecial 316	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   169: checkcast 318	java/io/Closeable
    //   172: astore 8
    //   174: aconst_null
    //   175: checkcast 231	java/lang/Throwable
    //   178: astore 5
    //   180: aload 5
    //   182: astore_2
    //   183: aload 8
    //   185: checkcast 307	java/io/DataOutputStream
    //   188: astore_3
    //   189: aload 5
    //   191: astore_2
    //   192: aload 7
    //   194: invokevirtual 321	java/io/File:getName	()Ljava/lang/String;
    //   197: astore 4
    //   199: aload 5
    //   201: astore_2
    //   202: aload 4
    //   204: ldc_w 323
    //   207: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   210: aload 5
    //   212: astore_2
    //   213: aload_3
    //   214: aload_0
    //   215: aload_0
    //   216: aload 4
    //   218: invokespecial 325	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateDisposition	(Ljava/lang/String;)Ljava/lang/String;
    //   221: invokespecial 327	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateBeforeStream	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokevirtual 330	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   227: aload 5
    //   229: astore_2
    //   230: new 332	java/io/FileInputStream
    //   233: dup
    //   234: aload 7
    //   236: invokespecial 335	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   239: checkcast 318	java/io/Closeable
    //   242: astore 9
    //   244: aload 5
    //   246: astore_2
    //   247: aconst_null
    //   248: checkcast 231	java/lang/Throwable
    //   251: astore 4
    //   253: aload 9
    //   255: checkcast 332	java/io/FileInputStream
    //   258: astore_2
    //   259: aload_2
    //   260: checkcast 337	java/io/InputStream
    //   263: aload_3
    //   264: checkcast 339	java/io/OutputStream
    //   267: aload_2
    //   268: invokevirtual 342	java/io/FileInputStream:available	()I
    //   271: ldc_w 343
    //   274: invokestatic 349	java/lang/Math:min	(II)I
    //   277: invokestatic 355	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   280: pop2
    //   281: aload 5
    //   283: astore_2
    //   284: aload 9
    //   286: aload 4
    //   288: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   291: aload 5
    //   293: astore_2
    //   294: aload_3
    //   295: aload_0
    //   296: invokespecial 363	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateAfterStream	()Ljava/lang/String;
    //   299: invokevirtual 330	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   302: aload 5
    //   304: astore_2
    //   305: aload_3
    //   306: aload_0
    //   307: invokespecial 365	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateReqBackup	()Ljava/lang/String;
    //   310: invokevirtual 330	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   313: aload 5
    //   315: astore_2
    //   316: getstatic 370	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   319: astore_3
    //   320: aload 8
    //   322: aload 5
    //   324: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   327: new 372	java/io/BufferedInputStream
    //   330: dup
    //   331: aload 6
    //   333: invokevirtual 376	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   336: invokespecial 379	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   339: checkcast 318	java/io/Closeable
    //   342: astore 4
    //   344: aconst_null
    //   345: checkcast 231	java/lang/Throwable
    //   348: astore_3
    //   349: aload_3
    //   350: astore_2
    //   351: aload 4
    //   353: checkcast 372	java/io/BufferedInputStream
    //   356: astore 5
    //   358: aload_3
    //   359: astore_2
    //   360: getstatic 198	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   363: aload 5
    //   365: checkcast 337	java/io/InputStream
    //   368: sipush 8192
    //   371: invokevirtual 383	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   374: astore 5
    //   376: aload_3
    //   377: astore_2
    //   378: getstatic 388	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   381: iconst_2
    //   382: anewarray 390	java/lang/String
    //   385: dup
    //   386: iconst_0
    //   387: ldc 55
    //   389: aastore
    //   390: dup
    //   391: iconst_1
    //   392: new 168	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 392
    //   402: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload 5
    //   407: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: aastore
    //   414: invokevirtual 396	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   417: aload_3
    //   418: astore_2
    //   419: getstatic 370	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   422: astore 8
    //   424: aload 4
    //   426: aload_3
    //   427: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   430: aload_0
    //   431: aload 5
    //   433: invokevirtual 400	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   436: ifeq +250 -> 686
    //   439: aload_0
    //   440: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   443: astore_2
    //   444: aload_2
    //   445: ifnull +19 -> 464
    //   448: aload_2
    //   449: sipush 200
    //   452: aload_0
    //   453: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   456: invokevirtual 280	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   459: invokeinterface 404 3 0
    //   464: aload 7
    //   466: invokevirtual 157	java/io/File:isFile	()Z
    //   469: ifeq +214 -> 683
    //   472: aload 7
    //   474: invokevirtual 406	java/io/File:delete	()Z
    //   477: pop
    //   478: aload 6
    //   480: ifnull -443 -> 37
    //   483: aload 6
    //   485: invokevirtual 409	java/net/HttpURLConnection:disconnect	()V
    //   488: return
    //   489: astore 4
    //   491: aload 4
    //   493: athrow
    //   494: astore_3
    //   495: aload 5
    //   497: astore_2
    //   498: aload 9
    //   500: aload 4
    //   502: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   505: aload 5
    //   507: astore_2
    //   508: aload_3
    //   509: athrow
    //   510: astore_3
    //   511: aload_3
    //   512: astore_2
    //   513: aload_3
    //   514: athrow
    //   515: astore_3
    //   516: aload 8
    //   518: aload_2
    //   519: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   522: aload_3
    //   523: athrow
    //   524: astore_2
    //   525: aload_0
    //   526: iconst_0
    //   527: invokevirtual 212	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:setRetry	(I)V
    //   530: aload_0
    //   531: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   534: astore_2
    //   535: aload_2
    //   536: ifnull +16 -> 552
    //   539: aload_2
    //   540: sipush 600
    //   543: ldc_w 411
    //   546: iconst_0
    //   547: invokeinterface 286 4 0
    //   552: aload 6
    //   554: ifnull -517 -> 37
    //   557: aload 6
    //   559: invokevirtual 409	java/net/HttpURLConnection:disconnect	()V
    //   562: return
    //   563: astore_3
    //   564: aload_3
    //   565: astore_2
    //   566: aload_3
    //   567: athrow
    //   568: astore_3
    //   569: aload 4
    //   571: aload_2
    //   572: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   575: aload_3
    //   576: athrow
    //   577: astore_2
    //   578: getstatic 388	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   581: iconst_2
    //   582: anewarray 390	java/lang/String
    //   585: dup
    //   586: iconst_0
    //   587: ldc 55
    //   589: aastore
    //   590: dup
    //   591: iconst_1
    //   592: new 168	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   599: aload_2
    //   600: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   603: ldc_w 416
    //   606: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: aload 7
    //   611: invokevirtual 419	java/io/File:getPath	()Ljava/lang/String;
    //   614: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: ldc_w 421
    //   620: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: aastore
    //   627: invokevirtual 424	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   630: aload 7
    //   632: invokevirtual 157	java/io/File:isFile	()Z
    //   635: ifeq +9 -> 644
    //   638: aload 7
    //   640: invokevirtual 406	java/io/File:delete	()Z
    //   643: pop
    //   644: aload_0
    //   645: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   648: astore_2
    //   649: aload_2
    //   650: ifnull +22 -> 672
    //   653: aload_2
    //   654: sipush 601
    //   657: ldc_w 426
    //   660: aload_0
    //   661: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   664: invokevirtual 280	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   667: invokeinterface 286 4 0
    //   672: aload 6
    //   674: ifnull -637 -> 37
    //   677: aload 6
    //   679: invokevirtual 409	java/net/HttpURLConnection:disconnect	()V
    //   682: return
    //   683: goto -205 -> 478
    //   686: aload_0
    //   687: invokevirtual 209	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:getRetry	()I
    //   690: ifle +34 -> 724
    //   693: aload_0
    //   694: invokespecial 428	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:reSend	()V
    //   697: goto -219 -> 478
    //   700: astore_2
    //   701: getstatic 388	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   704: ldc 55
    //   706: aload_2
    //   707: checkcast 231	java/lang/Throwable
    //   710: invokevirtual 432	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   713: aload 6
    //   715: ifnull -678 -> 37
    //   718: aload 6
    //   720: invokevirtual 409	java/net/HttpURLConnection:disconnect	()V
    //   723: return
    //   724: aload_0
    //   725: aload_0
    //   726: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   729: invokevirtual 139	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   732: ldc_w 434
    //   735: invokevirtual 438	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   738: aload 6
    //   740: invokevirtual 441	java/net/HttpURLConnection:getResponseCode	()I
    //   743: aload 5
    //   745: aload_0
    //   746: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   749: invokevirtual 444	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getEventName	()Ljava/lang/String;
    //   752: invokevirtual 448	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:addLost	(IILjava/lang/String;Ljava/lang/String;)V
    //   755: aload_0
    //   756: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   759: astore_2
    //   760: aload_2
    //   761: ifnull -283 -> 478
    //   764: aload_2
    //   765: sipush 700
    //   768: aload 5
    //   770: aload_0
    //   771: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   774: invokevirtual 280	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   777: invokeinterface 286 4 0
    //   782: goto -304 -> 478
    //   785: astore_2
    //   786: aload_0
    //   787: iconst_0
    //   788: invokevirtual 212	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:setRetry	(I)V
    //   791: getstatic 388	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   794: ldc 55
    //   796: aload_2
    //   797: invokevirtual 432	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   800: aload 6
    //   802: ifnull -765 -> 37
    //   805: aload 6
    //   807: invokevirtual 409	java/net/HttpURLConnection:disconnect	()V
    //   810: return
    //   811: astore_2
    //   812: aload 6
    //   814: ifnull +8 -> 822
    //   817: aload 6
    //   819: invokevirtual 409	java/net/HttpURLConnection:disconnect	()V
    //   822: aload_2
    //   823: athrow
    //   824: astore_3
    //   825: goto -330 -> 495
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	828	0	this	FileUploadRunnable
    //   56	36	1	i	int
    //   42	477	2	localObject1	Object
    //   524	1	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   534	38	2	localObject2	Object
    //   577	23	2	localFileNotFoundException	java.io.FileNotFoundException
    //   648	6	2	localReportResultCallback1	IReporter.ReportResultCallback
    //   700	7	2	localException	java.lang.Exception
    //   759	6	2	localReportResultCallback2	IReporter.ReportResultCallback
    //   785	12	2	localThrowable1	java.lang.Throwable
    //   811	12	2	localObject3	Object
    //   188	239	3	localObject4	Object
    //   494	15	3	localObject5	Object
    //   510	4	3	localThrowable2	java.lang.Throwable
    //   515	8	3	localObject6	Object
    //   563	4	3	localThrowable3	java.lang.Throwable
    //   568	8	3	localObject7	Object
    //   824	1	3	localObject8	Object
    //   197	228	4	localObject9	Object
    //   489	81	4	localThrowable4	java.lang.Throwable
    //   178	591	5	localObject10	Object
    //   150	668	6	localHttpURLConnection	java.net.HttpURLConnection
    //   103	536	7	localFile	File
    //   172	345	8	localObject11	Object
    //   242	257	9	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   253	281	489	java/lang/Throwable
    //   491	494	494	finally
    //   183	189	510	java/lang/Throwable
    //   192	199	510	java/lang/Throwable
    //   202	210	510	java/lang/Throwable
    //   213	227	510	java/lang/Throwable
    //   230	244	510	java/lang/Throwable
    //   247	253	510	java/lang/Throwable
    //   284	291	510	java/lang/Throwable
    //   294	302	510	java/lang/Throwable
    //   305	313	510	java/lang/Throwable
    //   316	320	510	java/lang/Throwable
    //   498	505	510	java/lang/Throwable
    //   508	510	510	java/lang/Throwable
    //   183	189	515	finally
    //   192	199	515	finally
    //   202	210	515	finally
    //   213	227	515	finally
    //   230	244	515	finally
    //   247	253	515	finally
    //   284	291	515	finally
    //   294	302	515	finally
    //   305	313	515	finally
    //   316	320	515	finally
    //   498	505	515	finally
    //   508	510	515	finally
    //   513	515	515	finally
    //   157	180	524	java/lang/OutOfMemoryError
    //   320	349	524	java/lang/OutOfMemoryError
    //   424	444	524	java/lang/OutOfMemoryError
    //   448	464	524	java/lang/OutOfMemoryError
    //   464	478	524	java/lang/OutOfMemoryError
    //   516	524	524	java/lang/OutOfMemoryError
    //   569	577	524	java/lang/OutOfMemoryError
    //   686	697	524	java/lang/OutOfMemoryError
    //   724	760	524	java/lang/OutOfMemoryError
    //   764	782	524	java/lang/OutOfMemoryError
    //   351	358	563	java/lang/Throwable
    //   360	376	563	java/lang/Throwable
    //   378	417	563	java/lang/Throwable
    //   419	424	563	java/lang/Throwable
    //   351	358	568	finally
    //   360	376	568	finally
    //   378	417	568	finally
    //   419	424	568	finally
    //   566	568	568	finally
    //   157	180	577	java/io/FileNotFoundException
    //   320	349	577	java/io/FileNotFoundException
    //   424	444	577	java/io/FileNotFoundException
    //   448	464	577	java/io/FileNotFoundException
    //   464	478	577	java/io/FileNotFoundException
    //   516	524	577	java/io/FileNotFoundException
    //   569	577	577	java/io/FileNotFoundException
    //   686	697	577	java/io/FileNotFoundException
    //   724	760	577	java/io/FileNotFoundException
    //   764	782	577	java/io/FileNotFoundException
    //   157	180	700	java/lang/Exception
    //   320	349	700	java/lang/Exception
    //   424	444	700	java/lang/Exception
    //   448	464	700	java/lang/Exception
    //   464	478	700	java/lang/Exception
    //   516	524	700	java/lang/Exception
    //   569	577	700	java/lang/Exception
    //   686	697	700	java/lang/Exception
    //   724	760	700	java/lang/Exception
    //   764	782	700	java/lang/Exception
    //   157	180	785	java/lang/Throwable
    //   320	349	785	java/lang/Throwable
    //   424	444	785	java/lang/Throwable
    //   448	464	785	java/lang/Throwable
    //   464	478	785	java/lang/Throwable
    //   516	524	785	java/lang/Throwable
    //   569	577	785	java/lang/Throwable
    //   686	697	785	java/lang/Throwable
    //   724	760	785	java/lang/Throwable
    //   764	782	785	java/lang/Throwable
    //   157	180	811	finally
    //   320	349	811	finally
    //   424	444	811	finally
    //   448	464	811	finally
    //   464	478	811	finally
    //   516	524	811	finally
    //   525	535	811	finally
    //   539	552	811	finally
    //   569	577	811	finally
    //   578	644	811	finally
    //   644	649	811	finally
    //   653	672	811	finally
    //   686	697	811	finally
    //   701	713	811	finally
    //   724	760	811	finally
    //   764	782	811	finally
    //   786	800	811	finally
    //   253	281	824	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.FileUploadRunnable
 * JD-Core Version:    0.7.0.1
 */