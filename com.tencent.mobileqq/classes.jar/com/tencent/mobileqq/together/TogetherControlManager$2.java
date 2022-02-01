package com.tencent.mobileqq.together;

import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class TogetherControlManager$2
  extends TroopPushObserver
{
  TogetherControlManager$2(TogetherControlManager paramTogetherControlManager) {}
  
  protected void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPassiveExit, troopUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", reason=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TogetherControlManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = TogetherControlManager.a(this.a).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TogetherParser)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherControlManager.2
 * JD-Core Version:    0.7.0.1
 */