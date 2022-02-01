package com.tencent.mobileqq.conditionsearch;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

class LocationSelectActivity$7
  implements DialogInterface.OnDismissListener
{
  LocationSelectActivity$7(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LocationSelectActivity.b(this.a).setRightTextColor(2);
    if (AppSetting.e)
    {
      paramDialogInterface = LocationSelectActivity.e(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131904243));
      localStringBuilder.append(LocationSelectActivity.d(this.a).name);
      paramDialogInterface.setContentDescription(localStringBuilder.toString());
      paramDialogInterface = LocationSelectActivity.b(this.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131904241));
      localStringBuilder.append(LocationSelectActivity.b(this.a).getRightTextView().getText());
      paramDialogInterface.setContentDescription(localStringBuilder.toString());
    }
    paramDialogInterface = LocationSelectActivity.f(this.a);
    if (LocationSelectActivity.g(this.a) == 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004248", "0X8004248", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
      return;
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X800424A", "0X800424A", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity.7
 * JD-Core Version:    0.7.0.1
 */