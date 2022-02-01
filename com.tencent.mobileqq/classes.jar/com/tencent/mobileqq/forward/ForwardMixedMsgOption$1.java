package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.replymsg.ForwardMsgManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardMixedMsgOption$1
  implements View.OnClickListener
{
  ForwardMixedMsgOption$1(ForwardMixedMsgOption paramForwardMixedMsgOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg != null)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.hideSoftInputFromWindow();
        Object localObject;
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.hasReplyText())
        {
          ((ForwardMsgManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
          localObject = this.a;
          ForwardReplyMsgOption.a((ForwardBaseOption)localObject, ((ForwardMixedMsgOption)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
        }
        else
        {
          localObject = new ForwardPreviewMixedMsgController(this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((ForwardPreviewMixedMsgController)localObject).a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692648), this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.addPreviewView(((ForwardPreviewMixedMsgController)localObject).b());
        }
        this.a.G();
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "no msg not enter preview");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMixedMsgOption.1
 * JD-Core Version:    0.7.0.1
 */