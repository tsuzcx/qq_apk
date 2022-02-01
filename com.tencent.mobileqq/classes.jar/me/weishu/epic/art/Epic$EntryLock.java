package me.weishu.epic.art;

import java.util.HashMap;
import java.util.Map;

class Epic$EntryLock
{
  static Map<Long, EntryLock> sLockPool = new HashMap();
  
  static EntryLock obtain(long paramLong)
  {
    try
    {
      if (sLockPool.containsKey(Long.valueOf(paramLong)))
      {
        localEntryLock = (EntryLock)sLockPool.get(Long.valueOf(paramLong));
        return localEntryLock;
      }
      EntryLock localEntryLock = new EntryLock();
      sLockPool.put(Long.valueOf(paramLong), localEntryLock);
      return localEntryLock;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.Epic.EntryLock
 * JD-Core Version:    0.7.0.1
 */