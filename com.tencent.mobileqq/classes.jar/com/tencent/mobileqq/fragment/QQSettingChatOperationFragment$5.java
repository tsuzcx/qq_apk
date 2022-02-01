package com.tencent.mobileqq.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class QQSettingChatOperationFragment$5
  extends Handler
{
  QQSettingChatOperationFragment$5(QQSettingChatOperationFragment paramQQSettingChatOperationFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
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
      return;
    }
    QQSettingChatOperationFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.5
 * JD-Core Version:    0.7.0.1
 */