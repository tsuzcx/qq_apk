package cooperation.weiyun.sdk.download;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.utils.ThreadPoolWrapper;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.utils.DualHashMap;
import com.tencent.weiyun.utils.IOUtils;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import cooperation.weiyun.sdk.download.processor.InfoRecorder;
import cooperation.weiyun.sdk.download.processor.InfoRecorder.InfoRecorderCallback;
import cooperation.weiyun.sdk.download.processor.LocalProcessor;
import cooperation.weiyun.sdk.download.processor.LocalProcessor.LocalProcessorCallback;
import cooperation.weiyun.sdk.download.processor.UrlFetcher;
import cooperation.weiyun.sdk.download.processor.UrlFetcher.UrlFetcherCallback;
import cooperation.weiyun.sdk.download.processor.WeiyunNetEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class WyDownloader
  implements INetEngineListener, InfoRecorder.InfoRecorderCallback, LocalProcessor.LocalProcessorCallback, UrlFetcher.UrlFetcherCallback
{
  private static Singleton<WyDownloader, Void> jdField_a_of_type_ComTencentWeiyunUtilsSingleton = new WyDownloader.1();
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private Context jdField_a_of_type_AndroidContentContext;
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  private final ThreadPoolWrapper jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper = new ThreadPoolWrapper("WyDownloader");
  private final DualHashMap<Long, String> jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap = new DualHashMap();
  private final DownloadJobCounter jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobCounter = new DownloadJobCounter();
  private WyDownloader.IFetchListener jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IFetchListener;
  private InfoRecorder jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder;
  private LocalProcessor jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorLocalProcessor;
  private UrlFetcher jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap<Long, DownloadJobContext> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<Long> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List<WyDownloader.IDownloadStatusListener> jdField_a_of_type_JavaUtilList;
  private Map<Long, NetReq> jdField_a_of_type_JavaUtilMap = new HashMap();
  private IHttpEngineService jdField_b_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  private final HashSet<Long> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<Long> jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<String, HttpNetReq> jdField_b_of_type_JavaUtilMap = new HashMap();
  
  private WyDownloader()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, new WyDownloader.2(this));
  }
  
  public static WyDownloader a()
  {
    return (WyDownloader)jdField_a_of_type_ComTencentWeiyunUtilsSingleton.get(null);
  }
  
  private String a(String paramString1, String paramString2)
  {
    return paramString1 + "." + paramString2 + ".tmp";
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      if (localObject == null)
      {
        localIterator.remove();
      }
      else
      {
        localObject = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        if ((localObject == null) || (((DownloadJobContext)localObject).d())) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.remove(Long.valueOf(paramLong)))
        {
          this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
          return;
        }
        if (this.jdField_b_of_type_JavaUtilLinkedList.remove(Long.valueOf(paramLong))) {
          b();
        }
      }
      a();
      b();
    }
  }
  
  private void a(long paramLong, NetReq paramNetReq)
  {
    if (paramNetReq == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(Long.valueOf(paramLong));
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), paramNetReq);
      a();
      b();
      return;
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext1 = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    if (paramBoolean1) {
      localDownloadJobContext2.a(paramBoolean2);
    }
    if (paramBoolean3) {
      localDownloadJobContext2.b(paramBoolean4);
    }
    a(localDownloadJobContext2, 1, 0, null);
    return true;
  }
  
  /* Error */
  private static boolean a(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokevirtual 212	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   7: invokestatic 216	cooperation/weiyun/utils/WeiyunPathUtil:a	()Ljava/lang/String;
    //   10: invokevirtual 222	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13: ifne +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_1
    //   19: invokevirtual 225	java/io/File:getName	()Ljava/lang/String;
    //   22: astore_3
    //   23: aload_3
    //   24: invokestatic 230	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +13 -> 42
    //   32: iload_2
    //   33: iconst_2
    //   34: if_icmpeq +8 -> 42
    //   37: iload_2
    //   38: iconst_1
    //   39: if_icmpne -23 -> 16
    //   42: aload_0
    //   43: aload_3
    //   44: invokestatic 236	com/tencent/mobileqq/transfile/filebrowser/MimeTypesTools:getMimeType	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 6
    //   49: new 238	android/content/ContentValues
    //   52: dup
    //   53: invokespecial 239	android/content/ContentValues:<init>	()V
    //   56: astore 5
    //   58: aload 5
    //   60: ldc 241
    //   62: aload_3
    //   63: invokevirtual 244	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload 5
    //   68: ldc 246
    //   70: aload_3
    //   71: invokevirtual 244	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 5
    //   76: ldc 248
    //   78: aload_1
    //   79: invokevirtual 252	java/io/File:lastModified	()J
    //   82: ldc2_w 253
    //   85: ldiv
    //   86: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: invokevirtual 257	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   92: aload 5
    //   94: ldc_w 259
    //   97: aload 6
    //   99: invokevirtual 244	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload 5
    //   104: ldc_w 261
    //   107: aload_1
    //   108: invokevirtual 264	java/io/File:length	()J
    //   111: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: invokevirtual 257	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   117: iload_2
    //   118: ifne +150 -> 268
    //   121: aload 5
    //   123: ldc_w 266
    //   126: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   129: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   132: invokevirtual 257	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   135: getstatic 277	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   138: astore_3
    //   139: aload_0
    //   140: invokevirtual 283	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   143: astore_0
    //   144: aload_0
    //   145: aload_3
    //   146: aload 5
    //   148: invokevirtual 289	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull -137 -> 16
    //   156: aload_0
    //   157: aload_3
    //   158: ldc_w 291
    //   161: invokevirtual 295	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   164: astore 5
    //   166: aload 5
    //   168: ifnull -152 -> 16
    //   171: new 297	java/io/BufferedInputStream
    //   174: dup
    //   175: new 299	java/io/FileInputStream
    //   178: dup
    //   179: aload_1
    //   180: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   183: invokespecial 305	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   186: astore_0
    //   187: new 307	java/io/BufferedOutputStream
    //   190: dup
    //   191: new 309	java/io/FileOutputStream
    //   194: dup
    //   195: aload 5
    //   197: invokevirtual 315	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   200: invokespecial 318	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   203: invokespecial 321	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   206: astore_1
    //   207: sipush 8192
    //   210: newarray byte
    //   212: astore_3
    //   213: aload_0
    //   214: aload_3
    //   215: invokevirtual 327	java/io/InputStream:read	([B)I
    //   218: istore_2
    //   219: iload_2
    //   220: ifle +81 -> 301
    //   223: aload_1
    //   224: aload_3
    //   225: iconst_0
    //   226: iload_2
    //   227: invokevirtual 333	java/io/OutputStream:write	([BII)V
    //   230: goto -17 -> 213
    //   233: astore 4
    //   235: aload_0
    //   236: astore_3
    //   237: aload 4
    //   239: astore_0
    //   240: aload_3
    //   241: invokestatic 339	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   244: aload_1
    //   245: invokestatic 339	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   248: aload 5
    //   250: invokevirtual 342	android/os/ParcelFileDescriptor:close	()V
    //   253: aload_0
    //   254: athrow
    //   255: astore_0
    //   256: ldc 84
    //   258: iconst_2
    //   259: ldc_w 344
    //   262: aload_0
    //   263: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: iconst_0
    //   267: ireturn
    //   268: iload_2
    //   269: iconst_2
    //   270: if_icmpne +24 -> 294
    //   273: aload 5
    //   275: ldc_w 266
    //   278: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   281: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   284: invokevirtual 257	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   287: getstatic 353	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   290: astore_3
    //   291: goto -152 -> 139
    //   294: getstatic 356	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   297: astore_3
    //   298: goto -159 -> 139
    //   301: aload_1
    //   302: invokevirtual 359	java/io/OutputStream:flush	()V
    //   305: aload_0
    //   306: invokestatic 339	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   309: aload_1
    //   310: invokestatic 339	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   313: aload 5
    //   315: invokevirtual 342	android/os/ParcelFileDescriptor:close	()V
    //   318: iconst_1
    //   319: ireturn
    //   320: astore_0
    //   321: goto -3 -> 318
    //   324: astore_1
    //   325: goto -72 -> 253
    //   328: astore_0
    //   329: aconst_null
    //   330: astore_1
    //   331: aload 4
    //   333: astore_3
    //   334: goto -94 -> 240
    //   337: astore 4
    //   339: aconst_null
    //   340: astore_1
    //   341: aload_0
    //   342: astore_3
    //   343: aload 4
    //   345: astore_0
    //   346: goto -106 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramContext	Context
    //   0	349	1	paramFile	File
    //   27	244	2	i	int
    //   22	321	3	localObject1	Object
    //   1	1	4	localObject2	Object
    //   233	99	4	localObject3	Object
    //   337	7	4	localObject4	Object
    //   56	258	5	localObject5	Object
    //   47	51	6	str	String
    // Exception table:
    //   from	to	target	type
    //   207	213	233	finally
    //   213	219	233	finally
    //   223	230	233	finally
    //   301	305	233	finally
    //   23	28	255	java/lang/Throwable
    //   42	117	255	java/lang/Throwable
    //   121	139	255	java/lang/Throwable
    //   139	152	255	java/lang/Throwable
    //   156	166	255	java/lang/Throwable
    //   240	248	255	java/lang/Throwable
    //   253	255	255	java/lang/Throwable
    //   273	291	255	java/lang/Throwable
    //   294	298	255	java/lang/Throwable
    //   305	313	255	java/lang/Throwable
    //   313	318	320	java/lang/Throwable
    //   248	253	324	java/lang/Throwable
    //   171	187	328	finally
    //   187	207	337	finally
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      if (this.jdField_b_of_type_JavaUtilLinkedList.size() >= 2) {
        break label62;
      }
    }
    Long localLong;
    NetReq localNetReq;
    label62:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localLong = (Long)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localNetReq = (NetReq)this.jdField_a_of_type_JavaUtilMap.remove(localLong);
        if (localNetReq != null) {
          break;
        }
        b();
      }
      return;
    }
    DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(localLong);
    if ((localDownloadJobContext == null) || (!a(localDownloadJobContext.c())) || (localDownloadJobContext.d()))
    {
      b();
      return;
    }
    this.jdField_b_of_type_JavaUtilLinkedList.add(localLong);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = WeiyunNetEngine.a();
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new WyDownloader.6(this, localLong, localNetReq));
  }
  
  public int a()
  {
    ??? = this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobCounter.a();
    int i = ((DownloadJobCounter)???).d;
    int j = ((DownloadJobCounter)???).c;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashMap.keySet());
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new WyDownloader.7(this, localArrayList));
      }
      return j + i;
    }
  }
  
  public DownloadJobContext a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null) {
        return null;
      }
    }
    return DownloadJobContext.a(localObject.a(), localObject.a().a(), localObject.b(), localObject.a().a());
  }
  
  public DownloadJobCounter a()
  {
    return this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobCounter.a();
  }
  
  public String a(DownloadFile paramDownloadFile, String paramString, WyDownloader.IDownloadStatusListener paramIDownloadStatusListener)
  {
    return b(paramDownloadFile, paramString, true, paramIDownloadStatusListener);
  }
  
  public String a(DownloadFile paramDownloadFile, String paramString, boolean paramBoolean, WyDownloader.IDownloadStatusListener paramIDownloadStatusListener)
  {
    return b(paramDownloadFile, paramString, paramBoolean, paramIDownloadStatusListener);
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4, WyDownloader.IDownloadStatusListener paramIDownloadStatusListener)
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    a(paramString1, paramString2, paramString3, paramString4, new WyDownloader.3(this, paramIDownloadStatusListener, i), Integer.toString(i));
    return Integer.toString(i);
  }
  
  void a(int paramInt, DownloadJobContext paramDownloadJobContext)
  {
    if (paramDownloadJobContext == null) {}
    do
    {
      return;
      synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
      {
        this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.put(Long.valueOf(paramDownloadJobContext.a()), Integer.toString(paramInt));
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)???).hasNext())
        {
          WyDownloader.IDownloadStatusListener localIDownloadStatusListener = (WyDownloader.IDownloadStatusListener)((Iterator)???).next();
          if (localIDownloadStatusListener != null) {
            localIDownloadStatusListener.a(Integer.toString(paramInt));
          }
        }
      }
    } while (paramDownloadJobContext.a() == null);
    paramDownloadJobContext.a().a(Integer.toString(paramInt));
  }
  
  public void a(int paramInt, DownloadJobContext paramDownloadJobContext, String paramString)
  {
    for (;;)
    {
      DownloadJobContext localDownloadJobContext;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        long l = paramDownloadJobContext.a();
        localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
        if (localDownloadJobContext == null)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), paramDownloadJobContext);
          i = 1;
          a(paramInt, paramDownloadJobContext);
          if (i != 0)
          {
            paramDownloadJobContext.b(paramString);
            if (i == 0) {
              break label175;
            }
            a(paramDownloadJobContext, 1, 0, null);
          }
        }
        else
        {
          if (!localDownloadJobContext.a().a()) {
            break label181;
          }
          paramDownloadJobContext.a().jdField_a_of_type_Int = localDownloadJobContext.a().jdField_a_of_type_Int;
          paramDownloadJobContext.a().jdField_b_of_type_Int = localDownloadJobContext.a().jdField_b_of_type_Int;
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), paramDownloadJobContext);
          i = 1;
        }
      }
      localDownloadJobContext.a(paramDownloadJobContext.b());
      localDownloadJobContext.b(paramDownloadJobContext.c());
      continue;
      label175:
      paramDownloadJobContext = localDownloadJobContext;
      continue;
      label181:
      int i = 0;
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    DownloadJobContext localDownloadJobContext;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null) {
        return;
      }
    }
    if (!localDownloadJobContext.d())
    {
      if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
      {
        a(localDownloadJobContext, 5, 1810004, null);
        return;
      }
      a(localDownloadJobContext, 5, paramInt, paramString);
    }
  }
  
  public void a(long paramLong, DownloadFile.DownloadServerInfo paramDownloadServerInfo)
  {
    DownloadJobContext localDownloadJobContext;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null) {
        return;
      }
    }
    if (!localDownloadJobContext.d())
    {
      if ((paramDownloadServerInfo == null) || (TextUtils.isEmpty(paramDownloadServerInfo.c)))
      {
        a(localDownloadJobContext, 5, 1829002, null);
        return;
      }
      if (!a(localDownloadJobContext.c()))
      {
        a(localDownloadJobContext, 5, 1810004, null);
        return;
      }
      ??? = DownloadJobContext.a(localDownloadJobContext, paramDownloadServerInfo.c, localDownloadJobContext.d(), paramDownloadServerInfo.jdField_b_of_type_JavaLangString, true, this, a(localDownloadJobContext.d(), localDownloadJobContext.a().jdField_a_of_type_JavaLangString));
      localDownloadJobContext.a((HttpNetReq)???);
      localDownloadJobContext.a(paramDownloadServerInfo.e);
      localDownloadJobContext.a().d = paramDownloadServerInfo.e;
      a(paramLong, (NetReq)???);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, DownloadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ??? = localDownloadJobContext;
      if (localDownloadJobContext != null) {
        break label66;
      }
      if (paramStatusInfo == null) {
        paramStatusInfo = null;
      }
    }
    paramStatusInfo = paramStatusInfo.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobContext;
    label66:
    do
    {
      a((DownloadJobContext)???, paramBoolean2);
      return;
      ??? = paramStatusInfo;
    } while (paramStatusInfo != null);
  }
  
  public void a(long paramLong, boolean paramBoolean, DownloadJobContext paramDownloadJobContext)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext != null) {
        a(localDownloadJobContext, 5, 1810002, null);
      }
      if (paramDownloadJobContext != null)
      {
        paramDownloadJobContext.a().jdField_a_of_type_Int = 0;
        paramDownloadJobContext.a().jdField_b_of_type_Int = 1810002;
        a(paramDownloadJobContext, true);
      }
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    DownloadJobContext localDownloadJobContext;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null) {
        return;
      }
    }
    if (!localDownloadJobContext.d())
    {
      localDownloadJobContext.b(paramString);
      if (paramBoolean1)
      {
        a(localDownloadJobContext, 4, 0, null);
        return;
      }
      if (paramBoolean2)
      {
        a(localDownloadJobContext, 5, 1810008, null);
        return;
      }
      if (paramBoolean3)
      {
        a(localDownloadJobContext, 5, 1810031, null);
        return;
      }
      if (!a(localDownloadJobContext.c()))
      {
        a(localDownloadJobContext, 5, 1810004, null);
        return;
      }
      this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher.a(localDownloadJobContext, 0);
    }
  }
  
  void a(DownloadJobContext paramDownloadJobContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobCounter.a();
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobCounter.a(paramDownloadJobContext, paramInt1, paramInt2);
  }
  
  void a(DownloadJobContext paramDownloadJobContext, int paramInt1, int paramInt2, String paramString)
  {
    if (paramDownloadJobContext == null) {}
    boolean bool;
    label47:
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        bool = true;
      }
    } while (!bool);
    int i = paramDownloadJobContext.a().jdField_a_of_type_Int;
    paramDownloadJobContext.a().jdField_a_of_type_Int = paramInt1;
    paramDownloadJobContext.a().jdField_b_of_type_Int = paramInt2;
    paramDownloadJobContext.a().jdField_a_of_type_JavaLangString = DownloadHelper.a(paramInt2, paramString);
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder.a(paramDownloadJobContext, true);
    a(paramDownloadJobContext, i, paramInt1);
    return;
    a(paramDownloadJobContext.a());
    i = 1;
    paramInt1 = 1;
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            if ((i != 0) || (paramDownloadJobContext.a().a()))
            {
              bool = true;
              label139:
              if (!bool) {
                break label793;
              }
              synchronized (this.jdField_a_of_type_JavaUtilHashSet)
              {
                this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(paramDownloadJobContext.a()));
              }
            }
            synchronized (this.jdField_b_of_type_JavaUtilHashSet)
            {
              this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(paramDownloadJobContext.a()));
              paramDownloadJobContext.c(false);
              this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorLocalProcessor.a(paramDownloadJobContext);
              break;
              bool = false;
              break label139;
              paramDownloadJobContext = finally;
              throw paramDownloadJobContext;
            }
          }
          bool = paramDownloadJobContext.a().c();
          break;
          bool = paramDownloadJobContext.a().b();
          if (!bool) {
            break label790;
          }
          synchronized (this.jdField_a_of_type_JavaUtilHashSet)
          {
            this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(paramDownloadJobContext.a()));
            paramDownloadJobContext.c(true);
            paramDownloadJobContext.b(false);
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = WeiyunNetEngine.a();
            }
            this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq(paramDownloadJobContext.a());
            a(paramDownloadJobContext.a());
          }
        }
        if (paramInt2 == 1810002) {
          synchronized (this.jdField_a_of_type_JavaUtilHashMap)
          {
            this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramDownloadJobContext.a()));
            synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
            {
              this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.removeByKey(Long.valueOf(paramDownloadJobContext.a()));
              synchronized (this.jdField_a_of_type_JavaUtilHashSet)
              {
                this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(paramDownloadJobContext.a()));
              }
            }
          }
        }
        for (;;)
        {
          synchronized (this.jdField_b_of_type_JavaUtilHashSet)
          {
            this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(paramDownloadJobContext.a()));
            paramDownloadJobContext.c(true);
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = WeiyunNetEngine.a();
            }
            this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq(paramDownloadJobContext.a());
            paramInt1 = 0;
            a(paramDownloadJobContext.a());
            bool = true;
            break;
            paramDownloadJobContext = finally;
            throw paramDownloadJobContext;
            paramDownloadJobContext = finally;
            throw paramDownloadJobContext;
            paramDownloadJobContext = finally;
            throw paramDownloadJobContext;
          }
          if ((paramInt2 == 1810003) || (paramInt2 == 1810004)) {
            synchronized (this.jdField_a_of_type_JavaUtilHashSet)
            {
              this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramDownloadJobContext.a()));
              paramInt1 = 1;
            }
          }
          synchronized (this.jdField_b_of_type_JavaUtilHashSet)
          {
            this.jdField_b_of_type_JavaUtilHashSet.add(Long.valueOf(paramDownloadJobContext.a()));
          }
        }
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramDownloadJobContext.a()));
          synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
          {
            this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.removeByKey(Long.valueOf(paramDownloadJobContext.a()));
            synchronized (this.jdField_a_of_type_JavaUtilHashSet)
            {
              this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(paramDownloadJobContext.a()));
            }
          }
        }
        synchronized (this.jdField_b_of_type_JavaUtilHashSet)
        {
          this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(paramDownloadJobContext.a()));
          paramDownloadJobContext.a().jdField_b_of_type_JavaLangString = paramDownloadJobContext.d();
          paramDownloadJobContext.a().jdField_b_of_type_Long = paramDownloadJobContext.a().jdField_a_of_type_Long;
          paramDownloadJobContext.a().jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobContext = paramDownloadJobContext;
          a(paramDownloadJobContext.a());
          break;
          paramDownloadJobContext = finally;
          throw paramDownloadJobContext;
          paramDownloadJobContext = finally;
          throw paramDownloadJobContext;
          paramDownloadJobContext = finally;
          throw paramDownloadJobContext;
        }
      }
      label790:
      break label47;
      label793:
      break label47;
      i = 0;
    }
  }
  
  void a(DownloadJobContext paramDownloadJobContext, boolean paramBoolean)
  {
    if (paramDownloadJobContext == null) {}
    do
    {
      return;
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      while (localIterator.hasNext())
      {
        WyDownloader.IDownloadStatusListener localIDownloadStatusListener = (WyDownloader.IDownloadStatusListener)localIterator.next();
        if (localIDownloadStatusListener != null) {
          localIDownloadStatusListener.a(paramDownloadJobContext.a(), paramDownloadJobContext.a(), paramDownloadJobContext.b(), paramBoolean);
        }
      }
    } while (paramDownloadJobContext.a() == null);
    paramDownloadJobContext.a().a(paramDownloadJobContext.a(), paramDownloadJobContext.a(), paramDownloadJobContext.b(), paramBoolean);
  }
  
  public void a(WyDownloader.IDownloadStatusListener paramIDownloadStatusListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramIDownloadStatusListener);
  }
  
  public void a(WyDownloader.IFetchListener paramIFetchListener, Context paramContext)
  {
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IFetchListener = paramIFetchListener;
    if (this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IFetchListener == null) {
      throw new NullPointerException("IFetchListener can not be null!");
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramIFetchListener = new ReleaseLooperHandler("weiyun_download-work-thread");
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder = new InfoRecorder(this, paramIFetchListener);
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorLocalProcessor = new LocalProcessor(this, paramIFetchListener);
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher = new UrlFetcher(this, this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IFetchListener, paramIFetchListener);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, WyDownloader.IDownloadListener paramIDownloadListener)
  {
    a(paramString1, paramString2, null, paramString3, paramIDownloadListener, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, WyDownloader.IDownloadListener paramIDownloadListener, String paramString5)
  {
    paramString1 = DownloadJobContext.a(paramString4, paramString1, paramString2, paramString3, true, new WyDownloader.4(this, paramIDownloadListener, paramString4, paramString2));
    if (this.jdField_b_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null) {
      this.jdField_b_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = WeiyunNetEngine.b();
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new WyDownloader.5(this, paramString1));
    if (paramString5 != null) {
      this.jdField_b_of_type_JavaUtilMap.put(paramString5, paramString1);
    }
  }
  
  public void a(String arg1, List<DownloadJobContext> paramList)
  {
    if ((!TextUtils.equals(???, WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid())) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    for (;;)
    {
      DownloadJobContext localDownloadJobContext;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label199;
        }
        localDownloadJobContext = (DownloadJobContext)paramList.next();
        long l = localDownloadJobContext.a();
        int i = localDownloadJobContext.a().jdField_a_of_type_Int;
        localDownloadJobContext.a().jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localDownloadJobContext);
        switch (i)
        {
        case 0: 
        case 1: 
        case 2: 
          a(localDownloadJobContext, 1, 0, null);
        }
      }
      a(localDownloadJobContext, 3, 0, null);
      continue;
      a(localDownloadJobContext, 5, localDownloadJobContext.a().jdField_b_of_type_Int, localDownloadJobContext.a().jdField_a_of_type_JavaLangString);
      continue;
      label199:
      return;
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.jdField_a_of_type_JavaUtilHashSet)
      {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashSet);
        ??? = localArrayList.iterator();
        if (!((Iterator)???).hasNext()) {
          return;
        }
        a(((Long)((Iterator)???).next()).longValue(), false, false, false, false);
      }
    }
    for (;;)
    {
      DownloadJobContext localDownloadJobContext;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localDownloadJobContext = (DownloadJobContext)((Map.Entry)localIterator.next()).getValue();
        if ((!localDownloadJobContext.c()) || (!paramBoolean2))
        {
          if (!localDownloadJobContext.a().b()) {
            continue;
          }
          localDownloadJobContext.c(true);
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService != null) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq(localDownloadJobContext.a());
          }
          a(localDownloadJobContext, 5, 1810004, null);
        }
      }
      if ((localDownloadJobContext.c()) && (paramBoolean2) && (localDownloadJobContext.a().d())) {
        a(localDownloadJobContext.a(), false, false, false, false);
      }
    }
  }
  
  public boolean a()
  {
    DownloadJobCounter localDownloadJobCounter = this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobCounter.a();
    int i = localDownloadJobCounter.jdField_a_of_type_Int;
    return localDownloadJobCounter.jdField_b_of_type_Int + i > 0;
  }
  
  public boolean a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext1 = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    a(localDownloadJobContext2, 3, 0, null);
    return true;
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext1 = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    if (paramBoolean1)
    {
      localDownloadJobContext2.a(paramBoolean2);
      localDownloadJobContext2.b(paramBoolean3);
    }
    a(localDownloadJobContext2, 1, 0, null);
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqTransfileApiIHttpEngineService != null)
    {
      ??? = (HttpNetReq)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (??? != null) {
        this.jdField_b_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq((NetReq)???);
      }
    }
    synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
    {
      paramString = (Long)this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.getByValue(paramString);
      if (paramString == null) {
        return false;
      }
    }
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder.a(paramString.longValue(), true);
    return true;
  }
  
  boolean a(boolean paramBoolean)
  {
    Context localContext = WeiyunTransmissionGlobal.getInstance().getContext();
    boolean bool = WeiyunTransmissionStatus.getInstance().isTranOnlyWifi();
    if ((paramBoolean) || (!bool)) {
      return NetworkUtils.isNetworkAvailable(localContext);
    }
    return NetworkUtils.isWifiAvailable(localContext);
  }
  
  public int b()
  {
    ??? = this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobCounter.a();
    int i = ((DownloadJobCounter)???).d;
    int j = ((DownloadJobCounter)???).jdField_a_of_type_Int;
    int k = ((DownloadJobCounter)???).jdField_b_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashMap.keySet());
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new WyDownloader.8(this, localArrayList));
      }
      return k + (i + j);
    }
  }
  
  String b(DownloadFile paramDownloadFile, String paramString, boolean paramBoolean, WyDownloader.IDownloadStatusListener paramIDownloadStatusListener)
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    paramString = DownloadJobContext.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid(), paramDownloadFile, paramString, new DownloadJobContext.StatusInfo());
    paramString.b(paramBoolean);
    paramString.a().c = paramDownloadFile.jdField_a_of_type_JavaLangString;
    paramString.a(paramIDownloadStatusListener);
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder.a(i, paramString);
    return Integer.toString(i);
  }
  
  public void b(WyDownloader.IDownloadStatusListener paramIDownloadStatusListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramIDownloadStatusListener)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramIDownloadStatusListener);
    }
  }
  
  public boolean b(long paramLong)
  {
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder.a(paramLong, true);
    return true;
  }
  
  public int c()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_b_of_type_JavaUtilHashSet)
    {
      int i = this.jdField_b_of_type_JavaUtilHashSet.size();
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilHashSet);
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new WyDownloader.9(this, localArrayList));
      }
      return i;
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {}
    int j;
    label125:
    do
    {
      return;
      if (paramNetResp.mResult == 0) {}
      for (int i = 1;; i = 0)
      {
        j = paramNetResp.mErrCode;
        paramNetResp = ((HttpNetReq)paramNetResp.mReq).getUserData();
        if ((paramNetResp == null) || (!(paramNetResp instanceof DownloadJobContext))) {
          break;
        }
        paramNetResp = (DownloadJobContext)paramNetResp;
        if ((paramNetResp == null) || (paramNetResp.d())) {
          break;
        }
        if (i == 0) {
          break label136;
        }
        File localFile = new File(paramNetResp.d());
        if (!localFile.exists()) {
          break label125;
        }
        if (!a(WeiyunTransmissionGlobal.getInstance().getContext(), localFile)) {
          IOUtils.scan2MediaStore(WeiyunTransmissionGlobal.getInstance().getContext(), localFile);
        }
        a(paramNetResp, 4, 0, null);
        return;
      }
      a(paramNetResp, 5, 1810031, null);
      return;
    } while (paramNetResp.d());
    label136:
    if (DownloadHelper.a(j))
    {
      a(paramNetResp, 0, j, null);
      return;
    }
    a(paramNetResp, 5, j, null);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = paramNetReq.getUserData();
    if ((paramNetReq != null) && ((paramNetReq instanceof DownloadJobContext)))
    {
      paramNetReq = (DownloadJobContext)paramNetReq;
      if (paramNetReq != null) {
        break label26;
      }
    }
    label26:
    while (paramNetReq.d()) {
      return;
    }
    if (paramNetReq.a().c()) {
      a(paramNetReq, 2, 0, null);
    }
    paramNetReq.a().jdField_a_of_type_Long = paramLong2;
    DownloadJobContext.StatusInfo localStatusInfo = paramNetReq.a();
    if (paramLong1 < paramLong2) {}
    for (;;)
    {
      localStatusInfo.jdField_b_of_type_Long = paramLong1;
      a(paramNetReq, false);
      return;
      paramLong1 = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.WyDownloader
 * JD-Core Version:    0.7.0.1
 */