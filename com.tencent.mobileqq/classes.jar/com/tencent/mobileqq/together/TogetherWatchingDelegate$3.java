package com.tencent.mobileqq.together;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class TogetherWatchingDelegate$3
  implements DialogInterface.OnClickListener
{
  TogetherWatchingDelegate$3(TogetherWatchingDelegate paramTogetherWatchingDelegate, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TogetherWatchingDelegate localTogetherWatchingDelegate = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherWatchingDelegate;
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1;
    if (this.jdField_a_of_type_Int == 8) {
      str1 = "clk_openframe_cancel";
    } else {
      str1 = "clk_joinbar_cancel";
    }
    TogetherWatchingDelegate.a(localTogetherWatchingDelegate, str2, str1);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherWatchingDelegate.3
 * JD-Core Version:    0.7.0.1
 */