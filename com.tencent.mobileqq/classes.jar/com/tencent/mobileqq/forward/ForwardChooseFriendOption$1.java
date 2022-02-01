package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.ResultReceiver;

class ForwardChooseFriendOption$1
  implements DialogInterface.OnClickListener
{
  ForwardChooseFriendOption$1(ForwardChooseFriendOption paramForwardChooseFriendOption, int paramInt, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardChooseFriendOption.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqForwardForwardChooseFriendOption.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardChooseFriendOption.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramDialogInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardChooseFriendOption.jdField_a_of_type_AndroidAppActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardChooseFriendOption.jdField_a_of_type_AndroidAppActivity.setResult(1);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardChooseFriendOption.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardChooseFriendOption.1
 * JD-Core Version:    0.7.0.1
 */