package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class PicPreDownloaderCore
{
  private PicPreDownloader jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  private PreDownloadStrategyBeta jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final List<PicReq> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  protected Map<String, Integer> a;
  private ConcurrentLinkedQueue<PicPreDownloaderCore.PicPreDownRunner> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private PriorityBlockingQueue<PicReq> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private final List<PicReq> jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private final List<PicReq> c = Collections.synchronizedList(new LinkedList());
  private final List<PicReq> d = Collections.synchronizedList(new LinkedList());
  
  public PicPreDownloaderCore(PicPreDownloader paramPicPreDownloader, PreDownloadStrategyBeta paramPreDownloadStrategyBeta)
  {
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader = paramPicPreDownloader;
    this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta = paramPreDownloadStrategyBeta;
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
    this.jdField_a_of_type_JavaLangRunnable = new PicPreDownloaderCore.1(this);
  }
  
  private PicReq a(String paramString, Collection<PicReq> paramCollection)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (localIterator.hasNext())
        {
          PicReq localPicReq = (PicReq)localIterator.next();
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null) {
            continue;
          }
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_Int == 1)
          {
            bool = true;
            int i = URLDrawableHelper.getFileSizeType(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString, bool);
            String str = TransFileControllerImpl.makeReceiveKey(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.f, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString, i);
            if ((paramString == null) || (!paramString.equals(str))) {
              continue;
            }
            paramCollection.remove(localPicReq);
            this.jdField_a_of_type_JavaUtilMap.remove(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.a(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -5);
            return localPicReq;
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 3)
    {
      PicPreDownloaderCore.PicPreDownRunner localPicPreDownRunner = (PicPreDownloaderCore.PicPreDownRunner)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localPicPreDownRunner != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        ThreadManager.excute(localPicPreDownRunner, 16, null, false);
      }
    }
  }
  
  protected int a(MessageForPic paramMessageForPic)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForPic.uuid);
    if (localInteger == null) {
      return -1;
    }
    Collection localCollection = a(localInteger.intValue());
    if (localCollection != null) {
      try
      {
        Iterator localIterator = localCollection.iterator();
        while (localIterator.hasNext())
        {
          PicReq localPicReq = (PicReq)localIterator.next();
          if (paramMessageForPic.subMsgId == localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_Int)
          {
            Logger.a("PIC_TAG_PRELOAD", "getPriority", "uuid: " + paramMessageForPic.uuid + " subMsgId: " + paramMessageForPic.subMsgId);
            int i = localInteger.intValue();
            return i;
          }
        }
      }
      finally {}
    }
    return -1;
  }
  
  PicReq a(boolean paramBoolean)
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      PicReq localPicReq1;
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
        localPicReq1 = (PicReq)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        if (paramBoolean) {
          this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        }
        return localPicReq1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
          localPicReq1 = (PicReq)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          if (paramBoolean) {
            this.jdField_b_of_type_JavaUtilList.remove(i - 1);
          }
          return localPicReq1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
        PicReq localPicReq2 = (PicReq)this.c.get(i - 1);
        if (paramBoolean) {
          this.c.remove(i - 1);
        }
        return localPicReq2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
        PicReq localPicReq3 = (PicReq)this.d.get(i - 1);
        if (paramBoolean) {
          this.d.remove(i - 1);
        }
        return localPicReq3;
      }
    }
    Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "cannot get any request");
    return null;
  }
  
  protected Collection<PicReq> a(int paramInt)
  {
    Logger.a("PIC_TAG_PRELOAD", "getRequestsByPriority", "priority=" + paramInt);
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue;
    case 5: 
      return this.jdField_a_of_type_JavaUtilList;
    case 4: 
      return this.jdField_b_of_type_JavaUtilList;
    case 3: 
      return this.c;
    }
    return this.d;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  protected void a(PicReq paramPicReq)
  {
    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(paramPicReq);
    paramPicReq.f = paramPicReq.jdField_e_of_type_Int;
    paramPicReq.jdField_e_of_type_Int = 6;
    this.jdField_a_of_type_JavaUtilMap.put(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString, Integer.valueOf(6));
    if (paramPicReq.jdField_a_of_type_Int == 6) {}
    for (String str = " big";; str = " thumb")
    {
      Logger.a("PIC_TAG_PRELOAD", "addToHandlingQueue, cmdStr:" + str, ", uniseq:" + paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ", subMsgId:" + paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_Int + ", priority:" + paramPicReq.jdField_e_of_type_Int);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      return;
    }
  }
  
  protected void a(PicReq paramPicReq, int paramInt1, int paramInt2)
  {
    List localList = null;
    String str = "";
    if (paramInt2 == 5)
    {
      localList = this.jdField_a_of_type_JavaUtilList;
      paramPicReq.jdField_e_of_type_Int = 5;
      str = "AIORequests";
      switch (paramInt1)
      {
      default: 
        paramPicReq.f = 2;
      }
    }
    for (;;)
    {
      if (localList != null)
      {
        Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", "successfully to add the pic request to " + str);
        localList.add(paramPicReq);
        e();
        this.jdField_a_of_type_JavaUtilMap.put(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString, Integer.valueOf(paramPicReq.jdField_e_of_type_Int));
      }
      return;
      paramPicReq.f = 4;
      continue;
      paramPicReq.f = 3;
      continue;
      if (paramInt2 == 1) {
        switch (paramInt1)
        {
        default: 
          localList = this.d;
          paramPicReq.jdField_e_of_type_Int = 2;
          paramPicReq.f = paramPicReq.jdField_e_of_type_Int;
          str = "GroupRequests";
          break;
        case 3: 
          localList = this.jdField_b_of_type_JavaUtilList;
          paramPicReq.jdField_e_of_type_Int = 4;
          paramPicReq.f = paramPicReq.jdField_e_of_type_Int;
          str = "C2CRequests";
          break;
        case 2: 
          localList = this.c;
          paramPicReq.jdField_e_of_type_Int = 3;
          paramPicReq.f = paramPicReq.jdField_e_of_type_Int;
          str = "DiscussionRequests";
        }
      }
    }
  }
  
  protected void a(Runnable paramRunnable, String paramString, MessageRecord paramMessageRecord)
  {
    String str = paramString;
    if (paramMessageRecord != null) {
      str = paramString + ", msgSeq = " + paramMessageRecord.shmsgseq;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(new PicPreDownloaderCore.PicPreDownRunner(this, paramRunnable, str));
    f();
  }
  
  public void a(String paramString)
  {
    PicReq localPicReq = a(paramString, this.jdField_a_of_type_JavaUtilList);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.jdField_a_of_type_Int);
      return;
    }
    localPicReq = a(paramString, this.jdField_b_of_type_JavaUtilList);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.jdField_a_of_type_Int);
      return;
    }
    localPicReq = a(paramString, this.c);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.jdField_a_of_type_Int);
      return;
    }
    localPicReq = a(paramString, this.d);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.jdField_a_of_type_Int);
      return;
    }
    Logger.a("PIC_TAG_PRELOAD", "", "drop", "Cannot be found in the request stacks");
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  protected boolean a(MessageForPic paramMessageForPic, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForPic.uuid);
    if (localInteger == null)
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "uuid=" + paramMessageForPic.uuid + ", priority=" + paramInt + ", cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    Logger.a("PIC_TAG_PRELOAD", "filter", "priority: " + paramInt + ", uniseq: " + paramMessageForPic.uniseq + ", subMsgId:" + paramMessageForPic.subMsgId);
    if (localCollection == null)
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "originalRequests == null");
      return false;
    }
    Object localObject1 = null;
    label339:
    for (;;)
    {
      try
      {
        Iterator localIterator = localCollection.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (PicReq)localIterator.next();
          if (paramMessageForPic.subMsgId != ((PicReq)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_Int) {
            break label339;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label339;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          Logger.a("PIC_TAG_PRELOAD", "filter", "No need to update the picReq");
          return bool1;
        }
      }
      finally {}
      Object localObject2 = a(paramInt);
      bool2 = bool1;
      if (localObject2 == null) {
        break;
      }
      localObject1.f = localObject1.jdField_e_of_type_Int;
      localObject1.jdField_e_of_type_Int = paramInt;
      localCollection.remove(localObject1);
      ((Collection)localObject2).add(localObject1);
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForPic.uuid, Integer.valueOf(paramInt));
      Logger.a("PIC_TAG_PRELOAD", "filter", "update the picReq");
      return bool1;
    }
  }
  
  protected boolean a(PicReq paramPicReq)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(paramPicReq))
    {
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(paramPicReq);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      this.jdField_a_of_type_JavaUtilMap.remove(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString);
      Logger.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ", cmd:" + paramPicReq.jdField_a_of_type_Int + ", curHandingNum:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
    }
  }
  
  protected boolean b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 1;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOn", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.d();
  }
  
  public void d()
  {
    try
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): AIORequests size=" + i);
      }
      ThreadManager.excute(new PicPreDownloaderCore.2(this, i), 16, null, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): exception=" + localException.getMessage());
    }
  }
  
  protected void e()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() + this.c.size() + this.d.size() > this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a.longValue()) {
      localObject1 = null;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.d.size() > 0)
        {
          localObject1 = (PicReq)this.d.remove(0);
          if (localObject1 != null)
          {
            this.jdField_a_of_type_JavaUtilMap.remove(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta;
            ((PreDownloadStrategyBeta)localObject1).N += 1L;
            Logger.a("PIC_TAG_PRELOAD", "checkRequestListSize", "over max request list size: " + this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a + ", remove a request");
          }
          return;
        }
        synchronized (this.c)
        {
          if (this.c.size() > 0) {
            localObject1 = (PicReq)this.c.remove(0);
          }
        }
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
          PicReq localPicReq1 = (PicReq)this.jdField_b_of_type_JavaUtilList.remove(0);
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          PicReq localPicReq2 = (PicReq)this.jdField_a_of_type_JavaUtilList.remove(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloaderCore
 * JD-Core Version:    0.7.0.1
 */