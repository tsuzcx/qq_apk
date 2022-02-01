package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class NearbyProfileDisplayTribePanel$27
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$27(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    if (this.a.p)
    {
      NearbyProfileDisplayTribePanel.b(this.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    Object localObject = AnimationUtils.a(paramView);
    int i = 0;
    label41:
    if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (localPicInfo.jdField_a_of_type_Int != ((PicInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int) {}
    }
    for (;;)
    {
      this.a.a.a(i, (Rect)localObject);
      ReportController.b(this.a.a.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
      if (this.a.a.e == 3) {}
      for (localObject = "2";; localObject = "1")
      {
        ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_pic", 0, 0, (String)localObject, "", "", "");
        if (!NearbyProxy.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, this.a.a.e)) {
          break;
        }
        this.a.a.app.getNearbyProxy().b(localPicInfo.jdField_a_of_type_JavaLangString);
        break;
        i += 1;
        break label41;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.27
 * JD-Core Version:    0.7.0.1
 */