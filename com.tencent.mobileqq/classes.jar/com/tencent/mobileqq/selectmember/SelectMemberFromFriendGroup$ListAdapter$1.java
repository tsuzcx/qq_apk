package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class SelectMemberFromFriendGroup$ListAdapter$1
  implements View.OnClickListener
{
  SelectMemberFromFriendGroup$ListAdapter$1(SelectMemberFromFriendGroup.ListAdapter paramListAdapter) {}
  
  public void onClick(View paramView)
  {
    SelectMemberFromFriendGroup.ListAdapter.ViewHolder localViewHolder = (SelectMemberFromFriendGroup.ListAdapter.ViewHolder)paramView.getTag();
    if (this.a.a.a.contains(localViewHolder.jdField_a_of_type_ComTencentMobileqqDataGroups))
    {
      this.a.a.a.remove(localViewHolder.jdField_a_of_type_ComTencentMobileqqDataGroups);
      localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.a.a.a(localViewHolder.jdField_a_of_type_ComTencentMobileqqDataGroups, false);
    }
    else
    {
      this.a.a.a.add(localViewHolder.jdField_a_of_type_ComTencentMobileqqDataGroups);
      localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.a.a.a(localViewHolder.jdField_a_of_type_ComTencentMobileqqDataGroups, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberFromFriendGroup.ListAdapter.1
 * JD-Core Version:    0.7.0.1
 */