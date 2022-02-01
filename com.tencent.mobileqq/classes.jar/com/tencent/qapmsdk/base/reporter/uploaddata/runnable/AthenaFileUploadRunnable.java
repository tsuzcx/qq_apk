package com.tencent.qapmsdk.base.reporter.uploaddata.runnable;

import com.tencent.qapmsdk.base.reporter.uploaddata.AthenaUpload;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/AthenaUpload;", "Ljava/lang/Runnable;", "url", "Ljava/net/URL;", "jsonObject", "Lorg/json/JSONObject;", "filePaths", "", "", "callback", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "(Ljava/net/URL;Lorg/json/JSONObject;Ljava/util/List;Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;)V", "buffer", "Ljava/lang/StringBuffer;", "getBuffer", "()Ljava/lang/StringBuffer;", "cleanOriginal", "", "generateEndStream", "generateFileStream", "fileName", "generateJsonStream", "getUploadGzipFiles", "Ljava/util/ArrayList;", "Ljava/io/File;", "Lkotlin/collections/ArrayList;", "request", "run", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class AthenaFileUploadRunnable
  extends AthenaUpload
  implements Runnable
{
  private static final String BOUNDARY = "27182818284590452353602874713526";
  public static final AthenaFileUploadRunnable.Companion Companion = new AthenaFileUploadRunnable.Companion(null);
  private static final String TAG = "QAPM_base_AthenaFileUploadRunnable";
  @NotNull
  private final StringBuffer buffer;
  private final IReporter.ReportResultCallback callback;
  private final List<String> filePaths;
  private final JSONObject jsonObject;
  
  public AthenaFileUploadRunnable(@NotNull URL paramURL, @NotNull JSONObject paramJSONObject, @NotNull List<String> paramList, @Nullable IReporter.ReportResultCallback paramReportResultCallback)
  {
    super(paramURL);
    this.jsonObject = paramJSONObject;
    this.filePaths = paramList;
    this.callback = paramReportResultCallback;
    this.buffer = new StringBuffer(512);
  }
  
  private final void cleanOriginal()
  {
    Object localObject2 = (Iterable)this.filePaths;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label80:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((CharSequence)localObject3).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label80;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = new File((String)((Iterator)localObject1).next());
      if ((((File)localObject2).isFile()) && (((File)localObject2).canRead())) {
        ((File)localObject2).delete();
      }
    }
  }
  
  private final String generateEndStream()
  {
    this.buffer.delete(0, this.buffer.length());
    this.buffer.append("--").append("27182818284590452353602874713526").append("\r\n");
    String str = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "buffer.toString()");
    return str;
  }
  
  private final String generateFileStream(String paramString)
  {
    this.buffer.delete(0, this.buffer.length());
    this.buffer.append("--").append("27182818284590452353602874713526").append("\r\n").append("Content-Disposition: form-data; name=\"files\"; filename=\"").append(paramString).append("\"").append("\r\n").append("Content-Type: application/octet-stream").append("\r\n\r\n");
    paramString = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "buffer.toString()");
    return paramString;
  }
  
  private final String generateJsonStream()
  {
    this.buffer.delete(0, this.buffer.length());
    this.buffer.append("--").append("27182818284590452353602874713526").append("\r\n").append("Content-Disposition: form-data; name=\"_json\"\r\n\r\n").append(this.jsonObject.toString()).append("\r\n");
    String str = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "buffer.toString()");
    return str;
  }
  
  private final ArrayList<File> getUploadGzipFiles()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (Iterable)this.filePaths;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label140:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      Object localObject4 = (String)localObject3;
      int i;
      if (((CharSequence)localObject4).length() == 0)
      {
        i = 1;
        label78:
        if (i == 0) {
          break label105;
        }
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label140;
        }
        ((Collection)localObject1).add(localObject3);
        break;
        i = 0;
        break label78;
        label105:
        localObject4 = new File((String)localObject4);
        if ((((File)localObject4).isFile()) && (((File)localObject4).canRead())) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (String)localObject2 + ".gz";
      if (FileUtil.Companion.zipFiles(CollectionsKt.listOf(localObject2), (String)localObject3, true)) {
        localArrayList.add(new File((String)localObject3));
      }
    }
    return localArrayList;
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
    //   0: aload_0
    //   1: invokespecial 224	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:getUploadGzipFiles	()Ljava/util/ArrayList;
    //   4: astore 6
    //   6: aload 6
    //   8: invokevirtual 227	java/util/ArrayList:isEmpty	()Z
    //   11: ifeq +25 -> 36
    //   14: aload_0
    //   15: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +15 -> 35
    //   23: aload_1
    //   24: sipush 601
    //   27: ldc 229
    //   29: iconst_0
    //   30: invokeinterface 235 4 0
    //   35: return
    //   36: new 237	java/util/HashMap
    //   39: dup
    //   40: invokespecial 238	java/util/HashMap:<init>	()V
    //   43: astore_1
    //   44: aload_1
    //   45: checkcast 240	java/util/Map
    //   48: ldc 242
    //   50: ldc 244
    //   52: invokeinterface 248 3 0
    //   57: pop
    //   58: aload_0
    //   59: aload_1
    //   60: invokevirtual 252	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +469 -> 536
    //   70: new 254	java/io/DataOutputStream
    //   73: dup
    //   74: aload 5
    //   76: invokevirtual 260	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   79: invokespecial 263	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   82: checkcast 265	java/io/Closeable
    //   85: astore 7
    //   87: aconst_null
    //   88: checkcast 222	java/lang/Throwable
    //   91: astore 4
    //   93: aload 4
    //   95: astore_1
    //   96: aload 7
    //   98: checkcast 254	java/io/DataOutputStream
    //   101: astore_2
    //   102: aload 4
    //   104: astore_1
    //   105: aload_2
    //   106: aload_0
    //   107: invokespecial 267	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:generateJsonStream	()Ljava/lang/String;
    //   110: invokevirtual 270	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   113: aload 4
    //   115: astore_1
    //   116: aload 6
    //   118: checkcast 99	java/lang/Iterable
    //   121: invokeinterface 109 1 0
    //   126: astore 9
    //   128: aload 4
    //   130: astore_1
    //   131: aload 9
    //   133: invokeinterface 115 1 0
    //   138: ifeq +252 -> 390
    //   141: aload 4
    //   143: astore_1
    //   144: aload 9
    //   146: invokeinterface 119 1 0
    //   151: checkcast 135	java/io/File
    //   154: astore_3
    //   155: aload 4
    //   157: astore_1
    //   158: aload_3
    //   159: invokevirtual 273	java/io/File:getName	()Ljava/lang/String;
    //   162: astore 8
    //   164: aload 4
    //   166: astore_1
    //   167: aload 8
    //   169: ldc_w 275
    //   172: invokestatic 168	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   175: aload 4
    //   177: astore_1
    //   178: aload_2
    //   179: aload_0
    //   180: aload 8
    //   182: invokespecial 277	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:generateFileStream	(Ljava/lang/String;)Ljava/lang/String;
    //   185: invokevirtual 270	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   188: aload 4
    //   190: astore_1
    //   191: new 279	java/io/FileInputStream
    //   194: dup
    //   195: aload_3
    //   196: invokespecial 282	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   199: checkcast 265	java/io/Closeable
    //   202: astore 8
    //   204: aload 4
    //   206: astore_1
    //   207: aconst_null
    //   208: checkcast 222	java/lang/Throwable
    //   211: astore_3
    //   212: aload 8
    //   214: checkcast 279	java/io/FileInputStream
    //   217: astore_1
    //   218: aload_1
    //   219: checkcast 284	java/io/InputStream
    //   222: aload_2
    //   223: checkcast 286	java/io/OutputStream
    //   226: aload_1
    //   227: invokevirtual 289	java/io/FileInputStream:available	()I
    //   230: ldc_w 290
    //   233: invokestatic 296	java/lang/Math:min	(II)I
    //   236: invokestatic 302	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   239: pop2
    //   240: aload 4
    //   242: astore_1
    //   243: aload 8
    //   245: aload_3
    //   246: invokestatic 308	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   249: aload 4
    //   251: astore_1
    //   252: aload_2
    //   253: ldc 160
    //   255: invokevirtual 270	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   258: goto -130 -> 128
    //   261: astore_3
    //   262: aload_3
    //   263: athrow
    //   264: astore_2
    //   265: aload 4
    //   267: astore_1
    //   268: aload 8
    //   270: aload_3
    //   271: invokestatic 308	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   274: aload 4
    //   276: astore_1
    //   277: aload_2
    //   278: athrow
    //   279: astore_2
    //   280: aload_2
    //   281: astore_1
    //   282: aload_2
    //   283: athrow
    //   284: astore_2
    //   285: aload 7
    //   287: aload_1
    //   288: invokestatic 308	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   291: aload_2
    //   292: athrow
    //   293: astore_1
    //   294: getstatic 314	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   297: iconst_2
    //   298: anewarray 121	java/lang/String
    //   301: dup
    //   302: iconst_0
    //   303: ldc 54
    //   305: aastore
    //   306: dup
    //   307: iconst_1
    //   308: new 185	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   315: aload_1
    //   316: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: ldc_w 319
    //   322: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: aastore
    //   329: invokevirtual 323	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   332: aload_0
    //   333: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   336: astore_1
    //   337: aload_1
    //   338: ifnull +16 -> 354
    //   341: aload_1
    //   342: sipush 600
    //   345: ldc_w 325
    //   348: iconst_0
    //   349: invokeinterface 235 4 0
    //   354: aload 6
    //   356: checkcast 99	java/lang/Iterable
    //   359: invokeinterface 109 1 0
    //   364: astore_1
    //   365: aload_1
    //   366: invokeinterface 115 1 0
    //   371: ifeq +562 -> 933
    //   374: aload_1
    //   375: invokeinterface 119 1 0
    //   380: checkcast 135	java/io/File
    //   383: invokevirtual 147	java/io/File:delete	()Z
    //   386: pop
    //   387: goto -22 -> 365
    //   390: aload 4
    //   392: astore_1
    //   393: aload_2
    //   394: aload_0
    //   395: invokespecial 327	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:generateEndStream	()Ljava/lang/String;
    //   398: invokevirtual 270	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   401: aload 4
    //   403: astore_1
    //   404: getstatic 332	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   407: astore_2
    //   408: aload 7
    //   410: aload 4
    //   412: invokestatic 308	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   415: new 334	java/io/BufferedInputStream
    //   418: dup
    //   419: aload 5
    //   421: invokevirtual 338	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   424: invokespecial 341	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   427: checkcast 265	java/io/Closeable
    //   430: astore 4
    //   432: aconst_null
    //   433: checkcast 222	java/lang/Throwable
    //   436: astore_2
    //   437: aload_2
    //   438: astore_1
    //   439: aload 4
    //   441: checkcast 334	java/io/BufferedInputStream
    //   444: astore_3
    //   445: aload_2
    //   446: astore_1
    //   447: getstatic 197	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   450: aload_3
    //   451: checkcast 284	java/io/InputStream
    //   454: sipush 8192
    //   457: invokevirtual 345	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   460: astore_3
    //   461: aload_2
    //   462: astore_1
    //   463: getstatic 332	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   466: astore 7
    //   468: aload 4
    //   470: aload_2
    //   471: invokestatic 308	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   474: aload 5
    //   476: invokevirtual 348	java/net/HttpURLConnection:getResponseCode	()I
    //   479: lookupswitch	default:+514->993, 200:+204->683, 400:+356->835, 500:+420->899
    //   513: invokespecial 350	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:cleanOriginal	()V
    //   516: aload_0
    //   517: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   520: astore_1
    //   521: aload_1
    //   522: ifnull +14 -> 536
    //   525: aload_1
    //   526: sipush 700
    //   529: aload_3
    //   530: iconst_0
    //   531: invokeinterface 235 4 0
    //   536: aload 6
    //   538: checkcast 99	java/lang/Iterable
    //   541: invokeinterface 109 1 0
    //   546: astore_1
    //   547: aload_1
    //   548: invokeinterface 115 1 0
    //   553: ifeq +369 -> 922
    //   556: aload_1
    //   557: invokeinterface 119 1 0
    //   562: checkcast 135	java/io/File
    //   565: invokevirtual 147	java/io/File:delete	()Z
    //   568: pop
    //   569: goto -22 -> 547
    //   572: astore_2
    //   573: aload_2
    //   574: astore_1
    //   575: aload_2
    //   576: athrow
    //   577: astore_2
    //   578: aload 4
    //   580: aload_1
    //   581: invokestatic 308	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   584: aload_2
    //   585: athrow
    //   586: astore_1
    //   587: getstatic 314	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   590: iconst_2
    //   591: anewarray 121	java/lang/String
    //   594: dup
    //   595: iconst_0
    //   596: ldc 54
    //   598: aastore
    //   599: dup
    //   600: iconst_1
    //   601: new 185	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   608: aload_1
    //   609: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   612: ldc_w 352
    //   615: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: aastore
    //   622: invokevirtual 323	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   625: aload_0
    //   626: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   629: astore_1
    //   630: aload_1
    //   631: ifnull +16 -> 647
    //   634: aload_1
    //   635: sipush 601
    //   638: ldc_w 354
    //   641: iconst_0
    //   642: invokeinterface 235 4 0
    //   647: aload 6
    //   649: checkcast 99	java/lang/Iterable
    //   652: invokeinterface 109 1 0
    //   657: astore_1
    //   658: aload_1
    //   659: invokeinterface 115 1 0
    //   664: ifeq +280 -> 944
    //   667: aload_1
    //   668: invokeinterface 119 1 0
    //   673: checkcast 135	java/io/File
    //   676: invokevirtual 147	java/io/File:delete	()Z
    //   679: pop
    //   680: goto -22 -> 658
    //   683: aload_0
    //   684: aload_3
    //   685: invokevirtual 358	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   688: ifeq +78 -> 766
    //   691: aload_0
    //   692: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   695: astore_1
    //   696: aload_1
    //   697: ifnull +13 -> 710
    //   700: aload_1
    //   701: sipush 200
    //   704: iconst_0
    //   705: invokeinterface 362 3 0
    //   710: aload_0
    //   711: invokespecial 350	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:cleanOriginal	()V
    //   714: goto -178 -> 536
    //   717: astore_1
    //   718: getstatic 314	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   721: ldc 54
    //   723: aload_1
    //   724: checkcast 222	java/lang/Throwable
    //   727: invokevirtual 366	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   730: aload 6
    //   732: checkcast 99	java/lang/Iterable
    //   735: invokeinterface 109 1 0
    //   740: astore_1
    //   741: aload_1
    //   742: invokeinterface 115 1 0
    //   747: ifeq +208 -> 955
    //   750: aload_1
    //   751: invokeinterface 119 1 0
    //   756: checkcast 135	java/io/File
    //   759: invokevirtual 147	java/io/File:delete	()Z
    //   762: pop
    //   763: goto -22 -> 741
    //   766: aload_0
    //   767: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   770: astore_1
    //   771: aload_1
    //   772: ifnull -62 -> 710
    //   775: aload_1
    //   776: sipush 700
    //   779: aload_3
    //   780: iconst_0
    //   781: invokeinterface 235 4 0
    //   786: goto -76 -> 710
    //   789: astore_1
    //   790: getstatic 314	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   793: ldc 54
    //   795: aload_1
    //   796: invokevirtual 366	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   799: aload 6
    //   801: checkcast 99	java/lang/Iterable
    //   804: invokeinterface 109 1 0
    //   809: astore_1
    //   810: aload_1
    //   811: invokeinterface 115 1 0
    //   816: ifeq +150 -> 966
    //   819: aload_1
    //   820: invokeinterface 119 1 0
    //   825: checkcast 135	java/io/File
    //   828: invokevirtual 147	java/io/File:delete	()Z
    //   831: pop
    //   832: goto -22 -> 810
    //   835: aload_0
    //   836: invokespecial 350	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:cleanOriginal	()V
    //   839: aload_0
    //   840: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   843: astore_1
    //   844: aload_1
    //   845: ifnull -309 -> 536
    //   848: aload_1
    //   849: sipush 400
    //   852: aload_3
    //   853: iconst_0
    //   854: invokeinterface 235 4 0
    //   859: goto -323 -> 536
    //   862: astore_1
    //   863: aload 6
    //   865: checkcast 99	java/lang/Iterable
    //   868: invokeinterface 109 1 0
    //   873: astore_2
    //   874: aload_2
    //   875: invokeinterface 115 1 0
    //   880: ifeq +97 -> 977
    //   883: aload_2
    //   884: invokeinterface 119 1 0
    //   889: checkcast 135	java/io/File
    //   892: invokevirtual 147	java/io/File:delete	()Z
    //   895: pop
    //   896: goto -22 -> 874
    //   899: aload_0
    //   900: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   903: astore_1
    //   904: aload_1
    //   905: ifnull -369 -> 536
    //   908: aload_1
    //   909: sipush 500
    //   912: aload_3
    //   913: iconst_0
    //   914: invokeinterface 235 4 0
    //   919: goto -383 -> 536
    //   922: aload 5
    //   924: ifnull -889 -> 35
    //   927: aload 5
    //   929: invokevirtual 369	java/net/HttpURLConnection:disconnect	()V
    //   932: return
    //   933: aload 5
    //   935: ifnull -900 -> 35
    //   938: aload 5
    //   940: invokevirtual 369	java/net/HttpURLConnection:disconnect	()V
    //   943: return
    //   944: aload 5
    //   946: ifnull -911 -> 35
    //   949: aload 5
    //   951: invokevirtual 369	java/net/HttpURLConnection:disconnect	()V
    //   954: return
    //   955: aload 5
    //   957: ifnull -922 -> 35
    //   960: aload 5
    //   962: invokevirtual 369	java/net/HttpURLConnection:disconnect	()V
    //   965: return
    //   966: aload 5
    //   968: ifnull -933 -> 35
    //   971: aload 5
    //   973: invokevirtual 369	java/net/HttpURLConnection:disconnect	()V
    //   976: return
    //   977: aload 5
    //   979: ifnull +8 -> 987
    //   982: aload 5
    //   984: invokevirtual 369	java/net/HttpURLConnection:disconnect	()V
    //   987: aload_1
    //   988: athrow
    //   989: astore_2
    //   990: goto -725 -> 265
    //   993: goto -481 -> 512
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	996	0	this	AthenaFileUploadRunnable
    //   18	270	1	localObject1	Object
    //   293	23	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   336	245	1	localObject2	Object
    //   586	23	1	localFileNotFoundException	java.io.FileNotFoundException
    //   629	72	1	localObject3	Object
    //   717	7	1	localException	java.lang.Exception
    //   740	36	1	localObject4	Object
    //   789	7	1	localThrowable1	java.lang.Throwable
    //   809	40	1	localObject5	Object
    //   862	1	1	localObject6	Object
    //   903	85	1	localReportResultCallback	IReporter.ReportResultCallback
    //   101	152	2	localDataOutputStream	java.io.DataOutputStream
    //   264	14	2	localObject7	Object
    //   279	4	2	localThrowable2	java.lang.Throwable
    //   284	110	2	localObject8	Object
    //   407	64	2	localObject9	Object
    //   572	4	2	localThrowable3	java.lang.Throwable
    //   577	8	2	localObject10	Object
    //   873	11	2	localIterator1	Iterator
    //   989	1	2	localObject11	Object
    //   154	92	3	localObject12	Object
    //   261	10	3	localThrowable4	java.lang.Throwable
    //   444	469	3	localObject13	Object
    //   91	488	4	localObject14	Object
    //   63	920	5	localHttpURLConnection	java.net.HttpURLConnection
    //   4	860	6	localArrayList	ArrayList
    //   85	382	7	localObject15	Object
    //   162	107	8	localObject16	Object
    //   126	19	9	localIterator2	Iterator
    // Exception table:
    //   from	to	target	type
    //   212	240	261	java/lang/Throwable
    //   262	264	264	finally
    //   96	102	279	java/lang/Throwable
    //   105	113	279	java/lang/Throwable
    //   116	128	279	java/lang/Throwable
    //   131	141	279	java/lang/Throwable
    //   144	155	279	java/lang/Throwable
    //   158	164	279	java/lang/Throwable
    //   167	175	279	java/lang/Throwable
    //   178	188	279	java/lang/Throwable
    //   191	204	279	java/lang/Throwable
    //   207	212	279	java/lang/Throwable
    //   243	249	279	java/lang/Throwable
    //   252	258	279	java/lang/Throwable
    //   268	274	279	java/lang/Throwable
    //   277	279	279	java/lang/Throwable
    //   393	401	279	java/lang/Throwable
    //   404	408	279	java/lang/Throwable
    //   96	102	284	finally
    //   105	113	284	finally
    //   116	128	284	finally
    //   131	141	284	finally
    //   144	155	284	finally
    //   158	164	284	finally
    //   167	175	284	finally
    //   178	188	284	finally
    //   191	204	284	finally
    //   207	212	284	finally
    //   243	249	284	finally
    //   252	258	284	finally
    //   268	274	284	finally
    //   277	279	284	finally
    //   282	284	284	finally
    //   393	401	284	finally
    //   404	408	284	finally
    //   70	93	293	java/lang/OutOfMemoryError
    //   285	293	293	java/lang/OutOfMemoryError
    //   408	437	293	java/lang/OutOfMemoryError
    //   468	512	293	java/lang/OutOfMemoryError
    //   512	521	293	java/lang/OutOfMemoryError
    //   525	536	293	java/lang/OutOfMemoryError
    //   578	586	293	java/lang/OutOfMemoryError
    //   683	696	293	java/lang/OutOfMemoryError
    //   700	710	293	java/lang/OutOfMemoryError
    //   710	714	293	java/lang/OutOfMemoryError
    //   766	771	293	java/lang/OutOfMemoryError
    //   775	786	293	java/lang/OutOfMemoryError
    //   835	844	293	java/lang/OutOfMemoryError
    //   848	859	293	java/lang/OutOfMemoryError
    //   899	904	293	java/lang/OutOfMemoryError
    //   908	919	293	java/lang/OutOfMemoryError
    //   439	445	572	java/lang/Throwable
    //   447	461	572	java/lang/Throwable
    //   463	468	572	java/lang/Throwable
    //   439	445	577	finally
    //   447	461	577	finally
    //   463	468	577	finally
    //   575	577	577	finally
    //   70	93	586	java/io/FileNotFoundException
    //   285	293	586	java/io/FileNotFoundException
    //   408	437	586	java/io/FileNotFoundException
    //   468	512	586	java/io/FileNotFoundException
    //   512	521	586	java/io/FileNotFoundException
    //   525	536	586	java/io/FileNotFoundException
    //   578	586	586	java/io/FileNotFoundException
    //   683	696	586	java/io/FileNotFoundException
    //   700	710	586	java/io/FileNotFoundException
    //   710	714	586	java/io/FileNotFoundException
    //   766	771	586	java/io/FileNotFoundException
    //   775	786	586	java/io/FileNotFoundException
    //   835	844	586	java/io/FileNotFoundException
    //   848	859	586	java/io/FileNotFoundException
    //   899	904	586	java/io/FileNotFoundException
    //   908	919	586	java/io/FileNotFoundException
    //   70	93	717	java/lang/Exception
    //   285	293	717	java/lang/Exception
    //   408	437	717	java/lang/Exception
    //   468	512	717	java/lang/Exception
    //   512	521	717	java/lang/Exception
    //   525	536	717	java/lang/Exception
    //   578	586	717	java/lang/Exception
    //   683	696	717	java/lang/Exception
    //   700	710	717	java/lang/Exception
    //   710	714	717	java/lang/Exception
    //   766	771	717	java/lang/Exception
    //   775	786	717	java/lang/Exception
    //   835	844	717	java/lang/Exception
    //   848	859	717	java/lang/Exception
    //   899	904	717	java/lang/Exception
    //   908	919	717	java/lang/Exception
    //   70	93	789	java/lang/Throwable
    //   285	293	789	java/lang/Throwable
    //   408	437	789	java/lang/Throwable
    //   468	512	789	java/lang/Throwable
    //   512	521	789	java/lang/Throwable
    //   525	536	789	java/lang/Throwable
    //   578	586	789	java/lang/Throwable
    //   683	696	789	java/lang/Throwable
    //   700	710	789	java/lang/Throwable
    //   710	714	789	java/lang/Throwable
    //   766	771	789	java/lang/Throwable
    //   775	786	789	java/lang/Throwable
    //   835	844	789	java/lang/Throwable
    //   848	859	789	java/lang/Throwable
    //   899	904	789	java/lang/Throwable
    //   908	919	789	java/lang/Throwable
    //   70	93	862	finally
    //   285	293	862	finally
    //   294	337	862	finally
    //   341	354	862	finally
    //   408	437	862	finally
    //   468	512	862	finally
    //   512	521	862	finally
    //   525	536	862	finally
    //   578	586	862	finally
    //   587	630	862	finally
    //   634	647	862	finally
    //   683	696	862	finally
    //   700	710	862	finally
    //   710	714	862	finally
    //   718	730	862	finally
    //   766	771	862	finally
    //   775	786	862	finally
    //   790	799	862	finally
    //   835	844	862	finally
    //   848	859	862	finally
    //   899	904	862	finally
    //   908	919	862	finally
    //   212	240	989	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.AthenaFileUploadRunnable
 * JD-Core Version:    0.7.0.1
 */