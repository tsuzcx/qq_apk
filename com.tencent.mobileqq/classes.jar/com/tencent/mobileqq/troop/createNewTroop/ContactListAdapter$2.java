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
    Object localObject;
    boolean bool;
    if ((localSelectBuddyChildTag != null) && (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject != null))
    {
      localObject = "";
      if (!(localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label263;
      }
      localObject = ((Friends)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localSelectBuddyChildTag.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label329;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, (String)localObject, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick = " + bool);
        }
        if (localSelectBuddyChildTag.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopRelationFriendsTroopViewHelper.b();
        }
        localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d)
        {
          if (!localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label352;
          }
          paramView.setContentDescription(localSelectBuddyChildTag.d.getText().toString() + HardCodeUtil.a(2131702539));
        }
      }
    }
    for (;;)
    {
      this.a.a();
      if (AppSetting.d) {
        paramView.postDelayed(new ContactListAdapter.2.1(this, paramView), 2000L);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label263:
        if ((localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
        {
          localObject = ((PhoneContact)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject).name;
          break;
        }
        if (!(localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
          break;
        }
        localObject = (RelationTroopEntity)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(((RelationTroopEntity)localObject).troopInfo.troopuin);
      }
      label329:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, (String)localObject, 0, "-1");
      break label108;
      label352:
      paramView.setContentDescription(localSelectBuddyChildTag.d.getText().toString() + HardCodeUtil.a(2131702538));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.2
 * JD-Core Version:    0.7.0.1
 */