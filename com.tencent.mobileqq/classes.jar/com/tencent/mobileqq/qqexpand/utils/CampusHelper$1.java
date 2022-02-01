package com.tencent.mobileqq.qqexpand.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.statistics.ReportController;

final class CampusHelper$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a.isShowing())
    {
      this.a.dismiss();
      ReportController.b(null, "dc00898", "", "", "0X800AD9C", "0X800AD9C", 2, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.CampusHelper.1
 * JD-Core Version:    0.7.0.1
 */