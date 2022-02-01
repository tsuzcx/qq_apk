package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ListenTogetherManager$7
  extends TroopMngObserver
{
  ListenTogetherManager$7(ListenTogetherManager paramListenTogetherManager) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onTroopManagerSuccess result: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" troopUin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if ((paramInt2 == 0) && ((paramInt1 == 9) || (paramInt1 == 2)))
    {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.7
 * JD-Core Version:    0.7.0.1
 */