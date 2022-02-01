package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class ForwardShareByServerHelper$7
  implements DialogInterface.OnClickListener
{
  ForwardShareByServerHelper$7(ForwardShareByServerHelper paramForwardShareByServerHelper, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardShareByServerHelper.a(ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper), "shareToQQ", ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      Util.a(ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper), 0, "", "");
      if (ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper) != null) {
        ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper).b(1);
      }
      ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardShareByServerHelper).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.7
 * JD-Core Version:    0.7.0.1
 */