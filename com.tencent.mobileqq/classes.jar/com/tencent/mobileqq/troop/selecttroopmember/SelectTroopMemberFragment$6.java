package com.tencent.mobileqq.troop.selecttroopmember;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;

class SelectTroopMemberFragment$6
  implements View.OnClickListener
{
  SelectTroopMemberFragment$6(SelectTroopMemberFragment paramSelectTroopMemberFragment, ArrayList paramArrayList, CheckBox paramCheckBox, boolean paramBoolean, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localTroopHandler != null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.getActivity(), 2131755842);
        this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog.setContentView(2131558435);
        this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        ((TextView)this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog.findViewById(2131365807)).setText(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.getString(2131691851));
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog.show();
      localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), this.jdField_a_of_type_Boolean);
    }
    catch (Exception localException)
    {
      label143:
      break label143;
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    SelectTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment.6
 * JD-Core Version:    0.7.0.1
 */