package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQProgressDialog;

class QQSettingMsgClearFragment$8
  extends Handler
{
  QQSettingMsgClearFragment$8(QQSettingMsgClearFragment paramQQSettingMsgClearFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = this.a.getActivity();
      if ((paramMessage != null) && (!paramMessage.isFinishing()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.8
 * JD-Core Version:    0.7.0.1
 */