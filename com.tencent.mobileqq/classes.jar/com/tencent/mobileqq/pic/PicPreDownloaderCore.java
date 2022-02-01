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
  protected Map<String, Integer> a = Collections.synchronizedMap(new HashMap());
  private AtomicInteger b = new AtomicInteger();
  private AtomicInteger c = new AtomicInteger();
  private PreDownloadStrategyBeta d;
  private PicPreDownloader e;
  private MqqHandler f;
  private Runnable g;
  private AtomicBoolean h = new AtomicBoolean(false);
  private PriorityBlockingQueue<PicReq> i = new PriorityBlockingQueue();
  private ConcurrentLinkedQueue<PicPreDownloaderCore.PicPreDownRunner> j = new ConcurrentLinkedQueue();
  private final List<PicReq> k = Collections.synchronizedList(new LinkedList());
  private final List<PicReq> l = Collections.synchronizedList(new LinkedList());
  private final List<PicReq> m = Collections.synchronizedList(new LinkedList());
  private final List<PicReq> n = Collections.synchronizedList(new LinkedList());
  private final List<PicReq> o = Collections.synchronizedList(new LinkedList());
  
  public PicPreDownloaderCore(PicPreDownloader paramPicPreDownloader, PreDownloadStrategyBeta paramPreDownloadStrategyBeta)
  {
    this.e = paramPicPreDownloader;
    this.d = paramPreDownloadStrategyBeta;
    this.f = ThreadManager.getSubThreadHandler();
    this.g = new PicPreDownloaderCore.1(this);
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
        } while (localPicReq.f == null);
        i1 = localPicReq.f.t;
        bool = true;
        if (i1 != 1) {
          break label180;
        }
      }
      finally
      {
        for (;;)
        {
          PicReq localPicReq;
          int i1;
          String str;
          for (;;)
          {
            throw paramString;
          }
          boolean bool = false;
        }
      }
      i1 = ((IPicHelper)QRoute.api(IPicHelper.class)).getFileSizeType(localPicReq.f.l, bool);
      str = BaseTransFileController.makeReceiveKey(localPicReq.f.m, localPicReq.f.n, i1);
    } while ((paramString == null) || (!paramString.equals(str)));
    paramCollection.remove(localPicReq);
    this.a.remove(localPicReq.f.n);
    this.e.a(localPicReq.l, -5);
    return localPicReq;
    return null;
  }
  
  private void h()
  {
    if (this.b.get() < 3)
    {
      PicPreDownloaderCore.PicPreDownRunner localPicPreDownRunner = (PicPreDownloaderCore.PicPreDownRunner)this.j.poll();
      if (localPicPreDownRunner != null)
      {
        this.b.incrementAndGet();
        ThreadManager.excute(localPicPreDownRunner, 16, null, false);
      }
    }
  }
  
  protected int a(MessageForPic paramMessageForPic)
  {
    Integer localInteger = (Integer)this.a.get(paramMessageForPic.uuid);
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
          if (paramMessageForPic.subMsgId == localPicReq.f.C)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("uuid: ");
            ((StringBuilder)localObject).append(paramMessageForPic.uuid);
            ((StringBuilder)localObject).append(" subMsgId: ");
            ((StringBuilder)localObject).append(paramMessageForPic.subMsgId);
            Logger.a("PIC_TAG_PRELOAD", "getPriority", ((StringBuilder)localObject).toString());
            int i1 = localInteger.intValue();
            return i1;
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
    synchronized (this.k)
    {
      int i1 = this.k.size();
      Object localObject1;
      if (i1 > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
        localObject1 = this.k;
        i1 -= 1;
        localObject1 = (PicReq)((List)localObject1).get(i1);
        if (paramBoolean) {
          this.k.remove(i1);
        }
        return localObject1;
      }
      synchronized (this.l)
      {
        i1 = this.l.size();
        if (i1 > 0)
        {
          Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
          localObject1 = this.l;
          i1 -= 1;
          localObject1 = (PicReq)((List)localObject1).get(i1);
          if (paramBoolean) {
            this.l.remove(i1);
          }
          return localObject1;
        }
        synchronized (this.m)
        {
          i1 = this.m.size();
          if (i1 > 0)
          {
            Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GuildRequests");
            localObject1 = this.m;
            i1 -= 1;
            localObject1 = (PicReq)((List)localObject1).get(i1);
            if (paramBoolean) {
              this.m.remove(i1);
            }
            return localObject1;
          }
          synchronized (this.n)
          {
            i1 = this.n.size();
            if (i1 > 0)
            {
              Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
              localObject1 = this.n;
              i1 -= 1;
              localObject1 = (PicReq)((List)localObject1).get(i1);
              if (paramBoolean) {
                this.n.remove(i1);
              }
              return localObject1;
            }
            synchronized (this.o)
            {
              i1 = this.o.size();
              if (i1 > 0)
              {
                Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
                localObject1 = this.o;
                i1 -= 1;
                localObject1 = (PicReq)((List)localObject1).get(i1);
                if (paramBoolean) {
                  this.o.remove(i1);
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
  }
  
  protected Collection<PicReq> a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("priority=");
    localStringBuilder.append(paramInt);
    Logger.a("PIC_TAG_PRELOAD", "getRequestsByPriority", localStringBuilder.toString());
    switch (paramInt)
    {
    default: 
      return null;
    case 7: 
      return this.i;
    case 6: 
      return this.k;
    case 5: 
      return this.l;
    case 4: 
      return this.m;
    case 3: 
      return this.n;
    }
    return this.o;
  }
  
  protected void a()
  {
    MqqHandler localMqqHandler = this.f;
    if (localMqqHandler != null)
    {
      Runnable localRunnable = this.g;
      if (localRunnable != null) {
        localMqqHandler.removeCallbacks(localRunnable);
      }
    }
  }
  
  protected void a(PicReq paramPicReq)
  {
    this.i.add(paramPicReq);
    paramPicReq.p = paramPicReq.o;
    paramPicReq.o = 7;
    this.a.put(paramPicReq.f.n, Integer.valueOf(7));
    if (paramPicReq.a == 6) {
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
    localStringBuilder.append(paramPicReq.f.g);
    localStringBuilder.append(", subMsgId:");
    localStringBuilder.append(paramPicReq.f.C);
    localStringBuilder.append(", priority:");
    localStringBuilder.append(paramPicReq.o);
    Logger.a("PIC_TAG_PRELOAD", str, localStringBuilder.toString());
    this.c.addAndGet(1);
  }
  
  protected void a(PicReq paramPicReq, int paramInt1, int paramInt2)
  {
    List localList;
    String str;
    if (paramInt2 == 6)
    {
      localList = this.k;
      paramPicReq.o = 6;
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4) {
            paramPicReq.p = 2;
          } else {
            paramPicReq.p = 4;
          }
        }
        else {
          paramPicReq.p = 5;
        }
      }
      else {
        paramPicReq.p = 3;
      }
      str = "AIORequests";
    }
    else if (paramInt2 == 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            localList = this.o;
            paramPicReq.o = 2;
            paramPicReq.p = paramPicReq.o;
            str = "GroupRequests";
          }
          else
          {
            localList = this.m;
            paramPicReq.o = 4;
            paramPicReq.p = paramPicReq.o;
            str = "GuildRequests";
          }
        }
        else
        {
          localList = this.l;
          paramPicReq.o = 5;
          paramPicReq.p = paramPicReq.o;
          str = "C2CRequests";
        }
      }
      else
      {
        localList = this.n;
        paramPicReq.o = 3;
        paramPicReq.p = paramPicReq.o;
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
      f();
      this.a.put(paramPicReq.f.n, Integer.valueOf(paramPicReq.o));
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
    this.j.offer(new PicPreDownloaderCore.PicPreDownRunner(this, paramRunnable, (String)localObject));
    h();
  }
  
  public void a(String paramString)
  {
    PicReq localPicReq = a(paramString, this.k);
    StringBuilder localStringBuilder;
    if (localPicReq != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("From AIORequests, uniseq:");
      localStringBuilder.append(localPicReq.f.g);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",cmd:");
      localStringBuilder.append(localPicReq.a);
      Logger.a("PIC_TAG_PRELOAD", "", "drop", localStringBuilder.toString());
      return;
    }
    localPicReq = a(paramString, this.l);
    if (localPicReq != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("From AIORequests, uniseq:");
      localStringBuilder.append(localPicReq.f.g);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",cmd:");
      localStringBuilder.append(localPicReq.a);
      Logger.a("PIC_TAG_PRELOAD", "", "drop", localStringBuilder.toString());
      return;
    }
    localPicReq = a(paramString, this.m);
    if (localPicReq != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("From AIORequests, uniseq:");
      localStringBuilder.append(localPicReq.f.g);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",cmd:");
      localStringBuilder.append(localPicReq.a);
      Logger.a("PIC_TAG_PRELOAD", "", "drop", localStringBuilder.toString());
      return;
    }
    localPicReq = a(paramString, this.n);
    if (localPicReq != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("From AIORequests, uniseq:");
      localStringBuilder.append(localPicReq.f.g);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",cmd:");
      localStringBuilder.append(localPicReq.a);
      Logger.a("PIC_TAG_PRELOAD", "", "drop", localStringBuilder.toString());
      return;
    }
    localPicReq = a(paramString, this.o);
    if (localPicReq != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("From AIORequests, uniseq:");
      localStringBuilder.append(localPicReq.f.g);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",cmd:");
      localStringBuilder.append(localPicReq.a);
      Logger.a("PIC_TAG_PRELOAD", "", "drop", localStringBuilder.toString());
      return;
    }
    Logger.a("PIC_TAG_PRELOAD", "", "drop", "Cannot be found in the request stacks");
  }
  
  protected boolean a(MessageForPic paramMessageForPic, int paramInt)
  {
    Integer localInteger = (Integer)this.a.get(paramMessageForPic.uuid);
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
        if (paramMessageForPic.subMsgId == ((PicReq)localObject2).f.C)
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
          ((PicReq)localObject1).p = ((PicReq)localObject1).o;
          ((PicReq)localObject1).o = paramInt;
          localCollection.remove(localObject1);
          ((Collection)localObject2).add(localObject1);
          this.a.put(paramMessageForPic.uuid, Integer.valueOf(paramInt));
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
  
  protected boolean b()
  {
    return this.h.get();
  }
  
  protected boolean b(PicReq paramPicReq)
  {
    if (this.i.contains(paramPicReq))
    {
      this.i.remove(paramPicReq);
      this.c.decrementAndGet();
      this.a.remove(paramPicReq.f.n);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uniseq:");
      localStringBuilder.append(paramPicReq.f.g);
      localStringBuilder.append(", cmd:");
      localStringBuilder.append(paramPicReq.a);
      localStringBuilder.append(", curHandingNum:");
      localStringBuilder.append(this.c.get());
      Logger.a("PIC_TAG_PRELOAD", "onDownload", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.h.set(false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mIsPicPreloadSuitable:");
    ((StringBuilder)localObject).append(this.h.get());
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOff", ((StringBuilder)localObject).toString());
    localObject = this.f;
    if (localObject != null)
    {
      Runnable localRunnable = this.g;
      if (localRunnable != null)
      {
        ((MqqHandler)localObject).removeCallbacks(localRunnable);
        this.f.postDelayed(this.g, 60000L);
      }
    }
  }
  
  public void d()
  {
    this.h.set(true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsPicPreloadSuitable:");
    localStringBuilder.append(this.h.get());
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOn", localStringBuilder.toString());
    this.e.d();
  }
  
  public void e()
  {
    try
    {
      int i1 = this.k.size();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("clearAIORequests(): AIORequests size=");
        localStringBuilder1.append(i1);
        QLog.d("PIC_TAG_PRELOAD", 2, localStringBuilder1.toString());
      }
      ThreadManager.excute(new PicPreDownloaderCore.2(this, i1), 16, null, false);
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
  
  protected void f()
  {
    if (this.k.size() + this.l.size() + this.n.size() + this.o.size() + this.m.size() > this.d.ab.longValue())
    {
      Object localObject1 = null;
      synchronized (this.o)
      {
        if (this.o.size() > 0) {
          localObject1 = (PicReq)this.o.remove(0);
        }
        synchronized (this.n)
        {
          if (this.n.size() > 0) {
            localObject1 = (PicReq)this.n.remove(0);
          }
          synchronized (this.m)
          {
            if (this.m.size() > 0) {
              localObject1 = (PicReq)this.m.remove(0);
            }
            synchronized (this.l)
            {
              if (this.l.size() > 0) {
                localObject1 = (PicReq)this.l.remove(0);
              }
              synchronized (this.k)
              {
                if (this.k.size() > 0) {
                  localObject1 = (PicReq)this.k.remove(0);
                }
                if (localObject1 != null)
                {
                  this.a.remove(((PicReq)localObject1).f.n);
                  localObject1 = this.d;
                  ((PreDownloadStrategyBeta)localObject1).Q += 1L;
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("over max request list size: ");
                  ((StringBuilder)localObject1).append(this.d.ab);
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
  
  protected boolean g()
  {
    return this.c.get() < 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloaderCore
 * JD-Core Version:    0.7.0.1
 */