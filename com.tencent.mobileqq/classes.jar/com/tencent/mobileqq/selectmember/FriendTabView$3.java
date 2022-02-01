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
    if ((localSelectBuddyChildTag != null) && (localSelectBuddyChildTag.g != null) && (localSelectBuddyChildTag.h != null))
    {
      Object localObject;
      if ((localSelectBuddyChildTag.h instanceof Friends)) {
        localObject = ((Friends)localSelectBuddyChildTag.h).getFriendNickWithAlias();
      } else if ((localSelectBuddyChildTag.h instanceof PhoneContact)) {
        localObject = ((PhoneContact)localSelectBuddyChildTag.h).name;
      } else {
        localObject = "";
      }
      if (localSelectBuddyChildTag.g.isEnabled())
      {
        boolean bool;
        if (localSelectBuddyChildTag.y.startsWith("+")) {
          bool = this.a.d.onListViewItemClick(localSelectBuddyChildTag.y, (String)localObject, 4, "-1", "");
        } else {
          bool = this.a.d.onListViewItemClick(localSelectBuddyChildTag.y, (String)localObject, 0, "-1", "");
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("----->onBuddyListClick = ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("FriendTabView", 2, ((StringBuilder)localObject).toString());
        }
        localSelectBuddyChildTag.g.setChecked(bool);
        if (AppSetting.e) {
          if (localSelectBuddyChildTag.g.isChecked())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localSelectBuddyChildTag.e.getText().toString());
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131902934));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localSelectBuddyChildTag.e.getText().toString());
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131902935));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
        }
        this.a.c();
        if (AppSetting.e) {
          paramView.postDelayed(new FriendTabView.3.1(this, paramView), 2000L);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTabView.3
 * JD-Core Version:    0.7.0.1
 */