package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

class StructMsgItemVideo$1$1
  implements DialogInterface.OnClickListener
{
  StructMsgItemVideo$1$1(StructMsgItemVideo.1 param1, Context paramContext, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StructMsgItemVideo.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo$1.a, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.1.1
 * JD-Core Version:    0.7.0.1
 */