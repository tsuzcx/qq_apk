package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class DataRangeTracker
{
  private static final long LOCK_INTERVAL = 1000L;
  private static final String TAG = "DataRangeTracker";
  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private Comparator<DataRangeTracker.Range> mComparator = new DataRangeTracker.1(this);
  private final ArrayList<DataRangeTracker.Range> mDownloadDataList = new ArrayList();
  private long mFileTotalSize = 0L;
  private long waitingPosition;
  private int waitingSize;
  
  private void lockRead()
  {
    this.lock.readLock().lock();
  }
  
  private void unlock()
  {
    try
    {
      Logger.i("DataRangeTracker", "[unlock].");
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void unlockRead()
  {
    this.lock.readLock().unlock();
  }
  
  public void abandonLock()
  {
    Logger.i("DataRangeTracker", "[abandonLock]");
    unblock();
    unlock();
  }
  
  public void addRange(long paramLong1, long paramLong2)
  {
    int j = 1;
    if (paramLong1 > paramLong2)
    {
      Logger.e("DataRangeTracker", "[addRange] illegal arguments! beginPos(%s) > endPos(%s)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    this.lock.writeLock().lock();
    try
    {
      localArrayList = new ArrayList();
      this.mDownloadDataList.add(new DataRangeTracker.Range(paramLong1, paramLong2, null));
      Collections.sort(this.mDownloadDataList, this.mComparator);
      k = this.mDownloadDataList.size() - 1;
      localObject1 = (DataRangeTracker.Range)this.mDownloadDataList.get(0);
      if (k <= 0) {
        break label279;
      }
      i = 1;
    }
    finally
    {
      for (;;)
      {
        ArrayList localArrayList;
        int k;
        Object localObject1;
        int i;
        DataRangeTracker.Range localRange;
        label279:
        boolean bool;
        label324:
        this.lock.writeLock().unlock();
        for (;;)
        {
          throw localObject3;
        }
        i += 1;
      }
    }
    if (i <= k)
    {
      localRange = (DataRangeTracker.Range)this.mDownloadDataList.get(i);
      if (DataRangeTracker.Range.access$100((DataRangeTracker.Range)localObject1) + 1L < DataRangeTracker.Range.access$200(localRange))
      {
        localArrayList.add(new DataRangeTracker.Range(DataRangeTracker.Range.access$200((DataRangeTracker.Range)localObject1), DataRangeTracker.Range.access$100((DataRangeTracker.Range)localObject1), null));
        localObject1 = new DataRangeTracker.Range(DataRangeTracker.Range.access$200(localRange), DataRangeTracker.Range.access$100(localRange), null);
      }
      else
      {
        if (DataRangeTracker.Range.access$100((DataRangeTracker.Range)localObject1) > DataRangeTracker.Range.access$100(localRange)) {
          paramLong1 = DataRangeTracker.Range.access$100((DataRangeTracker.Range)localObject1);
        } else {
          paramLong1 = DataRangeTracker.Range.access$100(localRange);
        }
        localObject1 = new DataRangeTracker.Range(DataRangeTracker.Range.access$200((DataRangeTracker.Range)localObject1), paramLong1, null);
      }
      if (i >= k) {
        localArrayList.add(localObject1);
      }
    }
    else
    {
      this.mDownloadDataList.clear();
      this.mDownloadDataList.addAll(localArrayList);
      if ((this.waitingPosition >= 0L) && (this.waitingSize > 0))
      {
        bool = isCached(this.waitingPosition, this.waitingSize);
        if (bool)
        {
          i = j;
          break label324;
        }
      }
      i = 0;
      this.lock.writeLock().unlock();
      if (i != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[addRange] notify position: ");
        ((StringBuilder)localObject1).append(this.waitingPosition);
        ((StringBuilder)localObject1).append(", size: ");
        ((StringBuilder)localObject1).append(this.waitingSize);
        Logger.i("DataRangeTracker", ((StringBuilder)localObject1).toString());
        try
        {
          this.waitingPosition = 0L;
          this.waitingSize = 0;
          return;
        }
        finally {}
      }
      return;
    }
  }
  
  public void block()
  {
    Logger.i("DataRangeTracker", "[block]");
  }
  
  public long findEnd(long paramLong)
  {
    lockRead();
    for (;;)
    {
      try
      {
        j = this.mDownloadDataList.size();
        if (j != 0) {
          continue;
        }
        paramLong = -1L;
      }
      finally
      {
        int j;
        int i;
        int k;
        unlockRead();
        continue;
        throw localObject;
        continue;
        paramLong -= 1L;
        continue;
      }
      unlockRead();
      return paramLong;
      i = 0;
      if (i < j)
      {
        if (paramLong < DataRangeTracker.Range.access$200((DataRangeTracker.Range)this.mDownloadDataList.get(i)))
        {
          paramLong = DataRangeTracker.Range.access$200((DataRangeTracker.Range)this.mDownloadDataList.get(i));
          continue;
        }
        if (paramLong <= DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(i)))
        {
          k = i + 1;
          if (k < j)
          {
            paramLong = DataRangeTracker.Range.access$200((DataRangeTracker.Range)this.mDownloadDataList.get(k));
            continue;
          }
        }
        i += 1;
      }
      else
      {
        paramLong = 0L;
      }
    }
  }
  
  public long findStart(long paramLong)
  {
    lockRead();
    for (;;)
    {
      int i;
      try
      {
        int j = this.mDownloadDataList.size();
        if (j == 0)
        {
          paramLong = -1L;
          unlockRead();
          return paramLong;
        }
        ArrayList localArrayList = this.mDownloadDataList;
        i = 0;
        long l1 = DataRangeTracker.Range.access$100((DataRangeTracker.Range)localArrayList.get(0)) + 1L;
        if (i < j)
        {
          long l2 = DataRangeTracker.Range.access$200((DataRangeTracker.Range)this.mDownloadDataList.get(i));
          if (paramLong < l2)
          {
            unlockRead();
            return l1;
          }
          l1 = DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(i)) + 1L;
          if (paramLong > DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(i))) {
            break label191;
          }
          paramLong = DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(i));
        }
        else
        {
          paramLong = DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(this.mDownloadDataList.size() - 1));
        }
      }
      finally
      {
        unlockRead();
      }
      for (;;)
      {
        throw localObject;
      }
      paramLong += 1L;
      continue;
      label191:
      i += 1;
    }
  }
  
  public long getContinuousEnd()
  {
    lockRead();
    try
    {
      int i = this.mDownloadDataList.size();
      if (i == 0) {
        return -1L;
      }
      long l = DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(0));
      return l;
    }
    finally
    {
      unlockRead();
    }
  }
  
  public long getContinuousStart()
  {
    lockRead();
    try
    {
      int i = this.mDownloadDataList.size();
      if (i == 0) {
        return -1L;
      }
      long l = DataRangeTracker.Range.access$200((DataRangeTracker.Range)this.mDownloadDataList.get(0));
      return l;
    }
    finally
    {
      unlockRead();
    }
  }
  
  List<DataRangeTracker.Range> getEmptyContentPairList(long paramLong)
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.mDownloadDataList)
    {
      Iterator localIterator = this.mDownloadDataList.iterator();
      DataRangeTracker.Range localRange;
      for (long l = 0L; localIterator.hasNext(); l = DataRangeTracker.Range.access$100(localRange) + 1L)
      {
        localRange = (DataRangeTracker.Range)localIterator.next();
        if (l < DataRangeTracker.Range.access$200(localRange)) {
          localArrayList2.add(new DataRangeTracker.Range(l, DataRangeTracker.Range.access$200(localRange) - 1L, null));
        }
      }
      if (l < paramLong) {
        localArrayList2.add(new DataRangeTracker.Range(l, paramLong - 1L, null));
      }
      return localArrayList2;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean isCached(long paramLong, int paramInt)
  {
    lockRead();
    try
    {
      long l2 = findStart(paramLong);
      long l1 = paramInt + paramLong;
      long l3 = findStart(l1);
      paramLong = findEnd(paramLong);
      long l4 = findEnd(l1);
      boolean bool = false;
      if ((l2 == l3) && (paramLong == l4))
      {
        if (paramLong == -1L) {
          return false;
        }
        paramLong = l1;
        if (this.mFileTotalSize > 0L)
        {
          paramLong = l1;
          if (l1 > this.mFileTotalSize) {
            paramLong = this.mFileTotalSize;
          }
        }
        if (paramLong <= l2) {
          bool = true;
        }
        return bool;
      }
      return false;
    }
    finally
    {
      unlockRead();
    }
  }
  
  public boolean lock(long paramLong1, int paramInt, long paramLong2)
  {
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[lock] position = [");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append("]. size = [");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]. timeout = [");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append("].");
        Logger.i("DataRangeTracker", localStringBuilder.toString());
        this.waitingPosition = paramLong1;
        this.waitingSize = paramInt;
        j = (int)(paramLong2 / 1000L);
        i = j;
        if (j > 0) {
          continue;
        }
        i = 1;
      }
      finally
      {
        StringBuilder localStringBuilder;
        int i;
        continue;
        throw localObject;
        continue;
        int j = 0;
        continue;
      }
      if (j >= i) {
        continue;
      }
      wait(1000L);
      if (isCached(this.waitingPosition, this.waitingSize)) {
        continue;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("continue [lock] position = [");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]. size = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]. totalSize = [");
      localStringBuilder.append(this.mFileTotalSize);
      localStringBuilder.append("]. findStart(position) = [");
      localStringBuilder.append(findStart(paramLong1));
      localStringBuilder.append("].");
      Logger.i("DataRangeTracker", localStringBuilder.toString());
      j += 1;
    }
    return true;
  }
  
  public String print()
  {
    try
    {
      this.lock.readLock().lock();
      try
      {
        Object localObject1 = new StringBuilder();
        int i = 0;
        while (i < this.mDownloadDataList.size())
        {
          ((StringBuilder)localObject1).append(((DataRangeTracker.Range)this.mDownloadDataList.get(i)).toString());
          i += 1;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        this.lock.readLock().unlock();
        return localObject1;
      }
      finally
      {
        this.lock.readLock().unlock();
      }
      throw localObject3;
    }
    finally {}
    for (;;) {}
  }
  
  public void setFileTotalSize(long paramLong)
  {
    this.mFileTotalSize = paramLong;
  }
  
  public void unblock()
  {
    Logger.i("DataRangeTracker", "[unblock]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.DataRangeTracker
 * JD-Core Version:    0.7.0.1
 */