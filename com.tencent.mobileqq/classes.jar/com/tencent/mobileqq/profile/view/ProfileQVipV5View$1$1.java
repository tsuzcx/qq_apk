package com.tencent.mobileqq.profile.view;

import android.widget.ImageView;
import auuy;
import axqy;
import bbcm;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class ProfileQVipV5View$1$1
  implements Runnable
{
  ProfileQVipV5View$1$1(ProfileQVipV5View.1 param1, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
    {
      ProfileQVipV5View.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.this$0).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.this$0.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      if (bbcm.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.this$0.jdField_a_of_type_Long)) {
        localAvatarPendantManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.this$0.jdField_a_of_type_Long).a(ProfileQVipV5View.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.this$0), 2, PendantInfo.c, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.jdField_a_of_type_Auuy.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.jdField_a_of_type_Boolean) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
        }
        return;
        localAvatarPendantManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.this$0.jdField_a_of_type_Long).a(ProfileQVipV5View.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.this$0), 1, PendantInfo.c, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.jdField_a_of_type_Auuy.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      }
    }
    ProfileQVipV5View.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.this$0).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipV5View$1.this$0.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileQVipV5View.1.1
 * JD-Core Version:    0.7.0.1
 */