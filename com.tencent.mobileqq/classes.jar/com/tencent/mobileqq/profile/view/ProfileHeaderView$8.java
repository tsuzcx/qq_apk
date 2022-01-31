package com.tencent.mobileqq.profile.view;

import ajxl;
import android.os.Message;
import auuy;
import bbcm;
import bfnk;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

class ProfileHeaderView$8
  implements Runnable
{
  ProfileHeaderView$8(ProfileHeaderView paramProfileHeaderView, auuy paramauuy, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((ajxl)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_Auuy.a.a);
    Message localMessage = this.this$0.jdField_a_of_type_Bfnk.obtainMessage(ProfileHeaderView.c, localExtensionInfo);
    this.this$0.jdField_a_of_type_Bfnk.sendMessage(localMessage);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bbcm.b(localExtensionInfo.pendantId))) {
      bbcm.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auuy.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.8
 * JD-Core Version:    0.7.0.1
 */