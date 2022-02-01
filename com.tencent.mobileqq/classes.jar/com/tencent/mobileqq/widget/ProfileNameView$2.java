package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileNameView$2
  implements View.OnClickListener
{
  ProfileNameView$2(ProfileNameView paramProfileNameView, ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://qun.qq.com/interactive/userhonor?gc=");
    ((StringBuilder)localObject).append(this.a.troopUin);
    ((StringBuilder)localObject).append("&uin=");
    ((StringBuilder)localObject).append(this.a.allInOne.uin);
    ((StringBuilder)localObject).append("&_wv=3&&_wwv=128");
    localObject = ((StringBuilder)localObject).toString();
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", (String)localObject);
    paramView.getContext().startActivity(localIntent);
    if ((paramView instanceof TroopMemberNewLevelView)) {
      localObject = (TroopMemberNewLevelView)paramView;
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      if ((((TroopMemberNewLevelView)localObject).a()) && (((TroopMemberNewLevelView)localObject).b()))
      {
        i = 3;
        break label160;
      }
      if (((TroopMemberNewLevelView)localObject).a())
      {
        i = 1;
        break label160;
      }
      if (((TroopMemberNewLevelView)localObject).b())
      {
        i = 2;
        break label160;
      }
    }
    int i = 0;
    label160:
    ReportController.b(this.b, "dc00898", "", "", "0X800B201", "0X800B201", i, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileNameView.2
 * JD-Core Version:    0.7.0.1
 */