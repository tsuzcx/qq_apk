package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.data.troop.ITroopInfoCallback;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopInfoServiceImpl$1$1
  implements Runnable
{
  TroopInfoServiceImpl$1$1(TroopInfoServiceImpl.1 param1, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    Object localObject1 = (List)TroopInfoServiceImpl.access$000(this.b.this$0).remove(this.b.a);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("asyncGetTroopInfo, size=");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.i("TroopManager", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ITroopInfoCallback)((WeakReference)((Iterator)localObject1).next()).get();
      if (localObject2 != null) {
        ((ITroopInfoCallback)localObject2).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopInfoServiceImpl.1.1
 * JD-Core Version:    0.7.0.1
 */