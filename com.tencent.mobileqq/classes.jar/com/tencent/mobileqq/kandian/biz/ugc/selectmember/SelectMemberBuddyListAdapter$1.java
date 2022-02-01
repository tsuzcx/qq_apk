package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.qphone.base.util.QLog;

class SelectMemberBuddyListAdapter$1
  implements View.OnClickListener
{
  SelectMemberBuddyListAdapter$1(SelectMemberBuddyListAdapter paramSelectMemberBuddyListAdapter) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "----->onBuddyListClick");
    SelectMemberBuddyListAdapter.SelectBuddyChildTag localSelectBuddyChildTag = (SelectMemberBuddyListAdapter.SelectBuddyChildTag)paramView.getTag();
    if ((localSelectBuddyChildTag != null) && (localSelectBuddyChildTag.g != null) && (localSelectBuddyChildTag.h != null))
    {
      if (localSelectBuddyChildTag.g.isEnabled())
      {
        boolean bool = localSelectBuddyChildTag.g.isChecked() ^ true;
        localSelectBuddyChildTag.g.setChecked(bool);
        Object localObject;
        if ((localSelectBuddyChildTag.h instanceof Friends))
        {
          localObject = (Friends)localSelectBuddyChildTag.h;
          localObject = ResultRecord.a(((Friends)localObject).uin, ((Friends)localObject).name, 1);
          if (bool) {
            this.a.b.add(localObject);
          } else {
            this.a.b.remove(localObject);
          }
        }
        if (AppSetting.e) {
          if (localSelectBuddyChildTag.g.isChecked())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localSelectBuddyChildTag.e.getText().toString());
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131911193));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localSelectBuddyChildTag.e.getText().toString());
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131911203));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
        }
        this.a.notifyDataSetChanged();
        if (AppSetting.e) {
          paramView.postDelayed(new SelectMemberBuddyListAdapter.1.1(this, paramView), 2000L);
        }
      }
      else
      {
        this.a.a();
      }
      if (SelectMemberBuddyListAdapter.a(this.a) != null) {
        SelectMemberBuddyListAdapter.a(this.a).onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.SelectMemberBuddyListAdapter.1
 * JD-Core Version:    0.7.0.1
 */