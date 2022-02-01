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
    this.a.A();
    if (ForwardShareCardOption.a(this.a) != -1) {
      if ((paramBoolean) && (paramTroopShareResp.jdField_a_of_type_Int == 0))
      {
        if (paramTroopShareResp.jdField_a_of_type_Boolean)
        {
          ForwardShareCardOption.a(this.a, paramTroopShareResp.b);
          if (ForwardShareCardOption.a(this.a) == 0) {}
        }
        else
        {
          ForwardShareCardOption.b(this.a, paramTroopShareResp.b);
          if (ForwardShareCardOption.a(this.a) != 1) {
            return;
          }
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mTroopVerifyLink=");
          localStringBuilder.append(ForwardShareCardOption.a(this.a));
          localStringBuilder.append(" mTroopNotNeedVefifyLink=");
          localStringBuilder.append(ForwardShareCardOption.b(this.a));
          QLog.d("ForwardOption.ForwardShareCardOption", 2, localStringBuilder.toString());
        }
        if ((paramTroopShareResp.jdField_a_of_type_JavaLangString != null) && (paramTroopShareResp.jdField_a_of_type_JavaLangString.equals(ForwardShareCardOption.c(this.a)))) {
          ForwardShareCardOption.a(this.a);
        }
      }
      else
      {
        if ((paramTroopShareResp.jdField_a_of_type_Boolean) && (ForwardShareCardOption.a(this.a) != 0)) {
          return;
        }
        if ((!paramTroopShareResp.jdField_a_of_type_Boolean) && (ForwardShareCardOption.a(this.a) != 1)) {
          return;
        }
        QQToast.a(this.a.a, 1, this.a.a.getString(2131692928), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
      }
    }
    ForwardShareCardOption.a(this.a, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption.2
 * JD-Core Version:    0.7.0.1
 */