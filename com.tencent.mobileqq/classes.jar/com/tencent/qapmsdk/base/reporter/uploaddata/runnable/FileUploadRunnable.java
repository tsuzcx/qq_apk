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
    Object localObject = this.buffer;
    ((StringBuffer)localObject).delete(0, ((StringBuffer)localObject).length());
    localObject = this.buffer;
    ((StringBuffer)localObject).append("\r\n--");
    ((StringBuffer)localObject).append("27182818284590452353602874713526");
    ((StringBuffer)localObject).append("\r\n");
    localObject = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "buffer.toString()");
    return localObject;
  }
  
  private final String generateBeforeStream(String paramString)
  {
    StringBuffer localStringBuffer = this.buffer;
    localStringBuffer.delete(0, localStringBuffer.length());
    localStringBuffer = this.buffer;
    localStringBuffer.append("--");
    localStringBuffer.append("27182818284590452353602874713526");
    localStringBuffer.append("\r\n");
    localStringBuffer.append(paramString);
    localStringBuffer.append("\r\n\r\n");
    paramString = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "buffer.toString()");
    return paramString;
  }
  
  private final String generateDisposition(String paramString)
  {
    StringBuffer localStringBuffer = this.buffer;
    localStringBuffer.delete(0, localStringBuffer.length());
    localStringBuffer = this.buffer;
    localStringBuffer.append("Content-Disposition: form-data; name=\"uploadedfile\"; filename=\"");
    localStringBuffer.append(paramString);
    localStringBuffer.append("\"");
    paramString = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "buffer.toString()");
    return paramString;
  }
  
  private final String generateReqBackup()
  {
    Object localObject = this.buffer;
    ((StringBuffer)localObject).delete(0, ((StringBuffer)localObject).length());
    localObject = this.buffer;
    ((StringBuffer)localObject).append("Content-Disposition: form-data; name=\"_json\"\r\n\r\n");
    ((StringBuffer)localObject).append(this.resultObject.getParams().toString());
    ((StringBuffer)localObject).append("\r\n--");
    ((StringBuffer)localObject).append("27182818284590452353602874713526");
    ((StringBuffer)localObject).append("--\r\n");
    localObject = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "buffer.toString()");
    return localObject;
  }
  
  private final String getUploadFilePath()
  {
    int i;
    if (((CharSequence)this.originalPath).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    String str1 = "";
    if (i != 0) {
      return "";
    }
    Object localObject2 = new File(this.originalPath);
    if ((((File)localObject2).isFile()) && (((File)localObject2).canRead())) {
      return this.originalPath;
    }
    Object localObject1 = str1;
    if (((File)localObject2).isDirectory())
    {
      localObject1 = str1;
      if (((File)localObject2).canRead())
      {
        localObject1 = ((File)localObject2).getParent();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("out_");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        ((StringBuilder)localObject2).append(".zip");
        localObject2 = new File((String)localObject1, ((StringBuilder)localObject2).toString()).getAbsolutePath();
        FileUtil.Companion localCompanion = FileUtil.Companion;
        String str2 = this.originalPath;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "zipFilePath");
        localObject1 = str1;
        if (FileUtil.Companion.zipFiles$default(localCompanion, str2, (String)localObject2, false, 4, null)) {
          localObject1 = localObject2;
        }
      }
    }
    return localObject1;
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
    //   52: ifne +8 -> 60
    //   55: iconst_1
    //   56: istore_1
    //   57: goto +5 -> 62
    //   60: iconst_0
    //   61: istore_1
    //   62: iload_1
    //   63: ifeq +32 -> 95
    //   66: aload_0
    //   67: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   70: astore_2
    //   71: aload_2
    //   72: ifnull +22 -> 94
    //   75: aload_2
    //   76: sipush 601
    //   79: ldc_w 277
    //   82: aload_0
    //   83: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   86: invokevirtual 280	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   89: invokeinterface 286 4 0
    //   94: return
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
    //   117: astore_3
    //   118: aload_3
    //   119: ldc_w 293
    //   122: ldc_w 295
    //   125: invokeinterface 299 3 0
    //   130: pop
    //   131: aload_3
    //   132: ldc_w 301
    //   135: getstatic 242	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   138: invokeinterface 299 3 0
    //   143: pop
    //   144: aload_0
    //   145: aload_2
    //   146: invokevirtual 305	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   149: astore 6
    //   151: aload 6
    //   153: ifnull +705 -> 858
    //   156: new 307	java/io/DataOutputStream
    //   159: dup
    //   160: aload 6
    //   162: invokevirtual 313	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   165: invokespecial 316	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   168: checkcast 318	java/io/Closeable
    //   171: astore 8
    //   173: aconst_null
    //   174: checkcast 231	java/lang/Throwable
    //   177: astore 4
    //   179: aload 4
    //   181: astore_2
    //   182: aload 8
    //   184: checkcast 307	java/io/DataOutputStream
    //   187: astore 10
    //   189: aload 4
    //   191: astore_2
    //   192: aload 7
    //   194: invokevirtual 321	java/io/File:getName	()Ljava/lang/String;
    //   197: astore_3
    //   198: aload 4
    //   200: astore_2
    //   201: aload_3
    //   202: ldc_w 323
    //   205: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   208: aload 4
    //   210: astore_2
    //   211: aload 10
    //   213: aload_0
    //   214: aload_0
    //   215: aload_3
    //   216: invokespecial 325	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateDisposition	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokespecial 327	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateBeforeStream	(Ljava/lang/String;)Ljava/lang/String;
    //   222: invokevirtual 330	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   225: aload 4
    //   227: astore_2
    //   228: new 332	java/io/FileInputStream
    //   231: dup
    //   232: aload 7
    //   234: invokespecial 335	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   237: checkcast 318	java/io/Closeable
    //   240: astore 9
    //   242: aload 4
    //   244: astore_2
    //   245: aconst_null
    //   246: checkcast 231	java/lang/Throwable
    //   249: astore 5
    //   251: aload 5
    //   253: astore_3
    //   254: aload 9
    //   256: checkcast 332	java/io/FileInputStream
    //   259: astore_2
    //   260: aload 5
    //   262: astore_3
    //   263: aload_2
    //   264: checkcast 337	java/io/InputStream
    //   267: aload 10
    //   269: checkcast 339	java/io/OutputStream
    //   272: aload_2
    //   273: invokevirtual 342	java/io/FileInputStream:available	()I
    //   276: ldc_w 343
    //   279: invokestatic 349	java/lang/Math:min	(II)I
    //   282: invokestatic 355	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   285: pop2
    //   286: aload 4
    //   288: astore_2
    //   289: aload 9
    //   291: aload 5
    //   293: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   296: aload 4
    //   298: astore_2
    //   299: aload 10
    //   301: aload_0
    //   302: invokespecial 363	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateAfterStream	()Ljava/lang/String;
    //   305: invokevirtual 330	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   308: aload 4
    //   310: astore_2
    //   311: aload 10
    //   313: aload_0
    //   314: invokespecial 365	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateReqBackup	()Ljava/lang/String;
    //   317: invokevirtual 330	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   320: aload 4
    //   322: astore_2
    //   323: getstatic 370	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   326: astore_3
    //   327: aload 8
    //   329: aload 4
    //   331: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   334: new 372	java/io/BufferedInputStream
    //   337: dup
    //   338: aload 6
    //   340: invokevirtual 376	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   343: invokespecial 379	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   346: checkcast 318	java/io/Closeable
    //   349: astore 4
    //   351: aconst_null
    //   352: checkcast 231	java/lang/Throwable
    //   355: astore_3
    //   356: aload_3
    //   357: astore_2
    //   358: aload 4
    //   360: checkcast 372	java/io/BufferedInputStream
    //   363: astore 5
    //   365: aload_3
    //   366: astore_2
    //   367: getstatic 198	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   370: aload 5
    //   372: checkcast 337	java/io/InputStream
    //   375: sipush 8192
    //   378: invokevirtual 383	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   381: astore 5
    //   383: aload_3
    //   384: astore_2
    //   385: getstatic 388	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   388: astore 8
    //   390: aload_3
    //   391: astore_2
    //   392: new 168	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   399: astore 9
    //   401: aload_3
    //   402: astore_2
    //   403: aload 9
    //   405: ldc_w 390
    //   408: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload_3
    //   413: astore_2
    //   414: aload 9
    //   416: aload 5
    //   418: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload_3
    //   423: astore_2
    //   424: aload 8
    //   426: iconst_2
    //   427: anewarray 392	java/lang/String
    //   430: dup
    //   431: iconst_0
    //   432: ldc 55
    //   434: aastore
    //   435: dup
    //   436: iconst_1
    //   437: aload 9
    //   439: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: aastore
    //   443: invokevirtual 396	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   446: aload_3
    //   447: astore_2
    //   448: getstatic 370	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   451: astore 8
    //   453: aload 4
    //   455: aload_3
    //   456: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   459: aload_0
    //   460: aload 5
    //   462: invokevirtual 400	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   465: ifeq +45 -> 510
    //   468: aload_0
    //   469: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   472: astore_2
    //   473: aload_2
    //   474: ifnull +19 -> 493
    //   477: aload_2
    //   478: sipush 200
    //   481: aload_0
    //   482: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   485: invokevirtual 280	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   488: invokeinterface 404 3 0
    //   493: aload 7
    //   495: invokevirtual 157	java/io/File:isFile	()Z
    //   498: ifeq +360 -> 858
    //   501: aload 7
    //   503: invokevirtual 406	java/io/File:delete	()Z
    //   506: pop
    //   507: goto +351 -> 858
    //   510: aload_0
    //   511: invokevirtual 209	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:getRetry	()I
    //   514: ifle +10 -> 524
    //   517: aload_0
    //   518: invokespecial 408	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:reSend	()V
    //   521: goto +337 -> 858
    //   524: aload_0
    //   525: aload_0
    //   526: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   529: invokevirtual 139	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   532: ldc_w 410
    //   535: invokevirtual 414	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   538: aload 6
    //   540: invokevirtual 417	java/net/HttpURLConnection:getResponseCode	()I
    //   543: aload 5
    //   545: aload_0
    //   546: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   549: invokevirtual 420	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getEventName	()Ljava/lang/String;
    //   552: invokevirtual 424	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:addLost	(IILjava/lang/String;Ljava/lang/String;)V
    //   555: aload_0
    //   556: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   559: astore_2
    //   560: aload_2
    //   561: ifnull +297 -> 858
    //   564: aload_2
    //   565: sipush 700
    //   568: aload 5
    //   570: aload_0
    //   571: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   574: invokevirtual 280	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   577: invokeinterface 286 4 0
    //   582: goto +276 -> 858
    //   585: astore_3
    //   586: goto +8 -> 594
    //   589: astore_3
    //   590: aload_3
    //   591: astore_2
    //   592: aload_3
    //   593: athrow
    //   594: aload 4
    //   596: aload_2
    //   597: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   600: aload_3
    //   601: athrow
    //   602: astore 5
    //   604: goto +8 -> 612
    //   607: astore_2
    //   608: aload_2
    //   609: astore_3
    //   610: aload_2
    //   611: athrow
    //   612: aload 4
    //   614: astore_2
    //   615: aload 9
    //   617: aload_3
    //   618: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   621: aload 4
    //   623: astore_2
    //   624: aload 5
    //   626: athrow
    //   627: astore_3
    //   628: goto +8 -> 636
    //   631: astore_3
    //   632: aload_3
    //   633: astore_2
    //   634: aload_3
    //   635: athrow
    //   636: aload 8
    //   638: aload_2
    //   639: invokestatic 361	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   642: aload_3
    //   643: athrow
    //   644: astore_2
    //   645: goto +201 -> 846
    //   648: astore_2
    //   649: aload_0
    //   650: iconst_0
    //   651: invokevirtual 212	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:setRetry	(I)V
    //   654: getstatic 388	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   657: ldc 55
    //   659: aload_2
    //   660: invokevirtual 428	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   663: aload 6
    //   665: ifnull +201 -> 866
    //   668: aload 6
    //   670: invokevirtual 431	java/net/HttpURLConnection:disconnect	()V
    //   673: return
    //   674: astore_2
    //   675: getstatic 388	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   678: ldc 55
    //   680: aload_2
    //   681: checkcast 231	java/lang/Throwable
    //   684: invokevirtual 428	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   687: aload 6
    //   689: ifnull +177 -> 866
    //   692: goto -24 -> 668
    //   695: astore_2
    //   696: getstatic 388	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   699: astore_3
    //   700: new 168	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   707: astore 4
    //   709: aload 4
    //   711: aload_2
    //   712: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload 4
    //   718: ldc_w 436
    //   721: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: aload 4
    //   727: aload 7
    //   729: invokevirtual 439	java/io/File:getPath	()Ljava/lang/String;
    //   732: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload 4
    //   738: ldc_w 441
    //   741: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload_3
    //   746: iconst_2
    //   747: anewarray 392	java/lang/String
    //   750: dup
    //   751: iconst_0
    //   752: ldc 55
    //   754: aastore
    //   755: dup
    //   756: iconst_1
    //   757: aload 4
    //   759: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: aastore
    //   763: invokevirtual 444	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   766: aload 7
    //   768: invokevirtual 157	java/io/File:isFile	()Z
    //   771: ifeq +9 -> 780
    //   774: aload 7
    //   776: invokevirtual 406	java/io/File:delete	()Z
    //   779: pop
    //   780: aload_0
    //   781: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   784: astore_2
    //   785: aload_2
    //   786: ifnull +85 -> 871
    //   789: aload_2
    //   790: sipush 601
    //   793: ldc_w 446
    //   796: aload_0
    //   797: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   800: invokevirtual 280	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   803: invokeinterface 286 4 0
    //   808: goto +63 -> 871
    //   811: aload_0
    //   812: iconst_0
    //   813: invokevirtual 212	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:setRetry	(I)V
    //   816: aload_0
    //   817: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   820: astore_2
    //   821: aload_2
    //   822: ifnull +16 -> 838
    //   825: aload_2
    //   826: sipush 600
    //   829: ldc_w 448
    //   832: iconst_0
    //   833: invokeinterface 286 4 0
    //   838: aload 6
    //   840: ifnull +26 -> 866
    //   843: goto -175 -> 668
    //   846: aload 6
    //   848: ifnull +8 -> 856
    //   851: aload 6
    //   853: invokevirtual 431	java/net/HttpURLConnection:disconnect	()V
    //   856: aload_2
    //   857: athrow
    //   858: aload 6
    //   860: ifnull +6 -> 866
    //   863: goto -195 -> 668
    //   866: return
    //   867: astore_2
    //   868: goto -57 -> 811
    //   871: aload 6
    //   873: ifnull -7 -> 866
    //   876: goto -208 -> 668
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	879	0	this	FileUploadRunnable
    //   56	7	1	i	int
    //   42	555	2	localObject1	Object
    //   607	4	2	localThrowable1	java.lang.Throwable
    //   614	25	2	localObject2	Object
    //   644	1	2	localObject3	Object
    //   648	12	2	localThrowable2	java.lang.Throwable
    //   674	7	2	localException	java.lang.Exception
    //   695	17	2	localFileNotFoundException	java.io.FileNotFoundException
    //   784	73	2	localReportResultCallback	IReporter.ReportResultCallback
    //   867	1	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   117	339	3	localObject4	Object
    //   585	1	3	localObject5	Object
    //   589	12	3	localThrowable3	java.lang.Throwable
    //   609	9	3	localThrowable4	java.lang.Throwable
    //   627	1	3	localObject6	Object
    //   631	12	3	localThrowable5	java.lang.Throwable
    //   699	47	3	localLogger	com.tencent.qapmsdk.common.logger.Logger
    //   177	581	4	localObject7	Object
    //   249	320	5	localObject8	Object
    //   602	23	5	localObject9	Object
    //   149	723	6	localHttpURLConnection	java.net.HttpURLConnection
    //   103	672	7	localFile	File
    //   171	466	8	localObject10	Object
    //   240	376	9	localObject11	Object
    //   187	125	10	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   358	365	585	finally
    //   367	383	585	finally
    //   385	390	585	finally
    //   392	401	585	finally
    //   403	412	585	finally
    //   414	422	585	finally
    //   424	446	585	finally
    //   448	453	585	finally
    //   592	594	585	finally
    //   358	365	589	java/lang/Throwable
    //   367	383	589	java/lang/Throwable
    //   385	390	589	java/lang/Throwable
    //   392	401	589	java/lang/Throwable
    //   403	412	589	java/lang/Throwable
    //   414	422	589	java/lang/Throwable
    //   424	446	589	java/lang/Throwable
    //   448	453	589	java/lang/Throwable
    //   254	260	602	finally
    //   263	286	602	finally
    //   610	612	602	finally
    //   254	260	607	java/lang/Throwable
    //   263	286	607	java/lang/Throwable
    //   182	189	627	finally
    //   192	198	627	finally
    //   201	208	627	finally
    //   211	225	627	finally
    //   228	242	627	finally
    //   245	251	627	finally
    //   289	296	627	finally
    //   299	308	627	finally
    //   311	320	627	finally
    //   323	327	627	finally
    //   615	621	627	finally
    //   624	627	627	finally
    //   634	636	627	finally
    //   182	189	631	java/lang/Throwable
    //   192	198	631	java/lang/Throwable
    //   201	208	631	java/lang/Throwable
    //   211	225	631	java/lang/Throwable
    //   228	242	631	java/lang/Throwable
    //   245	251	631	java/lang/Throwable
    //   289	296	631	java/lang/Throwable
    //   299	308	631	java/lang/Throwable
    //   311	320	631	java/lang/Throwable
    //   323	327	631	java/lang/Throwable
    //   615	621	631	java/lang/Throwable
    //   624	627	631	java/lang/Throwable
    //   156	179	644	finally
    //   327	356	644	finally
    //   453	473	644	finally
    //   477	493	644	finally
    //   493	507	644	finally
    //   510	521	644	finally
    //   524	560	644	finally
    //   564	582	644	finally
    //   594	602	644	finally
    //   636	644	644	finally
    //   649	663	644	finally
    //   675	687	644	finally
    //   696	780	644	finally
    //   780	785	644	finally
    //   789	808	644	finally
    //   811	821	644	finally
    //   825	838	644	finally
    //   156	179	648	java/lang/Throwable
    //   327	356	648	java/lang/Throwable
    //   453	473	648	java/lang/Throwable
    //   477	493	648	java/lang/Throwable
    //   493	507	648	java/lang/Throwable
    //   510	521	648	java/lang/Throwable
    //   524	560	648	java/lang/Throwable
    //   564	582	648	java/lang/Throwable
    //   594	602	648	java/lang/Throwable
    //   636	644	648	java/lang/Throwable
    //   156	179	674	java/lang/Exception
    //   327	356	674	java/lang/Exception
    //   453	473	674	java/lang/Exception
    //   477	493	674	java/lang/Exception
    //   493	507	674	java/lang/Exception
    //   510	521	674	java/lang/Exception
    //   524	560	674	java/lang/Exception
    //   564	582	674	java/lang/Exception
    //   594	602	674	java/lang/Exception
    //   636	644	674	java/lang/Exception
    //   156	179	695	java/io/FileNotFoundException
    //   327	356	695	java/io/FileNotFoundException
    //   453	473	695	java/io/FileNotFoundException
    //   477	493	695	java/io/FileNotFoundException
    //   493	507	695	java/io/FileNotFoundException
    //   510	521	695	java/io/FileNotFoundException
    //   524	560	695	java/io/FileNotFoundException
    //   564	582	695	java/io/FileNotFoundException
    //   594	602	695	java/io/FileNotFoundException
    //   636	644	695	java/io/FileNotFoundException
    //   156	179	867	java/lang/OutOfMemoryError
    //   327	356	867	java/lang/OutOfMemoryError
    //   453	473	867	java/lang/OutOfMemoryError
    //   477	493	867	java/lang/OutOfMemoryError
    //   493	507	867	java/lang/OutOfMemoryError
    //   510	521	867	java/lang/OutOfMemoryError
    //   524	560	867	java/lang/OutOfMemoryError
    //   564	582	867	java/lang/OutOfMemoryError
    //   594	602	867	java/lang/OutOfMemoryError
    //   636	644	867	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.FileUploadRunnable
 * JD-Core Version:    0.7.0.1
 */