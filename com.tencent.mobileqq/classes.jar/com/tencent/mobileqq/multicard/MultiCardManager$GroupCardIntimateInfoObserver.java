package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class MultiCardManager$GroupCardIntimateInfoObserver
  extends IntimateInfoObserver
{
  private MultiCardManager$GroupCardIntimateInfoObserver(MultiCardManager paramMultiCardManager) {}
  
  protected void a(boolean paramBoolean, long paramLong, ArrayList<Long> paramArrayList)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGetIntimateGroupRecommendUinList ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(" ");
      if (paramArrayList != null) {
        ??? = paramArrayList.toString();
      } else {
        ??? = "null";
      }
      ((StringBuilder)localObject2).append((String)???);
      QLog.d("MultiCardManager", 2, ((StringBuilder)localObject2).toString());
    }
    if ((paramLong == MultiCardManager.a(this.a)) && (MultiCardManager.d(this.a) != null))
    {
      if (paramArrayList != null) {
        synchronized (MultiCardManager.a(this.a))
        {
          MultiCardManager.a(this.a).put(Long.valueOf(paramLong), (ArrayList)paramArrayList.clone());
        }
      }
      synchronized (MultiCardManager.d(this.a))
      {
        localObject2 = (WeakReference)MultiCardManager.d(this.a).get(Long.valueOf(paramLong));
        if (localObject2 != null)
        {
          ??? = (MultiCardManager.GetGroupRecommendUinListsListener)((WeakReference)localObject2).get();
          if (??? != null)
          {
            if (!paramBoolean)
            {
              MultiCardManager.a(this.a, paramLong, (MultiCardManager.GetGroupRecommendUinListsListener)???);
              return;
            }
            ((MultiCardManager.GetGroupRecommendUinListsListener)???).a(paramLong, paramArrayList);
            return;
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object arg3)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onGetGroupIntimateInfos ");
      ((StringBuilder)???).append(paramBoolean);
      ((StringBuilder)???).append(" ");
      if (paramHashMap != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramHashMap.size());
        ((StringBuilder)localObject2).append(paramHashMap.toString());
        paramHashMap = ((StringBuilder)localObject2).toString();
      }
      else
      {
        paramHashMap = "null";
      }
      ((StringBuilder)???).append(paramHashMap);
      QLog.d("MultiCardManager", 2, ((StringBuilder)???).toString());
    }
    paramHashMap = new ArrayList(0);
    long l2 = 0L;
    long l3 = l2;
    if ((??? instanceof HashMap))
    {
      localObject2 = (HashMap)???;
      ??? = (ArrayList)((HashMap)localObject2).get("alreadyRequest");
      ??? = (ArrayList)((HashMap)localObject2).get("notRequest");
      localObject2 = (ArrayList)((HashMap)localObject2).get("groupUin");
      long l1 = l2;
      if (localObject2 != null)
      {
        l1 = l2;
        if (((ArrayList)localObject2).size() > 0) {
          l1 = ((Long)((ArrayList)localObject2).get(0)).longValue();
        }
      }
      if (??? != null) {
        paramHashMap.addAll((Collection)???);
      }
      l3 = l1;
      if (??? != null)
      {
        paramHashMap.addAll(???);
        l3 = l1;
        if (!paramBoolean)
        {
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("onGetGroupIntimateInfos false remove sendRequest  ");
            ((StringBuilder)???).append(???.toString());
            QLog.d("MultiCardManager", 2, ((StringBuilder)???).toString());
          }
          synchronized (MultiCardManager.e(this.a))
          {
            ??? = ???.iterator();
            while (???.hasNext())
            {
              localObject2 = (Long)???.next();
              MultiCardManager.e(this.a).remove(localObject2);
            }
            l3 = l1;
          }
        }
      }
    }
    if ((l3 == MultiCardManager.a(this.a)) && (MultiCardManager.f(this.a) != null)) {
      synchronized (MultiCardManager.f(this.a))
      {
        ??? = (WeakReference)MultiCardManager.f(this.a).get(Long.valueOf(l3));
        if (??? != null)
        {
          ??? = (MultiCardManager.GetGroupIntimateInfoListListener)((WeakReference)???).get();
          if (??? != null)
          {
            MultiCardManager.a(this.a, l3, paramHashMap, ???);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.GroupCardIntimateInfoObserver
 * JD-Core Version:    0.7.0.1
 */