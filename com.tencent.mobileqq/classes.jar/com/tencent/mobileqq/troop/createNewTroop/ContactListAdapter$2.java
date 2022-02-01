package com.tencent.mobileqq.troop.createNewTroop;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopcreate.RelationTroopEntity;
import com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView;
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactListAdapter$2
  implements View.OnClickListener
{
  ContactListAdapter$2(ContactListAdapter paramContactListAdapter) {}
  
  public void onClick(View paramView)
  {
    QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick");
    ContactListAdapter.SelectBuddyChildTag localSelectBuddyChildTag = (ContactListAdapter.SelectBuddyChildTag)paramView.getTag();
    if ((localSelectBuddyChildTag != null) && (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject != null))
    {
      Object localObject;
      if ((localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof Friends))
      {
        localObject = ((Friends)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      }
      else if ((localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
      {
        localObject = ((PhoneContact)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject).name;
      }
      else
      {
        if ((localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity))
        {
          localObject = (RelationTroopEntity)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject;
          this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.a(((RelationTroopEntity)localObject).troopInfo.troopuin);
          break label406;
        }
        localObject = "";
      }
      if (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        boolean bool;
        if (localSelectBuddyChildTag.jdField_a_of_type_JavaLangString.startsWith("+")) {
          bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.a(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, (String)localObject, 4, "-1");
        } else {
          bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.a(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, (String)localObject, 0, "-1");
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("----->onBuddyListClick = ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("createNewTroop.ContactListAdapter", 2, ((StringBuilder)localObject).toString());
        }
        if (localSelectBuddyChildTag.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.b();
        }
        localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d) {
          if (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localSelectBuddyChildTag.d.getText().toString());
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131702671));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localSelectBuddyChildTag.d.getText().toString());
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131702670));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
        }
        this.a.a();
        if (AppSetting.d) {
          paramView.postDelayed(new ContactListAdapter.2.1(this, paramView), 2000L);
        }
      }
    }
    label406:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.2
 * JD-Core Version:    0.7.0.1
 */