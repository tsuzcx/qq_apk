package com.tencent.mobileqq.profile.view;

import aloz;
import android.os.Message;
import awmk;
import bdbg;
import bhoe;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

class ProfileHeaderView$8
  implements Runnable
{
  ProfileHeaderView$8(ProfileHeaderView paramProfileHeaderView, awmk paramawmk, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((aloz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_Awmk.a.a);
    Message localMessage = this.this$0.jdField_a_of_type_Bhoe.obtainMessage(ProfileHeaderView.c, localExtensionInfo);
    this.this$0.jdField_a_of_type_Bhoe.sendMessage(localMessage);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bdbg.b(localExtensionInfo.pendantId))) {
      bdbg.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awmk.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.8
 * JD-Core Version:    0.7.0.1
 */