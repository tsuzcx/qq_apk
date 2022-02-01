package com.tencent.mobileqq.pic;

import azjq;
import azjx;
import azke;
import azkq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  private azkq jdField_a_of_type_Azkq;
  private PicPreDownloader jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final List<azke> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  protected Map<String, Integer> a;
  private ConcurrentLinkedQueue<PicPreDownloaderCore.PicPreDownRunner> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private PriorityBlockingQueue<azke> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private final List<azke> jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private final List<azke> c = Collections.synchronizedList(new LinkedList());
  private final List<azke> d = Collections.synchronizedList(new LinkedList());
  
  public PicPreDownloaderCore(PicPreDownloader paramPicPreDownloader, azkq paramazkq)
  {
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader = paramPicPreDownloader;
    this.jdField_a_of_type_Azkq = paramazkq;
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
    this.jdField_a_of_type_JavaLangRunnable = new PicPreDownloaderCore.1(this);
  }
  
  private azke a(String paramString, Collection<azke> paramCollection)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (localIterator.hasNext())
        {
          azke localazke = (azke)localIterator.next();
          if (localazke.jdField_a_of_type_Azjx == null) {
            continue;
          }
          if (localazke.jdField_a_of_type_Azjx.jdField_e_of_type_Int == 1)
          {
            bool = true;
            int i = URLDrawableHelper.getFileSizeType(localazke.jdField_a_of_type_Azjx.jdField_e_of_type_JavaLangString, bool);
            String str = TransFileController.makeReceiveKey(localazke.jdField_a_of_type_Azjx.f, localazke.jdField_a_of_type_Azjx.jdField_g_of_type_JavaLangString, i);
            if ((paramString == null) || (!paramString.equals(str))) {
              continue;
            }
            paramCollection.remove(localazke);
            this.jdField_a_of_type_JavaUtilMap.remove(localazke.jdField_a_of_type_Azjx.jdField_g_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.a(localazke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -5);
            return localazke;
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
          azke localazke = (azke)localIterator.next();
          if (paramMessageForPic.subMsgId == localazke.jdField_a_of_type_Azjx.jdField_g_of_type_Int)
          {
            azjq.a("PIC_TAG_PRELOAD", "getPriority", "uuid: " + paramMessageForPic.uuid + " subMsgId: " + paramMessageForPic.subMsgId);
            int i = localInteger.intValue();
            return i;
          }
        }
      }
      finally {}
    }
    return -1;
  }
  
  azke a(boolean paramBoolean)
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      azke localazke1;
      if (i > 0)
      {
        azjq.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
        localazke1 = (azke)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        if (paramBoolean) {
          this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        }
        return localazke1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          azjq.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
          localazke1 = (azke)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          if (paramBoolean) {
            this.jdField_b_of_type_JavaUtilList.remove(i - 1);
          }
          return localazke1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        azjq.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
        azke localazke2 = (azke)this.c.get(i - 1);
        if (paramBoolean) {
          this.c.remove(i - 1);
        }
        return localazke2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        azjq.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
        azke localazke3 = (azke)this.d.get(i - 1);
        if (paramBoolean) {
          this.d.remove(i - 1);
        }
        return localazke3;
      }
    }
    azjq.a("PIC_TAG_PRELOAD", "getPicRequest", "cannot get any request");
    return null;
  }
  
  protected Collection<azke> a(int paramInt)
  {
    azjq.a("PIC_TAG_PRELOAD", "getRequestsByPriority", "priority=" + paramInt);
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
  
  protected void a(azke paramazke)
  {
    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(paramazke);
    paramazke.f = paramazke.jdField_e_of_type_Int;
    paramazke.jdField_e_of_type_Int = 6;
    this.jdField_a_of_type_JavaUtilMap.put(paramazke.jdField_a_of_type_Azjx.jdField_g_of_type_JavaLangString, Integer.valueOf(6));
    if (paramazke.jdField_a_of_type_Int == 6) {}
    for (String str = " big";; str = " thumb")
    {
      azjq.a("PIC_TAG_PRELOAD", "addToHandlingQueue, cmdStr:" + str, ", uniseq:" + paramazke.jdField_a_of_type_Azjx.a + ", subMsgId:" + paramazke.jdField_a_of_type_Azjx.jdField_g_of_type_Int + ", priority:" + paramazke.jdField_e_of_type_Int);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      return;
    }
  }
  
  protected void a(azke paramazke, int paramInt1, int paramInt2)
  {
    List localList = null;
    String str = "";
    if (paramInt2 == 5)
    {
      localList = this.jdField_a_of_type_JavaUtilList;
      paramazke.jdField_e_of_type_Int = 5;
      str = "AIORequests";
      switch (paramInt1)
      {
      default: 
        paramazke.f = 2;
      }
    }
    for (;;)
    {
      if (localList != null)
      {
        azjq.a("PIC_TAG_PRELOAD", "addBigPicRequest", "successfully to add the pic request to " + str);
        localList.add(paramazke);
        e();
        this.jdField_a_of_type_JavaUtilMap.put(paramazke.jdField_a_of_type_Azjx.jdField_g_of_type_JavaLangString, Integer.valueOf(paramazke.jdField_e_of_type_Int));
      }
      return;
      paramazke.f = 4;
      continue;
      paramazke.f = 3;
      continue;
      if (paramInt2 == 1) {
        switch (paramInt1)
        {
        default: 
          localList = this.d;
          paramazke.jdField_e_of_type_Int = 2;
          paramazke.f = paramazke.jdField_e_of_type_Int;
          str = "GroupRequests";
          break;
        case 3: 
          localList = this.jdField_b_of_type_JavaUtilList;
          paramazke.jdField_e_of_type_Int = 4;
          paramazke.f = paramazke.jdField_e_of_type_Int;
          str = "C2CRequests";
          break;
        case 2: 
          localList = this.c;
          paramazke.jdField_e_of_type_Int = 3;
          paramazke.f = paramazke.jdField_e_of_type_Int;
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
    azke localazke = a(paramString, this.jdField_a_of_type_JavaUtilList);
    if (localazke != null)
    {
      azjq.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localazke.jdField_a_of_type_Azjx.a + ",key:" + paramString + ",cmd:" + localazke.jdField_a_of_type_Int);
      return;
    }
    localazke = a(paramString, this.jdField_b_of_type_JavaUtilList);
    if (localazke != null)
    {
      azjq.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localazke.jdField_a_of_type_Azjx.a + ",key:" + paramString + ",cmd:" + localazke.jdField_a_of_type_Int);
      return;
    }
    localazke = a(paramString, this.c);
    if (localazke != null)
    {
      azjq.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localazke.jdField_a_of_type_Azjx.a + ",key:" + paramString + ",cmd:" + localazke.jdField_a_of_type_Int);
      return;
    }
    localazke = a(paramString, this.d);
    if (localazke != null)
    {
      azjq.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localazke.jdField_a_of_type_Azjx.a + ",key:" + paramString + ",cmd:" + localazke.jdField_a_of_type_Int);
      return;
    }
    azjq.a("PIC_TAG_PRELOAD", "", "drop", "Cannot be found in the request stacks");
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  protected boolean a(azke paramazke)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(paramazke))
    {
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(paramazke);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      this.jdField_a_of_type_JavaUtilMap.remove(paramazke.jdField_a_of_type_Azjx.jdField_g_of_type_JavaLangString);
      azjq.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + paramazke.jdField_a_of_type_Azjx.a + ", cmd:" + paramazke.jdField_a_of_type_Int + ", curHandingNum:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      return true;
    }
    return false;
  }
  
  protected boolean a(MessageForPic paramMessageForPic, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForPic.uuid);
    if (localInteger == null)
    {
      azjq.a("PIC_TAG_PRELOAD", "filter", "uuid=" + paramMessageForPic.uuid + ", priority=" + paramInt + ", cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    azjq.a("PIC_TAG_PRELOAD", "filter", "priority: " + paramInt + ", uniseq: " + paramMessageForPic.uniseq + ", subMsgId:" + paramMessageForPic.subMsgId);
    if (localCollection == null)
    {
      azjq.a("PIC_TAG_PRELOAD", "filter", "originalRequests == null");
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
          localObject2 = (azke)localIterator.next();
          if (paramMessageForPic.subMsgId != ((azke)localObject2).jdField_a_of_type_Azjx.jdField_g_of_type_Int) {
            break label339;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label339;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          azjq.a("PIC_TAG_PRELOAD", "filter", "No need to update the picReq");
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
      azjq.a("PIC_TAG_PRELOAD", "filter", "update the picReq");
      return bool1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    azjq.a("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
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
    azjq.a("PIC_TAG_PRELOAD", "picPreDownloadOn", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
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
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() + this.c.size() + this.d.size() > this.jdField_a_of_type_Azkq.a.longValue()) {
      localObject1 = null;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.d.size() > 0)
        {
          localObject1 = (azke)this.d.remove(0);
          if (localObject1 != null)
          {
            this.jdField_a_of_type_JavaUtilMap.remove(((azke)localObject1).jdField_a_of_type_Azjx.jdField_g_of_type_JavaLangString);
            localObject1 = this.jdField_a_of_type_Azkq;
            ((azkq)localObject1).N += 1L;
            azjq.a("PIC_TAG_PRELOAD", "checkRequestListSize", "over max request list size: " + this.jdField_a_of_type_Azkq.a + ", remove a request");
          }
          return;
        }
        synchronized (this.c)
        {
          if (this.c.size() > 0) {
            localObject1 = (azke)this.c.remove(0);
          }
        }
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
          azke localazke1 = (azke)this.jdField_b_of_type_JavaUtilList.remove(0);
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          azke localazke2 = (azke)this.jdField_a_of_type_JavaUtilList.remove(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloaderCore
 * JD-Core Version:    0.7.0.1
 */