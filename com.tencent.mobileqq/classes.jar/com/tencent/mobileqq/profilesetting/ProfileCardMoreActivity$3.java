package com.tencent.mobileqq.profilesetting;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

class ProfileCardMoreActivity$3
  implements ActionSheet.OnButtonClickListener
{
  ProfileCardMoreActivity$3(ProfileCardMoreActivity paramProfileCardMoreActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt == 1) && (Utils.b(this.jdField_a_of_type_JavaLangString))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app, "dc00898", "", "", "0X8007FE0", "0X8007FE0", 0, 0, "", "", "", "");
      }
    }
    else
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app, "CliOper", "", "", "P_prof", "Pp_more_delete", ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne)), "", "", "");
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend(this.jdField_a_of_type_JavaLangString, (byte)2);
        paramView = this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app.getHandler(ChatActivity.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app.getHandler(ChatSettingActivity.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent == null) {
          this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent = new Intent();
        }
        this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent.putExtra("finchat", true);
        paramView = this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity;
        paramView.setResult(-1, paramView.jdField_a_of_type_AndroidContentIntent);
        if (Utils.b(this.jdField_a_of_type_JavaLangString)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.finish();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.notifyUser(2131691464, 1);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.3
 * JD-Core Version:    0.7.0.1
 */