package com.tencent.mobileqq.vas;

import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class AvatarPendantManager$PendantInfoLruCache
  extends AvatarPendantManager.LruLinkedHashMap<Long, PendantInfo>
{
  private static final long serialVersionUID = 1L;
  
  public AvatarPendantManager$PendantInfoLruCache(AvatarPendantManager paramAvatarPendantManager, int paramInt)
  {
    super(paramInt);
  }
  
  public void clear()
  {
    Iterator localIterator = values().iterator();
    while (localIterator.hasNext()) {
      ((PendantInfo)localIterator.next()).a(true);
    }
    super.clear();
  }
  
  protected boolean removeEldestEntry(Map.Entry<Long, PendantInfo> paramEntry)
  {
    if (size() > this.maxCapacity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantManager", 2, "entryRemoved key=" + paramEntry.getKey());
      }
      ((PendantInfo)paramEntry.getValue()).a(true);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.AvatarPendantManager.PendantInfoLruCache
 * JD-Core Version:    0.7.0.1
 */