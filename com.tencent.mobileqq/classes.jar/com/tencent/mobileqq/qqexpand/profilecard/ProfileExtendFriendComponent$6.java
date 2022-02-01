package com.tencent.mobileqq.qqexpand.profilecard;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class ProfileExtendFriendComponent$6
  implements View.OnClickListener
{
  ProfileExtendFriendComponent$6(ProfileExtendFriendComponent paramProfileExtendFriendComponent, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131363927)
    {
      if ((ProfileExtendFriendComponent.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent) != null) && (ProfileExtendFriendComponent.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent).isShowing())) {
        ProfileExtendFriendComponent.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent).dismiss();
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration))
      {
        ReportController.b(ProfileExtendFriendComponent.c(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent), "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(ProfileExtendFriendComponent.d(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent), "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
      return;
    }
    if (i == 2131363990)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration))
      {
        ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragment(ProfileExtendFriendComponent.e(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent), null);
      }
      else
      {
        paramView = InterestSwitchEditActivity.a(ProfileExtendFriendComponent.f(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent));
        ProfileExtendFriendComponent.g(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent).startActivityForResult(paramView, 1022);
      }
      if ((ProfileExtendFriendComponent.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent) != null) && (ProfileExtendFriendComponent.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent).isShowing())) {
        ProfileExtendFriendComponent.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent).dismiss();
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration))
      {
        ReportController.b(ProfileExtendFriendComponent.e(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent), "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(ProfileExtendFriendComponent.f(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent), "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent.6
 * JD-Core Version:    0.7.0.1
 */