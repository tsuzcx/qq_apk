package com.tencent.mobileqq.troop.selecttroopmember;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberMngHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;

class SelectTroopMemberFragment$6
  implements View.OnClickListener
{
  SelectTroopMemberFragment$6(SelectTroopMemberFragment paramSelectTroopMemberFragment, ArrayList paramArrayList, CheckBox paramCheckBox, boolean paramBoolean, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ITroopMemberMngHandler)this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_MNG_HANDLER);
    if (localObject != null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.getBaseActivity(), 2131756189);
        this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog.setContentView(2131558463);
        this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        ((TextView)this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644)).setText(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.getString(2131691773));
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_AndroidAppDialog.show();
      ((ITroopMemberMngHandler)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), this.jdField_a_of_type_Boolean);
    }
    catch (Exception localException)
    {
      label148:
      break label148;
    }
    localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    SelectTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment.6
 * JD-Core Version:    0.7.0.1
 */