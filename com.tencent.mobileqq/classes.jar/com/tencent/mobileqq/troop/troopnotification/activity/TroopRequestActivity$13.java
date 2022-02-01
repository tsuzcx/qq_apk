package com.tencent.mobileqq.troop.troopnotification.activity;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopRequestActivity$13
  extends TroopMngObserver
{
  TroopRequestActivity$13(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 7)) {
      this.a.ax.sendEmptyMessage(1);
    }
    if (paramInt1 == 8) {
      this.a.ax.sendEmptyMessage(1);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 7)) {
      if (paramInt2 == 0)
      {
        this.a.ax.sendEmptyMessage(0);
        this.a.finish();
      }
      else
      {
        this.a.ax.sendEmptyMessage(1);
      }
    }
    if (paramInt1 == 8)
    {
      if (paramInt2 == 0)
      {
        this.a.ax.sendEmptyMessage(0);
        return;
      }
      this.a.ax.sendEmptyMessage(1);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (this.a.c == null) {
      return;
    }
    Object localObject = this.a;
    ((TroopRequestActivity)localObject).c = ((TroopRequestActivity)localObject).c.trim();
    try
    {
      long l = Long.parseLong(this.a.c);
      if (paramLong == l) {
        break label64;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label50:
      label64:
      break label50;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.systemmsg.TroopRequestActivity", 2, "onSend0x88d_1_forJoinTroop_Ret=>NumberFormatException");
    }
    this.a.h();
    if (paramBoolean)
    {
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.v = paramTroopInfo.joinTroopQuestion;
        this.a.w = paramTroopInfo.joinTroopAnswer;
      }
      this.a.u = paramTroopInfo.cGroupOption;
      if (this.a.u != 3) {
        TroopRequestActivity.c(this.a);
      } else {
        QQToast.makeText(TroopRequestActivity.a(this.a).getApplication(), 2131917537, 0).show(this.a.getTitleBarHeight());
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("troop.cGroupOption = ");
        ((StringBuilder)localObject).append(paramTroopInfo.cGroupOption);
        QLog.i("Q.systemmsg.TroopRequestActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      this.a.ax.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.13
 * JD-Core Version:    0.7.0.1
 */