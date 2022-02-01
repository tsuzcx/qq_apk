package com.tencent.mobileqq.profilecard.base.view;

import anyw;
import azxr;
import bhkt;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class ProfileBaseView$1
  implements Runnable
{
  ProfileBaseView$1(ProfileBaseView paramProfileBaseView, azxr paramazxr, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((anyw)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_Azxr.a.a);
    ProfileBaseView.1.1 local1 = new ProfileBaseView.1.1(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(local1);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bhkt.b(localExtensionInfo.pendantId)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.this$0.jdField_a_of_type_Anui);
      bhkt.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azxr.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileBaseView.1
 * JD-Core Version:    0.7.0.1
 */