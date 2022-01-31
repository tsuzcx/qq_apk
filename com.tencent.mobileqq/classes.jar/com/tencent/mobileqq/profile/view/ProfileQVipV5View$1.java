package com.tencent.mobileqq.profile.view;

import ajxl;
import auuy;
import bbcm;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class ProfileQVipV5View$1
  implements Runnable
{
  ProfileQVipV5View$1(ProfileQVipV5View paramProfileQVipV5View, auuy paramauuy, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((ajxl)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_Auuy.a.a);
    ProfileQVipV5View.1.1 local1 = new ProfileQVipV5View.1.1(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(local1);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bbcm.b(localExtensionInfo.pendantId)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.this$0.jdField_a_of_type_Ajte);
      bbcm.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auuy.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileQVipV5View.1
 * JD-Core Version:    0.7.0.1
 */