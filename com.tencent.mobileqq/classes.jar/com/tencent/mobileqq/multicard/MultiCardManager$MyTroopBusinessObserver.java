package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MultiCardManager$MyTroopBusinessObserver
  extends TroopObserver
{
  private MultiCardManager$MyTroopBusinessObserver(MultiCardManager paramMultiCardManager) {}
  
  protected void onUpdateTroopGetMemberList(String arg1, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onUpdateTroopGetMemberList ");
      paramList.append(paramBoolean);
      paramList.append(" ");
      paramList.append(???);
      paramList.append(" ");
      paramList.append(paramInt1);
      QLog.d("MultiCardManager", 2, paramList.toString());
    }
    long l = 0L;
    try
    {
      paramLong = Long.parseLong(???);
    }
    catch (Exception ???)
    {
      paramLong = l;
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onUpdateTroopGetMemberList ");
        paramList.append(???.toString());
        QLog.d("MultiCardManager", 2, paramList.toString());
        paramLong = l;
      }
    }
    if ((paramInt1 == 9) && (paramLong == MultiCardManager.d(this.a)) && (MultiCardManager.e(this.a) != null)) {
      synchronized (MultiCardManager.e(this.a))
      {
        paramList = (WeakReference)MultiCardManager.e(this.a).get(Long.valueOf(paramLong));
        if (paramList != null)
        {
          paramList = (MultiCardManager.GetGroupMemberNickListener)paramList.get();
          if (paramList != null)
          {
            new ArrayList(0);
            synchronized (MultiCardManager.f(this.a))
            {
              ArrayList localArrayList = (ArrayList)MultiCardManager.f(this.a).get(Long.valueOf(paramLong));
              MultiCardManager.a(this.a, paramLong, localArrayList, paramList);
              return;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.MyTroopBusinessObserver
 * JD-Core Version:    0.7.0.1
 */