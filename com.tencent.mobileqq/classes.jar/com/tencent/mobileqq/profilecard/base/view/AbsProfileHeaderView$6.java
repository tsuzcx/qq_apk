package com.tencent.mobileqq.profilecard.base.view;

import android.os.Message;
import anmw;
import azfe;
import bgks;
import bkfv;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

class AbsProfileHeaderView$6
  implements Runnable
{
  AbsProfileHeaderView$6(AbsProfileHeaderView paramAbsProfileHeaderView, azfe paramazfe, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((anmw)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_Azfe.a.a);
    Message localMessage = this.this$0.jdField_a_of_type_Bkfv.obtainMessage(1003, localExtensionInfo);
    this.this$0.jdField_a_of_type_Bkfv.sendMessage(localMessage);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bgks.b(localExtensionInfo.pendantId))) {
      bgks.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azfe.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.6
 * JD-Core Version:    0.7.0.1
 */