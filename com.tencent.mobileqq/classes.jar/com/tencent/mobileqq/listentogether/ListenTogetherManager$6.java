package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ListenTogetherManager$6
  extends TroopBusinessObserver
{
  ListenTogetherManager$6(ListenTogetherManager paramListenTogetherManager) {}
  
  public void onPassiveExit(String paramString, int paramInt)
  {
    QLog.i("ListenTogether.Manager", 1, "onPassiveExit troopUin: " + paramString);
    String str = ListenTogetherUtils.a(1, paramString);
    if (ListenTogetherManager.a(this.a).equals(str))
    {
      ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).h = 3;
      ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).i = 3;
      ListenTogetherAIOStatusHelper.a(ListenTogetherManager.a(this.a), paramString, false);
      this.a.a(true, (ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a)), 1007);
      this.a.a(1, paramString, false);
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onTroopManagerSuccess result: " + paramInt2 + " troopUin: " + paramString);
    if ((paramInt2 == 0) && ((paramInt1 == 9) || (paramInt1 == 2)))
    {
      String str = ListenTogetherUtils.a(1, paramString);
      if (ListenTogetherManager.a(this.a).equals(str))
      {
        ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).h = 3;
        ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).i = 3;
        ListenTogetherAIOStatusHelper.a(ListenTogetherManager.a(this.a), paramString, false);
        this.a.a(true, (ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a)), 1007);
        this.a.a(1, paramString, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.6
 * JD-Core Version:    0.7.0.1
 */