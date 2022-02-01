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
    //   0: getstatic 236	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   3: checkcast 146	java/lang/CharSequence
    //   6: invokestatic 242	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +23 -> 32
    //   12: getstatic 248	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:INSTANCE	Lcom/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy;
    //   15: invokevirtual 252	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:getAuthorization	()Lcom/tencent/qapmsdk/base/reporter/authorization/Authorization;
    //   18: getstatic 256	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   21: getfield 261	com/tencent/qapmsdk/base/meta/UserMeta:appKey	Ljava/lang/String;
    //   24: iconst_1
    //   25: invokevirtual 267	com/tencent/qapmsdk/base/reporter/authorization/Authorization:getToken	(Ljava/lang/String;Z)Z
    //   28: ifne +4 -> 32
    //   31: return
    //   32: aload_0
    //   33: invokespecial 269	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:getUploadFilePath	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: checkcast 146	java/lang/CharSequence
    //   41: invokeinterface 147 1 0
    //   46: ifne +38 -> 84
    //   49: iconst_1
    //   50: istore_1
    //   51: iload_1
    //   52: ifeq +37 -> 89
    //   55: aload_0
    //   56: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull -30 -> 31
    //   64: aload_2
    //   65: sipush 601
    //   68: ldc_w 271
    //   71: aload_0
    //   72: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   75: invokevirtual 274	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   78: invokeinterface 280 4 0
    //   83: return
    //   84: iconst_0
    //   85: istore_1
    //   86: goto -35 -> 51
    //   89: new 150	java/io/File
    //   92: dup
    //   93: aload_2
    //   94: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore 7
    //   99: new 282	java/util/HashMap
    //   102: dup
    //   103: invokespecial 283	java/util/HashMap:<init>	()V
    //   106: astore_2
    //   107: aload_2
    //   108: checkcast 285	java/util/Map
    //   111: ldc_w 287
    //   114: ldc_w 289
    //   117: invokeinterface 293 3 0
    //   122: pop
    //   123: aload_2
    //   124: checkcast 285	java/util/Map
    //   127: ldc_w 295
    //   130: getstatic 236	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   133: invokeinterface 293 3 0
    //   138: pop
    //   139: aload_0
    //   140: aload_2
    //   141: invokevirtual 299	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   144: astore 6
    //   146: aload 6
    //   148: ifnull +345 -> 493
    //   151: new 301	java/io/DataOutputStream
    //   154: dup
    //   155: aload 6
    //   157: invokevirtual 307	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   160: invokespecial 310	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   163: checkcast 312	java/io/Closeable
    //   166: astore 8
    //   168: aconst_null
    //   169: checkcast 231	java/lang/Throwable
    //   172: astore 5
    //   174: aload 5
    //   176: astore_2
    //   177: aload 8
    //   179: checkcast 301	java/io/DataOutputStream
    //   182: astore_3
    //   183: aload 5
    //   185: astore_2
    //   186: aload 7
    //   188: invokevirtual 315	java/io/File:getName	()Ljava/lang/String;
    //   191: astore 4
    //   193: aload 5
    //   195: astore_2
    //   196: aload 4
    //   198: ldc_w 317
    //   201: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   204: aload 5
    //   206: astore_2
    //   207: aload_3
    //   208: aload_0
    //   209: aload_0
    //   210: aload 4
    //   212: invokespecial 319	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateDisposition	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokespecial 321	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateBeforeStream	(Ljava/lang/String;)Ljava/lang/String;
    //   218: invokevirtual 324	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   221: aload 5
    //   223: astore_2
    //   224: new 326	java/io/FileInputStream
    //   227: dup
    //   228: aload 7
    //   230: invokespecial 329	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   233: checkcast 312	java/io/Closeable
    //   236: astore 9
    //   238: aload 5
    //   240: astore_2
    //   241: aconst_null
    //   242: checkcast 231	java/lang/Throwable
    //   245: astore 4
    //   247: aload 9
    //   249: checkcast 326	java/io/FileInputStream
    //   252: astore_2
    //   253: aload_2
    //   254: checkcast 331	java/io/InputStream
    //   257: aload_3
    //   258: checkcast 333	java/io/OutputStream
    //   261: aload_2
    //   262: invokevirtual 336	java/io/FileInputStream:available	()I
    //   265: ldc_w 337
    //   268: invokestatic 343	java/lang/Math:min	(II)I
    //   271: invokestatic 349	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   274: pop2
    //   275: aload 5
    //   277: astore_2
    //   278: aload 9
    //   280: aload 4
    //   282: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   285: aload 5
    //   287: astore_2
    //   288: aload_3
    //   289: aload_0
    //   290: invokespecial 357	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateAfterStream	()Ljava/lang/String;
    //   293: invokevirtual 324	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   296: aload 5
    //   298: astore_2
    //   299: aload_3
    //   300: aload_0
    //   301: invokespecial 359	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateReqBackup	()Ljava/lang/String;
    //   304: invokevirtual 324	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   307: aload 5
    //   309: astore_2
    //   310: getstatic 364	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   313: astore_3
    //   314: aload 8
    //   316: aload 5
    //   318: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   321: new 366	java/io/BufferedInputStream
    //   324: dup
    //   325: aload 6
    //   327: invokevirtual 370	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   330: invokespecial 373	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   333: checkcast 312	java/io/Closeable
    //   336: astore 4
    //   338: aconst_null
    //   339: checkcast 231	java/lang/Throwable
    //   342: astore_3
    //   343: aload_3
    //   344: astore_2
    //   345: aload 4
    //   347: checkcast 366	java/io/BufferedInputStream
    //   350: astore 5
    //   352: aload_3
    //   353: astore_2
    //   354: getstatic 198	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   357: aload 5
    //   359: checkcast 331	java/io/InputStream
    //   362: sipush 8192
    //   365: invokevirtual 377	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   368: astore 5
    //   370: aload_3
    //   371: astore_2
    //   372: getstatic 382	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   375: iconst_2
    //   376: anewarray 384	java/lang/String
    //   379: dup
    //   380: iconst_0
    //   381: ldc 55
    //   383: aastore
    //   384: dup
    //   385: iconst_1
    //   386: aload 5
    //   388: aastore
    //   389: invokevirtual 388	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   392: aload_3
    //   393: astore_2
    //   394: getstatic 364	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   397: astore 8
    //   399: aload 4
    //   401: aload_3
    //   402: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   405: getstatic 382	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   408: iconst_2
    //   409: anewarray 384	java/lang/String
    //   412: dup
    //   413: iconst_0
    //   414: ldc_w 390
    //   417: aastore
    //   418: dup
    //   419: iconst_1
    //   420: new 168	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 392
    //   430: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload 5
    //   435: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: aastore
    //   442: invokevirtual 388	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   445: aload_0
    //   446: aload 5
    //   448: invokevirtual 396	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   451: ifeq +250 -> 701
    //   454: aload_0
    //   455: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   458: astore_2
    //   459: aload_2
    //   460: ifnull +19 -> 479
    //   463: aload_2
    //   464: sipush 200
    //   467: aload_0
    //   468: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   471: invokevirtual 274	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   474: invokeinterface 400 3 0
    //   479: aload 7
    //   481: invokevirtual 157	java/io/File:isFile	()Z
    //   484: ifeq +214 -> 698
    //   487: aload 7
    //   489: invokevirtual 402	java/io/File:delete	()Z
    //   492: pop
    //   493: aload 6
    //   495: ifnull -464 -> 31
    //   498: aload 6
    //   500: invokevirtual 405	java/net/HttpURLConnection:disconnect	()V
    //   503: return
    //   504: astore 4
    //   506: aload 4
    //   508: athrow
    //   509: astore_3
    //   510: aload 5
    //   512: astore_2
    //   513: aload 9
    //   515: aload 4
    //   517: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   520: aload 5
    //   522: astore_2
    //   523: aload_3
    //   524: athrow
    //   525: astore_3
    //   526: aload_3
    //   527: astore_2
    //   528: aload_3
    //   529: athrow
    //   530: astore_3
    //   531: aload 8
    //   533: aload_2
    //   534: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   537: aload_3
    //   538: athrow
    //   539: astore_2
    //   540: aload_0
    //   541: iconst_0
    //   542: invokevirtual 212	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:setRetry	(I)V
    //   545: aload_0
    //   546: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   549: astore_2
    //   550: aload_2
    //   551: ifnull +16 -> 567
    //   554: aload_2
    //   555: sipush 600
    //   558: ldc_w 407
    //   561: iconst_0
    //   562: invokeinterface 280 4 0
    //   567: aload 6
    //   569: ifnull -538 -> 31
    //   572: aload 6
    //   574: invokevirtual 405	java/net/HttpURLConnection:disconnect	()V
    //   577: return
    //   578: astore_3
    //   579: aload_3
    //   580: astore_2
    //   581: aload_3
    //   582: athrow
    //   583: astore_3
    //   584: aload 4
    //   586: aload_2
    //   587: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   590: aload_3
    //   591: athrow
    //   592: astore_2
    //   593: getstatic 382	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   596: iconst_2
    //   597: anewarray 384	java/lang/String
    //   600: dup
    //   601: iconst_0
    //   602: ldc 55
    //   604: aastore
    //   605: dup
    //   606: iconst_1
    //   607: new 168	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   614: aload_2
    //   615: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   618: ldc_w 412
    //   621: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload 7
    //   626: invokevirtual 415	java/io/File:getPath	()Ljava/lang/String;
    //   629: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: ldc_w 417
    //   635: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: aastore
    //   642: invokevirtual 420	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   645: aload 7
    //   647: invokevirtual 157	java/io/File:isFile	()Z
    //   650: ifeq +9 -> 659
    //   653: aload 7
    //   655: invokevirtual 402	java/io/File:delete	()Z
    //   658: pop
    //   659: aload_0
    //   660: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   663: astore_2
    //   664: aload_2
    //   665: ifnull +22 -> 687
    //   668: aload_2
    //   669: sipush 601
    //   672: ldc_w 422
    //   675: aload_0
    //   676: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   679: invokevirtual 274	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   682: invokeinterface 280 4 0
    //   687: aload 6
    //   689: ifnull -658 -> 31
    //   692: aload 6
    //   694: invokevirtual 405	java/net/HttpURLConnection:disconnect	()V
    //   697: return
    //   698: goto -205 -> 493
    //   701: aload_0
    //   702: invokevirtual 209	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:getRetry	()I
    //   705: ifle +34 -> 739
    //   708: aload_0
    //   709: invokespecial 424	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:reSend	()V
    //   712: goto -219 -> 493
    //   715: astore_2
    //   716: getstatic 382	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   719: ldc 55
    //   721: aload_2
    //   722: checkcast 231	java/lang/Throwable
    //   725: invokevirtual 428	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   728: aload 6
    //   730: ifnull -699 -> 31
    //   733: aload 6
    //   735: invokevirtual 405	java/net/HttpURLConnection:disconnect	()V
    //   738: return
    //   739: aload_0
    //   740: aload_0
    //   741: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   744: invokevirtual 139	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   747: ldc_w 430
    //   750: invokevirtual 434	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   753: aload 6
    //   755: invokevirtual 437	java/net/HttpURLConnection:getResponseCode	()I
    //   758: aload 5
    //   760: aload_0
    //   761: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   764: invokevirtual 440	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getEventName	()Ljava/lang/String;
    //   767: invokevirtual 444	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:addLost	(IILjava/lang/String;Ljava/lang/String;)V
    //   770: aload_0
    //   771: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   774: astore_2
    //   775: aload_2
    //   776: ifnull -283 -> 493
    //   779: aload_2
    //   780: sipush 700
    //   783: aload 5
    //   785: aload_0
    //   786: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   789: invokevirtual 274	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   792: invokeinterface 280 4 0
    //   797: goto -304 -> 493
    //   800: astore_2
    //   801: aload_0
    //   802: iconst_0
    //   803: invokevirtual 212	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:setRetry	(I)V
    //   806: getstatic 382	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   809: ldc 55
    //   811: aload_2
    //   812: invokevirtual 428	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   815: aload 6
    //   817: ifnull -786 -> 31
    //   820: aload 6
    //   822: invokevirtual 405	java/net/HttpURLConnection:disconnect	()V
    //   825: return
    //   826: astore_2
    //   827: aload 6
    //   829: ifnull +8 -> 837
    //   832: aload 6
    //   834: invokevirtual 405	java/net/HttpURLConnection:disconnect	()V
    //   837: aload_2
    //   838: athrow
    //   839: astore_3
    //   840: goto -330 -> 510
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	843	0	this	FileUploadRunnable
    //   50	36	1	i	int
    //   36	498	2	localObject1	Object
    //   539	1	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   549	38	2	localObject2	Object
    //   592	23	2	localFileNotFoundException	java.io.FileNotFoundException
    //   663	6	2	localReportResultCallback1	IReporter.ReportResultCallback
    //   715	7	2	localException	java.lang.Exception
    //   774	6	2	localReportResultCallback2	IReporter.ReportResultCallback
    //   800	12	2	localThrowable1	java.lang.Throwable
    //   826	12	2	localObject3	Object
    //   182	220	3	localObject4	Object
    //   509	15	3	localObject5	Object
    //   525	4	3	localThrowable2	java.lang.Throwable
    //   530	8	3	localObject6	Object
    //   578	4	3	localThrowable3	java.lang.Throwable
    //   583	8	3	localObject7	Object
    //   839	1	3	localObject8	Object
    //   191	209	4	localObject9	Object
    //   504	81	4	localThrowable4	java.lang.Throwable
    //   172	612	5	localObject10	Object
    //   144	689	6	localHttpURLConnection	java.net.HttpURLConnection
    //   97	557	7	localFile	File
    //   166	366	8	localObject11	Object
    //   236	278	9	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   247	275	504	java/lang/Throwable
    //   506	509	509	finally
    //   177	183	525	java/lang/Throwable
    //   186	193	525	java/lang/Throwable
    //   196	204	525	java/lang/Throwable
    //   207	221	525	java/lang/Throwable
    //   224	238	525	java/lang/Throwable
    //   241	247	525	java/lang/Throwable
    //   278	285	525	java/lang/Throwable
    //   288	296	525	java/lang/Throwable
    //   299	307	525	java/lang/Throwable
    //   310	314	525	java/lang/Throwable
    //   513	520	525	java/lang/Throwable
    //   523	525	525	java/lang/Throwable
    //   177	183	530	finally
    //   186	193	530	finally
    //   196	204	530	finally
    //   207	221	530	finally
    //   224	238	530	finally
    //   241	247	530	finally
    //   278	285	530	finally
    //   288	296	530	finally
    //   299	307	530	finally
    //   310	314	530	finally
    //   513	520	530	finally
    //   523	525	530	finally
    //   528	530	530	finally
    //   151	174	539	java/lang/OutOfMemoryError
    //   314	343	539	java/lang/OutOfMemoryError
    //   399	459	539	java/lang/OutOfMemoryError
    //   463	479	539	java/lang/OutOfMemoryError
    //   479	493	539	java/lang/OutOfMemoryError
    //   531	539	539	java/lang/OutOfMemoryError
    //   584	592	539	java/lang/OutOfMemoryError
    //   701	712	539	java/lang/OutOfMemoryError
    //   739	775	539	java/lang/OutOfMemoryError
    //   779	797	539	java/lang/OutOfMemoryError
    //   345	352	578	java/lang/Throwable
    //   354	370	578	java/lang/Throwable
    //   372	392	578	java/lang/Throwable
    //   394	399	578	java/lang/Throwable
    //   345	352	583	finally
    //   354	370	583	finally
    //   372	392	583	finally
    //   394	399	583	finally
    //   581	583	583	finally
    //   151	174	592	java/io/FileNotFoundException
    //   314	343	592	java/io/FileNotFoundException
    //   399	459	592	java/io/FileNotFoundException
    //   463	479	592	java/io/FileNotFoundException
    //   479	493	592	java/io/FileNotFoundException
    //   531	539	592	java/io/FileNotFoundException
    //   584	592	592	java/io/FileNotFoundException
    //   701	712	592	java/io/FileNotFoundException
    //   739	775	592	java/io/FileNotFoundException
    //   779	797	592	java/io/FileNotFoundException
    //   151	174	715	java/lang/Exception
    //   314	343	715	java/lang/Exception
    //   399	459	715	java/lang/Exception
    //   463	479	715	java/lang/Exception
    //   479	493	715	java/lang/Exception
    //   531	539	715	java/lang/Exception
    //   584	592	715	java/lang/Exception
    //   701	712	715	java/lang/Exception
    //   739	775	715	java/lang/Exception
    //   779	797	715	java/lang/Exception
    //   151	174	800	java/lang/Throwable
    //   314	343	800	java/lang/Throwable
    //   399	459	800	java/lang/Throwable
    //   463	479	800	java/lang/Throwable
    //   479	493	800	java/lang/Throwable
    //   531	539	800	java/lang/Throwable
    //   584	592	800	java/lang/Throwable
    //   701	712	800	java/lang/Throwable
    //   739	775	800	java/lang/Throwable
    //   779	797	800	java/lang/Throwable
    //   151	174	826	finally
    //   314	343	826	finally
    //   399	459	826	finally
    //   463	479	826	finally
    //   479	493	826	finally
    //   531	539	826	finally
    //   540	550	826	finally
    //   554	567	826	finally
    //   584	592	826	finally
    //   593	659	826	finally
    //   659	664	826	finally
    //   668	687	826	finally
    //   701	712	826	finally
    //   716	728	826	finally
    //   739	775	826	finally
    //   779	797	826	finally
    //   801	815	826	finally
    //   247	275	839	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.FileUploadRunnable
 * JD-Core Version:    0.7.0.1
 */