package com.tencent.mobileqq.selectmember;

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
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendTeamListInnerFrame$2
  implements View.OnClickListener
{
  FriendTeamListInnerFrame$2(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick");
    SelectBuddyChildTag localSelectBuddyChildTag = (SelectBuddyChildTag)paramView.getTag();
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
          this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.onRelationTroopItemClick(((RelationTroopEntity)localObject).troopInfo.troopuin);
          this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.d();
          break label416;
        }
        localObject = "";
      }
      if (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        boolean bool;
        if (localSelectBuddyChildTag.jdField_a_of_type_JavaLangString.startsWith("+")) {
          bool = this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.onListViewItemClick(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, (String)localObject, 4, "-1");
        } else {
          bool = this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.onListViewItemClick(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, (String)localObject, 0, "-1");
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("----->onBuddyListClick = ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("FriendTeamListInnerFrameNew", 2, ((StringBuilder)localObject).toString());
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
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131705047));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localSelectBuddyChildTag.d.getText().toString());
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131705046));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
        }
        this.a.f();
        if (AppSetting.d) {
          paramView.postDelayed(new FriendTeamListInnerFrame.2.1(this, paramView), 2000L);
        }
      }
    }
    label416:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTeamListInnerFrame.2
 * JD-Core Version:    0.7.0.1
 */