package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopNickRuleFragment$2
  extends TroopBusinessObserver
{
  TroopNickRuleFragment$2(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public void onModifyTroopNickRule(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if (paramBoolean)
    {
      QLog.d("TroopNickRuleFragment", 2, "onModifyTroopNickRule success uin = " + paramLong1);
      if (TroopNickRuleFragment.a(this.a).equals(String.valueOf(paramLong1))) {
        this.a.c();
      }
      return;
    }
    QLog.i("TroopNickRuleFragment", 2, "onModifyTroopNickRule failed errCode = " + paramLong2 + ", errInfo = " + paramString);
    paramString = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    int i;
    if (paramLong2 == 1298L)
    {
      i = 2131720274;
      QQToast.a(paramString, i, 0).a();
      if (paramLong2 != 1298L) {
        break label183;
      }
    }
    label183:
    for (paramString = "3";; paramString = "1")
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_failure", 0, 0, String.valueOf(TroopNickRuleFragment.a(this.a)), paramString, "", "");
      return;
      i = 2131720273;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment.2
 * JD-Core Version:    0.7.0.1
 */