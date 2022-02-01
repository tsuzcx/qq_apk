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
    LocationSelectActivity.a(this.a).setRightTextColor(2);
    if (AppSetting.d)
    {
      paramDialogInterface = LocationSelectActivity.b(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131706384));
      localStringBuilder.append(LocationSelectActivity.a(this.a).name);
      paramDialogInterface.setContentDescription(localStringBuilder.toString());
      paramDialogInterface = LocationSelectActivity.a(this.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131706382));
      localStringBuilder.append(LocationSelectActivity.a(this.a).a().getText());
      paramDialogInterface.setContentDescription(localStringBuilder.toString());
    }
    paramDialogInterface = LocationSelectActivity.a(this.a);
    if (LocationSelectActivity.a(this.a) == 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004248", "0X8004248", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
      return;
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X800424A", "0X800424A", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity.7
 * JD-Core Version:    0.7.0.1
 */