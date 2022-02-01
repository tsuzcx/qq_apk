package com.tencent.mobileqq.forward;

import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardNewVersionDialog$10
  implements View.OnClickListener
{
  ForwardNewVersionDialog$10(ForwardNewVersionDialog paramForwardNewVersionDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog) != null) {
      bool = ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog).a(paramView);
    } else {
      bool = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog.hideSoftInputFromWindow();
    DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog, 1);
    }
    if (ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog))
    {
      ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog).removeView(ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog).getView());
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
      if (QLog.isColorLevel()) {
        QLog.d("Forward.NewVersion.Dialog", 2, Log.getStackTraceString(localException));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.10
 * JD-Core Version:    0.7.0.1
 */