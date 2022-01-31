package com.tencent.mobileqq.profile.view;

import android.widget.ImageView;
import auuy;
import bbcm;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class ProfileQVipDiyView$1$1
  implements Runnable
{
  ProfileQVipDiyView$1$1(ProfileQVipDiyView.1 param1, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    AvatarPendantManager localAvatarPendantManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.this$0.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
      localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      if (bbcm.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.this$0.jdField_a_of_type_Long)) {
        localAvatarPendantManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.this$0.jdField_a_of_type_Long).a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.jdField_a_of_type_AndroidWidgetImageView, 2, PendantInfo.c, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.jdField_a_of_type_Auuy.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      }
    }
    for (;;)
    {
      ProfileQVipDiyView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.this$0, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo);
      return;
      localAvatarPendantManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.this$0.jdField_a_of_type_Long).a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.jdField_a_of_type_AndroidWidgetImageView, 1, PendantInfo.c, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.jdField_a_of_type_Auuy.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileQVipDiyView$1.this$0.jdField_a_of_type_Long = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileQVipDiyView.1.1
 * JD-Core Version:    0.7.0.1
 */