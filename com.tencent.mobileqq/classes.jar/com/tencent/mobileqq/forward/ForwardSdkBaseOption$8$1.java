package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;

class ForwardSdkBaseOption$8$1
  implements Runnable
{
  ForwardSdkBaseOption$8$1(ForwardSdkBaseOption.8 param8) {}
  
  public void run()
  {
    this.a.this$0.a(1004, ForwardAbility.ForwardAbilityType.b.intValue());
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "84");
    localBundle.putString("intext_1", "" + ReportDef.RepUtil.a(this.a.this$0.e));
    localBundle.putString("intext_2", "" + ReportDef.RepUtil.a(this.a.this$0.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.a.this$0.jdField_a_of_type_AndroidOsBundle.getString("uin")));
    localBundle.putString("intext_3", "0");
    localBundle.putString("intext_4", "5");
    ReportCenter.a().a(localBundle, "", this.a.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, this.a.this$0.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.8.1
 * JD-Core Version:    0.7.0.1
 */