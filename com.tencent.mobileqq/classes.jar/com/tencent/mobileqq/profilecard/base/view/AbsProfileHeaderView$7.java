package com.tencent.mobileqq.profilecard.base.view;

import android.os.Message;
import anvk;
import azrb;
import bhcs;
import bkyc;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;

class AbsProfileHeaderView$7
  implements Runnable
{
  AbsProfileHeaderView$7(AbsProfileHeaderView paramAbsProfileHeaderView, azrb paramazrb, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((anvk)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_Azrb.a.a);
    Message localMessage = this.this$0.jdField_a_of_type_Bkyc.obtainMessage(1003, localExtensionInfo);
    this.this$0.jdField_a_of_type_Bkyc.sendMessage(localMessage);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bhcs.b(localExtensionInfo.pendantId))) {
      bhcs.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azrb.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.7
 * JD-Core Version:    0.7.0.1
 */