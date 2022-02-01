package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.InputMethodUtil;

class NearbyProfileEditTribePanel$14
  implements View.OnClickListener
{
  NearbyProfileEditTribePanel$14(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mEnterProfileIntent.getIntExtra("param_mode", 0) == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 1) {
      return;
    }
    InputMethodUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694424));
      return;
    }
    if (!NearbyProfileEditTribePanel.a(this.a)) {
      return;
    }
    this.a.b();
    boolean bool1 = this.a.a();
    boolean bool2 = ((Boolean)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (bool1))
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694418, new Object[] { this.a.jdField_a_of_type_JavaLangString });
      paramView = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView, 0, 0, null, null);
      paramView.setPositiveButton(HardCodeUtil.a(2131707309), new NearbyProfileEditTribePanel.14.1(this, paramView));
      paramView.setNegativeButton(HardCodeUtil.a(2131707304), new NearbyProfileEditTribePanel.14.2(this, paramView));
      paramView.show();
      return;
    }
    if ((bool1) && (bool2))
    {
      paramView = HardCodeUtil.a(2131707333);
      paramView = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView, 0, 0, null, null);
      paramView.setPositiveButton(HardCodeUtil.a(2131707355), new NearbyProfileEditTribePanel.14.3(this, paramView));
      paramView.setNegativeButton(HardCodeUtil.a(2131707388), new NearbyProfileEditTribePanel.14.4(this, paramView));
      paramView.show();
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
      return;
    }
    if (bool1)
    {
      this.a.e();
      paramView = new Intent("tribe_profile_edit_finish");
      BaseApplicationImpl.getApplication().sendBroadcast(paramView);
      return;
    }
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.quitEditWithoutSaving();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.14
 * JD-Core Version:    0.7.0.1
 */