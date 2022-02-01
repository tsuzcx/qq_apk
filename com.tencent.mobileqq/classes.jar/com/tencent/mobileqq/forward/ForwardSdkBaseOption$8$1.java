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
    this.a.this$0.a(1004, ForwardAbility.ForwardAbilityType.c.intValue());
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "84");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ReportDef.RepUtil.a(this.a.this$0.ar));
    localBundle.putString("intext_1", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ReportDef.RepUtil.a(this.a.this$0.t.getInt("uintype"), this.a.this$0.t.getString("uin")));
    localBundle.putString("intext_2", localStringBuilder.toString());
    localBundle.putString("intext_3", "0");
    localBundle.putString("intext_4", "5");
    ReportCenter.a().a(localBundle, "", this.a.this$0.q.getCurrentAccountUin(), false, this.a.this$0.F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.8.1
 * JD-Core Version:    0.7.0.1
 */