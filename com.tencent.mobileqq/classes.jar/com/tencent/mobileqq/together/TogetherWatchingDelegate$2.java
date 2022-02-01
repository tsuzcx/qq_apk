package com.tencent.mobileqq.together;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class TogetherWatchingDelegate$2
  implements DialogInterface.OnClickListener
{
  TogetherWatchingDelegate$2(TogetherWatchingDelegate paramTogetherWatchingDelegate, String paramString, int paramInt1, Bundle paramBundle, int paramInt2, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TogetherWatchingDelegate localTogetherWatchingDelegate = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherWatchingDelegate;
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1;
    if (this.jdField_a_of_type_Int == 8) {
      str1 = "clk_openframe_open";
    } else {
      str1 = "clk_joinbar_open";
    }
    TogetherWatchingDelegate.a(localTogetherWatchingDelegate, str2, str1);
    paramDialogInterface.dismiss();
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt == 8)
    {
      TogetherWatchingDelegate.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherWatchingDelegate, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.b, paramInt);
      return;
    }
    TogetherWatchingDelegate.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherWatchingDelegate, this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_JavaLangString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherWatchingDelegate.2
 * JD-Core Version:    0.7.0.1
 */