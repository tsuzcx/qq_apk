package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressButton;

class NearbyProfileDisplayTribePanel$30
  implements DialogInterface.OnClickListener
{
  NearbyProfileDisplayTribePanel$30(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.a.S != null) {
        this.a.S.a(2);
      }
      if (NearbyProfileDisplayTribePanel.j(this.a) != null)
      {
        if (this.a.W)
        {
          ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, NearbyProfileDisplayTribePanel.j(this.a).uin, "", "yes", "android");
          return;
        }
        ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, NearbyProfileDisplayTribePanel.j(this.a).uin, "", "yes", "android");
      }
    }
    else if (paramInt == 0)
    {
      if (this.a.S != null) {
        this.a.S.a(10);
      }
      if (this.a.T != null)
      {
        this.a.T.setText(2131896715);
        this.a.T.setProgress(0);
      }
      paramDialogInterface = this.a;
      paramDialogInterface.U = 2;
      if (NearbyProfileDisplayTribePanel.j(paramDialogInterface) != null) {
        ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_cancel", 0, 0, NearbyProfileDisplayTribePanel.j(this.a).uin, "", "yes", "android");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.30
 * JD-Core Version:    0.7.0.1
 */