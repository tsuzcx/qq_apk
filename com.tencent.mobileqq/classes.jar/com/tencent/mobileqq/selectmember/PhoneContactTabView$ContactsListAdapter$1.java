package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhoneContactTabView$ContactsListAdapter$1
  implements View.OnClickListener
{
  PhoneContactTabView$ContactsListAdapter$1(PhoneContactTabView.ContactsListAdapter paramContactsListAdapter) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131365713)
    {
      SelectActivityViewHolder localSelectActivityViewHolder = (SelectActivityViewHolder)paramView.getTag();
      if ((localSelectActivityViewHolder != null) && (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localSelectActivityViewHolder.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
      {
        Object localObject = localSelectActivityViewHolder.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        if (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
        {
          boolean bool;
          if (localSelectActivityViewHolder.jdField_a_of_type_JavaLangString.startsWith("+")) {
            bool = this.a.a.a.onListViewItemClick(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString, ((PhoneContact)localObject).name, 4, "-1", ((PhoneContact)localObject).mobileNo);
          } else {
            bool = this.a.a.a.onListViewItemClick(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString, ((PhoneContact)localObject).name, 0, "-1", ((PhoneContact)localObject).mobileNo);
          }
          localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
          if (AppSetting.d) {
            if (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
            {
              if (localSelectActivityViewHolder.jdField_a_of_type_Boolean)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localSelectActivityViewHolder.d.getText());
                ((StringBuilder)localObject).append(this.a.a.a.getString(2131718719));
                paramView.setContentDescription(((StringBuilder)localObject).toString());
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localSelectActivityViewHolder.d.getText().toString());
                ((StringBuilder)localObject).append(HardCodeUtil.a(2131708001));
                paramView.setContentDescription(((StringBuilder)localObject).toString());
              }
            }
            else
            {
              int i = 0;
              if (localSelectActivityViewHolder.jdField_a_of_type_Boolean) {
                i = this.a.a.a.getCheckPhoneNumberResId(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString);
              }
              if ((localSelectActivityViewHolder.jdField_a_of_type_Boolean) && (i != 0))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localSelectActivityViewHolder.d.getText());
                ((StringBuilder)localObject).append(this.a.a.a.getString(i));
                paramView.setContentDescription(((StringBuilder)localObject).toString());
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localSelectActivityViewHolder.d.getText().toString());
                ((StringBuilder)localObject).append(HardCodeUtil.a(2131707998));
                paramView.setContentDescription(((StringBuilder)localObject).toString());
              }
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.PhoneContactTabView.ContactsListAdapter.1
 * JD-Core Version:    0.7.0.1
 */