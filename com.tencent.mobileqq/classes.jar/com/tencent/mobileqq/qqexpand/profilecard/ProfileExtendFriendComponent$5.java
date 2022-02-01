package com.tencent.mobileqq.qqexpand.profilecard;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class ProfileExtendFriendComponent$5
  implements View.OnClickListener
{
  ProfileExtendFriendComponent$5(ProfileExtendFriendComponent paramProfileExtendFriendComponent, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    if (((IExpandQuestionUtils)QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(ProfileExtendFriendComponent.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent).getCurrentAccountUin()))
    {
      paramView = ProfileGuideDialogUtils.a(ProfileExtendFriendComponent.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent));
      int i;
      if (ProfileExtendFriendComponent.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent)) {
        i = 2;
      } else {
        i = 1;
      }
      ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
      if ((ProfileExtendFriendComponent.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent) != null) && (!ProfileExtendFriendComponent.c(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent).isFinishing())) {
        paramView.show();
      }
      return;
    }
    paramView = new ExtendFriendInfo(this.jdField_a_of_type_ComTencentMobileqqDataCard);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_extend_friend_info", paramView);
    ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult(ProfileExtendFriendComponent.d(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent), localIntent, 4097);
    ReportController.b(ProfileExtendFriendComponent.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileExtendFriendComponent), "dc00898", "", "", "kuolie", "0X80092DB", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent.5
 * JD-Core Version:    0.7.0.1
 */