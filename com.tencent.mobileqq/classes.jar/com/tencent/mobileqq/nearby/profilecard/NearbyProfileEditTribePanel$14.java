package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;

class NearbyProfileEditTribePanel$14
  implements View.OnClickListener
{
  NearbyProfileEditTribePanel$14(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.getIntExtra("param_mode", 0) == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 1)
      {
        InputMethodUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694459));
        }
        else if (NearbyProfileEditTribePanel.a(this.a))
        {
          this.a.b();
          boolean bool1 = this.a.a();
          boolean bool2 = ((Boolean)NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
          Object localObject;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (bool1))
          {
            localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694453, new Object[] { this.a.jdField_a_of_type_JavaLangString });
            localObject = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
            ((QQCustomDialog)localObject).setPositiveButton(HardCodeUtil.a(2131707284), new NearbyProfileEditTribePanel.14.1(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).setNegativeButton(HardCodeUtil.a(2131707279), new NearbyProfileEditTribePanel.14.2(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).show();
          }
          else if ((bool1) && (bool2))
          {
            localObject = HardCodeUtil.a(2131707308);
            localObject = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
            ((QQCustomDialog)localObject).setPositiveButton(HardCodeUtil.a(2131707330), new NearbyProfileEditTribePanel.14.3(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).setNegativeButton(HardCodeUtil.a(2131707363), new NearbyProfileEditTribePanel.14.4(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).show();
            NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
          }
          else if (bool1)
          {
            this.a.e();
            localObject = new Intent("tribe_profile_edit_finish");
            BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
          }
          else
          {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
            this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.14
 * JD-Core Version:    0.7.0.1
 */