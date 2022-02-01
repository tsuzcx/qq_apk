package com.tencent.mobileqq.teamwork;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamWorkSaveDialog$2
  implements View.OnClickListener
{
  TeamWorkSaveDialog$2(TeamWorkSaveDialog paramTeamWorkSaveDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkSaveDialog, 0);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkSaveDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkSaveDialog.dismiss();
      }
      label38:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkSaveDialog.2
 * JD-Core Version:    0.7.0.1
 */