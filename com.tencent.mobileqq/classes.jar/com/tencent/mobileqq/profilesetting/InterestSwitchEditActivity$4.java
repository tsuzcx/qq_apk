package com.tencent.mobileqq.profilesetting;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class InterestSwitchEditActivity$4
  implements ActionSheetPrivacySelectAdapter.PrivacySelectActionSheetClickListener
{
  InterestSwitchEditActivity$4(InterestSwitchEditActivity paramInterestSwitchEditActivity, ProfileDisplaySettingItem paramProfileDisplaySettingItem, ActionSheet paramActionSheet) {}
  
  public void a(@NotNull View paramView, @Nullable ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean paramActionSheetPrivacySelectBean)
  {
    if ((paramActionSheetPrivacySelectBean != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileDisplaySettingItem.g() != paramActionSheetPrivacySelectBean.a()))
    {
      InterestSwitchEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity, paramActionSheetPrivacySelectBean.a(), this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileDisplaySettingItem);
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(BaseApplicationImpl.sApplication, 2131694422, 0).b(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity.getTitleBarHeight());
        return;
      }
      InterestSwitchEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity, this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileDisplaySettingItem, paramActionSheetPrivacySelectBean.a());
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity.4
 * JD-Core Version:    0.7.0.1
 */