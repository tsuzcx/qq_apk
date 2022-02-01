package com.tencent.mobileqq.data;

import java.util.ArrayList;
import java.util.Iterator;

public class DataLineMsgSetList
  implements Iterable<DataLineMsgSet>
{
  ArrayList<DataLineMsgSet> mList = new ArrayList();
  private long nFirstId;
  private long nLastId;
  
  private void checkFirstLastIdByAddOrModify(DataLineMsgSet paramDataLineMsgSet)
  {
    if ((this.nFirstId == 0L) || (this.nFirstId > paramDataLineMsgSet.getFirstId())) {
      this.nFirstId = paramDataLineMsgSet.getFirstId();
    }
    if ((this.nLastId == 0L) || (this.nLastId < paramDataLineMsgSet.getLastId())) {
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
    for (;;)
    {
      try
      {
        if (DataLineMsgSet.isSingle(paramDataLineMsgRecord))
        {
          localObject = new DataLineMsgSet(0);
          ((DataLineMsgSet)localObject).put(Integer.valueOf(0), paramDataLineMsgRecord);
          this.mList.add(localObject);
          checkFirstLastIdByAddOrModify((DataLineMsgSet)localObject);
          return localObject;
        }
        Object localObject = this.mList.iterator();
        DataLineMsgSet localDataLineMsgSet;
        if (((Iterator)localObject).hasNext())
        {
          localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject).next();
          if ((localDataLineMsgSet.getGroupId() == paramDataLineMsgRecord.groupId) && (localDataLineMsgSet.isSendFromLocal() == paramDataLineMsgRecord.isSendFromLocal()))
          {
            localObject = localDataLineMsgSet;
            if (localDataLineMsgSet == null)
            {
              localObject = new DataLineMsgSet(paramDataLineMsgRecord.groupId);
              this.mList.add(localObject);
            }
            ((DataLineMsgSet)localObject).put(Integer.valueOf(paramDataLineMsgRecord.groupIndex), paramDataLineMsgRecord);
            checkFirstLastIdByAddOrModify((DataLineMsgSet)localObject);
          }
        }
        else
        {
          localDataLineMsgSet = null;
        }
      }
      finally {}
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
    for (;;)
    {
      try
      {
        if (DataLineMsgSet.isSingle(paramDataLineMsgRecord))
        {
          localDataLineMsgSet = new DataLineMsgSet(0);
          localDataLineMsgSet.put(Integer.valueOf(0), paramDataLineMsgRecord);
          this.mList.add(0, localDataLineMsgSet);
          checkFirstLastIdByAddOrModify(localDataLineMsgSet);
          bool = true;
          return bool;
        }
        Iterator localIterator = this.mList.iterator();
        if (!localIterator.hasNext()) {
          break label158;
        }
        localDataLineMsgSet = (DataLineMsgSet)localIterator.next();
        if ((localDataLineMsgSet.getGroupId() != paramDataLineMsgRecord.groupId) || (localDataLineMsgSet.isSendFromLocal() != paramDataLineMsgRecord.isSendFromLocal())) {
          continue;
        }
        if (localDataLineMsgSet == null)
        {
          localDataLineMsgSet = new DataLineMsgSet(paramDataLineMsgRecord.groupId);
          this.mList.add(0, localDataLineMsgSet);
          bool = true;
          localDataLineMsgSet.put(Integer.valueOf(paramDataLineMsgRecord.groupIndex), paramDataLineMsgRecord);
          checkFirstLastIdByAddOrModify(localDataLineMsgSet);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      continue;
      label158:
      DataLineMsgSet localDataLineMsgSet = null;
    }
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
  
  /* Error */
  public boolean remove(DataLineMsgSet paramDataLineMsgSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/tencent/mobileqq/data/DataLineMsgSetList:mList	Ljava/util/ArrayList;
    //   6: invokevirtual 43	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface 49 1 0
    //   16: ifeq +41 -> 57
    //   19: aload_3
    //   20: invokeinterface 53 1 0
    //   25: checkcast 29	com/tencent/mobileqq/data/DataLineMsgSet
    //   28: astore 4
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 148	com/tencent/mobileqq/data/DataLineMsgSet:equals	(Ljava/lang/Object;)Z
    //   36: ifeq -26 -> 10
    //   39: aload_0
    //   40: getfield 22	com/tencent/mobileqq/data/DataLineMsgSetList:mList	Ljava/util/ArrayList;
    //   43: aload 4
    //   45: invokevirtual 150	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   48: istore_2
    //   49: aload_0
    //   50: invokespecial 144	com/tencent/mobileqq/data/DataLineMsgSetList:checkFirstLastIdByRemove	()V
    //   53: aload_0
    //   54: monitorexit
    //   55: iload_2
    //   56: ireturn
    //   57: iconst_0
    //   58: istore_2
    //   59: goto -6 -> 53
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	DataLineMsgSetList
    //   0	67	1	paramDataLineMsgSet	DataLineMsgSet
    //   48	11	2	bool	boolean
    //   9	11	3	localIterator	Iterator
    //   28	16	4	localDataLineMsgSet	DataLineMsgSet
    // Exception table:
    //   from	to	target	type
    //   2	10	62	finally
    //   10	53	62	finally
  }
  
  public int size()
  {
    return this.mList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.DataLineMsgSetList
 * JD-Core Version:    0.7.0.1
 */