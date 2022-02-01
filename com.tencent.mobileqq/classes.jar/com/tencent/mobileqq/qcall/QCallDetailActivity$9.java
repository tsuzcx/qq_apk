package com.tencent.mobileqq.qcall;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QCallDetailActivity$9
  implements ActionSheet.OnButtonClickListener
{
  QCallDetailActivity$9(QCallDetailActivity paramQCallDetailActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (QCallDetailActivity.g(this.c) != null)
    {
      if (paramInt >= QCallDetailActivity.g(this.c).length) {
        return;
      }
      if (QCallDetailActivity.g(this.c)[paramInt] != 2) {
        return;
      }
      paramView = new StringBuilder();
      paramView.append("tel:");
      paramView.append(this.a);
      paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      this.c.startActivity(paramView);
      ReportController.b(this.c.app, "CliOper", "", "", "0X8005AF9", "0X8005AF9", 0, 0, "", "", "", "");
      this.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.9
 * JD-Core Version:    0.7.0.1
 */