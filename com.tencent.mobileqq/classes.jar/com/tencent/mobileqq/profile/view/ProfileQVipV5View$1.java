package com.tencent.mobileqq.profile.view;

import aloz;
import awmk;
import bdbg;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class ProfileQVipV5View$1
  implements Runnable
{
  ProfileQVipV5View$1(ProfileQVipV5View paramProfileQVipV5View, awmk paramawmk, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((aloz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_Awmk.a.a);
    ProfileQVipV5View.1.1 local1 = new ProfileQVipV5View.1.1(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(local1);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bdbg.b(localExtensionInfo.pendantId)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.this$0.jdField_a_of_type_Alkr);
      bdbg.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awmk.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileQVipV5View.1
 * JD-Core Version:    0.7.0.1
 */