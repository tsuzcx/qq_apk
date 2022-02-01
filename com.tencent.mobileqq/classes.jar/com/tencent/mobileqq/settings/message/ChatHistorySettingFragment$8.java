package com.tencent.mobileqq.settings.message;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class ChatHistorySettingFragment$8
  extends Handler
{
  ChatHistorySettingFragment$8(ChatHistorySettingFragment paramChatHistorySettingFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131690861));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
      }
    }
    else
    {
      if ((this.a.getBaseActivity() != null) && (!this.a.getBaseActivity().isFinishing()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131690859));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(2130850009);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.8
 * JD-Core Version:    0.7.0.1
 */