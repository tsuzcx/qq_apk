package com.tencent.mobileqq.profilecard.base.view;

import android.widget.ImageView;
import azfe;
import bcst;
import bgks;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class ProfileBaseView$1$1
  implements Runnable
{
  ProfileBaseView$1$1(ProfileBaseView.1 param1, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
    {
      ProfileBaseView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.this$0).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.this$0.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      if (bgks.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.this$0.jdField_a_of_type_Long)) {
        localAvatarPendantManager.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.this$0.jdField_a_of_type_Long).a(ProfileBaseView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.this$0), 2, PendantInfo.c, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.jdField_a_of_type_Azfe.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.jdField_a_of_type_Boolean) {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
        }
        return;
        localAvatarPendantManager.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.this$0.jdField_a_of_type_Long).a(ProfileBaseView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.this$0), 1, PendantInfo.c, this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.jdField_a_of_type_Azfe.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      }
    }
    ProfileBaseView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.this$0).setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileBaseView$1.this$0.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileBaseView.1.1
 * JD-Core Version:    0.7.0.1
 */