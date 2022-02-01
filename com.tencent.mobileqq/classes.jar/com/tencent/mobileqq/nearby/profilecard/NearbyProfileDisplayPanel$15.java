package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.CikeConfigData;
import com.tencent.mobileqq.nearby.widget.NearbyAppDownloadDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyProfileDisplayPanel$15
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$15(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    CikeConfigData localCikeConfigData = CikeConfigData.a(this.a.a, this.a.a.app.getAccount(), 2);
    if (localCikeConfigData != null)
    {
      localCikeConfigData.f = "13";
      localCikeConfigData.g = NearbyProfileDisplayPanel.a(this.a).uin;
      NearbyAppDownloadDialog localNearbyAppDownloadDialog = new NearbyAppDownloadDialog(this.a.a);
      localNearbyAppDownloadDialog.a(localCikeConfigData);
      localNearbyAppDownloadDialog.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.15
 * JD-Core Version:    0.7.0.1
 */