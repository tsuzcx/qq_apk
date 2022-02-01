package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressButton;

class NearbyProfileDisplayPanel$41
  implements DialogInterface.OnClickListener
{
  NearbyProfileDisplayPanel$41(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.a.x != null) {
        this.a.x.a(2);
      }
      if (this.a.f != null)
      {
        if (this.a.B)
        {
          ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, String.valueOf(this.a.f.tinyId), "", "yes", "android");
          return;
        }
        ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, String.valueOf(this.a.f.tinyId), "", "yes", "android");
      }
    }
    else if (paramInt == 0)
    {
      if (this.a.x != null) {
        this.a.x.a(10);
      }
      if (this.a.y != null)
      {
        this.a.y.setText(2131896715);
        this.a.y.setProgress(0);
      }
      paramDialogInterface = this.a;
      paramDialogInterface.z = 2;
      if (paramDialogInterface.f != null) {
        ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_cancel", 0, 0, String.valueOf(this.a.f.tinyId), "", "yes", "android");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.41
 * JD-Core Version:    0.7.0.1
 */