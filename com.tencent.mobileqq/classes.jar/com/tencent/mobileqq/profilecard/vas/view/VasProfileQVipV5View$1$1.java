package com.tencent.mobileqq.profilecard.vas.view;

import android.widget.ImageView;
import azxr;
import bdll;
import bhkt;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class VasProfileQVipV5View$1$1
  implements Runnable
{
  VasProfileQVipV5View$1$1(VasProfileQVipV5View.1 param1, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
    {
      VasProfileQVipV5View.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.this$0).setVisibility(0);
      VasProfileQVipV5View.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.this$0, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId);
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)VasProfileQVipV5View.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.this$0).getManager(46);
      if (bhkt.a(VasProfileQVipV5View.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.this$0))) {
        localAvatarPendantManager.a(VasProfileQVipV5View.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.this$0)).a(VasProfileQVipV5View.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.this$0), 2, PendantInfo.c, this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.jdField_a_of_type_Azxr.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.jdField_a_of_type_Boolean) {
          bdll.b(VasProfileQVipV5View.c(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.this$0), "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
        }
        return;
        localAvatarPendantManager.a(VasProfileQVipV5View.c(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.this$0)).a(VasProfileQVipV5View.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.this$0), 1, PendantInfo.c, this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.jdField_a_of_type_Azxr.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      }
    }
    VasProfileQVipV5View.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.this$0).setVisibility(8);
    VasProfileQVipV5View.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileQVipV5View$1.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View.1.1
 * JD-Core Version:    0.7.0.1
 */