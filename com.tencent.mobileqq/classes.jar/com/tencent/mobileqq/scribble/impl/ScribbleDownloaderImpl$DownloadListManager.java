package com.tencent.mobileqq.scribble.impl;

import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.scribble.ScribbleDownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ScribbleDownloaderImpl$DownloadListManager
{
  public final int a = -1;
  public final int b = 0;
  public final int c = 1;
  public final int d = 2;
  public final int e = 0;
  public final int f = -1;
  private PriorityBlockingQueue<ScribbleDownloadInfo> h = new PriorityBlockingQueue();
  private ArrayList<ScribbleDownloadInfo> i = new ArrayList();
  private Lock j = new ReentrantLock();
  
  ScribbleDownloaderImpl$DownloadListManager(ScribbleDownloaderImpl paramScribbleDownloaderImpl) {}
  
  public int a(MessageForScribble paramMessageForScribble)
  {
    this.j.lock();
    try
    {
      int k = this.i.size();
      int m = 0;
      if (k > 0)
      {
        k = 0;
        while (k < this.i.size())
        {
          if (paramMessageForScribble.uniseq == ((ScribbleDownloadInfo)this.i.get(k)).a.uniseq)
          {
            this.i.remove(k);
            k = m;
            break label84;
          }
          k += 1;
        }
      }
      k = -1;
      label84:
      this.j.unlock();
      return k;
    }
    finally
    {
      this.j.unlock();
    }
    for (;;)
    {
      throw paramMessageForScribble;
    }
  }
  
  public int a(ScribbleDownloadInfo paramScribbleDownloadInfo)
  {
    this.j.lock();
    try
    {
      k = this.i.size();
      i2 = 0;
      if (k <= 0) {
        break label236;
      }
      k = 0;
    }
    finally
    {
      for (;;)
      {
        int i2;
        Iterator localIterator;
        ScribbleDownloadInfo localScribbleDownloadInfo;
        this.j.unlock();
        for (;;)
        {
          throw paramScribbleDownloadInfo;
        }
        k += 1;
        continue;
        int k = 0;
        int m = -1;
        continue;
        int i1 = 1;
        int n = 2;
      }
    }
    if (k < this.i.size()) {
      if (paramScribbleDownloadInfo.a.uniseq == ((ScribbleDownloadInfo)this.i.get(k)).a.uniseq)
      {
        k = 1;
        m = 1;
        i1 = k;
        n = m;
        if (k == 0)
        {
          i1 = k;
          n = m;
          if (this.h.size() > 0)
          {
            localIterator = this.h.iterator();
            do
            {
              i1 = k;
              n = m;
              if (!localIterator.hasNext()) {
                break;
              }
              localScribbleDownloadInfo = (ScribbleDownloadInfo)localIterator.next();
            } while (localScribbleDownloadInfo.a.uniseq != paramScribbleDownloadInfo.a.uniseq);
            if (localScribbleDownloadInfo.b >= paramScribbleDownloadInfo.b) {
              break label243;
            }
            localScribbleDownloadInfo.b = paramScribbleDownloadInfo.b;
            break label243;
          }
        }
        if (i1 == 0)
        {
          this.h.add(paramScribbleDownloadInfo);
          n = i2;
        }
        this.j.unlock();
        return n;
      }
    }
  }
  
  public ScribbleDownloadInfo a()
  {
    this.j.lock();
    try
    {
      ScribbleDownloadInfo localScribbleDownloadInfo;
      if (this.h.size() > 0)
      {
        localScribbleDownloadInfo = (ScribbleDownloadInfo)this.h.poll();
        this.i.add(localScribbleDownloadInfo);
      }
      else
      {
        localScribbleDownloadInfo = null;
      }
      return localScribbleDownloadInfo;
    }
    finally
    {
      this.j.unlock();
    }
  }
  
  public int b()
  {
    this.j.lock();
    try
    {
      int k = this.i.size();
      this.j.unlock();
      ScribbleDownloaderImpl localScribbleDownloaderImpl = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downing size is ");
      localStringBuilder.append(k);
      ScribbleDownloaderImpl.access$000(localScribbleDownloaderImpl, "getDownloadingSize", localStringBuilder.toString());
      return k;
    }
    finally
    {
      this.j.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.impl.ScribbleDownloaderImpl.DownloadListManager
 * JD-Core Version:    0.7.0.1
 */