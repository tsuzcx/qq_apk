package com.tencent.mobileqq.forward;

import android.os.Bundle;
import atku;
import bhvw;
import bhwc;
import com.tencent.mobileqq.app.QQAppInterface;

class ForwardSdkBaseOption$8$1
  implements Runnable
{
  ForwardSdkBaseOption$8$1(ForwardSdkBaseOption.8 param8) {}
  
  public void run()
  {
    this.a.this$0.a(1004, atku.b.intValue());
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "84");
    localBundle.putString("intext_1", "" + bhwc.a(this.a.this$0.e));
    localBundle.putString("intext_2", "" + bhwc.a(this.a.this$0.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.a.this$0.jdField_a_of_type_AndroidOsBundle.getString("uin")));
    localBundle.putString("intext_3", "0");
    localBundle.putString("intext_4", "5");
    bhvw.a().a(localBundle, "", this.a.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.8.1
 * JD-Core Version:    0.7.0.1
 */