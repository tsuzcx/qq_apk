package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class VisitorTroopCardFragment$11
  extends TroopMngObserver
{
  VisitorTroopCardFragment$11(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (!paramString1.equals(this.a.W.troopUin)) {
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
      paramString1.ac = paramInt1;
      paramString1.ad = paramInt2;
      if ((paramString1.ac == 1) && (paramInt2 == 0))
      {
        if (this.a.W.isHomeworkTroop())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify isHomeworkTroop true");
          }
          this.a.b(1);
          return;
        }
        this.a.f();
        return;
      }
      VisitorTroopCardFragment.i(this.a);
      return;
    }
    VisitorTroopCardFragment.i(this.a);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramString.equals(this.a.W.troopUin)) {
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
      this.a.ad = paramInt;
    } else {
      this.a.ad = 0;
    }
    VisitorTroopCardFragment.i(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.11
 * JD-Core Version:    0.7.0.1
 */