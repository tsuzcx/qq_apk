package com.tencent.mobileqq.nearby.profilecard;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.api.NearbyProxy;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

class NearbyProfileDisplayPanel$34
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$34(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof PicInfo))
    {
      PicInfo localPicInfo = (PicInfo)paramView.getTag();
      paramView = AnimationUtils.a(paramView);
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.a.a.mPicInfo.size()) {
          break;
        }
        if (NearbyProfileDisplayPanel.a(this.a).nowUserType == 0 ? localPicInfo.jdField_a_of_type_Int == ((PicInfo)this.a.a.mPicInfo.get(i)).jdField_a_of_type_Int : TextUtils.equals(localPicInfo.jdField_a_of_type_JavaLangString, ((PicInfo)this.a.a.mPicInfo.get(i)).jdField_a_of_type_JavaLangString))
        {
          j = i;
          break;
        }
        i += 1;
      }
      this.a.a.showBigPhoto(j, paramView);
      ReportController.b(this.a.a.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
      if (this.a.a.mMode == 3) {
        paramView = "2";
      } else {
        paramView = "1";
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_pic", 0, 0, paramView, "", "", "");
      if (NearbyProxy.a(this.a.a.allinone.profileEntryType, this.a.a.mMode)) {
        NearbyManagerHelper.a(this.a.a.app).a(localPicInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.34
 * JD-Core Version:    0.7.0.1
 */