package com.tencent.rmonitor.base.reporter.upload;

import android.os.Handler;
import com.tencent.rmonitor.base.reporter.IReporter.ReportCallback;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.FileUtil.Companion;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/upload/FileUploadRunnable;", "Lcom/tencent/rmonitor/base/reporter/upload/ReporterUpload;", "Ljava/lang/Runnable;", "url", "Ljava/net/URL;", "handler", "Landroid/os/Handler;", "reportData", "Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "callback", "Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;", "originalPath", "", "(Ljava/net/URL;Landroid/os/Handler;Lcom/tencent/rmonitor/base/reporter/data/ReportData;Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;Ljava/lang/String;)V", "buffer", "Ljava/lang/StringBuffer;", "generateAfterStream", "generateBeforeStream", "disposition", "generateDisposition", "fileName", "generateReqBackup", "getRunnable", "getUploadFilePath", "request", "", "run", "upload", "connection", "Ljava/net/HttpURLConnection;", "uploadFile", "Ljava/io/File;", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class FileUploadRunnable
  extends ReporterUpload
  implements Runnable
{
  public static final FileUploadRunnable.Companion a = new FileUploadRunnable.Companion(null);
  private final StringBuffer e;
  private final String f;
  
  public FileUploadRunnable(@NotNull URL paramURL, @NotNull Handler paramHandler, @NotNull ReportData paramReportData, @Nullable IReporter.ReportCallback paramReportCallback, @NotNull String paramString)
  {
    super(paramURL, paramHandler, paramReportData, paramReportCallback);
    this.f = paramString;
    this.e = new StringBuffer(512);
  }
  
  /* Error */
  private final void a(java.net.HttpURLConnection paramHttpURLConnection, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +676 -> 677
    //   4: new 96	java/io/DataOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokevirtual 102	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   12: invokespecial 105	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: checkcast 107	java/io/Closeable
    //   18: astore 7
    //   20: aconst_null
    //   21: checkcast 94	java/lang/Throwable
    //   24: astore_3
    //   25: aload_3
    //   26: astore 4
    //   28: aload 7
    //   30: checkcast 96	java/io/DataOutputStream
    //   33: astore 8
    //   35: aload_3
    //   36: astore 4
    //   38: aload_2
    //   39: invokevirtual 113	java/io/File:getName	()Ljava/lang/String;
    //   42: astore 5
    //   44: aload_3
    //   45: astore 4
    //   47: aload 5
    //   49: ldc 115
    //   51: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   54: aload_3
    //   55: astore 4
    //   57: aload_0
    //   58: aload_0
    //   59: aload 5
    //   61: invokespecial 122	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:b	(Ljava/lang/String;)Ljava/lang/String;
    //   64: invokespecial 125	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:c	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 5
    //   69: aload_3
    //   70: astore 4
    //   72: ldc 127
    //   74: invokestatic 133	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   77: astore 6
    //   79: aload_3
    //   80: astore 4
    //   82: aload 6
    //   84: ldc 135
    //   86: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   89: aload 5
    //   91: ifnull +553 -> 644
    //   94: aload_3
    //   95: astore 4
    //   97: aload 5
    //   99: aload 6
    //   101: invokevirtual 141	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   104: astore 5
    //   106: aload_3
    //   107: astore 4
    //   109: aload 5
    //   111: ldc 143
    //   113: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   116: aload_3
    //   117: astore 4
    //   119: aload 8
    //   121: aload 5
    //   123: invokevirtual 147	java/io/DataOutputStream:write	([B)V
    //   126: aload_3
    //   127: astore 4
    //   129: new 149	java/io/FileInputStream
    //   132: dup
    //   133: aload_2
    //   134: invokespecial 152	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   137: checkcast 107	java/io/Closeable
    //   140: astore 9
    //   142: aload_3
    //   143: astore 4
    //   145: aconst_null
    //   146: checkcast 94	java/lang/Throwable
    //   149: astore 6
    //   151: aload 6
    //   153: astore 5
    //   155: aload 9
    //   157: checkcast 149	java/io/FileInputStream
    //   160: astore 4
    //   162: aload 6
    //   164: astore 5
    //   166: aload 4
    //   168: checkcast 154	java/io/InputStream
    //   171: aload 8
    //   173: checkcast 156	java/io/OutputStream
    //   176: aload 4
    //   178: invokevirtual 160	java/io/FileInputStream:available	()I
    //   181: ldc 161
    //   183: invokestatic 167	java/lang/Math:min	(II)I
    //   186: invokestatic 173	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   189: pop2
    //   190: aload_3
    //   191: astore 4
    //   193: aload 9
    //   195: aload 6
    //   197: invokestatic 179	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   200: aload_3
    //   201: astore 4
    //   203: aload_0
    //   204: invokespecial 182	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:g	()Ljava/lang/String;
    //   207: astore 5
    //   209: aload_3
    //   210: astore 4
    //   212: ldc 127
    //   214: invokestatic 133	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   217: astore 6
    //   219: aload_3
    //   220: astore 4
    //   222: aload 6
    //   224: ldc 135
    //   226: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   229: aload 5
    //   231: ifnull +374 -> 605
    //   234: aload_3
    //   235: astore 4
    //   237: aload 5
    //   239: aload 6
    //   241: invokevirtual 141	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   244: astore 5
    //   246: aload_3
    //   247: astore 4
    //   249: aload 5
    //   251: ldc 143
    //   253: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   256: aload_3
    //   257: astore 4
    //   259: aload 8
    //   261: aload 5
    //   263: invokevirtual 147	java/io/DataOutputStream:write	([B)V
    //   266: aload_3
    //   267: astore 4
    //   269: aload_0
    //   270: invokespecial 185	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:h	()Ljava/lang/String;
    //   273: astore 5
    //   275: aload_3
    //   276: astore 4
    //   278: ldc 127
    //   280: invokestatic 133	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   283: astore 6
    //   285: aload_3
    //   286: astore 4
    //   288: aload 6
    //   290: ldc 135
    //   292: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   295: aload 5
    //   297: ifnull +294 -> 591
    //   300: aload_3
    //   301: astore 4
    //   303: aload 5
    //   305: aload 6
    //   307: invokevirtual 141	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   310: astore 5
    //   312: aload_3
    //   313: astore 4
    //   315: aload 5
    //   317: ldc 143
    //   319: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   322: aload_3
    //   323: astore 4
    //   325: aload 8
    //   327: aload 5
    //   329: invokevirtual 147	java/io/DataOutputStream:write	([B)V
    //   332: aload_3
    //   333: astore 4
    //   335: getstatic 191	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   338: astore 5
    //   340: aload 7
    //   342: aload_3
    //   343: invokestatic 179	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   346: getstatic 196	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   349: astore 4
    //   351: new 198	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   358: astore 5
    //   360: aload 5
    //   362: ldc 202
    //   364: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 5
    //   370: aload_1
    //   371: invokevirtual 209	java/net/HttpURLConnection:getResponseCode	()I
    //   374: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 5
    //   380: ldc 214
    //   382: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 5
    //   388: aload_1
    //   389: invokevirtual 217	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   392: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 4
    //   398: iconst_2
    //   399: anewarray 137	java/lang/String
    //   402: dup
    //   403: iconst_0
    //   404: ldc 219
    //   406: aastore
    //   407: dup
    //   408: iconst_1
    //   409: aload 5
    //   411: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: aastore
    //   415: invokevirtual 226	com/tencent/rmonitor/common/logger/Logger:i	([Ljava/lang/String;)V
    //   418: new 228	java/io/BufferedInputStream
    //   421: dup
    //   422: aload_1
    //   423: invokevirtual 232	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   426: invokespecial 235	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   429: checkcast 107	java/io/Closeable
    //   432: astore 5
    //   434: aload_3
    //   435: astore 4
    //   437: aload 5
    //   439: checkcast 228	java/io/BufferedInputStream
    //   442: astore 6
    //   444: aload_3
    //   445: astore 4
    //   447: getstatic 240	com/tencent/rmonitor/common/util/FileUtil:a	Lcom/tencent/rmonitor/common/util/FileUtil$Companion;
    //   450: aload 6
    //   452: checkcast 154	java/io/InputStream
    //   455: sipush 8192
    //   458: invokevirtual 245	com/tencent/rmonitor/common/util/FileUtil$Companion:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   461: astore 6
    //   463: aload_3
    //   464: astore 4
    //   466: getstatic 196	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   469: astore 7
    //   471: aload_3
    //   472: astore 4
    //   474: new 198	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   481: astore 8
    //   483: aload_3
    //   484: astore 4
    //   486: aload 8
    //   488: ldc 247
    //   490: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_3
    //   495: astore 4
    //   497: aload 8
    //   499: aload 6
    //   501: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload_3
    //   506: astore 4
    //   508: aload 7
    //   510: iconst_2
    //   511: anewarray 137	java/lang/String
    //   514: dup
    //   515: iconst_0
    //   516: ldc 219
    //   518: aastore
    //   519: dup
    //   520: iconst_1
    //   521: aload 8
    //   523: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: aastore
    //   527: invokevirtual 226	com/tencent/rmonitor/common/logger/Logger:i	([Ljava/lang/String;)V
    //   530: aload_3
    //   531: astore 4
    //   533: getstatic 191	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   536: astore 7
    //   538: aload 5
    //   540: aload_3
    //   541: invokestatic 179	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   544: aload_0
    //   545: aload 6
    //   547: aload_1
    //   548: invokevirtual 209	java/net/HttpURLConnection:getResponseCode	()I
    //   551: ldc2_w 248
    //   554: new 251	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable$upload$$inlined$let$lambda$1
    //   557: dup
    //   558: aload_0
    //   559: aload_2
    //   560: aload_1
    //   561: invokespecial 254	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable$upload$$inlined$let$lambda$1:<init>	(Lcom/tencent/rmonitor/base/reporter/upload/FileUploadRunnable;Ljava/io/File;Ljava/net/HttpURLConnection;)V
    //   564: checkcast 256	kotlin/jvm/functions/Function0
    //   567: invokevirtual 259	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:a	(Ljava/lang/String;IJLkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    //   570: pop
    //   571: return
    //   572: astore_1
    //   573: goto +9 -> 582
    //   576: astore_1
    //   577: aload_1
    //   578: astore 4
    //   580: aload_1
    //   581: athrow
    //   582: aload 5
    //   584: aload 4
    //   586: invokestatic 179	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   589: aload_1
    //   590: athrow
    //   591: aload_3
    //   592: astore 4
    //   594: new 261	kotlin/TypeCastException
    //   597: dup
    //   598: ldc_w 263
    //   601: invokespecial 266	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   604: athrow
    //   605: aload_3
    //   606: astore 4
    //   608: new 261	kotlin/TypeCastException
    //   611: dup
    //   612: ldc_w 263
    //   615: invokespecial 266	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   618: athrow
    //   619: astore_1
    //   620: goto +9 -> 629
    //   623: astore_1
    //   624: aload_1
    //   625: astore 5
    //   627: aload_1
    //   628: athrow
    //   629: aload_3
    //   630: astore 4
    //   632: aload 9
    //   634: aload 5
    //   636: invokestatic 179	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   639: aload_3
    //   640: astore 4
    //   642: aload_1
    //   643: athrow
    //   644: aload_3
    //   645: astore 4
    //   647: new 261	kotlin/TypeCastException
    //   650: dup
    //   651: ldc_w 263
    //   654: invokespecial 266	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   657: athrow
    //   658: astore_1
    //   659: goto +9 -> 668
    //   662: astore_1
    //   663: aload_1
    //   664: astore 4
    //   666: aload_1
    //   667: athrow
    //   668: aload 7
    //   670: aload 4
    //   672: invokestatic 179	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   675: aload_1
    //   676: athrow
    //   677: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	678	0	this	FileUploadRunnable
    //   0	678	1	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	678	2	paramFile	File
    //   24	621	3	localThrowable	java.lang.Throwable
    //   26	645	4	localObject1	Object
    //   42	593	5	localObject2	Object
    //   77	469	6	localObject3	Object
    //   18	651	7	localObject4	Object
    //   33	489	8	localObject5	Object
    //   140	493	9	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   437	444	572	finally
    //   447	463	572	finally
    //   466	471	572	finally
    //   474	483	572	finally
    //   486	494	572	finally
    //   497	505	572	finally
    //   508	530	572	finally
    //   533	538	572	finally
    //   580	582	572	finally
    //   437	444	576	java/lang/Throwable
    //   447	463	576	java/lang/Throwable
    //   466	471	576	java/lang/Throwable
    //   474	483	576	java/lang/Throwable
    //   486	494	576	java/lang/Throwable
    //   497	505	576	java/lang/Throwable
    //   508	530	576	java/lang/Throwable
    //   533	538	576	java/lang/Throwable
    //   155	162	619	finally
    //   166	190	619	finally
    //   627	629	619	finally
    //   155	162	623	java/lang/Throwable
    //   166	190	623	java/lang/Throwable
    //   28	35	658	finally
    //   38	44	658	finally
    //   47	54	658	finally
    //   57	69	658	finally
    //   72	79	658	finally
    //   82	89	658	finally
    //   97	106	658	finally
    //   109	116	658	finally
    //   119	126	658	finally
    //   129	142	658	finally
    //   145	151	658	finally
    //   193	200	658	finally
    //   203	209	658	finally
    //   212	219	658	finally
    //   222	229	658	finally
    //   237	246	658	finally
    //   249	256	658	finally
    //   259	266	658	finally
    //   269	275	658	finally
    //   278	285	658	finally
    //   288	295	658	finally
    //   303	312	658	finally
    //   315	322	658	finally
    //   325	332	658	finally
    //   335	340	658	finally
    //   594	605	658	finally
    //   608	619	658	finally
    //   632	639	658	finally
    //   642	644	658	finally
    //   647	658	658	finally
    //   666	668	658	finally
    //   28	35	662	java/lang/Throwable
    //   38	44	662	java/lang/Throwable
    //   47	54	662	java/lang/Throwable
    //   57	69	662	java/lang/Throwable
    //   72	79	662	java/lang/Throwable
    //   82	89	662	java/lang/Throwable
    //   97	106	662	java/lang/Throwable
    //   109	116	662	java/lang/Throwable
    //   119	126	662	java/lang/Throwable
    //   129	142	662	java/lang/Throwable
    //   145	151	662	java/lang/Throwable
    //   193	200	662	java/lang/Throwable
    //   203	209	662	java/lang/Throwable
    //   212	219	662	java/lang/Throwable
    //   222	229	662	java/lang/Throwable
    //   237	246	662	java/lang/Throwable
    //   249	256	662	java/lang/Throwable
    //   259	266	662	java/lang/Throwable
    //   269	275	662	java/lang/Throwable
    //   278	285	662	java/lang/Throwable
    //   288	295	662	java/lang/Throwable
    //   303	312	662	java/lang/Throwable
    //   315	322	662	java/lang/Throwable
    //   325	332	662	java/lang/Throwable
    //   335	340	662	java/lang/Throwable
    //   594	605	662	java/lang/Throwable
    //   608	619	662	java/lang/Throwable
    //   632	639	662	java/lang/Throwable
    //   642	644	662	java/lang/Throwable
    //   647	658	662	java/lang/Throwable
  }
  
  private final String b(String paramString)
  {
    StringBuffer localStringBuffer = this.e;
    localStringBuffer.delete(0, localStringBuffer.length());
    localStringBuffer = this.e;
    localStringBuffer.append("Content-Disposition: form-data; name=\"uploadedfile\"; filename=\"");
    localStringBuffer.append(paramString);
    localStringBuffer.append("\"");
    paramString = this.e.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "buffer.toString()");
    return paramString;
  }
  
  private final String c(String paramString)
  {
    StringBuffer localStringBuffer = this.e;
    localStringBuffer.delete(0, localStringBuffer.length());
    localStringBuffer = this.e;
    localStringBuffer.append("--");
    localStringBuffer.append("27182818284590452353602874713526");
    localStringBuffer.append("\r\n");
    localStringBuffer.append(paramString);
    localStringBuffer.append("\r\n\r\n");
    paramString = this.e.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "buffer.toString()");
    return paramString;
  }
  
  private final String f()
  {
    int i;
    if (((CharSequence)this.f).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    String str1 = "";
    if (i != 0) {
      return "";
    }
    Object localObject2 = new File(this.f);
    if ((((File)localObject2).isFile()) && (((File)localObject2).canRead())) {
      return this.f;
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
        FileUtil.Companion localCompanion = FileUtil.a;
        String str2 = this.f;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "zipFilePath");
        localObject1 = str1;
        if (FileUtil.Companion.a(localCompanion, str2, (String)localObject2, false, 4, null)) {
          localObject1 = localObject2;
        }
      }
    }
    return localObject1;
  }
  
  private final String g()
  {
    Object localObject = this.e;
    ((StringBuffer)localObject).delete(0, ((StringBuffer)localObject).length());
    localObject = this.e;
    ((StringBuffer)localObject).append("\r\n--");
    ((StringBuffer)localObject).append("27182818284590452353602874713526");
    ((StringBuffer)localObject).append("\r\n");
    localObject = this.e.toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "buffer.toString()");
    return localObject;
  }
  
  private final String h()
  {
    Object localObject = this.e;
    ((StringBuffer)localObject).delete(0, ((StringBuffer)localObject).length());
    localObject = this.e;
    ((StringBuffer)localObject).append("Content-Disposition: form-data; name=\"_json\"\r\n\r\n");
    ((StringBuffer)localObject).append(c().getParams().toString());
    ((StringBuffer)localObject).append("\r\n--");
    ((StringBuffer)localObject).append("27182818284590452353602874713526");
    ((StringBuffer)localObject).append("--\r\n");
    localObject = this.e.toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "buffer.toString()");
    return localObject;
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
    //   1: invokevirtual 361	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:b	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 366	android/os/SystemClock:elapsedRealtime	()J
    //   11: lstore_3
    //   12: aload_0
    //   13: invokespecial 368	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:f	()Ljava/lang/String;
    //   16: astore 9
    //   18: aload 9
    //   20: checkcast 293	java/lang/CharSequence
    //   23: invokeinterface 294 1 0
    //   28: istore_1
    //   29: iconst_0
    //   30: istore 8
    //   32: iconst_0
    //   33: istore 7
    //   35: iload_1
    //   36: ifne +8 -> 44
    //   39: iconst_1
    //   40: istore_1
    //   41: goto +5 -> 46
    //   44: iconst_0
    //   45: istore_1
    //   46: iload_1
    //   47: ifeq +35 -> 82
    //   50: aload_0
    //   51: invokevirtual 372	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:d	()Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;
    //   54: astore 9
    //   56: aload 9
    //   58: ifnull +23 -> 81
    //   61: aload 9
    //   63: sipush 601
    //   66: ldc_w 374
    //   69: aload_0
    //   70: invokevirtual 340	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:c	()Lcom/tencent/rmonitor/base/reporter/data/ReportData;
    //   73: invokevirtual 377	com/tencent/rmonitor/base/reporter/data/ReportData:getDbId	()I
    //   76: invokeinterface 382 4 0
    //   81: return
    //   82: new 109	java/io/File
    //   85: dup
    //   86: aload 9
    //   88: invokespecial 296	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore 10
    //   93: new 384	java/util/HashMap
    //   96: dup
    //   97: invokespecial 385	java/util/HashMap:<init>	()V
    //   100: astore 9
    //   102: aload 9
    //   104: checkcast 387	java/util/Map
    //   107: astore 11
    //   109: aload 11
    //   111: ldc_w 389
    //   114: ldc_w 391
    //   117: invokeinterface 395 3 0
    //   122: pop
    //   123: aload 11
    //   125: ldc_w 397
    //   128: getstatic 402	com/tencent/rmonitor/base/meta/BaseInfo:token	Ljava/lang/String;
    //   131: invokeinterface 395 3 0
    //   136: pop
    //   137: getstatic 196	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   140: astore 11
    //   142: new 198	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   149: astore 12
    //   151: aload 12
    //   153: ldc_w 404
    //   156: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 12
    //   162: aload_0
    //   163: invokevirtual 407	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:e	()Ljava/net/URL;
    //   166: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 12
    //   172: ldc_w 412
    //   175: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 12
    //   181: aload_0
    //   182: invokevirtual 340	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:c	()Lcom/tencent/rmonitor/base/reporter/data/ReportData;
    //   185: invokevirtual 346	com/tencent/rmonitor/base/reporter/data/ReportData:getParams	()Lorg/json/JSONObject;
    //   188: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 11
    //   194: iconst_2
    //   195: anewarray 137	java/lang/String
    //   198: dup
    //   199: iconst_0
    //   200: ldc 219
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload 12
    //   207: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: aastore
    //   211: invokevirtual 226	com/tencent/rmonitor/common/logger/Logger:i	([Ljava/lang/String;)V
    //   214: aload_0
    //   215: aload 9
    //   217: invokevirtual 415	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:a	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   220: astore 9
    //   222: aload_0
    //   223: aload 9
    //   225: aload 10
    //   227: invokespecial 417	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:a	(Ljava/net/HttpURLConnection;Ljava/io/File;)V
    //   230: aload 9
    //   232: ifnull +31 -> 263
    //   235: aload 9
    //   237: invokevirtual 209	java/net/HttpURLConnection:getResponseCode	()I
    //   240: sipush 200
    //   243: if_icmpne +11 -> 254
    //   246: iconst_0
    //   247: istore_1
    //   248: iconst_1
    //   249: istore 7
    //   251: goto +14 -> 265
    //   254: aload 9
    //   256: invokevirtual 209	java/net/HttpURLConnection:getResponseCode	()I
    //   259: istore_1
    //   260: goto +5 -> 265
    //   263: iconst_0
    //   264: istore_1
    //   265: iload_1
    //   266: istore_2
    //   267: iload 7
    //   269: istore 8
    //   271: aload 9
    //   273: ifnull +238 -> 511
    //   276: aload 9
    //   278: invokevirtual 420	java/net/HttpURLConnection:disconnect	()V
    //   281: iload_1
    //   282: istore_2
    //   283: iload 7
    //   285: istore 8
    //   287: goto +224 -> 511
    //   290: astore 10
    //   292: goto +238 -> 530
    //   295: astore 10
    //   297: aload_0
    //   298: iconst_0
    //   299: invokevirtual 422	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:a	(I)V
    //   302: getstatic 196	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   305: ldc 219
    //   307: aload 10
    //   309: invokevirtual 425	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   312: aload 9
    //   314: ifnull +195 -> 509
    //   317: aload 9
    //   319: invokevirtual 420	java/net/HttpURLConnection:disconnect	()V
    //   322: goto +187 -> 509
    //   325: astore 10
    //   327: getstatic 196	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   330: ldc 219
    //   332: aload 10
    //   334: checkcast 94	java/lang/Throwable
    //   337: invokevirtual 425	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload 9
    //   342: ifnull +167 -> 509
    //   345: goto -28 -> 317
    //   348: astore 11
    //   350: getstatic 196	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   353: astore 12
    //   355: new 198	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   362: astore 13
    //   364: aload 13
    //   366: aload 11
    //   368: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 13
    //   374: ldc_w 427
    //   377: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 13
    //   383: aload 10
    //   385: invokevirtual 430	java/io/File:getPath	()Ljava/lang/String;
    //   388: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 13
    //   394: ldc_w 432
    //   397: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 12
    //   403: iconst_2
    //   404: anewarray 137	java/lang/String
    //   407: dup
    //   408: iconst_0
    //   409: ldc 219
    //   411: aastore
    //   412: dup
    //   413: iconst_1
    //   414: aload 13
    //   416: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: aastore
    //   420: invokevirtual 434	com/tencent/rmonitor/common/logger/Logger:e	([Ljava/lang/String;)V
    //   423: aload 10
    //   425: invokevirtual 300	java/io/File:isFile	()Z
    //   428: ifeq +9 -> 437
    //   431: aload 10
    //   433: invokevirtual 436	java/io/File:delete	()Z
    //   436: pop
    //   437: aload_0
    //   438: invokevirtual 372	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:d	()Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;
    //   441: astore 10
    //   443: aload 10
    //   445: ifnull +109 -> 554
    //   448: aload 10
    //   450: sipush 601
    //   453: ldc_w 438
    //   456: aload_0
    //   457: invokevirtual 340	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:c	()Lcom/tencent/rmonitor/base/reporter/data/ReportData;
    //   460: invokevirtual 377	com/tencent/rmonitor/base/reporter/data/ReportData:getDbId	()I
    //   463: invokeinterface 382 4 0
    //   468: goto +86 -> 554
    //   471: aload_0
    //   472: iconst_0
    //   473: invokevirtual 422	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:a	(I)V
    //   476: aload_0
    //   477: invokevirtual 372	com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable:d	()Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;
    //   480: astore 10
    //   482: aload 10
    //   484: ifnull +17 -> 501
    //   487: aload 10
    //   489: sipush 600
    //   492: ldc_w 440
    //   495: iconst_0
    //   496: invokeinterface 382 4 0
    //   501: aload 9
    //   503: ifnull +6 -> 509
    //   506: goto -189 -> 317
    //   509: iconst_0
    //   510: istore_2
    //   511: invokestatic 366	android/os/SystemClock:elapsedRealtime	()J
    //   514: lstore 5
    //   516: invokestatic 445	com/tencent/rmonitor/base/reporter/DataReportSla:a	()Lcom/tencent/rmonitor/base/reporter/DataReportSla;
    //   519: iload 8
    //   521: iload_2
    //   522: lload 5
    //   524: lload_3
    //   525: lsub
    //   526: invokevirtual 448	com/tencent/rmonitor/base/reporter/DataReportSla:a	(ZIJ)V
    //   529: return
    //   530: aload 9
    //   532: ifnull +8 -> 540
    //   535: aload 9
    //   537: invokevirtual 420	java/net/HttpURLConnection:disconnect	()V
    //   540: goto +6 -> 546
    //   543: aload 10
    //   545: athrow
    //   546: goto -3 -> 543
    //   549: astore 10
    //   551: goto -80 -> 471
    //   554: aload 9
    //   556: ifnull -47 -> 509
    //   559: goto -242 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	562	0	this	FileUploadRunnable
    //   28	254	1	i	int
    //   266	256	2	j	int
    //   11	514	3	l1	long
    //   514	9	5	l2	long
    //   33	251	7	bool1	boolean
    //   30	490	8	bool2	boolean
    //   16	539	9	localObject1	Object
    //   91	135	10	localFile	File
    //   290	1	10	localObject2	Object
    //   295	13	10	localThrowable	java.lang.Throwable
    //   325	107	10	localException	java.lang.Exception
    //   441	103	10	localReportCallback	IReporter.ReportCallback
    //   549	1	10	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   107	86	11	localObject3	Object
    //   348	19	11	localFileNotFoundException	java.io.FileNotFoundException
    //   149	253	12	localObject4	Object
    //   362	53	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   222	230	290	finally
    //   235	246	290	finally
    //   254	260	290	finally
    //   297	312	290	finally
    //   327	340	290	finally
    //   350	437	290	finally
    //   437	443	290	finally
    //   448	468	290	finally
    //   471	482	290	finally
    //   487	501	290	finally
    //   222	230	295	java/lang/Throwable
    //   235	246	295	java/lang/Throwable
    //   254	260	295	java/lang/Throwable
    //   222	230	325	java/lang/Exception
    //   235	246	325	java/lang/Exception
    //   254	260	325	java/lang/Exception
    //   222	230	348	java/io/FileNotFoundException
    //   235	246	348	java/io/FileNotFoundException
    //   254	260	348	java/io/FileNotFoundException
    //   222	230	549	java/lang/OutOfMemoryError
    //   235	246	549	java/lang/OutOfMemoryError
    //   254	260	549	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.upload.FileUploadRunnable
 * JD-Core Version:    0.7.0.1
 */