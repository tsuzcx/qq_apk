package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class NearbyProfileDisplayPanel$32
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$32(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo;
    Object localObject;
    int i;
    int j;
    if ((paramView.getTag() instanceof PicInfo))
    {
      localPicInfo = (PicInfo)paramView.getTag();
      localObject = AnimationUtils.a(paramView);
      i = 0;
      if (i >= this.a.a.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label280;
      }
      if (NearbyProfileDisplayPanel.a(this.a).nowUserType != 0) {
        break label233;
      }
      if (localPicInfo.jdField_a_of_type_Int != ((PicInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int) {
        break label266;
      }
      j = i;
    }
    for (;;)
    {
      label87:
      this.a.a.a(j, (Rect)localObject);
      ReportController.b(this.a.a.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
      if (this.a.a.e == 3) {}
      for (localObject = "2";; localObject = "1")
      {
        ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_pic", 0, 0, (String)localObject, "", "", "");
        if (NearbyProxy.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, this.a.a.e)) {
          this.a.a.app.getNearbyProxy().b(localPicInfo.jdField_a_of_type_JavaLangString);
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label233:
        j = i;
        if (TextUtils.equals(localPicInfo.jdField_a_of_type_JavaLangString, ((PicInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)) {
          break label87;
        }
        label266:
        i += 1;
        break;
      }
      label280:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.32
 * JD-Core Version:    0.7.0.1
 */