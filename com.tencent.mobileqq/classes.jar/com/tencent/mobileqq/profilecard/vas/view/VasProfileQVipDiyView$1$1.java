package com.tencent.mobileqq.profilecard.vas.view;

import android.widget.ImageView;
import azrb;
import bhcs;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class VasProfileQVipDiyView$1$1
  implements Runnable
{
  VasProfileQVipDiyView$1$1(VasProfileQVipDiyView.1 param1, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    AvatarPendantManager localAvatarPendantManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      VasProfileQVipDiyView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.this$0, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId);
      localAvatarPendantManager = (AvatarPendantManager)VasProfileQVipDiyView.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.this$0).getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      if (bhcs.a(VasProfileQVipDiyView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.this$0))) {
        localAvatarPendantManager.a(VasProfileQVipDiyView.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.this$0)).a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.jdField_a_of_type_AndroidWidgetImageView, 2, PendantInfo.c, this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.jdField_a_of_type_Azrb.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      }
    }
    for (;;)
    {
      VasProfileQVipDiyView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.this$0, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo);
      return;
      localAvatarPendantManager.a(VasProfileQVipDiyView.c(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.this$0)).a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.jdField_a_of_type_AndroidWidgetImageView, 1, PendantInfo.c, this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.jdField_a_of_type_Azrb.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      VasProfileQVipDiyView.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipDiyView$1.this$0, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView.1.1
 * JD-Core Version:    0.7.0.1
 */