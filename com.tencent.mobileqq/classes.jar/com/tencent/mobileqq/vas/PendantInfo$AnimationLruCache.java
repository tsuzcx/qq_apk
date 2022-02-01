package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class PendantInfo$AnimationLruCache
  extends AvatarPendantManager.LruLinkedHashMap<Long, Drawable>
{
  static final long serialVersionUID = 1L;
  
  public PendantInfo$AnimationLruCache(PendantInfo paramPendantInfo, int paramInt)
  {
    super(paramInt);
  }
  
  public void clear()
  {
    Iterator localIterator = values().iterator();
    while (localIterator.hasNext())
    {
      Drawable localDrawable = (Drawable)localIterator.next();
      localDrawable.setCallback(null);
      if ((localDrawable instanceof VipPendantDrawable)) {
        ((VipPendantDrawable)localDrawable).a();
      }
    }
    super.clear();
  }
  
  protected boolean removeEldestEntry(Map.Entry<Long, Drawable> paramEntry)
  {
    if (size() > this.maxCapacity)
    {
      paramEntry = (Drawable)paramEntry.getValue();
      paramEntry.setCallback(null);
      if ((paramEntry instanceof VipPendantDrawable)) {
        ((VipPendantDrawable)paramEntry).a();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo.AnimationLruCache
 * JD-Core Version:    0.7.0.1
 */