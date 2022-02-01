package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class ForwardSDKB77AIOHelper$1
  implements DialogInterface.OnClickListener
{
  ForwardSDKB77AIOHelper$1(ForwardSDKB77AIOHelper paramForwardSDKB77AIOHelper, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardShareByServerHelper.a(ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper), "shareToQQ", ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      Util.a(ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper), 0, "", "");
      if (ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper) != null) {
        ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper).b(1);
      }
      ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper.1
 * JD-Core Version:    0.7.0.1
 */