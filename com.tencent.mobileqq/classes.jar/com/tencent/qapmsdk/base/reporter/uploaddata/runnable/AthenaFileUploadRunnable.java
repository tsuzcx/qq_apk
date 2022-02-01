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
    //   67: ifnull +489 -> 556
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
    //   371: ifeq +582 -> 953
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
    //   474: getstatic 314	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   477: iconst_2
    //   478: anewarray 121	java/lang/String
    //   481: dup
    //   482: iconst_0
    //   483: ldc 54
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: aload_3
    //   489: aastore
    //   490: invokevirtual 348	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   493: aload 5
    //   495: invokevirtual 351	java/net/HttpURLConnection:getResponseCode	()I
    //   498: lookupswitch	default:+515->1013, 200:+205->703, 400:+357->855, 500:+421->919
    //   533: invokespecial 353	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:cleanOriginal	()V
    //   536: aload_0
    //   537: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   540: astore_1
    //   541: aload_1
    //   542: ifnull +14 -> 556
    //   545: aload_1
    //   546: sipush 700
    //   549: aload_3
    //   550: iconst_0
    //   551: invokeinterface 235 4 0
    //   556: aload 6
    //   558: checkcast 99	java/lang/Iterable
    //   561: invokeinterface 109 1 0
    //   566: astore_1
    //   567: aload_1
    //   568: invokeinterface 115 1 0
    //   573: ifeq +369 -> 942
    //   576: aload_1
    //   577: invokeinterface 119 1 0
    //   582: checkcast 135	java/io/File
    //   585: invokevirtual 147	java/io/File:delete	()Z
    //   588: pop
    //   589: goto -22 -> 567
    //   592: astore_2
    //   593: aload_2
    //   594: astore_1
    //   595: aload_2
    //   596: athrow
    //   597: astore_2
    //   598: aload 4
    //   600: aload_1
    //   601: invokestatic 308	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   604: aload_2
    //   605: athrow
    //   606: astore_1
    //   607: getstatic 314	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   610: iconst_2
    //   611: anewarray 121	java/lang/String
    //   614: dup
    //   615: iconst_0
    //   616: ldc 54
    //   618: aastore
    //   619: dup
    //   620: iconst_1
    //   621: new 185	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   628: aload_1
    //   629: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   632: ldc_w 355
    //   635: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: aastore
    //   642: invokevirtual 323	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   645: aload_0
    //   646: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   649: astore_1
    //   650: aload_1
    //   651: ifnull +16 -> 667
    //   654: aload_1
    //   655: sipush 601
    //   658: ldc_w 357
    //   661: iconst_0
    //   662: invokeinterface 235 4 0
    //   667: aload 6
    //   669: checkcast 99	java/lang/Iterable
    //   672: invokeinterface 109 1 0
    //   677: astore_1
    //   678: aload_1
    //   679: invokeinterface 115 1 0
    //   684: ifeq +280 -> 964
    //   687: aload_1
    //   688: invokeinterface 119 1 0
    //   693: checkcast 135	java/io/File
    //   696: invokevirtual 147	java/io/File:delete	()Z
    //   699: pop
    //   700: goto -22 -> 678
    //   703: aload_0
    //   704: aload_3
    //   705: invokevirtual 361	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   708: ifeq +78 -> 786
    //   711: aload_0
    //   712: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   715: astore_1
    //   716: aload_1
    //   717: ifnull +13 -> 730
    //   720: aload_1
    //   721: sipush 200
    //   724: iconst_0
    //   725: invokeinterface 365 3 0
    //   730: aload_0
    //   731: invokespecial 353	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:cleanOriginal	()V
    //   734: goto -178 -> 556
    //   737: astore_1
    //   738: getstatic 314	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   741: ldc 54
    //   743: aload_1
    //   744: checkcast 222	java/lang/Throwable
    //   747: invokevirtual 369	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   750: aload 6
    //   752: checkcast 99	java/lang/Iterable
    //   755: invokeinterface 109 1 0
    //   760: astore_1
    //   761: aload_1
    //   762: invokeinterface 115 1 0
    //   767: ifeq +208 -> 975
    //   770: aload_1
    //   771: invokeinterface 119 1 0
    //   776: checkcast 135	java/io/File
    //   779: invokevirtual 147	java/io/File:delete	()Z
    //   782: pop
    //   783: goto -22 -> 761
    //   786: aload_0
    //   787: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   790: astore_1
    //   791: aload_1
    //   792: ifnull -62 -> 730
    //   795: aload_1
    //   796: sipush 700
    //   799: aload_3
    //   800: iconst_0
    //   801: invokeinterface 235 4 0
    //   806: goto -76 -> 730
    //   809: astore_1
    //   810: getstatic 314	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   813: ldc 54
    //   815: aload_1
    //   816: invokevirtual 369	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   819: aload 6
    //   821: checkcast 99	java/lang/Iterable
    //   824: invokeinterface 109 1 0
    //   829: astore_1
    //   830: aload_1
    //   831: invokeinterface 115 1 0
    //   836: ifeq +150 -> 986
    //   839: aload_1
    //   840: invokeinterface 119 1 0
    //   845: checkcast 135	java/io/File
    //   848: invokevirtual 147	java/io/File:delete	()Z
    //   851: pop
    //   852: goto -22 -> 830
    //   855: aload_0
    //   856: invokespecial 353	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:cleanOriginal	()V
    //   859: aload_0
    //   860: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   863: astore_1
    //   864: aload_1
    //   865: ifnull -309 -> 556
    //   868: aload_1
    //   869: sipush 400
    //   872: aload_3
    //   873: iconst_0
    //   874: invokeinterface 235 4 0
    //   879: goto -323 -> 556
    //   882: astore_1
    //   883: aload 6
    //   885: checkcast 99	java/lang/Iterable
    //   888: invokeinterface 109 1 0
    //   893: astore_2
    //   894: aload_2
    //   895: invokeinterface 115 1 0
    //   900: ifeq +97 -> 997
    //   903: aload_2
    //   904: invokeinterface 119 1 0
    //   909: checkcast 135	java/io/File
    //   912: invokevirtual 147	java/io/File:delete	()Z
    //   915: pop
    //   916: goto -22 -> 894
    //   919: aload_0
    //   920: getfield 87	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/AthenaFileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   923: astore_1
    //   924: aload_1
    //   925: ifnull -369 -> 556
    //   928: aload_1
    //   929: sipush 500
    //   932: aload_3
    //   933: iconst_0
    //   934: invokeinterface 235 4 0
    //   939: goto -383 -> 556
    //   942: aload 5
    //   944: ifnull -909 -> 35
    //   947: aload 5
    //   949: invokevirtual 372	java/net/HttpURLConnection:disconnect	()V
    //   952: return
    //   953: aload 5
    //   955: ifnull -920 -> 35
    //   958: aload 5
    //   960: invokevirtual 372	java/net/HttpURLConnection:disconnect	()V
    //   963: return
    //   964: aload 5
    //   966: ifnull -931 -> 35
    //   969: aload 5
    //   971: invokevirtual 372	java/net/HttpURLConnection:disconnect	()V
    //   974: return
    //   975: aload 5
    //   977: ifnull -942 -> 35
    //   980: aload 5
    //   982: invokevirtual 372	java/net/HttpURLConnection:disconnect	()V
    //   985: return
    //   986: aload 5
    //   988: ifnull -953 -> 35
    //   991: aload 5
    //   993: invokevirtual 372	java/net/HttpURLConnection:disconnect	()V
    //   996: return
    //   997: aload 5
    //   999: ifnull +8 -> 1007
    //   1002: aload 5
    //   1004: invokevirtual 372	java/net/HttpURLConnection:disconnect	()V
    //   1007: aload_1
    //   1008: athrow
    //   1009: astore_2
    //   1010: goto -745 -> 265
    //   1013: goto -481 -> 532
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1016	0	this	AthenaFileUploadRunnable
    //   18	270	1	localObject1	Object
    //   293	23	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   336	265	1	localObject2	Object
    //   606	23	1	localFileNotFoundException	java.io.FileNotFoundException
    //   649	72	1	localObject3	Object
    //   737	7	1	localException	java.lang.Exception
    //   760	36	1	localObject4	Object
    //   809	7	1	localThrowable1	java.lang.Throwable
    //   829	40	1	localObject5	Object
    //   882	1	1	localObject6	Object
    //   923	85	1	localReportResultCallback	IReporter.ReportResultCallback
    //   101	152	2	localDataOutputStream	java.io.DataOutputStream
    //   264	14	2	localObject7	Object
    //   279	4	2	localThrowable2	java.lang.Throwable
    //   284	110	2	localObject8	Object
    //   407	64	2	localObject9	Object
    //   592	4	2	localThrowable3	java.lang.Throwable
    //   597	8	2	localObject10	Object
    //   893	11	2	localIterator1	Iterator
    //   1009	1	2	localObject11	Object
    //   154	92	3	localObject12	Object
    //   261	10	3	localThrowable4	java.lang.Throwable
    //   444	489	3	localObject13	Object
    //   91	508	4	localObject14	Object
    //   63	940	5	localHttpURLConnection	java.net.HttpURLConnection
    //   4	880	6	localArrayList	ArrayList
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
    //   468	532	293	java/lang/OutOfMemoryError
    //   532	541	293	java/lang/OutOfMemoryError
    //   545	556	293	java/lang/OutOfMemoryError
    //   598	606	293	java/lang/OutOfMemoryError
    //   703	716	293	java/lang/OutOfMemoryError
    //   720	730	293	java/lang/OutOfMemoryError
    //   730	734	293	java/lang/OutOfMemoryError
    //   786	791	293	java/lang/OutOfMemoryError
    //   795	806	293	java/lang/OutOfMemoryError
    //   855	864	293	java/lang/OutOfMemoryError
    //   868	879	293	java/lang/OutOfMemoryError
    //   919	924	293	java/lang/OutOfMemoryError
    //   928	939	293	java/lang/OutOfMemoryError
    //   439	445	592	java/lang/Throwable
    //   447	461	592	java/lang/Throwable
    //   463	468	592	java/lang/Throwable
    //   439	445	597	finally
    //   447	461	597	finally
    //   463	468	597	finally
    //   595	597	597	finally
    //   70	93	606	java/io/FileNotFoundException
    //   285	293	606	java/io/FileNotFoundException
    //   408	437	606	java/io/FileNotFoundException
    //   468	532	606	java/io/FileNotFoundException
    //   532	541	606	java/io/FileNotFoundException
    //   545	556	606	java/io/FileNotFoundException
    //   598	606	606	java/io/FileNotFoundException
    //   703	716	606	java/io/FileNotFoundException
    //   720	730	606	java/io/FileNotFoundException
    //   730	734	606	java/io/FileNotFoundException
    //   786	791	606	java/io/FileNotFoundException
    //   795	806	606	java/io/FileNotFoundException
    //   855	864	606	java/io/FileNotFoundException
    //   868	879	606	java/io/FileNotFoundException
    //   919	924	606	java/io/FileNotFoundException
    //   928	939	606	java/io/FileNotFoundException
    //   70	93	737	java/lang/Exception
    //   285	293	737	java/lang/Exception
    //   408	437	737	java/lang/Exception
    //   468	532	737	java/lang/Exception
    //   532	541	737	java/lang/Exception
    //   545	556	737	java/lang/Exception
    //   598	606	737	java/lang/Exception
    //   703	716	737	java/lang/Exception
    //   720	730	737	java/lang/Exception
    //   730	734	737	java/lang/Exception
    //   786	791	737	java/lang/Exception
    //   795	806	737	java/lang/Exception
    //   855	864	737	java/lang/Exception
    //   868	879	737	java/lang/Exception
    //   919	924	737	java/lang/Exception
    //   928	939	737	java/lang/Exception
    //   70	93	809	java/lang/Throwable
    //   285	293	809	java/lang/Throwable
    //   408	437	809	java/lang/Throwable
    //   468	532	809	java/lang/Throwable
    //   532	541	809	java/lang/Throwable
    //   545	556	809	java/lang/Throwable
    //   598	606	809	java/lang/Throwable
    //   703	716	809	java/lang/Throwable
    //   720	730	809	java/lang/Throwable
    //   730	734	809	java/lang/Throwable
    //   786	791	809	java/lang/Throwable
    //   795	806	809	java/lang/Throwable
    //   855	864	809	java/lang/Throwable
    //   868	879	809	java/lang/Throwable
    //   919	924	809	java/lang/Throwable
    //   928	939	809	java/lang/Throwable
    //   70	93	882	finally
    //   285	293	882	finally
    //   294	337	882	finally
    //   341	354	882	finally
    //   408	437	882	finally
    //   468	532	882	finally
    //   532	541	882	finally
    //   545	556	882	finally
    //   598	606	882	finally
    //   607	650	882	finally
    //   654	667	882	finally
    //   703	716	882	finally
    //   720	730	882	finally
    //   730	734	882	finally
    //   738	750	882	finally
    //   786	791	882	finally
    //   795	806	882	finally
    //   810	819	882	finally
    //   855	864	882	finally
    //   868	879	882	finally
    //   919	924	882	finally
    //   928	939	882	finally
    //   212	240	1009	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.AthenaFileUploadRunnable
 * JD-Core Version:    0.7.0.1
 */