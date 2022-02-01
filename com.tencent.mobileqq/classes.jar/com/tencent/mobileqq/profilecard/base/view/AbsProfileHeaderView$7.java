package com.tencent.mobileqq.profilecard.base.view;

import amsw;
import android.os.Message;
import aymg;
import bfua;
import bjmp;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

class AbsProfileHeaderView$7
  implements Runnable
{
  AbsProfileHeaderView$7(AbsProfileHeaderView paramAbsProfileHeaderView, aymg paramaymg, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((amsw)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_Aymg.a.a);
    Message localMessage = this.this$0.jdField_a_of_type_Bjmp.obtainMessage(1003, localExtensionInfo);
    this.this$0.jdField_a_of_type_Bjmp.sendMessage(localMessage);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bfua.b(localExtensionInfo.pendantId))) {
      bfua.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aymg.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.7
 * JD-Core Version:    0.7.0.1
 */