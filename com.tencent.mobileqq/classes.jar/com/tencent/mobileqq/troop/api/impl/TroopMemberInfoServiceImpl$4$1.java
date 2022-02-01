package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.ITroopMemberInfoCallBack;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopMemberInfoServiceImpl$4$1
  implements Runnable
{
  TroopMemberInfoServiceImpl$4$1(TroopMemberInfoServiceImpl.4 param4, TroopMemberInfo paramTroopMemberInfo) {}
  
  public void run()
  {
    Object localObject1 = this.b.this$0.mTmiCallBackRefMap;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b.a);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(this.b.b);
    localObject1 = (List)((Map)localObject1).remove(((StringBuilder)localObject2).toString());
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getTroopMemberInfo, size=");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.i("TroopManager", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ITroopMemberInfoService.ITroopMemberInfoCallBack)((WeakReference)((Iterator)localObject1).next()).get();
      if (localObject2 != null) {
        ((ITroopMemberInfoService.ITroopMemberInfoCallBack)localObject2).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.4.1
 * JD-Core Version:    0.7.0.1
 */