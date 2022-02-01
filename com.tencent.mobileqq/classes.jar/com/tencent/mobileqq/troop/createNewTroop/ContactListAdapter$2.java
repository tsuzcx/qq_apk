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
    if ((localSelectBuddyChildTag != null) && (localSelectBuddyChildTag.g != null) && (localSelectBuddyChildTag.h != null))
    {
      Object localObject;
      if ((localSelectBuddyChildTag.h instanceof Friends))
      {
        localObject = ((Friends)localSelectBuddyChildTag.h).getFriendNickWithAlias();
      }
      else if ((localSelectBuddyChildTag.h instanceof PhoneContact))
      {
        localObject = ((PhoneContact)localSelectBuddyChildTag.h).name;
      }
      else
      {
        if ((localSelectBuddyChildTag.h instanceof RelationTroopEntity))
        {
          localObject = (RelationTroopEntity)localSelectBuddyChildTag.h;
          this.a.a.b(((RelationTroopEntity)localObject).troopInfo.troopuin);
          break label406;
        }
        localObject = "";
      }
      if (localSelectBuddyChildTag.g.isEnabled())
      {
        boolean bool;
        if (localSelectBuddyChildTag.y.startsWith("+")) {
          bool = this.a.a.b(localSelectBuddyChildTag.y, (String)localObject, 4, "-1");
        } else {
          bool = this.a.a.b(localSelectBuddyChildTag.y, (String)localObject, 0, "-1");
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("----->onBuddyListClick = ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("createNewTroop.ContactListAdapter", 2, ((StringBuilder)localObject).toString());
        }
        if (localSelectBuddyChildTag.b == 1007L) {
          this.a.b.b();
        }
        localSelectBuddyChildTag.g.setChecked(bool);
        if (AppSetting.e) {
          if (localSelectBuddyChildTag.g.isChecked())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localSelectBuddyChildTag.e.getText().toString());
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131900661));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localSelectBuddyChildTag.e.getText().toString());
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131900660));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
        }
        this.a.a();
        if (AppSetting.e) {
          paramView.postDelayed(new ContactListAdapter.2.1(this, paramView), 2000L);
        }
      }
    }
    label406:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.2
 * JD-Core Version:    0.7.0.1
 */