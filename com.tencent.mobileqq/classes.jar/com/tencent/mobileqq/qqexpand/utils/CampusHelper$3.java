package com.tencent.mobileqq.qqexpand.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.statistics.ReportController;

final class CampusHelper$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    CampusHelper.a(this.a, this.b);
    this.c.dismiss();
    ReportController.b(null, "dc00898", "", "", "0X800AD9C", "0X800AD9C", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.CampusHelper.3
 * JD-Core Version:    0.7.0.1
 */