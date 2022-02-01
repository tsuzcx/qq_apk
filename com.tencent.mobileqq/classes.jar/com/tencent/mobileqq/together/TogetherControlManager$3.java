package com.tencent.mobileqq.together;

import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class TogetherControlManager$3
  extends TroopMngObserver
{
  TogetherControlManager$3(TogetherControlManager paramTogetherControlManager) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTroopManagerSuccess,reqType=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", result=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", troopUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TogetherControlManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt2 == 0) && ((paramInt1 == 9) || (paramInt1 == 2)))
    {
      localObject = TogetherControlManager.a(this.a).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TogetherParser)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramInt1, paramInt2, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherControlManager.3
 * JD-Core Version:    0.7.0.1
 */