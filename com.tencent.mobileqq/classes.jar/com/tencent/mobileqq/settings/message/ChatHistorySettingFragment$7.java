package com.tencent.mobileqq.settings.message;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class ChatHistorySettingFragment$7
  extends Handler
{
  ChatHistorySettingFragment$7(ChatHistorySettingFragment paramChatHistorySettingFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if ((this.a.getActivity() != null) && (!this.a.getActivity().isFinishing()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131690931));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(2130850083);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131690933));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.7
 * JD-Core Version:    0.7.0.1
 */