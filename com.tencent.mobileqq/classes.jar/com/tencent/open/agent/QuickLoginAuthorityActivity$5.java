package com.tencent.open.agent;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class QuickLoginAuthorityActivity$5
  implements AuthorityAccountView.IChangeAccountListener
{
  QuickLoginAuthorityActivity$5(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A7BD", "0X800A7BD", QuickLoginAuthorityActivity.b(this.a), 0, "", "", "", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report-dc00898-0X800A7BD-fromType=");
    localStringBuilder.append(QuickLoginAuthorityActivity.b(this.a));
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.5
 * JD-Core Version:    0.7.0.1
 */