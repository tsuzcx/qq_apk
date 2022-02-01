package com.tencent.mobileqq.troop.selecttroopmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectTroopMemberFragment$4
  implements View.OnClickListener
{
  SelectTroopMemberFragment$4(SelectTroopMemberFragment paramSelectTroopMemberFragment, CheckBox paramCheckBox) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("confirm_nomore").a(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberFragment.jdField_a_of_type_JavaLangString }).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment.4
 * JD-Core Version:    0.7.0.1
 */