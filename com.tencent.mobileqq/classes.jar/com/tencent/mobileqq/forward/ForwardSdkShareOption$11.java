package com.tencent.mobileqq.forward;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.report.ReportCenter;

class ForwardSdkShareOption$11
  implements DialogInterface.OnClickListener
{
  ForwardSdkShareOption$11(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.c) {
      ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.a.jdField_a_of_type_Long), "1000", "51", "0", false, true);
    }
    ForwardSdkBaseOption.a(this.a.jdField_a_of_type_AndroidAppActivity, true, "addToQQFavorites", this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.11
 * JD-Core Version:    0.7.0.1
 */