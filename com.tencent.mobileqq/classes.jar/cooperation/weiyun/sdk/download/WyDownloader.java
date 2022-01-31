package cooperation.weiyun.sdk.download;

import amrn;
import amro;
import amrp;
import amrq;
import amrr;
import amrs;
import amrt;
import amru;
import amrv;
import amrw;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.utils.ThreadPoolWrapper;
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
  implements INetEngine.INetEngineListener, InfoRecorder.InfoRecorderCallback, LocalProcessor.LocalProcessorCallback, UrlFetcher.UrlFetcherCallback
{
  static INetEngine.IBreakDownFix jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new amro();
  private static Singleton jdField_a_of_type_ComTencentWeiyunUtilsSingleton;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private Context jdField_a_of_type_AndroidContentContext;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private final ThreadPoolWrapper jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper = new ThreadPoolWrapper("WyDownloader");
  private final DualHashMap jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap = new DualHashMap();
  private final DownloadJobCounter jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobCounter = new DownloadJobCounter();
  private WyDownloader.IFetchListener jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IFetchListener;
  private InfoRecorder jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder;
  private LocalProcessor jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorLocalProcessor;
  private UrlFetcher jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private INetEngine jdField_b_of_type_ComTencentMobileqqTransfileINetEngine;
  private final HashSet jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentWeiyunUtilsSingleton = new amrn();
  }
  
  private WyDownloader()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, new amrp(this));
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
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = WeiyunNetEngine.a();
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new amrt(this, localLong, localNetReq));
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
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new amru(this, localArrayList));
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
    a(paramString1, paramString2, paramString3, paramString4, new amrq(this, paramIDownloadStatusListener, i), Integer.toString(i));
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
      ??? = DownloadJobContext.a(localDownloadJobContext, paramDownloadServerInfo.c, localDownloadJobContext.d(), paramDownloadServerInfo.jdField_b_of_type_JavaLangString, jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix, this, a(localDownloadJobContext.d(), localDownloadJobContext.a().jdField_a_of_type_JavaLangString));
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
      this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher.a(localDownloadJobContext, DownloadType.FILE_ORDINARY.ordinal());
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = paramNetReq.a();
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
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 3) {}
    int j;
    label111:
    label122:
    do
    {
      return;
      if (paramNetResp.jdField_a_of_type_Int == 0) {}
      for (int i = 1;; i = 0)
      {
        j = paramNetResp.jdField_b_of_type_Int;
        paramNetResp = ((HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).a();
        if ((paramNetResp == null) || (!(paramNetResp instanceof DownloadJobContext))) {
          break;
        }
        paramNetResp = (DownloadJobContext)paramNetResp;
        if ((paramNetResp == null) || (paramNetResp.d())) {
          break;
        }
        if (i == 0) {
          break label122;
        }
        File localFile = new File(paramNetResp.d());
        if (!localFile.exists()) {
          break label111;
        }
        IOUtils.scan2MediaStore(WeiyunTransmissionGlobal.getInstance().getContext(), localFile);
        a(paramNetResp, 4, 0, null);
        return;
      }
      a(paramNetResp, 5, 1810031, null);
      return;
    } while (paramNetResp.d());
    if (DownloadHelper.a(j))
    {
      a(paramNetResp, 0, j, null);
      return;
    }
    a(paramNetResp, 5, j, null);
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
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = WeiyunNetEngine.a();
            }
            this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(paramDownloadJobContext.a());
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
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = WeiyunNetEngine.a();
            }
            this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(paramDownloadJobContext.a());
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
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder = new InfoRecorder(this);
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorLocalProcessor = new LocalProcessor(this);
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher = new UrlFetcher(this, this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IFetchListener);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorInfoRecorder.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, WyDownloader.IDownloadListener paramIDownloadListener)
  {
    a(paramString1, paramString2, null, paramString3, paramIDownloadListener, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, WyDownloader.IDownloadListener paramIDownloadListener, String paramString5)
  {
    paramString1 = DownloadJobContext.a(paramString4, paramString1, paramString2, paramString3, jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix, new amrr(this, paramIDownloadListener, paramString4, paramString2));
    if (this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine = WeiyunNetEngine.b();
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new amrs(this, paramString1));
    if (paramString5 != null) {
      this.jdField_b_of_type_JavaUtilMap.put(paramString5, paramString1);
    }
  }
  
  public void a(String arg1, List paramList)
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
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
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
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine != null) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(localDownloadJobContext.a());
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
    if (this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine != null)
    {
      ??? = (HttpNetReq)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (??? != null) {
        this.jdField_b_of_type_ComTencentMobileqqTransfileINetEngine.b((NetReq)???);
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
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new amrv(this, localArrayList));
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
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new amrw(this, localArrayList));
      }
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.WyDownloader
 * JD-Core Version:    0.7.0.1
 */