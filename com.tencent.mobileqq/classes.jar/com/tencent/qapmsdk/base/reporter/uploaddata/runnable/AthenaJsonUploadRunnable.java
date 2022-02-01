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
    //   12: ldc 82
    //   14: ldc 84
    //   16: invokeinterface 88 3 0
    //   21: pop
    //   22: aload_1
    //   23: checkcast 80	java/util/Map
    //   26: ldc 90
    //   28: ldc 84
    //   30: invokeinterface 88 3 0
    //   35: pop
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 94	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +295 -> 338
    //   46: new 96	java/io/DataOutputStream
    //   49: dup
    //   50: aload_3
    //   51: invokevirtual 102	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   54: invokespecial 105	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: checkcast 107	java/io/Closeable
    //   60: astore 4
    //   62: aconst_null
    //   63: checkcast 74	java/lang/Throwable
    //   66: astore_2
    //   67: aload_2
    //   68: astore_1
    //   69: aload 4
    //   71: checkcast 96	java/io/DataOutputStream
    //   74: astore 5
    //   76: aload_2
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   82: invokevirtual 113	org/json/JSONObject:toString	()Ljava/lang/String;
    //   85: astore 6
    //   87: aload_2
    //   88: astore_1
    //   89: aload 6
    //   91: ldc 115
    //   93: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   96: aload_2
    //   97: astore_1
    //   98: ldc 120
    //   100: invokestatic 126	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   103: astore 7
    //   105: aload_2
    //   106: astore_1
    //   107: aload 7
    //   109: ldc 128
    //   111: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   114: aload 6
    //   116: ifnonnull +103 -> 219
    //   119: aload_2
    //   120: astore_1
    //   121: new 130	kotlin/TypeCastException
    //   124: dup
    //   125: ldc 132
    //   127: invokespecial 135	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   130: athrow
    //   131: astore_2
    //   132: aload_2
    //   133: astore_1
    //   134: aload_2
    //   135: athrow
    //   136: astore_2
    //   137: aload 4
    //   139: aload_1
    //   140: invokestatic 141	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   143: aload_2
    //   144: athrow
    //   145: astore_1
    //   146: aload_0
    //   147: getfield 65	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   150: astore_2
    //   151: aload_2
    //   152: ifnull +15 -> 167
    //   155: aload_2
    //   156: sipush 600
    //   159: ldc 143
    //   161: iconst_0
    //   162: invokeinterface 149 4 0
    //   167: getstatic 155	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   170: ldc 37
    //   172: new 157	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   179: aload_1
    //   180: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: ldc 164
    //   185: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_0
    //   189: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   192: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   195: ldc 169
    //   197: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: aload_1
    //   204: checkcast 74	java/lang/Throwable
    //   207: invokevirtual 174	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
    //   218: return
    //   219: aload_2
    //   220: astore_1
    //   221: aload 6
    //   223: aload 7
    //   225: invokevirtual 183	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   228: astore 6
    //   230: aload_2
    //   231: astore_1
    //   232: aload 6
    //   234: ldc 185
    //   236: invokestatic 118	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   239: aload_2
    //   240: astore_1
    //   241: aload 5
    //   243: aload 6
    //   245: invokevirtual 189	java/io/DataOutputStream:write	([B)V
    //   248: aload_2
    //   249: astore_1
    //   250: aload 5
    //   252: invokevirtual 192	java/io/DataOutputStream:flush	()V
    //   255: aload_2
    //   256: astore_1
    //   257: getstatic 197	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   260: astore 5
    //   262: aload 4
    //   264: aload_2
    //   265: invokestatic 141	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   268: getstatic 202	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   271: new 204	java/io/BufferedInputStream
    //   274: dup
    //   275: aload_3
    //   276: invokevirtual 208	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   279: invokespecial 211	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   282: checkcast 213	java/io/InputStream
    //   285: sipush 8192
    //   288: invokevirtual 219	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   291: astore_1
    //   292: getstatic 155	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   295: iconst_2
    //   296: anewarray 179	java/lang/String
    //   299: dup
    //   300: iconst_0
    //   301: ldc 37
    //   303: aastore
    //   304: dup
    //   305: iconst_1
    //   306: aload_1
    //   307: aastore
    //   308: invokevirtual 223	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   311: aload_0
    //   312: aload_1
    //   313: invokevirtual 227	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   316: ifeq +31 -> 347
    //   319: aload_0
    //   320: getfield 65	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   323: astore_1
    //   324: aload_1
    //   325: ifnull +13 -> 338
    //   328: aload_1
    //   329: sipush 200
    //   332: iconst_0
    //   333: invokeinterface 231 3 0
    //   338: aload_3
    //   339: ifnull -121 -> 218
    //   342: aload_3
    //   343: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
    //   346: return
    //   347: aload_0
    //   348: getfield 65	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   351: astore_2
    //   352: aload_2
    //   353: ifnull -15 -> 338
    //   356: aload_2
    //   357: sipush 700
    //   360: aload_1
    //   361: iconst_0
    //   362: invokeinterface 149 4 0
    //   367: goto -29 -> 338
    //   370: astore_1
    //   371: getstatic 155	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   374: ldc 37
    //   376: new 157	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   383: aload_1
    //   384: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   387: ldc 164
    //   389: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_0
    //   393: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   396: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   399: ldc 233
    //   401: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: aload_1
    //   408: checkcast 74	java/lang/Throwable
    //   411: invokevirtual 174	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   414: aload_3
    //   415: ifnull -197 -> 218
    //   418: aload_3
    //   419: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
    //   422: return
    //   423: astore_1
    //   424: getstatic 155	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   427: ldc 37
    //   429: new 157	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   436: aload_1
    //   437: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   440: ldc 164
    //   442: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_0
    //   446: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   449: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   452: ldc 233
    //   454: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: aload_1
    //   461: checkcast 74	java/lang/Throwable
    //   464: invokevirtual 174	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   467: goto -257 -> 210
    //   470: astore_1
    //   471: aload_3
    //   472: ifnull +7 -> 479
    //   475: aload_3
    //   476: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
    //   479: aload_1
    //   480: athrow
    //   481: astore_1
    //   482: getstatic 155	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   485: ldc 37
    //   487: new 157	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   494: aload_1
    //   495: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   498: ldc 164
    //   500: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_0
    //   504: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   507: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   510: ldc 233
    //   512: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: aload_1
    //   519: checkcast 74	java/lang/Throwable
    //   522: invokevirtual 174	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   525: goto -315 -> 210
    //   528: astore_1
    //   529: getstatic 155	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   532: ldc 37
    //   534: new 157	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   541: aload_1
    //   542: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   545: ldc 164
    //   547: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload_0
    //   551: getfield 63	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaJsonUploadRunnable:jsonObject	Lorg/json/JSONObject;
    //   554: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   557: ldc 233
    //   559: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: aload_1
    //   566: invokevirtual 174	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   569: aload_3
    //   570: ifnull -352 -> 218
    //   573: aload_3
    //   574: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
    //   577: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	this	AthenaJsonUploadRunnable
    //   7	133	1	localObject1	java.lang.Object
    //   145	59	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   220	141	1	localObject2	java.lang.Object
    //   370	38	1	localException1	java.lang.Exception
    //   423	38	1	localException2	java.lang.Exception
    //   470	10	1	localObject3	java.lang.Object
    //   481	38	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   528	38	1	localThrowable1	java.lang.Throwable
    //   66	54	2	localThrowable2	java.lang.Throwable
    //   131	4	2	localThrowable3	java.lang.Throwable
    //   136	8	2	localObject4	java.lang.Object
    //   150	207	2	localReportResultCallback	IReporter.ReportResultCallback
    //   41	533	3	localHttpURLConnection	java.net.HttpURLConnection
    //   60	203	4	localCloseable	java.io.Closeable
    //   74	187	5	localObject5	java.lang.Object
    //   85	159	6	localObject6	java.lang.Object
    //   103	121	7	localCharset	java.nio.charset.Charset
    // Exception table:
    //   from	to	target	type
    //   69	76	131	java/lang/Throwable
    //   78	87	131	java/lang/Throwable
    //   89	96	131	java/lang/Throwable
    //   98	105	131	java/lang/Throwable
    //   107	114	131	java/lang/Throwable
    //   121	131	131	java/lang/Throwable
    //   221	230	131	java/lang/Throwable
    //   232	239	131	java/lang/Throwable
    //   241	248	131	java/lang/Throwable
    //   250	255	131	java/lang/Throwable
    //   257	262	131	java/lang/Throwable
    //   69	76	136	finally
    //   78	87	136	finally
    //   89	96	136	finally
    //   98	105	136	finally
    //   107	114	136	finally
    //   121	131	136	finally
    //   134	136	136	finally
    //   221	230	136	finally
    //   232	239	136	finally
    //   241	248	136	finally
    //   250	255	136	finally
    //   257	262	136	finally
    //   46	67	145	java/lang/OutOfMemoryError
    //   137	145	145	java/lang/OutOfMemoryError
    //   262	324	145	java/lang/OutOfMemoryError
    //   328	338	145	java/lang/OutOfMemoryError
    //   347	352	145	java/lang/OutOfMemoryError
    //   356	367	145	java/lang/OutOfMemoryError
    //   46	67	370	java/lang/Exception
    //   137	145	370	java/lang/Exception
    //   262	324	370	java/lang/Exception
    //   328	338	370	java/lang/Exception
    //   347	352	370	java/lang/Exception
    //   356	367	370	java/lang/Exception
    //   146	151	423	java/lang/Exception
    //   155	167	423	java/lang/Exception
    //   167	210	423	java/lang/Exception
    //   46	67	470	finally
    //   137	145	470	finally
    //   146	151	470	finally
    //   155	167	470	finally
    //   167	210	470	finally
    //   262	324	470	finally
    //   328	338	470	finally
    //   347	352	470	finally
    //   356	367	470	finally
    //   371	414	470	finally
    //   424	467	470	finally
    //   482	525	470	finally
    //   529	569	470	finally
    //   146	151	481	java/lang/OutOfMemoryError
    //   155	167	481	java/lang/OutOfMemoryError
    //   167	210	481	java/lang/OutOfMemoryError
    //   46	67	528	java/lang/Throwable
    //   137	145	528	java/lang/Throwable
    //   262	324	528	java/lang/Throwable
    //   328	338	528	java/lang/Throwable
    //   347	352	528	java/lang/Throwable
    //   356	367	528	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.AthenaJsonUploadRunnable
 * JD-Core Version:    0.7.0.1
 */