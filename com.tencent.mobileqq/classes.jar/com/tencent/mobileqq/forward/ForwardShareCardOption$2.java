package com.tencent.mobileqq.forward;

import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.troop.troopshare.TroopShareResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ForwardShareCardOption$2
  extends TroopManagerBizObserver
{
  ForwardShareCardOption$2(ForwardShareCardOption paramForwardShareCardOption) {}
  
  public void onTroopShareLink(boolean paramBoolean, TroopShareResp paramTroopShareResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onTroopShareLink start");
    }
    this.a.ae();
    if (ForwardShareCardOption.a(this.a) != -1) {
      if ((paramBoolean) && (paramTroopShareResp.b == 0))
      {
        if (paramTroopShareResp.c)
        {
          ForwardShareCardOption.a(this.a, paramTroopShareResp.d);
          if (ForwardShareCardOption.a(this.a) == 0) {}
        }
        else
        {
          ForwardShareCardOption.b(this.a, paramTroopShareResp.d);
          if (ForwardShareCardOption.a(this.a) != 1) {
            return;
          }
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mTroopVerifyLink=");
          localStringBuilder.append(ForwardShareCardOption.b(this.a));
          localStringBuilder.append(" mTroopNotNeedVefifyLink=");
          localStringBuilder.append(ForwardShareCardOption.c(this.a));
          QLog.d("ForwardOption.ForwardShareCardOption", 2, localStringBuilder.toString());
        }
        if ((paramTroopShareResp.a != null) && (paramTroopShareResp.a.equals(ForwardShareCardOption.d(this.a)))) {
          ForwardShareCardOption.e(this.a);
        }
      }
      else
      {
        if ((paramTroopShareResp.c) && (ForwardShareCardOption.a(this.a) != 0)) {
          return;
        }
        if ((!paramTroopShareResp.c) && (ForwardShareCardOption.a(this.a) != 1)) {
          return;
        }
        QQToast.makeText(this.a.s, 1, this.a.s.getString(2131890039), 0).show(((BaseActivity)this.a.s).getTitleBarHeight());
      }
    }
    ForwardShareCardOption.a(this.a, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption.2
 * JD-Core Version:    0.7.0.1
 */