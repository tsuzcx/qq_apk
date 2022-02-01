package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendTabView$3
  implements View.OnClickListener
{
  FriendTabView$3(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    SelectBuddyChildTag localSelectBuddyChildTag = (SelectBuddyChildTag)paramView.getTag();
    if ((localSelectBuddyChildTag != null) && (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject != null))
    {
      Object localObject;
      if ((localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        localObject = ((Friends)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      } else if ((localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        localObject = ((PhoneContact)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject).name;
      } else {
        localObject = "";
      }
      if (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        boolean bool;
        if (localSelectBuddyChildTag.jdField_a_of_type_JavaLangString.startsWith("+")) {
          bool = this.a.a.onListViewItemClick(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, (String)localObject, 4, "-1", "");
        } else {
          bool = this.a.a.onListViewItemClick(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, (String)localObject, 0, "-1", "");
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("----->onBuddyListClick = ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("FriendTabView", 2, ((StringBuilder)localObject).toString());
        }
        localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d) {
          if (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localSelectBuddyChildTag.d.getText().toString());
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131705044));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localSelectBuddyChildTag.d.getText().toString());
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131705045));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
        }
        this.a.c();
        if (AppSetting.d) {
          paramView.postDelayed(new FriendTabView.3.1(this, paramView), 2000L);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTabView.3
 * JD-Core Version:    0.7.0.1
 */