package com.tencent.mobileqq.profile.view;

import ajjj;
import android.os.Message;
import atwx;
import baau;
import beez;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

class ProfileHeaderView$8
  implements Runnable
{
  ProfileHeaderView$8(ProfileHeaderView paramProfileHeaderView, atwx paramatwx, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((ajjj)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_Atwx.a.a);
    Message localMessage = this.this$0.jdField_a_of_type_Beez.obtainMessage(ProfileHeaderView.c, localExtensionInfo);
    this.this$0.jdField_a_of_type_Beez.sendMessage(localMessage);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (baau.b(localExtensionInfo.pendantId))) {
      baau.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atwx.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.8
 * JD-Core Version:    0.7.0.1
 */