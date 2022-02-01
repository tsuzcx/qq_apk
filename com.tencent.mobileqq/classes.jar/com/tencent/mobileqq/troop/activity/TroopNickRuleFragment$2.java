package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopNickRuleFragment$2
  extends TroopManagerBizObserver
{
  TroopNickRuleFragment$2(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public void onModifyTroopNickRule(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append("onModifyTroopNickRule success uin = ");
      paramString.append(paramLong1);
      QLog.d("TroopNickRuleFragment", 2, paramString.toString());
      if (TroopNickRuleFragment.a(this.a).equals(String.valueOf(paramLong1))) {
        this.a.c();
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onModifyTroopNickRule failed errCode = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", errInfo = ");
      localStringBuilder.append(paramString);
      QLog.i("TroopNickRuleFragment", 2, localStringBuilder.toString());
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      int i;
      if (paramLong2 == 1298L) {
        i = 2131720012;
      } else {
        i = 2131720011;
      }
      QQToast.a(paramString, i, 0).a();
      if (paramLong2 == 1298L) {
        paramString = "3";
      } else {
        paramString = "1";
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_failure", 0, 0, String.valueOf(TroopNickRuleFragment.a(this.a)), paramString, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment.2
 * JD-Core Version:    0.7.0.1
 */