package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import tencent.im.oidb.cmd0xac5.cmd0xac5.MasterState;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;

class NearbyProfileEditPanel$20
  implements View.OnClickListener
{
  NearbyProfileEditPanel$20(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.getIntExtra("param_mode", 0);
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(false);
    if ((i == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 1)
        {
          InputMethodUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
          if (NetworkUtil.d(BaseApplication.getContext())) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694459));
        }
      }
    } while (!NearbyProfileEditPanel.a(this.a));
    this.a.b();
    boolean bool1 = this.a.a();
    boolean bool2 = ((Boolean)NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
    boolean bool3 = this.a.c();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get() != null) && (((cmd0xac5.NearbyNowData)this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get() != null)) {}
    for (i = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).uint32_state.get();; i = 0)
    {
      if ((i == 1) || (i == 2)) {}
      for (i = 1;; i = 0)
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (!bool3) || (i == 0)) {
          break label413;
        }
        new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_change").a(new String[] { "", "" + (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1) }).a();
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.t = bool3;
        this.a.f();
        break;
      }
      label413:
      Object localObject;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (bool1))
      {
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694453, new Object[] { this.a.jdField_a_of_type_JavaLangString });
        localObject = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
        ((QQCustomDialog)localObject).setPositiveButton(HardCodeUtil.a(2131707256), new NearbyProfileEditPanel.20.1(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).setNegativeButton(HardCodeUtil.a(2131707385), new NearbyProfileEditPanel.20.2(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).show();
        break;
      }
      if ((bool1) && (bool2))
      {
        localObject = HardCodeUtil.a(2131707373);
        localObject = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
        ((QQCustomDialog)localObject).setPositiveButton(HardCodeUtil.a(2131707322), new NearbyProfileEditPanel.20.3(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).setNegativeButton(HardCodeUtil.a(2131707324), new NearbyProfileEditPanel.20.4(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).show();
        NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
        break;
      }
      if (bool1)
      {
        this.a.f();
        break;
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.20
 * JD-Core Version:    0.7.0.1
 */