package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.CikeConfigData;
import com.tencent.mobileqq.nearby.widget.NearbyAppDownloadDialog;

class NearbyProfileDisplayPanel$16
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$16(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    paramView = CikeConfigData.a(this.a.e, this.a.e.app.getAccount(), 2);
    if (paramView != null)
    {
      paramView.f = "13";
      paramView.g = this.a.f.uin;
      NearbyAppDownloadDialog localNearbyAppDownloadDialog = new NearbyAppDownloadDialog(this.a.e);
      localNearbyAppDownloadDialog.a(paramView);
      localNearbyAppDownloadDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.16
 * JD-Core Version:    0.7.0.1
 */