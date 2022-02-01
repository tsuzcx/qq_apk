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
  private static final AtomicInteger f = new AtomicInteger(0);
  private static Singleton<WyDownloader, Void> u = new WyDownloader.1();
  private final HashMap<Long, DownloadJobContext> a = new HashMap();
  private final DualHashMap<Long, String> b = new DualHashMap();
  private final HashSet<Long> c = new HashSet();
  private final HashSet<Long> d = new HashSet();
  private final ThreadPoolWrapper e = new ThreadPoolWrapper("WyDownloader");
  private final DownloadJobCounter g = new DownloadJobCounter();
  private IFetchListener h;
  private List<IDownloadStatusListener> i;
  private InfoRecorder j;
  private LocalProcessor k;
  private UrlFetcher l;
  private IHttpEngineService m;
  private IHttpEngineService n;
  private Context o;
  private Object p = new Object();
  private LinkedList<Long> q = new LinkedList();
  private LinkedList<Long> r = new LinkedList();
  private Map<Long, NetReq> s = new HashMap();
  private Map<String, HttpNetReq> t = new HashMap();
  
  private WyDownloader()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.o, new WyDownloader.2(this));
  }
  
  public static WyDownloader a()
  {
    return (WyDownloader)u.get(null);
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
  
  private void a(long paramLong, NetReq paramNetReq)
  {
    if (paramNetReq == null) {
      return;
    }
    synchronized (this.p)
    {
      this.q.add(Long.valueOf(paramLong));
      this.s.put(Long.valueOf(paramLong), paramNetReq);
      g();
      h();
      return;
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    synchronized (this.a)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.a.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null)
      {
        d(paramLong);
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
    //   1: invokevirtual 206	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: invokestatic 210	com/tencent/mobileqq/weiyun/utils/WeiyunPathUtil:a	()Ljava/lang/String;
    //   7: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   10: ifne +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_1
    //   16: invokevirtual 219	java/io/File:getName	()Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: invokestatic 224	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil:k	(Ljava/lang/String;)I
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
    //   43: invokestatic 230	com/tencent/mobileqq/transfile/filebrowser/MimeTypesTools:getMimeType	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 5
    //   48: new 232	android/content/ContentValues
    //   51: dup
    //   52: invokespecial 233	android/content/ContentValues:<init>	()V
    //   55: astore 4
    //   57: aload 4
    //   59: ldc 235
    //   61: aload_3
    //   62: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload 4
    //   67: ldc 240
    //   69: aload_3
    //   70: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload 4
    //   75: ldc 242
    //   77: aload_1
    //   78: invokevirtual 246	java/io/File:lastModified	()J
    //   81: ldc2_w 247
    //   84: ldiv
    //   85: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   88: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   91: aload 4
    //   93: ldc 253
    //   95: aload 5
    //   97: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload 4
    //   102: ldc 255
    //   104: aload_1
    //   105: invokevirtual 258	java/io/File:length	()J
    //   108: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   114: iload_2
    //   115: ifne +24 -> 139
    //   118: aload 4
    //   120: ldc_w 260
    //   123: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   126: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   129: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   132: getstatic 271	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   135: astore_3
    //   136: goto +33 -> 169
    //   139: iload_2
    //   140: iconst_2
    //   141: if_icmpne +24 -> 165
    //   144: aload 4
    //   146: ldc_w 260
    //   149: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   152: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   158: getstatic 274	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   161: astore_3
    //   162: goto +7 -> 169
    //   165: getstatic 277	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   168: astore_3
    //   169: aload_0
    //   170: invokevirtual 283	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   173: astore_0
    //   174: aload_0
    //   175: aload_3
    //   176: aload 4
    //   178: invokevirtual 289	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   181: astore_3
    //   182: aload_3
    //   183: ifnull +145 -> 328
    //   186: aload_0
    //   187: aload_3
    //   188: ldc_w 291
    //   191: invokevirtual 295	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   194: astore 5
    //   196: aload 5
    //   198: ifnull +130 -> 328
    //   201: aconst_null
    //   202: astore 4
    //   204: new 297	java/io/BufferedInputStream
    //   207: dup
    //   208: new 299	java/io/FileInputStream
    //   211: dup
    //   212: aload_1
    //   213: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   216: invokespecial 305	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   219: astore_3
    //   220: new 307	java/io/BufferedOutputStream
    //   223: dup
    //   224: new 309	java/io/FileOutputStream
    //   227: dup
    //   228: aload 5
    //   230: invokevirtual 315	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   233: invokespecial 318	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   236: invokespecial 321	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   239: astore_1
    //   240: sipush 8192
    //   243: newarray byte
    //   245: astore_0
    //   246: aload_3
    //   247: aload_0
    //   248: invokevirtual 327	java/io/InputStream:read	([B)I
    //   251: istore_2
    //   252: iload_2
    //   253: ifle +13 -> 266
    //   256: aload_1
    //   257: aload_0
    //   258: iconst_0
    //   259: iload_2
    //   260: invokevirtual 333	java/io/OutputStream:write	([BII)V
    //   263: goto -17 -> 246
    //   266: aload_1
    //   267: invokevirtual 336	java/io/OutputStream:flush	()V
    //   270: aload_3
    //   271: invokestatic 342	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   274: aload_1
    //   275: invokestatic 342	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   278: aload 5
    //   280: invokevirtual 345	android/os/ParcelFileDescriptor:close	()V
    //   283: iconst_1
    //   284: ireturn
    //   285: astore_0
    //   286: goto +16 -> 302
    //   289: astore_0
    //   290: aload 4
    //   292: astore_1
    //   293: goto +9 -> 302
    //   296: astore_0
    //   297: aconst_null
    //   298: astore_3
    //   299: aload 4
    //   301: astore_1
    //   302: aload_3
    //   303: invokestatic 342	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   306: aload_1
    //   307: invokestatic 342	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   310: aload 5
    //   312: invokevirtual 345	android/os/ParcelFileDescriptor:close	()V
    //   315: aload_0
    //   316: athrow
    //   317: astore_0
    //   318: ldc 103
    //   320: iconst_2
    //   321: ldc_w 347
    //   324: aload_0
    //   325: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   328: iconst_0
    //   329: ireturn
    //   330: astore_0
    //   331: iconst_1
    //   332: ireturn
    //   333: astore_1
    //   334: goto -19 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramContext	Context
    //   0	337	1	paramFile	File
    //   24	236	2	i1	int
    //   19	284	3	localObject1	Object
    //   55	245	4	localContentValues	android.content.ContentValues
    //   46	265	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   240	246	285	finally
    //   246	252	285	finally
    //   256	263	285	finally
    //   266	270	285	finally
    //   220	240	289	finally
    //   204	220	296	finally
    //   20	25	317	java/lang/Throwable
    //   41	114	317	java/lang/Throwable
    //   118	136	317	java/lang/Throwable
    //   144	162	317	java/lang/Throwable
    //   165	169	317	java/lang/Throwable
    //   169	182	317	java/lang/Throwable
    //   186	196	317	java/lang/Throwable
    //   270	278	317	java/lang/Throwable
    //   302	310	317	java/lang/Throwable
    //   315	317	317	java/lang/Throwable
    //   278	283	330	java/lang/Throwable
    //   310	315	333	java/lang/Throwable
  }
  
  private void d(long paramLong)
  {
    synchronized (this.p)
    {
      if (this.q.remove(Long.valueOf(paramLong)))
      {
        this.s.remove(Long.valueOf(paramLong));
      }
      else if (this.r.remove(Long.valueOf(paramLong)))
      {
        h();
      }
      else
      {
        g();
        h();
      }
      return;
    }
  }
  
  private void g()
  {
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      if (localObject == null)
      {
        localIterator.remove();
      }
      else
      {
        localObject = (DownloadJobContext)this.a.get(localObject);
        if ((localObject == null) || (((DownloadJobContext)localObject).g())) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void h()
  {
    if (this.q.size() > 0)
    {
      int i1;
      if (this.r.size() < 2) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        Long localLong = (Long)this.q.remove(0);
        NetReq localNetReq = (NetReq)this.s.remove(localLong);
        if (localNetReq == null)
        {
          h();
          return;
        }
        DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.a.get(localLong);
        if ((localDownloadJobContext != null) && (a(localDownloadJobContext.f())) && (!localDownloadJobContext.g()))
        {
          this.r.add(localLong);
          if (this.m == null) {
            this.m = WeiyunNetEngine.a();
          }
          this.e.submit(new WyDownloader.6(this, localLong, localNetReq));
          return;
        }
        h();
      }
    }
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
    int i1 = f.getAndIncrement();
    a(paramString1, paramString2, paramString3, paramString4, new WyDownloader.3(this, paramIDownloadStatusListener, i1), Integer.toString(i1));
    return Integer.toString(i1);
  }
  
  void a(int paramInt, DownloadJobContext paramDownloadJobContext)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    synchronized (this.b)
    {
      this.b.put(Long.valueOf(paramDownloadJobContext.h()), Integer.toString(paramInt));
      ??? = this.i.iterator();
      while (((Iterator)???).hasNext())
      {
        IDownloadStatusListener localIDownloadStatusListener = (IDownloadStatusListener)((Iterator)???).next();
        if (localIDownloadStatusListener != null) {
          localIDownloadStatusListener.a(Integer.toString(paramInt));
        }
      }
      if (paramDownloadJobContext.l() != null) {
        paramDownloadJobContext.l().a(Integer.toString(paramInt));
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
    int i1;
    label184:
    label190:
    synchronized (this.a)
    {
      long l1 = paramDownloadJobContext.h();
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.a.get(Long.valueOf(l1));
      if (localDownloadJobContext == null)
      {
        this.a.put(Long.valueOf(l1), paramDownloadJobContext);
      }
      else
      {
        if (!localDownloadJobContext.m().a()) {
          break label190;
        }
        paramDownloadJobContext.m().a = localDownloadJobContext.m().a;
        paramDownloadJobContext.m().b = localDownloadJobContext.m().b;
        this.a.put(Long.valueOf(l1), paramDownloadJobContext);
        break label184;
        a(paramInt, paramDownloadJobContext);
        if (i1 != 0)
        {
          paramDownloadJobContext.b(paramString);
        }
        else
        {
          localDownloadJobContext.a(paramDownloadJobContext.e());
          localDownloadJobContext.b(paramDownloadJobContext.f());
        }
        if (i1 == 0) {
          paramDownloadJobContext = localDownloadJobContext;
        }
        a(paramDownloadJobContext, 1, 0, null);
        return;
      }
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    synchronized (this.a)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.a.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null) {
        return;
      }
      if (localDownloadJobContext.g()) {
        return;
      }
      if (!NetworkUtil.isNetworkAvailable(this.o))
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
    synchronized (this.a)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.a.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null) {
        return;
      }
      if (localDownloadJobContext.g()) {
        return;
      }
      if ((paramDownloadServerInfo != null) && (!TextUtils.isEmpty(paramDownloadServerInfo.d)))
      {
        if (!a(localDownloadJobContext.f()))
        {
          a(localDownloadJobContext, 5, 1810004, null);
          return;
        }
        ??? = DownloadJobContext.a(localDownloadJobContext, paramDownloadServerInfo.d, localDownloadJobContext.j(), paramDownloadServerInfo.c, true, this, a(localDownloadJobContext.j(), localDownloadJobContext.c().b));
        localDownloadJobContext.a((HttpNetReq)???);
        localDownloadJobContext.a(paramDownloadServerInfo.f);
        localDownloadJobContext.m().h = paramDownloadServerInfo.f;
        a(paramLong, (NetReq)???);
        return;
      }
      a(localDownloadJobContext, 5, 1829002, null);
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, DownloadJobContext paramDownloadJobContext)
  {
    synchronized (this.a)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.a.get(Long.valueOf(paramLong));
      if (localDownloadJobContext != null) {
        a(localDownloadJobContext, 5, 1810002, null);
      }
      if (paramDownloadJobContext != null)
      {
        paramDownloadJobContext.m().a = 0;
        paramDownloadJobContext.m().b = 1810002;
        a(paramDownloadJobContext, true);
      }
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo, boolean paramBoolean2)
  {
    synchronized (this.a)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.a.get(Long.valueOf(paramLong));
      ??? = localDownloadJobContext;
      if (localDownloadJobContext == null)
      {
        if (paramWeiyunDownloadStatusInfo == null) {
          paramWeiyunDownloadStatusInfo = null;
        } else {
          paramWeiyunDownloadStatusInfo = paramWeiyunDownloadStatusInfo.i;
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
    synchronized (this.a)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.a.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null) {
        return;
      }
      if (localDownloadJobContext.g()) {
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
      if (!a(localDownloadJobContext.f()))
      {
        a(localDownloadJobContext, 5, 1810004, null);
        return;
      }
      this.l.a(localDownloadJobContext, 0);
      return;
    }
  }
  
  public void a(IDownloadStatusListener paramIDownloadStatusListener)
  {
    this.i.add(paramIDownloadStatusListener);
  }
  
  public void a(IFetchListener paramIFetchListener, Context paramContext)
  {
    this.h = paramIFetchListener;
    if (this.h != null)
    {
      this.i = new ArrayList();
      paramIFetchListener = new ReleaseLooperHandler("weiyun_download-work-thread");
      this.j = new InfoRecorder(this, paramIFetchListener);
      this.k = new LocalProcessor(this, paramIFetchListener);
      this.l = new UrlFetcher(this, this.h, paramIFetchListener);
      this.o = paramContext;
      this.j.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid());
      return;
    }
    throw new NullPointerException("IFetchListener can not be null!");
  }
  
  void a(DownloadJobContext paramDownloadJobContext, int paramInt1, int paramInt2)
  {
    this.g.a();
    this.g.a(paramDownloadJobContext, paramInt1, paramInt2);
  }
  
  void a(DownloadJobContext paramDownloadJobContext, int paramInt1, int paramInt2, String paramString)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    label461:
    int i1;
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
                synchronized (this.a)
                {
                  this.a.remove(Long.valueOf(paramDownloadJobContext.h()));
                  synchronized (this.b)
                  {
                    this.b.removeByKey(Long.valueOf(paramDownloadJobContext.h()));
                    synchronized (this.c)
                    {
                      this.c.remove(Long.valueOf(paramDownloadJobContext.h()));
                      synchronized (this.d)
                      {
                        this.d.remove(Long.valueOf(paramDownloadJobContext.h()));
                        paramDownloadJobContext.c(true);
                        if (this.m == null) {
                          this.m = WeiyunNetEngine.a();
                        }
                        this.m.cancelReq(paramDownloadJobContext.k());
                        paramInt1 = 0;
                      }
                    }
                  }
                }
              }
              if ((paramInt2 != 1810003) && (paramInt2 != 1810004)) {
                synchronized (this.d)
                {
                  this.d.add(Long.valueOf(paramDownloadJobContext.h()));
                }
              }
              synchronized (this.c)
              {
                this.c.add(Long.valueOf(paramDownloadJobContext.h()));
                paramInt1 = 1;
                d(paramDownloadJobContext.h());
              }
            }
            synchronized (this.a)
            {
              this.a.remove(Long.valueOf(paramDownloadJobContext.h()));
              synchronized (this.b)
              {
                this.b.removeByKey(Long.valueOf(paramDownloadJobContext.h()));
                synchronized (this.c)
                {
                  this.c.remove(Long.valueOf(paramDownloadJobContext.h()));
                  synchronized (this.d)
                  {
                    this.d.remove(Long.valueOf(paramDownloadJobContext.h()));
                    paramDownloadJobContext.m().f = paramDownloadJobContext.j();
                    paramDownloadJobContext.m().e = paramDownloadJobContext.m().d;
                    paramDownloadJobContext.m().i = paramDownloadJobContext;
                    d(paramDownloadJobContext.h());
                    bool1 = true;
                  }
                }
              }
            }
          }
          bool1 = paramDownloadJobContext.m().b();
          if (bool1) {
            synchronized (this.c)
            {
              this.c.remove(Long.valueOf(paramDownloadJobContext.h()));
              paramDownloadJobContext.c(true);
              paramDownloadJobContext.b(false);
              if (this.m == null) {
                this.m = WeiyunNetEngine.a();
              }
              this.m.cancelReq(paramDownloadJobContext.k());
              d(paramDownloadJobContext.h());
            }
          }
          break label753;
        }
        bool1 = paramDownloadJobContext.m().c();
        break label753;
      }
      int i2 = 0;
      i1 = paramInt1;
      paramInt1 = i2;
    }
    else
    {
      d(paramDownloadJobContext.h());
      paramInt1 = 1;
      i1 = 1;
    }
    boolean bool2;
    if ((paramInt1 == 0) && (!paramDownloadJobContext.m().a())) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    paramInt1 = i1;
    boolean bool1 = bool2;
    if (bool2) {
      synchronized (this.c)
      {
        this.c.remove(Long.valueOf(paramDownloadJobContext.h()));
        synchronized (this.d)
        {
          this.d.remove(Long.valueOf(paramDownloadJobContext.h()));
          paramDownloadJobContext.c(false);
          this.k.a(paramDownloadJobContext);
          paramInt1 = i1;
          bool1 = bool2;
        }
      }
    }
    label753:
    if (bool1)
    {
      i1 = paramDownloadJobContext.m().a;
      paramDownloadJobContext.m().a = paramInt1;
      paramDownloadJobContext.m().b = paramInt2;
      paramDownloadJobContext.m().c = DownloadHelper.a(paramInt2, paramString);
      this.j.a(paramDownloadJobContext, true);
      a(paramDownloadJobContext, i1, paramInt1);
    }
  }
  
  void a(DownloadJobContext paramDownloadJobContext, boolean paramBoolean)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    Iterator localIterator = new ArrayList(this.i).iterator();
    while (localIterator.hasNext())
    {
      IDownloadStatusListener localIDownloadStatusListener = (IDownloadStatusListener)localIterator.next();
      if (localIDownloadStatusListener != null) {
        localIDownloadStatusListener.a(paramDownloadJobContext.b(), paramDownloadJobContext.h(), paramDownloadJobContext.n(), paramBoolean);
      }
    }
    if (paramDownloadJobContext.l() != null) {
      paramDownloadJobContext.l().a(paramDownloadJobContext.b(), paramDownloadJobContext.h(), paramDownloadJobContext.n(), paramBoolean);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, IDownloadListener paramIDownloadListener)
  {
    a(paramString1, paramString2, null, paramString3, paramIDownloadListener, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, IDownloadListener paramIDownloadListener, String paramString5)
  {
    paramString1 = DownloadJobContext.a(paramString4, paramString1, paramString2, paramString3, true, new WyDownloader.4(this, paramIDownloadListener, paramString4, paramString2));
    if (this.n == null) {
      this.n = WeiyunNetEngine.b();
    }
    this.e.submit(new WyDownloader.5(this, paramString1));
    if (paramString5 != null) {
      this.t.put(paramString5, paramString1);
    }
  }
  
  public void a(String arg1, List<DownloadJobContext> paramList)
  {
    if ((TextUtils.equals(???, WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid())) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      synchronized (this.a)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          DownloadJobContext localDownloadJobContext = (DownloadJobContext)paramList.next();
          long l1 = localDownloadJobContext.h();
          int i1 = localDownloadJobContext.m().a;
          localDownloadJobContext.m().a = 0;
          this.a.put(Long.valueOf(l1), localDownloadJobContext);
          if ((i1 != 0) && (i1 != 1) && (i1 != 2))
          {
            if (i1 != 3)
            {
              if (i1 == 5) {
                a(localDownloadJobContext, 5, localDownloadJobContext.m().b, localDownloadJobContext.m().c);
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
      synchronized (this.c)
      {
        localArrayList.addAll(this.c);
        ??? = localArrayList.iterator();
        if (!((Iterator)???).hasNext()) {
          return;
        }
        a(((Long)((Iterator)???).next()).longValue(), false, false, false, false);
      }
    }
    synchronized (this.a)
    {
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        DownloadJobContext localDownloadJobContext = (DownloadJobContext)((Map.Entry)localIterator.next()).getValue();
        if ((localDownloadJobContext.f()) && (paramBoolean2))
        {
          if ((localDownloadJobContext.f()) && (paramBoolean2) && (localDownloadJobContext.m().d())) {
            a(localDownloadJobContext.h(), false, false, false, false);
          }
        }
        else if (localDownloadJobContext.m().b())
        {
          localDownloadJobContext.c(true);
          if (this.m != null) {
            this.m.cancelReq(localDownloadJobContext.k());
          }
          a(localDownloadJobContext, 5, 1810004, null);
        }
      }
      return;
    }
  }
  
  public boolean a(long paramLong)
  {
    synchronized (this.a)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.a.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null)
      {
        d(paramLong);
        return false;
      }
      a(localDownloadJobContext, 3, 0, null);
      return true;
    }
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.a)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.a.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null)
      {
        d(paramLong);
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
    if (this.n != null)
    {
      ??? = (HttpNetReq)this.t.get(paramString);
      if (??? != null) {
        this.n.cancelReq((NetReq)???);
      }
    }
    synchronized (this.b)
    {
      paramString = (Long)this.b.getByValue(paramString);
      if (paramString == null) {
        return false;
      }
      this.j.a(paramString.longValue(), true);
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
  
  public DownloadJobContext b(long paramLong)
  {
    synchronized (this.a)
    {
      DownloadJobContext localDownloadJobContext = (DownloadJobContext)this.a.get(Long.valueOf(paramLong));
      if (localDownloadJobContext == null) {
        return null;
      }
      return DownloadJobContext.a(localDownloadJobContext.b(), localDownloadJobContext.c().a(), localDownloadJobContext.d(), localDownloadJobContext.m().e());
    }
  }
  
  public DownloadJobCounter b()
  {
    return this.g.a();
  }
  
  String b(DownloadFile paramDownloadFile, String paramString, boolean paramBoolean, IDownloadStatusListener paramIDownloadStatusListener)
  {
    int i1 = f.getAndIncrement();
    paramString = DownloadJobContext.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid(), paramDownloadFile, paramString, new WeiyunDownloadStatusInfo());
    paramString.b(paramBoolean);
    paramString.m().g = paramDownloadFile.b;
    paramString.a(paramIDownloadStatusListener);
    this.j.a(i1, paramString);
    return Integer.toString(i1);
  }
  
  public void b(IDownloadStatusListener paramIDownloadStatusListener)
  {
    if (this.i.contains(paramIDownloadStatusListener)) {
      this.i.remove(paramIDownloadStatusListener);
    }
  }
  
  public boolean c()
  {
    DownloadJobCounter localDownloadJobCounter = this.g.a();
    return localDownloadJobCounter.a + localDownloadJobCounter.b > 0;
  }
  
  public boolean c(long paramLong)
  {
    this.j.a(paramLong, true);
    return true;
  }
  
  public int d()
  {
    ??? = this.g.a();
    int i1 = ((DownloadJobCounter)???).d;
    int i2 = ((DownloadJobCounter)???).c;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.a)
    {
      localArrayList.addAll(this.a.keySet());
      if (!localArrayList.isEmpty()) {
        this.e.submit(new WyDownloader.7(this, localArrayList));
      }
      return i1 + i2;
    }
  }
  
  public int e()
  {
    ??? = this.g.a();
    int i1 = ((DownloadJobCounter)???).d;
    int i2 = ((DownloadJobCounter)???).a;
    int i3 = ((DownloadJobCounter)???).b;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.a)
    {
      localArrayList.addAll(this.a.keySet());
      if (!localArrayList.isEmpty()) {
        this.e.submit(new WyDownloader.8(this, localArrayList));
      }
      return i1 + i2 + i3;
    }
  }
  
  public int f()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.d)
    {
      int i1 = this.d.size();
      localArrayList.addAll(this.d);
      if (!localArrayList.isEmpty()) {
        this.e.submit(new WyDownloader.9(this, localArrayList));
      }
      return i1;
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {
      return;
    }
    int i1;
    if (paramNetResp.mResult == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = paramNetResp.mErrCode;
    paramNetResp = ((HttpNetReq)paramNetResp.mReq).getUserData();
    if ((paramNetResp != null) && ((paramNetResp instanceof DownloadJobContext)))
    {
      paramNetResp = (DownloadJobContext)paramNetResp;
      if (paramNetResp == null) {
        return;
      }
      if (paramNetResp.g()) {
        return;
      }
      if (i1 != 0)
      {
        File localFile = new File(paramNetResp.j());
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
      if (paramNetResp.g()) {
        return;
      }
      if (DownloadHelper.a(i2))
      {
        a(paramNetResp, 0, i2, null);
        return;
      }
      a(paramNetResp, 5, i2, null);
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
      if (paramNetReq.g()) {
        return;
      }
      if (paramNetReq.m().c()) {
        a(paramNetReq, 2, 0, null);
      }
      paramNetReq.m().d = paramLong2;
      WeiyunDownloadStatusInfo localWeiyunDownloadStatusInfo = paramNetReq.m();
      if (paramLong1 >= paramLong2) {
        paramLong1 = paramLong2;
      }
      localWeiyunDownloadStatusInfo.e = paramLong1;
      a(paramNetReq, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.WyDownloader
 * JD-Core Version:    0.7.0.1
 */