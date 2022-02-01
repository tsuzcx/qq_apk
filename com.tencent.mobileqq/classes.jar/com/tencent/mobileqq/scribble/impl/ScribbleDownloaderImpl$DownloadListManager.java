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
  public final int a;
  private ArrayList<ScribbleDownloadInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private PriorityBlockingQueue<ScribbleDownloadInfo> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public final int b = 0;
  public final int c = 1;
  public final int d = 2;
  public final int e = 0;
  public final int f = -1;
  
  ScribbleDownloaderImpl$DownloadListManager(ScribbleDownloaderImpl paramScribbleDownloaderImpl)
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.size();
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      ScribbleDownloaderImpl localScribbleDownloaderImpl = this.jdField_a_of_type_ComTencentMobileqqScribbleImplScribbleDownloaderImpl;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downing size is ");
      localStringBuilder.append(i);
      ScribbleDownloaderImpl.access$000(localScribbleDownloaderImpl, "getDownloadingSize", localStringBuilder.toString());
      return i;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public int a(MessageForScribble paramMessageForScribble)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.size();
      int j = 0;
      if (i > 0)
      {
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (paramMessageForScribble.uniseq == ((ScribbleDownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq)
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(i);
            i = j;
            break label84;
          }
          i += 1;
        }
      }
      i = -1;
      label84:
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      return i;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    for (;;)
    {
      throw paramMessageForScribble;
    }
  }
  
  public int a(ScribbleDownloadInfo paramScribbleDownloadInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
      n = 0;
      if (i <= 0) {
        break label236;
      }
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int n;
        Iterator localIterator;
        ScribbleDownloadInfo localScribbleDownloadInfo;
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        for (;;)
        {
          throw paramScribbleDownloadInfo;
        }
        i += 1;
        continue;
        int i = 0;
        int j = -1;
        continue;
        int m = 1;
        int k = 2;
      }
    }
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (paramScribbleDownloadInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq == ((ScribbleDownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq)
      {
        i = 1;
        j = 1;
        m = i;
        k = j;
        if (i == 0)
        {
          m = i;
          k = j;
          if (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.size() > 0)
          {
            localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
            do
            {
              m = i;
              k = j;
              if (!localIterator.hasNext()) {
                break;
              }
              localScribbleDownloadInfo = (ScribbleDownloadInfo)localIterator.next();
            } while (localScribbleDownloadInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq != paramScribbleDownloadInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq);
            if (localScribbleDownloadInfo.jdField_a_of_type_Int >= paramScribbleDownloadInfo.jdField_a_of_type_Int) {
              break label243;
            }
            localScribbleDownloadInfo.jdField_a_of_type_Int = paramScribbleDownloadInfo.jdField_a_of_type_Int;
            break label243;
          }
        }
        if (m == 0)
        {
          this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(paramScribbleDownloadInfo);
          k = n;
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return k;
      }
    }
  }
  
  public ScribbleDownloadInfo a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      ScribbleDownloadInfo localScribbleDownloadInfo;
      if (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.size() > 0)
      {
        localScribbleDownloadInfo = (ScribbleDownloadInfo)this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.poll();
        this.jdField_a_of_type_JavaUtilArrayList.add(localScribbleDownloadInfo);
      }
      else
      {
        localScribbleDownloadInfo = null;
      }
      return localScribbleDownloadInfo;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.impl.ScribbleDownloaderImpl.DownloadListManager
 * JD-Core Version:    0.7.0.1
 */