package com.tencent.mobileqq.forward;

import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardNewVersionDialog$9
  implements View.OnClickListener
{
  ForwardNewVersionDialog$9(ForwardNewVersionDialog paramForwardNewVersionDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog, 0);
    }
    if (ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog))
    {
      ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog).removeView(ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog));
      ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog, false);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Forward.NewVersion.Dialog", 2, Log.getStackTraceString(localException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.9
 * JD-Core Version:    0.7.0.1
 */