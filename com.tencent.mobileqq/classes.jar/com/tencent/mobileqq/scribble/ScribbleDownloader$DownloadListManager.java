package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.data.MessageForScribble;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ScribbleDownloader$DownloadListManager
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
  
  ScribbleDownloader$DownloadListManager(ScribbleDownloader paramScribbleDownloader)
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
      ScribbleDownloader.a(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleDownloader, "getDownloadingSize", "downing size is " + i);
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
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (paramMessageForScribble.uniseq == ((ScribbleDownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq)
            {
              this.jdField_a_of_type_JavaUtilArrayList.remove(i);
              i = 0;
              return i;
            }
            i += 1;
            continue;
          }
        }
        int i = -1;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public int a(ScribbleDownloadInfo paramScribbleDownloadInfo)
  {
    int k = 1;
    int m = -1;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (paramScribbleDownloadInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq == ((ScribbleDownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq)
            {
              j = 1;
              i = 1;
              if ((j == 0) && (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.size() > 0))
              {
                Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
                if (localIterator.hasNext())
                {
                  ScribbleDownloadInfo localScribbleDownloadInfo = (ScribbleDownloadInfo)localIterator.next();
                  if (localScribbleDownloadInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq != paramScribbleDownloadInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq) {
                    continue;
                  }
                  if (localScribbleDownloadInfo.jdField_a_of_type_Int >= paramScribbleDownloadInfo.jdField_a_of_type_Int) {
                    break label214;
                  }
                  localScribbleDownloadInfo.jdField_a_of_type_Int = paramScribbleDownloadInfo.jdField_a_of_type_Int;
                  break label214;
                  if (j == 0)
                  {
                    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(paramScribbleDownloadInfo);
                    i = 0;
                  }
                  return i;
                }
              }
            }
            else
            {
              i += 1;
              continue;
            }
            continue;
          }
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      int j = 0;
      int i = m;
      continue;
      label214:
      i = 2;
      j = k;
    }
  }
  
  public ScribbleDownloadInfo a()
  {
    ScribbleDownloadInfo localScribbleDownloadInfo = null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.size() > 0)
      {
        localScribbleDownloadInfo = (ScribbleDownloadInfo)this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.poll();
        this.jdField_a_of_type_JavaUtilArrayList.add(localScribbleDownloadInfo);
      }
      return localScribbleDownloadInfo;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleDownloader.DownloadListManager
 * JD-Core Version:    0.7.0.1
 */