package com.tencent.mobileqq.weiyun.sdk.download;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.api.download.IDownloadListener;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.mobileqq.weiyun.api.download.IFetchListener;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.model.DownloadFile.DownloadServerInfo;
import com.tencent.mobileqq.weiyun.model.DownloadJobContext;
import com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo;
import com.tencent.mobileqq.weiyun.sdk.download.processor.InfoRecorder;
import com.tencent.mobileqq.weiyun.sdk.download.processor.InfoRecorder.InfoRecorderCallback;
import com.tencent.mobileqq.weiyun.sdk.download.processor.LocalProcessor;
import com.tencent.mobileqq.weiyun.sdk.download.processor.LocalProcessor.LocalProcessorCallback;
import com.tencent.mobileqq.weiyun.sdk.download.processor.UrlFetcher;
import com.tencent.mobileqq.weiyun.sdk.download.processor.UrlFetcher.UrlFetcherCallback;
import com.tencent.mobileqq.weiyun.sdk.download.processor.WeiyunNetEngine;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.utils.ThreadPoolWrapper;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.utils.DualHashMap;
import com.tencent.weiyun.utils.IOUtils;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
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
  private IFetchListener jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIFetchListener;
  private final DownloadJobCounter jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadDownloadJobCounter = new DownloadJobCounter();
  private InfoRecorder jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder;
  private LocalProcessor jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorLocalProcessor;
  private UrlFetcher jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorUrlFetcher;
  private final ThreadPoolWrapper jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper = new ThreadPoolWrapper("WyDownloader");
  private final DualHashMap<Long, String> jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap = new DualHashMap();
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap<Long, DownloadJobContext> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<Long> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List<IDownloadStatusListener> jdField_a_of_type_JavaUtilList;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".tmp");
    return localStringBuilder.toString();
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
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.remove(Long.valueOf(paramLong)))
      {
        this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      }
      else if (this.jdField_b_of_type_JavaUtilLinkedList.remove(Long.valueOf(paramLong)))
      {
        b();
      }
      else
      {
        a();
        b();
      }
      return;
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
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null)
      {
        a(paramLong);
        return false;
      }
      if (paramBoolean1) {
        localDownloadJobContext.a(paramBoolean2);
      }
      if (paramBoolean3) {
        localDownloadJobContext.b(paramBoolean4);
      }
      a(localDownloadJobContext, 1, 0, null);
      return true;
    }
  }
  
  /* Error */
  private static boolean a(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 212	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: invokestatic 216	com/tencent/mobileqq/weiyun/utils/WeiyunPathUtil:a	()Ljava/lang/String;
    //   7: invokevirtual 222	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   10: ifne +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_1
    //   16: invokevirtual 225	java/io/File:getName	()Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: invokestatic 230	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil:b	(Ljava/lang/String;)I
    //   24: istore_2
    //   25: iload_2
    //   26: ifeq +15 -> 41
    //   29: iload_2
    //   30: iconst_2
    //   31: if_icmpeq +10 -> 41
    //   34: iload_2
    //   35: iconst_1
    //   36: if_icmpeq +5 -> 41
    //   39: iconst_0
    //   40: ireturn
    //   41: aload_0
    //   42: aload_3
    //   43: invokestatic 236	com/tencent/mobileqq/transfile/filebrowser/MimeTypesTools:getMimeType	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 5
    //   48: new 238	android/content/ContentValues
    //   51: dup
    //   52: invokespecial 239	android/content/ContentValues:<init>	()V
    //   55: astore 4
    //   57: aload 4
    //   59: ldc 241
    //   61: aload_3
    //   62: invokevirtual 244	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload 4
    //   67: ldc 246
    //   69: aload_3
    //   70: invokevirtual 244	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload 4
    //   75: ldc 248
    //   77: aload_1
    //   78: invokevirtual 252	java/io/File:lastModified	()J
    //   81: ldc2_w 253
    //   84: ldiv
    //   85: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   88: invokevirtual 257	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   91: aload 4
    //   93: ldc_w 259
    //   96: aload 5
    //   98: invokevirtual 244	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 4
    //   103: ldc_w 261
    //   106: aload_1
    //   107: invokevirtual 264	java/io/File:length	()J
    //   110: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   113: invokevirtual 257	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   116: iload_2
    //   117: ifne +24 -> 141
    //   120: aload 4
    //   122: ldc_w 266
    //   125: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   128: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   131: invokevirtual 257	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   134: getstatic 277	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   137: astore_3
    //   138: goto +33 -> 171
    //   141: iload_2
    //   142: iconst_2
    //   143: if_icmpne +24 -> 167
    //   146: aload 4
    //   148: ldc_w 266
    //   151: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   154: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   157: invokevirtual 257	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   160: getstatic 280	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   163: astore_3
    //   164: goto +7 -> 171
    //   167: getstatic 283	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   170: astore_3
    //   171: aload_0
    //   172: invokevirtual 289	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   175: astore_0
    //   176: aload_0
    //   177: aload_3
    //   178: aload 4
    //   180: invokevirtual 295	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   183: astore_3
    //   184: aload_3
    //   185: ifnull +145 -> 330
    //   188: aload_0
    //   189: aload_3
    //   190: ldc_w 297
    //   193: invokevirtual 301	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   196: astore 5
    //   198: aload 5
    //   200: ifnull +130 -> 330
    //   203: aconst_null
    //   204: astore 4
    //   206: new 303	java/io/BufferedInputStream
    //   209: dup
    //   210: new 305	java/io/FileInputStream
    //   213: dup
    //   214: aload_1
    //   215: invokespecial 308	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   218: invokespecial 311	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   221: astore_3
    //   222: new 313	java/io/BufferedOutputStream
    //   225: dup
    //   226: new 315	java/io/FileOutputStream
    //   229: dup
    //   230: aload 5
    //   232: invokevirtual 321	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   235: invokespecial 324	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   238: invokespecial 327	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   241: astore_1
    //   242: sipush 8192
    //   245: newarray byte
    //   247: astore_0
    //   248: aload_3
    //   249: aload_0
    //   250: invokevirtual 333	java/io/InputStream:read	([B)I
    //   253: istore_2
    //   254: iload_2
    //   255: ifle +13 -> 268
    //   258: aload_1
    //   259: aload_0
    //   260: iconst_0
    //   261: iload_2
    //   262: invokevirtual 339	java/io/OutputStream:write	([BII)V
    //   265: goto -17 -> 248
    //   268: aload_1
    //   269: invokevirtual 342	java/io/OutputStream:flush	()V
    //   272: aload_3
    //   273: invokestatic 348	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   276: aload_1
    //   277: invokestatic 348	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   280: aload 5
    //   282: invokevirtual 351	android/os/ParcelFileDescriptor:close	()V
    //   285: iconst_1
    //   286: ireturn
    //   287: astore_0
    //   288: goto +16 -> 304
    //   291: astore_0
    //   292: aload 4
    //   294: astore_1
    //   295: goto +9 -> 304
    //   298: astore_0
    //   299: aconst_null
    //   300: astore_3
    //   301: aload 4
    //   303: astore_1
    //   304: aload_3
    //   305: invokestatic 348	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   308: aload_1
    //   309: invokestatic 348	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   312: aload 5
    //   314: invokevirtual 351	android/os/ParcelFileDescriptor:close	()V
    //   317: aload_0
    //   318: athrow
    //   319: astore_0
    //   320: ldc 84
    //   322: iconst_2
    //   323: ldc_w 353
    //   326: aload_0
    //   327: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   330: iconst_0
    //   331: ireturn
    //   332: astore_0
    //   333: iconst_1
    //   334: ireturn
    //   335: astore_1
    //   336: goto -19 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramContext	Context
    //   0	339	1	paramFile	File
    //   24	238	2	i	int
    //   19	286	3	localObject1	Object
    //   55	247	4	localContentValues	android.content.ContentValues
    //   46	267	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   242	248	287	finally
    //   248	254	287	finally
    //   258	265	287	finally
    //   268	272	287	finally
    //   222	242	291	finally
    //   206	222	298	finally
    //   20	25	319	java/lang/Throwable
    //   41	116	319	java/lang/Throwable
    //   120	138	319	java/lang/Throwable
    //   146	164	319	java/lang/Throwable
    //   167	171	319	java/lang/Throwable
    //   171	184	319	java/lang/Throwable
    //   188	198	319	java/lang/Throwable
    //   272	280	319	java/lang/Throwable
    //   304	312	319	java/lang/Throwable
    //   317	319	319	java/lang/Throwable
    //   280	285	332	java/lang/Throwable
    //   312	317	335	java/lang/Throwable
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      int i;
      if (this.jdField_b_of_type_JavaUtilLinkedList.size() < 2) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        Long localLong = (Long)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        NetReq localNetReq = (NetReq)this.jdField_a_of_type_JavaUtilMap.remove(localLong);
        if (localNetReq == null)
        {
          b();
          return;
        }
        DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(localLong);
        if ((localDownloadJobContext != null) && (a(localDownloadJobContext.c())) && (!localDownloadJobContext.d()))
        {
          this.jdField_b_of_type_JavaUtilLinkedList.add(localLong);
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = WeiyunNetEngine.a();
          }
          this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new WyDownloader.6(this, localLong, localNetReq));
          return;
        }
        b();
      }
    }
  }
  
  public int a()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadDownloadJobCounter.a();
    int i = ((DownloadJobCounter)???).d;
    int j = ((DownloadJobCounter)???).c;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashMap.keySet());
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new WyDownloader.7(this, localArrayList));
      }
      return i + j;
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
      return DownloadJobContext.a(localDownloadJobContext.a(), localDownloadJobContext.a().a(), localDownloadJobContext.b(), localDownloadJobContext.a().a());
    }
  }
  
  public DownloadJobCounter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadDownloadJobCounter.a();
  }
  
  public String a(DownloadFile paramDownloadFile, String paramString, IDownloadStatusListener paramIDownloadStatusListener)
  {
    return b(paramDownloadFile, paramString, true, paramIDownloadStatusListener);
  }
  
  public String a(DownloadFile paramDownloadFile, String paramString, boolean paramBoolean, IDownloadStatusListener paramIDownloadStatusListener)
  {
    return b(paramDownloadFile, paramString, paramBoolean, paramIDownloadStatusListener);
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4, IDownloadStatusListener paramIDownloadStatusListener)
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    a(paramString1, paramString2, paramString3, paramString4, new WyDownloader.3(this, paramIDownloadStatusListener, i), Integer.toString(i));
    return Integer.toString(i);
  }
  
  void a(int paramInt, DownloadJobContext paramDownloadJobContext)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
    {
      this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.put(Long.valueOf(paramDownloadJobContext.a()), Integer.toString(paramInt));
      ??? = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)???).hasNext())
      {
        IDownloadStatusListener localIDownloadStatusListener = (IDownloadStatusListener)((Iterator)???).next();
        if (localIDownloadStatusListener != null) {
          localIDownloadStatusListener.a(Integer.toString(paramInt));
        }
      }
      if (paramDownloadJobContext.a() != null) {
        paramDownloadJobContext.a().a(Integer.toString(paramInt));
      }
      return;
    }
    for (;;)
    {
      throw paramDownloadJobContext;
    }
  }
  
  public void a(int paramInt, DownloadJobContext paramDownloadJobContext, String paramString)
  {
    int i;
    label184:
    label190:
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      long l = paramDownloadJobContext.a();
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if (localDownloadJobContext == null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), paramDownloadJobContext);
      }
      else
      {
        if (!localDownloadJobContext.a().a()) {
          break label190;
        }
        paramDownloadJobContext.a().jdField_a_of_type_Int = localDownloadJobContext.a().jdField_a_of_type_Int;
        paramDownloadJobContext.a().jdField_b_of_type_Int = localDownloadJobContext.a().jdField_b_of_type_Int;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), paramDownloadJobContext);
        break label184;
        a(paramInt, paramDownloadJobContext);
        if (i != 0)
        {
          paramDownloadJobContext.b(paramString);
        }
        else
        {
          localDownloadJobContext.a(paramDownloadJobContext.b());
          localDownloadJobContext.b(paramDownloadJobContext.c());
        }
        if (i == 0) {
          paramDownloadJobContext = localDownloadJobContext;
        }
        a(paramDownloadJobContext, 1, 0, null);
        return;
      }
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null) {
        return;
      }
      if (localDownloadJobContext.d()) {
        return;
      }
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
      {
        a(localDownloadJobContext, 5, 1810004, null);
        return;
      }
      a(localDownloadJobContext, 5, paramInt, paramString);
      return;
    }
  }
  
  public void a(long paramLong, DownloadFile.DownloadServerInfo paramDownloadServerInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null) {
        return;
      }
      if (localDownloadJobContext.d()) {
        return;
      }
      if ((paramDownloadServerInfo != null) && (!TextUtils.isEmpty(paramDownloadServerInfo.c)))
      {
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
        return;
      }
      a(localDownloadJobContext, 5, 1829002, null);
      return;
    }
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
  
  public void a(long paramLong, boolean paramBoolean1, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ??? = localDownloadJobContext;
      if (localDownloadJobContext == null)
      {
        if (paramWeiyunDownloadStatusInfo == null) {
          paramWeiyunDownloadStatusInfo = null;
        } else {
          paramWeiyunDownloadStatusInfo = paramWeiyunDownloadStatusInfo.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadJobContext;
        }
        ??? = paramWeiyunDownloadStatusInfo;
        if (paramWeiyunDownloadStatusInfo == null) {
          return;
        }
      }
      a((DownloadJobContext)???, paramBoolean2);
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null) {
        return;
      }
      if (localDownloadJobContext.d()) {
        return;
      }
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
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorUrlFetcher.a(localDownloadJobContext, 0);
      return;
    }
  }
  
  public void a(IDownloadStatusListener paramIDownloadStatusListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramIDownloadStatusListener);
  }
  
  public void a(IFetchListener paramIFetchListener, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIFetchListener = paramIFetchListener;
    if (this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIFetchListener != null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramIFetchListener = new ReleaseLooperHandler("weiyun_download-work-thread");
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder = new InfoRecorder(this, paramIFetchListener);
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorLocalProcessor = new LocalProcessor(this, paramIFetchListener);
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorUrlFetcher = new UrlFetcher(this, this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIFetchListener, paramIFetchListener);
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid());
      return;
    }
    throw new NullPointerException("IFetchListener can not be null!");
  }
  
  void a(DownloadJobContext paramDownloadJobContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadDownloadJobCounter.a();
    this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadDownloadJobCounter.a(paramDownloadJobContext, paramInt1, paramInt2);
  }
  
  void a(DownloadJobContext paramDownloadJobContext, int paramInt1, int paramInt2, String paramString)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    label461:
    int i;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              if (paramInt1 != 5) {
                break label461;
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
                      synchronized (this.jdField_b_of_type_JavaUtilHashSet)
                      {
                        this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(paramDownloadJobContext.a()));
                        paramDownloadJobContext.c(true);
                        if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null) {
                          this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = WeiyunNetEngine.a();
                        }
                        this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq(paramDownloadJobContext.a());
                        paramInt1 = 0;
                      }
                    }
                  }
                }
              }
              if ((paramInt2 != 1810003) && (paramInt2 != 1810004)) {
                synchronized (this.jdField_b_of_type_JavaUtilHashSet)
                {
                  this.jdField_b_of_type_JavaUtilHashSet.add(Long.valueOf(paramDownloadJobContext.a()));
                }
              }
              synchronized (this.jdField_a_of_type_JavaUtilHashSet)
              {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramDownloadJobContext.a()));
                paramInt1 = 1;
                a(paramDownloadJobContext.a());
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
                  synchronized (this.jdField_b_of_type_JavaUtilHashSet)
                  {
                    this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(paramDownloadJobContext.a()));
                    paramDownloadJobContext.a().jdField_b_of_type_JavaLangString = paramDownloadJobContext.d();
                    paramDownloadJobContext.a().jdField_b_of_type_Long = paramDownloadJobContext.a().jdField_a_of_type_Long;
                    paramDownloadJobContext.a().jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadJobContext = paramDownloadJobContext;
                    a(paramDownloadJobContext.a());
                    bool1 = true;
                  }
                }
              }
            }
          }
          bool1 = paramDownloadJobContext.a().b();
          if (bool1) {
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
          break label753;
        }
        bool1 = paramDownloadJobContext.a().c();
        break label753;
      }
      int j = 0;
      i = paramInt1;
      paramInt1 = j;
    }
    else
    {
      a(paramDownloadJobContext.a());
      paramInt1 = 1;
      i = 1;
    }
    boolean bool2;
    if ((paramInt1 == 0) && (!paramDownloadJobContext.a().a())) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    paramInt1 = i;
    boolean bool1 = bool2;
    if (bool2) {
      synchronized (this.jdField_a_of_type_JavaUtilHashSet)
      {
        this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(paramDownloadJobContext.a()));
        synchronized (this.jdField_b_of_type_JavaUtilHashSet)
        {
          this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(paramDownloadJobContext.a()));
          paramDownloadJobContext.c(false);
          this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorLocalProcessor.a(paramDownloadJobContext);
          paramInt1 = i;
          bool1 = bool2;
        }
      }
    }
    label753:
    if (bool1)
    {
      i = paramDownloadJobContext.a().jdField_a_of_type_Int;
      paramDownloadJobContext.a().jdField_a_of_type_Int = paramInt1;
      paramDownloadJobContext.a().jdField_b_of_type_Int = paramInt2;
      paramDownloadJobContext.a().jdField_a_of_type_JavaLangString = DownloadHelper.a(paramInt2, paramString);
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder.a(paramDownloadJobContext, true);
      a(paramDownloadJobContext, i, paramInt1);
    }
  }
  
  void a(DownloadJobContext paramDownloadJobContext, boolean paramBoolean)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      IDownloadStatusListener localIDownloadStatusListener = (IDownloadStatusListener)localIterator.next();
      if (localIDownloadStatusListener != null) {
        localIDownloadStatusListener.a(paramDownloadJobContext.a(), paramDownloadJobContext.a(), paramDownloadJobContext.b(), paramBoolean);
      }
    }
    if (paramDownloadJobContext.a() != null) {
      paramDownloadJobContext.a().a(paramDownloadJobContext.a(), paramDownloadJobContext.a(), paramDownloadJobContext.b(), paramBoolean);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, IDownloadListener paramIDownloadListener)
  {
    a(paramString1, paramString2, null, paramString3, paramIDownloadListener, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, IDownloadListener paramIDownloadListener, String paramString5)
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
    if ((TextUtils.equals(???, WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid())) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          DownloadJobContext localDownloadJobContext = (DownloadJobContext)paramList.next();
          long l = localDownloadJobContext.a();
          int i = localDownloadJobContext.a().jdField_a_of_type_Int;
          localDownloadJobContext.a().jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localDownloadJobContext);
          if ((i != 0) && (i != 1) && (i != 2))
          {
            if (i != 3)
            {
              if (i == 5) {
                a(localDownloadJobContext, 5, localDownloadJobContext.a().jdField_b_of_type_Int, localDownloadJobContext.a().jdField_a_of_type_JavaLangString);
              }
            }
            else {
              a(localDownloadJobContext, 3, 0, null);
            }
          }
          else {
            a(localDownloadJobContext, 1, 0, null);
          }
        }
        return;
      }
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
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        DownloadJobContext localDownloadJobContext = (DownloadJobContext)((Map.Entry)localIterator.next()).getValue();
        if ((localDownloadJobContext.c()) && (paramBoolean2))
        {
          if ((localDownloadJobContext.c()) && (paramBoolean2) && (localDownloadJobContext.a().d())) {
            a(localDownloadJobContext.a(), false, false, false, false);
          }
        }
        else if (localDownloadJobContext.a().b())
        {
          localDownloadJobContext.c(true);
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService != null) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq(localDownloadJobContext.a());
          }
          a(localDownloadJobContext, 5, 1810004, null);
        }
      }
      return;
    }
  }
  
  public boolean a()
  {
    DownloadJobCounter localDownloadJobCounter = this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadDownloadJobCounter.a();
    return localDownloadJobCounter.jdField_a_of_type_Int + localDownloadJobCounter.jdField_b_of_type_Int > 0;
  }
  
  public boolean a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null)
      {
        a(paramLong);
        return false;
      }
      a(localDownloadJobContext, 3, 0, null);
      return true;
    }
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null)
      {
        a(paramLong);
        return false;
      }
      if (paramBoolean1)
      {
        localDownloadJobContext.a(paramBoolean2);
        localDownloadJobContext.b(paramBoolean3);
      }
      a(localDownloadJobContext, 1, 0, null);
      return true;
    }
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
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder.a(paramString.longValue(), true);
      return true;
    }
  }
  
  boolean a(boolean paramBoolean)
  {
    Context localContext = WeiyunTransmissionGlobal.getInstance().getContext();
    boolean bool = WeiyunTransmissionStatus.getInstance().isTranOnlyWifi();
    if ((!paramBoolean) && (bool)) {
      return NetworkUtils.isWifiAvailable(localContext);
    }
    return NetworkUtils.isNetworkAvailable(localContext);
  }
  
  public int b()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadDownloadJobCounter.a();
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
      return i + j + k;
    }
  }
  
  String b(DownloadFile paramDownloadFile, String paramString, boolean paramBoolean, IDownloadStatusListener paramIDownloadStatusListener)
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    paramString = DownloadJobContext.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid(), paramDownloadFile, paramString, new WeiyunDownloadStatusInfo());
    paramString.b(paramBoolean);
    paramString.a().c = paramDownloadFile.jdField_a_of_type_JavaLangString;
    paramString.a(paramIDownloadStatusListener);
    this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder.a(i, paramString);
    return Integer.toString(i);
  }
  
  public void b(IDownloadStatusListener paramIDownloadStatusListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramIDownloadStatusListener)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramIDownloadStatusListener);
    }
  }
  
  public boolean b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorInfoRecorder.a(paramLong, true);
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
    if (paramNetResp.mResult == 3) {
      return;
    }
    int i;
    if (paramNetResp.mResult == 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramNetResp.mErrCode;
    paramNetResp = ((HttpNetReq)paramNetResp.mReq).getUserData();
    if ((paramNetResp != null) && ((paramNetResp instanceof DownloadJobContext)))
    {
      paramNetResp = (DownloadJobContext)paramNetResp;
      if (paramNetResp == null) {
        return;
      }
      if (paramNetResp.d()) {
        return;
      }
      if (i != 0)
      {
        File localFile = new File(paramNetResp.d());
        if (localFile.exists())
        {
          if (!a(WeiyunTransmissionGlobal.getInstance().getContext(), localFile)) {
            IOUtils.scan2MediaStore(WeiyunTransmissionGlobal.getInstance().getContext(), localFile);
          }
          a(paramNetResp, 4, 0, null);
          return;
        }
        a(paramNetResp, 5, 1810031, null);
        return;
      }
      if (paramNetResp.d()) {
        return;
      }
      if (DownloadHelper.a(j))
      {
        a(paramNetResp, 0, j, null);
        return;
      }
      a(paramNetResp, 5, j, null);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = paramNetReq.getUserData();
    if ((paramNetReq != null) && ((paramNetReq instanceof DownloadJobContext)))
    {
      paramNetReq = (DownloadJobContext)paramNetReq;
      if (paramNetReq == null) {
        return;
      }
      if (paramNetReq.d()) {
        return;
      }
      if (paramNetReq.a().c()) {
        a(paramNetReq, 2, 0, null);
      }
      paramNetReq.a().jdField_a_of_type_Long = paramLong2;
      WeiyunDownloadStatusInfo localWeiyunDownloadStatusInfo = paramNetReq.a();
      if (paramLong1 >= paramLong2) {
        paramLong1 = paramLong2;
      }
      localWeiyunDownloadStatusInfo.jdField_b_of_type_Long = paramLong1;
      a(paramNetReq, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.WyDownloader
 * JD-Core Version:    0.7.0.1
 */