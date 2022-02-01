package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BaseTransFileController;
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
    do
    {
      try
      {
        Iterator localIterator = paramCollection.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localPicReq = (PicReq)localIterator.next();
        } while (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null);
        i = localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_Int;
        bool = true;
        if (i != 1) {
          break label180;
        }
      }
      finally
      {
        for (;;)
        {
          PicReq localPicReq;
          int i;
          String str;
          for (;;)
          {
            throw paramString;
          }
          boolean bool = false;
        }
      }
      i = ((IPicHelper)QRoute.api(IPicHelper.class)).getFileSizeType(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString, bool);
      str = BaseTransFileController.makeReceiveKey(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.f, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString, i);
    } while ((paramString == null) || (!paramString.equals(str)));
    paramCollection.remove(localPicReq);
    this.jdField_a_of_type_JavaUtilMap.remove(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.a(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -5);
    return localPicReq;
    return null;
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
        Object localObject = localCollection.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PicReq localPicReq = (PicReq)((Iterator)localObject).next();
          if (paramMessageForPic.subMsgId == localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_Int)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("uuid: ");
            ((StringBuilder)localObject).append(paramMessageForPic.uuid);
            ((StringBuilder)localObject).append(" subMsgId: ");
            ((StringBuilder)localObject).append(paramMessageForPic.subMsgId);
            Logger.a("PIC_TAG_PRELOAD", "getPriority", ((StringBuilder)localObject).toString());
            int i = localInteger.intValue();
            return i;
          }
        }
        return -1;
      }
      finally {}
    }
    return -1;
  }
  
  PicReq a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      Object localObject1;
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
        localObject1 = this.jdField_a_of_type_JavaUtilList;
        i -= 1;
        localObject1 = (PicReq)((List)localObject1).get(i);
        if (paramBoolean) {
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
        return localObject1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
          localObject1 = this.jdField_b_of_type_JavaUtilList;
          i -= 1;
          localObject1 = (PicReq)((List)localObject1).get(i);
          if (paramBoolean) {
            this.jdField_b_of_type_JavaUtilList.remove(i);
          }
          return localObject1;
        }
        synchronized (this.c)
        {
          i = this.c.size();
          if (i > 0)
          {
            Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
            localObject1 = this.c;
            i -= 1;
            localObject1 = (PicReq)((List)localObject1).get(i);
            if (paramBoolean) {
              this.c.remove(i);
            }
            return localObject1;
          }
          synchronized (this.d)
          {
            i = this.d.size();
            if (i > 0)
            {
              Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
              localObject1 = this.d;
              i -= 1;
              localObject1 = (PicReq)((List)localObject1).get(i);
              if (paramBoolean) {
                this.d.remove(i);
              }
              return localObject1;
            }
            Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "cannot get any request");
            return null;
          }
        }
      }
    }
  }
  
  protected Collection<PicReq> a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("priority=");
    localStringBuilder.append(paramInt);
    Logger.a("PIC_TAG_PRELOAD", "getRequestsByPriority", localStringBuilder.toString());
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return null;
            }
            return this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue;
          }
          return this.jdField_a_of_type_JavaUtilList;
        }
        return this.jdField_b_of_type_JavaUtilList;
      }
      return this.c;
    }
    return this.d;
  }
  
  protected void a()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null)
    {
      Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
      if (localRunnable != null) {
        localMqqHandler.removeCallbacks(localRunnable);
      }
    }
  }
  
  protected void a(PicReq paramPicReq)
  {
    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(paramPicReq);
    paramPicReq.f = paramPicReq.jdField_e_of_type_Int;
    paramPicReq.jdField_e_of_type_Int = 6;
    this.jdField_a_of_type_JavaUtilMap.put(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString, Integer.valueOf(6));
    if (paramPicReq.jdField_a_of_type_Int == 6) {
      str = " big";
    } else {
      str = " thumb";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addToHandlingQueue, cmdStr:");
    localStringBuilder.append(str);
    String str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(", uniseq:");
    localStringBuilder.append(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a);
    localStringBuilder.append(", subMsgId:");
    localStringBuilder.append(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_Int);
    localStringBuilder.append(", priority:");
    localStringBuilder.append(paramPicReq.jdField_e_of_type_Int);
    Logger.a("PIC_TAG_PRELOAD", str, localStringBuilder.toString());
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
  }
  
  protected void a(PicReq paramPicReq, int paramInt1, int paramInt2)
  {
    List localList;
    String str;
    if (paramInt2 == 5)
    {
      localList = this.jdField_a_of_type_JavaUtilList;
      paramPicReq.jdField_e_of_type_Int = 5;
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          paramPicReq.f = 2;
        } else {
          paramPicReq.f = 4;
        }
      }
      else {
        paramPicReq.f = 3;
      }
      str = "AIORequests";
    }
    else if (paramInt2 == 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          localList = this.d;
          paramPicReq.jdField_e_of_type_Int = 2;
          paramPicReq.f = paramPicReq.jdField_e_of_type_Int;
          str = "GroupRequests";
        }
        else
        {
          localList = this.jdField_b_of_type_JavaUtilList;
          paramPicReq.jdField_e_of_type_Int = 4;
          paramPicReq.f = paramPicReq.jdField_e_of_type_Int;
          str = "C2CRequests";
        }
      }
      else
      {
        localList = this.c;
        paramPicReq.jdField_e_of_type_Int = 3;
        paramPicReq.f = paramPicReq.jdField_e_of_type_Int;
        str = "DiscussionRequests";
      }
    }
    else
    {
      localList = null;
      str = "";
    }
    if (localList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("successfully to add the pic request to ");
      localStringBuilder.append(str);
      Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", localStringBuilder.toString());
      localList.add(paramPicReq);
      e();
      this.jdField_a_of_type_JavaUtilMap.put(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString, Integer.valueOf(paramPicReq.jdField_e_of_type_Int));
    }
  }
  
  protected void a(Runnable paramRunnable, String paramString, MessageRecord paramMessageRecord)
  {
    Object localObject = paramString;
    if (paramMessageRecord != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", msgSeq = ");
      ((StringBuilder)localObject).append(paramMessageRecord.shmsgseq);
      localObject = ((StringBuilder)localObject).toString();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(new PicPreDownloaderCore.PicPreDownRunner(this, paramRunnable, (String)localObject));
    f();
  }
  
  public void a(String paramString)
  {
    PicReq localPicReq = a(paramString, this.jdField_a_of_type_JavaUtilList);
    StringBuilder localStringBuilder;
    if (localPicReq != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("From AIORequests, uniseq:");
      localStringBuilder.append(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",cmd:");
      localStringBuilder.append(localPicReq.jdField_a_of_type_Int);
      Logger.a("PIC_TAG_PRELOAD", "", "drop", localStringBuilder.toString());
      return;
    }
    localPicReq = a(paramString, this.jdField_b_of_type_JavaUtilList);
    if (localPicReq != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("From AIORequests, uniseq:");
      localStringBuilder.append(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",cmd:");
      localStringBuilder.append(localPicReq.jdField_a_of_type_Int);
      Logger.a("PIC_TAG_PRELOAD", "", "drop", localStringBuilder.toString());
      return;
    }
    localPicReq = a(paramString, this.c);
    if (localPicReq != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("From AIORequests, uniseq:");
      localStringBuilder.append(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",cmd:");
      localStringBuilder.append(localPicReq.jdField_a_of_type_Int);
      Logger.a("PIC_TAG_PRELOAD", "", "drop", localStringBuilder.toString());
      return;
    }
    localPicReq = a(paramString, this.d);
    if (localPicReq != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("From AIORequests, uniseq:");
      localStringBuilder.append(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",cmd:");
      localStringBuilder.append(localPicReq.jdField_a_of_type_Int);
      Logger.a("PIC_TAG_PRELOAD", "", "drop", localStringBuilder.toString());
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
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForPic.uuid);
    boolean bool = false;
    if (localInteger == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uuid=");
      ((StringBuilder)localObject1).append(paramMessageForPic.uuid);
      ((StringBuilder)localObject1).append(", priority=");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", cannot be found in the PriorityMap");
      Logger.a("PIC_TAG_PRELOAD", "filter", ((StringBuilder)localObject1).toString());
      return false;
    }
    Collection localCollection = a(localInteger.intValue());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("priority: ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(", uniseq: ");
    ((StringBuilder)localObject1).append(paramMessageForPic.uniseq);
    ((StringBuilder)localObject1).append(", subMsgId:");
    ((StringBuilder)localObject1).append(paramMessageForPic.subMsgId);
    Logger.a("PIC_TAG_PRELOAD", "filter", ((StringBuilder)localObject1).toString());
    if (localCollection == null)
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "originalRequests == null");
      return false;
    }
    localObject1 = null;
    try
    {
      Iterator localIterator = localCollection.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (PicReq)localIterator.next();
        if (paramMessageForPic.subMsgId == ((PicReq)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_Int)
        {
          bool = true;
          localObject1 = localObject2;
        }
      }
      if ((bool) && (paramInt > localInteger.intValue()))
      {
        localObject2 = a(paramInt);
        if (localObject2 != null)
        {
          ((PicReq)localObject1).f = ((PicReq)localObject1).jdField_e_of_type_Int;
          ((PicReq)localObject1).jdField_e_of_type_Int = paramInt;
          localCollection.remove(localObject1);
          ((Collection)localObject2).add(localObject1);
          this.jdField_a_of_type_JavaUtilMap.put(paramMessageForPic.uuid, Integer.valueOf(paramInt));
          Logger.a("PIC_TAG_PRELOAD", "filter", "update the picReq");
          return bool;
        }
      }
      else
      {
        Logger.a("PIC_TAG_PRELOAD", "filter", "No need to update the picReq");
      }
      return bool;
    }
    finally {}
    for (;;)
    {
      throw paramMessageForPic;
    }
  }
  
  protected boolean a(PicReq paramPicReq)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(paramPicReq))
    {
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(paramPicReq);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      this.jdField_a_of_type_JavaUtilMap.remove(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uniseq:");
      localStringBuilder.append(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a);
      localStringBuilder.append(", cmd:");
      localStringBuilder.append(paramPicReq.jdField_a_of_type_Int);
      localStringBuilder.append(", curHandingNum:");
      localStringBuilder.append(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      Logger.a("PIC_TAG_PRELOAD", "onDownload", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mIsPicPreloadSuitable:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOff", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null)
    {
      Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
      if (localRunnable != null)
      {
        ((MqqHandler)localObject).removeCallbacks(localRunnable);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
      }
    }
  }
  
  protected boolean b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 1;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsPicPreloadSuitable:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOn", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.d();
  }
  
  public void d()
  {
    try
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("clearAIORequests(): AIORequests size=");
        localStringBuilder1.append(i);
        QLog.d("PIC_TAG_PRELOAD", 2, localStringBuilder1.toString());
      }
      ThreadManager.excute(new PicPreDownloaderCore.2(this, i), 16, null, false);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("clearAIORequests(): exception=");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("PIC_TAG_PRELOAD", 2, localStringBuilder2.toString());
      }
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() + this.c.size() + this.d.size() > this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a.longValue())
    {
      Object localObject1 = null;
      synchronized (this.d)
      {
        if (this.d.size() > 0) {
          localObject1 = (PicReq)this.d.remove(0);
        }
        synchronized (this.c)
        {
          if (this.c.size() > 0) {
            localObject1 = (PicReq)this.c.remove(0);
          }
          synchronized (this.jdField_b_of_type_JavaUtilList)
          {
            if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
              localObject1 = (PicReq)this.jdField_b_of_type_JavaUtilList.remove(0);
            }
            synchronized (this.jdField_a_of_type_JavaUtilList)
            {
              if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
                localObject1 = (PicReq)this.jdField_a_of_type_JavaUtilList.remove(0);
              }
              if (localObject1 != null)
              {
                this.jdField_a_of_type_JavaUtilMap.remove(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString);
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta;
                ((PreDownloadStrategyBeta)localObject1).N += 1L;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("over max request list size: ");
                ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a);
                ((StringBuilder)localObject1).append(", remove a request");
                Logger.a("PIC_TAG_PRELOAD", "checkRequestListSize", ((StringBuilder)localObject1).toString());
                return;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloaderCore
 * JD-Core Version:    0.7.0.1
 */