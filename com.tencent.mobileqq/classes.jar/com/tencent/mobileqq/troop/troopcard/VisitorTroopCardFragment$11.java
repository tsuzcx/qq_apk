package com.tencent.mobileqq.troop.troopcard;

import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class VisitorTroopCardFragment$11
  extends TroopMngObserver
{
  VisitorTroopCardFragment$11(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (!paramString1.equals(this.a.a.troopUin)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onQueryJoinTroopCanNoVerify result:");
      paramString1.append(paramBoolean);
      QLog.d("VisitorTroopCardFragment.Activity", 2, paramString1.toString());
    }
    if (VisitorTroopCardFragment.a(this.a, paramBoolean, paramInt2)) {
      return;
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("onQueryJoinTroopCanNoVerify noVerify:");
        paramString1.append(paramInt1);
        QLog.d("VisitorTroopCardFragment.Activity", 2, paramString1.toString());
      }
      paramString1 = this.a;
      paramString1.b = paramInt1;
      paramString1.c = paramInt2;
      if ((paramString1.b == 1) && (paramInt2 == 0))
      {
        if (this.a.a.isHomeworkTroop())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify isHomeworkTroop true");
          }
          this.a.b(1);
          return;
        }
        this.a.e();
        return;
      }
      VisitorTroopCardFragment.b(this.a);
      return;
    }
    VisitorTroopCardFragment.b(this.a);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramString.equals(this.a.a.troopUin)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onQueryJoinTroopCanNoVerify result:");
      paramString.append(paramBoolean);
      paramString.append("highRiskTroop");
      paramString.append(paramInt);
      QLog.d("VisitorTroopCardFragment.Activity", 2, paramString.toString());
    }
    if (VisitorTroopCardFragment.a(this.a, paramBoolean, paramInt)) {
      return;
    }
    if (paramBoolean) {
      this.a.c = paramInt;
    } else {
      this.a.c = 0;
    }
    VisitorTroopCardFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.11
 * JD-Core Version:    0.7.0.1
 */