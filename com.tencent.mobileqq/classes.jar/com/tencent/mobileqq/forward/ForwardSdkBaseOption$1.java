package com.tencent.mobileqq.forward;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ForwardSdkBaseOption$1
  implements Handler.Callback
{
  ForwardSdkBaseOption$1(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 2) {
      return false;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption$PreStructViewHolder != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption$PreStructViewHolder.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.1
 * JD-Core Version:    0.7.0.1
 */