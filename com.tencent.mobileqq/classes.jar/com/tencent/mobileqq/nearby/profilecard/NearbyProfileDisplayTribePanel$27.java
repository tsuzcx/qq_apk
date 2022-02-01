package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.api.NearbyProxy;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

class NearbyProfileDisplayTribePanel$27
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$27(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    if (this.a.aa)
    {
      NearbyProfileDisplayTribePanel.b(this.a);
      return;
    }
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    paramView = AnimationUtils.a(paramView);
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.a.e.mPicInfo.size()) {
        break;
      }
      if (localPicInfo.a == ((PicInfo)this.a.e.mPicInfo.get(i)).a)
      {
        j = i;
        break;
      }
      i += 1;
    }
    this.a.e.showBigPhoto(j, paramView);
    ReportController.b(this.a.e.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
    if (this.a.e.mMode == 3) {
      paramView = "2";
    } else {
      paramView = "1";
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_pic", 0, 0, paramView, "", "", "");
    if (NearbyProxy.a(this.a.e.allinone.profileEntryType, this.a.e.mMode)) {
      NearbyManagerHelper.a(this.a.e.app).b(localPicInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.27
 * JD-Core Version:    0.7.0.1
 */