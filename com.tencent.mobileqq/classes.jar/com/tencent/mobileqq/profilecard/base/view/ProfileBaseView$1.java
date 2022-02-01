package com.tencent.mobileqq.profilecard.base.view;

import anvk;
import azrb;
import bhcs;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class ProfileBaseView$1
  implements Runnable
{
  ProfileBaseView$1(ProfileBaseView paramProfileBaseView, azrb paramazrb, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((anvk)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_Azrb.a.a);
    ProfileBaseView.1.1 local1 = new ProfileBaseView.1.1(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(local1);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bhcs.b(localExtensionInfo.pendantId)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
      bhcs.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azrb.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileBaseView.1
 * JD-Core Version:    0.7.0.1
 */