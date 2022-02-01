package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ListenTogetherManager$6
  extends TroopPushObserver
{
  ListenTogetherManager$6(ListenTogetherManager paramListenTogetherManager) {}
  
  protected void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPassiveExit troopUin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    localObject = ListenTogetherUtils.a(1, paramString);
    if (ListenTogetherManager.a(this.a).equals(localObject))
    {
      ((ListenTogetherSession)ListenTogetherManager.b(this.a).get(ListenTogetherManager.a(this.a))).p = 3;
      ((ListenTogetherSession)ListenTogetherManager.b(this.a).get(ListenTogetherManager.a(this.a))).q = 3;
      ListenTogetherAIOStatusHelper.a(ListenTogetherManager.j(this.a), paramString, false);
      localObject = this.a;
      ((ListenTogetherManager)localObject).a(true, (ListenTogetherSession)ListenTogetherManager.b((ListenTogetherManager)localObject).get(ListenTogetherManager.a(this.a)), 1007);
      this.a.a(1, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.6
 * JD-Core Version:    0.7.0.1
 */