package com.tencent.mobileqq.data;

import java.util.ArrayList;
import java.util.Iterator;

public class DataLineMsgSetList
  implements Iterable<DataLineMsgSet>
{
  ArrayList<DataLineMsgSet> mList = new ArrayList();
  private long nFirstId = 0L;
  private long nLastId = 0L;
  
  private void checkFirstLastIdByAddOrModify(DataLineMsgSet paramDataLineMsgSet)
  {
    long l = this.nFirstId;
    if ((l == 0L) || (l > paramDataLineMsgSet.getFirstId())) {
      this.nFirstId = paramDataLineMsgSet.getFirstId();
    }
    l = this.nLastId;
    if ((l == 0L) || (l < paramDataLineMsgSet.getLastId())) {
      this.nLastId = paramDataLineMsgSet.getLastId();
    }
  }
  
  private void checkFirstLastIdByRemove()
  {
    this.nFirstId = 0L;
    this.nLastId = 0L;
    Iterator localIterator = this.mList.iterator();
    while (localIterator.hasNext()) {
      checkFirstLastIdByAddOrModify((DataLineMsgSet)localIterator.next());
    }
  }
  
  public DataLineMsgSet appendToList(DataLineMsgRecord paramDataLineMsgRecord)
  {
    try
    {
      Object localObject1;
      if (DataLineMsgSet.isSingle(paramDataLineMsgRecord))
      {
        localObject1 = new DataLineMsgSet(0);
        ((DataLineMsgSet)localObject1).put(Integer.valueOf(0), paramDataLineMsgRecord);
        this.mList.add(localObject1);
        checkFirstLastIdByAddOrModify((DataLineMsgSet)localObject1);
        return localObject1;
      }
      Object localObject2 = null;
      Iterator localIterator = this.mList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (DataLineMsgSet)localIterator.next();
      } while ((((DataLineMsgSet)localObject1).getGroupId() != paramDataLineMsgRecord.groupId) || (((DataLineMsgSet)localObject1).isSendFromLocal() != paramDataLineMsgRecord.isSendFromLocal()));
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new DataLineMsgSet(paramDataLineMsgRecord.groupId);
        this.mList.add(localObject2);
      }
      ((DataLineMsgSet)localObject2).put(Integer.valueOf(paramDataLineMsgRecord.groupIndex), paramDataLineMsgRecord);
      checkFirstLastIdByAddOrModify((DataLineMsgSet)localObject2);
      return localObject2;
    }
    finally {}
    for (;;)
    {
      throw paramDataLineMsgRecord;
    }
  }
  
  public void appendToList(DataLineMsgSet paramDataLineMsgSet)
  {
    try
    {
      if ((!this.mList.contains(paramDataLineMsgSet)) || (paramDataLineMsgSet.getFirstItem().msgtype == -2073))
      {
        this.mList.add(paramDataLineMsgSet);
        checkFirstLastIdByAddOrModify(paramDataLineMsgSet);
      }
      return;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      this.mList.clear();
      this.nFirstId = 0L;
      this.nLastId = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DataLineMsgSetList clone()
  {
    DataLineMsgSetList localDataLineMsgSetList = new DataLineMsgSetList();
    Iterator localIterator = this.mList.iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgSet localDataLineMsgSet = (DataLineMsgSet)localIterator.next();
      localDataLineMsgSetList.mList.add(localDataLineMsgSet);
    }
    localDataLineMsgSetList.nFirstId = this.nFirstId;
    localDataLineMsgSetList.nLastId = this.nLastId;
    return localDataLineMsgSetList;
  }
  
  public void copyFrom(DataLineMsgSetList paramDataLineMsgSetList)
  {
    Iterator localIterator = paramDataLineMsgSetList.iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgSet localDataLineMsgSet = (DataLineMsgSet)localIterator.next();
      this.mList.add(localDataLineMsgSet);
    }
    this.nFirstId = paramDataLineMsgSetList.nFirstId;
    this.nLastId = paramDataLineMsgSetList.nLastId;
  }
  
  public DataLineMsgSet get(int paramInt)
  {
    return (DataLineMsgSet)this.mList.get(paramInt);
  }
  
  public long getFirstId()
  {
    return this.nFirstId;
  }
  
  public long getLastId()
  {
    return this.nLastId;
  }
  
  public int getSetIndex(long paramLong)
  {
    Iterator localIterator1 = this.mList.iterator();
    int i = 0;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
      while (localIterator2.hasNext()) {
        if (((DataLineMsgRecord)localIterator2.next()).sessionid == paramLong) {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public boolean insertFrontToList(DataLineMsgRecord paramDataLineMsgRecord)
  {
    try
    {
      boolean bool3 = DataLineMsgSet.isSingle(paramDataLineMsgRecord);
      boolean bool2 = true;
      bool1 = true;
      if (bool3)
      {
        localObject1 = new DataLineMsgSet(0);
        ((DataLineMsgSet)localObject1).put(Integer.valueOf(0), paramDataLineMsgRecord);
        this.mList.add(0, localObject1);
        checkFirstLastIdByAddOrModify((DataLineMsgSet)localObject1);
        bool1 = bool2;
        break label172;
      }
      Object localObject2 = null;
      Iterator localIterator = this.mList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (DataLineMsgSet)localIterator.next();
      } while ((((DataLineMsgSet)localObject1).getGroupId() != paramDataLineMsgRecord.groupId) || (((DataLineMsgSet)localObject1).isSendFromLocal() != paramDataLineMsgRecord.isSendFromLocal()));
      if (localObject1 != null) {
        break label187;
      }
      localObject1 = new DataLineMsgSet(paramDataLineMsgRecord.groupId);
      this.mList.add(0, localObject1);
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        for (;;)
        {
          label172:
          throw paramDataLineMsgRecord;
        }
        label187:
        boolean bool1 = false;
      }
    }
    ((DataLineMsgSet)localObject1).put(Integer.valueOf(paramDataLineMsgRecord.groupIndex), paramDataLineMsgRecord);
    checkFirstLastIdByAddOrModify((DataLineMsgSet)localObject1);
    return bool1;
  }
  
  public boolean isEmpty()
  {
    return this.mList.isEmpty();
  }
  
  public Iterator<DataLineMsgSet> iterator()
  {
    return this.mList.iterator();
  }
  
  public DataLineMsgSet remove(int paramInt)
  {
    try
    {
      DataLineMsgSet localDataLineMsgSet = (DataLineMsgSet)this.mList.remove(paramInt);
      checkFirstLastIdByRemove();
      return localDataLineMsgSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean remove(DataLineMsgSet paramDataLineMsgSet)
  {
    try
    {
      Iterator localIterator = this.mList.iterator();
      while (localIterator.hasNext())
      {
        DataLineMsgSet localDataLineMsgSet = (DataLineMsgSet)localIterator.next();
        if (localDataLineMsgSet.equals(paramDataLineMsgSet))
        {
          boolean bool = this.mList.remove(localDataLineMsgSet);
          checkFirstLastIdByRemove();
          return bool;
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramDataLineMsgSet;
    }
  }
  
  public int size()
  {
    return this.mList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DataLineMsgSetList
 * JD-Core Version:    0.7.0.1
 */