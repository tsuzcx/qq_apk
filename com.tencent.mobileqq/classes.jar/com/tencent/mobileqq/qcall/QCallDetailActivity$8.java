package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

class QCallDetailActivity$8
  implements ActionSheet.OnDismissListener
{
  QCallDetailActivity$8(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void onDismiss()
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8005AFA", "0X8005AFA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.8
 * JD-Core Version:    0.7.0.1
 */