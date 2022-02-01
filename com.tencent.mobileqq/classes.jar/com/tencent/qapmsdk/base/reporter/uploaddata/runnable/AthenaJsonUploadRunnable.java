package com.tencent.qapmsdk.base.reporter.uploaddata.runnable;

import com.tencent.qapmsdk.base.reporter.uploaddata.AthenaUpload;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/AthenaUpload;", "Ljava/lang/Runnable;", "url", "Ljava/net/URL;", "jsonObject", "Lorg/json/JSONObject;", "callback", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "(Ljava/net/URL;Lorg/json/JSONObject;Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;)V", "request", "", "run", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class AthenaJsonUploadRunnable
  extends AthenaUpload
  implements Runnable
{
  public static final AthenaJsonUploadRunnable.Companion Companion = new AthenaJsonUploadRunnable.Companion(null);
  @NotNull
  public static final String TAG = "QAPM_base_AthenaJsonUploadRunnable";
  private final IReporter.ReportResultCallback callback;
  private final JSONObject jsonObject;
  
  public AthenaJsonUploadRunnable(@NotNull URL paramURL, @NotNull JSONObject paramJSONObject, @Nullable IReporter.ReportResultCallback paramReportResultCallback)
  {
    super(paramURL);
    this.jsonObject = paramJSONObject;
    this.callback = paramReportResultCallback;
  }
  
  public void request()
  {
    run();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 76	java/util/HashMap
    //   3: dup
    //   4: invokespecial 78	java/util/HashMap:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: checkcast 80	java/util/Map
    //   12: astore_2
    //   13: aload_2
    //   14: ldc 82
    //   16: ldc 84
    //   18: invokeinterface 88 3 0
    //   23: pop
    //   24: aload_2
    //   25: ldc 90
    //   27: ldc 84
    //   29: invokeinterface 88 3 0
    //   34: pop
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 94	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull +621 -> 663
    //   45: new 96	java/io/DataOutputStream
    //   48: dup
    //   49: aload_3
    //   50: invokevirtual 102	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   53: invokespecial 105	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: checkcast 107	java/io/Closeable
    //   59: astore 4
    //   61: aconst_null
    //   62: checkcast 74	java/lang/Throwable
    //   65: astore_2
    //   66: aload_2
    //   67: astore_1
    //   68: aload 4
    //   70: checkcast 96	java/io/DataOutputStream
    //   73: astore 5
    //   75: aload_2
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   81: invokevirtual 113	org/json/JSONObject:toString	()Ljava/lang/String;
    //   84: astore 6
    //   86: aload_2
    //   87: astore_1
    //   88: aload 6
    //   90: ldc 115
    //   92: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   95: aload_2
    //   96: astore_1
    //   97: ldc 120
    //   99: invokestatic 126	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   102: astore 7
    //   104: aload_2
    //   105: astore_1
    //   106: aload 7
    //   108: ldc 128
    //   110: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   113: aload 6
    //   115: ifnull +148 -> 263
    //   118: aload_2
    //   119: astore_1
    //   120: aload 6
    //   122: aload 7
    //   124: invokevirtual 134	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   127: astore 6
    //   129: aload_2
    //   130: astore_1
    //   131: aload 6
    //   133: ldc 136
    //   135: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   138: aload_2
    //   139: astore_1
    //   140: aload 5
    //   142: aload 6
    //   144: invokevirtual 140	java/io/DataOutputStream:write	([B)V
    //   147: aload_2
    //   148: astore_1
    //   149: aload 5
    //   151: invokevirtual 143	java/io/DataOutputStream:flush	()V
    //   154: aload_2
    //   155: astore_1
    //   156: getstatic 149	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   159: astore 5
    //   161: aload 4
    //   163: aload_2
    //   164: invokestatic 155	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   167: getstatic 160	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   170: new 162	java/io/BufferedInputStream
    //   173: dup
    //   174: aload_3
    //   175: invokevirtual 166	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   178: invokespecial 169	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   181: checkcast 171	java/io/InputStream
    //   184: sipush 8192
    //   187: invokevirtual 177	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   190: astore_1
    //   191: getstatic 182	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   194: iconst_2
    //   195: anewarray 130	java/lang/String
    //   198: dup
    //   199: iconst_0
    //   200: ldc 37
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload_1
    //   206: aastore
    //   207: invokevirtual 186	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   210: aload_0
    //   211: aload_1
    //   212: invokevirtual 190	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   215: ifeq +25 -> 240
    //   218: aload_0
    //   219: getfield 65	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   222: astore_1
    //   223: aload_1
    //   224: ifnull +439 -> 663
    //   227: aload_1
    //   228: sipush 200
    //   231: iconst_0
    //   232: invokeinterface 196 3 0
    //   237: goto +426 -> 663
    //   240: aload_0
    //   241: getfield 65	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   244: astore_2
    //   245: aload_2
    //   246: ifnull +417 -> 663
    //   249: aload_2
    //   250: sipush 700
    //   253: aload_1
    //   254: iconst_0
    //   255: invokeinterface 200 4 0
    //   260: goto +403 -> 663
    //   263: aload_2
    //   264: astore_1
    //   265: new 202	kotlin/TypeCastException
    //   268: dup
    //   269: ldc 204
    //   271: invokespecial 207	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   274: athrow
    //   275: astore_2
    //   276: goto +8 -> 284
    //   279: astore_2
    //   280: aload_2
    //   281: astore_1
    //   282: aload_2
    //   283: athrow
    //   284: aload 4
    //   286: aload_1
    //   287: invokestatic 155	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   290: aload_2
    //   291: athrow
    //   292: astore_1
    //   293: goto +360 -> 653
    //   296: astore_1
    //   297: getstatic 182	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   300: astore_2
    //   301: new 209	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   308: astore 4
    //   310: aload 4
    //   312: aload_1
    //   313: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 4
    //   319: ldc 216
    //   321: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 4
    //   327: aload_0
    //   328: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   331: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 4
    //   337: ldc 221
    //   339: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload_2
    //   344: ldc 37
    //   346: aload 4
    //   348: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: aload_1
    //   352: invokevirtual 226	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   355: aload_3
    //   356: ifnull +314 -> 670
    //   359: aload_3
    //   360: invokevirtual 229	java/net/HttpURLConnection:disconnect	()V
    //   363: return
    //   364: astore_1
    //   365: getstatic 182	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   368: astore_2
    //   369: new 209	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   376: astore 4
    //   378: aload 4
    //   380: aload_1
    //   381: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 4
    //   387: ldc 216
    //   389: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 4
    //   395: aload_0
    //   396: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   399: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload 4
    //   405: ldc 221
    //   407: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_2
    //   412: ldc 37
    //   414: aload 4
    //   416: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: aload_1
    //   420: checkcast 74	java/lang/Throwable
    //   423: invokevirtual 226	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   426: aload_3
    //   427: ifnull +243 -> 670
    //   430: goto -71 -> 359
    //   433: astore_1
    //   434: aload_0
    //   435: getfield 65	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   438: astore_2
    //   439: aload_2
    //   440: ifnull +15 -> 455
    //   443: aload_2
    //   444: sipush 600
    //   447: ldc 231
    //   449: iconst_0
    //   450: invokeinterface 200 4 0
    //   455: getstatic 182	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   458: astore_2
    //   459: new 209	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   466: astore 4
    //   468: aload 4
    //   470: aload_1
    //   471: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 4
    //   477: ldc 216
    //   479: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 4
    //   485: aload_0
    //   486: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   489: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 4
    //   495: ldc 233
    //   497: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_2
    //   502: ldc 37
    //   504: aload 4
    //   506: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: aload_1
    //   510: checkcast 74	java/lang/Throwable
    //   513: invokevirtual 226	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   516: goto +130 -> 646
    //   519: astore_1
    //   520: getstatic 182	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   523: astore_2
    //   524: new 209	java/lang/StringBuilder
    //   527: dup
    //   528: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   531: astore 4
    //   533: aload 4
    //   535: aload_1
    //   536: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 4
    //   542: ldc 216
    //   544: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 4
    //   550: aload_0
    //   551: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   554: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 4
    //   560: ldc 221
    //   562: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload_2
    //   567: ldc 37
    //   569: aload 4
    //   571: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: aload_1
    //   575: checkcast 74	java/lang/Throwable
    //   578: invokevirtual 226	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   581: goto +65 -> 646
    //   584: astore_1
    //   585: getstatic 182	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   588: astore_2
    //   589: new 209	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   596: astore 4
    //   598: aload 4
    //   600: aload_1
    //   601: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload 4
    //   607: ldc 216
    //   609: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload 4
    //   615: aload_0
    //   616: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   619: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload 4
    //   625: ldc 221
    //   627: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload_2
    //   632: ldc 37
    //   634: aload 4
    //   636: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: aload_1
    //   640: checkcast 74	java/lang/Throwable
    //   643: invokevirtual 226	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   646: aload_3
    //   647: ifnull +23 -> 670
    //   650: goto -291 -> 359
    //   653: aload_3
    //   654: ifnull +7 -> 661
    //   657: aload_3
    //   658: invokevirtual 229	java/net/HttpURLConnection:disconnect	()V
    //   661: aload_1
    //   662: athrow
    //   663: aload_3
    //   664: ifnull +6 -> 670
    //   667: goto -308 -> 359
    //   670: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	this	AthenaJsonUploadRunnable
    //   7	280	1	localObject1	java.lang.Object
    //   292	1	1	localObject2	java.lang.Object
    //   296	56	1	localThrowable1	java.lang.Throwable
    //   364	56	1	localException1	java.lang.Exception
    //   433	77	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   519	56	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   584	78	1	localException2	java.lang.Exception
    //   12	252	2	localObject3	java.lang.Object
    //   275	1	2	localObject4	java.lang.Object
    //   279	12	2	localThrowable2	java.lang.Throwable
    //   300	332	2	localObject5	java.lang.Object
    //   40	624	3	localHttpURLConnection	java.net.HttpURLConnection
    //   59	576	4	localObject6	java.lang.Object
    //   73	87	5	localObject7	java.lang.Object
    //   84	59	6	localObject8	java.lang.Object
    //   102	21	7	localCharset	java.nio.charset.Charset
    // Exception table:
    //   from	to	target	type
    //   68	75	275	finally
    //   77	86	275	finally
    //   88	95	275	finally
    //   97	104	275	finally
    //   106	113	275	finally
    //   120	129	275	finally
    //   131	138	275	finally
    //   140	147	275	finally
    //   149	154	275	finally
    //   156	161	275	finally
    //   265	275	275	finally
    //   282	284	275	finally
    //   68	75	279	java/lang/Throwable
    //   77	86	279	java/lang/Throwable
    //   88	95	279	java/lang/Throwable
    //   97	104	279	java/lang/Throwable
    //   106	113	279	java/lang/Throwable
    //   120	129	279	java/lang/Throwable
    //   131	138	279	java/lang/Throwable
    //   140	147	279	java/lang/Throwable
    //   149	154	279	java/lang/Throwable
    //   156	161	279	java/lang/Throwable
    //   265	275	279	java/lang/Throwable
    //   45	66	292	finally
    //   161	223	292	finally
    //   227	237	292	finally
    //   240	245	292	finally
    //   249	260	292	finally
    //   284	292	292	finally
    //   297	355	292	finally
    //   365	426	292	finally
    //   434	439	292	finally
    //   443	455	292	finally
    //   455	516	292	finally
    //   520	581	292	finally
    //   585	646	292	finally
    //   45	66	296	java/lang/Throwable
    //   161	223	296	java/lang/Throwable
    //   227	237	296	java/lang/Throwable
    //   240	245	296	java/lang/Throwable
    //   249	260	296	java/lang/Throwable
    //   284	292	296	java/lang/Throwable
    //   45	66	364	java/lang/Exception
    //   161	223	364	java/lang/Exception
    //   227	237	364	java/lang/Exception
    //   240	245	364	java/lang/Exception
    //   249	260	364	java/lang/Exception
    //   284	292	364	java/lang/Exception
    //   45	66	433	java/lang/OutOfMemoryError
    //   161	223	433	java/lang/OutOfMemoryError
    //   227	237	433	java/lang/OutOfMemoryError
    //   240	245	433	java/lang/OutOfMemoryError
    //   249	260	433	java/lang/OutOfMemoryError
    //   284	292	433	java/lang/OutOfMemoryError
    //   434	439	519	java/lang/OutOfMemoryError
    //   443	455	519	java/lang/OutOfMemoryError
    //   455	516	519	java/lang/OutOfMemoryError
    //   434	439	584	java/lang/Exception
    //   443	455	584	java/lang/Exception
    //   455	516	584	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.AthenaJsonUploadRunnable
 * JD-Core Version:    0.7.0.1
 */