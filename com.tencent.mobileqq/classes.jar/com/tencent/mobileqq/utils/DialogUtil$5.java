package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class DialogUtil$5
  implements View.OnClickListener
{
  DialogUtil$5(DialogInterface.OnClickListener paramOnClickListener1, Dialog paramDialog, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365667) {}
    try
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_AndroidAppDialog, 0);
      }
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        break label96;
      }
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    catch (Exception localException)
    {
      DialogInterface.OnClickListener localOnClickListener;
      break label96;
    }
    if (paramView.getId() == 2131365673)
    {
      localOnClickListener = this.b;
      if (localOnClickListener != null) {
        localOnClickListener.onClick(this.jdField_a_of_type_AndroidAppDialog, 1);
      }
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
    label96:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil.5
 * JD-Core Version:    0.7.0.1
 */