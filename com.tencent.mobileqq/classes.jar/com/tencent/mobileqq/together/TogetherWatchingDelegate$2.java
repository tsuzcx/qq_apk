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
    if (this.jdField_a_of_type_Int == 8) {}
    for (String str1 = "clk_openframe_open";; str1 = "clk_joinbar_open")
    {
      TogetherWatchingDelegate.a(localTogetherWatchingDelegate, str2, str1);
      paramDialogInterface.dismiss();
      if (this.jdField_a_of_type_Int != 8) {
        break;
      }
      TogetherWatchingDelegate.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherWatchingDelegate, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      return;
    }
    TogetherWatchingDelegate.a(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherWatchingDelegate, this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherWatchingDelegate.2
 * JD-Core Version:    0.7.0.1
 */