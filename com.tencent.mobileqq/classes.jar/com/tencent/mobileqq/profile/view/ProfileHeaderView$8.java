package com.tencent.mobileqq.profile.view;

import alto;
import android.os.Message;
import awqt;
import bdfp;
import bhsl;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

class ProfileHeaderView$8
  implements Runnable
{
  ProfileHeaderView$8(ProfileHeaderView paramProfileHeaderView, awqt paramawqt, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((alto)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_Awqt.a.a);
    Message localMessage = this.this$0.jdField_a_of_type_Bhsl.obtainMessage(ProfileHeaderView.c, localExtensionInfo);
    this.this$0.jdField_a_of_type_Bhsl.sendMessage(localMessage);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bdfp.b(localExtensionInfo.pendantId))) {
      bdfp.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awqt.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.8
 * JD-Core Version:    0.7.0.1
 */