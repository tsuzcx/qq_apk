package com.tencent.mobileqq.forward;

import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardNewVersionDialog$10
  implements View.OnClickListener
{
  ForwardNewVersionDialog$10(ForwardNewVersionDialog paramForwardNewVersionDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog) != null) {}
    for (boolean bool = ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog).a(paramView);; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.hideSoftInputFromWindow();
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog, 1);
      }
      if (ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog))
      {
        ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog).removeView(ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog));
        ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog, false);
      }
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.isShowing()) && (!bool)) {
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.dismiss();
        }
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
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.10
 * JD-Core Version:    0.7.0.1
 */